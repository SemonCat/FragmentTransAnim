FragmentTransAnim
===========================

This is a library base on [FragmentTransactionExtended](https://github.com/DesarrolloAntonio/FragmentTransactionExtended).

This library make use Fragment#CustomAnim easier.

Import
===========================

Just add this:

```groovy
dependencies {
    compile "com.github.semoncat.fragmenttransanim:library:+"
}
``` 

How to use
===========================

You need to use custom layout for more anim.

Just replace your fragment container from FrameLayout to AnimFrameLayout.

```xml
<com.semoncat.fragmenttransanim.AnimFrameLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/container"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```

And setCustomAnim.

```java
getFragmentManager()
    .beginTransaction()
    .setCustomAnimations(R.anim.scalex_enter,
                         R.anim.scalex_exit,
                         R.anim.scalex_enter,
                         R.anim.scalex_exit);
    .add(R.id.container, new YourFragment(), YourFragment.class.getName())
    .commit();
```
