package com.DoraBash;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.lagradost.cloudstream3.plugins.Plugin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DoraBashSettingsFragment.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/DoraBash/classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J<\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0017b\u0016\b\u000e\u0012\u0012\b\u000f\u0012\u000e\b\fJ\u0004\b\b(\u0010J\u0004\b\b(\u0011J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/DoraBash/DoraBashSettingsFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "plugin", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "(Lcom/lagradost/cloudstream3/plugins/Plugin;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Landroid/annotation/SuppressLint;", "value", "SetTextI18n", "UseSwitchCompatOrMaterialCode", "onCreateDialog", "Landroid/app/Dialog;", "restartApp", "", "context", "Landroid/content/Context;", "DoraBash"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDoraBashSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DoraBashSettingsFragment.kt\ncom/DoraBash/DoraBashSettingsFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,167:1\n1#2:168\n2068#3,2:169\n2068#3,2:171\n*S KotlinDebug\n*F\n+ 1 DoraBashSettingsFragment.kt\ncom/DoraBash/DoraBashSettingsFragment\n*L\n103#1:169,2\n134#1:171,2\n*E\n"})
public final class DoraBashSettingsFragment extends BottomSheetDialogFragment {

    @NotNull
    private final Plugin plugin;

    public DoraBashSettingsFragment(@NotNull Plugin plugin) {
        this.plugin = plugin;
    }

    @SuppressLint({"SetTextI18n", "UseSwitchCompatOrMaterialCode"})
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final Context ctx = requireContext();
        Function1 dp = new Function1() { // from class: com.DoraBash.DoraBashSettingsFragment$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return Integer.valueOf(DoraBashSettingsFragment.onCreateView$lambda$0(ctx, ((Integer) obj).intValue()));
            }
        };
        LinearLayout root = new LinearLayout(ctx);
        root.setOrientation(1);
        root.setPadding(((Number) dp.invoke(16)).intValue(), ((Number) dp.invoke(20)).intValue(), ((Number) dp.invoke(16)).intValue(), ((Number) dp.invoke(24)).intValue());
        ScrollView $this$onCreateView_u24lambda_u242 = new ScrollView(ctx);
        $this$onCreateView_u24lambda_u242.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        $this$onCreateView_u24lambda_u242.addView(root);
        TextView $this$onCreateView_u24lambda_u243 = new TextView(ctx);
        $this$onCreateView_u24lambda_u243.setText("DoraBash Settings");
        $this$onCreateView_u24lambda_u243.setTextSize(2, 20.0f);
        $this$onCreateView_u24lambda_u243.setTypeface(null, 1);
        LinearLayout.LayoutParams it = new LinearLayout.LayoutParams(-1, -2);
        it.bottomMargin = ((Number) dp.invoke(12)).intValue();
        $this$onCreateView_u24lambda_u243.setLayoutParams(it);
        root.addView($this$onCreateView_u24lambda_u243);
        View $this$onCreateView_u24lambda_u244 = new View(ctx);
        $this$onCreateView_u24lambda_u244.setBackgroundColor(872415231);
        LinearLayout.LayoutParams it2 = new LinearLayout.LayoutParams(-1, ((Number) dp.invoke(1)).intValue());
        it2.bottomMargin = ((Number) dp.invoke(16)).intValue();
        $this$onCreateView_u24lambda_u244.setLayoutParams(it2);
        root.addView($this$onCreateView_u24lambda_u244);
        TextView $this$onCreateView_u24lambda_u245 = new TextView(ctx);
        $this$onCreateView_u24lambda_u245.setText("Cloudflare Protection");
        $this$onCreateView_u24lambda_u245.setTextSize(2, 17.0f);
        $this$onCreateView_u24lambda_u245.setTypeface(null, 1);
        LinearLayout.LayoutParams it3 = new LinearLayout.LayoutParams(-1, -2);
        it3.bottomMargin = ((Number) dp.invoke(6)).intValue();
        $this$onCreateView_u24lambda_u245.setLayoutParams(it3);
        root.addView($this$onCreateView_u24lambda_u245);
        TextView $this$onCreateView_u24lambda_u246 = new TextView(ctx);
        $this$onCreateView_u24lambda_u246.setText("If DoraBash shows a \"Just a moment\" screen, tap below to open a WebView and solve the challenge. Cookies will be saved automatically.");
        $this$onCreateView_u24lambda_u246.setTextSize(2, 13.0f);
        LinearLayout.LayoutParams it4 = new LinearLayout.LayoutParams(-1, -2);
        it4.bottomMargin = ((Number) dp.invoke(12)).intValue();
        $this$onCreateView_u24lambda_u246.setLayoutParams(it4);
        root.addView($this$onCreateView_u24lambda_u246);
        LinearLayout toggleRow = new LinearLayout(ctx);
        toggleRow.setOrientation(0);
        toggleRow.setGravity(16);
        LinearLayout.LayoutParams it5 = new LinearLayout.LayoutParams(-1, -2);
        it5.bottomMargin = ((Number) dp.invoke(12)).intValue();
        toggleRow.setLayoutParams(it5);
        TextView $this$onCreateView_u24lambda_u248 = new TextView(ctx);
        $this$onCreateView_u24lambda_u248.setText("Auto WebView Bypass");
        $this$onCreateView_u24lambda_u248.setTextSize(2, 14.0f);
        $this$onCreateView_u24lambda_u248.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
        Switch $this$onCreateView_u24lambda_u249 = new Switch(ctx);
        $this$onCreateView_u24lambda_u249.setChecked(DoraBashProvider.INSTANCE.getCfWebviewEnabled());
        $this$onCreateView_u24lambda_u249.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.DoraBash.DoraBashSettingsFragment$$ExternalSyntheticLambda3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                DoraBashSettingsFragment.onCreateView$lambda$9$0(compoundButton, z);
            }
        });
        toggleRow.addView($this$onCreateView_u24lambda_u248);
        toggleRow.addView($this$onCreateView_u24lambda_u249);
        root.addView(toggleRow);
        final Button bypassBtn = new Button(ctx);
        bypassBtn.setText(!StringsKt.isBlank(DoraBashProvider.INSTANCE.getCfCookies()) ? "✅ CF Cookies Saved – Refresh" : "🛡️ Bypass Cloudflare");
        LinearLayout.LayoutParams it6 = new LinearLayout.LayoutParams(-1, -2);
        it6.bottomMargin = ((Number) dp.invoke(8)).intValue();
        bypassBtn.setLayoutParams(it6);
        bypassBtn.setOnClickListener(new View.OnClickListener() { // from class: com.DoraBash.DoraBashSettingsFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DoraBashSettingsFragment.onCreateView$lambda$11(bypassBtn, this, view);
            }
        });
        root.addView(bypassBtn);
        Button clearBtn = new Button(ctx);
        clearBtn.setText("🗑️ Clear CF Cookies");
        clearBtn.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        clearBtn.setOnClickListener(new View.OnClickListener() { // from class: com.DoraBash.DoraBashSettingsFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Context context = ctx;
                new AlertDialog.Builder(context).setTitle("Clear CF Cookies?").setMessage("This will remove the saved Cloudflare cookies and User-Agent. You will need to bypass Cloudflare again before streaming.").setPositiveButton("Clear", new DialogInterface.OnClickListener() { // from class: com.DoraBash.DoraBashSettingsFragment$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        DoraBashSettingsFragment.onCreateView$lambda$13$0(button, context, dialogInterface, i);
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.DoraBash.DoraBashSettingsFragment$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
            }
        });
        root.addView(clearBtn);
        return $this$onCreateView_u24lambda_u242;
    }

    static final int onCreateView$lambda$0(Context $ctx, int value) {
        return (int) TypedValue.applyDimension(1, value, $ctx.getResources().getDisplayMetrics());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$9$0(CompoundButton compoundButton, boolean checked) {
        DoraBashProvider.INSTANCE.setCfWebviewEnabled(checked);
    }

    static final void onCreateView$lambda$11(final Button $bypassBtn, DoraBashSettingsFragment this$0, View it) {
        String cfCookieHost = DoraBashProvider.INSTANCE.getCfCookieHost();
        if (StringsKt.isBlank(cfCookieHost)) {
            cfCookieHost = "https://dorabash.in";
        }
        String host = cfCookieHost;
        CookieManager cm = CookieManager.getInstance();
        Iterable $this$forEach$iv = CollectionsKt.listOf(new String[]{"cf_clearance", "__ddg1_", "__ddg2_", "__cfruid"});
        for (Object element$iv : $this$forEach$iv) {
            String name = (String) element$iv;
            cm.setCookie(host, name + "=; Max-Age=0; expires=Thu, 01 Jan 1970 00:00:00 GMT");
        }
        cm.flush();
        DoraBashProvider.INSTANCE.setCfCookies("");
        DoraBashProvider.INSTANCE.setCfUserAgent("");
        DoraBashProvider.INSTANCE.setCfCookieHost("");
        $bypassBtn.setText("⏳ Solving…");
        new CloudflareWebViewDialog("https://dorabash.in", new Function1() { // from class: com.DoraBash.DoraBashSettingsFragment$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                return DoraBashSettingsFragment.onCreateView$lambda$11$2($bypassBtn, ((Boolean) obj).booleanValue());
            }
        }, true).show(this$0.getParentFragmentManager(), "dorabash_cf_bypass");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$11$2(Button $bypassBtn, boolean saved) {
        $bypassBtn.setText(saved ? "✅ CF Cookies Saved – Refresh" : "🛡️ Bypass Cloudflare");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$13$0(Button $bypassBtn, Context $ctx, DialogInterface dialogInterface, int i) {
        String host = DoraBashProvider.INSTANCE.getCfCookieHost();
        if (!StringsKt.isBlank(host)) {
            CookieManager cm = CookieManager.getInstance();
            Iterable $this$forEach$iv = CollectionsKt.listOf(new String[]{"cf_clearance", "__ddg1_", "__ddg2_", "__cfruid"});
            for (Object element$iv : $this$forEach$iv) {
                String name = (String) element$iv;
                cm.setCookie(host, name + "=; Max-Age=0; expires=Thu, 01 Jan 1970 00:00:00 GMT");
            }
            cm.flush();
        }
        DoraBashProvider.INSTANCE.setCfCookies("");
        DoraBashProvider.INSTANCE.setCfUserAgent("");
        DoraBashProvider.INSTANCE.setCfCookieHost("");
        $bypassBtn.setText("🛡️ Bypass Cloudflare");
        Toast.makeText($ctx, "✅ CF Cookies cleared", 0).show();
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

    private final void restartApp(Context context) {
        ComponentName it;
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (intent != null && (it = intent.getComponent()) != null) {
            context.startActivity(Intent.makeRestartActivityTask(it));
            Runtime.getRuntime().exit(0);
        }
    }
}
