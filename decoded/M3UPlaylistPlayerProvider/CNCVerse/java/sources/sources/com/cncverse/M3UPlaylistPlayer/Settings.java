package com.cncverse.M3UPlaylistPlayer;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.lagradost.cloudstream3.CommonActivity;
import com.lagradost.cloudstream3.utils.AppUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Settings.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/M3UPlaylistPlayerProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017J\b\u0010\u0017\u001a\u00020\u0018H\u0003J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/cncverse/M3UPlaylistPlayer/Settings;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "plugin", "Lcom/cncverse/M3UPlaylistPlayer/M3UPlaylistPlayerPlugin;", "sharedPref", "Landroid/content/SharedPreferences;", "initialPlaylists", "", "Lcom/cncverse/M3UPlaylistPlayer/PlaylistEntry;", "<init>", "(Lcom/cncverse/M3UPlaylistPlayer/M3UPlaylistPlayerPlugin;Landroid/content/SharedPreferences;Ljava/util/List;)V", "currentPlaylists", "", "playlistsContainer", "Landroid/widget/LinearLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "refreshPlaylistsList", "", "saveAndRestart", "restartApp", "M3UPlaylistPlayerProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Settings.kt\ncom/cncverse/M3UPlaylistPlayer/Settings\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,248:1\n1#2:249\n1924#3,3:250\n*S KotlinDebug\n*F\n+ 1 Settings.kt\ncom/cncverse/M3UPlaylistPlayer/Settings\n*L\n165#1:250,3\n*E\n"})
public final class Settings extends BottomSheetDialogFragment {

    @NotNull
    private final List<PlaylistEntry> currentPlaylists;

    @NotNull
    private final List<PlaylistEntry> initialPlaylists;
    private LinearLayout playlistsContainer;

    @NotNull
    private final M3UPlaylistPlayerPlugin plugin;

    @Nullable
    private final SharedPreferences sharedPref;

    public Settings(@NotNull M3UPlaylistPlayerPlugin plugin, @Nullable SharedPreferences sharedPref, @NotNull List<PlaylistEntry> list) {
        this.plugin = plugin;
        this.sharedPref = sharedPref;
        this.initialPlaylists = list;
        this.currentPlaylists = CollectionsKt.toMutableList(this.initialPlaylists);
    }

    @SuppressLint({"SetTextI18n"})
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Context context = requireContext();
        float dp = context.getResources().getDisplayMetrics().density;
        LinearLayout rootLayout = new LinearLayout(context);
        rootLayout.setOrientation(1);
        float f = 16;
        rootLayout.setPadding((int) (f * dp), (int) (f * dp), (int) (f * dp), (int) (f * dp));
        rootLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        TextView $this$onCreateView_u24lambda_u241 = new TextView(context);
        $this$onCreateView_u24lambda_u241.setText("M3U PlayList Player Settings");
        $this$onCreateView_u24lambda_u241.setTextSize(20.0f);
        $this$onCreateView_u24lambda_u241.setTypeface(Typeface.DEFAULT_BOLD);
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u241_u240 = new LinearLayout.LayoutParams(-1, -2);
        $this$onCreateView_u24lambda_u241_u240.bottomMargin = (int) (f * dp);
        $this$onCreateView_u24lambda_u241.setLayoutParams($this$onCreateView_u24lambda_u241_u240);
        rootLayout.addView($this$onCreateView_u24lambda_u241);
        final EditText $this$onCreateView_u24lambda_u242 = new EditText(context);
        $this$onCreateView_u24lambda_u242.setHint("Playlist Name");
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u242_u240 = new LinearLayout.LayoutParams(-1, -2);
        float f2 = 8;
        $this$onCreateView_u24lambda_u242_u240.bottomMargin = (int) (f2 * dp);
        $this$onCreateView_u24lambda_u242.setLayoutParams($this$onCreateView_u24lambda_u242_u240);
        rootLayout.addView($this$onCreateView_u24lambda_u242);
        final EditText $this$onCreateView_u24lambda_u243 = new EditText(context);
        $this$onCreateView_u24lambda_u243.setHint("M3U8 URL");
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u243_u240 = new LinearLayout.LayoutParams(-1, -2);
        $this$onCreateView_u24lambda_u243_u240.bottomMargin = (int) (f2 * dp);
        $this$onCreateView_u24lambda_u243.setLayoutParams($this$onCreateView_u24lambda_u243_u240);
        rootLayout.addView($this$onCreateView_u24lambda_u243);
        Button addButton = new Button(context);
        addButton.setText("Add Playlist");
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u244_u240 = new LinearLayout.LayoutParams(-1, -2);
        $this$onCreateView_u24lambda_u244_u240.bottomMargin = (int) (f * dp);
        addButton.setLayoutParams($this$onCreateView_u24lambda_u244_u240);
        rootLayout.addView(addButton);
        TextView $this$onCreateView_u24lambda_u245 = new TextView(context);
        $this$onCreateView_u24lambda_u245.setText("Registered Playlists");
        $this$onCreateView_u24lambda_u245.setTextSize(16.0f);
        $this$onCreateView_u24lambda_u245.setTypeface(Typeface.DEFAULT_BOLD);
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u245_u240 = new LinearLayout.LayoutParams(-1, -2);
        $this$onCreateView_u24lambda_u245_u240.bottomMargin = (int) (f2 * dp);
        $this$onCreateView_u24lambda_u245.setLayoutParams($this$onCreateView_u24lambda_u245_u240);
        rootLayout.addView($this$onCreateView_u24lambda_u245);
        ScrollView scrollView = new ScrollView(context);
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0f));
        LinearLayout $this$onCreateView_u24lambda_u247 = new LinearLayout(context);
        $this$onCreateView_u24lambda_u247.setOrientation(1);
        $this$onCreateView_u24lambda_u247.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.playlistsContainer = $this$onCreateView_u24lambda_u247;
        LinearLayout linearLayout = this.playlistsContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playlistsContainer");
            linearLayout = null;
        }
        scrollView.addView(linearLayout);
        rootLayout.addView(scrollView);
        Button saveButton = new Button(context);
        saveButton.setText("Save & Restart App");
        LinearLayout.LayoutParams $this$onCreateView_u24lambda_u248_u240 = new LinearLayout.LayoutParams(-1, -2);
        $this$onCreateView_u24lambda_u248_u240.topMargin = (int) (f * dp);
        saveButton.setLayoutParams($this$onCreateView_u24lambda_u248_u240);
        rootLayout.addView(saveButton);
        refreshPlaylistsList();
        addButton.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.M3UPlaylistPlayer.Settings$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Settings.onCreateView$lambda$9($this$onCreateView_u24lambda_u242, $this$onCreateView_u24lambda_u243, this, view);
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.M3UPlaylistPlayer.Settings$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.saveAndRestart();
            }
        });
        return rootLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$9(EditText $nameInput, EditText $urlInput, Settings this$0, View it) {
        String name = StringsKt.trim($nameInput.getText().toString()).toString();
        String url = StringsKt.trim($urlInput.getText().toString()).toString();
        if (name.length() > 0) {
            if (url.length() > 0) {
                this$0.currentPlaylists.add(new PlaylistEntry(name, url));
                $nameInput.getText().clear();
                $urlInput.getText().clear();
                this$0.refreshPlaylistsList();
                CommonActivity.showToast$default(CommonActivity.INSTANCE, "Playlist added.", (Integer) null, 2, (Object) null);
                return;
            }
        }
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Please enter both name and URL.", (Integer) null, 2, (Object) null);
    }

    @SuppressLint({"SetTextI18n"})
    private final void refreshPlaylistsList() {
        LinearLayout linearLayout;
        Context context = requireContext();
        float dp = context.getResources().getDisplayMetrics().density;
        LinearLayout linearLayout2 = this.playlistsContainer;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playlistsContainer");
            linearLayout2 = null;
        }
        linearLayout2.removeAllViews();
        int i = 0;
        if (this.currentPlaylists.isEmpty()) {
            TextView $this$refreshPlaylistsList_u24lambda_u240 = new TextView(context);
            $this$refreshPlaylistsList_u24lambda_u240.setText("No playlists added yet.");
            float f = 8;
            $this$refreshPlaylistsList_u24lambda_u240.setPadding(0, (int) (f * dp), 0, (int) (f * dp));
            LinearLayout linearLayout3 = this.playlistsContainer;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playlistsContainer");
                linearLayout = null;
            } else {
                linearLayout = linearLayout3;
            }
            linearLayout.addView($this$refreshPlaylistsList_u24lambda_u240);
            return;
        }
        Iterable $this$forEachIndexed$iv = this.currentPlaylists;
        final int index = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            PlaylistEntry playlist = (PlaylistEntry) item$iv;
            LinearLayout row = new LinearLayout(context);
            row.setOrientation(i);
            float dp2 = dp;
            LinearLayout.LayoutParams $this$refreshPlaylistsList_u24lambda_u241_u240_u240 = new LinearLayout.LayoutParams(-1, -2);
            Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
            float f2 = 8;
            $this$refreshPlaylistsList_u24lambda_u241_u240_u240.bottomMargin = (int) (f2 * dp2);
            row.setLayoutParams($this$refreshPlaylistsList_u24lambda_u241_u240_u240);
            row.setPadding((int) (f2 * dp2), (int) (f2 * dp2), (int) (f2 * dp2), (int) (f2 * dp2));
            row.setBackgroundColor(Color.parseColor("#1Affffff"));
            LinearLayout $this$refreshPlaylistsList_u24lambda_u241_u241 = new LinearLayout(context);
            $this$refreshPlaylistsList_u24lambda_u241_u241.setOrientation(1);
            $this$refreshPlaylistsList_u24lambda_u241_u241.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            TextView $this$refreshPlaylistsList_u24lambda_u241_u242 = new TextView(context);
            $this$refreshPlaylistsList_u24lambda_u241_u242.setText(playlist.getName());
            $this$refreshPlaylistsList_u24lambda_u241_u242.setTextSize(16.0f);
            $this$refreshPlaylistsList_u24lambda_u241_u242.setTypeface(Typeface.DEFAULT_BOLD);
            TextView $this$refreshPlaylistsList_u24lambda_u241_u243 = new TextView(context);
            $this$refreshPlaylistsList_u24lambda_u241_u243.setText(playlist.getUrl());
            $this$refreshPlaylistsList_u24lambda_u241_u243.setTextSize(12.0f);
            $this$refreshPlaylistsList_u24lambda_u241_u243.setMaxLines(1);
            $this$refreshPlaylistsList_u24lambda_u241_u241.addView($this$refreshPlaylistsList_u24lambda_u241_u242);
            $this$refreshPlaylistsList_u24lambda_u241_u241.addView($this$refreshPlaylistsList_u24lambda_u241_u243);
            Button $this$refreshPlaylistsList_u24lambda_u241_u244 = new Button(context);
            Context context2 = context;
            $this$refreshPlaylistsList_u24lambda_u241_u244.setText("Remove");
            $this$refreshPlaylistsList_u24lambda_u241_u244.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            $this$refreshPlaylistsList_u24lambda_u241_u244.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.M3UPlaylistPlayer.Settings$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Settings.refreshPlaylistsList$lambda$1$4$0(this.f$0, index, view);
                }
            });
            row.addView($this$refreshPlaylistsList_u24lambda_u241_u241);
            row.addView($this$refreshPlaylistsList_u24lambda_u241_u244);
            LinearLayout linearLayout4 = this.playlistsContainer;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playlistsContainer");
                linearLayout4 = null;
            }
            linearLayout4.addView(row);
            index = index$iv;
            context = context2;
            $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
            dp = dp2;
            i = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshPlaylistsList$lambda$1$4$0(Settings this$0, int $index, View it) {
        this$0.currentPlaylists.remove($index);
        this$0.refreshPlaylistsList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveAndRestart() {
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutString;
        String json = AppUtils.INSTANCE.toJson(this.currentPlaylists);
        SharedPreferences sharedPreferences = this.sharedPref;
        if (sharedPreferences != null && (editorEdit = sharedPreferences.edit()) != null && (editorPutString = editorEdit.putString("playlists", json)) != null) {
            editorPutString.apply();
        }
        new AlertDialog.Builder(requireContext()).setTitle("Restart Required").setMessage("Settings saved. The app must be restarted to apply changes.").setPositiveButton("Restart Now", new DialogInterface.OnClickListener() { // from class: com.cncverse.M3UPlaylistPlayer.Settings$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                Settings.saveAndRestart$lambda$0(this.f$0, dialogInterface, i);
            }
        }).setNegativeButton("Later", new DialogInterface.OnClickListener() { // from class: com.cncverse.M3UPlaylistPlayer.Settings$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void saveAndRestart$lambda$0(Settings this$0, DialogInterface dialogInterface, int i) {
        this$0.dismiss();
        this$0.restartApp();
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
