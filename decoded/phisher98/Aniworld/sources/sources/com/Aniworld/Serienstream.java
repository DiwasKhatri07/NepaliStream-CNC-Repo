package com.Aniworld;

import android.content.SharedPreferences;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvType;
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
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Serienstream.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Aniworld/classes.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00172\u0006\u0010\u001d\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u001eJ\u001e\u0010\u0019\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0096@¢\u0006\u0002\u0010$J\u0018\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u001eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\tR\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lcom/Aniworld/Serienstream;", "Lcom/Aniworld/Aniworld;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "token", "getToken", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "Aniworld"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSerienstream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Serienstream.kt\ncom/Aniworld/Serienstream\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,93:1\n1795#2,10:94\n2068#2:104\n2069#2:106\n1805#2:107\n1795#2,10:108\n2068#2:118\n2069#2:120\n1805#2:121\n1#3:105\n1#3:119\n1#3:122\n*S KotlinDebug\n*F\n+ 1 Serienstream.kt\ncom/Aniworld/Serienstream\n*L\n60#1:94,10\n60#1:104\n60#1:106\n60#1:107\n74#1:108,10\n74#1:118\n74#1:120\n74#1:121\n60#1:105\n74#1:119\n*E\n"})
public final class Serienstream extends Aniworld {

    @NotNull
    private final List<MainPageData> mainPage;

    @NotNull
    private String mainUrl;

    @NotNull
    private String name;

    @NotNull
    private final Set<TvType> supportedTypes;

    @Nullable
    private final String token;

    /* JADX INFO: renamed from: com.Aniworld.Serienstream$getMainPage$1 */
    /* JADX INFO: compiled from: Serienstream.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Aniworld.Serienstream", f = "Serienstream.kt", i = {0, 0}, l = {70}, m = "getMainPage", n = {"request", "page"}, nl = {72}, s = {"L$0", "I$0"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Serienstream.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Aniworld.Serienstream$load$1 */
    /* JADX INFO: compiled from: Serienstream.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Aniworld.Serienstream", f = "Serienstream.kt", i = {0}, l = {91}, m = "load", n = {"url"}, nl = {94}, s = {"L$0"}, v = 2)
    static final class C00091 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00091(Continuation<? super C00091> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Serienstream.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Aniworld.Serienstream$search$1 */
    /* JADX INFO: compiled from: Serienstream.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Aniworld.Serienstream", f = "Serienstream.kt", i = {0}, l = {54}, m = "search", n = {"query"}, nl = {58}, s = {"L$0"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Serienstream.this.search(null, (Continuation) this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Serienstream() {
        SharedPreferences sharedPreferences = null;
        this(sharedPreferences, 1, sharedPreferences);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Serienstream(@Nullable SharedPreferences sharedPreferences) {
        super(0 == true ? 1 : 0, 1, 0 == true ? 1 : 0);
        this.mainUrl = "https://serienstream.to";
        this.name = "Serienstream";
        this.supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries});
        this.token = sharedPreferences != null ? sharedPreferences.getString("serienstream_token", null) : null;
        this.mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("genre/action", "Action"), TuplesKt.to("genre/comedy", "Comedy"), TuplesKt.to("genre/drama", "Drama"), TuplesKt.to("genre/k-drama", "Drama"), TuplesKt.to("genre/thriller", "Thriller"), TuplesKt.to("genre/krimi", "Krimi"), TuplesKt.to("genre/mystery", "Mystery"), TuplesKt.to("genre/abenteuer", "Abenteuer"), TuplesKt.to("genre/fantasy", "Fantasy"), TuplesKt.to("genre/science-fiction", "Sci-Fi"), TuplesKt.to("genre/horror", "Horror"), TuplesKt.to("genre/western", "Western"), TuplesKt.to("genre/romantik", "Romantik"), TuplesKt.to("genre/dramedy", "Dramedy"), TuplesKt.to("genre/familie", "Familie"), TuplesKt.to("genre/telenovela", "Telenovela"), TuplesKt.to("genre/Sitcom", "Sitcom"), TuplesKt.to("genre/reality-tv", "Reality TV"), TuplesKt.to("genre/dokusoap", "Doku-Soap"), TuplesKt.to("genre/dokumentation", "Dokumentation"), TuplesKt.to("genre/anime", "Anime"), TuplesKt.to("genre/animation", "Animation"), TuplesKt.to("genre/Zeichentrick", "Zeichentrick"), TuplesKt.to("genre/kinderserie", "Kinderserie"), TuplesKt.to("genre/history", "Historie")});
    }

    public /* synthetic */ Serienstream(SharedPreferences sharedPreferences, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : sharedPreferences);
    }

    @Override // com.Aniworld.Aniworld
    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    @Override // com.Aniworld.Aniworld
    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    @Override // com.Aniworld.Aniworld
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override // com.Aniworld.Aniworld
    public void setName(@NotNull String str) {
        this.name = str;
    }

    @Override // com.Aniworld.Aniworld
    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @Override // com.Aniworld.Aniworld
    @Nullable
    public String getToken() {
        return this.token;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Override // com.Aniworld.Aniworld
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00101 c00101;
        if (continuation instanceof C00101) {
            c00101 = (C00101) continuation;
            if ((c00101.label & Integer.MIN_VALUE) != 0) {
                c00101.label -= Integer.MIN_VALUE;
            } else {
                c00101 = new C00101(continuation);
            }
        } else {
            c00101 = new C00101(continuation);
        }
        Object $result = c00101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00101.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/suche";
                Map mapMapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("term", query), TuplesKt.to("tab", "shows")});
                String str2 = getMainUrl() + "/suche";
                c00101.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00101.label = 1;
                $result = Requests.get$default(app, str, (Map) null, str2, mapMapOf, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00101, 4082, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document resp = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = resp.select(".results-group .card");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            AnimeSearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        return (List) destination$iv$iv;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Override // com.Aniworld.Aniworld
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00081 c00081;
        MainPageRequest request2;
        int page2 = page;
        if (continuation instanceof C00081) {
            c00081 = (C00081) continuation;
            if ((c00081.label & Integer.MIN_VALUE) != 0) {
                c00081.label -= Integer.MIN_VALUE;
            } else {
                c00081 = new C00081(continuation);
            }
        } else {
            c00081 = new C00081(continuation);
        }
        Object $result = c00081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00081.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + '/' + request.getData() + "?page=" + page2;
                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("cookie", String.valueOf(getToken())));
                c00081.L$0 = request;
                c00081.I$0 = page2;
                c00081.label = 1;
                $result = Requests.get$default(app, str, mapMapOf, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00081, 4092, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                page2 = c00081.I$0;
                request2 = (MainPageRequest) c00081.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        ArrayList items = new ArrayList();
        Iterable $this$mapNotNull$iv = document.select("div.col-6");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            int page3 = page2;
            Element it = (Element) element$iv$iv$iv;
            AnimeSearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
            page2 = page3;
        }
        List home = (List) destination$iv$iv;
        if (!home.isEmpty()) {
            items.add(new HomePageList(request2.getName(), home, false, 4, (DefaultConstructorMarker) null));
        }
        return MainAPIKt.newHomePageResponse$default(items, (Boolean) null, 2, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.Aniworld.Aniworld
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00091 c00091;
        Object objLoad;
        if (continuation instanceof C00091) {
            c00091 = (C00091) continuation;
            if ((c00091.label & Integer.MIN_VALUE) != 0) {
                c00091.label -= Integer.MIN_VALUE;
            } else {
                c00091 = new C00091(continuation);
            }
        } else {
            c00091 = new C00091(continuation);
        }
        Object $result = c00091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00091.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00091.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c00091.label = 1;
                objLoad = super.load(url, c00091);
                if (objLoad == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                objLoad = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LoadResponse $this$load_u24lambda_u240 = (LoadResponse) objLoad;
        if ($this$load_u24lambda_u240 != null) {
            $this$load_u24lambda_u240.setType(TvType.TvSeries);
        }
        return objLoad;
    }
}
