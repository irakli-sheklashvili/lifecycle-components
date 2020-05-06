package lifecycle.example.fragmentfromxml

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import lifecycle.example.R
import lifecycle.example.activity.MainActivity

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FragmentAttachedFromXml : Fragment() {

    override fun onAttach(context: Context) {
        lifecycle.addObserver(PresenterAttachedFromXml())
        super.onAttach(context)
        Log.i("Lifecycle Test", "Lifecycle Test FragmentAttachedFromXml onAttach")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.i("Lifecycle Test", "Lifecycle Test FragmentAttachedFromXml onCreateView")
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        Log.i("Lifecycle Test", "Lifecycle Test FragmentAttachedFromXml onViewCreated")
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
}
