package com.ToonTales;

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
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
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

/* JADX INFO: compiled from: ToonTales.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/ToonTales/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\f\u0010&\u001a\u00020'*\u00020(H\u0002J\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020'0\u001c2\u0006\u0010*\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+J\u0016\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+JF\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u000e2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205032\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020503H\u0096@¢\u0006\u0002\u00108R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00069"}, d2 = {"Lcom/ToonTales/ToonTales;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ToonTales"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nToonTales.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ToonTales.kt\ncom/ToonTales/ToonTales\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,97:1\n1795#2,10:98\n2068#2:108\n2069#2:110\n1805#2:111\n1795#2,10:112\n2068#2:122\n2069#2:124\n1805#2:125\n1#3:109\n1#3:123\n*S KotlinDebug\n*F\n+ 1 ToonTales.kt\ncom/ToonTales/ToonTales\n*L\n26#1:98,10\n26#1:108\n26#1:110\n26#1:111\n53#1:112,10\n53#1:122\n53#1:124\n53#1:125\n26#1:109\n53#1:123\n*E\n"})
public final class ToonTales extends MainAPI {

    @NotNull
    private String mainUrl = "https://www.toontales.net";

    @NotNull
    private String name = "ToonTales";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "en";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Cartoon);

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("series/popeye-the-sailor/", " Popeye the Sailor"), TuplesKt.to("series/the-pink-panther-show", "The Pink Panther Show"), TuplesKt.to("series/tom-and-jerry", "Tom and Jerry"), TuplesKt.to("series/disney", "Disney"), TuplesKt.to("series/looney-tunes", "Looney Tunes"), TuplesKt.to("series/merrie-melodies", "Merrie Melodies")});

    /* JADX INFO: renamed from: com.ToonTales.ToonTales$getMainPage$1 */
    /* JADX INFO: compiled from: ToonTales.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.ToonTales.ToonTales", f = "ToonTales.kt", i = {0, 0}, l = {25}, m = "getMainPage", n = {"request", "page"}, nl = {26}, s = {"L$0", "I$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ToonTales.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.ToonTales.ToonTales$load$1 */
    /* JADX INFO: compiled from: ToonTales.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.ToonTales.ToonTales", f = "ToonTales.kt", i = {0, 1, 1, 1, 1, 1}, l = {69, 73}, m = "load", n = {"url", "url", "document", "title", "poster", "description"}, nl = {70, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
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
            return ToonTales.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.ToonTales.ToonTales$loadLinks$1 */
    /* JADX INFO: compiled from: ToonTales.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.ToonTales.ToonTales", f = "ToonTales.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {80, 84}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "document", "file", "isCasting"}, nl = {81, 83}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
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
            return ToonTales.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.ToonTales.ToonTales$search$1 */
    /* JADX INFO: compiled from: ToonTales.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.ToonTales.ToonTales", f = "ToonTales.kt", i = {0, 0, 0}, l = {51}, m = "search", n = {"query", "searchResponse", "i"}, nl = {53}, s = {"L$0", "L$1", "I$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ToonTales.this.search(null, (Continuation) this);
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

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
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
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + '/' + request.getData() + "/?page=" + page;
                c00001.L$0 = request;
                c00001.I$0 = page;
                c00001.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4094, (Object) null);
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
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("section > div.item");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse(new HomePageList(request2.getName(), home, true), Boxing.boxBoolean(true));
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String title = $this$toSearchResult.select("a > img").attr("alt");
        String href = MainAPIKt.fixUrl(this, $this$toSearchResult.select("a").attr("href"));
        final String posterUrl = MainAPIKt.fixUrlNull(this, $this$toSearchResult.select("a > img").attr("src"));
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.ToonTales.ToonTales$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return ToonTales.toSearchResult$lambda$0(posterUrl, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0063  */
    /* JADX WARN: Code duplicated, block: B:18:0x00c9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:23:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:25:0x010d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0126  */
    /* JADX WARN: Code duplicated, block: B:31:0x0132  */
    /* JADX WARN: Code duplicated, block: B:38:0x0112 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00ca -> B:20:0x00d3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object search(@org.jetbrains.annotations.NotNull java.lang.String r27, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r28) {
        /*
            Method dump skipped, instruction units count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ToonTales.ToonTales.search(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        Object obj;
        Object obj2;
        String url2;
        String strAttr;
        String strAttr2;
        String strAttr3;
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
        switch (c00012.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00012.L$0 = url;
                c00012.label = 1;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, url, (Map) null, url, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4090, (Object) null);
                c00012 = c00012;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                break;
                break;
            case 1:
                String url3 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                url2 = url3;
                obj2 = $result;
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) obj2).getDocument();
        Element elementSelectFirst = document.selectFirst("meta[property=og:title]");
        String title = String.valueOf((elementSelectFirst == null || (strAttr3 = elementSelectFirst.attr("content")) == null) ? null : StringsKt.trim(strAttr3).toString());
        Element elementSelectFirst2 = document.selectFirst("meta[property=og:image]");
        String poster = String.valueOf((elementSelectFirst2 == null || (strAttr2 = elementSelectFirst2.attr("content")) == null) ? null : StringsKt.trim(strAttr2).toString());
        Element elementSelectFirst3 = document.selectFirst("meta[property=og:description]");
        String description = String.valueOf((elementSelectFirst3 == null || (strAttr = elementSelectFirst3.attr("content")) == null) ? null : StringsKt.trim(strAttr).toString());
        TvType tvType = TvType.Movie;
        C00022 c00022 = new C00022(poster, description, null);
        c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
        c00012.L$1 = SpillingKt.nullOutSpilledVariable(document);
        c00012.L$2 = SpillingKt.nullOutSpilledVariable(title);
        c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster);
        c00012.L$4 = SpillingKt.nullOutSpilledVariable(description);
        c00012.label = 2;
        Object objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title, url2, tvType, url2, c00022, c00012);
        if (objNewMovieLoadResponse == obj) {
            return obj;
        }
        return objNewMovieLoadResponse;
    }

    /* JADX INFO: renamed from: com.ToonTales.ToonTales$load$2 */
    /* JADX INFO: compiled from: ToonTales.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.ToonTales.ToonTales$load$2", f = "ToonTales.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00022 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00022(String str, String str2, Continuation<? super C00022> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$description = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00022 = new C00022(this.$poster, this.$description, continuation);
            c00022.L$0 = obj;
            return c00022;
        }

        public final Object invoke(MovieLoadResponse movieLoadResponse, Continuation<? super Unit> continuation) {
            return create(movieLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            MovieLoadResponse $this$newMovieLoadResponse = (MovieLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newMovieLoadResponse.setPosterUrl(this.$poster);
                    $this$newMovieLoadResponse.setPlot(this.$description);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:21:0x00db  */
    /* JADX WARN: Code duplicated, block: B:24:0x0136 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0137  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00031 c00031;
        ToonTales toonTales;
        boolean z;
        Object obj;
        Object obj2;
        String data2;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        Element elementSelectFirst;
        String strData;
        Object objNewExtractorLink;
        Function1<? super ExtractorLink, Unit> function5;
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
                toonTales = this;
            } else {
                toonTales = this;
                c00031 = toonTales.new C00031(continuation);
            }
        } else {
            toonTales = this;
            c00031 = toonTales.new C00031(continuation);
        }
        C00031 c00032 = c00031;
        Object $result = c00032.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00032.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00032.L$2 = function2;
                c00032.Z$0 = isCasting;
                c00032.label = 1;
                z = true;
                obj = coroutine_suspended;
                obj2 = Requests.get$default(app, data, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00032, 4094, (Object) null);
                c00032 = c00032;
                if (obj2 == obj) {
                    return obj;
                }
                data2 = data;
                isCasting2 = isCasting;
                function3 = function1;
                function4 = function2;
                Document document = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document.selectFirst("script:containsData(file)");
                if (elementSelectFirst != null) {
                    strData = elementSelectFirst.data();
                } else {
                    strData = null;
                }
                String file = StringsKt.substringBefore$default(StringsKt.substringAfter$default(String.valueOf(strData), "file: \"", (String) null, 2, (Object) null), "\"", (String) null, 2, (Object) null);
                String name = toonTales.getName();
                String name2 = toonTales.getName();
                ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                C00042 c00042 = new C00042(null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(document);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(file);
                c00032.L$5 = function4;
                c00032.Z$0 = isCasting2;
                c00032.label = 2;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name2, name, file, infer_type, c00042, c00032);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function5 = function4;
                function5.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(z);
            case 1:
                boolean isCasting3 = c00032.Z$0;
                Function1<? super ExtractorLink, Unit> function6 = (Function1) c00032.L$2;
                Function1<? super SubtitleFile, Unit> function7 = (Function1) c00032.L$1;
                data2 = (String) c00032.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                isCasting2 = isCasting3;
                function4 = function6;
                function3 = function7;
                z = true;
                obj2 = $result;
                Document document2 = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document2.selectFirst("script:containsData(file)");
                if (elementSelectFirst != null) {
                    strData = elementSelectFirst.data();
                } else {
                    strData = null;
                }
                String file2 = StringsKt.substringBefore$default(StringsKt.substringAfter$default(String.valueOf(strData), "file: \"", (String) null, 2, (Object) null), "\"", (String) null, 2, (Object) null);
                String name3 = toonTales.getName();
                String name4 = toonTales.getName();
                ExtractorLinkType infer_type2 = ExtractorApiKt.getINFER_TYPE();
                C00042 c00043 = new C00042(null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(document2);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(file2);
                c00032.L$5 = function4;
                c00032.Z$0 = isCasting2;
                c00032.label = 2;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name4, name3, file2, infer_type2, c00043, c00032);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function5 = function4;
                function5.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(z);
            case 2:
                boolean z2 = c00032.Z$0;
                function5 = (Function1) c00032.L$5;
                ResultKt.throwOnFailure($result);
                z = true;
                objNewExtractorLink = $result;
                function5.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ToonTales.ToonTales$loadLinks$2 */
    /* JADX INFO: compiled from: ToonTales.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.ToonTales.ToonTales$loadLinks$2", f = "ToonTales.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00042 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00042(Continuation<? super C00042> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = new C00042(continuation);
            c00042.L$0 = obj;
            return c00042;
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
                    $this$newExtractorLink.setReferer("");
                    $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(""));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
