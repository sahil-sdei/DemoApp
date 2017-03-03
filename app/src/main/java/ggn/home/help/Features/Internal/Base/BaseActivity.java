package ggn.home.help.Features.Internal.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import ggn.home.help.Features.Internal.Base.Contract.Presentable;
import ggn.home.help.Features.Internal.Base.Contract.Viewable;
import ggn.home.help.R;

/**
 * Created by G-Expo on 03 Mar 2017.
 */
public abstract class BaseActivity<T extends Presentable> extends AppCompatActivity implements Viewable<T>
{
    protected T presenter;

    /**
     * {@inheritDoc}
     */
    @Override
    public void onStart()
    {
        super.onStart();
        getPresenter().onStart();
    }

    public void setupToolbar(String title)
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        onCreateActivityG();
        getPresenter().onViewCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onStop()
    {
        getPresenter().onStop();
        super.onStop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDestroy()
    {
        getPresenter().detachView();
        presenter = null;
        super.onDestroy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void displayError(String message)
    {
        if (setParentView() != null)
        {
            Snackbar.make(setParentView(), message, Snackbar.LENGTH_LONG).show();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showLoading()
    {
        // no-op by default
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hideLoading()
    {
        // no-op by default
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getPresenter()
    {
        return presenter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void injectPresenter(T presenter)
    {
        this.presenter = presenter;
    }

    protected abstract int getLayoutId();

    protected abstract View setParentView();

    protected abstract void onCreateActivityG();
}
