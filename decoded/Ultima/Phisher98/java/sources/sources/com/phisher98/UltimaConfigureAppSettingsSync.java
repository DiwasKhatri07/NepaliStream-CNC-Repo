package com.phisher98;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.utils.AppContextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: AppSettingsSync.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Ultima/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J4\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0003b\u0010\b\u0019\u0012\f\b\u001a\u0012\b\b\fJ\u0004\b\b(\u001bJ\"\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0011H\u0003b\u0010\b\u0019\u0012\f\b\u001a\u0012\b\b\fJ\u0004\b\b(\u001eJ#\u0010\u001f\u001a\u0002H \"\b\b\u0000\u0010 *\u00020\u0013*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0002\u0010!J\u001e\u0010\"\u001a\u00020#*\u00020\u0013H\u0003b\u0010\b\u0019\u0012\f\b\u001a\u0012\b\b\fJ\u0004\b\b(\u001eJ \u0010&\u001a\u00020#H\u0007b\u0016\b\u0019\u0012\u0012\b\u001a\u0012\u000e\b\fJ\u0004\b\b('J\u0004\b\b((J\"\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u0013H\u0003b\u0010\b\u0019\u0012\f\b\u001a\u0012\b\b\fJ\u0004\b\b((J@\u0010+\u001a\u00020#2\u0006\u0010*\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0083@b\u0016\b\u0019\u0012\u0012\b\u001a\u0012\u000e\b\fJ\u0004\b\b('J\u0004\b\b((¢\u0006\u0002\u0010,R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/phisher98/UltimaConfigureAppSettingsSync;", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "(Landroidx/appcompat/app/AppCompatActivity;)V", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "plugin", "Lcom/phisher98/UltimaPlugin;", "getPlugin", "()Lcom/phisher98/UltimaPlugin;", "sm", "Lcom/phisher98/UltimaStorageManager;", "res", "Landroid/content/res/Resources;", "packageName", "", "getLayout", "Landroid/view/View;", "name", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "Landroid/annotation/SuppressLint;", "value", "DiscouragedApi", "getDrawable", "Landroid/graphics/drawable/Drawable;", "UseCompatLoadingForDrawables", "findView", "T", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "makeTvCompatible", "", "dialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "show", "UseSwitchCompatOrMaterialCode", "SetTextI18n", "updateLastSyncInfo", "rootView", "refreshDevicesList", "(Landroid/view/View;Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAppSettingsSync.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppSettingsSync.kt\ncom/phisher98/UltimaConfigureAppSettingsSync\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,477:1\n2068#2,2:478\n2068#2,2:480\n*S KotlinDebug\n*F\n+ 1 AppSettingsSync.kt\ncom/phisher98/UltimaConfigureAppSettingsSync\n*L\n277#1:478,2\n430#1:480,2\n*E\n"})
public final class UltimaConfigureAppSettingsSync {

    @NotNull
    private final AppCompatActivity activity;
    private BottomSheetDialog dialog;

    @NotNull
    private final String packageName;

    @NotNull
    private final UltimaPlugin plugin;

    @NotNull
    private final Resources res;

    @NotNull
    private final UltimaStorageManager sm;

    /* JADX INFO: renamed from: com.phisher98.UltimaConfigureAppSettingsSync$refreshDevicesList$1 */
    /* JADX INFO: compiled from: AppSettingsSync.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaConfigureAppSettingsSync", f = "AppSettingsSync.kt", i = {0, 0, 0, 0, 0}, l = {428}, m = "refreshDevicesList", n = {"rootView", "inflater", "container", "devicesListLayout", "creds"}, nl = {430}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UltimaConfigureAppSettingsSync.this.refreshDevicesList(null, null, null, (Continuation) this);
        }
    }

    public UltimaConfigureAppSettingsSync(@NotNull AppCompatActivity activity) throws Exception {
        this.activity = activity;
        UltimaPlugin companion = UltimaPlugin.INSTANCE.getInstance();
        if (companion == null) {
            throw new Exception("Plugin not initialized");
        }
        this.plugin = companion;
        this.sm = UltimaStorageManager.INSTANCE;
        Resources resources = this.plugin.getResources();
        if (resources == null) {
            throw new Exception("Unable to read resources");
        }
        this.res = resources;
        this.packageName = "com.phisher98";
    }

    @NotNull
    public final AppCompatActivity getActivity() {
        return this.activity;
    }

    @NotNull
    public final UltimaPlugin getPlugin() {
        return this.plugin;
    }

    @SuppressLint({"DiscouragedApi"})
    private final View getLayout(String name, LayoutInflater inflater, ViewGroup container) {
        int id = this.res.getIdentifier(name, "layout", this.packageName);
        XmlResourceParser layout = this.res.getLayout(id);
        return inflater.inflate((XmlPullParser) layout, container, false);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final Drawable getDrawable(String name) throws Exception {
        int id = this.res.getIdentifier(name, "drawable", this.packageName);
        Drawable drawable = this.res.getDrawable(id, null);
        if (drawable != null) {
            return drawable;
        }
        throw new Exception("Unable to find drawable " + name);
    }

    private final <T extends View> T findView(View view, String str) {
        return (T) view.findViewById(this.res.getIdentifier(str, "id", this.packageName));
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final void makeTvCompatible(View $this$makeTvCompatible) {
        int outlineId = this.res.getIdentifier("outline", "drawable", this.packageName);
        $this$makeTvCompatible.setBackground(this.res.getDrawable(outlineId, null));
    }

    @SuppressLint({"UseSwitchCompatOrMaterialCode", "SetTextI18n"})
    public final void show() {
        View settings;
        BottomSheetDialog bottomSheetDialog;
        Lifecycle lifecycle;
        CoroutineScope coroutineScope;
        this.dialog = new BottomSheetDialog(this.activity);
        final LayoutInflater inflater = LayoutInflater.from(this.activity);
        final View settings2 = getLayout("app_settings_sync", inflater, null);
        final AppCompatActivity context = this.activity;
        ImageView $this$show_u24lambda_u240 = (ImageView) findView(settings2, "save");
        $this$show_u24lambda_u240.setImageDrawable(getDrawable("save_icon"));
        makeTvCompatible($this$show_u24lambda_u240);
        $this$show_u24lambda_u240.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.UltimaConfigureAppSettingsSync$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UltimaConfigureAppSettingsSync.show$lambda$0$0(this.f$0, view);
            }
        });
        ImageView $this$show_u24lambda_u241 = (ImageView) findView(settings2, "app_settings_sync_creds_btn");
        $this$show_u24lambda_u241.setImageDrawable(getDrawable("edit_icon"));
        makeTvCompatible($this$show_u24lambda_u241);
        $this$show_u24lambda_u241.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.UltimaConfigureAppSettingsSync$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UltimaConfigureAppSettingsSync.show$lambda$1$0(this.f$0, inflater, context, settings2, view);
            }
        });
        final Switch $this$show_u24lambda_u242 = (Switch) findView(settings2, "backup_device");
        AppSettingsSyncCreds currentCreds = this.sm.getAppSettingsSyncCreds();
        $this$show_u24lambda_u242.setChecked(currentCreds != null ? currentCreds.getBackupDevice() : false);
        $this$show_u24lambda_u242.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.phisher98.UltimaConfigureAppSettingsSync$$ExternalSyntheticLambda2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                UltimaConfigureAppSettingsSync.show$lambda$2$0(this.f$0, $this$show_u24lambda_u242, context, settings2, compoundButton, z);
            }
        });
        final Switch $this$show_u24lambda_u243 = (Switch) findView(settings2, "restore_device");
        AppSettingsSyncCreds currentCreds2 = this.sm.getAppSettingsSyncCreds();
        $this$show_u24lambda_u243.setChecked(currentCreds2 != null ? currentCreds2.getRestoreDevice() : false);
        $this$show_u24lambda_u243.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.phisher98.UltimaConfigureAppSettingsSync$$ExternalSyntheticLambda3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                UltimaConfigureAppSettingsSync.show$lambda$3$0(this.f$0, $this$show_u24lambda_u243, context, settings2, compoundButton, z);
            }
        });
        Button $this$show_u24lambda_u244 = (Button) findView(settings2, "sync_now_btn");
        $this$show_u24lambda_u244.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.UltimaConfigureAppSettingsSync$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UltimaConfigureAppSettingsSync.show$lambda$4$0(this.f$0, context, settings2, view);
            }
        });
        final CheckBox backupExtensionsCb = (CheckBox) findView(settings2, "backup_extensions");
        final CheckBox restoreExtensionsCb = (CheckBox) findView(settings2, "restore_extensions");
        final CheckBox backupBookmarksCb = (CheckBox) findView(settings2, "backup_bookmarks");
        final CheckBox restoreBookmarksCb = (CheckBox) findView(settings2, "restore_bookmarks");
        final CheckBox backupResumeWatchingCb = (CheckBox) findView(settings2, "backup_resume_watching");
        final CheckBox restoreResumeWatchingCb = (CheckBox) findView(settings2, "restore_resume_watching");
        final CheckBox backupSearchHistoryCb = (CheckBox) findView(settings2, "backup_search_history");
        final CheckBox restoreSearchHistoryCb = (CheckBox) findView(settings2, "restore_search_history");
        final CheckBox backupPlayerCb = (CheckBox) findView(settings2, "backup_player");
        final CheckBox restorePlayerCb = (CheckBox) findView(settings2, "restore_player");
        final CheckBox backupSubtitlesCb = (CheckBox) findView(settings2, "backup_subtitles");
        final CheckBox restoreSubtitlesCb = (CheckBox) findView(settings2, "restore_subtitles");
        final CheckBox backupThemeCb = (CheckBox) findView(settings2, "backup_theme");
        final CheckBox restoreThemeCb = (CheckBox) findView(settings2, "restore_theme");
        final CheckBox backupLayoutCb = (CheckBox) findView(settings2, "backup_layout");
        final CheckBox restoreLayoutCb = (CheckBox) findView(settings2, "restore_layout");
        final CheckBox backupDownloadsCb = (CheckBox) findView(settings2, "backup_downloads");
        final CheckBox restoreDownloadsCb = (CheckBox) findView(settings2, "restore_downloads");
        final CheckBox backupGeneralCb = (CheckBox) findView(settings2, "backup_general");
        final CheckBox restoreGeneralCb = (CheckBox) findView(settings2, "restore_general");
        Iterable $this$forEach$iv = CollectionsKt.listOf(new CheckBox[]{backupExtensionsCb, restoreExtensionsCb, backupBookmarksCb, restoreBookmarksCb, backupResumeWatchingCb, restoreResumeWatchingCb, backupSearchHistoryCb, restoreSearchHistoryCb, backupPlayerCb, restorePlayerCb, backupSubtitlesCb, restoreSubtitlesCb, backupThemeCb, restoreThemeCb, backupLayoutCb, restoreLayoutCb, backupDownloadsCb, restoreDownloadsCb, backupGeneralCb, restoreGeneralCb});
        for (Object element$iv : $this$forEach$iv) {
            CheckBox it = (CheckBox) element$iv;
            makeTvCompatible(it);
        }
        AppSettingsSyncCreds appSettingsSyncCreds = this.sm.getAppSettingsSyncCreds();
        if (appSettingsSyncCreds == null) {
            appSettingsSyncCreds = new AppSettingsSyncCreds(false, null, null, null, null, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, -1, null);
        }
        AppSettingsSyncCreds currentCreds3 = appSettingsSyncCreds;
        backupExtensionsCb.setChecked(currentCreds3.getBackupExtensions());
        restoreExtensionsCb.setChecked(currentCreds3.getRestoreExtensions());
        backupBookmarksCb.setChecked(currentCreds3.getBackupBookmarks());
        restoreBookmarksCb.setChecked(currentCreds3.getRestoreBookmarks());
        backupResumeWatchingCb.setChecked(currentCreds3.getBackupResumeWatching());
        restoreResumeWatchingCb.setChecked(currentCreds3.getRestoreResumeWatching());
        backupSearchHistoryCb.setChecked(currentCreds3.getBackupSearchHistory());
        restoreSearchHistoryCb.setChecked(currentCreds3.getRestoreSearchHistory());
        backupPlayerCb.setChecked(currentCreds3.getBackupPlayer());
        restorePlayerCb.setChecked(currentCreds3.getRestorePlayer());
        backupSubtitlesCb.setChecked(currentCreds3.getBackupSubtitles());
        restoreSubtitlesCb.setChecked(currentCreds3.getRestoreSubtitles());
        backupThemeCb.setChecked(currentCreds3.getBackupTheme());
        restoreThemeCb.setChecked(currentCreds3.getRestoreTheme());
        backupLayoutCb.setChecked(currentCreds3.getBackupLayout());
        restoreLayoutCb.setChecked(currentCreds3.getRestoreLayout());
        backupDownloadsCb.setChecked(currentCreds3.getBackupDownloads());
        restoreDownloadsCb.setChecked(currentCreds3.getRestoreDownloads());
        backupGeneralCb.setChecked(currentCreds3.getBackupGeneral());
        restoreGeneralCb.setChecked(currentCreds3.getRestoreGeneral());
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.phisher98.UltimaConfigureAppSettingsSync$$ExternalSyntheticLambda5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                UltimaConfigureAppSettingsSync.show$lambda$6(this.f$0, backupExtensionsCb, restoreExtensionsCb, backupBookmarksCb, restoreBookmarksCb, backupResumeWatchingCb, restoreResumeWatchingCb, backupSearchHistoryCb, restoreSearchHistoryCb, backupPlayerCb, restorePlayerCb, backupSubtitlesCb, restoreSubtitlesCb, backupThemeCb, restoreThemeCb, backupLayoutCb, restoreLayoutCb, backupDownloadsCb, restoreDownloadsCb, backupGeneralCb, restoreGeneralCb, compoundButton, z);
            }
        };
        backupExtensionsCb.setOnCheckedChangeListener(onCheckedChangeListener);
        restoreExtensionsCb.setOnCheckedChangeListener(onCheckedChangeListener);
        backupBookmarksCb.setOnCheckedChangeListener(onCheckedChangeListener);
        restoreBookmarksCb.setOnCheckedChangeListener(onCheckedChangeListener);
        backupResumeWatchingCb.setOnCheckedChangeListener(onCheckedChangeListener);
        restoreResumeWatchingCb.setOnCheckedChangeListener(onCheckedChangeListener);
        backupSearchHistoryCb.setOnCheckedChangeListener(onCheckedChangeListener);
        restoreSearchHistoryCb.setOnCheckedChangeListener(onCheckedChangeListener);
        backupPlayerCb.setOnCheckedChangeListener(onCheckedChangeListener);
        restorePlayerCb.setOnCheckedChangeListener(onCheckedChangeListener);
        backupSubtitlesCb.setOnCheckedChangeListener(onCheckedChangeListener);
        restoreSubtitlesCb.setOnCheckedChangeListener(onCheckedChangeListener);
        backupThemeCb.setOnCheckedChangeListener(onCheckedChangeListener);
        restoreThemeCb.setOnCheckedChangeListener(onCheckedChangeListener);
        backupLayoutCb.setOnCheckedChangeListener(onCheckedChangeListener);
        restoreLayoutCb.setOnCheckedChangeListener(onCheckedChangeListener);
        backupDownloadsCb.setOnCheckedChangeListener(onCheckedChangeListener);
        restoreDownloadsCb.setOnCheckedChangeListener(onCheckedChangeListener);
        backupGeneralCb.setOnCheckedChangeListener(onCheckedChangeListener);
        restoreGeneralCb.setOnCheckedChangeListener(onCheckedChangeListener);
        AppCompatActivity appCompatActivity = this.activity;
        if (appCompatActivity == null || (lifecycle = appCompatActivity.getLifecycle()) == null || (coroutineScope = LifecycleKt.getCoroutineScope(lifecycle)) == null) {
            settings = settings2;
            bottomSheetDialog = null;
        } else {
            settings = settings2;
            bottomSheetDialog = null;
            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C00077(settings, inflater, null), 3, (Object) null);
        }
        BottomSheetDialog bottomSheetDialog2 = this.dialog;
        if (bottomSheetDialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
            bottomSheetDialog2 = bottomSheetDialog;
        }
        bottomSheetDialog2.setContentView(settings);
        BottomSheetDialog bottomSheetDialog3 = this.dialog;
        if (bottomSheetDialog3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
            bottomSheetDialog3 = bottomSheetDialog;
        }
        View bottomSheet = bottomSheetDialog3.findViewById(R.id.design_bottom_sheet);
        if (bottomSheet != null) {
            BottomSheetBehavior.from(bottomSheet).setState(3);
        }
        BottomSheetDialog bottomSheetDialog4 = this.dialog;
        if (bottomSheetDialog4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
            bottomSheetDialog4 = null;
        }
        bottomSheetDialog4.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.phisher98.UltimaConfigureAppSettingsSync$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                UltimaConfigureAppSettingsSync.show$lambda$7(this.f$0, dialogInterface);
            }
        });
        BottomSheetDialog bottomSheetDialog5 = this.dialog;
        if (bottomSheetDialog5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
            bottomSheetDialog5 = null;
        }
        bottomSheetDialog5.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$0$0(UltimaConfigureAppSettingsSync this$0, View it) {
        BottomSheetDialog bottomSheetDialog = this$0.dialog;
        if (bottomSheetDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
            bottomSheetDialog = null;
        }
        bottomSheetDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$1$0(final UltimaConfigureAppSettingsSync this$0, final LayoutInflater $inflater, final AppCompatActivity $context, final View $settings, View it) {
        View credsView = this$0.getLayout("app_settings_sync_creds", $inflater, null);
        final EditText deviceNameInput = (EditText) this$0.findView(credsView, "device_name");
        final EditText syncKeyInput = (EditText) this$0.findView(credsView, "sync_key");
        final Switch customDbSwitch = (Switch) this$0.findView(credsView, "custom_db_switch");
        final LinearLayout customDbSection = (LinearLayout) this$0.findView(credsView, "custom_db_section");
        final EditText $this$show_u24lambda_u241_u240_u240 = (EditText) this$0.findView(credsView, "firebase_rules_snippet");
        $this$show_u24lambda_u241_u240_u240.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.UltimaConfigureAppSettingsSync$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UltimaConfigureAppSettingsSync.show$lambda$1$0$0$0($context, $this$show_u24lambda_u241_u240_u240, view);
            }
        });
        final EditText firebaseUrlInput = (EditText) this$0.findView(credsView, "firebase_url");
        Button generateKeyBtn = (Button) this$0.findView(credsView, "generate_key_btn");
        AppSettingsSyncCreds appSettingsSyncCreds = this$0.sm.getAppSettingsSyncCreds();
        final AppSettingsSyncCreds currentCreds = appSettingsSyncCreds == null ? new AppSettingsSyncCreds(false, null, null, null, null, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, -1, null) : appSettingsSyncCreds;
        String deviceName = currentCreds.getDeviceName();
        if (deviceName == null) {
            deviceName = Build.MODEL;
        }
        deviceNameInput.setText(deviceName);
        syncKeyInput.setText(currentCreds.getSyncKey());
        customDbSwitch.setChecked(currentCreds.getUseCustomDatabase());
        customDbSection.setVisibility(currentCreds.getUseCustomDatabase() ? 0 : 8);
        firebaseUrlInput.setText(currentCreds.getFirebaseUrl());
        customDbSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.phisher98.UltimaConfigureAppSettingsSync$$ExternalSyntheticLambda8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                UltimaConfigureAppSettingsSync.show$lambda$1$0$1(customDbSection, compoundButton, z);
            }
        });
        generateKeyBtn.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.UltimaConfigureAppSettingsSync$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UltimaConfigureAppSettingsSync.show$lambda$1$0$2(syncKeyInput, view);
            }
        });
        AppContextUtils.setDefaultFocus$default(AppContextUtils.INSTANCE, new AlertDialog.Builder(this$0.activity).setTitle("Configure App Sync").setView(credsView).setPositiveButton("Save", new DialogInterface.OnClickListener() { // from class: com.phisher98.UltimaConfigureAppSettingsSync$$ExternalSyntheticLambda10
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                UltimaConfigureAppSettingsSync.show$lambda$1$0$3(deviceNameInput, syncKeyInput, customDbSwitch, firebaseUrlInput, currentCreds, this$0, $context, $settings, $inflater, dialogInterface, i);
            }
        }).setNegativeButton("Reset", new DialogInterface.OnClickListener() { // from class: com.phisher98.UltimaConfigureAppSettingsSync$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                UltimaConfigureAppSettingsSync.show$lambda$1$0$4(this.f$0, $settings, $inflater, dialogInterface, i);
            }
        }).show(), 0, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$1$0$0$0(AppCompatActivity $context, EditText $this_apply, View it) {
        Object systemService = $context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardManager clipboard = (ClipboardManager) systemService;
        ClipData clip = ClipData.newPlainText("Firebase Rules", $this_apply.getText().toString());
        clipboard.setPrimaryClip(clip);
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Copied Firebase Rules to clipboard", (Integer) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$1$0$1(LinearLayout $customDbSection, CompoundButton compoundButton, boolean isChecked) {
        $customDbSection.setVisibility(isChecked ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$1$0$2(EditText $syncKeyInput, View it) {
        String randomKey = StringsKt.take(StringsKt.replace$default(UUID.randomUUID().toString(), "-", "", false, 4, (Object) null), 12);
        $syncKeyInput.setText(randomKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$1$0$3(EditText $deviceNameInput, EditText $syncKeyInput, Switch $customDbSwitch, EditText $firebaseUrlInput, AppSettingsSyncCreds $currentCreds, UltimaConfigureAppSettingsSync this$0, AppCompatActivity $context, View $settings, LayoutInflater $inflater, DialogInterface dialogInterface, int i) {
        Lifecycle lifecycle;
        CoroutineScope coroutineScope;
        String devName = StringsKt.trim($deviceNameInput.getText().toString()).toString();
        String key = StringsKt.trim($syncKeyInput.getText().toString()).toString();
        boolean useCustom = $customDbSwitch.isChecked();
        String fbUrl = StringsKt.trim($firebaseUrlInput.getText().toString()).toString();
        if (key.length() == 0) {
            CommonActivity.showToast$default(CommonActivity.INSTANCE, "Sync Key cannot be empty", (Integer) null, 2, (Object) null);
            return;
        }
        String deviceId = $currentCreds.getDeviceId();
        if (deviceId == null) {
            deviceId = UltimaSettingsSyncUtils.INSTANCE.getDeviceId(this$0.packageName, (Context) $context);
        }
        String deviceId2 = deviceId;
        AppSettingsSyncCreds newCreds = AppSettingsSyncCreds.copy$default($currentCreds, useCustom, fbUrl.length() == 0 ? null : fbUrl, key, devName.length() == 0 ? Build.MODEL : devName, deviceId2, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, -32, null);
        this$0.sm.setAppSettingsSyncCreds(newCreds);
        AppCompatActivity appCompatActivity = this$0.activity;
        if (appCompatActivity != null && (lifecycle = appCompatActivity.getLifecycle()) != null && (coroutineScope = LifecycleKt.getCoroutineScope(lifecycle)) != null) {
            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new UltimaConfigureAppSettingsSync$show$2$1$4$1(this$0, $context, $settings, $inflater, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$1$0$4(UltimaConfigureAppSettingsSync this$0, View $settings, LayoutInflater $inflater, DialogInterface dialogInterface, int i) {
        Lifecycle lifecycle;
        CoroutineScope coroutineScope;
        AppCompatActivity appCompatActivity = this$0.activity;
        if (appCompatActivity == null || (lifecycle = appCompatActivity.getLifecycle()) == null || (coroutineScope = LifecycleKt.getCoroutineScope(lifecycle)) == null) {
            return;
        }
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new UltimaConfigureAppSettingsSync$show$2$1$5$1(this$0, $settings, $inflater, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$2$0(UltimaConfigureAppSettingsSync this$0, Switch $this_apply, AppCompatActivity $context, View $settings, CompoundButton compoundButton, boolean checked) {
        AppCompatActivity appCompatActivity;
        Lifecycle lifecycle;
        CoroutineScope coroutineScope;
        AppSettingsSyncCreds creds = this$0.sm.getAppSettingsSyncCreds();
        if (creds != null) {
            creds.setBackupDevice(checked);
            this$0.sm.setAppSettingsSyncCreds(creds);
            if (checked && (appCompatActivity = this$0.activity) != null && (lifecycle = appCompatActivity.getLifecycle()) != null && (coroutineScope = LifecycleKt.getCoroutineScope(lifecycle)) != null) {
                BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new UltimaConfigureAppSettingsSync$show$3$1$1(this$0, $context, $settings, null), 3, (Object) null);
                return;
            }
            return;
        }
        if (checked) {
            CommonActivity.showToast$default(CommonActivity.INSTANCE, "Configure credentials first", (Integer) null, 2, (Object) null);
            $this_apply.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$3$0(UltimaConfigureAppSettingsSync this$0, Switch $this_apply, AppCompatActivity $context, View $settings, CompoundButton compoundButton, boolean checked) {
        AppCompatActivity appCompatActivity;
        Lifecycle lifecycle;
        CoroutineScope coroutineScope;
        AppSettingsSyncCreds creds = this$0.sm.getAppSettingsSyncCreds();
        if (creds != null) {
            creds.setRestoreDevice(checked);
            this$0.sm.setAppSettingsSyncCreds(creds);
            if (checked && (appCompatActivity = this$0.activity) != null && (lifecycle = appCompatActivity.getLifecycle()) != null && (coroutineScope = LifecycleKt.getCoroutineScope(lifecycle)) != null) {
                BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new UltimaConfigureAppSettingsSync$show$4$1$1(this$0, $context, $settings, null), 3, (Object) null);
                return;
            }
            return;
        }
        if (checked) {
            CommonActivity.showToast$default(CommonActivity.INSTANCE, "Configure credentials first", (Integer) null, 2, (Object) null);
            $this_apply.setChecked(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$4$0(UltimaConfigureAppSettingsSync this$0, AppCompatActivity $context, View $settings, View it) {
        Lifecycle lifecycle;
        CoroutineScope coroutineScope;
        AppSettingsSyncCreds creds = this$0.sm.getAppSettingsSyncCreds();
        if (creds == null || !creds.isLoggedIn()) {
            CommonActivity.showToast$default(CommonActivity.INSTANCE, "Configure credentials first", (Integer) null, 2, (Object) null);
            return;
        }
        AppCompatActivity appCompatActivity = this$0.activity;
        if (appCompatActivity != null && (lifecycle = appCompatActivity.getLifecycle()) != null && (coroutineScope = LifecycleKt.getCoroutineScope(lifecycle)) != null) {
            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new UltimaConfigureAppSettingsSync$show$5$1$1(this$0, $context, $settings, null), 3, (Object) null);
        }
    }

    static final void show$lambda$6(UltimaConfigureAppSettingsSync this$0, CheckBox $backupExtensionsCb, CheckBox $restoreExtensionsCb, CheckBox $backupBookmarksCb, CheckBox $restoreBookmarksCb, CheckBox $backupResumeWatchingCb, CheckBox $restoreResumeWatchingCb, CheckBox $backupSearchHistoryCb, CheckBox $restoreSearchHistoryCb, CheckBox $backupPlayerCb, CheckBox $restorePlayerCb, CheckBox $backupSubtitlesCb, CheckBox $restoreSubtitlesCb, CheckBox $backupThemeCb, CheckBox $restoreThemeCb, CheckBox $backupLayoutCb, CheckBox $restoreLayoutCb, CheckBox $backupDownloadsCb, CheckBox $restoreDownloadsCb, CheckBox $backupGeneralCb, CheckBox $restoreGeneralCb, CompoundButton compoundButton, boolean z) {
        AppSettingsSyncCreds creds = this$0.sm.getAppSettingsSyncCreds();
        if (creds == null) {
            creds = new AppSettingsSyncCreds(false, null, null, null, null, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, -1, null);
        }
        creds.setBackupExtensions($backupExtensionsCb.isChecked());
        creds.setRestoreExtensions($restoreExtensionsCb.isChecked());
        creds.setBackupBookmarks($backupBookmarksCb.isChecked());
        creds.setRestoreBookmarks($restoreBookmarksCb.isChecked());
        creds.setBackupResumeWatching($backupResumeWatchingCb.isChecked());
        creds.setRestoreResumeWatching($restoreResumeWatchingCb.isChecked());
        creds.setBackupSearchHistory($backupSearchHistoryCb.isChecked());
        creds.setRestoreSearchHistory($restoreSearchHistoryCb.isChecked());
        creds.setBackupPlayer($backupPlayerCb.isChecked());
        creds.setRestorePlayer($restorePlayerCb.isChecked());
        creds.setBackupSubtitles($backupSubtitlesCb.isChecked());
        creds.setRestoreSubtitles($restoreSubtitlesCb.isChecked());
        creds.setBackupTheme($backupThemeCb.isChecked());
        creds.setRestoreTheme($restoreThemeCb.isChecked());
        creds.setBackupLayout($backupLayoutCb.isChecked());
        creds.setRestoreLayout($restoreLayoutCb.isChecked());
        creds.setBackupDownloads($backupDownloadsCb.isChecked());
        creds.setRestoreDownloads($restoreDownloadsCb.isChecked());
        creds.setBackupGeneral($backupGeneralCb.isChecked());
        creds.setRestoreGeneral($restoreGeneralCb.isChecked());
        this$0.sm.setAppSettingsSyncCreds(creds);
    }

    /* JADX INFO: renamed from: com.phisher98.UltimaConfigureAppSettingsSync$show$7 */
    /* JADX INFO: compiled from: AppSettingsSync.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.UltimaConfigureAppSettingsSync$show$7", f = "AppSettingsSync.kt", i = {}, l = {380}, m = "invokeSuspend", n = {}, nl = {381}, s = {}, v = 2)
    static final class C00077 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LayoutInflater $inflater;
        final /* synthetic */ View $settings;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00077(View view, LayoutInflater layoutInflater, Continuation<? super C00077> continuation) {
            super(2, continuation);
            this.$settings = view;
            this.$inflater = layoutInflater;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UltimaConfigureAppSettingsSync.this.new C00077(this.$settings, this.$inflater, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (UltimaConfigureAppSettingsSync.this.refreshDevicesList(this.$settings, this.$inflater, null, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            UltimaConfigureAppSettingsSync.this.updateLastSyncInfo(this.$settings);
            return Unit.INSTANCE;
        }
    }

    static final void show$lambda$7(UltimaConfigureAppSettingsSync this$0, DialogInterface it) {
        if (!this$0.activity.isFinishing() && !this$0.activity.isDestroyed()) {
            UltimaSettings settingsDialog = new UltimaSettings(this$0.activity);
            settingsDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    public final void updateLastSyncInfo(View rootView) {
        TextView infoView = (TextView) findView(rootView, "last_sync_info");
        StringBuilder sb = new StringBuilder();
        for (SyncCategory category : SyncCategory.getEntries()) {
            long ts = this.sm.getCategoryTimestamp(category);
            if (ts > 0) {
                String time = new SimpleDateFormat("MMM dd, HH:mm", Locale.getDefault()).format(new Date(ts));
                sb.append(category.getKey() + ": " + time).append('\n');
            }
        }
        if (sb.length() == 0) {
            infoView.setText("No sync data yet");
        } else {
            infoView.setText("Last synced:\n" + ((Object) sb));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @SuppressLint({"UseSwitchCompatOrMaterialCode", "SetTextI18n"})
    public final Object refreshDevicesList(View rootView, LayoutInflater inflater, ViewGroup container, Continuation<? super Unit> continuation) {
        C00061 c00061;
        ViewGroup container2;
        AppSettingsSyncCreds creds;
        final View rootView2;
        Object obj;
        final LayoutInflater inflater2;
        LinearLayout devicesListLayout;
        final UltimaConfigureAppSettingsSync ultimaConfigureAppSettingsSync = this;
        if (continuation instanceof C00061) {
            c00061 = (C00061) continuation;
            if ((c00061.label & Integer.MIN_VALUE) != 0) {
                c00061.label -= Integer.MIN_VALUE;
            } else {
                c00061 = ultimaConfigureAppSettingsSync.new C00061(continuation);
            }
        } else {
            c00061 = ultimaConfigureAppSettingsSync.new C00061(continuation);
        }
        C00061 c00062 = c00061;
        Object $result = c00062.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00062.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                LinearLayout devicesListLayout2 = (LinearLayout) ultimaConfigureAppSettingsSync.findView(rootView, "devices_list");
                devicesListLayout2.removeAllViews();
                AppSettingsSyncCreds creds2 = ultimaConfigureAppSettingsSync.sm.getAppSettingsSyncCreds();
                if (creds2 == null) {
                    return Unit.INSTANCE;
                }
                UltimaSettingsSyncUtils ultimaSettingsSyncUtils = UltimaSettingsSyncUtils.INSTANCE;
                c00062.L$0 = rootView;
                c00062.L$1 = inflater;
                container2 = container;
                c00062.L$2 = container2;
                c00062.L$3 = devicesListLayout2;
                c00062.L$4 = creds2;
                c00062.label = 1;
                Object objFetchDevices = ultimaSettingsSyncUtils.fetchDevices(c00062);
                if (objFetchDevices == coroutine_suspended) {
                    return coroutine_suspended;
                }
                creds = creds2;
                rootView2 = rootView;
                obj = objFetchDevices;
                inflater2 = inflater;
                devicesListLayout = devicesListLayout2;
                break;
                break;
            case 1:
                AppSettingsSyncCreds creds3 = (AppSettingsSyncCreds) c00062.L$4;
                LinearLayout devicesListLayout3 = (LinearLayout) c00062.L$3;
                ViewGroup container3 = (ViewGroup) c00062.L$2;
                inflater2 = (LayoutInflater) c00062.L$1;
                View rootView3 = (View) c00062.L$0;
                ResultKt.throwOnFailure($result);
                creds = creds3;
                container2 = container3;
                rootView2 = rootView3;
                obj = $result;
                devicesListLayout = devicesListLayout3;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable devices = (List) obj;
        if (devices == null) {
            return Unit.INSTANCE;
        }
        Iterable $this$forEach$iv = devices;
        for (Object element$iv : $this$forEach$iv) {
            final FirebaseDevice device = (FirebaseDevice) element$iv;
            final boolean isCurrent = Intrinsics.areEqual(device.getDeviceId(), creds.getDeviceId());
            View deviceView = ultimaConfigureAppSettingsSync.getLayout("watch_sync_device", inflater2, container2);
            final Switch nameSwitch = (Switch) ultimaConfigureAppSettingsSync.findView(deviceView, "watch_sync_device_name");
            nameSwitch.setText(device.getName() + (isCurrent ? " (current device)" : ""));
            nameSwitch.setChecked(true);
            nameSwitch.setClickable(true);
            nameSwitch.setFocusable(true);
            nameSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.phisher98.UltimaConfigureAppSettingsSync$$ExternalSyntheticLambda15
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    UltimaConfigureAppSettingsSync.refreshDevicesList$lambda$0$0(this.f$0, device, isCurrent, rootView2, inflater2, nameSwitch, compoundButton, z);
                }
            });
            devicesListLayout.addView(deviceView);
            ultimaConfigureAppSettingsSync = this;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshDevicesList$lambda$0$0(final UltimaConfigureAppSettingsSync this$0, final FirebaseDevice $device, final boolean $isCurrent, final View $rootView, final LayoutInflater $inflater, final Switch $nameSwitch, CompoundButton compoundButton, boolean isChecked) {
        if (!isChecked) {
            AppContextUtils.setDefaultFocus$default(AppContextUtils.INSTANCE, new AlertDialog.Builder(this$0.activity).setTitle("Remove Device").setMessage("Remove '" + $device.getName() + "' from sync network?").setPositiveButton("Remove", new DialogInterface.OnClickListener() { // from class: com.phisher98.UltimaConfigureAppSettingsSync$$ExternalSyntheticLambda12
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    UltimaConfigureAppSettingsSync.refreshDevicesList$lambda$0$0$0(this.f$0, $device, $isCurrent, $rootView, $inflater, $nameSwitch, dialogInterface, i);
                }
            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.phisher98.UltimaConfigureAppSettingsSync$$ExternalSyntheticLambda13
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    UltimaConfigureAppSettingsSync.refreshDevicesList$lambda$0$0$1($nameSwitch, dialogInterface, i);
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.phisher98.UltimaConfigureAppSettingsSync$$ExternalSyntheticLambda14
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    $nameSwitch.setChecked(true);
                }
            }).show(), 0, 1, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshDevicesList$lambda$0$0$0(UltimaConfigureAppSettingsSync this$0, FirebaseDevice $device, boolean $isCurrent, View $rootView, LayoutInflater $inflater, Switch $nameSwitch, DialogInterface dialogInterface, int i) {
        Lifecycle lifecycle;
        CoroutineScope coroutineScope;
        AppCompatActivity appCompatActivity = this$0.activity;
        if (appCompatActivity == null || (lifecycle = appCompatActivity.getLifecycle()) == null || (coroutineScope = LifecycleKt.getCoroutineScope(lifecycle)) == null) {
            return;
        }
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new UltimaConfigureAppSettingsSync$refreshDevicesList$2$1$1$1($device, $isCurrent, this$0, $rootView, $inflater, $nameSwitch, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshDevicesList$lambda$0$0$1(Switch $nameSwitch, DialogInterface dialog, int i) {
        $nameSwitch.setChecked(true);
        dialog.dismiss();
    }
}
