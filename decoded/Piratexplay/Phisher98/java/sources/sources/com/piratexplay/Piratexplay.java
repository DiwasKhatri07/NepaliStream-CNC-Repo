package com.piratexplay;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SearchResponseList;
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

/* JADX INFO: compiled from: Piratexplay.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Piratexplay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u0004\u0018\u00010'*\u00020(H\u0002J\u001e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010,J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00100JF\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u000e2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u000207052\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020705H\u0096@¢\u0006\u0002\u0010:J\f\u0010;\u001a\u00020\u0005*\u00020(H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006<"}, d2 = {"Lcom/piratexplay/Piratexplay;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImageAttr", "Piratexplay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPiratexplay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Piratexplay.kt\ncom/piratexplay/Piratexplay\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,153:1\n1544#2:154\n1633#2,2:155\n1795#2,10:157\n2068#2:167\n2069#2:169\n1805#2:170\n1635#2,3:171\n1795#2,10:174\n2068#2:184\n2069#2:186\n1805#2:187\n1739#2:188\n1814#2,3:189\n1795#2,10:192\n2068#2:202\n2069#2:204\n1805#2:205\n1739#2:206\n1814#2,3:207\n1544#2:210\n1633#2,2:211\n1739#2:213\n1814#2,2:214\n1739#2:216\n1814#2,3:217\n1816#2:221\n1635#2,3:222\n1#3:168\n1#3:185\n1#3:203\n1#3:220\n*S KotlinDebug\n*F\n+ 1 Piratexplay.kt\ncom/piratexplay/Piratexplay\n*L\n51#1:154\n51#1:155,2\n55#1:157,10\n55#1:167\n55#1:169\n55#1:170\n51#1:171,3\n69#1:174,10\n69#1:184\n69#1:186\n69#1:187\n77#1:188\n77#1:189,3\n81#1:192,10\n81#1:202\n81#1:204\n81#1:205\n86#1:206\n86#1:207,3\n88#1:210\n88#1:211,2\n91#1:213\n91#1:214,2\n95#1:216\n95#1:217,3\n91#1:221\n88#1:222,3\n55#1:168\n69#1:185\n81#1:203\n*E\n"})
public final class Piratexplay extends MainAPI {

    @NotNull
    private String mainUrl = "https://piratexplay.cc";

    @NotNull
    private String name = "Piratexplay";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "hi";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.AnimeMovie, TvType.Anime, TvType.Cartoon});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("category/popular", "Popular"), TuplesKt.to("category/top-airing", "Top Airing"), TuplesKt.to("category/ongoing", "OnGoing"), TuplesKt.to("category/series", "Series"), TuplesKt.to("category/movies", "Movies"), TuplesKt.to("category/anime", "Anime"), TuplesKt.to("category/cartoon", "Cartoon")});

    /* JADX INFO: renamed from: com.piratexplay.Piratexplay$getMainPage$1 */
    /* JADX INFO: compiled from: Piratexplay.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.piratexplay.Piratexplay", f = "Piratexplay.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {52}, m = "getMainPage", n = {"request", "$this$flatMap$iv", "$this$flatMapTo$iv$iv", "destination$iv$iv", "element$iv$iv", "page", "p"}, nl = {53}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "I$0", "I$1"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Piratexplay.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.piratexplay.Piratexplay$load$1 */
    /* JADX INFO: compiled from: Piratexplay.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.piratexplay.Piratexplay", f = "Piratexplay.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {73, 89, 110, 119}, m = "load", n = {"url", "url", "document", "title", "poster", "backgroundposter", "tags", "year", "tvType", "description", "recommendations", "seasonLinks", "$this$flatMap$iv", "$this$flatMapTo$iv$iv", "destination$iv$iv", "element$iv$iv", "seasonUrl", "url", "document", "title", "poster", "backgroundposter", "tags", "year", "tvType", "description", "recommendations", "seasonLinks", "episodes", "url", "document", "title", "poster", "backgroundposter", "tags", "year", "tvType", "description", "recommendations"}, nl = {74, 91, 119, 82}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$15", "L$16", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9"}, v = 2)
    static final class C00091 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
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

        C00091(Continuation<? super C00091> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Piratexplay.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.piratexplay.Piratexplay$loadLinks$1 */
    /* JADX INFO: compiled from: Piratexplay.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.piratexplay.Piratexplay", f = "Piratexplay.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {135, 136}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "document", "isCasting"}, nl = {136, 141}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00121 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00121(Continuation<? super C00121> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Piratexplay.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.piratexplay.Piratexplay$search$1 */
    /* JADX INFO: compiled from: Piratexplay.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.piratexplay.Piratexplay", f = "Piratexplay.kt", i = {0, 0}, l = {68}, m = "search", n = {"query", "page"}, nl = {69}, s = {"L$0", "I$0"}, v = 2)
    static final class C00141 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00141(Continuation<? super C00141> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Piratexplay.this.search(null, 0, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:16:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:18:0x0137 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:19:0x0138  */
    /* JADX WARN: Code duplicated, block: B:23:0x016f  */
    /* JADX WARN: Code duplicated, block: B:25:0x0185  */
    /* JADX WARN: Code duplicated, block: B:26:0x018f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0138 -> B:20:0x0144). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getMainPage(int r36, @org.jetbrains.annotations.NotNull com.lagradost.cloudstream3.MainPageRequest r37, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.HomePageResponse> r38) {
        /*
            Method dump skipped, instruction units count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.piratexplay.Piratexplay.getMainPage(int, com.lagradost.cloudstream3.MainPageRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String strText;
        String title;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("header h2");
        if (elementSelectFirst == null || (strText = elementSelectFirst.text()) == null || (title = StringsKt.trim(strText).toString()) == null) {
            return null;
        }
        Piratexplay piratexplay = this;
        Element elementSelectFirst2 = $this$toSearchResult.selectFirst("a");
        String href = MainAPIKt.fixUrl(piratexplay, String.valueOf(elementSelectFirst2 != null ? elementSelectFirst2.attr("href") : null));
        Piratexplay piratexplay2 = this;
        Element elementSelectFirst3 = $this$toSearchResult.selectFirst("img");
        final String posterUrl = MainAPIKt.fixUrlNull(piratexplay2, elementSelectFirst3 != null ? getImageAttr(elementSelectFirst3) : null);
        return MainAPIKt.newMovieSearchResponse$default(this, title, href, TvType.Movie, false, new Function1() { // from class: com.piratexplay.Piratexplay$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return Piratexplay.toSearchResult$lambda$0(posterUrl, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) {
        C00141 c00141;
        if (continuation instanceof C00141) {
            c00141 = (C00141) continuation;
            if ((c00141.label & Integer.MIN_VALUE) != 0) {
                c00141.label -= Integer.MIN_VALUE;
            } else {
                c00141 = new C00141(continuation);
            }
        } else {
            c00141 = new C00141(continuation);
        }
        Object $result = c00141.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00141.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/?s=" + query + "&page=" + page;
                c00141.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00141.I$0 = page;
                c00141.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00141, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                int i = c00141.I$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("#movies-a ul li");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        return MainAPIKt.toNewSearchResponseList$default((List) destination$iv$iv, (Boolean) null, 1, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:116:0x04de A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x032f  */
    /* JADX WARN: Code duplicated, block: B:71:0x03bd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:72:0x03be  */
    /* JADX WARN: Code duplicated, block: B:76:0x0409  */
    /* JADX WARN: Code duplicated, block: B:78:0x041f  */
    /* JADX WARN: Code duplicated, block: B:79:0x0424  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:82:0x0429  */
    /* JADX WARN: Code duplicated, block: B:86:0x046b A[LOOP:1: B:84:0x0465->B:86:0x046b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:89:0x04a7  */
    /* JADX WARN: Code duplicated, block: B:90:0x04b0  */
    /* JADX WARN: Code duplicated, block: B:92:0x04b3  */
    /* JADX WARN: Code duplicated, block: B:95:0x04d4  */
    /* JADX WARN: Code duplicated, block: B:96:0x04d9  */
    /* JADX WARN: Code duplicated, block: B:98:0x04dc  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x03be -> B:73:0x03da). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r52, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r53) {
        /*
            Method dump skipped, instruction units count: 1608
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.piratexplay.Piratexplay.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$3$0$2(String $name, Integer $season, Integer $episode, Element $ep, Piratexplay this$0, Episode $this$newEpisode) {
        $this$newEpisode.setName($name);
        $this$newEpisode.setSeason($season);
        $this$newEpisode.setEpisode($episode);
        Element elementSelectFirst = $ep.selectFirst("div.post-thumbnail img");
        $this$newEpisode.setPosterUrl(elementSelectFirst != null ? this$0.getImageAttr(elementSelectFirst) : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.piratexplay.Piratexplay$load$2 */
    /* JADX INFO: compiled from: Piratexplay.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.piratexplay.Piratexplay$load$2", f = "Piratexplay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00102 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $backgroundposter;
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<SearchResponse> $recommendations;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00102(String str, String str2, Integer num, String str3, List<String> list, List<? extends SearchResponse> list2, Continuation<? super C00102> continuation) {
            super(2, continuation);
            this.$backgroundposter = str;
            this.$poster = str2;
            this.$year = num;
            this.$description = str3;
            this.$tags = list;
            this.$recommendations = list2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00102 = new C00102(this.$backgroundposter, this.$poster, this.$year, this.$description, this.$tags, this.$recommendations, continuation);
            c00102.L$0 = obj;
            return c00102;
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
                    $this$newTvSeriesLoadResponse.setBackgroundPosterUrl(this.$backgroundposter);
                    $this$newTvSeriesLoadResponse.setPosterUrl(this.$poster);
                    $this$newTvSeriesLoadResponse.setYear(this.$year);
                    $this$newTvSeriesLoadResponse.setPlot(this.$description);
                    $this$newTvSeriesLoadResponse.setTags(this.$tags);
                    $this$newTvSeriesLoadResponse.setRecommendations(this.$recommendations);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.piratexplay.Piratexplay$load$3 */
    /* JADX INFO: compiled from: Piratexplay.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.piratexplay.Piratexplay$load$3", f = "Piratexplay.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00113 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $backgroundposter;
        final /* synthetic */ String $description;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00113(String str, String str2, Integer num, String str3, List<String> list, Continuation<? super C00113> continuation) {
            super(2, continuation);
            this.$backgroundposter = str;
            this.$poster = str2;
            this.$year = num;
            this.$description = str3;
            this.$tags = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00113 = new C00113(this.$backgroundposter, this.$poster, this.$year, this.$description, this.$tags, continuation);
            c00113.L$0 = obj;
            return c00113;
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
                    $this$newMovieLoadResponse.setBackgroundPosterUrl(this.$backgroundposter);
                    $this$newMovieLoadResponse.setPosterUrl(this.$poster);
                    $this$newMovieLoadResponse.setYear(this.$year);
                    $this$newMovieLoadResponse.setPlot(this.$description);
                    $this$newMovieLoadResponse.setTags(this.$tags);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x00fb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00121 c00121;
        Object obj;
        boolean z;
        C00121 c00122;
        String data2;
        boolean isCasting2;
        Function1<? super SubtitleFile, Unit> function3;
        Function1<? super ExtractorLink, Unit> function4;
        List listSelect;
        C00132 c00132;
        if (continuation instanceof C00121) {
            c00121 = (C00121) continuation;
            if ((c00121.label & Integer.MIN_VALUE) != 0) {
                c00121.label -= Integer.MIN_VALUE;
            } else {
                c00121 = new C00121(continuation);
            }
        } else {
            c00121 = new C00121(continuation);
        }
        Object $result = c00121.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00121.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00121.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00121.L$1 = function1;
                c00121.L$2 = function2;
                c00121.Z$0 = isCasting;
                c00121.label = 1;
                C00121 c00123 = c00121;
                obj = coroutine_suspended;
                z = true;
                $result = Requests.get$default(app, data, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00123, 4094, (Object) null);
                c00122 = c00123;
                if ($result == obj) {
                    return obj;
                }
                data2 = data;
                isCasting2 = isCasting;
                function3 = function1;
                function4 = function2;
                Document document = ((NiceResponse) $result).getDocument();
                listSelect = document.select("iframe");
                c00132 = new C00132(function3, function4, null);
                c00122.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00122.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00122.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00122.L$3 = SpillingKt.nullOutSpilledVariable(document);
                c00122.Z$0 = isCasting2;
                c00122.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00132, c00122) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 1:
                isCasting2 = c00121.Z$0;
                function4 = (Function1) c00121.L$2;
                function3 = (Function1) c00121.L$1;
                data2 = (String) c00121.L$0;
                ResultKt.throwOnFailure($result);
                c00122 = c00121;
                obj = coroutine_suspended;
                z = true;
                Document document2 = ((NiceResponse) $result).getDocument();
                listSelect = document2.select("iframe");
                c00132 = new C00132(function3, function4, null);
                c00122.L$0 = SpillingKt.nullOutSpilledVariable(data2);
                c00122.L$1 = SpillingKt.nullOutSpilledVariable(function3);
                c00122.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00122.L$3 = SpillingKt.nullOutSpilledVariable(document2);
                c00122.Z$0 = isCasting2;
                c00122.label = 2;
                if (ParCollectionsKt.amap(listSelect, c00132, c00122) == obj) {
                    return obj;
                }
                return Boxing.boxBoolean(z);
            case 2:
                boolean z2 = c00121.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.piratexplay.Piratexplay$loadLinks$2 */
    /* JADX INFO: compiled from: Piratexplay.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000b\u0010\u0002\u001a\u00070\u0003¢\u0006\u0002\b\u0004H\n"}, d2 = {"<anonymous>", "", "it", "Lorg/jsoup/nodes/Element;", "Lkotlin/jvm/internal/EnhancedNullability;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.piratexplay.Piratexplay$loadLinks$2", f = "Piratexplay.kt", i = {0, 0}, l = {139}, m = "invokeSuspend", n = {"it", "link"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
    @SourceDebugExtension({"SMAP\nPiratexplay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Piratexplay.kt\ncom/piratexplay/Piratexplay$loadLinks$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,153:1\n1#2:154\n*E\n"})
    static final class C00132 extends SuspendLambda implements Function2<Element, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00132(Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00132> continuation) {
            super(2, continuation);
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00132 = Piratexplay.this.new C00132(this.$subtitleCallback, this.$callback, continuation);
            c00132.L$0 = obj;
            return c00132;
        }

        public final Object invoke(Element element, Continuation<? super Boolean> continuation) {
            return create(element, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Element it = (Element) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String strAttr = it.attr("src");
                    if (StringsKt.isBlank(strAttr)) {
                        strAttr = it.attr("data-src");
                    }
                    String link = StringsKt.substringAfterLast$default(strAttr, "url=", (String) null, 2, (Object) null);
                    Log.INSTANCE.d("Phisher", link);
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(link);
                    this.label = 1;
                    Object objLoadExtractor = ExtractorApiKt.loadExtractor(link, Piratexplay.this.getMainUrl(), this.$subtitleCallback, this.$callback, (Continuation) this);
                    return objLoadExtractor == coroutine_suspended ? coroutine_suspended : objLoadExtractor;
                case 1:
                    ResultKt.throwOnFailure($result);
                    return $result;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final String getImageAttr(Element $this$getImageAttr) {
        if ($this$getImageAttr.hasAttr("src")) {
            return $this$getImageAttr.attr("src");
        }
        if ($this$getImageAttr.hasAttr("data-src")) {
            return $this$getImageAttr.attr("data-src");
        }
        return $this$getImageAttr.attr("src");
    }
}
