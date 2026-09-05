package com.phisher98.settings;

import android.R;
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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.lagradost.cloudstream3.CommonActivity;
import com.phisher98.TorraStreamProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: SettingsFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/TorraStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0002J#\u0010\u0014\u001a\u0002H\u0015\"\b\b\u0000\u0010\u0015*\u00020\u000b*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u0016J \u0010\u0017\u001a\u00020\u0018*\u0004\u0018\u00010\u000bH\u0003b\u0010\b\u0019\u0012\f\b\u001a\u0012\b\b\fJ\u0004\b\b(\u001bJ$\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J(\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0017b\f\b!\u0012\b\b\u001a\u0012\u0004\b\u0003\u0010.J\b\u0010\"\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/phisher98/settings/SettingsFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "plugin", "Lcom/phisher98/TorraStreamProvider;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Lcom/phisher98/TorraStreamProvider;Landroid/content/SharedPreferences;)V", "res", "Landroid/content/res/Resources;", "getLayout", "Landroid/view/View;", "name", "", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "getDrawable", "Landroid/graphics/drawable/Drawable;", "findView", "T", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "makeTvCompatible", "", "Landroid/annotation/SuppressLint;", "value", "UseCompatLoadingForDrawables", "onCreateView", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroidx/annotation/RequiresApi;", "restartApp", "TorraStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSettingsFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsFragment.kt\ncom/phisher98/settings/SettingsFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,350:1\n2068#2,2:351\n2068#2,2:353\n2068#2,2:355\n2068#2,2:357\n788#2:359\n800#2:360\n2077#2,2:361\n801#2,2:363\n2079#2:365\n803#2:366\n788#2:372\n800#2:373\n2077#2,2:374\n801#2,2:376\n2079#2:378\n803#2:379\n788#2:388\n800#2:389\n2077#2,2:390\n801#2,2:392\n2079#2:394\n803#2:395\n788#2:401\n800#2:402\n2077#2,2:403\n801#2,2:405\n2079#2:407\n803#2:408\n788#2:418\n800#2:419\n2077#2,2:420\n801#2,2:422\n2079#2:424\n803#2:425\n788#2:431\n800#2:432\n2077#2,2:433\n801#2,2:435\n2079#2:437\n803#2:438\n788#2:447\n800#2:448\n2077#2,2:449\n801#2,2:451\n2079#2:453\n803#2:454\n788#2:460\n800#2:461\n2077#2,2:462\n801#2,2:464\n2079#2:466\n803#2:467\n788#2:481\n800#2:482\n2077#2,2:483\n801#2,2:485\n2079#2:487\n803#2:488\n788#2:489\n800#2:490\n2077#2,2:491\n801#2,2:493\n2079#2:495\n803#2:496\n788#2:497\n800#2:498\n2077#2,2:499\n801#2,2:501\n2079#2:503\n803#2:504\n788#2:505\n800#2:506\n2077#2,2:507\n801#2,2:509\n2079#2:511\n803#2:512\n40#3,5:367\n45#3,6:380\n40#3,5:396\n45#3,6:409\n40#3,5:426\n45#3,6:439\n40#3,5:455\n45#3,6:468\n40#3,5:476\n45#3,6:513\n43#3,8:519\n37#4,2:386\n37#4,2:415\n37#4,2:445\n37#4,2:474\n1#5:417\n*S KotlinDebug\n*F\n+ 1 SettingsFragment.kt\ncom/phisher98/settings/SettingsFragment\n*L\n67#1:351,2\n108#1:353,2\n166#1:355,2\n208#1:357,2\n73#1:359\n73#1:360\n73#1:361,2\n73#1:363,2\n73#1:365\n73#1:366\n90#1:372\n90#1:373\n90#1:374,2\n90#1:376,2\n90#1:378\n90#1:379\n114#1:388\n114#1:389\n114#1:390,2\n114#1:392,2\n114#1:394\n114#1:395\n131#1:401\n131#1:402\n131#1:403,2\n131#1:405,2\n131#1:407\n131#1:408\n172#1:418\n172#1:419\n172#1:420,2\n172#1:422,2\n172#1:424\n172#1:425\n190#1:431\n190#1:432\n190#1:433,2\n190#1:435,2\n190#1:437\n190#1:438\n214#1:447\n214#1:448\n214#1:449,2\n214#1:451,2\n214#1:453\n214#1:454\n231#1:460\n231#1:461\n231#1:462,2\n231#1:464,2\n231#1:466\n231#1:467\n277#1:481\n277#1:482\n277#1:483,2\n277#1:485,2\n277#1:487\n277#1:488\n278#1:489\n278#1:490\n278#1:491,2\n278#1:493,2\n278#1:495\n278#1:496\n279#1:497\n279#1:498\n279#1:499,2\n279#1:501,2\n279#1:503\n279#1:504\n280#1:505\n280#1:506\n280#1:507,2\n280#1:509,2\n280#1:511\n280#1:512\n87#1:367,5\n87#1:380,6\n128#1:396,5\n128#1:409,6\n187#1:426,5\n187#1:439,6\n228#1:455,5\n228#1:468,6\n276#1:476,5\n276#1:513,6\n312#1:519,8\n82#1:386,2\n123#1:415,2\n182#1:445,2\n223#1:474,2\n*E\n"})
public final class SettingsFragment extends BottomSheetDialogFragment {

    @NotNull
    private final Resources res;

    @NotNull
    private final SharedPreferences sharedPref;

    public SettingsFragment(@NotNull TorraStreamProvider plugin, @NotNull SharedPreferences sharedPref) throws Exception {
        this.sharedPref = sharedPref;
        Resources resources = plugin.getResources();
        if (resources != null) {
            this.res = resources;
            return;
        }
        throw new Exception("Unable to read resources");
    }

    private final View getLayout(String name, LayoutInflater inflater, ViewGroup container) {
        int id = this.res.getIdentifier(name, "layout", "com.phisher98");
        return inflater.inflate((XmlPullParser) this.res.getLayout(id), container, false);
    }

    private final Drawable getDrawable(String name) {
        int id = this.res.getIdentifier(name, "drawable", "com.phisher98");
        return this.res.getDrawable(id, null);
    }

    private final <T extends View> T findView(View view, String str) {
        return (T) view.findViewById(this.res.getIdentifier(str, "id", "com.phisher98"));
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final void makeTvCompatible(View $this$makeTvCompatible) {
        int outlineId;
        Drawable drawable;
        if ($this$makeTvCompatible != null && (outlineId = this.res.getIdentifier("outline", "drawable", "com.phisher98")) != 0 && (drawable = this.res.getDrawable(outlineId, null)) != null) {
            $this$makeTvCompatible.setBackground(drawable);
        }
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Iterable iterableListOf;
        boolean z;
        int pos;
        Iterable iterableSplit$default;
        Iterable iterableSplit$default2;
        int pos2;
        Iterable $this$forEach$iv;
        View root = getLayout("settings", inflater, container);
        final TextView mainApiTextView = (TextView) findView(root, "mainapi_spinner");
        final List mainApis = CollectionsKt.listOf(new String[]{"TorraStream (TMDB)", "TorraStream-Anime"});
        final List mainApiKeys = CollectionsKt.listOf(new String[]{"TMDB", "Anime"});
        final boolean[] selectedMainApis = new boolean[mainApis.size()];
        String savedMainApisString = this.sharedPref.getString("main_apis", "TMDB,Anime");
        if (savedMainApisString == null || (iterableListOf = StringsKt.split$default(savedMainApisString, new String[]{","}, false, 0, 6, (Object) null)) == null) {
            iterableListOf = CollectionsKt.listOf(new String[]{"TMDB", "Anime"});
        }
        Iterable savedMainApis = iterableListOf;
        for (Object element$iv : savedMainApis) {
            String saved = (String) element$iv;
            int index = mainApiKeys.indexOf(saved);
            if (index >= 0) {
                selectedMainApis[index] = true;
            }
        }
        final Function0 updateMainApiText = new Function0() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda7
            public final Object invoke() {
                return SettingsFragment.onCreateView$lambda$1(mainApis, mainApiTextView, selectedMainApis);
            }
        };
        updateMainApiText.invoke();
        mainApiTextView.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsFragment.onCreateView$lambda$2(this.f$0, mainApis, selectedMainApis, updateMainApiText, mainApiKeys, view);
            }
        });
        makeTvCompatible(mainApiTextView);
        final TextView providerTextView = (TextView) findView(root, "providers_spinner");
        final List providers = CollectionsKt.listOf(new String[]{"YTS", "EZTV", "RARBG", "1337x", "ThePirateBay", "KickassTorrents", "TorrentGalaxy", "MagnetDL", "HorribleSubs", "NyaaSi", "TokyoTosho", "AniDex", "Rutor", "RuTracker", "Comando", "BluDV", "Torrent9", "ilCorSaRoNeRo", "MejorTorrent", "Wolfmax4k", "Cinecalidad", "BestTorrents"});
        final boolean[] selectedProviders = new boolean[providers.size()];
        String string = this.sharedPref.getString("provider", "");
        if (string == null || ($this$forEach$iv = StringsKt.split$default(string, new String[]{","}, false, 0, 6, (Object) null)) == null) {
            z = true;
        } else {
            for (Object element$iv2 : $this$forEach$iv) {
                String saved2 = (String) element$iv2;
                int index2 = providers.indexOf(saved2);
                if (index2 >= 0) {
                    selectedProviders[index2] = true;
                }
            }
            z = true;
            Unit unit = Unit.INSTANCE;
        }
        final Function0 updateProviderText = new Function0() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda9
            public final Object invoke() {
                return SettingsFragment.onCreateView$lambda$4(providers, providerTextView, selectedProviders);
            }
        };
        updateProviderText.invoke();
        providerTextView.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsFragment.onCreateView$lambda$5(this.f$0, providers, selectedProviders, updateProviderText, view);
            }
        });
        makeTvCompatible(providerTextView);
        final Spinner sortSpinner = (Spinner) findView(root, "sort_spinner");
        List sortOptions = CollectionsKt.listOf(new String[]{"Seeders", "Qualitysize", "Quality", "Size"});
        ArrayAdapter it = new ArrayAdapter(requireContext(), R.layout.simple_spinner_item, sortOptions);
        it.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        sortSpinner.setAdapter((SpinnerAdapter) it);
        String savedSort = this.sharedPref.getString("sort", null);
        if (savedSort != null && (pos2 = sortOptions.indexOf(savedSort)) >= 0) {
            sortSpinner.setSelection(pos2);
        }
        makeTvCompatible(sortSpinner);
        final TextView languageTextView = (TextView) findView(root, "language_spinner");
        final List languages = CollectionsKt.listOf(new String[]{"Japanese", "Russian", "Italian", "Portuguese", "Spanish", "Latino", "Korean", "Chinese", "Taiwanese", "French", "German", "Dutch", "Hindi", "Telugu", "Tamil", "Polish", "Lithuanian", "Latvian", "Estonian", "Czech", "Slovakian", "Slovenian", "Hungarian", "Romanian", "Bulgarian", "Serbian", "Croatian", "Ukrainian", "Greek", "Danish", "Finnish", "Swedish", "Norwegian", "Turkish", "Arabic", "Persian", "Hebrew", "Vietnamese", "Indonesian", "Malay", "Thai"});
        final boolean[] selectedLanguages = new boolean[languages.size()];
        String string2 = this.sharedPref.getString("language", "");
        if (string2 != null && (iterableSplit$default2 = StringsKt.split$default(string2, new String[]{","}, false, 0, 6, (Object) null)) != null) {
            Iterable $this$forEach$iv2 = iterableSplit$default2;
            for (Object element$iv3 : $this$forEach$iv2) {
                Iterable $this$forEach$iv3 = $this$forEach$iv2;
                String saved3 = (String) element$iv3;
                int index3 = languages.indexOf(saved3);
                if (index3 >= 0) {
                    selectedLanguages[index3] = z;
                }
                $this$forEach$iv2 = $this$forEach$iv3;
            }
            Unit unit2 = Unit.INSTANCE;
        }
        final Function0 updateLanguageText = new Function0() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda11
            public final Object invoke() {
                return SettingsFragment.onCreateView$lambda$8(languages, languageTextView, selectedLanguages);
            }
        };
        updateLanguageText.invoke();
        languageTextView.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsFragment.onCreateView$lambda$9(this.f$0, languages, selectedLanguages, updateLanguageText, view);
            }
        });
        makeTvCompatible(languageTextView);
        final TextView qualityTextView = (TextView) findView(root, "quality_spinner");
        final List qualities = CollectionsKt.listOf(new String[]{"Brremux", "Hdrall", "Dolbyvision", "Dolbyvisionwithhdr", "Threed", "Nonthreed", "4k", "1080p", "720p", "480p", "Other", "Scr", "Cam", "Unknown"});
        final boolean[] selectedQualities = new boolean[qualities.size()];
        String string3 = this.sharedPref.getString("qualityfilter", "");
        if (string3 != null && (iterableSplit$default = StringsKt.split$default(string3, new String[]{","}, false, 0, 6, (Object) null)) != null) {
            Iterable $this$forEach$iv4 = iterableSplit$default;
            for (Object element$iv4 : $this$forEach$iv4) {
                Iterable $this$forEach$iv5 = $this$forEach$iv4;
                String saved4 = (String) element$iv4;
                int index4 = qualities.indexOf(saved4);
                if (index4 >= 0) {
                    selectedQualities[index4] = z;
                }
                $this$forEach$iv4 = $this$forEach$iv5;
            }
            Unit unit3 = Unit.INSTANCE;
        }
        final Function0 updateQualityText = new Function0() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda13
            public final Object invoke() {
                return SettingsFragment.onCreateView$lambda$11(qualities, qualityTextView, selectedQualities);
            }
        };
        updateQualityText.invoke();
        qualityTextView.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsFragment.onCreateView$lambda$12(this.f$0, qualities, selectedQualities, updateQualityText, view);
            }
        });
        makeTvCompatible(qualityTextView);
        final EditText limitInput = (EditText) findView(root, "limit_input");
        limitInput.setText(this.sharedPref.getString("limit", ""));
        makeTvCompatible(limitInput);
        final EditText sizeInput = (EditText) findView(root, "size_filter_input");
        sizeInput.setText(this.sharedPref.getString("sizefilter", ""));
        makeTvCompatible(sizeInput);
        final Spinner debridSpinner = (Spinner) findView(root, "debrid_provider_spinner");
        List debridProviders = CollectionsKt.listOf(new String[]{"None", "RealDebrid", "Premiumize", "AllDebrid", "DebridLink", "EasyDebrid", "Offcloud", "TorBox", "Put.io", "AIO Streams"});
        ArrayAdapter it2 = new ArrayAdapter(requireContext(), R.layout.simple_spinner_item, debridProviders);
        it2.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        debridSpinner.setAdapter((SpinnerAdapter) it2);
        String savedDebrid = this.sharedPref.getString("debrid_provider", null);
        if (savedDebrid != null && (pos = debridProviders.indexOf(savedDebrid)) >= 0) {
            debridSpinner.setSelection(pos);
        }
        makeTvCompatible(debridSpinner);
        final EditText debridKeyInput = (EditText) findView(root, "debrid_key_input");
        debridKeyInput.setText(this.sharedPref.getString("debrid_key", ""));
        makeTvCompatible(debridKeyInput);
        ImageView saveBtn = (ImageView) findView(root, "save");
        saveBtn.setImageDrawable(getDrawable("save_icon"));
        makeTvCompatible(saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsFragment.onCreateView$lambda$14(this.f$0, mainApiKeys, providers, languages, qualities, sortSpinner, limitInput, sizeInput, debridSpinner, debridKeyInput, selectedMainApis, selectedProviders, selectedLanguages, selectedQualities, view);
            }
        });
        View resetBtn = findView(root, "delete_img");
        makeTvCompatible(resetBtn);
        resetBtn.setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingsFragment settingsFragment = this.f$0;
                new AlertDialog.Builder(settingsFragment.requireContext()).setTitle("Reset").setMessage("This will delete all saved settings.").setPositiveButton("Reset", new DialogInterface.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda17
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        SettingsFragment.onCreateView$lambda$15$0(settingsFragment, zArr, function0, zArr, function0, zArr, function0, zArr, function0, spinner, spinner, editText, editText, editText, dialogInterface, i);
                    }
                }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
            }
        });
        return root;
    }

    static final Unit onCreateView$lambda$1(List $mainApis, TextView $mainApiTextView, boolean[] $selectedMainApis) {
        List $this$filterIndexed$iv = $mainApis;
        Collection destination$iv$iv = new ArrayList();
        int index$iv$iv = 0;
        for (Object item$iv$iv$iv : $this$filterIndexed$iv) {
            int index$iv$iv$iv = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int index = index$iv$iv;
            if ($selectedMainApis[index]) {
                destination$iv$iv.add(item$iv$iv$iv);
            }
            index$iv$iv = index$iv$iv$iv;
        }
        List selected = (List) destination$iv$iv;
        $mainApiTextView.setText(selected.isEmpty() ? "Select Main APIs" : CollectionsKt.joinToString$default(selected, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$2(final SettingsFragment this$0, List $mainApis, final boolean[] $selectedMainApis, final Function0 $updateMainApiText, final List $mainApiKeys, View it) {
        List $this$toTypedArray$iv = $mainApis;
        new AlertDialog.Builder(this$0.requireContext()).setTitle("Select Main APIs").setMultiChoiceItems((CharSequence[]) $this$toTypedArray$iv.toArray(new String[0]), $selectedMainApis, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i, boolean z) {
                SettingsFragment.onCreateView$lambda$2$0($selectedMainApis, dialogInterface, i, z);
            }
        }).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SettingsFragment.onCreateView$lambda$2$1($updateMainApiText, this$0, $mainApiKeys, $selectedMainApis, dialogInterface, i);
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2$0(boolean[] $selectedMainApis, DialogInterface dialogInterface, int which, boolean isChecked) {
        $selectedMainApis[which] = isChecked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$2$1(Function0 $updateMainApiText, SettingsFragment this$0, List $mainApiKeys, boolean[] $selectedMainApis, DialogInterface dialogInterface, int i) {
        $updateMainApiText.invoke();
        SharedPreferences $this$edit$iv = this$0.sharedPref;
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        List $this$filterIndexed$iv = $mainApiKeys;
        Collection destination$iv$iv = new ArrayList();
        int index$iv$iv$iv = 0;
        for (Object item$iv$iv$iv : $this$filterIndexed$iv) {
            int index$iv$iv$iv2 = index$iv$iv$iv + 1;
            if (index$iv$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int i2 = index$iv$iv$iv;
            if ($selectedMainApis[i2]) {
                destination$iv$iv.add(item$iv$iv$iv);
            }
            index$iv$iv$iv = index$iv$iv$iv2;
        }
        editor$iv.putString("main_apis", CollectionsKt.joinToString$default((List) destination$iv$iv, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        editor$iv.apply();
    }

    static final Unit onCreateView$lambda$4(List $providers, TextView $providerTextView, boolean[] $selectedProviders) {
        List $this$filterIndexed$iv = $providers;
        Collection destination$iv$iv = new ArrayList();
        int index$iv$iv = 0;
        for (Object item$iv$iv$iv : $this$filterIndexed$iv) {
            int index$iv$iv$iv = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int index = index$iv$iv;
            if ($selectedProviders[index]) {
                destination$iv$iv.add(item$iv$iv$iv);
            }
            index$iv$iv = index$iv$iv$iv;
        }
        List selected = (List) destination$iv$iv;
        $providerTextView.setText(selected.isEmpty() ? "Select Providers" : CollectionsKt.joinToString$default(selected, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$5(final SettingsFragment this$0, final List $providers, final boolean[] $selectedProviders, final Function0 $updateProviderText, View it) {
        List $this$toTypedArray$iv = $providers;
        new AlertDialog.Builder(this$0.requireContext()).setTitle("Select Providers").setMultiChoiceItems((CharSequence[]) $this$toTypedArray$iv.toArray(new String[0]), $selectedProviders, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i, boolean z) {
                SettingsFragment.onCreateView$lambda$5$0($selectedProviders, dialogInterface, i, z);
            }
        }).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SettingsFragment.onCreateView$lambda$5$1($updateProviderText, this$0, $providers, $selectedProviders, dialogInterface, i);
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5$0(boolean[] $selectedProviders, DialogInterface dialogInterface, int which, boolean isChecked) {
        $selectedProviders[which] = isChecked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$5$1(Function0 $updateProviderText, SettingsFragment this$0, List $providers, boolean[] $selectedProviders, DialogInterface dialogInterface, int i) {
        $updateProviderText.invoke();
        SharedPreferences $this$edit$iv = this$0.sharedPref;
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        List $this$filterIndexed$iv = $providers;
        Collection destination$iv$iv = new ArrayList();
        int index$iv$iv$iv = 0;
        for (Object item$iv$iv$iv : $this$filterIndexed$iv) {
            int index$iv$iv$iv2 = index$iv$iv$iv + 1;
            if (index$iv$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int i2 = index$iv$iv$iv;
            if ($selectedProviders[i2]) {
                destination$iv$iv.add(item$iv$iv$iv);
            }
            index$iv$iv$iv = index$iv$iv$iv2;
        }
        editor$iv.putString("provider", CollectionsKt.joinToString$default((List) destination$iv$iv, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        editor$iv.apply();
    }

    static final Unit onCreateView$lambda$8(List $languages, TextView $languageTextView, boolean[] $selectedLanguages) {
        List $this$filterIndexed$iv = $languages;
        Collection destination$iv$iv = new ArrayList();
        int index$iv$iv = 0;
        for (Object item$iv$iv$iv : $this$filterIndexed$iv) {
            int index$iv$iv$iv = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int index = index$iv$iv;
            if ($selectedLanguages[index]) {
                destination$iv$iv.add(item$iv$iv$iv);
            }
            index$iv$iv = index$iv$iv$iv;
        }
        List selected = (List) destination$iv$iv;
        $languageTextView.setText(selected.isEmpty() ? "Select Languages" : CollectionsKt.joinToString$default(selected, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                return SettingsFragment.onCreateView$lambda$8$1((String) obj);
            }
        }, 30, (Object) null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence onCreateView$lambda$8$1(String it) {
        String string;
        if (it.length() > 0) {
            StringBuilder sb = new StringBuilder();
            char c = it.charAt(0);
            String strValueOf = String.valueOf(c);
            Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strValueOf.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            StringBuilder sbAppend = sb.append((Object) upperCase);
            String strSubstring = it.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            string = sbAppend.append(strSubstring).toString();
        } else {
            string = it;
        }
        return string;
    }

    static final void onCreateView$lambda$9(final SettingsFragment this$0, final List $languages, final boolean[] $selectedLanguages, final Function0 $updateLanguageText, View it) {
        List $this$toTypedArray$iv = $languages;
        new AlertDialog.Builder(this$0.requireContext()).setTitle("Select Languages").setMultiChoiceItems((CharSequence[]) $this$toTypedArray$iv.toArray(new String[0]), $selectedLanguages, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda18
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i, boolean z) {
                SettingsFragment.onCreateView$lambda$9$0($selectedLanguages, dialogInterface, i, z);
            }
        }).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda19
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SettingsFragment.onCreateView$lambda$9$1($updateLanguageText, this$0, $languages, $selectedLanguages, dialogInterface, i);
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$9$0(boolean[] $selectedLanguages, DialogInterface dialogInterface, int which, boolean isChecked) {
        $selectedLanguages[which] = isChecked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$9$1(Function0 $updateLanguageText, SettingsFragment this$0, List $languages, boolean[] $selectedLanguages, DialogInterface dialogInterface, int i) {
        $updateLanguageText.invoke();
        SharedPreferences $this$edit$iv = this$0.sharedPref;
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        List $this$filterIndexed$iv = $languages;
        Collection destination$iv$iv = new ArrayList();
        int index$iv$iv$iv = 0;
        for (Object item$iv$iv$iv : $this$filterIndexed$iv) {
            int index$iv$iv$iv2 = index$iv$iv$iv + 1;
            if (index$iv$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int index = index$iv$iv$iv;
            if ($selectedLanguages[index]) {
                destination$iv$iv.add(item$iv$iv$iv);
            }
            index$iv$iv$iv = index$iv$iv$iv2;
        }
        editor$iv.putString("language", CollectionsKt.joinToString$default((List) destination$iv$iv, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        editor$iv.apply();
    }

    static final Unit onCreateView$lambda$11(List $qualities, TextView $qualityTextView, boolean[] $selectedQualities) {
        List $this$filterIndexed$iv = $qualities;
        Collection destination$iv$iv = new ArrayList();
        int index$iv$iv = 0;
        for (Object item$iv$iv$iv : $this$filterIndexed$iv) {
            int index$iv$iv$iv = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int i = index$iv$iv;
            if ($selectedQualities[i]) {
                destination$iv$iv.add(item$iv$iv$iv);
            }
            index$iv$iv = index$iv$iv$iv;
        }
        List selected = (List) destination$iv$iv;
        $qualityTextView.setText(selected.isEmpty() ? "Select Qualities" : CollectionsKt.joinToString$default(selected, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        return Unit.INSTANCE;
    }

    static final void onCreateView$lambda$12(final SettingsFragment this$0, final List $qualities, final boolean[] $selectedQualities, final Function0 $updateQualityText, View it) {
        List $this$toTypedArray$iv = $qualities;
        new AlertDialog.Builder(this$0.requireContext()).setTitle("Select Qualities").setMultiChoiceItems((CharSequence[]) $this$toTypedArray$iv.toArray(new String[0]), $selectedQualities, new DialogInterface.OnMultiChoiceClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda20
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i, boolean z) {
                SettingsFragment.onCreateView$lambda$12$0($selectedQualities, dialogInterface, i, z);
            }
        }).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda21
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SettingsFragment.onCreateView$lambda$12$1($updateQualityText, this$0, $qualities, $selectedQualities, dialogInterface, i);
            }
        }).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$12$0(boolean[] $selectedQualities, DialogInterface dialogInterface, int which, boolean isChecked) {
        $selectedQualities[which] = isChecked;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$12$1(Function0 $updateQualityText, SettingsFragment this$0, List $qualities, boolean[] $selectedQualities, DialogInterface dialogInterface, int i) {
        $updateQualityText.invoke();
        SharedPreferences $this$edit$iv = this$0.sharedPref;
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        List $this$filterIndexed$iv = $qualities;
        Collection destination$iv$iv = new ArrayList();
        int index$iv$iv$iv = 0;
        for (Object item$iv$iv$iv : $this$filterIndexed$iv) {
            int index$iv$iv$iv2 = index$iv$iv$iv + 1;
            if (index$iv$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int i2 = index$iv$iv$iv;
            if ($selectedQualities[i2]) {
                destination$iv$iv.add(item$iv$iv$iv);
            }
            index$iv$iv$iv = index$iv$iv$iv2;
        }
        editor$iv.putString("qualityfilter", CollectionsKt.joinToString$default((List) destination$iv$iv, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        editor$iv.apply();
    }

    static final void onCreateView$lambda$14(final SettingsFragment this$0, List $mainApiKeys, List $providers, List $languages, List $qualities, Spinner $sortSpinner, EditText $limitInput, EditText $sizeInput, Spinner $debridSpinner, EditText $debridKeyInput, boolean[] $selectedMainApis, boolean[] $selectedProviders, boolean[] $selectedLanguages, boolean[] $selectedQualities, View it) {
        String string;
        String string2;
        SharedPreferences $this$edit$iv = this$0.sharedPref;
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        List $this$filterIndexed$iv = $mainApiKeys;
        Collection destination$iv$iv = new ArrayList();
        int index$iv$iv = 0;
        for (Object item$iv$iv$iv : $this$filterIndexed$iv) {
            int index$iv$iv$iv = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int i = index$iv$iv;
            if ($selectedMainApis[i]) {
                destination$iv$iv.add(item$iv$iv$iv);
            }
            index$iv$iv = index$iv$iv$iv;
            $this$edit$iv = $this$edit$iv;
        }
        String str = ",";
        editor$iv.putString("main_apis", CollectionsKt.joinToString$default((List) destination$iv$iv, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        List $this$filterIndexed$iv2 = $providers;
        Collection destination$iv$iv2 = new ArrayList();
        int index$iv$iv2 = 0;
        for (Object item$iv$iv$iv2 : $this$filterIndexed$iv2) {
            int index$iv$iv$iv2 = index$iv$iv2 + 1;
            if (index$iv$iv2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int i2 = index$iv$iv2;
            if ($selectedProviders[i2]) {
                destination$iv$iv2.add(item$iv$iv$iv2);
            }
            index$iv$iv2 = index$iv$iv$iv2;
            str = str;
        }
        String str2 = str;
        editor$iv.putString("provider", CollectionsKt.joinToString$default((List) destination$iv$iv2, str2, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        List $this$filterIndexed$iv3 = $languages;
        Collection destination$iv$iv3 = new ArrayList();
        int index$iv$iv3 = 0;
        for (Object item$iv$iv$iv3 : $this$filterIndexed$iv3) {
            int index$iv$iv$iv3 = index$iv$iv3 + 1;
            if (index$iv$iv3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int i3 = index$iv$iv3;
            if ($selectedLanguages[i3]) {
                destination$iv$iv3.add(item$iv$iv$iv3);
            }
            index$iv$iv3 = index$iv$iv$iv3;
            $this$filterIndexed$iv3 = $this$filterIndexed$iv3;
        }
        editor$iv.putString("language", CollectionsKt.joinToString$default((List) destination$iv$iv3, str2, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        List $this$filterIndexed$iv4 = $qualities;
        Collection destination$iv$iv4 = new ArrayList();
        int index$iv$iv4 = 0;
        for (Object item$iv$iv$iv4 : $this$filterIndexed$iv4) {
            int index$iv$iv$iv4 = index$iv$iv4 + 1;
            if (index$iv$iv4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int i4 = index$iv$iv4;
            if ($selectedQualities[i4]) {
                destination$iv$iv4.add(item$iv$iv$iv4);
            }
            index$iv$iv4 = index$iv$iv$iv4;
            $this$filterIndexed$iv4 = $this$filterIndexed$iv4;
        }
        editor$iv.putString("qualityfilter", CollectionsKt.joinToString$default((List) destination$iv$iv4, str2, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        Object selectedItem = $sortSpinner.getSelectedItem();
        String str3 = "";
        if (selectedItem == null || (string = selectedItem.toString()) == null) {
            string = "";
        }
        editor$iv.putString("sort", string);
        editor$iv.putString("limit", $limitInput.getText().toString());
        editor$iv.putString("sizefilter", $sizeInput.getText().toString());
        Object selectedItem2 = $debridSpinner.getSelectedItem();
        if (selectedItem2 != null && (string2 = selectedItem2.toString()) != null) {
            str3 = string2;
        }
        editor$iv.putString("debrid_provider", str3);
        editor$iv.putString("debrid_key", $debridKeyInput.getText().toString());
        editor$iv.apply();
        new AlertDialog.Builder(this$0.requireContext()).setTitle("Restart Required").setMessage("Changes have been saved. Do you want to restart the app to apply them?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                SettingsFragment.onCreateView$lambda$14$1(this.f$0, dialogInterface, i5);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: com.phisher98.settings.SettingsFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i5) {
                SettingsFragment.onCreateView$lambda$14$2(this.f$0, dialogInterface, i5);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$14$1(SettingsFragment this$0, DialogInterface dialogInterface, int i) {
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Saved and Restarting...", (Integer) null, 2, (Object) null);
        this$0.dismiss();
        this$0.restartApp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$14$2(SettingsFragment this$0, DialogInterface dialog, int i) {
        CommonActivity.showToast$default(CommonActivity.INSTANCE, "Saved. Restart later to apply changes.", (Integer) null, 2, (Object) null);
        dialog.dismiss();
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$15$0(SettingsFragment this$0, boolean[] $selectedMainApis, Function0 $updateMainApiText, boolean[] $selectedProviders, Function0 $updateProviderText, boolean[] $selectedLanguages, Function0 $updateLanguageText, boolean[] $selectedQualities, Function0 $updateQualityText, Spinner $sortSpinner, Spinner $debridSpinner, EditText $limitInput, EditText $sizeInput, EditText $debridKeyInput, DialogInterface dialogInterface, int i) {
        SharedPreferences $this$edit$iv = this$0.sharedPref;
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        editor$iv.clear();
        editor$iv.commit();
        ArraysKt.fill$default($selectedMainApis, false, 0, 0, 6, (Object) null);
        $updateMainApiText.invoke();
        ArraysKt.fill$default($selectedProviders, false, 0, 0, 6, (Object) null);
        $updateProviderText.invoke();
        ArraysKt.fill$default($selectedLanguages, false, 0, 0, 6, (Object) null);
        $updateLanguageText.invoke();
        ArraysKt.fill$default($selectedQualities, false, 0, 0, 6, (Object) null);
        $updateQualityText.invoke();
        $sortSpinner.setSelection(0, false);
        $debridSpinner.setSelection(0, false);
        $limitInput.getText().clear();
        $sizeInput.getText().clear();
        $debridKeyInput.getText().clear();
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
}
