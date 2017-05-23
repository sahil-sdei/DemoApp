package ggn.home.help.Features.TestPackage;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import ggn.home.help.Features.Internal.Base.BaseActivity;
import ggn.home.help.R;

public class TestActivity extends BaseActivity<TestPresenter> implements TestView
{
    public static <T> void start(Context context, T data)
    {
        Intent starter = new Intent(context, TestActivity.class);
        if (data != null) {
            starter.putExtra("constant here", (Parcelable) (data));
        }
        context.startActivity(starter);

    }

    @Override
    protected int setLayoutId()
    {
        return R.layout.activity_test;
    }

//    @Override
//    protected View setParentView()
//    {
//        return findViewById(R.id.activity_test);
//    }

    @Override
    protected void onCreateActivityG()
    {
        injectPresenter(new TestPresenter());
        getPresenter().attachView(this);
    }

    public void clickMe(View view)
    {
        displayError("Snack bar.........");
    }

    @Override
    public void initViews()
    {
//        initialize all views here..
        ((Button) findViewById(R.id.btnTest)).setText("Test to change text (Activity)");

        setupToolbar("Gagan");
    }

    @Override
    public Context getActivityG()
    {
        return TestActivity.this;
    }
}
