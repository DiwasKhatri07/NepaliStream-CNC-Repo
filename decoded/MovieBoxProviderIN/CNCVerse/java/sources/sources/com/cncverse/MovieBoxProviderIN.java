package com.cncverse;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.kotlin.ExtensionsKt;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.MovieLoadResponse;
import com.lagradost.cloudstream3.MovieSearchResponse;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SearchResponseList;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.ui.settings.Globals;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.lang.reflect.Field;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
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
import kotlin.random.Random;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MovieBoxProviderIN.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/MovieBoxProviderIN/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 T2\u00020\u0001:\u0002TUB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0019\u0010\u001f\u001a\u00020\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0002\u0010\"J\u0006\u0010%\u001a\u00020\u0005J\u0006\u0010+\u001a\u00020,J>\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00052\b\u0010/\u001a\u0004\u0018\u00010\u00052\b\u00100\u001a\u0004\u0018\u00010\u00052\u0006\u00101\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u00010\u00052\u0006\u00103\u001a\u00020!H\u0003JS\u00104\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00052\b\u0010/\u001a\u0004\u0018\u00010\u00052\b\u00100\u001a\u0004\u0018\u00010\u00052\u0006\u00101\u001a\u00020\u00052\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u00105\u001a\u00020\u000e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0002\u00106J\u001e\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0096@¢\u0006\u0002\u0010=J\u001e\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00052\u0006\u00109\u001a\u00020:H\u0096@¢\u0006\u0002\u0010AJ\u0016\u0010B\u001a\u00020C2\u0006\u00101\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010DJF\u0010E\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u000e2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020K0I2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020K0IH\u0096@¢\u0006\u0002\u0010NJ\b\u0010O\u001a\u00020KH\u0002J\b\u0010P\u001a\u00020KH\u0002J\u0010\u0010Q\u001a\u00020K2\u0006\u00101\u001a\u00020\u0005H\u0002J\u0018\u0010R\u001a\u0004\u0018\u00010\u00052\u0006\u0010S\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010DR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010&\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R \u0010(\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050*0)X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/cncverse/MovieBoxProviderIN;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "secretKeyDefault", "secretKeyAlt", "md5", "input", "", "reverseString", "generateXClientToken", "hardcodedTimestamp", "", "(Ljava/lang/Long;)Ljava/lang/String;", "random", "Ljava/security/SecureRandom;", "generateDeviceId", "deviceId", "getDeviceId", "brandModels", "", "", "randomBrandModel", "Lcom/cncverse/MovieBoxProviderIN$BrandModel;", "buildCanonicalString", "method", "accept", "contentType", "url", "body", "timestamp", "generateXTrSignature", "useAltKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Long;)Ljava/lang/String;", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponseList;", "query", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showSubscriptionPopupIfNeeded", "showTelegramPopup", "openInExternalBrowser", "fetchAnonymousToken", "ua", "Companion", "BrandModel", "MovieBoxProviderIN_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMovieBoxProviderIN.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieBoxProviderIN.kt\ncom/cncverse/MovieBoxProviderIN\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 6 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,1408:1\n1642#2,10:1409\n1915#2:1419\n1642#2,10:1420\n1915#2:1430\n1916#2:1432\n1652#2:1433\n1642#2,10:1434\n1915#2:1444\n1916#2:1446\n1652#2:1447\n1642#2,10:1448\n1915#2:1458\n1916#2:1460\n1652#2:1461\n1916#2:1463\n1652#2:1464\n1642#2,10:1465\n1915#2:1475\n1916#2:1477\n1652#2:1478\n1696#2,8:1479\n1586#2:1487\n1661#2,3:1488\n1915#2,2:1491\n1915#2:1493\n1916#2:1501\n1915#2:1503\n296#2,2:1504\n1916#2:1513\n1915#2:1515\n1915#2,2:1516\n1916#2:1518\n1#3:1431\n1#3:1445\n1#3:1459\n1#3:1462\n1#3:1476\n1#3:1506\n383#4,7:1494\n221#5:1502\n222#5:1514\n437#6:1507\n513#6,5:1508\n*S KotlinDebug\n*F\n+ 1 MovieBoxProviderIN.kt\ncom/cncverse/MovieBoxProviderIN\n*L\n252#1:1409,10\n252#1:1419\n261#1:1420,10\n261#1:1430\n261#1:1432\n261#1:1433\n263#1:1434,10\n263#1:1444\n263#1:1446\n263#1:1447\n265#1:1448,10\n265#1:1458\n265#1:1460\n265#1:1461\n252#1:1463\n252#1:1464\n412#1:1465,10\n412#1:1475\n412#1:1477\n412#1:1478\n424#1:1479,8\n428#1:1487\n428#1:1488,3\n472#1:1491,2\n499#1:1493\n499#1:1501\n514#1:1503\n516#1:1504,2\n514#1:1513\n851#1:1515\n853#1:1516,2\n851#1:1518\n261#1:1431\n263#1:1445\n265#1:1459\n252#1:1462\n412#1:1476\n503#1:1494,7\n513#1:1502\n513#1:1514\n533#1:1507\n533#1:1508,5\n*E\n"})
public final class MovieBoxProviderIN extends MainAPI {
    private static final long BROWSER_DEBOUNCE_MS = 10000;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String OMG10 = "aHR0cHM6Ly9vbWcxMC5jb20vNC8xMTEwNDQ4OQ==";

    @Nullable
    private static volatile String bearerToken;

    @Nullable
    private static Context context;
    private static volatile boolean csGuardWasEverActive;
    private static volatile long lastBrowserOpenMs;
    private static volatile boolean subscriptionPopupShown;
    private static volatile boolean telegramPopupShown;

    @NotNull
    private String mainUrl = "https://api3.aoneroom.com";

    @NotNull
    private String name = "MovieBoxIN";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "ta";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries});

    @NotNull
    private final String secretKeyDefault = MainAPIKt.base64Decode("NzZpUmwwN3MweFNOOWpxbUVXQXQ3OUVCSlp1bElRSXNWNjRGWnIyTw==");

    @NotNull
    private final String secretKeyAlt = MainAPIKt.base64Decode("WHFuMm5uTzQxL0w5Mm8xaXVYaFNMSFRiWHZZNFo1Wlo2Mm04bVNMQQ==");

    @NotNull
    private final SecureRandom random = new SecureRandom();

    @NotNull
    private final String deviceId = generateDeviceId();

    @NotNull
    private final Map<String, List<String>> brandModels = MapsKt.mapOf(new Pair[]{TuplesKt.to("Samsung", CollectionsKt.listOf(new String[]{"SM-S918B", "SM-A528B", "SM-M336B"})), TuplesKt.to("Xiaomi", CollectionsKt.listOf(new String[]{"2201117TI", "M2012K11AI", "Redmi Note 11"})), TuplesKt.to("OnePlus", CollectionsKt.listOf(new String[]{"LE2111", "CPH2449", "IN2023"})), TuplesKt.to("Google", CollectionsKt.listOf(new String[]{"Pixel 6", "Pixel 7", "Pixel 8"})), TuplesKt.to("Realme", CollectionsKt.listOf(new String[]{"RMX3085", "RMX3360", "RMX3551"}))});

    /* JADX INFO: renamed from: com.cncverse.MovieBoxProviderIN$fetchAnonymousToken$1 */
    /* JADX INFO: compiled from: MovieBoxProviderIN.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieBoxProviderIN", f = "MovieBoxProviderIN.kt", i = {0, 0, 0, 0, 0}, l = {1145}, m = "fetchAnonymousToken", n = {"ua", "pingUrl", "xct", "sig", "headers"}, nl = {1146}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieBoxProviderIN.this.fetchAnonymousToken(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MovieBoxProviderIN$getMainPage$1 */
    /* JADX INFO: compiled from: MovieBoxProviderIN.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieBoxProviderIN", f = "MovieBoxProviderIN.kt", i = {0, 0, 0, 0, 0, 0}, l = {225}, m = "getMainPage", n = {"request", "url", "xClientToken", "xTrSignature", "headers", "page"}, nl = {226}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
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
            return MovieBoxProviderIN.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MovieBoxProviderIN$load$1 */
    /* JADX INFO: compiled from: MovieBoxProviderIN.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieBoxProviderIN", f = "MovieBoxProviderIN.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7}, l = {364, 378, 447, 453, 461, 489, 565, 580}, m = "load", n = {"url", "brand", "model", "ua", "clientInfo", "id", "finalUrl", "xClientToken", "xTrSignature", "versionCode", "url", "brand", "model", "ua", "clientInfo", "id", "finalUrl", "xClientToken", "xTrSignature", "token", "headers", "versionCode", "url", "brand", "model", "ua", "clientInfo", "id", "finalUrl", "xClientToken", "xTrSignature", "token", "headers", "response", "xUser", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "versionCode", "subjectType", "url", "brand", "model", "ua", "clientInfo", "id", "finalUrl", "xClientToken", "xTrSignature", "token", "headers", "response", "xUser", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "tmdbId", "imdbId", "versionCode", "subjectType", "url", "brand", "model", "ua", "clientInfo", "id", "finalUrl", "xClientToken", "xTrSignature", "token", "headers", "response", "xUser", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "tmdbId", "imdbId", "logoUrl", "versionCode", "subjectType", "url", "brand", "model", "ua", "clientInfo", "id", "finalUrl", "xClientToken", "xTrSignature", "token", "headers", "response", "xUser", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "tmdbId", "imdbId", "logoUrl", "meta", "metaVideos", "Poster", "Background", "Description", "IMDBRating", "allSubjectIds", "episodeMap", "subjectId", "seasonUrl", "seasonSig", "seasonHeaders", "versionCode", "subjectType", "url", "brand", "model", "ua", "clientInfo", "id", "finalUrl", "xClientToken", "xTrSignature", "token", "headers", "response", "xUser", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "tmdbId", "imdbId", "logoUrl", "meta", "metaVideos", "Poster", "Background", "Description", "IMDBRating", "allSubjectIds", "episodeMap", "episodes", "versionCode", "subjectType", "url", "brand", "model", "ua", "clientInfo", "id", "finalUrl", "xClientToken", "xTrSignature", "token", "headers", "response", "xUser", "body", "mapper", "root", "data", "title", "description", "releaseDate", "duration", "genre", "imdbRating", "year", "coverUrl", "backgroundUrl", "actors", "tags", "durationMinutes", "type", "tmdbId", "imdbId", "logoUrl", "meta", "metaVideos", "Poster", "Background", "Description", "IMDBRating", "versionCode", "subjectType"}, nl = {366, 379, 454, 461, 462, 490, 580, -1}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$33", "L$34", "L$35", "L$36", "L$37", "L$38", "L$39", "L$40", "L$42", "L$43", "L$44", "L$45", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$33", "L$34", "L$35", "L$36", "L$37", "L$38", "L$39", "L$40", "L$41", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$33", "L$34", "L$35", "L$36", "L$37", "L$38", "I$0", "I$1"}, v = 2)
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
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$21;
        Object L$22;
        Object L$23;
        Object L$24;
        Object L$25;
        Object L$26;
        Object L$27;
        Object L$28;
        Object L$29;
        Object L$3;
        Object L$30;
        Object L$31;
        Object L$32;
        Object L$33;
        Object L$34;
        Object L$35;
        Object L$36;
        Object L$37;
        Object L$38;
        Object L$39;
        Object L$4;
        Object L$40;
        Object L$41;
        Object L$42;
        Object L$43;
        Object L$44;
        Object L$45;
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
            return MovieBoxProviderIN.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MovieBoxProviderIN$loadLinks$1 */
    /* JADX INFO: compiled from: MovieBoxProviderIN.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieBoxProviderIN", f = "MovieBoxProviderIN.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, l = {642, 656, 693, 720, 739, 774, 785, 806, 818, 844, 861}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "brand", "model", "ua", "clientInfo", "parts", "originalSubjectId", "subjectUrl", "subjectXClientToken", "subjectXTrSignature", "isCasting", "versionCode", "season", "episode", "data", "subtitleCallback", "callback", "brand", "model", "ua", "clientInfo", "parts", "originalSubjectId", "subjectUrl", "subjectXClientToken", "subjectXTrSignature", "cachedToken", "subjectHeaders", "isCasting", "versionCode", "season", "episode", "data", "subtitleCallback", "callback", "brand", "model", "ua", "clientInfo", "parts", "originalSubjectId", "subjectUrl", "subjectXClientToken", "subjectXTrSignature", "cachedToken", "subjectHeaders", "subjectResponse", "mapper", "subjectIds", "originalLanguageName", "xUserHeader", "token", "isCasting", "versionCode", "season", "episode", "data", "subtitleCallback", "callback", "brand", "model", "ua", "clientInfo", "parts", "originalSubjectId", "subjectUrl", "subjectXClientToken", "subjectXTrSignature", "cachedToken", "subjectHeaders", "subjectResponse", "mapper", "subjectIds", "originalLanguageName", "xUserHeader", "token", "subjectId", "language", "url", "xClientToken", "xTrSignature", "headers", "isCasting", "versionCode", "season", "episode", "data", "subtitleCallback", "callback", "brand", "model", "ua", "clientInfo", "parts", "originalSubjectId", "subjectUrl", "subjectXClientToken", "subjectXTrSignature", "cachedToken", "subjectHeaders", "subjectResponse", "mapper", "subjectIds", "originalLanguageName", "xUserHeader", "token", "subjectId", "language", "url", "xClientToken", "xTrSignature", "headers", "response", "responseBody", "root", "playData", "streams", "stream", "streamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "id", "quality", "isCasting", "versionCode", "season", "episode", "data", "subtitleCallback", "callback", "brand", "model", "ua", "clientInfo", "parts", "originalSubjectId", "subjectUrl", "subjectXClientToken", "subjectXTrSignature", "cachedToken", "subjectHeaders", "subjectResponse", "mapper", "subjectIds", "originalLanguageName", "xUserHeader", "token", "subjectId", "language", "url", "xClientToken", "xTrSignature", "headers", "response", "responseBody", "root", "playData", "streams", "stream", "streamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "id", "quality", "subLink", "xClientToken", "xTrSignature", "headers", "isCasting", "versionCode", "season", "episode", "data", "subtitleCallback", "callback", "brand", "model", "ua", "clientInfo", "parts", "originalSubjectId", "subjectUrl", "subjectXClientToken", "subjectXTrSignature", "cachedToken", "subjectHeaders", "subjectResponse", "mapper", "subjectIds", "originalLanguageName", "xUserHeader", "token", "subjectId", "language", "url", "xClientToken", "xTrSignature", "headers", "response", "responseBody", "root", "playData", "streams", "stream", "streamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "id", "quality", "subLink", "xClientToken", "xTrSignature", "headers", "subResponse", "subRoot", "extCaptions", "caption", "captionUrl", "lang", "isCasting", "versionCode", "season", "episode", "data", "subtitleCallback", "callback", "brand", "model", "ua", "clientInfo", "parts", "originalSubjectId", "subjectUrl", "subjectXClientToken", "subjectXTrSignature", "cachedToken", "subjectHeaders", "subjectResponse", "mapper", "subjectIds", "originalLanguageName", "xUserHeader", "token", "subjectId", "language", "url", "xClientToken", "xTrSignature", "headers", "response", "responseBody", "root", "playData", "streams", "stream", "streamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "id", "quality", "subLink", "xClientToken", "xTrSignature", "headers", "subResponse", "subRoot", "extCaptions", "subLink1", "xClientToken1", "xTrSignature1", "headers1", "isCasting", "versionCode", "season", "episode", "data", "subtitleCallback", "callback", "brand", "model", "ua", "clientInfo", "parts", "originalSubjectId", "subjectUrl", "subjectXClientToken", "subjectXTrSignature", "cachedToken", "subjectHeaders", "subjectResponse", "mapper", "subjectIds", "originalLanguageName", "xUserHeader", "token", "subjectId", "language", "url", "xClientToken", "xTrSignature", "headers", "response", "responseBody", "root", "playData", "streams", "stream", "streamUrl", "format", "resolutions", "signCookieRaw", "signCookie", "id", "quality", "subLink", "xClientToken", "xTrSignature", "headers", "subResponse", "subRoot", "extCaptions", "subLink1", "xClientToken1", "xTrSignature1", "headers1", "subResponse1", "subRoot1", "extCaptions1", "caption", "captionUrl", "lang", "isCasting", "versionCode", "season", "episode", "data", "subtitleCallback", "callback", "brand", "model", "ua", "clientInfo", "parts", "originalSubjectId", "subjectUrl", "subjectXClientToken", "subjectXTrSignature", "cachedToken", "subjectHeaders", "subjectResponse", "mapper", "subjectIds", "originalLanguageName", "xUserHeader", "token", "subjectId", "language", "url", "xClientToken", "xTrSignature", "headers", "response", "responseBody", "root", "playData", "streams", "fallbackUrl", "fallbackHeaders", "isCasting", "versionCode", "season", "episode", "data", "subtitleCallback", "callback", "brand", "model", "ua", "clientInfo", "parts", "originalSubjectId", "subjectUrl", "subjectXClientToken", "subjectXTrSignature", "cachedToken", "subjectHeaders", "subjectResponse", "mapper", "subjectIds", "originalLanguageName", "xUserHeader", "token", "subjectId", "language", "url", "xClientToken", "xTrSignature", "headers", "response", "responseBody", "root", "playData", "streams", "fallbackUrl", "fallbackHeaders", "fallbackResponse", "fallbackRoot", "detectors", "$this$forEach$iv", "element$iv", "detector", "$this$forEach$iv", "element$iv", "video", "se", "link", "ep", "isCasting", "versionCode", "season", "episode", "$i$f$forEach", "$i$a$-forEach-MovieBoxProviderIN$loadLinks$5", "$i$f$forEach", "$i$a$-forEach-MovieBoxProviderIN$loadLinks$5$1", "quality"}, nl = {643, 657, 697, 721, 738, 775, 784, 808, 817, 846, 860}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "Z$0", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "Z$0", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "Z$0", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$33", "L$34", "L$35", "L$36", "L$37", "L$38", "L$39", "L$40", "Z$0", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$33", "L$34", "L$35", "L$36", "L$37", "L$38", "L$39", "L$40", "L$41", "L$42", "L$43", "L$44", "Z$0", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$33", "L$34", "L$35", "L$36", "L$37", "L$38", "L$39", "L$40", "L$41", "L$42", "L$43", "L$44", "L$45", "L$46", "L$47", "L$49", "L$50", "L$51", "Z$0", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$33", "L$34", "L$35", "L$36", "L$37", "L$38", "L$39", "L$40", "L$41", "L$42", "L$43", "L$44", "L$45", "L$46", "L$47", "L$48", "L$49", "L$50", "L$51", "Z$0", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$33", "L$34", "L$35", "L$36", "L$37", "L$38", "L$39", "L$40", "L$41", "L$42", "L$43", "L$44", "L$45", "L$46", "L$47", "L$48", "L$49", "L$50", "L$51", "L$52", "L$53", "L$54", "L$56", "L$57", "L$58", "Z$0", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$33", "Z$0", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$21", "L$22", "L$23", "L$24", "L$25", "L$26", "L$27", "L$28", "L$29", "L$30", "L$31", "L$32", "L$33", "L$34", "L$35", "L$36", "L$37", "L$39", "L$40", "L$41", "L$43", "L$44", "L$45", "L$46", "L$47", "Z$0", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "I$6", "I$7"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        int I$6;
        int I$7;
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
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$21;
        Object L$22;
        Object L$23;
        Object L$24;
        Object L$25;
        Object L$26;
        Object L$27;
        Object L$28;
        Object L$29;
        Object L$3;
        Object L$30;
        Object L$31;
        Object L$32;
        Object L$33;
        Object L$34;
        Object L$35;
        Object L$36;
        Object L$37;
        Object L$38;
        Object L$39;
        Object L$4;
        Object L$40;
        Object L$41;
        Object L$42;
        Object L$43;
        Object L$44;
        Object L$45;
        Object L$46;
        Object L$47;
        Object L$48;
        Object L$49;
        Object L$5;
        Object L$50;
        Object L$51;
        Object L$52;
        Object L$53;
        Object L$54;
        Object L$55;
        Object L$56;
        Object L$57;
        Object L$58;
        Object L$59;
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
            return MovieBoxProviderIN.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MovieBoxProviderIN$search$1 */
    /* JADX INFO: compiled from: MovieBoxProviderIN.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieBoxProviderIN", f = "MovieBoxProviderIN.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {296, 311}, m = "search", n = {"query", "brand", "model", "ua", "clientInfo", "url", "jsonBody", "xClientToken", "xTrSignature", "page", "versionCode", "query", "brand", "model", "ua", "clientInfo", "url", "jsonBody", "xClientToken", "xTrSignature", "token", "headers", "requestBody", "page", "versionCode"}, nl = {297, 317}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "I$1"}, v = 2)
    static final class C00071 extends ContinuationImpl {
        int I$0;
        int I$1;
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

        C00071(Continuation<? super C00071> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MovieBoxProviderIN.this.search(null, 0, (Continuation) this);
        }
    }

    /* JADX INFO: compiled from: MovieBoxProviderIN.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/cncverse/MovieBoxProviderIN$Companion;", "", "<init>", "()V", "isCsGuardActive", "", "csGuardWasEverActive", "isCsGuardBlocked", "showCsGuardToast", "", "ctx", "Landroid/content/Context;", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "OMG10", "", "lastBrowserOpenMs", "", "telegramPopupShown", "subscriptionPopupShown", "BROWSER_DEBOUNCE_MS", "bearerToken", "getBearerToken", "()Ljava/lang/String;", "setBearerToken", "(Ljava/lang/String;)V", "MovieBoxProviderIN_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nMovieBoxProviderIN.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieBoxProviderIN.kt\ncom/cncverse/MovieBoxProviderIN$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1408:1\n1#2:1409\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0042  */
        public final boolean isCsGuardActive() {
            String name;
            Class<?> cls;
            String name2;
            try {
                Class<?> cls2 = Class.forName("android.app.ActivityThread");
                Object thread = cls2.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
                Field field = cls2.getDeclaredField("mInstrumentation");
                field.setAccessible(true);
                Object obj = field.get(thread);
                if (obj == null || (cls = obj.getClass()) == null || (name2 = cls.getName()) == null) {
                    name = "";
                } else {
                    name = name2.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(name, "toLowerCase(...)");
                    if (name == null) {
                        name = "";
                    }
                }
                return StringsKt.contains$default(name, "guard", false, 2, (Object) null) || StringsKt.contains$default(name, "csguard", false, 2, (Object) null);
            } catch (Throwable th) {
                return false;
            }
        }

        public final boolean isCsGuardBlocked() {
            if (isCsGuardActive()) {
                MovieBoxProviderIN.csGuardWasEverActive = true;
            }
            return MovieBoxProviderIN.csGuardWasEverActive;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showCsGuardToast(final Context ctx) {
            if (ctx == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.MovieBoxProviderIN$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MovieBoxProviderIN.Companion.showCsGuardToast$lambda$0(ctx);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showCsGuardToast$lambda$0(Context $c) {
            Toast.makeText($c, "🚫 CSGuard detected — Restart CloudStream after removing CSGuard to use CNCRepo", 1).show();
        }

        @Nullable
        public final Context getContext() {
            return MovieBoxProviderIN.context;
        }

        public final void setContext(@Nullable Context context) {
            MovieBoxProviderIN.context = context;
        }

        @Nullable
        public final String getBearerToken() {
            return MovieBoxProviderIN.bearerToken;
        }

        public final void setBearerToken(@Nullable String str) {
            MovieBoxProviderIN.bearerToken = str;
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

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    private final String md5(byte[] input) {
        return ArraysKt.joinToString$default(MessageDigest.getInstance("MD5").digest(input), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.cncverse.MovieBoxProviderIN$$ExternalSyntheticLambda15
            public final Object invoke(Object obj) {
                return MovieBoxProviderIN.md5$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence md5$lambda$0(byte it) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private final String reverseString(String input) {
        return StringsKt.reversed(input).toString();
    }

    static /* synthetic */ String generateXClientToken$default(MovieBoxProviderIN movieBoxProviderIN, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        return movieBoxProviderIN.generateXClientToken(l);
    }

    private final String generateXClientToken(Long hardcodedTimestamp) {
        String timestamp = String.valueOf(hardcodedTimestamp != null ? hardcodedTimestamp.longValue() : System.currentTimeMillis());
        String reversed = reverseString(timestamp);
        byte[] bytes = reversed.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String hash = md5(bytes);
        return timestamp + ',' + hash;
    }

    @NotNull
    public final String generateDeviceId() {
        byte[] bytes = new byte[16];
        this.random.nextBytes(bytes);
        return ArraysKt.joinToString$default(bytes, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.cncverse.MovieBoxProviderIN$$ExternalSyntheticLambda14
            public final Object invoke(Object obj) {
                return MovieBoxProviderIN.generateDeviceId$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence generateDeviceId$lambda$0(byte it) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    @NotNull
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* JADX INFO: compiled from: MovieBoxProviderIN.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/cncverse/MovieBoxProviderIN$BrandModel;", "", "brand", "", "model", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getBrand", "()Ljava/lang/String;", "getModel", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "MovieBoxProviderIN_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class BrandModel {

        @NotNull
        private final String brand;

        @NotNull
        private final String model;

        public static /* synthetic */ BrandModel copy$default(BrandModel brandModel, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = brandModel.brand;
            }
            if ((i & 2) != 0) {
                str2 = brandModel.model;
            }
            return brandModel.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getBrand() {
            return this.brand;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getModel() {
            return this.model;
        }

        @NotNull
        public final BrandModel copy(@NotNull String brand, @NotNull String model) {
            return new BrandModel(brand, model);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BrandModel)) {
                return false;
            }
            BrandModel brandModel = (BrandModel) other;
            return Intrinsics.areEqual(this.brand, brandModel.brand) && Intrinsics.areEqual(this.model, brandModel.model);
        }

        public int hashCode() {
            return (this.brand.hashCode() * 31) + this.model.hashCode();
        }

        @NotNull
        public String toString() {
            return "BrandModel(brand=" + this.brand + ", model=" + this.model + ')';
        }

        public BrandModel(@NotNull String brand, @NotNull String model) {
            this.brand = brand;
            this.model = model;
        }

        @NotNull
        public final String getBrand() {
            return this.brand;
        }

        @NotNull
        public final String getModel() {
            return this.model;
        }
    }

    @NotNull
    public final BrandModel randomBrandModel() {
        String brand = (String) CollectionsKt.random(this.brandModels.keySet(), Random.Default);
        List<String> list = this.brandModels.get(brand);
        Intrinsics.checkNotNull(list);
        String model = (String) CollectionsKt.random(list, Random.Default);
        return new BrandModel(brand, model);
    }

    @SuppressLint({"UseKtx"})
    private final String buildCanonicalString(String method, String accept, String contentType, String url, String body, long timestamp) {
        byte[] bodyBytes;
        String bodyHash;
        String bodyLength;
        final Uri parsed = Uri.parse(url);
        String path = parsed.getPath();
        if (path == null) {
            path = "";
        }
        String query = !parsed.getQueryParameterNames().isEmpty() ? CollectionsKt.joinToString$default(CollectionsKt.sorted(parsed.getQueryParameterNames()), "&", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.cncverse.MovieBoxProviderIN$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return MovieBoxProviderIN.buildCanonicalString$lambda$0(parsed, (String) obj);
            }
        }, 30, (Object) null) : "";
        String canonicalUrl = query.length() > 0 ? path + '?' + query : path;
        if (body != null) {
            bodyBytes = body.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bodyBytes, "getBytes(...)");
        } else {
            bodyBytes = null;
        }
        if (bodyBytes != null) {
            byte[] trimmed = bodyBytes.length > 102400 ? ArraysKt.copyOfRange(bodyBytes, 0, 102400) : bodyBytes;
            bodyHash = md5(trimmed);
        } else {
            bodyHash = "";
        }
        if (bodyBytes == null || (bodyLength = String.valueOf(bodyBytes.length)) == null) {
            bodyLength = "";
        }
        StringBuilder sb = new StringBuilder();
        String upperCase = method.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return sb.append(upperCase).append('\n').append(accept == null ? "" : accept).append('\n').append(contentType != null ? contentType : "").append('\n').append(bodyLength).append('\n').append(timestamp).append('\n').append(bodyHash).append('\n').append(canonicalUrl).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence buildCanonicalString$lambda$0(Uri $parsed, final String key) {
        return CollectionsKt.joinToString$default($parsed.getQueryParameters(key), "&", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.cncverse.MovieBoxProviderIN$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                return MovieBoxProviderIN.buildCanonicalString$lambda$0$0(key, (String) obj);
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence buildCanonicalString$lambda$0$0(String $key, String value) {
        return $key + '=' + value;
    }

    static /* synthetic */ String generateXTrSignature$default(MovieBoxProviderIN movieBoxProviderIN, String str, String str2, String str3, String str4, String str5, boolean z, Long l, int i, Object obj) {
        if ((i & 16) != 0) {
            str5 = null;
        }
        if ((i & 32) != 0) {
            z = false;
        }
        if ((i & 64) != 0) {
            l = null;
        }
        return movieBoxProviderIN.generateXTrSignature(str, str2, str3, str4, str5, z, l);
    }

    private final String generateXTrSignature(String method, String accept, String contentType, String url, String body, boolean useAltKey, Long hardcodedTimestamp) throws NoSuchAlgorithmException, InvalidKeyException {
        long timestamp = hardcodedTimestamp != null ? hardcodedTimestamp.longValue() : System.currentTimeMillis();
        String canonical = buildCanonicalString(method, accept, contentType, url, body, timestamp);
        String secret = useAltKey ? this.secretKeyAlt : this.secretKeyDefault;
        byte[] secretBytes = MainAPIKt.base64DecodeArray(secret);
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(new SecretKeySpec(secretBytes, "HmacMD5"));
        byte[] bytes = canonical.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] signature = mac.doFinal(bytes);
        String signatureB64 = MainAPIKt.base64Encode(signature);
        return timestamp + "|2|" + signatureB64;
    }

    /* JADX WARN: Code duplicated, block: B:118:0x03d5  */
    /* JADX WARN: Code duplicated, block: B:136:0x0413 A[Catch: Exception -> 0x0459, TryCatch #3 {Exception -> 0x0459, blocks: (B:143:0x044c, B:136:0x0413, B:120:0x03dd, B:122:0x03e4, B:129:0x03f2, B:74:0x02ad, B:76:0x02b7, B:79:0x02c9, B:85:0x02ea, B:88:0x02fa, B:90:0x0302, B:92:0x030a, B:93:0x0323, B:95:0x0329, B:97:0x0349, B:100:0x035b, B:104:0x0371, B:107:0x0380, B:109:0x0389, B:110:0x039f, B:112:0x03a5, B:114:0x03bf, B:116:0x03c9, B:141:0x0434), top: B:162:0x01c1 }] */
    /* JADX WARN: Code duplicated, block: B:137:0x041a  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Failed to find 'out' block for switch in B:59:0x0252. Please report as an issue. */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00011 c00011;
        int page2;
        String responseBody;
        Boolean bool;
        List homePageLists;
        Iterable $this$mapNotNull$iv;
        NiceResponse response;
        HomePageList homePageList;
        Collection destination$iv$iv;
        String it;
        String type;
        List mediaList;
        Iterable iterable;
        Collection destination$iv$iv2;
        Iterable iterable2;
        Collection destination$iv$iv3;
        String str = "banner";
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
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                }
                showTelegramPopup();
                showSubscriptionPopupIfNeeded();
                String url = getMainUrl() + "/wefeed-mobile-bff/tab-operating?page=1&tabId=0&version=";
                String xClientToken = generateXClientToken$default(this, null, 1, null);
                String xTrSignature = generateXTrSignature$default(this, "GET", "application/json", "application/json", url, null, false, null, 112, null);
                Map headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("user-agent", "com.community.mbox.in/50020042 (Linux; U; Android 16; en_IN; sdk_gphone64_x86_64; Build/BP22.250325.006; Cronet/133.0.6876.3)"), TuplesKt.to("accept", "application/json"), TuplesKt.to("content-type", "application/json"), TuplesKt.to("connection", "keep-alive"), TuplesKt.to("x-client-token", xClientToken), TuplesKt.to("x-tr-signature", xTrSignature), TuplesKt.to("x-client-info", "{\"package_name\":\"com.community.mbox.in\",\"version_name\":\"3.0.03.0529.03\",\"version_code\":50020042,\"os\":\"android\",\"os_version\":\"16\",\"device_id\":\"" + this.deviceId + "\",\"install_store\":\"ps\",\"gaid\":\"d7578036d13336cc\",\"brand\":\"google\",\"model\":\"" + randomBrandModel() + "\",\"system_language\":\"en\",\"net\":\"NETWORK_WIFI\",\"region\":\"IN\",\"timezone\":\"Asia/Calcutta\",\"sp_code\":\"\"}"), TuplesKt.to("x-client-status", "0"), TuplesKt.to("x-play-mode", "2")});
                Requests app = MainActivityKt.getApp();
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(xClientToken);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(xTrSignature);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                page2 = page;
                c00012.I$0 = page2;
                c00012.label = 1;
                Object obj = Requests.get$default(app, url, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4092, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result = obj;
                break;
                break;
            case 1:
                int page3 = c00012.I$0;
                ResultKt.throwOnFailure($result);
                page2 = page3;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse response2 = (NiceResponse) $result;
        ResponseBody body = response2.getBody();
        if (body == null || (responseBody = body.string()) == null) {
            responseBody = "";
        }
        try {
            ObjectMapper mapper = ExtensionsKt.jacksonObjectMapper();
            JsonNode root = mapper.readTree(responseBody);
            JsonNode jsonNode = root.get("data");
            try {
                if (jsonNode != null && ($this$mapNotNull$iv = jsonNode.get("items")) != null) {
                    Collection destination$iv$iv4 = new ArrayList();
                    Collection destination$iv$iv5 = destination$iv$iv4;
                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                        JsonNode section = (JsonNode) element$iv$iv$iv;
                        Object $result2 = $result;
                        try {
                            JsonNode jsonNode2 = section.get("title");
                            if (jsonNode2 == null || (it = jsonNode2.asText()) == null) {
                                response = response2;
                            } else {
                                response = response2;
                                try {
                                    if (StringsKt.equals(it, str, true)) {
                                        it = "🔥Top Picks";
                                    }
                                    if (it != null) {
                                        String title = it;
                                        JsonNode jsonNode3 = section.get("type");
                                        if (jsonNode3 != null) {
                                            try {
                                                type = jsonNode3.asText();
                                            } catch (Exception e) {
                                                e = e;
                                                bool = null;
                                            }
                                        } else {
                                            type = null;
                                        }
                                        if (type != null) {
                                            switch (type.hashCode()) {
                                                case -83035752:
                                                    str = str;
                                                    page2 = page2;
                                                    responseBody = responseBody;
                                                    if (type.equals("SUBJECTS_MOVIE")) {
                                                        Iterable iterable3 = section.get("subjects");
                                                        if (iterable3 != null) {
                                                            Iterable $this$mapNotNull$iv2 = iterable3;
                                                            Collection destination$iv$iv6 = new ArrayList();
                                                            for (Object element$iv$iv$iv2 : $this$mapNotNull$iv2) {
                                                                JsonNode subjectItem = (JsonNode) element$iv$iv$iv2;
                                                                Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv2;
                                                                SearchResponse mainPage$parseSubject = getMainPage$parseSubject(this, subjectItem);
                                                                if (mainPage$parseSubject != null) {
                                                                    destination$iv$iv6.add(mainPage$parseSubject);
                                                                }
                                                                $this$mapNotNull$iv2 = $this$mapNotNull$iv3;
                                                            }
                                                            mediaList = (List) destination$iv$iv6;
                                                        } else {
                                                            mediaList = null;
                                                        }
                                                    } else {
                                                        mediaList = null;
                                                    }
                                                    break;
                                                case 1951953708:
                                                    page2 = page2;
                                                    responseBody = responseBody;
                                                    if (type.equals("BANNER")) {
                                                        JsonNode jsonNode4 = section.get(str);
                                                        if (jsonNode4 == null || (iterable = jsonNode4.get("banners")) == null) {
                                                            mediaList = null;
                                                        } else {
                                                            Iterable $this$mapNotNull$iv4 = iterable;
                                                            Collection destination$iv$iv7 = new ArrayList();
                                                            for (Object element$iv$iv$iv3 : $this$mapNotNull$iv4) {
                                                                JsonNode bannerItem = (JsonNode) element$iv$iv$iv3;
                                                                String str2 = str;
                                                                Iterable $this$mapNotNull$iv5 = $this$mapNotNull$iv4;
                                                                SearchResponse mainPage$parseSubject2 = getMainPage$parseSubject(this, bannerItem.get("subject"));
                                                                if (mainPage$parseSubject2 != null) {
                                                                    destination$iv$iv2 = destination$iv$iv7;
                                                                    destination$iv$iv2.add(mainPage$parseSubject2);
                                                                } else {
                                                                    destination$iv$iv2 = destination$iv$iv7;
                                                                }
                                                                destination$iv$iv7 = destination$iv$iv2;
                                                                $this$mapNotNull$iv4 = $this$mapNotNull$iv5;
                                                                str = str2;
                                                            }
                                                            str = str;
                                                            mediaList = (List) destination$iv$iv7;
                                                        }
                                                    } else {
                                                        str = str;
                                                        mediaList = null;
                                                    }
                                                    break;
                                                case 1999208305:
                                                    page2 = page2;
                                                    try {
                                                        if (type.equals("CUSTOM")) {
                                                            JsonNode jsonNode5 = section.get("customData");
                                                            if (jsonNode5 == null || (iterable2 = jsonNode5.get("items")) == null) {
                                                                str = str;
                                                                mediaList = null;
                                                            } else {
                                                                Iterable $this$mapNotNull$iv6 = iterable2;
                                                                Collection destination$iv$iv8 = new ArrayList();
                                                                for (Object element$iv$iv$iv4 : $this$mapNotNull$iv6) {
                                                                    JsonNode customItem = (JsonNode) element$iv$iv$iv4;
                                                                    Iterable $this$mapNotNull$iv7 = $this$mapNotNull$iv6;
                                                                    String responseBody2 = responseBody;
                                                                    SearchResponse mainPage$parseSubject3 = getMainPage$parseSubject(this, customItem.get("subject"));
                                                                    if (mainPage$parseSubject3 != null) {
                                                                        destination$iv$iv3 = destination$iv$iv8;
                                                                        destination$iv$iv3.add(mainPage$parseSubject3);
                                                                    } else {
                                                                        destination$iv$iv3 = destination$iv$iv8;
                                                                    }
                                                                    destination$iv$iv8 = destination$iv$iv3;
                                                                    responseBody = responseBody2;
                                                                    $this$mapNotNull$iv6 = $this$mapNotNull$iv7;
                                                                }
                                                                responseBody = responseBody;
                                                                str = str;
                                                                mediaList = (List) destination$iv$iv8;
                                                            }
                                                        } else {
                                                            str = str;
                                                            responseBody = responseBody;
                                                            mediaList = null;
                                                        }
                                                    } catch (Exception e2) {
                                                        e = e2;
                                                        bool = null;
                                                    }
                                                    break;
                                                default:
                                                    str = str;
                                                    page2 = page2;
                                                    responseBody = responseBody;
                                                    mediaList = null;
                                                    break;
                                            }
                                            return MainAPIKt.newHomePageResponse$default(homePageLists, bool, 2, bool);
                                        }
                                        str = str;
                                        page2 = page2;
                                        responseBody = responseBody;
                                        mediaList = null;
                                        List list = mediaList;
                                        homePageList = list == null || list.isEmpty() ? null : new HomePageList(title, mediaList, false, 4, (DefaultConstructorMarker) null);
                                    }
                                    if (homePageList != null) {
                                        destination$iv$iv = destination$iv$iv5;
                                        destination$iv$iv.add(homePageList);
                                    } else {
                                        destination$iv$iv = destination$iv$iv5;
                                    }
                                    response2 = response;
                                    destination$iv$iv5 = destination$iv$iv;
                                    $result = $result2;
                                    page2 = page2;
                                    responseBody = responseBody;
                                    str = str;
                                } catch (Exception e3) {
                                    e = e3;
                                    bool = null;
                                }
                            }
                            homePageList = null;
                            if (homePageList != null) {
                                destination$iv$iv = destination$iv$iv5;
                                destination$iv$iv.add(homePageList);
                            } else {
                                destination$iv$iv = destination$iv$iv5;
                            }
                            response2 = response;
                            destination$iv$iv5 = destination$iv$iv;
                            $result = $result2;
                            page2 = page2;
                            responseBody = responseBody;
                            str = str;
                        } catch (Exception e4) {
                            e = e4;
                            bool = null;
                        }
                    }
                    homePageLists = (List) destination$iv$iv5;
                    bool = null;
                    return MainAPIKt.newHomePageResponse$default(homePageLists, bool, 2, bool);
                }
                bool = null;
                try {
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                } catch (Exception e5) {
                    e = e5;
                }
            } catch (Exception e6) {
                e = e6;
                bool = null;
            }
        } catch (Exception e7) {
            e = e7;
            bool = null;
        }
        e.printStackTrace();
        homePageLists = CollectionsKt.emptyList();
        return MainAPIKt.newHomePageResponse$default(homePageLists, bool, 2, bool);
    }

    private static final SearchResponse getMainPage$parseSubject(MovieBoxProviderIN this$0, final JsonNode subjectJson) {
        JsonNode jsonNode;
        String subjectId;
        JsonNode jsonNode2;
        String title;
        JsonNode jsonNode3;
        if (subjectJson == null || (jsonNode = subjectJson.get("subjectId")) == null || (subjectId = jsonNode.asText()) == null || (jsonNode2 = subjectJson.get("title")) == null || (title = jsonNode2.asText()) == null) {
            return null;
        }
        JsonNode jsonNode4 = subjectJson.get("cover");
        final String coverUrl = (jsonNode4 == null || (jsonNode3 = jsonNode4.get("url")) == null) ? null : jsonNode3.asText();
        JsonNode jsonNode5 = subjectJson.get("subjectType");
        Integer numValueOf = jsonNode5 != null ? Integer.valueOf(jsonNode5.asInt()) : null;
        TvType subjectType = ((numValueOf != null && numValueOf.intValue() == 1) || numValueOf == null || numValueOf.intValue() != 2) ? TvType.Movie : TvType.TvSeries;
        return MainAPIKt.newMovieSearchResponse$default(this$0, title, subjectId, subjectType, false, new Function1() { // from class: com.cncverse.MovieBoxProviderIN$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return MovieBoxProviderIN.getMainPage$parseSubject$lambda$0(coverUrl, subjectJson, (MovieSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$parseSubject$lambda$0(String $coverUrl, JsonNode $subjectJson, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($coverUrl);
        Score.Companion companion = Score.Companion;
        JsonNode jsonNode = $subjectJson.get("imdbRatingValue");
        $this$newMovieSearchResponse.setScore(companion.from10(jsonNode != null ? jsonNode.asText() : null));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x021a  */
    /* JADX WARN: Code duplicated, block: B:34:0x021d  */
    /* JADX WARN: Code duplicated, block: B:39:0x0233  */
    /* JADX WARN: Code duplicated, block: B:41:0x0237  */
    /* JADX WARN: Code duplicated, block: B:42:0x0254  */
    /* JADX WARN: Code duplicated, block: B:45:0x033c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x033d  */
    /* JADX WARN: Code duplicated, block: B:49:0x036c  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:80:0x0404  */
    /* JADX WARN: Code duplicated, block: B:81:0x0409  */
    /* JADX WARN: Code duplicated, block: B:83:0x040d  */
    /* JADX WARN: Code duplicated, block: B:84:0x0412  */
    /* JADX WARN: Code duplicated, block: B:85:0x0417  */
    /* JADX WARN: Code duplicated, block: B:94:0x046d A[ADDED_TO_REGION, REMOVE] */
    @Nullable
    public Object search(@NotNull String query, int page, @NotNull Continuation<? super SearchResponseList> continuation) {
        C00071 c00071;
        String jsonBody;
        String brand;
        String xClientToken;
        Object $result;
        String clientInfo;
        Object obj;
        String model;
        String ua;
        String url;
        String ua2;
        String model2;
        String token;
        String clientInfo2;
        String xClientToken2;
        int versionCode;
        String query2;
        String xTrSignature;
        Object objFetchAnonymousToken;
        String clientInfo3;
        String model3;
        String xClientToken3;
        int versionCode2;
        String query3;
        String str;
        boolean z;
        Map $this$search_u24lambda_u240;
        String str2;
        Map $this$search_u24lambda_u241;
        Object obj2;
        Object objPost$default;
        String clientInfo4;
        String token2;
        String jsonBody2;
        JsonNode jsonNode;
        Boolean bool;
        JsonNode<JsonNode> results;
        String title;
        String id;
        String ua3;
        JsonNode jsonNode2;
        int subjectType;
        TvType tvType;
        int page2 = page;
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
        Object $result2 = c00072.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00072.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return MainAPIKt.newSearchResponseList$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                }
                BrandModel brandModelRandomBrandModel = randomBrandModel();
                String brand2 = brandModelRandomBrandModel.getBrand();
                String model4 = brandModelRandomBrandModel.getModel();
                String ua4 = "com.community.oneroom/50020042 (Linux; U; Android 13; en_US; " + brand2 + "; Build/TQ3A.230901.001; Cronet/145.0.7582.0)";
                String clientInfo5 = "{\"package_name\":\"com.community.oneroom\",\"version_name\":\"3.0.13.0325.03\",\"version_code\":50020042,\"os\":\"android\",\"os_version\":\"13\",\"install_ch\":\"ps\",\"device_id\":\"" + this.deviceId + "\",\"install_store\":\"ps\",\"gaid\":\"1b2212c1-dadf-43c3-a0c8-bd6ce48ae22d\",\"brand\":\"" + brand2 + "\",\"model\":\"" + model4 + "\",\"system_language\":\"en\",\"net\":\"NETWORK_WIFI\",\"region\":\"US\",\"timezone\":\"Asia/Calcutta\",\"sp_code\":\"\",\"X-Play-Mode\":\"1\",\"X-Idle-Data\":\"1\",\"X-Family-Mode\":\"0\",\"X-Content-Mode\":\"0\"}";
                String url2 = getMainUrl() + "/wefeed-mobile-bff/subject-api/search/v2";
                jsonBody = "{\"page\": " + page2 + ", \"perPage\": 20, \"keyword\": \"" + query + "\"}";
                brand = brand2;
                xClientToken = generateXClientToken$default(this, null, 1, null);
                $result = $result2;
                clientInfo = clientInfo5;
                String xTrSignature2 = generateXTrSignature$default(this, "POST", "application/json", "application/json; charset=utf-8", url2, jsonBody, false, null, 96, null);
                String str3 = bearerToken;
                if (str3 == null) {
                    c00072.L$0 = SpillingKt.nullOutSpilledVariable(query);
                    c00072.L$1 = SpillingKt.nullOutSpilledVariable(brand);
                    c00072.L$2 = SpillingKt.nullOutSpilledVariable(model4);
                    c00072.L$3 = ua4;
                    c00072.L$4 = clientInfo;
                    c00072.L$5 = url2;
                    c00072.L$6 = jsonBody;
                    c00072.L$7 = xClientToken;
                    c00072.L$8 = xTrSignature2;
                    c00072.I$0 = page2;
                    c00072.I$1 = 50020042;
                    c00072.label = 1;
                    objFetchAnonymousToken = fetchAnonymousToken(ua4, c00072);
                    obj = coroutine_suspended;
                    if (objFetchAnonymousToken == obj) {
                        return obj;
                    }
                    clientInfo3 = url2;
                    ua = ua4;
                    model3 = model4;
                    xClientToken3 = xTrSignature2;
                    versionCode2 = 50020042;
                    query3 = query;
                    String str4 = clientInfo;
                    clientInfo2 = clientInfo3;
                    url = str4;
                    model2 = model3;
                    ua2 = xClientToken;
                    model = xClientToken3;
                    xClientToken2 = jsonBody;
                    versionCode = versionCode2;
                    token = (String) objFetchAnonymousToken;
                    query2 = query3;
                    xTrSignature = brand;
                } else {
                    obj = coroutine_suspended;
                    model = xTrSignature2;
                    ua = ua4;
                    url = clientInfo;
                    ua2 = xClientToken;
                    model2 = model4;
                    token = str3;
                    clientInfo2 = url2;
                    xClientToken2 = jsonBody;
                    versionCode = 50020042;
                    query2 = query;
                    xTrSignature = brand;
                }
                str = token;
                if (str != null || StringsKt.isBlank(str)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    bearerToken = token;
                }
                $this$search_u24lambda_u240 = MapsKt.createMapBuilder();
                str2 = token;
                if (str2 != null || StringsKt.isBlank(str2)) {
                    $this$search_u24lambda_u241 = $this$search_u24lambda_u240;
                } else {
                    $this$search_u24lambda_u241 = $this$search_u24lambda_u240;
                    $this$search_u24lambda_u241.put("Authorization", "Bearer " + token);
                }
                $this$search_u24lambda_u241.put("user-agent", ua);
                $this$search_u24lambda_u241.put("accept", "application/json");
                $this$search_u24lambda_u241.put("content-type", "application/json; charset=utf-8");
                obj2 = obj;
                $this$search_u24lambda_u241.put("connection", "keep-alive");
                $this$search_u24lambda_u241.put("x-client-token", ua2);
                $this$search_u24lambda_u241.put("x-tr-signature", model);
                $this$search_u24lambda_u241.put("x-client-info", url);
                $this$search_u24lambda_u241.put("x-client-status", "0");
                Map headers = MapsKt.build($this$search_u24lambda_u240);
                RequestBody requestBody = RequestBody.Companion.create(xClientToken2, MediaType.Companion.get("application/json; charset=utf-8"));
                Requests app = MainActivityKt.getApp();
                c00072.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00072.L$1 = SpillingKt.nullOutSpilledVariable(xTrSignature);
                c00072.L$2 = SpillingKt.nullOutSpilledVariable(model2);
                c00072.L$3 = SpillingKt.nullOutSpilledVariable(ua);
                c00072.L$4 = SpillingKt.nullOutSpilledVariable(url);
                c00072.L$5 = SpillingKt.nullOutSpilledVariable(clientInfo2);
                c00072.L$6 = SpillingKt.nullOutSpilledVariable(xClientToken2);
                c00072.L$7 = SpillingKt.nullOutSpilledVariable(ua2);
                c00072.L$8 = SpillingKt.nullOutSpilledVariable(model);
                c00072.L$9 = SpillingKt.nullOutSpilledVariable(token);
                c00072.L$10 = SpillingKt.nullOutSpilledVariable(headers);
                c00072.L$11 = SpillingKt.nullOutSpilledVariable(requestBody);
                c00072.I$0 = page2;
                c00072.I$1 = versionCode;
                c00072.label = 2;
                objPost$default = Requests.post$default(app, clientInfo2, headers, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00072, 65276, (Object) null);
                if (objPost$default == obj2) {
                    return obj2;
                }
                $result2 = objPost$default;
                clientInfo4 = url;
                token2 = ua;
                jsonBody2 = query2;
                NiceResponse response = (NiceResponse) $result2;
                String responseBody = response.getBody().string();
                ObjectMapper mapper = ExtensionsKt.jacksonObjectMapper();
                JsonNode root = mapper.readTree(responseBody);
                jsonNode = root.get("data");
                if (jsonNode != null || (results = jsonNode.get("results")) == null) {
                    bool = null;
                    return MainAPIKt.newSearchResponseList$default(CollectionsKt.emptyList(), bool, 2, bool);
                }
                List searchList = new ArrayList();
                for (JsonNode result : results) {
                    results = results;
                    clientInfo4 = clientInfo4;
                    JsonNode<JsonNode> subjects = result.get("subjects");
                    if (subjects != null) {
                        for (final JsonNode subject : subjects) {
                            result = result;
                            subjects = subjects;
                            JsonNode jsonNode3 = subject.get("title");
                            if (jsonNode3 == null || (title = jsonNode3.asText()) == null) {
                                token2 = token2;
                            } else {
                                JsonNode jsonNode4 = subject.get("subjectId");
                                if (jsonNode4 == null || (id = jsonNode4.asText()) == null) {
                                    token2 = token2;
                                } else {
                                    JsonNode jsonNode5 = subject.get("cover");
                                    if (jsonNode5 != null) {
                                        ua3 = token2;
                                        JsonNode jsonNode6 = jsonNode5.get("url");
                                        final String coverImg = jsonNode6 != null ? jsonNode6.asText() : null;
                                        jsonNode2 = subject.get("subjectType");
                                        if (jsonNode2 != null) {
                                            subjectType = jsonNode2.asInt();
                                        } else {
                                            subjectType = 1;
                                        }
                                        switch (subjectType) {
                                            case 1:
                                                tvType = TvType.Movie;
                                                break;
                                            case 2:
                                                tvType = TvType.TvSeries;
                                                break;
                                            default:
                                                tvType = TvType.Movie;
                                                break;
                                        }
                                        TvType type = tvType;
                                        searchList.add(MainAPIKt.newMovieSearchResponse$default(this, title, id, type, false, new Function1() { // from class: com.cncverse.MovieBoxProviderIN$$ExternalSyntheticLambda3
                                            public final Object invoke(Object obj3) {
                                                return MovieBoxProviderIN.search$lambda$1(coverImg, subject, (MovieSearchResponse) obj3);
                                            }
                                        }, 8, (Object) null));
                                        token2 = ua3;
                                    } else {
                                        ua3 = token2;
                                    }
                                    jsonNode2 = subject.get("subjectType");
                                    if (jsonNode2 != null) {
                                        subjectType = jsonNode2.asInt();
                                    } else {
                                        subjectType = 1;
                                    }
                                    switch (subjectType) {
                                        case 1:
                                            tvType = TvType.Movie;
                                            break;
                                        case 2:
                                            tvType = TvType.TvSeries;
                                            break;
                                        default:
                                            tvType = TvType.Movie;
                                            break;
                                    }
                                    TvType type2 = tvType;
                                    searchList.add(MainAPIKt.newMovieSearchResponse$default(this, title, id, type2, false, new Function1() { // from class: com.cncverse.MovieBoxProviderIN$$ExternalSyntheticLambda3
                                        public final Object invoke(Object obj3) {
                                            return MovieBoxProviderIN.search$lambda$1(coverImg, subject, (MovieSearchResponse) obj3);
                                        }
                                    }, 8, (Object) null));
                                    token2 = ua3;
                                }
                            }
                        }
                    }
                }
                return MainAPIKt.toNewSearchResponseList$default(searchList, (Boolean) null, 1, (Object) null);
            case 1:
                int versionCode3 = c00072.I$1;
                int page3 = c00072.I$0;
                String xTrSignature3 = (String) c00072.L$8;
                String xClientToken4 = (String) c00072.L$7;
                jsonBody = (String) c00072.L$6;
                String url3 = (String) c00072.L$5;
                String clientInfo6 = (String) c00072.L$4;
                ua = (String) c00072.L$3;
                model3 = (String) c00072.L$2;
                String brand3 = (String) c00072.L$1;
                query3 = (String) c00072.L$0;
                ResultKt.throwOnFailure($result2);
                brand = brand3;
                $result = $result2;
                page2 = page3;
                clientInfo = clientInfo6;
                obj = coroutine_suspended;
                xClientToken = xClientToken4;
                clientInfo3 = url3;
                xClientToken3 = xTrSignature3;
                versionCode2 = versionCode3;
                objFetchAnonymousToken = $result;
                String str5 = clientInfo;
                clientInfo2 = clientInfo3;
                url = str5;
                model2 = model3;
                ua2 = xClientToken;
                model = xClientToken3;
                xClientToken2 = jsonBody;
                versionCode = versionCode2;
                token = (String) objFetchAnonymousToken;
                query2 = query3;
                xTrSignature = brand;
                str = token;
                if (str != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (!z) {
                    bearerToken = token;
                }
                $this$search_u24lambda_u240 = MapsKt.createMapBuilder();
                str2 = token;
                if (str2 != null || StringsKt.isBlank(str2)) {
                    $this$search_u24lambda_u241 = $this$search_u24lambda_u240;
                    $this$search_u24lambda_u241.put("Authorization", "Bearer " + token);
                } else {
                    $this$search_u24lambda_u241 = $this$search_u24lambda_u240;
                }
                $this$search_u24lambda_u241.put("user-agent", ua);
                $this$search_u24lambda_u241.put("accept", "application/json");
                $this$search_u24lambda_u241.put("content-type", "application/json; charset=utf-8");
                obj2 = obj;
                $this$search_u24lambda_u241.put("connection", "keep-alive");
                $this$search_u24lambda_u241.put("x-client-token", ua2);
                $this$search_u24lambda_u241.put("x-tr-signature", model);
                $this$search_u24lambda_u241.put("x-client-info", url);
                $this$search_u24lambda_u241.put("x-client-status", "0");
                Map headers2 = MapsKt.build($this$search_u24lambda_u240);
                RequestBody requestBody2 = RequestBody.Companion.create(xClientToken2, MediaType.Companion.get("application/json; charset=utf-8"));
                Requests app2 = MainActivityKt.getApp();
                c00072.L$0 = SpillingKt.nullOutSpilledVariable(query2);
                c00072.L$1 = SpillingKt.nullOutSpilledVariable(xTrSignature);
                c00072.L$2 = SpillingKt.nullOutSpilledVariable(model2);
                c00072.L$3 = SpillingKt.nullOutSpilledVariable(ua);
                c00072.L$4 = SpillingKt.nullOutSpilledVariable(url);
                c00072.L$5 = SpillingKt.nullOutSpilledVariable(clientInfo2);
                c00072.L$6 = SpillingKt.nullOutSpilledVariable(xClientToken2);
                c00072.L$7 = SpillingKt.nullOutSpilledVariable(ua2);
                c00072.L$8 = SpillingKt.nullOutSpilledVariable(model);
                c00072.L$9 = SpillingKt.nullOutSpilledVariable(token);
                c00072.L$10 = SpillingKt.nullOutSpilledVariable(headers2);
                c00072.L$11 = SpillingKt.nullOutSpilledVariable(requestBody2);
                c00072.I$0 = page2;
                c00072.I$1 = versionCode;
                c00072.label = 2;
                objPost$default = Requests.post$default(app2, clientInfo2, headers2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, requestBody2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00072, 65276, (Object) null);
                if (objPost$default == obj2) {
                    return obj2;
                }
                $result2 = objPost$default;
                clientInfo4 = url;
                token2 = ua;
                jsonBody2 = query2;
                NiceResponse response2 = (NiceResponse) $result2;
                String responseBody2 = response2.getBody().string();
                ObjectMapper mapper2 = ExtensionsKt.jacksonObjectMapper();
                JsonNode root2 = mapper2.readTree(responseBody2);
                jsonNode = root2.get("data");
                if (jsonNode != null) {
                    bool = null;
                } else {
                    bool = null;
                }
                return MainAPIKt.newSearchResponseList$default(CollectionsKt.emptyList(), bool, 2, bool);
            case 2:
                int i = c00072.I$1;
                int i2 = c00072.I$0;
                clientInfo4 = (String) c00072.L$4;
                token2 = (String) c00072.L$3;
                String query4 = (String) c00072.L$0;
                ResultKt.throwOnFailure($result2);
                jsonBody2 = query4;
                NiceResponse response3 = (NiceResponse) $result2;
                String responseBody3 = response3.getBody().string();
                ObjectMapper mapper3 = ExtensionsKt.jacksonObjectMapper();
                JsonNode root3 = mapper3.readTree(responseBody3);
                jsonNode = root3.get("data");
                if (jsonNode != null) {
                    bool = null;
                } else {
                    bool = null;
                }
                return MainAPIKt.newSearchResponseList$default(CollectionsKt.emptyList(), bool, 2, bool);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$1(String $coverImg, JsonNode $subject, MovieSearchResponse $this$newMovieSearchResponse) {
        $this$newMovieSearchResponse.setPosterUrl($coverImg);
        Score.Companion companion = Score.Companion;
        JsonNode jsonNode = $subject.get("imdbRatingValue");
        $this$newMovieSearchResponse.setScore(companion.from10(jsonNode != null ? jsonNode.asText() : null));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:159:0x0bf3  */
    /* JADX WARN: Code duplicated, block: B:298:0x117a  */
    /* JADX WARN: Code duplicated, block: B:300:0x1314 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:301:0x1315  */
    /* JADX WARN: Code duplicated, block: B:304:0x136c  */
    /* JADX WARN: Code duplicated, block: B:306:0x1382  */
    /* JADX WARN: Code duplicated, block: B:307:0x138b  */
    /* JADX WARN: Code duplicated, block: B:309:0x1390  */
    /* JADX WARN: Code duplicated, block: B:336:0x1436 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:338:0x143d  */
    /* JADX WARN: Code duplicated, block: B:498:0x0bf9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:301:0x1315 -> B:302:0x135e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object load(@org.jetbrains.annotations.NotNull java.lang.String r124, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.lagradost.cloudstream3.LoadResponse> r125) {
        /*
            Method dump skipped, instruction units count: 6810
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.MovieBoxProviderIN.load(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$8$0$5(String $epName, int $seasonNumber, int $episodeNumber, String $epThumb, String $epDesc, Integer $runtime, String $aired, Episode $this$newEpisode) {
        $this$newEpisode.setName($epName);
        $this$newEpisode.setSeason(Integer.valueOf($seasonNumber));
        $this$newEpisode.setEpisode(Integer.valueOf($episodeNumber));
        $this$newEpisode.setPosterUrl($epThumb);
        $this$newEpisode.setDescription($epDesc);
        $this$newEpisode.setRunTime($runtime);
        MainAPIKt.addDate$default($this$newEpisode, $aired, (String) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$9(String $coverUrl, Episode $this$newEpisode) {
        $this$newEpisode.setName("Episode 1");
        $this$newEpisode.setSeason(1);
        $this$newEpisode.setEpisode(1);
        $this$newEpisode.setPosterUrl($coverUrl);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.cncverse.MovieBoxProviderIN$load$7 */
    /* JADX INFO: compiled from: MovieBoxProviderIN.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieBoxProviderIN$load$7", f = "MovieBoxProviderIN.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nMovieBoxProviderIN.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieBoxProviderIN.kt\ncom/cncverse/MovieBoxProviderIN$load$7\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1408:1\n1#2:1409\n*E\n"})
    static final class C00037 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $Background;
        final /* synthetic */ String $Description;
        final /* synthetic */ String $IMDBRating;
        final /* synthetic */ String $Poster;
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $backgroundUrl;
        final /* synthetic */ String $coverUrl;
        final /* synthetic */ String $description;
        final /* synthetic */ Integer $durationMinutes;
        final /* synthetic */ String $imdbId;
        final /* synthetic */ Integer $imdbRating;
        final /* synthetic */ String $logoUrl;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Integer $tmdbId;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00037(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, List<String> list, List<ActorData> list2, String str8, Integer num2, Integer num3, String str9, Integer num4, Continuation<? super C00037> continuation) {
            super(2, continuation);
            this.$coverUrl = str;
            this.$Poster = str2;
            this.$Background = str3;
            this.$backgroundUrl = str4;
            this.$logoUrl = str5;
            this.$Description = str6;
            this.$description = str7;
            this.$year = num;
            this.$tags = list;
            this.$actors = list2;
            this.$IMDBRating = str8;
            this.$imdbRating = num2;
            this.$durationMinutes = num3;
            this.$imdbId = str9;
            this.$tmdbId = num4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00037 = new C00037(this.$coverUrl, this.$Poster, this.$Background, this.$backgroundUrl, this.$logoUrl, this.$Description, this.$description, this.$year, this.$tags, this.$actors, this.$IMDBRating, this.$imdbRating, this.$durationMinutes, this.$imdbId, this.$tmdbId, continuation);
            c00037.L$0 = obj;
            return c00037;
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
                    String str = this.$coverUrl;
                    if (str == null) {
                        str = this.$Poster;
                    }
                    loadResponse.setPosterUrl(str);
                    String str2 = this.$Background;
                    if (str2 == null && (str2 = this.$backgroundUrl) == null) {
                        str2 = this.$Poster;
                    }
                    loadResponse.setBackgroundPosterUrl(str2);
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th) {
                    }
                    String str3 = this.$Description;
                    if (str3 == null) {
                        str3 = this.$description;
                    }
                    loadResponse.setPlot(str3);
                    loadResponse.setYear(this.$year);
                    loadResponse.setTags(this.$tags);
                    loadResponse.setActors(this.$actors);
                    Score scoreFrom10 = Score.Companion.from10(this.$IMDBRating);
                    if (scoreFrom10 == null) {
                        Integer num = this.$imdbRating;
                        if (num != null) {
                            int it = num.intValue();
                            scoreFrom10 = Score.Companion.from10(Boxing.boxInt(it));
                        } else {
                            scoreFrom10 = null;
                        }
                    }
                    loadResponse.setScore(scoreFrom10);
                    loadResponse.setDuration(this.$durationMinutes);
                    LoadResponse.Companion.addImdbId(loadResponse, this.$imdbId);
                    LoadResponse.Companion.addTMDbId(loadResponse, String.valueOf(this.$tmdbId));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.cncverse.MovieBoxProviderIN$load$8 */
    /* JADX INFO: compiled from: MovieBoxProviderIN.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/MovieLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieBoxProviderIN$load$8", f = "MovieBoxProviderIN.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nMovieBoxProviderIN.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MovieBoxProviderIN.kt\ncom/cncverse/MovieBoxProviderIN$load$8\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1408:1\n1#2:1409\n*E\n"})
    static final class C00048 extends SuspendLambda implements Function2<MovieLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $Background;
        final /* synthetic */ String $Description;
        final /* synthetic */ String $IMDBRating;
        final /* synthetic */ String $Poster;
        final /* synthetic */ List<ActorData> $actors;
        final /* synthetic */ String $backgroundUrl;
        final /* synthetic */ String $coverUrl;
        final /* synthetic */ String $description;
        final /* synthetic */ Integer $durationMinutes;
        final /* synthetic */ String $imdbId;
        final /* synthetic */ Integer $imdbRating;
        final /* synthetic */ String $logoUrl;
        final /* synthetic */ List<String> $tags;
        final /* synthetic */ Integer $tmdbId;
        final /* synthetic */ Integer $year;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00048(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, List<String> list, List<ActorData> list2, String str8, Integer num2, Integer num3, String str9, Integer num4, Continuation<? super C00048> continuation) {
            super(2, continuation);
            this.$coverUrl = str;
            this.$Poster = str2;
            this.$Background = str3;
            this.$backgroundUrl = str4;
            this.$logoUrl = str5;
            this.$Description = str6;
            this.$description = str7;
            this.$year = num;
            this.$tags = list;
            this.$actors = list2;
            this.$IMDBRating = str8;
            this.$imdbRating = num2;
            this.$durationMinutes = num3;
            this.$imdbId = str9;
            this.$tmdbId = num4;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00048 = new C00048(this.$coverUrl, this.$Poster, this.$Background, this.$backgroundUrl, this.$logoUrl, this.$Description, this.$description, this.$year, this.$tags, this.$actors, this.$IMDBRating, this.$imdbRating, this.$durationMinutes, this.$imdbId, this.$tmdbId, continuation);
            c00048.L$0 = obj;
            return c00048;
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
                    String str = this.$coverUrl;
                    if (str == null) {
                        str = this.$Poster;
                    }
                    loadResponse.setPosterUrl(str);
                    String str2 = this.$Background;
                    if (str2 == null) {
                        str2 = this.$backgroundUrl;
                    }
                    loadResponse.setBackgroundPosterUrl(str2);
                    try {
                        loadResponse.setLogoUrl(this.$logoUrl);
                        break;
                    } catch (Throwable th) {
                    }
                    String str3 = this.$Description;
                    if (str3 == null) {
                        str3 = this.$description;
                    }
                    loadResponse.setPlot(str3);
                    loadResponse.setYear(this.$year);
                    loadResponse.setTags(this.$tags);
                    loadResponse.setActors(this.$actors);
                    Score scoreFrom10 = Score.Companion.from10(this.$IMDBRating);
                    if (scoreFrom10 == null) {
                        Integer num = this.$imdbRating;
                        if (num != null) {
                            int it = num.intValue();
                            scoreFrom10 = Score.Companion.from10(Boxing.boxInt(it));
                        } else {
                            scoreFrom10 = null;
                        }
                    }
                    loadResponse.setScore(scoreFrom10);
                    loadResponse.setDuration(this.$durationMinutes);
                    LoadResponse.Companion.addImdbId(loadResponse, this.$imdbId);
                    LoadResponse.Companion.addTMDbId(loadResponse, String.valueOf(this.$tmdbId));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 24 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:1127:0x4ade
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:143)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:58)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:50)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r117, boolean r118, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r119, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r120, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r121) {
        /*
            Method dump skipped, instruction units count: 21592
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.MovieBoxProviderIN.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadLinks$lambda$0$0(Context $_ctx) {
        Toast.makeText($_ctx, "⚠️(Opening ads) Subscription expired. If you have renewed your subscription, please re-verify it in Subscription Manager.", 1).show();
    }

    /* JADX INFO: renamed from: com.cncverse.MovieBoxProviderIN$loadLinks$4 */
    /* JADX INFO: compiled from: MovieBoxProviderIN.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.MovieBoxProviderIN$loadLinks$4", f = "MovieBoxProviderIN.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00064 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Integer $quality;
        final /* synthetic */ String $signCookie;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00064(Integer num, String str, Continuation<? super C00064> continuation) {
            super(2, continuation);
            this.$quality = num;
            this.$signCookie = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00064 = MovieBoxProviderIN.this.new C00064(this.$quality, this.$signCookie, continuation);
            c00064.L$0 = obj;
            return c00064;
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
                    $this$newExtractorLink.setHeaders(MapsKt.mapOf(TuplesKt.to("Referer", MovieBoxProviderIN.this.getMainUrl())));
                    if (this.$quality != null) {
                        $this$newExtractorLink.setQuality(this.$quality.intValue());
                    }
                    if (this.$signCookie != null) {
                        $this$newExtractorLink.setHeaders(MapsKt.plus($this$newExtractorLink.getHeaders(), MapsKt.mapOf(TuplesKt.to("Cookie", this.$signCookie))));
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final void showSubscriptionPopupIfNeeded() {
        final Context ctx = context;
        if (ctx == null || subscriptionPopupShown) {
            return;
        }
        try {
            boolean isTV = Globals.INSTANCE.isLayout(2);
            if (isTV) {
                return;
            }
        } catch (Exception e) {
        }
        SharedPreferences sharedPreferences = ctx.getSharedPreferences("CNCVerseSubscription", 0);
        boolean isSubscribed = Intrinsics.areEqual(sharedPreferences != null ? sharedPreferences.getString("mode", "ads") : null, "subscription");
        if (isSubscribed) {
            return;
        }
        SharedPreferences _dontShowPrefs = ctx.getSharedPreferences("CNCVerseSubscription", 0);
        if (_dontShowPrefs.getBoolean("dont_show_ads_popup", false)) {
            subscriptionPopupShown = true;
        } else {
            subscriptionPopupShown = true;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.MovieBoxProviderIN$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    MovieBoxProviderIN.showSubscriptionPopupIfNeeded$lambda$0(ctx);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSubscriptionPopupIfNeeded$lambda$0(final Context $ctx) {
        try {
            float dp = $ctx.getResources().getDisplayMetrics().density;
            GradientDrawable $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u240 = new GradientDrawable();
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u240.setColor(Color.parseColor("#1A1A2E"));
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u240.setCornerRadius(16.0f * dp);
            LinearLayout root = new LinearLayout($ctx);
            root.setOrientation(1);
            float f = 24;
            root.setPadding((int) (f * dp), (int) (20 * dp), (int) (f * dp), (int) (16 * dp));
            root.setBackground($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u240);
            TextView $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242 = new TextView($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setText("📺 You're in Ads Mode");
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setTextColor(-1);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setTextSize(17.0f);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setTypeface(Typeface.DEFAULT_BOLD);
            LinearLayout.LayoutParams it = new LinearLayout.LayoutParams(-1, -2);
            it.bottomMargin = (int) (8 * dp);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242.setLayoutParams(it);
            View divider = new View($ctx);
            divider.setBackgroundColor(Color.parseColor("#2D2D4A"));
            LinearLayout.LayoutParams it2 = new LinearLayout.LayoutParams(-1, 1);
            it2.bottomMargin = (int) (12 * dp);
            divider.setLayoutParams(it2);
            TextView $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244 = new TextView($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setText("All CNCVerse extensions currently run with ads.\n\nSubscribe to remove ads from just ₹20/month.\n\nManage via Settings > Extensions > CNCVerse Cloudstream Repo > Subscription Manager.");
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setTextColor(Color.parseColor("#A0A0A8"));
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setTextSize(14.0f);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setLineSpacing(0.0f, 1.4f);
            LinearLayout.LayoutParams it3 = new LinearLayout.LayoutParams(-1, -2);
            it3.bottomMargin = (int) (18 * dp);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244.setLayoutParams(it3);
            LinearLayout btnRow = new LinearLayout($ctx);
            btnRow.setOrientation(0);
            btnRow.setGravity(8388613);
            TextView laterTv = new TextView($ctx);
            laterTv.setText("Maybe Later");
            laterTv.setTextColor(Color.parseColor("#808090"));
            laterTv.setTextSize(14.0f);
            float f2 = 10;
            int p = (int) (f2 * dp);
            laterTv.setPadding(p, p, p, p);
            laterTv.setClickable(true);
            laterTv.setFocusable(true);
            TextView subscribeTv = new TextView($ctx);
            subscribeTv.setText("Subscribe Now");
            subscribeTv.setTextColor(Color.parseColor("#A78BFA"));
            subscribeTv.setTextSize(14.0f);
            subscribeTv.setTypeface(Typeface.DEFAULT_BOLD);
            int p2 = (int) (f2 * dp);
            subscribeTv.setPadding(p2, p2, 0, p2);
            subscribeTv.setClickable(true);
            subscribeTv.setFocusable(true);
            LinearLayout $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248 = new LinearLayout($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.setOrientation(0);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.setGravity(8388627);
            LinearLayout.LayoutParams it4 = new LinearLayout.LayoutParams(-1, -2);
            it4.bottomMargin = (int) (f2 * dp);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.setLayoutParams(it4);
            final CheckBox $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249 = new CheckBox($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249.setChecked(false);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#A78BFA")));
            TextView $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410 = new TextView($ctx);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410.setText("Don't show me again");
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410.setTextColor(Color.parseColor("#A0A0A8"));
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410.setTextSize(13.0f);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410.setPadding((int) (6 * dp), 0, 0, 0);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249);
            $this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u2410);
            btnRow.addView(laterTv);
            btnRow.addView(subscribeTv);
            root.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u242);
            root.addView(divider);
            root.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u244);
            root.addView($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u248);
            root.addView(btnRow);
            final AlertDialog dialog = new AlertDialog.Builder($ctx).setView(root).setCancelable(true).create();
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.MovieBoxProviderIN$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MovieBoxProviderIN.showSubscriptionPopupIfNeeded$lambda$0$11($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249, $ctx, dialog, view);
                }
            });
            subscribeTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.MovieBoxProviderIN$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MovieBoxProviderIN.showSubscriptionPopupIfNeeded$lambda$0$12(dialog, $ctx, view);
                }
            });
            dialog.show();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSubscriptionPopupIfNeeded$lambda$0$11(CheckBox $dontShowCb, Context $ctx, AlertDialog $dialog, View it) {
        if ($dontShowCb.isChecked()) {
            $ctx.getSharedPreferences("CNCVerseSubscription", 0).edit().putBoolean("dont_show_ads_popup", true).apply();
        }
        $dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSubscriptionPopupIfNeeded$lambda$0$12(AlertDialog $dialog, Context $ctx, View it) {
        $dialog.dismiss();
        try {
            Intent i = new Intent("android.intent.action.VIEW", Uri.parse("https://cncverse-sub.pages.dev"));
            i.addFlags(268435456);
            $ctx.startActivity(i);
        } catch (Exception e) {
        }
    }

    private final void showTelegramPopup() {
        final Context ctx;
        if (Globals.INSTANCE.isLayout(2) || (ctx = context) == null || telegramPopupShown) {
            return;
        }
        SharedPreferences prefs = ctx.getSharedPreferences("cncverse_prefs", 0);
        if (prefs.getBoolean("telegram_popup_shown", false)) {
            telegramPopupShown = true;
            return;
        }
        telegramPopupShown = true;
        prefs.edit().putBoolean("telegram_popup_shown", true).apply();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.MovieBoxProviderIN$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                MovieBoxProviderIN.showTelegramPopup$lambda$0(ctx);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTelegramPopup$lambda$0(final Context $ctx) {
        try {
            float dp = $ctx.getResources().getDisplayMetrics().density;
            GradientDrawable $this$showTelegramPopup_u24lambda_u240_u240 = new GradientDrawable();
            $this$showTelegramPopup_u24lambda_u240_u240.setColor(Color.parseColor("#1A1A2E"));
            $this$showTelegramPopup_u24lambda_u240_u240.setCornerRadius(16.0f * dp);
            LinearLayout root = new LinearLayout($ctx);
            root.setOrientation(1);
            float f = 24;
            root.setPadding((int) (f * dp), (int) (20 * dp), (int) (f * dp), (int) (16 * dp));
            root.setBackground($this$showTelegramPopup_u24lambda_u240_u240);
            TextView $this$showTelegramPopup_u24lambda_u240_u242 = new TextView($ctx);
            $this$showTelegramPopup_u24lambda_u240_u242.setText("💬 Join CNCVerse Community");
            $this$showTelegramPopup_u24lambda_u240_u242.setTextColor(-1);
            $this$showTelegramPopup_u24lambda_u240_u242.setTextSize(17.0f);
            $this$showTelegramPopup_u24lambda_u240_u242.setTypeface(Typeface.DEFAULT_BOLD);
            LinearLayout.LayoutParams it = new LinearLayout.LayoutParams(-1, -2);
            float f2 = 10;
            it.bottomMargin = (int) (f2 * dp);
            $this$showTelegramPopup_u24lambda_u240_u242.setLayoutParams(it);
            View dividerV = new View($ctx);
            dividerV.setBackgroundColor(Color.parseColor("#2D2D4A"));
            LinearLayout.LayoutParams it2 = new LinearLayout.LayoutParams(-1, 1);
            it2.bottomMargin = (int) (14 * dp);
            dividerV.setLayoutParams(it2);
            TextView $this$showTelegramPopup_u24lambda_u240_u244 = new TextView($ctx);
            $this$showTelegramPopup_u24lambda_u240_u244.setText("Join our Telegram group to discuss and share your opinion!");
            $this$showTelegramPopup_u24lambda_u240_u244.setTextColor(Color.parseColor("#A0A0A8"));
            $this$showTelegramPopup_u24lambda_u240_u244.setTextSize(14.0f);
            $this$showTelegramPopup_u24lambda_u240_u244.setLineSpacing(0.0f, 1.4f);
            LinearLayout.LayoutParams it3 = new LinearLayout.LayoutParams(-1, -2);
            it3.bottomMargin = (int) (18 * dp);
            $this$showTelegramPopup_u24lambda_u240_u244.setLayoutParams(it3);
            LinearLayout btnRow = new LinearLayout($ctx);
            btnRow.setOrientation(0);
            btnRow.setGravity(8388613);
            TextView laterTv = new TextView($ctx);
            laterTv.setText("Later");
            laterTv.setTextColor(Color.parseColor("#808090"));
            laterTv.setTextSize(14.0f);
            int p = (int) (f2 * dp);
            laterTv.setPadding(p, p, p, p);
            laterTv.setClickable(true);
            laterTv.setFocusable(true);
            TextView joinTv = new TextView($ctx);
            joinTv.setText("Join Telegram");
            joinTv.setTextColor(Color.parseColor("#5B9BF5"));
            joinTv.setTextSize(14.0f);
            joinTv.setTypeface(Typeface.DEFAULT_BOLD);
            int p2 = (int) (f2 * dp);
            joinTv.setPadding(p2, p2, 0, p2);
            joinTv.setClickable(true);
            joinTv.setFocusable(true);
            btnRow.addView(laterTv);
            btnRow.addView(joinTv);
            root.addView($this$showTelegramPopup_u24lambda_u240_u242);
            root.addView(dividerV);
            root.addView($this$showTelegramPopup_u24lambda_u240_u244);
            root.addView(btnRow);
            final AlertDialog dialog = new AlertDialog.Builder($ctx).setView(root).setCancelable(true).create();
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.MovieBoxProviderIN$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            joinTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.MovieBoxProviderIN$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MovieBoxProviderIN.showTelegramPopup$lambda$0$9(dialog, $ctx, view);
                }
            });
            dialog.show();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showTelegramPopup$lambda$0$9(AlertDialog $dialog, Context $ctx, View it) {
        $dialog.dismiss();
        try {
            Intent i = new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/cncverse"));
            i.addFlags(268435456);
            $ctx.startActivity(i);
        } catch (Exception e) {
        }
    }

    private final void openInExternalBrowser(final String url) {
        final Context ctx;
        if (Globals.INSTANCE.isLayout(2) || (ctx = context) == null) {
            return;
        }
        long now = System.currentTimeMillis();
        if (now - lastBrowserOpenMs < BROWSER_DEBOUNCE_MS) {
            return;
        }
        lastBrowserOpenMs = now;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.MovieBoxProviderIN$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                MovieBoxProviderIN.openInExternalBrowser$lambda$0(ctx, url);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openInExternalBrowser$lambda$0(Context $ctx, String $url) {
        try {
            Intent $this$openInExternalBrowser_u24lambda_u240_u240 = new Intent("android.intent.action.VIEW", Uri.parse($url));
            $this$openInExternalBrowser_u24lambda_u240_u240.addFlags(268435456);
            $ctx.startActivity($this$openInExternalBrowser_u24lambda_u240_u240);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
    public final Object fetchAnonymousToken(String ua, Continuation<? super String> continuation) {
        C00001 c00001;
        Object obj;
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
        C00001 c00002 = c00001;
        Object $result = c00002.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00002.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    String pingUrl = getMainUrl() + "/wefeed-mobile-bff/tab/ranking-list?tabId=0&categoryType=4516404531735022304&page=1&perPage=1";
                    String xct = generateXClientToken$default(this, null, 1, null);
                    obj = null;
                    try {
                        String sig = generateXTrSignature$default(this, "GET", "application/json", "application/json", pingUrl, null, false, null, 112, null);
                        Pair[] pairArr = new Pair[7];
                        try {
                            pairArr[0] = TuplesKt.to("user-agent", ua);
                            pairArr[1] = TuplesKt.to("accept", "application/json");
                            pairArr[2] = TuplesKt.to("content-type", "application/json");
                            pairArr[3] = TuplesKt.to("x-client-token", xct);
                            pairArr[4] = TuplesKt.to("x-tr-signature", sig);
                            pairArr[5] = TuplesKt.to("x-client-info", "{\"package_name\":\"com.community.oneroom\",\"version_name\":\"3.0.13.0325.03\",\"version_code\":50020088,\"os\":\"android\",\"os_version\":\"13\",\"device_id\":\"" + this.deviceId + "\",\"install_store\":\"ps\",\"system_language\":\"en\",\"net\":\"NETWORK_WIFI\",\"region\":\"US\",\"timezone\":\"Asia/Calcutta\",\"sp_code\":\"\"}");
                            pairArr[6] = TuplesKt.to("x-client-status", "0");
                            Map headers = MapsKt.mapOf(pairArr);
                            Requests app = MainActivityKt.getApp();
                            c00002.L$0 = SpillingKt.nullOutSpilledVariable(ua);
                            c00002.L$1 = SpillingKt.nullOutSpilledVariable(pingUrl);
                            c00002.L$2 = SpillingKt.nullOutSpilledVariable(xct);
                            c00002.L$3 = SpillingKt.nullOutSpilledVariable(sig);
                            c00002.L$4 = SpillingKt.nullOutSpilledVariable(headers);
                            c00002.label = 1;
                            try {
                                Object obj2 = Requests.get$default(app, pingUrl, headers, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00002, 4092, (Object) null);
                                if (obj2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                $result = obj2;
                            } catch (Exception e) {
                                return null;
                            }
                        } catch (Exception e2) {
                            return obj;
                        }
                        break;
                    } catch (Exception e3) {
                    }
                } catch (Exception e4) {
                    obj = null;
                }
                break;
            case 1:
                try {
                    ResultKt.throwOnFailure($result);
                    obj = null;
                } catch (Exception e5) {
                    return null;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            NiceResponse resp = (NiceResponse) $result;
            String xUser = resp.getHeaders().get("x-user");
            String str = xUser;
            if (str == null || StringsKt.isBlank(str)) {
                return obj;
            }
            JsonNode json = ExtensionsKt.jacksonObjectMapper().readTree(xUser);
            JsonNode jsonNode = json.get("token");
            return jsonNode != null ? jsonNode.asText() : obj;
        } catch (Exception e6) {
            return obj;
        }
    }
}
