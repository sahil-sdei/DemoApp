package ggn.home.help.Features.Internal.Base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.util.List;

/**
 * Created by G-Expo on 03 Mar 2017.
 */
public abstract class SuperAdapterG<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH>
{

    List<T>   modelList;
    Class<VH> mViewHolderClass;

    public SuperAdapterG(List<T> modelClass, Class<VH> viewHolderClass)
    {
        modelList = modelClass;
        mViewHolderClass = viewHolderClass;
    }


    @Override
    public int getItemCount()
    {
        return modelList.size();
    }


    @Override
    public int getItemViewType(int position)
    {
        return position;
    }

    public T getItem(int position)
    {
        return modelList.get(position);
    }


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType)
    {
        ViewGroup view = (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(getLayout(), parent, false);
        try
        {
            Constructor<VH> constructor = mViewHolderClass.getConstructor(View.class);
            return constructor.newInstance(view);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onBindViewHolder(VH viewHolder, int position)
    {
        T model = getItem(position);
        populateViewHolderG(viewHolder, model, position);
    }


    abstract protected void populateViewHolderG(VH viewHolder, T model, int position);

    abstract protected int getLayout();
}


