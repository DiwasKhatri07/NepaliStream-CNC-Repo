package com.MovieBlast;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.ActorRole;
import com.lagradost.cloudstream3.Episode;
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
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
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
import kotlin.collections.IntIterator;
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
import kotlin.ranges.RangesKt;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: MovieBlast.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MovieBlast/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 =2\u00020\u0001:\u0001=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u001b\u001a\u00020\u000e*\u00020\u001cH\u0002J\u001e\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010'J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u001e2\u0006\u0010*\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+J\u000e\u0010,\u001a\u0004\u0018\u00010)*\u00020\u001cH\u0002J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010+JF\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u000e2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000206042\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020604H\u0096@¢\u0006\u0002\u00109J\u000e\u0010:\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005J\u0010\u0010;\u001a\u00020$2\b\u0010<\u001a\u0004\u0018\u00010\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006>"}, d2 = {"Lcom/MovieBlast/MovieBlast;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "isSeries", "Lcom/MovieBlast/HomeDaum;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResultSafe", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "httpsify", "matchQualityFromString", "s", "Companion", "MovieBlast"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMovieBlast.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieBlast.kt\ncom/MovieBlast/MovieBlast\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,320:1\n73#2,5:321\n73#2,5:326\n1739#3:331\n1814#3,3:332\n1795#3,10:336\n2068#3:346\n2069#3:348\n1805#3:349\n1795#3,10:350\n2068#3:360\n2069#3:362\n1805#3:363\n1795#3,10:364\n2068#3:374\n2069#3:376\n1805#3:377\n1795#3,10:378\n2068#3:388\n2069#3:390\n1805#3:391\n1#4:335\n1#4:347\n1#4:361\n1#4:375\n1#4:389\n1#4:395\n93#5,2:392\n63#5:394\n64#5,15:396\n95#5,2:413\n50#6:411\n43#6:412\n*S KotlinDebug\n*F\n+ 1 MovieBlast.kt\ncom/MovieBlast/MovieBlast\n*L\n79#1:321,5\n99#1:326,5\n102#1:331\n102#1:332,3\n162#1:336,10\n162#1:346\n162#1:348\n162#1:349\n168#1:350,10\n168#1:360\n168#1:362\n168#1:363\n195#1:364,10\n195#1:374\n195#1:376\n195#1:377\n232#1:378,10\n232#1:388\n232#1:390\n232#1:391\n162#1:347\n168#1:361\n195#1:375\n232#1:389\n266#1:395\n266#1:392,2\n266#1:394\n266#1:396,15\n266#1:413,2\n266#1:411\n266#1:412\n*E\n"})
public final class MovieBlast extends MainAPI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Map<String, String> headers = MapsKt.mapOf(TuplesKt.to("user-agent", "okhttp/5.0.0-alpha.6"));

    @NotNull
    private static final String token = MainAPIKt.base64Decode("amR2aGhqdjI1NXZnaGhnZGh2ZmNoMjU2NTY1NmpoZGNnaGZkZg==");

    @NotNull
    private String mainUrl = MainAPIKt.base64Decode("aHR0cHM6Ly9hcHAuY2xvdWQtbWIueHl6");

    @NotNull
    private String name = "MovieBlast";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "te";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.Anime, TvType.Cartoon});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("api/genres/pinned/all", "Latest"), TuplesKt.to("api/genres/trending/all", "Trending"), TuplesKt.to("api/genres/new/all", "Recently Added"), TuplesKt.to("api/genres/popularmovies/all", "Popular • Movies"), TuplesKt.to("api/genres/popularseries/all", "Popular • Series"), TuplesKt.to("api/media/seriesEpisodesAll", "Latest • Series"), TuplesKt.to("api/genres/recommended/all", "Recommended"), TuplesKt.to("api/genres/media/names/New%20HD%20Released", "New HD Releases")});

    /* JADX INFO: renamed from: com.MovieBlast.MovieBlast$getMainPage$1 */
    /* JADX INFO: compiled from: MovieBlast.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBlast.MovieBlast", f = "MovieBlast.kt", i = {0, 0}, l = {76}, m = "getMainPage", n = {"request", "page"}, nl = {79}, s = {"L$0", "I$0"}, v = 2)
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
            return MovieBlast.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.MovieBlast.MovieBlast$load$1 */
    /* JADX INFO: compiled from: MovieBlast.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBlast.MovieBlast", f = "MovieBlast.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {140, 217, 243}, m = "load", n = {"url", "url", "json", "title", "poster", "background", "backdroppath", "overview", "releaseDate", "voteAverage", "genres", "actors", "episodes", "seasons", "isSeries", "url", "json", "title", "poster", "background", "backdroppath", "overview", "releaseDate", "voteAverage", "genres", "actors", "videoUrls", "isSeries"}, nl = {142, 231, 181}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
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
            return MovieBlast.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.MovieBlast.MovieBlast$loadLinks$1 */
    /* JADX INFO: compiled from: MovieBlast.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBlast.MovieBlast", f = "MovieBlast.kt", i = {0, 0, 0, 0, 0}, l = {267}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "links", "isCasting"}, nl = {292}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
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
            return MovieBlast.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.MovieBlast.MovieBlast$search$1 */
    /* JADX INFO: compiled from: MovieBlast.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBlast.MovieBlast", f = "MovieBlast.kt", i = {0, 0, 0}, l = {98}, m = "search", n = {"query", "safeQuery", "headers"}, nl = {99}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C00061 extends ContinuationImpl {
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
            return MovieBlast.this.search(null, (Continuation) this);
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

    /* JADX INFO: compiled from: MovieBlast.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/MovieBlast/MovieBlast$Companion;", "", "<init>", "()V", "headers", "", "", "getHeaders", "()Ljava/util/Map;", "token", "getToken", "()Ljava/lang/String;", "MovieBlast"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Map<String, String> getHeaders() {
            return MovieBlast.headers;
        }

        @NotNull
        public final String getToken() {
            return MovieBlast.token;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
    
        if (r0.equals("serie") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        if (r0.equals("show") != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        if (r0.equals("tv") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003f, code lost:
    
        if (r0.equals("series") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
    
        return true;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isSeries(HomeDaum $this$isSeries) {
        String lowerCase;
        String type = $this$isSeries.getType();
        String lowerCase2 = null;
        if (type != null) {
            lowerCase = type.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase != null) {
            switch (lowerCase.hashCode()) {
                case -905838985:
                    break;
                case 3714:
                    break;
                case 3529469:
                    break;
                case 109326716:
                    break;
            }
        }
        String contentType = $this$isSeries.getContentType();
        if (contentType != null) {
            lowerCase2 = contentType.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        }
        return Intrinsics.areEqual(lowerCase2, "series");
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
        Object safe;
        List items;
        List<HomeDaum> data;
        Sequence sequenceAsSequence;
        Sequence sequenceMapNotNull;
        Sequence sequenceDistinctBy;
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
                String str = getMainUrl() + '/' + request.getData() + '/' + token + "?page=" + page;
                Map<String, String> map = headers;
                c00001.L$0 = request;
                c00001.I$0 = page;
                c00001.label = 1;
                $result = Requests.get$default(app, str, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4092, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
            case 1:
                int i = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Home.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        Home res = (Home) safe;
        if (res == null || (data = res.getData()) == null || (sequenceAsSequence = CollectionsKt.asSequence(data)) == null || (sequenceMapNotNull = SequencesKt.mapNotNull(sequenceAsSequence, new Function1() { // from class: com.MovieBlast.MovieBlast$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return this.f$0.toSearchResultSafe((HomeDaum) obj);
            }
        })) == null || (sequenceDistinctBy = SequencesKt.distinctBy(sequenceMapNotNull, new Function1() { // from class: com.MovieBlast.MovieBlast$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return MovieBlast.getMainPage$lambda$1((SearchResponse) obj);
            }
        })) == null || (items = SequencesKt.toList(sequenceDistinctBy)) == null) {
            items = CollectionsKt.emptyList();
        }
        return MainAPIKt.newHomePageResponse$default(request2.getName(), items, (Boolean) null, 4, (Object) null);
    }

    static final String getMainPage$lambda$1(SearchResponse it) {
        String url = it.getUrl();
        if (StringsKt.isBlank(url)) {
            url = it.getName() + '-' + it.getPosterUrl();
        }
        return url;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00061 c00061;
        boolean z;
        Object safe;
        if (continuation instanceof C00061) {
            c00061 = (C00061) continuation;
            if ((c00061.label & Integer.MIN_VALUE) != 0) {
                c00061.label -= Integer.MIN_VALUE;
            } else {
                c00061 = new C00061(continuation);
            }
        } else {
            c00061 = new C00061(continuation);
        }
        C00061 c00062 = c00061;
        Object $result = c00062.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00062.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String safeQuery = StringsKt.replace$default(StringsKt.trim(query).toString(), " ", "%20", false, 4, (Object) null);
                Map headers2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("hash256", MainAPIKt.base64Decode("ODZkYzAzMjQ0YWRkZGIzY2JlZGJmMGFlMzYwNzRhNzM2ZWUyOTNhNjQ3NzRiMThlODJhNjI0NGVhZmQwZGYzMA==")), TuplesKt.to("packagename", StringsKt.trim(MainAPIKt.base64Decode("Y29tLm1vdmllYmxhc3QNCg==")).toString()), TuplesKt.to("signature", MainAPIKt.base64Decode("MzA4MjAyZTQzMDgyMDFjYzAyMDEwMTMwMGQwNjA5MmE4NjQ4ODZmNzBkMDEwMTA1MDUwMDMwMzczMTE2MzAxNDA2MDM1NTA0MDMwYzBkNDE2ZTY0NzI2ZjY5NjQyMDQ0NjU2Mjc1NjczMTEwMzAwZTA2MDM1NTA0MGEwYzA3NDE2ZTY0NzI2ZjY5NjQzMTBiMzAwOTA2MDM1NTA0MDYxMzAyNTU1MzMwMjAxNzBkMzIzNDMxMzIzMTM5MzEzNTMyMzMzNTMzNWExODBmMzIzMDM1MzQzMTMyMzEzMjMxMzUzMjMzMzUzMzVhMzAzNzMxMTYzMDE0MDYwMzU1MDQwMzBjMGQ0MTZlNjQ3MjZmNjk2NDIwNDQ2NTYyNzU2NzMxMTAzMDBlMDYwMzU1MDQwYTBjMDc0MTZlNjQ3MjZmNjk2NDMxMGIzMDA5MDYwMzU1MDQwNjEzMDI1NTUzMzA4MjAxMjIzMDBkMDYwOTJhODY0ODg2ZjcwZDAxMDEwMTA1MDAwMzgyMDEwZjAwMzA4MjAxMGEwMjgyMDEwMTAwYmU1OWEzNGJkYWYyZDI1MzFlMjUyYWE1ZTJmMDg0ODkzMDJmNjYxNTE0YzYyOWMwZjQwM2M3MzZiMWY4OTEwYmJhYzM1Mzg5OWQ4YzI5ZDkzZTE4ODQxZGQxNTc5OTkwN2Q4MTM2OTk5YmI3NTFhMjlkNjU3ZTU0MDMzNjRlMTBiODZjOWI1ZWFhYjRjODY4MDNmN2RmMTZjNDc0OTQ5OWUwMGUxOThlOGY4ZGJlODdjMTdlZDU5OTdjMzk1ZWRhZmE0OWQzN2IxNTliYWVmZWNkYzhlMTU1Mzg2MDQ0ZjIyNGJhMmJmYTM2MzllZmM0YWM0YTYzODc1ODM4MjVlZTUxM2M5ZWE1OTRkNDQ5NmNmYjY4OWE5MzM2M2U3MGFkMWM5OWY4YTIyZTBhNGUxOWZiNzBiY2JlYmVjOTM3M2U0MWE0NTVlMmU0YWEwYWY4ZDJiODk2ZTRmZjVjYjM4Y2VlNTliMmM4YmU4NjI3MWJlYTEwYjAwM2EzYTY3NDBmZDM0MmZkOTk1MDk3MjdmMmI5YTFjYmZhZTczMGY1MTU0OGI5YzczMzBjNTI1MzBiNGNjMjVhOGJkZTRjNmY1MmE3N2IyYzI2OTYyYmNkMmRjYzNmZWI1MTcwYWJlMjY5YWVjNjJlMDE4M2QxZjNkMDcyYTliNGZlODZiYjc2M2YwMjAzMDEwMDAxMzAwZDA2MDkyYTg2NDg4NmY3MGQwMTAxMDUwNTAwMDM4MjAxMDEwMDM2NDU1MTA5NzNkYjA3ODIzZTlkY2I5YzA1N2RhN2RkYTE4M2M2NzFhMzhlZGUxYjYwOGJjNzkxNzQwNWJiZDZlM2Y5NTVkMzFkZmU2ZWIyMjAzOGMxODE4YjgzYTczMzVlMzA2MDZkZGFjMzMxYjVkYjI5MDYzYzhkM2MxZTdmZmQyM2VmNzUyZDFhYWJhMjhkM2NlMzFhMTZlOWViYjNlMGE1NTI5ZDc3NDdmZWY2ZGE3OWZjMTljMjQ2NzZjMWQ4MTJkMjA5ZDJhMmRhM2E4ZmE2YTQzZDhjOWE0Y2MxZTFmNWUwMzA5ZDBlNjkzNzZkZWM3YWE1ZTA2MjViZTI0ODQwOWNlZTg2MjZmODlkNjdiZDQ3N2JhZjU5MzdjMDM2MmVlZjEyNDkxYmI3OWU3OTFjZGRlMjEwZmY5Yzc4NTNkNWViZGIzZWY2ZTgxOTA0YmMwNjA0ODk2Mjk1Mzg3NTEzYzY4ZDM5YzA5MWQwZmIxMWRlOTA0OTQwMmEzY2IwZTc5NzVjMzI4ZmU4ZDM0YjlmNmVjYWUyY2E0NWYyZGFiM2IwOTA3NWJhYjEzNjA5NzdjM2FmMzc3NTkxNjgyMjU4OTJhNjJmYmY2NGY4YzI4Y2VkMjY2NGE2NWU2MWI2ODM3YmEwMTAzZTQ4NGE1OWI5YzQ3MTVkNzU5ZWUz")), TuplesKt.to("User-Agent", getName())});
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/api/search/" + safeQuery + '/' + token;
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00062.L$1 = SpillingKt.nullOutSpilledVariable(safeQuery);
                c00062.L$2 = SpillingKt.nullOutSpilledVariable(headers2);
                c00062.label = 1;
                z = true;
                $result = Requests.get$default(app, str, headers2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 4092, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(SearchRoot.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        SearchRoot res = (SearchRoot) safe;
        if (res == null) {
            return CollectionsKt.emptyList();
        }
        Iterable $this$map$iv = res.getSearch();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            final Search item = (Search) item$iv$iv;
            boolean isSeries = StringsKt.contains(item.getType(), "serie", z);
            String path = isSeries ? "series/show" : "media/detail";
            SearchRoot res2 = res;
            Iterable $this$map$iv2 = $this$map$iv;
            String href = getMainUrl() + "/api/" + path + '/' + item.getId() + '/' + token;
            destination$iv$iv.add(MainAPIKt.newMovieSearchResponse$default(this, item.getName(), href, isSeries ? TvType.TvSeries : TvType.Movie, false, new Function1() { // from class: com.MovieBlast.MovieBlast$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return MovieBlast.search$lambda$0$0(item, (MovieSearchResponse) obj);
                }
            }, 8, (Object) null));
            res = res2;
            $this$map$iv = $this$map$iv2;
            z = true;
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$0$0(Search $item, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($item.getPosterPath());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SearchResponse toSearchResultSafe(final HomeDaum $this$toSearchResultSafe) {
        Long id = $this$toSearchResultSafe.getId();
        if (id == null) {
            return null;
        }
        long id2 = id.longValue();
        String title = $this$toSearchResultSafe.getName();
        if (title == null) {
            return null;
        }
        boolean isSeries = isSeries($this$toSearchResultSafe);
        String path = isSeries ? "series/show" : "media/detail";
        TvType tvType = isSeries ? TvType.TvSeries : TvType.Movie;
        return MainAPIKt.newMovieSearchResponse$default(this, title, getMainUrl() + "/api/" + path + '/' + id2 + '/' + token, tvType, false, new Function1() { // from class: com.MovieBlast.MovieBlast$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return MovieBlast.toSearchResultSafe$lambda$0($this$toSearchResultSafe, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toSearchResultSafe$lambda$0(HomeDaum $this_toSearchResultSafe, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($this_toSearchResultSafe.getPosterPath());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x035b  */
    /* JADX WARN: Code duplicated, block: B:102:0x0379  */
    /* JADX WARN: Code duplicated, block: B:103:0x039c  */
    /* JADX WARN: Code duplicated, block: B:106:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:109:0x03cd  */
    /* JADX WARN: Code duplicated, block: B:115:0x049c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:116:0x049d  */
    /* JADX WARN: Code duplicated, block: B:118:0x04b3  */
    /* JADX WARN: Code duplicated, block: B:120:0x04bc  */
    /* JADX WARN: Code duplicated, block: B:123:0x04df  */
    /* JADX WARN: Code duplicated, block: B:125:0x04f9  */
    /* JADX WARN: Code duplicated, block: B:126:0x051c  */
    /* JADX WARN: Code duplicated, block: B:129:0x052a  */
    /* JADX WARN: Code duplicated, block: B:132:0x0546  */
    /* JADX WARN: Code duplicated, block: B:135:0x05bd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:136:0x05be  */
    /* JADX WARN: Code duplicated, block: B:141:0x01f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:144:0x029a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:153:0x03ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:156:0x052e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x0125  */
    /* JADX WARN: Code duplicated, block: B:22:0x0128  */
    /* JADX WARN: Code duplicated, block: B:26:0x013c  */
    /* JADX WARN: Code duplicated, block: B:29:0x0141  */
    /* JADX WARN: Code duplicated, block: B:32:0x0151  */
    /* JADX WARN: Code duplicated, block: B:34:0x0154  */
    /* JADX WARN: Code duplicated, block: B:35:0x0157 A[PHI: r7
      0x0157: PHI (r7v7 'it' java.lang.String) = (r7v6 'it' java.lang.String), (r7v27 'it' java.lang.String) binds: [B:28:0x013f, B:33:0x0152] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:38:0x0197  */
    /* JADX WARN: Code duplicated, block: B:39:0x0199  */
    /* JADX WARN: Code duplicated, block: B:41:0x019c  */
    /* JADX WARN: Code duplicated, block: B:42:0x019f  */
    /* JADX WARN: Code duplicated, block: B:45:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:48:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:50:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:51:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:53:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:56:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:59:0x020d  */
    /* JADX WARN: Code duplicated, block: B:62:0x022f  */
    /* JADX WARN: Code duplicated, block: B:64:0x0247  */
    /* JADX WARN: Code duplicated, block: B:66:0x0259  */
    /* JADX WARN: Code duplicated, block: B:67:0x0260  */
    /* JADX WARN: Code duplicated, block: B:69:0x0287  */
    /* JADX WARN: Code duplicated, block: B:72:0x0294  */
    /* JADX WARN: Code duplicated, block: B:75:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:78:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:79:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:82:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:85:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:87:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:90:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:92:0x0309  */
    /* JADX WARN: Code duplicated, block: B:93:0x0315  */
    /* JADX WARN: Code duplicated, block: B:95:0x031e  */
    /* JADX WARN: Code duplicated, block: B:97:0x032a  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) throws JSONException {
        C00011 c00011;
        Object obj;
        Object obj2;
        String url2;
        JSONObject json;
        String title;
        String it;
        String poster;
        String it2;
        String background;
        String backdroppath;
        String overview;
        String releaseDate;
        Double dBoxDouble;
        boolean z;
        Double voteAverage;
        JSONArray arr;
        List genres;
        JSONArray arr2;
        String title2;
        String url3;
        List actors;
        JSONArray jSONArrayOptJSONArray;
        int length;
        int i;
        int i2;
        String str;
        String str2;
        String title3;
        JSONArray vids;
        String title4;
        List videoUrls;
        String url4;
        Object objNewMovieLoadResponse;
        String url5;
        int i3;
        Collection destination$iv$iv;
        IntIterator it3;
        JSONObject it4;
        LoadURL loadURL;
        List episodes;
        JSONArray seasons;
        int i4;
        int length2;
        Object objNewTvSeriesLoadResponse;
        JSONObject seasonObj;
        final int seasonNumber;
        JSONArray eps;
        int j;
        int length3;
        JSONObject json2;
        List episodes2;
        int i5;
        int i6;
        JSONArray jSONArrayOptJSONArray2;
        int i7;
        int i8;
        JSONObject seasonObj2;
        JSONArray eps2;
        Collection destination$iv$iv2;
        JSONArray vids2;
        int $i$f$mapNotNull;
        Collection destination$iv$iv3;
        IntIterator it5;
        JSONObject it6;
        LoadURL loadURL2;
        Collection destination$iv$iv4;
        IntIterator it7;
        JSONObject obj3;
        Object $result;
        ActorData actorData;
        String name;
        Collection destination$iv$iv5;
        IntIterator it8;
        JSONObject jSONObjectOptJSONObject;
        String strOptString;
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
        Object $result2 = c00012.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00012.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                Requests app = MainActivityKt.getApp();
                c00012.L$0 = url;
                c00012.label = 1;
                obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                c00012 = c00012;
                if (obj2 == obj) {
                    return obj;
                }
                url2 = url;
                json = new JSONObject(((NiceResponse) obj2).getText());
                title = json.optString("name", json.optString("title", "Unknown"));
                it = json.optString("poster_path");
                if (StringsKt.isBlank(it)) {
                    poster = null;
                } else {
                    poster = it;
                }
                it2 = json.optString("backdrop_path_tv");
                if (StringsKt.isBlank(it2)) {
                    it2 = null;
                }
                if (it2 == null) {
                    it2 = json.optString("backdrop_path");
                    if (StringsKt.isBlank(it2)) {
                        it2 = null;
                    }
                    if (it2 == null) {
                        background = poster;
                    } else {
                        background = it2;
                    }
                } else {
                    background = it2;
                }
                Log.INSTANCE.d("Phisher", String.valueOf(poster));
                backdroppath = json.optString("backdrop_path");
                overview = json.optString("overview");
                releaseDate = json.optString("first_air_date", json.optString("release_date"));
                dBoxDouble = Boxing.boxDouble(json.optDouble("vote_average", -1.0d));
                if (dBoxDouble.doubleValue() >= 0.0d) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    voteAverage = dBoxDouble;
                } else {
                    voteAverage = null;
                }
                arr = json.optJSONArray("genres");
                if (arr != null) {
                    Iterable $this$mapNotNull$iv = RangesKt.until(0, arr.length());
                    destination$iv$iv5 = new ArrayList();
                    it8 = $this$mapNotNull$iv.iterator();
                    while (it8.hasNext()) {
                        int element$iv$iv$iv = it8.nextInt();
                        jSONObjectOptJSONObject = arr.optJSONObject(element$iv$iv$iv);
                        if (jSONObjectOptJSONObject != null) {
                            strOptString = jSONObjectOptJSONObject.optString("name");
                        } else {
                            strOptString = null;
                        }
                        if (strOptString != null) {
                            destination$iv$iv5.add(strOptString);
                        }
                    }
                    genres = (List) destination$iv$iv5;
                } else {
                    genres = CollectionsKt.emptyList();
                }
                arr2 = json.optJSONArray("casterslist");
                if (arr2 != null) {
                    Iterable $this$mapNotNull$iv2 = RangesKt.until(0, arr2.length());
                    destination$iv$iv4 = new ArrayList();
                    it7 = $this$mapNotNull$iv2.iterator();
                    while (it7.hasNext()) {
                        int element$iv$iv$iv2 = it7.nextInt();
                        obj3 = arr2.optJSONObject(element$iv$iv$iv2);
                        if (obj3 != null) {
                            $result = $result2;
                            name = obj3.optString("original_name");
                            if (name == null) {
                                actorData = null;
                            } else {
                                actorData = new ActorData(new Actor(name, obj3.optString("profile_path")), (ActorRole) null, obj3.optString("character"), (Actor) null, 10, (DefaultConstructorMarker) null);
                            }
                        } else {
                            $result = $result2;
                            actorData = null;
                        }
                        if (actorData != null) {
                            destination$iv$iv4.add(actorData);
                        }
                        $result2 = $result;
                        title = title;
                        url2 = url2;
                    }
                    title2 = title;
                    url3 = url2;
                    actors = (List) destination$iv$iv4;
                } else {
                    title2 = title;
                    url3 = url2;
                    actors = CollectionsKt.emptyList();
                }
                jSONArrayOptJSONArray = json.optJSONArray("seasons");
                if (jSONArrayOptJSONArray != null) {
                    length = jSONArrayOptJSONArray.length();
                } else {
                    length = 0;
                }
                if (length > 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                i2 = i;
                str = "server";
                str2 = "link";
                if (i2 != 0) {
                    title3 = title2;
                    vids = json.optJSONArray("videos");
                    if (vids != null) {
                        i3 = 0;
                        Iterable $this$mapNotNull$iv3 = RangesKt.until(0, vids.length());
                        destination$iv$iv = new ArrayList();
                        it3 = $this$mapNotNull$iv3.iterator();
                        while (it3.hasNext()) {
                            int element$iv$iv$iv3 = it3.nextInt();
                            String title5 = title3;
                            it4 = vids.optJSONObject(element$iv$iv$iv3);
                            if (it4 != null) {
                                loadURL = new LoadURL(it4.optString(str2), it4.optString(str), it4.optString("lang"));
                            } else {
                                loadURL = null;
                            }
                            if (loadURL != null) {
                                destination$iv$iv.add(loadURL);
                            }
                            i3 = i3;
                            vids = vids;
                            str2 = str2;
                            str = str;
                            title3 = title5;
                        }
                        title4 = title3;
                        videoUrls = (List) destination$iv$iv;
                    } else {
                        title4 = title3;
                        videoUrls = CollectionsKt.emptyList();
                    }
                    TvType tvType = TvType.Movie;
                    String json3 = AppUtils.INSTANCE.toJson(videoUrls);
                    C00034 c00034 = new C00034(poster, background, backdroppath, overview, genres, releaseDate, voteAverage, actors, json, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(json);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(title4);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(background);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(backdroppath);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(overview);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(releaseDate);
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(voteAverage);
                    c00012.L$9 = SpillingKt.nullOutSpilledVariable(genres);
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(actors);
                    c00012.L$11 = SpillingKt.nullOutSpilledVariable(videoUrls);
                    c00012.I$0 = i2;
                    c00012.label = 3;
                    url4 = url3;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title4, url4, tvType, json3, c00034, c00012);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    url5 = url4;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                episodes = new ArrayList();
                seasons = json.optJSONArray("seasons");
                if (seasons == null) {
                    seasons = new JSONArray();
                }
                i4 = 0;
                length2 = seasons.length();
                while (i4 < length2) {
                    seasonObj = seasons.getJSONObject(i4);
                    seasonNumber = seasonObj.optInt("season_number", 0);
                    eps = seasonObj.optJSONArray("episodes");
                    if (eps == null) {
                        json2 = json;
                        episodes2 = episodes;
                        i5 = i4;
                        i6 = length2;
                    } else {
                        j = 0;
                        length3 = eps.length();
                        while (j < length3) {
                            int i9 = length3;
                            final JSONObject ep = eps.getJSONObject(j);
                            jSONArrayOptJSONArray2 = ep.optJSONArray("videos");
                            if (jSONArrayOptJSONArray2 != null) {
                                vids2 = jSONArrayOptJSONArray2;
                                Iterable $this$mapNotNull$iv4 = RangesKt.until(0, vids2.length());
                                $i$f$mapNotNull = 0;
                                destination$iv$iv3 = new ArrayList();
                                it5 = $this$mapNotNull$iv4.iterator();
                                while (it5.hasNext()) {
                                    int element$iv$iv$iv4 = it5.nextInt();
                                    int $i$f$mapNotNull2 = $i$f$mapNotNull;
                                    JSONArray vids3 = vids2;
                                    int i10 = i4;
                                    it6 = vids3.optJSONObject(element$iv$iv$iv4);
                                    if (it6 != null) {
                                        loadURL2 = new LoadURL(it6.optString("link"), it6.optString("server"), it6.optString("lang"));
                                    } else {
                                        loadURL2 = null;
                                    }
                                    if (loadURL2 != null) {
                                        destination$iv$iv3.add(loadURL2);
                                    }
                                    i4 = i10;
                                    $i$f$mapNotNull = $i$f$mapNotNull2;
                                    length2 = length2;
                                    vids2 = vids3;
                                    seasonObj = seasonObj;
                                    eps = eps;
                                }
                                i8 = length2;
                                seasonObj2 = seasonObj;
                                eps2 = eps;
                                i7 = i4;
                                destination$iv$iv2 = (List) destination$iv$iv3;
                            } else {
                                i7 = i4;
                                i8 = length2;
                                seasonObj2 = seasonObj;
                                eps2 = eps;
                                destination$iv$iv2 = CollectionsKt.emptyList();
                            }
                            episodes.add(MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(destination$iv$iv2), new Function1() { // from class: com.MovieBlast.MovieBlast$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj4) {
                                    return MovieBlast.load$lambda$7(ep, seasonNumber, (Episode) obj4);
                                }
                            }));
                            j++;
                            length3 = i9;
                            i4 = i7;
                            episodes = episodes;
                            json = json;
                            length2 = i8;
                            seasonObj = seasonObj2;
                            eps = eps2;
                        }
                        json2 = json;
                        episodes2 = episodes;
                        i5 = i4;
                        i6 = length2;
                    }
                    i4 = i5 + 1;
                    seasons = seasons;
                    episodes = episodes2;
                    json = json2;
                    length2 = i6;
                }
                JSONObject json4 = json;
                List episodes3 = episodes;
                TvType tvType2 = TvType.TvSeries;
                C00023 c00023 = new C00023(poster, background, backdroppath, overview, genres, releaseDate, voteAverage, actors, json4, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(json4);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(background);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(backdroppath);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(overview);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(releaseDate);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(voteAverage);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(genres);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(actors);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodes3);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(seasons);
                c00012.I$0 = i2;
                c00012.label = 2;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title2, url3, tvType2, episodes3, c00023, c00012);
                if (objNewTvSeriesLoadResponse == obj) {
                    return obj;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 1:
                String url6 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result2);
                url2 = url6;
                obj = coroutine_suspended;
                obj2 = $result2;
                json = new JSONObject(((NiceResponse) obj2).getText());
                title = json.optString("name", json.optString("title", "Unknown"));
                it = json.optString("poster_path");
                if (StringsKt.isBlank(it)) {
                    poster = it;
                } else {
                    poster = null;
                }
                it2 = json.optString("backdrop_path_tv");
                if (StringsKt.isBlank(it2)) {
                    it2 = null;
                }
                if (it2 == null) {
                    it2 = json.optString("backdrop_path");
                    if (StringsKt.isBlank(it2)) {
                        it2 = null;
                    }
                    if (it2 == null) {
                        background = poster;
                    } else {
                        background = it2;
                    }
                } else {
                    background = it2;
                }
                Log.INSTANCE.d("Phisher", String.valueOf(poster));
                backdroppath = json.optString("backdrop_path");
                overview = json.optString("overview");
                releaseDate = json.optString("first_air_date", json.optString("release_date"));
                dBoxDouble = Boxing.boxDouble(json.optDouble("vote_average", -1.0d));
                if (dBoxDouble.doubleValue() >= 0.0d) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    voteAverage = dBoxDouble;
                } else {
                    voteAverage = null;
                }
                arr = json.optJSONArray("genres");
                if (arr != null) {
                    Iterable $this$mapNotNull$iv5 = RangesKt.until(0, arr.length());
                    destination$iv$iv5 = new ArrayList();
                    it8 = $this$mapNotNull$iv5.iterator();
                    while (it8.hasNext()) {
                        int element$iv$iv$iv5 = it8.nextInt();
                        jSONObjectOptJSONObject = arr.optJSONObject(element$iv$iv$iv5);
                        if (jSONObjectOptJSONObject != null) {
                            strOptString = jSONObjectOptJSONObject.optString("name");
                        } else {
                            strOptString = null;
                        }
                        if (strOptString != null) {
                            destination$iv$iv5.add(strOptString);
                        }
                    }
                    genres = (List) destination$iv$iv5;
                } else {
                    genres = CollectionsKt.emptyList();
                }
                arr2 = json.optJSONArray("casterslist");
                if (arr2 != null) {
                    Iterable $this$mapNotNull$iv6 = RangesKt.until(0, arr2.length());
                    destination$iv$iv4 = new ArrayList();
                    it7 = $this$mapNotNull$iv6.iterator();
                    while (it7.hasNext()) {
                        int element$iv$iv$iv6 = it7.nextInt();
                        obj3 = arr2.optJSONObject(element$iv$iv$iv6);
                        if (obj3 != null) {
                            $result = $result2;
                            name = obj3.optString("original_name");
                            if (name == null) {
                                actorData = null;
                            } else {
                                actorData = new ActorData(new Actor(name, obj3.optString("profile_path")), (ActorRole) null, obj3.optString("character"), (Actor) null, 10, (DefaultConstructorMarker) null);
                            }
                        } else {
                            $result = $result2;
                            actorData = null;
                        }
                        if (actorData != null) {
                            destination$iv$iv4.add(actorData);
                        }
                        $result2 = $result;
                        title = title;
                        url2 = url2;
                    }
                    title2 = title;
                    url3 = url2;
                    actors = (List) destination$iv$iv4;
                } else {
                    title2 = title;
                    url3 = url2;
                    actors = CollectionsKt.emptyList();
                }
                jSONArrayOptJSONArray = json.optJSONArray("seasons");
                if (jSONArrayOptJSONArray != null) {
                    length = jSONArrayOptJSONArray.length();
                } else {
                    length = 0;
                }
                if (length > 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                i2 = i;
                str = "server";
                str2 = "link";
                if (i2 != 0) {
                    title3 = title2;
                    vids = json.optJSONArray("videos");
                    if (vids != null) {
                        i3 = 0;
                        Iterable $this$mapNotNull$iv7 = RangesKt.until(0, vids.length());
                        destination$iv$iv = new ArrayList();
                        it3 = $this$mapNotNull$iv7.iterator();
                        while (it3.hasNext()) {
                            int element$iv$iv$iv7 = it3.nextInt();
                            String title6 = title3;
                            it4 = vids.optJSONObject(element$iv$iv$iv7);
                            if (it4 != null) {
                                loadURL = new LoadURL(it4.optString(str2), it4.optString(str), it4.optString("lang"));
                            } else {
                                loadURL = null;
                            }
                            if (loadURL != null) {
                                destination$iv$iv.add(loadURL);
                            }
                            i3 = i3;
                            vids = vids;
                            str2 = str2;
                            str = str;
                            title3 = title6;
                        }
                        title4 = title3;
                        videoUrls = (List) destination$iv$iv;
                    } else {
                        title4 = title3;
                        videoUrls = CollectionsKt.emptyList();
                    }
                    TvType tvType3 = TvType.Movie;
                    String json5 = AppUtils.INSTANCE.toJson(videoUrls);
                    C00034 c00035 = new C00034(poster, background, backdroppath, overview, genres, releaseDate, voteAverage, actors, json, null);
                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(json);
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(title4);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster);
                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(background);
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(backdroppath);
                    c00012.L$6 = SpillingKt.nullOutSpilledVariable(overview);
                    c00012.L$7 = SpillingKt.nullOutSpilledVariable(releaseDate);
                    c00012.L$8 = SpillingKt.nullOutSpilledVariable(voteAverage);
                    c00012.L$9 = SpillingKt.nullOutSpilledVariable(genres);
                    c00012.L$10 = SpillingKt.nullOutSpilledVariable(actors);
                    c00012.L$11 = SpillingKt.nullOutSpilledVariable(videoUrls);
                    c00012.I$0 = i2;
                    c00012.label = 3;
                    url4 = url3;
                    objNewMovieLoadResponse = MainAPIKt.newMovieLoadResponse(this, title4, url4, tvType3, json5, c00035, c00012);
                    if (objNewMovieLoadResponse == obj) {
                        return obj;
                    }
                    url5 = url4;
                    return (LoadResponse) objNewMovieLoadResponse;
                }
                episodes = new ArrayList();
                seasons = json.optJSONArray("seasons");
                if (seasons == null) {
                    seasons = new JSONArray();
                }
                i4 = 0;
                length2 = seasons.length();
                while (i4 < length2) {
                    seasonObj = seasons.getJSONObject(i4);
                    seasonNumber = seasonObj.optInt("season_number", 0);
                    eps = seasonObj.optJSONArray("episodes");
                    if (eps == null) {
                        json2 = json;
                        episodes2 = episodes;
                        i5 = i4;
                        i6 = length2;
                    } else {
                        j = 0;
                        length3 = eps.length();
                        while (j < length3) {
                            int i11 = length3;
                            final JSONObject ep2 = eps.getJSONObject(j);
                            jSONArrayOptJSONArray2 = ep2.optJSONArray("videos");
                            if (jSONArrayOptJSONArray2 != null) {
                                vids2 = jSONArrayOptJSONArray2;
                                Iterable $this$mapNotNull$iv8 = RangesKt.until(0, vids2.length());
                                $i$f$mapNotNull = 0;
                                destination$iv$iv3 = new ArrayList();
                                it5 = $this$mapNotNull$iv8.iterator();
                                while (it5.hasNext()) {
                                    int element$iv$iv$iv8 = it5.nextInt();
                                    int $i$f$mapNotNull3 = $i$f$mapNotNull;
                                    JSONArray vids4 = vids2;
                                    int i12 = i4;
                                    it6 = vids4.optJSONObject(element$iv$iv$iv8);
                                    if (it6 != null) {
                                        loadURL2 = new LoadURL(it6.optString("link"), it6.optString("server"), it6.optString("lang"));
                                    } else {
                                        loadURL2 = null;
                                    }
                                    if (loadURL2 != null) {
                                        destination$iv$iv3.add(loadURL2);
                                    }
                                    i4 = i12;
                                    $i$f$mapNotNull = $i$f$mapNotNull3;
                                    length2 = length2;
                                    vids2 = vids4;
                                    seasonObj = seasonObj;
                                    eps = eps;
                                }
                                i8 = length2;
                                seasonObj2 = seasonObj;
                                eps2 = eps;
                                i7 = i4;
                                destination$iv$iv2 = (List) destination$iv$iv3;
                            } else {
                                i7 = i4;
                                i8 = length2;
                                seasonObj2 = seasonObj;
                                eps2 = eps;
                                destination$iv$iv2 = CollectionsKt.emptyList();
                            }
                            episodes.add(MainAPIKt.newEpisode(this, AppUtils.INSTANCE.toJson(destination$iv$iv2), new Function1() { // from class: com.MovieBlast.MovieBlast$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj4) {
                                    return MovieBlast.load$lambda$7(ep2, seasonNumber, (Episode) obj4);
                                }
                            }));
                            j++;
                            length3 = i11;
                            i4 = i7;
                            episodes = episodes;
                            json = json;
                            length2 = i8;
                            seasonObj = seasonObj2;
                            eps = eps2;
                        }
                        json2 = json;
                        episodes2 = episodes;
                        i5 = i4;
                        i6 = length2;
                    }
                    i4 = i5 + 1;
                    seasons = seasons;
                    episodes = episodes2;
                    json = json2;
                    length2 = i6;
                }
                JSONObject json6 = json;
                List episodes4 = episodes;
                TvType tvType4 = TvType.TvSeries;
                C00023 c00024 = new C00023(poster, background, backdroppath, overview, genres, releaseDate, voteAverage, actors, json6, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(json6);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(title2);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(poster);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(background);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(backdroppath);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(overview);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(releaseDate);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(voteAverage);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(genres);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(actors);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(episodes4);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(seasons);
                c00012.I$0 = i2;
                c00012.label = 2;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(this, title2, url3, tvType4, episodes4, c00024, c00012);
                if (objNewTvSeriesLoadResponse == obj) {
                    return obj;
                }
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 2:
                int i13 = c00012.I$0;
                ResultKt.throwOnFailure($result2);
                objNewTvSeriesLoadResponse = $result2;
                return (LoadResponse) objNewTvSeriesLoadResponse;
            case 3:
                int i14 = c00012.I$0;
                url5 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result2);
                i2 = i14;
                objNewMovieLoadResponse = $result2;
                return (LoadResponse) objNewMovieLoadResponse;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final Unit load$lambda$7(JSONObject $ep, int $seasonNumber, Episode $this$newEpisode) {
        $this$newEpisode.setName($ep.optString("name"));
        $this$newEpisode.setSeason(Integer.valueOf($seasonNumber));
        $this$newEpisode.setEpisode(Integer.valueOf($ep.optInt("episode_number", 0)));
        $this$newEpisode.setDescription($ep.optString("overview"));
        MainAPIKt.addDate$default($this$newEpisode, $ep.optString("created_at"), (String) null, 2, (Object) null);
        $this$newEpisode.setPosterUrl($ep.optString("still_path_tv", $ep.optString("still_path")));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.MovieBlast.MovieBlast$load$3 */
    /* JADX INFO: compiled from: MovieBlast.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBlast.MovieBlast$load$3", f = "MovieBlast.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00023 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $backdroppath;
        final /* synthetic */ String $background;
        final /* synthetic */ List<String> $genres;
        final /* synthetic */ JSONObject $json;
        final /* synthetic */ String $overview;
        final /* synthetic */ String $poster;
        final /* synthetic */ String $releaseDate;
        final /* synthetic */ Double $voteAverage;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00023(String str, String str2, String str3, String str4, List<String> list, String str5, Double d, List<ActorData> list2, JSONObject jSONObject, Continuation<? super C00023> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$background = str2;
            this.$backdroppath = str3;
            this.$overview = str4;
            this.$genres = list;
            this.$releaseDate = str5;
            this.$voteAverage = d;
            this.$actors = list2;
            this.$json = jSONObject;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00023 = new C00023(this.$poster, this.$background, this.$backdroppath, this.$overview, this.$genres, this.$releaseDate, this.$voteAverage, this.$actors, this.$json, continuation);
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
                    String str = this.$background;
                    if (str == null && (str = this.$backdroppath) == null) {
                        str = this.$poster;
                    }
                    loadResponse.setBackgroundPosterUrl(str);
                    loadResponse.setPlot(this.$overview);
                    loadResponse.setTags(this.$genres);
                    loadResponse.setYear(StringsKt.toIntOrNull(StringsKt.substringBefore$default(this.$releaseDate, "-", (String) null, 2, (Object) null)));
                    loadResponse.setScore(Score.Companion.from10(this.$voteAverage));
                    loadResponse.setActors(this.$actors);
                    LoadResponse.Companion.addImdbId(loadResponse, this.$json.optString("imdb_external_id"));
                    LoadResponse.Companion.addTMDbId(loadResponse, String.valueOf(this.$json.optLong("tmdb_id")));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.MovieBlast.MovieBlast$load$4 */
    /* JADX INFO: compiled from: MovieBlast.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBlast.MovieBlast$load$4", f = "MovieBlast.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00034 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $backdroppath;
        final /* synthetic */ String $background;
        final /* synthetic */ List<String> $genres;
        final /* synthetic */ JSONObject $json;
        final /* synthetic */ String $overview;
        final /* synthetic */ String $poster;
        final /* synthetic */ String $releaseDate;
        final /* synthetic */ Double $voteAverage;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00034(String str, String str2, String str3, String str4, List<String> list, String str5, Double d, List<ActorData> list2, JSONObject jSONObject, Continuation<? super C00034> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$background = str2;
            this.$backdroppath = str3;
            this.$overview = str4;
            this.$genres = list;
            this.$releaseDate = str5;
            this.$voteAverage = d;
            this.$actors = list2;
            this.$json = jSONObject;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00034 = new C00034(this.$poster, this.$background, this.$backdroppath, this.$overview, this.$genres, this.$releaseDate, this.$voteAverage, this.$actors, this.$json, continuation);
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
                    String str = this.$background;
                    if (str == null) {
                        str = this.$backdroppath;
                    }
                    loadResponse.setBackgroundPosterUrl(str);
                    loadResponse.setPlot(this.$overview);
                    loadResponse.setTags(this.$genres);
                    loadResponse.setYear(StringsKt.toIntOrNull(StringsKt.substringBefore$default(this.$releaseDate, "-", (String) null, 2, (Object) null)));
                    loadResponse.setScore(Score.Companion.from10(this.$voteAverage));
                    loadResponse.setActors(this.$actors);
                    LoadResponse.Companion.addImdbId(loadResponse, this.$json.optString("imdb_external_id"));
                    LoadResponse.Companion.addTMDbId(loadResponse, String.valueOf(this.$json.optLong("tmdb_id")));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00041 c00041;
        Object obj;
        Object obj2;
        Object objDecodeFromString;
        boolean z;
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
        C00041 c00042 = c00041;
        Object $result = c00042.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00042.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppUtils appUtils = AppUtils.INSTANCE;
                if (data == null) {
                    obj = null;
                } else {
                    try {
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(LoadURL.class)));
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj2) != null) {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            } catch (Throwable th2) {
                                Result.Companion companion4 = Result.Companion;
                                obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
                            }
                        }
                        DeserializationStrategy deserializationStrategy = (KSerializer) (Result.isFailure-impl(obj2) ? null : obj2);
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                            } catch (SerializationException e) {
                                ArchComponentExtKt.logError(e);
                                ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv.readValue(data, new TypeReference<List<? extends LoadURL>>() { // from class: com.MovieBlast.MovieBlast$loadLinks$$inlined$tryParseJson$1
                                });
                            } catch (Throwable th3) {
                                ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(data, new TypeReference<List<? extends LoadURL>>() { // from class: com.MovieBlast.MovieBlast$loadLinks$$inlined$tryParseJson$1
                                });
                            }
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(data, new TypeReference<List<? extends LoadURL>>() { // from class: com.MovieBlast.MovieBlast$loadLinks$$inlined$tryParseJson$1
                            });
                        }
                        obj = objDecodeFromString;
                    } catch (Exception e2) {
                        obj = null;
                    }
                }
                List links = (List) obj;
                if (links == null) {
                    links = CollectionsKt.emptyList();
                }
                C00052 c00052 = new C00052(function2, null);
                c00042.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00042.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00042.L$3 = SpillingKt.nullOutSpilledVariable(links);
                c00042.Z$0 = isCasting;
                z = true;
                c00042.label = 1;
                if (ParCollectionsKt.amap(links, c00052, c00042) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                boolean z2 = c00042.Z$0;
                ResultKt.throwOnFailure($result);
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(z);
    }

    /* JADX INFO: renamed from: com.MovieBlast.MovieBlast$loadLinks$2 */
    /* JADX INFO: compiled from: MovieBlast.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "loadUrl", "Lcom/MovieBlast/LoadURL;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MovieBlast.MovieBlast$loadLinks$2", f = "MovieBlast.kt", i = {0, 0, 0}, l = {280}, m = "invokeSuspend", n = {"loadUrl", "headers", "signed"}, nl = {279}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C00052 extends SuspendLambda implements Function2<LoadURL, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00052(Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00052> continuation) {
            super(2, continuation);
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00052 = MovieBlast.this.new C00052(this.$callback, continuation);
            c00052.L$0 = obj;
            return c00052;
        }

        public final Object invoke(LoadURL loadURL, Continuation<? super Unit> continuation) {
            return create(loadURL, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object objNewExtractorLink;
            Function1<ExtractorLink, Unit> function1;
            LoadURL loadUrl = (LoadURL) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (loadUrl.getLink() != null) {
                        Map headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("Accept-Encoding", "identity"), TuplesKt.to("Connection", "Keep-Alive"), TuplesKt.to("Icy-MetaData", "1"), TuplesKt.to("Referer", MovieBlast.this.getName()), TuplesKt.to("User-Agent", MovieBlast.this.getName()), TuplesKt.to("x-request-x", StringsKt.trim(MainAPIKt.base64Decode("Y29tLm1vdmllYmxhc3QNCg==")).toString())});
                        String signed = MovieBlastParserKt.generateSignedUrl(MovieBlast.this.httpsify(loadUrl.getLink()));
                        Function1<ExtractorLink, Unit> function2 = this.$callback;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(loadUrl);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(headers);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(signed);
                        this.L$3 = function2;
                        this.label = 1;
                        objNewExtractorLink = ExtractorApiKt.newExtractorLink(String.valueOf(loadUrl.getServer()), MovieBlast.this.getName() + ' ' + loadUrl.getLang(), signed, ExtractorApiKt.getINFER_TYPE(), new AnonymousClass1(MovieBlast.this, loadUrl, headers, null), (Continuation) this);
                        if (objNewExtractorLink == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function1 = function2;
                        function1.invoke(objNewExtractorLink);
                    }
                    return Unit.INSTANCE;
                case 1:
                    function1 = (Function1) this.L$3;
                    ResultKt.throwOnFailure($result);
                    objNewExtractorLink = $result;
                    function1.invoke(objNewExtractorLink);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.MovieBlast.MovieBlast$loadLinks$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: MovieBlast.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.MovieBlast.MovieBlast$loadLinks$2$1", f = "MovieBlast.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            final /* synthetic */ Map<String, String> $headers;
            final /* synthetic */ LoadURL $loadUrl;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MovieBlast this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MovieBlast movieBlast, LoadURL loadURL, Map<String, String> map, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = movieBlast;
                this.$loadUrl = loadURL;
                this.$headers = map;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, this.$loadUrl, this.$headers, continuation);
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
                        $this$newExtractorLink.setQuality(this.this$0.matchQualityFromString(this.$loadUrl.getServer()));
                        $this$newExtractorLink.setHeaders(this.$headers);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    @NotNull
    public final String httpsify(@NotNull String url) {
        return !StringsKt.startsWith$default(url, "http", false, 2, (Object) null) ? "https://" + url : url;
    }

    public final int matchQualityFromString(@Nullable String s) {
        String str = s;
        if (str == null || StringsKt.isBlank(str)) {
            return Qualities.Unknown.getValue();
        }
        String v = s.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(v, "toLowerCase(...)");
        if (StringsKt.contains$default(v, "2160", false, 2, (Object) null) || StringsKt.contains$default(v, "4k", false, 2, (Object) null)) {
            return Qualities.P2160.getValue();
        }
        if (StringsKt.contains$default(v, "1440", false, 2, (Object) null)) {
            return Qualities.P1440.getValue();
        }
        if (StringsKt.contains$default(v, "1080", false, 2, (Object) null) || StringsKt.contains$default(v, "fullhd", false, 2, (Object) null)) {
            return Qualities.P1080.getValue();
        }
        if (StringsKt.contains$default(v, "720", false, 2, (Object) null) || StringsKt.contains$default(v, "hd", false, 2, (Object) null)) {
            return Qualities.P720.getValue();
        }
        if (StringsKt.contains$default(v, "480", false, 2, (Object) null)) {
            return Qualities.P480.getValue();
        }
        return StringsKt.contains$default(v, "360", false, 2, (Object) null) ? Qualities.P360.getValue() : Qualities.Unknown.getValue();
    }
}
