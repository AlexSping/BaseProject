package com.sping.baseproject.di.module
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.room.Dao
import com.sping.baseproject.di.extra.FragmentKey
import com.sping.baseproject.model.dao.PostDao
import com.sping.baseproject.model.database.AppDatabase
import com.sping.baseproject.utils.navigation.InjectingFragmentFactory
import com.sping.baseproject.ui.post.PostFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * [Module] that satisfies [InjectingFragmentFactory] dependencies
 */
@Module
abstract class FragmentFactoryModule {

    /**
     * Binds [InjectingFragmentFactory] dependency
     */
    @Binds
    abstract fun bindFragmentFactory(factory: InjectingFragmentFactory): FragmentFactory

    /**
     * Binds [PostFragment] dependency
     */
    @Binds
    @IntoMap
    @FragmentKey(PostFragment::class)
    abstract fun bindPostFragment(postFragment: PostFragment): Fragment
}