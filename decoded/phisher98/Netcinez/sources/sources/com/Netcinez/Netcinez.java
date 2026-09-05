package com.Netcinez;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvSeriesSearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
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
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Netcinez.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Netcinez/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010'J\f\u0010(\u001a\u00020)*\u00020*H\u0002J\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\u001e2\u0006\u0010,\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010-J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010-JF\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u000e2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000207052\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020705H\u0096@¢\u0006\u0002\u0010:R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006;"}, d2 = {"Lcom/Netcinez/Netcinez;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "hasQuickSearch", "getHasQuickSearch", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Netcinez"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nNetcinez.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Netcinez.kt\ncom/Netcinez/Netcinez\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,208:1\n1795#2,10:209\n2068#2:219\n2069#2:221\n1805#2:222\n1795#2,10:224\n2068#2:234\n2069#2:236\n1805#2:237\n1739#2:238\n1814#2,3:239\n1739#2:242\n1814#2,3:243\n1#3:220\n1#3:223\n1#3:235\n*S KotlinDebug\n*F\n+ 1 Netcinez.kt\ncom/Netcinez/Netcinez\n*L\n62#1:209,10\n62#1:219\n62#1:221\n62#1:222\n88#1:224,10\n88#1:234\n88#1:236\n88#1:237\n106#1:238\n106#1:239,3\n118#1:242\n118#1:243,3\n62#1:220\n88#1:235\n*E\n"})
public final class Netcinez extends MainAPI {

    @NotNull
    private String mainUrl = "https://netcinez.si";

    @NotNull
    private String name = "Netcinez";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "pt-br";
    private final boolean hasDownloadSupport = true;
    private final boolean hasQuickSearch = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.Anime, TvType.TvSeries});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("category/ultimos-filmes", "Últimas Atualizações Filmes"), TuplesKt.to("category/acao", "Ação Filmes"), TuplesKt.to("category/animacao", "Animação Filmes"), TuplesKt.to("category/aventura", "Aventura Filmes"), TuplesKt.to("category/comedia", "Comédia Filmes"), TuplesKt.to("category/crime", "Crime Filmes"), TuplesKt.to("tvshows", "Últimas Atualizações Séries"), TuplesKt.to("tvshows/category/acao", "Ação Séries"), TuplesKt.to("tvshows/category/animacao", "Animação Séries"), TuplesKt.to("tvshows/category/aventura", "Aventura Séries"), TuplesKt.to("tvshows/category/comedia", "Comédia Séries"), TuplesKt.to("tvshows/category/crime", "Crime Séries")});

    /* JADX INFO: renamed from: com.Netcinez.Netcinez$getMainPage$1 */
    /* JADX INFO: compiled from: Netcinez.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Netcinez.Netcinez", f = "Netcinez.kt", i = {0, 0, 0}, l = {60}, m = "getMainPage", n = {"request", "url", "page"}, nl = {62}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Netcinez.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Netcinez.Netcinez$load$1 */
    /* JADX INFO: compiled from: Netcinez.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Netcinez.Netcinez", f = "Netcinez.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {100, 107, 132, 141}, m = "load", n = {"url", "url", "document", "title", "poster", "description", "type", "imdbid", "actors", "url", "document", "title", "poster", "description", "type", "imdbid", "actors", "recommendations", "year", "episodes", "url", "document", "title", "poster", "description", "type", "imdbid", "actors", "recommendations", "year"}, nl = {101, 115, 141, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Netcinez.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Netcinez.Netcinez$loadLinks$1 */
    /* JADX INFO: compiled from: Netcinez.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Netcinez.Netcinez", f = "Netcinez.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {157, 164, 171}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "doc", "iframeUrl", "isCasting", "data", "subtitleCallback", "callback", "doc", "iframeUrl", "iframeDoc", "buttons", "isCasting"}, nl = {158, 165, 205}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Netcinez.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Netcinez.Netcinez$search$1 */
    /* JADX INFO: compiled from: Netcinez.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Netcinez.Netcinez", f = "Netcinez.kt", i = {0, 0, 0}, l = {87}, m = "search", n = {"query", "searchResponse", "i"}, nl = {88}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Netcinez.this.search(null, (Continuation) this);
        }
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

    public boolean getHasDownloadSupport() {
        return this.hasDownloadSupport;
    }

    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        boolean z;
        MainPageRequest request2;
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
        Object $result = c00001.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00001.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String url = getMainUrl() + '/' + request.getData();
                Requests app = MainActivityKt.getApp();
                c00001.L$0 = request;
                c00001.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00001.I$0 = page;
                c00001.label = 1;
                z = true;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                int i = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("#box_movies > div.movie");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse(new HomePageList(request2.getName(), home, false), Boxing.boxBoolean(z));
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String title = StringsKt.trim($this$toSearchResult.select("h2").text()).toString();
        String href = MainAPIKt.fixUrl(this, $this$toSearchResult.select("a").attr("href"));
        String strAttr = $this$toSearchResult.select("img").attr("data-src");
        if (strAttr.length() == 0) {
            strAttr = $this$toSearchResult.select("img").attr("src");
        }
        final String posterUrl = strAttr;
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.Netcinez.Netcinez$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return Netcinez.toSearchResult$lambda$1(posterUrl, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$1(String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0063  */
    /* JADX WARN: Code duplicated, block: B:18:0x00bf A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:23:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:25:0x0103  */
    /* JADX WARN: Code duplicated, block: B:29:0x011c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0128  */
    /* JADX WARN: Code duplicated, block: B:38:0x0108 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00c0 -> B:20:0x00c9). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object search(@org.jetbrains.annotations.NotNull java.lang.String r27, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r28) {
        /*
            Method dump skipped, instruction units count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.Netcinez.Netcinez.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x014a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0171  */
    /* JADX WARN: Code duplicated, block: B:28:0x0178  */
    /* JADX WARN: Code duplicated, block: B:31:0x0189  */
    /* JADX WARN: Code duplicated, block: B:32:0x018c  */
    /* JADX WARN: Code duplicated, block: B:38:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:42:0x01c8 A[LOOP:1: B:40:0x01c2->B:42:0x01c8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:45:0x021b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x021c  */
    /* JADX WARN: Code duplicated, block: B:49:0x023e  */
    /* JADX WARN: Code duplicated, block: B:52:0x0268  */
    /* JADX WARN: Code duplicated, block: B:54:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:55:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:59:0x0368 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:60:0x0369  */
    /* JADX WARN: Code duplicated, block: B:62:0x037b  */
    /* JADX WARN: Code duplicated, block: B:64:0x03d3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:65:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        Object obj;
        String str;
        int i;
        String str2;
        Object obj2;
        String url2;
        Document document;
        Element elementSelectFirst;
        String strText;
        String title;
        String poster;
        Element elementSelectFirst2;
        String strAttr;
        String description;
        TvType type;
        Element elementSelectFirst3;
        String strSubstringAfterLast$default;
        String imdbid;
        Iterable $this$map$iv;
        Collection destination$iv$iv;
        List actors;
        Netcinez netcinez;
        Object objAmap;
        List actors2;
        Document document2;
        TvType type2;
        String url3;
        String imdbid2;
        String description2;
        String poster2;
        String title2;
        String strAttr2;
        List recommendations;
        Integer year;
        Object objNewMovieLoadResponse;
        List episodes;
        Iterable $this$map$iv2;
        int $i$f$map;
        Collection destination$iv$iv2;
        Object objNewTvSeriesLoadResponse;
        Element elementSelectFirst4;
        String ephref;
        if (continuation instanceof C00011) {
            c00011 = (C00011) continuation;
            if ((c00011.label & Integer.MIN_VALUE) != 0) {
                c00011.label -= Integer.MIN_VALUE;
            } else {
                c00011 = new C00011(continuation);
            }
        } else {
            c00011 = new C00011(continuation);
        }
        C00011 c00012 = c00011;
        Object $result = c00012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String str3 = "a";
        switch (c00012.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00012.L$0 = url;
                c00012.label = 1;
                obj = coroutine_suspended;
                str = "a";
                i = 2;
                str2 = "href";
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                c00012 = c00012;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                document = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document.selectFirst("div.dataplus h1");
                if (elementSelectFirst != null || (strText = elementSelectFirst.text()) == null) {
                    strText = document.select("div.dataplus span.original").text();
                }
                title = strText;
                poster = MainAPIKt.fixUrl(this, document.select("div.headingder > div.cover").attr("data-bg"));
                elementSelectFirst2 = document.selectFirst("meta[property=og:description]");
                if (elementSelectFirst2 != null) {
                    strAttr = elementSelectFirst2.attr("content");
                } else {
                    strAttr = null;
                }
                description = strAttr;
                if (StringsKt.contains$default(url2, "tvshows", false, i, (Object) null)) {
                    type = TvType.TvSeries;
                } else {
                    type = TvType.Movie;
                }
                elementSelectFirst3 = document.selectFirst("div.imdbdatos a");
                if (elementSelectFirst3 != null || (strAttr2 = elementSelectFirst3.attr(str2)) == null) {
                    strSubstringAfterLast$default = null;
                } else {
                    strSubstringAfterLast$default = StringsKt.substringAfterLast$default(strAttr2, "/", (String) null, i, (Object) null);
                }
                imdbid = strSubstringAfterLast$default;
                $this$map$iv = document.select("#dato-1 > div:nth-child(4)");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Iterable $this$map$iv3 = $this$map$iv;
                    String str4 = str;
                    destination$iv$iv.add(((Element) item$iv$iv).select(str4).text());
                    str = str4;
                    $this$map$iv = $this$map$iv3;
                }
                str3 = str;
                actors = (List) destination$iv$iv;
                List listSelect = document.select("div.links a");
                netcinez = this;
                Netcinez$load$recommendations$1 netcinez$load$recommendations$1 = new Netcinez$load$recommendations$1(netcinez, null);
                c00012.L$0 = url2;
                c00012.L$1 = document;
                c00012.L$2 = title;
                c00012.L$3 = poster;
                c00012.L$4 = description;
                c00012.L$5 = type;
                c00012.L$6 = imdbid;
                c00012.L$7 = actors;
                c00012.label = 2;
                objAmap = ParCollectionsKt.amap(listSelect, netcinez$load$recommendations$1, c00012);
                if (objAmap == obj) {
                    return obj;
                }
                actors2 = actors;
                document2 = document;
                type2 = type;
                url3 = url2;
                imdbid2 = imdbid;
                description2 = description;
                poster2 = poster;
                title2 = title;
                recommendations = (List) objAmap;
                year = StringsKt.toIntOrNull(document2.select("#dato-1 > div:nth-child(5)").text());
                if (type2 != TvType.TvSeries) {
                    TvType tvType = TvType.Movie;
                    C00034 c00034 = new C00034(poster2, description2, year, recommendations, actors2, imdbid2, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster2);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(description2);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(imdbid2);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(actors2);
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00012.L$9 = SpillingKt.nullOutSpilledVariable(year);
                    c00012.label = 4;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(netcinez, title2, url3, tvType, url3, c00034, c00012);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    return objNewMovieLoadResponse;
                }
                episodes = new ArrayList();
                $this$map$iv2 = document2.select("div.post #cssmenu > ul li > ul > li");
                $i$f$map = 0;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                for (Object item$iv$iv2 : $this$map$iv2) {
                    Document document3 = document2;
                    Element it = (Element) item$iv$iv2;
                    Iterable $this$map$iv4 = $this$map$iv2;
                    String title3 = title2;
                    String url4 = url3;
                    List episodes2 = episodes;
                    int $i$f$map2 = $i$f$map;
                    final Integer seasonno = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(it.select("a > span.datex").text(), "-", (String) null, 2, (Object) null)).toString());
                    final Integer episodeno = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringAfterLast$default(it.select("a > span.datex").text(), "-", (String) null, 2, (Object) null)).toString());
                    final String epname = it.select("a > span.datix").text();
                    elementSelectFirst4 = it.selectFirst(str3);
                    if (elementSelectFirst4 != null) {
                        ephref = elementSelectFirst4.attr(str2);
                    } else {
                        ephref = null;
                    }
                    episodes2.add(MainAPIKt.newEpisode(netcinez, ephref, new Function1() { // from class: com.Netcinez.Netcinez$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj3) {
                            return Netcinez.load$lambda$1$0(epname, seasonno, episodeno, (Episode) obj3);
                        }
                    }));
                    destination$iv$iv2.add(Unit.INSTANCE);
                    $this$map$iv2 = $this$map$iv4;
                    document2 = document3;
                    $i$f$map = $i$f$map2;
                    url3 = url4;
                    title2 = title3;
                    episodes = episodes2;
                    str2 = str2;
                }
                Document document4 = document2;
                TvType tvType2 = TvType.TvSeries;
                C00023 c00023 = new C00023(poster2, description2, year, recommendations, actors2, imdbid2, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(document4);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster2);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(description2);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(imdbid2);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(actors2);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(recommendations);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(year);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(episodes);
                c00012.label = 3;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(netcinez, title2, url3, tvType2, episodes, c00023, c00012);
                if (objNewTvSeriesLoadResponse == obj) {
                    return obj;
                }
                return objNewTvSeriesLoadResponse;
            case 1:
                url2 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                str = "a";
                i = 2;
                obj2 = $result;
                str2 = "href";
                document = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document.selectFirst("div.dataplus h1");
                if (elementSelectFirst != null) {
                    strText = document.select("div.dataplus span.original").text();
                } else {
                    strText = document.select("div.dataplus span.original").text();
                }
                title = strText;
                poster = MainAPIKt.fixUrl(this, document.select("div.headingder > div.cover").attr("data-bg"));
                elementSelectFirst2 = document.selectFirst("meta[property=og:description]");
                if (elementSelectFirst2 != null) {
                    strAttr = elementSelectFirst2.attr("content");
                } else {
                    strAttr = null;
                }
                description = strAttr;
                if (StringsKt.contains$default(url2, "tvshows", false, i, (Object) null)) {
                    type = TvType.TvSeries;
                } else {
                    type = TvType.Movie;
                }
                elementSelectFirst3 = document.selectFirst("div.imdbdatos a");
                if (elementSelectFirst3 != null) {
                    strSubstringAfterLast$default = null;
                } else {
                    strSubstringAfterLast$default = null;
                }
                imdbid = strSubstringAfterLast$default;
                $this$map$iv = document.select("#dato-1 > div:nth-child(4)");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r16.hasNext()) {
                    Iterable $this$map$iv5 = $this$map$iv;
                    String str5 = str;
                    destination$iv$iv.add(((Element) item$iv$iv).select(str5).text());
                    str = str5;
                    $this$map$iv = $this$map$iv5;
                }
                str3 = str;
                actors = (List) destination$iv$iv;
                List listSelect2 = document.select("div.links a");
                netcinez = this;
                Netcinez$load$recommendations$1 netcinez$load$recommendations$2 = new Netcinez$load$recommendations$1(netcinez, null);
                c00012.L$0 = url2;
                c00012.L$1 = document;
                c00012.L$2 = title;
                c00012.L$3 = poster;
                c00012.L$4 = description;
                c00012.L$5 = type;
                c00012.L$6 = imdbid;
                c00012.L$7 = actors;
                c00012.label = 2;
                objAmap = ParCollectionsKt.amap(listSelect2, netcinez$load$recommendations$2, c00012);
                if (objAmap == obj) {
                    return obj;
                }
                actors2 = actors;
                document2 = document;
                type2 = type;
                url3 = url2;
                imdbid2 = imdbid;
                description2 = description;
                poster2 = poster;
                title2 = title;
                recommendations = (List) objAmap;
                year = StringsKt.toIntOrNull(document2.select("#dato-1 > div:nth-child(5)").text());
                if (type2 != TvType.TvSeries) {
                    TvType tvType3 = TvType.Movie;
                    C00034 c00035 = new C00034(poster2, description2, year, recommendations, actors2, imdbid2, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster2);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(description2);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(imdbid2);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(actors2);
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00012.L$9 = SpillingKt.nullOutSpilledVariable(year);
                    c00012.label = 4;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(netcinez, title2, url3, tvType3, url3, c00035, c00012);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    return objNewMovieLoadResponse;
                }
                episodes = new ArrayList();
                $this$map$iv2 = document2.select("div.post #cssmenu > ul li > ul > li");
                $i$f$map = 0;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                while (r15.hasNext()) {
                    Document document5 = document2;
                    Element it2 = (Element) item$iv$iv2;
                    Iterable $this$map$iv6 = $this$map$iv2;
                    String title4 = title2;
                    String url5 = url3;
                    List episodes3 = episodes;
                    int $i$f$map3 = $i$f$map;
                    final Integer seasonno2 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(it2.select("a > span.datex").text(), "-", (String) null, 2, (Object) null)).toString());
                    final Integer episodeno2 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringAfterLast$default(it2.select("a > span.datex").text(), "-", (String) null, 2, (Object) null)).toString());
                    final String epname2 = it2.select("a > span.datix").text();
                    elementSelectFirst4 = it2.selectFirst(str3);
                    if (elementSelectFirst4 != null) {
                        ephref = elementSelectFirst4.attr(str2);
                    } else {
                        ephref = null;
                    }
                    episodes3.add(MainAPIKt.newEpisode(netcinez, ephref, new Function1() { // from class: com.Netcinez.Netcinez$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj3) {
                            return Netcinez.load$lambda$1$0(epname2, seasonno2, episodeno2, (Episode) obj3);
                        }
                    }));
                    destination$iv$iv2.add(Unit.INSTANCE);
                    $this$map$iv2 = $this$map$iv6;
                    document2 = document5;
                    $i$f$map = $i$f$map3;
                    url3 = url5;
                    title2 = title4;
                    episodes = episodes3;
                    str2 = str2;
                }
                Document document6 = document2;
                TvType tvType4 = TvType.TvSeries;
                C00023 c00024 = new C00023(poster2, description2, year, recommendations, actors2, imdbid2, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(document6);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster2);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(description2);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(imdbid2);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(actors2);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(recommendations);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(year);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(episodes);
                c00012.label = 3;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(netcinez, title2, url3, tvType4, episodes, c00024, c00012);
                if (objNewTvSeriesLoadResponse == obj) {
                    return obj;
                }
                return objNewTvSeriesLoadResponse;
            case 2:
                List actors3 = (List) c00012.L$7;
                String imdbid3 = (String) c00012.L$6;
                type2 = (TvType) c00012.L$5;
                String description3 = (String) c00012.L$4;
                String poster3 = (String) c00012.L$3;
                String title5 = (String) c00012.L$2;
                Document document7 = (Document) c00012.L$1;
                String url6 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                netcinez = this;
                obj = coroutine_suspended;
                actors2 = actors3;
                document2 = document7;
                objAmap = $result;
                str2 = "href";
                url3 = url6;
                imdbid2 = imdbid3;
                description2 = description3;
                poster2 = poster3;
                title2 = title5;
                recommendations = (List) objAmap;
                year = StringsKt.toIntOrNull(document2.select("#dato-1 > div:nth-child(5)").text());
                if (type2 != TvType.TvSeries) {
                    TvType tvType5 = TvType.Movie;
                    C00034 c00036 = new C00034(poster2, description2, year, recommendations, actors2, imdbid2, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster2);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(description2);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(imdbid2);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(actors2);
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(recommendations);
                    c00012.L$9 = SpillingKt.nullOutSpilledVariable(year);
                    c00012.label = 4;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(netcinez, title2, url3, tvType5, url3, c00036, c00012);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    return objNewMovieLoadResponse;
                }
                episodes = new ArrayList();
                $this$map$iv2 = document2.select("div.post #cssmenu > ul li > ul > li");
                $i$f$map = 0;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                while (r15.hasNext()) {
                    Document document8 = document2;
                    Element it3 = (Element) item$iv$iv2;
                    Iterable $this$map$iv7 = $this$map$iv2;
                    String title6 = title2;
                    String url7 = url3;
                    List episodes4 = episodes;
                    int $i$f$map4 = $i$f$map;
                    final Integer seasonno3 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringBefore$default(it3.select("a > span.datex").text(), "-", (String) null, 2, (Object) null)).toString());
                    final Integer episodeno3 = StringsKt.toIntOrNull(StringsKt.trim(StringsKt.substringAfterLast$default(it3.select("a > span.datex").text(), "-", (String) null, 2, (Object) null)).toString());
                    final String epname3 = it3.select("a > span.datix").text();
                    elementSelectFirst4 = it3.selectFirst(str3);
                    if (elementSelectFirst4 != null) {
                        ephref = elementSelectFirst4.attr(str2);
                    } else {
                        ephref = null;
                    }
                    episodes4.add(MainAPIKt.newEpisode(netcinez, ephref, new Function1() { // from class: com.Netcinez.Netcinez$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj3) {
                            return Netcinez.load$lambda$1$0(epname3, seasonno3, episodeno3, (Episode) obj3);
                        }
                    }));
                    destination$iv$iv2.add(Unit.INSTANCE);
                    $this$map$iv2 = $this$map$iv7;
                    document2 = document8;
                    $i$f$map = $i$f$map4;
                    url3 = url7;
                    title2 = title6;
                    episodes = episodes4;
                    str2 = str2;
                }
                Document document9 = document2;
                TvType tvType6 = TvType.TvSeries;
                C00023 c00025 = new C00023(poster2, description2, year, recommendations, actors2, imdbid2, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(document9);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster2);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(description2);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(type2);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(imdbid2);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(actors2);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(recommendations);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(year);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(episodes);
                c00012.label = 3;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(netcinez, title2, url3, tvType6, episodes, c00025, c00012);
                if (objNewTvSeriesLoadResponse == obj) {
                    return obj;
                }
                return objNewTvSeriesLoadResponse;
            case 3:
                ResultKt.throwOnFailure($result);
                return $result;
            case 4:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$1$0(String $epname, Integer $seasonno, Integer $episodeno, Episode $this$newEpisode) {
        $this$newEpisode.setName($epname);
        $this$newEpisode.setSeason($seasonno);
        $this$newEpisode.setEpisode($episodeno);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.Netcinez.Netcinez$load$3 */
    /* JADX INFO: compiled from: Netcinez.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Netcinez.Netcinez$load$3", f = "Netcinez.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00023 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $actors;
        final /* synthetic */ String $description;
        final /* synthetic */ String $imdbid;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<TvSeriesSearchResponse> $recommendations;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00023(String str, String str2, Integer num, List<TvSeriesSearchResponse> list, List<String> list2, String str3, Continuation<? super C00023> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$description = str2;
            this.$year = num;
            this.$recommendations = list;
            this.$actors = list2;
            this.$imdbid = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00023 = new C00023(this.$poster, this.$description, this.$year, this.$recommendations, this.$actors, this.$imdbid, continuation);
            c00023.L$0 = obj;
            return c00023;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setPlot(this.$description);
                    loadResponse.setYear(this.$year);
                    loadResponse.setRecommendations(this.$recommendations);
                    LoadResponse.Companion.addActorNames(loadResponse, this.$actors);
                    LoadResponse.Companion.addImdbId(loadResponse, this.$imdbid);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.Netcinez.Netcinez$load$4 */
    /* JADX INFO: compiled from: Netcinez.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Netcinez.Netcinez$load$4", f = "Netcinez.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00034 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $actors;
        final /* synthetic */ String $description;
        final /* synthetic */ String $imdbid;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<TvSeriesSearchResponse> $recommendations;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00034(String str, String str2, Integer num, List<TvSeriesSearchResponse> list, List<String> list2, String str3, Continuation<? super C00034> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$description = str2;
            this.$year = num;
            this.$recommendations = list;
            this.$actors = list2;
            this.$imdbid = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00034 = new C00034(this.$poster, this.$description, this.$year, this.$recommendations, this.$actors, this.$imdbid, continuation);
            c00034.L$0 = obj;
            return c00034;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LoadResponse loadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    loadResponse.setPosterUrl(this.$poster);
                    loadResponse.setPlot(this.$description);
                    loadResponse.setYear(this.$year);
                    loadResponse.setRecommendations(this.$recommendations);
                    LoadResponse.Companion.addActorNames(loadResponse, this.$actors);
                    LoadResponse.Companion.addImdbId(loadResponse, this.$imdbid);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0114  */
    /* JADX WARN: Code duplicated, block: B:22:0x011b  */
    /* JADX WARN: Code duplicated, block: B:29:0x012a  */
    /* JADX WARN: Code duplicated, block: B:31:0x012d  */
    /* JADX WARN: Code duplicated, block: B:33:0x0139  */
    /* JADX WARN: Code duplicated, block: B:35:0x018d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x018e  */
    /* JADX WARN: Code duplicated, block: B:39:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:41:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:43:0x01f6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00041 c00041;
        boolean z;
        Object obj;
        String str;
        C00041 c00042;
        String data2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Object obj2;
        boolean isCasting2;
        Document doc;
        Element elementSelectFirst;
        String iframeUrl;
        String str2;
        boolean z2;
        Function1<? super ExtractorLink, Unit> function5;
        boolean isCasting3;
        String iframeUrl2;
        C00041 c00043;
        String data3;
        Function1<? super SubtitleFile, Unit> function6;
        Function1<? super ExtractorLink, Unit> function7;
        boolean isCasting4;
        Document doc2;
        Document iframeDoc;
        List listSelect;
        C00052 c00052;
        if (continuation instanceof C00041) {
            c00041 = (C00041) continuation;
            if ((c00041.label & Integer.MIN_VALUE) != 0) {
                c00041.label -= Integer.MIN_VALUE;
            } else {
                c00041 = new C00041(continuation);
            }
        } else {
            c00041 = new C00041(continuation);
        }
        Object $result = c00041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00041.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00041.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00041.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00041.L$2 = function2;
                c00041.Z$0 = isCasting;
                c00041.label = 1;
                z = true;
                C00041 c00044 = c00041;
                obj = coroutine_suspended;
                str = "Error:";
                Object obj3 = Requests.get$default(app, data, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00044, 4094, (Object) null);
                c00042 = c00044;
                if (obj3 == obj) {
                    return obj;
                }
                data2 = data;
                function3 = function1;
                function4 = function2;
                obj2 = obj3;
                isCasting2 = isCasting;
                doc = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = doc.selectFirst("#player-container iframe");
                if (elementSelectFirst != null) {
                    iframeUrl = elementSelectFirst.absUrl("src");
                } else {
                    iframeUrl = null;
                }
                str2 = iframeUrl;
                if (str2 != null || str2.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    Log.INSTANCE.d(str, "Iframe not found");
                    return Boxing.boxBoolean(false);
                }
                Requests app2 = MainActivityKt.getApp();
                c00042.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00042.L$2 = function4;
                c00042.L$3 = SpillingKt.nullOutSpilledVariable(doc);
                c00042.L$4 = SpillingKt.nullOutSpilledVariable(iframeUrl);
                c00042.Z$0 = isCasting2;
                c00042.label = 2;
                function5 = function4;
                C00041 c00045 = c00042;
                String iframeUrl3 = iframeUrl;
                isCasting3 = isCasting2;
                $result = Requests.get$default(app2, iframeUrl3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00045, 4094, (Object) null);
                iframeUrl2 = iframeUrl3;
                c00043 = c00045;
                if ($result == obj) {
                    return obj;
                }
                data3 = data2;
                function6 = function3;
                function7 = function5;
                isCasting4 = isCasting3;
                doc2 = doc;
                iframeDoc = ((NiceResponse) $result).getDocument();
                listSelect = iframeDoc.select("div.btn-container a");
                if (listSelect.isEmpty()) {
                    Log.INSTANCE.d(str, "No buttons found in iframe");
                    return Boxing.boxBoolean(false);
                }
                c00052 = new C00052(function7, this, null);
                c00043.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                c00043.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                c00043.L$2 = SpillingKt.nullOutSpilledVariable(function7);
                c00043.L$3 = SpillingKt.nullOutSpilledVariable(doc2);
                c00043.L$4 = SpillingKt.nullOutSpilledVariable(iframeUrl2);
                c00043.L$5 = SpillingKt.nullOutSpilledVariable(iframeDoc);
                c00043.L$6 = SpillingKt.nullOutSpilledVariable(listSelect);
                c00043.Z$0 = isCasting4;
                c00043.label = 3;
                if (ParCollectionsKt.amap(listSelect, c00052, c00043) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 1:
                boolean isCasting5 = c00041.Z$0;
                Function1<? super ExtractorLink, Unit> function8 = (Function1) c00041.L$2;
                Function1<? super SubtitleFile, Unit> function9 = (Function1) c00041.L$1;
                String data4 = (String) c00041.L$0;
                ResultKt.throwOnFailure($result);
                c00042 = c00041;
                obj = coroutine_suspended;
                str = "Error:";
                function3 = function9;
                data2 = data4;
                z = true;
                obj2 = $result;
                isCasting2 = isCasting5;
                function4 = function8;
                doc = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = doc.selectFirst("#player-container iframe");
                if (elementSelectFirst != null) {
                    iframeUrl = elementSelectFirst.absUrl("src");
                } else {
                    iframeUrl = null;
                }
                str2 = iframeUrl;
                if (str2 != null) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                if (z2) {
                    Log.INSTANCE.d(str, "Iframe not found");
                    return Boxing.boxBoolean(false);
                }
                Requests app3 = MainActivityKt.getApp();
                c00042.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00042.L$2 = function4;
                c00042.L$3 = SpillingKt.nullOutSpilledVariable(doc);
                c00042.L$4 = SpillingKt.nullOutSpilledVariable(iframeUrl);
                c00042.Z$0 = isCasting2;
                c00042.label = 2;
                function5 = function4;
                C00041 c00046 = c00042;
                String iframeUrl4 = iframeUrl;
                isCasting3 = isCasting2;
                $result = Requests.get$default(app3, iframeUrl4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00046, 4094, (Object) null);
                iframeUrl2 = iframeUrl4;
                c00043 = c00046;
                if ($result == obj) {
                    return obj;
                }
                data3 = data2;
                function6 = function3;
                function7 = function5;
                isCasting4 = isCasting3;
                doc2 = doc;
                iframeDoc = ((NiceResponse) $result).getDocument();
                listSelect = iframeDoc.select("div.btn-container a");
                if (listSelect.isEmpty()) {
                    Log.INSTANCE.d(str, "No buttons found in iframe");
                    return Boxing.boxBoolean(false);
                }
                c00052 = new C00052(function7, this, null);
                c00043.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                c00043.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                c00043.L$2 = SpillingKt.nullOutSpilledVariable(function7);
                c00043.L$3 = SpillingKt.nullOutSpilledVariable(doc2);
                c00043.L$4 = SpillingKt.nullOutSpilledVariable(iframeUrl2);
                c00043.L$5 = SpillingKt.nullOutSpilledVariable(iframeDoc);
                c00043.L$6 = SpillingKt.nullOutSpilledVariable(listSelect);
                c00043.Z$0 = isCasting4;
                c00043.label = 3;
                if (ParCollectionsKt.amap(listSelect, c00052, c00043) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 2:
                isCasting4 = c00041.Z$0;
                String iframeUrl5 = (String) c00041.L$4;
                Document doc3 = (Document) c00041.L$3;
                Function1<? super ExtractorLink, Unit> function10 = (Function1) c00041.L$2;
                Function1<? super SubtitleFile, Unit> function11 = (Function1) c00041.L$1;
                String data5 = (String) c00041.L$0;
                ResultKt.throwOnFailure($result);
                c00043 = c00041;
                obj = coroutine_suspended;
                str = "Error:";
                iframeUrl2 = iframeUrl5;
                doc2 = doc3;
                function7 = function10;
                function6 = function11;
                data3 = data5;
                z = true;
                iframeDoc = ((NiceResponse) $result).getDocument();
                listSelect = iframeDoc.select("div.btn-container a");
                if (listSelect.isEmpty()) {
                    Log.INSTANCE.d(str, "No buttons found in iframe");
                    return Boxing.boxBoolean(false);
                }
                c00052 = new C00052(function7, this, null);
                c00043.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                c00043.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                c00043.L$2 = SpillingKt.nullOutSpilledVariable(function7);
                c00043.L$3 = SpillingKt.nullOutSpilledVariable(doc2);
                c00043.L$4 = SpillingKt.nullOutSpilledVariable(iframeUrl2);
                c00043.L$5 = SpillingKt.nullOutSpilledVariable(iframeDoc);
                c00043.L$6 = SpillingKt.nullOutSpilledVariable(listSelect);
                c00043.Z$0 = isCasting4;
                c00043.label = 3;
                if (ParCollectionsKt.amap(listSelect, c00052, c00043) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 3:
                boolean z3 = c00041.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.Netcinez.Netcinez$loadLinks$2 */
    /* JADX INFO: compiled from: Netcinez.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "button", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Netcinez.Netcinez$loadLinks$2", f = "Netcinez.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {176, 187}, m = "invokeSuspend", n = {"button", "intermediateUrl", "label", "button", "intermediateUrl", "label", "finalDoc", "finalElement", "finalUrl"}, nl = {177, 186}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00052 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        final /* synthetic */ Netcinez this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00052(Function1<? super ExtractorLink, Unit> function1, Netcinez netcinez, Continuation<? super C00052> continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.this$0 = netcinez;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00052 = new C00052(this.$callback, this.this$0, continuation);
            c00052.L$0 = obj;
            return c00052;
        }

        public final Object invoke(Element element, Continuation<? super Unit> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x00a9 A[Catch: Exception -> 0x004f, TryCatch #0 {Exception -> 0x004f, blocks: (B:7:0x0037, B:47:0x0165, B:10:0x0049, B:19:0x009a, B:21:0x00a9, B:24:0x00b1, B:25:0x00b5, B:27:0x00b9, B:30:0x00c2, B:38:0x00db, B:43:0x00e8, B:48:0x0169, B:31:0x00c7, B:34:0x00d0), top: B:55:0x0014 }] */
        /* JADX WARN: Code duplicated, block: B:22:0x00ae  */
        /* JADX WARN: Code duplicated, block: B:24:0x00b1 A[Catch: Exception -> 0x004f, TryCatch #0 {Exception -> 0x004f, blocks: (B:7:0x0037, B:47:0x0165, B:10:0x0049, B:19:0x009a, B:21:0x00a9, B:24:0x00b1, B:25:0x00b5, B:27:0x00b9, B:30:0x00c2, B:38:0x00db, B:43:0x00e8, B:48:0x0169, B:31:0x00c7, B:34:0x00d0), top: B:55:0x0014 }] */
        /* JADX WARN: Code duplicated, block: B:26:0x00b8  */
        /* JADX WARN: Code duplicated, block: B:27:0x00b9 A[Catch: Exception -> 0x004f, TryCatch #0 {Exception -> 0x004f, blocks: (B:7:0x0037, B:47:0x0165, B:10:0x0049, B:19:0x009a, B:21:0x00a9, B:24:0x00b1, B:25:0x00b5, B:27:0x00b9, B:30:0x00c2, B:38:0x00db, B:43:0x00e8, B:48:0x0169, B:31:0x00c7, B:34:0x00d0), top: B:55:0x0014 }] */
        /* JADX WARN: Code duplicated, block: B:29:0x00c1  */
        /* JADX WARN: Code duplicated, block: B:30:0x00c2 A[Catch: Exception -> 0x004f, TryCatch #0 {Exception -> 0x004f, blocks: (B:7:0x0037, B:47:0x0165, B:10:0x0049, B:19:0x009a, B:21:0x00a9, B:24:0x00b1, B:25:0x00b5, B:27:0x00b9, B:30:0x00c2, B:38:0x00db, B:43:0x00e8, B:48:0x0169, B:31:0x00c7, B:34:0x00d0), top: B:55:0x0014 }] */
        /* JADX WARN: Code duplicated, block: B:31:0x00c7 A[Catch: Exception -> 0x004f, TryCatch #0 {Exception -> 0x004f, blocks: (B:7:0x0037, B:47:0x0165, B:10:0x0049, B:19:0x009a, B:21:0x00a9, B:24:0x00b1, B:25:0x00b5, B:27:0x00b9, B:30:0x00c2, B:38:0x00db, B:43:0x00e8, B:48:0x0169, B:31:0x00c7, B:34:0x00d0), top: B:55:0x0014 }] */
        /* JADX WARN: Code duplicated, block: B:33:0x00cf  */
        /* JADX WARN: Code duplicated, block: B:34:0x00d0 A[Catch: Exception -> 0x004f, TryCatch #0 {Exception -> 0x004f, blocks: (B:7:0x0037, B:47:0x0165, B:10:0x0049, B:19:0x009a, B:21:0x00a9, B:24:0x00b1, B:25:0x00b5, B:27:0x00b9, B:30:0x00c2, B:38:0x00db, B:43:0x00e8, B:48:0x0169, B:31:0x00c7, B:34:0x00d0), top: B:55:0x0014 }] */
        /* JADX WARN: Code duplicated, block: B:35:0x00d7  */
        /* JADX WARN: Code duplicated, block: B:38:0x00db A[Catch: Exception -> 0x004f, TryCatch #0 {Exception -> 0x004f, blocks: (B:7:0x0037, B:47:0x0165, B:10:0x0049, B:19:0x009a, B:21:0x00a9, B:24:0x00b1, B:25:0x00b5, B:27:0x00b9, B:30:0x00c2, B:38:0x00db, B:43:0x00e8, B:48:0x0169, B:31:0x00c7, B:34:0x00d0), top: B:55:0x0014 }] */
        /* JADX WARN: Code duplicated, block: B:40:0x00e4  */
        /* JADX WARN: Code duplicated, block: B:41:0x00e5  */
        /* JADX WARN: Code duplicated, block: B:43:0x00e8 A[Catch: Exception -> 0x004f, TryCatch #0 {Exception -> 0x004f, blocks: (B:7:0x0037, B:47:0x0165, B:10:0x0049, B:19:0x009a, B:21:0x00a9, B:24:0x00b1, B:25:0x00b5, B:27:0x00b9, B:30:0x00c2, B:38:0x00db, B:43:0x00e8, B:48:0x0169, B:31:0x00c7, B:34:0x00d0), top: B:55:0x0014 }] */
        /* JADX WARN: Code duplicated, block: B:45:0x0160 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:46:0x0161  */
        /* JADX WARN: Code duplicated, block: B:48:0x0169 A[Catch: Exception -> 0x004f, TRY_LEAVE, TryCatch #0 {Exception -> 0x004f, blocks: (B:7:0x0037, B:47:0x0165, B:10:0x0049, B:19:0x009a, B:21:0x00a9, B:24:0x00b1, B:25:0x00b5, B:27:0x00b9, B:30:0x00c2, B:38:0x00db, B:43:0x00e8, B:48:0x0169, B:31:0x00c7, B:34:0x00d0), top: B:55:0x0014 }] */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final Object invokeSuspend(Object $result) {
            String label;
            Object obj;
            String intermediateUrl;
            Document finalDoc;
            Element finalElement;
            String strTagName;
            String strAbsUrl;
            String finalUrl;
            Function1<ExtractorLink, Unit> function1;
            Object objNewExtractorLink;
            Function1<ExtractorLink, Unit> function2;
            Element button = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            boolean z = true;
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String intermediateUrl2 = button.absUrl("href");
                        label = StringsKt.trim(button.text()).toString();
                        try {
                            this.L$0 = SpillingKt.nullOutSpilledVariable(button);
                            this.L$1 = intermediateUrl2;
                            this.L$2 = label;
                            this.label = 1;
                            obj = Requests.get$default(MainActivityKt.getApp(), intermediateUrl2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, (Continuation) this, 4094, (Object) null);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            intermediateUrl = intermediateUrl2;
                            finalDoc = ((NiceResponse) obj).getDocument();
                            finalElement = finalDoc.selectFirst("div.container a, source");
                            if (finalElement != null) {
                                strTagName = finalElement.tagName();
                            } else {
                                strTagName = null;
                            }
                            if (strTagName != null) {
                                switch (strTagName.hashCode()) {
                                    case -896505829:
                                        if (strTagName.equals("source")) {
                                            strAbsUrl = null;
                                        } else {
                                            strAbsUrl = finalElement.absUrl("src");
                                        }
                                        break;
                                    case 97:
                                        if (strTagName.equals("a")) {
                                            strAbsUrl = null;
                                        } else {
                                            strAbsUrl = finalElement.absUrl("href");
                                        }
                                        break;
                                    default:
                                        strAbsUrl = null;
                                        break;
                                }
                            } else {
                                strAbsUrl = null;
                            }
                            finalUrl = strAbsUrl;
                            if (finalUrl != null) {
                                if (finalUrl.length() > 0) {
                                    z = false;
                                }
                                if (z) {
                                    function1 = this.$callback;
                                    this.L$0 = SpillingKt.nullOutSpilledVariable(button);
                                    this.L$1 = intermediateUrl;
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(label);
                                    this.L$3 = SpillingKt.nullOutSpilledVariable(finalDoc);
                                    this.L$4 = SpillingKt.nullOutSpilledVariable(finalElement);
                                    this.L$5 = SpillingKt.nullOutSpilledVariable(finalUrl);
                                    this.L$6 = function1;
                                    this.label = 2;
                                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(this.this$0.getName() + ' ' + label, this.this$0.getName() + ' ' + label, finalUrl, ExtractorApiKt.getINFER_TYPE(), new AnonymousClass1(this.this$0, null), (Continuation) this);
                                    if (objNewExtractorLink == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    function2 = function1;
                                    function2.invoke(objNewExtractorLink);
                                } else {
                                    Log.INSTANCE.d("Error:", "No final link found at " + intermediateUrl);
                                }
                            }
                            return Unit.INSTANCE;
                        } catch (Exception e) {
                            e = e;
                            Log.INSTANCE.e("Error:", "Error processing link: " + intermediateUrl2 + ' ' + e);
                        }
                        break;
                    case 1:
                        label = (String) this.L$2;
                        intermediateUrl = (String) this.L$1;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        finalDoc = ((NiceResponse) obj).getDocument();
                        finalElement = finalDoc.selectFirst("div.container a, source");
                        if (finalElement != null) {
                            strTagName = finalElement.tagName();
                        } else {
                            strTagName = null;
                        }
                        if (strTagName != null) {
                            switch (strTagName.hashCode()) {
                                case -896505829:
                                    if (strTagName.equals("source")) {
                                        strAbsUrl = finalElement.absUrl("src");
                                    } else {
                                        strAbsUrl = null;
                                    }
                                    break;
                                case 97:
                                    if (strTagName.equals("a")) {
                                        strAbsUrl = finalElement.absUrl("href");
                                    } else {
                                        strAbsUrl = null;
                                    }
                                    break;
                                default:
                                    strAbsUrl = null;
                                    break;
                            }
                        } else {
                            strAbsUrl = null;
                        }
                        finalUrl = strAbsUrl;
                        if (finalUrl != null) {
                            if (finalUrl.length() > 0) {
                                z = false;
                            }
                            if (z) {
                                function1 = this.$callback;
                                this.L$0 = SpillingKt.nullOutSpilledVariable(button);
                                this.L$1 = intermediateUrl;
                                this.L$2 = SpillingKt.nullOutSpilledVariable(label);
                                this.L$3 = SpillingKt.nullOutSpilledVariable(finalDoc);
                                this.L$4 = SpillingKt.nullOutSpilledVariable(finalElement);
                                this.L$5 = SpillingKt.nullOutSpilledVariable(finalUrl);
                                this.L$6 = function1;
                                this.label = 2;
                                objNewExtractorLink = ExtractorApiKt.newExtractorLink(this.this$0.getName() + ' ' + label, this.this$0.getName() + ' ' + label, finalUrl, ExtractorApiKt.getINFER_TYPE(), new AnonymousClass1(this.this$0, null), (Continuation) this);
                                if (objNewExtractorLink == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                function2 = function1;
                                function2.invoke(objNewExtractorLink);
                            } else {
                                Log.INSTANCE.d("Error:", "No final link found at " + intermediateUrl);
                            }
                        }
                        return Unit.INSTANCE;
                    case 2:
                        function2 = (Function1) this.L$6;
                        ResultKt.throwOnFailure($result);
                        objNewExtractorLink = $result;
                        function2.invoke(objNewExtractorLink);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception e2) {
                e = e2;
            }
        }

        /* JADX INFO: renamed from: com.Netcinez.Netcinez$loadLinks$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Netcinez.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.Netcinez.Netcinez$loadLinks$2$1", f = "Netcinez.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ Netcinez this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Netcinez netcinez, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = netcinez;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
                return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $this$newExtractorLink.setReferer(this.this$0.getMainUrl());
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }
}
