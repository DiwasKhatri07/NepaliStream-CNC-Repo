package com.MPlayer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.ErrorLoadingException;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: MPlayer.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MPlayerProvider/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001IB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\f\u0010&\u001a\u00020'*\u00020(H\u0002J\f\u0010&\u001a\u00020'*\u00020)H\u0002J\u0010\u0010*\u001a\u0004\u0018\u00010\n2\u0006\u0010+\u001a\u00020(J\u0010\u0010*\u001a\u0004\u0018\u00010\n2\u0006\u0010+\u001a\u00020)J\u0010\u0010,\u001a\u0004\u0018\u00010\n2\u0006\u0010-\u001a\u00020\nJ\u0010\u0010.\u001a\u0004\u0018\u00010\n2\u0006\u0010+\u001a\u00020(J\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020'002\u0006\u00101\u001a\u00020\nH\u0096@¢\u0006\u0002\u00102J\u0018\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020\nH\u0096@¢\u0006\u0002\u00102JF\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\u00162\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<0:2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020<0:H\u0096@¢\u0006\u0002\u0010?J(\u0010@\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\n0A002\u0006\u00105\u001a\u00020\nH\u0082@¢\u0006\u0002\u00102J\"\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0C*\u00020D2\b\b\u0002\u0010E\u001a\u00020\nH\u0002J\u0010\u0010F\u001a\u0004\u0018\u00010\n*\u0004\u0018\u00010GH\u0002J\u0014\u0010H\u001a\u0004\u0018\u00010\n2\b\u00105\u001a\u0004\u0018\u00010\nH\u0002R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u0016X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\f¨\u0006J"}, d2 = {"Lcom/MPlayer/MPlayer;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "imageUrl", "userID", "webApi", "endpointurl", "endParam", "getEndParam", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lcom/MPlayer/MovieItem;", "Lcom/MPlayer/Item;", "getPortraitLargeImageUrl", "item", "getMovieBigPic", "jsonString", "getMBigPic", "search", "", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSeasonData", "Lkotlin/Pair;", "getCookies", "", "Lokhttp3/Headers;", "cookieKey", "bestVariant", "Lorg/json/JSONObject;", "normalizeUrl", "LoadUrl", "MPlayerProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMPlayer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MPlayer.kt\ncom/MPlayer/MPlayer\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,522:1\n1739#2:523\n1814#2,3:524\n1739#2:527\n1814#2,3:528\n1739#2:531\n1814#2,3:532\n1739#2:535\n1814#2,3:536\n1739#2:539\n1814#2,3:540\n296#2,2:543\n296#2,2:546\n296#2,2:548\n296#2,2:550\n1739#2:552\n1814#2,3:553\n1739#2:556\n1814#2,3:557\n1739#2:560\n1814#2,3:561\n777#2:564\n873#2,2:565\n2068#2:567\n2068#2,2:568\n2069#2:570\n1795#2,10:571\n2068#2:581\n2069#2:583\n1805#2:584\n777#2:585\n873#2,2:586\n1795#2,10:588\n2068#2:598\n2069#2:600\n1805#2:601\n1358#2,2:602\n1435#2,4:604\n1#3:545\n1#3:582\n1#3:599\n684#4:608\n669#4,6:609\n*S KotlinDebug\n*F\n+ 1 MPlayer.kt\ncom/MPlayer/MPlayer\n*L\n58#1:523\n58#1:524,3\n67#1:527\n67#1:528,3\n76#1:531\n76#1:532,3\n84#1:535\n84#1:536,3\n92#1:539\n92#1:540,3\n122#1:543,2\n129#1:546,2\n136#1:548,2\n142#1:550,2\n217#1:552\n217#1:553,3\n240#1:556\n240#1:557,3\n313#1:560\n313#1:561,3\n314#1:564\n314#1:565,2\n350#1:567\n369#1:568,2\n350#1:570\n464#1:571,10\n464#1:581\n464#1:583\n464#1:584\n480#1:585\n480#1:586,2\n480#1:588,10\n480#1:598\n480#1:600\n480#1:601\n484#1:602,2\n484#1:604,4\n464#1:582\n480#1:599\n487#1:608\n487#1:609,6\n*E\n"})
public final class MPlayer extends MainAPI {

    @Nullable
    private String userID;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.AsianDrama});

    @NotNull
    private String lang = "hi";

    @NotNull
    private String mainUrl = "https://www.mxplayer.in";

    @NotNull
    private String name = "M Player";
    private final boolean hasMainPage = true;

    @NotNull
    private String imageUrl = "https://qqcdnpictest.mxplay.com/";

    @NotNull
    private final String webApi = "https://api.mxplayer.in/v1/web";

    @NotNull
    private final String endpointurl = "https://d3sgzbosmwirao.cloudfront.net/";

    /* JADX INFO: renamed from: com.MPlayer.MPlayer$getMainPage$1 */
    /* JADX INFO: compiled from: MPlayer.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MPlayer.MPlayer", f = "MPlayer.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {49, 53, 62, 71, 80, 88}, m = "getMainPage", n = {"request", "page", "request", "res", "page", "request", "res", "dramaResponse", "dramaRoot", "dramashows", "page", "request", "res", "dramaResponse", "dramaRoot", "dramashows", "crimeResponse", "crimeRoot", "crime_shows", "page", "request", "res", "dramaResponse", "dramaRoot", "dramashows", "crimeResponse", "crimeRoot", "crime_shows", "thrillerResponse", "thrillerRoot", "thriller_shows", "page", "request", "res", "dramaResponse", "dramaRoot", "dramashows", "crimeResponse", "crimeRoot", "crime_shows", "thrillerResponse", "thrillerRoot", "thriller_shows", "hindimovieresponse", "movieRoot", "hindi_Movies", "page"}, nl = {50, 56, 65, 74, 82, 90}, s = {"L$0", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "I$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
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

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MPlayer.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.MPlayer.MPlayer$getSeasonData$1 */
    /* JADX INFO: compiled from: MPlayer.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MPlayer.MPlayer", f = "MPlayer.kt", i = {0}, l = {463}, m = "getSeasonData", n = {"url"}, nl = {464}, s = {"L$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MPlayer.this.getSeasonData(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.MPlayer.MPlayer$load$1 */
    /* JADX INFO: compiled from: MPlayer.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MPlayer.MPlayer", f = "MPlayer.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {347, 361, 407, 415}, m = "load", n = {"url", "gson", "video", "title", "poster", "type", "languages", "alternativeUrls", "hrefList", "epposter", "url", "gson", "video", "title", "poster", "type", "languages", "alternativeUrls", "hrefList", "epposter", "seasonData", "episodes", "$this$forEach$iv", "element$iv", "seasonId", "episodeNumber", "nextQuery", "apiUrl", "season", "page", "url", "gson", "video", "title", "poster", "type", "languages", "alternativeUrls", "hrefList", "epposter", "seasonData", "episodes", "url", "gson", "video", "title", "poster", "type", "languages", "alternativeUrls", "hrefList"}, nl = {348, 363, 415, 345}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$14", "L$15", "L$16", "L$17", "L$18", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        int I$0;
        int I$1;
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

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MPlayer.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.MPlayer.MPlayer$loadLinks$1 */
    /* JADX INFO: compiled from: MPlayer.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MPlayer.MPlayer", f = "MPlayer.kt", i = {0, 0, 0, 0, 0}, l = {440}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "urls", "isCasting"}, nl = {459}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
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
            return MPlayer.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.MPlayer.MPlayer$search$1 */
    /* JADX INFO: compiled from: MPlayer.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MPlayer.MPlayer", f = "MPlayer.kt", i = {0}, l = {147}, m = "search", n = {"query"}, nl = {151}, s = {"L$0"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MPlayer.this.search(null, (Continuation) this);
        }
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @NotNull
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
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

    private final String getEndParam() {
        return "&device-density=2&userid=" + this.userID + "&platform=com.mxplay.desktop&content-languages=hi,en&kids-mode-enabled=false";
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: com.lagradost.cloudstream3.ErrorLoadingException */
    /* JADX WARN: Code duplicated, block: B:24:0x020b  */
    /* JADX WARN: Code duplicated, block: B:26:0x0294 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x0295  */
    /* JADX WARN: Code duplicated, block: B:31:0x02d5 A[LOOP:4: B:29:0x02cf->B:31:0x02d5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x0372 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x0373  */
    /* JADX WARN: Code duplicated, block: B:39:0x03b3 A[LOOP:3: B:37:0x03ad->B:39:0x03b3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:42:0x045e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x045f  */
    /* JADX WARN: Code duplicated, block: B:47:0x04a1 A[LOOP:2: B:45:0x049b->B:47:0x04a1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:50:0x0567 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:51:0x0568  */
    /* JADX WARN: Code duplicated, block: B:55:0x05ab A[LOOP:1: B:53:0x05a5->B:55:0x05ab, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:58:0x067f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:59:0x0680  */
    /* JADX WARN: Code duplicated, block: B:63:0x06c4 A[LOOP:0: B:61:0x06be->B:63:0x06c4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x0732  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Type inference failed for: r10v36, types: [com.MPlayer.MPlayer$getMainPage$movieRoot$1] */
    /* JADX WARN: Type inference failed for: r5v45, types: [com.MPlayer.MPlayer$getMainPage$movieRootte$1] */
    /* JADX WARN: Type inference failed for: r7v11, types: [com.MPlayer.MPlayer$getMainPage$dramaRoot$1] */
    /* JADX WARN: Type inference failed for: r8v14, types: [com.MPlayer.MPlayer$getMainPage$crimeRoot$1] */
    /* JADX WARN: Type inference failed for: r9v22, types: [com.MPlayer.MPlayer$getMainPage$thrillerRoot$1] */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws ErrorLoadingException {
        C00001 c00001;
        String str;
        Object obj;
        int page2;
        C00001 c00002;
        MainPageRequest request2;
        Object obj2;
        int page3;
        NiceResponse res;
        String str2;
        int page4;
        String str3;
        char c;
        char c2;
        Object obj3;
        C00001 c00003;
        Object obj4;
        int page5;
        MXPlayer dramaRoot;
        Collection destination$iv$iv;
        List dramashows;
        int page6;
        String dramaResponse;
        int page7;
        Object obj5;
        C00001 c00004;
        Object obj6;
        int page8;
        List dramashows2;
        MXPlayer crimeRoot;
        Collection destination$iv$iv2;
        List crime_shows;
        int page9;
        List dramashows3;
        String crimeResponse;
        Object obj7;
        C00001 c00005;
        Object obj8;
        List dramashows4;
        int page10;
        List crime_shows2;
        MXPlayer thrillerRoot;
        Collection destination$iv$iv3;
        List thriller_shows;
        List dramashows5;
        int page11;
        List crime_shows3;
        String thrillerResponse;
        String str4;
        C00001 c00006;
        int page12;
        List crime_shows4;
        List dramashows6;
        List crime_shows5;
        Collection destination$iv$iv4;
        List hindi_Movies;
        List dramashows7;
        List thriller_shows2;
        List crime_shows6;
        List hindi_Movies2;
        List dramashows8;
        List thriller_shows3;
        Collection destination$iv$iv5;
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
                Requests app = UtilsKt.getApp();
                String mainUrl = getMainUrl();
                c00001.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00001.I$0 = page;
                c00001.label = 1;
                str = "/detail/browseItem?&pageNum=";
                C00001 c00007 = c00001;
                obj = coroutine_suspended;
                page2 = 1;
                Object obj9 = Requests.get$default(app, mainUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00007, 4094, (Object) null);
                c00002 = c00007;
                if (obj9 == obj) {
                    return obj;
                }
                request2 = request;
                obj2 = obj9;
                page3 = page;
                res = (NiceResponse) obj2;
                str2 = (String) getCookies$default(this, res.getOkhttpResponse().headers(), null, page2, null).get("UserID");
                if (str2 != null) {
                    throw new ErrorLoadingException("load fail, geo blocked");
                }
                this.userID = str2;
                Requests app2 = UtilsKt.getApp();
                String str5 = this.webApi + str + page3 + "&pageSize=20&isCustomized=true&genreFilterIds=48efa872f6f17facebf6149dfc536ee1&type=2" + getEndParam();
                String str6 = getMainUrl() + '/';
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00002.I$0 = page3;
                c00002.label = 2;
                page4 = page3;
                C00001 c00008 = c00002;
                str3 = str;
                c = '/';
                c2 = 1;
                obj3 = Requests.get$default(app2, str5, (Map) null, str6, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00008, 4090, (Object) null);
                c00003 = c00008;
                if (obj3 == obj) {
                    return obj;
                }
                obj4 = obj3;
                page5 = page4;
                String dramaResponse2 = ((NiceResponse) obj4).toString();
                dramaRoot = (MXPlayer) new Gson().fromJson(dramaResponse2, new TypeToken<MXPlayer>() { // from class: com.MPlayer.MPlayer$getMainPage$dramaRoot$1
                }.getType());
                Iterable $this$map$iv = dramaRoot.getItems();
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Item item = (Item) item$iv$iv;
                    destination$iv$iv.add(toSearchResult(item));
                }
                dramashows = (List) destination$iv$iv;
                Requests app3 = UtilsKt.getApp();
                String str7 = this.webApi + "/detail/browseItem?&pageNum=1&pageSize=20&isCustomized=true&genreFilterIds=b413dff55bdad743c577a8bea3b65044&type=2" + getEndParam();
                String str8 = getMainUrl() + c;
                c00003.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00003.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00003.L$2 = SpillingKt.nullOutSpilledVariable(dramaResponse2);
                c00003.L$3 = SpillingKt.nullOutSpilledVariable(dramaRoot);
                c00003.L$4 = dramashows;
                c00003.I$0 = page5;
                c00003.label = 3;
                page6 = page5;
                C00001 c00009 = c00003;
                dramaResponse = dramaResponse2;
                page7 = 10;
                obj5 = Requests.get$default(app3, str7, (Map) null, str8, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00009, 4090, (Object) null);
                c00004 = c00009;
                if (obj5 == obj) {
                    return obj;
                }
                obj6 = obj5;
                page8 = page6;
                dramashows2 = dramashows;
                String crimeResponse2 = ((NiceResponse) obj6).toString();
                crimeRoot = (MXPlayer) new Gson().fromJson(crimeResponse2, new TypeToken<MXPlayer>() { // from class: com.MPlayer.MPlayer$getMainPage$crimeRoot$1
                }.getType());
                Iterable $this$map$iv2 = crimeRoot.getItems();
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, page7));
                for (Object item$iv$iv2 : $this$map$iv2) {
                    Item item2 = (Item) item$iv$iv2;
                    destination$iv$iv2.add(toSearchResult(item2));
                }
                crime_shows = (List) destination$iv$iv2;
                Requests app4 = UtilsKt.getApp();
                String str9 = this.webApi + "/detail/browseItem?&pageNum=1&pageSize=20&isCustomized=true&genreFilterIds=2dd5daf25be5619543524f360c73c3d8&type=2" + getEndParam();
                String str10 = getMainUrl() + '/';
                c00004.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00004.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00004.L$2 = SpillingKt.nullOutSpilledVariable(dramaResponse);
                c00004.L$3 = SpillingKt.nullOutSpilledVariable(dramaRoot);
                c00004.L$4 = dramashows2;
                c00004.L$5 = SpillingKt.nullOutSpilledVariable(crimeResponse2);
                c00004.L$6 = SpillingKt.nullOutSpilledVariable(crimeRoot);
                c00004.L$7 = crime_shows;
                c00004.I$0 = page8;
                c00004.label = 4;
                page9 = page8;
                C00001 c000010 = c00004;
                dramashows3 = dramashows2;
                crimeResponse = crimeResponse2;
                obj7 = Requests.get$default(app4, str9, (Map) null, str10, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000010, 4090, (Object) null);
                c00005 = c000010;
                if (obj7 == obj) {
                    return obj;
                }
                obj8 = obj7;
                dramashows4 = dramashows3;
                page10 = page9;
                crime_shows2 = crime_shows;
                String thrillerResponse2 = ((NiceResponse) obj8).toString();
                thrillerRoot = (MXPlayer) new Gson().fromJson(thrillerResponse2, new TypeToken<MXPlayer>() { // from class: com.MPlayer.MPlayer$getMainPage$thrillerRoot$1
                }.getType());
                Iterable $this$map$iv3 = thrillerRoot.getItems();
                destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, page7));
                for (Object item$iv$iv3 : $this$map$iv3) {
                    Item item3 = (Item) item$iv$iv3;
                    destination$iv$iv3.add(toSearchResult(item3));
                }
                thriller_shows = (List) destination$iv$iv3;
                Requests app5 = UtilsKt.getApp();
                String str11 = this.webApi + str3 + page10 + "&pageSize=20&isCustomized=true&browseLangFilterIds=hi&type=1" + getEndParam();
                String str12 = getMainUrl() + '/';
                c00005.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00005.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00005.L$2 = SpillingKt.nullOutSpilledVariable(dramaResponse);
                c00005.L$3 = SpillingKt.nullOutSpilledVariable(dramaRoot);
                c00005.L$4 = dramashows4;
                c00005.L$5 = SpillingKt.nullOutSpilledVariable(crimeResponse);
                c00005.L$6 = SpillingKt.nullOutSpilledVariable(crimeRoot);
                c00005.L$7 = crime_shows2;
                c00005.L$8 = SpillingKt.nullOutSpilledVariable(thrillerResponse2);
                c00005.L$9 = SpillingKt.nullOutSpilledVariable(thrillerRoot);
                c00005.L$10 = thriller_shows;
                c00005.I$0 = page10;
                c00005.label = 5;
                dramashows5 = dramashows4;
                page11 = page10;
                C00001 c000011 = c00005;
                crime_shows3 = crime_shows2;
                thrillerResponse = thrillerResponse2;
                str4 = str3;
                $result = Requests.get$default(app5, str11, (Map) null, str12, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000011, 4090, (Object) null);
                c00006 = c000011;
                if ($result == obj) {
                    return obj;
                }
                page12 = page11;
                crime_shows4 = crime_shows3;
                dramashows6 = dramashows5;
                crime_shows5 = thriller_shows;
                String hindimovieresponse = ((NiceResponse) $result).toString();
                MovieRoot movieRoot = (MovieRoot) new Gson().fromJson(hindimovieresponse, new TypeToken<MovieRoot>() { // from class: com.MPlayer.MPlayer$getMainPage$movieRoot$1
                }.getType());
                Iterable $this$map$iv4 = movieRoot.getItems();
                destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, page7));
                for (Object item$iv$iv4 : $this$map$iv4) {
                    MovieItem item4 = (MovieItem) item$iv$iv4;
                    destination$iv$iv4.add(toSearchResult(item4));
                }
                hindi_Movies = (List) destination$iv$iv4;
                Requests app6 = UtilsKt.getApp();
                String str13 = this.webApi + str4 + page12 + "&pageSize=20&isCustomized=true&browseLangFilterIds=te&type=1" + getEndParam();
                String str14 = getMainUrl() + '/';
                c00006.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00006.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00006.L$2 = SpillingKt.nullOutSpilledVariable(dramaResponse);
                c00006.L$3 = SpillingKt.nullOutSpilledVariable(dramaRoot);
                c00006.L$4 = dramashows6;
                c00006.L$5 = SpillingKt.nullOutSpilledVariable(crimeResponse);
                c00006.L$6 = SpillingKt.nullOutSpilledVariable(crimeRoot);
                c00006.L$7 = crime_shows4;
                c00006.L$8 = SpillingKt.nullOutSpilledVariable(thrillerResponse);
                c00006.L$9 = SpillingKt.nullOutSpilledVariable(thrillerRoot);
                c00006.L$10 = crime_shows5;
                c00006.L$11 = SpillingKt.nullOutSpilledVariable(hindimovieresponse);
                c00006.L$12 = SpillingKt.nullOutSpilledVariable(movieRoot);
                c00006.L$13 = hindi_Movies;
                c00006.I$0 = page12;
                c00006.label = 6;
                dramashows7 = dramashows6;
                thriller_shows2 = crime_shows5;
                crime_shows6 = crime_shows4;
                $result = Requests.get$default(app6, str13, (Map) null, str14, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00006, 4090, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                hindi_Movies2 = hindi_Movies;
                dramashows8 = dramashows7;
                thriller_shows3 = thriller_shows2;
                String telgumovieresponse = ((NiceResponse) $result).toString();
                MovieRoot movieRootte = (MovieRoot) new Gson().fromJson(telgumovieresponse, new TypeToken<MovieRoot>() { // from class: com.MPlayer.MPlayer$getMainPage$movieRootte$1
                }.getType());
                Iterable $this$map$iv5 = movieRootte.getItems();
                destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
                for (Object item$iv$iv5 : $this$map$iv5) {
                    MovieItem item5 = (MovieItem) item$iv$iv5;
                    destination$iv$iv5.add(toSearchResult(item5));
                }
                List telgu_Movies = (List) destination$iv$iv5;
                HomePageList Dramashows = new HomePageList("Drama Shows", dramashows8, false, 4, (DefaultConstructorMarker) null);
                HomePageList HindiMovies = new HomePageList("Hindi Movies", hindi_Movies2, false, 4, (DefaultConstructorMarker) null);
                HomePageList telguMovies = new HomePageList("Telgu Movies", telgu_Movies, false, 4, (DefaultConstructorMarker) null);
                HomePageList crimeshows = new HomePageList("Crime Shows", crime_shows6, false, 4, (DefaultConstructorMarker) null);
                HomePageList thrillershows = new HomePageList("Thriller Shows", thriller_shows3, false, 4, (DefaultConstructorMarker) null);
                HomePageList[] homePageListArr = new HomePageList[5];
                homePageListArr[0] = crimeshows;
                homePageListArr[c2] = Dramashows;
                homePageListArr[2] = thrillershows;
                homePageListArr[3] = HindiMovies;
                homePageListArr[4] = telguMovies;
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(homePageListArr), (Boolean) null, 2, (Object) null);
            case 1:
                int page13 = c00001.I$0;
                MainPageRequest request3 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                c00002 = c00001;
                obj = coroutine_suspended;
                request2 = request3;
                str = "/detail/browseItem?&pageNum=";
                page3 = page13;
                obj2 = $result;
                page2 = 1;
                res = (NiceResponse) obj2;
                str2 = (String) getCookies$default(this, res.getOkhttpResponse().headers(), null, page2, null).get("UserID");
                if (str2 != null) {
                    throw new ErrorLoadingException("load fail, geo blocked");
                }
                this.userID = str2;
                Requests app7 = UtilsKt.getApp();
                String str15 = this.webApi + str + page3 + "&pageSize=20&isCustomized=true&genreFilterIds=48efa872f6f17facebf6149dfc536ee1&type=2" + getEndParam();
                String str16 = getMainUrl() + '/';
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00002.I$0 = page3;
                c00002.label = 2;
                page4 = page3;
                C00001 c000012 = c00002;
                str3 = str;
                c = '/';
                c2 = 1;
                obj3 = Requests.get$default(app7, str15, (Map) null, str16, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000012, 4090, (Object) null);
                c00003 = c000012;
                if (obj3 == obj) {
                    return obj;
                }
                obj4 = obj3;
                page5 = page4;
                String dramaResponse3 = ((NiceResponse) obj4).toString();
                dramaRoot = (MXPlayer) new Gson().fromJson(dramaResponse3, new TypeToken<MXPlayer>() { // from class: com.MPlayer.MPlayer$getMainPage$dramaRoot$1
                }.getType());
                Iterable $this$map$iv6 = dramaRoot.getItems();
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv6, 10));
                while (r12.hasNext()) {
                    Item item6 = (Item) item$iv$iv;
                    destination$iv$iv.add(toSearchResult(item6));
                }
                dramashows = (List) destination$iv$iv;
                Requests app8 = UtilsKt.getApp();
                String str17 = this.webApi + "/detail/browseItem?&pageNum=1&pageSize=20&isCustomized=true&genreFilterIds=b413dff55bdad743c577a8bea3b65044&type=2" + getEndParam();
                String str18 = getMainUrl() + c;
                c00003.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00003.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00003.L$2 = SpillingKt.nullOutSpilledVariable(dramaResponse3);
                c00003.L$3 = SpillingKt.nullOutSpilledVariable(dramaRoot);
                c00003.L$4 = dramashows;
                c00003.I$0 = page5;
                c00003.label = 3;
                page6 = page5;
                C00001 c000013 = c00003;
                dramaResponse = dramaResponse3;
                page7 = 10;
                obj5 = Requests.get$default(app8, str17, (Map) null, str18, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000013, 4090, (Object) null);
                c00004 = c000013;
                if (obj5 == obj) {
                    return obj;
                }
                obj6 = obj5;
                page8 = page6;
                dramashows2 = dramashows;
                String crimeResponse3 = ((NiceResponse) obj6).toString();
                crimeRoot = (MXPlayer) new Gson().fromJson(crimeResponse3, new TypeToken<MXPlayer>() { // from class: com.MPlayer.MPlayer$getMainPage$crimeRoot$1
                }.getType());
                Iterable $this$map$iv7 = crimeRoot.getItems();
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv7, page7));
                while (r12.hasNext()) {
                    Item item7 = (Item) item$iv$iv2;
                    destination$iv$iv2.add(toSearchResult(item7));
                }
                crime_shows = (List) destination$iv$iv2;
                Requests app9 = UtilsKt.getApp();
                String str19 = this.webApi + "/detail/browseItem?&pageNum=1&pageSize=20&isCustomized=true&genreFilterIds=2dd5daf25be5619543524f360c73c3d8&type=2" + getEndParam();
                String str110 = getMainUrl() + '/';
                c00004.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00004.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00004.L$2 = SpillingKt.nullOutSpilledVariable(dramaResponse);
                c00004.L$3 = SpillingKt.nullOutSpilledVariable(dramaRoot);
                c00004.L$4 = dramashows2;
                c00004.L$5 = SpillingKt.nullOutSpilledVariable(crimeResponse3);
                c00004.L$6 = SpillingKt.nullOutSpilledVariable(crimeRoot);
                c00004.L$7 = crime_shows;
                c00004.I$0 = page8;
                c00004.label = 4;
                page9 = page8;
                C00001 c000014 = c00004;
                dramashows3 = dramashows2;
                crimeResponse = crimeResponse3;
                obj7 = Requests.get$default(app9, str19, (Map) null, str110, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000014, 4090, (Object) null);
                c00005 = c000014;
                if (obj7 == obj) {
                    return obj;
                }
                obj8 = obj7;
                dramashows4 = dramashows3;
                page10 = page9;
                crime_shows2 = crime_shows;
                String thrillerResponse3 = ((NiceResponse) obj8).toString();
                thrillerRoot = (MXPlayer) new Gson().fromJson(thrillerResponse3, new TypeToken<MXPlayer>() { // from class: com.MPlayer.MPlayer$getMainPage$thrillerRoot$1
                }.getType());
                Iterable $this$map$iv8 = thrillerRoot.getItems();
                destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv8, page7));
                while (r13.hasNext()) {
                    Item item8 = (Item) item$iv$iv3;
                    destination$iv$iv3.add(toSearchResult(item8));
                }
                thriller_shows = (List) destination$iv$iv3;
                Requests app10 = UtilsKt.getApp();
                String str111 = this.webApi + str3 + page10 + "&pageSize=20&isCustomized=true&browseLangFilterIds=hi&type=1" + getEndParam();
                String str112 = getMainUrl() + '/';
                c00005.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00005.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00005.L$2 = SpillingKt.nullOutSpilledVariable(dramaResponse);
                c00005.L$3 = SpillingKt.nullOutSpilledVariable(dramaRoot);
                c00005.L$4 = dramashows4;
                c00005.L$5 = SpillingKt.nullOutSpilledVariable(crimeResponse);
                c00005.L$6 = SpillingKt.nullOutSpilledVariable(crimeRoot);
                c00005.L$7 = crime_shows2;
                c00005.L$8 = SpillingKt.nullOutSpilledVariable(thrillerResponse3);
                c00005.L$9 = SpillingKt.nullOutSpilledVariable(thrillerRoot);
                c00005.L$10 = thriller_shows;
                c00005.I$0 = page10;
                c00005.label = 5;
                dramashows5 = dramashows4;
                page11 = page10;
                C00001 c000015 = c00005;
                crime_shows3 = crime_shows2;
                thrillerResponse = thrillerResponse3;
                str4 = str3;
                $result = Requests.get$default(app10, str111, (Map) null, str112, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000015, 4090, (Object) null);
                c00006 = c000015;
                if ($result == obj) {
                    return obj;
                }
                page12 = page11;
                crime_shows4 = crime_shows3;
                dramashows6 = dramashows5;
                crime_shows5 = thriller_shows;
                String hindimovieresponse2 = ((NiceResponse) $result).toString();
                MovieRoot movieRoot2 = (MovieRoot) new Gson().fromJson(hindimovieresponse2, new TypeToken<MovieRoot>() { // from class: com.MPlayer.MPlayer$getMainPage$movieRoot$1
                }.getType());
                Iterable $this$map$iv9 = movieRoot2.getItems();
                destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv9, page7));
                while (r14.hasNext()) {
                    MovieItem item9 = (MovieItem) item$iv$iv4;
                    destination$iv$iv4.add(toSearchResult(item9));
                }
                hindi_Movies = (List) destination$iv$iv4;
                Requests app11 = UtilsKt.getApp();
                String str113 = this.webApi + str4 + page12 + "&pageSize=20&isCustomized=true&browseLangFilterIds=te&type=1" + getEndParam();
                String str114 = getMainUrl() + '/';
                c00006.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00006.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00006.L$2 = SpillingKt.nullOutSpilledVariable(dramaResponse);
                c00006.L$3 = SpillingKt.nullOutSpilledVariable(dramaRoot);
                c00006.L$4 = dramashows6;
                c00006.L$5 = SpillingKt.nullOutSpilledVariable(crimeResponse);
                c00006.L$6 = SpillingKt.nullOutSpilledVariable(crimeRoot);
                c00006.L$7 = crime_shows4;
                c00006.L$8 = SpillingKt.nullOutSpilledVariable(thrillerResponse);
                c00006.L$9 = SpillingKt.nullOutSpilledVariable(thrillerRoot);
                c00006.L$10 = crime_shows5;
                c00006.L$11 = SpillingKt.nullOutSpilledVariable(hindimovieresponse2);
                c00006.L$12 = SpillingKt.nullOutSpilledVariable(movieRoot2);
                c00006.L$13 = hindi_Movies;
                c00006.I$0 = page12;
                c00006.label = 6;
                dramashows7 = dramashows6;
                thriller_shows2 = crime_shows5;
                crime_shows6 = crime_shows4;
                $result = Requests.get$default(app11, str113, (Map) null, str114, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00006, 4090, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                hindi_Movies2 = hindi_Movies;
                dramashows8 = dramashows7;
                thriller_shows3 = thriller_shows2;
                String telgumovieresponse2 = ((NiceResponse) $result).toString();
                MovieRoot movieRootte2 = (MovieRoot) new Gson().fromJson(telgumovieresponse2, new TypeToken<MovieRoot>() { // from class: com.MPlayer.MPlayer$getMainPage$movieRootte$1
                }.getType());
                Iterable $this$map$iv10 = movieRootte2.getItems();
                destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv10, 10));
                while (r12.hasNext()) {
                    MovieItem item10 = (MovieItem) item$iv$iv5;
                    destination$iv$iv5.add(toSearchResult(item10));
                }
                List telgu_Movies2 = (List) destination$iv$iv5;
                HomePageList Dramashows2 = new HomePageList("Drama Shows", dramashows8, false, 4, (DefaultConstructorMarker) null);
                HomePageList HindiMovies2 = new HomePageList("Hindi Movies", hindi_Movies2, false, 4, (DefaultConstructorMarker) null);
                HomePageList telguMovies2 = new HomePageList("Telgu Movies", telgu_Movies2, false, 4, (DefaultConstructorMarker) null);
                HomePageList crimeshows2 = new HomePageList("Crime Shows", crime_shows6, false, 4, (DefaultConstructorMarker) null);
                HomePageList thrillershows2 = new HomePageList("Thriller Shows", thriller_shows3, false, 4, (DefaultConstructorMarker) null);
                HomePageList[] homePageListArr2 = new HomePageList[5];
                homePageListArr2[0] = crimeshows2;
                homePageListArr2[c2] = Dramashows2;
                homePageListArr2[2] = thrillershows2;
                homePageListArr2[3] = HindiMovies2;
                homePageListArr2[4] = telguMovies2;
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(homePageListArr2), (Boolean) null, 2, (Object) null);
            case 2:
                int page14 = c00001.I$0;
                NiceResponse res2 = (NiceResponse) c00001.L$1;
                MainPageRequest request4 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                c00003 = c00001;
                obj = coroutine_suspended;
                res = res2;
                request2 = request4;
                str3 = "/detail/browseItem?&pageNum=";
                c2 = 1;
                page5 = page14;
                obj4 = $result;
                c = '/';
                String dramaResponse4 = ((NiceResponse) obj4).toString();
                dramaRoot = (MXPlayer) new Gson().fromJson(dramaResponse4, new TypeToken<MXPlayer>() { // from class: com.MPlayer.MPlayer$getMainPage$dramaRoot$1
                }.getType());
                Iterable $this$map$iv11 = dramaRoot.getItems();
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv11, 10));
                while (r12.hasNext()) {
                    Item item11 = (Item) item$iv$iv;
                    destination$iv$iv.add(toSearchResult(item11));
                }
                dramashows = (List) destination$iv$iv;
                Requests app12 = UtilsKt.getApp();
                String str115 = this.webApi + "/detail/browseItem?&pageNum=1&pageSize=20&isCustomized=true&genreFilterIds=b413dff55bdad743c577a8bea3b65044&type=2" + getEndParam();
                String str116 = getMainUrl() + c;
                c00003.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00003.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00003.L$2 = SpillingKt.nullOutSpilledVariable(dramaResponse4);
                c00003.L$3 = SpillingKt.nullOutSpilledVariable(dramaRoot);
                c00003.L$4 = dramashows;
                c00003.I$0 = page5;
                c00003.label = 3;
                page6 = page5;
                C00001 c000016 = c00003;
                dramaResponse = dramaResponse4;
                page7 = 10;
                obj5 = Requests.get$default(app12, str115, (Map) null, str116, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000016, 4090, (Object) null);
                c00004 = c000016;
                if (obj5 == obj) {
                    return obj;
                }
                obj6 = obj5;
                page8 = page6;
                dramashows2 = dramashows;
                String crimeResponse4 = ((NiceResponse) obj6).toString();
                crimeRoot = (MXPlayer) new Gson().fromJson(crimeResponse4, new TypeToken<MXPlayer>() { // from class: com.MPlayer.MPlayer$getMainPage$crimeRoot$1
                }.getType());
                Iterable $this$map$iv12 = crimeRoot.getItems();
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv12, page7));
                while (r12.hasNext()) {
                    Item item12 = (Item) item$iv$iv2;
                    destination$iv$iv2.add(toSearchResult(item12));
                }
                crime_shows = (List) destination$iv$iv2;
                Requests app13 = UtilsKt.getApp();
                String str117 = this.webApi + "/detail/browseItem?&pageNum=1&pageSize=20&isCustomized=true&genreFilterIds=2dd5daf25be5619543524f360c73c3d8&type=2" + getEndParam();
                String str118 = getMainUrl() + '/';
                c00004.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00004.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00004.L$2 = SpillingKt.nullOutSpilledVariable(dramaResponse);
                c00004.L$3 = SpillingKt.nullOutSpilledVariable(dramaRoot);
                c00004.L$4 = dramashows2;
                c00004.L$5 = SpillingKt.nullOutSpilledVariable(crimeResponse4);
                c00004.L$6 = SpillingKt.nullOutSpilledVariable(crimeRoot);
                c00004.L$7 = crime_shows;
                c00004.I$0 = page8;
                c00004.label = 4;
                page9 = page8;
                C00001 c000017 = c00004;
                dramashows3 = dramashows2;
                crimeResponse = crimeResponse4;
                obj7 = Requests.get$default(app13, str117, (Map) null, str118, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000017, 4090, (Object) null);
                c00005 = c000017;
                if (obj7 == obj) {
                    return obj;
                }
                obj8 = obj7;
                dramashows4 = dramashows3;
                page10 = page9;
                crime_shows2 = crime_shows;
                String thrillerResponse4 = ((NiceResponse) obj8).toString();
                thrillerRoot = (MXPlayer) new Gson().fromJson(thrillerResponse4, new TypeToken<MXPlayer>() { // from class: com.MPlayer.MPlayer$getMainPage$thrillerRoot$1
                }.getType());
                Iterable $this$map$iv13 = thrillerRoot.getItems();
                destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv13, page7));
                while (r13.hasNext()) {
                    Item item13 = (Item) item$iv$iv3;
                    destination$iv$iv3.add(toSearchResult(item13));
                }
                thriller_shows = (List) destination$iv$iv3;
                Requests app14 = UtilsKt.getApp();
                String str119 = this.webApi + str3 + page10 + "&pageSize=20&isCustomized=true&browseLangFilterIds=hi&type=1" + getEndParam();
                String str1110 = getMainUrl() + '/';
                c00005.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00005.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00005.L$2 = SpillingKt.nullOutSpilledVariable(dramaResponse);
                c00005.L$3 = SpillingKt.nullOutSpilledVariable(dramaRoot);
                c00005.L$4 = dramashows4;
                c00005.L$5 = SpillingKt.nullOutSpilledVariable(crimeResponse);
                c00005.L$6 = SpillingKt.nullOutSpilledVariable(crimeRoot);
                c00005.L$7 = crime_shows2;
                c00005.L$8 = SpillingKt.nullOutSpilledVariable(thrillerResponse4);
                c00005.L$9 = SpillingKt.nullOutSpilledVariable(thrillerRoot);
                c00005.L$10 = thriller_shows;
                c00005.I$0 = page10;
                c00005.label = 5;
                dramashows5 = dramashows4;
                page11 = page10;
                C00001 c000018 = c00005;
                crime_shows3 = crime_shows2;
                thrillerResponse = thrillerResponse4;
                str4 = str3;
                $result = Requests.get$default(app14, str119, (Map) null, str1110, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000018, 4090, (Object) null);
                c00006 = c000018;
                if ($result == obj) {
                    return obj;
                }
                page12 = page11;
                crime_shows4 = crime_shows3;
                dramashows6 = dramashows5;
                crime_shows5 = thriller_shows;
                String hindimovieresponse3 = ((NiceResponse) $result).toString();
                MovieRoot movieRoot3 = (MovieRoot) new Gson().fromJson(hindimovieresponse3, new TypeToken<MovieRoot>() { // from class: com.MPlayer.MPlayer$getMainPage$movieRoot$1
                }.getType());
                Iterable $this$map$iv14 = movieRoot3.getItems();
                destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv14, page7));
                while (r14.hasNext()) {
                    MovieItem item14 = (MovieItem) item$iv$iv4;
                    destination$iv$iv4.add(toSearchResult(item14));
                }
                hindi_Movies = (List) destination$iv$iv4;
                Requests app15 = UtilsKt.getApp();
                String str1111 = this.webApi + str4 + page12 + "&pageSize=20&isCustomized=true&browseLangFilterIds=te&type=1" + getEndParam();
                String str1112 = getMainUrl() + '/';
                c00006.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00006.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00006.L$2 = SpillingKt.nullOutSpilledVariable(dramaResponse);
                c00006.L$3 = SpillingKt.nullOutSpilledVariable(dramaRoot);
                c00006.L$4 = dramashows6;
                c00006.L$5 = SpillingKt.nullOutSpilledVariable(crimeResponse);
                c00006.L$6 = SpillingKt.nullOutSpilledVariable(crimeRoot);
                c00006.L$7 = crime_shows4;
                c00006.L$8 = SpillingKt.nullOutSpilledVariable(thrillerResponse);
                c00006.L$9 = SpillingKt.nullOutSpilledVariable(thrillerRoot);
                c00006.L$10 = crime_shows5;
                c00006.L$11 = SpillingKt.nullOutSpilledVariable(hindimovieresponse3);
                c00006.L$12 = SpillingKt.nullOutSpilledVariable(movieRoot3);
                c00006.L$13 = hindi_Movies;
                c00006.I$0 = page12;
                c00006.label = 6;
                dramashows7 = dramashows6;
                thriller_shows2 = crime_shows5;
                crime_shows6 = crime_shows4;
                $result = Requests.get$default(app15, str1111, (Map) null, str1112, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00006, 4090, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                hindi_Movies2 = hindi_Movies;
                dramashows8 = dramashows7;
                thriller_shows3 = thriller_shows2;
                String telgumovieresponse3 = ((NiceResponse) $result).toString();
                MovieRoot movieRootte3 = (MovieRoot) new Gson().fromJson(telgumovieresponse3, new TypeToken<MovieRoot>() { // from class: com.MPlayer.MPlayer$getMainPage$movieRootte$1
                }.getType());
                Iterable $this$map$iv15 = movieRootte3.getItems();
                destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv15, 10));
                while (r12.hasNext()) {
                    MovieItem item15 = (MovieItem) item$iv$iv5;
                    destination$iv$iv5.add(toSearchResult(item15));
                }
                List telgu_Movies3 = (List) destination$iv$iv5;
                HomePageList Dramashows3 = new HomePageList("Drama Shows", dramashows8, false, 4, (DefaultConstructorMarker) null);
                HomePageList HindiMovies3 = new HomePageList("Hindi Movies", hindi_Movies2, false, 4, (DefaultConstructorMarker) null);
                HomePageList telguMovies3 = new HomePageList("Telgu Movies", telgu_Movies3, false, 4, (DefaultConstructorMarker) null);
                HomePageList crimeshows3 = new HomePageList("Crime Shows", crime_shows6, false, 4, (DefaultConstructorMarker) null);
                HomePageList thrillershows3 = new HomePageList("Thriller Shows", thriller_shows3, false, 4, (DefaultConstructorMarker) null);
                HomePageList[] homePageListArr3 = new HomePageList[5];
                homePageListArr3[0] = crimeshows3;
                homePageListArr3[c2] = Dramashows3;
                homePageListArr3[2] = thrillershows3;
                homePageListArr3[3] = HindiMovies3;
                homePageListArr3[4] = telguMovies3;
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(homePageListArr3), (Boolean) null, 2, (Object) null);
            case 3:
                int page15 = c00001.I$0;
                List dramashows9 = (List) c00001.L$4;
                MXPlayer dramaRoot2 = (MXPlayer) c00001.L$3;
                String dramaResponse5 = (String) c00001.L$2;
                NiceResponse res3 = (NiceResponse) c00001.L$1;
                MainPageRequest request5 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                c00004 = c00001;
                obj = coroutine_suspended;
                dramaRoot = dramaRoot2;
                dramaResponse = dramaResponse5;
                res = res3;
                request2 = request5;
                str3 = "/detail/browseItem?&pageNum=";
                c2 = 1;
                page8 = page15;
                dramashows2 = dramashows9;
                page7 = 10;
                obj6 = $result;
                String crimeResponse5 = ((NiceResponse) obj6).toString();
                crimeRoot = (MXPlayer) new Gson().fromJson(crimeResponse5, new TypeToken<MXPlayer>() { // from class: com.MPlayer.MPlayer$getMainPage$crimeRoot$1
                }.getType());
                Iterable $this$map$iv16 = crimeRoot.getItems();
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv16, page7));
                while (r12.hasNext()) {
                    Item item16 = (Item) item$iv$iv2;
                    destination$iv$iv2.add(toSearchResult(item16));
                }
                crime_shows = (List) destination$iv$iv2;
                Requests app16 = UtilsKt.getApp();
                String str1113 = this.webApi + "/detail/browseItem?&pageNum=1&pageSize=20&isCustomized=true&genreFilterIds=2dd5daf25be5619543524f360c73c3d8&type=2" + getEndParam();
                String str1114 = getMainUrl() + '/';
                c00004.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00004.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00004.L$2 = SpillingKt.nullOutSpilledVariable(dramaResponse);
                c00004.L$3 = SpillingKt.nullOutSpilledVariable(dramaRoot);
                c00004.L$4 = dramashows2;
                c00004.L$5 = SpillingKt.nullOutSpilledVariable(crimeResponse5);
                c00004.L$6 = SpillingKt.nullOutSpilledVariable(crimeRoot);
                c00004.L$7 = crime_shows;
                c00004.I$0 = page8;
                c00004.label = 4;
                page9 = page8;
                C00001 c000019 = c00004;
                dramashows3 = dramashows2;
                crimeResponse = crimeResponse5;
                obj7 = Requests.get$default(app16, str1113, (Map) null, str1114, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c000019, 4090, (Object) null);
                c00005 = c000019;
                if (obj7 == obj) {
                    return obj;
                }
                obj8 = obj7;
                dramashows4 = dramashows3;
                page10 = page9;
                crime_shows2 = crime_shows;
                String thrillerResponse5 = ((NiceResponse) obj8).toString();
                thrillerRoot = (MXPlayer) new Gson().fromJson(thrillerResponse5, new TypeToken<MXPlayer>() { // from class: com.MPlayer.MPlayer$getMainPage$thrillerRoot$1
                }.getType());
                Iterable $this$map$iv17 = thrillerRoot.getItems();
                destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv17, page7));
                while (r13.hasNext()) {
                    Item item17 = (Item) item$iv$iv3;
                    destination$iv$iv3.add(toSearchResult(item17));
                }
                thriller_shows = (List) destination$iv$iv3;
                Requests app17 = UtilsKt.getApp();
                String str1115 = this.webApi + str3 + page10 + "&pageSize=20&isCustomized=true&browseLangFilterIds=hi&type=1" + getEndParam();
                String str1116 = getMainUrl() + '/';
                c00005.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00005.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00005.L$2 = SpillingKt.nullOutSpilledVariable(dramaResponse);
                c00005.L$3 = SpillingKt.nullOutSpilledVariable(dramaRoot);
                c00005.L$4 = dramashows4;
                c00005.L$5 = SpillingKt.nullOutSpilledVariable(crimeResponse);
                c00005.L$6 = SpillingKt.nullOutSpilledVariable(crimeRoot);
                c00005.L$7 = crime_shows2;
                c00005.L$8 = SpillingKt.nullOutSpilledVariable(thrillerResponse5);
                c00005.L$9 = SpillingKt.nullOutSpilledVariable(thrillerRoot);
                c00005.L$10 = thriller_shows;
                c00005.I$0 = page10;
                c00005.label = 5;
                dramashows5 = dramashows4;
                page11 = page10;
                C00001 c0000110 = c00005;
                crime_shows3 = crime_shows2;
                thrillerResponse = thrillerResponse5;
                str4 = str3;
                $result = Requests.get$default(app17, str1115, (Map) null, str1116, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0000110, 4090, (Object) null);
                c00006 = c0000110;
                if ($result == obj) {
                    return obj;
                }
                page12 = page11;
                crime_shows4 = crime_shows3;
                dramashows6 = dramashows5;
                crime_shows5 = thriller_shows;
                String hindimovieresponse4 = ((NiceResponse) $result).toString();
                MovieRoot movieRoot4 = (MovieRoot) new Gson().fromJson(hindimovieresponse4, new TypeToken<MovieRoot>() { // from class: com.MPlayer.MPlayer$getMainPage$movieRoot$1
                }.getType());
                Iterable $this$map$iv18 = movieRoot4.getItems();
                destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv18, page7));
                while (r14.hasNext()) {
                    MovieItem item18 = (MovieItem) item$iv$iv4;
                    destination$iv$iv4.add(toSearchResult(item18));
                }
                hindi_Movies = (List) destination$iv$iv4;
                Requests app18 = UtilsKt.getApp();
                String str1117 = this.webApi + str4 + page12 + "&pageSize=20&isCustomized=true&browseLangFilterIds=te&type=1" + getEndParam();
                String str1118 = getMainUrl() + '/';
                c00006.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00006.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00006.L$2 = SpillingKt.nullOutSpilledVariable(dramaResponse);
                c00006.L$3 = SpillingKt.nullOutSpilledVariable(dramaRoot);
                c00006.L$4 = dramashows6;
                c00006.L$5 = SpillingKt.nullOutSpilledVariable(crimeResponse);
                c00006.L$6 = SpillingKt.nullOutSpilledVariable(crimeRoot);
                c00006.L$7 = crime_shows4;
                c00006.L$8 = SpillingKt.nullOutSpilledVariable(thrillerResponse);
                c00006.L$9 = SpillingKt.nullOutSpilledVariable(thrillerRoot);
                c00006.L$10 = crime_shows5;
                c00006.L$11 = SpillingKt.nullOutSpilledVariable(hindimovieresponse4);
                c00006.L$12 = SpillingKt.nullOutSpilledVariable(movieRoot4);
                c00006.L$13 = hindi_Movies;
                c00006.I$0 = page12;
                c00006.label = 6;
                dramashows7 = dramashows6;
                thriller_shows2 = crime_shows5;
                crime_shows6 = crime_shows4;
                $result = Requests.get$default(app18, str1117, (Map) null, str1118, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00006, 4090, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                hindi_Movies2 = hindi_Movies;
                dramashows8 = dramashows7;
                thriller_shows3 = thriller_shows2;
                String telgumovieresponse4 = ((NiceResponse) $result).toString();
                MovieRoot movieRootte4 = (MovieRoot) new Gson().fromJson(telgumovieresponse4, new TypeToken<MovieRoot>() { // from class: com.MPlayer.MPlayer$getMainPage$movieRootte$1
                }.getType());
                Iterable $this$map$iv19 = movieRootte4.getItems();
                destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv19, 10));
                while (r12.hasNext()) {
                    MovieItem item19 = (MovieItem) item$iv$iv5;
                    destination$iv$iv5.add(toSearchResult(item19));
                }
                List telgu_Movies4 = (List) destination$iv$iv5;
                HomePageList Dramashows4 = new HomePageList("Drama Shows", dramashows8, false, 4, (DefaultConstructorMarker) null);
                HomePageList HindiMovies4 = new HomePageList("Hindi Movies", hindi_Movies2, false, 4, (DefaultConstructorMarker) null);
                HomePageList telguMovies4 = new HomePageList("Telgu Movies", telgu_Movies4, false, 4, (DefaultConstructorMarker) null);
                HomePageList crimeshows4 = new HomePageList("Crime Shows", crime_shows6, false, 4, (DefaultConstructorMarker) null);
                HomePageList thrillershows4 = new HomePageList("Thriller Shows", thriller_shows3, false, 4, (DefaultConstructorMarker) null);
                HomePageList[] homePageListArr4 = new HomePageList[5];
                homePageListArr4[0] = crimeshows4;
                homePageListArr4[c2] = Dramashows4;
                homePageListArr4[2] = thrillershows4;
                homePageListArr4[3] = HindiMovies4;
                homePageListArr4[4] = telguMovies4;
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(homePageListArr4), (Boolean) null, 2, (Object) null);
            case 4:
                int page16 = c00001.I$0;
                List crime_shows7 = (List) c00001.L$7;
                MXPlayer crimeRoot2 = (MXPlayer) c00001.L$6;
                String crimeResponse6 = (String) c00001.L$5;
                List dramashows10 = (List) c00001.L$4;
                MXPlayer dramaRoot3 = (MXPlayer) c00001.L$3;
                String dramaResponse6 = (String) c00001.L$2;
                NiceResponse res4 = (NiceResponse) c00001.L$1;
                MainPageRequest request6 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                c00005 = c00001;
                obj = coroutine_suspended;
                crimeRoot = crimeRoot2;
                crimeResponse = crimeResponse6;
                dramashows4 = dramashows10;
                dramaRoot = dramaRoot3;
                str3 = "/detail/browseItem?&pageNum=";
                dramaResponse = dramaResponse6;
                res = res4;
                request2 = request6;
                c2 = 1;
                page10 = page16;
                crime_shows2 = crime_shows7;
                page7 = 10;
                obj8 = $result;
                String thrillerResponse6 = ((NiceResponse) obj8).toString();
                thrillerRoot = (MXPlayer) new Gson().fromJson(thrillerResponse6, new TypeToken<MXPlayer>() { // from class: com.MPlayer.MPlayer$getMainPage$thrillerRoot$1
                }.getType());
                Iterable $this$map$iv110 = thrillerRoot.getItems();
                destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv110, page7));
                while (r13.hasNext()) {
                    Item item110 = (Item) item$iv$iv3;
                    destination$iv$iv3.add(toSearchResult(item110));
                }
                thriller_shows = (List) destination$iv$iv3;
                Requests app19 = UtilsKt.getApp();
                String str1119 = this.webApi + str3 + page10 + "&pageSize=20&isCustomized=true&browseLangFilterIds=hi&type=1" + getEndParam();
                String str11110 = getMainUrl() + '/';
                c00005.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00005.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00005.L$2 = SpillingKt.nullOutSpilledVariable(dramaResponse);
                c00005.L$3 = SpillingKt.nullOutSpilledVariable(dramaRoot);
                c00005.L$4 = dramashows4;
                c00005.L$5 = SpillingKt.nullOutSpilledVariable(crimeResponse);
                c00005.L$6 = SpillingKt.nullOutSpilledVariable(crimeRoot);
                c00005.L$7 = crime_shows2;
                c00005.L$8 = SpillingKt.nullOutSpilledVariable(thrillerResponse6);
                c00005.L$9 = SpillingKt.nullOutSpilledVariable(thrillerRoot);
                c00005.L$10 = thriller_shows;
                c00005.I$0 = page10;
                c00005.label = 5;
                dramashows5 = dramashows4;
                page11 = page10;
                C00001 c0000111 = c00005;
                crime_shows3 = crime_shows2;
                thrillerResponse = thrillerResponse6;
                str4 = str3;
                $result = Requests.get$default(app19, str1119, (Map) null, str11110, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c0000111, 4090, (Object) null);
                c00006 = c0000111;
                if ($result == obj) {
                    return obj;
                }
                page12 = page11;
                crime_shows4 = crime_shows3;
                dramashows6 = dramashows5;
                crime_shows5 = thriller_shows;
                String hindimovieresponse5 = ((NiceResponse) $result).toString();
                MovieRoot movieRoot5 = (MovieRoot) new Gson().fromJson(hindimovieresponse5, new TypeToken<MovieRoot>() { // from class: com.MPlayer.MPlayer$getMainPage$movieRoot$1
                }.getType());
                Iterable $this$map$iv111 = movieRoot5.getItems();
                destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv111, page7));
                while (r14.hasNext()) {
                    MovieItem item111 = (MovieItem) item$iv$iv4;
                    destination$iv$iv4.add(toSearchResult(item111));
                }
                hindi_Movies = (List) destination$iv$iv4;
                Requests app110 = UtilsKt.getApp();
                String str11111 = this.webApi + str4 + page12 + "&pageSize=20&isCustomized=true&browseLangFilterIds=te&type=1" + getEndParam();
                String str11112 = getMainUrl() + '/';
                c00006.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00006.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00006.L$2 = SpillingKt.nullOutSpilledVariable(dramaResponse);
                c00006.L$3 = SpillingKt.nullOutSpilledVariable(dramaRoot);
                c00006.L$4 = dramashows6;
                c00006.L$5 = SpillingKt.nullOutSpilledVariable(crimeResponse);
                c00006.L$6 = SpillingKt.nullOutSpilledVariable(crimeRoot);
                c00006.L$7 = crime_shows4;
                c00006.L$8 = SpillingKt.nullOutSpilledVariable(thrillerResponse);
                c00006.L$9 = SpillingKt.nullOutSpilledVariable(thrillerRoot);
                c00006.L$10 = crime_shows5;
                c00006.L$11 = SpillingKt.nullOutSpilledVariable(hindimovieresponse5);
                c00006.L$12 = SpillingKt.nullOutSpilledVariable(movieRoot5);
                c00006.L$13 = hindi_Movies;
                c00006.I$0 = page12;
                c00006.label = 6;
                dramashows7 = dramashows6;
                thriller_shows2 = crime_shows5;
                crime_shows6 = crime_shows4;
                $result = Requests.get$default(app110, str11111, (Map) null, str11112, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00006, 4090, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                hindi_Movies2 = hindi_Movies;
                dramashows8 = dramashows7;
                thriller_shows3 = thriller_shows2;
                String telgumovieresponse5 = ((NiceResponse) $result).toString();
                MovieRoot movieRootte5 = (MovieRoot) new Gson().fromJson(telgumovieresponse5, new TypeToken<MovieRoot>() { // from class: com.MPlayer.MPlayer$getMainPage$movieRootte$1
                }.getType());
                Iterable $this$map$iv112 = movieRootte5.getItems();
                destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv112, 10));
                while (r12.hasNext()) {
                    MovieItem item112 = (MovieItem) item$iv$iv5;
                    destination$iv$iv5.add(toSearchResult(item112));
                }
                List telgu_Movies5 = (List) destination$iv$iv5;
                HomePageList Dramashows5 = new HomePageList("Drama Shows", dramashows8, false, 4, (DefaultConstructorMarker) null);
                HomePageList HindiMovies5 = new HomePageList("Hindi Movies", hindi_Movies2, false, 4, (DefaultConstructorMarker) null);
                HomePageList telguMovies5 = new HomePageList("Telgu Movies", telgu_Movies5, false, 4, (DefaultConstructorMarker) null);
                HomePageList crimeshows5 = new HomePageList("Crime Shows", crime_shows6, false, 4, (DefaultConstructorMarker) null);
                HomePageList thrillershows5 = new HomePageList("Thriller Shows", thriller_shows3, false, 4, (DefaultConstructorMarker) null);
                HomePageList[] homePageListArr5 = new HomePageList[5];
                homePageListArr5[0] = crimeshows5;
                homePageListArr5[c2] = Dramashows5;
                homePageListArr5[2] = thrillershows5;
                homePageListArr5[3] = HindiMovies5;
                homePageListArr5[4] = telguMovies5;
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(homePageListArr5), (Boolean) null, 2, (Object) null);
            case 5:
                int page17 = c00001.I$0;
                List thriller_shows4 = (List) c00001.L$10;
                MXPlayer thrillerRoot2 = (MXPlayer) c00001.L$9;
                String thrillerResponse7 = (String) c00001.L$8;
                List crime_shows8 = (List) c00001.L$7;
                MXPlayer crimeRoot3 = (MXPlayer) c00001.L$6;
                String crimeResponse7 = (String) c00001.L$5;
                List dramashows11 = (List) c00001.L$4;
                MXPlayer dramaRoot4 = (MXPlayer) c00001.L$3;
                String dramaResponse7 = (String) c00001.L$2;
                NiceResponse res5 = (NiceResponse) c00001.L$1;
                MainPageRequest request7 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                c00006 = c00001;
                obj = coroutine_suspended;
                request2 = request7;
                thrillerRoot = thrillerRoot2;
                thrillerResponse = thrillerResponse7;
                crime_shows4 = crime_shows8;
                crimeRoot = crimeRoot3;
                str4 = "/detail/browseItem?&pageNum=";
                crimeResponse = crimeResponse7;
                dramashows6 = dramashows11;
                res = res5;
                dramaRoot = dramaRoot4;
                dramaResponse = dramaResponse7;
                page7 = 10;
                c2 = 1;
                crime_shows5 = thriller_shows4;
                page12 = page17;
                String hindimovieresponse6 = ((NiceResponse) $result).toString();
                MovieRoot movieRoot6 = (MovieRoot) new Gson().fromJson(hindimovieresponse6, new TypeToken<MovieRoot>() { // from class: com.MPlayer.MPlayer$getMainPage$movieRoot$1
                }.getType());
                Iterable $this$map$iv113 = movieRoot6.getItems();
                destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv113, page7));
                while (r14.hasNext()) {
                    MovieItem item113 = (MovieItem) item$iv$iv4;
                    destination$iv$iv4.add(toSearchResult(item113));
                }
                hindi_Movies = (List) destination$iv$iv4;
                Requests app111 = UtilsKt.getApp();
                String str11113 = this.webApi + str4 + page12 + "&pageSize=20&isCustomized=true&browseLangFilterIds=te&type=1" + getEndParam();
                String str11114 = getMainUrl() + '/';
                c00006.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00006.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00006.L$2 = SpillingKt.nullOutSpilledVariable(dramaResponse);
                c00006.L$3 = SpillingKt.nullOutSpilledVariable(dramaRoot);
                c00006.L$4 = dramashows6;
                c00006.L$5 = SpillingKt.nullOutSpilledVariable(crimeResponse);
                c00006.L$6 = SpillingKt.nullOutSpilledVariable(crimeRoot);
                c00006.L$7 = crime_shows4;
                c00006.L$8 = SpillingKt.nullOutSpilledVariable(thrillerResponse);
                c00006.L$9 = SpillingKt.nullOutSpilledVariable(thrillerRoot);
                c00006.L$10 = crime_shows5;
                c00006.L$11 = SpillingKt.nullOutSpilledVariable(hindimovieresponse6);
                c00006.L$12 = SpillingKt.nullOutSpilledVariable(movieRoot6);
                c00006.L$13 = hindi_Movies;
                c00006.I$0 = page12;
                c00006.label = 6;
                dramashows7 = dramashows6;
                thriller_shows2 = crime_shows5;
                crime_shows6 = crime_shows4;
                $result = Requests.get$default(app111, str11113, (Map) null, str11114, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00006, 4090, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                hindi_Movies2 = hindi_Movies;
                dramashows8 = dramashows7;
                thriller_shows3 = thriller_shows2;
                String telgumovieresponse6 = ((NiceResponse) $result).toString();
                MovieRoot movieRootte6 = (MovieRoot) new Gson().fromJson(telgumovieresponse6, new TypeToken<MovieRoot>() { // from class: com.MPlayer.MPlayer$getMainPage$movieRootte$1
                }.getType());
                Iterable $this$map$iv114 = movieRootte6.getItems();
                destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv114, 10));
                while (r12.hasNext()) {
                    MovieItem item114 = (MovieItem) item$iv$iv5;
                    destination$iv$iv5.add(toSearchResult(item114));
                }
                List telgu_Movies6 = (List) destination$iv$iv5;
                HomePageList Dramashows6 = new HomePageList("Drama Shows", dramashows8, false, 4, (DefaultConstructorMarker) null);
                HomePageList HindiMovies6 = new HomePageList("Hindi Movies", hindi_Movies2, false, 4, (DefaultConstructorMarker) null);
                HomePageList telguMovies6 = new HomePageList("Telgu Movies", telgu_Movies6, false, 4, (DefaultConstructorMarker) null);
                HomePageList crimeshows6 = new HomePageList("Crime Shows", crime_shows6, false, 4, (DefaultConstructorMarker) null);
                HomePageList thrillershows6 = new HomePageList("Thriller Shows", thriller_shows3, false, 4, (DefaultConstructorMarker) null);
                HomePageList[] homePageListArr6 = new HomePageList[5];
                homePageListArr6[0] = crimeshows6;
                homePageListArr6[c2] = Dramashows6;
                homePageListArr6[2] = thrillershows6;
                homePageListArr6[3] = HindiMovies6;
                homePageListArr6[4] = telguMovies6;
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(homePageListArr6), (Boolean) null, 2, (Object) null);
            case 6:
                int i = c00001.I$0;
                List hindi_Movies3 = (List) c00001.L$13;
                thriller_shows3 = (List) c00001.L$10;
                List crime_shows9 = (List) c00001.L$7;
                List dramashows12 = (List) c00001.L$4;
                ResultKt.throwOnFailure($result);
                crime_shows6 = crime_shows9;
                dramashows8 = dramashows12;
                c2 = 1;
                hindi_Movies2 = hindi_Movies3;
                String telgumovieresponse7 = ((NiceResponse) $result).toString();
                MovieRoot movieRootte7 = (MovieRoot) new Gson().fromJson(telgumovieresponse7, new TypeToken<MovieRoot>() { // from class: com.MPlayer.MPlayer$getMainPage$movieRootte$1
                }.getType());
                Iterable $this$map$iv115 = movieRootte7.getItems();
                destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv115, 10));
                while (r12.hasNext()) {
                    MovieItem item115 = (MovieItem) item$iv$iv5;
                    destination$iv$iv5.add(toSearchResult(item115));
                }
                List telgu_Movies7 = (List) destination$iv$iv5;
                HomePageList Dramashows7 = new HomePageList("Drama Shows", dramashows8, false, 4, (DefaultConstructorMarker) null);
                HomePageList HindiMovies7 = new HomePageList("Hindi Movies", hindi_Movies2, false, 4, (DefaultConstructorMarker) null);
                HomePageList telguMovies7 = new HomePageList("Telgu Movies", telgu_Movies7, false, 4, (DefaultConstructorMarker) null);
                HomePageList crimeshows7 = new HomePageList("Crime Shows", crime_shows6, false, 4, (DefaultConstructorMarker) null);
                HomePageList thrillershows7 = new HomePageList("Thriller Shows", thriller_shows3, false, 4, (DefaultConstructorMarker) null);
                HomePageList[] homePageListArr7 = new HomePageList[5];
                homePageListArr7[0] = crimeshows7;
                homePageListArr7[c2] = Dramashows7;
                homePageListArr7[2] = thrillershows7;
                homePageListArr7[3] = HindiMovies7;
                homePageListArr7[4] = telguMovies7;
                return MainAPIKt.newHomePageResponse$default(CollectionsKt.listOf(homePageListArr7), (Boolean) null, 2, (Object) null);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final SearchResponse toSearchResult(MovieItem $this$toSearchResult) {
        final String portraitLargeImageUrl = getPortraitLargeImageUrl($this$toSearchResult);
        String bigpic = getMBigPic($this$toSearchResult);
        return MainAPIKt.newMovieSearchResponse$default(this, $this$toSearchResult.getTitle(), AppUtils.INSTANCE.toJson(new LoadUrl($this$toSearchResult.getTitle(), $this$toSearchResult.getTitleContentImageInfo(), bigpic, $this$toSearchResult.getType(), $this$toSearchResult.getStream(), $this$toSearchResult.getDescription(), $this$toSearchResult.getShareUrl(), null, null, $this$toSearchResult.getLanguages(), 256, null)), (TvType) null, false, new Function1() { // from class: com.MPlayer.MPlayer$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return MPlayer.toSearchResult$lambda$0(portraitLargeImageUrl, (MovieSearchResponse) obj);
            }
        }, 12, (Object) null);
    }

    static final Unit toSearchResult$lambda$0(String $portraitLargeImageUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($portraitLargeImageUrl);
        return Unit.INSTANCE;
    }

    private final SearchResponse toSearchResult(Item $this$toSearchResult) {
        final String portraitLargeImageUrl = getPortraitLargeImageUrl($this$toSearchResult);
        return MainAPIKt.newMovieSearchResponse$default(this, $this$toSearchResult.getTitle(), AppUtils.INSTANCE.toJson(new LoadUrl($this$toSearchResult.getTitle(), $this$toSearchResult.getTitleContentImageInfo(), null, $this$toSearchResult.getType(), null, $this$toSearchResult.getDescription(), $this$toSearchResult.getShareUrl(), null, null, $this$toSearchResult.getLanguages(), 256, null)), (TvType) null, false, new Function1() { // from class: com.MPlayer.MPlayer$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return MPlayer.toSearchResult$lambda$1(portraitLargeImageUrl, (MovieSearchResponse) obj);
            }
        }, 12, (Object) null);
    }

    static final Unit toSearchResult$lambda$1(String $portraitLargeImageUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($portraitLargeImageUrl);
        return Unit.INSTANCE;
    }

    @Nullable
    public final String getPortraitLargeImageUrl(@NotNull MovieItem item) {
        Object element$iv;
        String it;
        Iterable $this$firstOrNull$iv = item.getImageInfo();
        Iterator it2 = $this$firstOrNull$iv.iterator();
        do {
            if (!it2.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it2.next();
        } while (!Intrinsics.areEqual(((MovieImageInfo) element$iv).getType(), "portrait_large"));
        MovieImageInfo movieImageInfo = (MovieImageInfo) element$iv;
        if (movieImageInfo == null || (it = movieImageInfo.getUrl()) == null) {
            return null;
        }
        return this.imageUrl + it;
    }

    @Nullable
    public final String getPortraitLargeImageUrl(@NotNull Item item) {
        Object element$iv;
        String it;
        Iterable $this$firstOrNull$iv = item.getImageInfo();
        Iterator it2 = $this$firstOrNull$iv.iterator();
        do {
            if (!it2.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it2.next();
        } while (!Intrinsics.areEqual(((ImageInfo) element$iv).getType(), "portrait_large"));
        ImageInfo imageInfo = (ImageInfo) element$iv;
        if (imageInfo == null || (it = imageInfo.getUrl()) == null) {
            return null;
        }
        return this.imageUrl + it;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0040  */
    @Nullable
    public final String getMovieBigPic(@NotNull String jsonString) {
        String bigPicUrl;
        Object element$iv;
        MovieTitleContentImageInfo it;
        Gson gson = new Gson();
        MovieItem item = (MovieItem) gson.fromJson(jsonString, MovieItem.class);
        Iterable titleContentImageInfo = item.getTitleContentImageInfo();
        if (titleContentImageInfo != null) {
            Iterable $this$firstOrNull$iv = titleContentImageInfo;
            Iterator it2 = $this$firstOrNull$iv.iterator();
            do {
                if (!it2.hasNext()) {
                    element$iv = null;
                    break;
                }
                element$iv = it2.next();
                it = (MovieTitleContentImageInfo) element$iv;
            } while (!Intrinsics.areEqual(it.getType(), "banner_and_static_bg_desktop"));
            MovieTitleContentImageInfo movieTitleContentImageInfo = (MovieTitleContentImageInfo) element$iv;
            if (movieTitleContentImageInfo != null) {
                bigPicUrl = movieTitleContentImageInfo.getUrl();
            } else {
                bigPicUrl = null;
            }
        } else {
            bigPicUrl = null;
        }
        if (bigPicUrl == null) {
            return null;
        }
        String it3 = bigPicUrl;
        return this.imageUrl + it3;
    }

    @Nullable
    public final String getMBigPic(@NotNull MovieItem item) {
        Object element$iv;
        String it;
        Iterable $this$firstOrNull$iv = item.getImageInfo();
        Iterator it2 = $this$firstOrNull$iv.iterator();
        do {
            if (!it2.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it2.next();
        } while (!Intrinsics.areEqual(((MovieImageInfo) element$iv).getType(), "bigpic"));
        MovieImageInfo movieImageInfo = (MovieImageInfo) element$iv;
        if (movieImageInfo == null || (it = movieImageInfo.getUrl()) == null) {
            return null;
        }
        return this.imageUrl + it;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws JSONException {
        C00071 c00071;
        String query2;
        List languages;
        JSONObject root;
        String alternativeStream;
        List titleContentImageInfo;
        List titleContentImageInfo2;
        MPlayer mPlayer = this;
        if (continuation instanceof C00071) {
            c00071 = (C00071) continuation;
            if ((c00071.label & Integer.MIN_VALUE) != 0) {
                c00071.label -= Integer.MIN_VALUE;
            } else {
                c00071 = mPlayer.new C00071(continuation);
            }
        } else {
            c00071 = mPlayer.new C00071(continuation);
        }
        Object $result = c00071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00071.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = UtilsKt.getApp();
                String str = mPlayer.webApi + "/search/resultv2?query=" + query + mPlayer.getEndParam();
                String str2 = mPlayer.getMainUrl() + '/';
                RequestBody requestBodyCreate = RequestBody.Companion.create("{}", MediaType.Companion.get("application/json"));
                c00071.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00071.label = 1;
                $result = Requests.post$default(app, str, (Map) null, str2, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBodyCreate, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00071, 65274, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                query2 = query;
                break;
            case 1:
                query2 = (String) c00071.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String response = ((NiceResponse) $result).getText();
        List result = new ArrayList();
        JSONObject root2 = new JSONObject(response);
        JSONArray sections = root2.optJSONArray("sections");
        if (sections == null) {
            return result;
        }
        int i = 0;
        int length = sections.length();
        while (i < length) {
            JSONObject section = sections.getJSONObject(i);
            JSONArray items = section.optJSONArray("items");
            if (items != null) {
                int j = 0;
                int length2 = items.length();
                while (j < length2) {
                    JSONObject item = items.getJSONObject(j);
                    String title = item.optString("title");
                    String description = item.optString("description");
                    String type = item.optString("type");
                    String shareUrl = item.optString("shareUrl");
                    JSONArray arr = item.optJSONArray("languages");
                    if (arr != null) {
                        int length3 = arr.length();
                        ArrayList arrayList = new ArrayList(length3);
                        int i2 = 0;
                        while (i2 < length3) {
                            int idx = i2;
                            arrayList.add(arr.optString(idx));
                            i2++;
                            length3 = length3;
                        }
                        languages = arrayList;
                    } else {
                        languages = CollectionsKt.emptyList();
                    }
                    JSONArray imageInfo = item.optJSONArray("imageInfo");
                    final Ref.ObjectRef portraitLargeImageUrl = new Ref.ObjectRef();
                    if (imageInfo != null) {
                        int k = 0;
                        int length4 = imageInfo.length();
                        while (true) {
                            if (k < length4) {
                                root = root2;
                                JSONObject img = imageInfo.getJSONObject(k);
                                JSONArray imageInfo2 = imageInfo;
                                int k2 = k;
                                if (Intrinsics.areEqual(img.optString("type"), "portrait_large")) {
                                    portraitLargeImageUrl.element = mPlayer.endpointurl + img.optString("url");
                                } else {
                                    k = k2 + 1;
                                    root2 = root;
                                    imageInfo = imageInfo2;
                                }
                            } else {
                                root = root2;
                            }
                        }
                    } else {
                        root = root2;
                    }
                    JSONObject stream = item.optJSONObject("stream");
                    if (stream != null) {
                        JSONObject thirdParty = stream.optJSONObject("thirdParty");
                        JSONObject mxplay = stream.optJSONObject("mxplay");
                        JSONObject jSONObjectOptJSONObject = stream.optJSONObject("hls");
                        if (jSONObjectOptJSONObject == null) {
                            jSONObjectOptJSONObject = mxplay != null ? mxplay.optJSONObject("hls") : null;
                        }
                        JSONObject hlsObj = jSONObjectOptJSONObject;
                        JSONObject jSONObjectOptJSONObject2 = stream.optJSONObject("dash");
                        if (jSONObjectOptJSONObject2 == null) {
                            jSONObjectOptJSONObject2 = mxplay != null ? mxplay.optJSONObject("dash") : null;
                        }
                        JSONObject dashObj = jSONObjectOptJSONObject2;
                        String it = mPlayer.bestVariant(hlsObj);
                        if (it == null && (thirdParty == null || (it = thirdParty.optString("hlsUrl")) == null || StringsKt.isBlank(it))) {
                            it = null;
                        }
                        String hlsRaw = it;
                        String it2 = mPlayer.bestVariant(dashObj);
                        if (it2 == null && (thirdParty == null || (it2 = thirdParty.optString("dashUrl")) == null || StringsKt.isBlank(it2))) {
                            it2 = null;
                        }
                        String dashRaw = it2;
                        String hlsUrl = mPlayer.normalizeUrl(hlsRaw);
                        String dashUrl = mPlayer.normalizeUrl(dashRaw);
                        List urls = CollectionsKt.distinct(CollectionsKt.listOfNotNull(new String[]{hlsUrl, dashUrl}));
                        switch (urls.size()) {
                            case 0:
                                alternativeStream = null;
                                break;
                            case 1:
                                alternativeStream = (String) urls.get(0);
                                break;
                            default:
                                alternativeStream = new Gson().toJson(urls);
                                break;
                        }
                    } else {
                        alternativeStream = null;
                    }
                    if (StringsKt.contains(type, "movie", true)) {
                        JSONArray arr2 = item.optJSONArray("titleContentImageInfo");
                        if (arr2 != null) {
                            Iterable $this$map$iv = RangesKt.until(0, arr2.length());
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            Iterable $this$mapTo$iv$iv = $this$map$iv;
                            IntIterator it3 = $this$mapTo$iv$iv.iterator();
                            while (it3.hasNext()) {
                                int item$iv$iv = it3.nextInt();
                                destination$iv$iv.add(arr2.get(item$iv$iv));
                                $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                            }
                            titleContentImageInfo2 = (List) destination$iv$iv;
                        } else {
                            titleContentImageInfo2 = null;
                        }
                        result.add(MainAPIKt.newMovieSearchResponse$default(this, title, AppUtils.INSTANCE.toJson(new LoadUrl(title, titleContentImageInfo2, null, type, null, description, shareUrl, alternativeStream, (String) portraitLargeImageUrl.element, languages)), (TvType) null, false, new Function1() { // from class: com.MPlayer.MPlayer$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                return MPlayer.search$lambda$4(portraitLargeImageUrl, (MovieSearchResponse) obj);
                            }
                        }, 12, (Object) null));
                    } else {
                        JSONArray arr3 = item.optJSONArray("titleContentImageInfo");
                        if (arr3 != null) {
                            Iterable $this$map$iv2 = RangesKt.until(0, arr3.length());
                            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                            IntIterator it4 = $this$map$iv2.iterator();
                            while (it4.hasNext()) {
                                int item$iv$iv2 = it4.nextInt();
                                destination$iv$iv2.add(arr3.get(item$iv$iv2));
                                $this$map$iv2 = $this$map$iv2;
                            }
                            titleContentImageInfo = (List) destination$iv$iv2;
                        } else {
                            titleContentImageInfo = null;
                        }
                        result.add(MainAPIKt.newMovieSearchResponse$default(this, title, AppUtils.INSTANCE.toJson(new LoadUrl(title, titleContentImageInfo, null, type, null, r4, shareUrl, alternativeStream, (String) portraitLargeImageUrl.element, languages)), (TvType) null, false, new Function1() { // from class: com.MPlayer.MPlayer$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj) {
                                return MPlayer.search$lambda$6(portraitLargeImageUrl, (MovieSearchResponse) obj);
                            }
                        }, 12, (Object) null));
                    }
                    j++;
                    mPlayer = this;
                    root2 = root;
                    response = response;
                    query2 = query2;
                }
            }
            i++;
            mPlayer = this;
            root2 = root2;
            response = response;
            query2 = query2;
        }
        return result;
    }

    static final Unit search$lambda$4(Ref.ObjectRef $portraitLargeImageUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl((String) $portraitLargeImageUrl.element);
        return Unit.INSTANCE;
    }

    static final Unit search$lambda$6(Ref.ObjectRef $portraitLargeImageUrl, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl((String) $portraitLargeImageUrl.element);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:184:0x0580  */
    /* JADX WARN: Code duplicated, block: B:185:0x05ae  */
    /* JADX WARN: Code duplicated, block: B:188:0x0661 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:189:0x0662  */
    /* JADX WARN: Code duplicated, block: B:193:0x068d  */
    /* JADX WARN: Code duplicated, block: B:211:0x0820  */
    /* JADX WARN: Code duplicated, block: B:213:0x0832  */
    /* JADX WARN: Code duplicated, block: B:214:0x0837  */
    /* JADX WARN: Code duplicated, block: B:217:0x083c  */
    /* JADX WARN: Code duplicated, block: B:218:0x083f  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:189:0x0662 -> B:190:0x067b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r64, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r65) {
        /*
            Method dump skipped, instruction units count: 2506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.MPlayer.MPlayer.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$2$0$0(String $name, int $season, int $epno, String $image, String $description, int $duration, Episode $this$newEpisode) {
        $this$newEpisode.setName($name);
        $this$newEpisode.setSeason(Integer.valueOf($season));
        $this$newEpisode.setEpisode(Integer.valueOf($epno));
        $this$newEpisode.setPosterUrl($image);
        $this$newEpisode.setDescription($description);
        $this$newEpisode.setRunTime(Integer.valueOf($duration));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.MPlayer.MPlayer$load$3 */
    /* JADX INFO: compiled from: MPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MPlayer.MPlayer$load$3", f = "MPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00033 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $epposter;
        final /* synthetic */ List<String> $languages;
        final /* synthetic */ LoadUrl $video;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00033(String str, LoadUrl loadUrl, List<String> list, Continuation<? super C00033> continuation) {
            super(2, continuation);
            this.$epposter = str;
            this.$video = loadUrl;
            this.$languages = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00033 = new C00033(this.$epposter, this.$video, this.$languages, continuation);
            c00033.L$0 = obj;
            return c00033;
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
                    String alternativeposter = this.$epposter;
                    if (alternativeposter == null) {
                        alternativeposter = this.$video.getAlternativeposter();
                    }
                    $this$newTvSeriesLoadResponse.setPosterUrl(alternativeposter);
                    $this$newTvSeriesLoadResponse.setBackgroundPosterUrl(this.$epposter);
                    $this$newTvSeriesLoadResponse.setPlot(this.$video.getDescription());
                    $this$newTvSeriesLoadResponse.setTags(this.$languages);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.MPlayer.MPlayer$load$4 */
    /* JADX INFO: compiled from: MPlayer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MPlayer.MPlayer$load$4", f = "MPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00044 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $languages;
        final /* synthetic */ Object $poster;
        final /* synthetic */ LoadUrl $video;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00044(Object obj, LoadUrl loadUrl, List<String> list, Continuation<? super C00044> continuation) {
            super(2, continuation);
            this.$poster = obj;
            this.$video = loadUrl;
            this.$languages = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00044 = new C00044(this.$poster, this.$video, this.$languages, continuation);
            c00044.L$0 = obj;
            return c00044;
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
                    $this$newMovieLoadResponse.setPosterUrl(String.valueOf(this.$poster));
                    $this$newMovieLoadResponse.setBackgroundPosterUrl(String.valueOf(this.$poster));
                    $this$newMovieLoadResponse.setPlot(this.$video.getDescription());
                    $this$newMovieLoadResponse.setTags(this.$languages);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00051 c00051;
        List urls;
        if (continuation instanceof C00051) {
            c00051 = (C00051) continuation;
            if ((c00051.label & Integer.MIN_VALUE) != 0) {
                c00051.label -= Integer.MIN_VALUE;
            } else {
                c00051 = new C00051(continuation);
            }
        } else {
            c00051 = new C00051(continuation);
        }
        Object $result = c00051.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00051.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (StringsKt.startsWith$default(StringsKt.trim(data).toString(), "[", false, 2, (Object) null)) {
                    Gson gson = new Gson();
                    try {
                        String[] strArr = (String[]) gson.fromJson(data, String[].class);
                        urls = strArr != null ? ArraysKt.toList(strArr) : null;
                        if (urls == null) {
                            urls = CollectionsKt.emptyList();
                        }
                    } catch (Exception e) {
                        Log.INSTANCE.e("Error M Player:", "Failed to parse stream URL list: " + e.getMessage());
                        urls = CollectionsKt.listOf(data);
                    }
                } else {
                    urls = CollectionsKt.listOf(data);
                }
                C00062 c00062 = new C00062(function2, null);
                c00051.L$0 = SpillingKt.nullOutSpilledVariable(data);
                c00051.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                c00051.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                c00051.L$3 = SpillingKt.nullOutSpilledVariable(urls);
                c00051.Z$0 = isCasting;
                c00051.label = 1;
                if (ParCollectionsKt.amap(urls, c00062, c00051) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                boolean isCasting2 = c00051.Z$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(true);
    }

    /* JADX INFO: renamed from: com.MPlayer.MPlayer$loadLinks$2 */
    /* JADX INFO: compiled from: MPlayer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "url", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.MPlayer.MPlayer$loadLinks$2", f = "MPlayer.kt", i = {0, 0, 0}, l = {447}, m = "invokeSuspend", n = {"url", "label", "fullUrl"}, nl = {446}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C00062 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00062(Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00062> continuation) {
            super(2, continuation);
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00062 = MPlayer.this.new C00062(this.$callback, continuation);
            c00062.L$0 = obj;
            return c00062;
        }

        public final Object invoke(String str, Continuation<? super Unit> continuation) {
            return create(str, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            String str;
            Object objNewExtractorLink;
            Function1<ExtractorLink, Unit> function1;
            String url = (String) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (StringsKt.contains$default(url, ".m3u8", false, 2, (Object) null)) {
                        str = "HLS";
                    } else {
                        str = StringsKt.contains$default(url, ".mpd", false, 2, (Object) null) ? "DASH" : "";
                    }
                    String label = str;
                    String fullUrl = StringsKt.startsWith$default(url, "video", false, 2, (Object) null) ? MPlayer.this.endpointurl + url : url;
                    Function1<ExtractorLink, Unit> function2 = this.$callback;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(url);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(label);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(fullUrl);
                    this.L$3 = function2;
                    this.label = 1;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(label, MPlayer.this.getName() + ' ' + label, fullUrl, ExtractorApiKt.getINFER_TYPE(), new AnonymousClass1(MPlayer.this, null), (Continuation) this);
                    if (objNewExtractorLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function1 = function2;
                    break;
                    break;
                case 1:
                    function1 = (Function1) this.L$3;
                    ResultKt.throwOnFailure($result);
                    objNewExtractorLink = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function1.invoke(objNewExtractorLink);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.MPlayer.MPlayer$loadLinks$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: MPlayer.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.MPlayer.MPlayer$loadLinks$2$1", f = "MPlayer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MPlayer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MPlayer mPlayer, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = mPlayer;
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
                        $this$newExtractorLink.setReferer(this.this$0.getMainUrl() + '/');
                        $this$newExtractorLink.setQuality(Qualities.P1080.getValue());
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object getSeasonData(String url, Continuation<? super List<Pair<Integer, String>>> continuation) {
        C00011 c00011;
        Object $result;
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
        Object $result2 = c00011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00011.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                Requests app = UtilsKt.getApp();
                c00011.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c00011.label = 1;
                C00011 c00012 = c00011;
                $result = $result2;
                $result2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                if ($result2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result2);
                $result = $result2;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document document = ((NiceResponse) $result2).getDocument();
        Iterable $this$mapNotNull$iv = document.select("div.hs__items-container > div");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element element = (Element) element$iv$iv$iv;
            Document document2 = document;
            Integer tab = StringsKt.toIntOrNull(element.attr("data-tab"));
            Object $result3 = $result;
            String id = element.attr("data-id");
            Pair pair = (tab == null || StringsKt.isBlank(id)) ? null : TuplesKt.to(tab, id);
            if (pair != null) {
                destination$iv$iv.add(pair);
            }
            document = document2;
            $result = $result3;
        }
        return (List) destination$iv$iv;
    }

    static /* synthetic */ Map getCookies$default(MPlayer mPlayer, Headers headers, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "set-cookie";
        }
        return mPlayer.getCookies(headers, str);
    }

    private final Map<String, String> getCookies(Headers $this$getCookies, String cookieKey) {
        String string;
        String string2;
        Iterable $this$filter$iv = (Iterable) $this$getCookies;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            Pair it = (Pair) element$iv$iv;
            if (StringsKt.equals((String) it.getFirst(), cookieKey, true)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$mapNotNull$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Pair it2 = (Pair) element$iv$iv$iv;
            String str = (String) CollectionsKt.firstOrNull(StringsKt.split$default((CharSequence) it2.getSecond(), new String[]{";"}, false, 0, 6, (Object) null));
            if (str != null) {
                destination$iv$iv2.add(str);
            }
        }
        Iterable cookieList = (List) destination$iv$iv2;
        Iterable<String> $this$associate$iv = cookieList;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        Map destination$iv$iv3 = new LinkedHashMap(capacity$iv);
        for (String it3 : $this$associate$iv) {
            List split = StringsKt.split$default(it3, new String[]{"="}, false, 2, 2, (Object) null);
            String str2 = (String) CollectionsKt.getOrNull(split, 0);
            String str3 = "";
            if (str2 == null || (string = StringsKt.trim(str2).toString()) == null) {
                string = "";
            }
            String str4 = (String) CollectionsKt.getOrNull(split, 1);
            if (str4 != null && (string2 = StringsKt.trim(str4).toString()) != null) {
                str3 = string2;
            }
            Pair pair = TuplesKt.to(string, str3);
            destination$iv$iv3.put(pair.getFirst(), pair.getSecond());
        }
        Map destination$iv$iv4 = new LinkedHashMap();
        for (Map.Entry element$iv$iv2 : destination$iv$iv3.entrySet()) {
            if ((StringsKt.isBlank((CharSequence) element$iv$iv2.getKey()) || StringsKt.isBlank((CharSequence) element$iv$iv2.getValue())) ? false : true) {
                destination$iv$iv4.put(element$iv$iv2.getKey(), element$iv$iv2.getValue());
            }
        }
        return destination$iv$iv4;
    }

    /* JADX INFO: compiled from: MPlayer.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0087\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0014\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010,\u001a\u00020-HÖ\u0081\u0004J\n\u0010.\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u0006/"}, d2 = {"Lcom/MPlayer/MPlayer$LoadUrl;", "", "title", "", "titleContentImageInfo", "", "bigpic", "tvType", "stream", "Lcom/MPlayer/MovieStream;", "description", "shareUrl", "alternativestream", "alternativeposter", "languages", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/MPlayer/MovieStream;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getTitleContentImageInfo", "()Ljava/util/List;", "getBigpic", "getTvType", "getStream", "()Lcom/MPlayer/MovieStream;", "getDescription", "getShareUrl", "getAlternativestream", "getAlternativeposter", "getLanguages", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "MPlayerProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LoadUrl {

        @Nullable
        private final String alternativeposter;

        @Nullable
        private final String alternativestream;

        @Nullable
        private final String bigpic;

        @NotNull
        private final String description;

        @Nullable
        private final List<String> languages;

        @Nullable
        private final String shareUrl;

        @Nullable
        private final MovieStream stream;

        @NotNull
        private final String title;

        @Nullable
        private final List<Object> titleContentImageInfo;

        @NotNull
        private final String tvType;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LoadUrl copy$default(LoadUrl loadUrl, String str, List list, String str2, String str3, MovieStream movieStream, String str4, String str5, String str6, String str7, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loadUrl.title;
            }
            if ((i & 2) != 0) {
                list = loadUrl.titleContentImageInfo;
            }
            if ((i & 4) != 0) {
                str2 = loadUrl.bigpic;
            }
            if ((i & 8) != 0) {
                str3 = loadUrl.tvType;
            }
            if ((i & 16) != 0) {
                movieStream = loadUrl.stream;
            }
            if ((i & 32) != 0) {
                str4 = loadUrl.description;
            }
            if ((i & 64) != 0) {
                str5 = loadUrl.shareUrl;
            }
            if ((i & 128) != 0) {
                str6 = loadUrl.alternativestream;
            }
            if ((i & 256) != 0) {
                str7 = loadUrl.alternativeposter;
            }
            if ((i & 512) != 0) {
                list2 = loadUrl.languages;
            }
            String str8 = str7;
            List list3 = list2;
            String str9 = str5;
            String str10 = str6;
            MovieStream movieStream2 = movieStream;
            String str11 = str4;
            return loadUrl.copy(str, list, str2, str3, movieStream2, str11, str9, str10, str8, list3);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final List<String> component10() {
            return this.languages;
        }

        @Nullable
        public final List<Object> component2() {
            return this.titleContentImageInfo;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getBigpic() {
            return this.bigpic;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getTvType() {
            return this.tvType;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final MovieStream getStream() {
            return this.stream;
        }

        @NotNull
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getShareUrl() {
            return this.shareUrl;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getAlternativestream() {
            return this.alternativestream;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getAlternativeposter() {
            return this.alternativeposter;
        }

        @NotNull
        public final LoadUrl copy(@NotNull String title, @Nullable List<? extends Object> titleContentImageInfo, @Nullable String bigpic, @NotNull String tvType, @Nullable MovieStream stream, @NotNull String description, @Nullable String shareUrl, @Nullable String alternativestream, @Nullable String alternativeposter, @Nullable List<String> languages) {
            return new LoadUrl(title, titleContentImageInfo, bigpic, tvType, stream, description, shareUrl, alternativestream, alternativeposter, languages);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadUrl)) {
                return false;
            }
            LoadUrl loadUrl = (LoadUrl) other;
            return Intrinsics.areEqual(this.title, loadUrl.title) && Intrinsics.areEqual(this.titleContentImageInfo, loadUrl.titleContentImageInfo) && Intrinsics.areEqual(this.bigpic, loadUrl.bigpic) && Intrinsics.areEqual(this.tvType, loadUrl.tvType) && Intrinsics.areEqual(this.stream, loadUrl.stream) && Intrinsics.areEqual(this.description, loadUrl.description) && Intrinsics.areEqual(this.shareUrl, loadUrl.shareUrl) && Intrinsics.areEqual(this.alternativestream, loadUrl.alternativestream) && Intrinsics.areEqual(this.alternativeposter, loadUrl.alternativeposter) && Intrinsics.areEqual(this.languages, loadUrl.languages);
        }

        public int hashCode() {
            return (((((((((((((((((this.title.hashCode() * 31) + (this.titleContentImageInfo == null ? 0 : this.titleContentImageInfo.hashCode())) * 31) + (this.bigpic == null ? 0 : this.bigpic.hashCode())) * 31) + this.tvType.hashCode()) * 31) + (this.stream == null ? 0 : this.stream.hashCode())) * 31) + this.description.hashCode()) * 31) + (this.shareUrl == null ? 0 : this.shareUrl.hashCode())) * 31) + (this.alternativestream == null ? 0 : this.alternativestream.hashCode())) * 31) + (this.alternativeposter == null ? 0 : this.alternativeposter.hashCode())) * 31) + (this.languages != null ? this.languages.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "LoadUrl(title=" + this.title + ", titleContentImageInfo=" + this.titleContentImageInfo + ", bigpic=" + this.bigpic + ", tvType=" + this.tvType + ", stream=" + this.stream + ", description=" + this.description + ", shareUrl=" + this.shareUrl + ", alternativestream=" + this.alternativestream + ", alternativeposter=" + this.alternativeposter + ", languages=" + this.languages + ')';
        }

        public LoadUrl(@NotNull String title, @Nullable List<? extends Object> list, @Nullable String bigpic, @NotNull String tvType, @Nullable MovieStream stream, @NotNull String description, @Nullable String shareUrl, @Nullable String alternativestream, @Nullable String alternativeposter, @Nullable List<String> list2) {
            this.title = title;
            this.titleContentImageInfo = list;
            this.bigpic = bigpic;
            this.tvType = tvType;
            this.stream = stream;
            this.description = description;
            this.shareUrl = shareUrl;
            this.alternativestream = alternativestream;
            this.alternativeposter = alternativeposter;
            this.languages = list2;
        }

        public /* synthetic */ LoadUrl(String str, List list, String str2, String str3, MovieStream movieStream, String str4, String str5, String str6, String str7, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : str2, str3, (i & 16) != 0 ? null : movieStream, str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? CollectionsKt.emptyList() : list2);
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final List<Object> getTitleContentImageInfo() {
            return this.titleContentImageInfo;
        }

        @Nullable
        public final String getBigpic() {
            return this.bigpic;
        }

        @NotNull
        public final String getTvType() {
            return this.tvType;
        }

        @Nullable
        public final MovieStream getStream() {
            return this.stream;
        }

        @NotNull
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getShareUrl() {
            return this.shareUrl;
        }

        @Nullable
        public final String getAlternativestream() {
            return this.alternativestream;
        }

        @Nullable
        public final String getAlternativeposter() {
            return this.alternativeposter;
        }

        @Nullable
        public final List<String> getLanguages() {
            return this.languages;
        }
    }

    private final String bestVariant(JSONObject $this$bestVariant) {
        if ($this$bestVariant == null) {
            return null;
        }
        String[] keys = {"high", "base", "main"};
        for (String k : keys) {
            String v = $this$bestVariant.optString(k);
            String str = v;
            if (!(str == null || StringsKt.isBlank(str))) {
                return v;
            }
        }
        return null;
    }

    private final String normalizeUrl(String url) {
        String str = url;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        if (StringsKt.startsWith(url, "http", true)) {
            return url;
        }
        return this.endpointurl + url;
    }
}
