# lifecycle-components
Working Group project

Presenters are lifecycle observer, which means they can receive lifecycle events the same way as Activity/Fragment/Dialog and
there is no direct interations between ui and presenter lifecycle methods.   

Fragments are attached using navigation library.  

When you attach fragment from XML layout:  
 
 * using navigation library, lifecycle methods order are logical, first it fires owner 
 Activity lifecycle methods like onCreate e.t.c and then attached fragment lifecycle methods.  
 Logs:  
  Lifecycle Test Activity onCreate.   
  Lifecycle Test ActivityPresenter onCreate. 
  Lifecycle Test FragmentAttachedFromXml onAttach.      
  Lifecycle Test PresenterAttachedFromXml onCreate. 
  Lifecycle Test FragmentAttachedFromXml onCreateView. 
  Lifecycle Test FragmentAttachedFromXml onViewCreated.  
  Lifecycle Test PresenterAttachedFromXml onStart. 
  Lifecycle Test Activity onStart.  
  Lifecycle Test ActivityPresenter onStart.   
  Lifecycle Test Activity onResume.  
  Lifecycle Test ActivityPresenter onResume. 
  Lifecycle Test PresenterAttachedFromXml onResume.  
  Lifecycle Test Activity onCreateOptionsMenu.  
 
 * and you don't use navigation library it behaves illogical, first it fires child 
 fragment lifecycle methods and then owner activity lifecycle methods.  
 Logs:  
    Lifecycle Test FragmentAttachedFromXml onAttach. 
    Lifecycle Test PresenterAttachedFromXml onCreate. 
    Lifecycle Test FragmentAttachedFromXml onCreateView. 
    Lifecycle Test FragmentAttachedFromXml onViewCreated. 
    Lifecycle Test Activity onCreate.  
    Lifecycle Test ActivityPresenter onCreate. 
    Lifecycle Test PresenterAttachedFromXml onStart. 
    Lifecycle Test Activity onStart. 
    Lifecycle Test ActivityPresenter onStart. 
    Lifecycle Test Activity onResume. 
    Lifecycle Test ActivityPresenter onResume. 
    Lifecycle Test PresenterAttachedFromXml onResume. 
    Lifecycle Test Activity onCreateOptionsMenu. 

When you attach fragment by code there is no difference you use navigation library or not. 
Order of lifecycle mthods are the same. So it's always recomended to attach fragment from the code.

This is what happens when you replace one fragment with another fragment.  
FragmentAttachedFromXml is already attached fragment and FragmentAttachedOnClick is replacing it.   
Lifecycle order is the same whether or not you use navigation library.   
  Log:  
    Lifecycle Test FragmentAttachedOnClick onAttach. 
    Lifecycle Test PresenterAttachedOnClick onCreate. 
    Lifecycle Test FragmentAttachedOnClick onCreateView. 
    Lifecycle Test FragmentAttachedOnClick onViewCreated. 
    Lifecycle Test PresenterAttachedOnClick onStart. 
    Lifecycle Test PresenterAttachedOnClick onResume. 
    Lifecycle Test PresenterAttachedFromXml onPause. 
    Lifecycle Test PresenterAttachedFromXml onStop. 
    Lifecycle Test FragmentAttachedFromXml onDestroyView. 
    
Dialog lifecycles are straighforward.  

Logs when you create:  
  Lifecycle Test DialogPresenter onCreate. 
  Lifecycle Test Dialog onCreateDialog. 
  Lifecycle Test Dialog onCreateView. 
  Lifecycle Test DialogPresenter onStart. 
  Lifecycle Test Dialog onResume. 
  Lifecycle Test DialogPresenter onResume. 
  
Logs when you dismiss:  
  Lifecycle Test Dialog onDismiss. 
  Lifecycle Test DialogPresenter onPause. 
  Lifecycle Test DialogPresenter onStop. 
  Lifecycle Test Dialog onDestroyView. 
  Lifecycle Test DialogPresenter onDestroy. 
  Lifecycle Test Dialog onDestroy. 
  Lifecycle Test Dialog onDetach. 

 

