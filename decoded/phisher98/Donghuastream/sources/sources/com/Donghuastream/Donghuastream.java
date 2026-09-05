package com.Donghuastream;

import com.fleeksoft.ksoup.Ksoup;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Donghuastream.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Donghuastream/classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\n\u0010&\u001a\u00020'*\u00020(J\f\u0010)\u001a\u00020\u0005*\u00020(H\u0002J\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020'0\u001c2\u0006\u0010+\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010,J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010,JF\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u000e2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000206042\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020604H\u0096@¢\u0006\u0002\u00109R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006:"}, d2 = {"Lcom/Donghuastream/Donghuastream;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "getImageAttr", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Donghuastream"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDonghuastream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Donghuastream.kt\ncom/Donghuastream/Donghuastream\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,191:1\n1795#2,10:192\n2068#2:202\n2069#2:204\n1805#2:205\n1795#2,10:206\n2068#2:216\n2069#2:218\n1805#2:219\n1739#2:220\n1814#2,3:221\n1#3:203\n1#3:217\n*S KotlinDebug\n*F\n+ 1 Donghuastream.kt\ncom/Donghuastream/Donghuastream\n*L\n49#1:192,10\n49#1:202\n49#1:204\n49#1:205\n85#1:206,10\n85#1:216\n85#1:218\n85#1:219\n110#1:220\n110#1:221,3\n49#1:203\n85#1:217\n*E\n"})
public class Donghuastream extends MainAPI {

    @NotNull
    private String mainUrl = "https://donghuastream.org";

    @NotNull
    private String name = "Donghuastream";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "zh";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Anime);

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("anime/?status=&type=&order=update&page=", "Recently Updated"), TuplesKt.to("anime/?status=completed&type=&order=update", "Completed"), TuplesKt.to("anime/?status=&type=special&sub=&order=update", "Special Anime")});

    /* JADX INFO: renamed from: com.Donghuastream.Donghuastream$getMainPage$1 */
    /* JADX INFO: compiled from: Donghuastream.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Donghuastream.Donghuastream", f = "Donghuastream.kt", i = {0, 0, 0}, l = {48}, m = "getMainPage$suspendImpl", n = {"$this", "request", "page"}, nl = {49}, s = {"L$0", "L$1", "I$0"}, v = 2)
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
            return Donghuastream.getMainPage$suspendImpl(Donghuastream.this, 0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Donghuastream.Donghuastream$load$1 */
    /* JADX INFO: compiled from: Donghuastream.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Donghuastream.Donghuastream", f = "Donghuastream.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {100, 109, 125, 134}, m = "load$suspendImpl", n = {"$this", "url", "$this", "url", "document", "title", "href", "poster", "description", "type", "tvtag", "Eppage", "$this", "url", "document", "title", "href", "poster", "description", "type", "tvtag", "Eppage", "doc", "episodes", "$this", "url", "document", "title", "href", "poster", "description", "type", "tvtag"}, nl = {101, 110, 130, 107}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
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
            return Donghuastream.load$suspendImpl(Donghuastream.this, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Donghuastream.Donghuastream$loadLinks$1 */
    /* JADX INFO: compiled from: Donghuastream.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Donghuastream.Donghuastream", f = "Donghuastream.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {147, 151}, m = "loadLinks$suspendImpl", n = {"$this", "data", "subtitleCallback", "callback", "isCasting", "$this", "data", "subtitleCallback", "callback", "html", "options", "isCasting"}, nl = {149, 188}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
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
            return Donghuastream.loadLinks$suspendImpl(Donghuastream.this, null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Donghuastream.Donghuastream$search$1 */
    /* JADX INFO: compiled from: Donghuastream.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Donghuastream.Donghuastream", f = "Donghuastream.kt", i = {0, 0, 0, 0}, l = {83}, m = "search$suspendImpl", n = {"$this", "query", "searchResponse", "i"}, nl = {85}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Donghuastream.search$suspendImpl(Donghuastream.this, null, (Continuation) this);
        }
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
    static /* synthetic */ Object getMainPage$suspendImpl(Donghuastream $this, int page, MainPageRequest request, Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        boolean z;
        MainPageRequest request2;
        Donghuastream $this2 = $this;
        int page2 = page;
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
                Requests app = MainActivityKt.getApp();
                String str = $this2.getMainUrl() + '/' + request.getData() + page2;
                c00001.L$0 = $this2;
                c00001.L$1 = request;
                c00001.I$0 = page2;
                c00001.label = 1;
                z = true;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                page2 = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$1;
                $this2 = (Donghuastream) c00001.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.listupd > article");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            int page3 = page2;
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = $this2.toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
            page2 = page3;
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse(new HomePageList(request2.getName(), home, false), Boxing.boxBoolean(z));
    }

    @NotNull
    public final SearchResponse toSearchResult(@NotNull Element $this$toSearchResult) {
        String title = $this$toSearchResult.select("div.bsx > a").attr("title");
        String href = MainAPIKt.fixUrl(this, $this$toSearchResult.select("div.bsx > a").attr("href"));
        Donghuastream donghuastream = this;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("div.bsx a img");
        final String posterUrl = MainAPIKt.fixUrlNull(donghuastream, elementSelectFirst != null ? getImageAttr(elementSelectFirst) : null);
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.Donghuastream.Donghuastream$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return Donghuastream.toSearchResult$lambda$0(posterUrl, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    private final String getImageAttr(Element $this$getImageAttr) {
        if ($this$getImageAttr.hasAttr("data-src")) {
            return $this$getImageAttr.attr("data-src");
        }
        if ($this$getImageAttr.hasAttr("src")) {
            return $this$getImageAttr.attr("src");
        }
        return $this$getImageAttr.attr("src");
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0065  */
    /* JADX WARN: Code duplicated, block: B:18:0x00cd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:23:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:25:0x010f  */
    /* JADX WARN: Code duplicated, block: B:29:0x0128  */
    /* JADX WARN: Code duplicated, block: B:31:0x0134  */
    /* JADX WARN: Code duplicated, block: B:38:0x0114 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00ce -> B:20:0x00d5). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    static /* synthetic */ java.lang.Object search$suspendImpl(com.Donghuastream.Donghuastream r25, java.lang.String r26, kotlin.coroutines.Continuation<? super java.util.List<? extends com.lagradost.cloudstream3.SearchResponse>> r27) {
        /*
            Method dump skipped, instruction units count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.Donghuastream.Donghuastream.search$suspendImpl(com.Donghuastream.Donghuastream, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0468  */
    /* JADX WARN: Code duplicated, block: B:105:0x02eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x017b  */
    /* JADX WARN: Code duplicated, block: B:30:0x018e  */
    /* JADX WARN: Code duplicated, block: B:36:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:39:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:40:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:43:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:44:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:47:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:51:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:54:0x0263 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:55:0x0264  */
    /* JADX WARN: Code duplicated, block: B:59:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:61:0x02de  */
    /* JADX WARN: Code duplicated, block: B:64:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:69:0x0325  */
    /* JADX WARN: Code duplicated, block: B:70:0x0327  */
    /* JADX WARN: Code duplicated, block: B:72:0x032a  */
    /* JADX WARN: Code duplicated, block: B:74:0x0332  */
    /* JADX WARN: Code duplicated, block: B:77:0x0345  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x03b9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:82:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:84:0x03c9  */
    /* JADX WARN: Code duplicated, block: B:86:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:87:0x03eb  */
    /* JADX WARN: Code duplicated, block: B:89:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:94:0x0407  */
    /* JADX WARN: Code duplicated, block: B:96:0x040f  */
    /* JADX WARN: Code duplicated, block: B:99:0x0467 A[RETURN] */
    static /* synthetic */ Object load$suspendImpl(Donghuastream $this, String url, Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        Object obj;
        String str;
        String str2;
        String url2;
        String str3;
        String url3;
        Object obj2;
        Donghuastream $this2;
        Document document;
        Element elementSelectFirst;
        String string;
        String title;
        Element elementSelectFirst2;
        String strAttr;
        String href;
        Ref.ObjectRef poster;
        Element elementSelectFirst3;
        String string2;
        String description;
        Element elementSelectFirst4;
        String strText;
        String type;
        TvType tvtag;
        String url4;
        TvType tvtag2;
        String str4;
        boolean z;
        Document document2;
        String href2;
        Ref.ObjectRef poster2;
        String description2;
        Document document3;
        String type2;
        TvType tvtag3;
        String title2;
        String url5;
        Element elementSelectFirst5;
        String string3;
        String strAttr2;
        Element elementSelectFirst6;
        String Eppage;
        String url6;
        String url7;
        TvType tvtag4;
        Donghuastream $this3;
        String description3;
        Object obj3;
        String Eppage2;
        String href3;
        String type3;
        TvType tvtag5;
        final String Eppage3;
        String url8;
        Document document4;
        Ref.ObjectRef poster3;
        String title3;
        String strText2;
        String strText3;
        Iterable $this$map$iv;
        int $i$f$map;
        Collection destination$iv$iv;
        Iterable $this$mapTo$iv$iv;
        boolean z2;
        Object objNewTvSeriesLoadResponse;
        Element elementSelectFirst7;
        String string4;
        String strAttr3;
        Element elementSelectFirst8;
        String str5;
        final String posterr;
        if (continuation instanceof C00011) {
            c00011 = (C00011) continuation;
            if ((c00011.label & Integer.MIN_VALUE) != 0) {
                c00011.label -= Integer.MIN_VALUE;
            } else {
                c00011 = $this.new C00011(continuation);
            }
        } else {
            c00011 = $this.new C00011(continuation);
        }
        C00011 c00012 = c00011;
        Object $result = c00012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00012.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00012.L$0 = $this;
                c00012.L$1 = url;
                c00012.label = 1;
                obj = coroutine_suspended;
                str = "content";
                str2 = "meta[property=og:image]";
                url2 = "data-src";
                str3 = "href";
                Object obj4 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                c00012 = c00012;
                if (obj4 == obj) {
                    return obj;
                }
                url3 = url;
                obj2 = obj4;
                $this2 = $this;
                document = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document.selectFirst("h1.entry-title");
                if (elementSelectFirst != null || (strText3 = elementSelectFirst.text()) == null) {
                    string = null;
                } else {
                    string = StringsKt.trim(strText3).toString();
                }
                title = String.valueOf(string);
                elementSelectFirst2 = document.selectFirst(".eplister li > a");
                if (elementSelectFirst2 != null || (strAttr = elementSelectFirst2.attr(str3)) == null) {
                    strAttr = "";
                }
                href = strAttr;
                poster = new Ref.ObjectRef();
                poster.element = document.select("div.ime > img").attr(url2);
                elementSelectFirst3 = document.selectFirst("div.entry-content");
                if (elementSelectFirst3 != null || (strText2 = elementSelectFirst3.text()) == null) {
                    string2 = null;
                } else {
                    string2 = StringsKt.trim(strText2).toString();
                }
                description = string2;
                elementSelectFirst4 = document.selectFirst(".spe");
                if (elementSelectFirst4 != null) {
                    strText = elementSelectFirst4.text();
                } else {
                    strText = null;
                }
                type = String.valueOf(strText);
                if (StringsKt.contains$default(type, "Movie", false, 2, (Object) null)) {
                    tvtag = TvType.Movie;
                } else {
                    tvtag = TvType.TvSeries;
                }
                if (tvtag == TvType.TvSeries) {
                    Donghuastream $this4 = $this2;
                    url4 = url3;
                    tvtag2 = tvtag;
                    String str6 = str;
                    str4 = str2;
                    if (((CharSequence) poster.element).length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        document2 = document;
                        elementSelectFirst5 = document2.selectFirst(str4);
                        if (elementSelectFirst5 != null || (strAttr2 = elementSelectFirst5.attr(str6)) == null) {
                            string3 = null;
                        } else {
                            string3 = StringsKt.trim(strAttr2).toString();
                        }
                        poster.element = String.valueOf(string3);
                    } else {
                        document2 = document;
                    }
                    TvType tvType = TvType.Movie;
                    C00033 c00033 = new C00033(poster, description, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(document2);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(title);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(href);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(poster);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(description);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(type);
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(tvtag2);
                    c00012.label = 4;
                    href2 = href;
                    $result = MainAPIKt.newMovieLoadResponse($this4, title, url4, tvType, href2, c00033, c00012);
                    if ($result == obj) {
                        return obj;
                    }
                    poster2 = poster;
                    description2 = description;
                    document3 = document2;
                    type2 = type;
                    tvtag3 = tvtag2;
                    title2 = title;
                    url5 = url4;
                    return (LoadResponse) $result;
                }
                elementSelectFirst6 = document.selectFirst(".eplister li > a");
                if (elementSelectFirst6 != null || (Eppage = elementSelectFirst6.attr(str3)) == null) {
                    Eppage = "";
                }
                Requests app2 = MainActivityKt.getApp();
                c00012.L$0 = $this2;
                c00012.L$1 = url3;
                c00012.L$2 = document;
                c00012.L$3 = title;
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(href);
                c00012.L$5 = poster;
                c00012.L$6 = description;
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(type);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(tvtag);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(Eppage);
                c00012.label = 2;
                url6 = url3;
                url7 = Eppage;
                C00011 c00013 = c00012;
                tvtag4 = tvtag;
                $this3 = $this2;
                description3 = url2;
                obj3 = Requests.get$default(app2, url7, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                c00012 = c00013;
                if (obj3 == obj) {
                    return obj;
                }
                Eppage2 = url7;
                href3 = href;
                type3 = type;
                tvtag5 = tvtag4;
                Eppage3 = title;
                url8 = url6;
                document4 = document;
                poster3 = poster;
                title3 = description;
                Document doc = ((NiceResponse) obj3).getDocument();
                $this$map$iv = doc.select("div.episodelist > ul > li");
                $i$f$map = 0;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                $this$mapTo$iv$iv = $this$map$iv;
                for (Object item$iv$iv : $this$mapTo$iv$iv) {
                    Iterable $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                    Element info = (Element) item$iv$iv;
                    String url9 = url8;
                    String href1 = info.select("a").attr(str3);
                    String str7 = str3;
                    Iterable $this$map$iv2 = $this$map$iv;
                    int $i$f$map2 = $i$f$map;
                    String Eppage4 = Eppage2;
                    final String episode = StringsKt.substringBeforeLast$default(StringsKt.substringAfter$default(info.select("a span").text(), "-", (String) null, 2, (Object) null), "-", (String) null, 2, (Object) null);
                    elementSelectFirst8 = info.selectFirst("a img");
                    if (elementSelectFirst8 != null) {
                        str5 = description3;
                        posterr = elementSelectFirst8.attr(str5);
                        if (posterr == null) {
                        }
                        destination$iv$iv.add(MainAPIKt.newEpisode($this3, href1, new Function1() { // from class: com.Donghuastream.Donghuastream$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj5) {
                                return Donghuastream.load$lambda$0$0(episode, Eppage3, posterr, (Episode) obj5);
                            }
                        }));
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                        description3 = str5;
                        Eppage2 = Eppage4;
                        url8 = url9;
                        $this$map$iv = $this$map$iv2;
                        str3 = str7;
                        $i$f$map = $i$f$map2;
                    } else {
                        str5 = description3;
                    }
                    posterr = "";
                    destination$iv$iv.add(MainAPIKt.newEpisode($this3, href1, new Function1() { // from class: com.Donghuastream.Donghuastream$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj5) {
                            return Donghuastream.load$lambda$0$0(episode, Eppage3, posterr, (Episode) obj5);
                        }
                    }));
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                    description3 = str5;
                    Eppage2 = Eppage4;
                    url8 = url9;
                    $this$map$iv = $this$map$iv2;
                    str3 = str7;
                    $i$f$map = $i$f$map2;
                }
                String url10 = url8;
                String Eppage5 = Eppage2;
                List episodes = (List) destination$iv$iv;
                if (((CharSequence) poster3.element).length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    elementSelectFirst7 = document4.selectFirst(str2);
                    if (elementSelectFirst7 != null || (strAttr3 = elementSelectFirst7.attr(str)) == null) {
                        string4 = null;
                    } else {
                        string4 = StringsKt.trim(strAttr3).toString();
                    }
                    poster3.element = String.valueOf(string4);
                }
                Document document5 = document4;
                TvType tvType2 = TvType.Anime;
                List listReversed = CollectionsKt.reversed(episodes);
                C00022 c00022 = new C00022(poster3, title3, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(url10);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(document5);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(Eppage3);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(href3);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(poster3);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(type3);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(tvtag5);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(Eppage5);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(doc);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodes);
                c00012.label = 3;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse($this3, Eppage3, url10, tvType2, listReversed, c00022, c00012);
                if (objNewTvSeriesLoadResponse == obj) {
                    return obj;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 1:
                String url11 = (String) c00012.L$1;
                Donghuastream $this5 = (Donghuastream) c00012.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this5;
                obj = coroutine_suspended;
                url3 = url11;
                str = "content";
                str2 = "meta[property=og:image]";
                url2 = "data-src";
                obj2 = $result;
                str3 = "href";
                document = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document.selectFirst("h1.entry-title");
                if (elementSelectFirst != null) {
                    string = null;
                } else {
                    string = null;
                }
                title = String.valueOf(string);
                elementSelectFirst2 = document.selectFirst(".eplister li > a");
                if (elementSelectFirst2 != null) {
                    strAttr = "";
                } else {
                    strAttr = "";
                }
                href = strAttr;
                poster = new Ref.ObjectRef();
                poster.element = document.select("div.ime > img").attr(url2);
                elementSelectFirst3 = document.selectFirst("div.entry-content");
                if (elementSelectFirst3 != null) {
                    string2 = null;
                } else {
                    string2 = null;
                }
                description = string2;
                elementSelectFirst4 = document.selectFirst(".spe");
                if (elementSelectFirst4 != null) {
                    strText = elementSelectFirst4.text();
                } else {
                    strText = null;
                }
                type = String.valueOf(strText);
                if (StringsKt.contains$default(type, "Movie", false, 2, (Object) null)) {
                    tvtag = TvType.Movie;
                } else {
                    tvtag = TvType.TvSeries;
                }
                if (tvtag == TvType.TvSeries) {
                    Donghuastream $this6 = $this2;
                    url4 = url3;
                    tvtag2 = tvtag;
                    String str8 = str;
                    str4 = str2;
                    if (((CharSequence) poster.element).length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        document2 = document;
                        elementSelectFirst5 = document2.selectFirst(str4);
                        if (elementSelectFirst5 != null) {
                            string3 = null;
                        } else {
                            string3 = null;
                        }
                        poster.element = String.valueOf(string3);
                    } else {
                        document2 = document;
                    }
                    TvType tvType3 = TvType.Movie;
                    C00033 c00034 = new C00033(poster, description, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable($this6);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(document2);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(title);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(href);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(poster);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(description);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(type);
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(tvtag2);
                    c00012.label = 4;
                    href2 = href;
                    $result = MainAPIKt.newMovieLoadResponse($this6, title, url4, tvType3, href2, c00034, c00012);
                    if ($result == obj) {
                        return obj;
                    }
                    poster2 = poster;
                    description2 = description;
                    document3 = document2;
                    type2 = type;
                    tvtag3 = tvtag2;
                    title2 = title;
                    url5 = url4;
                    return (LoadResponse) $result;
                }
                elementSelectFirst6 = document.selectFirst(".eplister li > a");
                if (elementSelectFirst6 != null) {
                    Eppage = "";
                } else {
                    Eppage = "";
                }
                Requests app3 = MainActivityKt.getApp();
                c00012.L$0 = $this2;
                c00012.L$1 = url3;
                c00012.L$2 = document;
                c00012.L$3 = title;
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(href);
                c00012.L$5 = poster;
                c00012.L$6 = description;
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(type);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(tvtag);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(Eppage);
                c00012.label = 2;
                url6 = url3;
                url7 = Eppage;
                C00011 c00014 = c00012;
                tvtag4 = tvtag;
                $this3 = $this2;
                description3 = url2;
                obj3 = Requests.get$default(app3, url7, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00014, 4094, (Object) null);
                c00012 = c00014;
                if (obj3 == obj) {
                    return obj;
                }
                Eppage2 = url7;
                href3 = href;
                type3 = type;
                tvtag5 = tvtag4;
                Eppage3 = title;
                url8 = url6;
                document4 = document;
                poster3 = poster;
                title3 = description;
                Document doc2 = ((NiceResponse) obj3).getDocument();
                $this$map$iv = doc2.select("div.episodelist > ul > li");
                $i$f$map = 0;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                $this$mapTo$iv$iv = $this$map$iv;
                while (r18.hasNext()) {
                    Iterable $this$mapTo$iv$iv3 = $this$mapTo$iv$iv;
                    Element info2 = (Element) item$iv$iv;
                    String url12 = url8;
                    String href4 = info2.select("a").attr(str3);
                    String str9 = str3;
                    Iterable $this$map$iv3 = $this$map$iv;
                    int $i$f$map3 = $i$f$map;
                    String Eppage6 = Eppage2;
                    final String episode2 = StringsKt.substringBeforeLast$default(StringsKt.substringAfter$default(info2.select("a span").text(), "-", (String) null, 2, (Object) null), "-", (String) null, 2, (Object) null);
                    elementSelectFirst8 = info2.selectFirst("a img");
                    if (elementSelectFirst8 != null) {
                        str5 = description3;
                        posterr = elementSelectFirst8.attr(str5);
                        if (posterr == null) {
                        }
                        destination$iv$iv.add(MainAPIKt.newEpisode($this3, href4, new Function1() { // from class: com.Donghuastream.Donghuastream$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj5) {
                                return Donghuastream.load$lambda$0$0(episode2, Eppage3, posterr, (Episode) obj5);
                            }
                        }));
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv3;
                        description3 = str5;
                        Eppage2 = Eppage6;
                        url8 = url12;
                        $this$map$iv = $this$map$iv3;
                        str3 = str9;
                        $i$f$map = $i$f$map3;
                    } else {
                        str5 = description3;
                    }
                    posterr = "";
                    destination$iv$iv.add(MainAPIKt.newEpisode($this3, href4, new Function1() { // from class: com.Donghuastream.Donghuastream$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj5) {
                            return Donghuastream.load$lambda$0$0(episode2, Eppage3, posterr, (Episode) obj5);
                        }
                    }));
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv3;
                    description3 = str5;
                    Eppage2 = Eppage6;
                    url8 = url12;
                    $this$map$iv = $this$map$iv3;
                    str3 = str9;
                    $i$f$map = $i$f$map3;
                }
                String url13 = url8;
                String Eppage7 = Eppage2;
                List episodes2 = (List) destination$iv$iv;
                if (((CharSequence) poster3.element).length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    elementSelectFirst7 = document4.selectFirst(str2);
                    if (elementSelectFirst7 != null) {
                        string4 = null;
                    } else {
                        string4 = null;
                    }
                    poster3.element = String.valueOf(string4);
                }
                Document document6 = document4;
                TvType tvType4 = TvType.Anime;
                List listReversed2 = CollectionsKt.reversed(episodes2);
                C00022 c00023 = new C00022(poster3, title3, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(url13);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(document6);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(Eppage3);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(href3);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(poster3);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(type3);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(tvtag5);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(Eppage7);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(doc2);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodes2);
                c00012.label = 3;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse($this3, Eppage3, url13, tvType4, listReversed2, c00023, c00012);
                if (objNewTvSeriesLoadResponse == obj) {
                    return obj;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 2:
                String Eppage8 = (String) c00012.L$9;
                tvtag5 = (TvType) c00012.L$8;
                type3 = (String) c00012.L$7;
                String description4 = (String) c00012.L$6;
                poster3 = (Ref.ObjectRef) c00012.L$5;
                href3 = (String) c00012.L$4;
                String title4 = (String) c00012.L$3;
                Document document7 = (Document) c00012.L$2;
                String url14 = (String) c00012.L$1;
                Donghuastream $this7 = (Donghuastream) c00012.L$0;
                ResultKt.throwOnFailure($result);
                $this3 = $this7;
                obj = coroutine_suspended;
                str = "content";
                str2 = "meta[property=og:image]";
                description3 = "data-src";
                document4 = document7;
                url8 = url14;
                obj3 = $result;
                str3 = "href";
                Eppage2 = Eppage8;
                Eppage3 = title4;
                title3 = description4;
                Document doc3 = ((NiceResponse) obj3).getDocument();
                $this$map$iv = doc3.select("div.episodelist > ul > li");
                $i$f$map = 0;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                $this$mapTo$iv$iv = $this$map$iv;
                while (r18.hasNext()) {
                    Iterable $this$mapTo$iv$iv4 = $this$mapTo$iv$iv;
                    Element info3 = (Element) item$iv$iv;
                    String url15 = url8;
                    String href5 = info3.select("a").attr(str3);
                    String str10 = str3;
                    Iterable $this$map$iv4 = $this$map$iv;
                    int $i$f$map4 = $i$f$map;
                    String Eppage9 = Eppage2;
                    final String episode3 = StringsKt.substringBeforeLast$default(StringsKt.substringAfter$default(info3.select("a span").text(), "-", (String) null, 2, (Object) null), "-", (String) null, 2, (Object) null);
                    elementSelectFirst8 = info3.selectFirst("a img");
                    if (elementSelectFirst8 != null) {
                        str5 = description3;
                        posterr = elementSelectFirst8.attr(str5);
                        if (posterr == null) {
                        }
                        destination$iv$iv.add(MainAPIKt.newEpisode($this3, href5, new Function1() { // from class: com.Donghuastream.Donghuastream$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj5) {
                                return Donghuastream.load$lambda$0$0(episode3, Eppage3, posterr, (Episode) obj5);
                            }
                        }));
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv4;
                        description3 = str5;
                        Eppage2 = Eppage9;
                        url8 = url15;
                        $this$map$iv = $this$map$iv4;
                        str3 = str10;
                        $i$f$map = $i$f$map4;
                    } else {
                        str5 = description3;
                    }
                    posterr = "";
                    destination$iv$iv.add(MainAPIKt.newEpisode($this3, href5, new Function1() { // from class: com.Donghuastream.Donghuastream$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj5) {
                            return Donghuastream.load$lambda$0$0(episode3, Eppage3, posterr, (Episode) obj5);
                        }
                    }));
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv4;
                    description3 = str5;
                    Eppage2 = Eppage9;
                    url8 = url15;
                    $this$map$iv = $this$map$iv4;
                    str3 = str10;
                    $i$f$map = $i$f$map4;
                }
                String url16 = url8;
                String Eppage10 = Eppage2;
                List episodes3 = (List) destination$iv$iv;
                if (((CharSequence) poster3.element).length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    elementSelectFirst7 = document4.selectFirst(str2);
                    if (elementSelectFirst7 != null) {
                        string4 = null;
                    } else {
                        string4 = null;
                    }
                    poster3.element = String.valueOf(string4);
                }
                Document document8 = document4;
                TvType tvType5 = TvType.Anime;
                List listReversed3 = CollectionsKt.reversed(episodes3);
                C00022 c00024 = new C00022(poster3, title3, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(url16);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(document8);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(Eppage3);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(href3);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(poster3);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(title3);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(type3);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(tvtag5);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(Eppage10);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(doc3);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodes3);
                c00012.label = 3;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse($this3, Eppage3, url16, tvType5, listReversed3, c00024, c00012);
                if (objNewTvSeriesLoadResponse == obj) {
                    return obj;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 3:
                ResultKt.throwOnFailure($result);
                objNewTvSeriesLoadResponse = $result;
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 4:
                tvtag3 = (TvType) c00012.L$8;
                type2 = (String) c00012.L$7;
                description2 = (String) c00012.L$6;
                poster2 = (Ref.ObjectRef) c00012.L$5;
                href2 = (String) c00012.L$4;
                title2 = (String) c00012.L$3;
                document3 = (Document) c00012.L$2;
                url5 = (String) c00012.L$1;
                ResultKt.throwOnFailure($result);
                return (LoadResponse) $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$0$0(String $episode, String $title, String $posterr, Episode $this$newEpisode) {
        $this$newEpisode.setName(StringsKt.replace($episode, $title, "", true));
        $this$newEpisode.setEpisode(StringsKt.toIntOrNull($episode));
        $this$newEpisode.setPosterUrl($posterr);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.Donghuastream.Donghuastream$load$2 */
    /* JADX INFO: compiled from: Donghuastream.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Donghuastream.Donghuastream$load$2", f = "Donghuastream.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00022 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ Ref.ObjectRef<String> $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00022(Ref.ObjectRef<String> objectRef, String str, Continuation<? super C00022> continuation) {
            super(2, continuation);
            this.$poster = objectRef;
            this.$description = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00022 = new C00022(this.$poster, this.$description, continuation);
            c00022.L$0 = obj;
            return c00022;
        }

        public final Object invoke(TvSeriesLoadResponse tvSeriesLoadResponse, Continuation<? super Unit> continuation) {
            return create(tvSeriesLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            TvSeriesLoadResponse $this$newTvSeriesLoadResponse = (TvSeriesLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newTvSeriesLoadResponse.setPosterUrl((String) this.$poster.element);
                    $this$newTvSeriesLoadResponse.setPlot(this.$description);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.Donghuastream.Donghuastream$load$3 */
    /* JADX INFO: compiled from: Donghuastream.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Donghuastream.Donghuastream$load$3", f = "Donghuastream.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00033 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ Ref.ObjectRef<String> $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00033(Ref.ObjectRef<String> objectRef, String str, Continuation<? super C00033> continuation) {
            super(2, continuation);
            this.$poster = objectRef;
            this.$description = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00033 = new C00033(this.$poster, this.$description, continuation);
            c00033.L$0 = obj;
            return c00033;
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
                    $this$newMovieLoadResponse.setPosterUrl((String) this.$poster.element);
                    $this$newMovieLoadResponse.setPlot(this.$description);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x011e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x011f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object loadLinks$suspendImpl(Donghuastream $this, String data, boolean isCasting, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Boolean> continuation) {
        C00041 c00041;
        Donghuastream $this2;
        Object obj;
        boolean z;
        C00041 c00042;
        String data2;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        List listSelect;
        C00052 c00052;
        if (continuation instanceof C00041) {
            c00041 = (C00041) continuation;
            if ((c00041.label & Integer.MIN_VALUE) != 0) {
                c00041.label -= Integer.MIN_VALUE;
                $this2 = $this;
            } else {
                $this2 = $this;
                c00041 = $this2.new C00041(continuation);
            }
        } else {
            $this2 = $this;
            c00041 = $this2.new C00041(continuation);
        }
        Object $result = c00041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00041.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00041.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00041.L$1 = SpillingKt.nullOutSpilledVariable(data);
                c00041.L$2 = function1;
                c00041.L$3 = function2;
                c00041.Z$0 = isCasting;
                c00041.label = 1;
                C00041 c00043 = c00041;
                obj = coroutine_suspended;
                z = true;
                $result = Requests.get$default(app, data, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00043, 4094, (Object) null);
                c00042 = c00043;
                if ($result == obj) {
                    return obj;
                }
                data2 = data;
                isCasting2 = isCasting;
                function3 = function1;
                function4 = function2;
                Document html = ((NiceResponse) $result).getDocument();
                listSelect = html.select("option[data-index]");
                c00052 = new C00052(function3, function4, null);
                c00042.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                c00042.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00042.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c00042.L$4 = SpillingKt.nullOutSpilledVariable(html);
                c00042.L$5 = SpillingKt.nullOutSpilledVariable(listSelect);
                c00042.Z$0 = isCasting2;
                c00042.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00052, c00042) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 1:
                isCasting2 = c00041.Z$0;
                function4 = (Function1) c00041.L$3;
                function3 = (Function1) c00041.L$2;
                data2 = (String) c00041.L$1;
                $this2 = (Donghuastream) c00041.L$0;
                ResultKt.throwOnFailure($result);
                c00042 = c00041;
                obj = coroutine_suspended;
                z = true;
                Document html2 = ((NiceResponse) $result).getDocument();
                listSelect = html2.select("option[data-index]");
                c00052 = new C00052(function3, function4, null);
                c00042.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                c00042.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                c00042.L$3 = SpillingKt.nullOutSpilledVariable(function4);
                c00042.L$4 = SpillingKt.nullOutSpilledVariable(html2);
                c00042.L$5 = SpillingKt.nullOutSpilledVariable(listSelect);
                c00042.Z$0 = isCasting2;
                c00042.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00052, c00042) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 2:
                boolean z2 = c00041.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.Donghuastream.Donghuastream$loadLinks$2 */
    /* JADX INFO: compiled from: Donghuastream.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "option", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Donghuastream.Donghuastream$loadLinks$2", f = "Donghuastream.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {167, 171, 183}, m = "invokeSuspend", n = {"option", "base64", "label", "decodedHtml", "iframeUrl", "cleanedUrl", "option", "base64", "label", "decodedHtml", "iframeUrl", "option", "base64", "label", "decodedHtml", "iframeUrl"}, nl = {169, 170, 186}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    @SourceDebugExtension({"SMAP\nDonghuastream.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Donghuastream.kt\ncom/Donghuastream/Donghuastream$loadLinks$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,191:1\n1#2:192\n*E\n"})
    static final class C00052 extends SuspendLambda implements Function2<Element, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00052(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00052> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00052 = new C00052(this.$subtitleCallback, this.$callback, continuation);
            c00052.L$0 = obj;
            return c00052;
        }

        public final Object invoke(Element element, Continuation<? super Unit> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String base64;
            String base65;
            Function1<ExtractorLink, Unit> function1;
            Object obj;
            String decodedHtml;
            String decodedHtml2;
            String p0;
            Element option = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String base66 = option.attr("value");
                    if (StringsKt.isBlank(base66)) {
                        return Unit.INSTANCE;
                    }
                    base64 = StringsKt.trim(option.text()).toString();
                    try {
                        String decodedHtml3 = MainAPIKt.base64Decode(base66);
                        com.fleeksoft.ksoup.nodes.Element elementSelectFirst = Ksoup.parse$default(Ksoup.INSTANCE, decodedHtml3, (String) null, 2, (Object) null).selectFirst("iframe");
                        String p1 = (elementSelectFirst == null || (p0 = elementSelectFirst.attr("src")) == null) ? null : ExtractorApiKt.httpsify(p0);
                        String str = p1;
                        if (str == null || str.length() == 0) {
                            return Unit.INSTANCE;
                        }
                        if (StringsKt.contains$default(p1, "vidmoly", false, 2, (Object) null)) {
                            String cleanedUrl = "http:" + StringsKt.substringBefore$default(StringsKt.substringAfter$default(p1, "=\"", (String) null, 2, (Object) null), "\"", (String) null, 2, (Object) null);
                            this.L$0 = SpillingKt.nullOutSpilledVariable(option);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(base66);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(base64);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(decodedHtml3);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(p1);
                            this.L$5 = SpillingKt.nullOutSpilledVariable(cleanedUrl);
                            this.label = 1;
                            if (ExtractorApiKt.loadExtractor(cleanedUrl, p1, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else if (StringsKt.endsWith$default(p1, ".mp4", false, 2, (Object) null)) {
                            Function1<ExtractorLink, Unit> function2 = this.$callback;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(option);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(base66);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(base64);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(decodedHtml3);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(p1);
                            this.L$5 = function2;
                            this.label = 2;
                            String iframeUrl = p1;
                            Object objNewExtractorLink = ExtractorApiKt.newExtractorLink(base64, base64, iframeUrl, ExtractorApiKt.getINFER_TYPE(), new AnonymousClass1(base64, null), (Continuation) this);
                            if (objNewExtractorLink == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            base65 = base66;
                            function1 = function2;
                            obj = objNewExtractorLink;
                            decodedHtml = decodedHtml3;
                            decodedHtml2 = iframeUrl;
                            function1.invoke(obj);
                            Unit unit = Unit.INSTANCE;
                        } else {
                            String iframeUrl2 = p1;
                            this.L$0 = SpillingKt.nullOutSpilledVariable(option);
                            this.L$1 = SpillingKt.nullOutSpilledVariable(base66);
                            this.L$2 = SpillingKt.nullOutSpilledVariable(base64);
                            this.L$3 = SpillingKt.nullOutSpilledVariable(decodedHtml3);
                            this.L$4 = SpillingKt.nullOutSpilledVariable(iframeUrl2);
                            this.label = 3;
                            if (ExtractorApiKt.loadExtractor(iframeUrl2, iframeUrl2, this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    } catch (Exception e) {
                        Log.INSTANCE.w("Error", "Base64 decode failed: " + base66);
                        return Unit.INSTANCE;
                    }
                case 1:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                case 2:
                    function1 = (Function1) this.L$5;
                    decodedHtml2 = (String) this.L$4;
                    decodedHtml = (String) this.L$3;
                    String label = (String) this.L$2;
                    String base67 = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    base65 = base67;
                    base64 = label;
                    obj = $result;
                    function1.invoke(obj);
                    Unit unit2 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                case 3:
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.Donghuastream.Donghuastream$loadLinks$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: Donghuastream.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.Donghuastream.Donghuastream$loadLinks$2$1", f = "Donghuastream.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $label;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$label = str;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$label, continuation);
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
                        $this$newExtractorLink.setReferer("");
                        $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(this.$label));
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }
}
