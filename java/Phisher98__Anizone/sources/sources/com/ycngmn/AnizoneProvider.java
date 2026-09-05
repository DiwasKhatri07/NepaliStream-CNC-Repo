package com.ycngmn;

import android.content.SharedPreferences;
import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.ResultKt;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: AnizoneProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Anizone/classes.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010(\u001a\u00020)H\u0082@¢\u0006\u0002\u0010*J\u000e\u0010+\u001a\u00020)H\u0082@¢\u0006\u0002\u0010*J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0002Jl\u00102\u001a\u0002002\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007042\u0018\u00105\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u000206040 2\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070%2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070%2\u0006\u00109\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010:J$\u0010;\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0 \u0012\u0006\u0012\u0004\u0018\u00010\u00070<2\u0006\u0010/\u001a\u000200H\u0002J\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00020=0 2\u0006\u0010?\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010@J\u001e\u0010\"\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0096@¢\u0006\u0002\u0010GJ\u0010\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u0007H\u0002J\u0010\u0010J\u001a\u00020=2\u0006\u0010K\u001a\u00020LH\u0002J\u001c\u0010M\u001a\b\u0012\u0004\u0012\u00020=0 2\u0006\u0010?\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010@J\u0010\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u000200H\u0002J$\u0010Q\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020O0 \u0012\u0006\u0012\u0004\u0018\u00010\u00070<2\u0006\u0010/\u001a\u000200H\u0002J\u0016\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010@JF\u0010U\u001a\u00020\u00182\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u00182\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020)0Y2\u0012\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020)0YH\u0096@¢\u0006\u0002\u0010]R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u000bR\u0014\u0010\u0017\u001a\u00020\u0018X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u0018X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u0018X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Lcom/ycngmn/AnizoneProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "sharedPref", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "lang", "getLang", "setLang", "hasMainPage", "", "getHasMainPage", "()Z", "hasQuickSearch", "getHasQuickSearch", "hasDownloadSupport", "getHasDownloadSupport", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "cookies", "", "wireData", "isInitialized", "ensureInit", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sortAnimeLatest", "getSnapshot", "doc", "Lorg/jsoup/nodes/Document;", "json", "Lorg/json/JSONObject;", "getHtmlFromWire", "liveWireBuilder", "updates", "", "calls", "", "biscuit", "wireCreds", "remember", "(Ljava/util/Map;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseJsonItems", "Lkotlin/Pair;", "Lcom/lagradost/cloudstream3/SearchResponse;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pageCursors", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractTitleFromXData", "xdata", "toResult", "post", "Lorg/jsoup/nodes/Element;", "quickSearch", "parseEpisodeItem", "Lcom/lagradost/cloudstream3/Episode;", "item", "parseEpisodesFromJson", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Anizone"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnizoneProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnizoneProvider.kt\ncom/ycngmn/AnizoneProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,462:1\n1739#2:463\n1814#2,3:464\n296#2,2:467\n1739#2:470\n1814#2,3:471\n296#2,2:474\n1739#2:476\n1814#2,3:477\n1739#2:480\n1814#2,3:481\n1849#2,8:484\n1#3:469\n*S KotlinDebug\n*F\n+ 1 AnizoneProvider.kt\ncom/ycngmn/AnizoneProvider\n*L\n84#1:463\n84#1:464,3\n85#1:467,2\n271#1:470\n271#1:471,3\n272#1:474,2\n350#1:476\n350#1:477,3\n355#1:480\n355#1:481,3\n391#1:484,8\n*E\n"})
public final class AnizoneProvider extends MainAPI {

    @NotNull
    private Map<String, String> cookies;
    private final boolean hasDownloadSupport;
    private final boolean hasMainPage;
    private final boolean hasQuickSearch;
    private boolean isInitialized;

    @NotNull
    private String lang;

    @NotNull
    private final List<MainPageData> mainPage;

    @NotNull
    private String mainUrl;

    @NotNull
    private String name;

    @NotNull
    private Map<String, String> pageCursors;

    @Nullable
    private final SharedPreferences sharedPref;

    @NotNull
    private final Set<TvType> supportedTypes;

    @NotNull
    private Map<String, String> wireData;

    /* JADX INFO: renamed from: com.ycngmn.AnizoneProvider$ensureInit$1 */
    /* JADX INFO: compiled from: AnizoneProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.ycngmn.AnizoneProvider", f = "AnizoneProvider.kt", i = {1, 1}, l = {68, 74}, m = "ensureInit", n = {"initReq", "doc"}, nl = {69, 75}, s = {"L$0", "L$1"}, v = 2)
    static final class C00001 extends ContinuationImpl {
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
            return AnizoneProvider.this.ensureInit((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.ycngmn.AnizoneProvider$getMainPage$1 */
    /* JADX INFO: compiled from: AnizoneProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.ycngmn.AnizoneProvider", f = "AnizoneProvider.kt", i = {0, 0, 1, 1, 1, 1}, l = {199, 215}, m = "getMainPage", n = {"request", "page", "request", "calls", "updates", "page"}, nl = {201, 216}, s = {"L$0", "I$0", "L$0", "L$1", "L$2", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnizoneProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.ycngmn.AnizoneProvider$liveWireBuilder$1 */
    /* JADX INFO: compiled from: AnizoneProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.ycngmn.AnizoneProvider", f = "AnizoneProvider.kt", i = {0, 0, 0, 0, 0, 0}, l = {112}, m = "liveWireBuilder", n = {"updates", "calls", "biscuit", "wireCreds", "payload", "remember"}, nl = {128}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnizoneProvider.this.liveWireBuilder(null, null, null, null, false, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.ycngmn.AnizoneProvider$load$1 */
    /* JADX INFO: compiled from: AnizoneProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.ycngmn.AnizoneProvider", f = "AnizoneProvider.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {329, 379, 393}, m = "load", n = {"url", "url", "r", "doc", "cookie", "wireData", "title", "poster", "bgImage", "synopsis", "rowLines", "releasedYear", "status", "genres", "allEpisodes", "itemsMatch", "nextCursor", "hasNextPage", "pagesFetched", "url", "r", "doc", "cookie", "wireData", "title", "poster", "bgImage", "synopsis", "rowLines", "releasedYear", "status", "genres", "allEpisodes", "itemsMatch", "nextCursor", "finalEpisodes", "hasNextPage", "pagesFetched"}, nl = {330, 385, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "I$0", "I$1"}, v = 2)
    static final class C00031 extends ContinuationImpl {
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

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnizoneProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.ycngmn.AnizoneProvider$loadLinks$1 */
    /* JADX INFO: compiled from: AnizoneProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.ycngmn.AnizoneProvider", f = "AnizoneProvider.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {413, 438, 450}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "isCasting", "data", "subtitleCallback", "callback", "webHtml", "web", "sourceName", "m3U8", "jsonMatch", "jsonStr", "json", "subtitles", "sub", "title", "file", "isCasting", "i", "data", "subtitleCallback", "callback", "webHtml", "web", "sourceName", "m3U8", "jsonMatch", "isCasting"}, nl = {414, 437, 449}, s = {"L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        int I$0;
        int I$1;
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
        int label;
        /* synthetic */ Object result;

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnizoneProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.ycngmn.AnizoneProvider$search$1 */
    /* JADX INFO: compiled from: AnizoneProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.ycngmn.AnizoneProvider", f = "AnizoneProvider.kt", i = {0, 1}, l = {189, 190}, m = "search", n = {"query", "query"}, nl = {190, 193}, s = {"L$0", "L$0"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnizoneProvider.this.search(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.ycngmn.AnizoneProvider$sortAnimeLatest$1 */
    /* JADX INFO: compiled from: AnizoneProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.ycngmn.AnizoneProvider", f = "AnizoneProvider.kt", i = {}, l = {79}, m = "sortAnimeLatest", n = {}, nl = {80}, s = {}, v = 2)
    static final class C00071 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnizoneProvider.this.sortAnimeLatest((Continuation) this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AnizoneProvider() {
        SharedPreferences sharedPreferences = null;
        this(sharedPreferences, 1, sharedPreferences);
    }

    public AnizoneProvider(@Nullable SharedPreferences sharedPref) {
        this.sharedPref = sharedPref;
        this.mainUrl = "https://anizone.to";
        this.name = "AniZone";
        this.supportedTypes = SetsKt.setOf(new TvType[]{TvType.Anime, TvType.AnimeMovie});
        this.lang = "en";
        this.hasMainPage = true;
        this.hasQuickSearch = true;
        this.hasDownloadSupport = true;
        this.mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to("2", "Latest TV Series"), TuplesKt.to("4", "Latest Movies"), TuplesKt.to("6", "Latest Web")});
        this.cookies = new LinkedHashMap();
        this.wireData = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("wireSnapshot", ""), TuplesKt.to("token", "")});
        this.pageCursors = new LinkedHashMap();
    }

    public /* synthetic */ AnizoneProvider(SharedPreferences sharedPreferences, int i, DefaultConstructorMarker defaultConstructorMarker) {
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

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    public boolean getHasQuickSearch() {
        return this.hasQuickSearch;
    }

    public boolean getHasDownloadSupport() {
        return this.hasDownloadSupport;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:25:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:28:0x00fe A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object ensureInit(Continuation<? super Unit> continuation) {
        C00001 c00001;
        Object obj;
        boolean z;
        C00001 c00002;
        Document doc;
        Element elementSelectFirst;
        String strAttr;
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
                if (this.isInitialized) {
                    return Unit.INSTANCE;
                }
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/anime";
                c00001.label = 1;
                obj = coroutine_suspended;
                C00001 c00003 = c00001;
                z = true;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00003, 4094, (Object) null);
                c00002 = c00003;
                if ($result == obj) {
                    return obj;
                }
                NiceResponse initReq = (NiceResponse) $result;
                this.cookies.putAll(initReq.getCookies());
                doc = initReq.getDocument();
                Map<String, String> map = this.wireData;
                elementSelectFirst = doc.selectFirst("meta[name=csrf-token]");
                if (elementSelectFirst != null || (strAttr = elementSelectFirst.attr("content")) == null) {
                    strAttr = doc.select("script[data-csrf]").attr("data-csrf");
                }
                map.put("token", strAttr);
                this.wireData.put("wireSnapshot", getSnapshot(doc));
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(initReq);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(doc);
                c00002.label = 2;
                if (sortAnimeLatest(c00002) == obj) {
                    return obj;
                }
                this.isInitialized = z;
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                c00002 = c00001;
                z = true;
                NiceResponse initReq2 = (NiceResponse) $result;
                this.cookies.putAll(initReq2.getCookies());
                doc = initReq2.getDocument();
                Map<String, String> map2 = this.wireData;
                elementSelectFirst = doc.selectFirst("meta[name=csrf-token]");
                if (elementSelectFirst != null) {
                    strAttr = doc.select("script[data-csrf]").attr("data-csrf");
                } else {
                    strAttr = doc.select("script[data-csrf]").attr("data-csrf");
                }
                map2.put("token", strAttr);
                this.wireData.put("wireSnapshot", getSnapshot(doc));
                c00002.L$0 = SpillingKt.nullOutSpilledVariable(initReq2);
                c00002.L$1 = SpillingKt.nullOutSpilledVariable(doc);
                c00002.label = 2;
                if (sortAnimeLatest(c00002) == obj) {
                    return obj;
                }
                this.isInitialized = z;
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                z = true;
                this.isInitialized = z;
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object sortAnimeLatest(Continuation<? super Unit> continuation) {
        C00071 c00071;
        if (continuation instanceof C00071) {
            c00071 = (C00071) continuation;
            if ((c00071.label & Integer.MIN_VALUE) != 0) {
                c00071.label -= Integer.MIN_VALUE;
            } else {
                c00071 = new C00071(continuation);
            }
        } else {
            c00071 = new C00071(continuation);
        }
        C00071 c00072 = c00071;
        Object $result = c00072.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00072.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Map<String, String> mapMapOf = MapsKt.mapOf(TuplesKt.to("sort", "release-desc"));
                ArrayList arrayList = new ArrayList();
                Map<String, String> map = this.cookies;
                Map<String, String> map2 = this.wireData;
                c00072.label = 1;
                if (liveWireBuilder(mapMapOf, arrayList, map, map2, true, c00072) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    private final String getSnapshot(Document doc) {
        Object obj;
        Iterable $this$map$iv = doc.select("div[wire:snapshot]");
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Element it = (Element) item$iv$iv;
            destination$iv$iv.add(StringsKt.replace$default(it.attr("wire:snapshot"), "&quot;", "\"", false, 4, (Object) null));
        }
        List snapshots = (List) destination$iv$iv;
        List $this$firstOrNull$iv = snapshots;
        Iterator it2 = $this$firstOrNull$iv.iterator();
        while (true) {
            obj = null;
            if (!it2.hasNext()) {
                break;
            }
            Object element$iv = it2.next();
            String it3 = (String) element$iv;
            if (StringsKt.contains$default(it3, "\"name\":\"pages.", false, 2, (Object) null)) {
                obj = element$iv;
                break;
            }
        }
        String str = (String) obj;
        if (str != null) {
            return str;
        }
        String str2 = (String) CollectionsKt.lastOrNull(snapshots);
        return str2 == null ? "" : str2;
    }

    private final String getSnapshot(JSONObject json) {
        return json.getJSONArray("components").getJSONObject(0).getString("snapshot");
    }

    private final Document getHtmlFromWire(JSONObject json) {
        return Jsoup.parse(json.getJSONArray("components").getJSONObject(0).getJSONObject("effects").getString("html"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object liveWireBuilder(Map<String, String> map, List<? extends Map<String, ? extends Object>> list, Map<String, String> map2, Map<String, String> map3, boolean remember, Continuation<? super JSONObject> continuation) throws Exception {
        C00021 c00021;
        String str;
        String str2;
        Map<String, String> map4;
        Map<String, String> map5;
        boolean remember2;
        if (continuation instanceof C00021) {
            c00021 = (C00021) continuation;
            if ((c00021.label & Integer.MIN_VALUE) != 0) {
                c00021.label -= Integer.MIN_VALUE;
            } else {
                c00021 = new C00021(continuation);
            }
        } else {
            c00021 = new C00021(continuation);
        }
        Object $result = c00021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00021.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Map payload = MapsKt.mapOf(new Pair[]{TuplesKt.to("_token", map3.get("token")), TuplesKt.to("components", CollectionsKt.listOf(MapsKt.mapOf(new Pair[]{TuplesKt.to("snapshot", map3.get("wireSnapshot")), TuplesKt.to("updates", map), TuplesKt.to("calls", list)})))});
                Requests app = MainActivityKt.getApp();
                String str3 = getMainUrl() + "/livewire/update";
                Pair[] pairArr = new Pair[7];
                pairArr[0] = TuplesKt.to("Content-Type", "application/json");
                pairArr[1] = TuplesKt.to("Accept", "application/json");
                pairArr[2] = TuplesKt.to("X-Requested-With", "XMLHttpRequest");
                pairArr[3] = TuplesKt.to("X-Livewire", "true");
                String str4 = map3.get("token");
                if (str4 == null) {
                    str4 = "";
                }
                pairArr[4] = TuplesKt.to("X-CSRF-TOKEN", str4);
                pairArr[5] = TuplesKt.to("Origin", getMainUrl());
                pairArr[6] = TuplesKt.to("Referer", getMainUrl() + "/anime");
                Map mapMapOf = MapsKt.mapOf(pairArr);
                RequestBody requestBodyCreate = RequestBody.Companion.create(AppUtils.INSTANCE.toJson(payload), MediaType.Companion.get("application/json"));
                c00021.L$0 = SpillingKt.nullOutSpilledVariable(map);
                c00021.L$1 = SpillingKt.nullOutSpilledVariable(list);
                c00021.L$2 = map2;
                c00021.L$3 = map3;
                c00021.L$4 = SpillingKt.nullOutSpilledVariable(payload);
                c00021.Z$0 = remember;
                c00021.label = 1;
                str = "components";
                str2 = "wireSnapshot";
                $result = Requests.post$default(app, str3, mapMapOf, (String) null, (Map) null, map2, (Map) null, (List) null, (Object) null, requestBodyCreate, false, 0, (TimeUnit) null, 30L, (Interceptor) null, false, (ResponseParser) null, c00021, 61164, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                map4 = map2;
                map5 = map3;
                remember2 = remember;
                break;
            case 1:
                remember2 = c00021.Z$0;
                Map<String, String> map6 = (Map) c00021.L$3;
                map4 = (Map) c00021.L$2;
                ResultKt.throwOnFailure($result);
                str = "components";
                map5 = map6;
                str2 = "wireSnapshot";
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse req = (NiceResponse) $result;
        String bodyStr = req.getText();
        JSONObject jsonResponse = new JSONObject(bodyStr);
        if (!jsonResponse.has(str)) {
            throw new Exception("Livewire error: " + bodyStr);
        }
        if (remember2) {
            map5.put(str2, getSnapshot(jsonResponse));
            map4.putAll(req.getCookies());
        }
        return jsonResponse;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x007b  */
    /* JADX WARN: Code duplicated, block: B:32:0x007e  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c1  */
    private final Pair<List<SearchResponse>, String> parseJsonItems(JSONObject json) throws JSONException {
        JSONArray dispatches;
        String nextCursor;
        String it;
        boolean z;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        List itemsList = new ArrayList();
        String nextCursor2 = null;
        JSONArray jSONArrayOptJSONArray = json.optJSONArray("components");
        String str = null;
        JSONArray dispatches2 = (jSONArrayOptJSONArray == null || (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("effects")) == null) ? null : jSONObjectOptJSONObject2.optJSONArray("dispatches");
        if (dispatches2 != null) {
            int i = 0;
            int length = dispatches2.length();
            while (i < length) {
                JSONObject dispatch = dispatches2.getJSONObject(i);
                String name = dispatch.optString("name");
                if (Intrinsics.areEqual(name, "filters-reset") || Intrinsics.areEqual(name, "items-loaded")) {
                    JSONObject params = dispatch.optJSONObject("params");
                    if (params == null) {
                        dispatches = dispatches2;
                    } else {
                        String nextCursor3 = params.optString("nextCursor", str);
                        if (Intrinsics.areEqual(nextCursor3, "null")) {
                            nextCursor3 = null;
                        } else {
                            if (nextCursor3 == null) {
                                z = false;
                            } else {
                                if (nextCursor3.length() == 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                            }
                            if (z) {
                                nextCursor3 = null;
                            }
                        }
                        JSONArray items = params.optJSONArray("items");
                        if (items == null) {
                            nextCursor = nextCursor3;
                            dispatches = dispatches2;
                        } else {
                            int j = 0;
                            int length2 = items.length();
                            while (j < length2) {
                                JSONObject item = items.getJSONObject(j);
                                String slug = item.optString("slug");
                                JSONObject titleList = item.optJSONObject("title_list");
                                if (titleList != null && (it = titleList.optString("1")) != null) {
                                    if (!(it.length() > 0)) {
                                        it = null;
                                    }
                                    if (it == null) {
                                        it = item.optString("main_title");
                                    }
                                } else {
                                    it = item.optString("main_title");
                                }
                                String title = it;
                                final String cover = item.optString("cover");
                                String nextCursor4 = nextCursor3;
                                String url = getMainUrl() + "/anime/" + slug;
                                final int eps = item.optInt("episode_count", 0);
                                item.optBoolean("is_ongoing", false);
                                itemsList.add(MainAPIKt.newAnimeSearchResponse$default(this, title, url, (TvType) null, false, new Function1() { // from class: com.ycngmn.AnizoneProvider$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj) {
                                        return AnizoneProvider.parseJsonItems$lambda$1(cover, eps, (AnimeSearchResponse) obj);
                                    }
                                }, 12, (Object) null));
                                j++;
                                nextCursor3 = nextCursor4;
                                dispatches2 = dispatches2;
                            }
                            nextCursor = nextCursor3;
                            dispatches = dispatches2;
                        }
                        nextCursor2 = nextCursor;
                    }
                } else {
                    dispatches = dispatches2;
                }
                i++;
                dispatches2 = dispatches;
                str = null;
            }
        }
        return new Pair<>(itemsList, nextCursor2);
    }

    static final Unit parseJsonItems$lambda$1(String $cover, int $eps, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($cover);
        if ($eps > 0) {
            MainAPIKt.addSub($this$newAnimeSearchResponse, Integer.valueOf($eps));
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0085 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws Exception {
        C00061 c00061;
        Object objLiveWireBuilder;
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
                c00062.L$0 = query;
                c00062.label = 1;
                if (ensureInit(c00062) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Map<String, String> mapMapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("search", query), TuplesKt.to("type", "2")});
                ArrayList arrayList = new ArrayList();
                Map<String, String> map = this.cookies;
                Map<String, String> map2 = this.wireData;
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00062.label = 2;
                objLiveWireBuilder = liveWireBuilder(mapMapOf, arrayList, map, map2, false, c00062);
                if (objLiveWireBuilder == coroutine_suspended) {
                    return coroutine_suspended;
                }
                JSONObject json = (JSONObject) objLiveWireBuilder;
                return parseJsonItems(json).getFirst();
            case 1:
                query = (String) c00062.L$0;
                ResultKt.throwOnFailure($result);
                Map<String, String> mapMapOf2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("search", query), TuplesKt.to("type", "2")});
                ArrayList arrayList2 = new ArrayList();
                Map<String, String> map3 = this.cookies;
                Map<String, String> map4 = this.wireData;
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00062.label = 2;
                objLiveWireBuilder = liveWireBuilder(mapMapOf2, arrayList2, map3, map4, false, c00062);
                if (objLiveWireBuilder == coroutine_suspended) {
                    return coroutine_suspended;
                }
                JSONObject json2 = (JSONObject) objLiveWireBuilder;
                return parseJsonItems(json2).getFirst();
            case 2:
                ResultKt.throwOnFailure($result);
                objLiveWireBuilder = $result;
                JSONObject json3 = (JSONObject) objLiveWireBuilder;
                return parseJsonItems(json3).getFirst();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0074  */
    /* JADX WARN: Code duplicated, block: B:20:0x008c  */
    /* JADX WARN: Code duplicated, block: B:22:0x009a  */
    /* JADX WARN: Code duplicated, block: B:24:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:27:0x00fa A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:31:0x0115  */
    /* JADX WARN: Code duplicated, block: B:32:0x011d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0130  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws Exception {
        C00011 c00011;
        List calls;
        Map updates;
        String cursor;
        Object objLiveWireBuilder;
        String nextCursor;
        Map<String, String> map;
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
                c00012.L$0 = request;
                c00012.I$0 = page;
                c00012.label = 1;
                if (ensureInit(c00012) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                calls = new ArrayList();
                updates = new LinkedHashMap();
                if (page == 1) {
                    updates.put("type", request.getData());
                    updates.put("search", "");
                    this.pageCursors.remove(request.getName());
                } else {
                    cursor = this.pageCursors.get(request.getName());
                    if (cursor == null) {
                        return MainAPIKt.newHomePageResponse(new HomePageList(request.getName(), CollectionsKt.emptyList(), false), Boxing.boxBoolean(false));
                    }
                    Boxing.boxBoolean(calls.add(MapsKt.mapOf(new Pair[]{TuplesKt.to("path", ""), TuplesKt.to("method", "loadPage"), TuplesKt.to("params", CollectionsKt.listOf(cursor))})));
                }
                Map<String, String> map2 = this.cookies;
                Map<String, String> map3 = this.wireData;
                c00012.L$0 = request;
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(calls);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(updates);
                c00012.I$0 = page;
                c00012.label = 2;
                objLiveWireBuilder = liveWireBuilder(updates, calls, map2, map3, true, c00012);
                if (objLiveWireBuilder == coroutine_suspended) {
                    return coroutine_suspended;
                }
                JSONObject json = (JSONObject) objLiveWireBuilder;
                Pair<List<SearchResponse>, String> jsonItems = parseJsonItems(json);
                List items = (List) jsonItems.component1();
                nextCursor = (String) jsonItems.component2();
                map = this.pageCursors;
                if (nextCursor != null) {
                    map.put(request.getName(), nextCursor);
                } else {
                    map.remove(request.getName());
                }
                return MainAPIKt.newHomePageResponse(new HomePageList(request.getName(), items, false), Boxing.boxBoolean(nextCursor != null));
            case 1:
                page = c00012.I$0;
                request = (MainPageRequest) c00012.L$0;
                ResultKt.throwOnFailure($result);
                calls = new ArrayList();
                updates = new LinkedHashMap();
                if (page == 1) {
                    updates.put("type", request.getData());
                    updates.put("search", "");
                    this.pageCursors.remove(request.getName());
                } else {
                    cursor = this.pageCursors.get(request.getName());
                    if (cursor == null) {
                        return MainAPIKt.newHomePageResponse(new HomePageList(request.getName(), CollectionsKt.emptyList(), false), Boxing.boxBoolean(false));
                    }
                    Boxing.boxBoolean(calls.add(MapsKt.mapOf(new Pair[]{TuplesKt.to("path", ""), TuplesKt.to("method", "loadPage"), TuplesKt.to("params", CollectionsKt.listOf(cursor))})));
                }
                Map<String, String> map4 = this.cookies;
                Map<String, String> map5 = this.wireData;
                c00012.L$0 = request;
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(calls);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(updates);
                c00012.I$0 = page;
                c00012.label = 2;
                objLiveWireBuilder = liveWireBuilder(updates, calls, map4, map5, true, c00012);
                if (objLiveWireBuilder == coroutine_suspended) {
                    return coroutine_suspended;
                }
                JSONObject json2 = (JSONObject) objLiveWireBuilder;
                Pair<List<SearchResponse>, String> jsonItems2 = parseJsonItems(json2);
                List items2 = (List) jsonItems2.component1();
                nextCursor = (String) jsonItems2.component2();
                map = this.pageCursors;
                if (nextCursor != null) {
                    map.put(request.getName(), nextCursor);
                } else {
                    map.remove(request.getName());
                }
                return MainAPIKt.newHomePageResponse(new HomePageList(request.getName(), items2, false), Boxing.boxBoolean(nextCursor != null));
            case 2:
                int page2 = c00012.I$0;
                request = (MainPageRequest) c00012.L$0;
                ResultKt.throwOnFailure($result);
                objLiveWireBuilder = $result;
                JSONObject json3 = (JSONObject) objLiveWireBuilder;
                Pair<List<SearchResponse>, String> jsonItems3 = parseJsonItems(json3);
                List items3 = (List) jsonItems3.component1();
                nextCursor = (String) jsonItems3.component2();
                map = this.pageCursors;
                if (nextCursor != null) {
                    map.put(request.getName(), nextCursor);
                } else {
                    map.remove(request.getName());
                }
                return MainAPIKt.newHomePageResponse(new HomePageList(request.getName(), items3, false), Boxing.boxBoolean(nextCursor != null));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final String extractTitleFromXData(String xdata) throws JSONException {
        String title;
        MatchResult titleMatch;
        String string;
        String title2 = "";
        SharedPreferences sharedPreferences = this.sharedPref;
        String prefLanguage = "1";
        if (sharedPreferences != null && (string = sharedPreferences.getString("anizone_title_language", "1")) != null) {
            prefLanguage = string;
        }
        MatchResult jsonMatch = Regex.find$default(new Regex("JSON\\.parse\\(['\"](.+?)['\"]\\)"), xdata, 0, 2, (Object) null);
        if (jsonMatch != null) {
            String cleanJson = StringsKt.replace$default(StringsKt.replace$default((String) jsonMatch.getGroupValues().get(1), "\\u0022", "\"", false, 4, (Object) null), "\\\\", "\\", false, 4, (Object) null);
            try {
                JSONObject json = new JSONObject(cleanJson);
                if (!Intrinsics.areEqual(prefLanguage, "0") && json.has(prefLanguage)) {
                    title2 = json.getString(prefLanguage);
                }
            } catch (Exception e) {
            }
        }
        if (StringsKt.isBlank(title2) && (titleMatch = Regex.find$default(new Regex("window\\.getTitle\\(.*?, *['\"](.+?)['\"]\\)"), xdata, 0, 2, (Object) null)) != null) {
            title2 = StringsKt.replace$default(StringsKt.replace$default((String) titleMatch.getGroupValues().get(1), "&quot;", "\"", false, 4, (Object) null), "\\'", "'", false, 4, (Object) null);
        }
        if (StringsKt.isBlank(title2) && jsonMatch != null) {
            String cleanJson2 = StringsKt.replace$default(StringsKt.replace$default((String) jsonMatch.getGroupValues().get(1), "\\u0022", "\"", false, 4, (Object) null), "\\\\", "\\", false, 4, (Object) null);
            try {
                JSONObject json2 = new JSONObject(cleanJson2);
                String it = (String) SequencesKt.firstOrNull(SequencesKt.asSequence(json2.keys()));
                if (it == null || (title = json2.getString(it)) == null) {
                    title = "";
                }
                return title;
            } catch (Exception e2) {
                return title2;
            }
        }
        return title2;
    }

    private final SearchResponse toResult(final Element post) throws JSONException {
        String strAttr;
        Integer intOrNull;
        Object element$iv;
        String strSubstringBefore$default;
        String it;
        String xdata = post.attr("x-data");
        String title = extractTitleFromXData(xdata);
        Element elementSelectFirst = post.selectFirst("a");
        if (elementSelectFirst == null || (strAttr = elementSelectFirst.attr("href")) == null) {
            strAttr = "";
        }
        String url = strAttr;
        Iterable $this$map$iv = post.select("div.inline.text-xs span");
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Element it2 = (Element) item$iv$iv;
            destination$iv$iv.add(StringsKt.trim(it2.text()).toString());
        }
        Iterable $this$firstOrNull$iv = (List) destination$iv$iv;
        Iterator it3 = $this$firstOrNull$iv.iterator();
        do {
            intOrNull = null;
            if (!it3.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it3.next();
            it = (String) element$iv;
        } while (!StringsKt.endsWith(it, "Eps", true));
        String str = (String) element$iv;
        if (str != null && (strSubstringBefore$default = StringsKt.substringBefore$default(str, " ", (String) null, 2, (Object) null)) != null) {
            intOrNull = StringsKt.toIntOrNull(strSubstringBefore$default);
        }
        final Integer epsCount = intOrNull;
        return MainAPIKt.newAnimeSearchResponse$default(this, title, url, TvType.Anime, false, new Function1() { // from class: com.ycngmn.AnizoneProvider$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return AnizoneProvider.toResult$lambda$2(post, epsCount, (AnimeSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    static final Unit toResult$lambda$2(Element $post, Integer $epsCount, AnimeSearchResponse $this$newAnimeSearchResponse) {
        Element elementSelectFirst = $post.selectFirst("img");
        $this$newAnimeSearchResponse.setPosterUrl(elementSelectFirst != null ? elementSelectFirst.attr("src") : null);
        MainAPIKt.addSub($this$newAnimeSearchResponse, $epsCount);
        return Unit.INSTANCE;
    }

    @Nullable
    public Object quickSearch(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        return search(query, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002d  */
    /* JADX WARN: Code duplicated, block: B:24:0x004a  */
    /* JADX WARN: Code duplicated, block: B:26:0x004d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0063  */
    /* JADX WARN: Code duplicated, block: B:34:0x0066  */
    /* JADX WARN: Code duplicated, block: B:36:0x0069  */
    /* JADX WARN: Code duplicated, block: B:37:0x0070  */
    private final Episode parseEpisodeItem(JSONObject item) {
        final String it;
        String it2;
        String slug = item.optString("slug");
        JSONObject titleList = item.optJSONObject("title_list");
        String str = null;
        if (titleList == null || (it = titleList.optString("1")) == null) {
            if (titleList != null || (it = titleList.optString("9")) == null) {
                it = null;
            } else {
                if (!(it.length() > 0)) {
                    it = null;
                }
            }
            if (it == null) {
                if (titleList != null && (it2 = titleList.optString("5")) != null) {
                    if (it2.length() > 0) {
                        str = it2;
                    }
                }
                if (str == null) {
                    it = item.optString("main_title");
                } else {
                    it = str;
                }
            }
        } else {
            if (!(it.length() > 0)) {
                it = null;
            }
            if (it == null) {
                if (titleList != null) {
                    it = null;
                } else {
                    it = null;
                }
                if (it == null) {
                    if (titleList != null) {
                        if (it2.length() > 0) {
                            str = it2;
                        }
                    }
                    if (str == null) {
                        it = item.optString("main_title");
                    } else {
                        it = str;
                    }
                }
            }
        }
        String url = item.optString("url");
        final String snapshot = item.optString("snapshot");
        final Integer episodeNum = StringsKt.toIntOrNull(slug);
        return MainAPIKt.newEpisode(this, url, new Function1() { // from class: com.ycngmn.AnizoneProvider$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return AnizoneProvider.parseEpisodeItem$lambda$3(it, snapshot, episodeNum, (Episode) obj);
            }
        });
    }

    static final Unit parseEpisodeItem$lambda$3(String $episodeName, String $snapshot, Integer $episodeNum, Episode $this$newEpisode) {
        $this$newEpisode.setName($episodeName);
        $this$newEpisode.setPosterUrl($snapshot.length() > 0 ? $snapshot : null);
        $this$newEpisode.setEpisode($episodeNum);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0073  */
    /* JADX WARN: Code duplicated, block: B:30:0x0076  */
    private final Pair<List<Episode>, String> parseEpisodesFromJson(JSONObject json) throws JSONException {
        JSONObject params;
        boolean z;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        List eps = new ArrayList();
        String nextCursor = null;
        JSONArray jSONArrayOptJSONArray = json.optJSONArray("components");
        JSONArray dispatches = (jSONArrayOptJSONArray == null || (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("effects")) == null) ? null : jSONObjectOptJSONObject2.optJSONArray("dispatches");
        if (dispatches != null) {
            int length = dispatches.length();
            for (int i = 0; i < length; i++) {
                JSONObject dispatch = dispatches.getJSONObject(i);
                String name = dispatch.optString("name");
                if ((Intrinsics.areEqual(name, "items-loaded") || Intrinsics.areEqual(name, "filters-reset")) && (params = dispatch.optJSONObject("params")) != null) {
                    nextCursor = params.optString("nextCursor", null);
                    if (Intrinsics.areEqual(nextCursor, "null")) {
                        nextCursor = null;
                    } else {
                        if (nextCursor != null) {
                            z = nextCursor.length() == 0;
                        }
                        if (z) {
                            nextCursor = null;
                        }
                    }
                    JSONArray items = params.optJSONArray("items");
                    if (items != null) {
                        int length2 = items.length();
                        for (int j = 0; j < length2; j++) {
                            eps.add(parseEpisodeItem(items.getJSONObject(j)));
                        }
                    }
                }
            }
        }
        return new Pair<>(eps, nextCursor);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NotImplementedError */
    /* JADX WARN: Code duplicated, block: B:103:0x0476  */
    /* JADX WARN: Code duplicated, block: B:104:0x0478  */
    /* JADX WARN: Code duplicated, block: B:109:0x04b3  */
    /* JADX WARN: Code duplicated, block: B:115:0x059a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:116:0x059b  */
    /* JADX WARN: Code duplicated, block: B:118:0x05bb  */
    /* JADX WARN: Code duplicated, block: B:121:0x04e3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x04d3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:0x027a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:28:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:32:0x01df  */
    /* JADX WARN: Code duplicated, block: B:36:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:38:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:39:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:42:0x0206  */
    /* JADX WARN: Code duplicated, block: B:43:0x020b  */
    /* JADX WARN: Code duplicated, block: B:48:0x021a  */
    /* JADX WARN: Code duplicated, block: B:52:0x023f A[LOOP:1: B:50:0x0239->B:52:0x023f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:56:0x0266  */
    /* JADX WARN: Code duplicated, block: B:58:0x0274  */
    /* JADX WARN: Code duplicated, block: B:59:0x0276  */
    /* JADX WARN: Code duplicated, block: B:65:0x027f  */
    /* JADX WARN: Code duplicated, block: B:66:0x0284  */
    /* JADX WARN: Code duplicated, block: B:69:0x028d  */
    /* JADX WARN: Code duplicated, block: B:70:0x0290  */
    /* JADX WARN: Code duplicated, block: B:72:0x0298  */
    /* JADX WARN: Code duplicated, block: B:73:0x029b  */
    /* JADX WARN: Code duplicated, block: B:77:0x02c4 A[LOOP:3: B:75:0x02be->B:77:0x02c4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x0303  */
    /* JADX WARN: Code duplicated, block: B:82:0x0341 A[LOOP:4: B:81:0x033f->B:82:0x0341, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:86:0x036b  */
    /* JADX WARN: Code duplicated, block: B:90:0x037b  */
    /* JADX WARN: Code duplicated, block: B:91:0x037d  */
    /* JADX WARN: Code duplicated, block: B:95:0x039d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:100:0x043f -> B:101:0x0457). Please report as a decompilation issue!!! */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) throws Exception {
        C00031 c00031;
        String str;
        Object $result;
        C00031 c00032;
        Object obj;
        int i;
        char c;
        Object obj2;
        String url2;
        NiceResponse r;
        Document doc;
        Map<String, String> mutableMap;
        Map<String, String> mapMutableMapOf;
        Element elementSelectFirst;
        String title;
        String xdata;
        Element elementSelectFirst2;
        String poster;
        Element elementSelectFirst3;
        String bgImage;
        Element elementSelectFirst4;
        String synopsis;
        Collection destination$iv$iv;
        List rowLines;
        Iterator it;
        Object next;
        String str2;
        Integer releasedYear;
        ShowStatus status;
        List rowLines2;
        Collection destination$iv$iv2;
        Iterable $this$mapTo$iv$iv;
        List allEpisodes;
        NiceResponse r2;
        MatchResult itemsMatch;
        String nextCursor;
        MatchResult matchResultFind$default;
        int i2;
        AnizoneProvider anizoneProvider;
        Continuation<? super LoadResponse> continuation2;
        Document doc2;
        Map<String, String> map;
        C00031 c00033;
        String url3;
        List allEpisodes2;
        String title2;
        String synopsis2;
        MatchResult itemsMatch2;
        int i3;
        Integer releasedYear2;
        String bgImage2;
        List genres;
        int pagesFetched;
        String url4;
        ShowStatus status2;
        Object obj3;
        List groupValues;
        String jsonStr;
        JSONArray itemsArr;
        int i4;
        int length;
        String it2;
        boolean z;
        Element elementSelectFirst5;
        String xdata2;
        String strText;
        String nextCursor2;
        Object obj4;
        HashSet set$iv;
        ArrayList list$iv;
        Object objNewAnimeLoadResponse$default;
        String data;
        HashSet set$iv2;
        Map<String, String> map2;
        Map<String, String> map3;
        String url5;
        Document doc3;
        AnizoneProvider anizoneProvider2;
        Integer releasedYear3;
        ShowStatus status3;
        Object $result2;
        List rowLines3;
        MatchResult itemsMatch3;
        Object obj5;
        List genres2;
        Continuation<? super LoadResponse> continuation3;
        String cursor;
        int i5;
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
            } else {
                c00031 = new C00031(continuation);
            }
        } else {
            c00031 = new C00031(continuation);
        }
        Object $result3 = c00031.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00031.label) {
            case 0:
                ResultKt.throwOnFailure($result3);
                Requests app = MainActivityKt.getApp();
                c00031.L$0 = url;
                c00031.label = 1;
                str = "";
                $result = $result3;
                c00032 = c00031;
                obj = coroutine_suspended;
                i = 2;
                c = 0;
                Object obj6 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00032, 4094, (Object) null);
                if (obj6 == obj) {
                    return obj;
                }
                obj2 = obj6;
                url2 = url;
                r = (NiceResponse) obj2;
                doc = r.getDocument();
                mutableMap = MapsKt.toMutableMap(r.getCookies());
                Pair[] pairArr = new Pair[i];
                pairArr[c] = TuplesKt.to("wireSnapshot", getSnapshot(doc));
                pairArr[1] = TuplesKt.to("token", doc.select("script[data-csrf]").attr("data-csrf"));
                mapMutableMapOf = MapsKt.mutableMapOf(pairArr);
                elementSelectFirst = doc.selectFirst("h1");
                if (elementSelectFirst != null || (strText = elementSelectFirst.text()) == null || (title = StringsKt.trim(strText).toString()) == null) {
                    title = str;
                }
                if (StringsKt.isBlank(title)) {
                    elementSelectFirst5 = doc.selectFirst("[x-data*=\"displayAnimeTitle\"]");
                    if (elementSelectFirst5 != null || (xdata2 = elementSelectFirst5.attr("x-data")) == null) {
                        xdata2 = str;
                    }
                    title = extractTitleFromXData(xdata2);
                }
                xdata = title;
                if (!StringsKt.isBlank(xdata)) {
                    throw new NotImplementedError("Unable to find title");
                }
                elementSelectFirst2 = doc.selectFirst("div.mx-auto.lg\\:mx-0 > img");
                if (elementSelectFirst2 != null) {
                    poster = elementSelectFirst2.attr("src");
                } else {
                    poster = null;
                }
                elementSelectFirst3 = doc.selectFirst("main img");
                if (elementSelectFirst3 != null) {
                    bgImage = elementSelectFirst3.attr("src");
                } else {
                    bgImage = null;
                }
                elementSelectFirst4 = doc.selectFirst(".sr-only + div");
                if (elementSelectFirst4 != null || (synopsis = elementSelectFirst4.text()) == null) {
                    synopsis = str;
                }
                Iterable $this$map$iv = doc.select("span.inline-block");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Element it3 = (Element) item$iv$iv;
                    destination$iv$iv.add(it3.text());
                }
                rowLines = (List) destination$iv$iv;
                it = rowLines.iterator();
                do {
                    if (it.hasNext()) {
                        next = it.next();
                        it2 = (String) next;
                        if (StringsKt.toIntOrNull(it2) != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } else {
                        next = null;
                    }
                    str2 = (String) next;
                    if (str2 != null) {
                        releasedYear = StringsKt.toIntOrNull(str2);
                    } else {
                        releasedYear = null;
                    }
                    if (rowLines.contains("Completed")) {
                        status = ShowStatus.Completed;
                    } else if (rowLines.contains("Ongoing")) {
                        status = ShowStatus.Ongoing;
                    } else {
                        status = null;
                    }
                    Iterable $this$map$iv2 = doc.select("a[wire:navigate][wire:key]");
                    rowLines2 = rowLines;
                    Object obj7 = obj;
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    $this$mapTo$iv$iv = $this$map$iv2;
                    for (Object item$iv$iv2 : $this$mapTo$iv$iv) {
                        Element it4 = (Element) item$iv$iv2;
                        destination$iv$iv2.add(it4.text());
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                    }
                    List genres3 = (List) destination$iv$iv2;
                    allEpisodes = new ArrayList();
                    String url6 = url2;
                    r2 = r;
                    itemsMatch = Regex.find$default(new Regex("items:\\s*JSON\\.parse\\(\\s*['\"](.*?)['\"]\\s*\\)"), doc.html(), 0, 2, (Object) null);
                    if (itemsMatch != null) {
                        jsonStr = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default((String) itemsMatch.getGroupValues().get(1), "\\u0022", "\"", false, 4, (Object) null), "\\/", "/", false, 4, (Object) null), "\\\\", "\\", false, 4, (Object) null);
                        itemsArr = new JSONArray(jsonStr);
                        i4 = 0;
                        length = itemsArr.length();
                        while (i4 < length) {
                            allEpisodes.add(parseEpisodeItem(itemsArr.getJSONObject(i4)));
                            i4++;
                            jsonStr = jsonStr;
                        }
                    }
                    nextCursor = null;
                    matchResultFind$default = Regex.find$default(new Regex("nextCursor\\s*:\\s*['\"]([a-zA-Z0-9+/=]+)['\"]"), doc.html(), 0, 2, (Object) null);
                    if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null) {
                        nextCursor = (String) groupValues.get(1);
                    }
                    if (nextCursor != null) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    anizoneProvider = this;
                    continuation2 = continuation;
                    doc2 = doc;
                    map = mapMutableMapOf;
                    c00033 = c00032;
                    url3 = url6;
                    allEpisodes2 = allEpisodes;
                    title2 = title;
                    synopsis2 = synopsis;
                    itemsMatch2 = itemsMatch;
                    i3 = i2;
                    releasedYear2 = releasedYear;
                    bgImage2 = bgImage;
                    genres = genres3;
                    pagesFetched = 0;
                    url4 = poster;
                    status2 = status;
                    obj3 = obj7;
                    nextCursor2 = nextCursor;
                    if (i3 != 0 || pagesFetched >= 50) {
                        Map<String, String> map4 = map;
                        Map<String, String> map5 = mutableMap;
                        obj4 = obj3;
                        AnizoneProvider anizoneProvider3 = anizoneProvider;
                        Iterable $this$distinctBy$iv = allEpisodes2;
                        set$iv = new HashSet();
                        list$iv = new ArrayList();
                        for (Object e$iv : $this$distinctBy$iv) {
                            genres = genres;
                            Episode it5 = (Episode) e$iv;
                            data = it5.getData();
                            url4 = url4;
                            set$iv2 = set$iv;
                            title2 = title2;
                            if (set$iv2.add(data)) {
                                list$iv.add(e$iv);
                                set$iv = set$iv2;
                            } else {
                                set$iv = set$iv2;
                            }
                        }
                        List genres4 = genres;
                        String poster2 = url4;
                        String title3 = title2;
                        List finalEpisodes = CollectionsKt.reversed(list$iv);
                        TvType tvType = TvType.Anime;
                        String synopsis3 = synopsis2;
                        String bgImage3 = bgImage2;
                        ShowStatus status4 = status2;
                        Integer releasedYear4 = releasedYear2;
                        C00042 c00042 = new C00042(poster2, bgImage3, synopsis3, genres4, releasedYear4, status4, finalEpisodes, null);
                        c00033.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                        c00033.L$1 = SpillingKt.nullOutSpilledVariable(r2);
                        c00033.L$2 = SpillingKt.nullOutSpilledVariable(doc2);
                        c00033.L$3 = SpillingKt.nullOutSpilledVariable(map5);
                        c00033.L$4 = SpillingKt.nullOutSpilledVariable(map4);
                        c00033.L$5 = SpillingKt.nullOutSpilledVariable(title3);
                        c00033.L$6 = SpillingKt.nullOutSpilledVariable(poster2);
                        c00033.L$7 = SpillingKt.nullOutSpilledVariable(bgImage3);
                        c00033.L$8 = SpillingKt.nullOutSpilledVariable(synopsis3);
                        c00033.L$9 = SpillingKt.nullOutSpilledVariable(rowLines2);
                        c00033.L$10 = SpillingKt.nullOutSpilledVariable(releasedYear4);
                        c00033.L$11 = SpillingKt.nullOutSpilledVariable(status4);
                        c00033.L$12 = SpillingKt.nullOutSpilledVariable(genres4);
                        c00033.L$13 = SpillingKt.nullOutSpilledVariable(allEpisodes2);
                        c00033.L$14 = SpillingKt.nullOutSpilledVariable(itemsMatch2);
                        c00033.L$15 = SpillingKt.nullOutSpilledVariable(nextCursor2);
                        c00033.L$16 = SpillingKt.nullOutSpilledVariable(finalEpisodes);
                        c00033.I$0 = i3;
                        c00033.I$1 = pagesFetched;
                        c00033.label = 3;
                        objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(anizoneProvider3, title3, url3, tvType, false, c00042, c00033, 8, (Object) null);
                        if (objNewAnimeLoadResponse$default == obj4) {
                            return obj4;
                        }
                        return objNewAnimeLoadResponse$default;
                    }
                    pagesFetched++;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    Object obj8 = obj3;
                    Intrinsics.checkNotNull(nextCursor2);
                    List<? extends Map<String, ? extends Object>> listMutableListOf = CollectionsKt.mutableListOf(new Map[]{MapsKt.mapOf(new Pair[]{TuplesKt.to("path", str), TuplesKt.to("method", "loadPage"), TuplesKt.to("params", CollectionsKt.listOf(nextCursor2))})});
                    c00033.L$0 = url3;
                    c00033.L$1 = SpillingKt.nullOutSpilledVariable(r2);
                    c00033.L$2 = SpillingKt.nullOutSpilledVariable(doc2);
                    c00033.L$3 = mutableMap;
                    c00033.L$4 = map;
                    c00033.L$5 = title2;
                    c00033.L$6 = url4;
                    c00033.L$7 = bgImage2;
                    c00033.L$8 = synopsis2;
                    c00033.L$9 = SpillingKt.nullOutSpilledVariable(rowLines2);
                    c00033.L$10 = releasedYear2;
                    c00033.L$11 = status2;
                    c00033.L$12 = genres;
                    c00033.L$13 = allEpisodes2;
                    c00033.L$14 = SpillingKt.nullOutSpilledVariable(itemsMatch2);
                    c00033.L$15 = SpillingKt.nullOutSpilledVariable(nextCursor2);
                    c00033.I$0 = i3;
                    c00033.I$1 = pagesFetched;
                    c00033.label = 2;
                    Map<String, String> map6 = map;
                    Map<String, String> map7 = mutableMap;
                    Object objLiveWireBuilder = anizoneProvider.liveWireBuilder(linkedHashMap, listMutableListOf, map7, map6, true, c00033);
                    AnizoneProvider anizoneProvider4 = anizoneProvider;
                    map2 = map7;
                    map3 = map6;
                    if (objLiveWireBuilder == obj8) {
                        return obj8;
                    }
                    url5 = url3;
                    $result3 = objLiveWireBuilder;
                    doc3 = doc2;
                    anizoneProvider2 = anizoneProvider4;
                    releasedYear3 = releasedYear2;
                    status3 = status2;
                    $result2 = $result;
                    rowLines3 = rowLines2;
                    itemsMatch3 = itemsMatch2;
                    obj5 = obj8;
                    genres2 = genres;
                    continuation3 = continuation2;
                    JSONObject jsonResponse = (JSONObject) $result3;
                    Pair<List<Episode>, String> episodesFromJson = anizoneProvider2.parseEpisodesFromJson(jsonResponse);
                    List newEps = (List) episodesFromJson.component1();
                    cursor = (String) episodesFromJson.component2();
                    continuation2 = continuation3;
                    allEpisodes2.addAll(newEps);
                    if (cursor != null) {
                        i5 = 1;
                    } else {
                        i5 = 0;
                    }
                    url3 = url5;
                    anizoneProvider = anizoneProvider2;
                    mutableMap = map2;
                    map = map3;
                    obj3 = obj5;
                    itemsMatch2 = itemsMatch3;
                    rowLines2 = rowLines3;
                    $result = $result2;
                    doc2 = doc3;
                    nextCursor = cursor;
                    genres = genres2;
                    i3 = i5;
                    status2 = status3;
                    releasedYear2 = releasedYear3;
                    nextCursor2 = nextCursor;
                    if (i3 != 0) {
                    }
                    Map<String, String> map8 = map;
                    Map<String, String> map9 = mutableMap;
                    obj4 = obj3;
                    AnizoneProvider anizoneProvider5 = anizoneProvider;
                    Iterable $this$distinctBy$iv2 = allEpisodes2;
                    set$iv = new HashSet();
                    list$iv = new ArrayList();
                    while (r21.hasNext()) {
                        genres = genres;
                        Episode it6 = (Episode) e$iv;
                        data = it6.getData();
                        url4 = url4;
                        set$iv2 = set$iv;
                        title2 = title2;
                        if (set$iv2.add(data)) {
                            list$iv.add(e$iv);
                            set$iv = set$iv2;
                        } else {
                            set$iv = set$iv2;
                        }
                    }
                    List genres5 = genres;
                    String poster3 = url4;
                    String title4 = title2;
                    List finalEpisodes2 = CollectionsKt.reversed(list$iv);
                    TvType tvType2 = TvType.Anime;
                    String synopsis4 = synopsis2;
                    String bgImage4 = bgImage2;
                    ShowStatus status5 = status2;
                    Integer releasedYear5 = releasedYear2;
                    C00042 c00043 = new C00042(poster3, bgImage4, synopsis4, genres5, releasedYear5, status5, finalEpisodes2, null);
                    c00033.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c00033.L$1 = SpillingKt.nullOutSpilledVariable(r2);
                    c00033.L$2 = SpillingKt.nullOutSpilledVariable(doc2);
                    c00033.L$3 = SpillingKt.nullOutSpilledVariable(map9);
                    c00033.L$4 = SpillingKt.nullOutSpilledVariable(map8);
                    c00033.L$5 = SpillingKt.nullOutSpilledVariable(title4);
                    c00033.L$6 = SpillingKt.nullOutSpilledVariable(poster3);
                    c00033.L$7 = SpillingKt.nullOutSpilledVariable(bgImage4);
                    c00033.L$8 = SpillingKt.nullOutSpilledVariable(synopsis4);
                    c00033.L$9 = SpillingKt.nullOutSpilledVariable(rowLines2);
                    c00033.L$10 = SpillingKt.nullOutSpilledVariable(releasedYear5);
                    c00033.L$11 = SpillingKt.nullOutSpilledVariable(status5);
                    c00033.L$12 = SpillingKt.nullOutSpilledVariable(genres5);
                    c00033.L$13 = SpillingKt.nullOutSpilledVariable(allEpisodes2);
                    c00033.L$14 = SpillingKt.nullOutSpilledVariable(itemsMatch2);
                    c00033.L$15 = SpillingKt.nullOutSpilledVariable(nextCursor2);
                    c00033.L$16 = SpillingKt.nullOutSpilledVariable(finalEpisodes2);
                    c00033.I$0 = i3;
                    c00033.I$1 = pagesFetched;
                    c00033.label = 3;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(anizoneProvider5, title4, url3, tvType2, false, c00043, c00033, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj4) {
                        return obj4;
                    }
                    return objNewAnimeLoadResponse$default;
                } while (!z);
                str2 = (String) next;
                if (str2 != null) {
                    releasedYear = StringsKt.toIntOrNull(str2);
                } else {
                    releasedYear = null;
                }
                if (rowLines.contains("Completed")) {
                    status = ShowStatus.Completed;
                } else if (rowLines.contains("Ongoing")) {
                    status = ShowStatus.Ongoing;
                } else {
                    status = null;
                }
                Iterable $this$map$iv3 = doc.select("a[wire:navigate][wire:key]");
                rowLines2 = rowLines;
                Object obj9 = obj;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                $this$mapTo$iv$iv = $this$map$iv3;
                while (r25.hasNext()) {
                    Element it7 = (Element) item$iv$iv2;
                    destination$iv$iv2.add(it7.text());
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                }
                List genres6 = (List) destination$iv$iv2;
                allEpisodes = new ArrayList();
                String url7 = url2;
                r2 = r;
                itemsMatch = Regex.find$default(new Regex("items:\\s*JSON\\.parse\\(\\s*['\"](.*?)['\"]\\s*\\)"), doc.html(), 0, 2, (Object) null);
                if (itemsMatch != null) {
                    jsonStr = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default((String) itemsMatch.getGroupValues().get(1), "\\u0022", "\"", false, 4, (Object) null), "\\/", "/", false, 4, (Object) null), "\\\\", "\\", false, 4, (Object) null);
                    itemsArr = new JSONArray(jsonStr);
                    i4 = 0;
                    length = itemsArr.length();
                    while (i4 < length) {
                        allEpisodes.add(parseEpisodeItem(itemsArr.getJSONObject(i4)));
                        i4++;
                        jsonStr = jsonStr;
                    }
                }
                nextCursor = null;
                matchResultFind$default = Regex.find$default(new Regex("nextCursor\\s*:\\s*['\"]([a-zA-Z0-9+/=]+)['\"]"), doc.html(), 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    nextCursor = (String) groupValues.get(1);
                }
                if (nextCursor != null) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                anizoneProvider = this;
                continuation2 = continuation;
                doc2 = doc;
                map = mapMutableMapOf;
                c00033 = c00032;
                url3 = url7;
                allEpisodes2 = allEpisodes;
                title2 = title;
                synopsis2 = synopsis;
                itemsMatch2 = itemsMatch;
                i3 = i2;
                releasedYear2 = releasedYear;
                bgImage2 = bgImage;
                genres = genres6;
                pagesFetched = 0;
                url4 = poster;
                status2 = status;
                obj3 = obj9;
                nextCursor2 = nextCursor;
                if (i3 != 0) {
                }
                Map<String, String> map10 = map;
                Map<String, String> map11 = mutableMap;
                obj4 = obj3;
                AnizoneProvider anizoneProvider6 = anizoneProvider;
                Iterable $this$distinctBy$iv3 = allEpisodes2;
                set$iv = new HashSet();
                list$iv = new ArrayList();
                while (r21.hasNext()) {
                    genres = genres;
                    Episode it8 = (Episode) e$iv;
                    data = it8.getData();
                    url4 = url4;
                    set$iv2 = set$iv;
                    title2 = title2;
                    if (set$iv2.add(data)) {
                        list$iv.add(e$iv);
                        set$iv = set$iv2;
                    } else {
                        set$iv = set$iv2;
                    }
                }
                List genres7 = genres;
                String poster4 = url4;
                String title5 = title2;
                List finalEpisodes3 = CollectionsKt.reversed(list$iv);
                TvType tvType3 = TvType.Anime;
                String synopsis5 = synopsis2;
                String bgImage5 = bgImage2;
                ShowStatus status6 = status2;
                Integer releasedYear6 = releasedYear2;
                C00042 c00044 = new C00042(poster4, bgImage5, synopsis5, genres7, releasedYear6, status6, finalEpisodes3, null);
                c00033.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00033.L$1 = SpillingKt.nullOutSpilledVariable(r2);
                c00033.L$2 = SpillingKt.nullOutSpilledVariable(doc2);
                c00033.L$3 = SpillingKt.nullOutSpilledVariable(map11);
                c00033.L$4 = SpillingKt.nullOutSpilledVariable(map10);
                c00033.L$5 = SpillingKt.nullOutSpilledVariable(title5);
                c00033.L$6 = SpillingKt.nullOutSpilledVariable(poster4);
                c00033.L$7 = SpillingKt.nullOutSpilledVariable(bgImage5);
                c00033.L$8 = SpillingKt.nullOutSpilledVariable(synopsis5);
                c00033.L$9 = SpillingKt.nullOutSpilledVariable(rowLines2);
                c00033.L$10 = SpillingKt.nullOutSpilledVariable(releasedYear6);
                c00033.L$11 = SpillingKt.nullOutSpilledVariable(status6);
                c00033.L$12 = SpillingKt.nullOutSpilledVariable(genres7);
                c00033.L$13 = SpillingKt.nullOutSpilledVariable(allEpisodes2);
                c00033.L$14 = SpillingKt.nullOutSpilledVariable(itemsMatch2);
                c00033.L$15 = SpillingKt.nullOutSpilledVariable(nextCursor2);
                c00033.L$16 = SpillingKt.nullOutSpilledVariable(finalEpisodes3);
                c00033.I$0 = i3;
                c00033.I$1 = pagesFetched;
                c00033.label = 3;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(anizoneProvider6, title5, url3, tvType3, false, c00044, c00033, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj4) {
                    return obj4;
                }
                return objNewAnimeLoadResponse$default;
            case 1:
                String url8 = (String) c00031.L$0;
                ResultKt.throwOnFailure($result3);
                c00032 = c00031;
                $result = $result3;
                obj = coroutine_suspended;
                str = "";
                c = 0;
                url2 = url8;
                obj2 = $result;
                i = 2;
                r = (NiceResponse) obj2;
                doc = r.getDocument();
                mutableMap = MapsKt.toMutableMap(r.getCookies());
                Pair[] pairArr2 = new Pair[i];
                pairArr2[c] = TuplesKt.to("wireSnapshot", getSnapshot(doc));
                pairArr2[1] = TuplesKt.to("token", doc.select("script[data-csrf]").attr("data-csrf"));
                mapMutableMapOf = MapsKt.mutableMapOf(pairArr2);
                elementSelectFirst = doc.selectFirst("h1");
                if (elementSelectFirst != null) {
                    title = str;
                } else {
                    title = str;
                }
                if (StringsKt.isBlank(title)) {
                    elementSelectFirst5 = doc.selectFirst("[x-data*=\"displayAnimeTitle\"]");
                    if (elementSelectFirst5 != null) {
                        xdata2 = str;
                    } else {
                        xdata2 = str;
                    }
                    title = extractTitleFromXData(xdata2);
                }
                xdata = title;
                if (!StringsKt.isBlank(xdata)) {
                    throw new NotImplementedError("Unable to find title");
                }
                elementSelectFirst2 = doc.selectFirst("div.mx-auto.lg\\:mx-0 > img");
                if (elementSelectFirst2 != null) {
                    poster = elementSelectFirst2.attr("src");
                } else {
                    poster = null;
                }
                elementSelectFirst3 = doc.selectFirst("main img");
                if (elementSelectFirst3 != null) {
                    bgImage = elementSelectFirst3.attr("src");
                } else {
                    bgImage = null;
                }
                elementSelectFirst4 = doc.selectFirst(".sr-only + div");
                if (elementSelectFirst4 != null) {
                    synopsis = str;
                } else {
                    synopsis = str;
                }
                Iterable $this$map$iv4 = doc.select("span.inline-block");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                while (r23.hasNext()) {
                    Element it9 = (Element) item$iv$iv;
                    destination$iv$iv.add(it9.text());
                }
                rowLines = (List) destination$iv$iv;
                it = rowLines.iterator();
                do {
                    if (it.hasNext()) {
                        next = it.next();
                        it2 = (String) next;
                        if (StringsKt.toIntOrNull(it2) != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } else {
                        next = null;
                    }
                    str2 = (String) next;
                    if (str2 != null) {
                        releasedYear = StringsKt.toIntOrNull(str2);
                    } else {
                        releasedYear = null;
                    }
                    if (rowLines.contains("Completed")) {
                        status = ShowStatus.Completed;
                    } else if (rowLines.contains("Ongoing")) {
                        status = ShowStatus.Ongoing;
                    } else {
                        status = null;
                    }
                    Iterable $this$map$iv5 = doc.select("a[wire:navigate][wire:key]");
                    rowLines2 = rowLines;
                    Object obj10 = obj;
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
                    $this$mapTo$iv$iv = $this$map$iv5;
                    while (r25.hasNext()) {
                        Element it10 = (Element) item$iv$iv2;
                        destination$iv$iv2.add(it10.text());
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                    }
                    List genres8 = (List) destination$iv$iv2;
                    allEpisodes = new ArrayList();
                    String url9 = url2;
                    r2 = r;
                    itemsMatch = Regex.find$default(new Regex("items:\\s*JSON\\.parse\\(\\s*['\"](.*?)['\"]\\s*\\)"), doc.html(), 0, 2, (Object) null);
                    if (itemsMatch != null) {
                        jsonStr = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default((String) itemsMatch.getGroupValues().get(1), "\\u0022", "\"", false, 4, (Object) null), "\\/", "/", false, 4, (Object) null), "\\\\", "\\", false, 4, (Object) null);
                        itemsArr = new JSONArray(jsonStr);
                        i4 = 0;
                        length = itemsArr.length();
                        while (i4 < length) {
                            allEpisodes.add(parseEpisodeItem(itemsArr.getJSONObject(i4)));
                            i4++;
                            jsonStr = jsonStr;
                        }
                    }
                    nextCursor = null;
                    matchResultFind$default = Regex.find$default(new Regex("nextCursor\\s*:\\s*['\"]([a-zA-Z0-9+/=]+)['\"]"), doc.html(), 0, 2, (Object) null);
                    if (matchResultFind$default != null) {
                        nextCursor = (String) groupValues.get(1);
                    }
                    if (nextCursor != null) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    anizoneProvider = this;
                    continuation2 = continuation;
                    doc2 = doc;
                    map = mapMutableMapOf;
                    c00033 = c00032;
                    url3 = url9;
                    allEpisodes2 = allEpisodes;
                    title2 = title;
                    synopsis2 = synopsis;
                    itemsMatch2 = itemsMatch;
                    i3 = i2;
                    releasedYear2 = releasedYear;
                    bgImage2 = bgImage;
                    genres = genres8;
                    pagesFetched = 0;
                    url4 = poster;
                    status2 = status;
                    obj3 = obj10;
                    nextCursor2 = nextCursor;
                    if (i3 != 0) {
                        break;
                    }
                    Map<String, String> map12 = map;
                    Map<String, String> map13 = mutableMap;
                    obj4 = obj3;
                    AnizoneProvider anizoneProvider7 = anizoneProvider;
                    Iterable $this$distinctBy$iv4 = allEpisodes2;
                    set$iv = new HashSet();
                    list$iv = new ArrayList();
                    while (r21.hasNext()) {
                        genres = genres;
                        Episode it11 = (Episode) e$iv;
                        data = it11.getData();
                        url4 = url4;
                        set$iv2 = set$iv;
                        title2 = title2;
                        if (set$iv2.add(data)) {
                            list$iv.add(e$iv);
                            set$iv = set$iv2;
                        } else {
                            set$iv = set$iv2;
                        }
                    }
                    List genres9 = genres;
                    String poster5 = url4;
                    String title6 = title2;
                    List finalEpisodes4 = CollectionsKt.reversed(list$iv);
                    TvType tvType4 = TvType.Anime;
                    String synopsis6 = synopsis2;
                    String bgImage6 = bgImage2;
                    ShowStatus status7 = status2;
                    Integer releasedYear7 = releasedYear2;
                    C00042 c00045 = new C00042(poster5, bgImage6, synopsis6, genres9, releasedYear7, status7, finalEpisodes4, null);
                    c00033.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                    c00033.L$1 = SpillingKt.nullOutSpilledVariable(r2);
                    c00033.L$2 = SpillingKt.nullOutSpilledVariable(doc2);
                    c00033.L$3 = SpillingKt.nullOutSpilledVariable(map13);
                    c00033.L$4 = SpillingKt.nullOutSpilledVariable(map12);
                    c00033.L$5 = SpillingKt.nullOutSpilledVariable(title6);
                    c00033.L$6 = SpillingKt.nullOutSpilledVariable(poster5);
                    c00033.L$7 = SpillingKt.nullOutSpilledVariable(bgImage6);
                    c00033.L$8 = SpillingKt.nullOutSpilledVariable(synopsis6);
                    c00033.L$9 = SpillingKt.nullOutSpilledVariable(rowLines2);
                    c00033.L$10 = SpillingKt.nullOutSpilledVariable(releasedYear7);
                    c00033.L$11 = SpillingKt.nullOutSpilledVariable(status7);
                    c00033.L$12 = SpillingKt.nullOutSpilledVariable(genres9);
                    c00033.L$13 = SpillingKt.nullOutSpilledVariable(allEpisodes2);
                    c00033.L$14 = SpillingKt.nullOutSpilledVariable(itemsMatch2);
                    c00033.L$15 = SpillingKt.nullOutSpilledVariable(nextCursor2);
                    c00033.L$16 = SpillingKt.nullOutSpilledVariable(finalEpisodes4);
                    c00033.I$0 = i3;
                    c00033.I$1 = pagesFetched;
                    c00033.label = 3;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(anizoneProvider7, title6, url3, tvType4, false, c00045, c00033, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj4) {
                        return obj4;
                    }
                    return objNewAnimeLoadResponse$default;
                } while (!z);
                str2 = (String) next;
                if (str2 != null) {
                    releasedYear = StringsKt.toIntOrNull(str2);
                } else {
                    releasedYear = null;
                }
                if (rowLines.contains("Completed")) {
                    status = ShowStatus.Completed;
                } else if (rowLines.contains("Ongoing")) {
                    status = ShowStatus.Ongoing;
                } else {
                    status = null;
                }
                Iterable $this$map$iv6 = doc.select("a[wire:navigate][wire:key]");
                rowLines2 = rowLines;
                Object obj11 = obj;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv6, 10));
                $this$mapTo$iv$iv = $this$map$iv6;
                while (r25.hasNext()) {
                    Element it12 = (Element) item$iv$iv2;
                    destination$iv$iv2.add(it12.text());
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                }
                List genres10 = (List) destination$iv$iv2;
                allEpisodes = new ArrayList();
                String url10 = url2;
                r2 = r;
                itemsMatch = Regex.find$default(new Regex("items:\\s*JSON\\.parse\\(\\s*['\"](.*?)['\"]\\s*\\)"), doc.html(), 0, 2, (Object) null);
                if (itemsMatch != null) {
                    jsonStr = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default((String) itemsMatch.getGroupValues().get(1), "\\u0022", "\"", false, 4, (Object) null), "\\/", "/", false, 4, (Object) null), "\\\\", "\\", false, 4, (Object) null);
                    itemsArr = new JSONArray(jsonStr);
                    i4 = 0;
                    length = itemsArr.length();
                    while (i4 < length) {
                        allEpisodes.add(parseEpisodeItem(itemsArr.getJSONObject(i4)));
                        i4++;
                        jsonStr = jsonStr;
                    }
                }
                nextCursor = null;
                matchResultFind$default = Regex.find$default(new Regex("nextCursor\\s*:\\s*['\"]([a-zA-Z0-9+/=]+)['\"]"), doc.html(), 0, 2, (Object) null);
                if (matchResultFind$default != null) {
                    nextCursor = (String) groupValues.get(1);
                }
                if (nextCursor != null) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                anizoneProvider = this;
                continuation2 = continuation;
                doc2 = doc;
                map = mapMutableMapOf;
                c00033 = c00032;
                url3 = url10;
                allEpisodes2 = allEpisodes;
                title2 = title;
                synopsis2 = synopsis;
                itemsMatch2 = itemsMatch;
                i3 = i2;
                releasedYear2 = releasedYear;
                bgImage2 = bgImage;
                genres = genres10;
                pagesFetched = 0;
                url4 = poster;
                status2 = status;
                obj3 = obj11;
                nextCursor2 = nextCursor;
                if (i3 != 0) {
                    break;
                }
                Map<String, String> map14 = map;
                Map<String, String> map15 = mutableMap;
                obj4 = obj3;
                AnizoneProvider anizoneProvider8 = anizoneProvider;
                Iterable $this$distinctBy$iv5 = allEpisodes2;
                set$iv = new HashSet();
                list$iv = new ArrayList();
                while (r21.hasNext()) {
                    genres = genres;
                    Episode it13 = (Episode) e$iv;
                    data = it13.getData();
                    url4 = url4;
                    set$iv2 = set$iv;
                    title2 = title2;
                    if (set$iv2.add(data)) {
                        list$iv.add(e$iv);
                        set$iv = set$iv2;
                    } else {
                        set$iv = set$iv2;
                    }
                }
                List genres11 = genres;
                String poster6 = url4;
                String title7 = title2;
                List finalEpisodes5 = CollectionsKt.reversed(list$iv);
                TvType tvType5 = TvType.Anime;
                String synopsis7 = synopsis2;
                String bgImage7 = bgImage2;
                ShowStatus status8 = status2;
                Integer releasedYear8 = releasedYear2;
                C00042 c00046 = new C00042(poster6, bgImage7, synopsis7, genres11, releasedYear8, status8, finalEpisodes5, null);
                c00033.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00033.L$1 = SpillingKt.nullOutSpilledVariable(r2);
                c00033.L$2 = SpillingKt.nullOutSpilledVariable(doc2);
                c00033.L$3 = SpillingKt.nullOutSpilledVariable(map15);
                c00033.L$4 = SpillingKt.nullOutSpilledVariable(map14);
                c00033.L$5 = SpillingKt.nullOutSpilledVariable(title7);
                c00033.L$6 = SpillingKt.nullOutSpilledVariable(poster6);
                c00033.L$7 = SpillingKt.nullOutSpilledVariable(bgImage7);
                c00033.L$8 = SpillingKt.nullOutSpilledVariable(synopsis7);
                c00033.L$9 = SpillingKt.nullOutSpilledVariable(rowLines2);
                c00033.L$10 = SpillingKt.nullOutSpilledVariable(releasedYear8);
                c00033.L$11 = SpillingKt.nullOutSpilledVariable(status8);
                c00033.L$12 = SpillingKt.nullOutSpilledVariable(genres11);
                c00033.L$13 = SpillingKt.nullOutSpilledVariable(allEpisodes2);
                c00033.L$14 = SpillingKt.nullOutSpilledVariable(itemsMatch2);
                c00033.L$15 = SpillingKt.nullOutSpilledVariable(nextCursor2);
                c00033.L$16 = SpillingKt.nullOutSpilledVariable(finalEpisodes5);
                c00033.I$0 = i3;
                c00033.I$1 = pagesFetched;
                c00033.label = 3;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(anizoneProvider8, title7, url3, tvType5, false, c00046, c00033, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj4) {
                    return obj4;
                }
                return objNewAnimeLoadResponse$default;
            case 2:
                int pagesFetched2 = c00031.I$1;
                int i6 = c00031.I$0;
                MatchResult itemsMatch4 = (MatchResult) c00031.L$14;
                List allEpisodes3 = (List) c00031.L$13;
                genres2 = (List) c00031.L$12;
                status3 = (ShowStatus) c00031.L$11;
                Integer releasedYear9 = (Integer) c00031.L$10;
                List rowLines4 = (List) c00031.L$9;
                synopsis2 = (String) c00031.L$8;
                bgImage2 = (String) c00031.L$7;
                String poster7 = (String) c00031.L$6;
                String title8 = (String) c00031.L$5;
                Map<String, String> map16 = (Map) c00031.L$4;
                Map<String, String> map17 = (Map) c00031.L$3;
                doc3 = (Document) c00031.L$2;
                NiceResponse r3 = (NiceResponse) c00031.L$1;
                String url11 = (String) c00031.L$0;
                ResultKt.throwOnFailure($result3);
                itemsMatch3 = itemsMatch4;
                pagesFetched = pagesFetched2;
                obj5 = coroutine_suspended;
                releasedYear3 = releasedYear9;
                map3 = map16;
                map2 = map17;
                r2 = r3;
                url5 = url11;
                $result2 = $result3;
                str = "";
                url4 = poster7;
                rowLines3 = rowLines4;
                allEpisodes2 = allEpisodes3;
                anizoneProvider2 = this;
                c00033 = c00031;
                title2 = title8;
                continuation3 = continuation;
                JSONObject jsonResponse2 = (JSONObject) $result3;
                Pair<List<Episode>, String> episodesFromJson2 = anizoneProvider2.parseEpisodesFromJson(jsonResponse2);
                List newEps2 = (List) episodesFromJson2.component1();
                cursor = (String) episodesFromJson2.component2();
                continuation2 = continuation3;
                allEpisodes2.addAll(newEps2);
                if (cursor != null) {
                    i5 = 1;
                } else {
                    i5 = 0;
                }
                url3 = url5;
                anizoneProvider = anizoneProvider2;
                mutableMap = map2;
                map = map3;
                obj3 = obj5;
                itemsMatch2 = itemsMatch3;
                rowLines2 = rowLines3;
                $result = $result2;
                doc2 = doc3;
                nextCursor = cursor;
                genres = genres2;
                i3 = i5;
                status2 = status3;
                releasedYear2 = releasedYear3;
                nextCursor2 = nextCursor;
                if (i3 != 0) {
                    break;
                }
                Map<String, String> map18 = map;
                Map<String, String> map19 = mutableMap;
                obj4 = obj3;
                AnizoneProvider anizoneProvider9 = anizoneProvider;
                Iterable $this$distinctBy$iv6 = allEpisodes2;
                set$iv = new HashSet();
                list$iv = new ArrayList();
                while (r21.hasNext()) {
                    genres = genres;
                    Episode it14 = (Episode) e$iv;
                    data = it14.getData();
                    url4 = url4;
                    set$iv2 = set$iv;
                    title2 = title2;
                    if (set$iv2.add(data)) {
                        list$iv.add(e$iv);
                        set$iv = set$iv2;
                    } else {
                        set$iv = set$iv2;
                    }
                }
                List genres12 = genres;
                String poster8 = url4;
                String title9 = title2;
                List finalEpisodes6 = CollectionsKt.reversed(list$iv);
                TvType tvType6 = TvType.Anime;
                String synopsis8 = synopsis2;
                String bgImage8 = bgImage2;
                ShowStatus status9 = status2;
                Integer releasedYear10 = releasedYear2;
                C00042 c00047 = new C00042(poster8, bgImage8, synopsis8, genres12, releasedYear10, status9, finalEpisodes6, null);
                c00033.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00033.L$1 = SpillingKt.nullOutSpilledVariable(r2);
                c00033.L$2 = SpillingKt.nullOutSpilledVariable(doc2);
                c00033.L$3 = SpillingKt.nullOutSpilledVariable(map19);
                c00033.L$4 = SpillingKt.nullOutSpilledVariable(map18);
                c00033.L$5 = SpillingKt.nullOutSpilledVariable(title9);
                c00033.L$6 = SpillingKt.nullOutSpilledVariable(poster8);
                c00033.L$7 = SpillingKt.nullOutSpilledVariable(bgImage8);
                c00033.L$8 = SpillingKt.nullOutSpilledVariable(synopsis8);
                c00033.L$9 = SpillingKt.nullOutSpilledVariable(rowLines2);
                c00033.L$10 = SpillingKt.nullOutSpilledVariable(releasedYear10);
                c00033.L$11 = SpillingKt.nullOutSpilledVariable(status9);
                c00033.L$12 = SpillingKt.nullOutSpilledVariable(genres12);
                c00033.L$13 = SpillingKt.nullOutSpilledVariable(allEpisodes2);
                c00033.L$14 = SpillingKt.nullOutSpilledVariable(itemsMatch2);
                c00033.L$15 = SpillingKt.nullOutSpilledVariable(nextCursor2);
                c00033.L$16 = SpillingKt.nullOutSpilledVariable(finalEpisodes6);
                c00033.I$0 = i3;
                c00033.I$1 = pagesFetched;
                c00033.label = 3;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(anizoneProvider9, title9, url3, tvType6, false, c00047, c00033, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj4) {
                    return obj4;
                }
                return objNewAnimeLoadResponse$default;
            case 3:
                int i7 = c00031.I$1;
                int i8 = c00031.I$0;
                ResultKt.throwOnFailure($result3);
                return $result3;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ycngmn.AnizoneProvider$load$2 */
    /* JADX INFO: compiled from: AnizoneProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.ycngmn.AnizoneProvider$load$2", f = "AnizoneProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00042 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $bgImage;
        final /* synthetic */ List<Episode> $finalEpisodes;
        final /* synthetic */ List<String> $genres;
        final /* synthetic */ String $poster;
        final /* synthetic */ Integer $releasedYear;
        final /* synthetic */ ShowStatus $status;
        final /* synthetic */ String $synopsis;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00042(String str, String str2, String str3, List<String> list, Integer num, ShowStatus showStatus, List<Episode> list2, Continuation<? super C00042> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$bgImage = str2;
            this.$synopsis = str3;
            this.$genres = list;
            this.$releasedYear = num;
            this.$status = showStatus;
            this.$finalEpisodes = list2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = new C00042(this.$poster, this.$bgImage, this.$synopsis, this.$genres, this.$releasedYear, this.$status, this.$finalEpisodes, continuation);
            c00042.L$0 = obj;
            return c00042;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            AnimeLoadResponse $this$newAnimeLoadResponse = (AnimeLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newAnimeLoadResponse.setPosterUrl(this.$poster);
                    $this$newAnimeLoadResponse.setBackgroundPosterUrl(this.$bgImage);
                    $this$newAnimeLoadResponse.setPlot(this.$synopsis);
                    $this$newAnimeLoadResponse.setTags(this.$genres);
                    $this$newAnimeLoadResponse.setYear(this.$releasedYear);
                    $this$newAnimeLoadResponse.setShowStatus(this.$status);
                    MainAPIKt.addEpisodes($this$newAnimeLoadResponse, DubStatus.Subbed, this.$finalEpisodes);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0164  */
    /* JADX WARN: Code duplicated, block: B:45:0x0203  */
    /* JADX WARN: Code duplicated, block: B:46:0x0206  */
    /* JADX WARN: Code duplicated, block: B:48:0x020a A[Catch: Exception -> 0x02f0, TryCatch #0 {Exception -> 0x02f0, blocks: (B:43:0x01eb, B:48:0x020a, B:53:0x021c), top: B:90:0x01eb }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0214  */
    /* JADX WARN: Code duplicated, block: B:51:0x0217  */
    /* JADX WARN: Code duplicated, block: B:53:0x021c A[Catch: Exception -> 0x02f0, TRY_LEAVE, TryCatch #0 {Exception -> 0x02f0, blocks: (B:43:0x01eb, B:48:0x020a, B:53:0x021c), top: B:90:0x01eb }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0287 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:58:0x0288  */
    /* JADX WARN: Code duplicated, block: B:65:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:94:0x01e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0288 -> B:98:0x02a2). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r38, boolean r39, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r40, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r41, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r42) {
        /*
            Method dump skipped, instruction units count: 1048
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ycngmn.AnizoneProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
