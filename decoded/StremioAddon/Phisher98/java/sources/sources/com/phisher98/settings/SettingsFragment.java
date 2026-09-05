package com.phisher98.settings;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.lagradost.cloudstream3.CommonActivity;
import com.phisher98.StremioAddonProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: SettingsFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StremioAddon/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001)B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0003b\u0010\b\u0014\u0012\f\b\u0015\u0012\b\b\fJ\u0004\b\b(\u0016J#\u0010\u0017\u001a\u0002H\u0018\"\b\b\u0000\u0010\u0018*\u00020\u000b*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u0019J \u0010\u001a\u001a\u00020\u001b*\u0004\u0018\u00010\u000bH\u0003b\u0010\b\u0014\u0012\f\b\u0015\u0012\b\b\fJ\u0004\b\b(\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0002J\u0016\u0010\u001e\u001a\u00020\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0 H\u0002J6\u0010!\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\"\u001a\u0004\u0018\u00010#H\u0017b\u0010\b\u0014\u0012\f\b\u0015\u0012\b\b\fJ\u0004\b\b($J(\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0017b\f\b'\u0012\b\b\u0015\u0012\u0004\b\u0003\u0010.J\b\u0010(\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/phisher98/settings/SettingsFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "plugin", "Lcom/phisher98/StremioAddonProvider;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Lcom/phisher98/StremioAddonProvider;Landroid/content/SharedPreferences;)V", "res", "Landroid/content/res/Resources;", "getLayout", "Landroid/view/View;", "name", "", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "Landroid/annotation/SuppressLint;", "value", "UseCompatLoadingForDrawables", "findView", "T", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "makeTvCompatible", "", "loadAddonsFromPrefs", "", "saveAddonsToPrefs", "addons", "", "onCreateView", "savedInstanceState", "Landroid/os/Bundle;", "NotifyDataSetChanged", "onViewCreated", "view", "Landroidx/annotation/RequiresApi;", "restartApp", "AddonAdapter", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsFragment.kt\ncom/phisher98/settings/SettingsFragment\n+ 2 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,219:1\n40#2,5:220\n45#2,6:233\n43#2,2:239\n45#2,6:246\n777#3:225\n873#3,2:226\n2068#3,2:228\n2077#3,3:230\n777#3:241\n873#3,2:242\n2068#3,2:244\n*S KotlinDebug\n*F\n+ 1 SettingsFragment.kt\ncom/phisher98/settings/SettingsFragment\n*L\n76#1:220,5\n76#1:233,6\n148#1:239,2\n148#1:246,6\n79#1:225\n79#1:226,2\n80#1:228,2\n83#1:230,3\n150#1:241\n150#1:242,2\n151#1:244,2\n*E\n"})
public final class SettingsFragment extends BottomSheetDialogFragment {

    @NotNull
    private final Resources res;

    @NotNull
    private final SharedPreferences sharedPref;

    public SettingsFragment(@NotNull StremioAddonProvider plugin, @NotNull SharedPreferences sharedPref) throws Exception {
        this.sharedPref = sharedPref;
        Resources resources = plugin.getResources();
        if (resources != null) {
            this.res = resources;
            return;
        }
        throw new Exception("Unable to read resources");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getLayout(String name, LayoutInflater inflater, ViewGroup container) {
        int id = this.res.getIdentifier(name, "layout", "com.phisher98");
        return inflater.inflate((XmlPullParser) this.res.getLayout(id), container, false);
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final Drawable getDrawable(String name) {
        int id = this.res.getIdentifier(name, "drawable", "com.phisher98");
        return this.res.getDrawable(id, null);
    }

    private final <T extends View> T findView(View view, String str) {
        return (T) view.findViewById(this.res.getIdentifier(str, "id", "com.phisher98"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public final void makeTvCompatible(View $this$makeTvCompatible) {
        int outlineId;
        Drawable drawable;
        if ($this$makeTvCompatible != null && (outlineId = this.res.getIdentifier("outline", "drawable", "com.phisher98")) != 0 && (drawable = this.res.getDrawable(outlineId, null)) != null) {
            $this$makeTvCompatible.setBackground(drawable);
        }
    }

    private final List<String> loadAddonsFromPrefs() {
        List addons = new ArrayList();
        int index = 0;
        while (true) {
            String key = index != 0 ? "stremio_addon" + (index + 1) : "stremio_addon";
            if (this.sharedPref.contains(key)) {
                String string = this.sharedPref.getString(key, "");
                String string2 = string != null ? StringsKt.trim(string).toString() : null;
                String value = string2 != null ? string2 : "";
                if (value.length() > 0) {
                    addons.add(value);
                }
                index++;
            } else {
                return addons;
            }
        }
    }

    private final void saveAddonsToPrefs(List<String> addons) {
        SharedPreferences $this$edit$iv = this.sharedPref;
        boolean commit$iv = false;
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        Iterable $this$filter$iv = this.sharedPref.getAll().keySet();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String it = (String) element$iv$iv;
            SharedPreferences $this$edit$iv2 = $this$edit$iv;
            boolean commit$iv2 = commit$iv;
            if (StringsKt.startsWith$default(it, "stremio_addon", false, 2, (Object) null)) {
                destination$iv$iv.add(element$iv$iv);
            }
            $this$edit$iv = $this$edit$iv2;
            commit$iv = commit$iv2;
        }
        Iterable $this$forEach$iv = (List) destination$iv$iv;
        for (Object element$iv : $this$forEach$iv) {
            String it2 = (String) element$iv;
            editor$iv.remove(it2);
        }
        List<String> $this$forEachIndexed$iv = addons;
        int index = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String url = (String) item$iv;
            String key = index == 0 ? "stremio_addon" : "stremio_addon" + (index + 1);
            editor$iv.putString(key, url);
            index = index$iv;
        }
        editor$iv.apply();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = getLayout("settings", inflater, container);
        final EditText stremioAddonInput = (EditText) findView(root, "stremio_addon_input");
        Button addAddonButton = (Button) findView(root, "add_addon_button");
        makeTvCompatible(stremioAddonInput);
        makeTvCompatible(addAddonButton);
        final List<String> listLoadAddonsFromPrefs = loadAddonsFromPrefs();
        RecyclerView addonRecyclerView = findView(root, "stremio_addon_list");
        addonRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        final AddonAdapter addonAdapter = new AddonAdapter(listLoadAddonsFromPrefs);
        addonRecyclerView.setAdapter(addonAdapter);
        addAddonButton.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsFragment.onCreateView$lambda$0(stremioAddonInput, listLoadAddonsFromPrefs, addonAdapter, view);
            }
        });
        ImageView saveBtn = (ImageView) findView(root, "save");
        saveBtn.setImageDrawable(getDrawable("save_icon"));
        makeTvCompatible(saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsFragment.onCreateView$lambda$1(this.f$0, listLoadAddonsFromPrefs, view);
            }
        });
        View resetBtn = findView(root, "delete_img");
        makeTvCompatible(resetBtn);
        resetBtn.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsFragment settingsFragment = this.f$0;
                new AlertDialog.Builder(settingsFragment.requireContext()).setTitle("Reset").setMessage("This will delete all saved addons.").setPositiveButton("Reset", new DialogInterface.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SettingsFragment.onCreateView$lambda$2$0(this.f$0, list, addonAdapter, editText, dialogInterface, i);
                    }
                }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
            }
        });
        return root;
    }

    static final void onCreateView$lambda$0(EditText $stremioAddonInput, List $addonList, AddonAdapter $addonAdapter, View it) {
        String text = StringsKt.trim($stremioAddonInput.getText().toString()).toString();
        if (text.length() > 0) {
            $addonList.add(text);
            $addonAdapter.notifyItemInserted($addonList.size() - 1);
            $stremioAddonInput.getText().clear();
        }
    }

    static final void onCreateView$lambda$1(final SettingsFragment this$0, List $addonList, View it) {
        this$0.saveAddonsToPrefs($addonList);
        new AlertDialog.Builder(this$0.requireContext()).setTitle("Restart Required").setMessage("Changes have been saved. Do you want to restart the app to apply them?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SettingsFragment.onCreateView$lambda$1$0(this.f$0, dialogInterface, i);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SettingsFragment.onCreateView$lambda$1$1(this.f$0, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1$0(SettingsFragment this$0, DialogInterface dialogInterface, int i) {
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Saved and Restarting...", (Integer) null, 2, (Object) null);
        this$0.dismiss();
        this$0.restartApp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1$1(SettingsFragment this$0, DialogInterface dialog, int i) {
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Saved. Restart later to apply changes.", (Integer) null, 2, (Object) null);
        dialog.dismiss();
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2$0(SettingsFragment this$0, List $addonList, AddonAdapter $addonAdapter, EditText $stremioAddonInput, DialogInterface dialogInterface, int i) {
        SharedPreferences $this$edit$iv = this$0.sharedPref;
        boolean commit$iv = true;
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        Iterable $this$filter$iv = this$0.sharedPref.getAll().keySet();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String it = (String) element$iv$iv;
            SharedPreferences $this$edit$iv2 = $this$edit$iv;
            boolean commit$iv2 = commit$iv;
            if (StringsKt.startsWith$default(it, "stremio_addon", false, 2, (Object) null)) {
                destination$iv$iv.add(element$iv$iv);
            }
            $this$edit$iv = $this$edit$iv2;
            commit$iv = commit$iv2;
        }
        Iterable $this$forEach$iv = (List) destination$iv$iv;
        for (Object element$iv : $this$forEach$iv) {
            String it2 = (String) element$iv;
            editor$iv.remove(it2);
        }
        editor$iv.commit();
        int size = $addonList.size();
        if (size > 0) {
            $addonList.clear();
            $addonAdapter.notifyItemRangeRemoved(0, size);
        }
        $stremioAddonInput.getText().clear();
        this$0.restartApp();
    }

    @RequiresApi(23)
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

    /* JADX INFO: compiled from: SettingsFragment.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0013B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ \u0010\t\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/phisher98/settings/SettingsFragment$AddonAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/phisher98/settings/SettingsFragment$AddonAdapter$AddonViewHolder;", "Lcom/phisher98/settings/SettingsFragment;", "items", "", "", "<init>", "(Lcom/phisher98/settings/SettingsFragment;Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "AddonViewHolder", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public final class AddonAdapter extends RecyclerView.Adapter<AddonViewHolder> {

        @NotNull
        private final List<String> items;

        public AddonAdapter(List<String> list) {
            this.items = list;
        }

        /* JADX INFO: compiled from: SettingsFragment.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/phisher98/settings/SettingsFragment$AddonAdapter$AddonViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Lcom/phisher98/settings/SettingsFragment$AddonAdapter;Landroid/view/View;)V", "urlText", "Landroid/widget/TextView;", "getUrlText", "()Landroid/widget/TextView;", "deleteButton", "Landroid/widget/Button;", "getDeleteButton", "()Landroid/widget/Button;", "StremioAddon"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public final class AddonViewHolder extends RecyclerView.ViewHolder {

            @NotNull
            private final Button deleteButton;

            @NotNull
            private final TextView urlText;

            public AddonViewHolder(View view) {
                super(view);
                this.urlText = (TextView) view.findViewById(SettingsFragment.this.res.getIdentifier("addon_url_text", "id", "com.phisher98"));
                this.deleteButton = (Button) view.findViewById(SettingsFragment.this.res.getIdentifier("delete_addon_button", "id", "com.phisher98"));
            }

            @NotNull
            public final TextView getUrlText() {
                return this.urlText;
            }

            @NotNull
            public final Button getDeleteButton() {
                return this.deleteButton;
            }
        }

        @NotNull
        public AddonViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = SettingsFragment.this.getLayout("item_stremio_addon", inflater, parent);
            SettingsFragment.this.makeTvCompatible(view);
            return new AddonViewHolder(view);
        }

        public void onBindViewHolder(@NotNull final AddonViewHolder holder, int position) {
            String url = this.items.get(position);
            holder.getUrlText().setText(url);
            holder.getDeleteButton().setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$AddonAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SettingsFragment.AddonAdapter.onBindViewHolder$lambda$0(holder, this, view);
                }
            });
        }

        static final void onBindViewHolder$lambda$0(AddonViewHolder $holder, AddonAdapter this$0, View it) {
            int pos = $holder.getBindingAdapterPosition();
            if (pos != -1) {
                this$0.items.remove(pos);
                this$0.notifyItemRemoved(pos);
            }
        }

        public int getItemCount() {
            return this.items.size();
        }
    }
}
