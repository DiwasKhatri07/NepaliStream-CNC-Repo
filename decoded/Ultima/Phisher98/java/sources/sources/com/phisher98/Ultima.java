package com.phisher98;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.DataStoreHelper;
import com.phisher98.donation.DonationManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Ultima.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Ultima/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020%0#H\u0002J\u001e\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0*H\u0002J \u0010,\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0096@¢\u0006\u0002\u00103J\u001e\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\t2\u0006\u0010/\u001a\u000200H\u0096@¢\u0006\u0002\u00107J\u0016\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010;R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\rR\u0014\u0010\u0018\u001a\u00020\u0019X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u0019X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020%0#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u0006<"}, d2 = {"Lcom/phisher98/Ultima;", "Lcom/lagradost/cloudstream3/MainAPI;", "plugin", "Lcom/phisher98/UltimaPlugin;", "<init>", "(Lcom/phisher98/UltimaPlugin;)V", "getPlugin", "()Lcom/phisher98/UltimaPlugin;", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "setSupportedTypes", "(Ljava/util/Set;)V", "lang", "getLang", "setLang", "hasMainPage", "", "getHasMainPage", "()Z", "hasQuickSearch", "getHasQuickSearch", "sm", "Lcom/phisher98/UltimaStorageManager;", "mapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "sectionNamesList", "", "loadSections", "Lcom/lagradost/cloudstream3/MainPageData;", "buildSectionName", "section", "Lcom/phisher98/UltimaUtils$SectionInfo;", "names", "", "mainPage", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUltima.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Ultima.kt\ncom/phisher98/Ultima\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 6 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n*L\n1#1,226:1\n11615#2:227\n12048#2,5:228\n11615#2:271\n12048#2,5:272\n777#3:233\n873#3,2:234\n1233#3:236\n2068#3,2:237\n1987#3,4:239\n1739#3:267\n1814#3,3:268\n777#3:277\n873#3,2:278\n1739#3:280\n1814#3,3:281\n1795#3,10:284\n2068#3:294\n2069#3:296\n1805#3:297\n777#3:298\n873#3,2:299\n1795#3,10:301\n2068#3:311\n2069#3:332\n1805#3:333\n777#3:334\n873#3,2:335\n50#4:243\n43#4:244\n50#4:246\n43#4:247\n50#4:265\n43#4:266\n50#4:329\n43#4:330\n1#5:245\n1#5:249\n1#5:295\n1#5:313\n1#5:331\n63#6:248\n64#6,15:250\n63#6:312\n64#6,15:314\n*S KotlinDebug\n*F\n+ 1 Ultima.kt\ncom/phisher98/Ultima\n*L\n44#1:227\n44#1:228,5\n155#1:271\n155#1:272,5\n45#1:233\n45#1:234,2\n46#1:236\n48#1:237,2\n68#1:239,4\n139#1:267\n139#1:268,3\n156#1:277\n156#1:278,2\n157#1:280\n157#1:281,3\n164#1:284,10\n164#1:294\n164#1:296\n164#1:297\n194#1:298\n194#1:299,2\n195#1:301,10\n195#1:311\n195#1:332\n195#1:333\n203#1:334\n203#1:335,2\n93#1:243\n93#1:244\n103#1:246\n103#1:247\n120#1:265\n120#1:266\n197#1:329\n197#1:330\n120#1:249\n164#1:295\n197#1:313\n195#1:331\n120#1:248\n120#1:250,15\n197#1:312\n197#1:314,15\n*E\n"})
public final class Ultima extends MainAPI {
    private final boolean hasQuickSearch;

    @NotNull
    private final UltimaPlugin plugin;

    @NotNull
    private String name = "Ultima";

    @NotNull
    private Set<? extends TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Anime});

    @NotNull
    private String lang = "en";
    private final boolean hasMainPage = true;

    @NotNull
    private final UltimaStorageManager sm = UltimaStorageManager.INSTANCE;

    @NotNull
    private final ObjectMapper mapper = ExtensionsKt.jacksonObjectMapper();

    @NotNull
    private List<String> sectionNamesList = CollectionsKt.emptyList();

    /* JADX INFO: renamed from: com.phisher98.Ultima$getMainPage$1 */
    /* JADX INFO: compiled from: Ultima.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Ultima", f = "Ultima.kt", i = {0, 0, 0, 1, 1, 1, 1, 1}, l = {90, 129}, m = "getMainPage", n = {"request", "homeSections", "page", "request", "section", "provider", "liveData", "page"}, nl = {91, 136}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Ultima.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Ultima$load$1 */
    /* JADX INFO: compiled from: Ultima.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Ultima", f = "Ultima.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {207, 221}, m = "load", n = {"url", "enabledPlugins", "providersToTry", "provider", "url", "enabledPlugins", "providersToTry"}, nl = {209, -1}, s = {"L$0", "L$1", "L$2", "L$4", "L$0", "L$1", "L$2"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Ultima.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Ultima$search$1 */
    /* JADX INFO: compiled from: Ultima.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Ultima", f = "Ultima.kt", i = {0, 0, 0, 0, 0}, l = {189}, m = "search", n = {"query", "enabledPluginNames", "allProviders", "tasks", "page"}, nl = {-1}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Ultima.this.search(null, 0, (Continuation) this);
        }
    }

    public Ultima(@NotNull UltimaPlugin plugin) {
        this.plugin = plugin;
    }

    @NotNull
    public final UltimaPlugin getPlugin() {
        return this.plugin;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    public void setSupportedTypes(@NotNull Set<? extends TvType> set) {
        this.supportedTypes = set;
    }

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    private final List<MainPageData> loadSections() {
        List result;
        Iterable iterableEmptyList;
        List tempSectionNames = new ArrayList();
        List result2 = new ArrayList();
        UltimaUtils.ExtensionInfo[] savedPlugins = this.sm.getCurrentExtensions();
        CollectionsKt.addAll(result2, MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("", "watch_sync")}));
        Collection destination$iv$iv = new ArrayList();
        for (UltimaUtils.ExtensionInfo extensionInfo : savedPlugins) {
            UltimaUtils.SectionInfo[] sections = extensionInfo.getSections();
            if (sections == null || (iterableEmptyList = ArraysKt.asList(sections)) == null) {
                iterableEmptyList = CollectionsKt.emptyList();
            }
            Iterable list$iv$iv = iterableEmptyList;
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        Iterable $this$filter$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            UltimaUtils.SectionInfo it = (UltimaUtils.SectionInfo) element$iv$iv;
            if (it.getEnabled()) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        Iterable $this$sortedByDescending$iv = (List) destination$iv$iv2;
        Iterable enabledSections = CollectionsKt.sortedWith($this$sortedByDescending$iv, new Comparator() { // from class: com.phisher98.Ultima$loadSections$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                UltimaUtils.SectionInfo it2 = (UltimaUtils.SectionInfo) t2;
                UltimaUtils.SectionInfo it3 = (UltimaUtils.SectionInfo) t;
                return ComparisonsKt.compareValues(Integer.valueOf(it2.getPriority()), Integer.valueOf(it3.getPriority()));
            }
        });
        Iterable $this$forEach$iv = enabledSections;
        for (Object element$iv : $this$forEach$iv) {
            UltimaUtils.SectionInfo section = (UltimaUtils.SectionInfo) element$iv;
            try {
                String sectionKey = this.mapper.writeValueAsString(section);
                String sectionName = buildSectionName(section, tempSectionNames);
                try {
                    result = result2;
                    try {
                        CollectionsKt.addAll(result2, MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to(sectionKey, sectionName)}));
                    } catch (Exception e) {
                        e = e;
                        Log.INSTANCE.e("loadSections", "Failed to load section " + section.getName() + ": " + e.getMessage());
                    }
                } catch (Exception e2) {
                    e = e2;
                    result = result2;
                }
            } catch (Exception e3) {
                e = e3;
                result = result2;
            }
            result2 = result;
        }
        List result3 = result2;
        this.sectionNamesList = tempSectionNames;
        return result3.size() <= 1 ? MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("", "")}) : result3;
    }

    private final String buildSectionName(UltimaUtils.SectionInfo section, List<String> names) {
        String name;
        if (this.sm.getExtNameOnHome()) {
            name = section.getPluginName() + ": " + section.getName();
        } else if (names.contains(section.getName())) {
            StringBuilder sbAppend = new StringBuilder().append(section.getName()).append(' ');
            List<String> $this$count$iv = names;
            int i = 0;
            if (!($this$count$iv instanceof Collection) || !$this$count$iv.isEmpty()) {
                int count$iv = 0;
                for (Object element$iv : $this$count$iv) {
                    String it = (String) element$iv;
                    if (StringsKt.startsWith$default(it, section.getName(), false, 2, (Object) null) && (count$iv = count$iv + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
                i = count$iv;
            }
            name = sbAppend.append(i + 1).toString();
        } else {
            name = section.getName();
        }
        names.add(name);
        return name;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return loadSections();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:144:0x02bd A[Catch: all -> 0x03d7, TryCatch #17 {all -> 0x03d7, blocks: (B:31:0x009a, B:33:0x00a1, B:109:0x01f9, B:115:0x0224, B:122:0x0253, B:126:0x025c, B:135:0x028c, B:136:0x029b, B:138:0x02a1, B:142:0x02b9, B:144:0x02bd, B:145:0x02c7, B:147:0x02cd, B:151:0x02e6, B:153:0x02eb, B:157:0x02f6, B:156:0x02f2, B:134:0x0277, B:133:0x0271, B:121:0x0248, B:114:0x021a, B:118:0x022b, B:111:0x0201, B:128:0x0262), top: B:224:0x0098, inners: #3, #19, #24 }] */
    /* JADX WARN: Code duplicated, block: B:147:0x02cd A[Catch: all -> 0x03d7, TryCatch #17 {all -> 0x03d7, blocks: (B:31:0x009a, B:33:0x00a1, B:109:0x01f9, B:115:0x0224, B:122:0x0253, B:126:0x025c, B:135:0x028c, B:136:0x029b, B:138:0x02a1, B:142:0x02b9, B:144:0x02bd, B:145:0x02c7, B:147:0x02cd, B:151:0x02e6, B:153:0x02eb, B:157:0x02f6, B:156:0x02f2, B:134:0x0277, B:133:0x0271, B:121:0x0248, B:114:0x021a, B:118:0x022b, B:111:0x0201, B:128:0x0262), top: B:224:0x0098, inners: #3, #19, #24 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x02eb A[Catch: all -> 0x03d7, TryCatch #17 {all -> 0x03d7, blocks: (B:31:0x009a, B:33:0x00a1, B:109:0x01f9, B:115:0x0224, B:122:0x0253, B:126:0x025c, B:135:0x028c, B:136:0x029b, B:138:0x02a1, B:142:0x02b9, B:144:0x02bd, B:145:0x02c7, B:147:0x02cd, B:151:0x02e6, B:153:0x02eb, B:157:0x02f6, B:156:0x02f2, B:134:0x0277, B:133:0x0271, B:121:0x0248, B:114:0x021a, B:118:0x022b, B:111:0x0201, B:128:0x0262), top: B:224:0x0098, inners: #3, #19, #24 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x02f2 A[Catch: all -> 0x03d7, TryCatch #17 {all -> 0x03d7, blocks: (B:31:0x009a, B:33:0x00a1, B:109:0x01f9, B:115:0x0224, B:122:0x0253, B:126:0x025c, B:135:0x028c, B:136:0x029b, B:138:0x02a1, B:142:0x02b9, B:144:0x02bd, B:145:0x02c7, B:147:0x02cd, B:151:0x02e6, B:153:0x02eb, B:157:0x02f6, B:156:0x02f2, B:134:0x0277, B:133:0x0271, B:121:0x0248, B:114:0x021a, B:118:0x022b, B:111:0x0201, B:128:0x0262), top: B:224:0x0098, inners: #3, #19, #24 }] */
    /* JADX WARN: Code duplicated, block: B:161:0x0328 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:162:0x0329  */
    /* JADX WARN: Code duplicated, block: B:165:0x032e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:167:0x0331  */
    /* JADX WARN: Code duplicated, block: B:171:0x0353 A[Catch: all -> 0x03a0, TRY_LEAVE, TryCatch #0 {all -> 0x03a0, blocks: (B:168:0x0333, B:169:0x034d, B:171:0x0353), top: B:199:0x0333 }] */
    /* JADX WARN: Code duplicated, block: B:186:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:243:0x02e5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x0137  */
    /* JADX WARN: Code duplicated, block: B:66:0x013c A[Catch: all -> 0x014d, Exception -> 0x0155, TRY_LEAVE, TryCatch #8 {Exception -> 0x0155, blocks: (B:56:0x011d, B:61:0x012c, B:66:0x013c, B:82:0x017d, B:84:0x0183, B:90:0x0191), top: B:213:0x011d }] */
    /* JADX WARN: Code duplicated, block: B:72:0x015a  */
    /* JADX WARN: Code duplicated, block: B:74:0x015d  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:80:0x017a  */
    /* JADX WARN: Code duplicated, block: B:88:0x018d  */
    /* JADX WARN: Code duplicated, block: B:90:0x0191 A[Catch: Exception -> 0x0155, all -> 0x01a7, TRY_LEAVE, TryCatch #4 {all -> 0x01a7, blocks: (B:75:0x0160, B:82:0x017d, B:84:0x0183, B:90:0x0191), top: B:207:0x0160 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x01b2  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws ErrorLoadingException {
        C00001 c00001;
        MainPageRequest request2;
        Object obj;
        Object obj2;
        Object objDecodeFromString;
        Object next;
        MainAPI provider;
        Iterator it;
        Object next2;
        MainPageData mainPageData;
        String liveData;
        Object mainPage;
        MainPageData it2;
        MainAPI it3;
        ArrayList homeSections;
        MainPageRequest request3;
        Object objFetchCategory;
        SyncCategoryPayload payload;
        int page2;
        BackupFile backupFile;
        Object next3;
        String resumeWatchingKey;
        String resumeWatchingJson;
        List list;
        List resumeWatchingList;
        List list2;
        boolean z;
        HomePageResponse response;
        Collection destination$iv$iv;
        int page3;
        int page4 = page;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
            } else {
                c00001 = new C00001(continuation);
            }
        } else {
            c00001 = new C00001(continuation);
        }
        C00001 c00002 = c00001;
        Object $result = c00002.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00002.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DonationManager.INSTANCE.checkAndShow(getName());
                if (request.getName().length() == 0) {
                    throw new ErrorLoadingException("Select sections from the extension's settings page to show here.");
                }
                try {
                    try {
                        if (!Intrinsics.areEqual(request.getName(), "watch_sync")) {
                            AppUtils appUtils = AppUtils.INSTANCE;
                            String value$iv = request.getData();
                            try {
                                Result.Companion companion = Result.Companion;
                                KType kTypeTypeOf = Reflection.typeOf(UltimaUtils.SectionInfo.class);
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                break;
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            if (Result.exceptionOrNull-impl(obj2) != null) {
                                try {
                                    Result.Companion companion3 = Result.Companion;
                                    obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(UltimaUtils.SectionInfo.class), (List) null, 2, (Object) null));
                                } catch (Throwable th2) {
                                    Result.Companion companion4 = Result.Companion;
                                    obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
                                }
                                break;
                            }
                            DeserializationStrategy deserializationStrategy = (KSerializer) (Result.isFailure-impl(obj2) ? null : obj2);
                            if (deserializationStrategy != null) {
                                try {
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                                } catch (SerializationException e) {
                                    ArchComponentExtKt.logError(e);
                                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv.readValue(value$iv, new TypeReference<UltimaUtils.SectionInfo>() { // from class: com.phisher98.Ultima$getMainPage$$inlined$parseJson$1
                                    });
                                } catch (Throwable th3) {
                                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv2.readValue(value$iv, new TypeReference<UltimaUtils.SectionInfo>() { // from class: com.phisher98.Ultima$getMainPage$$inlined$parseJson$1
                                    });
                                }
                                break;
                            } else {
                                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv3.readValue(value$iv, new TypeReference<UltimaUtils.SectionInfo>() { // from class: com.phisher98.Ultima$getMainPage$$inlined$parseJson$1
                                });
                            }
                            UltimaUtils.SectionInfo section = (UltimaUtils.SectionInfo) objDecodeFromString;
                            Iterator<T> it4 = UltimaUtils.INSTANCE.getAllProviders().iterator();
                            do {
                                if (it4.hasNext()) {
                                    next = it4.next();
                                    it3 = (MainAPI) next;
                                } else {
                                    next = null;
                                }
                                provider = (MainAPI) next;
                                if (provider == null) {
                                    it = provider.getMainPage().iterator();
                                    try {
                                        do {
                                            if (it.hasNext()) {
                                                next2 = it.next();
                                                it2 = (MainPageData) next2;
                                            } else {
                                                next2 = null;
                                            }
                                            mainPageData = (MainPageData) next2;
                                            if (mainPageData != null || (liveData = mainPageData.getData()) == null) {
                                                liveData = section.getUrl();
                                            }
                                            MainPageRequest mainPageRequest = new MainPageRequest(section.getName(), liveData, request.getHorizontalImages());
                                            request2 = request;
                                            c00002.L$0 = request2;
                                            c00002.L$1 = SpillingKt.nullOutSpilledVariable(section);
                                            c00002.L$2 = SpillingKt.nullOutSpilledVariable(provider);
                                            c00002.L$3 = SpillingKt.nullOutSpilledVariable(liveData);
                                            c00002.I$0 = page4;
                                            c00002.label = 2;
                                            mainPage = provider.getMainPage(page4, mainPageRequest, c00002);
                                            if (mainPage == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            try {
                                                response = (HomePageResponse) mainPage;
                                                if (response == null) {
                                                    return null;
                                                }
                                                obj = null;
                                                try {
                                                    Iterable $this$map$iv = response.getItems();
                                                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                                    for (Object item$iv$iv : $this$map$iv) {
                                                        HomePageList list3 = (HomePageList) item$iv$iv;
                                                        String liveData2 = liveData;
                                                        page3 = page4;
                                                        try {
                                                            destination$iv$iv.add(new HomePageList(request2.getName(), list3.getList(), list3.isHorizontalImages()));
                                                            liveData = liveData2;
                                                            page4 = page3;
                                                            response = response;
                                                        } catch (Throwable th4) {
                                                            e = th4;
                                                        }
                                                    }
                                                    page3 = page4;
                                                    return MainAPIKt.newHomePageResponse((List) destination$iv$iv, Boxing.boxBoolean(response.getHasNext()));
                                                } catch (Throwable th5) {
                                                    e = th5;
                                                }
                                            } catch (Throwable th6) {
                                                e = th6;
                                                obj = null;
                                            }
                                        } while (!StringsKt.equals(it2.getName(), section.getName(), true));
                                        c00002.L$0 = request2;
                                        c00002.L$1 = SpillingKt.nullOutSpilledVariable(section);
                                        c00002.L$2 = SpillingKt.nullOutSpilledVariable(provider);
                                        c00002.L$3 = SpillingKt.nullOutSpilledVariable(liveData);
                                        c00002.I$0 = page4;
                                        c00002.label = 2;
                                        mainPage = provider.getMainPage(page4, mainPageRequest, c00002);
                                        if (mainPage == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        response = (HomePageResponse) mainPage;
                                        if (response == null) {
                                            return null;
                                        }
                                        obj = null;
                                        Iterable $this$map$iv2 = response.getItems();
                                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                                        while (r15.hasNext()) {
                                            HomePageList list4 = (HomePageList) item$iv$iv;
                                            String liveData3 = liveData;
                                            page3 = page4;
                                            destination$iv$iv.add(new HomePageList(request2.getName(), list4.getList(), list4.isHorizontalImages()));
                                            liveData = liveData3;
                                            page4 = page3;
                                            response = response;
                                        }
                                        page3 = page4;
                                        return MainAPIKt.newHomePageResponse((List) destination$iv$iv, Boxing.boxBoolean(response.getHasNext()));
                                    } catch (Throwable th7) {
                                        e = th7;
                                        obj = null;
                                    }
                                    mainPageData = (MainPageData) next2;
                                    if (mainPageData != null) {
                                        liveData = section.getUrl();
                                    } else {
                                        liveData = section.getUrl();
                                    }
                                    MainPageRequest mainPageRequest2 = new MainPageRequest(section.getName(), liveData, request.getHorizontalImages());
                                    request2 = request;
                                } else {
                                    request2 = request;
                                    obj = null;
                                    try {
                                        throw new ErrorLoadingException("Provider '" + section.getPluginName() + "' is not available.");
                                    } catch (Throwable th8) {
                                        e = th8;
                                    }
                                }
                            } while (!Intrinsics.areEqual(it3.getName(), section.getPluginName()));
                            provider = (MainAPI) next;
                            if (provider == null) {
                                request2 = request;
                                obj = null;
                                throw new ErrorLoadingException("Provider '" + section.getPluginName() + "' is not available.");
                            }
                            it = provider.getMainPage().iterator();
                            do {
                                if (it.hasNext()) {
                                    next2 = it.next();
                                    it2 = (MainPageData) next2;
                                } else {
                                    next2 = null;
                                }
                                mainPageData = (MainPageData) next2;
                                if (mainPageData != null) {
                                    liveData = section.getUrl();
                                } else {
                                    liveData = section.getUrl();
                                }
                                MainPageRequest mainPageRequest3 = new MainPageRequest(section.getName(), liveData, request.getHorizontalImages());
                                request2 = request;
                                c00002.L$0 = request2;
                                c00002.L$1 = SpillingKt.nullOutSpilledVariable(section);
                                c00002.L$2 = SpillingKt.nullOutSpilledVariable(provider);
                                c00002.L$3 = SpillingKt.nullOutSpilledVariable(liveData);
                                c00002.I$0 = page4;
                                c00002.label = 2;
                                mainPage = provider.getMainPage(page4, mainPageRequest3, c00002);
                                if (mainPage == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                response = (HomePageResponse) mainPage;
                                if (response == null) {
                                    return null;
                                }
                                obj = null;
                                Iterable $this$map$iv3 = response.getItems();
                                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                                while (r15.hasNext()) {
                                    HomePageList list5 = (HomePageList) item$iv$iv;
                                    String liveData4 = liveData;
                                    page3 = page4;
                                    destination$iv$iv.add(new HomePageList(request2.getName(), list5.getList(), list5.isHorizontalImages()));
                                    liveData = liveData4;
                                    page4 = page3;
                                    response = response;
                                }
                                page3 = page4;
                                return MainAPIKt.newHomePageResponse((List) destination$iv$iv, Boxing.boxBoolean(response.getHasNext()));
                            } while (!StringsKt.equals(it2.getName(), section.getName(), true));
                            mainPageData = (MainPageData) next2;
                            if (mainPageData != null) {
                                liveData = section.getUrl();
                            } else {
                                liveData = section.getUrl();
                            }
                            MainPageRequest mainPageRequest4 = new MainPageRequest(section.getName(), liveData, request.getHorizontalImages());
                            request2 = request;
                            c00002.L$0 = request2;
                            c00002.L$1 = SpillingKt.nullOutSpilledVariable(section);
                            c00002.L$2 = SpillingKt.nullOutSpilledVariable(provider);
                            c00002.L$3 = SpillingKt.nullOutSpilledVariable(liveData);
                            c00002.I$0 = page4;
                            c00002.label = 2;
                            mainPage = provider.getMainPage(page4, mainPageRequest4, c00002);
                            if (mainPage == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            response = (HomePageResponse) mainPage;
                            if (response == null) {
                                return null;
                            }
                            obj = null;
                            Iterable $this$map$iv4 = response.getItems();
                            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                            while (r15.hasNext()) {
                                HomePageList list6 = (HomePageList) item$iv$iv;
                                String liveData5 = liveData;
                                page3 = page4;
                                destination$iv$iv.add(new HomePageList(request2.getName(), list6.getList(), list6.isHorizontalImages()));
                                liveData = liveData5;
                                page4 = page3;
                                response = response;
                            }
                            page3 = page4;
                            return MainAPIKt.newHomePageResponse((List) destination$iv$iv, Boxing.boxBoolean(response.getHasNext()));
                        }
                        ArrayList homeSections2 = new ArrayList();
                        try {
                            UltimaSettingsSyncUtils ultimaSettingsSyncUtils = UltimaSettingsSyncUtils.INSTANCE;
                            SyncCategory syncCategory = SyncCategory.RESUME_WATCHING;
                            c00002.L$0 = SpillingKt.nullOutSpilledVariable(request);
                            c00002.L$1 = homeSections2;
                            c00002.I$0 = page4;
                            c00002.label = 1;
                            objFetchCategory = ultimaSettingsSyncUtils.fetchCategory(syncCategory, c00002);
                            if (objFetchCategory == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            homeSections = homeSections2;
                            request3 = request;
                            try {
                                try {
                                    payload = (SyncCategoryPayload) objFetchCategory;
                                    if (payload != null || StringsKt.isBlank(payload.getData())) {
                                        page2 = page4;
                                    } else {
                                        try {
                                            ObjectMapper $this$readValue$iv = this.mapper;
                                            String content$iv = payload.getData();
                                            backupFile = (BackupFile) $this$readValue$iv.readValue(content$iv, new TypeReference<BackupFile>() { // from class: com.phisher98.Ultima$getMainPage$$inlined$readValue$1
                                            });
                                        } catch (Exception e2) {
                                            backupFile = null;
                                        }
                                        if (backupFile != null) {
                                            Map<String, String> string = backupFile.getDatastore().getString();
                                            if (string != null) {
                                                try {
                                                    Set<String> setKeySet = string.keySet();
                                                    if (setKeySet != null) {
                                                        Iterator<T> it5 = setKeySet.iterator();
                                                        while (true) {
                                                            if (it5.hasNext()) {
                                                                next3 = it5.next();
                                                                String it6 = (String) next3;
                                                                page2 = page4;
                                                                try {
                                                                    try {
                                                                        if (!StringsKt.contains$default(it6, "result_resume_watching", false, 2, (Object) null)) {
                                                                            page4 = page2;
                                                                        }
                                                                    } catch (Exception e3) {
                                                                        e = e3;
                                                                        try {
                                                                            Log.INSTANCE.e("getMainPage", "Error loading watch_sync: " + e.getMessage());
                                                                        } catch (Throwable th9) {
                                                                            e = th9;
                                                                            request2 = request3;
                                                                            obj = null;
                                                                        }
                                                                    }
                                                                } catch (Throwable th10) {
                                                                    e = th10;
                                                                    obj = null;
                                                                    request2 = request3;
                                                                }
                                                            } else {
                                                                page2 = page4;
                                                                next3 = null;
                                                            }
                                                        }
                                                        resumeWatchingKey = (String) next3;
                                                    } else {
                                                        page2 = page4;
                                                        resumeWatchingKey = null;
                                                    }
                                                    if (resumeWatchingKey != null) {
                                                        String it7 = resumeWatchingKey;
                                                        resumeWatchingJson = backupFile.getDatastore().getString().get(it7);
                                                    } else {
                                                        resumeWatchingJson = null;
                                                    }
                                                    if (resumeWatchingJson != null) {
                                                        String it8 = resumeWatchingJson;
                                                        try {
                                                            try {
                                                                ObjectMapper $this$readValue$iv2 = this.mapper;
                                                                list = (List) $this$readValue$iv2.readValue(it8, new TypeReference<List<? extends DataStoreHelper.ResumeWatchingResult>>() { // from class: com.phisher98.Ultima$getMainPage$lambda$2$$inlined$readValue$1
                                                                });
                                                            } catch (Throwable th11) {
                                                                e = th11;
                                                                request2 = request3;
                                                                obj = null;
                                                            }
                                                        } catch (Exception e4) {
                                                            list = null;
                                                        }
                                                    } else {
                                                        list = null;
                                                    }
                                                    resumeWatchingList = list;
                                                    list2 = resumeWatchingList;
                                                    if (list2 != null || list2.isEmpty()) {
                                                        z = true;
                                                    } else {
                                                        z = false;
                                                    }
                                                    if (!z) {
                                                        homeSections.add(new HomePageList("Continue from Cloud", resumeWatchingList, false, 4, (DefaultConstructorMarker) null));
                                                    }
                                                } catch (Throwable th12) {
                                                    e = th12;
                                                    obj = null;
                                                    request2 = request3;
                                                }
                                                break;
                                            } else {
                                                page2 = page4;
                                                resumeWatchingKey = null;
                                                if (resumeWatchingKey != null) {
                                                    String it9 = resumeWatchingKey;
                                                    resumeWatchingJson = backupFile.getDatastore().getString().get(it9);
                                                } else {
                                                    resumeWatchingJson = null;
                                                }
                                                if (resumeWatchingJson != null) {
                                                    String it10 = resumeWatchingJson;
                                                    ObjectMapper $this$readValue$iv3 = this.mapper;
                                                    list = (List) $this$readValue$iv3.readValue(it10, new TypeReference<List<? extends DataStoreHelper.ResumeWatchingResult>>() { // from class: com.phisher98.Ultima$getMainPage$lambda$2$$inlined$readValue$1
                                                    });
                                                } else {
                                                    list = null;
                                                }
                                                resumeWatchingList = list;
                                                list2 = resumeWatchingList;
                                                if (list2 != null) {
                                                    z = true;
                                                } else {
                                                    z = true;
                                                }
                                                if (!z) {
                                                    homeSections.add(new HomePageList("Continue from Cloud", resumeWatchingList, false, 4, (DefaultConstructorMarker) null));
                                                }
                                                break;
                                            }
                                            return MainAPIKt.newHomePageResponse(homeSections, Boxing.boxBoolean(false));
                                        }
                                        page2 = page4;
                                    }
                                    break;
                                } catch (Exception e5) {
                                    e = e5;
                                }
                                return MainAPIKt.newHomePageResponse(homeSections, Boxing.boxBoolean(false));
                            } catch (Throwable th13) {
                                e = th13;
                                request2 = request3;
                                obj = null;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            homeSections = homeSections2;
                            request3 = request;
                            Log.INSTANCE.e("getMainPage", "Error loading watch_sync: " + e.getMessage());
                            return MainAPIKt.newHomePageResponse(homeSections, Boxing.boxBoolean(false));
                        }
                    } catch (Throwable th14) {
                        e = th14;
                        request2 = request;
                        obj = null;
                    }
                } catch (Throwable th15) {
                    e = th15;
                    request2 = request;
                    obj = null;
                }
                Log.INSTANCE.e("getMainPage", "Error loading main page: " + e.getMessage());
                e.printStackTrace();
                return obj;
            case 1:
                page4 = c00002.I$0;
                homeSections = (ArrayList) c00002.L$1;
                request3 = (MainPageRequest) c00002.L$0;
                try {
                    try {
                        ResultKt.throwOnFailure($result);
                        objFetchCategory = $result;
                        payload = (SyncCategoryPayload) objFetchCategory;
                        if (payload != null) {
                            page2 = page4;
                        } else {
                            page2 = page4;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        Log.INSTANCE.e("getMainPage", "Error loading watch_sync: " + e.getMessage());
                        return MainAPIKt.newHomePageResponse(homeSections, Boxing.boxBoolean(false));
                    }
                    return MainAPIKt.newHomePageResponse(homeSections, Boxing.boxBoolean(false));
                } catch (Throwable th16) {
                    e = th16;
                    obj = null;
                    request2 = request3;
                }
                break;
            case 2:
                page4 = c00002.I$0;
                liveData = (String) c00002.L$3;
                request2 = (MainPageRequest) c00002.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    mainPage = $result;
                    response = (HomePageResponse) mainPage;
                    if (response == null) {
                        return null;
                    }
                    obj = null;
                    Iterable $this$map$iv5 = response.getItems();
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
                    while (r15.hasNext()) {
                        HomePageList list7 = (HomePageList) item$iv$iv;
                        String liveData6 = liveData;
                        page3 = page4;
                        destination$iv$iv.add(new HomePageList(request2.getName(), list7.getList(), list7.isHorizontalImages()));
                        liveData = liveData6;
                        page4 = page3;
                        response = response;
                    }
                    page3 = page4;
                    return MainAPIKt.newHomePageResponse((List) destination$iv$iv, Boxing.boxBoolean(response.getHasNext()));
                } catch (Throwable th17) {
                    e = th17;
                    obj = null;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0157  */
    /* JADX WARN: Code duplicated, block: B:49:0x015a  */
    /* JADX WARN: Code duplicated, block: B:51:0x0169  */
    /* JADX WARN: Code duplicated, block: B:70:0x016d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) {
        C00021 c00021;
        Object objRunLimitedParallel;
        Object next;
        MainAPI provider;
        Collection destination$iv$iv;
        Ultima$search$tasks$1$1 ultima$search$tasks$1$1;
        MainAPI it;
        Iterable iterableEmptyList;
        Ultima ultima = this;
        if (continuation instanceof C00021) {
            c00021 = (C00021) continuation;
            if ((c00021.label & Integer.MIN_VALUE) != 0) {
                c00021.label -= Integer.MIN_VALUE;
            } else {
                c00021 = ultima.new C00021(continuation);
            }
        } else {
            c00021 = ultima.new C00021(continuation);
        }
        C00021 c00022 = c00021;
        Object $result = c00022.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00022.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                UltimaUtils.ExtensionInfo[] currentExtensions = ultima.sm.getCurrentExtensions();
                Collection destination$iv$iv2 = new ArrayList();
                for (UltimaUtils.ExtensionInfo extensionInfo : currentExtensions) {
                    UltimaUtils.SectionInfo[] sections = extensionInfo.getSections();
                    if (sections == null || (iterableEmptyList = ArraysKt.asList(sections)) == null) {
                        iterableEmptyList = CollectionsKt.emptyList();
                    }
                    Iterable list$iv$iv = iterableEmptyList;
                    CollectionsKt.addAll(destination$iv$iv2, list$iv$iv);
                }
                Iterable $this$filter$iv = (List) destination$iv$iv2;
                Collection destination$iv$iv3 = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    UltimaUtils.SectionInfo it2 = (UltimaUtils.SectionInfo) element$iv$iv;
                    if (it2.getEnabled()) {
                        destination$iv$iv3.add(element$iv$iv);
                    }
                }
                Iterable $this$map$iv = (List) destination$iv$iv3;
                Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    UltimaUtils.SectionInfo it3 = (UltimaUtils.SectionInfo) item$iv$iv;
                    destination$iv$iv4.add(it3.getPluginName());
                }
                List enabledPluginNames = CollectionsKt.distinct((List) destination$iv$iv4);
                if (enabledPluginNames.isEmpty()) {
                    return MainAPIKt.toNewSearchResponseList$default(CollectionsKt.emptyList(), (Boolean) null, 1, (Object) null);
                }
                List<MainAPI> allProviders = UltimaUtils.INSTANCE.getAllProviders();
                List $this$mapNotNull$iv = enabledPluginNames;
                Collection destination$iv$iv5 = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    String pluginName = (String) element$iv$iv$iv;
                    Iterator<T> it4 = allProviders.iterator();
                    do {
                        if (it4.hasNext()) {
                            next = it4.next();
                            it = (MainAPI) next;
                        } else {
                            next = null;
                        }
                        provider = (MainAPI) next;
                        if (provider == null) {
                            destination$iv$iv = destination$iv$iv5;
                            ultima$search$tasks$1$1 = null;
                        } else {
                            destination$iv$iv = destination$iv$iv5;
                            ultima$search$tasks$1$1 = new Ultima$search$tasks$1$1(provider, query, pluginName, ultima, null);
                        }
                        if (ultima$search$tasks$1$1 != null) {
                            destination$iv$iv.add(ultima$search$tasks$1$1);
                        }
                        ultima = this;
                        destination$iv$iv5 = destination$iv$iv;
                    } while (!Intrinsics.areEqual(it.getName(), pluginName));
                    provider = (MainAPI) next;
                    if (provider == null) {
                        destination$iv$iv = destination$iv$iv5;
                        ultima$search$tasks$1$1 = null;
                    } else {
                        destination$iv$iv = destination$iv$iv5;
                        ultima$search$tasks$1$1 = new Ultima$search$tasks$1$1(provider, query, pluginName, ultima, null);
                    }
                    if (ultima$search$tasks$1$1 != null) {
                        destination$iv$iv.add(ultima$search$tasks$1$1);
                    }
                    ultima = this;
                    destination$iv$iv5 = destination$iv$iv;
                }
                List tasks = (List) destination$iv$iv5;
                c00022.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00022.L$1 = SpillingKt.nullOutSpilledVariable(enabledPluginNames);
                c00022.L$2 = SpillingKt.nullOutSpilledVariable(allProviders);
                c00022.L$3 = SpillingKt.nullOutSpilledVariable(tasks);
                c00022.I$0 = page;
                c00022.label = 1;
                objRunLimitedParallel = UltimaUtilsKt.runLimitedParallel(4, tasks, c00022);
                if (objRunLimitedParallel == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                int i = c00022.I$0;
                ResultKt.throwOnFailure($result);
                objRunLimitedParallel = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return MainAPIKt.toNewSearchResponseList$default(CollectionsKt.flatten((Iterable) objRunLimitedParallel), (Boolean) null, 1, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:137:0x019c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x0198  */
    /* JADX WARN: Code duplicated, block: B:79:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:84:0x0219 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:85:0x021a  */
    /* JADX WARN: Code duplicated, block: B:88:0x0221 A[Catch: all -> 0x0245, TryCatch #4 {all -> 0x0245, blocks: (B:86:0x021d, B:88:0x0221, B:90:0x022d, B:92:0x0235), top: B:116:0x021d }] */
    /* JADX WARN: Code duplicated, block: B:92:0x0235 A[Catch: all -> 0x0245, TRY_LEAVE, TryCatch #4 {all -> 0x0245, blocks: (B:86:0x021d, B:88:0x0221, B:90:0x022d, B:92:0x0235), top: B:116:0x021d }] */
    /* JADX WARN: Code duplicated, block: B:96:0x023e  */
    /* JADX WARN: Code duplicated, block: B:98:0x0241 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x024d -> B:77:0x01f0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x021a -> B:116:0x021d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r28, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r29) {
        /*
            Method dump skipped, instruction units count: 686
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.Ultima.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
