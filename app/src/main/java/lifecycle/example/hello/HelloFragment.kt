package lifecycle.example.hello

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_hello.*
import lifecycle.example.R
import javax.inject.Inject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HelloFragment : DaggerFragment(), HelloView {

    @Inject
    lateinit var presenter: HelloPresenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("Lifecycle Test", "Lifecycle Test FragmentAttachedFromXml onAttach")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.i("Lifecycle Test", "Lifecycle Test FragmentAttachedFromXml onCreateView")
        return inflater.inflate(R.layout.fragment_hello, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        Log.i("Lifecycle Test", "Lifecycle Test FragmentAttachedFromXml onViewCreated")

        download_button.setOnClickListener {
            presenter.downloadStuff();
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("Lifecycle Test", "Lifecycle Test FragmentAttachedFromXml onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Lifecycle Test", "Lifecycle Test FragmentAttachedFromXml onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("Lifecycle Test", "Lifecycle Test FragmentAttachedFromXml onDetach")
    }

    override fun onDownloadFinish() {
        Toast.makeText(context, "Downlaod Finished", Toast.LENGTH_LONG).show()
    }
}
