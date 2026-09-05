package com.Aniworld;

import android.content.SharedPreferences;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Aniworld.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Aniworld/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0003<=>B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010#J\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010(J\u0018\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010(JF\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00102\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000202002\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020200H\u0096@¢\u0006\u0002\u00105J\f\u00106\u001a\u0004\u0018\u000107*\u000208J\u0016\u00109\u001a\u0004\u0018\u00010\u0007*\u00020\u00072\u0006\u0010:\u001a\u00020;H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\tR\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006?"}, d2 = {"Lcom/Aniworld/Aniworld;", "Lcom/lagradost/cloudstream3/MainAPI;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "token", "getToken", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/AnimeSearchResponse;", "Lorg/jsoup/nodes/Element;", "getLanguage", "document", "Lorg/jsoup/nodes/Document;", "AnimeSearch", "SerienstreamSearch", "Show", "Aniworld"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAniworld.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Aniworld.kt\ncom/Aniworld/Aniworld\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,338:1\n1739#2:339\n1814#2,2:340\n1795#2,10:342\n2068#2:352\n2069#2:354\n1805#2:355\n1816#2:356\n1739#2:362\n1814#2,3:363\n777#2:389\n873#2,2:390\n1739#2:392\n1814#2,3:393\n1739#2:397\n1814#2,3:398\n296#2,2:401\n1739#2:403\n1814#2,3:404\n1739#2:407\n1814#2,3:408\n2068#2:411\n2068#2,2:412\n2069#2:414\n1795#2,10:415\n2068#2:425\n2069#2:427\n1805#2:428\n777#2:429\n873#2,2:430\n1#3:353\n1#3:369\n1#3:396\n1#3:426\n1#3:432\n73#4,5:357\n93#5,2:366\n63#5:368\n64#5,15:370\n95#5,2:387\n50#6:385\n43#6:386\n*S KotlinDebug\n*F\n+ 1 Aniworld.kt\ncom/Aniworld/Aniworld\n*L\n67#1:339\n67#1:340,2\n69#1:342,10\n69#1:352\n69#1:354\n69#1:355\n67#1:356\n86#1:362\n86#1:363,3\n107#1:389\n107#1:390,2\n111#1:392\n111#1:393,3\n154#1:397\n154#1:398,3\n155#1:401,2\n163#1:403\n163#1:404,3\n166#1:407\n166#1:408,3\n169#1:411\n174#1:412,2\n169#1:414\n227#1:415,10\n227#1:425\n227#1:427\n227#1:428\n252#1:429\n252#1:430,2\n69#1:353\n107#1:369\n227#1:426\n84#1:357,5\n107#1:366,2\n107#1:368\n107#1:370,15\n107#1:387,2\n107#1:385\n107#1:386\n*E\n"})
public class Aniworld extends MainAPI {
    private final boolean hasMainPage;

    @NotNull
    private String lang;

    @NotNull
    private String mainUrl;

    @NotNull
    private String name;

    @NotNull
    private final Set<TvType> supportedTypes;

    @Nullable
    private final String token;

    /* JADX INFO: renamed from: com.Aniworld.Aniworld$getMainPage$1 */
    /* JADX INFO: compiled from: Aniworld.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Aniworld.Aniworld", f = "Aniworld.kt", i = {0, 0, 0, 0, 0}, l = {64}, m = "getMainPage$suspendImpl", n = {"$this", "request", "requesturl", "page", "isTvSeries"}, nl = {66}, s = {"L$0", "L$1", "L$2", "I$0", "Z$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Aniworld.getMainPage$suspendImpl(Aniworld.this, 0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Aniworld.Aniworld$load$1 */
    /* JADX INFO: compiled from: Aniworld.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Aniworld.Aniworld", f = "Aniworld.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {125, 137, 172, 200}, m = "load$suspendImpl", n = {"$this", "url", "$this", "url", "document", "imdbid", "$this$load_u24lambda_u240", "isTvSeries", "$this", "url", "document", "imdbid", "jsonObject", "mappings", "malidId", "anilistid", "title", "imdbBGPoster", "poster", "tags", "year", "description", "actor", "episodes", "$this$forEach$iv", "element$iv", "ele", "pageLink", "isTvSeries", "seasonno", "$this", "url", "document", "imdbid", "jsonObject", "mappings", "malidId", "anilistid", "title", "imdbBGPoster", "poster", "tags", "year", "description", "actor", "episodes", "isTvSeries"}, nl = {126, 136, 174, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$18", "L$19", "L$20", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "Z$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Aniworld.load$suspendImpl(Aniworld.this, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Aniworld.Aniworld$loadLinks$1 */
    /* JADX INFO: compiled from: Aniworld.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Aniworld.Aniworld", f = "Aniworld.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {224, 253}, m = "loadLinks$suspendImpl", n = {"$this", "data", "subtitleCallback", "callback", "isCasting", "$this", "data", "subtitleCallback", "callback", "document", "isCasting"}, nl = {253, 267}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Aniworld.loadLinks$suspendImpl(Aniworld.this, null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Aniworld.Aniworld$search$1 */
    /* JADX INFO: compiled from: Aniworld.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Aniworld.Aniworld", f = "Aniworld.kt", i = {0, 0, 0, 1, 1, 1}, l = {83, 99}, m = "search$suspendImpl", n = {"$this", "query", "isTvSeries", "$this", "query", "isTvSeries"}, nl = {84, 107}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Aniworld.search$suspendImpl(Aniworld.this, null, (Continuation) this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Aniworld() {
        SharedPreferences sharedPreferences = null;
        this(sharedPreferences, 1, sharedPreferences);
    }

    @Nullable
    public Object getMainPage(int i, @NotNull MainPageRequest mainPageRequest, @NotNull Continuation<? super HomePageResponse> continuation) {
        return getMainPage$suspendImpl(this, i, mainPageRequest, continuation);
    }

    @Nullable
    public Object load(@NotNull String str, @NotNull Continuation<? super LoadResponse> continuation) {
        return load$suspendImpl(this, str, continuation);
    }

    @Nullable
    public Object loadLinks(@NotNull String str, boolean z, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        return loadLinks$suspendImpl(this, str, z, function1, function2, continuation);
    }

    @Nullable
    public Object search(@NotNull String str, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        return search$suspendImpl(this, str, continuation);
    }

    public Aniworld(@Nullable SharedPreferences sharedPref) {
        this.mainUrl = "https://aniworld.to";
        this.name = "Aniworld";
        this.hasMainPage = true;
        this.lang = "de";
        this.token = sharedPref != null ? sharedPref.getString("serienstream_token", null) : null;
        this.supportedTypes = SetsKt.setOf(new TvType[]{TvType.Anime, TvType.AnimeMovie, TvType.OVA});
    }

    public /* synthetic */ Aniworld(SharedPreferences sharedPreferences, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : sharedPreferences);
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    @Nullable
    public String getToken() {
        return this.token;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getMainPage$suspendImpl(Aniworld $this, int page, MainPageRequest request, Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        Document document;
        Aniworld $this2 = $this;
        if (continuation instanceof C00001) {
            c00001 = (C00001) continuation;
            if ((c00001.label & Integer.MIN_VALUE) != 0) {
                c00001.label -= Integer.MIN_VALUE;
            } else {
                c00001 = $this2.new C00001(continuation);
            }
        } else {
            c00001 = $this2.new C00001(continuation);
        }
        Object $result = c00001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00001.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                boolean isTvSeries = StringsKt.equals($this2.getName(), "Serienstream", true);
                String requesturl = isTvSeries ? $this2.getMainUrl() + "/beliebte-serien" : $this2.getMainUrl();
                Requests app = MainActivityKt.getApp();
                c00001.L$0 = $this2;
                c00001.L$1 = SpillingKt.nullOutSpilledVariable(request);
                c00001.L$2 = SpillingKt.nullOutSpilledVariable(requesturl);
                c00001.I$0 = page;
                c00001.Z$0 = isTvSeries;
                c00001.label = 1;
                $result = Requests.get$default(app, requesturl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                boolean z = c00001.Z$0;
                int i = c00001.I$0;
                $this2 = (Aniworld) c00001.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document2 = ((NiceResponse) $result).getDocument();
        ArrayList item = new ArrayList();
        Iterable $this$map$iv = document2.select("div.carousel,div.mb-5");
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Element ele = (Element) item$iv$iv;
            Element elementSelectFirst = ele.selectFirst("h2,h3");
            if (elementSelectFirst != null) {
                String header = elementSelectFirst.text();
                if (header == null) {
                    document = document2;
                } else {
                    Iterable $this$mapNotNull$iv = ele.select("div.coverListItem,div.col-6");
                    Collection destination$iv$iv2 = new ArrayList();
                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                        Document document3 = document2;
                        Element it = (Element) element$iv$iv$iv;
                        AnimeSearchResponse searchResult = $this2.toSearchResult(it);
                        if (searchResult != null) {
                            destination$iv$iv2.add(searchResult);
                        }
                        document2 = document3;
                    }
                    document = document2;
                    List home = (List) destination$iv$iv2;
                    if (!home.isEmpty()) {
                        item.add(new HomePageList(header, home, false, 4, (DefaultConstructorMarker) null));
                    }
                }
            } else {
                document = document2;
            }
            destination$iv$iv.add(Unit.INSTANCE);
            document2 = document;
        }
        return MainAPIKt.newHomePageResponse$default(item, (Boolean) null, 2, (Object) null);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:100:0x0388  */
    /* JADX WARN: Code duplicated, block: B:103:0x0398  */
    /* JADX WARN: Code duplicated, block: B:104:0x039b  */
    /* JADX WARN: Code duplicated, block: B:109:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:117:0x028c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x02c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:125:0x034a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x024b  */
    /* JADX WARN: Code duplicated, block: B:43:0x0250  */
    /* JADX WARN: Code duplicated, block: B:50:0x0289  */
    /* JADX WARN: Code duplicated, block: B:62:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:72:0x02db A[Catch: Exception -> 0x02f2, TRY_LEAVE, TryCatch #7 {Exception -> 0x02f2, blocks: (B:60:0x02b9, B:63:0x02c0, B:72:0x02db, B:71:0x02d5, B:59:0x02af, B:66:0x02c6), top: B:120:0x02af, inners: #8 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:83:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:86:0x0314  */
    /* JADX WARN: Code duplicated, block: B:88:0x0333  */
    /* JADX WARN: Code duplicated, block: B:93:0x0347  */
    /* JADX WARN: Code duplicated, block: B:98:0x0376  */
    static /* synthetic */ Object search$suspendImpl(Aniworld $this, String query, Continuation<? super List<? extends SearchResponse>> continuation) throws ErrorLoadingException {
        C00051 c00051;
        String str;
        Aniworld $this2;
        Object obj;
        Object $result;
        String query2;
        String str2;
        int i;
        Aniworld $this3;
        Object obj2;
        Object safe;
        SerienstreamSearch serienstreamSearch;
        Iterable shows;
        String value$iv;
        Aniworld $this4;
        Object obj3;
        Object obj4;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        Iterable iterable;
        int $i$f$filter;
        Collection destination$iv$iv;
        Collection destination$iv$iv2;
        String title;
        String str3;
        String str4;
        String strReplace;
        AnimeSearch it;
        boolean z;
        if (continuation instanceof C00051) {
            c00051 = (C00051) continuation;
            if ((c00051.label & Integer.MIN_VALUE) != 0) {
                c00051.label -= Integer.MIN_VALUE;
            } else {
                c00051 = $this.new C00051(continuation);
            }
        } else {
            c00051 = $this.new C00051(continuation);
        }
        Object $result2 = c00051.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00051.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                boolean isTvSeries = StringsKt.equals($this.getName(), "Serienstream", true);
                if (isTvSeries) {
                    c00051.L$0 = $this;
                    c00051.L$1 = SpillingKt.nullOutSpilledVariable(query);
                    c00051.Z$0 = isTvSeries;
                    c00051.label = 1;
                    query2 = "</?em>";
                    str2 = "";
                    C00051 c00052 = c00051;
                    i = 10;
                    Object obj5 = Requests.get$default(MainActivityKt.getApp(), "https://serienstream.to/suche?term=" + query, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00052, 4094, (Object) null);
                    if (obj5 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $this3 = $this;
                    obj2 = obj5;
                    NiceResponse this_$iv = (NiceResponse) obj2;
                    try {
                        ResponseParser parser = this_$iv.getParser();
                        Intrinsics.checkNotNull(parser);
                        safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(SerienstreamSearch.class));
                        break;
                    } catch (Exception e$iv) {
                        e$iv.printStackTrace();
                        safe = null;
                    }
                    serienstreamSearch = (SerienstreamSearch) safe;
                    if (serienstreamSearch != null || (shows = serienstreamSearch.getShows()) == null) {
                        return CollectionsKt.emptyList();
                    }
                    Iterable $this$map$iv = shows;
                    Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, i));
                    int $i$f$mapTo = 0;
                    for (Object item$iv$iv : $this$map$iv) {
                        Show it2 = (Show) item$iv$iv;
                        destination$iv$iv3.add(MainAPIKt.newAnimeSearchResponse$default($this3, new Regex(query2).replace(it2.getName(), str2), MainAPIKt.fixUrl($this3, it2.getUrl()), TvType.TvSeries, false, new Function1() { // from class: com.Aniworld.Aniworld$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj6) {
                                return Aniworld.search$lambda$0$0((AnimeSearchResponse) obj6);
                            }
                        }, 8, (Object) null));
                        $this$map$iv = $this$map$iv;
                        $i$f$mapTo = $i$f$mapTo;
                    }
                    return (List) destination$iv$iv3;
                }
                C00051 c00053 = c00051;
                Requests app = MainActivityKt.getApp();
                String str5 = $this.getMainUrl() + "/ajax/search";
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("keyword", query));
                String str6 = $this.getMainUrl() + "/search";
                Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to("x-requested-with", "XMLHttpRequest"));
                c00053.L$0 = $this;
                c00053.L$1 = SpillingKt.nullOutSpilledVariable(query);
                c00053.Z$0 = isTvSeries;
                c00053.label = 2;
                str = "";
                Object objPost$default = Requests.post$default(app, str5, mapMapOf2, str6, (Map) null, (Map) null, mapMapOf, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00053, 65496, (Object) null);
                if (objPost$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this2 = $this;
                obj = objPost$default;
                $result = query;
                NiceResponse json = (NiceResponse) obj;
                AppUtils appUtils = AppUtils.INSTANCE;
                value$iv = json.getText();
                if (value$iv == null) {
                    try {
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(AnimeSearch.class)));
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj3) != null) {
                            $this4 = $this2;
                        } else {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                $this4 = $this2;
                                try {
                                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                                    break;
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        Result.Companion companion4 = Result.Companion;
                                        obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                                    } catch (Exception e) {
                                        obj4 = null;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                $this4 = $this2;
                            }
                        }
                        if (Result.isFailure-impl(obj3)) {
                            obj3 = null;
                        }
                        deserializationStrategy = (KSerializer) obj3;
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                            } catch (SerializationException e2) {
                                ArchComponentExtKt.logError(e2);
                                ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv.readValue(value$iv, new TypeReference<List<? extends AnimeSearch>>() { // from class: com.Aniworld.Aniworld$search$suspendImpl$$inlined$tryParseJson$1
                                });
                            } catch (Throwable th4) {
                                ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(value$iv, new TypeReference<List<? extends AnimeSearch>>() { // from class: com.Aniworld.Aniworld$search$suspendImpl$$inlined$tryParseJson$1
                                });
                            }
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(value$iv, new TypeReference<List<? extends AnimeSearch>>() { // from class: com.Aniworld.Aniworld$search$suspendImpl$$inlined$tryParseJson$1
                            });
                        }
                        obj4 = objDecodeFromString;
                    } catch (Exception e3) {
                        $this4 = $this2;
                        obj4 = null;
                        iterable = (List) obj4;
                        if (iterable == null) {
                            throw new ErrorLoadingException((String) null, 1, (DefaultConstructorMarker) null);
                        }
                        Iterable $this$filter$iv = iterable;
                        $i$f$filter = 0;
                        destination$iv$iv = new ArrayList();
                        for (Object element$iv$iv : $this$filter$iv) {
                            it = (AnimeSearch) element$iv$iv;
                            z = false;
                            int $i$f$filter2 = $i$f$filter;
                            Object query3 = $result;
                            if (!StringsKt.contains$default(it.getLink(), "episode-", false, 2, (Object) null)) {
                                z = true;
                            }
                            if (z) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                            $i$f$filter = $i$f$filter2;
                            $result = query3;
                        }
                        Iterable $this$map$iv2 = (List) destination$iv$iv;
                        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                        for (Object item$iv$iv2 : $this$map$iv2) {
                            AnimeSearch it3 = (AnimeSearch) item$iv$iv2;
                            Aniworld aniworld = $this4;
                            title = it3.getTitle();
                            if (title != null) {
                                str3 = str;
                                strReplace = new Regex("</?em>").replace(title, str3);
                                if (strReplace != null) {
                                    str4 = strReplace;
                                }
                                destination$iv$iv2.add(MainAPIKt.newAnimeSearchResponse$default(aniworld, str4, MainAPIKt.fixUrl($this4, it3.getLink()), TvType.Anime, false, new Function1() { // from class: com.Aniworld.Aniworld$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj6) {
                                        return Aniworld.search$lambda$2$0((AnimeSearchResponse) obj6);
                                    }
                                }, 8, (Object) null));
                                str = str3;
                            } else {
                                str3 = str;
                            }
                            str4 = str3;
                            destination$iv$iv2.add(MainAPIKt.newAnimeSearchResponse$default(aniworld, str4, MainAPIKt.fixUrl($this4, it3.getLink()), TvType.Anime, false, new Function1() { // from class: com.Aniworld.Aniworld$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj6) {
                                    return Aniworld.search$lambda$2$0((AnimeSearchResponse) obj6);
                                }
                            }, 8, (Object) null));
                            str = str3;
                        }
                        return (List) destination$iv$iv2;
                    }
                    break;
                } else {
                    $this4 = $this2;
                    obj4 = null;
                }
                iterable = (List) obj4;
                if (iterable == null) {
                    throw new ErrorLoadingException((String) null, 1, (DefaultConstructorMarker) null);
                }
                Iterable $this$filter$iv2 = iterable;
                $i$f$filter = 0;
                destination$iv$iv = new ArrayList();
                while (r9.hasNext()) {
                    it = (AnimeSearch) element$iv$iv;
                    z = false;
                    int $i$f$filter3 = $i$f$filter;
                    Object query4 = $result;
                    if (!StringsKt.contains$default(it.getLink(), "episode-", false, 2, (Object) null) && StringsKt.contains$default(it.getLink(), "/stream", false, 2, (Object) null)) {
                        z = true;
                    }
                    if (z) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    $i$f$filter = $i$f$filter3;
                    $result = query4;
                }
                Iterable $this$map$iv3 = (List) destination$iv$iv;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                while (r8.hasNext()) {
                    AnimeSearch it4 = (AnimeSearch) item$iv$iv2;
                    Aniworld aniworld2 = $this4;
                    title = it4.getTitle();
                    if (title != null) {
                        str3 = str;
                        strReplace = new Regex("</?em>").replace(title, str3);
                        if (strReplace != null) {
                            str4 = strReplace;
                        }
                        destination$iv$iv2.add(MainAPIKt.newAnimeSearchResponse$default(aniworld2, str4, MainAPIKt.fixUrl($this4, it4.getLink()), TvType.Anime, false, new Function1() { // from class: com.Aniworld.Aniworld$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj6) {
                                return Aniworld.search$lambda$2$0((AnimeSearchResponse) obj6);
                            }
                        }, 8, (Object) null));
                        str = str3;
                    } else {
                        str3 = str;
                    }
                    str4 = str3;
                    destination$iv$iv2.add(MainAPIKt.newAnimeSearchResponse$default(aniworld2, str4, MainAPIKt.fixUrl($this4, it4.getLink()), TvType.Anime, false, new Function1() { // from class: com.Aniworld.Aniworld$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj6) {
                            return Aniworld.search$lambda$2$0((AnimeSearchResponse) obj6);
                        }
                    }, 8, (Object) null));
                    str = str3;
                }
                return (List) destination$iv$iv2;
            case 1:
                boolean isTvSeries2 = c00051.Z$0;
                Aniworld $this5 = (Aniworld) c00051.L$0;
                ResultKt.throwOnFailure($result2);
                $this3 = $this5;
                obj2 = $result2;
                str2 = "";
                query2 = "</?em>";
                i = 10;
                NiceResponse this_$iv2 = (NiceResponse) obj2;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(SerienstreamSearch.class));
                serienstreamSearch = (SerienstreamSearch) safe;
                if (serienstreamSearch != null) {
                    break;
                }
                return CollectionsKt.emptyList();
            case 2:
                boolean z2 = c00051.Z$0;
                Object query5 = (String) c00051.L$1;
                Aniworld $this6 = (Aniworld) c00051.L$0;
                ResultKt.throwOnFailure($result2);
                $this2 = $this6;
                obj = $result2;
                str = "";
                $result = query5;
                NiceResponse json2 = (NiceResponse) obj;
                AppUtils appUtils2 = AppUtils.INSTANCE;
                value$iv = json2.getText();
                if (value$iv == null) {
                    Result.Companion companion5 = Result.Companion;
                    KType kTypeTypeOf2 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(AnimeSearch.class)));
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                    if (Result.exceptionOrNull-impl(obj3) != null) {
                        Result.Companion companion6 = Result.Companion;
                        $this4 = $this2;
                        obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                    } else {
                        $this4 = $this2;
                    }
                    if (Result.isFailure-impl(obj3)) {
                        obj3 = null;
                    }
                    deserializationStrategy = (KSerializer) obj3;
                    if (deserializationStrategy != null) {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                    } else {
                        ObjectMapper $this$readValue$iv$iv$iv4 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv$iv4.readValue(value$iv, new TypeReference<List<? extends AnimeSearch>>() { // from class: com.Aniworld.Aniworld$search$suspendImpl$$inlined$tryParseJson$1
                        });
                    }
                    obj4 = objDecodeFromString;
                    break;
                } else {
                    $this4 = $this2;
                    obj4 = null;
                }
                iterable = (List) obj4;
                if (iterable == null) {
                    throw new ErrorLoadingException((String) null, 1, (DefaultConstructorMarker) null);
                }
                Iterable $this$filter$iv3 = iterable;
                $i$f$filter = 0;
                destination$iv$iv = new ArrayList();
                while (r9.hasNext()) {
                    it = (AnimeSearch) element$iv$iv;
                    z = false;
                    int $i$f$filter4 = $i$f$filter;
                    Object query6 = $result;
                    if (!StringsKt.contains$default(it.getLink(), "episode-", false, 2, (Object) null)) {
                        z = true;
                    }
                    if (z) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    $i$f$filter = $i$f$filter4;
                    $result = query6;
                }
                Iterable $this$map$iv4 = (List) destination$iv$iv;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                while (r8.hasNext()) {
                    AnimeSearch it5 = (AnimeSearch) item$iv$iv2;
                    Aniworld aniworld3 = $this4;
                    title = it5.getTitle();
                    if (title != null) {
                        str3 = str;
                        strReplace = new Regex("</?em>").replace(title, str3);
                        if (strReplace != null) {
                            str4 = strReplace;
                        }
                        destination$iv$iv2.add(MainAPIKt.newAnimeSearchResponse$default(aniworld3, str4, MainAPIKt.fixUrl($this4, it5.getLink()), TvType.Anime, false, new Function1() { // from class: com.Aniworld.Aniworld$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj6) {
                                return Aniworld.search$lambda$2$0((AnimeSearchResponse) obj6);
                            }
                        }, 8, (Object) null));
                        str = str3;
                    } else {
                        str3 = str;
                    }
                    str4 = str3;
                    destination$iv$iv2.add(MainAPIKt.newAnimeSearchResponse$default(aniworld3, str4, MainAPIKt.fixUrl($this4, it5.getLink()), TvType.Anime, false, new Function1() { // from class: com.Aniworld.Aniworld$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj6) {
                            return Aniworld.search$lambda$2$0((AnimeSearchResponse) obj6);
                        }
                    }, 8, (Object) null));
                    str = str3;
                }
                return (List) destination$iv$iv2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$0(AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl("https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/Icons/aniworld.jpg");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$2$0(AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl("https://raw.githubusercontent.com/phisher98/TVVVV/refs/heads/main/Icons/aniworld.jpg");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:145:0x04a1  */
    /* JADX WARN: Code duplicated, block: B:147:0x04a7  */
    /* JADX WARN: Code duplicated, block: B:148:0x04ae  */
    /* JADX WARN: Code duplicated, block: B:166:0x0597  */
    /* JADX WARN: Code duplicated, block: B:168:0x05ad  */
    /* JADX WARN: Code duplicated, block: B:170:0x05b7  */
    /* JADX WARN: Code duplicated, block: B:171:0x05ca  */
    /* JADX WARN: Code duplicated, block: B:173:0x05e7  */
    /* JADX WARN: Code duplicated, block: B:176:0x05f6  */
    /* JADX WARN: Code duplicated, block: B:179:0x0684 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:180:0x0685  */
    /* JADX WARN: Code duplicated, block: B:184:0x06d6  */
    /* JADX WARN: Code duplicated, block: B:186:0x06f8 A[PHI: r2
      0x06f8: PHI (r2v62 java.lang.Integer) = (r2v48 java.lang.Integer), (r2v51 java.lang.Integer), (r2v55 java.lang.Integer) binds: [B:185:0x06f6, B:188:0x0707, B:198:0x072d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:187:0x06fd  */
    /* JADX WARN: Code duplicated, block: B:192:0x0714  */
    /* JADX WARN: Code duplicated, block: B:197:0x072c  */
    /* JADX WARN: Code duplicated, block: B:202:0x0738  */
    /* JADX WARN: Code duplicated, block: B:206:0x0742  */
    /* JADX WARN: Code duplicated, block: B:208:0x074d  */
    /* JADX WARN: Code duplicated, block: B:217:0x0785  */
    /* JADX WARN: Code duplicated, block: B:220:0x0797  */
    /* JADX WARN: Code duplicated, block: B:221:0x07a0  */
    /* JADX WARN: Code duplicated, block: B:224:0x07ad  */
    /* JADX WARN: Code duplicated, block: B:227:0x07d4  */
    /* JADX WARN: Code duplicated, block: B:229:0x07d9  */
    /* JADX WARN: Code duplicated, block: B:230:0x07e3  */
    /* JADX WARN: Code duplicated, block: B:231:0x07e5  */
    /* JADX WARN: Code duplicated, block: B:233:0x0829  */
    /* JADX WARN: Code duplicated, block: B:236:0x0868  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x0348  */
    /* JADX WARN: Code duplicated, block: B:85:0x0364  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:180:0x0685 -> B:181:0x06a2). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    static /* synthetic */ java.lang.Object load$suspendImpl(com.Aniworld.Aniworld r52, java.lang.String r53, kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r54) {
        /*
            Method dump skipped, instruction units count: 2446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.Aniworld.Aniworld.load$suspendImpl(com.Aniworld.Aniworld, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$9$0$2(String $epname, int $seasonno, int $epno, String $epposter, Episode $this$newEpisode) {
        $this$newEpisode.setName($epname);
        $this$newEpisode.setSeason(Integer.valueOf($seasonno));
        $this$newEpisode.setEpisode(Integer.valueOf($epno));
        $this$newEpisode.setPosterUrl($epposter);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.Aniworld.Aniworld$load$3 */
    /* JADX INFO: compiled from: Aniworld.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Aniworld.Aniworld$load$3", f = "Aniworld.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00023 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $actor;
        final /* synthetic */ Integer $anilistid;
        final /* synthetic */ String $description;
        final /* synthetic */ List<Episode> $episodes;
        final /* synthetic */ String $imdbBGPoster;
        final /* synthetic */ String $imdbid;
        final /* synthetic */ boolean $isTvSeries;
        final /* synthetic */ Integer $malidId;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ String $title;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00023(String str, String str2, String str3, Integer num, List<Episode> list, List<String> list2, boolean z, Integer num2, Integer num3, String str4, String str5, List<String> list3, Continuation<? super C00023> continuation) {
            super(2, continuation);
            this.$title = str;
            this.$poster = str2;
            this.$imdbBGPoster = str3;
            this.$year = num;
            this.$episodes = list;
            this.$actor = list2;
            this.$isTvSeries = z;
            this.$malidId = num2;
            this.$anilistid = num3;
            this.$imdbid = str4;
            this.$description = str5;
            this.$tags = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00023 = new C00023(this.$title, this.$poster, this.$imdbBGPoster, this.$year, this.$episodes, this.$actor, this.$isTvSeries, this.$malidId, this.$anilistid, this.$imdbid, this.$description, this.$tags, continuation);
            c00023.L$0 = obj;
            return c00023;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (AnimeLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setEngName(this.$title);
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setBackgroundPosterUrl(this.$imdbBGPoster);
                    loadResponse.setYear(this.$year);
                    MainAPIKt.addEpisodes(loadResponse, DubStatus.Subbed, this.$episodes);
                    LoadResponse.Companion.addActorNames(loadResponse, this.$actor);
                    if (!this.$isTvSeries) {
                        LoadResponse.Companion.addMalId(loadResponse, this.$malidId);
                        LoadResponse.Companion.addAniListId(loadResponse, this.$anilistid);
                    }
                    LoadResponse.Companion.addImdbId(loadResponse, this.$imdbid);
                    loadResponse.setPlot(this.$description);
                    loadResponse.setTags(this.$tags);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x010a  */
    /* JADX WARN: Code duplicated, block: B:23:0x0129  */
    /* JADX WARN: Code duplicated, block: B:24:0x0133  */
    /* JADX WARN: Code duplicated, block: B:26:0x013d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0151  */
    /* JADX WARN: Code duplicated, block: B:31:0x0155  */
    /* JADX WARN: Code duplicated, block: B:32:0x015d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0172  */
    /* JADX WARN: Code duplicated, block: B:37:0x0176  */
    /* JADX WARN: Code duplicated, block: B:38:0x017e  */
    /* JADX WARN: Code duplicated, block: B:45:0x019b  */
    /* JADX WARN: Code duplicated, block: B:47:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:48:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:51:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:54:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:57:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:60:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:63:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:65:0x020a  */
    /* JADX WARN: Code duplicated, block: B:72:0x0226  */
    /* JADX WARN: Code duplicated, block: B:78:0x0240  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:83:0x027a  */
    /* JADX WARN: Code duplicated, block: B:88:0x02ce A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:89:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:94:0x0246 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x028e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x0274 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:21:0x010a, please report this as an issue */
    static /* synthetic */ Object loadLinks$suspendImpl(Aniworld $this, String data, boolean isCasting, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Boolean> continuation) {
        C00031 c00031;
        Object obj;
        boolean z;
        C00031 c00032;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Aniworld $this2;
        Object obj2;
        String it$iv$iv;
        boolean isCasting2;
        Document document;
        Iterable $this$mapNotNull$iv;
        Collection destination$iv$iv;
        Collection destination$iv$iv2;
        ArrayList arrayList;
        C00044 c00044;
        Triple it;
        Element el;
        String strTagName;
        Triple triple;
        Iterable $this$mapNotNull$iv2;
        Aniworld $this3;
        Document document2;
        Function1<? super SubtitleFile, Unit> function5;
        String lang;
        String link;
        Triple tripleAttr;
        Element elementSelectFirst;
        String strText;
        String lang2;
        String link2;
        Element elementSelectFirst2;
        String strText2;
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
            } else {
                c00031 = $this.new C00031(continuation);
            }
        } else {
            c00031 = $this.new C00031(continuation);
        }
        Object $result = c00031.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00031.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("cookie", String.valueOf($this.getToken())));
                c00031.L$0 = $this;
                c00031.L$1 = SpillingKt.nullOutSpilledVariable(data);
                c00031.L$2 = function1;
                c00031.L$3 = function2;
                c00031.Z$0 = isCasting;
                c00031.label = 1;
                C00031 c00033 = c00031;
                obj = coroutine_suspended;
                z = true;
                Object obj3 = Requests.get$default(app, data, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00033, 4092, (Object) null);
                c00032 = c00033;
                if (obj3 == obj) {
                    return obj;
                }
                function3 = function1;
                function4 = function2;
                $this2 = $this;
                obj2 = obj3;
                it$iv$iv = data;
                isCasting2 = isCasting;
                document = ((NiceResponse) obj2).getDocument();
                $this$mapNotNull$iv = document.select("div.hosterSiteVideo ul li, #episode-links button.link-box");
                destination$iv$iv = new ArrayList();
                for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                    String data2 = it$iv$iv;
                    el = (Element) element$iv$iv$iv;
                    strTagName = el.tagName();
                    triple = null;
                    switch (strTagName.hashCode()) {
                        case -1377687758:
                            $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                            $this3 = $this2;
                            document2 = document;
                            function5 = function3;
                            if (strTagName.equals("button")) {
                                lang = el.attr("data-language-label");
                                if (StringsKt.isBlank(lang)) {
                                    lang = null;
                                }
                                if (lang != null) {
                                    link = el.attr("data-play-url");
                                    if (StringsKt.isBlank(link)) {
                                        link = null;
                                    }
                                    if (link != null) {
                                        tripleAttr = el.attr("data-provider-name");
                                        if (StringsKt.isBlank(tripleAttr)) {
                                            elementSelectFirst = el.selectFirst("span");
                                            if (elementSelectFirst != null && (strText = elementSelectFirst.text()) != null) {
                                                triple = StringsKt.trim(strText).toString();
                                            }
                                            tripleAttr = triple != null ? triple : "";
                                        }
                                        String name = (String) tripleAttr;
                                        triple = new Triple(lang, MainAPIKt.fixUrl($this3, link), name);
                                    }
                                }
                            }
                            break;
                        case 3453:
                            $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                            if (strTagName.equals("li")) {
                                lang2 = el.attr("data-lang-key");
                                if (StringsKt.isBlank(lang2)) {
                                    lang2 = null;
                                }
                                if (lang2 == null) {
                                    $this3 = $this2;
                                    document2 = document;
                                    function5 = function3;
                                } else {
                                    link2 = el.attr("data-link-target");
                                    if (StringsKt.isBlank(link2)) {
                                        link2 = null;
                                    }
                                    if (link2 == null) {
                                        $this3 = $this2;
                                        document2 = document;
                                        function5 = function3;
                                    } else {
                                        $this3 = $this2;
                                        elementSelectFirst2 = el.selectFirst("h4");
                                        if (elementSelectFirst2 != null && (strText2 = elementSelectFirst2.text()) != null) {
                                            triple = StringsKt.trim(strText2).toString();
                                        }
                                        document2 = document;
                                        function5 = function3;
                                        triple = new Triple(lang2, MainAPIKt.fixUrl($this3, link2), triple != null ? triple : "");
                                    }
                                }
                            } else {
                                $this3 = $this2;
                                document2 = document;
                                function5 = function3;
                            }
                            break;
                        default:
                            $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                            $this3 = $this2;
                            document2 = document;
                            function5 = function3;
                            break;
                    }
                    if (triple != null) {
                        destination$iv$iv.add(triple);
                    }
                    it$iv$iv = data2;
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                    $this2 = $this3;
                    document = document2;
                    function3 = function5;
                }
                String data3 = it$iv$iv;
                Aniworld $this4 = $this2;
                Document document3 = document;
                Function1<? super SubtitleFile, Unit> function6 = function3;
                Iterable $this$filter$iv = (List) destination$iv$iv;
                destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    it = (Triple) element$iv$iv;
                    if (!Intrinsics.areEqual(it.getThird(), "Vidoza")) {
                        destination$iv$iv2.add(element$iv$iv);
                    }
                }
                arrayList = (List) destination$iv$iv2;
                c00044 = $this4.new C00044(document3, function6, function4, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(data3);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(document3);
                c00032.Z$0 = isCasting2;
                c00032.label = 2;
                if (ParCollectionsKt.amap(arrayList, c00044, c00032) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 1:
                boolean isCasting3 = c00031.Z$0;
                Function1<? super ExtractorLink, Unit> function7 = (Function1) c00031.L$3;
                function3 = (Function1) c00031.L$2;
                String data4 = (String) c00031.L$1;
                Aniworld $this5 = (Aniworld) c00031.L$0;
                ResultKt.throwOnFailure($result);
                c00032 = c00031;
                obj = coroutine_suspended;
                $this2 = $this5;
                it$iv$iv = data4;
                z = true;
                isCasting2 = isCasting3;
                function4 = function7;
                obj2 = $result;
                document = ((NiceResponse) obj2).getDocument();
                $this$mapNotNull$iv = document.select("div.hosterSiteVideo ul li, #episode-links button.link-box");
                destination$iv$iv = new ArrayList();
                while (r16.hasNext()) {
                    String data5 = it$iv$iv;
                    el = (Element) element$iv$iv$iv;
                    strTagName = el.tagName();
                    triple = null;
                    switch (strTagName.hashCode()) {
                        case -1377687758:
                            $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                            $this3 = $this2;
                            document2 = document;
                            function5 = function3;
                            if (strTagName.equals("button")) {
                                lang = el.attr("data-language-label");
                                if (StringsKt.isBlank(lang)) {
                                    lang = null;
                                }
                                if (lang != null) {
                                    link = el.attr("data-play-url");
                                    if (StringsKt.isBlank(link)) {
                                        link = null;
                                    }
                                    if (link != null) {
                                        tripleAttr = el.attr("data-provider-name");
                                        if (StringsKt.isBlank(tripleAttr)) {
                                            elementSelectFirst = el.selectFirst("span");
                                            if (elementSelectFirst != null) {
                                                triple = StringsKt.trim(strText).toString();
                                            }
                                            tripleAttr = triple != null ? triple : "";
                                        }
                                        String name2 = (String) tripleAttr;
                                        triple = new Triple(lang, MainAPIKt.fixUrl($this3, link), name2);
                                    }
                                }
                            }
                            break;
                        case 3453:
                            $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                            if (strTagName.equals("li")) {
                                lang2 = el.attr("data-lang-key");
                                if (StringsKt.isBlank(lang2)) {
                                    lang2 = null;
                                }
                                if (lang2 == null) {
                                    $this3 = $this2;
                                    document2 = document;
                                    function5 = function3;
                                } else {
                                    link2 = el.attr("data-link-target");
                                    if (StringsKt.isBlank(link2)) {
                                        link2 = null;
                                    }
                                    if (link2 == null) {
                                        $this3 = $this2;
                                        document2 = document;
                                        function5 = function3;
                                    } else {
                                        $this3 = $this2;
                                        elementSelectFirst2 = el.selectFirst("h4");
                                        if (elementSelectFirst2 != null) {
                                            triple = StringsKt.trim(strText2).toString();
                                        }
                                        document2 = document;
                                        function5 = function3;
                                        triple = new Triple(lang2, MainAPIKt.fixUrl($this3, link2), triple != null ? triple : "");
                                    }
                                }
                            } else {
                                $this3 = $this2;
                                document2 = document;
                                function5 = function3;
                            }
                            break;
                        default:
                            $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                            $this3 = $this2;
                            document2 = document;
                            function5 = function3;
                            break;
                    }
                    if (triple != null) {
                        destination$iv$iv.add(triple);
                    }
                    it$iv$iv = data5;
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                    $this2 = $this3;
                    document = document2;
                    function3 = function5;
                }
                String data6 = it$iv$iv;
                Aniworld $this6 = $this2;
                Document document4 = document;
                Function1<? super SubtitleFile, Unit> function8 = function3;
                Iterable $this$filter$iv2 = (List) destination$iv$iv;
                destination$iv$iv2 = new ArrayList();
                while (r8.hasNext()) {
                    it = (Triple) element$iv$iv;
                    if (!Intrinsics.areEqual(it.getThird(), "Vidoza")) {
                        destination$iv$iv2.add(element$iv$iv);
                    }
                }
                arrayList = (List) destination$iv$iv2;
                c00044 = $this6.new C00044(document4, function8, function4, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable($this6);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(data6);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(function8);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(document4);
                c00032.Z$0 = isCasting2;
                c00032.label = 2;
                if (ParCollectionsKt.amap(arrayList, c00044, c00032) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 2:
                boolean z2 = c00031.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.Aniworld.Aniworld$loadLinks$4 */
    /* JADX INFO: compiled from: Aniworld.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "<destruct>", "Lkotlin/Triple;", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Aniworld.Aniworld$loadLinks$4", f = "Aniworld.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {254, 261, 263}, m = "invokeSuspend", n = {"<destruct>", "langKey", "link", "providerName", "<destruct>", "langKey", "link", "providerName", "response", "redirectUrl", "lang", "name", "<destruct>", "langKey", "link", "providerName", "response", "redirectUrl", "lang", "name"}, nl = {255, 263, 265}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C00044 extends SuspendLambda implements Function2<Triple<? extends String, ? extends String, ? extends String>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Document $document;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00044(Document document, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00044> continuation) {
            super(2, continuation);
            this.$document = document;
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00044 = Aniworld.this.new C00044(this.$document, this.$subtitleCallback, this.$callback, continuation);
            c00044.L$0 = obj;
            return c00044;
        }

        public final Object invoke(Triple<String, String, String> triple, Continuation<? super Unit> continuation) {
            return create(triple, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x00dd  */
        /* JADX WARN: Code duplicated, block: B:17:0x00e0  */
        /* JADX WARN: Code duplicated, block: B:19:0x00eb  */
        /* JADX WARN: Code duplicated, block: B:22:0x0119  */
        /* JADX WARN: Code duplicated, block: B:24:0x015f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:25:0x0160  */
        /* JADX WARN: Code duplicated, block: B:27:0x0163  */
        /* JADX WARN: Code duplicated, block: B:29:0x01ac A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:30:0x01ad  */
        public final Object invokeSuspend(Object $result) {
            Object obj;
            String langKey;
            String link;
            String link2;
            NiceResponse response;
            String redirectUrl;
            String lang;
            String name;
            Triple triple = (Triple) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String langKey2 = (String) triple.component1();
                    String link3 = (String) triple.component2();
                    String providerName = (String) triple.component3();
                    this.L$0 = SpillingKt.nullOutSpilledVariable(triple);
                    this.L$1 = langKey2;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(link3);
                    this.L$3 = providerName;
                    this.label = 1;
                    obj = Requests.get$default(MainActivityKt.getApp(), link3, MapsKt.mapOf(TuplesKt.to("cookie", String.valueOf(Aniworld.this.getToken()))), (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4060, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    langKey = langKey2;
                    link = link3;
                    link2 = providerName;
                    response = (NiceResponse) obj;
                    redirectUrl = response.getHeaders().get("Location");
                    if (redirectUrl == null) {
                        return Unit.INSTANCE;
                    }
                    lang = Aniworld.this.getLanguage(langKey, this.$document);
                    if (lang == null) {
                        lang = langKey;
                    }
                    name = link2 + " [" + lang + ']';
                    if (StringsKt.contains$default(redirectUrl, "filemoon", false, 2, (Object) null)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(triple);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(langKey);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(link2);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(response);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(redirectUrl);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(lang);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(name);
                        this.label = 2;
                        if (new FileMoon().getUrl(redirectUrl, name, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(triple);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(langKey);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(link2);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(response);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(redirectUrl);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(lang);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(name);
                        this.label = 3;
                        if (AniworldKt.loadCustomExtractor$default(name, redirectUrl, "", this.$subtitleCallback, this.$callback, null, (Continuation) this, 32, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    String providerName2 = (String) this.L$3;
                    String link4 = (String) this.L$2;
                    String langKey3 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    link2 = providerName2;
                    link = link4;
                    langKey = langKey3;
                    obj = $result;
                    response = (NiceResponse) obj;
                    redirectUrl = response.getHeaders().get("Location");
                    if (redirectUrl == null) {
                        return Unit.INSTANCE;
                    }
                    lang = Aniworld.this.getLanguage(langKey, this.$document);
                    if (lang == null) {
                        lang = langKey;
                    }
                    name = link2 + " [" + lang + ']';
                    if (StringsKt.contains$default(redirectUrl, "filemoon", false, 2, (Object) null)) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(triple);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(langKey);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(link2);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(response);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(redirectUrl);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(lang);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(name);
                        this.label = 2;
                        if (new FileMoon().getUrl(redirectUrl, name, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(triple);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(langKey);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(link);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(link2);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(response);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(redirectUrl);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(lang);
                        this.L$7 = SpillingKt.nullOutSpilledVariable(name);
                        this.label = 3;
                        if (AniworldKt.loadCustomExtractor$default(name, redirectUrl, "", this.$subtitleCallback, this.$callback, null, (Continuation) this, 32, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                case 2:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                case 3:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003e  */
    /* JADX WARN: Code duplicated, block: B:22:0x0044  */
    /* JADX WARN: Code duplicated, block: B:23:0x004b  */
    /* JADX WARN: Code duplicated, block: B:25:0x004e  */
    /* JADX WARN: Code duplicated, block: B:38:0x0075  */
    /* JADX WARN: Code duplicated, block: B:40:0x007b  */
    @Nullable
    public final AnimeSearchResponse toSearchResult(@NotNull Element $this$toSearchResult) {
        Element elementSelectFirst;
        String strAttr;
        String title;
        Element elementSelectFirst2;
        String it;
        String it2;
        Aniworld aniworld = this;
        Element elementSelectFirst3 = $this$toSearchResult.selectFirst("a");
        String strAttr2 = null;
        String href = MainAPIKt.fixUrlNull(aniworld, elementSelectFirst3 != null ? elementSelectFirst3.attr("href") : null);
        if (href == null) {
            return null;
        }
        Element elementSelectFirst4 = $this$toSearchResult.selectFirst("h3");
        if (elementSelectFirst4 != null && (it2 = elementSelectFirst4.text()) != null) {
            if (StringsKt.isBlank(it2)) {
                it2 = null;
            }
            if (it2 == null) {
                elementSelectFirst = $this$toSearchResult.selectFirst("img");
                if (elementSelectFirst != null) {
                    strAttr = elementSelectFirst.attr("alt");
                } else {
                    strAttr = null;
                }
                if (strAttr == null) {
                    strAttr = "";
                }
                title = strAttr;
            } else {
                title = it2;
            }
        } else {
            elementSelectFirst = $this$toSearchResult.selectFirst("img");
            if (elementSelectFirst != null) {
                strAttr = elementSelectFirst.attr("alt");
            } else {
                strAttr = null;
            }
            if (strAttr == null) {
                strAttr = "";
            }
            title = strAttr;
        }
        Aniworld aniworld2 = this;
        Element elementSelectFirst5 = $this$toSearchResult.selectFirst("img");
        if (elementSelectFirst5 == null || (it = elementSelectFirst5.attr("data-src")) == null) {
            elementSelectFirst2 = $this$toSearchResult.selectFirst("img");
            if (elementSelectFirst2 != null) {
                strAttr2 = elementSelectFirst2.attr("src");
            }
        } else {
            if (StringsKt.isBlank(it)) {
                it = null;
            }
            if (it == null) {
                elementSelectFirst2 = $this$toSearchResult.selectFirst("img");
                if (elementSelectFirst2 != null) {
                    strAttr2 = elementSelectFirst2.attr("src");
                }
            } else {
                strAttr2 = it;
            }
        }
        final String posterUrl = MainAPIKt.fixUrlNull(aniworld2, strAttr2);
        return MainAPIKt.newAnimeSearchResponse$default(this, title, href, TvType.Anime, false, new Function1() { // from class: com.Aniworld.Aniworld$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return Aniworld.toSearchResult$lambda$2(posterUrl, (AnimeSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$2(String $posterUrl, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getLanguage(String $this$getLanguage, Document document) {
        String strAttr;
        String strRemovePrefix;
        Element elementSelectFirst = document.selectFirst("div.changeLanguageBox img[data-lang-key=" + $this$getLanguage + ']');
        if (elementSelectFirst == null || (strAttr = elementSelectFirst.attr("title")) == null || (strRemovePrefix = StringsKt.removePrefix(strAttr, "mit")) == null) {
            return null;
        }
        return StringsKt.trim(strRemovePrefix).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: Aniworld.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B9\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J;\u0010\u000e\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/Aniworld/Aniworld$AnimeSearch;", "", "link", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getLink", "()Ljava/lang/String;", "getTitle", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Aniworld"}, k = 1, mv = {2, 4, 0}, xi = 48)
    static final /* data */ class AnimeSearch {

        @NotNull
        private final String link;

        @Nullable
        private final String title;

        public static /* synthetic */ AnimeSearch copy$default(AnimeSearch animeSearch, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = animeSearch.link;
            }
            if ((i & 2) != 0) {
                str2 = animeSearch.title;
            }
            return animeSearch.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLink() {
            return this.link;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final AnimeSearch copy(@JsonProperty("link") @NotNull String link, @JsonProperty("title") @Nullable String title) {
            return new AnimeSearch(link, title);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnimeSearch)) {
                return false;
            }
            AnimeSearch animeSearch = (AnimeSearch) other;
            return Intrinsics.areEqual(this.link, animeSearch.link) && Intrinsics.areEqual(this.title, animeSearch.title);
        }

        public int hashCode() {
            return (this.link.hashCode() * 31) + (this.title == null ? 0 : this.title.hashCode());
        }

        @NotNull
        public String toString() {
            return "AnimeSearch(link=" + this.link + ", title=" + this.title + ')';
        }

        public AnimeSearch(@JsonProperty("link") @NotNull String link, @JsonProperty("title") @Nullable String title) {
            this.link = link;
            this.title = title;
        }

        public /* synthetic */ AnimeSearch(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2);
        }

        @NotNull
        public final String getLink() {
            return this.link;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }
    }

    /* JADX INFO: compiled from: Aniworld.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0003J=\u0010\u0010\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/Aniworld/Aniworld$SerienstreamSearch;", "", "shows", "", "Lcom/Aniworld/Aniworld$Show;", "people", "genres", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getShows", "()Ljava/util/List;", "getPeople", "getGenres", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Aniworld"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class SerienstreamSearch {

        @NotNull
        private final List<Object> genres;

        @NotNull
        private final List<Object> people;

        @NotNull
        private final List<Show> shows;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SerienstreamSearch copy$default(SerienstreamSearch serienstreamSearch, List list, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = serienstreamSearch.shows;
            }
            if ((i & 2) != 0) {
                list2 = serienstreamSearch.people;
            }
            if ((i & 4) != 0) {
                list3 = serienstreamSearch.genres;
            }
            return serienstreamSearch.copy(list, list2, list3);
        }

        @NotNull
        public final List<Show> component1() {
            return this.shows;
        }

        @NotNull
        public final List<Object> component2() {
            return this.people;
        }

        @NotNull
        public final List<Object> component3() {
            return this.genres;
        }

        @NotNull
        public final SerienstreamSearch copy(@NotNull List<Show> shows, @NotNull List<? extends Object> people, @NotNull List<? extends Object> genres) {
            return new SerienstreamSearch(shows, people, genres);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SerienstreamSearch)) {
                return false;
            }
            SerienstreamSearch serienstreamSearch = (SerienstreamSearch) other;
            return Intrinsics.areEqual(this.shows, serienstreamSearch.shows) && Intrinsics.areEqual(this.people, serienstreamSearch.people) && Intrinsics.areEqual(this.genres, serienstreamSearch.genres);
        }

        public int hashCode() {
            return (((this.shows.hashCode() * 31) + this.people.hashCode()) * 31) + this.genres.hashCode();
        }

        @NotNull
        public String toString() {
            return "SerienstreamSearch(shows=" + this.shows + ", people=" + this.people + ", genres=" + this.genres + ')';
        }

        public SerienstreamSearch(@NotNull List<Show> list, @NotNull List<? extends Object> list2, @NotNull List<? extends Object> list3) {
            this.shows = list;
            this.people = list2;
            this.genres = list3;
        }

        @NotNull
        public final List<Show> getShows() {
            return this.shows;
        }

        @NotNull
        public final List<Object> getPeople() {
            return this.people;
        }

        @NotNull
        public final List<Object> getGenres() {
            return this.genres;
        }
    }

    /* JADX INFO: compiled from: Aniworld.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/Aniworld/Aniworld$Show;", "", "name", "", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Aniworld"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Show {

        @NotNull
        private final String name;

        @NotNull
        private final String url;

        public static /* synthetic */ Show copy$default(Show show, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = show.name;
            }
            if ((i & 2) != 0) {
                str2 = show.url;
            }
            return show.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final Show copy(@NotNull String name, @NotNull String url) {
            return new Show(name, url);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Show)) {
                return false;
            }
            Show show = (Show) other;
            return Intrinsics.areEqual(this.name, show.name) && Intrinsics.areEqual(this.url, show.url);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.url.hashCode();
        }

        @NotNull
        public String toString() {
            return "Show(name=" + this.name + ", url=" + this.url + ')';
        }

        public Show(@NotNull String name, @NotNull String url) {
            this.name = name;
            this.url = url;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }
    }
}
