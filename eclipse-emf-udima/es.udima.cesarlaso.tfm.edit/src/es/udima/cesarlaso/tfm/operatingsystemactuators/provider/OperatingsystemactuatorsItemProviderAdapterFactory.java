/**
 */
package es.udima.cesarlaso.tfm.operatingsystemactuators.provider;

import es.udima.cesarlaso.tfm.operatingsystemactuators.util.OperatingsystemactuatorsAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class OperatingsystemactuatorsItemProviderAdapterFactory extends OperatingsystemactuatorsAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatingsystemactuatorsItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link es.udima.cesarlaso.tfm.operatingsystemactuators.SystemCommand} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemCommandItemProvider systemCommandItemProvider;

	/**
	 * This creates an adapter for a {@link es.udima.cesarlaso.tfm.operatingsystemactuators.SystemCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSystemCommandAdapter() {
		if (systemCommandItemProvider == null) {
			systemCommandItemProvider = new SystemCommandItemProvider(this);
		}

		return systemCommandItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link es.udima.cesarlaso.tfm.operatingsystemactuators.PlaySound} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlaySoundItemProvider playSoundItemProvider;

	/**
	 * This creates an adapter for a {@link es.udima.cesarlaso.tfm.operatingsystemactuators.PlaySound}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPlaySoundAdapter() {
		if (playSoundItemProvider == null) {
			playSoundItemProvider = new PlaySoundItemProvider(this);
		}

		return playSoundItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link es.udima.cesarlaso.tfm.operatingsystemactuators.Download} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DownloadItemProvider downloadItemProvider;

	/**
	 * This creates an adapter for a {@link es.udima.cesarlaso.tfm.operatingsystemactuators.Download}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDownloadAdapter() {
		if (downloadItemProvider == null) {
			downloadItemProvider = new DownloadItemProvider(this);
		}

		return downloadItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link es.udima.cesarlaso.tfm.operatingsystemactuators.BackgroundImage} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BackgroundImageItemProvider backgroundImageItemProvider;

	/**
	 * This creates an adapter for a {@link es.udima.cesarlaso.tfm.operatingsystemactuators.BackgroundImage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createBackgroundImageAdapter() {
		if (backgroundImageItemProvider == null) {
			backgroundImageItemProvider = new BackgroundImageItemProvider(this);
		}

		return backgroundImageItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link es.udima.cesarlaso.tfm.operatingsystemactuators.DrawImage} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DrawImageItemProvider drawImageItemProvider;

	/**
	 * This creates an adapter for a {@link es.udima.cesarlaso.tfm.operatingsystemactuators.DrawImage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDrawImageAdapter() {
		if (drawImageItemProvider == null) {
			drawImageItemProvider = new DrawImageItemProvider(this);
		}

		return drawImageItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link es.udima.cesarlaso.tfm.operatingsystemactuators.PlayVideo} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlayVideoItemProvider playVideoItemProvider;

	/**
	 * This creates an adapter for a {@link es.udima.cesarlaso.tfm.operatingsystemactuators.PlayVideo}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPlayVideoAdapter() {
		if (playVideoItemProvider == null) {
			playVideoItemProvider = new PlayVideoItemProvider(this);
		}

		return playVideoItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link es.udima.cesarlaso.tfm.operatingsystemactuators.FilePath} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FilePathItemProvider filePathItemProvider;

	/**
	 * This creates an adapter for a {@link es.udima.cesarlaso.tfm.operatingsystemactuators.FilePath}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFilePathAdapter() {
		if (filePathItemProvider == null) {
			filePathItemProvider = new FilePathItemProvider(this);
		}

		return filePathItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (systemCommandItemProvider != null) systemCommandItemProvider.dispose();
		if (playSoundItemProvider != null) playSoundItemProvider.dispose();
		if (downloadItemProvider != null) downloadItemProvider.dispose();
		if (backgroundImageItemProvider != null) backgroundImageItemProvider.dispose();
		if (drawImageItemProvider != null) drawImageItemProvider.dispose();
		if (playVideoItemProvider != null) playVideoItemProvider.dispose();
		if (filePathItemProvider != null) filePathItemProvider.dispose();
	}

}