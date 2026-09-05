package com.phisher98;

import android.content.Context;
import android.util.Log;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.CloudStreamApp;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.DataStore;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: StremioC.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StremioX/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0010#\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 E2\u00020\u0001:\u0011EFGHIJKLMNOPQRSTUB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010!\u001a\u00020\u0003H\u0002J\b\u0010\"\u001a\u00020\u0003H\u0002J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0002J\u0010\u0010%\u001a\u0004\u0018\u00010\u0017H\u0082@¢\u0006\u0002\u0010&J\u001e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0096@¢\u0006\u0002\u0010-J\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010/\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u00100J\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010/\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u00100J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u00100JF\u00105\u001a\u00020\u00132\u0006\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00132\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;092\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020;09H\u0096@¢\u0006\u0002\u0010>JJ\u0010?\u001a\u00020;2\b\u0010@\u001a\u0004\u0018\u00010\u00032\b\u0010A\u001a\u0004\u0018\u00010\u00032\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020;092\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020;09H\u0082@¢\u0006\u0002\u0010BJ\u0012\u0010C\u001a\u00020\u00132\b\u00104\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010D\u001a\u00020\u00132\b\u00104\u001a\u0004\u0018\u00010\u0003H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/phisher98/StremioC;", "Lcom/lagradost/cloudstream3/MainAPI;", "mainUrl", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "getName", "setName", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "hasMainPage", "", "getHasMainPage", "()Z", "cachedManifest", "Lcom/phisher98/StremioC$Manifest;", "lastManifestUrl", "lastCacheTime", "", "catalogSentIds", "", "", "pageContentCache", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "baseUrl", "querySuffix", "buildUrl", "path", "getManifest", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchTMDb", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeStremioX", "type", "id", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isImdborTmdb", "isImdb", "Companion", "LoadData", "CustomSite", "Manifest", "Extra", "Catalog", "CatalogResponse", "Trailer", "TrailerStream", "Link", "CatalogEntry", "Video", "StreamsResponse", "Subtitle", "ProxyHeaders", "BehaviorHints", "Stream", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStremioC.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StremioC.kt\ncom/phisher98/StremioC\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 7 CloudStreamApp.kt\ncom/lagradost/cloudstream3/CloudStreamApp$Companion\n+ 8 DataStore.kt\ncom/lagradost/cloudstream3/utils/DataStore\n*L\n1#1,1058:1\n1#2:1059\n1#2:1109\n1#2:1113\n1#2:1132\n1#2:1163\n1#2:1194\n73#3,5:1060\n73#3,5:1082\n73#3,5:1150\n73#3,5:1157\n73#3,5:1181\n777#4:1065\n873#4,2:1066\n777#4:1068\n873#4,2:1069\n777#4:1071\n873#4,2:1072\n1849#4,8:1074\n777#4:1087\n873#4,2:1088\n1849#4,8:1090\n1795#4,10:1098\n2068#4:1108\n2069#4:1110\n1805#4:1111\n296#4,2:1155\n2068#4,2:1186\n777#4:1214\n873#4,2:1215\n63#5:1112\n64#5,15:1114\n63#5:1131\n64#5,15:1133\n63#5:1162\n64#5,15:1164\n63#5:1193\n64#5,15:1195\n50#6:1129\n43#6:1130\n50#6:1148\n43#6:1149\n50#6:1179\n43#6:1180\n50#6:1210\n43#6:1211\n144#7:1188\n231#8:1189\n222#8,3:1190\n225#8,2:1212\n*S KotlinDebug\n*F\n+ 1 StremioC.kt\ncom/phisher98/StremioC\n*L\n172#1:1109\n204#1:1113\n208#1:1132\n239#1:1163\n292#1:1194\n98#1:1060,5\n171#1:1082,5\n213#1:1150,5\n223#1:1157,5\n244#1:1181,5\n125#1:1065\n125#1:1066,2\n149#1:1068\n149#1:1069,2\n160#1:1071\n160#1:1072,2\n161#1:1074,8\n172#1:1087\n172#1:1088,2\n172#1:1090,8\n172#1:1098,10\n172#1:1108\n172#1:1110\n172#1:1111\n217#1:1155,2\n248#1:1186,2\n294#1:1214\n294#1:1215,2\n204#1:1112\n204#1:1114,15\n208#1:1131\n208#1:1133,15\n239#1:1162\n239#1:1164,15\n292#1:1193\n292#1:1195,15\n204#1:1129\n204#1:1130\n208#1:1148\n208#1:1149\n239#1:1179\n239#1:1180\n292#1:1210\n292#1:1211\n292#1:1188\n292#1:1189\n292#1:1190,3\n292#1:1212,2\n*E\n"})
public final class StremioC extends MainAPI {

    @NotNull
    private static final String TRACKER_LIST_URL = "https://raw.githubusercontent.com/ngosang/trackerslist/master/trackers_best.txt";

    @NotNull
    private static final String apiKey = "98ae14df2b8d8f8f8136499daf79f0e0";

    @NotNull
    private static final String cinemeta = "https://aiometadata.elfhosted.com/stremio/b7cb164b-074b-41d5-b458-b3a834e197bb";

    @NotNull
    private static final String cinemetav3 = "https://v3-cinemeta.strem.io";

    @NotNull
    private static final String tmdbAPI = "https://api.themoviedb.org/3";

    @Nullable
    private Manifest cachedManifest;
    private long lastCacheTime;

    @NotNull
    private String mainUrl;

    @NotNull
    private String name;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final List<String> TRACKER_LIST_URLS = CollectionsKt.listOf(new String[]{"https://raw.githubusercontent.com/ngosang/trackerslist/refs/heads/master/trackers_best.txt", "https://raw.githubusercontent.com/ngosang/trackerslist/refs/heads/master/trackers_best_ip.txt"});

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Others);
    private final boolean hasMainPage = true;

    @NotNull
    private String lastManifestUrl = "";

    @NotNull
    private final Map<String, Set<String>> catalogSentIds = new LinkedHashMap();

    @NotNull
    private final Map<String, List<SearchResponse>> pageContentCache = new LinkedHashMap();

    /* JADX INFO: renamed from: com.phisher98.StremioC$getMainPage$1 */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioC", f = "StremioC.kt", i = {0, 0, 0, 1, 1, 1, 1, 1}, l = {124, 127}, m = "getMainPage", n = {"request", "page", "skip", "request", "manifest", "targetCatalogs", "page", "skip"}, nl = {125, 149}, s = {"L$0", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
        int I$1;
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
            return StremioC.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StremioC$getManifest$1 */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioC", f = "StremioC.kt", i = {0, 0, 0, 0}, l = {98}, m = "getManifest", n = {"currentUrl", "now", "cacheAge", "isExpired"}, nl = {1059}, s = {"L$0", "J$0", "J$1", "I$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        int I$0;
        long J$0;
        long J$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StremioC.this.getManifest((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StremioC$invokeStremioX$1 */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioC", f = "StremioC.kt", i = {0, 0, 0, 0, 0}, l = {294}, m = "invokeStremioX", n = {"type", "id", "subtitleCallback", "callback", "sites"}, nl = {303}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StremioC.this.invokeStremioX(null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StremioC$load$1 */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioC", f = "StremioC.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {206, 212, 220, 230}, m = "load", n = {"url", "url", "res", "normalizedId", "encodedId", "url", "res", "normalizedId", "encodedId", "response", "$this$load_u24lambda_u241", "url", "res", "normalizedId", "encodedId", "response", "entry"}, nl = {207, 213, 223, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StremioC.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StremioC$loadLinks$1 */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioC", f = "StremioC.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3}, l = {241, 249, 252, 276}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "loadData", "normalizedId", "isCasting", "data", "subtitleCallback", "callback", "loadData", "normalizedId", "request", "res", "$this$forEach$iv", "element$iv", "stream", "isCasting", "data", "subtitleCallback", "callback", "loadData", "normalizedId", "request", "res", "isCasting", "data", "subtitleCallback", "callback", "loadData", "normalizedId", "request", "res", "isCasting"}, nl = {243, 250, 276, 283}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$9", "L$10", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0"}, v = 2)
    static final class C00061 extends ContinuationImpl {
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
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StremioC.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StremioC$search$1 */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioC", f = "StremioC.kt", i = {0, 1, 1, 1, 2, 2, 2, 2}, l = {159, 161, 165}, m = "search", n = {"query", "query", "manifest", "supportedCatalogs", "query", "manifest", "supportedCatalogs", "addonResults"}, nl = {160, 1062, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00121 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00121(Continuation<? super C00121> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StremioC.this.search(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.StremioC$searchTMDb$1 */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioC", f = "StremioC.kt", i = {0, 0, 0}, l = {171}, m = "searchTMDb", n = {"query", "encoded", "url"}, nl = {1059}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C00131 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00131(Continuation<? super C00131> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StremioC.this.searchTMDb(null, (Continuation) this);
        }
    }

    public StremioC(@NotNull String mainUrl, @NotNull String name) {
        this.mainUrl = mainUrl;
        this.name = name;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setMainUrl(@NotNull String str) {
        this.mainUrl = str;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/phisher98/StremioC$Companion;", "", "<init>", "()V", "cinemeta", "", "cinemetav3", "TRACKER_LIST_URLS", "", "getTRACKER_LIST_URLS", "()Ljava/util/List;", "TRACKER_LIST_URL", "tmdbAPI", "apiKey", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final List<String> getTRACKER_LIST_URLS() {
            return StremioC.TRACKER_LIST_URLS;
        }
    }

    private final String baseUrl() {
        return StringsKt.trimEnd(StringsKt.substringBefore$default(getMainUrl(), "?", (String) null, 2, (Object) null), new char[]{'/'});
    }

    private final String querySuffix() {
        String it;
        String it2 = StringsKt.substringAfter(getMainUrl(), "?", "");
        if (!(it2.length() > 0)) {
            it2 = null;
        }
        return (it2 == null || (it = new StringBuilder().append('?').append(it2).toString()) == null) ? "" : it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildUrl(String path) {
        return baseUrl() + path + querySuffix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object getManifest(Continuation<? super Manifest> continuation) {
        C00021 c00021;
        String currentUrl;
        long now;
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
        C00021 c00022 = c00021;
        Object $result = c00022.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Object safe = null;
        switch (c00022.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String currentUrl2 = buildUrl("/manifest.json");
                long now2 = System.currentTimeMillis();
                long cacheAge = now2 - this.lastCacheTime;
                int i = cacheAge > 86400000 ? 1 : 0;
                if (this.cachedManifest != null && Intrinsics.areEqual(this.lastManifestUrl, currentUrl2) && i == 0) {
                    Manifest manifest = this.cachedManifest;
                    List<Catalog> catalogs = manifest != null ? manifest.getCatalogs() : null;
                    if (!(catalogs == null || catalogs.isEmpty())) {
                        return this.cachedManifest;
                    }
                }
                Requests app = MainActivityKt.getApp();
                c00022.L$0 = currentUrl2;
                c00022.J$0 = now2;
                c00022.J$1 = cacheAge;
                c00022.I$0 = i;
                c00022.label = 1;
                Object obj = Requests.get$default(app, currentUrl2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 120L, (Interceptor) null, false, (ResponseParser) null, c00022, 3838, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                currentUrl = currentUrl2;
                now = now2;
                $result = obj;
                break;
                break;
            case 1:
                int i2 = c00022.I$0;
                long j = c00022.J$1;
                now = c00022.J$0;
                currentUrl = (String) c00022.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) $result;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Manifest.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
        }
        Manifest res = (Manifest) safe;
        if (res != null && !res.getCatalogs().isEmpty()) {
            this.cachedManifest = res;
            this.lastManifestUrl = currentUrl;
            this.lastCacheTime = now;
            this.pageContentCache.clear();
            this.catalogSentIds.clear();
        } else {
            Boxing.boxInt(Log.d("Error:", "Null"));
        }
        return res == null ? this.cachedManifest : res;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:41:0x0103 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:0x0104  */
    /* JADX WARN: Code duplicated, block: B:46:0x0120  */
    /* JADX WARN: Code duplicated, block: B:54:0x0136 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x011a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00011 c00011;
        int skip;
        Object obj;
        MainPageRequest request2;
        Manifest manifest;
        boolean z;
        List targetCatalogs;
        Object objAmap;
        Iterable catalogs;
        Collection destination$iv$iv;
        HomePageList it;
        int page2 = page;
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
        Object $result = c00011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00011.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (getMainUrl().length() == 0) {
                    throw new IllegalArgumentException("Configure in Extension Settings\n");
                }
                setMainUrl(UtilsKt.fixSourceUrl(getMainUrl()));
                if (page2 <= 1) {
                    this.catalogSentIds.clear();
                }
                skip = (page2 - 1) * 100;
                c00011.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00011.I$0 = page2;
                c00011.I$1 = skip;
                c00011.label = 1;
                Object manifest2 = getManifest(c00011);
                if (manifest2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = manifest2;
                request2 = request;
                manifest = (Manifest) obj;
                if (manifest != null || (catalogs = manifest.getCatalogs()) == null) {
                    z = true;
                    targetCatalogs = CollectionsKt.emptyList();
                } else {
                    Iterable $this$filter$iv = catalogs;
                    Collection destination$iv$iv2 = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        Catalog it2 = (Catalog) element$iv$iv;
                        if (!it2.isSearchRequired()) {
                            destination$iv$iv2.add(element$iv$iv);
                        }
                    }
                    z = true;
                    targetCatalogs = (List) destination$iv$iv2;
                }
                StremioC$getMainPage$lists$1 stremioC$getMainPage$lists$1 = new StremioC$getMainPage$lists$1(skip, this, null);
                c00011.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00011.L$1 = SpillingKt.nullOutSpilledVariable(manifest);
                c00011.L$2 = SpillingKt.nullOutSpilledVariable(targetCatalogs);
                c00011.I$0 = page2;
                c00011.I$1 = skip;
                c00011.label = 2;
                objAmap = ParCollectionsKt.amap(targetCatalogs, stremioC$getMainPage$lists$1, c00011);
                if (objAmap == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Iterable $this$filter$iv2 = (Iterable) objAmap;
                destination$iv$iv = new ArrayList();
                for (Object element$iv$iv2 : $this$filter$iv2) {
                    it = (HomePageList) element$iv$iv2;
                    if (!it.getList().isEmpty()) {
                        destination$iv$iv.add(element$iv$iv2);
                    }
                }
                List lists = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(lists, Boxing.boxBoolean(z));
            case 1:
                skip = c00011.I$1;
                page2 = c00011.I$0;
                request2 = (MainPageRequest) c00011.L$0;
                ResultKt.throwOnFailure($result);
                obj = $result;
                manifest = (Manifest) obj;
                if (manifest != null) {
                    z = true;
                    targetCatalogs = CollectionsKt.emptyList();
                } else {
                    z = true;
                    targetCatalogs = CollectionsKt.emptyList();
                }
                StremioC$getMainPage$lists$1 stremioC$getMainPage$lists$2 = new StremioC$getMainPage$lists$1(skip, this, null);
                c00011.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00011.L$1 = SpillingKt.nullOutSpilledVariable(manifest);
                c00011.L$2 = SpillingKt.nullOutSpilledVariable(targetCatalogs);
                c00011.I$0 = page2;
                c00011.I$1 = skip;
                c00011.label = 2;
                objAmap = ParCollectionsKt.amap(targetCatalogs, stremioC$getMainPage$lists$2, c00011);
                if (objAmap == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Iterable $this$filter$iv3 = (Iterable) objAmap;
                destination$iv$iv = new ArrayList();
                while (r14.hasNext()) {
                    it = (HomePageList) element$iv$iv2;
                    if (!it.getList().isEmpty()) {
                        destination$iv$iv.add(element$iv$iv2);
                    }
                }
                List lists2 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(lists2, Boxing.boxBoolean(z));
            case 2:
                int i = c00011.I$1;
                int i2 = c00011.I$0;
                ResultKt.throwOnFailure($result);
                objAmap = $result;
                z = true;
                Iterable $this$filter$iv4 = (Iterable) objAmap;
                destination$iv$iv = new ArrayList();
                while (r14.hasNext()) {
                    it = (HomePageList) element$iv$iv2;
                    if (!it.getList().isEmpty()) {
                        destination$iv$iv.add(element$iv$iv2);
                    }
                }
                List lists3 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(lists3, Boxing.boxBoolean(z));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:32:0x00d5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:37:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:42:0x0119 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x011a  */
    /* JADX WARN: Code duplicated, block: B:45:0x013b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x013c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0108 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x00ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws UnsupportedEncodingException {
        C00121 c00121;
        Object manifest;
        Manifest manifest2;
        List supportedCatalogs;
        Object objAmap;
        Manifest manifest3;
        List supportedCatalogs2;
        Iterable catalogs;
        HashSet set$iv;
        ArrayList list$iv;
        ArrayList addonResults;
        Object objSearchTMDb;
        SearchResponse it;
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
                setMainUrl(UtilsKt.fixSourceUrl(getMainUrl()));
                c00121.L$0 = query;
                c00121.label = 1;
                manifest = getManifest(c00121);
                if (manifest == coroutine_suspended) {
                    return coroutine_suspended;
                }
                manifest2 = (Manifest) manifest;
                if (manifest2 != null || (catalogs = manifest2.getCatalogs()) == null) {
                    supportedCatalogs = CollectionsKt.emptyList();
                } else {
                    Iterable $this$filter$iv = catalogs;
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        Catalog it2 = (Catalog) element$iv$iv;
                        if (it2.supportsSearch()) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                    }
                    supportedCatalogs = (List) destination$iv$iv;
                }
                StremioC$search$addonResults$1 stremioC$search$addonResults$1 = new StremioC$search$addonResults$1(query, this, null);
                c00121.L$0 = query;
                c00121.L$1 = SpillingKt.nullOutSpilledVariable(manifest2);
                c00121.L$2 = SpillingKt.nullOutSpilledVariable(supportedCatalogs);
                c00121.label = 2;
                objAmap = ParCollectionsKt.amap(supportedCatalogs, stremioC$search$addonResults$1, c00121);
                if (objAmap == coroutine_suspended) {
                    return coroutine_suspended;
                }
                manifest3 = manifest2;
                supportedCatalogs2 = supportedCatalogs;
                Iterable $this$distinctBy$iv = CollectionsKt.flatten((Iterable) objAmap);
                set$iv = new HashSet();
                list$iv = new ArrayList();
                for (Object e$iv : $this$distinctBy$iv) {
                    it = (SearchResponse) e$iv;
                    if (set$iv.add(it.getUrl())) {
                        list$iv.add(e$iv);
                    }
                }
                addonResults = list$iv;
                if (!addonResults.isEmpty()) {
                    return addonResults;
                }
                c00121.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00121.L$1 = SpillingKt.nullOutSpilledVariable(manifest3);
                c00121.L$2 = SpillingKt.nullOutSpilledVariable(supportedCatalogs2);
                c00121.L$3 = SpillingKt.nullOutSpilledVariable(addonResults);
                c00121.label = 3;
                objSearchTMDb = searchTMDb(query, c00121);
                if (objSearchTMDb == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objSearchTMDb;
            case 1:
                query = (String) c00121.L$0;
                ResultKt.throwOnFailure($result);
                manifest = $result;
                manifest2 = (Manifest) manifest;
                if (manifest2 != null) {
                    supportedCatalogs = CollectionsKt.emptyList();
                } else {
                    supportedCatalogs = CollectionsKt.emptyList();
                }
                StremioC$search$addonResults$1 stremioC$search$addonResults$2 = new StremioC$search$addonResults$1(query, this, null);
                c00121.L$0 = query;
                c00121.L$1 = SpillingKt.nullOutSpilledVariable(manifest2);
                c00121.L$2 = SpillingKt.nullOutSpilledVariable(supportedCatalogs);
                c00121.label = 2;
                objAmap = ParCollectionsKt.amap(supportedCatalogs, stremioC$search$addonResults$2, c00121);
                if (objAmap == coroutine_suspended) {
                    return coroutine_suspended;
                }
                manifest3 = manifest2;
                supportedCatalogs2 = supportedCatalogs;
                Iterable $this$distinctBy$iv2 = CollectionsKt.flatten((Iterable) objAmap);
                set$iv = new HashSet();
                list$iv = new ArrayList();
                while (r9.hasNext()) {
                    it = (SearchResponse) e$iv;
                    if (set$iv.add(it.getUrl())) {
                        list$iv.add(e$iv);
                    }
                }
                addonResults = list$iv;
                if (!addonResults.isEmpty()) {
                    return addonResults;
                }
                c00121.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00121.L$1 = SpillingKt.nullOutSpilledVariable(manifest3);
                c00121.L$2 = SpillingKt.nullOutSpilledVariable(supportedCatalogs2);
                c00121.L$3 = SpillingKt.nullOutSpilledVariable(addonResults);
                c00121.label = 3;
                objSearchTMDb = searchTMDb(query, c00121);
                if (objSearchTMDb == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objSearchTMDb;
            case 2:
                supportedCatalogs2 = (List) c00121.L$2;
                Manifest manifest4 = (Manifest) c00121.L$1;
                query = (String) c00121.L$0;
                ResultKt.throwOnFailure($result);
                manifest3 = manifest4;
                objAmap = $result;
                Iterable $this$distinctBy$iv3 = CollectionsKt.flatten((Iterable) objAmap);
                set$iv = new HashSet();
                list$iv = new ArrayList();
                while (r9.hasNext()) {
                    it = (SearchResponse) e$iv;
                    if (set$iv.add(it.getUrl())) {
                        list$iv.add(e$iv);
                    }
                }
                addonResults = list$iv;
                if (!addonResults.isEmpty()) {
                    return addonResults;
                }
                c00121.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00121.L$1 = SpillingKt.nullOutSpilledVariable(manifest3);
                c00121.L$2 = SpillingKt.nullOutSpilledVariable(supportedCatalogs2);
                c00121.L$3 = SpillingKt.nullOutSpilledVariable(addonResults);
                c00121.label = 3;
                objSearchTMDb = searchTMDb(query, c00121);
                if (objSearchTMDb == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objSearchTMDb;
            case 3:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object searchTMDb(String query, Continuation<? super List<? extends SearchResponse>> continuation) throws UnsupportedEncodingException {
        C00131 c00131;
        String url;
        Object obj;
        String encoded;
        Object safe;
        MovieSearchResponse movieSearchResponseNewMovieSearchResponse$default;
        List results;
        if (continuation instanceof C00131) {
            c00131 = (C00131) continuation;
            if ((c00131.label & Integer.MIN_VALUE) != 0) {
                c00131.label -= Integer.MIN_VALUE;
            } else {
                c00131 = new C00131(continuation);
            }
        } else {
            c00131 = new C00131(continuation);
        }
        C00131 c00132 = c00131;
        Object $result = c00132.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00132.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String encoded2 = URLEncoder.encode(query, "UTF-8");
                String url2 = "https://api.themoviedb.org/3/search/multi?api_key=98ae14df2b8d8f8f8136499daf79f0e0&language=en-US&query=" + encoded2 + "&page=1&include_adult=false";
                Requests app = MainActivityKt.getApp();
                c00132.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00132.L$1 = SpillingKt.nullOutSpilledVariable(encoded2);
                c00132.L$2 = SpillingKt.nullOutSpilledVariable(url2);
                c00132.label = 1;
                url = url2;
                obj = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 120L, (Interceptor) null, false, (ResponseParser) null, c00132, 3838, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                encoded = encoded2;
                break;
                break;
            case 1:
                String url3 = (String) c00132.L$2;
                encoded = (String) c00132.L$1;
                ResultKt.throwOnFailure($result);
                obj = $result;
                url = url3;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse this_$iv = (NiceResponse) obj;
        try {
            ResponseParser parser = this_$iv.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Results.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        Results results2 = (Results) safe;
        List results3 = (results2 == null || (results = results2.getResults()) == null) ? CollectionsKt.emptyList() : results;
        List $this$filter$iv = results3;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            Media it = (Media) element$iv$iv;
            if (Intrinsics.areEqual(it.getMediaType(), "movie") || Intrinsics.areEqual(it.getMediaType(), "tv")) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$distinctBy$iv = (List) destination$iv$iv;
        HashSet set$iv = new HashSet();
        ArrayList list$iv = new ArrayList();
        for (Object e$iv2 : $this$distinctBy$iv) {
            Media it2 = (Media) e$iv2;
            results3 = results3;
            if (set$iv.add(it2.getMediaType() + ':' + it2.getId())) {
                list$iv.add(e$iv2);
            }
        }
        ArrayList $this$mapNotNull$iv = list$iv;
        int $i$f$mapNotNull = 0;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Media media = (Media) element$iv$iv$iv;
            Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
            String stremioType = Intrinsics.areEqual(media.getMediaType(), "tv") ? "series" : "movie";
            String title = media.getTitle();
            if (title == null && (title = media.getName()) == null && (title = media.getOriginalTitle()) == null) {
                $i$f$mapNotNull = $i$f$mapNotNull;
                movieSearchResponseNewMovieSearchResponse$default = null;
            } else {
                String title2 = title;
                String it3 = media.getPosterPath();
                String poster = it3 != null ? "https://image.tmdb.org/t/p/w500" + it3 : null;
                CatalogEntry entry = new CatalogEntry(title2, "tmdb:" + media.getId(), poster, poster, null, null, stremioType, null, null, null, null, null, null, null, null, 32256, null);
                final String poster2 = poster;
                movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(this, title2, AppUtils.INSTANCE.toJson(entry), Intrinsics.areEqual(stremioType, "series") ? TvType.TvSeries : TvType.Movie, false, new Function1() { // from class: com.phisher98.StremioC$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        return StremioC.searchTMDb$lambda$2$1(poster2, (MovieSearchResponse) obj2);
                    }
                }, 8, (Object) null);
            }
            if (movieSearchResponseNewMovieSearchResponse$default != null) {
                destination$iv$iv2.add(movieSearchResponseNewMovieSearchResponse$default);
            }
            $this$mapNotNull$iv = $this$mapNotNull$iv2;
            url = url;
            encoded = encoded;
            $i$f$mapNotNull = $i$f$mapNotNull;
        }
        return (List) destination$iv$iv2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchTMDb$lambda$2$1(String $poster, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($poster);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x033a  */
    /* JADX WARN: Code duplicated, block: B:102:0x033e  */
    /* JADX WARN: Code duplicated, block: B:104:0x0344  */
    /* JADX WARN: Code duplicated, block: B:105:0x034c  */
    /* JADX WARN: Code duplicated, block: B:107:0x0350  */
    /* JADX WARN: Code duplicated, block: B:109:0x03d9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:110:0x03da  */
    /* JADX WARN: Code duplicated, block: B:118:0x040b  */
    /* JADX WARN: Code duplicated, block: B:122:0x0414 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:123:0x0416  */
    /* JADX WARN: Code duplicated, block: B:126:0x0423  */
    /* JADX WARN: Code duplicated, block: B:130:0x042e  */
    /* JADX WARN: Code duplicated, block: B:133:0x043d  */
    /* JADX WARN: Code duplicated, block: B:137:0x047c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:138:0x047d A[PHI: r4
      0x047d: PHI (r4v34 '$result' java.lang.Object) = (r4v30 '$result' java.lang.Object), (r4v0 '$result' java.lang.Object) binds: [B:136:0x047a, B:12:0x0038] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Code duplicated, block: B:139:0x047e  */
    /* JADX WARN: Code duplicated, block: B:141:0x01e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:0x021a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:160:0x0335 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:66:0x0213  */
    /* JADX WARN: Code duplicated, block: B:75:0x022f  */
    /* JADX WARN: Code duplicated, block: B:79:0x02d7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:88:0x0304  */
    /* JADX WARN: Code duplicated, block: B:90:0x030b  */
    /* JADX WARN: Code duplicated, block: B:92:0x0311  */
    /* JADX WARN: Code duplicated, block: B:95:0x031e  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) throws UnsupportedEncodingException {
        C00051 c00051;
        Object obj;
        int i;
        String str;
        Object obj2;
        String $result;
        Object obj3;
        Object objDecodeFromString;
        CatalogEntry catalogEntry;
        CatalogEntry res;
        String url2;
        String encodedId;
        CatalogEntry res2;
        String normalizedId;
        String normalizedId2;
        CatalogEntry catalogEntry2;
        String encodedId2;
        CatalogEntry res3;
        String encodedId3;
        String metaJson;
        Object obj4;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString2;
        Object safe;
        CatalogResponse catalogResponse;
        CatalogResponse response;
        CatalogEntry meta;
        String encodedId4;
        String normalizedId3;
        String url3;
        CatalogEntry res4;
        Iterable metas;
        CatalogEntry catalogEntry3;
        List<CatalogEntry> metas2;
        String encodedId5;
        CatalogEntry res5;
        CatalogResponse response2;
        String encodedId6;
        String normalizedId4;
        String url4;
        CatalogEntry res6;
        Iterator it;
        Object element$iv;
        CatalogEntry it2;
        Object safe2;
        CatalogResponse fallback;
        CatalogEntry meta2;
        List<CatalogEntry> metas3;
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
        C00051 c00052 = c00051;
        Object $result2 = c00052.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00052.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                if (!StringsKt.startsWith$default(url, "{", false, 2, (Object) null)) {
                    Requests app = MainActivityKt.getApp();
                    c00052.L$0 = SpillingKt.nullOutSpilledVariable(url);
                    c00052.label = 1;
                    obj = coroutine_suspended;
                    i = 2;
                    str = ".json";
                    obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00052, 4094, (Object) null);
                    if (obj2 == obj) {
                        c00052 = c00052;
                        return obj;
                    }
                    c00052 = c00052;
                    $result = url;
                    String json = ((NiceResponse) obj2).getText();
                    metaJson = new JSONObject(json).getJSONObject("meta").toString();
                    AppUtils appUtils = AppUtils.INSTANCE;
                    try {
                        Result.Companion companion = Result.Companion;
                        KType kTypeTypeOf = Reflection.typeOf(CatalogEntry.class);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (Result.exceptionOrNull-impl(obj4) != null) {
                        catalogEntry = null;
                    } else {
                        try {
                            Result.Companion companion3 = Result.Companion;
                            catalogEntry = null;
                            try {
                                obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(CatalogEntry.class), (List) null, i, (Object) null));
                            } catch (Throwable th2) {
                                th = th2;
                                Result.Companion companion4 = Result.Companion;
                                obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            catalogEntry = null;
                        }
                    }
                    if (Result.isFailure-impl(obj4)) {
                        obj4 = catalogEntry;
                    }
                    deserializationStrategy = (KSerializer) obj4;
                    if (deserializationStrategy != null) {
                        try {
                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy, metaJson);
                        } catch (SerializationException e) {
                            ArchComponentExtKt.logError(e);
                            ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv.readValue(metaJson, new TypeReference<CatalogEntry>() { // from class: com.phisher98.StremioC$load$$inlined$parseJson$2
                            });
                        } catch (Throwable th4) {
                            ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv2.readValue(metaJson, new TypeReference<CatalogEntry>() { // from class: com.phisher98.StremioC$load$$inlined$parseJson$2
                            });
                        }
                    } else {
                        ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                        objDecodeFromString2 = $this$readValue$iv$iv3.readValue(metaJson, new TypeReference<CatalogEntry>() { // from class: com.phisher98.StremioC$load$$inlined$parseJson$2
                        });
                    }
                    String str2 = $result;
                    res = (CatalogEntry) objDecodeFromString2;
                    url2 = str2;
                    break;
                } else {
                    AppUtils appUtils2 = AppUtils.INSTANCE;
                    try {
                        Result.Companion companion5 = Result.Companion;
                        KType kTypeTypeOf2 = Reflection.typeOf(CatalogEntry.class);
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                    } catch (Throwable th5) {
                        Result.Companion companion6 = Result.Companion;
                        obj3 = Result.constructor-impl(ResultKt.createFailure(th5));
                    }
                    if (Result.exceptionOrNull-impl(obj3) != null) {
                        try {
                            Result.Companion companion7 = Result.Companion;
                            obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(CatalogEntry.class), (List) null, 2, (Object) null));
                        } catch (Throwable th6) {
                            Result.Companion companion8 = Result.Companion;
                            obj3 = Result.constructor-impl(ResultKt.createFailure(th6));
                        }
                    }
                    if (Result.isFailure-impl(obj3)) {
                        obj3 = null;
                    }
                    DeserializationStrategy deserializationStrategy2 = (KSerializer) obj3;
                    if (deserializationStrategy2 != null) {
                        try {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, url);
                        } catch (SerializationException e2) {
                            ArchComponentExtKt.logError(e2);
                            ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv4.readValue(url, new TypeReference<CatalogEntry>() { // from class: com.phisher98.StremioC$load$$inlined$parseJson$1
                            });
                        } catch (Throwable th7) {
                            ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv5.readValue(url, new TypeReference<CatalogEntry>() { // from class: com.phisher98.StremioC$load$$inlined$parseJson$1
                            });
                        }
                    } else {
                        ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv6.readValue(url, new TypeReference<CatalogEntry>() { // from class: com.phisher98.StremioC$load$$inlined$parseJson$1
                        });
                    }
                    obj = coroutine_suspended;
                    str = ".json";
                    catalogEntry = null;
                    i = 2;
                    res = (CatalogEntry) objDecodeFromString;
                    url2 = url;
                    break;
                }
                String normalizedId5 = UtilsKt.normalizeId(res.getId());
                encodedId = URLEncoder.encode(normalizedId5, "UTF-8");
                Requests app2 = MainActivityKt.getApp();
                String str3 = str;
                String strBuildUrl = buildUrl("/meta/" + res.getType() + '/' + encodedId + str3);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00052.L$1 = res;
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(normalizedId5);
                c00052.L$3 = encodedId;
                c00052.label = i;
                C00051 c00053 = c00052;
                res2 = res;
                normalizedId = normalizedId5;
                normalizedId2 = str3;
                catalogEntry2 = catalogEntry;
                $result2 = Requests.get$default(app2, strBuildUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00053, 4094, (Object) null);
                c00052 = c00053;
                if ($result2 == obj) {
                    return obj;
                }
                encodedId2 = encodedId;
                res3 = res2;
                encodedId3 = url2;
                NiceResponse this_$iv = (NiceResponse) $result2;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(CatalogResponse.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = catalogEntry2;
                }
                catalogResponse = (CatalogResponse) safe;
                if (catalogResponse == null) {
                    throw new RuntimeException("Failed to load meta");
                }
                response = catalogResponse;
                meta = response.getMeta();
                if (meta == null) {
                    metas = response.getMetas();
                    if (metas != null) {
                        Iterable $this$firstOrNull$iv = metas;
                        it = $this$firstOrNull$iv.iterator();
                        do {
                            if (it.hasNext()) {
                                element$iv = it.next();
                                it2 = (CatalogEntry) element$iv;
                            } else {
                                element$iv = catalogEntry2;
                            }
                            catalogEntry3 = (CatalogEntry) element$iv;
                        } while (!Intrinsics.areEqual(it2.getId(), res3.getId()));
                        catalogEntry3 = (CatalogEntry) element$iv;
                    } else {
                        catalogEntry3 = catalogEntry2;
                    }
                    if (catalogEntry3 == null) {
                        metas2 = response.getMetas();
                        if (metas2 != null) {
                            catalogEntry3 = (CatalogEntry) CollectionsKt.firstOrNull(metas2);
                        } else {
                            catalogEntry3 = catalogEntry2;
                        }
                        if (catalogEntry3 == null) {
                            StremioC $this$load_u24lambda_u241 = this;
                            Requests app3 = MainActivityKt.getApp();
                            String encodedId7 = "https://aiometadata.elfhosted.com/stremio/b7cb164b-074b-41d5-b458-b3a834e197bb/meta/" + res3.getType() + '/' + encodedId2 + normalizedId2;
                            c00052.L$0 = SpillingKt.nullOutSpilledVariable(encodedId3);
                            c00052.L$1 = res3;
                            c00052.L$2 = SpillingKt.nullOutSpilledVariable(normalizedId);
                            c00052.L$3 = SpillingKt.nullOutSpilledVariable(encodedId2);
                            c00052.L$4 = SpillingKt.nullOutSpilledVariable(response);
                            c00052.L$5 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u241);
                            c00052.label = 3;
                            encodedId5 = encodedId2;
                            res5 = res3;
                            C00051 c00054 = c00052;
                            $result2 = Requests.get$default(app3, encodedId7, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 120L, (Interceptor) null, false, (ResponseParser) null, c00054, 3838, (Object) null);
                            c00052 = c00054;
                            if ($result2 == obj) {
                                return obj;
                            }
                            response2 = response;
                            encodedId6 = encodedId5;
                            normalizedId4 = normalizedId;
                            url4 = encodedId3;
                            res6 = res5;
                            NiceResponse this_$iv2 = (NiceResponse) $result2;
                            try {
                                ResponseParser parser2 = this_$iv2.getParser();
                                Intrinsics.checkNotNull(parser2);
                                safe2 = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(CatalogResponse.class));
                                break;
                            } catch (Exception e$iv2) {
                                e$iv2.printStackTrace();
                                safe2 = catalogEntry2;
                            }
                            fallback = (CatalogResponse) safe2;
                            if (fallback != null || (meta2 = fallback.getMeta()) == null) {
                                if (fallback != null || (metas3 = fallback.getMetas()) == null) {
                                    meta2 = catalogEntry2;
                                } else {
                                    meta2 = (CatalogEntry) CollectionsKt.firstOrNull(metas3);
                                }
                                if (meta2 == null) {
                                    throw new RuntimeException("Meta not found (primary + fallback)");
                                }
                            }
                            meta = meta2;
                            response = response2;
                            encodedId4 = encodedId6;
                            normalizedId3 = normalizedId4;
                            res4 = res6;
                            url3 = url4;
                            CatalogEntry entry = meta;
                            String id = res4.getId();
                            c00052.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                            c00052.L$1 = SpillingKt.nullOutSpilledVariable(res4);
                            c00052.L$2 = SpillingKt.nullOutSpilledVariable(normalizedId3);
                            c00052.L$3 = SpillingKt.nullOutSpilledVariable(encodedId4);
                            c00052.L$4 = SpillingKt.nullOutSpilledVariable(response);
                            c00052.L$5 = SpillingKt.nullOutSpilledVariable(entry);
                            c00052.label = 4;
                            $result2 = entry.toLoadResponse(this, id, c00052);
                            if ($result2 == obj) {
                                return obj;
                            }
                            return $result2;
                        }
                    }
                    encodedId4 = encodedId2;
                    meta = catalogEntry3;
                } else {
                    encodedId4 = encodedId2;
                }
                normalizedId3 = normalizedId;
                url3 = encodedId3;
                res4 = res3;
                CatalogEntry entry2 = meta;
                String id2 = res4.getId();
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(res4);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(normalizedId3);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(encodedId4);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(response);
                c00052.L$5 = SpillingKt.nullOutSpilledVariable(entry2);
                c00052.label = 4;
                $result2 = entry2.toLoadResponse(this, id2, c00052);
                if ($result2 == obj) {
                    return obj;
                }
                return $result2;
            case 1:
                String url5 = (String) c00052.L$0;
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                str = ".json";
                i = 2;
                $result = url5;
                obj2 = $result2;
                String json2 = ((NiceResponse) obj2).getText();
                metaJson = new JSONObject(json2).getJSONObject("meta").toString();
                AppUtils appUtils3 = AppUtils.INSTANCE;
                Result.Companion companion9 = Result.Companion;
                KType kTypeTypeOf3 = Reflection.typeOf(CatalogEntry.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                if (Result.exceptionOrNull-impl(obj4) != null) {
                    Result.Companion companion10 = Result.Companion;
                    catalogEntry = null;
                    obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(CatalogEntry.class), (List) null, i, (Object) null));
                    break;
                } else {
                    catalogEntry = null;
                }
                if (Result.isFailure-impl(obj4)) {
                    obj4 = catalogEntry;
                }
                deserializationStrategy = (KSerializer) obj4;
                if (deserializationStrategy != null) {
                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy, metaJson);
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv7 = MainAPIKt.getMapper();
                    objDecodeFromString2 = $this$readValue$iv$iv7.readValue(metaJson, new TypeReference<CatalogEntry>() { // from class: com.phisher98.StremioC$load$$inlined$parseJson$2
                    });
                }
                String str4 = $result;
                res = (CatalogEntry) objDecodeFromString2;
                url2 = str4;
                String normalizedId6 = UtilsKt.normalizeId(res.getId());
                encodedId = URLEncoder.encode(normalizedId6, "UTF-8");
                Requests app4 = MainActivityKt.getApp();
                String str5 = str;
                String strBuildUrl2 = buildUrl("/meta/" + res.getType() + '/' + encodedId + str5);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00052.L$1 = res;
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(normalizedId6);
                c00052.L$3 = encodedId;
                c00052.label = i;
                C00051 c00055 = c00052;
                res2 = res;
                normalizedId = normalizedId6;
                normalizedId2 = str5;
                catalogEntry2 = catalogEntry;
                $result2 = Requests.get$default(app4, strBuildUrl2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00055, 4094, (Object) null);
                c00052 = c00055;
                if ($result2 == obj) {
                    return obj;
                }
                encodedId2 = encodedId;
                res3 = res2;
                encodedId3 = url2;
                NiceResponse this_$iv3 = (NiceResponse) $result2;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                safe = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(CatalogResponse.class));
                catalogResponse = (CatalogResponse) safe;
                if (catalogResponse == null) {
                    throw new RuntimeException("Failed to load meta");
                }
                response = catalogResponse;
                meta = response.getMeta();
                if (meta == null) {
                    metas = response.getMetas();
                    if (metas != null) {
                        Iterable $this$firstOrNull$iv2 = metas;
                        it = $this$firstOrNull$iv2.iterator();
                        do {
                            if (it.hasNext()) {
                                element$iv = it.next();
                                it2 = (CatalogEntry) element$iv;
                            } else {
                                element$iv = catalogEntry2;
                            }
                            catalogEntry3 = (CatalogEntry) element$iv;
                        } while (!Intrinsics.areEqual(it2.getId(), res3.getId()));
                        catalogEntry3 = (CatalogEntry) element$iv;
                    } else {
                        catalogEntry3 = catalogEntry2;
                    }
                    if (catalogEntry3 == null) {
                        metas2 = response.getMetas();
                        if (metas2 != null) {
                            catalogEntry3 = (CatalogEntry) CollectionsKt.firstOrNull(metas2);
                        } else {
                            catalogEntry3 = catalogEntry2;
                        }
                        if (catalogEntry3 == null) {
                            StremioC $this$load_u24lambda_u242 = this;
                            Requests app5 = MainActivityKt.getApp();
                            String encodedId8 = "https://aiometadata.elfhosted.com/stremio/b7cb164b-074b-41d5-b458-b3a834e197bb/meta/" + res3.getType() + '/' + encodedId2 + normalizedId2;
                            c00052.L$0 = SpillingKt.nullOutSpilledVariable(encodedId3);
                            c00052.L$1 = res3;
                            c00052.L$2 = SpillingKt.nullOutSpilledVariable(normalizedId);
                            c00052.L$3 = SpillingKt.nullOutSpilledVariable(encodedId2);
                            c00052.L$4 = SpillingKt.nullOutSpilledVariable(response);
                            c00052.L$5 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u242);
                            c00052.label = 3;
                            encodedId5 = encodedId2;
                            res5 = res3;
                            C00051 c00056 = c00052;
                            $result2 = Requests.get$default(app5, encodedId8, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 120L, (Interceptor) null, false, (ResponseParser) null, c00056, 3838, (Object) null);
                            c00052 = c00056;
                            if ($result2 == obj) {
                                return obj;
                            }
                            response2 = response;
                            encodedId6 = encodedId5;
                            normalizedId4 = normalizedId;
                            url4 = encodedId3;
                            res6 = res5;
                            NiceResponse this_$iv4 = (NiceResponse) $result2;
                            ResponseParser parser4 = this_$iv4.getParser();
                            Intrinsics.checkNotNull(parser4);
                            safe2 = parser4.parseSafe(this_$iv4.getText(), Reflection.getOrCreateKotlinClass(CatalogResponse.class));
                            fallback = (CatalogResponse) safe2;
                            if (fallback != null) {
                                if (fallback != null) {
                                    meta2 = catalogEntry2;
                                } else {
                                    meta2 = catalogEntry2;
                                }
                                if (meta2 == null) {
                                    throw new RuntimeException("Meta not found (primary + fallback)");
                                }
                            } else {
                                if (fallback != null) {
                                    meta2 = catalogEntry2;
                                } else {
                                    meta2 = catalogEntry2;
                                }
                                if (meta2 == null) {
                                    throw new RuntimeException("Meta not found (primary + fallback)");
                                }
                            }
                            meta = meta2;
                            response = response2;
                            encodedId4 = encodedId6;
                            normalizedId3 = normalizedId4;
                            res4 = res6;
                            url3 = url4;
                            CatalogEntry entry3 = meta;
                            String id3 = res4.getId();
                            c00052.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                            c00052.L$1 = SpillingKt.nullOutSpilledVariable(res4);
                            c00052.L$2 = SpillingKt.nullOutSpilledVariable(normalizedId3);
                            c00052.L$3 = SpillingKt.nullOutSpilledVariable(encodedId4);
                            c00052.L$4 = SpillingKt.nullOutSpilledVariable(response);
                            c00052.L$5 = SpillingKt.nullOutSpilledVariable(entry3);
                            c00052.label = 4;
                            $result2 = entry3.toLoadResponse(this, id3, c00052);
                            if ($result2 == obj) {
                                return obj;
                            }
                            return $result2;
                        }
                    }
                    encodedId4 = encodedId2;
                    meta = catalogEntry3;
                } else {
                    encodedId4 = encodedId2;
                }
                normalizedId3 = normalizedId;
                url3 = encodedId3;
                res4 = res3;
                CatalogEntry entry4 = meta;
                String id4 = res4.getId();
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(res4);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(normalizedId3);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(encodedId4);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(response);
                c00052.L$5 = SpillingKt.nullOutSpilledVariable(entry4);
                c00052.label = 4;
                $result2 = entry4.toLoadResponse(this, id4, c00052);
                if ($result2 == obj) {
                    return obj;
                }
                return $result2;
            case 2:
                String encodedId9 = (String) c00052.L$3;
                String normalizedId7 = (String) c00052.L$2;
                CatalogEntry res7 = (CatalogEntry) c00052.L$1;
                String url6 = (String) c00052.L$0;
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                normalizedId2 = ".json";
                normalizedId = normalizedId7;
                catalogEntry2 = null;
                res3 = res7;
                encodedId3 = url6;
                encodedId2 = encodedId9;
                NiceResponse this_$iv5 = (NiceResponse) $result2;
                ResponseParser parser5 = this_$iv5.getParser();
                Intrinsics.checkNotNull(parser5);
                safe = parser5.parseSafe(this_$iv5.getText(), Reflection.getOrCreateKotlinClass(CatalogResponse.class));
                catalogResponse = (CatalogResponse) safe;
                if (catalogResponse == null) {
                    throw new RuntimeException("Failed to load meta");
                }
                response = catalogResponse;
                meta = response.getMeta();
                if (meta == null) {
                    metas = response.getMetas();
                    if (metas != null) {
                        Iterable $this$firstOrNull$iv3 = metas;
                        it = $this$firstOrNull$iv3.iterator();
                        do {
                            if (it.hasNext()) {
                                element$iv = it.next();
                                it2 = (CatalogEntry) element$iv;
                            } else {
                                element$iv = catalogEntry2;
                            }
                            catalogEntry3 = (CatalogEntry) element$iv;
                        } while (!Intrinsics.areEqual(it2.getId(), res3.getId()));
                        catalogEntry3 = (CatalogEntry) element$iv;
                    } else {
                        catalogEntry3 = catalogEntry2;
                    }
                    if (catalogEntry3 == null) {
                        metas2 = response.getMetas();
                        if (metas2 != null) {
                            catalogEntry3 = (CatalogEntry) CollectionsKt.firstOrNull(metas2);
                        } else {
                            catalogEntry3 = catalogEntry2;
                        }
                        if (catalogEntry3 == null) {
                            StremioC $this$load_u24lambda_u243 = this;
                            Requests app6 = MainActivityKt.getApp();
                            String encodedId10 = "https://aiometadata.elfhosted.com/stremio/b7cb164b-074b-41d5-b458-b3a834e197bb/meta/" + res3.getType() + '/' + encodedId2 + normalizedId2;
                            c00052.L$0 = SpillingKt.nullOutSpilledVariable(encodedId3);
                            c00052.L$1 = res3;
                            c00052.L$2 = SpillingKt.nullOutSpilledVariable(normalizedId);
                            c00052.L$3 = SpillingKt.nullOutSpilledVariable(encodedId2);
                            c00052.L$4 = SpillingKt.nullOutSpilledVariable(response);
                            c00052.L$5 = SpillingKt.nullOutSpilledVariable($this$load_u24lambda_u243);
                            c00052.label = 3;
                            encodedId5 = encodedId2;
                            res5 = res3;
                            C00051 c00057 = c00052;
                            $result2 = Requests.get$default(app6, encodedId10, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 120L, (Interceptor) null, false, (ResponseParser) null, c00057, 3838, (Object) null);
                            c00052 = c00057;
                            if ($result2 == obj) {
                                return obj;
                            }
                            response2 = response;
                            encodedId6 = encodedId5;
                            normalizedId4 = normalizedId;
                            url4 = encodedId3;
                            res6 = res5;
                            NiceResponse this_$iv6 = (NiceResponse) $result2;
                            ResponseParser parser6 = this_$iv6.getParser();
                            Intrinsics.checkNotNull(parser6);
                            safe2 = parser6.parseSafe(this_$iv6.getText(), Reflection.getOrCreateKotlinClass(CatalogResponse.class));
                            fallback = (CatalogResponse) safe2;
                            if (fallback != null) {
                                if (fallback != null) {
                                    meta2 = catalogEntry2;
                                } else {
                                    meta2 = catalogEntry2;
                                }
                                if (meta2 == null) {
                                    throw new RuntimeException("Meta not found (primary + fallback)");
                                }
                            } else {
                                if (fallback != null) {
                                    meta2 = catalogEntry2;
                                } else {
                                    meta2 = catalogEntry2;
                                }
                                if (meta2 == null) {
                                    throw new RuntimeException("Meta not found (primary + fallback)");
                                }
                            }
                            meta = meta2;
                            response = response2;
                            encodedId4 = encodedId6;
                            normalizedId3 = normalizedId4;
                            res4 = res6;
                            url3 = url4;
                            CatalogEntry entry5 = meta;
                            String id5 = res4.getId();
                            c00052.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                            c00052.L$1 = SpillingKt.nullOutSpilledVariable(res4);
                            c00052.L$2 = SpillingKt.nullOutSpilledVariable(normalizedId3);
                            c00052.L$3 = SpillingKt.nullOutSpilledVariable(encodedId4);
                            c00052.L$4 = SpillingKt.nullOutSpilledVariable(response);
                            c00052.L$5 = SpillingKt.nullOutSpilledVariable(entry5);
                            c00052.label = 4;
                            $result2 = entry5.toLoadResponse(this, id5, c00052);
                            if ($result2 == obj) {
                                return obj;
                            }
                            return $result2;
                        }
                    }
                    encodedId4 = encodedId2;
                    meta = catalogEntry3;
                } else {
                    encodedId4 = encodedId2;
                }
                normalizedId3 = normalizedId;
                url3 = encodedId3;
                res4 = res3;
                CatalogEntry entry6 = meta;
                String id6 = res4.getId();
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(res4);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(normalizedId3);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(encodedId4);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(response);
                c00052.L$5 = SpillingKt.nullOutSpilledVariable(entry6);
                c00052.label = 4;
                $result2 = entry6.toLoadResponse(this, id6, c00052);
                if ($result2 == obj) {
                    return obj;
                }
                return $result2;
            case 3:
                response2 = (CatalogResponse) c00052.L$4;
                encodedId6 = (String) c00052.L$3;
                normalizedId4 = (String) c00052.L$2;
                res6 = (CatalogEntry) c00052.L$1;
                url4 = (String) c00052.L$0;
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                catalogEntry2 = null;
                NiceResponse this_$iv7 = (NiceResponse) $result2;
                ResponseParser parser7 = this_$iv7.getParser();
                Intrinsics.checkNotNull(parser7);
                safe2 = parser7.parseSafe(this_$iv7.getText(), Reflection.getOrCreateKotlinClass(CatalogResponse.class));
                fallback = (CatalogResponse) safe2;
                if (fallback != null) {
                    if (fallback != null) {
                        meta2 = catalogEntry2;
                    } else {
                        meta2 = catalogEntry2;
                    }
                    if (meta2 == null) {
                        throw new RuntimeException("Meta not found (primary + fallback)");
                    }
                } else {
                    if (fallback != null) {
                        meta2 = catalogEntry2;
                    } else {
                        meta2 = catalogEntry2;
                    }
                    if (meta2 == null) {
                        throw new RuntimeException("Meta not found (primary + fallback)");
                    }
                }
                meta = meta2;
                response = response2;
                encodedId4 = encodedId6;
                normalizedId3 = normalizedId4;
                res4 = res6;
                url3 = url4;
                CatalogEntry entry7 = meta;
                String id7 = res4.getId();
                c00052.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(res4);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(normalizedId3);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(encodedId4);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(response);
                c00052.L$5 = SpillingKt.nullOutSpilledVariable(entry7);
                c00052.label = 4;
                $result2 = entry7.toLoadResponse(this, id7, c00052);
                if ($result2 == obj) {
                    return obj;
                }
                return $result2;
            case 4:
                ResultKt.throwOnFailure($result2);
                return $result2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:73:0x0299  */
    /* JADX WARN: Code duplicated, block: B:75:0x02e3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:76:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x02e4 -> B:77:0x02f1). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r28, boolean r29, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r30, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r31, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r32) {
        /*
            Method dump skipped, instruction units count: 1008
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StremioC.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.phisher98.StremioC$loadLinks$3 */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioC$loadLinks$3", f = "StremioC.kt", i = {}, l = {254}, m = "invokeSuspend", n = {}, nl = {255}, s = {}, v = 2)
    static final class C00073 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ LoadData $loadData;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00073(LoadData loadData, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00073> continuation) {
            super(1, continuation);
            this.$loadData = loadData;
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return StremioC.this.new C00073(this.$loadData, this.$subtitleCallback, this.$callback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (StremioC.this.invokeStremioX(this.$loadData.getType(), this.$loadData.getId(), this.$subtitleCallback, this.$callback, (Continuation) this) == coroutine_suspended) {
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
    }

    /* JADX INFO: renamed from: com.phisher98.StremioC$loadLinks$4 */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioC$loadLinks$4", f = "StremioC.kt", i = {}, l = {256}, m = "invokeSuspend", n = {}, nl = {257}, s = {}, v = 2)
    static final class C00084 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ LoadData $loadData;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00084(LoadData loadData, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00084> continuation) {
            super(1, continuation);
            this.$loadData = loadData;
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00084(this.$loadData, this.$callback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (StremioCKt.invokeTorrentio(this.$loadData.getImdbId(), this.$loadData.getSeason(), this.$loadData.getEpisode(), this.$callback, (Continuation) this) == coroutine_suspended) {
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
    }

    /* JADX INFO: renamed from: com.phisher98.StremioC$loadLinks$5 */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioC$loadLinks$5", f = "StremioC.kt", i = {}, l = {259}, m = "invokeSuspend", n = {}, nl = {260}, s = {}, v = 2)
    static final class C00095 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ LoadData $loadData;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00095(LoadData loadData, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00095> continuation) {
            super(1, continuation);
            this.$loadData = loadData;
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00095(this.$loadData, this.$callback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (StremioCKt.invokeKnaben(this.$loadData.getImdbId(), this.$loadData.getYear(), this.$loadData.getSeason(), this.$loadData.getEpisode(), this.$callback, (Continuation) this) == coroutine_suspended) {
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
    }

    /* JADX INFO: renamed from: com.phisher98.StremioC$loadLinks$6 */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioC$loadLinks$6", f = "StremioC.kt", i = {}, l = {262}, m = "invokeSuspend", n = {}, nl = {263}, s = {}, v = 2)
    static final class C00106 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ LoadData $loadData;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00106(LoadData loadData, Function1<? super ExtractorLink, Unit> function1, Continuation<? super C00106> continuation) {
            super(1, continuation);
            this.$loadData = loadData;
            this.$callback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00106(this.$loadData, this.$callback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (StremioCKt.invokeUindex(this.$loadData.getImdbId(), this.$loadData.getYear(), this.$loadData.getSeason(), this.$loadData.getEpisode(), this.$callback, (Continuation) this) == coroutine_suspended) {
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
    }

    /* JADX INFO: renamed from: com.phisher98.StremioC$loadLinks$7 */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioC$loadLinks$7", f = "StremioC.kt", i = {}, l = {265}, m = "invokeSuspend", n = {}, nl = {271}, s = {}, v = 2)
    static final class C00117 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ LoadData $loadData;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00117(LoadData loadData, Function1<? super SubtitleFile, Unit> function1, Continuation<? super C00117> continuation) {
            super(1, continuation);
            this.$loadData = loadData;
            this.$subtitleCallback = function1;
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C00117(this.$loadData, this.$subtitleCallback, continuation);
        }

        public final Object invoke(Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (SubsExtractors.INSTANCE.invokeWatchsomuch(this.$loadData.getImdbId(), this.$loadData.getSeason(), this.$loadData.getEpisode(), this.$subtitleCallback, (Continuation) this) == coroutine_suspended) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object invokeStremioX(String type, String id, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00031 c00031;
        Object objDecodeFromString;
        List sites;
        Object obj;
        Object obj2;
        String str;
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
        C00031 c00032 = c00031;
        Object $result = c00032.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00032.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CloudStreamApp.Companion this_$iv = CloudStreamApp.Companion;
                Context context = this_$iv.getContext();
                if (context != null) {
                    try {
                        try {
                            String string = DataStore.INSTANCE.getSharedPrefs(context).getString("user_custom_sites", null);
                            if (string == null) {
                                objDecodeFromString = null;
                            } else {
                                AppUtils appUtils = AppUtils.INSTANCE;
                                try {
                                    Result.Companion companion = Result.Companion;
                                    try {
                                        KType kTypeTypeOf = Reflection.typeOf(CustomSite[].class, KTypeProjection.Companion.invariant(Reflection.typeOf(CustomSite.class)));
                                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                        break;
                                    } catch (Throwable th) {
                                        th = th;
                                        try {
                                            Result.Companion companion2 = Result.Companion;
                                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                                        } catch (Exception e) {
                                            objDecodeFromString = null;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                                if (Result.exceptionOrNull-impl(obj) == null) {
                                    obj2 = null;
                                } else {
                                    try {
                                        Result.Companion companion3 = Result.Companion;
                                        obj2 = null;
                                        try {
                                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(CustomSite[].class), (List) null, 2, (Object) null));
                                        } catch (Throwable th3) {
                                            th = th3;
                                            Result.Companion companion4 = Result.Companion;
                                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        obj2 = null;
                                    }
                                }
                                if (Result.isFailure-impl(obj)) {
                                    obj = obj2;
                                }
                                DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                                if (deserializationStrategy != null) {
                                    try {
                                        str = string;
                                        try {
                                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, str);
                                        } catch (SerializationException e2) {
                                            e = e2;
                                            ArchComponentExtKt.logError((Throwable) e);
                                            objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<CustomSite[]>() { // from class: com.phisher98.StremioC$invokeStremioX$$inlined$getKey$1
                                            });
                                        } catch (Throwable th5) {
                                            objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<CustomSite[]>() { // from class: com.phisher98.StremioC$invokeStremioX$$inlined$getKey$1
                                            });
                                        }
                                    } catch (SerializationException e3) {
                                        e = e3;
                                        str = string;
                                    } catch (Throwable th6) {
                                        str = string;
                                    }
                                } else {
                                    str = string;
                                }
                                objDecodeFromString = MainAPIKt.getMapper().readValue(str, new TypeReference<CustomSite[]>() { // from class: com.phisher98.StremioC$invokeStremioX$$inlined$getKey$1
                                });
                            }
                            break;
                        } catch (Exception e4) {
                        }
                    } catch (Exception e5) {
                    }
                } else {
                    objDecodeFromString = null;
                }
                CustomSite[] customSiteArr = (CustomSite[]) objDecodeFromString;
                if (customSiteArr == null || (sites = ArraysKt.toMutableList(customSiteArr)) == null) {
                    sites = new ArrayList();
                }
                List $this$filter$iv = sites;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    CustomSite it = (CustomSite) element$iv$iv;
                    if (Intrinsics.areEqual(it.getParentJavaClass(), "StremioX")) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                C00043 c00043 = new C00043(type, id, function1, function2, null);
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(type);
                c00032.L$1 = SpillingKt.nullOutSpilledVariable(id);
                c00032.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c00032.L$3 = SpillingKt.nullOutSpilledVariable(function2);
                c00032.L$4 = SpillingKt.nullOutSpilledVariable(sites);
                c00032.label = 1;
                if (ParCollectionsKt.amap((List) destination$iv$iv, c00043, c00032) == coroutine_suspended) {
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.phisher98.StremioC$invokeStremioX$3 */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "site", "Lcom/phisher98/StremioC$CustomSite;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.StremioC$invokeStremioX$3", f = "StremioC.kt", i = {0, 1, 1, 1, 1, 1}, l = {295, 300}, m = "invokeSuspend", n = {"site", "site", "res", "$this$forEach$iv", "element$iv", "stream"}, nl = {298, 301}, s = {"L$0", "L$0", "L$1", "L$2", "L$6", "L$7"}, v = 2)
    @SourceDebugExtension({"SMAP\nStremioC.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StremioC.kt\ncom/phisher98/StremioC$invokeStremioX$3\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1058:1\n73#2,5:1059\n2068#3,2:1064\n*S KotlinDebug\n*F\n+ 1 StremioC.kt\ncom/phisher98/StremioC$invokeStremioX$3\n*L\n298#1:1059,5\n299#1:1064,2\n*E\n"})
    static final class C00043 extends SuspendLambda implements Function2<CustomSite, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<ExtractorLink, Unit> $callback;
        final /* synthetic */ String $id;
        final /* synthetic */ Function1<SubtitleFile, Unit> $subtitleCallback;
        final /* synthetic */ String $type;
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
        C00043(String str, String str2, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super C00043> continuation) {
            super(2, continuation);
            this.$type = str;
            this.$id = str2;
            this.$subtitleCallback = function1;
            this.$callback = function2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00043 = new C00043(this.$type, this.$id, this.$subtitleCallback, this.$callback, continuation);
            c00043.L$0 = obj;
            return c00043;
        }

        public final Object invoke(CustomSite customSite, Continuation<? super Unit> continuation) {
            return create(customSite, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x00f4  */
        /* JADX WARN: Code duplicated, block: B:25:0x0129 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:26:0x012a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x012a -> B:27:0x0135). Please report as a decompilation issue!!! */
        /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
            java.lang.StackOverflowError
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.getNextBlockInIfSuccessorChain(IfRegionMaker.java:646)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.getNextIfNodeInfo(IfRegionMaker.java:620)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.getNextIf(IfRegionMaker.java:602)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.mergeNestedIfNodes(IfRegionMaker.java:409)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:68)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
            	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
            	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
            */
        public final java.lang.Object invokeSuspend(java.lang.Object r31) {
            /*
                Method dump skipped, instruction units count: 336
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StremioC.C00043.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010JV\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u0010¨\u0006\""}, d2 = {"Lcom/phisher98/StremioC$LoadData;", "", "type", "", "id", "season", "", "episode", "imdbId", "year", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getType", "()Ljava/lang/String;", "getId", "getSeason", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEpisode", "getImdbId", "getYear", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/phisher98/StremioC$LoadData;", "equals", "", "other", "hashCode", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class LoadData {

        @Nullable
        private final Integer episode;

        @Nullable
        private final String id;

        @Nullable
        private final String imdbId;

        @Nullable
        private final Integer season;

        @Nullable
        private final String type;

        @Nullable
        private final Integer year;

        public LoadData() {
            this(null, null, null, null, null, null, 63, null);
        }

        public static /* synthetic */ LoadData copy$default(LoadData loadData, String str, String str2, Integer num, Integer num2, String str3, Integer num3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loadData.type;
            }
            if ((i & 2) != 0) {
                str2 = loadData.id;
            }
            if ((i & 4) != 0) {
                num = loadData.season;
            }
            if ((i & 8) != 0) {
                num2 = loadData.episode;
            }
            if ((i & 16) != 0) {
                str3 = loadData.imdbId;
            }
            if ((i & 32) != 0) {
                num3 = loadData.year;
            }
            String str4 = str3;
            Integer num4 = num3;
            return loadData.copy(str, str2, num, num2, str4, num4);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getYear() {
            return this.year;
        }

        @NotNull
        public final LoadData copy(@Nullable String type, @Nullable String id, @Nullable Integer season, @Nullable Integer episode, @Nullable String imdbId, @Nullable Integer year) {
            return new LoadData(type, id, season, episode, imdbId, year);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadData)) {
                return false;
            }
            LoadData loadData = (LoadData) other;
            return Intrinsics.areEqual(this.type, loadData.type) && Intrinsics.areEqual(this.id, loadData.id) && Intrinsics.areEqual(this.season, loadData.season) && Intrinsics.areEqual(this.episode, loadData.episode) && Intrinsics.areEqual(this.imdbId, loadData.imdbId) && Intrinsics.areEqual(this.year, loadData.year);
        }

        public int hashCode() {
            return ((((((((((this.type == null ? 0 : this.type.hashCode()) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.imdbId == null ? 0 : this.imdbId.hashCode())) * 31) + (this.year != null ? this.year.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "LoadData(type=" + this.type + ", id=" + this.id + ", season=" + this.season + ", episode=" + this.episode + ", imdbId=" + this.imdbId + ", year=" + this.year + ')';
        }

        public LoadData(@Nullable String type, @Nullable String id, @Nullable Integer season, @Nullable Integer episode, @Nullable String imdbId, @Nullable Integer year) {
            this.type = type;
            this.id = id;
            this.season = season;
            this.episode = episode;
            this.imdbId = imdbId;
            this.year = year;
        }

        public /* synthetic */ LoadData(String str, String str2, Integer num, Integer num2, String str3, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : num3);
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final Integer getSeason() {
            return this.season;
        }

        @Nullable
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        public final String getImdbId() {
            return this.imdbId;
        }

        @Nullable
        public final Integer getYear() {
            return this.year;
        }
    }

    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0016\b\u0001\u0010\u0006\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0001\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0016\b\u0001\u0010\b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003Ji\u0010\u0014\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0016\b\u0003\u0010\u0006\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0016\b\u0003\u0010\b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/phisher98/StremioC$CustomSite;", "", "parentJavaClass", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "name", "url", "lang", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getParentJavaClass", "()Ljava/lang/String;", "getName", "getUrl", "getLang", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class CustomSite {

        @NotNull
        private final String lang;

        @NotNull
        private final String name;

        @NotNull
        private final String parentJavaClass;

        @NotNull
        private final String url;

        public static /* synthetic */ CustomSite copy$default(CustomSite customSite, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = customSite.parentJavaClass;
            }
            if ((i & 2) != 0) {
                str2 = customSite.name;
            }
            if ((i & 4) != 0) {
                str3 = customSite.url;
            }
            if ((i & 8) != 0) {
                str4 = customSite.lang;
            }
            return customSite.copy(str, str2, str3, str4);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getParentJavaClass() {
            return this.parentJavaClass;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getLang() {
            return this.lang;
        }

        @NotNull
        public final CustomSite copy(@JsonProperty("parentJavaClass") @NotNull String parentJavaClass, @JsonProperty("name") @NotNull String name, @JsonProperty("url") @NotNull String url, @JsonProperty("lang") @NotNull String lang) {
            return new CustomSite(parentJavaClass, name, url, lang);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CustomSite)) {
                return false;
            }
            CustomSite customSite = (CustomSite) other;
            return Intrinsics.areEqual(this.parentJavaClass, customSite.parentJavaClass) && Intrinsics.areEqual(this.name, customSite.name) && Intrinsics.areEqual(this.url, customSite.url) && Intrinsics.areEqual(this.lang, customSite.lang);
        }

        public int hashCode() {
            return (((((this.parentJavaClass.hashCode() * 31) + this.name.hashCode()) * 31) + this.url.hashCode()) * 31) + this.lang.hashCode();
        }

        @NotNull
        public String toString() {
            return "CustomSite(parentJavaClass=" + this.parentJavaClass + ", name=" + this.name + ", url=" + this.url + ", lang=" + this.lang + ')';
        }

        public CustomSite(@JsonProperty("parentJavaClass") @NotNull String parentJavaClass, @JsonProperty("name") @NotNull String name, @JsonProperty("url") @NotNull String url, @JsonProperty("lang") @NotNull String lang) {
            this.parentJavaClass = parentJavaClass;
            this.name = name;
            this.url = url;
            this.lang = lang;
        }

        @NotNull
        public final String getParentJavaClass() {
            return this.parentJavaClass;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final String getLang() {
            return this.lang;
        }
    }

    private final boolean isImdborTmdb(String url) {
        if (MainAPIKt.imdbUrlToIdNullable(url) == null) {
            return url != null && StringsKt.startsWith$default(url, "tmdb:", false, 2, (Object) null);
        }
        return true;
    }

    private final boolean isImdb(String url) {
        return MainAPIKt.imdbUrlToIdNullable(url) != null;
    }

    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/phisher98/StremioC$Manifest;", "", "catalogs", "", "Lcom/phisher98/StremioC$Catalog;", "<init>", "(Ljava/util/List;)V", "getCatalogs", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final /* data */ class Manifest {

        @NotNull
        private final List<Catalog> catalogs;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Manifest copy$default(Manifest manifest, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = manifest.catalogs;
            }
            return manifest.copy(list);
        }

        @NotNull
        public final List<Catalog> component1() {
            return this.catalogs;
        }

        @NotNull
        public final Manifest copy(@NotNull List<Catalog> catalogs) {
            return new Manifest(catalogs);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Manifest) && Intrinsics.areEqual(this.catalogs, ((Manifest) other).catalogs);
        }

        public int hashCode() {
            return this.catalogs.hashCode();
        }

        @NotNull
        public String toString() {
            return "Manifest(catalogs=" + this.catalogs + ')';
        }

        public Manifest(@NotNull List<Catalog> list) {
            this.catalogs = list;
        }

        @NotNull
        public final List<Catalog> getCatalogs() {
            return this.catalogs;
        }
    }

    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\fJB\u0010\u0010\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0006\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/phisher98/StremioC$Extra;", "", "name", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "isRequired", "", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "getName", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;)Lcom/phisher98/StremioC$Extra;", "equals", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final /* data */ class Extra {

        @Nullable
        private final Boolean isRequired;

        @Nullable
        private final String name;

        public static /* synthetic */ Extra copy$default(Extra extra, String str, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = extra.name;
            }
            if ((i & 2) != 0) {
                bool = extra.isRequired;
            }
            return extra.copy(str, bool);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Boolean getIsRequired() {
            return this.isRequired;
        }

        @NotNull
        public final Extra copy(@JsonProperty("name") @Nullable String name, @JsonProperty("isRequired") @Nullable Boolean isRequired) {
            return new Extra(name, isRequired);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Extra)) {
                return false;
            }
            Extra extra = (Extra) other;
            return Intrinsics.areEqual(this.name, extra.name) && Intrinsics.areEqual(this.isRequired, extra.isRequired);
        }

        public int hashCode() {
            return ((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.isRequired != null ? this.isRequired.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Extra(name=" + this.name + ", isRequired=" + this.isRequired + ')';
        }

        public Extra(@JsonProperty("name") @Nullable String name, @JsonProperty("isRequired") @Nullable Boolean isRequired) {
            this.name = name;
            this.isRequired = isRequired;
        }

        public /* synthetic */ Extra(String str, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? false : bool);
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final Boolean isRequired() {
            return this.isRequired;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0082\b\u0018\u00002\u00020\u0001Bs\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u001e\b\u0003\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t:\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\b\u0012\u001e\b\u0003\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t:\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\t2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H\u0086@¢\u0006\u0002\u0010\"J\u001e\u0010#\u001a\u00020$2\u0006\u0010 \u001a\u00020!2\u0006\u0010%\u001a\u00020&H\u0086@¢\u0006\u0002\u0010'J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J{\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u001e\b\u0003\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t:\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\b2\u001e\b\u0003\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t:\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\rHÆ\u0001J\u0014\u0010/\u001a\u00020\u001b2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00101\u001a\u00020&HÖ\u0081\u0004J\n\u00102\u001a\u00020\u0003HÖ\u0081\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017¨\u00063"}, d2 = {"Lcom/phisher98/StremioC$Catalog;", "", "name", "", "id", "type", "types", "", "extra", "", "Lcom/phisher98/StremioC$Extra;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "extraSupported", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getId", "getType", "getTypes", "()Ljava/util/List;", "getExtra", "getExtraSupported", "isSearchRequired", "", "supportsSearch", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "provider", "Lcom/phisher98/StremioC;", "(Ljava/lang/String;Lcom/phisher98/StremioC;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toHomePageList", "Lcom/lagradost/cloudstream3/HomePageList;", "skip", "", "(Lcom/phisher98/StremioC;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nStremioC.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StremioC.kt\ncom/phisher98/StremioC$Catalog\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1058:1\n1960#2,3:1059\n1960#2,3:1062\n1849#2,8:1065\n1739#2:1073\n1814#2,3:1074\n1849#2,8:1077\n1739#2:1085\n1814#2,3:1086\n*S KotlinDebug\n*F\n+ 1 StremioC.kt\ncom/phisher98/StremioC$Catalog\n*L\n349#1:1059,3\n353#1:1062,3\n365#1:1065,8\n365#1:1073\n365#1:1074,3\n384#1:1077,8\n384#1:1085\n384#1:1086,3\n*E\n"})
    static final /* data */ class Catalog {

        @Nullable
        private final List<Extra> extra;

        @Nullable
        private final List<String> extraSupported;

        @NotNull
        private final String id;

        @Nullable
        private String name;

        @Nullable
        private final String type;

        @NotNull
        private final List<String> types;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Catalog copy$default(Catalog catalog, String str, String str2, String str3, List list, List list2, List list3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = catalog.name;
            }
            if ((i & 2) != 0) {
                str2 = catalog.id;
            }
            if ((i & 4) != 0) {
                str3 = catalog.type;
            }
            if ((i & 8) != 0) {
                list = catalog.types;
            }
            if ((i & 16) != 0) {
                list2 = catalog.extra;
            }
            if ((i & 32) != 0) {
                list3 = catalog.extraSupported;
            }
            List list4 = list2;
            List list5 = list3;
            return catalog.copy(str, str2, str3, list, list4, list5);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final List<String> component4() {
            return this.types;
        }

        @Nullable
        public final List<Extra> component5() {
            return this.extra;
        }

        @Nullable
        public final List<String> component6() {
            return this.extraSupported;
        }

        @NotNull
        public final Catalog copy(@Nullable String name, @NotNull String id, @Nullable String type, @NotNull List<String> types, @JsonProperty("extra") @Nullable List<Extra> extra, @JsonProperty("extraSupported") @Nullable List<String> extraSupported) {
            return new Catalog(name, id, type, types, extra, extraSupported);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Catalog)) {
                return false;
            }
            Catalog catalog = (Catalog) other;
            return Intrinsics.areEqual(this.name, catalog.name) && Intrinsics.areEqual(this.id, catalog.id) && Intrinsics.areEqual(this.type, catalog.type) && Intrinsics.areEqual(this.types, catalog.types) && Intrinsics.areEqual(this.extra, catalog.extra) && Intrinsics.areEqual(this.extraSupported, catalog.extraSupported);
        }

        public int hashCode() {
            return ((((((((((this.name == null ? 0 : this.name.hashCode()) * 31) + this.id.hashCode()) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + this.types.hashCode()) * 31) + (this.extra == null ? 0 : this.extra.hashCode())) * 31) + (this.extraSupported != null ? this.extraSupported.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Catalog(name=" + this.name + ", id=" + this.id + ", type=" + this.type + ", types=" + this.types + ", extra=" + this.extra + ", extraSupported=" + this.extraSupported + ')';
        }

        public Catalog(@Nullable String name, @NotNull String id, @Nullable String type, @NotNull List<String> list, @JsonProperty("extra") @Nullable List<Extra> list2, @JsonProperty("extraSupported") @Nullable List<String> list3) {
            this.name = name;
            this.id = id;
            this.type = type;
            this.types = list;
            this.extra = list2;
            this.extraSupported = list3;
            if (this.type != null) {
                this.types.add(this.type);
            }
        }

        public /* synthetic */ Catalog(String str, String str2, String str3, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, (i & 8) != 0 ? new ArrayList() : list, (i & 16) != 0 ? null : list2, (i & 32) != 0 ? null : list3);
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        public final void setName(@Nullable String str) {
            this.name = str;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final List<String> getTypes() {
            return this.types;
        }

        @Nullable
        public final List<Extra> getExtra() {
            return this.extra;
        }

        @Nullable
        public final List<String> getExtraSupported() {
            return this.extraSupported;
        }

        public final boolean isSearchRequired() {
            boolean z;
            Iterable iterable = this.extra;
            if (iterable == null) {
                return false;
            }
            Iterable $this$any$iv = iterable;
            if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
                z = false;
            } else {
                for (Object element$iv : $this$any$iv) {
                    Extra it = (Extra) element$iv;
                    if (Intrinsics.areEqual(it.getName(), "search") && Intrinsics.areEqual(it.isRequired(), true)) {
                        z = true;
                    }
                }
                z = false;
            }
            return z;
        }

        /* JADX WARN: Code duplicated, block: B:18:0x003d  */
        public final boolean supportsSearch() {
            boolean hasSearchInExtra;
            boolean z;
            Iterable iterable = this.extra;
            if (iterable != null) {
                Iterable $this$any$iv = iterable;
                if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                    Iterator it = $this$any$iv.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object element$iv = it.next();
                            Extra it2 = (Extra) element$iv;
                            if (Intrinsics.areEqual(it2.getName(), "search")) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                } else {
                    z = false;
                }
                if (z) {
                    hasSearchInExtra = true;
                } else {
                    hasSearchInExtra = false;
                }
            } else {
                hasSearchInExtra = false;
            }
            List<String> list = this.extraSupported;
            boolean hasSearchInExtraSupported = list != null && list.contains("search");
            return hasSearchInExtra || hasSearchInExtraSupported;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        @Nullable
        public final Object search(@NotNull String query, @NotNull StremioC provider, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
            StremioC$Catalog$search$1 stremioC$Catalog$search$1;
            Object objAmap;
            if (continuation instanceof StremioC$Catalog$search$1) {
                stremioC$Catalog$search$1 = (StremioC$Catalog$search$1) continuation;
                if ((stremioC$Catalog$search$1.label & Integer.MIN_VALUE) != 0) {
                    stremioC$Catalog$search$1.label -= Integer.MIN_VALUE;
                } else {
                    stremioC$Catalog$search$1 = new StremioC$Catalog$search$1(this, continuation);
                }
            } else {
                stremioC$Catalog$search$1 = new StremioC$Catalog$search$1(this, continuation);
            }
            Object $result = stremioC$Catalog$search$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (stremioC$Catalog$search$1.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    List<String> list = this.types;
                    StremioC$Catalog$search$allMetas$1 stremioC$Catalog$search$allMetas$1 = new StremioC$Catalog$search$allMetas$1(provider, this, query, null);
                    stremioC$Catalog$search$1.L$0 = SpillingKt.nullOutSpilledVariable(query);
                    stremioC$Catalog$search$1.L$1 = provider;
                    stremioC$Catalog$search$1.label = 1;
                    objAmap = ParCollectionsKt.amap(list, stremioC$Catalog$search$allMetas$1, stremioC$Catalog$search$1);
                    if (objAmap == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    provider = (StremioC) stremioC$Catalog$search$1.L$1;
                    ResultKt.throwOnFailure($result);
                    objAmap = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Iterable allMetas = CollectionsKt.flatten((Iterable) objAmap);
            Iterable $this$distinctBy$iv = allMetas;
            HashSet set$iv = new HashSet();
            ArrayList list$iv = new ArrayList();
            for (Object e$iv : $this$distinctBy$iv) {
                CatalogEntry it = (CatalogEntry) e$iv;
                if (set$iv.add(it.getId())) {
                    list$iv.add(e$iv);
                }
            }
            ArrayList $this$distinctBy$iv2 = list$iv;
            ArrayList $this$map$iv = $this$distinctBy$iv2;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                CatalogEntry it2 = (CatalogEntry) item$iv$iv;
                destination$iv$iv.add(it2.toSearchResponse(provider));
            }
            return (List) destination$iv$iv;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        @Nullable
        public final Object toHomePageList(@NotNull StremioC provider, int skip, @NotNull Continuation<? super HomePageList> continuation) {
            StremioC$Catalog$toHomePageList$1 stremioC$Catalog$toHomePageList$1;
            Object objAmap;
            if (continuation instanceof StremioC$Catalog$toHomePageList$1) {
                stremioC$Catalog$toHomePageList$1 = (StremioC$Catalog$toHomePageList$1) continuation;
                if ((stremioC$Catalog$toHomePageList$1.label & Integer.MIN_VALUE) != 0) {
                    stremioC$Catalog$toHomePageList$1.label -= Integer.MIN_VALUE;
                } else {
                    stremioC$Catalog$toHomePageList$1 = new StremioC$Catalog$toHomePageList$1(this, continuation);
                }
            } else {
                stremioC$Catalog$toHomePageList$1 = new StremioC$Catalog$toHomePageList$1(this, continuation);
            }
            Object $result = stremioC$Catalog$toHomePageList$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (stremioC$Catalog$toHomePageList$1.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    List<String> list = this.types;
                    StremioC$Catalog$toHomePageList$allMetas$1 stremioC$Catalog$toHomePageList$allMetas$1 = new StremioC$Catalog$toHomePageList$allMetas$1(skip, this, provider, null);
                    stremioC$Catalog$toHomePageList$1.L$0 = provider;
                    stremioC$Catalog$toHomePageList$1.I$0 = skip;
                    stremioC$Catalog$toHomePageList$1.label = 1;
                    objAmap = ParCollectionsKt.amap(list, stremioC$Catalog$toHomePageList$allMetas$1, stremioC$Catalog$toHomePageList$1);
                    if (objAmap == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    int skip2 = stremioC$Catalog$toHomePageList$1.I$0;
                    provider = (StremioC) stremioC$Catalog$toHomePageList$1.L$0;
                    ResultKt.throwOnFailure($result);
                    objAmap = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Iterable allMetas = CollectionsKt.flatten((Iterable) objAmap);
            Iterable $this$distinctBy$iv = allMetas;
            HashSet set$iv = new HashSet();
            ArrayList list$iv = new ArrayList();
            for (Object e$iv : $this$distinctBy$iv) {
                CatalogEntry it = (CatalogEntry) e$iv;
                if (set$iv.add(it.getId())) {
                    list$iv.add(e$iv);
                }
            }
            ArrayList $this$distinctBy$iv2 = list$iv;
            ArrayList $this$map$iv = $this$distinctBy$iv2;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                CatalogEntry it2 = (CatalogEntry) item$iv$iv;
                destination$iv$iv.add(it2.toSearchResponse(provider));
            }
            List distinctEntries = (List) destination$iv$iv;
            String str = this.name;
            if (str == null) {
                str = this.id;
            }
            return new HomePageList(str, distinctEntries, false, 4, (DefaultConstructorMarker) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B!\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/phisher98/StremioC$CatalogResponse;", "", "metas", "", "Lcom/phisher98/StremioC$CatalogEntry;", "meta", "<init>", "(Ljava/util/List;Lcom/phisher98/StremioC$CatalogEntry;)V", "getMetas", "()Ljava/util/List;", "getMeta", "()Lcom/phisher98/StremioC$CatalogEntry;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    static final /* data */ class CatalogResponse {

        @Nullable
        private final CatalogEntry meta;

        @Nullable
        private final List<CatalogEntry> metas;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CatalogResponse copy$default(CatalogResponse catalogResponse, List list, CatalogEntry catalogEntry, int i, Object obj) {
            if ((i & 1) != 0) {
                list = catalogResponse.metas;
            }
            if ((i & 2) != 0) {
                catalogEntry = catalogResponse.meta;
            }
            return catalogResponse.copy(list, catalogEntry);
        }

        @Nullable
        public final List<CatalogEntry> component1() {
            return this.metas;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final CatalogEntry getMeta() {
            return this.meta;
        }

        @NotNull
        public final CatalogResponse copy(@Nullable List<CatalogEntry> metas, @Nullable CatalogEntry meta) {
            return new CatalogResponse(metas, meta);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CatalogResponse)) {
                return false;
            }
            CatalogResponse catalogResponse = (CatalogResponse) other;
            return Intrinsics.areEqual(this.metas, catalogResponse.metas) && Intrinsics.areEqual(this.meta, catalogResponse.meta);
        }

        public int hashCode() {
            return ((this.metas == null ? 0 : this.metas.hashCode()) * 31) + (this.meta != null ? this.meta.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "CatalogResponse(metas=" + this.metas + ", meta=" + this.meta + ')';
        }

        public CatalogResponse(@Nullable List<CatalogEntry> list, @Nullable CatalogEntry meta) {
            this.metas = list;
            this.meta = meta;
        }

        @Nullable
        public final CatalogEntry getMeta() {
            return this.meta;
        }

        @Nullable
        public final List<CatalogEntry> getMetas() {
            return this.metas;
        }
    }

    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/phisher98/StremioC$Trailer;", "", "source", "", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final /* data */ class Trailer {

        @Nullable
        private final String source;

        @Nullable
        private final String type;

        public static /* synthetic */ Trailer copy$default(Trailer trailer, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = trailer.source;
            }
            if ((i & 2) != 0) {
                str2 = trailer.type;
            }
            return trailer.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSource() {
            return this.source;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @NotNull
        public final Trailer copy(@Nullable String source, @Nullable String type) {
            return new Trailer(source, type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Trailer)) {
                return false;
            }
            Trailer trailer = (Trailer) other;
            return Intrinsics.areEqual(this.source, trailer.source) && Intrinsics.areEqual(this.type, trailer.type);
        }

        public int hashCode() {
            return ((this.source == null ? 0 : this.source.hashCode()) * 31) + (this.type != null ? this.type.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Trailer(source=" + this.source + ", type=" + this.type + ')';
        }

        public Trailer(@Nullable String source, @Nullable String type) {
            this.source = source;
            this.type = type;
        }

        @Nullable
        public final String getSource() {
            return this.source;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }
    }

    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u000e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/phisher98/StremioC$TrailerStream;", "", "ytId", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getYtId", "()Ljava/lang/String;", "getTitle", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final /* data */ class TrailerStream {

        @Nullable
        private final String title;

        @Nullable
        private final String ytId;

        public static /* synthetic */ TrailerStream copy$default(TrailerStream trailerStream, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = trailerStream.ytId;
            }
            if ((i & 2) != 0) {
                str2 = trailerStream.title;
            }
            return trailerStream.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getYtId() {
            return this.ytId;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final TrailerStream copy(@JsonProperty("ytId") @Nullable String ytId, @JsonProperty("title") @Nullable String title) {
            return new TrailerStream(ytId, title);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TrailerStream)) {
                return false;
            }
            TrailerStream trailerStream = (TrailerStream) other;
            return Intrinsics.areEqual(this.ytId, trailerStream.ytId) && Intrinsics.areEqual(this.title, trailerStream.title);
        }

        public int hashCode() {
            return ((this.ytId == null ? 0 : this.ytId.hashCode()) * 31) + (this.title != null ? this.title.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "TrailerStream(ytId=" + this.ytId + ", title=" + this.title + ')';
        }

        public TrailerStream(@JsonProperty("ytId") @Nullable String ytId, @JsonProperty("title") @Nullable String title) {
            this.ytId = ytId;
            this.title = title;
        }

        public /* synthetic */ TrailerStream(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2);
        }

        @Nullable
        public final String getYtId() {
            return this.ytId;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }
    }

    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010\u0011\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/phisher98/StremioC$Link;", "", "name", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "category", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getCategory", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final /* data */ class Link {

        @Nullable
        private final String category;

        @Nullable
        private final String name;

        @Nullable
        private final String url;

        public Link() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ Link copy$default(Link link, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = link.name;
            }
            if ((i & 2) != 0) {
                str2 = link.category;
            }
            if ((i & 4) != 0) {
                str3 = link.url;
            }
            return link.copy(str, str2, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCategory() {
            return this.category;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final Link copy(@JsonProperty("name") @Nullable String name, @JsonProperty("category") @Nullable String category, @JsonProperty("url") @Nullable String url) {
            return new Link(name, category, url);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Link)) {
                return false;
            }
            Link link = (Link) other;
            return Intrinsics.areEqual(this.name, link.name) && Intrinsics.areEqual(this.category, link.category) && Intrinsics.areEqual(this.url, link.url);
        }

        public int hashCode() {
            return ((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.category == null ? 0 : this.category.hashCode())) * 31) + (this.url != null ? this.url.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Link(name=" + this.name + ", category=" + this.category + ", url=" + this.url + ')';
        }

        public Link(@JsonProperty("name") @Nullable String name, @JsonProperty("category") @Nullable String category, @JsonProperty("url") @Nullable String url) {
            this.name = name;
            this.category = category;
            this.url = url;
        }

        public /* synthetic */ Link(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getCategory() {
            return this.category;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B©\u0003\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0016\b\u0001\u0010\u0006\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u001e\b\u0001\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u001e\b\u0001\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u001c\b\u0003\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u0012\u001c\b\u0003\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0011\u0012\u001c\b\u0003\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014\u0012\u001c\b\u0003\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015\u0012\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0018\u0012\u001c\b\u0003\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201J \u00102\u001a\u0002032\u0006\u00100\u001a\u0002012\b\u00104\u001a\u0004\u0018\u00010\u0003H\u0086@¢\u0006\u0002\u00105J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010=\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003J\u0011\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\u000f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\u000f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00130\rHÆ\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00160\rHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001a0\rHÆ\u0003J«\u0003\u0010E\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0016\b\u0003\u0010\u0006\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u001e\b\u0003\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u001e\b\u0003\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f2\u001c\b\u0003\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u001c\b\u0003\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00112\u001c\b\u0003\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00142\u001c\b\u0003\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00152\u0018\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00182\u001c\b\u0003\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\r:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0019HÆ\u0001J\u0014\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010I\u001a\u00020JHÖ\u0081\u0004J\n\u0010K\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010&R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\r¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\r¢\u0006\b\n\u0000\u001a\u0004\b+\u0010&R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001eR\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\r¢\u0006\b\n\u0000\u001a\u0004\b-\u0010&¨\u0006L"}, d2 = {"Lcom/phisher98/StremioC$CatalogEntry;", "", "name", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "id", "poster", "background", "description", "imdbRating", "type", "videos", "", "Lcom/phisher98/StremioC$Video;", "genre", "genres", "cast", "trailersSources", "Lcom/phisher98/StremioC$Trailer;", "trailers", "trailerStreams", "Lcom/phisher98/StremioC$TrailerStream;", "yearNum", "year", "links", "Lcom/phisher98/StremioC$Link;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getId", "getPoster", "getBackground", "getDescription", "getImdbRating", "getType", "getVideos", "()Ljava/util/List;", "getGenre", "getGenres", "getCast", "getTrailersSources", "getTrailerStreams", "getYearNum", "getLinks", "toSearchResponse", "Lcom/lagradost/cloudstream3/SearchResponse;", "provider", "Lcom/phisher98/StremioC;", "toLoadResponse", "Lcom/lagradost/cloudstream3/LoadResponse;", "imdbId", "(Lcom/phisher98/StremioC;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nStremioC.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StremioC.kt\ncom/phisher98/StremioC$CatalogEntry\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,1058:1\n1795#2,10:1059\n2068#2:1069\n2069#2:1071\n1805#2:1072\n2068#2,2:1073\n1805#2:1075\n1739#2:1076\n1814#2,3:1077\n296#2,2:1080\n1795#2,10:1093\n2068#2:1103\n2069#2:1105\n1805#2:1106\n1739#2:1107\n1814#2,3:1108\n1#3:1070\n1#3:1082\n1#3:1104\n73#4,5:1083\n73#4,5:1088\n*S KotlinDebug\n*F\n+ 1 StremioC.kt\ncom/phisher98/StremioC$CatalogEntry\n*L\n439#1:1059,10\n439#1:1069\n439#1:1071\n439#1:1072\n439#1:1073,2\n439#1:1075\n441#1:1076\n441#1:1077,3\n445#1:1080,2\n468#1:1093,10\n468#1:1103\n468#1:1105\n468#1:1106\n533#1:1107\n533#1:1108,3\n439#1:1070\n468#1:1104\n456#1:1083,5\n466#1:1088,5\n*E\n"})
    static final /* data */ class CatalogEntry {

        @Nullable
        private final String background;

        @NotNull
        private final List<String> cast;

        @Nullable
        private final String description;

        @Nullable
        private final List<String> genre;

        @NotNull
        private final List<String> genres;

        @NotNull
        private final String id;

        @Nullable
        private final String imdbRating;

        @NotNull
        private final List<Link> links;

        @NotNull
        private final String name;

        @Nullable
        private final String poster;

        @NotNull
        private final List<TrailerStream> trailerStreams;

        @NotNull
        private final List<Trailer> trailersSources;

        @Nullable
        private final String type;

        @Nullable
        private final List<Video> videos;

        @Nullable
        private final String yearNum;

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final List<String> component10() {
            return this.genres;
        }

        @NotNull
        public final List<String> component11() {
            return this.cast;
        }

        @NotNull
        public final List<Trailer> component12() {
            return this.trailersSources;
        }

        @NotNull
        public final List<TrailerStream> component13() {
            return this.trailerStreams;
        }

        @Nullable
        /* JADX INFO: renamed from: component14, reason: from getter */
        public final String getYearNum() {
            return this.yearNum;
        }

        @NotNull
        public final List<Link> component15() {
            return this.links;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getBackground() {
            return this.background;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final List<Video> component8() {
            return this.videos;
        }

        @Nullable
        public final List<String> component9() {
            return this.genre;
        }

        @NotNull
        public final CatalogEntry copy(@JsonProperty("name") @NotNull String name, @JsonProperty("id") @NotNull String id, @JsonProperty("poster") @Nullable String poster, @JsonProperty("background") @Nullable String background, @JsonProperty("description") @Nullable String description, @JsonProperty("imdbRating") @Nullable String imdbRating, @JsonProperty("type") @Nullable String type, @JsonProperty("videos") @Nullable List<Video> videos, @JsonProperty("genre") @Nullable List<String> genre, @JsonProperty("genres") @NotNull List<String> genres, @JsonProperty("cast") @NotNull List<String> cast, @JsonProperty("trailers") @NotNull List<Trailer> trailersSources, @JsonProperty("trailerStreams") @NotNull List<TrailerStream> trailerStreams, @JsonProperty("year") @Nullable String yearNum, @JsonProperty("links") @NotNull List<Link> links) {
            return new CatalogEntry(name, id, poster, background, description, imdbRating, type, videos, genre, genres, cast, trailersSources, trailerStreams, yearNum, links);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CatalogEntry)) {
                return false;
            }
            CatalogEntry catalogEntry = (CatalogEntry) other;
            return Intrinsics.areEqual(this.name, catalogEntry.name) && Intrinsics.areEqual(this.id, catalogEntry.id) && Intrinsics.areEqual(this.poster, catalogEntry.poster) && Intrinsics.areEqual(this.background, catalogEntry.background) && Intrinsics.areEqual(this.description, catalogEntry.description) && Intrinsics.areEqual(this.imdbRating, catalogEntry.imdbRating) && Intrinsics.areEqual(this.type, catalogEntry.type) && Intrinsics.areEqual(this.videos, catalogEntry.videos) && Intrinsics.areEqual(this.genre, catalogEntry.genre) && Intrinsics.areEqual(this.genres, catalogEntry.genres) && Intrinsics.areEqual(this.cast, catalogEntry.cast) && Intrinsics.areEqual(this.trailersSources, catalogEntry.trailersSources) && Intrinsics.areEqual(this.trailerStreams, catalogEntry.trailerStreams) && Intrinsics.areEqual(this.yearNum, catalogEntry.yearNum) && Intrinsics.areEqual(this.links, catalogEntry.links);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((this.name.hashCode() * 31) + this.id.hashCode()) * 31) + (this.poster == null ? 0 : this.poster.hashCode())) * 31) + (this.background == null ? 0 : this.background.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.imdbRating == null ? 0 : this.imdbRating.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.videos == null ? 0 : this.videos.hashCode())) * 31) + (this.genre == null ? 0 : this.genre.hashCode())) * 31) + this.genres.hashCode()) * 31) + this.cast.hashCode()) * 31) + this.trailersSources.hashCode()) * 31) + this.trailerStreams.hashCode()) * 31) + (this.yearNum != null ? this.yearNum.hashCode() : 0)) * 31) + this.links.hashCode();
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("CatalogEntry(name=").append(this.name).append(", id=").append(this.id).append(", poster=").append(this.poster).append(", background=").append(this.background).append(", description=").append(this.description).append(", imdbRating=").append(this.imdbRating).append(", type=").append(this.type).append(", videos=").append(this.videos).append(", genre=").append(this.genre).append(", genres=").append(this.genres).append(", cast=").append(this.cast).append(", trailersSources=");
            sb.append(this.trailersSources).append(", trailerStreams=").append(this.trailerStreams).append(", yearNum=").append(this.yearNum).append(", links=").append(this.links).append(')');
            return sb.toString();
        }

        public CatalogEntry(@JsonProperty("name") @NotNull String name, @JsonProperty("id") @NotNull String id, @JsonProperty("poster") @Nullable String poster, @JsonProperty("background") @Nullable String background, @JsonProperty("description") @Nullable String description, @JsonProperty("imdbRating") @Nullable String imdbRating, @JsonProperty("type") @Nullable String type, @JsonProperty("videos") @Nullable List<Video> list, @JsonProperty("genre") @Nullable List<String> list2, @JsonProperty("genres") @NotNull List<String> list3, @JsonProperty("cast") @NotNull List<String> list4, @JsonProperty("trailers") @NotNull List<Trailer> list5, @JsonProperty("trailerStreams") @NotNull List<TrailerStream> list6, @JsonProperty("year") @Nullable String yearNum, @JsonProperty("links") @NotNull List<Link> list7) {
            this.name = name;
            this.id = id;
            this.poster = poster;
            this.background = background;
            this.description = description;
            this.imdbRating = imdbRating;
            this.type = type;
            this.videos = list;
            this.genre = list2;
            this.genres = list3;
            this.cast = list4;
            this.trailersSources = list5;
            this.trailerStreams = list6;
            this.yearNum = yearNum;
            this.links = list7;
        }

        public /* synthetic */ CatalogEntry(String str, String str2, String str3, String str4, String str5, String str6, String str7, List list, List list2, List list3, List list4, List list5, List list6, String str8, List list7, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, str5, str6, str7, list, list2, (i & 512) != 0 ? CollectionsKt.emptyList() : list3, (i & 1024) != 0 ? CollectionsKt.emptyList() : list4, (i & 2048) != 0 ? CollectionsKt.emptyList() : list5, (i & 4096) != 0 ? CollectionsKt.emptyList() : list6, (i & 8192) != 0 ? null : str8, (i & 16384) != 0 ? CollectionsKt.emptyList() : list7);
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getPoster() {
            return this.poster;
        }

        @Nullable
        public final String getBackground() {
            return this.background;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getImdbRating() {
            return this.imdbRating;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final List<Video> getVideos() {
            return this.videos;
        }

        @Nullable
        public final List<String> getGenre() {
            return this.genre;
        }

        @NotNull
        public final List<String> getGenres() {
            return this.genres;
        }

        @NotNull
        public final List<String> getCast() {
            return this.cast;
        }

        @NotNull
        public final List<Trailer> getTrailersSources() {
            return this.trailersSources;
        }

        @NotNull
        public final List<TrailerStream> getTrailerStreams() {
            return this.trailerStreams;
        }

        @Nullable
        public final String getYearNum() {
            return this.yearNum;
        }

        @NotNull
        public final List<Link> getLinks() {
            return this.links;
        }

        @NotNull
        public final SearchResponse toSearchResponse(@NotNull StremioC provider) {
            return MainAPIKt.newMovieSearchResponse$default(provider, this.name, AppUtils.INSTANCE.toJson(this), TvType.Others, false, new Function1() { // from class: com.phisher98.StremioC$CatalogEntry$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    return StremioC.CatalogEntry.toSearchResponse$lambda$0(this.f$0, (MovieSearchResponse) obj);
                }
            }, 8, (Object) null);
        }

        static final Unit toSearchResponse$lambda$0(CatalogEntry this$0, MovieSearchResponse $this$newMovieSearchResponse) {
            $this$newMovieSearchResponse.setPosterUrl(this$0.poster);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Code duplicated, block: B:102:0x02f9  */
        /* JADX WARN: Code duplicated, block: B:112:0x0392 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:113:0x0393  */
        /* JADX WARN: Code duplicated, block: B:127:0x03cd  */
        /* JADX WARN: Code duplicated, block: B:128:0x03cf A[Catch: Exception -> 0x0414, TryCatch #5 {Exception -> 0x0414, blocks: (B:125:0x03c9, B:128:0x03cf, B:130:0x03d5, B:138:0x03ee, B:141:0x03f6, B:134:0x03e0, B:136:0x03e6, B:124:0x03c4), top: B:287:0x03c4 }] */
        /* JADX WARN: Code duplicated, block: B:133:0x03de  */
        /* JADX WARN: Code duplicated, block: B:134:0x03e0 A[Catch: Exception -> 0x0414, TryCatch #5 {Exception -> 0x0414, blocks: (B:125:0x03c9, B:128:0x03cf, B:130:0x03d5, B:138:0x03ee, B:141:0x03f6, B:134:0x03e0, B:136:0x03e6, B:124:0x03c4), top: B:287:0x03c4 }] */
        /* JADX WARN: Code duplicated, block: B:139:0x03f3  */
        /* JADX WARN: Code duplicated, block: B:141:0x03f6 A[Catch: Exception -> 0x0414, TRY_LEAVE, TryCatch #5 {Exception -> 0x0414, blocks: (B:125:0x03c9, B:128:0x03cf, B:130:0x03d5, B:138:0x03ee, B:141:0x03f6, B:134:0x03e0, B:136:0x03e6, B:124:0x03c4), top: B:287:0x03c4 }] */
        /* JADX WARN: Code duplicated, block: B:154:0x0458  */
        /* JADX WARN: Code duplicated, block: B:155:0x046b  */
        /* JADX WARN: Code duplicated, block: B:159:0x048d A[Catch: Exception -> 0x070f, TRY_LEAVE, TryCatch #0 {Exception -> 0x070f, blocks: (B:157:0x0489, B:159:0x048d), top: B:277:0x0489 }] */
        /* JADX WARN: Code duplicated, block: B:166:0x0511 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:167:0x0512  */
        /* JADX WARN: Code duplicated, block: B:181:0x054d A[Catch: Exception -> 0x06b8, TryCatch #4 {Exception -> 0x06b8, blocks: (B:179:0x0549, B:181:0x054d, B:183:0x0553, B:185:0x0559, B:186:0x056f, B:188:0x0575, B:198:0x05af, B:178:0x0544), top: B:285:0x0544 }] */
        /* JADX WARN: Code duplicated, block: B:197:0x05ab A[PHI: r36
          0x05ab: PHI (r36v14 java.lang.String) = (r36v11 java.lang.String), (r36v12 java.lang.String), (r36v13 java.lang.String) binds: [B:189:0x0587, B:191:0x058d, B:193:0x0593] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:200:0x05b5  */
        /* JADX WARN: Code duplicated, block: B:204:0x05c5  */
        /* JADX WARN: Code duplicated, block: B:207:0x05cb  */
        /* JADX WARN: Code duplicated, block: B:210:0x05d7 A[Catch: Exception -> 0x06af, TRY_ENTER, TryCatch #1 {Exception -> 0x06af, blocks: (B:225:0x0682, B:210:0x05d7, B:212:0x05f3, B:215:0x05fc, B:219:0x0609, B:221:0x0667, B:223:0x066c, B:222:0x066a, B:211:0x05ef, B:227:0x0694, B:229:0x06a7), top: B:279:0x0682 }] */
        /* JADX WARN: Code duplicated, block: B:211:0x05ef A[Catch: Exception -> 0x06af, TryCatch #1 {Exception -> 0x06af, blocks: (B:225:0x0682, B:210:0x05d7, B:212:0x05f3, B:215:0x05fc, B:219:0x0609, B:221:0x0667, B:223:0x066c, B:222:0x066a, B:211:0x05ef, B:227:0x0694, B:229:0x06a7), top: B:279:0x0682 }] */
        /* JADX WARN: Code duplicated, block: B:214:0x05fb  */
        /* JADX WARN: Code duplicated, block: B:217:0x0602  */
        /* JADX WARN: Code duplicated, block: B:218:0x0607  */
        /* JADX WARN: Code duplicated, block: B:221:0x0667 A[Catch: Exception -> 0x06af, TryCatch #1 {Exception -> 0x06af, blocks: (B:225:0x0682, B:210:0x05d7, B:212:0x05f3, B:215:0x05fc, B:219:0x0609, B:221:0x0667, B:223:0x066c, B:222:0x066a, B:211:0x05ef, B:227:0x0694, B:229:0x06a7), top: B:279:0x0682 }] */
        /* JADX WARN: Code duplicated, block: B:222:0x066a A[Catch: Exception -> 0x06af, TryCatch #1 {Exception -> 0x06af, blocks: (B:225:0x0682, B:210:0x05d7, B:212:0x05f3, B:215:0x05fc, B:219:0x0609, B:221:0x0667, B:223:0x066c, B:222:0x066a, B:211:0x05ef, B:227:0x0694, B:229:0x06a7), top: B:279:0x0682 }] */
        /* JADX WARN: Code duplicated, block: B:228:0x06a2  */
        /* JADX WARN: Code duplicated, block: B:242:0x06f5  */
        /* JADX WARN: Code duplicated, block: B:252:0x0773  */
        /* JADX WARN: Code duplicated, block: B:256:0x077d  */
        /* JADX WARN: Code duplicated, block: B:259:0x0785  */
        /* JADX WARN: Code duplicated, block: B:261:0x07c5  */
        /* JADX WARN: Code duplicated, block: B:262:0x07cb  */
        /* JADX WARN: Code duplicated, block: B:265:0x0831 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:266:0x0832  */
        /* JADX WARN: Code duplicated, block: B:268:0x083e  */
        /* JADX WARN: Code duplicated, block: B:271:0x0899 A[LOOP:1: B:269:0x0893->B:271:0x0899, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:274:0x0907 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:275:0x0908  */
        /* JADX WARN: Code duplicated, block: B:297:0x0302 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:7:0x0018  */
        /* JADX WARN: Code duplicated, block: B:87:0x02c9  */
        /* JADX WARN: Code duplicated, block: B:89:0x02cc  */
        /* JADX WARN: Code duplicated, block: B:90:0x02ce  */
        /* JADX WARN: Code duplicated, block: B:94:0x02d5 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:95:0x02d7  */
        /* JADX WARN: Code duplicated, block: B:99:0x02e5  */
        @Nullable
        public final Object toLoadResponse(@NotNull StremioC provider, @Nullable String imdbId, @NotNull Continuation<? super LoadResponse> continuation) {
            StremioC$CatalogEntry$toLoadResponse$1 stremioC$CatalogEntry$toLoadResponse$1;
            Object element$iv;
            String it;
            String finalImdbId;
            Object obj;
            String imdbId2;
            String extractedImdbId;
            Ref.ObjectRef fetchedRecommendations;
            String extractedTmdbId;
            Ref.ObjectRef tmdbIdStr;
            List allTrailers;
            int i;
            String tmdbMediaType;
            String extractedImdbId2;
            String str;
            String extractedTmdbId2;
            String imdbId3;
            Ref.ObjectRef fetchedRecommendations2;
            String finalImdbId2;
            Ref.ObjectRef tmdbIdStr2;
            List allTrailers2;
            String tmdbMediaType2;
            String str2;
            String extractedTmdbId3;
            boolean z;
            String finalImdbId3;
            int i2;
            String tmdbMediaType3;
            String extractedTmdbId4;
            Object obj2;
            int i3;
            String extractedImdbId3;
            String url;
            StremioC provider2;
            String finalImdbId4;
            String imdbId4;
            Ref.ObjectRef tmdbIdStr3;
            Ref.ObjectRef fetchedRecommendations3;
            List allTrailers3;
            String tmdbMediaType4;
            StremioC$CatalogEntry$toLoadResponse$1 stremioC$CatalogEntry$toLoadResponse$2;
            String finalImdbId5;
            Object obj3;
            Ref.ObjectRef fetchedRecommendations4;
            String tmdbMediaType5;
            StremioC provider3;
            Object safe;
            TmdbFindResponse findRes;
            List<TmdbFindResult> tv_results;
            TmdbFindResult tmdbFindResult;
            Integer tmdbId;
            List<TmdbFindResult> movie_results;
            List<Video> list;
            boolean z2;
            Object obj4;
            StremioC provider4;
            Iterable $this$map$iv;
            int $i$f$map;
            Collection destination$iv$iv;
            Object objNewTvSeriesLoadResponse;
            String str3;
            Integer intOrNull;
            Object obj5;
            Object safe2;
            TmdbDetailResponse detailRes;
            ArrayList arrayList;
            TmdbRecommendations recommendations;
            Iterable results;
            Iterable $this$mapNotNull$iv;
            int $i$f$mapNotNull;
            String str4;
            MovieSearchResponse movieSearchResponseNewMovieSearchResponse$default;
            String posterPath;
            boolean z3;
            String posterPath2;
            String rawMediaType;
            String stremioType;
            TvType tvType;
            if (continuation instanceof StremioC$CatalogEntry$toLoadResponse$1) {
                stremioC$CatalogEntry$toLoadResponse$1 = (StremioC$CatalogEntry$toLoadResponse$1) continuation;
                if ((stremioC$CatalogEntry$toLoadResponse$1.label & Integer.MIN_VALUE) != 0) {
                    stremioC$CatalogEntry$toLoadResponse$1.label -= Integer.MIN_VALUE;
                } else {
                    stremioC$CatalogEntry$toLoadResponse$1 = new StremioC$CatalogEntry$toLoadResponse$1(this, continuation);
                }
            } else {
                stremioC$CatalogEntry$toLoadResponse$1 = new StremioC$CatalogEntry$toLoadResponse$1(this, continuation);
            }
            StremioC$CatalogEntry$toLoadResponse$1 stremioC$CatalogEntry$toLoadResponse$3 = stremioC$CatalogEntry$toLoadResponse$1;
            Object $result = stremioC$CatalogEntry$toLoadResponse$3.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            String str5 = "tv";
            String str6 = "movie";
            switch (stremioC$CatalogEntry$toLoadResponse$3.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Iterable $this$mapNotNull$iv2 = this.trailersSources;
                    Collection destination$iv$iv2 = new ArrayList();
                    for (Object element$iv$iv$iv : $this$mapNotNull$iv2) {
                        Trailer it2 = (Trailer) element$iv$iv$iv;
                        String source = it2.getSource();
                        if (source != null) {
                            destination$iv$iv2.add(source);
                        }
                        $this$mapNotNull$iv2 = $this$mapNotNull$iv2;
                    }
                    ArrayList arrayList2 = (List) destination$iv$iv2;
                    Iterable $this$mapNotNull$iv3 = this.trailerStreams;
                    Collection destination$iv$iv3 = new ArrayList();
                    for (Object element$iv$iv$iv2 : $this$mapNotNull$iv3) {
                        TrailerStream it3 = (TrailerStream) element$iv$iv$iv2;
                        String ytId = it3.getYtId();
                        if (ytId != null) {
                            destination$iv$iv3.add(ytId);
                        }
                        $result = $result;
                    }
                    Iterable $this$map$iv2 = CollectionsKt.distinct(CollectionsKt.plus(arrayList2, (List) destination$iv$iv3));
                    int $i$f$map2 = 0;
                    Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    for (Object item$iv$iv : $this$map$iv2) {
                        String it4 = (String) item$iv$iv;
                        destination$iv$iv4.add("https://www.youtube.com/watch?v=" + it4);
                        $this$map$iv2 = $this$map$iv2;
                        $i$f$map2 = $i$f$map2;
                    }
                    List allTrailers4 = (List) destination$iv$iv4;
                    Ref.ObjectRef fetchedRecommendations5 = new Ref.ObjectRef();
                    Iterable $this$firstOrNull$iv = this.links;
                    Iterator it5 = $this$firstOrNull$iv.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            element$iv = it5.next();
                            Link it6 = (Link) element$iv;
                            Iterable $this$firstOrNull$iv2 = $this$firstOrNull$iv;
                            if (!Intrinsics.areEqual(it6.getCategory(), "imdb")) {
                                $this$firstOrNull$iv = $this$firstOrNull$iv2;
                            }
                        } else {
                            element$iv = null;
                        }
                    }
                    Link link = (Link) element$iv;
                    if (link == null || (url = link.getUrl()) == null || (it = StringsKt.substringAfterLast$default(url, "/", (String) null, 2, (Object) null)) == null || !StringsKt.startsWith$default(it, "tt", false, 2, (Object) null)) {
                        it = null;
                    }
                    String extractedTmdbId5 = StringsKt.startsWith$default(this.id, "tmdb:", false, 2, (Object) null) ? StringsKt.removePrefix(this.id, "tmdb:") : null;
                    finalImdbId = it == null ? StringsKt.startsWith$default(this.id, "tt", false, 2, (Object) null) ? this.id : imdbId : it;
                    Ref.ObjectRef tmdbIdStr4 = new Ref.ObjectRef();
                    tmdbIdStr4.element = extractedTmdbId5;
                    try {
                        if (Intrinsics.areEqual(this.type, "movie")) {
                            i = 1;
                            if (i != 0) {
                                tmdbMediaType = "movie";
                            } else {
                                tmdbMediaType = "tv";
                            }
                            extractedImdbId2 = it;
                            if (tmdbIdStr4.element == null) {
                                if (finalImdbId != null) {
                                    str2 = "tmdb:";
                                    extractedTmdbId3 = extractedTmdbId5;
                                    if (StringsKt.startsWith$default(finalImdbId, "tt", false, 2, (Object) null)) {
                                    }
                                    if (z) {
                                        String findUrl = "https://api.themoviedb.org/3/find/" + finalImdbId + "?api_key=98ae14df2b8d8f8f8136499daf79f0e0&external_source=imdb_id";
                                        Requests app = MainActivityKt.getApp();
                                        provider = provider;
                                        stremioC$CatalogEntry$toLoadResponse$3.L$0 = provider;
                                        stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$2 = allTrailers4;
                                        stremioC$CatalogEntry$toLoadResponse$3.L$3 = fetchedRecommendations5;
                                        stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId3);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$6 = finalImdbId;
                                        stremioC$CatalogEntry$toLoadResponse$3.L$7 = tmdbIdStr4;
                                        stremioC$CatalogEntry$toLoadResponse$3.L$8 = tmdbMediaType;
                                        stremioC$CatalogEntry$toLoadResponse$3.L$9 = SpillingKt.nullOutSpilledVariable(findUrl);
                                        stremioC$CatalogEntry$toLoadResponse$3.I$0 = i;
                                        stremioC$CatalogEntry$toLoadResponse$3.label = 1;
                                        finalImdbId3 = finalImdbId;
                                        i2 = i;
                                        tmdbMediaType3 = tmdbMediaType;
                                        extractedTmdbId4 = extractedTmdbId3;
                                        str = str2;
                                        str6 = "movie";
                                        obj2 = Requests.get$default(app, findUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, stremioC$CatalogEntry$toLoadResponse$3, 4094, (Object) null);
                                        stremioC$CatalogEntry$toLoadResponse$3 = stremioC$CatalogEntry$toLoadResponse$3;
                                        if (obj2 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        imdbId2 = imdbId;
                                        i3 = i2;
                                        extractedImdbId3 = extractedImdbId2;
                                        fetchedRecommendations = fetchedRecommendations5;
                                        extractedTmdbId = extractedTmdbId4;
                                        finalImdbId = finalImdbId3;
                                        tmdbIdStr = tmdbIdStr4;
                                        allTrailers = allTrailers4;
                                        NiceResponse this_$iv = (NiceResponse) obj2;
                                        ResponseParser parser = this_$iv.getParser();
                                        Intrinsics.checkNotNull(parser);
                                        provider3 = provider;
                                        safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(TmdbFindResponse.class));
                                        findRes = (TmdbFindResponse) safe;
                                        if (i3 != 0) {
                                            if (findRes != null) {
                                            }
                                            tmdbId = null;
                                        } else {
                                            if (findRes != null) {
                                            }
                                            tmdbId = null;
                                        }
                                        if (tmdbId != null) {
                                            tmdbIdStr.element = String.valueOf(tmdbId.intValue());
                                        }
                                        provider = provider3;
                                        finalImdbId2 = finalImdbId;
                                        extractedImdbId2 = extractedImdbId3;
                                        tmdbIdStr2 = tmdbIdStr;
                                        extractedTmdbId2 = extractedTmdbId;
                                        i = i3;
                                        fetchedRecommendations2 = fetchedRecommendations;
                                        allTrailers2 = allTrailers;
                                        imdbId3 = imdbId2;
                                        tmdbMediaType2 = tmdbMediaType3;
                                        if (tmdbIdStr2.element != null) {
                                            String detailUrl = "https://api.themoviedb.org/3/" + tmdbMediaType2 + '/' + ((String) tmdbIdStr2.element) + "?api_key=98ae14df2b8d8f8f8136499daf79f0e0&append_to_response=recommendations";
                                            Requests app2 = MainActivityKt.getApp();
                                            stremioC$CatalogEntry$toLoadResponse$3.L$0 = provider;
                                            imdbId4 = imdbId3;
                                            stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId4);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$2 = allTrailers2;
                                            stremioC$CatalogEntry$toLoadResponse$3.L$3 = fetchedRecommendations2;
                                            stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId2);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$6 = finalImdbId2;
                                            stremioC$CatalogEntry$toLoadResponse$3.L$7 = tmdbIdStr2;
                                            stremioC$CatalogEntry$toLoadResponse$3.L$8 = tmdbMediaType2;
                                            stremioC$CatalogEntry$toLoadResponse$3.L$9 = SpillingKt.nullOutSpilledVariable(detailUrl);
                                            stremioC$CatalogEntry$toLoadResponse$3.I$0 = i;
                                            stremioC$CatalogEntry$toLoadResponse$3.label = 2;
                                            tmdbIdStr3 = tmdbIdStr2;
                                            fetchedRecommendations3 = fetchedRecommendations2;
                                            allTrailers3 = allTrailers2;
                                            tmdbMediaType4 = tmdbMediaType2;
                                            stremioC$CatalogEntry$toLoadResponse$2 = stremioC$CatalogEntry$toLoadResponse$3;
                                            finalImdbId5 = finalImdbId2;
                                            obj3 = Requests.get$default(app2, detailUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, stremioC$CatalogEntry$toLoadResponse$2, 4094, (Object) null);
                                            stremioC$CatalogEntry$toLoadResponse$3 = stremioC$CatalogEntry$toLoadResponse$2;
                                            if (obj3 == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            imdbId2 = imdbId4;
                                            fetchedRecommendations4 = fetchedRecommendations3;
                                            tmdbMediaType5 = tmdbMediaType4;
                                            extractedTmdbId = extractedTmdbId2;
                                            finalImdbId = finalImdbId5;
                                            tmdbIdStr = tmdbIdStr3;
                                            allTrailers = allTrailers3;
                                            NiceResponse this_$iv2 = (NiceResponse) obj3;
                                            ResponseParser parser2 = this_$iv2.getParser();
                                            Intrinsics.checkNotNull(parser2);
                                            obj = coroutine_suspended;
                                            safe2 = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(TmdbDetailResponse.class));
                                            detailRes = (TmdbDetailResponse) safe2;
                                            if (detailRes != null) {
                                                provider2 = provider;
                                                arrayList = null;
                                                fetchedRecommendations4.element = arrayList;
                                                finalImdbId4 = finalImdbId;
                                                allTrailers2 = allTrailers;
                                                fetchedRecommendations2 = fetchedRecommendations4;
                                            } else {
                                                provider2 = provider;
                                                arrayList = null;
                                                fetchedRecommendations4.element = arrayList;
                                                finalImdbId4 = finalImdbId;
                                                allTrailers2 = allTrailers;
                                                fetchedRecommendations2 = fetchedRecommendations4;
                                            }
                                        } else {
                                            obj = coroutine_suspended;
                                            imdbId2 = imdbId3;
                                            provider2 = provider;
                                            extractedTmdbId = extractedTmdbId2;
                                            finalImdbId4 = finalImdbId2;
                                            tmdbIdStr = tmdbIdStr2;
                                        }
                                        list = this.videos;
                                        if (list != null) {
                                            z2 = true;
                                        } else {
                                            z2 = true;
                                        }
                                        if (z2) {
                                            Ref.ObjectRef fetchedRecommendations6 = fetchedRecommendations2;
                                            List allTrailers5 = allTrailers2;
                                            Ref.ObjectRef tmdbIdStr5 = tmdbIdStr;
                                            obj4 = obj;
                                            provider4 = provider2;
                                            StremioC stremioC = provider4;
                                            String str7 = this.name;
                                            String str8 = provider4.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                            TvType tvType2 = TvType.TvSeries;
                                            $this$map$iv = this.videos;
                                            $i$f$map = 0;
                                            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                            for (Object item$iv$iv2 : $this$map$iv) {
                                                Iterable $this$map$iv3 = $this$map$iv;
                                                Video it7 = (Video) item$iv$iv2;
                                                destination$iv$iv.add(it7.toEpisode(provider4, this.type, finalImdbId4));
                                                $this$map$iv = $this$map$iv3;
                                                $i$f$map = $i$f$map;
                                            }
                                            StremioC$CatalogEntry$toLoadResponse$6 stremioC$CatalogEntry$toLoadResponse$6 = new StremioC$CatalogEntry$toLoadResponse$6(this, allTrailers5, fetchedRecommendations6, tmdbIdStr5, finalImdbId4, null);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider4);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers5);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations6);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId4);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr5);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                            stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                            stremioC$CatalogEntry$toLoadResponse$3.label = 4;
                                            objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(stremioC, str7, str8, tvType2, (List) destination$iv$iv, stremioC$CatalogEntry$toLoadResponse$6, stremioC$CatalogEntry$toLoadResponse$3);
                                            if (objNewTvSeriesLoadResponse == obj4) {
                                                return obj4;
                                            }
                                            return objNewTvSeriesLoadResponse;
                                        }
                                        StremioC stremioC2 = provider2;
                                        String str9 = this.name;
                                        String str10 = provider2.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                        Ref.ObjectRef fetchedRecommendations7 = fetchedRecommendations2;
                                        TvType tvType3 = TvType.Movie;
                                        String str11 = this.type;
                                        String str12 = this.id;
                                        str3 = this.yearNum;
                                        if (str3 != null) {
                                            intOrNull = StringsKt.toIntOrNull(str3);
                                        } else {
                                            intOrNull = null;
                                        }
                                        String finalImdbId6 = finalImdbId4;
                                        LoadData loadData = new LoadData(str11, str12, null, null, finalImdbId6, intOrNull, 12, null);
                                        List allTrailers6 = allTrailers2;
                                        Ref.ObjectRef tmdbIdStr6 = tmdbIdStr;
                                        StremioC$CatalogEntry$toLoadResponse$4 stremioC$CatalogEntry$toLoadResponse$4 = new StremioC$CatalogEntry$toLoadResponse$4(this, allTrailers6, fetchedRecommendations7, tmdbIdStr6, finalImdbId6, null);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider2);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers6);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations7);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId6);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr6);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                        stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                        stremioC$CatalogEntry$toLoadResponse$3.label = 3;
                                        obj5 = obj;
                                        $result = MainAPIKt.newMovieLoadResponse(stremioC2, str9, str10, tvType3, loadData, stremioC$CatalogEntry$toLoadResponse$4, stremioC$CatalogEntry$toLoadResponse$3);
                                        if ($result == obj5) {
                                            return obj5;
                                        }
                                    } else {
                                        str = str2;
                                        extractedTmdbId2 = extractedTmdbId3;
                                    }
                                    extractedImdbId2 = extractedImdbId;
                                    provider2 = provider;
                                    finalImdbId4 = finalImdbId;
                                    fetchedRecommendations2 = fetchedRecommendations;
                                    allTrailers2 = allTrailers;
                                    list = this.videos;
                                    if (list != null) {
                                        z2 = true;
                                    } else {
                                        z2 = true;
                                    }
                                    if (z2) {
                                        Ref.ObjectRef fetchedRecommendations8 = fetchedRecommendations2;
                                        List allTrailers7 = allTrailers2;
                                        Ref.ObjectRef tmdbIdStr7 = tmdbIdStr;
                                        obj4 = obj;
                                        provider4 = provider2;
                                        StremioC stremioC3 = provider4;
                                        String str13 = this.name;
                                        String str14 = provider4.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                        TvType tvType4 = TvType.TvSeries;
                                        $this$map$iv = this.videos;
                                        $i$f$map = 0;
                                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                        while (r17.hasNext()) {
                                            Iterable $this$map$iv4 = $this$map$iv;
                                            Video it8 = (Video) item$iv$iv2;
                                            destination$iv$iv.add(it8.toEpisode(provider4, this.type, finalImdbId4));
                                            $this$map$iv = $this$map$iv4;
                                            $i$f$map = $i$f$map;
                                        }
                                        StremioC$CatalogEntry$toLoadResponse$6 stremioC$CatalogEntry$toLoadResponse$7 = new StremioC$CatalogEntry$toLoadResponse$6(this, allTrailers7, fetchedRecommendations8, tmdbIdStr7, finalImdbId4, null);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider4);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers7);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations8);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId4);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr7);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                        stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                        stremioC$CatalogEntry$toLoadResponse$3.label = 4;
                                        objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(stremioC3, str13, str14, tvType4, (List) destination$iv$iv, stremioC$CatalogEntry$toLoadResponse$7, stremioC$CatalogEntry$toLoadResponse$3);
                                        if (objNewTvSeriesLoadResponse == obj4) {
                                            return obj4;
                                        }
                                        return objNewTvSeriesLoadResponse;
                                    }
                                    StremioC stremioC4 = provider2;
                                    String str15 = this.name;
                                    String str16 = provider2.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                    Ref.ObjectRef fetchedRecommendations9 = fetchedRecommendations2;
                                    TvType tvType5 = TvType.Movie;
                                    String str17 = this.type;
                                    String str18 = this.id;
                                    str3 = this.yearNum;
                                    if (str3 != null) {
                                        intOrNull = StringsKt.toIntOrNull(str3);
                                    } else {
                                        intOrNull = null;
                                    }
                                    String finalImdbId7 = finalImdbId4;
                                    LoadData loadData2 = new LoadData(str17, str18, null, null, finalImdbId7, intOrNull, 12, null);
                                    List allTrailers8 = allTrailers2;
                                    Ref.ObjectRef tmdbIdStr8 = tmdbIdStr;
                                    StremioC$CatalogEntry$toLoadResponse$4 stremioC$CatalogEntry$toLoadResponse$5 = new StremioC$CatalogEntry$toLoadResponse$4(this, allTrailers8, fetchedRecommendations9, tmdbIdStr8, finalImdbId7, null);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider2);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers8);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations9);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId7);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr8);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                    stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                    stremioC$CatalogEntry$toLoadResponse$3.label = 3;
                                    obj5 = obj;
                                    $result = MainAPIKt.newMovieLoadResponse(stremioC4, str15, str16, tvType5, loadData2, stremioC$CatalogEntry$toLoadResponse$5, stremioC$CatalogEntry$toLoadResponse$3);
                                    if ($result == obj5) {
                                        return obj5;
                                    }
                                } else {
                                    str2 = "tmdb:";
                                    extractedTmdbId3 = extractedTmdbId5;
                                }
                                if (z) {
                                    String findUrl2 = "https://api.themoviedb.org/3/find/" + finalImdbId + "?api_key=98ae14df2b8d8f8f8136499daf79f0e0&external_source=imdb_id";
                                    Requests app3 = MainActivityKt.getApp();
                                    provider = provider;
                                    stremioC$CatalogEntry$toLoadResponse$3.L$0 = provider;
                                    stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$2 = allTrailers4;
                                    stremioC$CatalogEntry$toLoadResponse$3.L$3 = fetchedRecommendations5;
                                    stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId3);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$6 = finalImdbId;
                                    stremioC$CatalogEntry$toLoadResponse$3.L$7 = tmdbIdStr4;
                                    stremioC$CatalogEntry$toLoadResponse$3.L$8 = tmdbMediaType;
                                    stremioC$CatalogEntry$toLoadResponse$3.L$9 = SpillingKt.nullOutSpilledVariable(findUrl2);
                                    stremioC$CatalogEntry$toLoadResponse$3.I$0 = i;
                                    stremioC$CatalogEntry$toLoadResponse$3.label = 1;
                                    finalImdbId3 = finalImdbId;
                                    i2 = i;
                                    tmdbMediaType3 = tmdbMediaType;
                                    extractedTmdbId4 = extractedTmdbId3;
                                    str = str2;
                                    str6 = "movie";
                                    obj2 = Requests.get$default(app3, findUrl2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, stremioC$CatalogEntry$toLoadResponse$3, 4094, (Object) null);
                                    stremioC$CatalogEntry$toLoadResponse$3 = stremioC$CatalogEntry$toLoadResponse$3;
                                    if (obj2 == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    imdbId2 = imdbId;
                                    i3 = i2;
                                    extractedImdbId3 = extractedImdbId2;
                                    fetchedRecommendations = fetchedRecommendations5;
                                    extractedTmdbId = extractedTmdbId4;
                                    finalImdbId = finalImdbId3;
                                    tmdbIdStr = tmdbIdStr4;
                                    allTrailers = allTrailers4;
                                    NiceResponse this_$iv3 = (NiceResponse) obj2;
                                    ResponseParser parser3 = this_$iv3.getParser();
                                    Intrinsics.checkNotNull(parser3);
                                    provider3 = provider;
                                    safe = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(TmdbFindResponse.class));
                                    findRes = (TmdbFindResponse) safe;
                                    if (i3 != 0) {
                                        if (findRes != null) {
                                        }
                                        tmdbId = null;
                                    } else {
                                        if (findRes != null) {
                                        }
                                        tmdbId = null;
                                    }
                                    if (tmdbId != null) {
                                        tmdbIdStr.element = String.valueOf(tmdbId.intValue());
                                    }
                                    provider = provider3;
                                    finalImdbId2 = finalImdbId;
                                    extractedImdbId2 = extractedImdbId3;
                                    tmdbIdStr2 = tmdbIdStr;
                                    extractedTmdbId2 = extractedTmdbId;
                                    i = i3;
                                    fetchedRecommendations2 = fetchedRecommendations;
                                    allTrailers2 = allTrailers;
                                    imdbId3 = imdbId2;
                                    tmdbMediaType2 = tmdbMediaType3;
                                    if (tmdbIdStr2.element != null) {
                                        String detailUrl2 = "https://api.themoviedb.org/3/" + tmdbMediaType2 + '/' + ((String) tmdbIdStr2.element) + "?api_key=98ae14df2b8d8f8f8136499daf79f0e0&append_to_response=recommendations";
                                        Requests app4 = MainActivityKt.getApp();
                                        stremioC$CatalogEntry$toLoadResponse$3.L$0 = provider;
                                        imdbId4 = imdbId3;
                                        stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId4);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$2 = allTrailers2;
                                        stremioC$CatalogEntry$toLoadResponse$3.L$3 = fetchedRecommendations2;
                                        stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId2);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$6 = finalImdbId2;
                                        stremioC$CatalogEntry$toLoadResponse$3.L$7 = tmdbIdStr2;
                                        stremioC$CatalogEntry$toLoadResponse$3.L$8 = tmdbMediaType2;
                                        stremioC$CatalogEntry$toLoadResponse$3.L$9 = SpillingKt.nullOutSpilledVariable(detailUrl2);
                                        stremioC$CatalogEntry$toLoadResponse$3.I$0 = i;
                                        stremioC$CatalogEntry$toLoadResponse$3.label = 2;
                                        tmdbIdStr3 = tmdbIdStr2;
                                        fetchedRecommendations3 = fetchedRecommendations2;
                                        allTrailers3 = allTrailers2;
                                        tmdbMediaType4 = tmdbMediaType2;
                                        stremioC$CatalogEntry$toLoadResponse$2 = stremioC$CatalogEntry$toLoadResponse$3;
                                        finalImdbId5 = finalImdbId2;
                                        obj3 = Requests.get$default(app4, detailUrl2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, stremioC$CatalogEntry$toLoadResponse$2, 4094, (Object) null);
                                        stremioC$CatalogEntry$toLoadResponse$3 = stremioC$CatalogEntry$toLoadResponse$2;
                                        if (obj3 == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        imdbId2 = imdbId4;
                                        fetchedRecommendations4 = fetchedRecommendations3;
                                        tmdbMediaType5 = tmdbMediaType4;
                                        extractedTmdbId = extractedTmdbId2;
                                        finalImdbId = finalImdbId5;
                                        tmdbIdStr = tmdbIdStr3;
                                        allTrailers = allTrailers3;
                                        NiceResponse this_$iv4 = (NiceResponse) obj3;
                                        ResponseParser parser4 = this_$iv4.getParser();
                                        Intrinsics.checkNotNull(parser4);
                                        obj = coroutine_suspended;
                                        safe2 = parser4.parseSafe(this_$iv4.getText(), Reflection.getOrCreateKotlinClass(TmdbDetailResponse.class));
                                        detailRes = (TmdbDetailResponse) safe2;
                                        if (detailRes != null) {
                                            provider2 = provider;
                                            arrayList = null;
                                            fetchedRecommendations4.element = arrayList;
                                            finalImdbId4 = finalImdbId;
                                            allTrailers2 = allTrailers;
                                            fetchedRecommendations2 = fetchedRecommendations4;
                                        } else {
                                            provider2 = provider;
                                            arrayList = null;
                                            fetchedRecommendations4.element = arrayList;
                                            finalImdbId4 = finalImdbId;
                                            allTrailers2 = allTrailers;
                                            fetchedRecommendations2 = fetchedRecommendations4;
                                        }
                                    } else {
                                        obj = coroutine_suspended;
                                        imdbId2 = imdbId3;
                                        provider2 = provider;
                                        extractedTmdbId = extractedTmdbId2;
                                        finalImdbId4 = finalImdbId2;
                                        tmdbIdStr = tmdbIdStr2;
                                    }
                                    list = this.videos;
                                    if (list != null) {
                                        z2 = true;
                                    } else {
                                        z2 = true;
                                    }
                                    if (z2) {
                                        Ref.ObjectRef fetchedRecommendations10 = fetchedRecommendations2;
                                        List allTrailers9 = allTrailers2;
                                        Ref.ObjectRef tmdbIdStr9 = tmdbIdStr;
                                        obj4 = obj;
                                        provider4 = provider2;
                                        StremioC stremioC5 = provider4;
                                        String str19 = this.name;
                                        String str110 = provider4.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                        TvType tvType6 = TvType.TvSeries;
                                        $this$map$iv = this.videos;
                                        $i$f$map = 0;
                                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                        while (r17.hasNext()) {
                                            Iterable $this$map$iv5 = $this$map$iv;
                                            Video it9 = (Video) item$iv$iv2;
                                            destination$iv$iv.add(it9.toEpisode(provider4, this.type, finalImdbId4));
                                            $this$map$iv = $this$map$iv5;
                                            $i$f$map = $i$f$map;
                                        }
                                        StremioC$CatalogEntry$toLoadResponse$6 stremioC$CatalogEntry$toLoadResponse$8 = new StremioC$CatalogEntry$toLoadResponse$6(this, allTrailers9, fetchedRecommendations10, tmdbIdStr9, finalImdbId4, null);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider4);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers9);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations10);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId4);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr9);
                                        stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                        stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                        stremioC$CatalogEntry$toLoadResponse$3.label = 4;
                                        objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(stremioC5, str19, str110, tvType6, (List) destination$iv$iv, stremioC$CatalogEntry$toLoadResponse$8, stremioC$CatalogEntry$toLoadResponse$3);
                                        if (objNewTvSeriesLoadResponse == obj4) {
                                            return obj4;
                                        }
                                        return objNewTvSeriesLoadResponse;
                                    }
                                    StremioC stremioC6 = provider2;
                                    String str111 = this.name;
                                    String str112 = provider2.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                    Ref.ObjectRef fetchedRecommendations11 = fetchedRecommendations2;
                                    TvType tvType7 = TvType.Movie;
                                    String str113 = this.type;
                                    String str114 = this.id;
                                    str3 = this.yearNum;
                                    if (str3 != null) {
                                        intOrNull = StringsKt.toIntOrNull(str3);
                                    } else {
                                        intOrNull = null;
                                    }
                                    String finalImdbId8 = finalImdbId4;
                                    LoadData loadData3 = new LoadData(str113, str114, null, null, finalImdbId8, intOrNull, 12, null);
                                    List allTrailers10 = allTrailers2;
                                    Ref.ObjectRef tmdbIdStr10 = tmdbIdStr;
                                    StremioC$CatalogEntry$toLoadResponse$4 stremioC$CatalogEntry$toLoadResponse$9 = new StremioC$CatalogEntry$toLoadResponse$4(this, allTrailers10, fetchedRecommendations11, tmdbIdStr10, finalImdbId8, null);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider2);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers10);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations11);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId8);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr10);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                    stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                    stremioC$CatalogEntry$toLoadResponse$3.label = 3;
                                    obj5 = obj;
                                    $result = MainAPIKt.newMovieLoadResponse(stremioC6, str111, str112, tvType7, loadData3, stremioC$CatalogEntry$toLoadResponse$9, stremioC$CatalogEntry$toLoadResponse$3);
                                    if ($result == obj5) {
                                        return obj5;
                                    }
                                } else {
                                    str = str2;
                                    extractedTmdbId2 = extractedTmdbId3;
                                }
                                extractedImdbId2 = extractedImdbId;
                                provider2 = provider;
                                finalImdbId4 = finalImdbId;
                                fetchedRecommendations2 = fetchedRecommendations;
                                allTrailers2 = allTrailers;
                                list = this.videos;
                                if (list != null) {
                                    z2 = true;
                                } else {
                                    z2 = true;
                                }
                                if (z2) {
                                    Ref.ObjectRef fetchedRecommendations12 = fetchedRecommendations2;
                                    List allTrailers11 = allTrailers2;
                                    Ref.ObjectRef tmdbIdStr11 = tmdbIdStr;
                                    obj4 = obj;
                                    provider4 = provider2;
                                    StremioC stremioC7 = provider4;
                                    String str115 = this.name;
                                    String str116 = provider4.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                    TvType tvType8 = TvType.TvSeries;
                                    $this$map$iv = this.videos;
                                    $i$f$map = 0;
                                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                    while (r17.hasNext()) {
                                        Iterable $this$map$iv6 = $this$map$iv;
                                        Video it10 = (Video) item$iv$iv2;
                                        destination$iv$iv.add(it10.toEpisode(provider4, this.type, finalImdbId4));
                                        $this$map$iv = $this$map$iv6;
                                        $i$f$map = $i$f$map;
                                    }
                                    StremioC$CatalogEntry$toLoadResponse$6 stremioC$CatalogEntry$toLoadResponse$10 = new StremioC$CatalogEntry$toLoadResponse$6(this, allTrailers11, fetchedRecommendations12, tmdbIdStr11, finalImdbId4, null);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider4);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers11);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations12);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId4);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr11);
                                    stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                    stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                    stremioC$CatalogEntry$toLoadResponse$3.label = 4;
                                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(stremioC7, str115, str116, tvType8, (List) destination$iv$iv, stremioC$CatalogEntry$toLoadResponse$10, stremioC$CatalogEntry$toLoadResponse$3);
                                    if (objNewTvSeriesLoadResponse == obj4) {
                                        return obj4;
                                    }
                                    return objNewTvSeriesLoadResponse;
                                }
                                StremioC stremioC8 = provider2;
                                String str117 = this.name;
                                String str118 = provider2.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                Ref.ObjectRef fetchedRecommendations13 = fetchedRecommendations2;
                                TvType tvType9 = TvType.Movie;
                                String str119 = this.type;
                                String str1110 = this.id;
                                str3 = this.yearNum;
                                if (str3 != null) {
                                    intOrNull = StringsKt.toIntOrNull(str3);
                                } else {
                                    intOrNull = null;
                                }
                                String finalImdbId9 = finalImdbId4;
                                LoadData loadData4 = new LoadData(str119, str1110, null, null, finalImdbId9, intOrNull, 12, null);
                                List allTrailers12 = allTrailers2;
                                Ref.ObjectRef tmdbIdStr12 = tmdbIdStr;
                                StremioC$CatalogEntry$toLoadResponse$4 stremioC$CatalogEntry$toLoadResponse$11 = new StremioC$CatalogEntry$toLoadResponse$4(this, allTrailers12, fetchedRecommendations13, tmdbIdStr12, finalImdbId9, null);
                                stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider2);
                                stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers12);
                                stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations13);
                                stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId9);
                                stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr12);
                                stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                stremioC$CatalogEntry$toLoadResponse$3.label = 3;
                                obj5 = obj;
                                $result = MainAPIKt.newMovieLoadResponse(stremioC8, str117, str118, tvType9, loadData4, stremioC$CatalogEntry$toLoadResponse$11, stremioC$CatalogEntry$toLoadResponse$3);
                                if ($result == obj5) {
                                    return obj5;
                                }
                            } else {
                                str = "tmdb:";
                                extractedTmdbId2 = extractedTmdbId5;
                            }
                            imdbId3 = imdbId;
                            fetchedRecommendations2 = fetchedRecommendations5;
                            finalImdbId2 = finalImdbId;
                            tmdbIdStr2 = tmdbIdStr4;
                            allTrailers2 = allTrailers4;
                            tmdbMediaType2 = tmdbMediaType;
                            if (tmdbIdStr2.element != null) {
                                String detailUrl3 = "https://api.themoviedb.org/3/" + tmdbMediaType2 + '/' + ((String) tmdbIdStr2.element) + "?api_key=98ae14df2b8d8f8f8136499daf79f0e0&append_to_response=recommendations";
                                Requests app5 = MainActivityKt.getApp();
                                stremioC$CatalogEntry$toLoadResponse$3.L$0 = provider;
                                imdbId4 = imdbId3;
                                stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId4);
                                stremioC$CatalogEntry$toLoadResponse$3.L$2 = allTrailers2;
                                stremioC$CatalogEntry$toLoadResponse$3.L$3 = fetchedRecommendations2;
                                stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId2);
                                stremioC$CatalogEntry$toLoadResponse$3.L$6 = finalImdbId2;
                                stremioC$CatalogEntry$toLoadResponse$3.L$7 = tmdbIdStr2;
                                stremioC$CatalogEntry$toLoadResponse$3.L$8 = tmdbMediaType2;
                                stremioC$CatalogEntry$toLoadResponse$3.L$9 = SpillingKt.nullOutSpilledVariable(detailUrl3);
                                stremioC$CatalogEntry$toLoadResponse$3.I$0 = i;
                                stremioC$CatalogEntry$toLoadResponse$3.label = 2;
                                tmdbIdStr3 = tmdbIdStr2;
                                fetchedRecommendations3 = fetchedRecommendations2;
                                allTrailers3 = allTrailers2;
                                tmdbMediaType4 = tmdbMediaType2;
                                stremioC$CatalogEntry$toLoadResponse$2 = stremioC$CatalogEntry$toLoadResponse$3;
                                finalImdbId5 = finalImdbId2;
                                obj3 = Requests.get$default(app5, detailUrl3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, stremioC$CatalogEntry$toLoadResponse$2, 4094, (Object) null);
                                stremioC$CatalogEntry$toLoadResponse$3 = stremioC$CatalogEntry$toLoadResponse$2;
                                if (obj3 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                imdbId2 = imdbId4;
                                fetchedRecommendations4 = fetchedRecommendations3;
                                tmdbMediaType5 = tmdbMediaType4;
                                extractedTmdbId = extractedTmdbId2;
                                finalImdbId = finalImdbId5;
                                tmdbIdStr = tmdbIdStr3;
                                allTrailers = allTrailers3;
                                NiceResponse this_$iv5 = (NiceResponse) obj3;
                                ResponseParser parser5 = this_$iv5.getParser();
                                Intrinsics.checkNotNull(parser5);
                                obj = coroutine_suspended;
                                safe2 = parser5.parseSafe(this_$iv5.getText(), Reflection.getOrCreateKotlinClass(TmdbDetailResponse.class));
                                detailRes = (TmdbDetailResponse) safe2;
                                if (detailRes != null) {
                                    provider2 = provider;
                                    arrayList = null;
                                    fetchedRecommendations4.element = arrayList;
                                    finalImdbId4 = finalImdbId;
                                    allTrailers2 = allTrailers;
                                    fetchedRecommendations2 = fetchedRecommendations4;
                                } else {
                                    provider2 = provider;
                                    arrayList = null;
                                    fetchedRecommendations4.element = arrayList;
                                    finalImdbId4 = finalImdbId;
                                    allTrailers2 = allTrailers;
                                    fetchedRecommendations2 = fetchedRecommendations4;
                                }
                            } else {
                                obj = coroutine_suspended;
                                imdbId2 = imdbId3;
                                provider2 = provider;
                                extractedTmdbId = extractedTmdbId2;
                                finalImdbId4 = finalImdbId2;
                                tmdbIdStr = tmdbIdStr2;
                            }
                            list = this.videos;
                            if (list != null) {
                                z2 = true;
                            } else {
                                z2 = true;
                            }
                            if (z2) {
                                Ref.ObjectRef fetchedRecommendations14 = fetchedRecommendations2;
                                List allTrailers13 = allTrailers2;
                                Ref.ObjectRef tmdbIdStr13 = tmdbIdStr;
                                obj4 = obj;
                                provider4 = provider2;
                                StremioC stremioC9 = provider4;
                                String str1111 = this.name;
                                String str1112 = provider4.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                TvType tvType10 = TvType.TvSeries;
                                $this$map$iv = this.videos;
                                $i$f$map = 0;
                                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                while (r17.hasNext()) {
                                    Iterable $this$map$iv7 = $this$map$iv;
                                    Video it11 = (Video) item$iv$iv2;
                                    destination$iv$iv.add(it11.toEpisode(provider4, this.type, finalImdbId4));
                                    $this$map$iv = $this$map$iv7;
                                    $i$f$map = $i$f$map;
                                }
                                StremioC$CatalogEntry$toLoadResponse$6 stremioC$CatalogEntry$toLoadResponse$12 = new StremioC$CatalogEntry$toLoadResponse$6(this, allTrailers13, fetchedRecommendations14, tmdbIdStr13, finalImdbId4, null);
                                stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider4);
                                stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers13);
                                stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations14);
                                stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId4);
                                stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr13);
                                stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                stremioC$CatalogEntry$toLoadResponse$3.label = 4;
                                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(stremioC9, str1111, str1112, tvType10, (List) destination$iv$iv, stremioC$CatalogEntry$toLoadResponse$12, stremioC$CatalogEntry$toLoadResponse$3);
                                if (objNewTvSeriesLoadResponse == obj4) {
                                    return obj4;
                                }
                                return objNewTvSeriesLoadResponse;
                            }
                            StremioC stremioC10 = provider2;
                            String str1113 = this.name;
                            String str1114 = provider2.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                            Ref.ObjectRef fetchedRecommendations15 = fetchedRecommendations2;
                            TvType tvType11 = TvType.Movie;
                            String str1115 = this.type;
                            String str1116 = this.id;
                            str3 = this.yearNum;
                            if (str3 != null) {
                                intOrNull = StringsKt.toIntOrNull(str3);
                            } else {
                                intOrNull = null;
                            }
                            String finalImdbId10 = finalImdbId4;
                            LoadData loadData5 = new LoadData(str1115, str1116, null, null, finalImdbId10, intOrNull, 12, null);
                            List allTrailers14 = allTrailers2;
                            Ref.ObjectRef tmdbIdStr14 = tmdbIdStr;
                            StremioC$CatalogEntry$toLoadResponse$4 stremioC$CatalogEntry$toLoadResponse$13 = new StremioC$CatalogEntry$toLoadResponse$4(this, allTrailers14, fetchedRecommendations15, tmdbIdStr14, finalImdbId10, null);
                            stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider2);
                            stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                            stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers14);
                            stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations15);
                            stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                            stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                            stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId10);
                            stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr14);
                            stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                            stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                            stremioC$CatalogEntry$toLoadResponse$3.label = 3;
                            obj5 = obj;
                            $result = MainAPIKt.newMovieLoadResponse(stremioC10, str1113, str1114, tvType11, loadData5, stremioC$CatalogEntry$toLoadResponse$13, stremioC$CatalogEntry$toLoadResponse$3);
                            if ($result == obj5) {
                                return obj5;
                            }
                        } else {
                            try {
                                List<Video> list2 = this.videos;
                                if (list2 == null || list2.isEmpty()) {
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                                if (i != 0) {
                                    tmdbMediaType = "movie";
                                } else {
                                    tmdbMediaType = "tv";
                                }
                                extractedImdbId2 = it;
                                try {
                                    try {
                                        if (tmdbIdStr4.element == null) {
                                            if (finalImdbId != null) {
                                                str2 = "tmdb:";
                                                extractedTmdbId3 = extractedTmdbId5;
                                                try {
                                                    z = StringsKt.startsWith$default(finalImdbId, "tt", false, 2, (Object) null);
                                                    if (z) {
                                                        try {
                                                            String findUrl3 = "https://api.themoviedb.org/3/find/" + finalImdbId + "?api_key=98ae14df2b8d8f8f8136499daf79f0e0&external_source=imdb_id";
                                                            Requests app6 = MainActivityKt.getApp();
                                                            provider = provider;
                                                            try {
                                                                stremioC$CatalogEntry$toLoadResponse$3.L$0 = provider;
                                                                stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId);
                                                                stremioC$CatalogEntry$toLoadResponse$3.L$2 = allTrailers4;
                                                                stremioC$CatalogEntry$toLoadResponse$3.L$3 = fetchedRecommendations5;
                                                                stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                                                stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId3);
                                                                stremioC$CatalogEntry$toLoadResponse$3.L$6 = finalImdbId;
                                                                stremioC$CatalogEntry$toLoadResponse$3.L$7 = tmdbIdStr4;
                                                                stremioC$CatalogEntry$toLoadResponse$3.L$8 = tmdbMediaType;
                                                                stremioC$CatalogEntry$toLoadResponse$3.L$9 = SpillingKt.nullOutSpilledVariable(findUrl3);
                                                                stremioC$CatalogEntry$toLoadResponse$3.I$0 = i;
                                                                stremioC$CatalogEntry$toLoadResponse$3.label = 1;
                                                                finalImdbId3 = finalImdbId;
                                                                i2 = i;
                                                                tmdbMediaType3 = tmdbMediaType;
                                                                extractedTmdbId4 = extractedTmdbId3;
                                                                str = str2;
                                                                str6 = "movie";
                                                                try {
                                                                    obj2 = Requests.get$default(app6, findUrl3, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, stremioC$CatalogEntry$toLoadResponse$3, 4094, (Object) null);
                                                                    stremioC$CatalogEntry$toLoadResponse$3 = stremioC$CatalogEntry$toLoadResponse$3;
                                                                    if (obj2 == coroutine_suspended) {
                                                                        return coroutine_suspended;
                                                                    }
                                                                    imdbId2 = imdbId;
                                                                    i3 = i2;
                                                                    extractedImdbId3 = extractedImdbId2;
                                                                    fetchedRecommendations = fetchedRecommendations5;
                                                                    extractedTmdbId = extractedTmdbId4;
                                                                    finalImdbId = finalImdbId3;
                                                                    tmdbIdStr = tmdbIdStr4;
                                                                    allTrailers = allTrailers4;
                                                                    try {
                                                                        NiceResponse this_$iv6 = (NiceResponse) obj2;
                                                                        try {
                                                                            ResponseParser parser6 = this_$iv6.getParser();
                                                                            Intrinsics.checkNotNull(parser6);
                                                                            provider3 = provider;
                                                                            try {
                                                                                safe = parser6.parseSafe(this_$iv6.getText(), Reflection.getOrCreateKotlinClass(TmdbFindResponse.class));
                                                                                break;
                                                                            } catch (Exception e) {
                                                                                e$iv = e;
                                                                                try {
                                                                                    e$iv.printStackTrace();
                                                                                    safe = null;
                                                                                } catch (Exception e2) {
                                                                                    provider = provider3;
                                                                                    obj = coroutine_suspended;
                                                                                    extractedImdbId = extractedImdbId3;
                                                                                }
                                                                            }
                                                                        } catch (Exception e3) {
                                                                            e$iv = e3;
                                                                            provider3 = provider;
                                                                        }
                                                                        findRes = (TmdbFindResponse) safe;
                                                                        if (i3 != 0) {
                                                                            if (findRes != null || (movie_results = findRes.getMovie_results()) == null || (tmdbFindResult = (TmdbFindResult) CollectionsKt.firstOrNull(movie_results)) == null) {
                                                                                tmdbId = null;
                                                                            } else {
                                                                                tmdbId = tmdbFindResult.getId();
                                                                            }
                                                                        } else if (findRes != null || (tv_results = findRes.getTv_results()) == null || (tmdbFindResult = (TmdbFindResult) CollectionsKt.firstOrNull(tv_results)) == null) {
                                                                            tmdbId = null;
                                                                        } else {
                                                                            tmdbId = tmdbFindResult.getId();
                                                                        }
                                                                        if (tmdbId != null) {
                                                                            tmdbIdStr.element = String.valueOf(tmdbId.intValue());
                                                                        }
                                                                        provider = provider3;
                                                                        finalImdbId2 = finalImdbId;
                                                                        extractedImdbId2 = extractedImdbId3;
                                                                        tmdbIdStr2 = tmdbIdStr;
                                                                        extractedTmdbId2 = extractedTmdbId;
                                                                        i = i3;
                                                                        fetchedRecommendations2 = fetchedRecommendations;
                                                                        allTrailers2 = allTrailers;
                                                                        imdbId3 = imdbId2;
                                                                        tmdbMediaType2 = tmdbMediaType3;
                                                                        if (tmdbIdStr2.element != null) {
                                                                            String detailUrl4 = "https://api.themoviedb.org/3/" + tmdbMediaType2 + '/' + ((String) tmdbIdStr2.element) + "?api_key=98ae14df2b8d8f8f8136499daf79f0e0&append_to_response=recommendations";
                                                                            Requests app7 = MainActivityKt.getApp();
                                                                            stremioC$CatalogEntry$toLoadResponse$3.L$0 = provider;
                                                                            imdbId4 = imdbId3;
                                                                            try {
                                                                                stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId4);
                                                                                stremioC$CatalogEntry$toLoadResponse$3.L$2 = allTrailers2;
                                                                                stremioC$CatalogEntry$toLoadResponse$3.L$3 = fetchedRecommendations2;
                                                                                stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                                                                stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId2);
                                                                                stremioC$CatalogEntry$toLoadResponse$3.L$6 = finalImdbId2;
                                                                                stremioC$CatalogEntry$toLoadResponse$3.L$7 = tmdbIdStr2;
                                                                                stremioC$CatalogEntry$toLoadResponse$3.L$8 = tmdbMediaType2;
                                                                                stremioC$CatalogEntry$toLoadResponse$3.L$9 = SpillingKt.nullOutSpilledVariable(detailUrl4);
                                                                                stremioC$CatalogEntry$toLoadResponse$3.I$0 = i;
                                                                                stremioC$CatalogEntry$toLoadResponse$3.label = 2;
                                                                                tmdbIdStr3 = tmdbIdStr2;
                                                                                fetchedRecommendations3 = fetchedRecommendations2;
                                                                                allTrailers3 = allTrailers2;
                                                                                tmdbMediaType4 = tmdbMediaType2;
                                                                                stremioC$CatalogEntry$toLoadResponse$2 = stremioC$CatalogEntry$toLoadResponse$3;
                                                                                finalImdbId5 = finalImdbId2;
                                                                                try {
                                                                                    obj3 = Requests.get$default(app7, detailUrl4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, stremioC$CatalogEntry$toLoadResponse$2, 4094, (Object) null);
                                                                                    stremioC$CatalogEntry$toLoadResponse$3 = stremioC$CatalogEntry$toLoadResponse$2;
                                                                                    if (obj3 == coroutine_suspended) {
                                                                                        return coroutine_suspended;
                                                                                    }
                                                                                    imdbId2 = imdbId4;
                                                                                    fetchedRecommendations4 = fetchedRecommendations3;
                                                                                    tmdbMediaType5 = tmdbMediaType4;
                                                                                    extractedTmdbId = extractedTmdbId2;
                                                                                    finalImdbId = finalImdbId5;
                                                                                    tmdbIdStr = tmdbIdStr3;
                                                                                    allTrailers = allTrailers3;
                                                                                    try {
                                                                                        NiceResponse this_$iv7 = (NiceResponse) obj3;
                                                                                        try {
                                                                                            ResponseParser parser7 = this_$iv7.getParser();
                                                                                            Intrinsics.checkNotNull(parser7);
                                                                                            obj = coroutine_suspended;
                                                                                            try {
                                                                                                safe2 = parser7.parseSafe(this_$iv7.getText(), Reflection.getOrCreateKotlinClass(TmdbDetailResponse.class));
                                                                                                break;
                                                                                            } catch (Exception e4) {
                                                                                                e$iv = e4;
                                                                                                try {
                                                                                                    e$iv.printStackTrace();
                                                                                                    safe2 = null;
                                                                                                } catch (Exception e5) {
                                                                                                    fetchedRecommendations = fetchedRecommendations4;
                                                                                                    extractedImdbId = extractedImdbId2;
                                                                                                }
                                                                                            }
                                                                                        } catch (Exception e6) {
                                                                                            e$iv = e6;
                                                                                            obj = coroutine_suspended;
                                                                                        }
                                                                                        detailRes = (TmdbDetailResponse) safe2;
                                                                                        if (detailRes != null || (recommendations = detailRes.getRecommendations()) == null || (results = recommendations.getResults()) == null) {
                                                                                            provider2 = provider;
                                                                                            arrayList = null;
                                                                                        } else {
                                                                                            Iterable $this$mapNotNull$iv4 = results;
                                                                                            int $i$f$mapNotNull2 = 0;
                                                                                            Collection destination$iv$iv5 = new ArrayList();
                                                                                            for (Object element$iv$iv$iv3 : $this$mapNotNull$iv4) {
                                                                                                TmdbMedia media = (TmdbMedia) element$iv$iv$iv3;
                                                                                                String title = media.getTitle();
                                                                                                if (title == null) {
                                                                                                    try {
                                                                                                        title = media.getName();
                                                                                                        if (title == null && (title = media.getOriginalTitle()) == null) {
                                                                                                            $this$mapNotNull$iv = $this$mapNotNull$iv4;
                                                                                                            $i$f$mapNotNull = $i$f$mapNotNull2;
                                                                                                            provider2 = provider;
                                                                                                            str4 = str;
                                                                                                            movieSearchResponseNewMovieSearchResponse$default = null;
                                                                                                        } else {
                                                                                                            String recTitle = title;
                                                                                                            posterPath = media.getPosterPath();
                                                                                                            if (posterPath != null) {
                                                                                                                $this$mapNotNull$iv = $this$mapNotNull$iv4;
                                                                                                                $i$f$mapNotNull = $i$f$mapNotNull2;
                                                                                                                provider2 = provider;
                                                                                                                try {
                                                                                                                    z3 = StringsKt.startsWith$default(posterPath, "/", false, 2, (Object) null);
                                                                                                                    if (z3) {
                                                                                                                        posterPath2 = "https://image.tmdb.org/t/p/original" + media.getPosterPath();
                                                                                                                    } else {
                                                                                                                        posterPath2 = media.getPosterPath();
                                                                                                                    }
                                                                                                                    final String posterUrl = posterPath2;
                                                                                                                    rawMediaType = media.getMediaType();
                                                                                                                    if (rawMediaType == null) {
                                                                                                                        rawMediaType = tmdbMediaType5;
                                                                                                                    }
                                                                                                                    if (Intrinsics.areEqual(rawMediaType, str5)) {
                                                                                                                        stremioType = "series";
                                                                                                                    } else {
                                                                                                                        stremioType = str6;
                                                                                                                    }
                                                                                                                    str4 = str;
                                                                                                                    CatalogEntry recommendationEntry = new CatalogEntry(recTitle, str4 + media.getId(), posterUrl, null, media.getOverview(), null, stremioType, null, null, null, null, null, null, null, null, 32256, null);
                                                                                                                    StremioC stremioC11 = provider2;
                                                                                                                    String json = AppUtils.INSTANCE.toJson(recommendationEntry);
                                                                                                                    if (Intrinsics.areEqual(stremioType, str6)) {
                                                                                                                        tvType = TvType.Movie;
                                                                                                                    } else {
                                                                                                                        tvType = TvType.TvSeries;
                                                                                                                    }
                                                                                                                    movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(stremioC11, recTitle, json, tvType, false, new Function1() { // from class: com.phisher98.StremioC$CatalogEntry$$ExternalSyntheticLambda0
                                                                                                                        public final Object invoke(Object obj6) {
                                                                                                                            return StremioC.CatalogEntry.toLoadResponse$lambda$5$0(posterUrl, (MovieSearchResponse) obj6);
                                                                                                                        }
                                                                                                                    }, 8, (Object) null);
                                                                                                                } catch (Exception e7) {
                                                                                                                    fetchedRecommendations = fetchedRecommendations4;
                                                                                                                    extractedImdbId = extractedImdbId2;
                                                                                                                    provider = provider2;
                                                                                                                    extractedImdbId2 = extractedImdbId;
                                                                                                                    provider2 = provider;
                                                                                                                    finalImdbId4 = finalImdbId;
                                                                                                                    fetchedRecommendations2 = fetchedRecommendations;
                                                                                                                    allTrailers2 = allTrailers;
                                                                                                                    list = this.videos;
                                                                                                                    if (list != null) {
                                                                                                                        z2 = true;
                                                                                                                    } else {
                                                                                                                        z2 = true;
                                                                                                                    }
                                                                                                                    if (z2) {
                                                                                                                        StremioC stremioC12 = provider2;
                                                                                                                        String str1117 = this.name;
                                                                                                                        String str1118 = provider2.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                                                                                                        Ref.ObjectRef fetchedRecommendations16 = fetchedRecommendations2;
                                                                                                                        TvType tvType12 = TvType.Movie;
                                                                                                                        String str1119 = this.type;
                                                                                                                        String str11110 = this.id;
                                                                                                                        str3 = this.yearNum;
                                                                                                                        if (str3 != null) {
                                                                                                                            intOrNull = StringsKt.toIntOrNull(str3);
                                                                                                                        } else {
                                                                                                                            intOrNull = null;
                                                                                                                        }
                                                                                                                        String finalImdbId11 = finalImdbId4;
                                                                                                                        LoadData loadData6 = new LoadData(str1119, str11110, null, null, finalImdbId11, intOrNull, 12, null);
                                                                                                                        List allTrailers15 = allTrailers2;
                                                                                                                        Ref.ObjectRef tmdbIdStr15 = tmdbIdStr;
                                                                                                                        StremioC$CatalogEntry$toLoadResponse$4 stremioC$CatalogEntry$toLoadResponse$14 = new StremioC$CatalogEntry$toLoadResponse$4(this, allTrailers15, fetchedRecommendations16, tmdbIdStr15, finalImdbId11, null);
                                                                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider2);
                                                                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                                                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers15);
                                                                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations16);
                                                                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                                                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                                                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId11);
                                                                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr15);
                                                                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                                                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                                                                                                        stremioC$CatalogEntry$toLoadResponse$3.label = 3;
                                                                                                                        obj5 = obj;
                                                                                                                        $result = MainAPIKt.newMovieLoadResponse(stremioC12, str1117, str1118, tvType12, loadData6, stremioC$CatalogEntry$toLoadResponse$14, stremioC$CatalogEntry$toLoadResponse$3);
                                                                                                                        if ($result == obj5) {
                                                                                                                            return obj5;
                                                                                                                        }
                                                                                                                        return $result;
                                                                                                                    }
                                                                                                                    Ref.ObjectRef fetchedRecommendations17 = fetchedRecommendations2;
                                                                                                                    List allTrailers16 = allTrailers2;
                                                                                                                    Ref.ObjectRef tmdbIdStr16 = tmdbIdStr;
                                                                                                                    obj4 = obj;
                                                                                                                    provider4 = provider2;
                                                                                                                    StremioC stremioC13 = provider4;
                                                                                                                    String str11111 = this.name;
                                                                                                                    String str11112 = provider4.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                                                                                                    TvType tvType13 = TvType.TvSeries;
                                                                                                                    $this$map$iv = this.videos;
                                                                                                                    $i$f$map = 0;
                                                                                                                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                                                                                                    while (r17.hasNext()) {
                                                                                                                        Iterable $this$map$iv8 = $this$map$iv;
                                                                                                                        Video it12 = (Video) item$iv$iv2;
                                                                                                                        destination$iv$iv.add(it12.toEpisode(provider4, this.type, finalImdbId4));
                                                                                                                        $this$map$iv = $this$map$iv8;
                                                                                                                        $i$f$map = $i$f$map;
                                                                                                                    }
                                                                                                                    StremioC$CatalogEntry$toLoadResponse$6 stremioC$CatalogEntry$toLoadResponse$15 = new StremioC$CatalogEntry$toLoadResponse$6(this, allTrailers16, fetchedRecommendations17, tmdbIdStr16, finalImdbId4, null);
                                                                                                                    stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider4);
                                                                                                                    stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                                                                                                    stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers16);
                                                                                                                    stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations17);
                                                                                                                    stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                                                                                                    stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                                                                                                    stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId4);
                                                                                                                    stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr16);
                                                                                                                    stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                                                                                                    stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                                                                                                    stremioC$CatalogEntry$toLoadResponse$3.label = 4;
                                                                                                                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(stremioC13, str11111, str11112, tvType13, (List) destination$iv$iv, stremioC$CatalogEntry$toLoadResponse$15, stremioC$CatalogEntry$toLoadResponse$3);
                                                                                                                    if (objNewTvSeriesLoadResponse == obj4) {
                                                                                                                        return obj4;
                                                                                                                    }
                                                                                                                    return objNewTvSeriesLoadResponse;
                                                                                                                }
                                                                                                            } else {
                                                                                                                $this$mapNotNull$iv = $this$mapNotNull$iv4;
                                                                                                                $i$f$mapNotNull = $i$f$mapNotNull2;
                                                                                                                provider2 = provider;
                                                                                                            }
                                                                                                            if (z3) {
                                                                                                                posterPath2 = "https://image.tmdb.org/t/p/original" + media.getPosterPath();
                                                                                                            } else {
                                                                                                                posterPath2 = media.getPosterPath();
                                                                                                            }
                                                                                                            final String posterUrl2 = posterPath2;
                                                                                                            rawMediaType = media.getMediaType();
                                                                                                            if (rawMediaType == null) {
                                                                                                                rawMediaType = tmdbMediaType5;
                                                                                                            }
                                                                                                            if (Intrinsics.areEqual(rawMediaType, str5)) {
                                                                                                                stremioType = "series";
                                                                                                            } else {
                                                                                                                stremioType = str6;
                                                                                                            }
                                                                                                            str4 = str;
                                                                                                            CatalogEntry recommendationEntry2 = new CatalogEntry(recTitle, str4 + media.getId(), posterUrl2, null, media.getOverview(), null, stremioType, null, null, null, null, null, null, null, null, 32256, null);
                                                                                                            StremioC stremioC14 = provider2;
                                                                                                            String json2 = AppUtils.INSTANCE.toJson(recommendationEntry2);
                                                                                                            if (Intrinsics.areEqual(stremioType, str6)) {
                                                                                                                tvType = TvType.Movie;
                                                                                                            } else {
                                                                                                                tvType = TvType.TvSeries;
                                                                                                            }
                                                                                                            movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(stremioC14, recTitle, json2, tvType, false, new Function1() { // from class: com.phisher98.StremioC$CatalogEntry$$ExternalSyntheticLambda0
                                                                                                                public final Object invoke(Object obj6) {
                                                                                                                    return StremioC.CatalogEntry.toLoadResponse$lambda$5$0(posterUrl2, (MovieSearchResponse) obj6);
                                                                                                                }
                                                                                                            }, 8, (Object) null);
                                                                                                        }
                                                                                                    } catch (Exception e8) {
                                                                                                        fetchedRecommendations = fetchedRecommendations4;
                                                                                                        extractedImdbId = extractedImdbId2;
                                                                                                    }
                                                                                                } else {
                                                                                                    String recTitle2 = title;
                                                                                                    posterPath = media.getPosterPath();
                                                                                                    if (posterPath != null) {
                                                                                                        $this$mapNotNull$iv = $this$mapNotNull$iv4;
                                                                                                        $i$f$mapNotNull = $i$f$mapNotNull2;
                                                                                                        provider2 = provider;
                                                                                                        if (StringsKt.startsWith$default(posterPath, "/", false, 2, (Object) null)) {
                                                                                                        }
                                                                                                        if (z3) {
                                                                                                            posterPath2 = "https://image.tmdb.org/t/p/original" + media.getPosterPath();
                                                                                                        } else {
                                                                                                            posterPath2 = media.getPosterPath();
                                                                                                        }
                                                                                                        final String posterUrl3 = posterPath2;
                                                                                                        rawMediaType = media.getMediaType();
                                                                                                        if (rawMediaType == null) {
                                                                                                            rawMediaType = tmdbMediaType5;
                                                                                                        }
                                                                                                        if (Intrinsics.areEqual(rawMediaType, str5)) {
                                                                                                            stremioType = "series";
                                                                                                        } else {
                                                                                                            stremioType = str6;
                                                                                                        }
                                                                                                        str4 = str;
                                                                                                        CatalogEntry recommendationEntry3 = new CatalogEntry(recTitle2, str4 + media.getId(), posterUrl3, null, media.getOverview(), null, stremioType, null, null, null, null, null, null, null, null, 32256, null);
                                                                                                        StremioC stremioC15 = provider2;
                                                                                                        String json3 = AppUtils.INSTANCE.toJson(recommendationEntry3);
                                                                                                        if (Intrinsics.areEqual(stremioType, str6)) {
                                                                                                            tvType = TvType.Movie;
                                                                                                        } else {
                                                                                                            tvType = TvType.TvSeries;
                                                                                                        }
                                                                                                        movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(stremioC15, recTitle2, json3, tvType, false, new Function1() { // from class: com.phisher98.StremioC$CatalogEntry$$ExternalSyntheticLambda0
                                                                                                            public final Object invoke(Object obj6) {
                                                                                                                return StremioC.CatalogEntry.toLoadResponse$lambda$5$0(posterUrl3, (MovieSearchResponse) obj6);
                                                                                                            }
                                                                                                        }, 8, (Object) null);
                                                                                                    } else {
                                                                                                        $this$mapNotNull$iv = $this$mapNotNull$iv4;
                                                                                                        $i$f$mapNotNull = $i$f$mapNotNull2;
                                                                                                        provider2 = provider;
                                                                                                    }
                                                                                                    if (z3) {
                                                                                                        posterPath2 = "https://image.tmdb.org/t/p/original" + media.getPosterPath();
                                                                                                    } else {
                                                                                                        posterPath2 = media.getPosterPath();
                                                                                                    }
                                                                                                    final String posterUrl4 = posterPath2;
                                                                                                    rawMediaType = media.getMediaType();
                                                                                                    if (rawMediaType == null) {
                                                                                                        rawMediaType = tmdbMediaType5;
                                                                                                    }
                                                                                                    if (Intrinsics.areEqual(rawMediaType, str5)) {
                                                                                                        stremioType = "series";
                                                                                                    } else {
                                                                                                        stremioType = str6;
                                                                                                    }
                                                                                                    str4 = str;
                                                                                                    CatalogEntry recommendationEntry4 = new CatalogEntry(recTitle2, str4 + media.getId(), posterUrl4, null, media.getOverview(), null, stremioType, null, null, null, null, null, null, null, null, 32256, null);
                                                                                                    StremioC stremioC16 = provider2;
                                                                                                    String json4 = AppUtils.INSTANCE.toJson(recommendationEntry4);
                                                                                                    if (Intrinsics.areEqual(stremioType, str6)) {
                                                                                                        tvType = TvType.Movie;
                                                                                                    } else {
                                                                                                        tvType = TvType.TvSeries;
                                                                                                    }
                                                                                                    movieSearchResponseNewMovieSearchResponse$default = MainAPIKt.newMovieSearchResponse$default(stremioC16, recTitle2, json4, tvType, false, new Function1() { // from class: com.phisher98.StremioC$CatalogEntry$$ExternalSyntheticLambda0
                                                                                                        public final Object invoke(Object obj6) {
                                                                                                            return StremioC.CatalogEntry.toLoadResponse$lambda$5$0(posterUrl4, (MovieSearchResponse) obj6);
                                                                                                        }
                                                                                                    }, 8, (Object) null);
                                                                                                }
                                                                                                if (movieSearchResponseNewMovieSearchResponse$default != null) {
                                                                                                    try {
                                                                                                        destination$iv$iv5.add(movieSearchResponseNewMovieSearchResponse$default);
                                                                                                    } catch (Exception e9) {
                                                                                                        fetchedRecommendations = fetchedRecommendations4;
                                                                                                        extractedImdbId = extractedImdbId2;
                                                                                                        provider = provider2;
                                                                                                        extractedImdbId2 = extractedImdbId;
                                                                                                        provider2 = provider;
                                                                                                        finalImdbId4 = finalImdbId;
                                                                                                        fetchedRecommendations2 = fetchedRecommendations;
                                                                                                        allTrailers2 = allTrailers;
                                                                                                        list = this.videos;
                                                                                                        if (list != null) {
                                                                                                            z2 = true;
                                                                                                        } else {
                                                                                                            z2 = true;
                                                                                                        }
                                                                                                        if (z2) {
                                                                                                            StremioC stremioC17 = provider2;
                                                                                                            String str11113 = this.name;
                                                                                                            String str11114 = provider2.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                                                                                            Ref.ObjectRef fetchedRecommendations18 = fetchedRecommendations2;
                                                                                                            TvType tvType14 = TvType.Movie;
                                                                                                            String str11115 = this.type;
                                                                                                            String str11116 = this.id;
                                                                                                            str3 = this.yearNum;
                                                                                                            if (str3 != null) {
                                                                                                                intOrNull = StringsKt.toIntOrNull(str3);
                                                                                                            } else {
                                                                                                                intOrNull = null;
                                                                                                            }
                                                                                                            String finalImdbId12 = finalImdbId4;
                                                                                                            LoadData loadData7 = new LoadData(str11115, str11116, null, null, finalImdbId12, intOrNull, 12, null);
                                                                                                            List allTrailers17 = allTrailers2;
                                                                                                            Ref.ObjectRef tmdbIdStr17 = tmdbIdStr;
                                                                                                            StremioC$CatalogEntry$toLoadResponse$4 stremioC$CatalogEntry$toLoadResponse$16 = new StremioC$CatalogEntry$toLoadResponse$4(this, allTrailers17, fetchedRecommendations18, tmdbIdStr17, finalImdbId12, null);
                                                                                                            stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider2);
                                                                                                            stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                                                                                            stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers17);
                                                                                                            stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations18);
                                                                                                            stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                                                                                            stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                                                                                            stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId12);
                                                                                                            stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr17);
                                                                                                            stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                                                                                            stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                                                                                            stremioC$CatalogEntry$toLoadResponse$3.label = 3;
                                                                                                            obj5 = obj;
                                                                                                            $result = MainAPIKt.newMovieLoadResponse(stremioC17, str11113, str11114, tvType14, loadData7, stremioC$CatalogEntry$toLoadResponse$16, stremioC$CatalogEntry$toLoadResponse$3);
                                                                                                            if ($result == obj5) {
                                                                                                                return obj5;
                                                                                                            }
                                                                                                            return $result;
                                                                                                        }
                                                                                                        Ref.ObjectRef fetchedRecommendations19 = fetchedRecommendations2;
                                                                                                        List allTrailers18 = allTrailers2;
                                                                                                        Ref.ObjectRef tmdbIdStr18 = tmdbIdStr;
                                                                                                        obj4 = obj;
                                                                                                        provider4 = provider2;
                                                                                                        StremioC stremioC18 = provider4;
                                                                                                        String str11117 = this.name;
                                                                                                        String str11118 = provider4.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                                                                                        TvType tvType15 = TvType.TvSeries;
                                                                                                        $this$map$iv = this.videos;
                                                                                                        $i$f$map = 0;
                                                                                                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                                                                                        while (r17.hasNext()) {
                                                                                                            Iterable $this$map$iv9 = $this$map$iv;
                                                                                                            Video it13 = (Video) item$iv$iv2;
                                                                                                            destination$iv$iv.add(it13.toEpisode(provider4, this.type, finalImdbId4));
                                                                                                            $this$map$iv = $this$map$iv9;
                                                                                                            $i$f$map = $i$f$map;
                                                                                                        }
                                                                                                        StremioC$CatalogEntry$toLoadResponse$6 stremioC$CatalogEntry$toLoadResponse$17 = new StremioC$CatalogEntry$toLoadResponse$6(this, allTrailers18, fetchedRecommendations19, tmdbIdStr18, finalImdbId4, null);
                                                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider4);
                                                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers18);
                                                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations19);
                                                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId4);
                                                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr18);
                                                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                                                                                        stremioC$CatalogEntry$toLoadResponse$3.label = 4;
                                                                                                        objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(stremioC18, str11117, str11118, tvType15, (List) destination$iv$iv, stremioC$CatalogEntry$toLoadResponse$17, stremioC$CatalogEntry$toLoadResponse$3);
                                                                                                        if (objNewTvSeriesLoadResponse == obj4) {
                                                                                                            return obj4;
                                                                                                        }
                                                                                                        return objNewTvSeriesLoadResponse;
                                                                                                    }
                                                                                                }
                                                                                                detailRes = detailRes;
                                                                                                $this$mapNotNull$iv4 = $this$mapNotNull$iv;
                                                                                                str = str4;
                                                                                                $i$f$mapNotNull2 = $i$f$mapNotNull;
                                                                                                provider = provider2;
                                                                                                str5 = str5;
                                                                                                break;
                                                                                            }
                                                                                            provider2 = provider;
                                                                                            arrayList = (List) destination$iv$iv5;
                                                                                        }
                                                                                        fetchedRecommendations4.element = arrayList;
                                                                                        finalImdbId4 = finalImdbId;
                                                                                        allTrailers2 = allTrailers;
                                                                                        fetchedRecommendations2 = fetchedRecommendations4;
                                                                                    } catch (Exception e10) {
                                                                                        obj = coroutine_suspended;
                                                                                    }
                                                                                } catch (Exception e11) {
                                                                                    obj = coroutine_suspended;
                                                                                    stremioC$CatalogEntry$toLoadResponse$3 = stremioC$CatalogEntry$toLoadResponse$2;
                                                                                    imdbId2 = imdbId4;
                                                                                    extractedImdbId = extractedImdbId2;
                                                                                    fetchedRecommendations = fetchedRecommendations3;
                                                                                    extractedTmdbId = extractedTmdbId2;
                                                                                    finalImdbId = finalImdbId5;
                                                                                    tmdbIdStr = tmdbIdStr3;
                                                                                    allTrailers = allTrailers3;
                                                                                }
                                                                            } catch (Exception e12) {
                                                                                obj = coroutine_suspended;
                                                                                imdbId2 = imdbId4;
                                                                                extractedImdbId = extractedImdbId2;
                                                                                fetchedRecommendations = fetchedRecommendations2;
                                                                                extractedTmdbId = extractedTmdbId2;
                                                                                finalImdbId = finalImdbId2;
                                                                                tmdbIdStr = tmdbIdStr2;
                                                                                allTrailers = allTrailers2;
                                                                            }
                                                                        } else {
                                                                            obj = coroutine_suspended;
                                                                            imdbId2 = imdbId3;
                                                                            provider2 = provider;
                                                                            extractedTmdbId = extractedTmdbId2;
                                                                            finalImdbId4 = finalImdbId2;
                                                                            tmdbIdStr = tmdbIdStr2;
                                                                        }
                                                                    } catch (Exception e13) {
                                                                        obj = coroutine_suspended;
                                                                        extractedImdbId = extractedImdbId3;
                                                                    }
                                                                    list = this.videos;
                                                                    if (list != null || list.isEmpty()) {
                                                                        z2 = true;
                                                                    } else {
                                                                        z2 = false;
                                                                    }
                                                                    if (z2) {
                                                                        Ref.ObjectRef fetchedRecommendations110 = fetchedRecommendations2;
                                                                        List allTrailers19 = allTrailers2;
                                                                        Ref.ObjectRef tmdbIdStr19 = tmdbIdStr;
                                                                        obj4 = obj;
                                                                        provider4 = provider2;
                                                                        StremioC stremioC19 = provider4;
                                                                        String str11119 = this.name;
                                                                        String str111110 = provider4.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                                                        TvType tvType16 = TvType.TvSeries;
                                                                        $this$map$iv = this.videos;
                                                                        $i$f$map = 0;
                                                                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                                                        while (r17.hasNext()) {
                                                                            Iterable $this$map$iv10 = $this$map$iv;
                                                                            Video it14 = (Video) item$iv$iv2;
                                                                            destination$iv$iv.add(it14.toEpisode(provider4, this.type, finalImdbId4));
                                                                            $this$map$iv = $this$map$iv10;
                                                                            $i$f$map = $i$f$map;
                                                                        }
                                                                        StremioC$CatalogEntry$toLoadResponse$6 stremioC$CatalogEntry$toLoadResponse$18 = new StremioC$CatalogEntry$toLoadResponse$6(this, allTrailers19, fetchedRecommendations110, tmdbIdStr19, finalImdbId4, null);
                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider4);
                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers19);
                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations110);
                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId4);
                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr19);
                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                                                        stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                                                        stremioC$CatalogEntry$toLoadResponse$3.label = 4;
                                                                        objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(stremioC19, str11119, str111110, tvType16, (List) destination$iv$iv, stremioC$CatalogEntry$toLoadResponse$18, stremioC$CatalogEntry$toLoadResponse$3);
                                                                        if (objNewTvSeriesLoadResponse == obj4) {
                                                                            return obj4;
                                                                        }
                                                                        return objNewTvSeriesLoadResponse;
                                                                    }
                                                                    StremioC stremioC110 = provider2;
                                                                    String str111111 = this.name;
                                                                    String str111112 = provider2.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                                                    Ref.ObjectRef fetchedRecommendations111 = fetchedRecommendations2;
                                                                    TvType tvType17 = TvType.Movie;
                                                                    String str111113 = this.type;
                                                                    String str111114 = this.id;
                                                                    str3 = this.yearNum;
                                                                    if (str3 != null) {
                                                                        intOrNull = StringsKt.toIntOrNull(str3);
                                                                    } else {
                                                                        intOrNull = null;
                                                                    }
                                                                    String finalImdbId13 = finalImdbId4;
                                                                    LoadData loadData8 = new LoadData(str111113, str111114, null, null, finalImdbId13, intOrNull, 12, null);
                                                                    List allTrailers110 = allTrailers2;
                                                                    Ref.ObjectRef tmdbIdStr110 = tmdbIdStr;
                                                                    StremioC$CatalogEntry$toLoadResponse$4 stremioC$CatalogEntry$toLoadResponse$19 = new StremioC$CatalogEntry$toLoadResponse$4(this, allTrailers110, fetchedRecommendations111, tmdbIdStr110, finalImdbId13, null);
                                                                    stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider2);
                                                                    stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                                                    stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers110);
                                                                    stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations111);
                                                                    stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                                                    stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                                                    stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId13);
                                                                    stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr110);
                                                                    stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                                                    stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                                                    stremioC$CatalogEntry$toLoadResponse$3.label = 3;
                                                                    obj5 = obj;
                                                                    $result = MainAPIKt.newMovieLoadResponse(stremioC110, str111111, str111112, tvType17, loadData8, stremioC$CatalogEntry$toLoadResponse$19, stremioC$CatalogEntry$toLoadResponse$3);
                                                                    if ($result == obj5) {
                                                                        return obj5;
                                                                    }
                                                                } catch (Exception e14) {
                                                                    stremioC$CatalogEntry$toLoadResponse$3 = stremioC$CatalogEntry$toLoadResponse$3;
                                                                    imdbId2 = imdbId;
                                                                    obj = coroutine_suspended;
                                                                    extractedImdbId = extractedImdbId2;
                                                                    fetchedRecommendations = fetchedRecommendations5;
                                                                    extractedTmdbId = extractedTmdbId4;
                                                                    finalImdbId = finalImdbId3;
                                                                    tmdbIdStr = tmdbIdStr4;
                                                                    allTrailers = allTrailers4;
                                                                }
                                                            } catch (Exception e15) {
                                                                imdbId2 = imdbId;
                                                                obj = coroutine_suspended;
                                                                extractedImdbId = extractedImdbId2;
                                                                fetchedRecommendations = fetchedRecommendations5;
                                                                extractedTmdbId = extractedTmdbId3;
                                                                tmdbIdStr = tmdbIdStr4;
                                                                allTrailers = allTrailers4;
                                                            }
                                                        } catch (Exception e16) {
                                                            provider = provider;
                                                        }
                                                    } else {
                                                        str = str2;
                                                        extractedTmdbId2 = extractedTmdbId3;
                                                    }
                                                } catch (Exception e17) {
                                                    provider = provider;
                                                    imdbId2 = imdbId;
                                                    allTrailers = allTrailers4;
                                                    obj = coroutine_suspended;
                                                    fetchedRecommendations = fetchedRecommendations5;
                                                    tmdbIdStr = tmdbIdStr4;
                                                    extractedTmdbId = extractedTmdbId3;
                                                    extractedImdbId = extractedImdbId2;
                                                }
                                                extractedImdbId2 = extractedImdbId;
                                                provider2 = provider;
                                                finalImdbId4 = finalImdbId;
                                                fetchedRecommendations2 = fetchedRecommendations;
                                                allTrailers2 = allTrailers;
                                                list = this.videos;
                                                if (list != null) {
                                                    z2 = true;
                                                } else {
                                                    z2 = true;
                                                }
                                                if (z2) {
                                                    Ref.ObjectRef fetchedRecommendations112 = fetchedRecommendations2;
                                                    List allTrailers111 = allTrailers2;
                                                    Ref.ObjectRef tmdbIdStr111 = tmdbIdStr;
                                                    obj4 = obj;
                                                    provider4 = provider2;
                                                    StremioC stremioC111 = provider4;
                                                    String str111115 = this.name;
                                                    String str111116 = provider4.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                                    TvType tvType18 = TvType.TvSeries;
                                                    $this$map$iv = this.videos;
                                                    $i$f$map = 0;
                                                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                                    while (r17.hasNext()) {
                                                        Iterable $this$map$iv11 = $this$map$iv;
                                                        Video it15 = (Video) item$iv$iv2;
                                                        destination$iv$iv.add(it15.toEpisode(provider4, this.type, finalImdbId4));
                                                        $this$map$iv = $this$map$iv11;
                                                        $i$f$map = $i$f$map;
                                                    }
                                                    StremioC$CatalogEntry$toLoadResponse$6 stremioC$CatalogEntry$toLoadResponse$110 = new StremioC$CatalogEntry$toLoadResponse$6(this, allTrailers111, fetchedRecommendations112, tmdbIdStr111, finalImdbId4, null);
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider4);
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers111);
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations112);
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId4);
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr111);
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                                    stremioC$CatalogEntry$toLoadResponse$3.label = 4;
                                                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(stremioC111, str111115, str111116, tvType18, (List) destination$iv$iv, stremioC$CatalogEntry$toLoadResponse$110, stremioC$CatalogEntry$toLoadResponse$3);
                                                    if (objNewTvSeriesLoadResponse == obj4) {
                                                        return obj4;
                                                    }
                                                    return objNewTvSeriesLoadResponse;
                                                }
                                                StremioC stremioC112 = provider2;
                                                String str111117 = this.name;
                                                String str111118 = provider2.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                                Ref.ObjectRef fetchedRecommendations113 = fetchedRecommendations2;
                                                TvType tvType19 = TvType.Movie;
                                                String str111119 = this.type;
                                                String str1111110 = this.id;
                                                str3 = this.yearNum;
                                                if (str3 != null) {
                                                    intOrNull = StringsKt.toIntOrNull(str3);
                                                } else {
                                                    intOrNull = null;
                                                }
                                                String finalImdbId14 = finalImdbId4;
                                                LoadData loadData9 = new LoadData(str111119, str1111110, null, null, finalImdbId14, intOrNull, 12, null);
                                                List allTrailers112 = allTrailers2;
                                                Ref.ObjectRef tmdbIdStr112 = tmdbIdStr;
                                                StremioC$CatalogEntry$toLoadResponse$4 stremioC$CatalogEntry$toLoadResponse$111 = new StremioC$CatalogEntry$toLoadResponse$4(this, allTrailers112, fetchedRecommendations113, tmdbIdStr112, finalImdbId14, null);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider2);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers112);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations113);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId14);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr112);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                                stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                                stremioC$CatalogEntry$toLoadResponse$3.label = 3;
                                                obj5 = obj;
                                                $result = MainAPIKt.newMovieLoadResponse(stremioC112, str111117, str111118, tvType19, loadData9, stremioC$CatalogEntry$toLoadResponse$111, stremioC$CatalogEntry$toLoadResponse$3);
                                                if ($result == obj5) {
                                                    return obj5;
                                                }
                                            } else {
                                                str2 = "tmdb:";
                                                extractedTmdbId3 = extractedTmdbId5;
                                            }
                                            if (z) {
                                                String findUrl4 = "https://api.themoviedb.org/3/find/" + finalImdbId + "?api_key=98ae14df2b8d8f8f8136499daf79f0e0&external_source=imdb_id";
                                                Requests app8 = MainActivityKt.getApp();
                                                provider = provider;
                                                stremioC$CatalogEntry$toLoadResponse$3.L$0 = provider;
                                                stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$2 = allTrailers4;
                                                stremioC$CatalogEntry$toLoadResponse$3.L$3 = fetchedRecommendations5;
                                                stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId3);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$6 = finalImdbId;
                                                stremioC$CatalogEntry$toLoadResponse$3.L$7 = tmdbIdStr4;
                                                stremioC$CatalogEntry$toLoadResponse$3.L$8 = tmdbMediaType;
                                                stremioC$CatalogEntry$toLoadResponse$3.L$9 = SpillingKt.nullOutSpilledVariable(findUrl4);
                                                stremioC$CatalogEntry$toLoadResponse$3.I$0 = i;
                                                stremioC$CatalogEntry$toLoadResponse$3.label = 1;
                                                finalImdbId3 = finalImdbId;
                                                i2 = i;
                                                tmdbMediaType3 = tmdbMediaType;
                                                extractedTmdbId4 = extractedTmdbId3;
                                                str = str2;
                                                str6 = "movie";
                                                obj2 = Requests.get$default(app8, findUrl4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, stremioC$CatalogEntry$toLoadResponse$3, 4094, (Object) null);
                                                stremioC$CatalogEntry$toLoadResponse$3 = stremioC$CatalogEntry$toLoadResponse$3;
                                                if (obj2 == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                imdbId2 = imdbId;
                                                i3 = i2;
                                                extractedImdbId3 = extractedImdbId2;
                                                fetchedRecommendations = fetchedRecommendations5;
                                                extractedTmdbId = extractedTmdbId4;
                                                finalImdbId = finalImdbId3;
                                                tmdbIdStr = tmdbIdStr4;
                                                allTrailers = allTrailers4;
                                                NiceResponse this_$iv8 = (NiceResponse) obj2;
                                                ResponseParser parser8 = this_$iv8.getParser();
                                                Intrinsics.checkNotNull(parser8);
                                                provider3 = provider;
                                                safe = parser8.parseSafe(this_$iv8.getText(), Reflection.getOrCreateKotlinClass(TmdbFindResponse.class));
                                                findRes = (TmdbFindResponse) safe;
                                                if (i3 != 0) {
                                                    if (findRes != null) {
                                                    }
                                                    tmdbId = null;
                                                } else {
                                                    if (findRes != null) {
                                                    }
                                                    tmdbId = null;
                                                }
                                                if (tmdbId != null) {
                                                    tmdbIdStr.element = String.valueOf(tmdbId.intValue());
                                                }
                                                provider = provider3;
                                                finalImdbId2 = finalImdbId;
                                                extractedImdbId2 = extractedImdbId3;
                                                tmdbIdStr2 = tmdbIdStr;
                                                extractedTmdbId2 = extractedTmdbId;
                                                i = i3;
                                                fetchedRecommendations2 = fetchedRecommendations;
                                                allTrailers2 = allTrailers;
                                                imdbId3 = imdbId2;
                                                tmdbMediaType2 = tmdbMediaType3;
                                                if (tmdbIdStr2.element != null) {
                                                    String detailUrl5 = "https://api.themoviedb.org/3/" + tmdbMediaType2 + '/' + ((String) tmdbIdStr2.element) + "?api_key=98ae14df2b8d8f8f8136499daf79f0e0&append_to_response=recommendations";
                                                    Requests app9 = MainActivityKt.getApp();
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$0 = provider;
                                                    imdbId4 = imdbId3;
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId4);
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$2 = allTrailers2;
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$3 = fetchedRecommendations2;
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId2);
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$6 = finalImdbId2;
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$7 = tmdbIdStr2;
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$8 = tmdbMediaType2;
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$9 = SpillingKt.nullOutSpilledVariable(detailUrl5);
                                                    stremioC$CatalogEntry$toLoadResponse$3.I$0 = i;
                                                    stremioC$CatalogEntry$toLoadResponse$3.label = 2;
                                                    tmdbIdStr3 = tmdbIdStr2;
                                                    fetchedRecommendations3 = fetchedRecommendations2;
                                                    allTrailers3 = allTrailers2;
                                                    tmdbMediaType4 = tmdbMediaType2;
                                                    stremioC$CatalogEntry$toLoadResponse$2 = stremioC$CatalogEntry$toLoadResponse$3;
                                                    finalImdbId5 = finalImdbId2;
                                                    obj3 = Requests.get$default(app9, detailUrl5, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, stremioC$CatalogEntry$toLoadResponse$2, 4094, (Object) null);
                                                    stremioC$CatalogEntry$toLoadResponse$3 = stremioC$CatalogEntry$toLoadResponse$2;
                                                    if (obj3 == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
                                                    imdbId2 = imdbId4;
                                                    fetchedRecommendations4 = fetchedRecommendations3;
                                                    tmdbMediaType5 = tmdbMediaType4;
                                                    extractedTmdbId = extractedTmdbId2;
                                                    finalImdbId = finalImdbId5;
                                                    tmdbIdStr = tmdbIdStr3;
                                                    allTrailers = allTrailers3;
                                                    NiceResponse this_$iv9 = (NiceResponse) obj3;
                                                    ResponseParser parser9 = this_$iv9.getParser();
                                                    Intrinsics.checkNotNull(parser9);
                                                    obj = coroutine_suspended;
                                                    safe2 = parser9.parseSafe(this_$iv9.getText(), Reflection.getOrCreateKotlinClass(TmdbDetailResponse.class));
                                                    detailRes = (TmdbDetailResponse) safe2;
                                                    if (detailRes != null) {
                                                        provider2 = provider;
                                                        arrayList = null;
                                                        fetchedRecommendations4.element = arrayList;
                                                        finalImdbId4 = finalImdbId;
                                                        allTrailers2 = allTrailers;
                                                        fetchedRecommendations2 = fetchedRecommendations4;
                                                    } else {
                                                        provider2 = provider;
                                                        arrayList = null;
                                                        fetchedRecommendations4.element = arrayList;
                                                        finalImdbId4 = finalImdbId;
                                                        allTrailers2 = allTrailers;
                                                        fetchedRecommendations2 = fetchedRecommendations4;
                                                    }
                                                } else {
                                                    obj = coroutine_suspended;
                                                    imdbId2 = imdbId3;
                                                    provider2 = provider;
                                                    extractedTmdbId = extractedTmdbId2;
                                                    finalImdbId4 = finalImdbId2;
                                                    tmdbIdStr = tmdbIdStr2;
                                                }
                                                list = this.videos;
                                                if (list != null) {
                                                    z2 = true;
                                                } else {
                                                    z2 = true;
                                                }
                                                if (z2) {
                                                    Ref.ObjectRef fetchedRecommendations114 = fetchedRecommendations2;
                                                    List allTrailers113 = allTrailers2;
                                                    Ref.ObjectRef tmdbIdStr113 = tmdbIdStr;
                                                    obj4 = obj;
                                                    provider4 = provider2;
                                                    StremioC stremioC113 = provider4;
                                                    String str1111111 = this.name;
                                                    String str1111112 = provider4.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                                    TvType tvType110 = TvType.TvSeries;
                                                    $this$map$iv = this.videos;
                                                    $i$f$map = 0;
                                                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                                    while (r17.hasNext()) {
                                                        Iterable $this$map$iv12 = $this$map$iv;
                                                        Video it16 = (Video) item$iv$iv2;
                                                        destination$iv$iv.add(it16.toEpisode(provider4, this.type, finalImdbId4));
                                                        $this$map$iv = $this$map$iv12;
                                                        $i$f$map = $i$f$map;
                                                    }
                                                    StremioC$CatalogEntry$toLoadResponse$6 stremioC$CatalogEntry$toLoadResponse$112 = new StremioC$CatalogEntry$toLoadResponse$6(this, allTrailers113, fetchedRecommendations114, tmdbIdStr113, finalImdbId4, null);
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider4);
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers113);
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations114);
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId4);
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr113);
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                                    stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                                    stremioC$CatalogEntry$toLoadResponse$3.label = 4;
                                                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(stremioC113, str1111111, str1111112, tvType110, (List) destination$iv$iv, stremioC$CatalogEntry$toLoadResponse$112, stremioC$CatalogEntry$toLoadResponse$3);
                                                    if (objNewTvSeriesLoadResponse == obj4) {
                                                        return obj4;
                                                    }
                                                    return objNewTvSeriesLoadResponse;
                                                }
                                                StremioC stremioC114 = provider2;
                                                String str1111113 = this.name;
                                                String str1111114 = provider2.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                                Ref.ObjectRef fetchedRecommendations115 = fetchedRecommendations2;
                                                TvType tvType111 = TvType.Movie;
                                                String str1111115 = this.type;
                                                String str1111116 = this.id;
                                                str3 = this.yearNum;
                                                if (str3 != null) {
                                                    intOrNull = StringsKt.toIntOrNull(str3);
                                                } else {
                                                    intOrNull = null;
                                                }
                                                String finalImdbId15 = finalImdbId4;
                                                LoadData loadData10 = new LoadData(str1111115, str1111116, null, null, finalImdbId15, intOrNull, 12, null);
                                                List allTrailers114 = allTrailers2;
                                                Ref.ObjectRef tmdbIdStr114 = tmdbIdStr;
                                                StremioC$CatalogEntry$toLoadResponse$4 stremioC$CatalogEntry$toLoadResponse$113 = new StremioC$CatalogEntry$toLoadResponse$4(this, allTrailers114, fetchedRecommendations115, tmdbIdStr114, finalImdbId15, null);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider2);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers114);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations115);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId15);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr114);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                                stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                                stremioC$CatalogEntry$toLoadResponse$3.label = 3;
                                                obj5 = obj;
                                                $result = MainAPIKt.newMovieLoadResponse(stremioC114, str1111113, str1111114, tvType111, loadData10, stremioC$CatalogEntry$toLoadResponse$113, stremioC$CatalogEntry$toLoadResponse$3);
                                                if ($result == obj5) {
                                                    return obj5;
                                                }
                                            } else {
                                                str = str2;
                                                extractedTmdbId2 = extractedTmdbId3;
                                            }
                                            extractedImdbId2 = extractedImdbId;
                                            provider2 = provider;
                                            finalImdbId4 = finalImdbId;
                                            fetchedRecommendations2 = fetchedRecommendations;
                                            allTrailers2 = allTrailers;
                                            list = this.videos;
                                            if (list != null) {
                                                z2 = true;
                                            } else {
                                                z2 = true;
                                            }
                                            if (z2) {
                                                Ref.ObjectRef fetchedRecommendations116 = fetchedRecommendations2;
                                                List allTrailers115 = allTrailers2;
                                                Ref.ObjectRef tmdbIdStr115 = tmdbIdStr;
                                                obj4 = obj;
                                                provider4 = provider2;
                                                StremioC stremioC115 = provider4;
                                                String str1111117 = this.name;
                                                String str1111118 = provider4.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                                TvType tvType112 = TvType.TvSeries;
                                                $this$map$iv = this.videos;
                                                $i$f$map = 0;
                                                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                                while (r17.hasNext()) {
                                                    Iterable $this$map$iv13 = $this$map$iv;
                                                    Video it17 = (Video) item$iv$iv2;
                                                    destination$iv$iv.add(it17.toEpisode(provider4, this.type, finalImdbId4));
                                                    $this$map$iv = $this$map$iv13;
                                                    $i$f$map = $i$f$map;
                                                }
                                                StremioC$CatalogEntry$toLoadResponse$6 stremioC$CatalogEntry$toLoadResponse$114 = new StremioC$CatalogEntry$toLoadResponse$6(this, allTrailers115, fetchedRecommendations116, tmdbIdStr115, finalImdbId4, null);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider4);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers115);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations116);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId4);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr115);
                                                stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                                stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                                stremioC$CatalogEntry$toLoadResponse$3.label = 4;
                                                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(stremioC115, str1111117, str1111118, tvType112, (List) destination$iv$iv, stremioC$CatalogEntry$toLoadResponse$114, stremioC$CatalogEntry$toLoadResponse$3);
                                                if (objNewTvSeriesLoadResponse == obj4) {
                                                    return obj4;
                                                }
                                                return objNewTvSeriesLoadResponse;
                                            }
                                            StremioC stremioC116 = provider2;
                                            String str1111119 = this.name;
                                            String str11111110 = provider2.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                            Ref.ObjectRef fetchedRecommendations117 = fetchedRecommendations2;
                                            TvType tvType113 = TvType.Movie;
                                            String str11111111 = this.type;
                                            String str11111112 = this.id;
                                            str3 = this.yearNum;
                                            if (str3 != null) {
                                                intOrNull = StringsKt.toIntOrNull(str3);
                                            } else {
                                                intOrNull = null;
                                            }
                                            String finalImdbId16 = finalImdbId4;
                                            LoadData loadData11 = new LoadData(str11111111, str11111112, null, null, finalImdbId16, intOrNull, 12, null);
                                            List allTrailers116 = allTrailers2;
                                            Ref.ObjectRef tmdbIdStr116 = tmdbIdStr;
                                            StremioC$CatalogEntry$toLoadResponse$4 stremioC$CatalogEntry$toLoadResponse$115 = new StremioC$CatalogEntry$toLoadResponse$4(this, allTrailers116, fetchedRecommendations117, tmdbIdStr116, finalImdbId16, null);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider2);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers116);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations117);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId16);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr116);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                            stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                            stremioC$CatalogEntry$toLoadResponse$3.label = 3;
                                            obj5 = obj;
                                            $result = MainAPIKt.newMovieLoadResponse(stremioC116, str1111119, str11111110, tvType113, loadData11, stremioC$CatalogEntry$toLoadResponse$115, stremioC$CatalogEntry$toLoadResponse$3);
                                            if ($result == obj5) {
                                                return obj5;
                                            }
                                        } else {
                                            str = "tmdb:";
                                            extractedTmdbId2 = extractedTmdbId5;
                                        }
                                        if (tmdbIdStr2.element != null) {
                                            String detailUrl6 = "https://api.themoviedb.org/3/" + tmdbMediaType2 + '/' + ((String) tmdbIdStr2.element) + "?api_key=98ae14df2b8d8f8f8136499daf79f0e0&append_to_response=recommendations";
                                            Requests app10 = MainActivityKt.getApp();
                                            stremioC$CatalogEntry$toLoadResponse$3.L$0 = provider;
                                            imdbId4 = imdbId3;
                                            stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId4);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$2 = allTrailers2;
                                            stremioC$CatalogEntry$toLoadResponse$3.L$3 = fetchedRecommendations2;
                                            stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId2);
                                            stremioC$CatalogEntry$toLoadResponse$3.L$6 = finalImdbId2;
                                            stremioC$CatalogEntry$toLoadResponse$3.L$7 = tmdbIdStr2;
                                            stremioC$CatalogEntry$toLoadResponse$3.L$8 = tmdbMediaType2;
                                            stremioC$CatalogEntry$toLoadResponse$3.L$9 = SpillingKt.nullOutSpilledVariable(detailUrl6);
                                            stremioC$CatalogEntry$toLoadResponse$3.I$0 = i;
                                            stremioC$CatalogEntry$toLoadResponse$3.label = 2;
                                            tmdbIdStr3 = tmdbIdStr2;
                                            fetchedRecommendations3 = fetchedRecommendations2;
                                            allTrailers3 = allTrailers2;
                                            tmdbMediaType4 = tmdbMediaType2;
                                            stremioC$CatalogEntry$toLoadResponse$2 = stremioC$CatalogEntry$toLoadResponse$3;
                                            finalImdbId5 = finalImdbId2;
                                            obj3 = Requests.get$default(app10, detailUrl6, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, stremioC$CatalogEntry$toLoadResponse$2, 4094, (Object) null);
                                            stremioC$CatalogEntry$toLoadResponse$3 = stremioC$CatalogEntry$toLoadResponse$2;
                                            if (obj3 == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            imdbId2 = imdbId4;
                                            fetchedRecommendations4 = fetchedRecommendations3;
                                            tmdbMediaType5 = tmdbMediaType4;
                                            extractedTmdbId = extractedTmdbId2;
                                            finalImdbId = finalImdbId5;
                                            tmdbIdStr = tmdbIdStr3;
                                            allTrailers = allTrailers3;
                                            NiceResponse this_$iv10 = (NiceResponse) obj3;
                                            ResponseParser parser10 = this_$iv10.getParser();
                                            Intrinsics.checkNotNull(parser10);
                                            obj = coroutine_suspended;
                                            safe2 = parser10.parseSafe(this_$iv10.getText(), Reflection.getOrCreateKotlinClass(TmdbDetailResponse.class));
                                            detailRes = (TmdbDetailResponse) safe2;
                                            if (detailRes != null) {
                                                provider2 = provider;
                                                arrayList = null;
                                                fetchedRecommendations4.element = arrayList;
                                                finalImdbId4 = finalImdbId;
                                                allTrailers2 = allTrailers;
                                                fetchedRecommendations2 = fetchedRecommendations4;
                                            } else {
                                                provider2 = provider;
                                                arrayList = null;
                                                fetchedRecommendations4.element = arrayList;
                                                finalImdbId4 = finalImdbId;
                                                allTrailers2 = allTrailers;
                                                fetchedRecommendations2 = fetchedRecommendations4;
                                            }
                                        } else {
                                            obj = coroutine_suspended;
                                            imdbId2 = imdbId3;
                                            provider2 = provider;
                                            extractedTmdbId = extractedTmdbId2;
                                            finalImdbId4 = finalImdbId2;
                                            tmdbIdStr = tmdbIdStr2;
                                        }
                                    } catch (Exception e18) {
                                        obj = coroutine_suspended;
                                        imdbId2 = imdbId3;
                                        extractedImdbId = extractedImdbId2;
                                        fetchedRecommendations = fetchedRecommendations2;
                                        extractedTmdbId = extractedTmdbId2;
                                        finalImdbId = finalImdbId2;
                                        tmdbIdStr = tmdbIdStr2;
                                        allTrailers = allTrailers2;
                                    }
                                    imdbId3 = imdbId;
                                    fetchedRecommendations2 = fetchedRecommendations5;
                                    finalImdbId2 = finalImdbId;
                                    tmdbIdStr2 = tmdbIdStr4;
                                    allTrailers2 = allTrailers4;
                                    tmdbMediaType2 = tmdbMediaType;
                                } catch (Exception e19) {
                                    obj = coroutine_suspended;
                                    provider = provider;
                                    imdbId2 = imdbId;
                                    extractedImdbId = extractedImdbId2;
                                    fetchedRecommendations = fetchedRecommendations5;
                                    extractedTmdbId = extractedTmdbId5;
                                    tmdbIdStr = tmdbIdStr4;
                                    allTrailers = allTrailers4;
                                }
                            } catch (Exception e20) {
                                imdbId2 = imdbId;
                                allTrailers = allTrailers4;
                                obj = coroutine_suspended;
                                fetchedRecommendations = fetchedRecommendations5;
                                extractedImdbId = it;
                                extractedTmdbId = extractedTmdbId5;
                                tmdbIdStr = tmdbIdStr4;
                                provider = provider;
                            }
                            list = this.videos;
                            if (list != null) {
                                z2 = true;
                            } else {
                                z2 = true;
                            }
                            if (z2) {
                                Ref.ObjectRef fetchedRecommendations118 = fetchedRecommendations2;
                                List allTrailers117 = allTrailers2;
                                Ref.ObjectRef tmdbIdStr117 = tmdbIdStr;
                                obj4 = obj;
                                provider4 = provider2;
                                StremioC stremioC117 = provider4;
                                String str11111113 = this.name;
                                String str11111114 = provider4.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                TvType tvType114 = TvType.TvSeries;
                                $this$map$iv = this.videos;
                                $i$f$map = 0;
                                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                while (r17.hasNext()) {
                                    Iterable $this$map$iv14 = $this$map$iv;
                                    Video it18 = (Video) item$iv$iv2;
                                    destination$iv$iv.add(it18.toEpisode(provider4, this.type, finalImdbId4));
                                    $this$map$iv = $this$map$iv14;
                                    $i$f$map = $i$f$map;
                                }
                                StremioC$CatalogEntry$toLoadResponse$6 stremioC$CatalogEntry$toLoadResponse$116 = new StremioC$CatalogEntry$toLoadResponse$6(this, allTrailers117, fetchedRecommendations118, tmdbIdStr117, finalImdbId4, null);
                                stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider4);
                                stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers117);
                                stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations118);
                                stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId4);
                                stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr117);
                                stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                stremioC$CatalogEntry$toLoadResponse$3.label = 4;
                                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(stremioC117, str11111113, str11111114, tvType114, (List) destination$iv$iv, stremioC$CatalogEntry$toLoadResponse$116, stremioC$CatalogEntry$toLoadResponse$3);
                                if (objNewTvSeriesLoadResponse == obj4) {
                                    return obj4;
                                }
                                return objNewTvSeriesLoadResponse;
                            }
                            StremioC stremioC118 = provider2;
                            String str11111115 = this.name;
                            String str11111116 = provider2.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                            Ref.ObjectRef fetchedRecommendations119 = fetchedRecommendations2;
                            TvType tvType115 = TvType.Movie;
                            String str11111117 = this.type;
                            String str11111118 = this.id;
                            str3 = this.yearNum;
                            if (str3 != null) {
                                intOrNull = StringsKt.toIntOrNull(str3);
                            } else {
                                intOrNull = null;
                            }
                            String finalImdbId17 = finalImdbId4;
                            LoadData loadData12 = new LoadData(str11111117, str11111118, null, null, finalImdbId17, intOrNull, 12, null);
                            List allTrailers118 = allTrailers2;
                            Ref.ObjectRef tmdbIdStr118 = tmdbIdStr;
                            StremioC$CatalogEntry$toLoadResponse$4 stremioC$CatalogEntry$toLoadResponse$117 = new StremioC$CatalogEntry$toLoadResponse$4(this, allTrailers118, fetchedRecommendations119, tmdbIdStr118, finalImdbId17, null);
                            stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider2);
                            stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                            stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers118);
                            stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations119);
                            stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                            stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                            stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId17);
                            stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr118);
                            stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                            stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                            stremioC$CatalogEntry$toLoadResponse$3.label = 3;
                            obj5 = obj;
                            $result = MainAPIKt.newMovieLoadResponse(stremioC118, str11111115, str11111116, tvType115, loadData12, stremioC$CatalogEntry$toLoadResponse$117, stremioC$CatalogEntry$toLoadResponse$3);
                            if ($result == obj5) {
                                return obj5;
                            }
                        }
                    } catch (Exception e21) {
                        obj = coroutine_suspended;
                        String str20 = it;
                        provider = provider;
                        imdbId2 = imdbId;
                        extractedImdbId = str20;
                        fetchedRecommendations = fetchedRecommendations5;
                        extractedTmdbId = extractedTmdbId5;
                        tmdbIdStr = tmdbIdStr4;
                        allTrailers = allTrailers4;
                    }
                    return $result;
                case 1:
                    int i4 = stremioC$CatalogEntry$toLoadResponse$3.I$0;
                    String tmdbMediaType6 = (String) stremioC$CatalogEntry$toLoadResponse$3.L$8;
                    tmdbIdStr = (Ref.ObjectRef) stremioC$CatalogEntry$toLoadResponse$3.L$7;
                    finalImdbId = (String) stremioC$CatalogEntry$toLoadResponse$3.L$6;
                    extractedTmdbId = (String) stremioC$CatalogEntry$toLoadResponse$3.L$5;
                    extractedImdbId3 = (String) stremioC$CatalogEntry$toLoadResponse$3.L$4;
                    i3 = i4;
                    fetchedRecommendations = (Ref.ObjectRef) stremioC$CatalogEntry$toLoadResponse$3.L$3;
                    allTrailers = (List) stremioC$CatalogEntry$toLoadResponse$3.L$2;
                    imdbId2 = (String) stremioC$CatalogEntry$toLoadResponse$3.L$1;
                    StremioC provider5 = (StremioC) stremioC$CatalogEntry$toLoadResponse$3.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        str = "tmdb:";
                        tmdbMediaType3 = tmdbMediaType6;
                        provider = provider5;
                        obj2 = $result;
                        str6 = "movie";
                        NiceResponse this_$iv11 = (NiceResponse) obj2;
                        ResponseParser parser11 = this_$iv11.getParser();
                        Intrinsics.checkNotNull(parser11);
                        provider3 = provider;
                        safe = parser11.parseSafe(this_$iv11.getText(), Reflection.getOrCreateKotlinClass(TmdbFindResponse.class));
                        findRes = (TmdbFindResponse) safe;
                        if (i3 != 0) {
                            if (findRes != null) {
                            }
                            tmdbId = null;
                        } else {
                            if (findRes != null) {
                            }
                            tmdbId = null;
                        }
                        if (tmdbId != null) {
                            tmdbIdStr.element = String.valueOf(tmdbId.intValue());
                        }
                        provider = provider3;
                        finalImdbId2 = finalImdbId;
                        extractedImdbId2 = extractedImdbId3;
                        tmdbIdStr2 = tmdbIdStr;
                        extractedTmdbId2 = extractedTmdbId;
                        i = i3;
                        fetchedRecommendations2 = fetchedRecommendations;
                        allTrailers2 = allTrailers;
                        imdbId3 = imdbId2;
                        tmdbMediaType2 = tmdbMediaType3;
                        if (tmdbIdStr2.element != null) {
                            String detailUrl7 = "https://api.themoviedb.org/3/" + tmdbMediaType2 + '/' + ((String) tmdbIdStr2.element) + "?api_key=98ae14df2b8d8f8f8136499daf79f0e0&append_to_response=recommendations";
                            Requests app11 = MainActivityKt.getApp();
                            stremioC$CatalogEntry$toLoadResponse$3.L$0 = provider;
                            imdbId4 = imdbId3;
                            stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId4);
                            stremioC$CatalogEntry$toLoadResponse$3.L$2 = allTrailers2;
                            stremioC$CatalogEntry$toLoadResponse$3.L$3 = fetchedRecommendations2;
                            stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                            stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId2);
                            stremioC$CatalogEntry$toLoadResponse$3.L$6 = finalImdbId2;
                            stremioC$CatalogEntry$toLoadResponse$3.L$7 = tmdbIdStr2;
                            stremioC$CatalogEntry$toLoadResponse$3.L$8 = tmdbMediaType2;
                            stremioC$CatalogEntry$toLoadResponse$3.L$9 = SpillingKt.nullOutSpilledVariable(detailUrl7);
                            stremioC$CatalogEntry$toLoadResponse$3.I$0 = i;
                            stremioC$CatalogEntry$toLoadResponse$3.label = 2;
                            tmdbIdStr3 = tmdbIdStr2;
                            fetchedRecommendations3 = fetchedRecommendations2;
                            allTrailers3 = allTrailers2;
                            tmdbMediaType4 = tmdbMediaType2;
                            stremioC$CatalogEntry$toLoadResponse$2 = stremioC$CatalogEntry$toLoadResponse$3;
                            finalImdbId5 = finalImdbId2;
                            obj3 = Requests.get$default(app11, detailUrl7, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, stremioC$CatalogEntry$toLoadResponse$2, 4094, (Object) null);
                            stremioC$CatalogEntry$toLoadResponse$3 = stremioC$CatalogEntry$toLoadResponse$2;
                            if (obj3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            imdbId2 = imdbId4;
                            fetchedRecommendations4 = fetchedRecommendations3;
                            tmdbMediaType5 = tmdbMediaType4;
                            extractedTmdbId = extractedTmdbId2;
                            finalImdbId = finalImdbId5;
                            tmdbIdStr = tmdbIdStr3;
                            allTrailers = allTrailers3;
                            NiceResponse this_$iv12 = (NiceResponse) obj3;
                            ResponseParser parser12 = this_$iv12.getParser();
                            Intrinsics.checkNotNull(parser12);
                            obj = coroutine_suspended;
                            safe2 = parser12.parseSafe(this_$iv12.getText(), Reflection.getOrCreateKotlinClass(TmdbDetailResponse.class));
                            detailRes = (TmdbDetailResponse) safe2;
                            if (detailRes != null) {
                                provider2 = provider;
                                arrayList = null;
                                fetchedRecommendations4.element = arrayList;
                                finalImdbId4 = finalImdbId;
                                allTrailers2 = allTrailers;
                                fetchedRecommendations2 = fetchedRecommendations4;
                            } else {
                                provider2 = provider;
                                arrayList = null;
                                fetchedRecommendations4.element = arrayList;
                                finalImdbId4 = finalImdbId;
                                allTrailers2 = allTrailers;
                                fetchedRecommendations2 = fetchedRecommendations4;
                            }
                            return $result;
                        }
                        obj = coroutine_suspended;
                        imdbId2 = imdbId3;
                        provider2 = provider;
                        extractedTmdbId = extractedTmdbId2;
                        finalImdbId4 = finalImdbId2;
                        tmdbIdStr = tmdbIdStr2;
                        break;
                    } catch (Exception e22) {
                        obj = coroutine_suspended;
                        extractedImdbId = extractedImdbId3;
                        provider = provider5;
                        break;
                    }
                    list = this.videos;
                    if (list != null) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        StremioC stremioC119 = provider2;
                        String str11111119 = this.name;
                        String str111111110 = provider2.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                        Ref.ObjectRef fetchedRecommendations1110 = fetchedRecommendations2;
                        TvType tvType116 = TvType.Movie;
                        String str111111111 = this.type;
                        String str111111112 = this.id;
                        str3 = this.yearNum;
                        if (str3 != null) {
                            intOrNull = StringsKt.toIntOrNull(str3);
                        } else {
                            intOrNull = null;
                        }
                        String finalImdbId18 = finalImdbId4;
                        LoadData loadData13 = new LoadData(str111111111, str111111112, null, null, finalImdbId18, intOrNull, 12, null);
                        List allTrailers119 = allTrailers2;
                        Ref.ObjectRef tmdbIdStr119 = tmdbIdStr;
                        StremioC$CatalogEntry$toLoadResponse$4 stremioC$CatalogEntry$toLoadResponse$118 = new StremioC$CatalogEntry$toLoadResponse$4(this, allTrailers119, fetchedRecommendations1110, tmdbIdStr119, finalImdbId18, null);
                        stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider2);
                        stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                        stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers119);
                        stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations1110);
                        stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                        stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                        stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId18);
                        stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr119);
                        stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                        stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                        stremioC$CatalogEntry$toLoadResponse$3.label = 3;
                        obj5 = obj;
                        $result = MainAPIKt.newMovieLoadResponse(stremioC119, str11111119, str111111110, tvType116, loadData13, stremioC$CatalogEntry$toLoadResponse$118, stremioC$CatalogEntry$toLoadResponse$3);
                        if ($result == obj5) {
                            return obj5;
                        }
                        return $result;
                    }
                    Ref.ObjectRef fetchedRecommendations1111 = fetchedRecommendations2;
                    List allTrailers1110 = allTrailers2;
                    Ref.ObjectRef tmdbIdStr1110 = tmdbIdStr;
                    obj4 = obj;
                    provider4 = provider2;
                    StremioC stremioC1110 = provider4;
                    String str111111113 = this.name;
                    String str111111114 = provider4.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                    TvType tvType117 = TvType.TvSeries;
                    $this$map$iv = this.videos;
                    $i$f$map = 0;
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    while (r17.hasNext()) {
                        Iterable $this$map$iv15 = $this$map$iv;
                        Video it19 = (Video) item$iv$iv2;
                        destination$iv$iv.add(it19.toEpisode(provider4, this.type, finalImdbId4));
                        $this$map$iv = $this$map$iv15;
                        $i$f$map = $i$f$map;
                    }
                    StremioC$CatalogEntry$toLoadResponse$6 stremioC$CatalogEntry$toLoadResponse$119 = new StremioC$CatalogEntry$toLoadResponse$6(this, allTrailers1110, fetchedRecommendations1111, tmdbIdStr1110, finalImdbId4, null);
                    stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider4);
                    stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                    stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers1110);
                    stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations1111);
                    stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                    stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                    stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId4);
                    stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr1110);
                    stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                    stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                    stremioC$CatalogEntry$toLoadResponse$3.label = 4;
                    objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(stremioC1110, str111111113, str111111114, tvType117, (List) destination$iv$iv, stremioC$CatalogEntry$toLoadResponse$119, stremioC$CatalogEntry$toLoadResponse$3);
                    if (objNewTvSeriesLoadResponse == obj4) {
                        return obj4;
                    }
                    return objNewTvSeriesLoadResponse;
                case 2:
                    int i5 = stremioC$CatalogEntry$toLoadResponse$3.I$0;
                    tmdbMediaType5 = (String) stremioC$CatalogEntry$toLoadResponse$3.L$8;
                    tmdbIdStr = (Ref.ObjectRef) stremioC$CatalogEntry$toLoadResponse$3.L$7;
                    finalImdbId = (String) stremioC$CatalogEntry$toLoadResponse$3.L$6;
                    extractedTmdbId = (String) stremioC$CatalogEntry$toLoadResponse$3.L$5;
                    extractedImdbId = (String) stremioC$CatalogEntry$toLoadResponse$3.L$4;
                    fetchedRecommendations = (Ref.ObjectRef) stremioC$CatalogEntry$toLoadResponse$3.L$3;
                    allTrailers = (List) stremioC$CatalogEntry$toLoadResponse$3.L$2;
                    imdbId2 = (String) stremioC$CatalogEntry$toLoadResponse$3.L$1;
                    StremioC provider6 = (StremioC) stremioC$CatalogEntry$toLoadResponse$3.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        str = "tmdb:";
                        provider = provider6;
                        obj3 = $result;
                        extractedImdbId2 = extractedImdbId;
                        str6 = "movie";
                        fetchedRecommendations4 = fetchedRecommendations;
                        NiceResponse this_$iv13 = (NiceResponse) obj3;
                        ResponseParser parser13 = this_$iv13.getParser();
                        Intrinsics.checkNotNull(parser13);
                        obj = coroutine_suspended;
                        safe2 = parser13.parseSafe(this_$iv13.getText(), Reflection.getOrCreateKotlinClass(TmdbDetailResponse.class));
                        detailRes = (TmdbDetailResponse) safe2;
                        if (detailRes != null) {
                            provider2 = provider;
                            arrayList = null;
                            fetchedRecommendations4.element = arrayList;
                            finalImdbId4 = finalImdbId;
                            allTrailers2 = allTrailers;
                            fetchedRecommendations2 = fetchedRecommendations4;
                            list = this.videos;
                            if (list != null) {
                                z2 = true;
                            } else {
                                z2 = true;
                            }
                            if (z2) {
                                Ref.ObjectRef fetchedRecommendations1112 = fetchedRecommendations2;
                                List allTrailers1111 = allTrailers2;
                                Ref.ObjectRef tmdbIdStr1111 = tmdbIdStr;
                                obj4 = obj;
                                provider4 = provider2;
                                StremioC stremioC1111 = provider4;
                                String str111111115 = this.name;
                                String str111111116 = provider4.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                TvType tvType118 = TvType.TvSeries;
                                $this$map$iv = this.videos;
                                $i$f$map = 0;
                                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                while (r17.hasNext()) {
                                    Iterable $this$map$iv16 = $this$map$iv;
                                    Video it110 = (Video) item$iv$iv2;
                                    destination$iv$iv.add(it110.toEpisode(provider4, this.type, finalImdbId4));
                                    $this$map$iv = $this$map$iv16;
                                    $i$f$map = $i$f$map;
                                }
                                StremioC$CatalogEntry$toLoadResponse$6 stremioC$CatalogEntry$toLoadResponse$1110 = new StremioC$CatalogEntry$toLoadResponse$6(this, allTrailers1111, fetchedRecommendations1112, tmdbIdStr1111, finalImdbId4, null);
                                stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider4);
                                stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers1111);
                                stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations1112);
                                stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId4);
                                stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr1111);
                                stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                stremioC$CatalogEntry$toLoadResponse$3.label = 4;
                                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(stremioC1111, str111111115, str111111116, tvType118, (List) destination$iv$iv, stremioC$CatalogEntry$toLoadResponse$1110, stremioC$CatalogEntry$toLoadResponse$3);
                                if (objNewTvSeriesLoadResponse == obj4) {
                                    return obj4;
                                }
                                return objNewTvSeriesLoadResponse;
                            }
                            StremioC stremioC1112 = provider2;
                            String str111111117 = this.name;
                            String str111111118 = provider2.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                            Ref.ObjectRef fetchedRecommendations1113 = fetchedRecommendations2;
                            TvType tvType119 = TvType.Movie;
                            String str111111119 = this.type;
                            String str1111111110 = this.id;
                            str3 = this.yearNum;
                            if (str3 != null) {
                                intOrNull = StringsKt.toIntOrNull(str3);
                            } else {
                                intOrNull = null;
                            }
                            String finalImdbId19 = finalImdbId4;
                            LoadData loadData14 = new LoadData(str111111119, str1111111110, null, null, finalImdbId19, intOrNull, 12, null);
                            List allTrailers1112 = allTrailers2;
                            Ref.ObjectRef tmdbIdStr1112 = tmdbIdStr;
                            StremioC$CatalogEntry$toLoadResponse$4 stremioC$CatalogEntry$toLoadResponse$1111 = new StremioC$CatalogEntry$toLoadResponse$4(this, allTrailers1112, fetchedRecommendations1113, tmdbIdStr1112, finalImdbId19, null);
                            stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider2);
                            stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                            stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers1112);
                            stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations1113);
                            stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                            stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                            stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId19);
                            stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr1112);
                            stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                            stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                            stremioC$CatalogEntry$toLoadResponse$3.label = 3;
                            obj5 = obj;
                            $result = MainAPIKt.newMovieLoadResponse(stremioC1112, str111111117, str111111118, tvType119, loadData14, stremioC$CatalogEntry$toLoadResponse$1111, stremioC$CatalogEntry$toLoadResponse$3);
                            if ($result == obj5) {
                                return obj5;
                            }
                        } else {
                            provider2 = provider;
                            arrayList = null;
                            fetchedRecommendations4.element = arrayList;
                            finalImdbId4 = finalImdbId;
                            allTrailers2 = allTrailers;
                            fetchedRecommendations2 = fetchedRecommendations4;
                            list = this.videos;
                            if (list != null) {
                                z2 = true;
                            } else {
                                z2 = true;
                            }
                            if (z2) {
                                Ref.ObjectRef fetchedRecommendations1114 = fetchedRecommendations2;
                                List allTrailers1113 = allTrailers2;
                                Ref.ObjectRef tmdbIdStr1113 = tmdbIdStr;
                                obj4 = obj;
                                provider4 = provider2;
                                StremioC stremioC1113 = provider4;
                                String str1111111111 = this.name;
                                String str1111111112 = provider4.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                                TvType tvType1110 = TvType.TvSeries;
                                $this$map$iv = this.videos;
                                $i$f$map = 0;
                                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                while (r17.hasNext()) {
                                    Iterable $this$map$iv17 = $this$map$iv;
                                    Video it111 = (Video) item$iv$iv2;
                                    destination$iv$iv.add(it111.toEpisode(provider4, this.type, finalImdbId4));
                                    $this$map$iv = $this$map$iv17;
                                    $i$f$map = $i$f$map;
                                }
                                StremioC$CatalogEntry$toLoadResponse$6 stremioC$CatalogEntry$toLoadResponse$1112 = new StremioC$CatalogEntry$toLoadResponse$6(this, allTrailers1113, fetchedRecommendations1114, tmdbIdStr1113, finalImdbId4, null);
                                stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider4);
                                stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                                stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers1113);
                                stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations1114);
                                stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                                stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                                stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId4);
                                stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr1113);
                                stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                                stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                                stremioC$CatalogEntry$toLoadResponse$3.label = 4;
                                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse(stremioC1113, str1111111111, str1111111112, tvType1110, (List) destination$iv$iv, stremioC$CatalogEntry$toLoadResponse$1112, stremioC$CatalogEntry$toLoadResponse$3);
                                if (objNewTvSeriesLoadResponse == obj4) {
                                    return obj4;
                                }
                                return objNewTvSeriesLoadResponse;
                            }
                            StremioC stremioC1114 = provider2;
                            String str1111111113 = this.name;
                            String str1111111114 = provider2.getMainUrl() + "/meta/" + this.type + '/' + this.id + ".json";
                            Ref.ObjectRef fetchedRecommendations1115 = fetchedRecommendations2;
                            TvType tvType1111 = TvType.Movie;
                            String str1111111115 = this.type;
                            String str1111111116 = this.id;
                            str3 = this.yearNum;
                            if (str3 != null) {
                                intOrNull = StringsKt.toIntOrNull(str3);
                            } else {
                                intOrNull = null;
                            }
                            String finalImdbId110 = finalImdbId4;
                            LoadData loadData15 = new LoadData(str1111111115, str1111111116, null, null, finalImdbId110, intOrNull, 12, null);
                            List allTrailers1114 = allTrailers2;
                            Ref.ObjectRef tmdbIdStr1114 = tmdbIdStr;
                            StremioC$CatalogEntry$toLoadResponse$4 stremioC$CatalogEntry$toLoadResponse$1113 = new StremioC$CatalogEntry$toLoadResponse$4(this, allTrailers1114, fetchedRecommendations1115, tmdbIdStr1114, finalImdbId110, null);
                            stremioC$CatalogEntry$toLoadResponse$3.L$0 = SpillingKt.nullOutSpilledVariable(provider2);
                            stremioC$CatalogEntry$toLoadResponse$3.L$1 = SpillingKt.nullOutSpilledVariable(imdbId2);
                            stremioC$CatalogEntry$toLoadResponse$3.L$2 = SpillingKt.nullOutSpilledVariable(allTrailers1114);
                            stremioC$CatalogEntry$toLoadResponse$3.L$3 = SpillingKt.nullOutSpilledVariable(fetchedRecommendations1115);
                            stremioC$CatalogEntry$toLoadResponse$3.L$4 = SpillingKt.nullOutSpilledVariable(extractedImdbId2);
                            stremioC$CatalogEntry$toLoadResponse$3.L$5 = SpillingKt.nullOutSpilledVariable(extractedTmdbId);
                            stremioC$CatalogEntry$toLoadResponse$3.L$6 = SpillingKt.nullOutSpilledVariable(finalImdbId110);
                            stremioC$CatalogEntry$toLoadResponse$3.L$7 = SpillingKt.nullOutSpilledVariable(tmdbIdStr1114);
                            stremioC$CatalogEntry$toLoadResponse$3.L$8 = null;
                            stremioC$CatalogEntry$toLoadResponse$3.L$9 = null;
                            stremioC$CatalogEntry$toLoadResponse$3.label = 3;
                            obj5 = obj;
                            $result = MainAPIKt.newMovieLoadResponse(stremioC1114, str1111111113, str1111111114, tvType1111, loadData15, stremioC$CatalogEntry$toLoadResponse$1113, stremioC$CatalogEntry$toLoadResponse$3);
                            if ($result == obj5) {
                                return obj5;
                            }
                        }
                    } catch (Exception e23) {
                        obj = coroutine_suspended;
                        provider = provider6;
                        break;
                    }
                    return $result;
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
        public static final Unit toLoadResponse$lambda$5$0(String $posterUrl, MovieSearchResponse $this$newMovieSearchResponse) {
            $this$newMovieSearchResponse.setPosterUrl($posterUrl);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001Bñ\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n\u0012\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r\u0012\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e\u0012\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010)\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jø\u0001\u0010-\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n2\u0018\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0018\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f2\u0018\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0018\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000e2\u0018\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000fHÆ\u0001¢\u0006\u0002\u0010.J\u0014\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00102\u001a\u00020\tHÖ\u0081\u0004J\n\u00103\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u0015\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001a\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013¨\u00064"}, d2 = {"Lcom/phisher98/StremioC$Video;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "title", "name", "seasonNumber", "", "season", "number", "episode", "thumbnail", "overview", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTitle", "getName", "getSeasonNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNumber", "getEpisode", "getThumbnail", "getOverview", "getDescription", "toEpisode", "Lcom/lagradost/cloudstream3/Episode;", "provider", "Lcom/phisher98/StremioC;", "type", "imdbId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/phisher98/StremioC$Video;", "equals", "", "other", "hashCode", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    static final /* data */ class Video {

        @Nullable
        private final String description;

        @Nullable
        private final Integer episode;

        @Nullable
        private final String id;

        @Nullable
        private final String name;

        @Nullable
        private final Integer number;

        @Nullable
        private final String overview;

        @Nullable
        private final Integer seasonNumber;

        @Nullable
        private final String thumbnail;

        @Nullable
        private final String title;

        public Video() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        public static /* synthetic */ Video copy$default(Video video, String str, String str2, String str3, Integer num, Integer num2, Integer num3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = video.id;
            }
            if ((i & 2) != 0) {
                str2 = video.title;
            }
            if ((i & 4) != 0) {
                str3 = video.name;
            }
            if ((i & 8) != 0) {
                num = video.seasonNumber;
            }
            if ((i & 16) != 0) {
                num2 = video.number;
            }
            if ((i & 32) != 0) {
                num3 = video.episode;
            }
            if ((i & 64) != 0) {
                str4 = video.thumbnail;
            }
            if ((i & 128) != 0) {
                str5 = video.overview;
            }
            if ((i & 256) != 0) {
                str6 = video.description;
            }
            String str7 = str5;
            String str8 = str6;
            Integer num4 = num3;
            String str9 = str4;
            Integer num5 = num2;
            String str10 = str3;
            return video.copy(str, str2, str10, num, num5, num4, str9, str7, str8);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Integer getSeasonNumber() {
            return this.seasonNumber;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Integer getNumber() {
            return this.number;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getThumbnail() {
            return this.thumbnail;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final Video copy(@JsonProperty("id") @Nullable String id, @JsonProperty("title") @Nullable String title, @JsonProperty("name") @Nullable String name, @JsonProperty("season") @Nullable Integer seasonNumber, @JsonProperty("number") @Nullable Integer number, @JsonProperty("episode") @Nullable Integer episode, @JsonProperty("thumbnail") @Nullable String thumbnail, @JsonProperty("overview") @Nullable String overview, @JsonProperty("description") @Nullable String description) {
            return new Video(id, title, name, seasonNumber, number, episode, thumbnail, overview, description);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Video)) {
                return false;
            }
            Video video = (Video) other;
            return Intrinsics.areEqual(this.id, video.id) && Intrinsics.areEqual(this.title, video.title) && Intrinsics.areEqual(this.name, video.name) && Intrinsics.areEqual(this.seasonNumber, video.seasonNumber) && Intrinsics.areEqual(this.number, video.number) && Intrinsics.areEqual(this.episode, video.episode) && Intrinsics.areEqual(this.thumbnail, video.thumbnail) && Intrinsics.areEqual(this.overview, video.overview) && Intrinsics.areEqual(this.description, video.description);
        }

        public int hashCode() {
            return ((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.seasonNumber == null ? 0 : this.seasonNumber.hashCode())) * 31) + (this.number == null ? 0 : this.number.hashCode())) * 31) + (this.episode == null ? 0 : this.episode.hashCode())) * 31) + (this.thumbnail == null ? 0 : this.thumbnail.hashCode())) * 31) + (this.overview == null ? 0 : this.overview.hashCode())) * 31) + (this.description != null ? this.description.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Video(id=" + this.id + ", title=" + this.title + ", name=" + this.name + ", seasonNumber=" + this.seasonNumber + ", number=" + this.number + ", episode=" + this.episode + ", thumbnail=" + this.thumbnail + ", overview=" + this.overview + ", description=" + this.description + ')';
        }

        public Video(@JsonProperty("id") @Nullable String id, @JsonProperty("title") @Nullable String title, @JsonProperty("name") @Nullable String name, @JsonProperty("season") @Nullable Integer seasonNumber, @JsonProperty("number") @Nullable Integer number, @JsonProperty("episode") @Nullable Integer episode, @JsonProperty("thumbnail") @Nullable String thumbnail, @JsonProperty("overview") @Nullable String overview, @JsonProperty("description") @Nullable String description) {
            this.id = id;
            this.title = title;
            this.name = name;
            this.seasonNumber = seasonNumber;
            this.number = number;
            this.episode = episode;
            this.thumbnail = thumbnail;
            this.overview = overview;
            this.description = description;
        }

        public /* synthetic */ Video(String str, String str2, String str3, Integer num, Integer num2, Integer num3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2, (i & 32) != 0 ? null : num3, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : str6);
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final Integer getSeasonNumber() {
            return this.seasonNumber;
        }

        @Nullable
        public final Integer getNumber() {
            return this.number;
        }

        @Nullable
        public final Integer getEpisode() {
            return this.episode;
        }

        @Nullable
        public final String getThumbnail() {
            return this.thumbnail;
        }

        @Nullable
        public final String getOverview() {
            return this.overview;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final Episode toEpisode(@NotNull StremioC provider, @Nullable String type, @Nullable String imdbId) {
            StremioC stremioC = provider;
            String str = this.id;
            Integer num = this.seasonNumber;
            Integer num2 = this.episode;
            if (num2 == null) {
                num2 = this.number;
            }
            return MainAPIKt.newEpisode(stremioC, new LoadData(type, str, num, num2, imdbId, null, 32, null), new Function1() { // from class: com.phisher98.StremioC$Video$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return StremioC.Video.toEpisode$lambda$0(this.f$0, (Episode) obj);
                }
            });
        }

        static final Unit toEpisode$lambda$0(Video this$0, Episode $this$newEpisode) {
            String str = this$0.name;
            if (str == null) {
                str = this$0.title;
            }
            $this$newEpisode.setName(str);
            $this$newEpisode.setPosterUrl(this$0.thumbnail);
            String str2 = this$0.overview;
            if (str2 == null) {
                str2 = this$0.description;
            }
            $this$newEpisode.setDescription(str2);
            $this$newEpisode.setSeason(this$0.seasonNumber);
            Integer num = this$0.episode;
            if (num == null) {
                num = this$0.number;
            }
            $this$newEpisode.setEpisode(num);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/phisher98/StremioC$StreamsResponse;", "", "streams", "", "Lcom/phisher98/StremioC$Stream;", "<init>", "(Ljava/util/List;)V", "getStreams", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final /* data */ class StreamsResponse {

        @NotNull
        private final List<Stream> streams;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StreamsResponse copy$default(StreamsResponse streamsResponse, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = streamsResponse.streams;
            }
            return streamsResponse.copy(list);
        }

        @NotNull
        public final List<Stream> component1() {
            return this.streams;
        }

        @NotNull
        public final StreamsResponse copy(@NotNull List<Stream> streams) {
            return new StreamsResponse(streams);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof StreamsResponse) && Intrinsics.areEqual(this.streams, ((StreamsResponse) other).streams);
        }

        public int hashCode() {
            return this.streams.hashCode();
        }

        @NotNull
        public String toString() {
            return "StreamsResponse(streams=" + this.streams + ')';
        }

        public StreamsResponse(@NotNull List<Stream> list) {
            this.streams = list;
        }

        @NotNull
        public final List<Stream> getStreams() {
            return this.streams;
        }
    }

    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/phisher98/StremioC$Subtitle;", "", "url", "", "lang", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getLang", "getId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    private static final /* data */ class Subtitle {

        @Nullable
        private final String id;

        @Nullable
        private final String lang;

        @Nullable
        private final String url;

        public static /* synthetic */ Subtitle copy$default(Subtitle subtitle, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subtitle.url;
            }
            if ((i & 2) != 0) {
                str2 = subtitle.lang;
            }
            if ((i & 4) != 0) {
                str3 = subtitle.id;
            }
            return subtitle.copy(str, str2, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLang() {
            return this.lang;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final Subtitle copy(@Nullable String url, @Nullable String lang, @Nullable String id) {
            return new Subtitle(url, lang, id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Subtitle)) {
                return false;
            }
            Subtitle subtitle = (Subtitle) other;
            return Intrinsics.areEqual(this.url, subtitle.url) && Intrinsics.areEqual(this.lang, subtitle.lang) && Intrinsics.areEqual(this.id, subtitle.id);
        }

        public int hashCode() {
            return ((((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.lang == null ? 0 : this.lang.hashCode())) * 31) + (this.id != null ? this.id.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Subtitle(url=" + this.url + ", lang=" + this.lang + ", id=" + this.id + ')';
        }

        public Subtitle(@Nullable String url, @Nullable String lang, @Nullable String id) {
            this.url = url;
            this.lang = lang;
            this.id = id;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final String getLang() {
            return this.lang;
        }

        @Nullable
        public final String getId() {
            return this.id;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\n\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0004HÖ\u0081\u0004R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/phisher98/StremioC$ProxyHeaders;", "", "request", "", "", "<init>", "(Ljava/util/Map;)V", "getRequest", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    static final /* data */ class ProxyHeaders {

        @Nullable
        private final Map<String, String> request;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ProxyHeaders copy$default(ProxyHeaders proxyHeaders, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = proxyHeaders.request;
            }
            return proxyHeaders.copy(map);
        }

        @Nullable
        public final Map<String, String> component1() {
            return this.request;
        }

        @NotNull
        public final ProxyHeaders copy(@Nullable Map<String, String> request) {
            return new ProxyHeaders(request);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ProxyHeaders) && Intrinsics.areEqual(this.request, ((ProxyHeaders) other).request);
        }

        public int hashCode() {
            if (this.request == null) {
                return 0;
            }
            return this.request.hashCode();
        }

        @NotNull
        public String toString() {
            return "ProxyHeaders(request=" + this.request + ')';
        }

        public ProxyHeaders(@Nullable Map<String, String> map) {
            this.request = map;
        }

        @Nullable
        public final Map<String, String> getRequest() {
            return this.request;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0006HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/phisher98/StremioC$BehaviorHints;", "", "proxyHeaders", "Lcom/phisher98/StremioC$ProxyHeaders;", "headers", "", "", "<init>", "(Lcom/phisher98/StremioC$ProxyHeaders;Ljava/util/Map;)V", "getProxyHeaders", "()Lcom/phisher98/StremioC$ProxyHeaders;", "getHeaders", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    static final /* data */ class BehaviorHints {

        @Nullable
        private final Map<String, String> headers;

        @Nullable
        private final ProxyHeaders proxyHeaders;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ BehaviorHints copy$default(BehaviorHints behaviorHints, ProxyHeaders proxyHeaders, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                proxyHeaders = behaviorHints.proxyHeaders;
            }
            if ((i & 2) != 0) {
                map = behaviorHints.headers;
            }
            return behaviorHints.copy(proxyHeaders, map);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ProxyHeaders getProxyHeaders() {
            return this.proxyHeaders;
        }

        @Nullable
        public final Map<String, String> component2() {
            return this.headers;
        }

        @NotNull
        public final BehaviorHints copy(@Nullable ProxyHeaders proxyHeaders, @Nullable Map<String, String> headers) {
            return new BehaviorHints(proxyHeaders, headers);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BehaviorHints)) {
                return false;
            }
            BehaviorHints behaviorHints = (BehaviorHints) other;
            return Intrinsics.areEqual(this.proxyHeaders, behaviorHints.proxyHeaders) && Intrinsics.areEqual(this.headers, behaviorHints.headers);
        }

        public int hashCode() {
            return ((this.proxyHeaders == null ? 0 : this.proxyHeaders.hashCode()) * 31) + (this.headers != null ? this.headers.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "BehaviorHints(proxyHeaders=" + this.proxyHeaders + ", headers=" + this.headers + ')';
        }

        public BehaviorHints(@Nullable ProxyHeaders proxyHeaders, @Nullable Map<String, String> map) {
            this.proxyHeaders = proxyHeaders;
            this.headers = map;
        }

        @Nullable
        public final ProxyHeaders getProxyHeaders() {
            return this.proxyHeaders;
        }

        @Nullable
        public final Map<String, String> getHeaders() {
            return this.headers;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StremioC.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001Bw\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0004\b\u0010\u0010\u0011J6\u0010\u001f\u001a\u00020 2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020 0\"2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020 0\"H\u0086@¢\u0006\u0002\u0010&J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030\rHÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0\rHÆ\u0003J\u0089\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\rHÆ\u0001J\u0014\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00105\u001a\u000206HÖ\u0081\u0004J\n\u00107\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001d¨\u00068"}, d2 = {"Lcom/phisher98/StremioC$Stream;", "", "name", "", "title", "url", "description", "ytId", "externalUrl", "behaviorHints", "Lcom/phisher98/StremioC$BehaviorHints;", "infoHash", "sources", "", "subtitles", "Lcom/phisher98/StremioC$Subtitle;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/phisher98/StremioC$BehaviorHints;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getTitle", "getUrl", "getDescription", "getYtId", "getExternalUrl", "getBehaviorHints", "()Lcom/phisher98/StremioC$BehaviorHints;", "getInfoHash", "getSources", "()Ljava/util/List;", "getSubtitles", "runCallback", "", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nStremioC.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StremioC.kt\ncom/phisher98/StremioC$Stream\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1058:1\n2068#2,2:1059\n788#2:1061\n800#2:1062\n2077#2,2:1063\n801#2,2:1065\n2079#2:1067\n803#2:1068\n777#2:1069\n873#2,2:1070\n777#2:1072\n873#2,2:1073\n1739#2:1075\n1814#2,3:1076\n777#2:1079\n873#2,2:1080\n*S KotlinDebug\n*F\n+ 1 StremioC.kt\ncom/phisher98/StremioC$Stream\n*L\n633#1:1059,2\n653#1:1061\n653#1:1062\n653#1:1063,2\n653#1:1065,2\n653#1:1067\n653#1:1068\n654#1:1069\n654#1:1070,2\n657#1:1072\n657#1:1073,2\n658#1:1075\n658#1:1076,3\n659#1:1079\n659#1:1080,2\n*E\n"})
    static final /* data */ class Stream {

        @Nullable
        private final BehaviorHints behaviorHints;

        @Nullable
        private final String description;

        @Nullable
        private final String externalUrl;

        @Nullable
        private final String infoHash;

        @Nullable
        private final String name;

        @NotNull
        private final List<String> sources;

        @NotNull
        private final List<Subtitle> subtitles;

        @Nullable
        private final String title;

        @Nullable
        private final String url;

        @Nullable
        private final String ytId;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Stream copy$default(Stream stream, String str, String str2, String str3, String str4, String str5, String str6, BehaviorHints behaviorHints, String str7, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stream.name;
            }
            if ((i & 2) != 0) {
                str2 = stream.title;
            }
            if ((i & 4) != 0) {
                str3 = stream.url;
            }
            if ((i & 8) != 0) {
                str4 = stream.description;
            }
            if ((i & 16) != 0) {
                str5 = stream.ytId;
            }
            if ((i & 32) != 0) {
                str6 = stream.externalUrl;
            }
            if ((i & 64) != 0) {
                behaviorHints = stream.behaviorHints;
            }
            if ((i & 128) != 0) {
                str7 = stream.infoHash;
            }
            if ((i & 256) != 0) {
                list = stream.sources;
            }
            if ((i & 512) != 0) {
                list2 = stream.subtitles;
            }
            List list3 = list;
            List list4 = list2;
            BehaviorHints behaviorHints2 = behaviorHints;
            String str8 = str7;
            String str9 = str5;
            String str10 = str6;
            return stream.copy(str, str2, str3, str4, str9, str10, behaviorHints2, str8, list3, list4);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final List<Subtitle> component10() {
            return this.subtitles;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getYtId() {
            return this.ytId;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getExternalUrl() {
            return this.externalUrl;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final BehaviorHints getBehaviorHints() {
            return this.behaviorHints;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getInfoHash() {
            return this.infoHash;
        }

        @NotNull
        public final List<String> component9() {
            return this.sources;
        }

        @NotNull
        public final Stream copy(@Nullable String name, @Nullable String title, @Nullable String url, @Nullable String description, @Nullable String ytId, @Nullable String externalUrl, @Nullable BehaviorHints behaviorHints, @Nullable String infoHash, @NotNull List<String> sources, @NotNull List<Subtitle> subtitles) {
            return new Stream(name, title, url, description, ytId, externalUrl, behaviorHints, infoHash, sources, subtitles);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Stream)) {
                return false;
            }
            Stream stream = (Stream) other;
            return Intrinsics.areEqual(this.name, stream.name) && Intrinsics.areEqual(this.title, stream.title) && Intrinsics.areEqual(this.url, stream.url) && Intrinsics.areEqual(this.description, stream.description) && Intrinsics.areEqual(this.ytId, stream.ytId) && Intrinsics.areEqual(this.externalUrl, stream.externalUrl) && Intrinsics.areEqual(this.behaviorHints, stream.behaviorHints) && Intrinsics.areEqual(this.infoHash, stream.infoHash) && Intrinsics.areEqual(this.sources, stream.sources) && Intrinsics.areEqual(this.subtitles, stream.subtitles);
        }

        public int hashCode() {
            return ((((((((((((((((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.ytId == null ? 0 : this.ytId.hashCode())) * 31) + (this.externalUrl == null ? 0 : this.externalUrl.hashCode())) * 31) + (this.behaviorHints == null ? 0 : this.behaviorHints.hashCode())) * 31) + (this.infoHash != null ? this.infoHash.hashCode() : 0)) * 31) + this.sources.hashCode()) * 31) + this.subtitles.hashCode();
        }

        @NotNull
        public String toString() {
            return "Stream(name=" + this.name + ", title=" + this.title + ", url=" + this.url + ", description=" + this.description + ", ytId=" + this.ytId + ", externalUrl=" + this.externalUrl + ", behaviorHints=" + this.behaviorHints + ", infoHash=" + this.infoHash + ", sources=" + this.sources + ", subtitles=" + this.subtitles + ')';
        }

        public Stream(@Nullable String name, @Nullable String title, @Nullable String url, @Nullable String description, @Nullable String ytId, @Nullable String externalUrl, @Nullable BehaviorHints behaviorHints, @Nullable String infoHash, @NotNull List<String> list, @NotNull List<Subtitle> list2) {
            this.name = name;
            this.title = title;
            this.url = url;
            this.description = description;
            this.ytId = ytId;
            this.externalUrl = externalUrl;
            this.behaviorHints = behaviorHints;
            this.infoHash = infoHash;
            this.sources = list;
            this.subtitles = list2;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ Stream(String str, String str2, String str3, String str4, String str5, String str6, BehaviorHints behaviorHints, String str7, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            List listEmptyList;
            List listEmptyList2;
            if ((i & 256) == 0) {
                listEmptyList = list;
            } else {
                listEmptyList = CollectionsKt.emptyList();
            }
            if ((i & 512) == 0) {
                listEmptyList2 = list2;
            } else {
                listEmptyList2 = CollectionsKt.emptyList();
            }
            this(str, str2, str3, str4, str5, str6, behaviorHints, str7, listEmptyList, listEmptyList2);
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getYtId() {
            return this.ytId;
        }

        @Nullable
        public final String getExternalUrl() {
            return this.externalUrl;
        }

        @Nullable
        public final BehaviorHints getBehaviorHints() {
            return this.behaviorHints;
        }

        @Nullable
        public final String getInfoHash() {
            return this.infoHash;
        }

        @NotNull
        public final List<String> getSources() {
            return this.sources;
        }

        @NotNull
        public final List<Subtitle> getSubtitles() {
            return this.subtitles;
        }

        /* JADX WARN: Code duplicated, block: B:30:0x0121  */
        /* JADX WARN: Code duplicated, block: B:32:0x0134  */
        /* JADX WARN: Code duplicated, block: B:33:0x0136  */
        /* JADX WARN: Code duplicated, block: B:36:0x013e  */
        /* JADX WARN: Code duplicated, block: B:39:0x0147 A[PHI: r12
          0x0147: PHI (r12v4 java.lang.String) = (r12v3 java.lang.String), (r12v10 java.lang.String) binds: [B:35:0x013c, B:37:0x0142] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:43:0x0150  */
        /* JADX WARN: Code duplicated, block: B:45:0x017b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:46:0x017c  */
        /* JADX WARN: Code duplicated, block: B:7:0x001a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x014d -> B:48:0x0189). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x017c -> B:47:0x0182). Please report as a decompilation issue!!! */
        /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
            java.lang.StackOverflowError
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
            */
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object runCallback(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r42, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r43, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r44) {
            /*
                Method dump skipped, instruction units count: 1160
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.phisher98.StremioC.Stream.runCallback(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
        }

        static final CharSequence runCallback$lambda$3(String it) {
            return "&tr=" + it;
        }

        static final CharSequence runCallback$lambda$7(String it) {
            return "&tr=" + it;
        }
    }
}
