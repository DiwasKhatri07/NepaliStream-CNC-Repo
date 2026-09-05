package com.phisher98;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.lagradost.cloudstream3.plugins.Plugin;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: XDMoviesSettingsFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/XDMovies/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J>\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0017b\u0016\b\u000e\u0012\u0012\b\u000f\u0012\u000e\b\fJ\u0004\b\b(\u0010J\u0004\b\b(\u0011J#\u0010\u0012\u001a\u0002H\u0013\"\b\b\u0000\u0010\u0013*\u00020\u0007*\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¢\u0006\u0002\u0010\u0016J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/phisher98/XDMoviesSettingsFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "plugin", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "(Lcom/lagradost/cloudstream3/plugins/Plugin;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Landroid/annotation/SuppressLint;", "value", "UseCompatLoadingForDrawables", "SetTextI18n", "findView", "T", "name", "", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "onCreateDialog", "Landroid/app/Dialog;", "restartApp", "", "context", "Landroid/content/Context;", "XDMovies"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nXDMoviesSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 XDMoviesSettingsFragment.kt\ncom/phisher98/XDMoviesSettingsFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,185:1\n2068#2,2:186\n*S KotlinDebug\n*F\n+ 1 XDMoviesSettingsFragment.kt\ncom/phisher98/XDMoviesSettingsFragment\n*L\n134#1:186,2\n*E\n"})
public final class XDMoviesSettingsFragment extends BottomSheetDialogFragment {

    @NotNull
    private final Plugin plugin;

    public XDMoviesSettingsFragment(@NotNull Plugin plugin) {
        this.plugin = plugin;
    }

    @SuppressLint({"UseCompatLoadingForDrawables", "SetTextI18n"})
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Resources resources = this.plugin.getResources();
        Intrinsics.checkNotNull(resources);
        int id = resources.getIdentifier("bottom_sheet_layout", "layout", "com.phisher98");
        Resources resources2 = this.plugin.getResources();
        Intrinsics.checkNotNull(resources2);
        XmlResourceParser layout = resources2.getLayout(id);
        View view = inflater.inflate((XmlPullParser) layout, container, false);
        Resources resources3 = this.plugin.getResources();
        Intrinsics.checkNotNull(resources3);
        int outlineId = resources3.getIdentifier("outline", "drawable", "com.phisher98");
        Resources resources4 = this.plugin.getResources();
        Intrinsics.checkNotNull(resources4);
        int saveIconId = resources4.getIdentifier("save_icon", "drawable", "com.phisher98");
        ImageView saveBtn = (ImageView) findView(view, "save");
        Resources resources5 = this.plugin.getResources();
        Intrinsics.checkNotNull(resources5);
        saveBtn.setImageDrawable(resources5.getDrawable(saveIconId, null));
        Resources resources6 = this.plugin.getResources();
        Intrinsics.checkNotNull(resources6);
        saveBtn.setBackground(resources6.getDrawable(outlineId, null));
        saveBtn.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.XDMoviesSettingsFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                XDMoviesSettingsFragment.onCreateView$lambda$0(this.f$0, view2);
            }
        });
        final Button bypassBtn = (Button) findView(view, "cf_bypass_btn");
        bypassBtn.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.XDMoviesSettingsFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                XDMoviesSettingsFragment.onCreateView$lambda$1(bypassBtn, this, view2);
            }
        });
        String cfCookies = XDMoviesProvider.INSTANCE.getCfCookies();
        if (!StringsKt.isBlank(cfCookies)) {
            bypassBtn.setText("✅ CF Cookies Saved – Refresh");
        } else {
            bypassBtn.setText("🛡️ Bypass Cloudflare");
        }
        Button clearBtn = (Button) findView(view, "cf_clear_btn");
        clearBtn.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.XDMoviesSettingsFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                XDMoviesSettingsFragment.onCreateView$lambda$2(this.f$0, bypassBtn, view2);
            }
        });
        Switch cfWebviewSwitch = (Switch) findView(view, "cf_webview_toggle");
        cfWebviewSwitch.setChecked(XDMoviesProvider.INSTANCE.getCfWebviewEnabled());
        cfWebviewSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.phisher98.XDMoviesSettingsFragment$$ExternalSyntheticLambda5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                XDMoviesProvider.INSTANCE.setCfWebviewEnabled(z);
            }
        });
        return view;
    }

    static final void onCreateView$lambda$0(final XDMoviesSettingsFragment this$0, View it) {
        final Context ctx = this$0.getContext();
        if (ctx != null) {
            new AlertDialog.Builder(ctx).setTitle("Restart App?").setMessage("Save changes and restart the app?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.phisher98.XDMoviesSettingsFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.f$0.restartApp(ctx);
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.phisher98.XDMoviesSettingsFragment$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    XDMoviesSettingsFragment.onCreateView$lambda$0$0$1(ctx, this$0, dialogInterface, i);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0$0$1(Context $ctx, XDMoviesSettingsFragment this$0, DialogInterface dialog, int i) {
        dialog.dismiss();
        Toast.makeText($ctx, "Changes saved", 0).show();
        this$0.dismiss();
    }

    static final void onCreateView$lambda$1(Button $bypassBtn, XDMoviesSettingsFragment this$0, View it) {
        $bypassBtn.setEnabled(false);
        $bypassBtn.setText("⏳ Checking cookie…");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this$0), (CoroutineContext) null, (CoroutineStart) null, new XDMoviesSettingsFragment$onCreateView$2$1($bypassBtn, this$0, null), 3, (Object) null);
    }

    static final void onCreateView$lambda$2(XDMoviesSettingsFragment this$0, final Button $bypassBtn, View it) {
        final Context ctx = this$0.getContext();
        if (ctx != null) {
            new AlertDialog.Builder(ctx).setTitle("Clear CF Cookies?").setMessage("This will remove the saved Cloudflare cookies and User-Agent. You will need to bypass Cloudflare again before streaming.").setPositiveButton("Clear", new DialogInterface.OnClickListener() { // from class: com.phisher98.XDMoviesSettingsFragment$$ExternalSyntheticLambda6
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    XDMoviesSettingsFragment.onCreateView$lambda$2$0$0($bypassBtn, ctx, dialogInterface, i);
                }
            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.phisher98.XDMoviesSettingsFragment$$ExternalSyntheticLambda7
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2$0$0(Button $bypassBtn, Context $ctx, DialogInterface dialogInterface, int i) {
        String host = XDMoviesProvider.INSTANCE.getCfCookieHost();
        if (!StringsKt.isBlank(host)) {
            CookieManager cm = CookieManager.getInstance();
            Iterable $this$forEach$iv = CollectionsKt.listOf(new String[]{"cf_clearance", "__ddg1_", "__ddg2_", "__cfruid"});
            for (Object element$iv : $this$forEach$iv) {
                String name = (String) element$iv;
                cm.setCookie(host, name + "=; Max-Age=0; expires=Thu, 01 Jan 1970 00:00:00 GMT");
            }
            cm.flush();
        }
        XDMoviesProvider.INSTANCE.setCfCookies("");
        XDMoviesProvider.INSTANCE.setCfUserAgent("");
        XDMoviesProvider.INSTANCE.setCfCookieHost("");
        $bypassBtn.setText("🛡️ Bypass Cloudflare");
        Toast.makeText($ctx, "✅ CF Cookies cleared", 0).show();
    }

    private final <T extends View> T findView(View view, String str) {
        Resources resources = this.plugin.getResources();
        Intrinsics.checkNotNull(resources);
        return (T) view.findViewById(resources.getIdentifier(str, "id", "com.phisher98"));
    }

    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetBehavior behavior;
        BottomSheetDialog bottomSheetDialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        BottomSheetDialog bottomSheetDialog = bottomSheetDialogOnCreateDialog instanceof BottomSheetDialog ? bottomSheetDialogOnCreateDialog : null;
        if (bottomSheetDialog != null && (behavior = bottomSheetDialog.getBehavior()) != null) {
            behavior.setState(3);
        }
        return bottomSheetDialogOnCreateDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void restartApp(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage(context.getPackageName());
        ComponentName componentName = intent != null ? intent.getComponent() : null;
        if (componentName != null) {
            Intent restartIntent = Intent.makeRestartActivityTask(componentName);
            context.startActivity(restartIntent);
            Runtime.getRuntime().exit(0);
        }
    }
}
