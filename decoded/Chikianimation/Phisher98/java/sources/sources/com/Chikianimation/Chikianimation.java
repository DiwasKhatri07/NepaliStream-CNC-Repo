package com.Chikianimation;

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
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import com.phisher98.donation.DonationManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
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
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* JADX INFO: compiled from: Chikianimation.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Chikianimation/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001e\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\u001e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0096@¢\u0006\u0002\u0010)J\u000e\u0010*\u001a\u0004\u0018\u00010+*\u00020,H\u0002J\f\u0010-\u001a\u00020\u0005*\u00020,H\u0002J\u0016\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00101JF\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u000e2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000208062\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020806H\u0096@¢\u0006\u0002\u0010;J\u0010\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006?"}, d2 = {"Lcom/Chikianimation/Chikianimation;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "getImgSrc", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseDate", "", "value", "Chikianimation"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nChikianimation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Chikianimation.kt\ncom/Chikianimation/Chikianimation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 5 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,321:1\n1795#2,10:322\n2068#2:332\n2069#2:334\n1805#2:335\n1795#2,10:336\n2068#2:346\n2069#2:348\n1805#2:349\n296#2,2:351\n1795#2,10:353\n2068#2:363\n2069#2:367\n1805#2:368\n1849#2,8:369\n2068#2,2:377\n1849#2,8:379\n2068#2:387\n2069#2:389\n1739#2:392\n1814#2,3:393\n777#2:396\n873#2,2:397\n1#3:333\n1#3:347\n1#3:350\n1#3:366\n1#3:388\n1088#4,2:364\n1505#5,2:390\n*S KotlinDebug\n*F\n+ 1 Chikianimation.kt\ncom/Chikianimation/Chikianimation\n*L\n33#1:322,10\n33#1:332\n33#1:334\n33#1:335\n46#1:336,10\n46#1:346\n46#1:348\n46#1:349\n100#1:351,2\n110#1:353,10\n110#1:363\n110#1:367\n110#1:368\n135#1:369,8\n178#1:377,2\n194#1:379,8\n261#1:387\n261#1:389\n279#1:392\n279#1:393,3\n280#1:396\n280#1:397,2\n33#1:333\n46#1:347\n110#1:366\n124#1:364,2\n268#1:390,2\n*E\n"})
public final class Chikianimation extends MainAPI {

    @NotNull
    private String mainUrl = "https://chikianimation.com";

    @NotNull
    private String name = "Chikianimation";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "zh";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.Anime});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("anime/?status=&type=&order=update", "Recently Updated"), TuplesKt.to("anime/?status=&type=&order=popular", "Popular"), TuplesKt.to("anime/?status=&type=&order=latest", "Latest Added"), TuplesKt.to("anime/?status=ongoing&type=&order=update", "Ongoing"), TuplesKt.to("anime/?status=completed&type=&order=update", "Completed"), TuplesKt.to("anime/?status=&type=ona&order=update", "ONA (Donghua)")});

    /* JADX INFO: renamed from: com.Chikianimation.Chikianimation$getMainPage$1 */
    /* JADX INFO: compiled from: Chikianimation.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Chikianimation.Chikianimation", f = "Chikianimation.kt", i = {0, 0, 0}, l = {32}, m = "getMainPage", n = {"request", "url", "page"}, nl = {33}, s = {"L$0", "L$1", "I$0"}, v = 2)
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
            return Chikianimation.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Chikianimation.Chikianimation$load$1 */
    /* JADX INFO: compiled from: Chikianimation.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Chikianimation.Chikianimation", f = "Chikianimation.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6}, l = {85, 140, 147, 162, 175, 194, 202}, m = "load", n = {"url", "url", "document", "rawTitle", "title", "thumbImg", "poster", "description", "genre", "statusText", "typeText", "episodeItems", "episodes", "movieWatchUrl", "isCompleted", "isOngoing", "isMovieType", "url", "document", "rawTitle", "title", "thumbImg", "poster", "description", "genre", "statusText", "typeText", "episodeItems", "episodes", "isCompleted", "isOngoing", "isMovieType", "url", "document", "rawTitle", "title", "thumbImg", "poster", "description", "genre", "statusText", "typeText", "episodeItems", "isCompleted", "isOngoing", "isMovieType", "hasPlayer", "url", "document", "rawTitle", "title", "thumbImg", "poster", "description", "genre", "statusText", "typeText", "episodeItems", "seriesId", "slug", "$this$load_u24lambda_u249", "isCompleted", "isOngoing", "isMovieType", "hasPlayer", "url", "document", "rawTitle", "title", "thumbImg", "poster", "description", "genre", "statusText", "typeText", "episodeItems", "seriesId", "slug", "homeDoc", "fallbackEps", "isCompleted", "isOngoing", "isMovieType", "hasPlayer", "url", "document", "rawTitle", "title", "thumbImg", "poster", "description", "genre", "statusText", "typeText", "episodeItems", "seriesId", "slug", "homeDoc", "fallbackEps", "isCompleted", "isOngoing", "isMovieType", "hasPlayer"}, nl = {87, 147, 160, 171, 175, 202, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "Z$0", "Z$1", "Z$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0", "Z$1", "Z$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "Z$0", "Z$1", "Z$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "Z$0", "Z$1", "Z$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "Z$0", "Z$1", "Z$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "Z$0", "Z$1", "Z$2", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        boolean Z$1;
        boolean Z$2;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Chikianimation.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Chikianimation.Chikianimation$loadLinks$1 */
    /* JADX INFO: compiled from: Chikianimation.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Chikianimation.Chikianimation", f = "Chikianimation.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, l = {219, 263, 271, 282}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "found", "$this$loadLinks_u24lambda_u240", "isCasting", "data", "subtitleCallback", "callback", "found", "pageHtml", "document", "$this$forEach$iv", "element$iv", "el", "src", "isCasting", "data", "subtitleCallback", "callback", "found", "pageHtml", "document", "$this$forEach$iv", "element$iv", "m", "videoId", "$this$loadLinks_u24lambda_u245_u240", "isCasting", "data", "subtitleCallback", "callback", "found", "pageHtml", "document", "options", "isCasting"}, nl = {218, 264, 272, 312}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0"}, v = 2)
    static final class C00071 extends ContinuationImpl {
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
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Chikianimation.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Chikianimation.Chikianimation$search$1 */
    /* JADX INFO: compiled from: Chikianimation.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Chikianimation.Chikianimation", f = "Chikianimation.kt", i = {0, 0}, l = {44}, m = "search", n = {"query", "page"}, nl = {45}, s = {"L$0", "I$0"}, v = 2)
    static final class C00091 extends ContinuationImpl {
        int I$0;
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
            return Chikianimation.this.search(null, 0, (Continuation) this);
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
        int page2;
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
                DonationManager.INSTANCE.checkAndShow(getName());
                String url = getMainUrl() + '/' + request.getData() + "&page=" + page;
                Requests app = MainActivityKt.getApp();
                c00001.L$0 = request;
                c00001.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00001.I$0 = page;
                c00001.label = 1;
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                page2 = page;
                request2 = request;
                break;
                break;
            case 1:
                page2 = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.listupd article.bs");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            int page3 = page2;
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
            page2 = page3;
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse(new HomePageList(request2.getName(), home, false), Boxing.boxBoolean(!home.isEmpty()));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) {
        C00091 c00091;
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
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/page/" + page + "/?s=" + query;
                c00091.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00091.I$0 = page;
                c00091.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00091, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                int i = c00091.I$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.listupd article.bs");
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

    /* JADX WARN: Code duplicated, block: B:41:0x00a7  */
    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        Element link;
        String it;
        String it2;
        String strText;
        Element bsx = $this$toSearchResult.selectFirst("div.bsx");
        final String poster = null;
        if (bsx == null || (link = bsx.selectFirst("a")) == null) {
            return null;
        }
        String strAttr = link.attr("href");
        if (StringsKt.isBlank(strAttr)) {
            return null;
        }
        String href = strAttr;
        String string = StringsKt.trim(link.attr("title")).toString();
        if (StringsKt.isBlank(string)) {
            Element elementSelectFirst = bsx.selectFirst(".tt");
            string = (elementSelectFirst == null || (strText = elementSelectFirst.text()) == null) ? null : StringsKt.trim(strText).toString();
        }
        String str = string;
        if (str != null) {
            String string2 = str;
            if (StringsKt.isBlank(string2)) {
                string2 = StringsKt.trim(link.text()).toString();
            }
            String title = string2;
            if (title == null || StringsKt.isBlank(title)) {
                return null;
            }
            Element imgEl = bsx.selectFirst("div.limit img, img");
            if (imgEl != null && (it2 = imgEl.attr("src")) != null) {
                if (!StringsKt.startsWith$default(it2, "http", false, 2, (Object) null)) {
                    it2 = null;
                }
                if (it2 != null) {
                    poster = it2;
                } else if (imgEl != null) {
                    poster = it;
                }
            } else if (imgEl != null && (it = imgEl.attr("data-src")) != null && StringsKt.startsWith$default(it, "http", false, 2, (Object) null)) {
                poster = it;
            }
            return MainAPIKt.newMovieSearchResponse$default(this, title, MainAPIKt.fixUrl(this, href), TvType.Movie, false, new Function1() { // from class: com.Chikianimation.Chikianimation$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return Chikianimation.toSearchResult$lambda$5(poster, (MovieSearchResponse) obj);
                }
            }, 8, (Object) null);
        }
        return null;
    }

    static final Unit toSearchResult$lambda$5(String $poster, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($poster);
        return Unit.INSTANCE;
    }

    private final String getImgSrc(Element $this$getImgSrc) {
        String src = $this$getImgSrc.attr("src");
        String dataSrc = $this$getImgSrc.attr("data-src");
        if (StringsKt.startsWith$default(src, "http", false, 2, (Object) null)) {
            return src;
        }
        return StringsKt.startsWith$default(dataSrc, "http", false, 2, (Object) null) ? dataSrc : "";
    }

    /* JADX WARN: Code duplicated, block: B:107:0x04e4  */
    /* JADX WARN: Code duplicated, block: B:110:0x04ef  */
    /* JADX WARN: Code duplicated, block: B:111:0x04f4  */
    /* JADX WARN: Code duplicated, block: B:113:0x04f7  */
    /* JADX WARN: Code duplicated, block: B:116:0x050e  */
    /* JADX WARN: Code duplicated, block: B:117:0x0513  */
    /* JADX WARN: Code duplicated, block: B:159:0x062d  */
    /* JADX WARN: Code duplicated, block: B:164:0x0673  */
    /* JADX WARN: Code duplicated, block: B:169:0x0696  */
    /* JADX WARN: Code duplicated, block: B:171:0x069d  */
    /* JADX WARN: Code duplicated, block: B:176:0x06b7  */
    /* JADX WARN: Code duplicated, block: B:178:0x06ba  */
    /* JADX WARN: Code duplicated, block: B:181:0x0746 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:182:0x0747  */
    /* JADX WARN: Code duplicated, block: B:184:0x0758  */
    /* JADX WARN: Code duplicated, block: B:187:0x0780  */
    /* JADX WARN: Code duplicated, block: B:190:0x07f4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:191:0x07f5  */
    /* JADX WARN: Code duplicated, block: B:193:0x0808  */
    /* JADX WARN: Code duplicated, block: B:195:0x0824  */
    /* JADX WARN: Code duplicated, block: B:196:0x0826  */
    /* JADX WARN: Code duplicated, block: B:199:0x082a  */
    /* JADX WARN: Code duplicated, block: B:201:0x0838  */
    /* JADX WARN: Code duplicated, block: B:204:0x08a2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:205:0x08a3  */
    /* JADX WARN: Code duplicated, block: B:207:0x08b3  */
    /* JADX WARN: Code duplicated, block: B:213:0x08e0  */
    /* JADX WARN: Code duplicated, block: B:215:0x08e8  */
    /* JADX WARN: Code duplicated, block: B:218:0x08f7  */
    /* JADX WARN: Code duplicated, block: B:229:0x09a9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:230:0x09aa  */
    /* JADX WARN: Code duplicated, block: B:246:0x0aca  */
    /* JADX WARN: Code duplicated, block: B:249:0x0ad6  */
    /* JADX WARN: Code duplicated, block: B:251:0x0b01  */
    /* JADX WARN: Code duplicated, block: B:254:0x0b0e  */
    /* JADX WARN: Code duplicated, block: B:256:0x0b2a  */
    /* JADX WARN: Code duplicated, block: B:258:0x0b46  */
    /* JADX WARN: Code duplicated, block: B:260:0x0b54  */
    /* JADX WARN: Code duplicated, block: B:263:0x0b6e  */
    /* JADX WARN: Code duplicated, block: B:266:0x0b80  */
    /* JADX WARN: Code duplicated, block: B:267:0x0b9f  */
    /* JADX WARN: Code duplicated, block: B:270:0x0bbe  */
    /* JADX WARN: Code duplicated, block: B:275:0x0bd2  */
    /* JADX WARN: Code duplicated, block: B:278:0x0bed  */
    /* JADX WARN: Code duplicated, block: B:279:0x0bf1  */
    /* JADX WARN: Code duplicated, block: B:282:0x0c22  */
    /* JADX WARN: Code duplicated, block: B:283:0x0c2d  */
    /* JADX WARN: Code duplicated, block: B:286:0x0c42  */
    /* JADX WARN: Code duplicated, block: B:289:0x0c60  */
    /* JADX WARN: Code duplicated, block: B:295:0x0d0a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:296:0x0d0b  */
    /* JADX WARN: Code duplicated, block: B:298:0x0d27  */
    /* JADX WARN: Code duplicated, block: B:300:0x0d3d  */
    /* JADX WARN: Code duplicated, block: B:303:0x0db9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:304:0x0dba  */
    /* JADX WARN: Code duplicated, block: B:323:0x0c80 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:324:0x0c7a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:328:0x03c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:329:0x03c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:332:0x0631 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:336:0x0686 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:338:0x066d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:36:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:46:0x0318  */
    /* JADX WARN: Code duplicated, block: B:48:0x0320  */
    /* JADX WARN: Code duplicated, block: B:49:0x0327  */
    /* JADX WARN: Code duplicated, block: B:51:0x032a  */
    /* JADX WARN: Code duplicated, block: B:57:0x034a  */
    /* JADX WARN: Code duplicated, block: B:60:0x0379  */
    /* JADX WARN: Code duplicated, block: B:64:0x0394  */
    /* JADX WARN: Code duplicated, block: B:67:0x03b9 A[LOOP:2: B:62:0x038e->B:67:0x03b9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:71:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:72:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:74:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:77:0x03f9  */
    /* JADX WARN: Code duplicated, block: B:78:0x03fe  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x0401  */
    /* JADX WARN: Code duplicated, block: B:83:0x0422  */
    /* JADX WARN: Code duplicated, block: B:86:0x043f  */
    /* JADX WARN: Code duplicated, block: B:88:0x0457  */
    /* JADX WARN: Code duplicated, block: B:89:0x046a  */
    /* JADX WARN: Code duplicated, block: B:91:0x047a  */
    /* JADX WARN: Code duplicated, block: B:92:0x048d  */
    /* JADX WARN: Code duplicated, block: B:97:0x04ae  */
    /* JADX WARN: Code duplicated, block: B:99:0x04b1  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        Object obj;
        String str;
        String str2;
        String url2;
        Document document;
        Element elementSelectFirst;
        String str3;
        String string;
        String rawTitle;
        String string2;
        String title;
        Element thumbImg;
        Element elementSelectFirst2;
        String strAttr;
        String poster;
        Element elementSelectFirst3;
        String description;
        String strJoinToString$default;
        String genre;
        Iterable $this$firstOrNull$iv;
        Iterator it;
        String str4;
        String url3;
        boolean z;
        Object element$iv;
        Element element;
        String strText;
        String statusText;
        boolean isCompleted;
        boolean isOngoing;
        Element elementSelectFirst4;
        String strText2;
        String description2;
        String str5;
        boolean isMovieType;
        Elements episodeItems;
        String url4;
        String str6;
        String str7;
        int i;
        int i2;
        MatchResult matchResultFind$default;
        Element elementSelectFirst5;
        String strRemovePrefix;
        String strId;
        String seriesId;
        String slug;
        Document document2;
        String description3;
        String str8;
        String str9;
        Elements episodeItems2;
        String slug2;
        String seriesId2;
        boolean hasPlayer;
        boolean isOngoing2;
        boolean isCompleted2;
        String poster2;
        int i3;
        String rawTitle2;
        String title2;
        Element thumbImg2;
        String url5;
        String title3;
        String statusText2;
        C00011 c00012;
        List groupValues;
        String str10;
        Iterable $this$mapNotNull$iv;
        int $i$f$mapNotNull;
        Collection destination$iv$iv;
        Iterable $this$mapNotNullTo$iv$iv;
        String title4;
        Element thumbImg3;
        String poster3;
        HashSet set$iv;
        ArrayList list$iv;
        List episodes;
        String str11;
        String name;
        boolean z2;
        Episode it2;
        Element item;
        Element link1;
        int $i$f$mapNotNull2;
        String str12;
        String strAttr2;
        Element elementSelectFirst6;
        String epNumText;
        String str13;
        MatchResult matchResultFind$default2;
        Float floatOrNull;
        Element elementSelectFirst7;
        String strText3;
        boolean isDub;
        final String dubSuffix;
        final String formattedName;
        Episode episodeNewEpisode;
        boolean z3;
        List groupValues2;
        String str14;
        String strText4;
        Element it3;
        Iterable $this$firstOrNull$iv2;
        String strText5;
        String imgSrc;
        String strText6;
        Object obj2;
        Object obj3;
        String slug3;
        Elements episodeItems3;
        String seriesId3;
        String genre2;
        String poster4;
        String rawTitle3;
        String seriesId4;
        Document homeDoc;
        List fallbackEps;
        String rawTitle4;
        Object obj4;
        String slug4;
        Document homeDoc2;
        String seriesId5;
        int i4;
        Object obj5;
        String str15;
        TvType tvType;
        HashSet set$iv2;
        ArrayList list$iv2;
        Object obj6;
        String data;
        Iterable iterableSelect;
        Iterable $this$forEach$iv;
        int $i$f$forEach;
        Element a;
        String h;
        String str16;
        Object obj7;
        Document homeDoc3;
        String seriesId6;
        int $i$f$forEach2;
        String strAttr3;
        String epTitle;
        MatchResult epNumMatch;
        String str17;
        final String epName;
        MatchResult matchResultFind$default3;
        List groupValues3;
        Chikianimation chikianimation = this;
        if (continuation instanceof C00011) {
            c00011 = (C00011) continuation;
            if ((c00011.label & Integer.MIN_VALUE) != 0) {
                c00011.label -= Integer.MIN_VALUE;
            } else {
                c00011 = chikianimation.new C00011(continuation);
            }
        } else {
            c00011 = chikianimation.new C00011(continuation);
        }
        C00011 c00013 = c00011;
        Object $result = c00013.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00013.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00013.L$0 = url;
                c00013.label = 1;
                obj = coroutine_suspended;
                str = "href";
                str2 = "Episode ";
                $result = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                c00013 = c00013;
                if ($result == obj) {
                    return obj;
                }
                url2 = url;
                document = ((NiceResponse) $result).getDocument();
                elementSelectFirst = document.selectFirst("h1.entry-title, h1");
                str3 = "";
                if (elementSelectFirst != null || (strText6 = elementSelectFirst.text()) == null || (string = StringsKt.trim(strText6).toString()) == null) {
                    string = "";
                }
                rawTitle = string;
                string2 = StringsKt.trim(new Regex("(?i)(episode|ep)\\s*\\d+.*").replace(rawTitle, "")).toString();
                if (StringsKt.isBlank(string2)) {
                    string2 = rawTitle;
                }
                title = string2;
                thumbImg = document.selectFirst("div.thumb img, .thumb img");
                if (thumbImg != null || (imgSrc = chikianimation.getImgSrc(thumbImg)) == null) {
                    elementSelectFirst2 = document.selectFirst("meta[property=og:image]");
                    if (elementSelectFirst2 != null) {
                        strAttr = elementSelectFirst2.attr("content");
                    } else {
                        strAttr = null;
                    }
                    if (strAttr == null) {
                        strAttr = "";
                    }
                } else {
                    String str18 = imgSrc;
                    if (StringsKt.isBlank(str18)) {
                        str18 = null;
                    }
                    strAttr = str18;
                    if (strAttr == null) {
                        elementSelectFirst2 = document.selectFirst("meta[property=og:image]");
                        if (elementSelectFirst2 != null) {
                            strAttr = elementSelectFirst2.attr("content");
                        } else {
                            strAttr = null;
                        }
                        if (strAttr == null) {
                            strAttr = "";
                        }
                    }
                }
                poster = strAttr;
                elementSelectFirst3 = document.selectFirst("div.entry-content[itemprop=description], div.synp .entry-content, div.entry-content");
                if (elementSelectFirst3 != null || (strText5 = elementSelectFirst3.text()) == null) {
                    description = null;
                } else {
                    description = StringsKt.trim(strText5).toString();
                }
                strJoinToString$default = CollectionsKt.joinToString$default(document.select("div.genxed a, a[href*=/genres/]"), ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.Chikianimation.Chikianimation$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj8) {
                        return StringsKt.trim(((Element) obj8).text()).toString();
                    }
                }, 30, (Object) null);
                if (StringsKt.isBlank(strJoinToString$default)) {
                    strJoinToString$default = null;
                }
                genre = strJoinToString$default;
                $this$firstOrNull$iv = document.select("div.infox div.spe span");
                it = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        element$iv = it.next();
                        it3 = (Element) element$iv;
                        $this$firstOrNull$iv2 = $this$firstOrNull$iv;
                        str4 = str3;
                        url3 = url2;
                        z = true;
                        if (StringsKt.contains(it3.text(), "Status", true)) {
                            $this$firstOrNull$iv = $this$firstOrNull$iv2;
                            str3 = str4;
                            url2 = url3;
                        }
                    } else {
                        str4 = str3;
                        url3 = url2;
                        z = true;
                        element$iv = null;
                    }
                }
                element = (Element) element$iv;
                if (element != null) {
                    strText = element.text();
                } else {
                    strText = null;
                }
                if (strText == null) {
                    strText = str4;
                }
                statusText = strText;
                isCompleted = StringsKt.contains(statusText, "completed", z);
                isOngoing = StringsKt.contains(statusText, "ongoing", z);
                elementSelectFirst4 = document.selectFirst(".spe");
                if (elementSelectFirst4 != null) {
                    strText2 = elementSelectFirst4.text();
                } else {
                    strText2 = null;
                }
                if (strText2 == null) {
                    strText2 = str4;
                }
                description2 = strText2;
                str5 = "Movie";
                isMovieType = StringsKt.contains(description2, "Movie", z);
                episodeItems = document.select("div.eplister ul li, div.episodelist ul li, ul.episodelist li");
                if (!((Collection) episodeItems).isEmpty()) {
                    $this$mapNotNull$iv = (Iterable) episodeItems;
                    $i$f$mapNotNull = 0;
                    destination$iv$iv = new ArrayList();
                    $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
                    for (Object element$iv$iv$iv : $this$mapNotNullTo$iv$iv) {
                        item = (Element) element$iv$iv$iv;
                        Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                        link1 = item.selectFirst("a");
                        if (link1 == null) {
                            $i$f$mapNotNull2 = $i$f$mapNotNull;
                            str13 = str;
                            str2 = str2;
                            episodeNewEpisode = null;
                        } else {
                            $i$f$mapNotNull2 = $i$f$mapNotNull;
                            str12 = str;
                            strAttr2 = link1.attr(str12);
                            if (StringsKt.isBlank(strAttr2)) {
                                str13 = str12;
                                str2 = str2;
                                episodeNewEpisode = null;
                            } else {
                                String href1 = strAttr2;
                                elementSelectFirst6 = item.selectFirst(".epl-num, .num-epi");
                                if (elementSelectFirst6 != null || (strText4 = elementSelectFirst6.text()) == null) {
                                    epNumText = null;
                                } else {
                                    epNumText = StringsKt.trim(strText4).toString();
                                }
                                if (epNumText == null) {
                                    epNumText = str4;
                                }
                                str13 = str12;
                                matchResultFind$default2 = Regex.find$default(new Regex("(\\d+(?:\\.\\d+)?)"), epNumText, 0, 2, (Object) null);
                                if (matchResultFind$default2 != null || (groupValues2 = matchResultFind$default2.getGroupValues()) == null || (str14 = (String) groupValues2.get(1)) == null) {
                                    floatOrNull = null;
                                } else {
                                    floatOrNull = StringsKt.toFloatOrNull(str14);
                                }
                                final Float epNum = floatOrNull;
                                elementSelectFirst7 = item.selectFirst(".epl-date");
                                if (elementSelectFirst7 != null) {
                                    strText3 = elementSelectFirst7.text();
                                } else {
                                    strText3 = null;
                                }
                                if (strText3 == null) {
                                    strText3 = str4;
                                }
                                final long epDate = chikianimation.parseDate(strText3);
                                isDub = StringsKt.contains(item.text(), "Dub", true);
                                if (isDub) {
                                    dubSuffix = " [Dub]";
                                } else {
                                    dubSuffix = str4;
                                }
                                if (!StringsKt.contains(epNumText, "full", true) || StringsKt.contains(epNumText, "movie", true)) {
                                    formattedName = "Full Movie";
                                } else if (StringsKt.startsWith(epNumText, "episode", true)) {
                                    formattedName = epNumText;
                                    str2 = str2;
                                } else if (StringsKt.startsWith(epNumText, "ep", true)) {
                                    str2 = str2;
                                    formattedName = new Regex("(?i)^ep\\.?\\s*").replace(epNumText, str2);
                                } else {
                                    str2 = str2;
                                    if (!StringsKt.isBlank(epNumText)) {
                                        CharSequence $this$all$iv = epNumText;
                                        int i5 = 0;
                                        while (true) {
                                            if (i5 < $this$all$iv.length()) {
                                                char element$iv2 = $this$all$iv.charAt(i5);
                                                boolean isDub2 = isDub;
                                                char it4 = element$iv2;
                                                char element$iv3 = it4;
                                                if (Character.isDigit(element$iv3)) {
                                                    i5++;
                                                    isDub = isDub2;
                                                } else {
                                                    z3 = false;
                                                }
                                            } else {
                                                z3 = true;
                                            }
                                        }
                                        if (z3) {
                                            formattedName = str2 + epNumText;
                                        }
                                    }
                                    formattedName = epNum != null ? str2 + (((epNum.floatValue() % 1.0f) > 0.0f ? 1 : ((epNum.floatValue() % 1.0f) == 0.0f ? 0 : -1)) == 0 ? String.valueOf((int) epNum.floatValue()) : String.valueOf(epNum.floatValue())) : !StringsKt.isBlank(epNumText) ? str2 + epNumText : "Episode 1";
                                }
                                episodeNewEpisode = MainAPIKt.newEpisode(this, MainAPIKt.fixUrl(this, href1), new Function1() { // from class: com.Chikianimation.Chikianimation$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj8) {
                                        return Chikianimation.load$lambda$5$2(formattedName, dubSuffix, epNum, epDate, (Episode) obj8);
                                    }
                                });
                            }
                        }
                        if (episodeNewEpisode != null) {
                            destination$iv$iv.add(episodeNewEpisode);
                        }
                        chikianimation = this;
                        str2 = str2;
                        $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                        str5 = str5;
                        poster = poster;
                        $this$mapNotNull$iv = $this$mapNotNull$iv2;
                        $i$f$mapNotNull = $i$f$mapNotNull2;
                        title = title;
                        str = str13;
                        thumbImg = thumbImg;
                    }
                    String str19 = str5;
                    title4 = title;
                    thumbImg3 = thumbImg;
                    poster3 = poster;
                    Iterable $this$distinctBy$iv = (List) destination$iv$iv;
                    set$iv = new HashSet();
                    list$iv = new ArrayList();
                    for (Object e$iv : $this$distinctBy$iv) {
                        it2 = (Episode) e$iv;
                        if (set$iv.add(it2.getData())) {
                            list$iv.add(e$iv);
                        }
                    }
                    episodes = CollectionsKt.reversed(list$iv);
                    if (isMovieType) {
                        if (episodes.size() == 1) {
                            name = ((Episode) CollectionsKt.first(episodes)).getName();
                            if (name == null && StringsKt.contains(name, str19, true)) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                            }
                        }
                        TvType tvType2 = TvType.Anime;
                        C00044 c00044 = new C00044(poster3, description, genre, isCompleted, isOngoing, null);
                        c00013.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                        c00013.L$1 = SpillingKt.nullOutSpilledVariable(document);
                        c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle);
                        c00013.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                        c00013.L$4 = SpillingKt.nullOutSpilledVariable(thumbImg3);
                        c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster3);
                        c00013.L$6 = SpillingKt.nullOutSpilledVariable(description);
                        c00013.L$7 = SpillingKt.nullOutSpilledVariable(genre);
                        c00013.L$8 = SpillingKt.nullOutSpilledVariable(statusText);
                        c00013.L$9 = SpillingKt.nullOutSpilledVariable(description2);
                        c00013.L$10 = SpillingKt.nullOutSpilledVariable(episodeItems);
                        c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodes);
                        c00013.Z$0 = isCompleted;
                        c00013.Z$1 = isOngoing;
                        c00013.Z$2 = isMovieType;
                        c00013.label = 3;
                        $result = MainAPIKt.newTvSeriesLoadResponse(this, title4, url3, tvType2, episodes, c00044, c00013);
                        if ($result == obj) {
                            return obj;
                        }
                        return $result;
                    }
                    String movieWatchUrl = ((Episode) CollectionsKt.first(episodes)).getData();
                    Chikianimation chikianimation2 = this;
                    str11 = rawTitle;
                    if (StringsKt.isBlank(str11)) {
                        str11 = title4;
                    }
                    String str20 = str11;
                    TvType tvType3 = TvType.Movie;
                    C00033 c00033 = new C00033(poster3, description, genre, null);
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(document);
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle);
                    c00013.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                    c00013.L$4 = SpillingKt.nullOutSpilledVariable(thumbImg3);
                    c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster3);
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(description);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(genre);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(statusText);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(description2);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(episodeItems);
                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(movieWatchUrl);
                    c00013.Z$0 = isCompleted;
                    c00013.Z$1 = isOngoing;
                    c00013.Z$2 = isMovieType;
                    c00013.label = 2;
                    $result = MainAPIKt.newMovieLoadResponse(chikianimation2, str20, url3, tvType3, movieWatchUrl, c00033, c00013);
                    if ($result == obj) {
                        return obj;
                    }
                    return $result;
                }
                url4 = url3;
                str6 = str;
                str7 = str2;
                if (document.selectFirst(".mobius, select.mirror, iframe, #pembed, .player") != null) {
                    i = 1;
                } else {
                    i = 0;
                }
                i2 = i;
                if (i2 != 0) {
                    Chikianimation chikianimation3 = this;
                    str10 = rawTitle;
                    if (StringsKt.isBlank(str10)) {
                        str10 = title;
                    }
                    String str21 = str10;
                    TvType tvType4 = TvType.Movie;
                    C00056 c00056 = new C00056(poster, description, genre, null);
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(document);
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle);
                    c00013.L$3 = SpillingKt.nullOutSpilledVariable(title);
                    c00013.L$4 = SpillingKt.nullOutSpilledVariable(thumbImg);
                    c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster);
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(description);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(genre);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(statusText);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(description2);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(episodeItems);
                    c00013.Z$0 = isCompleted;
                    c00013.Z$1 = isOngoing;
                    c00013.Z$2 = isMovieType;
                    c00013.I$0 = i2;
                    c00013.label = 4;
                    $result = MainAPIKt.newMovieLoadResponse(chikianimation3, str21, url4, tvType4, url4, c00056, c00013);
                    if ($result == obj) {
                        return obj;
                    }
                    return $result;
                }
                matchResultFind$default = Regex.find$default(new Regex("\"series_id\":(\\d+)"), document.html(), 0, 2, (Object) null);
                if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null || (strRemovePrefix = (String) groupValues.get(1)) == null) {
                    elementSelectFirst5 = document.selectFirst("article[id^=post-]");
                    if (elementSelectFirst5 != null || (strId = elementSelectFirst5.id()) == null) {
                        strRemovePrefix = null;
                    } else {
                        strRemovePrefix = StringsKt.removePrefix(strId, "post-");
                    }
                }
                seriesId = strRemovePrefix;
                slug = StringsKt.substringAfterLast$default(StringsKt.trimEnd(url4, new char[]{'/'}), '/', (String) null, 2, (Object) null);
                try {
                    Result.Companion companion = Result.Companion;
                    Chikianimation $this$load_u24lambda_u249 = this;
                    Requests app2 = MainActivityKt.getApp();
                    String url6 = $this$load_u24lambda_u249.getMainUrl();
                    c00013.L$0 = url4;
                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(document);
                    try {
                        c00013.L$2 = rawTitle;
                        try {
                            c00013.L$3 = title;
                            c00013.L$4 = SpillingKt.nullOutSpilledVariable(thumbImg);
                            c00013.L$5 = poster;
                            c00013.L$6 = description;
                            c00013.L$7 = genre;
                            c00013.L$8 = SpillingKt.nullOutSpilledVariable(statusText);
                            c00013.L$9 = SpillingKt.nullOutSpilledVariable(description2);
                            c00013.L$10 = SpillingKt.nullOutSpilledVariable(episodeItems);
                            c00013.L$11 = seriesId;
                            c00013.L$12 = slug;
                            c00013.L$13 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u249);
                            c00013.Z$0 = isCompleted;
                            c00013.Z$1 = isOngoing;
                            c00013.Z$2 = isMovieType;
                            c00013.I$0 = i2;
                            c00013.label = 5;
                            c00012 = c00013;
                            document2 = document;
                            description3 = description;
                            str8 = str7;
                            str9 = str6;
                            try {
                                $result = Requests.get$default(app2, url6, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                                c00013 = c00012;
                                if ($result == obj) {
                                    return obj;
                                }
                                episodeItems2 = episodeItems;
                                slug2 = slug;
                                seriesId2 = seriesId;
                                hasPlayer = isMovieType;
                                isOngoing2 = isOngoing;
                                isCompleted2 = isCompleted;
                                poster2 = poster;
                                i3 = i2;
                                rawTitle2 = rawTitle;
                                title2 = title;
                                thumbImg2 = thumbImg;
                                url5 = url4;
                                title3 = statusText;
                                statusText2 = genre;
                                try {
                                    obj2 = Result.constructor-impl(((NiceResponse) $result).getDocument());
                                    break;
                                } catch (Throwable th) {
                                    th = th;
                                    Result.Companion companion2 = Result.Companion;
                                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                }
                                obj3 = obj2;
                                slug3 = slug2;
                                episodeItems3 = episodeItems2;
                                seriesId3 = seriesId2;
                                genre2 = statusText2;
                                poster4 = poster2;
                                rawTitle3 = rawTitle2;
                                seriesId4 = description3;
                                if (Result.isFailure-impl(obj3)) {
                                    obj3 = null;
                                }
                                homeDoc = (Document) obj3;
                                fallbackEps = new ArrayList();
                                if (homeDoc != null) {
                                    rawTitle4 = rawTitle3;
                                    iterableSelect = homeDoc.select("a[href*=" + slug3 + "], a[rel=" + seriesId3 + ']');
                                    if (iterableSelect != null) {
                                        $this$forEach$iv = iterableSelect;
                                        $i$f$forEach = 0;
                                        for (Object element$iv4 : $this$forEach$iv) {
                                            Iterable $this$forEach$iv2 = $this$forEach$iv;
                                            a = (Element) element$iv4;
                                            String slug5 = slug3;
                                            h = a.attr(str9);
                                            if (StringsKt.isBlank(h)) {
                                                str16 = str9;
                                                obj7 = obj;
                                                homeDoc3 = homeDoc;
                                                seriesId6 = seriesId3;
                                                $i$f$forEach2 = $i$f$forEach;
                                            } else {
                                                str16 = str9;
                                                homeDoc3 = homeDoc;
                                                obj7 = obj;
                                                seriesId6 = seriesId3;
                                                $i$f$forEach2 = $i$f$forEach;
                                                if (!StringsKt.contains$default(h, "/anime/", false, 2, (Object) null)) {
                                                    strAttr3 = a.attr("title");
                                                    if (StringsKt.isBlank(strAttr3)) {
                                                        strAttr3 = a.text();
                                                    }
                                                    epTitle = strAttr3;
                                                    epNumMatch = Regex.find$default(new Regex("(?i)(?:episode|ep)\\s*(\\d+(?:\\s*to\\s*\\d+)?)"), epTitle, 0, 2, (Object) null);
                                                    if (epNumMatch == null) {
                                                        epNumMatch = Regex.find$default(new Regex("(\\d+(?:\\s*to\\s*\\d+)?)"), epTitle, 0, 2, (Object) null);
                                                    }
                                                    if (epNumMatch != null) {
                                                        str17 = str8;
                                                        epName = str17 + ((String) epNumMatch.getGroupValues().get(1));
                                                    } else {
                                                        str17 = str8;
                                                        epName = "Episode 1";
                                                    }
                                                    str8 = str17;
                                                    matchResultFind$default3 = Regex.find$default(new Regex("(\\d+)"), epTitle, 0, 2, (Object) null);
                                                    if (matchResultFind$default3 == null && (groupValues3 = matchResultFind$default3.getGroupValues()) != null) {
                                                        String str22 = (String) groupValues3.get(1);
                                                        final Integer epNum2 = str22 != null ? StringsKt.toIntOrNull(str22) : null;
                                                        fallbackEps.add(MainAPIKt.newEpisode(this, MainAPIKt.fixUrl(this, h), new Function1() { // from class: com.Chikianimation.Chikianimation$$ExternalSyntheticLambda4
                                                            public final Object invoke(Object obj8) {
                                                                return Chikianimation.load$lambda$10$1(epName, epNum2, (Episode) obj8);
                                                            }
                                                        }));
                                                    }
                                                    fallbackEps.add(MainAPIKt.newEpisode(this, MainAPIKt.fixUrl(this, h), new Function1() { // from class: com.Chikianimation.Chikianimation$$ExternalSyntheticLambda4
                                                        public final Object invoke(Object obj8) {
                                                            return Chikianimation.load$lambda$10$1(epName, epNum2, (Episode) obj8);
                                                        }
                                                    }));
                                                }
                                            }
                                            $this$forEach$iv = $this$forEach$iv2;
                                            i3 = i3;
                                            slug3 = slug5;
                                            seriesId3 = seriesId6;
                                            homeDoc = homeDoc3;
                                            str9 = str16;
                                            $i$f$forEach = $i$f$forEach2;
                                            obj = obj7;
                                        }
                                        obj4 = obj;
                                        slug4 = slug3;
                                        homeDoc2 = homeDoc;
                                        seriesId5 = seriesId3;
                                        i4 = i3;
                                        Unit unit = Unit.INSTANCE;
                                    } else {
                                        obj4 = obj;
                                        slug4 = slug3;
                                        homeDoc2 = homeDoc;
                                        seriesId5 = seriesId3;
                                        i4 = i3;
                                    }
                                } else {
                                    rawTitle4 = rawTitle3;
                                    obj4 = obj;
                                    slug4 = slug3;
                                    homeDoc2 = homeDoc;
                                    seriesId5 = seriesId3;
                                    i4 = i3;
                                }
                                if (fallbackEps.isEmpty()) {
                                    int i6 = i4;
                                    String url7 = url5;
                                    obj5 = obj4;
                                    Chikianimation chikianimation4 = this;
                                    str15 = rawTitle4;
                                    if (StringsKt.isBlank(str15)) {
                                        str15 = title2;
                                    }
                                    TvType tvType5 = TvType.Movie;
                                    C000211 c000211 = new C000211(poster4, seriesId4, genre2, null);
                                    c00013.L$0 = SpillingKt.nullOutSpilledVariable(url7);
                                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                                    c00013.L$3 = SpillingKt.nullOutSpilledVariable(title2);
                                    c00013.L$4 = SpillingKt.nullOutSpilledVariable(thumbImg2);
                                    c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster4);
                                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(seriesId4);
                                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(genre2);
                                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(description2);
                                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(episodeItems3);
                                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(seriesId5);
                                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(slug4);
                                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(homeDoc2);
                                    c00013.L$14 = SpillingKt.nullOutSpilledVariable(fallbackEps);
                                    c00013.Z$0 = isCompleted2;
                                    c00013.Z$1 = isOngoing2;
                                    c00013.Z$2 = hasPlayer;
                                    c00013.I$0 = i6;
                                    c00013.label = 7;
                                    $result = MainAPIKt.newMovieLoadResponse(chikianimation4, str15, url7, tvType5, url7, c000211, c00013);
                                    if ($result == obj5) {
                                        return obj5;
                                    }
                                    return $result;
                                }
                                Chikianimation chikianimation5 = this;
                                tvType = TvType.Anime;
                                List $this$distinctBy$iv2 = fallbackEps;
                                set$iv2 = new HashSet();
                                list$iv2 = new ArrayList();
                                for (Object e$iv2 : $this$distinctBy$iv2) {
                                    Episode it5 = (Episode) e$iv2;
                                    data = it5.getData();
                                    tvType = tvType;
                                    if (set$iv2.add(data)) {
                                        list$iv2.add(e$iv2);
                                    }
                                }
                                C00069 c00069 = new C00069(poster4, seriesId4, genre2, null);
                                c00013.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                                c00013.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                                c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                                c00013.L$3 = SpillingKt.nullOutSpilledVariable(title2);
                                c00013.L$4 = SpillingKt.nullOutSpilledVariable(thumbImg2);
                                c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster4);
                                c00013.L$6 = SpillingKt.nullOutSpilledVariable(seriesId4);
                                c00013.L$7 = SpillingKt.nullOutSpilledVariable(genre2);
                                c00013.L$8 = SpillingKt.nullOutSpilledVariable(title3);
                                c00013.L$9 = SpillingKt.nullOutSpilledVariable(description2);
                                c00013.L$10 = SpillingKt.nullOutSpilledVariable(episodeItems3);
                                c00013.L$11 = SpillingKt.nullOutSpilledVariable(seriesId5);
                                c00013.L$12 = SpillingKt.nullOutSpilledVariable(slug4);
                                c00013.L$13 = SpillingKt.nullOutSpilledVariable(homeDoc2);
                                c00013.L$14 = SpillingKt.nullOutSpilledVariable(fallbackEps);
                                c00013.Z$0 = isCompleted2;
                                c00013.Z$1 = isOngoing2;
                                c00013.Z$2 = hasPlayer;
                                c00013.I$0 = i4;
                                c00013.label = 6;
                                $result = MainAPIKt.newTvSeriesLoadResponse(chikianimation5, title2, url5, tvType, list$iv2, c00069, c00013);
                                obj6 = obj4;
                                if ($result == obj6) {
                                    return obj6;
                                }
                                return $result;
                            } catch (Throwable th2) {
                                th = th2;
                                c00013 = c00012;
                                episodeItems2 = episodeItems;
                                slug2 = slug;
                                seriesId2 = seriesId;
                                hasPlayer = isMovieType;
                                isOngoing2 = isOngoing;
                                isCompleted2 = isCompleted;
                                poster2 = poster;
                                i3 = i2;
                                rawTitle2 = rawTitle;
                                title2 = title;
                                thumbImg2 = thumbImg;
                                url5 = url4;
                                title3 = statusText;
                                statusText2 = genre;
                                Result.Companion companion3 = Result.Companion;
                                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                obj3 = obj2;
                                slug3 = slug2;
                                episodeItems3 = episodeItems2;
                                seriesId3 = seriesId2;
                                genre2 = statusText2;
                                poster4 = poster2;
                                rawTitle3 = rawTitle2;
                                seriesId4 = description3;
                                if (Result.isFailure-impl(obj3)) {
                                    obj3 = null;
                                }
                                homeDoc = (Document) obj3;
                                fallbackEps = new ArrayList();
                                if (homeDoc != null) {
                                    rawTitle4 = rawTitle3;
                                    iterableSelect = homeDoc.select("a[href*=" + slug3 + "], a[rel=" + seriesId3 + ']');
                                    if (iterableSelect != null) {
                                        $this$forEach$iv = iterableSelect;
                                        $i$f$forEach = 0;
                                        while (r17.hasNext()) {
                                            Iterable $this$forEach$iv3 = $this$forEach$iv;
                                            a = (Element) element$iv4;
                                            String slug6 = slug3;
                                            h = a.attr(str9);
                                            if (StringsKt.isBlank(h)) {
                                                str16 = str9;
                                                homeDoc3 = homeDoc;
                                                obj7 = obj;
                                                seriesId6 = seriesId3;
                                                $i$f$forEach2 = $i$f$forEach;
                                                if (!StringsKt.contains$default(h, "/anime/", false, 2, (Object) null)) {
                                                    strAttr3 = a.attr("title");
                                                    if (StringsKt.isBlank(strAttr3)) {
                                                        strAttr3 = a.text();
                                                    }
                                                    epTitle = strAttr3;
                                                    epNumMatch = Regex.find$default(new Regex("(?i)(?:episode|ep)\\s*(\\d+(?:\\s*to\\s*\\d+)?)"), epTitle, 0, 2, (Object) null);
                                                    if (epNumMatch == null) {
                                                        epNumMatch = Regex.find$default(new Regex("(\\d+(?:\\s*to\\s*\\d+)?)"), epTitle, 0, 2, (Object) null);
                                                    }
                                                    if (epNumMatch != null) {
                                                        str17 = str8;
                                                        epName = str17 + ((String) epNumMatch.getGroupValues().get(1));
                                                    } else {
                                                        str17 = str8;
                                                        epName = "Episode 1";
                                                    }
                                                    str8 = str17;
                                                    matchResultFind$default3 = Regex.find$default(new Regex("(\\d+)"), epTitle, 0, 2, (Object) null);
                                                    if (matchResultFind$default3 == null) {
                                                    }
                                                    fallbackEps.add(MainAPIKt.newEpisode(this, MainAPIKt.fixUrl(this, h), new Function1() { // from class: com.Chikianimation.Chikianimation$$ExternalSyntheticLambda4
                                                        public final Object invoke(Object obj8) {
                                                            return Chikianimation.load$lambda$10$1(epName, epNum2, (Episode) obj8);
                                                        }
                                                    }));
                                                }
                                            } else {
                                                str16 = str9;
                                                obj7 = obj;
                                                homeDoc3 = homeDoc;
                                                seriesId6 = seriesId3;
                                                $i$f$forEach2 = $i$f$forEach;
                                            }
                                            $this$forEach$iv = $this$forEach$iv3;
                                            i3 = i3;
                                            slug3 = slug6;
                                            seriesId3 = seriesId6;
                                            homeDoc = homeDoc3;
                                            str9 = str16;
                                            $i$f$forEach = $i$f$forEach2;
                                            obj = obj7;
                                        }
                                        obj4 = obj;
                                        slug4 = slug3;
                                        homeDoc2 = homeDoc;
                                        seriesId5 = seriesId3;
                                        i4 = i3;
                                        Unit unit2 = Unit.INSTANCE;
                                    } else {
                                        obj4 = obj;
                                        slug4 = slug3;
                                        homeDoc2 = homeDoc;
                                        seriesId5 = seriesId3;
                                        i4 = i3;
                                    }
                                } else {
                                    rawTitle4 = rawTitle3;
                                    obj4 = obj;
                                    slug4 = slug3;
                                    homeDoc2 = homeDoc;
                                    seriesId5 = seriesId3;
                                    i4 = i3;
                                }
                                if (fallbackEps.isEmpty()) {
                                    int i7 = i4;
                                    String url8 = url5;
                                    obj5 = obj4;
                                    Chikianimation chikianimation6 = this;
                                    str15 = rawTitle4;
                                    if (StringsKt.isBlank(str15)) {
                                        str15 = title2;
                                    }
                                    TvType tvType6 = TvType.Movie;
                                    C000211 c000212 = new C000211(poster4, seriesId4, genre2, null);
                                    c00013.L$0 = SpillingKt.nullOutSpilledVariable(url8);
                                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                                    c00013.L$3 = SpillingKt.nullOutSpilledVariable(title2);
                                    c00013.L$4 = SpillingKt.nullOutSpilledVariable(thumbImg2);
                                    c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster4);
                                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(seriesId4);
                                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(genre2);
                                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(title3);
                                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(description2);
                                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(episodeItems3);
                                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(seriesId5);
                                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(slug4);
                                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(homeDoc2);
                                    c00013.L$14 = SpillingKt.nullOutSpilledVariable(fallbackEps);
                                    c00013.Z$0 = isCompleted2;
                                    c00013.Z$1 = isOngoing2;
                                    c00013.Z$2 = hasPlayer;
                                    c00013.I$0 = i7;
                                    c00013.label = 7;
                                    $result = MainAPIKt.newMovieLoadResponse(chikianimation6, str15, url8, tvType6, url8, c000212, c00013);
                                    if ($result == obj5) {
                                        return obj5;
                                    }
                                    return $result;
                                }
                                Chikianimation chikianimation7 = this;
                                tvType = TvType.Anime;
                                List $this$distinctBy$iv3 = fallbackEps;
                                set$iv2 = new HashSet();
                                list$iv2 = new ArrayList();
                                while (r8.hasNext()) {
                                    Episode it6 = (Episode) e$iv2;
                                    data = it6.getData();
                                    tvType = tvType;
                                    if (set$iv2.add(data)) {
                                        list$iv2.add(e$iv2);
                                    }
                                }
                                C00069 c000610 = new C00069(poster4, seriesId4, genre2, null);
                                c00013.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                                c00013.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                                c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                                c00013.L$3 = SpillingKt.nullOutSpilledVariable(title2);
                                c00013.L$4 = SpillingKt.nullOutSpilledVariable(thumbImg2);
                                c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster4);
                                c00013.L$6 = SpillingKt.nullOutSpilledVariable(seriesId4);
                                c00013.L$7 = SpillingKt.nullOutSpilledVariable(genre2);
                                c00013.L$8 = SpillingKt.nullOutSpilledVariable(title3);
                                c00013.L$9 = SpillingKt.nullOutSpilledVariable(description2);
                                c00013.L$10 = SpillingKt.nullOutSpilledVariable(episodeItems3);
                                c00013.L$11 = SpillingKt.nullOutSpilledVariable(seriesId5);
                                c00013.L$12 = SpillingKt.nullOutSpilledVariable(slug4);
                                c00013.L$13 = SpillingKt.nullOutSpilledVariable(homeDoc2);
                                c00013.L$14 = SpillingKt.nullOutSpilledVariable(fallbackEps);
                                c00013.Z$0 = isCompleted2;
                                c00013.Z$1 = isOngoing2;
                                c00013.Z$2 = hasPlayer;
                                c00013.I$0 = i4;
                                c00013.label = 6;
                                $result = MainAPIKt.newTvSeriesLoadResponse(chikianimation7, title2, url5, tvType, list$iv2, c000610, c00013);
                                obj6 = obj4;
                                if ($result == obj6) {
                                    return obj6;
                                }
                                return $result;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            document2 = document;
                            description3 = description;
                            str8 = str7;
                            str9 = str6;
                            episodeItems2 = episodeItems;
                            slug2 = slug;
                            seriesId2 = seriesId;
                            hasPlayer = isMovieType;
                            isOngoing2 = isOngoing;
                            isCompleted2 = isCompleted;
                            poster2 = poster;
                            i3 = i2;
                            rawTitle2 = rawTitle;
                            title2 = title;
                            thumbImg2 = thumbImg;
                            url5 = url4;
                            title3 = statusText;
                            statusText2 = genre;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        document2 = document;
                        description3 = description;
                        str8 = str7;
                        str9 = str6;
                        episodeItems2 = episodeItems;
                        slug2 = slug;
                        seriesId2 = seriesId;
                        hasPlayer = isMovieType;
                        isOngoing2 = isOngoing;
                        isCompleted2 = isCompleted;
                        poster2 = poster;
                        i3 = i2;
                        rawTitle2 = rawTitle;
                        title2 = title;
                        thumbImg2 = thumbImg;
                        url5 = url4;
                        title3 = statusText;
                        statusText2 = genre;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    document2 = document;
                    description3 = description;
                    str8 = str7;
                    str9 = str6;
                    episodeItems2 = episodeItems;
                    slug2 = slug;
                    seriesId2 = seriesId;
                    hasPlayer = isMovieType;
                    isOngoing2 = isOngoing;
                    isCompleted2 = isCompleted;
                    poster2 = poster;
                    i3 = i2;
                    rawTitle2 = rawTitle;
                    title2 = title;
                    thumbImg2 = thumbImg;
                    url5 = url4;
                    title3 = statusText;
                    statusText2 = genre;
                }
                break;
            case 1:
                String url9 = (String) c00013.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                str = "href";
                str2 = "Episode ";
                url2 = url9;
                document = ((NiceResponse) $result).getDocument();
                elementSelectFirst = document.selectFirst("h1.entry-title, h1");
                str3 = "";
                if (elementSelectFirst != null) {
                    string = "";
                } else {
                    string = "";
                }
                rawTitle = string;
                string2 = StringsKt.trim(new Regex("(?i)(episode|ep)\\s*\\d+.*").replace(rawTitle, "")).toString();
                if (StringsKt.isBlank(string2)) {
                    string2 = rawTitle;
                }
                title = string2;
                thumbImg = document.selectFirst("div.thumb img, .thumb img");
                if (thumbImg != null) {
                    elementSelectFirst2 = document.selectFirst("meta[property=og:image]");
                    if (elementSelectFirst2 != null) {
                        strAttr = elementSelectFirst2.attr("content");
                    } else {
                        strAttr = null;
                    }
                    if (strAttr == null) {
                        strAttr = "";
                    }
                } else {
                    elementSelectFirst2 = document.selectFirst("meta[property=og:image]");
                    if (elementSelectFirst2 != null) {
                        strAttr = elementSelectFirst2.attr("content");
                    } else {
                        strAttr = null;
                    }
                    if (strAttr == null) {
                        strAttr = "";
                    }
                }
                poster = strAttr;
                elementSelectFirst3 = document.selectFirst("div.entry-content[itemprop=description], div.synp .entry-content, div.entry-content");
                if (elementSelectFirst3 != null) {
                    description = null;
                } else {
                    description = null;
                }
                strJoinToString$default = CollectionsKt.joinToString$default(document.select("div.genxed a, a[href*=/genres/]"), ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.Chikianimation.Chikianimation$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj8) {
                        return StringsKt.trim(((Element) obj8).text()).toString();
                    }
                }, 30, (Object) null);
                if (StringsKt.isBlank(strJoinToString$default)) {
                    strJoinToString$default = null;
                }
                genre = strJoinToString$default;
                $this$firstOrNull$iv = document.select("div.infox div.spe span");
                it = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        element$iv = it.next();
                        it3 = (Element) element$iv;
                        $this$firstOrNull$iv2 = $this$firstOrNull$iv;
                        str4 = str3;
                        url3 = url2;
                        z = true;
                        if (StringsKt.contains(it3.text(), "Status", true)) {
                            $this$firstOrNull$iv = $this$firstOrNull$iv2;
                            str3 = str4;
                            url2 = url3;
                        }
                    } else {
                        str4 = str3;
                        url3 = url2;
                        z = true;
                        element$iv = null;
                    }
                }
                element = (Element) element$iv;
                if (element != null) {
                    strText = element.text();
                } else {
                    strText = null;
                }
                if (strText == null) {
                    strText = str4;
                }
                statusText = strText;
                isCompleted = StringsKt.contains(statusText, "completed", z);
                isOngoing = StringsKt.contains(statusText, "ongoing", z);
                elementSelectFirst4 = document.selectFirst(".spe");
                if (elementSelectFirst4 != null) {
                    strText2 = elementSelectFirst4.text();
                } else {
                    strText2 = null;
                }
                if (strText2 == null) {
                    strText2 = str4;
                }
                description2 = strText2;
                str5 = "Movie";
                isMovieType = StringsKt.contains(description2, "Movie", z);
                episodeItems = document.select("div.eplister ul li, div.episodelist ul li, ul.episodelist li");
                if (!((Collection) episodeItems).isEmpty()) {
                    $this$mapNotNull$iv = (Iterable) episodeItems;
                    $i$f$mapNotNull = 0;
                    destination$iv$iv = new ArrayList();
                    $this$mapNotNullTo$iv$iv = $this$mapNotNull$iv;
                    while (r30.hasNext()) {
                        item = (Element) element$iv$iv$iv;
                        Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                        link1 = item.selectFirst("a");
                        if (link1 == null) {
                            $i$f$mapNotNull2 = $i$f$mapNotNull;
                            str13 = str;
                            str2 = str2;
                            episodeNewEpisode = null;
                        } else {
                            $i$f$mapNotNull2 = $i$f$mapNotNull;
                            str12 = str;
                            strAttr2 = link1.attr(str12);
                            if (StringsKt.isBlank(strAttr2)) {
                                str13 = str12;
                                str2 = str2;
                                episodeNewEpisode = null;
                            } else {
                                String href2 = strAttr2;
                                elementSelectFirst6 = item.selectFirst(".epl-num, .num-epi");
                                if (elementSelectFirst6 != null) {
                                    epNumText = null;
                                } else {
                                    epNumText = null;
                                }
                                if (epNumText == null) {
                                    epNumText = str4;
                                }
                                str13 = str12;
                                matchResultFind$default2 = Regex.find$default(new Regex("(\\d+(?:\\.\\d+)?)"), epNumText, 0, 2, (Object) null);
                                if (matchResultFind$default2 != null) {
                                    floatOrNull = null;
                                } else {
                                    floatOrNull = null;
                                }
                                final Float epNum3 = floatOrNull;
                                elementSelectFirst7 = item.selectFirst(".epl-date");
                                if (elementSelectFirst7 != null) {
                                    strText3 = elementSelectFirst7.text();
                                } else {
                                    strText3 = null;
                                }
                                if (strText3 == null) {
                                    strText3 = str4;
                                }
                                final long epDate2 = chikianimation.parseDate(strText3);
                                isDub = StringsKt.contains(item.text(), "Dub", true);
                                if (isDub) {
                                    dubSuffix = " [Dub]";
                                } else {
                                    dubSuffix = str4;
                                }
                                if (StringsKt.contains(epNumText, "full", true)) {
                                }
                                formattedName = "Full Movie";
                                episodeNewEpisode = MainAPIKt.newEpisode(this, MainAPIKt.fixUrl(this, href2), new Function1() { // from class: com.Chikianimation.Chikianimation$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj8) {
                                        return Chikianimation.load$lambda$5$2(formattedName, dubSuffix, epNum3, epDate2, (Episode) obj8);
                                    }
                                });
                            }
                        }
                        if (episodeNewEpisode != null) {
                            destination$iv$iv.add(episodeNewEpisode);
                        }
                        chikianimation = this;
                        str2 = str2;
                        $this$mapNotNullTo$iv$iv = $this$mapNotNullTo$iv$iv;
                        str5 = str5;
                        poster = poster;
                        $this$mapNotNull$iv = $this$mapNotNull$iv3;
                        $i$f$mapNotNull = $i$f$mapNotNull2;
                        title = title;
                        str = str13;
                        thumbImg = thumbImg;
                    }
                    String str110 = str5;
                    title4 = title;
                    thumbImg3 = thumbImg;
                    poster3 = poster;
                    Iterable $this$distinctBy$iv4 = (List) destination$iv$iv;
                    set$iv = new HashSet();
                    list$iv = new ArrayList();
                    while (r5.hasNext()) {
                        it2 = (Episode) e$iv;
                        if (set$iv.add(it2.getData())) {
                            list$iv.add(e$iv);
                        }
                    }
                    episodes = CollectionsKt.reversed(list$iv);
                    if (isMovieType) {
                        if (episodes.size() == 1) {
                            name = ((Episode) CollectionsKt.first(episodes)).getName();
                            if (name == null) {
                                z2 = false;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                            }
                        }
                        TvType tvType7 = TvType.Anime;
                        C00044 c00045 = new C00044(poster3, description, genre, isCompleted, isOngoing, null);
                        c00013.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                        c00013.L$1 = SpillingKt.nullOutSpilledVariable(document);
                        c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle);
                        c00013.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                        c00013.L$4 = SpillingKt.nullOutSpilledVariable(thumbImg3);
                        c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster3);
                        c00013.L$6 = SpillingKt.nullOutSpilledVariable(description);
                        c00013.L$7 = SpillingKt.nullOutSpilledVariable(genre);
                        c00013.L$8 = SpillingKt.nullOutSpilledVariable(statusText);
                        c00013.L$9 = SpillingKt.nullOutSpilledVariable(description2);
                        c00013.L$10 = SpillingKt.nullOutSpilledVariable(episodeItems);
                        c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodes);
                        c00013.Z$0 = isCompleted;
                        c00013.Z$1 = isOngoing;
                        c00013.Z$2 = isMovieType;
                        c00013.label = 3;
                        $result = MainAPIKt.newTvSeriesLoadResponse(this, title4, url3, tvType7, episodes, c00045, c00013);
                        if ($result == obj) {
                            return obj;
                        }
                        return $result;
                    }
                    String movieWatchUrl2 = ((Episode) CollectionsKt.first(episodes)).getData();
                    Chikianimation chikianimation8 = this;
                    str11 = rawTitle;
                    if (StringsKt.isBlank(str11)) {
                        str11 = title4;
                    }
                    String str23 = str11;
                    TvType tvType8 = TvType.Movie;
                    C00033 c00034 = new C00033(poster3, description, genre, null);
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(document);
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle);
                    c00013.L$3 = SpillingKt.nullOutSpilledVariable(title4);
                    c00013.L$4 = SpillingKt.nullOutSpilledVariable(thumbImg3);
                    c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster3);
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(description);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(genre);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(statusText);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(description2);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(episodeItems);
                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(episodes);
                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(movieWatchUrl2);
                    c00013.Z$0 = isCompleted;
                    c00013.Z$1 = isOngoing;
                    c00013.Z$2 = isMovieType;
                    c00013.label = 2;
                    $result = MainAPIKt.newMovieLoadResponse(chikianimation8, str23, url3, tvType8, movieWatchUrl2, c00034, c00013);
                    if ($result == obj) {
                        return obj;
                    }
                    return $result;
                }
                url4 = url3;
                str6 = str;
                str7 = str2;
                if (document.selectFirst(".mobius, select.mirror, iframe, #pembed, .player") != null) {
                    i = 1;
                } else {
                    i = 0;
                }
                i2 = i;
                if (i2 != 0) {
                    Chikianimation chikianimation9 = this;
                    str10 = rawTitle;
                    if (StringsKt.isBlank(str10)) {
                        str10 = title;
                    }
                    String str24 = str10;
                    TvType tvType9 = TvType.Movie;
                    C00056 c00057 = new C00056(poster, description, genre, null);
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable(url4);
                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(document);
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle);
                    c00013.L$3 = SpillingKt.nullOutSpilledVariable(title);
                    c00013.L$4 = SpillingKt.nullOutSpilledVariable(thumbImg);
                    c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster);
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(description);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(genre);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(statusText);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(description2);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(episodeItems);
                    c00013.Z$0 = isCompleted;
                    c00013.Z$1 = isOngoing;
                    c00013.Z$2 = isMovieType;
                    c00013.I$0 = i2;
                    c00013.label = 4;
                    $result = MainAPIKt.newMovieLoadResponse(chikianimation9, str24, url4, tvType9, url4, c00057, c00013);
                    if ($result == obj) {
                        return obj;
                    }
                    return $result;
                }
                matchResultFind$default = Regex.find$default(new Regex("\"series_id\":(\\d+)"), document.html(), 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    elementSelectFirst5 = document.selectFirst("article[id^=post-]");
                    if (elementSelectFirst5 != null) {
                        strRemovePrefix = null;
                    } else {
                        strRemovePrefix = null;
                    }
                } else {
                    elementSelectFirst5 = document.selectFirst("article[id^=post-]");
                    if (elementSelectFirst5 != null) {
                        strRemovePrefix = null;
                    } else {
                        strRemovePrefix = null;
                    }
                }
                seriesId = strRemovePrefix;
                slug = StringsKt.substringAfterLast$default(StringsKt.trimEnd(url4, new char[]{'/'}), '/', (String) null, 2, (Object) null);
                Result.Companion companion4 = Result.Companion;
                Chikianimation $this$load_u24lambda_u2410 = this;
                Requests app3 = MainActivityKt.getApp();
                String url10 = $this$load_u24lambda_u2410.getMainUrl();
                c00013.L$0 = url4;
                c00013.L$1 = SpillingKt.nullOutSpilledVariable(document);
                c00013.L$2 = rawTitle;
                c00013.L$3 = title;
                c00013.L$4 = SpillingKt.nullOutSpilledVariable(thumbImg);
                c00013.L$5 = poster;
                c00013.L$6 = description;
                c00013.L$7 = genre;
                c00013.L$8 = SpillingKt.nullOutSpilledVariable(statusText);
                c00013.L$9 = SpillingKt.nullOutSpilledVariable(description2);
                c00013.L$10 = SpillingKt.nullOutSpilledVariable(episodeItems);
                c00013.L$11 = seriesId;
                c00013.L$12 = slug;
                c00013.L$13 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u2410);
                c00013.Z$0 = isCompleted;
                c00013.Z$1 = isOngoing;
                c00013.Z$2 = isMovieType;
                c00013.I$0 = i2;
                c00013.label = 5;
                c00012 = c00013;
                document2 = document;
                description3 = description;
                str8 = str7;
                str9 = str6;
                $result = Requests.get$default(app3, url10, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                c00013 = c00012;
                if ($result == obj) {
                    return obj;
                }
                episodeItems2 = episodeItems;
                slug2 = slug;
                seriesId2 = seriesId;
                hasPlayer = isMovieType;
                isOngoing2 = isOngoing;
                isCompleted2 = isCompleted;
                poster2 = poster;
                i3 = i2;
                rawTitle2 = rawTitle;
                title2 = title;
                thumbImg2 = thumbImg;
                url5 = url4;
                title3 = statusText;
                statusText2 = genre;
                obj2 = Result.constructor-impl(((NiceResponse) $result).getDocument());
                obj3 = obj2;
                slug3 = slug2;
                episodeItems3 = episodeItems2;
                seriesId3 = seriesId2;
                genre2 = statusText2;
                poster4 = poster2;
                rawTitle3 = rawTitle2;
                seriesId4 = description3;
                if (Result.isFailure-impl(obj3)) {
                    obj3 = null;
                }
                homeDoc = (Document) obj3;
                fallbackEps = new ArrayList();
                if (homeDoc != null) {
                    rawTitle4 = rawTitle3;
                    iterableSelect = homeDoc.select("a[href*=" + slug3 + "], a[rel=" + seriesId3 + ']');
                    if (iterableSelect != null) {
                        $this$forEach$iv = iterableSelect;
                        $i$f$forEach = 0;
                        while (r17.hasNext()) {
                            Iterable $this$forEach$iv4 = $this$forEach$iv;
                            a = (Element) element$iv4;
                            String slug7 = slug3;
                            h = a.attr(str9);
                            if (StringsKt.isBlank(h)) {
                                str16 = str9;
                                homeDoc3 = homeDoc;
                                obj7 = obj;
                                seriesId6 = seriesId3;
                                $i$f$forEach2 = $i$f$forEach;
                                if (!StringsKt.contains$default(h, "/anime/", false, 2, (Object) null)) {
                                    strAttr3 = a.attr("title");
                                    if (StringsKt.isBlank(strAttr3)) {
                                        strAttr3 = a.text();
                                    }
                                    epTitle = strAttr3;
                                    epNumMatch = Regex.find$default(new Regex("(?i)(?:episode|ep)\\s*(\\d+(?:\\s*to\\s*\\d+)?)"), epTitle, 0, 2, (Object) null);
                                    if (epNumMatch == null) {
                                        epNumMatch = Regex.find$default(new Regex("(\\d+(?:\\s*to\\s*\\d+)?)"), epTitle, 0, 2, (Object) null);
                                    }
                                    if (epNumMatch != null) {
                                        str17 = str8;
                                        epName = str17 + ((String) epNumMatch.getGroupValues().get(1));
                                    } else {
                                        str17 = str8;
                                        epName = "Episode 1";
                                    }
                                    str8 = str17;
                                    matchResultFind$default3 = Regex.find$default(new Regex("(\\d+)"), epTitle, 0, 2, (Object) null);
                                    if (matchResultFind$default3 == null) {
                                    }
                                    fallbackEps.add(MainAPIKt.newEpisode(this, MainAPIKt.fixUrl(this, h), new Function1() { // from class: com.Chikianimation.Chikianimation$$ExternalSyntheticLambda4
                                        public final Object invoke(Object obj8) {
                                            return Chikianimation.load$lambda$10$1(epName, epNum2, (Episode) obj8);
                                        }
                                    }));
                                }
                            } else {
                                str16 = str9;
                                obj7 = obj;
                                homeDoc3 = homeDoc;
                                seriesId6 = seriesId3;
                                $i$f$forEach2 = $i$f$forEach;
                            }
                            $this$forEach$iv = $this$forEach$iv4;
                            i3 = i3;
                            slug3 = slug7;
                            seriesId3 = seriesId6;
                            homeDoc = homeDoc3;
                            str9 = str16;
                            $i$f$forEach = $i$f$forEach2;
                            obj = obj7;
                        }
                        obj4 = obj;
                        slug4 = slug3;
                        homeDoc2 = homeDoc;
                        seriesId5 = seriesId3;
                        i4 = i3;
                        Unit unit3 = Unit.INSTANCE;
                    } else {
                        obj4 = obj;
                        slug4 = slug3;
                        homeDoc2 = homeDoc;
                        seriesId5 = seriesId3;
                        i4 = i3;
                    }
                } else {
                    rawTitle4 = rawTitle3;
                    obj4 = obj;
                    slug4 = slug3;
                    homeDoc2 = homeDoc;
                    seriesId5 = seriesId3;
                    i4 = i3;
                }
                if (fallbackEps.isEmpty()) {
                    int i8 = i4;
                    String url11 = url5;
                    obj5 = obj4;
                    Chikianimation chikianimation10 = this;
                    str15 = rawTitle4;
                    if (StringsKt.isBlank(str15)) {
                        str15 = title2;
                    }
                    TvType tvType10 = TvType.Movie;
                    C000211 c000213 = new C000211(poster4, seriesId4, genre2, null);
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable(url11);
                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                    c00013.L$3 = SpillingKt.nullOutSpilledVariable(title2);
                    c00013.L$4 = SpillingKt.nullOutSpilledVariable(thumbImg2);
                    c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster4);
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(seriesId4);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(genre2);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(title3);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(description2);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(episodeItems3);
                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(seriesId5);
                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(slug4);
                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(homeDoc2);
                    c00013.L$14 = SpillingKt.nullOutSpilledVariable(fallbackEps);
                    c00013.Z$0 = isCompleted2;
                    c00013.Z$1 = isOngoing2;
                    c00013.Z$2 = hasPlayer;
                    c00013.I$0 = i8;
                    c00013.label = 7;
                    $result = MainAPIKt.newMovieLoadResponse(chikianimation10, str15, url11, tvType10, url11, c000213, c00013);
                    if ($result == obj5) {
                        return obj5;
                    }
                    return $result;
                }
                Chikianimation chikianimation11 = this;
                tvType = TvType.Anime;
                List $this$distinctBy$iv5 = fallbackEps;
                set$iv2 = new HashSet();
                list$iv2 = new ArrayList();
                while (r8.hasNext()) {
                    Episode it7 = (Episode) e$iv2;
                    data = it7.getData();
                    tvType = tvType;
                    if (set$iv2.add(data)) {
                        list$iv2.add(e$iv2);
                    }
                }
                C00069 c000611 = new C00069(poster4, seriesId4, genre2, null);
                c00013.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                c00013.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                c00013.L$3 = SpillingKt.nullOutSpilledVariable(title2);
                c00013.L$4 = SpillingKt.nullOutSpilledVariable(thumbImg2);
                c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster4);
                c00013.L$6 = SpillingKt.nullOutSpilledVariable(seriesId4);
                c00013.L$7 = SpillingKt.nullOutSpilledVariable(genre2);
                c00013.L$8 = SpillingKt.nullOutSpilledVariable(title3);
                c00013.L$9 = SpillingKt.nullOutSpilledVariable(description2);
                c00013.L$10 = SpillingKt.nullOutSpilledVariable(episodeItems3);
                c00013.L$11 = SpillingKt.nullOutSpilledVariable(seriesId5);
                c00013.L$12 = SpillingKt.nullOutSpilledVariable(slug4);
                c00013.L$13 = SpillingKt.nullOutSpilledVariable(homeDoc2);
                c00013.L$14 = SpillingKt.nullOutSpilledVariable(fallbackEps);
                c00013.Z$0 = isCompleted2;
                c00013.Z$1 = isOngoing2;
                c00013.Z$2 = hasPlayer;
                c00013.I$0 = i4;
                c00013.label = 6;
                $result = MainAPIKt.newTvSeriesLoadResponse(chikianimation11, title2, url5, tvType, list$iv2, c000611, c00013);
                obj6 = obj4;
                if ($result == obj6) {
                    return obj6;
                }
                return $result;
            case 2:
                boolean z4 = c00013.Z$2;
                boolean z5 = c00013.Z$1;
                boolean z6 = c00013.Z$0;
                ResultKt.throwOnFailure($result);
                return $result;
            case 3:
                boolean z7 = c00013.Z$2;
                boolean z8 = c00013.Z$1;
                boolean z9 = c00013.Z$0;
                ResultKt.throwOnFailure($result);
                return $result;
            case 4:
                int i9 = c00013.I$0;
                boolean z10 = c00013.Z$2;
                boolean z11 = c00013.Z$1;
                boolean z12 = c00013.Z$0;
                ResultKt.throwOnFailure($result);
                return $result;
            case 5:
                i3 = c00013.I$0;
                hasPlayer = c00013.Z$2;
                isOngoing2 = c00013.Z$1;
                isCompleted2 = c00013.Z$0;
                slug2 = (String) c00013.L$12;
                seriesId2 = (String) c00013.L$11;
                episodeItems2 = (Elements) c00013.L$10;
                String typeText = (String) c00013.L$9;
                title3 = (String) c00013.L$8;
                statusText2 = (String) c00013.L$7;
                String description4 = (String) c00013.L$6;
                poster2 = (String) c00013.L$5;
                thumbImg2 = (Element) c00013.L$4;
                title2 = (String) c00013.L$3;
                rawTitle2 = (String) c00013.L$2;
                document2 = (Document) c00013.L$1;
                url5 = (String) c00013.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj = coroutine_suspended;
                    str9 = "href";
                    str8 = "Episode ";
                    description3 = description4;
                    description2 = typeText;
                    obj2 = Result.constructor-impl(((NiceResponse) $result).getDocument());
                    break;
                } catch (Throwable th6) {
                    th = th6;
                    obj = coroutine_suspended;
                    str9 = "href";
                    str8 = "Episode ";
                    description3 = description4;
                    description2 = typeText;
                    Result.Companion companion5 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                    obj3 = obj2;
                    slug3 = slug2;
                    episodeItems3 = episodeItems2;
                    seriesId3 = seriesId2;
                    genre2 = statusText2;
                    poster4 = poster2;
                    rawTitle3 = rawTitle2;
                    seriesId4 = description3;
                    if (Result.isFailure-impl(obj3)) {
                        obj3 = null;
                    }
                    homeDoc = (Document) obj3;
                    fallbackEps = new ArrayList();
                    if (homeDoc != null) {
                        rawTitle4 = rawTitle3;
                        iterableSelect = homeDoc.select("a[href*=" + slug3 + "], a[rel=" + seriesId3 + ']');
                        if (iterableSelect != null) {
                            $this$forEach$iv = iterableSelect;
                            $i$f$forEach = 0;
                            while (r17.hasNext()) {
                                Iterable $this$forEach$iv5 = $this$forEach$iv;
                                a = (Element) element$iv4;
                                String slug8 = slug3;
                                h = a.attr(str9);
                                if (StringsKt.isBlank(h)) {
                                    str16 = str9;
                                    homeDoc3 = homeDoc;
                                    obj7 = obj;
                                    seriesId6 = seriesId3;
                                    $i$f$forEach2 = $i$f$forEach;
                                    if (!StringsKt.contains$default(h, "/anime/", false, 2, (Object) null)) {
                                        strAttr3 = a.attr("title");
                                        if (StringsKt.isBlank(strAttr3)) {
                                            strAttr3 = a.text();
                                        }
                                        epTitle = strAttr3;
                                        epNumMatch = Regex.find$default(new Regex("(?i)(?:episode|ep)\\s*(\\d+(?:\\s*to\\s*\\d+)?)"), epTitle, 0, 2, (Object) null);
                                        if (epNumMatch == null) {
                                            epNumMatch = Regex.find$default(new Regex("(\\d+(?:\\s*to\\s*\\d+)?)"), epTitle, 0, 2, (Object) null);
                                        }
                                        if (epNumMatch != null) {
                                            str17 = str8;
                                            epName = str17 + ((String) epNumMatch.getGroupValues().get(1));
                                        } else {
                                            str17 = str8;
                                            epName = "Episode 1";
                                        }
                                        str8 = str17;
                                        matchResultFind$default3 = Regex.find$default(new Regex("(\\d+)"), epTitle, 0, 2, (Object) null);
                                        if (matchResultFind$default3 == null) {
                                        }
                                        fallbackEps.add(MainAPIKt.newEpisode(this, MainAPIKt.fixUrl(this, h), new Function1() { // from class: com.Chikianimation.Chikianimation$$ExternalSyntheticLambda4
                                            public final Object invoke(Object obj8) {
                                                return Chikianimation.load$lambda$10$1(epName, epNum2, (Episode) obj8);
                                            }
                                        }));
                                    }
                                } else {
                                    str16 = str9;
                                    obj7 = obj;
                                    homeDoc3 = homeDoc;
                                    seriesId6 = seriesId3;
                                    $i$f$forEach2 = $i$f$forEach;
                                }
                                $this$forEach$iv = $this$forEach$iv5;
                                i3 = i3;
                                slug3 = slug8;
                                seriesId3 = seriesId6;
                                homeDoc = homeDoc3;
                                str9 = str16;
                                $i$f$forEach = $i$f$forEach2;
                                obj = obj7;
                            }
                            obj4 = obj;
                            slug4 = slug3;
                            homeDoc2 = homeDoc;
                            seriesId5 = seriesId3;
                            i4 = i3;
                            Unit unit4 = Unit.INSTANCE;
                        } else {
                            obj4 = obj;
                            slug4 = slug3;
                            homeDoc2 = homeDoc;
                            seriesId5 = seriesId3;
                            i4 = i3;
                        }
                    } else {
                        rawTitle4 = rawTitle3;
                        obj4 = obj;
                        slug4 = slug3;
                        homeDoc2 = homeDoc;
                        seriesId5 = seriesId3;
                        i4 = i3;
                    }
                    if (fallbackEps.isEmpty()) {
                        int i10 = i4;
                        String url12 = url5;
                        obj5 = obj4;
                        Chikianimation chikianimation12 = this;
                        str15 = rawTitle4;
                        if (StringsKt.isBlank(str15)) {
                            str15 = title2;
                        }
                        TvType tvType11 = TvType.Movie;
                        C000211 c000214 = new C000211(poster4, seriesId4, genre2, null);
                        c00013.L$0 = SpillingKt.nullOutSpilledVariable(url12);
                        c00013.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                        c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                        c00013.L$3 = SpillingKt.nullOutSpilledVariable(title2);
                        c00013.L$4 = SpillingKt.nullOutSpilledVariable(thumbImg2);
                        c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster4);
                        c00013.L$6 = SpillingKt.nullOutSpilledVariable(seriesId4);
                        c00013.L$7 = SpillingKt.nullOutSpilledVariable(genre2);
                        c00013.L$8 = SpillingKt.nullOutSpilledVariable(title3);
                        c00013.L$9 = SpillingKt.nullOutSpilledVariable(description2);
                        c00013.L$10 = SpillingKt.nullOutSpilledVariable(episodeItems3);
                        c00013.L$11 = SpillingKt.nullOutSpilledVariable(seriesId5);
                        c00013.L$12 = SpillingKt.nullOutSpilledVariable(slug4);
                        c00013.L$13 = SpillingKt.nullOutSpilledVariable(homeDoc2);
                        c00013.L$14 = SpillingKt.nullOutSpilledVariable(fallbackEps);
                        c00013.Z$0 = isCompleted2;
                        c00013.Z$1 = isOngoing2;
                        c00013.Z$2 = hasPlayer;
                        c00013.I$0 = i10;
                        c00013.label = 7;
                        $result = MainAPIKt.newMovieLoadResponse(chikianimation12, str15, url12, tvType11, url12, c000214, c00013);
                        if ($result == obj5) {
                            return obj5;
                        }
                        return $result;
                    }
                    Chikianimation chikianimation13 = this;
                    tvType = TvType.Anime;
                    List $this$distinctBy$iv6 = fallbackEps;
                    set$iv2 = new HashSet();
                    list$iv2 = new ArrayList();
                    while (r8.hasNext()) {
                        Episode it8 = (Episode) e$iv2;
                        data = it8.getData();
                        tvType = tvType;
                        if (set$iv2.add(data)) {
                            list$iv2.add(e$iv2);
                        }
                    }
                    C00069 c000612 = new C00069(poster4, seriesId4, genre2, null);
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                    c00013.L$3 = SpillingKt.nullOutSpilledVariable(title2);
                    c00013.L$4 = SpillingKt.nullOutSpilledVariable(thumbImg2);
                    c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster4);
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(seriesId4);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(genre2);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(title3);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(description2);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(episodeItems3);
                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(seriesId5);
                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(slug4);
                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(homeDoc2);
                    c00013.L$14 = SpillingKt.nullOutSpilledVariable(fallbackEps);
                    c00013.Z$0 = isCompleted2;
                    c00013.Z$1 = isOngoing2;
                    c00013.Z$2 = hasPlayer;
                    c00013.I$0 = i4;
                    c00013.label = 6;
                    $result = MainAPIKt.newTvSeriesLoadResponse(chikianimation13, title2, url5, tvType, list$iv2, c000612, c00013);
                    obj6 = obj4;
                    if ($result == obj6) {
                        return obj6;
                    }
                    return $result;
                }
                obj3 = obj2;
                slug3 = slug2;
                episodeItems3 = episodeItems2;
                seriesId3 = seriesId2;
                genre2 = statusText2;
                poster4 = poster2;
                rawTitle3 = rawTitle2;
                seriesId4 = description3;
                if (Result.isFailure-impl(obj3)) {
                    obj3 = null;
                }
                homeDoc = (Document) obj3;
                fallbackEps = new ArrayList();
                if (homeDoc != null) {
                    rawTitle4 = rawTitle3;
                    iterableSelect = homeDoc.select("a[href*=" + slug3 + "], a[rel=" + seriesId3 + ']');
                    if (iterableSelect != null) {
                        $this$forEach$iv = iterableSelect;
                        $i$f$forEach = 0;
                        while (r17.hasNext()) {
                            Iterable $this$forEach$iv6 = $this$forEach$iv;
                            a = (Element) element$iv4;
                            String slug9 = slug3;
                            h = a.attr(str9);
                            if (StringsKt.isBlank(h)) {
                                str16 = str9;
                                homeDoc3 = homeDoc;
                                obj7 = obj;
                                seriesId6 = seriesId3;
                                $i$f$forEach2 = $i$f$forEach;
                                if (!StringsKt.contains$default(h, "/anime/", false, 2, (Object) null)) {
                                    strAttr3 = a.attr("title");
                                    if (StringsKt.isBlank(strAttr3)) {
                                        strAttr3 = a.text();
                                    }
                                    epTitle = strAttr3;
                                    epNumMatch = Regex.find$default(new Regex("(?i)(?:episode|ep)\\s*(\\d+(?:\\s*to\\s*\\d+)?)"), epTitle, 0, 2, (Object) null);
                                    if (epNumMatch == null) {
                                        epNumMatch = Regex.find$default(new Regex("(\\d+(?:\\s*to\\s*\\d+)?)"), epTitle, 0, 2, (Object) null);
                                    }
                                    if (epNumMatch != null) {
                                        str17 = str8;
                                        epName = str17 + ((String) epNumMatch.getGroupValues().get(1));
                                    } else {
                                        str17 = str8;
                                        epName = "Episode 1";
                                    }
                                    str8 = str17;
                                    matchResultFind$default3 = Regex.find$default(new Regex("(\\d+)"), epTitle, 0, 2, (Object) null);
                                    if (matchResultFind$default3 == null) {
                                    }
                                    fallbackEps.add(MainAPIKt.newEpisode(this, MainAPIKt.fixUrl(this, h), new Function1() { // from class: com.Chikianimation.Chikianimation$$ExternalSyntheticLambda4
                                        public final Object invoke(Object obj8) {
                                            return Chikianimation.load$lambda$10$1(epName, epNum2, (Episode) obj8);
                                        }
                                    }));
                                }
                            } else {
                                str16 = str9;
                                obj7 = obj;
                                homeDoc3 = homeDoc;
                                seriesId6 = seriesId3;
                                $i$f$forEach2 = $i$f$forEach;
                            }
                            $this$forEach$iv = $this$forEach$iv6;
                            i3 = i3;
                            slug3 = slug9;
                            seriesId3 = seriesId6;
                            homeDoc = homeDoc3;
                            str9 = str16;
                            $i$f$forEach = $i$f$forEach2;
                            obj = obj7;
                        }
                        obj4 = obj;
                        slug4 = slug3;
                        homeDoc2 = homeDoc;
                        seriesId5 = seriesId3;
                        i4 = i3;
                        Unit unit5 = Unit.INSTANCE;
                    } else {
                        obj4 = obj;
                        slug4 = slug3;
                        homeDoc2 = homeDoc;
                        seriesId5 = seriesId3;
                        i4 = i3;
                    }
                } else {
                    rawTitle4 = rawTitle3;
                    obj4 = obj;
                    slug4 = slug3;
                    homeDoc2 = homeDoc;
                    seriesId5 = seriesId3;
                    i4 = i3;
                }
                if (fallbackEps.isEmpty()) {
                    int i11 = i4;
                    String url13 = url5;
                    obj5 = obj4;
                    Chikianimation chikianimation14 = this;
                    str15 = rawTitle4;
                    if (StringsKt.isBlank(str15)) {
                        str15 = title2;
                    }
                    TvType tvType12 = TvType.Movie;
                    C000211 c000215 = new C000211(poster4, seriesId4, genre2, null);
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable(url13);
                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                    c00013.L$3 = SpillingKt.nullOutSpilledVariable(title2);
                    c00013.L$4 = SpillingKt.nullOutSpilledVariable(thumbImg2);
                    c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster4);
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(seriesId4);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(genre2);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(title3);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(description2);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(episodeItems3);
                    c00013.L$11 = SpillingKt.nullOutSpilledVariable(seriesId5);
                    c00013.L$12 = SpillingKt.nullOutSpilledVariable(slug4);
                    c00013.L$13 = SpillingKt.nullOutSpilledVariable(homeDoc2);
                    c00013.L$14 = SpillingKt.nullOutSpilledVariable(fallbackEps);
                    c00013.Z$0 = isCompleted2;
                    c00013.Z$1 = isOngoing2;
                    c00013.Z$2 = hasPlayer;
                    c00013.I$0 = i11;
                    c00013.label = 7;
                    $result = MainAPIKt.newMovieLoadResponse(chikianimation14, str15, url13, tvType12, url13, c000215, c00013);
                    if ($result == obj5) {
                        return obj5;
                    }
                    return $result;
                }
                Chikianimation chikianimation15 = this;
                tvType = TvType.Anime;
                List $this$distinctBy$iv7 = fallbackEps;
                set$iv2 = new HashSet();
                list$iv2 = new ArrayList();
                while (r8.hasNext()) {
                    Episode it9 = (Episode) e$iv2;
                    data = it9.getData();
                    tvType = tvType;
                    if (set$iv2.add(data)) {
                        list$iv2.add(e$iv2);
                    }
                }
                C00069 c000613 = new C00069(poster4, seriesId4, genre2, null);
                c00013.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                c00013.L$1 = SpillingKt.nullOutSpilledVariable(document2);
                c00013.L$2 = SpillingKt.nullOutSpilledVariable(rawTitle4);
                c00013.L$3 = SpillingKt.nullOutSpilledVariable(title2);
                c00013.L$4 = SpillingKt.nullOutSpilledVariable(thumbImg2);
                c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster4);
                c00013.L$6 = SpillingKt.nullOutSpilledVariable(seriesId4);
                c00013.L$7 = SpillingKt.nullOutSpilledVariable(genre2);
                c00013.L$8 = SpillingKt.nullOutSpilledVariable(title3);
                c00013.L$9 = SpillingKt.nullOutSpilledVariable(description2);
                c00013.L$10 = SpillingKt.nullOutSpilledVariable(episodeItems3);
                c00013.L$11 = SpillingKt.nullOutSpilledVariable(seriesId5);
                c00013.L$12 = SpillingKt.nullOutSpilledVariable(slug4);
                c00013.L$13 = SpillingKt.nullOutSpilledVariable(homeDoc2);
                c00013.L$14 = SpillingKt.nullOutSpilledVariable(fallbackEps);
                c00013.Z$0 = isCompleted2;
                c00013.Z$1 = isOngoing2;
                c00013.Z$2 = hasPlayer;
                c00013.I$0 = i4;
                c00013.label = 6;
                $result = MainAPIKt.newTvSeriesLoadResponse(chikianimation15, title2, url5, tvType, list$iv2, c000613, c00013);
                obj6 = obj4;
                if ($result == obj6) {
                    return obj6;
                }
                return $result;
            case 6:
                int i12 = c00013.I$0;
                boolean z13 = c00013.Z$2;
                boolean z14 = c00013.Z$1;
                boolean z15 = c00013.Z$0;
                ResultKt.throwOnFailure($result);
                return $result;
            case 7:
                int i13 = c00013.I$0;
                boolean z16 = c00013.Z$2;
                boolean z17 = c00013.Z$1;
                boolean z18 = c00013.Z$0;
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$5$2(String $formattedName, String $dubSuffix, Float $epNum, long $epDate, Episode $this$newEpisode) {
        $this$newEpisode.setName($formattedName + $dubSuffix);
        $this$newEpisode.setEpisode($epNum != null ? Integer.valueOf((int) $epNum.floatValue()) : null);
        $this$newEpisode.setDate(Long.valueOf($epDate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.Chikianimation.Chikianimation$load$3 */
    /* JADX INFO: compiled from: Chikianimation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Chikianimation.Chikianimation$load$3", f = "Chikianimation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00033 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $genre;
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00033(String str, String str2, String str3, Continuation<? super C00033> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$description = str2;
            this.$genre = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00033 = new C00033(this.$poster, this.$description, this.$genre, continuation);
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
                    $this$newMovieLoadResponse.setPosterUrl(this.$poster);
                    $this$newMovieLoadResponse.setPlot(this.$description);
                    String str = this.$genre;
                    $this$newMovieLoadResponse.setTags(str != null ? StringsKt.split$default(str, new String[]{", "}, false, 0, 6, (Object) null) : null);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.Chikianimation.Chikianimation$load$4 */
    /* JADX INFO: compiled from: Chikianimation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Chikianimation.Chikianimation$load$4", f = "Chikianimation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00044 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $genre;
        final /* synthetic */ boolean $isCompleted;
        final /* synthetic */ boolean $isOngoing;
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00044(String str, String str2, String str3, boolean z, boolean z2, Continuation<? super C00044> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$description = str2;
            this.$genre = str3;
            this.$isCompleted = z;
            this.$isOngoing = z2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00044 = new C00044(this.$poster, this.$description, this.$genre, this.$isCompleted, this.$isOngoing, continuation);
            c00044.L$0 = obj;
            return c00044;
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
                    $this$newTvSeriesLoadResponse.setPosterUrl(this.$poster);
                    $this$newTvSeriesLoadResponse.setPlot(this.$description);
                    String str = this.$genre;
                    ShowStatus showStatus = null;
                    $this$newTvSeriesLoadResponse.setTags(str != null ? StringsKt.split$default(str, new String[]{", "}, false, 0, 6, (Object) null) : null);
                    if (this.$isCompleted) {
                        showStatus = ShowStatus.Completed;
                    } else if (this.$isOngoing) {
                        showStatus = ShowStatus.Ongoing;
                    }
                    $this$newTvSeriesLoadResponse.setShowStatus(showStatus);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.Chikianimation.Chikianimation$load$6 */
    /* JADX INFO: compiled from: Chikianimation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Chikianimation.Chikianimation$load$6", f = "Chikianimation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00056 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $genre;
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00056(String str, String str2, String str3, Continuation<? super C00056> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$description = str2;
            this.$genre = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00056 = new C00056(this.$poster, this.$description, this.$genre, continuation);
            c00056.L$0 = obj;
            return c00056;
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
                    String str = this.$genre;
                    $this$newMovieLoadResponse.setTags(str != null ? StringsKt.split$default(str, new String[]{", "}, false, 0, 6, (Object) null) : null);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$10$1(String $epName, Integer $epNum, Episode $this$newEpisode) {
        $this$newEpisode.setName($epName);
        $this$newEpisode.setEpisode($epNum);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.Chikianimation.Chikianimation$load$9 */
    /* JADX INFO: compiled from: Chikianimation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Chikianimation.Chikianimation$load$9", f = "Chikianimation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00069 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $genre;
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00069(String str, String str2, String str3, Continuation<? super C00069> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$description = str2;
            this.$genre = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00069 = new C00069(this.$poster, this.$description, this.$genre, continuation);
            c00069.L$0 = obj;
            return c00069;
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
                    $this$newTvSeriesLoadResponse.setPosterUrl(this.$poster);
                    $this$newTvSeriesLoadResponse.setPlot(this.$description);
                    String str = this.$genre;
                    $this$newTvSeriesLoadResponse.setTags(str != null ? StringsKt.split$default(str, new String[]{", "}, false, 0, 6, (Object) null) : null);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.Chikianimation.Chikianimation$load$11 */
    /* JADX INFO: compiled from: Chikianimation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Chikianimation.Chikianimation$load$11", f = "Chikianimation.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C000211 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $genre;
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C000211(String str, String str2, String str3, Continuation<? super C000211> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$description = str2;
            this.$genre = str3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c000211 = new C000211(this.$poster, this.$description, this.$genre, continuation);
            c000211.L$0 = obj;
            return c000211;
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
                    String str = this.$genre;
                    $this$newMovieLoadResponse.setTags(str != null ? StringsKt.split$default(str, new String[]{", "}, false, 0, 6, (Object) null) : null);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0217  */
    /* JADX WARN: Code duplicated, block: B:52:0x0231  */
    /* JADX WARN: Code duplicated, block: B:55:0x0275 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:0x0276  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0276 -> B:57:0x028b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x033c -> B:118:0x0356). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x03b5 -> B:85:0x03c7). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r29, boolean r30, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r31, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r32, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r33) {
        /*
            Method dump skipped, instruction units count: 1290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.Chikianimation.Chikianimation.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:43:0x01af A[Catch: all -> 0x00ce, TryCatch #5 {all -> 0x00ce, blocks: (B:23:0x00c8, B:41:0x01a7, B:43:0x01af, B:44:0x01b1), top: B:90:0x00c8 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x02da A[Catch: all -> 0x0067, TryCatch #1 {all -> 0x0067, blocks: (B:13:0x0061, B:70:0x02d2, B:72:0x02da, B:73:0x02dc), top: B:82:0x0061 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    public static final Object loadLinks$handleUrl(Chikianimation this$0, Function1<? super SubtitleFile, Unit> function1, final Function1<? super ExtractorLink, Unit> function2, Ref.BooleanRef found, String url, String ref, Continuation<? super Unit> continuation) {
        Chikianimation$loadLinks$handleUrl$1 chikianimation$loadLinks$handleUrl$1;
        Object obj;
        Object obj2;
        final Ref.BooleanRef found2 = found;
        if (continuation instanceof Chikianimation$loadLinks$handleUrl$1) {
            chikianimation$loadLinks$handleUrl$1 = (Chikianimation$loadLinks$handleUrl$1) continuation;
            if ((chikianimation$loadLinks$handleUrl$1.label & Integer.MIN_VALUE) != 0) {
                chikianimation$loadLinks$handleUrl$1.label -= Integer.MIN_VALUE;
            } else {
                chikianimation$loadLinks$handleUrl$1 = new Chikianimation$loadLinks$handleUrl$1(continuation);
            }
        } else {
            chikianimation$loadLinks$handleUrl$1 = new Chikianimation$loadLinks$handleUrl$1(continuation);
        }
        Chikianimation$loadLinks$handleUrl$1 chikianimation$loadLinks$handleUrl$2 = chikianimation$loadLinks$handleUrl$1;
        Object $result = chikianimation$loadLinks$handleUrl$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (chikianimation$loadLinks$handleUrl$2.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Ref.ObjectRef cleanUrl = new Ref.ObjectRef();
                cleanUrl.element = StringsKt.trim(url).toString();
                if (StringsKt.startsWith$default((String) cleanUrl.element, "//", false, 2, (Object) null)) {
                    cleanUrl.element = ExtractorApiKt.httpsify((String) cleanUrl.element);
                }
                if (StringsKt.isBlank((CharSequence) cleanUrl.element)) {
                    return Unit.INSTANCE;
                }
                MatchResult dmMatch = Regex.find$default(new Regex("dailymotion\\.com/(?:player/[^/]+\\.html\\?video=|embed/video/|video/)([a-zA-Z0-9_]+)"), (CharSequence) cleanUrl.element, 0, 2, (Object) null);
                if (dmMatch != null) {
                    String videoId = (String) dmMatch.getGroupValues().get(1);
                    Log.INSTANCE.d("Chikianimation", "Dailymotion video ID: " + videoId);
                    try {
                        Result.Companion companion = Result.Companion;
                        chikianimation$loadLinks$handleUrl$2.L$0 = SpillingKt.nullOutSpilledVariable(this$0);
                        chikianimation$loadLinks$handleUrl$2.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                        chikianimation$loadLinks$handleUrl$2.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                        chikianimation$loadLinks$handleUrl$2.L$3 = found2;
                        chikianimation$loadLinks$handleUrl$2.L$4 = SpillingKt.nullOutSpilledVariable(url);
                        chikianimation$loadLinks$handleUrl$2.L$5 = SpillingKt.nullOutSpilledVariable(ref);
                        chikianimation$loadLinks$handleUrl$2.L$6 = SpillingKt.nullOutSpilledVariable(cleanUrl);
                        chikianimation$loadLinks$handleUrl$2.L$7 = SpillingKt.nullOutSpilledVariable(dmMatch);
                        chikianimation$loadLinks$handleUrl$2.L$8 = SpillingKt.nullOutSpilledVariable(videoId);
                        chikianimation$loadLinks$handleUrl$2.L$9 = SpillingKt.nullOutSpilledVariable(this$0);
                        chikianimation$loadLinks$handleUrl$2.label = 1;
                        Object objLoadExtractor = ExtractorApiKt.loadExtractor("https://www.dailymotion.com/video/" + videoId, ref, function1, function2, chikianimation$loadLinks$handleUrl$2);
                        if (objLoadExtractor == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj2 = objLoadExtractor;
                        if (((Boolean) obj2).booleanValue()) {
                            found2.element = true;
                        }
                        Result.constructor-impl(Unit.INSTANCE);
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        th = th;
                        Result.Companion companion2 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th));
                    }
                } else if (StringsKt.contains((CharSequence) cleanUrl.element, "galaxydonghua", true)) {
                    Log.INSTANCE.d("Chikianimation", "Direct GalaxyDonghua handling for: " + ((String) cleanUrl.element));
                    try {
                        Result.Companion companion3 = Result.Companion;
                        GalaxyDonghua galaxyDonghua = new GalaxyDonghua();
                        String str = (String) cleanUrl.element;
                        Function1<? super ExtractorLink, Unit> function3 = new Function1() { // from class: com.Chikianimation.Chikianimation$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj3) {
                                return Chikianimation.loadLinks$handleUrl$lambda$2$0(found2, function2, (ExtractorLink) obj3);
                            }
                        };
                        chikianimation$loadLinks$handleUrl$2.L$0 = SpillingKt.nullOutSpilledVariable(this$0);
                        chikianimation$loadLinks$handleUrl$2.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                        chikianimation$loadLinks$handleUrl$2.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                        chikianimation$loadLinks$handleUrl$2.L$3 = SpillingKt.nullOutSpilledVariable(found2);
                        chikianimation$loadLinks$handleUrl$2.L$4 = SpillingKt.nullOutSpilledVariable(url);
                        chikianimation$loadLinks$handleUrl$2.L$5 = SpillingKt.nullOutSpilledVariable(ref);
                        chikianimation$loadLinks$handleUrl$2.L$6 = SpillingKt.nullOutSpilledVariable(cleanUrl);
                        chikianimation$loadLinks$handleUrl$2.L$7 = SpillingKt.nullOutSpilledVariable(dmMatch);
                        chikianimation$loadLinks$handleUrl$2.L$8 = SpillingKt.nullOutSpilledVariable(this$0);
                        chikianimation$loadLinks$handleUrl$2.label = 2;
                        if (galaxyDonghua.getUrl(str, ref, function1, function3, chikianimation$loadLinks$handleUrl$2) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Result.constructor-impl(Unit.INSTANCE);
                        return Unit.INSTANCE;
                    } catch (Throwable th2) {
                        th = th2;
                        Result.Companion companion4 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th));
                    }
                } else {
                    Log.INSTANCE.d("Chikianimation", "Loading extractor for: " + ((String) cleanUrl.element));
                    try {
                        Result.Companion companion5 = Result.Companion;
                        String str2 = (String) cleanUrl.element;
                        chikianimation$loadLinks$handleUrl$2.L$0 = SpillingKt.nullOutSpilledVariable(this$0);
                        chikianimation$loadLinks$handleUrl$2.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                        chikianimation$loadLinks$handleUrl$2.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                        chikianimation$loadLinks$handleUrl$2.L$3 = found2;
                        chikianimation$loadLinks$handleUrl$2.L$4 = SpillingKt.nullOutSpilledVariable(url);
                        chikianimation$loadLinks$handleUrl$2.L$5 = SpillingKt.nullOutSpilledVariable(ref);
                        chikianimation$loadLinks$handleUrl$2.L$6 = SpillingKt.nullOutSpilledVariable(cleanUrl);
                        chikianimation$loadLinks$handleUrl$2.L$7 = SpillingKt.nullOutSpilledVariable(dmMatch);
                        chikianimation$loadLinks$handleUrl$2.L$8 = SpillingKt.nullOutSpilledVariable(this$0);
                        chikianimation$loadLinks$handleUrl$2.label = 3;
                        Object objLoadExtractor2 = ExtractorApiKt.loadExtractor(str2, ref, function1, function2, chikianimation$loadLinks$handleUrl$2);
                        if (objLoadExtractor2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = objLoadExtractor2;
                        if (((Boolean) obj).booleanValue()) {
                            found2.element = true;
                        }
                        Result.constructor-impl(Unit.INSTANCE);
                        return Unit.INSTANCE;
                    } catch (Throwable th3) {
                        th = th3;
                        Result.Companion companion6 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th));
                    }
                }
                break;
            case 1:
                found2 = (Ref.BooleanRef) chikianimation$loadLinks$handleUrl$2.L$3;
                try {
                    ResultKt.throwOnFailure($result);
                    obj2 = $result;
                    if (((Boolean) obj2).booleanValue()) {
                        found2.element = true;
                    }
                    Result.constructor-impl(Unit.INSTANCE);
                    break;
                } catch (Throwable th4) {
                    th = th4;
                    Result.Companion companion7 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                }
                return Unit.INSTANCE;
            case 2:
                try {
                    ResultKt.throwOnFailure($result);
                    Result.constructor-impl(Unit.INSTANCE);
                    break;
                } catch (Throwable th5) {
                    th = th5;
                    Result.Companion companion8 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                }
                return Unit.INSTANCE;
            case 3:
                found2 = (Ref.BooleanRef) chikianimation$loadLinks$handleUrl$2.L$3;
                try {
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    if (((Boolean) obj).booleanValue()) {
                        found2.element = true;
                    }
                    Result.constructor-impl(Unit.INSTANCE);
                    break;
                } catch (Throwable th6) {
                    th = th6;
                    Result.Companion companion9 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadLinks$handleUrl$lambda$2$0(Ref.BooleanRef $found, Function1 $callback, ExtractorLink link) {
        $found.element = true;
        $callback.invoke(link);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.Chikianimation.Chikianimation$loadLinks$4 */
    /* JADX INFO: compiled from: Chikianimation.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "playerPageUrl", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Chikianimation.Chikianimation$loadLinks$4", f = "Chikianimation.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {285, 290, 298, 307}, m = "invokeSuspend", n = {"playerPageUrl", "resolvedUrl", "playerPageUrl", "resolvedUrl", "$this$invokeSuspend_u24lambda_u240", "playerPageUrl", "resolvedUrl", "$this$invokeSuspend_u24lambda_u240", "playerHtml", "playerDoc", "$this$forEach$iv", "element$iv", "m", "videoId", "$this$invokeSuspend_u24lambda_u240_u240_u240", "playerPageUrl", "resolvedUrl", "$this$invokeSuspend_u24lambda_u240", "playerHtml", "playerDoc", "$this$forEach$iv", "element$iv", "el", "src"}, nl = {286, 291, 299, 308}, s = {"L$0", "L$1", "L$0", "L$1", "L$6", "L$0", "L$1", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$0", "L$1", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13"}, v = 2)
    @SourceDebugExtension({"SMAP\nChikianimation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Chikianimation.kt\ncom/Chikianimation/Chikianimation$loadLinks$4\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,321:1\n1505#2,2:322\n2068#3:324\n2069#3:326\n1#4:325\n*S KotlinDebug\n*F\n+ 1 Chikianimation.kt\ncom/Chikianimation/Chikianimation$loadLinks$4\n*L\n295#1:322,2\n305#1:324\n305#1:326\n*E\n"})
    static final class C00084 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $data;
        final /* synthetic */ Ref.BooleanRef $found;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00084(String str, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Ref.BooleanRef booleanRef, Continuation<? super C00084> continuation) {
            super(2, continuation);
            this.$data = str;
            this.$subtitleCallback = function1;
            this.$callback = function2;
            this.$found = booleanRef;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00084 = Chikianimation.this.new C00084(this.$data, this.$subtitleCallback, this.$callback, this.$found, continuation);
            c00084.L$0 = obj;
            return c00084;
        }

        public final Object invoke(String str, Continuation<? super Unit> continuation) {
            return create(str, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:45:0x023b A[Catch: all -> 0x0466, TRY_LEAVE, TryCatch #6 {all -> 0x0466, blocks: (B:43:0x0235, B:45:0x023b), top: B:139:0x0235 }] */
        /* JADX WARN: Code duplicated, block: B:53:0x02b9 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:54:0x02ba  */
        /* JADX WARN: Code duplicated, block: B:57:0x02de  */
        /* JADX WARN: Code duplicated, block: B:59:0x02e4  */
        /* JADX WARN: Not initialized variable reg: 21, insn: 0x0116: MOVE (r9 I:??[OBJECT, ARRAY]) = (r21 I:??[OBJECT, ARRAY] A[D('resolvedUrl' java.lang.String)]), block:B:18:0x0113 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x02ba -> B:133:0x02d6). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0364 -> B:74:0x0369). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x041b -> B:95:0x0436). Please report as a decompilation issue!!! */
        /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
            java.lang.StackOverflowError
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r31) {
            /*
                Method dump skipped, instruction units count: 1296
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.Chikianimation.Chikianimation.C00084.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final long parseDate(String value) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            Chikianimation chikianimation = this;
            Date date = new SimpleDateFormat("MMMM d, yyyy", Locale.US).parse(value);
            obj = Result.constructor-impl(Long.valueOf(date != null ? date.getTime() : 0L));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = 0L;
        }
        return ((Number) obj).longValue();
    }
}
