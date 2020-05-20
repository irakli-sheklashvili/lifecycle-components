package lifecycle.example.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerDialogFragment
import kotlinx.android.synthetic.main.dialog.*
import lifecycle.example.R
import javax.inject.Inject


class DialogFragment : DaggerDialogFragment() {

    @Inject
    lateinit var dialogPresenter: DialogPresenter

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        lifecycle.addObserver(dialogPresenter)
        Log.i("Lifecycle Test", "Lifecycle Test Dialog onCreateDialog")
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("Lifecycle Test", "Lifecycle Test Dialog onCreateView")
        val dialog = dialog
        dialog?.window?.setLayout(500, 800)
        return layoutInflater.inflate(R.layout.dialog, container, true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("Lifecycle Test", "Lifecycle Test Dialog onViewCreated")
    }

    override fun onResume() {
        super.onResume()
        closeBtn.setOnClickListener { dismiss() }
        Log.i("Lifecycle Test", "Lifecycle Test Dialog onResume")
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        Log.i("Lifecycle Test", "Lifecycle Test Dialog onDismiss")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("Lifecycle Test", "Lifecycle Test Dialog onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle Test", "Lifecycle Test Dialog onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("Lifecycle Test", "Lifecycle Test Dialog onDetach")
    }
}