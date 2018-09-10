package com.example.android.coverage.ui.settings.custom

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.core.arch.BaseFragment
import com.example.android.core.ktools.vmb
import com.example.android.coverage.R
import com.example.android.coverage.databinding.FragmentSettingsCustomBinding
import timber.log.Timber

interface SettingsCustomView {
	fun onShowProfileClick()
	fun onNotificationsClick()
	fun onShowAccountClick()
}

class SettingsCustomFragment : BaseFragment(), SettingsCustomView {

	private val vmb by vmb<SettingsCustomViewModel, FragmentSettingsCustomBinding>(R.layout.fragment_settings_custom) { findViewModel(SettingsCustomViewModel::class.java) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		//TODO discuss this weird required extra set with Jakub
		vmb.binding.view = this
		vmb.binding.viewModel = findViewModel(SettingsCustomViewModel::class.java)
	}

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		return vmb.rootView
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		vmb.binding.setLifecycleOwner(viewLifecycleOwner)
		vmb.viewModel.token.observe(viewLifecycleOwner, Observer { tokenText ->
			//			vmb.rootView.textX.text = tokenText
			run {
				Timber.d(">>>$tokenText")
				//vmb.rootView.textX.text = tokenText
			}
		})
	}

//	override fun nextToken() {
//		Timber.d(">>>nextToken")
//		vmb.viewModel.token.value = Random().nextInt().toString()
//	}

	override fun onShowProfileClick() {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun onNotificationsClick() {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}

	override fun onShowAccountClick() {
		TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
	}
}