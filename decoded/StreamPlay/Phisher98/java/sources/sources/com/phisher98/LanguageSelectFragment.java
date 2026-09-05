package com.phisher98;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: LanguageSelectFragment.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001(B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000b\u001a\u00020\bH\u0016J\u001e\u0010\u000e\u001a\u00020\b*\u00020\u000fH\u0003b\u0010\b\u0010\u0012\f\b\u0011\u0012\b\b\fJ\u0004\b\b(\u0012J\"\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J#\u0010\u001a\u001a\u0002H\u001b\"\b\b\u0000\u0010\u001b*\u00020\u000f*\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¢\u0006\u0002\u0010\u001cJ$\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020'H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00060!R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/phisher98/LanguageSelectFragment;", "Landroidx/fragment/app/DialogFragment;", "plugin", "Lcom/phisher98/StreamPlayPlugin;", "sharedPref", "Landroid/content/SharedPreferences;", "onDismissCallback", "Lkotlin/Function0;", "", "<init>", "(Lcom/phisher98/StreamPlayPlugin;Landroid/content/SharedPreferences;Lkotlin/jvm/functions/Function0;)V", "onStart", "res", "Landroid/content/res/Resources;", "makeTvCompatible", "Landroid/view/View;", "Landroid/annotation/SuppressLint;", "value", "UseCompatLoadingForDrawables", "getLayout", "name", "", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "findView", "T", "(Landroid/view/View;Ljava/lang/String;)Landroid/view/View;", "languages", "", "Lkotlin/Pair;", "adapter", "Lcom/phisher98/LanguageSelectFragment$LanguageAdapter;", "onCreateView", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "LanguageAdapter", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLanguageSelectFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LanguageSelectFragment.kt\ncom/phisher98/LanguageSelectFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 4 SharedPreferences.kt\nandroidx/core/content/SharedPreferencesKt\n*L\n1#1,209:1\n1221#2:210\n1221#2:211\n71#3,10:212\n93#3,3:222\n40#4,11:225\n*S KotlinDebug\n*F\n+ 1 LanguageSelectFragment.kt\ncom/phisher98/LanguageSelectFragment\n*L\n120#1:210\n143#1:211\n154#1:212,10\n154#1:222,3\n146#1:225,11\n*E\n"})
public final class LanguageSelectFragment extends DialogFragment {
    private LanguageAdapter adapter;

    @NotNull
    private final List<Pair<String, String>> languages;

    @Nullable
    private final Function0<Unit> onDismissCallback;

    @NotNull
    private final Resources res;

    @NotNull
    private final SharedPreferences sharedPref;

    public LanguageSelectFragment(@NotNull StreamPlayPlugin plugin, @NotNull SharedPreferences sharedPref, @Nullable Function0<Unit> function0) throws Exception {
        this.sharedPref = sharedPref;
        this.onDismissCallback = function0;
        Resources resources = plugin.getResources();
        if (resources == null) {
            throw new Exception("Unable to access plugin resources");
        }
        this.res = resources;
        Iterable $this$sortedBy$iv = CollectionsKt.listOf(new Pair[]{TuplesKt.to("South Africa (Afrikaans)", "af-ZA"), TuplesKt.to("United Arab Emirates (Arabic)", "ar-AE"), TuplesKt.to("Saudi Arabia (Arabic)", "ar-SA"), TuplesKt.to("Azerbaijan (Azerbaijani)", "az-AZ"), TuplesKt.to("Bulgaria (Bulgarian)", "bg-BG"), TuplesKt.to("India (Bengali)", "bn-IN"), TuplesKt.to("Spain (Catalan)", "ca-ES"), TuplesKt.to("Czech Republic (Czech)", "cs-CZ"), TuplesKt.to("United Kingdom (Welsh)", "cy-GB"), TuplesKt.to("Denmark (Danish)", "da-DK"), TuplesKt.to("Germany (German)", "de-DE"), TuplesKt.to("Greece (Greek)", "el-GR"), TuplesKt.to("United States (English)", "en-US"), TuplesKt.to("United Kingdom (English)", "en-GB"), TuplesKt.to("Spain (Spanish)", "es-ES"), TuplesKt.to("Latin America (Spanish)", "es-419"), TuplesKt.to("Estonia (Estonian)", "et-EE"), TuplesKt.to("Spain (Basque)", "eu-ES"), TuplesKt.to("Iran (Persian)", "fa-IR"), TuplesKt.to("Finland (Finnish)", "fi-FI"), TuplesKt.to("Philippines (Filipino)", "fil-PH"), TuplesKt.to("France (French)", "fr-FR"), TuplesKt.to("Spain (Galician)", "gl-ES"), TuplesKt.to("India (Gujarati)", "gu-IN"), TuplesKt.to("Israel (Hebrew)", "he-IL"), TuplesKt.to("India (Hindi)", "hi-IN"), TuplesKt.to("Croatia (Croatian)", "hr-HR"), TuplesKt.to("Hungary (Hungarian)", "hu-HU"), TuplesKt.to("Indonesia (Indonesian)", "id-ID"), TuplesKt.to("Iceland (Icelandic)", "is-IS"), TuplesKt.to("Italy (Italian)", "it-IT"), TuplesKt.to("Japan (Japanese)", "ja-JP"), TuplesKt.to("India (Kannada)", "kn-IN"), TuplesKt.to("South Korea (Korean)", "ko-KR"), TuplesKt.to("Lithuania (Lithuanian)", "lt-LT"), TuplesKt.to("Latvia (Latvian)", "lv-LV"), TuplesKt.to("India (Malayalam)", "ml-IN"), TuplesKt.to("Malaysia (Malay)", "ms-MY"), TuplesKt.to("Norway (Norwegian)", "no-NO"), TuplesKt.to("Netherlands (Dutch)", "nl-NL"), TuplesKt.to("Poland (Polish)", "pl-PL"), TuplesKt.to("Brazil (Portuguese)", "pt-BR"), TuplesKt.to("Portugal (Portuguese)", "pt-PT"), TuplesKt.to("Romania (Romanian)", "ro-RO"), TuplesKt.to("Russia (Russian)", "ru-RU"), TuplesKt.to("Slovakia (Slovak)", "sk-SK"), TuplesKt.to("Slovenia (Slovenian)", "sl-SI"), TuplesKt.to("Serbia (Serbian)", "sr-RS"), TuplesKt.to("Sweden (Swedish)", "sv-SE"), TuplesKt.to("India (Tamil)", "ta-IN"), TuplesKt.to("India (Telugu)", "te-IN"), TuplesKt.to("Thailand (Thai)", "th-TH"), TuplesKt.to("Turkey (Turkish)", "tr-TR"), TuplesKt.to("Ukraine (Ukrainian)", "uk-UA"), TuplesKt.to("Vietnam (Vietnamese)", "vi-VN"), TuplesKt.to("China (Chinese Simplified)", "zh-CN"), TuplesKt.to("Taiwan (Chinese Traditional)", "zh-TW")});
        this.languages = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: com.phisher98.LanguageSelectFragment$special$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Pair it = (Pair) t;
                String lowerCase = ((String) it.getFirst()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                Pair it2 = (Pair) t2;
                String lowerCase2 = ((String) it2.getFirst()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                return ComparisonsKt.compareValues(lowerCase, lowerCase2);
            }
        });
    }

    public /* synthetic */ LanguageSelectFragment(StreamPlayPlugin streamPlayPlugin, SharedPreferences sharedPreferences, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(streamPlayPlugin, sharedPreferences, (i & 4) != 0 ? null : function0);
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

    @SuppressLint({"UseCompatLoadingForDrawables"})
    private final void makeTvCompatible(View $this$makeTvCompatible) {
        int outlineId = this.res.getIdentifier("outline", "drawable", "com.phisher98");
        $this$makeTvCompatible.setBackground(this.res.getDrawable(outlineId, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View getLayout(String name, LayoutInflater inflater, ViewGroup container) {
        int id = this.res.getIdentifier(name, "layout", "com.phisher98");
        XmlResourceParser layout = this.res.getLayout(id);
        return inflater.inflate((XmlPullParser) layout, container, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends View> T findView(View view, String str) throws Exception {
        int identifier = this.res.getIdentifier(str, "id", "com.phisher98");
        if (identifier == 0) {
            throw new Exception("View ID " + str + " not found.");
        }
        return (T) view.findViewById(identifier);
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) throws Exception {
        View root = getLayout("fragment_language_select", inflater, container);
        int drawableId = this.res.getIdentifier("dialog_background", "drawable", "com.phisher98");
        LanguageAdapter languageAdapter = null;
        if (drawableId != 0) {
            root.setBackground(this.res.getDrawable(drawableId, null));
        }
        RecyclerView recycler = findView(root, "languageRecycler");
        TextView search = (EditText) findView(root, "searchLanguage");
        makeTvCompatible((View) recycler);
        makeTvCompatible(search);
        recycler.setLayoutManager(new LinearLayoutManager(requireContext()));
        String string = this.sharedPref.getString("tmdb_language_code", "en-US");
        String savedCode = string != null ? string : "en-US";
        Iterable $this$sortedBy$iv = this.languages;
        this.adapter = new LanguageAdapter(CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: com.phisher98.LanguageSelectFragment$onCreateView$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Pair it = (Pair) t;
                String lowerCase = ((String) it.getFirst()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                Pair it2 = (Pair) t2;
                String lowerCase2 = ((String) it2.getFirst()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                return ComparisonsKt.compareValues(lowerCase, lowerCase2);
            }
        }), savedCode, new Function1() { // from class: com.phisher98.LanguageSelectFragment$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return LanguageSelectFragment.onCreateView$lambda$1(this.f$0, (String) obj);
            }
        });
        LanguageAdapter languageAdapter2 = this.adapter;
        if (languageAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            languageAdapter = languageAdapter2;
        }
        recycler.setAdapter(languageAdapter);
        TextView $this$addTextChangedListener$iv = search;
        $this$addTextChangedListener$iv.addTextChangedListener(new TextWatcher() { // from class: com.phisher98.LanguageSelectFragment$onCreateView$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable s) {
                LanguageSelectFragment.LanguageAdapter languageAdapter3 = this.this$0.adapter;
                if (languageAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    languageAdapter3 = null;
                }
                languageAdapter3.filter(String.valueOf(s));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
            }
        });
        return root;
    }

    static final Unit onCreateView$lambda$1(LanguageSelectFragment this$0, String code) {
        SharedPreferences $this$edit$iv = this$0.sharedPref;
        SharedPreferences.Editor editor$iv = $this$edit$iv.edit();
        Intrinsics.checkExpressionValueIsNotNull(editor$iv, "editor");
        editor$iv.putString("tmdb_language_code", code);
        editor$iv.apply();
        Toast.makeText(this$0.requireContext(), "Language set to " + code, 0).show();
        this$0.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: LanguageSelectFragment.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u001eB=\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ \u0010\u0010\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u000b2\u000e\u0010\u0016\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\"\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0007H\u0007b\u0010\b\u001b\u0012\f\b\u001c\u0012\b\b\fJ\u0004\b\b(\u001dR \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00060\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/phisher98/LanguageSelectFragment$LanguageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/phisher98/LanguageSelectFragment$LanguageAdapter$VH;", "Lcom/phisher98/LanguageSelectFragment;", "originalList", "", "Lkotlin/Pair;", "", "selectedCode", "onClick", "Lkotlin/Function1;", "", "<init>", "(Lcom/phisher98/LanguageSelectFragment;Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "filteredList", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "filter", "query", "Landroid/annotation/SuppressLint;", "value", "NotifyDataSetChanged", "VH", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nLanguageSelectFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LanguageSelectFragment.kt\ncom/phisher98/LanguageSelectFragment$LanguageAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,209:1\n777#2:210\n873#2,2:211\n*S KotlinDebug\n*F\n+ 1 LanguageSelectFragment.kt\ncom/phisher98/LanguageSelectFragment$LanguageAdapter\n*L\n198#1:210\n198#1:211,2\n*E\n"})
    public final class LanguageAdapter extends RecyclerView.Adapter<C0041VH> {

        @NotNull
        private List<Pair<String, String>> filteredList;

        @NotNull
        private final Function1<String, Unit> onClick;

        @NotNull
        private final List<Pair<String, String>> originalList;

        @NotNull
        private final String selectedCode;

        /* JADX WARN: Multi-variable type inference failed */
        public LanguageAdapter(@NotNull List<Pair<String, String>> list, @NotNull String selectedCode, Function1<? super String, Unit> function1) {
            this.originalList = list;
            this.selectedCode = selectedCode;
            this.onClick = function1;
            this.filteredList = CollectionsKt.toMutableList(this.originalList);
        }

        /* JADX INFO: renamed from: com.phisher98.LanguageSelectFragment$LanguageAdapter$VH */
        /* JADX INFO: compiled from: LanguageSelectFragment.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/phisher98/LanguageSelectFragment$LanguageAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "<init>", "(Lcom/phisher98/LanguageSelectFragment$LanguageAdapter;Landroid/view/View;)V", "getV", "()Landroid/view/View;", "radio", "Landroid/widget/RadioButton;", "getRadio", "()Landroid/widget/RadioButton;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
        public final class C0041VH extends RecyclerView.ViewHolder {

            @NotNull
            private final RadioButton radio;

            @NotNull
            private final View v;

            public C0041VH(View v) {
                super(v);
                this.v = v;
                this.radio = (RadioButton) LanguageSelectFragment.this.findView(this.v, "radio_language");
            }

            @NotNull
            public final View getV() {
                return this.v;
            }

            @NotNull
            public final RadioButton getRadio() {
                return this.radio;
            }
        }

        @NotNull
        public C0041VH onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
            View view = LanguageSelectFragment.this.getLayout("item_language", LayoutInflater.from(parent.getContext()), parent);
            return new C0041VH(view);
        }

        public void onBindViewHolder(@NotNull C0041VH holder, int position) {
            Pair<String, String> pair = this.filteredList.get(position);
            String name = (String) pair.component1();
            final String code = (String) pair.component2();
            holder.getRadio().setText(name);
            holder.getRadio().setChecked(Intrinsics.areEqual(code, this.selectedCode));
            holder.getRadio().setOnClickListener(new View.OnClickListener() { // from class: com.phisher98.LanguageSelectFragment$LanguageAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.onClick.invoke(code);
                }
            });
        }

        public int getItemCount() {
            return this.filteredList.size();
        }

        @SuppressLint({"NotifyDataSetChanged"})
        public final void filter(@NotNull String query) {
            List<Pair<String, String>> mutableList;
            boolean zIsBlank = StringsKt.isBlank(query);
            Iterable iterable = this.originalList;
            if (zIsBlank) {
                mutableList = CollectionsKt.toMutableList((Collection) iterable);
            } else {
                Iterable $this$filter$iv = iterable;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    Pair it = (Pair) element$iv$iv;
                    if (StringsKt.contains((CharSequence) it.getFirst(), query, true)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                mutableList = CollectionsKt.toMutableList((List) destination$iv$iv);
            }
            this.filteredList = mutableList;
            notifyDataSetChanged();
        }
    }

    public void onDismiss(@NotNull DialogInterface dialog) {
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.onDismissCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
