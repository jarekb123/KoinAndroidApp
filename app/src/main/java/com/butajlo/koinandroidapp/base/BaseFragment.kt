package com.butajlo.koinandroidapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.dsl.module.Module
import org.koin.standalone.StandAloneContext.loadKoinModules

typealias NoArgsFun = () -> Unit

abstract class BaseFragment : Fragment() {

    /**
     * Defines layout resource id
     */
    abstract val layoutRes: Int

    /**
     * List of [Module]s which contains beans used in this fragment
     */
    protected open val fragmentModules = emptyList<Module>()

    private val beforeViewsFuns = mutableListOf<NoArgsFun>()
    private val afterViewsFuns = mutableListOf<NoArgsFun>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(fragmentModules)
        beforeViewsFuns.forEach { it() }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutRes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        afterViewsFuns.forEach { it() }
    }

    /**
     * Creates a function which is executed in [BaseFragment.onViewCreated] callback
     *
     * Examples:
     *
     *      1. Execute in `init` block
     * ```
     *      init {
     *          afterViews {
     *              observeViewModel()
     *          }
     *      }
     *      ```
     *      2. Execute by store in val field
     * ```
     *      val observeViewModel = afterViews {
     *          observeViewModel()
     *      }
     * ```
     */
    fun afterViews(afterViewsFun: NoArgsFun) {
        afterViewsFuns.add(afterViewsFun)
    }

    fun beforeViews(beforeViewsFun: NoArgsFun) {
        beforeViewsFuns.add(beforeViewsFun)
    }

}