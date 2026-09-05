package com.phisher98;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.phisher98.settings.SettingsFragment;
import com.phisher98.settings.ToggleFragment;
import com.phisher98.settings.WyzieSettingsFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: MainSettingsFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J#\u0010\u0010\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u0012*\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u0013J\f\u0010\u0014\u001a\u00020\t*\u00020\u0012H\u0002J\"\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J$\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001f\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/phisher98/MainSettingsFragment;", "Landroidx/fragment/app/DialogFragment;", "plugin", "Lcom/phisher98/StreamPlayPlugin;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Lcom/phisher98/StreamPlayPlugin;Landroid/content/SharedPreferences;)V", "onStart", "", "res", "Landroid/content/res/Resources;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "name", "", "findView", "T", "Landroid/view/View;", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "makeTvCompatible", "getLayout", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onCreateView", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "restartApp", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class MainSettingsFragment extends DialogFragment {

    @NotNull
    private final StreamPlayPlugin plugin;

    @NotNull
    private final Resources res;

    @NotNull
    private final SharedPreferences sharedPref;

    public MainSettingsFragment(@NotNull StreamPlayPlugin plugin, @NotNull SharedPreferences sharedPref) throws Exception {
        this.plugin = plugin;
        this.sharedPref = sharedPref;
        Resources resources = this.plugin.getResources();
        if (resources != null) {
            this.res = resources;
            return;
        }
        throw new Exception("Unable to access plugin resources");
    }

    public void onStart() {
        Window $this$onStart_u24lambda_u240;
        int width;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && ($this$onStart_u24lambda_u240 = dialog.getWindow()) != null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int maxDialogWidth = (int) (500.0f * displayMetrics.density);
            if (displayMetrics.widthPixels > 0 && displayMetrics.widthPixels > maxDialogWidth) {
                width = maxDialogWidth;
            } else {
                width = (int) (displayMetrics.widthPixels * 0.9f);
            }
            $this$onStart_u24lambda_u240.setLayout(width, -2);
            $this$onStart_u24lambda_u240.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    private final Drawable getDrawable(String name) throws Exception {
        int id = this.res.getIdentifier(name, "drawable", "com.phisher98");
        Drawable drawable = this.res.getDrawable(id, null);
        if (drawable != null) {
            return drawable;
        }
        throw new Exception("Drawable " + name + " not found");
    }

    private final <T extends View> T findView(View view, String str) throws Exception {
        int identifier = this.res.getIdentifier(str, "id", "com.phisher98");
        if (identifier == 0) {
            throw new Exception("View ID " + str + " not found.");
        }
        return (T) view.findViewById(identifier);
    }

    private final void makeTvCompatible(View $this$makeTvCompatible) {
        int outlineId = this.res.getIdentifier("outline", "drawable", "com.phisher98");
        $this$makeTvCompatible.setBackground(this.res.getDrawable(outlineId, null));
    }

    private final View getLayout(String name, LayoutInflater inflater, ViewGroup container) {
        int id = this.res.getIdentifier(name, "layout", "com.phisher98");
        XmlResourceParser layout = this.res.getLayout(id);
        return inflater.inflate((XmlPullParser) layout, container, false);
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) throws Exception {
        View view = getLayout("fragment_main_settings", inflater, container);
        int drawableId = this.res.getIdentifier("dialog_background", "drawable", "com.phisher98");
        if (drawableId != 0) {
            view.setBackground(this.res.getDrawable(drawableId, null));
        }
        ImageView loginCard = (ImageView) findView(view, "loginCard");
        ImageView wyzieCard = (ImageView) findView(view, "wyzieCard");
        ImageView featureCard = (ImageView) findView(view, "featureCard");
        ImageView toggleproviders = (ImageView) findView(view, "toggleproviders");
        ImageView languagechange = (ImageView) findView(view, "languageCard");
        ImageView stremioaddon = (ImageView) findView(view, "stremioaddons");
        ImageView stremioaddonstreams = (ImageView) findView(view, "stremioaddonstreams");
        ImageView performance = (ImageView) findView(view, "performance");
        View loginRow = findView(view, "loginRow");
        View wyzieRow = findView(view, "wyzieRow");
        View featureRow = findView(view, "featureRow");
        View toggleprovidersRow = findView(view, "toggleprovidersRow");
        View languageRow = findView(view, "languageRow");
        View stremioaddonsRow = findView(view, "stremioaddonsRow");
        View stremioaddonstreamsRow = findView(view, "stremioaddonstreamsRow");
        View performanceRow = findView(view, "performanceRow");
        ImageView saveIcon = (ImageView) findView(view, "saveIcon");
        loginCard.setImageDrawable(getDrawable("settings_icon"));
        wyzieCard.setImageDrawable(getDrawable("settings_icon"));
        languagechange.setImageDrawable(getDrawable("settings_icon"));
        featureCard.setImageDrawable(getDrawable("settings_icon"));
        toggleproviders.setImageDrawable(getDrawable("settings_icon"));
        stremioaddon.setImageDrawable(getDrawable("settings_icon"));
        stremioaddonstreams.setImageDrawable(getDrawable("settings_icon"));
        performance.setImageDrawable(getDrawable("settings_icon"));
        saveIcon.setImageDrawable(getDrawable("save_icon"));
        loginRow.setBackground(getDrawable("settings_item_background"));
        wyzieRow.setBackground(getDrawable("settings_item_background"));
        featureRow.setBackground(getDrawable("settings_item_background"));
        toggleprovidersRow.setBackground(getDrawable("settings_item_background"));
        languageRow.setBackground(getDrawable("settings_item_background"));
        stremioaddonsRow.setBackground(getDrawable("settings_item_background"));
        stremioaddonstreamsRow.setBackground(getDrawable("settings_item_background"));
        performanceRow.setBackground(getDrawable("settings_item_background"));
        makeTvCompatible(saveIcon);
        final Function2 showSubFragment = new Function2() { // from class: com.phisher98.MainSettingsFragment$$ExternalSyntheticLambda4
            public final Object invoke(Object obj, Object obj2) {
                return MainSettingsFragment.onCreateView$lambda$0(this.f$0, (Function1) obj, (String) obj2);
            }
        };
        loginRow.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.MainSettingsFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                showSubFragment.invoke(new Function1() { // from class: com.phisher98.MainSettingsFragment$$ExternalSyntheticLambda18
                    public final Object invoke(Object obj) {
                        return MainSettingsFragment.onCreateView$lambda$1$0(this.f$0, (Function0) obj);
                    }
                }, "settings_fragment");
            }
        });
        wyzieRow.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.MainSettingsFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                showSubFragment.invoke(new Function1() { // from class: com.phisher98.MainSettingsFragment$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        return MainSettingsFragment.onCreateView$lambda$2$0(this.f$0, (Function0) obj);
                    }
                }, "wyzie_settings_fragment");
            }
        });
        featureRow.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.MainSettingsFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                showSubFragment.invoke(new Function1() { // from class: com.phisher98.MainSettingsFragment$$ExternalSyntheticLambda19
                    public final Object invoke(Object obj) {
                        return MainSettingsFragment.onCreateView$lambda$3$0(this.f$0, (Function0) obj);
                    }
                }, "fragment_toggle_extensions");
            }
        });
        toggleprovidersRow.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.MainSettingsFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                showSubFragment.invoke(new Function1() { // from class: com.phisher98.MainSettingsFragment$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return MainSettingsFragment.onCreateView$lambda$4$0(this.f$0, (Function0) obj);
                    }
                }, "fragment_toggle_providers");
            }
        });
        languageRow.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.MainSettingsFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                showSubFragment.invoke(new Function1() { // from class: com.phisher98.MainSettingsFragment$$ExternalSyntheticLambda14
                    public final Object invoke(Object obj) {
                        return MainSettingsFragment.onCreateView$lambda$5$0(this.f$0, (Function0) obj);
                    }
                }, "fragment_language_list");
            }
        });
        stremioaddonsRow.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.MainSettingsFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                showSubFragment.invoke(new Function1() { // from class: com.phisher98.MainSettingsFragment$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        return MainSettingsFragment.onCreateView$lambda$6$0(mainSettingsFragment, (Function0) obj);
                    }
                }, "stremio_bottom_sheet_layout");
            }
        });
        stremioaddonstreamsRow.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.MainSettingsFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                showSubFragment.invoke(new Function1() { // from class: com.phisher98.MainSettingsFragment$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        return MainSettingsFragment.onCreateView$lambda$7$0(this.f$0, (Function0) obj);
                    }
                }, "streamplay_stremio_addon_bottom_sheet_layout");
            }
        });
        performanceRow.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.MainSettingsFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                showSubFragment.invoke(new Function1() { // from class: com.phisher98.MainSettingsFragment$$ExternalSyntheticLambda16
                    public final Object invoke(Object obj) {
                        return MainSettingsFragment.onCreateView$lambda$8$0(mainSettingsFragment, (Function0) obj);
                    }
                }, "concurrency_bottom_sheet");
            }
        });
        saveIcon.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.MainSettingsFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MainSettingsFragment.onCreateView$lambda$9(this.f$0, view2);
            }
        });
        return view;
    }

    static final Unit onCreateView$lambda$0(final MainSettingsFragment this$0, Function1 fragmentCreator, String tag) {
        FragmentActivity activity = this$0.getActivity();
        final FragmentManager fm = activity != null ? activity.getSupportFragmentManager() : null;
        if (fm != null) {
            this$0.dismiss();
            DialogFragment subFragment = (DialogFragment) fragmentCreator.invoke(new Function0() { // from class: com.phisher98.MainSettingsFragment$$ExternalSyntheticLambda17
                public final Object invoke() {
                    return MainSettingsFragment.onCreateView$lambda$0$0(this.f$0, fm);
                }
            });
            subFragment.show(fm, tag);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0(MainSettingsFragment this$0, FragmentManager $fm) {
        MainSettingsFragment mainSettings = new MainSettingsFragment(this$0.plugin, this$0.sharedPref);
        mainSettings.show($fm, "main_settings");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogFragment onCreateView$lambda$1$0(MainSettingsFragment this$0, Function0 cb) {
        return new SettingsFragment(this$0.plugin, this$0.sharedPref, cb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogFragment onCreateView$lambda$2$0(MainSettingsFragment this$0, Function0 cb) {
        return new WyzieSettingsFragment(this$0.plugin, this$0.sharedPref, cb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogFragment onCreateView$lambda$3$0(MainSettingsFragment this$0, Function0 cb) {
        return new ToggleFragment(this$0.plugin, this$0.sharedPref, cb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogFragment onCreateView$lambda$4$0(MainSettingsFragment this$0, Function0 cb) {
        return new ProvidersFragment(this$0.plugin, this$0.sharedPref, cb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogFragment onCreateView$lambda$5$0(MainSettingsFragment this$0, Function0 cb) {
        return new LanguageSelectFragment(this$0.plugin, this$0.sharedPref, cb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogFragment onCreateView$lambda$6$0(MainSettingsFragment this$0, Function0 cb) {
        return new StreamPlayStremioCatelogFrag(this$0.plugin, this$0.sharedPref, cb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogFragment onCreateView$lambda$7$0(MainSettingsFragment this$0, Function0 cb) {
        return new StreamPlayStremioAddonFrag(this$0.plugin, this$0.sharedPref, cb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogFragment onCreateView$lambda$8$0(MainSettingsFragment this$0, Function0 cb) {
        return new ConcurrencyBottomSheet(this$0.plugin, this$0.sharedPref, cb);
    }

    static final void onCreateView$lambda$9(final MainSettingsFragment this$0, View it) {
        Context context = this$0.getContext();
        if (context == null) {
            return;
        }
        new AlertDialog.Builder(context).setTitle("Save & Reload").setMessage("Changes have been saved. Do you want to restart the app to apply them?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.phisher98.MainSettingsFragment$$ExternalSyntheticLambda15
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainSettingsFragment.onCreateView$lambda$9$0(this.f$0, dialogInterface, i);
            }
        }).setNegativeButton("No", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$9$0(MainSettingsFragment this$0, DialogInterface dialogInterface, int i) {
        this$0.dismiss();
        this$0.restartApp();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
    }

    private final void restartApp() {
        Context context = requireContext().getApplicationContext();
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
