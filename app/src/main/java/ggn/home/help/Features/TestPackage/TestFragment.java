package ggn.home.help.Features.TestPackage;


import android.support.v4.app.Fragment;
import android.widget.Button;

import ggn.home.help.Features.Internal.Base.BaseFragment;
import ggn.home.help.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends BaseFragment<TestPresenter> implements TestView
{
    public TestFragment()
    {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutId()
    {
        return R.layout.fragment_blank;
    }

    @Override
    protected void onCreateFragmentG()
    {
        injectPresenter(new TestPresenter());
        getPresenter().attachView(this);
    }

    @Override
    public void initViews()
    {
//        initialize all views here..
        ((Button) getParentView().findViewById(R.id.btnTest)).setText("Test to change text (fragment)");
    }


}
