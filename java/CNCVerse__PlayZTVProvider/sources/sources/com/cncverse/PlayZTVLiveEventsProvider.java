package com.cncverse;

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
import android.util.Base64;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LiveSearchResponse;
import com.lagradost.cloudstream3.LiveStreamLoadResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.ui.settings.Globals;
import com.lagradost.cloudstream3.utils.AppUtils;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
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
import kotlin.reflect.KType;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PlayZTVLiveEventsProvider.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/PlayZTVProvider/classes.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0006\u0018\u0000 H2\u00020\u0001:\u0002HIB\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H\u0002J\u001e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0096@¢\u0006\u0002\u0010,J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u00100\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u00101J\u0016\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u00101J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u000206H\u0002J\u0010\u00108\u001a\u0002062\u0006\u00104\u001a\u00020\u0003H\u0002JF\u00109\u001a\u00020\u00132\u0006\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u00132\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u0002060=2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u0002060=H\u0096@¢\u0006\u0002\u0010AJ(\u0010B\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030D0C2\u0006\u0010E\u001a\u00020\u0003H\u0002J\u0010\u0010F\u001a\u00020\u00032\u0006\u0010G\u001a\u00020\u0003H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR\u001a\u0010\u000f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0013X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/cncverse/PlayZTVLiveEventsProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "name", "", "customCatLink", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getCustomCatLink", "mainUrl", "getMainUrl", "setMainUrl", "lang", "getLang", "setLang", "hasMainPage", "", "getHasMainPage", "()Z", "hasChromecastSupport", "getHasChromecastSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "client", "Lokhttp3/OkHttpClient;", "createDisplayTitle", "event", "Lcom/cncverse/PlayZLiveEventData;", "getEventStatus", "isEventLive", "isEventEnded", "generateMatchCardUrl", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "showSubscriptionPopupIfNeeded", "", "showTelegramPopup", "openInExternalBrowser", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseStreamLink", "Lkotlin/Pair;", "", "link", "hexToBase64", "hex", "Companion", "LiveEventLoadData", "PlayZTVProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPlayZTVLiveEventsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayZTVLiveEventsProvider.kt\ncom/cncverse/PlayZTVLiveEventsProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 5 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 6 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 7 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,710:1\n1#2:711\n1#2:743\n1#2:762\n1#2:791\n1512#3:712\n1538#3,3:713\n1541#3,3:723\n1586#3:729\n1661#3,3:730\n1068#3:734\n777#3:735\n873#3,2:736\n1586#3:738\n1661#3,3:739\n1642#3,10:780\n1915#3:790\n1916#3:792\n1652#3:793\n1915#3,2:794\n1915#3,2:796\n1586#3:798\n1661#3,3:799\n383#4,7:716\n129#5:726\n158#5,2:727\n160#5:733\n63#6:742\n64#6,15:744\n63#6:761\n64#6,15:763\n50#7:759\n43#7:760\n50#7:778\n43#7:779\n*S KotlinDebug\n*F\n+ 1 PlayZTVLiveEventsProvider.kt\ncom/cncverse/PlayZTVLiveEventsProvider\n*L\n294#1:743\n581#1:762\n589#1:791\n197#1:712\n197#1:713,3\n197#1:723,3\n226#1:729\n226#1:730,3\n246#1:734\n266#1:735\n266#1:736,2\n272#1:738\n272#1:739,3\n589#1:780,10\n589#1:790\n589#1:792\n589#1:793\n604#1:794,2\n682#1:796,2\n706#1:798\n706#1:799,3\n197#1:716,7\n200#1:726\n200#1:727,2\n200#1:733\n294#1:742\n294#1:744,15\n581#1:761\n581#1:763,15\n294#1:759\n294#1:760\n581#1:778\n581#1:779\n*E\n"})
public final class PlayZTVLiveEventsProvider extends MainAPI {
    private static final long BROWSER_DEBOUNCE_MS = 10000;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String OMG10 = "aHR0cHM6Ly9vbWcxMC5jb20vNC8xMTEwNDQ4OQ==";

    @Nullable
    private static Context context;
    private static volatile boolean csGuardWasEverActive;
    private static volatile long lastBrowserOpenMs;
    private static volatile boolean subscriptionPopupShown;
    private static volatile boolean telegramPopupShown;

    @NotNull
    private final OkHttpClient client;

    @Nullable
    private final String customCatLink;
    private final boolean hasChromecastSupport;
    private final boolean hasMainPage;

    @NotNull
    private String lang;

    @NotNull
    private String mainUrl;

    @NotNull
    private String name;

    @NotNull
    private final Set<TvType> supportedTypes;

    /* JADX INFO: renamed from: com.cncverse.PlayZTVLiveEventsProvider$getMainPage$1 */
    /* JADX INFO: compiled from: PlayZTVLiveEventsProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayZTVLiveEventsProvider", f = "PlayZTVLiveEventsProvider.kt", i = {0, 0, 1, 1}, l = {193, 195}, m = "getMainPage", n = {"request", "page", "request", "page"}, nl = {195, 192}, s = {"L$0", "I$0", "L$0", "I$0"}, v = 2)
    static final class C00151 extends ContinuationImpl {
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00151(Continuation<? super C00151> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayZTVLiveEventsProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PlayZTVLiveEventsProvider$loadLinks$1 */
    /* JADX INFO: compiled from: PlayZTVLiveEventsProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayZTVLiveEventsProvider", f = "PlayZTVLiveEventsProvider.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {583, 618, 627, 641, 654}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "loadData", "isCasting", "data", "subtitleCallback", "callback", "loadData", "streams", "streamList", "$this$forEach$iv", "element$iv", "stream", "streamLink", "serverName", "url", "headers", "kidBase64", "keyBase64", "drmInfo", "isCasting", "$i$f$forEach", "$i$a$-forEach-PlayZTVLiveEventsProvider$loadLinks$3", "data", "subtitleCallback", "callback", "loadData", "streams", "streamList", "$this$forEach$iv", "element$iv", "stream", "streamLink", "serverName", "url", "headers", "drmInfo", "isCasting", "$i$f$forEach", "$i$a$-forEach-PlayZTVLiveEventsProvider$loadLinks$3", "data", "subtitleCallback", "callback", "loadData", "streams", "streamList", "$this$forEach$iv", "element$iv", "stream", "streamLink", "serverName", "url", "headers", "finalHeaders", "isCasting", "$i$f$forEach", "$i$a$-forEach-PlayZTVLiveEventsProvider$loadLinks$3", "data", "subtitleCallback", "callback", "loadData", "streams", "streamList", "$this$forEach$iv", "element$iv", "stream", "streamLink", "serverName", "url", "headers", "finalHeaders", "isCasting", "$i$f$forEach", "$i$a$-forEach-PlayZTVLiveEventsProvider$loadLinks$3"}, nl = {584, 617, 626, 640, 653}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "Z$0", "I$0", "I$1"}, v = 2)
    static final class C00181 extends ContinuationImpl {
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

        C00181(Continuation<? super C00181> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayZTVLiveEventsProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.PlayZTVLiveEventsProvider$search$1 */
    /* JADX INFO: compiled from: PlayZTVLiveEventsProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayZTVLiveEventsProvider", f = "PlayZTVLiveEventsProvider.kt", i = {0, 1}, l = {261, 263}, m = "search", n = {"query", "query"}, nl = {263, 260}, s = {"L$0", "L$0"}, v = 2)
    static final class C00191 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C00191(Continuation<? super C00191> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlayZTVLiveEventsProvider.this.search(null, (Continuation) this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PlayZTVLiveEventsProvider() {
        String str = null;
        this(str, str, 3, str);
    }

    public PlayZTVLiveEventsProvider(@NotNull String name, @Nullable String customCatLink) {
        this.name = name;
        this.customCatLink = customCatLink;
        this.mainUrl = "https://adsflw.xyz";
        this.lang = "hi";
        this.hasMainPage = true;
        this.hasChromecastSupport = true;
        this.supportedTypes = SetsKt.setOf(TvType.Live);
        this.client = new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).build();
    }

    public /* synthetic */ PlayZTVLiveEventsProvider(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "⚡PlayZTV Live Events" : str, (i & 2) != 0 ? null : str2);
    }

    @Nullable
    public final String getCustomCatLink() {
        return this.customCatLink;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(@NotNull String str) {
        this.name = str;
    }

    /* JADX INFO: compiled from: PlayZTVLiveEventsProvider.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/cncverse/PlayZTVLiveEventsProvider$Companion;", "", "<init>", "()V", "isCsGuardActive", "", "csGuardWasEverActive", "isCsGuardBlocked", "showCsGuardToast", "", "ctx", "Landroid/content/Context;", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "OMG10", "", "lastBrowserOpenMs", "", "telegramPopupShown", "subscriptionPopupShown", "BROWSER_DEBOUNCE_MS", "PlayZTVProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nPlayZTVLiveEventsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayZTVLiveEventsProvider.kt\ncom/cncverse/PlayZTVLiveEventsProvider$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,710:1\n1#2:711\n*E\n"})
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
                PlayZTVLiveEventsProvider.csGuardWasEverActive = true;
            }
            return PlayZTVLiveEventsProvider.csGuardWasEverActive;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showCsGuardToast(final Context ctx) {
            if (ctx == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.PlayZTVLiveEventsProvider$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PlayZTVLiveEventsProvider.Companion.showCsGuardToast$lambda$0(ctx);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showCsGuardToast$lambda$0(Context $c) {
            Toast.makeText($c, "🚫 CSGuard detected — Restart CloudStream after removing CSGuard to use CNCRepo", 1).show();
        }

        @Nullable
        public final Context getContext() {
            return PlayZTVLiveEventsProvider.context;
        }

        public final void setContext(@Nullable Context context) {
            PlayZTVLiveEventsProvider.context = context;
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
    public String getLang() {
        return this.lang;
    }

    public void setLang(@NotNull String str) {
        this.lang = str;
    }

    public boolean getHasMainPage() {
        return this.hasMainPage;
    }

    public boolean getHasChromecastSupport() {
        return this.hasChromecastSupport;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    private final String createDisplayTitle(PlayZLiveEventData event) {
        PlayZLiveEventInfo info = event.getEventInfo();
        if (info == null) {
            return event.getTitle();
        }
        String teamA = info.getTeamA();
        if (!(teamA == null || StringsKt.isBlank(teamA))) {
            String teamB = info.getTeamB();
            if (!(teamB == null || StringsKt.isBlank(teamB)) && !Intrinsics.areEqual(info.getTeamA(), info.getTeamB())) {
                return info.getTeamA() + " vs " + info.getTeamB();
            }
        }
        String teamA2 = info.getTeamA();
        return teamA2 == null ? event.getTitle() : teamA2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getEventStatus(PlayZLiveEventData event) {
        Date date;
        Date date2;
        PlayZLiveEventInfo info = event.getEventInfo();
        if (info == null) {
            return "";
        }
        long now = System.currentTimeMillis();
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
            String it = info.getStartTime();
            Long end = null;
            Long start = (it == null || (date2 = fmt.parse(it)) == null) ? null : Long.valueOf(date2.getTime());
            String it2 = info.getEndTime();
            if (it2 != null && (date = fmt.parse(it2)) != null) {
                end = Long.valueOf(date.getTime());
            }
            if (end != null && now >= end.longValue()) {
                return "✅";
            }
            if (start == null || now < start.longValue()) {
                return (start == null || now >= start.longValue()) ? "" : "🔜";
            }
            return "🔴";
        } catch (Exception e) {
            return "";
        }
    }

    private final boolean isEventLive(PlayZLiveEventData event) {
        Date date;
        Date date2;
        PlayZLiveEventInfo info = event.getEventInfo();
        if (info == null) {
            return false;
        }
        long now = System.currentTimeMillis();
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
            String it = info.getStartTime();
            Long end = null;
            Long start = (it == null || (date2 = fmt.parse(it)) == null) ? null : Long.valueOf(date2.getTime());
            String it2 = info.getEndTime();
            if (it2 != null && (date = fmt.parse(it2)) != null) {
                end = Long.valueOf(date.getTime());
            }
            return (end == null || now < end.longValue()) && start != null && now >= start.longValue();
        } catch (Exception e) {
            return false;
        }
    }

    private final boolean isEventEnded(PlayZLiveEventData event) {
        Date date;
        PlayZLiveEventInfo info = event.getEventInfo();
        if (info == null) {
            return false;
        }
        long now = System.currentTimeMillis();
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
            String it = info.getEndTime();
            Long end = null;
            if (it != null && (date = fmt.parse(it)) != null) {
                end = Long.valueOf(date.getTime());
            }
            return end != null && now >= end.longValue();
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00a9  */
    private final String generateMatchCardUrl(PlayZLiveEventData event) {
        String title;
        String teamA;
        String teamB;
        String teamAFlag;
        String teamBFlag;
        String eventLogo;
        String it;
        PlayZLiveEventInfo info = event.getEventInfo();
        Function1 encode = new Function1() { // from class: com.cncverse.PlayZTVLiveEventsProvider$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                return PlayZTVLiveEventsProvider.generateMatchCardUrl$lambda$0((String) obj);
            }
        };
        if (info == null || (title = info.getEventName()) == null) {
            title = event.getTitle();
        }
        String title2 = (String) encode.invoke(title);
        if (info == null || (teamA = info.getTeamA()) == null) {
            teamA = "Team A";
        }
        String teamA2 = (String) encode.invoke(teamA);
        if (info == null || (teamB = info.getTeamB()) == null) {
            teamB = "Team B";
        }
        String teamB2 = (String) encode.invoke(teamB);
        String time = "";
        if (info == null || (teamAFlag = info.getTeamAFlag()) == null) {
            teamAFlag = "";
        }
        String teamAImg = teamAFlag;
        if (info == null || (teamBFlag = info.getTeamBFlag()) == null) {
            teamBFlag = "";
        }
        String teamBImg = teamBFlag;
        if (info == null || (eventLogo = info.getEventLogo()) == null) {
            eventLogo = "";
        }
        String eventLogo2 = eventLogo;
        boolean isLive = isEventLive(event);
        boolean isEnded = isEventEnded(event);
        if (info != null) {
            try {
                String it2 = info.getStartTime();
                if (it2 != null) {
                    SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                    try {
                        SimpleDateFormat disp = new SimpleDateFormat("MMM dd, yyyy hh:mm a", Locale.US);
                        Date d = df.parse(it2);
                        if (d == null || (it = (String) encode.invoke(disp.format(d))) == null) {
                            it = "";
                        }
                        if (it != null) {
                            time = it;
                        }
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
            }
        }
        StringBuilder $this$generateMatchCardUrl_u24lambda_u242 = new StringBuilder();
        $this$generateMatchCardUrl_u24lambda_u242.append("https://live-card-png.cricify.workers.dev/?");
        $this$generateMatchCardUrl_u24lambda_u242.append("title=" + title2);
        $this$generateMatchCardUrl_u24lambda_u242.append("&teamA=" + teamA2);
        $this$generateMatchCardUrl_u24lambda_u242.append("&teamB=" + teamB2);
        if (!StringsKt.isBlank(teamAImg)) {
            $this$generateMatchCardUrl_u24lambda_u242.append("&teamAImg=" + teamAImg);
        }
        if (!StringsKt.isBlank(teamBImg)) {
            $this$generateMatchCardUrl_u24lambda_u242.append("&teamBImg=" + teamBImg);
        }
        if (!StringsKt.isBlank(eventLogo2)) {
            $this$generateMatchCardUrl_u24lambda_u242.append("&eventLogo=" + eventLogo2);
        }
        if (!StringsKt.isBlank(time)) {
            $this$generateMatchCardUrl_u24lambda_u242.append("&time=" + time);
        }
        $this$generateMatchCardUrl_u24lambda_u242.append("&isLive=" + isLive);
        $this$generateMatchCardUrl_u24lambda_u242.append("&isEnded=" + isEnded);
        return $this$generateMatchCardUrl_u24lambda_u242.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String generateMatchCardUrl$lambda$0(String it) {
        return URLEncoder.encode(it, "UTF-8");
    }

    /* JADX INFO: compiled from: PlayZTVLiveEventsProvider.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003JM\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/cncverse/PlayZTVLiveEventsProvider$LiveEventLoadData;", "", "eventId", "", "title", "", "poster", "slug", "formats", "", "Lcom/cncverse/PlayZLiveEventFormat;", "eventInfo", "Lcom/cncverse/PlayZLiveEventInfo;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/cncverse/PlayZLiveEventInfo;)V", "getEventId", "()I", "getTitle", "()Ljava/lang/String;", "getPoster", "getSlug", "getFormats", "()Ljava/util/List;", "getEventInfo", "()Lcom/cncverse/PlayZLiveEventInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "PlayZTVProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class LiveEventLoadData {
        private final int eventId;

        @Nullable
        private final PlayZLiveEventInfo eventInfo;

        @NotNull
        private final List<PlayZLiveEventFormat> formats;

        @NotNull
        private final String poster;

        @NotNull
        private final String slug;

        @NotNull
        private final String title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ LiveEventLoadData copy$default(LiveEventLoadData liveEventLoadData, int i, String str, String str2, String str3, List list, PlayZLiveEventInfo playZLiveEventInfo, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = liveEventLoadData.eventId;
            }
            if ((i2 & 2) != 0) {
                str = liveEventLoadData.title;
            }
            if ((i2 & 4) != 0) {
                str2 = liveEventLoadData.poster;
            }
            if ((i2 & 8) != 0) {
                str3 = liveEventLoadData.slug;
            }
            if ((i2 & 16) != 0) {
                list = liveEventLoadData.formats;
            }
            if ((i2 & 32) != 0) {
                playZLiveEventInfo = liveEventLoadData.eventInfo;
            }
            List list2 = list;
            PlayZLiveEventInfo playZLiveEventInfo2 = playZLiveEventInfo;
            return liveEventLoadData.copy(i, str, str2, str3, list2, playZLiveEventInfo2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getEventId() {
            return this.eventId;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getPoster() {
            return this.poster;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSlug() {
            return this.slug;
        }

        @NotNull
        public final List<PlayZLiveEventFormat> component5() {
            return this.formats;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final PlayZLiveEventInfo getEventInfo() {
            return this.eventInfo;
        }

        @NotNull
        public final LiveEventLoadData copy(int eventId, @NotNull String title, @NotNull String poster, @NotNull String slug, @NotNull List<PlayZLiveEventFormat> formats, @Nullable PlayZLiveEventInfo eventInfo) {
            return new LiveEventLoadData(eventId, title, poster, slug, formats, eventInfo);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LiveEventLoadData)) {
                return false;
            }
            LiveEventLoadData liveEventLoadData = (LiveEventLoadData) other;
            return this.eventId == liveEventLoadData.eventId && Intrinsics.areEqual(this.title, liveEventLoadData.title) && Intrinsics.areEqual(this.poster, liveEventLoadData.poster) && Intrinsics.areEqual(this.slug, liveEventLoadData.slug) && Intrinsics.areEqual(this.formats, liveEventLoadData.formats) && Intrinsics.areEqual(this.eventInfo, liveEventLoadData.eventInfo);
        }

        public int hashCode() {
            return (((((((((this.eventId * 31) + this.title.hashCode()) * 31) + this.poster.hashCode()) * 31) + this.slug.hashCode()) * 31) + this.formats.hashCode()) * 31) + (this.eventInfo == null ? 0 : this.eventInfo.hashCode());
        }

        @NotNull
        public String toString() {
            return "LiveEventLoadData(eventId=" + this.eventId + ", title=" + this.title + ", poster=" + this.poster + ", slug=" + this.slug + ", formats=" + this.formats + ", eventInfo=" + this.eventInfo + ')';
        }

        public LiveEventLoadData(int eventId, @NotNull String title, @NotNull String poster, @NotNull String slug, @NotNull List<PlayZLiveEventFormat> list, @Nullable PlayZLiveEventInfo eventInfo) {
            this.eventId = eventId;
            this.title = title;
            this.poster = poster;
            this.slug = slug;
            this.formats = list;
            this.eventInfo = eventInfo;
        }

        public final int getEventId() {
            return this.eventId;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getPoster() {
            return this.poster;
        }

        @NotNull
        public final String getSlug() {
            return this.slug;
        }

        @NotNull
        public final List<PlayZLiveEventFormat> getFormats() {
            return this.formats;
        }

        @Nullable
        public final PlayZLiveEventInfo getEventInfo() {
            return this.eventInfo;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:101:0x026c  */
    /* JADX WARN: Code duplicated, block: B:112:0x0270 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:37:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:43:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:48:0x012b  */
    /* JADX WARN: Code duplicated, block: B:51:0x0157  */
    /* JADX WARN: Code duplicated, block: B:54:0x0160  */
    /* JADX WARN: Code duplicated, block: B:55:0x0163  */
    /* JADX WARN: Code duplicated, block: B:58:0x016c  */
    /* JADX WARN: Code duplicated, block: B:59:0x016f  */
    /* JADX WARN: Code duplicated, block: B:62:0x0178  */
    /* JADX WARN: Code duplicated, block: B:63:0x017b  */
    /* JADX WARN: Code duplicated, block: B:66:0x0184  */
    /* JADX WARN: Code duplicated, block: B:67:0x0187  */
    /* JADX WARN: Code duplicated, block: B:70:0x0190  */
    /* JADX WARN: Code duplicated, block: B:71:0x0193  */
    /* JADX WARN: Code duplicated, block: B:74:0x019c  */
    /* JADX WARN: Code duplicated, block: B:75:0x019f  */
    /* JADX WARN: Code duplicated, block: B:78:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:79:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:83:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:85:0x020b  */
    /* JADX WARN: Code duplicated, block: B:86:0x0227  */
    /* JADX WARN: Code duplicated, block: B:89:0x023a  */
    /* JADX WARN: Code duplicated, block: B:91:0x0242  */
    /* JADX WARN: Code duplicated, block: B:95:0x024b  */
    /* JADX WARN: Code duplicated, block: B:97:0x024e  */
    /* JADX WARN: Code duplicated, block: B:98:0x0255  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00151 c00151;
        Object objFetchLiveEvents;
        MainPageRequest request2;
        Object objFetchCustomEvents;
        List events;
        Map grouped;
        Map $this$map$iv;
        Collection destination$iv$iv;
        String lowerCase;
        String icon;
        Iterable $this$map$iv2;
        Collection destination$iv$iv2;
        Iterable $this$mapTo$iv$iv;
        Iterator it;
        Iterable $this$map$iv3;
        PlayZLiveEventData event;
        String displayTitle;
        String status;
        String status2;
        String poster;
        List<PlayZLiveEventFormat> formats;
        String image;
        boolean z;
        PlayZLiveEventInfo eventInfo;
        String str;
        Object value$iv$iv$iv;
        Object answer$iv$iv$iv;
        int page2 = page;
        if (continuation instanceof C00151) {
            c00151 = (C00151) continuation;
            if ((c00151.label & Integer.MIN_VALUE) != 0) {
                c00151.label -= Integer.MIN_VALUE;
            } else {
                c00151 = new C00151(continuation);
            }
        } else {
            c00151 = new C00151(continuation);
        }
        Object $result = c00151.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00151.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                }
                showTelegramPopup();
                showSubscriptionPopupIfNeeded();
                if (this.customCatLink == null) {
                    PlayZTVProviderManager playZTVProviderManager = PlayZTVProviderManager.INSTANCE;
                    c00151.L$0 = SpillingKt.nullOutSpilledVariable(request);
                    c00151.I$0 = page2;
                    c00151.label = 2;
                    objFetchLiveEvents = playZTVProviderManager.fetchLiveEvents(c00151);
                    if (objFetchLiveEvents == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    request2 = request;
                    events = (List) objFetchLiveEvents;
                    List $this$groupBy$iv = events;
                    grouped = new LinkedHashMap();
                    for (Object element$iv$iv : $this$groupBy$iv) {
                        PlayZLiveEventData it2 = (PlayZLiveEventData) element$iv$iv;
                        eventInfo = it2.getEventInfo();
                        String cat = eventInfo != null ? "Other" : "Other";
                        str = cat;
                        value$iv$iv$iv = grouped.get(str);
                        if (value$iv$iv$iv == null) {
                            Object answer$iv$iv$iv2 = (List) new ArrayList();
                            answer$iv$iv$iv = answer$iv$iv$iv2;
                            grouped.put(str, answer$iv$iv$iv);
                        } else {
                            answer$iv$iv$iv = value$iv$iv$iv;
                        }
                        List list$iv$iv = (List) answer$iv$iv$iv;
                        list$iv$iv.add(element$iv$iv);
                        page2 = page2;
                    }
                    $this$map$iv = grouped;
                    destination$iv$iv = new ArrayList($this$map$iv.size());
                    for (Map.Entry item$iv$iv : $this$map$iv.entrySet()) {
                        String category = (String) item$iv$iv.getKey();
                        List catEvents = (List) item$iv$iv.getValue();
                        Map $this$map$iv4 = $this$map$iv;
                        lowerCase = category.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        switch (lowerCase) {
                            case "boxing":
                                icon = "🥊";
                                break;
                            case "tennis":
                                icon = "🎾";
                                break;
                            case "ice hockey":
                                icon = "🏒";
                                break;
                            case "football":
                                icon = "⚽";
                                break;
                            case "motorsport":
                                icon = "🏎️";
                                break;
                            case "basketball":
                                icon = "🏀";
                                break;
                            case "cricket":
                                icon = "🏏";
                                break;
                            default:
                                icon = "📺";
                                break;
                        }
                        C00151 c00152 = c00151;
                        final Comparator comparator = new Comparator() { // from class: com.cncverse.PlayZTVLiveEventsProvider$getMainPage$lambda$1$$inlined$compareBy$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                Integer num;
                                Integer num2;
                                PlayZLiveEventData event2 = (PlayZLiveEventData) t;
                                String status3 = this.this$0.getEventStatus(event2);
                                if (StringsKt.contains$default(status3, "🔴", false, 2, (Object) null)) {
                                    num = (Comparable) 0;
                                } else if (StringsKt.contains$default(status3, "🔜", false, 2, (Object) null)) {
                                    num = (Comparable) 1;
                                } else {
                                    num = StringsKt.contains$default(status3, "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                                }
                                PlayZLiveEventData event3 = (PlayZLiveEventData) t2;
                                String status4 = this.this$0.getEventStatus(event3);
                                if (StringsKt.contains$default(status4, "🔴", false, 2, (Object) null)) {
                                    num2 = (Comparable) 0;
                                } else if (StringsKt.contains$default(status4, "🔜", false, 2, (Object) null)) {
                                    num2 = (Comparable) 1;
                                } else {
                                    num2 = StringsKt.contains$default(status4, "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                                }
                                return ComparisonsKt.compareValues(num, num2);
                            }
                        };
                        Object $result2 = $result;
                        $this$map$iv2 = CollectionsKt.sortedWith(catEvents, new Comparator() { // from class: com.cncverse.PlayZTVLiveEventsProvider$getMainPage$lambda$1$$inlined$thenBy$1
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // java.util.Comparator
                            public final int compare(T t, T t2) {
                                Long lValueOf;
                                Long lValueOf2;
                                String startTime;
                                String startTime2;
                                int previousCompare = comparator.compare(t, t2);
                                if (previousCompare != 0) {
                                    return previousCompare;
                                }
                                PlayZLiveEventData event2 = (PlayZLiveEventData) t;
                                try {
                                    PlayZLiveEventInfo info = event2.getEventInfo();
                                    if (info == null || (startTime2 = info.getStartTime()) == null) {
                                        lValueOf = (Comparable) Long.MAX_VALUE;
                                    } else {
                                        SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                        Date date = fmt.parse(startTime2);
                                        lValueOf = Long.valueOf(date != null ? date.getTime() : Long.MAX_VALUE);
                                    }
                                } catch (Exception e) {
                                    lValueOf = (Comparable) Long.MAX_VALUE;
                                }
                                PlayZLiveEventData event3 = (PlayZLiveEventData) t2;
                                try {
                                    PlayZLiveEventInfo info2 = event3.getEventInfo();
                                    if (info2 == null || (startTime = info2.getStartTime()) == null) {
                                        lValueOf2 = (Comparable) Long.MAX_VALUE;
                                    } else {
                                        SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                        Date date2 = fmt2.parse(startTime);
                                        lValueOf2 = Long.valueOf(date2 != null ? date2.getTime() : Long.MAX_VALUE);
                                    }
                                } catch (Exception e2) {
                                    lValueOf2 = (Comparable) Long.MAX_VALUE;
                                }
                                return ComparisonsKt.compareValues(lValueOf, lValueOf2);
                            }
                        });
                        destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                        $this$mapTo$iv$iv = $this$map$iv2;
                        it = $this$mapTo$iv$iv.iterator();
                        while (true) {
                            $this$map$iv3 = $this$map$iv2;
                            if (it.hasNext()) {
                                event = (PlayZLiveEventData) it.next();
                                Iterable $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                                displayTitle = createDisplayTitle(event);
                                MainPageRequest request3 = request2;
                                status = getEventStatus(event);
                                if (StringsKt.isBlank(status)) {
                                    status2 = displayTitle;
                                } else {
                                    status2 = status + ' ' + displayTitle;
                                }
                                String fullTitle = status2;
                                if (Intrinsics.areEqual(event.getCat(), "Custom")) {
                                    image = event.getImage();
                                    if (image != null) {
                                        z = true;
                                    } else {
                                        z = true;
                                    }
                                    if (z) {
                                        poster = generateMatchCardUrl(event);
                                    } else {
                                        poster = event.getImage();
                                    }
                                } else {
                                    poster = generateMatchCardUrl(event);
                                }
                                int id = event.getId();
                                String slug = event.getSlug();
                                formats = event.getFormats();
                                if (formats == null) {
                                    formats = CollectionsKt.emptyList();
                                }
                                LiveEventLoadData loadData = new LiveEventLoadData(id, displayTitle, poster, slug, formats, event.getEventInfo());
                                final String poster2 = poster;
                                destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle, AppUtils.INSTANCE.toJson(loadData), TvType.Live, false, new Function1() { // from class: com.cncverse.PlayZTVLiveEventsProvider$$ExternalSyntheticLambda5
                                    public final Object invoke(Object obj) {
                                        return PlayZTVLiveEventsProvider.getMainPage$lambda$1$2$0(poster2, (LiveSearchResponse) obj);
                                    }
                                }, 8, (Object) null));
                                $this$map$iv2 = $this$map$iv3;
                                $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                                request2 = request3;
                                events = events;
                            }
                        }
                        List items = (List) destination$iv$iv2;
                        destination$iv$iv.add(new HomePageList(icon + ' ' + category, items, true));
                        $this$map$iv = $this$map$iv4;
                        c00151 = c00152;
                        $result = $result2;
                        request2 = request2;
                    }
                    Iterable $this$sortedBy$iv = (List) destination$iv$iv;
                    List pages = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: com.cncverse.PlayZTVLiveEventsProvider$getMainPage$$inlined$sortedBy$1
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            int i;
                            HomePageList list = (HomePageList) t;
                            int i2 = 1;
                            if (StringsKt.contains(list.getName(), "Cricket", true)) {
                                i = 0;
                            } else if (StringsKt.contains(list.getName(), "Football", true)) {
                                i = 1;
                            } else {
                                i = StringsKt.contains(list.getName(), "Basketball", true) ? 2 : 10;
                            }
                            Integer numValueOf = Integer.valueOf(i);
                            HomePageList list2 = (HomePageList) t2;
                            if (StringsKt.contains(list2.getName(), "Cricket", true)) {
                                i2 = 0;
                            } else if (!StringsKt.contains(list2.getName(), "Football", true)) {
                                i2 = StringsKt.contains(list2.getName(), "Basketball", true) ? 2 : 10;
                            }
                            return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(i2));
                        }
                    });
                    return MainAPIKt.newHomePageResponse(pages, Boxing.boxBoolean(false));
                }
                PlayZTVProviderManager playZTVProviderManager2 = PlayZTVProviderManager.INSTANCE;
                String str2 = this.customCatLink;
                c00151.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00151.I$0 = page2;
                c00151.label = 1;
                objFetchCustomEvents = playZTVProviderManager2.fetchCustomEvents(str2, c00151);
                if (objFetchCustomEvents == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                events = (List) objFetchCustomEvents;
                List $this$groupBy$iv2 = events;
                grouped = new LinkedHashMap();
                while (r13.hasNext()) {
                    PlayZLiveEventData it3 = (PlayZLiveEventData) element$iv$iv;
                    eventInfo = it3.getEventInfo();
                    if ((eventInfo != null || (cat = eventInfo.getEventCat()) == null) && (cat = it3.getCat()) == null) {
                    }
                    str = cat;
                    value$iv$iv$iv = grouped.get(str);
                    if (value$iv$iv$iv == null) {
                        Object answer$iv$iv$iv3 = (List) new ArrayList();
                        answer$iv$iv$iv = answer$iv$iv$iv3;
                        grouped.put(str, answer$iv$iv$iv);
                    } else {
                        answer$iv$iv$iv = value$iv$iv$iv;
                    }
                    List list$iv$iv2 = (List) answer$iv$iv$iv;
                    list$iv$iv2.add(element$iv$iv);
                    page2 = page2;
                }
                $this$map$iv = grouped;
                destination$iv$iv = new ArrayList($this$map$iv.size());
                while (r12.hasNext()) {
                    String category2 = (String) item$iv$iv.getKey();
                    List catEvents2 = (List) item$iv$iv.getValue();
                    Map $this$map$iv5 = $this$map$iv;
                    lowerCase = category2.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    switch (lowerCase) {
                        case -1383120329:
                            if (!lowerCase.equals("boxing")) {
                                icon = "📺";
                            } else {
                                icon = "🥊";
                            }
                            break;
                        case -877324069:
                            if (!lowerCase.equals("tennis")) {
                                icon = "📺";
                            } else {
                                icon = "🎾";
                            }
                            break;
                        case -654884904:
                            if (!lowerCase.equals("ice hockey")) {
                                icon = "📺";
                            } else {
                                icon = "🏒";
                            }
                            break;
                        case 394668909:
                            if (!lowerCase.equals("football")) {
                                icon = "📺";
                            } else {
                                icon = "⚽";
                            }
                            break;
                        case 400486431:
                            if (!lowerCase.equals("motorsport")) {
                                icon = "📺";
                            } else {
                                icon = "🏎️";
                            }
                            break;
                        case 727149765:
                            if (!lowerCase.equals("basketball")) {
                                icon = "📺";
                            } else {
                                icon = "🏀";
                            }
                            break;
                        case 1032299505:
                            if (!lowerCase.equals("cricket")) {
                                icon = "📺";
                            } else {
                                icon = "🏏";
                            }
                            break;
                        default:
                            icon = "📺";
                            break;
                    }
                    C00151 c00153 = c00151;
                    final Comparator comparator2 = new Comparator() { // from class: com.cncverse.PlayZTVLiveEventsProvider$getMainPage$lambda$1$$inlined$compareBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Integer num;
                            Integer num2;
                            PlayZLiveEventData event2 = (PlayZLiveEventData) t;
                            String status3 = this.this$0.getEventStatus(event2);
                            if (StringsKt.contains$default(status3, "🔴", false, 2, (Object) null)) {
                                num = (Comparable) 0;
                            } else if (StringsKt.contains$default(status3, "🔜", false, 2, (Object) null)) {
                                num = (Comparable) 1;
                            } else {
                                num = StringsKt.contains$default(status3, "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                            }
                            PlayZLiveEventData event3 = (PlayZLiveEventData) t2;
                            String status4 = this.this$0.getEventStatus(event3);
                            if (StringsKt.contains$default(status4, "🔴", false, 2, (Object) null)) {
                                num2 = (Comparable) 0;
                            } else if (StringsKt.contains$default(status4, "🔜", false, 2, (Object) null)) {
                                num2 = (Comparable) 1;
                            } else {
                                num2 = StringsKt.contains$default(status4, "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                            }
                            return ComparisonsKt.compareValues(num, num2);
                        }
                    };
                    Object $result3 = $result;
                    $this$map$iv2 = CollectionsKt.sortedWith(catEvents2, new Comparator() { // from class: com.cncverse.PlayZTVLiveEventsProvider$getMainPage$lambda$1$$inlined$thenBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Long lValueOf;
                            Long lValueOf2;
                            String startTime;
                            String startTime2;
                            int previousCompare = comparator2.compare(t, t2);
                            if (previousCompare != 0) {
                                return previousCompare;
                            }
                            PlayZLiveEventData event2 = (PlayZLiveEventData) t;
                            try {
                                PlayZLiveEventInfo info = event2.getEventInfo();
                                if (info == null || (startTime2 = info.getStartTime()) == null) {
                                    lValueOf = (Comparable) Long.MAX_VALUE;
                                } else {
                                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                    Date date = fmt.parse(startTime2);
                                    lValueOf = Long.valueOf(date != null ? date.getTime() : Long.MAX_VALUE);
                                }
                            } catch (Exception e) {
                                lValueOf = (Comparable) Long.MAX_VALUE;
                            }
                            PlayZLiveEventData event3 = (PlayZLiveEventData) t2;
                            try {
                                PlayZLiveEventInfo info2 = event3.getEventInfo();
                                if (info2 == null || (startTime = info2.getStartTime()) == null) {
                                    lValueOf2 = (Comparable) Long.MAX_VALUE;
                                } else {
                                    SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                    Date date2 = fmt2.parse(startTime);
                                    lValueOf2 = Long.valueOf(date2 != null ? date2.getTime() : Long.MAX_VALUE);
                                }
                            } catch (Exception e2) {
                                lValueOf2 = (Comparable) Long.MAX_VALUE;
                            }
                            return ComparisonsKt.compareValues(lValueOf, lValueOf2);
                        }
                    });
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    $this$mapTo$iv$iv = $this$map$iv2;
                    it = $this$mapTo$iv$iv.iterator();
                    while (true) {
                        $this$map$iv3 = $this$map$iv2;
                        if (it.hasNext()) {
                            event = (PlayZLiveEventData) it.next();
                            Iterable $this$mapTo$iv$iv3 = $this$mapTo$iv$iv;
                            displayTitle = createDisplayTitle(event);
                            MainPageRequest request4 = request2;
                            status = getEventStatus(event);
                            if (StringsKt.isBlank(status)) {
                                status2 = status + ' ' + displayTitle;
                            } else {
                                status2 = displayTitle;
                            }
                            String fullTitle2 = status2;
                            if (Intrinsics.areEqual(event.getCat(), "Custom")) {
                                poster = generateMatchCardUrl(event);
                            } else {
                                image = event.getImage();
                                if (image != null || StringsKt.isBlank(image)) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    poster = event.getImage();
                                } else {
                                    poster = generateMatchCardUrl(event);
                                }
                            }
                            int id2 = event.getId();
                            String slug2 = event.getSlug();
                            formats = event.getFormats();
                            if (formats == null) {
                                formats = CollectionsKt.emptyList();
                            }
                            LiveEventLoadData loadData2 = new LiveEventLoadData(id2, displayTitle, poster, slug2, formats, event.getEventInfo());
                            final String poster3 = poster;
                            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle2, AppUtils.INSTANCE.toJson(loadData2), TvType.Live, false, new Function1() { // from class: com.cncverse.PlayZTVLiveEventsProvider$$ExternalSyntheticLambda5
                                public final Object invoke(Object obj) {
                                    return PlayZTVLiveEventsProvider.getMainPage$lambda$1$2$0(poster3, (LiveSearchResponse) obj);
                                }
                            }, 8, (Object) null));
                            $this$map$iv2 = $this$map$iv3;
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv3;
                            request2 = request4;
                            events = events;
                        }
                    }
                    List items2 = (List) destination$iv$iv2;
                    destination$iv$iv.add(new HomePageList(icon + ' ' + category2, items2, true));
                    $this$map$iv = $this$map$iv5;
                    c00151 = c00153;
                    $result = $result3;
                    request2 = request2;
                }
                Iterable $this$sortedBy$iv2 = (List) destination$iv$iv;
                List pages2 = CollectionsKt.sortedWith($this$sortedBy$iv2, new Comparator() { // from class: com.cncverse.PlayZTVLiveEventsProvider$getMainPage$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int i;
                        HomePageList list = (HomePageList) t;
                        int i2 = 1;
                        if (StringsKt.contains(list.getName(), "Cricket", true)) {
                            i = 0;
                        } else if (StringsKt.contains(list.getName(), "Football", true)) {
                            i = 1;
                        } else {
                            i = StringsKt.contains(list.getName(), "Basketball", true) ? 2 : 10;
                        }
                        Integer numValueOf = Integer.valueOf(i);
                        HomePageList list2 = (HomePageList) t2;
                        if (StringsKt.contains(list2.getName(), "Cricket", true)) {
                            i2 = 0;
                        } else if (!StringsKt.contains(list2.getName(), "Football", true)) {
                            i2 = StringsKt.contains(list2.getName(), "Basketball", true) ? 2 : 10;
                        }
                        return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(i2));
                    }
                });
                return MainAPIKt.newHomePageResponse(pages2, Boxing.boxBoolean(false));
            case 1:
                page2 = c00151.I$0;
                request2 = (MainPageRequest) c00151.L$0;
                ResultKt.throwOnFailure($result);
                objFetchCustomEvents = $result;
                events = (List) objFetchCustomEvents;
                List $this$groupBy$iv3 = events;
                grouped = new LinkedHashMap();
                while (r13.hasNext()) {
                    PlayZLiveEventData it4 = (PlayZLiveEventData) element$iv$iv;
                    eventInfo = it4.getEventInfo();
                    if (eventInfo != null) {
                    }
                    str = cat;
                    value$iv$iv$iv = grouped.get(str);
                    if (value$iv$iv$iv == null) {
                        Object answer$iv$iv$iv4 = (List) new ArrayList();
                        answer$iv$iv$iv = answer$iv$iv$iv4;
                        grouped.put(str, answer$iv$iv$iv);
                    } else {
                        answer$iv$iv$iv = value$iv$iv$iv;
                    }
                    List list$iv$iv3 = (List) answer$iv$iv$iv;
                    list$iv$iv3.add(element$iv$iv);
                    page2 = page2;
                }
                $this$map$iv = grouped;
                destination$iv$iv = new ArrayList($this$map$iv.size());
                while (r12.hasNext()) {
                    String category3 = (String) item$iv$iv.getKey();
                    List catEvents3 = (List) item$iv$iv.getValue();
                    Map $this$map$iv6 = $this$map$iv;
                    lowerCase = category3.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    switch (lowerCase) {
                        case -1383120329:
                            if (!lowerCase.equals("boxing")) {
                                icon = "📺";
                            } else {
                                icon = "🥊";
                            }
                            break;
                        case -877324069:
                            if (!lowerCase.equals("tennis")) {
                                icon = "📺";
                            } else {
                                icon = "🎾";
                            }
                            break;
                        case -654884904:
                            if (!lowerCase.equals("ice hockey")) {
                                icon = "📺";
                            } else {
                                icon = "🏒";
                            }
                            break;
                        case 394668909:
                            if (!lowerCase.equals("football")) {
                                icon = "📺";
                            } else {
                                icon = "⚽";
                            }
                            break;
                        case 400486431:
                            if (!lowerCase.equals("motorsport")) {
                                icon = "📺";
                            } else {
                                icon = "🏎️";
                            }
                            break;
                        case 727149765:
                            if (!lowerCase.equals("basketball")) {
                                icon = "📺";
                            } else {
                                icon = "🏀";
                            }
                            break;
                        case 1032299505:
                            if (!lowerCase.equals("cricket")) {
                                icon = "📺";
                            } else {
                                icon = "🏏";
                            }
                            break;
                        default:
                            icon = "📺";
                            break;
                    }
                    C00151 c00154 = c00151;
                    final Comparator comparator3 = new Comparator() { // from class: com.cncverse.PlayZTVLiveEventsProvider$getMainPage$lambda$1$$inlined$compareBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Integer num;
                            Integer num2;
                            PlayZLiveEventData event2 = (PlayZLiveEventData) t;
                            String status3 = this.this$0.getEventStatus(event2);
                            if (StringsKt.contains$default(status3, "🔴", false, 2, (Object) null)) {
                                num = (Comparable) 0;
                            } else if (StringsKt.contains$default(status3, "🔜", false, 2, (Object) null)) {
                                num = (Comparable) 1;
                            } else {
                                num = StringsKt.contains$default(status3, "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                            }
                            PlayZLiveEventData event3 = (PlayZLiveEventData) t2;
                            String status4 = this.this$0.getEventStatus(event3);
                            if (StringsKt.contains$default(status4, "🔴", false, 2, (Object) null)) {
                                num2 = (Comparable) 0;
                            } else if (StringsKt.contains$default(status4, "🔜", false, 2, (Object) null)) {
                                num2 = (Comparable) 1;
                            } else {
                                num2 = StringsKt.contains$default(status4, "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                            }
                            return ComparisonsKt.compareValues(num, num2);
                        }
                    };
                    Object $result4 = $result;
                    $this$map$iv2 = CollectionsKt.sortedWith(catEvents3, new Comparator() { // from class: com.cncverse.PlayZTVLiveEventsProvider$getMainPage$lambda$1$$inlined$thenBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Long lValueOf;
                            Long lValueOf2;
                            String startTime;
                            String startTime2;
                            int previousCompare = comparator3.compare(t, t2);
                            if (previousCompare != 0) {
                                return previousCompare;
                            }
                            PlayZLiveEventData event2 = (PlayZLiveEventData) t;
                            try {
                                PlayZLiveEventInfo info = event2.getEventInfo();
                                if (info == null || (startTime2 = info.getStartTime()) == null) {
                                    lValueOf = (Comparable) Long.MAX_VALUE;
                                } else {
                                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                    Date date = fmt.parse(startTime2);
                                    lValueOf = Long.valueOf(date != null ? date.getTime() : Long.MAX_VALUE);
                                }
                            } catch (Exception e) {
                                lValueOf = (Comparable) Long.MAX_VALUE;
                            }
                            PlayZLiveEventData event3 = (PlayZLiveEventData) t2;
                            try {
                                PlayZLiveEventInfo info2 = event3.getEventInfo();
                                if (info2 == null || (startTime = info2.getStartTime()) == null) {
                                    lValueOf2 = (Comparable) Long.MAX_VALUE;
                                } else {
                                    SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                    Date date2 = fmt2.parse(startTime);
                                    lValueOf2 = Long.valueOf(date2 != null ? date2.getTime() : Long.MAX_VALUE);
                                }
                            } catch (Exception e2) {
                                lValueOf2 = (Comparable) Long.MAX_VALUE;
                            }
                            return ComparisonsKt.compareValues(lValueOf, lValueOf2);
                        }
                    });
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    $this$mapTo$iv$iv = $this$map$iv2;
                    it = $this$mapTo$iv$iv.iterator();
                    while (true) {
                        $this$map$iv3 = $this$map$iv2;
                        if (it.hasNext()) {
                            event = (PlayZLiveEventData) it.next();
                            Iterable $this$mapTo$iv$iv4 = $this$mapTo$iv$iv;
                            displayTitle = createDisplayTitle(event);
                            MainPageRequest request5 = request2;
                            status = getEventStatus(event);
                            if (StringsKt.isBlank(status)) {
                                status2 = status + ' ' + displayTitle;
                            } else {
                                status2 = displayTitle;
                            }
                            String fullTitle3 = status2;
                            if (Intrinsics.areEqual(event.getCat(), "Custom")) {
                                poster = generateMatchCardUrl(event);
                            } else {
                                image = event.getImage();
                                if (image != null) {
                                    z = true;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    poster = event.getImage();
                                } else {
                                    poster = generateMatchCardUrl(event);
                                }
                            }
                            int id3 = event.getId();
                            String slug3 = event.getSlug();
                            formats = event.getFormats();
                            if (formats == null) {
                                formats = CollectionsKt.emptyList();
                            }
                            LiveEventLoadData loadData3 = new LiveEventLoadData(id3, displayTitle, poster, slug3, formats, event.getEventInfo());
                            final String poster4 = poster;
                            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle3, AppUtils.INSTANCE.toJson(loadData3), TvType.Live, false, new Function1() { // from class: com.cncverse.PlayZTVLiveEventsProvider$$ExternalSyntheticLambda5
                                public final Object invoke(Object obj) {
                                    return PlayZTVLiveEventsProvider.getMainPage$lambda$1$2$0(poster4, (LiveSearchResponse) obj);
                                }
                            }, 8, (Object) null));
                            $this$map$iv2 = $this$map$iv3;
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv4;
                            request2 = request5;
                            events = events;
                        }
                    }
                    List items3 = (List) destination$iv$iv2;
                    destination$iv$iv.add(new HomePageList(icon + ' ' + category3, items3, true));
                    $this$map$iv = $this$map$iv6;
                    c00151 = c00154;
                    $result = $result4;
                    request2 = request2;
                }
                Iterable $this$sortedBy$iv3 = (List) destination$iv$iv;
                List pages3 = CollectionsKt.sortedWith($this$sortedBy$iv3, new Comparator() { // from class: com.cncverse.PlayZTVLiveEventsProvider$getMainPage$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int i;
                        HomePageList list = (HomePageList) t;
                        int i2 = 1;
                        if (StringsKt.contains(list.getName(), "Cricket", true)) {
                            i = 0;
                        } else if (StringsKt.contains(list.getName(), "Football", true)) {
                            i = 1;
                        } else {
                            i = StringsKt.contains(list.getName(), "Basketball", true) ? 2 : 10;
                        }
                        Integer numValueOf = Integer.valueOf(i);
                        HomePageList list2 = (HomePageList) t2;
                        if (StringsKt.contains(list2.getName(), "Cricket", true)) {
                            i2 = 0;
                        } else if (!StringsKt.contains(list2.getName(), "Football", true)) {
                            i2 = StringsKt.contains(list2.getName(), "Basketball", true) ? 2 : 10;
                        }
                        return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(i2));
                    }
                });
                return MainAPIKt.newHomePageResponse(pages3, Boxing.boxBoolean(false));
            case 2:
                page2 = c00151.I$0;
                request2 = (MainPageRequest) c00151.L$0;
                ResultKt.throwOnFailure($result);
                objFetchLiveEvents = $result;
                events = (List) objFetchLiveEvents;
                List $this$groupBy$iv4 = events;
                grouped = new LinkedHashMap();
                while (r13.hasNext()) {
                    PlayZLiveEventData it5 = (PlayZLiveEventData) element$iv$iv;
                    eventInfo = it5.getEventInfo();
                    if (eventInfo != null) {
                    }
                    str = cat;
                    value$iv$iv$iv = grouped.get(str);
                    if (value$iv$iv$iv == null) {
                        Object answer$iv$iv$iv5 = (List) new ArrayList();
                        answer$iv$iv$iv = answer$iv$iv$iv5;
                        grouped.put(str, answer$iv$iv$iv);
                    } else {
                        answer$iv$iv$iv = value$iv$iv$iv;
                    }
                    List list$iv$iv4 = (List) answer$iv$iv$iv;
                    list$iv$iv4.add(element$iv$iv);
                    page2 = page2;
                }
                $this$map$iv = grouped;
                destination$iv$iv = new ArrayList($this$map$iv.size());
                while (r12.hasNext()) {
                    String category4 = (String) item$iv$iv.getKey();
                    List catEvents4 = (List) item$iv$iv.getValue();
                    Map $this$map$iv7 = $this$map$iv;
                    lowerCase = category4.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    switch (lowerCase) {
                        case -1383120329:
                            if (!lowerCase.equals("boxing")) {
                                icon = "📺";
                            } else {
                                icon = "🥊";
                            }
                            break;
                        case -877324069:
                            if (!lowerCase.equals("tennis")) {
                                icon = "📺";
                            } else {
                                icon = "🎾";
                            }
                            break;
                        case -654884904:
                            if (!lowerCase.equals("ice hockey")) {
                                icon = "📺";
                            } else {
                                icon = "🏒";
                            }
                            break;
                        case 394668909:
                            if (!lowerCase.equals("football")) {
                                icon = "📺";
                            } else {
                                icon = "⚽";
                            }
                            break;
                        case 400486431:
                            if (!lowerCase.equals("motorsport")) {
                                icon = "📺";
                            } else {
                                icon = "🏎️";
                            }
                            break;
                        case 727149765:
                            if (!lowerCase.equals("basketball")) {
                                icon = "📺";
                            } else {
                                icon = "🏀";
                            }
                            break;
                        case 1032299505:
                            if (!lowerCase.equals("cricket")) {
                                icon = "📺";
                            } else {
                                icon = "🏏";
                            }
                            break;
                        default:
                            icon = "📺";
                            break;
                    }
                    C00151 c00155 = c00151;
                    final Comparator comparator4 = new Comparator() { // from class: com.cncverse.PlayZTVLiveEventsProvider$getMainPage$lambda$1$$inlined$compareBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Integer num;
                            Integer num2;
                            PlayZLiveEventData event2 = (PlayZLiveEventData) t;
                            String status3 = this.this$0.getEventStatus(event2);
                            if (StringsKt.contains$default(status3, "🔴", false, 2, (Object) null)) {
                                num = (Comparable) 0;
                            } else if (StringsKt.contains$default(status3, "🔜", false, 2, (Object) null)) {
                                num = (Comparable) 1;
                            } else {
                                num = StringsKt.contains$default(status3, "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                            }
                            PlayZLiveEventData event3 = (PlayZLiveEventData) t2;
                            String status4 = this.this$0.getEventStatus(event3);
                            if (StringsKt.contains$default(status4, "🔴", false, 2, (Object) null)) {
                                num2 = (Comparable) 0;
                            } else if (StringsKt.contains$default(status4, "🔜", false, 2, (Object) null)) {
                                num2 = (Comparable) 1;
                            } else {
                                num2 = StringsKt.contains$default(status4, "✅", false, 2, (Object) null) ? (Comparable) 2 : (Comparable) 3;
                            }
                            return ComparisonsKt.compareValues(num, num2);
                        }
                    };
                    Object $result5 = $result;
                    $this$map$iv2 = CollectionsKt.sortedWith(catEvents4, new Comparator() { // from class: com.cncverse.PlayZTVLiveEventsProvider$getMainPage$lambda$1$$inlined$thenBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            Long lValueOf;
                            Long lValueOf2;
                            String startTime;
                            String startTime2;
                            int previousCompare = comparator4.compare(t, t2);
                            if (previousCompare != 0) {
                                return previousCompare;
                            }
                            PlayZLiveEventData event2 = (PlayZLiveEventData) t;
                            try {
                                PlayZLiveEventInfo info = event2.getEventInfo();
                                if (info == null || (startTime2 = info.getStartTime()) == null) {
                                    lValueOf = (Comparable) Long.MAX_VALUE;
                                } else {
                                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                    Date date = fmt.parse(startTime2);
                                    lValueOf = Long.valueOf(date != null ? date.getTime() : Long.MAX_VALUE);
                                }
                            } catch (Exception e) {
                                lValueOf = (Comparable) Long.MAX_VALUE;
                            }
                            PlayZLiveEventData event3 = (PlayZLiveEventData) t2;
                            try {
                                PlayZLiveEventInfo info2 = event3.getEventInfo();
                                if (info2 == null || (startTime = info2.getStartTime()) == null) {
                                    lValueOf2 = (Comparable) Long.MAX_VALUE;
                                } else {
                                    SimpleDateFormat fmt2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                                    Date date2 = fmt2.parse(startTime);
                                    lValueOf2 = Long.valueOf(date2 != null ? date2.getTime() : Long.MAX_VALUE);
                                }
                            } catch (Exception e2) {
                                lValueOf2 = (Comparable) Long.MAX_VALUE;
                            }
                            return ComparisonsKt.compareValues(lValueOf, lValueOf2);
                        }
                    });
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    $this$mapTo$iv$iv = $this$map$iv2;
                    it = $this$mapTo$iv$iv.iterator();
                    while (true) {
                        $this$map$iv3 = $this$map$iv2;
                        if (it.hasNext()) {
                            event = (PlayZLiveEventData) it.next();
                            Iterable $this$mapTo$iv$iv5 = $this$mapTo$iv$iv;
                            displayTitle = createDisplayTitle(event);
                            MainPageRequest request6 = request2;
                            status = getEventStatus(event);
                            if (StringsKt.isBlank(status)) {
                                status2 = status + ' ' + displayTitle;
                            } else {
                                status2 = displayTitle;
                            }
                            String fullTitle4 = status2;
                            if (Intrinsics.areEqual(event.getCat(), "Custom")) {
                                poster = generateMatchCardUrl(event);
                            } else {
                                image = event.getImage();
                                if (image != null) {
                                    z = true;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    poster = event.getImage();
                                } else {
                                    poster = generateMatchCardUrl(event);
                                }
                            }
                            int id4 = event.getId();
                            String slug4 = event.getSlug();
                            formats = event.getFormats();
                            if (formats == null) {
                                formats = CollectionsKt.emptyList();
                            }
                            LiveEventLoadData loadData4 = new LiveEventLoadData(id4, displayTitle, poster, slug4, formats, event.getEventInfo());
                            final String poster5 = poster;
                            destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, fullTitle4, AppUtils.INSTANCE.toJson(loadData4), TvType.Live, false, new Function1() { // from class: com.cncverse.PlayZTVLiveEventsProvider$$ExternalSyntheticLambda5
                                public final Object invoke(Object obj) {
                                    return PlayZTVLiveEventsProvider.getMainPage$lambda$1$2$0(poster5, (LiveSearchResponse) obj);
                                }
                            }, 8, (Object) null));
                            $this$map$iv2 = $this$map$iv3;
                            $this$mapTo$iv$iv = $this$mapTo$iv$iv5;
                            request2 = request6;
                            events = events;
                        }
                    }
                    List items4 = (List) destination$iv$iv2;
                    destination$iv$iv.add(new HomePageList(icon + ' ' + category4, items4, true));
                    $this$map$iv = $this$map$iv7;
                    c00151 = c00155;
                    $result = $result5;
                    request2 = request2;
                }
                Iterable $this$sortedBy$iv4 = (List) destination$iv$iv;
                List pages4 = CollectionsKt.sortedWith($this$sortedBy$iv4, new Comparator() { // from class: com.cncverse.PlayZTVLiveEventsProvider$getMainPage$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        int i;
                        HomePageList list = (HomePageList) t;
                        int i2 = 1;
                        if (StringsKt.contains(list.getName(), "Cricket", true)) {
                            i = 0;
                        } else if (StringsKt.contains(list.getName(), "Football", true)) {
                            i = 1;
                        } else {
                            i = StringsKt.contains(list.getName(), "Basketball", true) ? 2 : 10;
                        }
                        Integer numValueOf = Integer.valueOf(i);
                        HomePageList list2 = (HomePageList) t2;
                        if (StringsKt.contains(list2.getName(), "Cricket", true)) {
                            i2 = 0;
                        } else if (!StringsKt.contains(list2.getName(), "Football", true)) {
                            i2 = StringsKt.contains(list2.getName(), "Basketball", true) ? 2 : 10;
                        }
                        return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(i2));
                    }
                });
                return MainAPIKt.newHomePageResponse(pages4, Boxing.boxBoolean(false));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMainPage$lambda$1$2$0(String $poster, LiveSearchResponse $this$newLiveSearchResponse) {
        $this$newLiveSearchResponse.setPosterUrl($poster);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x009d  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:34:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:38:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:42:0x00de  */
    /* JADX WARN: Code duplicated, block: B:45:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:48:0x0123  */
    /* JADX WARN: Code duplicated, block: B:53:0x0159  */
    /* JADX WARN: Code duplicated, block: B:55:0x0172  */
    /* JADX WARN: Code duplicated, block: B:56:0x018a  */
    /* JADX WARN: Code duplicated, block: B:59:0x0197  */
    /* JADX WARN: Code duplicated, block: B:61:0x019f  */
    /* JADX WARN: Code duplicated, block: B:65:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:67:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:68:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:71:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:77:0x0126 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:80:0x01cd A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:31:0x009d, please report this as an issue */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00191 c00191;
        Object objFetchLiveEvents;
        Object objFetchCustomEvents;
        Iterable events;
        Collection destination$iv$iv;
        Collection destination$iv$iv2;
        PlayZLiveEventData event;
        String displayTitle;
        String status;
        String fullTitle;
        String poster;
        List<PlayZLiveEventFormat> formats;
        String image;
        boolean z;
        String title;
        PlayZLiveEventInfo eventInfo;
        String query2;
        PlayZLiveEventInfo eventInfo2;
        String teamB;
        PlayZLiveEventInfo eventInfo3;
        String eventName;
        String eventType;
        PlayZTVLiveEventsProvider playZTVLiveEventsProvider = this;
        String query3 = query;
        if (continuation instanceof C00191) {
            c00191 = (C00191) continuation;
            if ((c00191.label & Integer.MIN_VALUE) != 0) {
                c00191.label -= Integer.MIN_VALUE;
            } else {
                c00191 = playZTVLiveEventsProvider.new C00191(continuation);
            }
        } else {
            c00191 = playZTVLiveEventsProvider.new C00191(continuation);
        }
        Object $result = c00191.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00191.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return CollectionsKt.emptyList();
                }
                if (playZTVLiveEventsProvider.customCatLink != null) {
                    PlayZTVProviderManager playZTVProviderManager = PlayZTVProviderManager.INSTANCE;
                    String str = playZTVLiveEventsProvider.customCatLink;
                    c00191.L$0 = query3;
                    c00191.label = 1;
                    objFetchCustomEvents = playZTVProviderManager.fetchCustomEvents(str, c00191);
                    if (objFetchCustomEvents == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    events = (List) objFetchCustomEvents;
                    Iterable $this$filter$iv = events;
                    destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        PlayZLiveEventData event2 = (PlayZLiveEventData) element$iv$iv;
                        title = event2.getTitle();
                        eventInfo = event2.getEventInfo();
                        if (eventInfo != null) {
                            query2 = eventInfo.getTeamA();
                        } else {
                            query2 = null;
                        }
                        eventInfo2 = event2.getEventInfo();
                        if (eventInfo2 != null) {
                            teamB = eventInfo2.getTeamB();
                        } else {
                            teamB = null;
                        }
                        eventInfo3 = event2.getEventInfo();
                        if (eventInfo3 != null) {
                            eventName = eventInfo3.getEventName();
                        } else {
                            eventName = null;
                        }
                        PlayZLiveEventInfo eventInfo4 = event2.getEventInfo();
                        eventType = eventInfo4 != null ? eventInfo4.getEventType() : null;
                        Object $result2 = $result;
                        if (StringsKt.contains(CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{title, query2, teamB, eventName, eventType}), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), query3, true)) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        query3 = query3;
                        c00191 = c00191;
                        $result = $result2;
                    }
                    Iterable $this$map$iv = (List) destination$iv$iv;
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        event = (PlayZLiveEventData) item$iv$iv;
                        displayTitle = playZTVLiveEventsProvider.createDisplayTitle(event);
                        status = playZTVLiveEventsProvider.getEventStatus(event);
                        if (StringsKt.isBlank(status)) {
                            fullTitle = displayTitle;
                        } else {
                            fullTitle = status + ' ' + displayTitle;
                        }
                        if (Intrinsics.areEqual(event.getCat(), "Custom")) {
                            image = event.getImage();
                            if (image != null || StringsKt.isBlank(image)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                poster = event.getImage();
                            } else {
                                poster = playZTVLiveEventsProvider.generateMatchCardUrl(event);
                            }
                        } else {
                            poster = playZTVLiveEventsProvider.generateMatchCardUrl(event);
                        }
                        int id = event.getId();
                        String slug = event.getSlug();
                        formats = event.getFormats();
                        if (formats == null) {
                            formats = CollectionsKt.emptyList();
                        }
                        LiveEventLoadData loadData = new LiveEventLoadData(id, displayTitle, poster, slug, formats, event.getEventInfo());
                        final String poster2 = poster;
                        destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(playZTVLiveEventsProvider, fullTitle, AppUtils.INSTANCE.toJson(loadData), TvType.Live, false, new Function1() { // from class: com.cncverse.PlayZTVLiveEventsProvider$$ExternalSyntheticLambda10
                            public final Object invoke(Object obj) {
                                return PlayZTVLiveEventsProvider.search$lambda$1$0(poster2, (LiveSearchResponse) obj);
                            }
                        }, 8, (Object) null));
                        playZTVLiveEventsProvider = this;
                    }
                    return (List) destination$iv$iv2;
                }
                PlayZTVProviderManager playZTVProviderManager2 = PlayZTVProviderManager.INSTANCE;
                c00191.L$0 = query3;
                c00191.label = 2;
                objFetchLiveEvents = playZTVProviderManager2.fetchLiveEvents(c00191);
                if (objFetchLiveEvents == coroutine_suspended) {
                    return coroutine_suspended;
                }
                events = (List) objFetchLiveEvents;
                Iterable $this$filter$iv2 = events;
                destination$iv$iv = new ArrayList();
                while (r12.hasNext()) {
                    PlayZLiveEventData event3 = (PlayZLiveEventData) element$iv$iv;
                    title = event3.getTitle();
                    eventInfo = event3.getEventInfo();
                    if (eventInfo != null) {
                        query2 = eventInfo.getTeamA();
                    } else {
                        query2 = null;
                    }
                    eventInfo2 = event3.getEventInfo();
                    if (eventInfo2 != null) {
                        teamB = eventInfo2.getTeamB();
                    } else {
                        teamB = null;
                    }
                    eventInfo3 = event3.getEventInfo();
                    if (eventInfo3 != null) {
                        eventName = eventInfo3.getEventName();
                    } else {
                        eventName = null;
                    }
                    PlayZLiveEventInfo eventInfo5 = event3.getEventInfo();
                    if (eventInfo5 != null) {
                    }
                    Object $result3 = $result;
                    if (StringsKt.contains(CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{title, query2, teamB, eventName, eventType}), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), query3, true)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    query3 = query3;
                    c00191 = c00191;
                    $result = $result3;
                }
                Iterable $this$map$iv2 = (List) destination$iv$iv;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                while (r8.hasNext()) {
                    event = (PlayZLiveEventData) item$iv$iv;
                    displayTitle = playZTVLiveEventsProvider.createDisplayTitle(event);
                    status = playZTVLiveEventsProvider.getEventStatus(event);
                    if (StringsKt.isBlank(status)) {
                        fullTitle = status + ' ' + displayTitle;
                    } else {
                        fullTitle = displayTitle;
                    }
                    if (Intrinsics.areEqual(event.getCat(), "Custom")) {
                        poster = playZTVLiveEventsProvider.generateMatchCardUrl(event);
                    } else {
                        image = event.getImage();
                        if (image != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            poster = event.getImage();
                        } else {
                            poster = playZTVLiveEventsProvider.generateMatchCardUrl(event);
                        }
                    }
                    int id2 = event.getId();
                    String slug2 = event.getSlug();
                    formats = event.getFormats();
                    if (formats == null) {
                        formats = CollectionsKt.emptyList();
                    }
                    LiveEventLoadData loadData2 = new LiveEventLoadData(id2, displayTitle, poster, slug2, formats, event.getEventInfo());
                    final String poster3 = poster;
                    destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(playZTVLiveEventsProvider, fullTitle, AppUtils.INSTANCE.toJson(loadData2), TvType.Live, false, new Function1() { // from class: com.cncverse.PlayZTVLiveEventsProvider$$ExternalSyntheticLambda10
                        public final Object invoke(Object obj) {
                            return PlayZTVLiveEventsProvider.search$lambda$1$0(poster3, (LiveSearchResponse) obj);
                        }
                    }, 8, (Object) null));
                    playZTVLiveEventsProvider = this;
                }
                return (List) destination$iv$iv2;
            case 1:
                query3 = (String) c00191.L$0;
                ResultKt.throwOnFailure($result);
                objFetchCustomEvents = $result;
                events = (List) objFetchCustomEvents;
                Iterable $this$filter$iv3 = events;
                destination$iv$iv = new ArrayList();
                while (r12.hasNext()) {
                    PlayZLiveEventData event4 = (PlayZLiveEventData) element$iv$iv;
                    title = event4.getTitle();
                    eventInfo = event4.getEventInfo();
                    if (eventInfo != null) {
                        query2 = eventInfo.getTeamA();
                    } else {
                        query2 = null;
                    }
                    eventInfo2 = event4.getEventInfo();
                    if (eventInfo2 != null) {
                        teamB = eventInfo2.getTeamB();
                    } else {
                        teamB = null;
                    }
                    eventInfo3 = event4.getEventInfo();
                    if (eventInfo3 != null) {
                        eventName = eventInfo3.getEventName();
                    } else {
                        eventName = null;
                    }
                    PlayZLiveEventInfo eventInfo6 = event4.getEventInfo();
                    if (eventInfo6 != null) {
                    }
                    Object $result4 = $result;
                    if (StringsKt.contains(CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{title, query2, teamB, eventName, eventType}), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), query3, true)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    query3 = query3;
                    c00191 = c00191;
                    $result = $result4;
                }
                Iterable $this$map$iv3 = (List) destination$iv$iv;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                while (r8.hasNext()) {
                    event = (PlayZLiveEventData) item$iv$iv;
                    displayTitle = playZTVLiveEventsProvider.createDisplayTitle(event);
                    status = playZTVLiveEventsProvider.getEventStatus(event);
                    if (StringsKt.isBlank(status)) {
                        fullTitle = status + ' ' + displayTitle;
                    } else {
                        fullTitle = displayTitle;
                    }
                    if (Intrinsics.areEqual(event.getCat(), "Custom")) {
                        poster = playZTVLiveEventsProvider.generateMatchCardUrl(event);
                    } else {
                        image = event.getImage();
                        if (image != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            poster = event.getImage();
                        } else {
                            poster = playZTVLiveEventsProvider.generateMatchCardUrl(event);
                        }
                    }
                    int id3 = event.getId();
                    String slug3 = event.getSlug();
                    formats = event.getFormats();
                    if (formats == null) {
                        formats = CollectionsKt.emptyList();
                    }
                    LiveEventLoadData loadData3 = new LiveEventLoadData(id3, displayTitle, poster, slug3, formats, event.getEventInfo());
                    final String poster4 = poster;
                    destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(playZTVLiveEventsProvider, fullTitle, AppUtils.INSTANCE.toJson(loadData3), TvType.Live, false, new Function1() { // from class: com.cncverse.PlayZTVLiveEventsProvider$$ExternalSyntheticLambda10
                        public final Object invoke(Object obj) {
                            return PlayZTVLiveEventsProvider.search$lambda$1$0(poster4, (LiveSearchResponse) obj);
                        }
                    }, 8, (Object) null));
                    playZTVLiveEventsProvider = this;
                }
                return (List) destination$iv$iv2;
            case 2:
                query3 = (String) c00191.L$0;
                ResultKt.throwOnFailure($result);
                objFetchLiveEvents = $result;
                events = (List) objFetchLiveEvents;
                Iterable $this$filter$iv4 = events;
                destination$iv$iv = new ArrayList();
                while (r12.hasNext()) {
                    PlayZLiveEventData event5 = (PlayZLiveEventData) element$iv$iv;
                    title = event5.getTitle();
                    eventInfo = event5.getEventInfo();
                    if (eventInfo != null) {
                        query2 = eventInfo.getTeamA();
                    } else {
                        query2 = null;
                    }
                    eventInfo2 = event5.getEventInfo();
                    if (eventInfo2 != null) {
                        teamB = eventInfo2.getTeamB();
                    } else {
                        teamB = null;
                    }
                    eventInfo3 = event5.getEventInfo();
                    if (eventInfo3 != null) {
                        eventName = eventInfo3.getEventName();
                    } else {
                        eventName = null;
                    }
                    PlayZLiveEventInfo eventInfo7 = event5.getEventInfo();
                    if (eventInfo7 != null) {
                    }
                    Object $result5 = $result;
                    if (StringsKt.contains(CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{title, query2, teamB, eventName, eventType}), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), query3, true)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    query3 = query3;
                    c00191 = c00191;
                    $result = $result5;
                }
                Iterable $this$map$iv4 = (List) destination$iv$iv;
                destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                while (r8.hasNext()) {
                    event = (PlayZLiveEventData) item$iv$iv;
                    displayTitle = playZTVLiveEventsProvider.createDisplayTitle(event);
                    status = playZTVLiveEventsProvider.getEventStatus(event);
                    if (StringsKt.isBlank(status)) {
                        fullTitle = status + ' ' + displayTitle;
                    } else {
                        fullTitle = displayTitle;
                    }
                    if (Intrinsics.areEqual(event.getCat(), "Custom")) {
                        poster = playZTVLiveEventsProvider.generateMatchCardUrl(event);
                    } else {
                        image = event.getImage();
                        if (image != null) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            poster = event.getImage();
                        } else {
                            poster = playZTVLiveEventsProvider.generateMatchCardUrl(event);
                        }
                    }
                    int id4 = event.getId();
                    String slug4 = event.getSlug();
                    formats = event.getFormats();
                    if (formats == null) {
                        formats = CollectionsKt.emptyList();
                    }
                    LiveEventLoadData loadData4 = new LiveEventLoadData(id4, displayTitle, poster, slug4, formats, event.getEventInfo());
                    final String poster5 = poster;
                    destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(playZTVLiveEventsProvider, fullTitle, AppUtils.INSTANCE.toJson(loadData4), TvType.Live, false, new Function1() { // from class: com.cncverse.PlayZTVLiveEventsProvider$$ExternalSyntheticLambda10
                        public final Object invoke(Object obj) {
                            return PlayZTVLiveEventsProvider.search$lambda$1$0(poster5, (LiveSearchResponse) obj);
                        }
                    }, 8, (Object) null));
                    playZTVLiveEventsProvider = this;
                }
                return (List) destination$iv$iv2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit search$lambda$1$0(String $poster, LiveSearchResponse $this$newLiveSearchResponse) {
        $this$newLiveSearchResponse.setPosterUrl($poster);
        return Unit.INSTANCE;
    }

    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        Object obj;
        Object objDecodeFromString;
        AppUtils appUtils = AppUtils.INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            KType kTypeTypeOf = Reflection.typeOf(LiveEventLoadData.class);
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            try {
                Result.Companion companion3 = Result.Companion;
                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(LiveEventLoadData.class), (List) null, 2, (Object) null));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th2));
            }
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        DeserializationStrategy deserializationStrategy = (KSerializer) obj;
        if (deserializationStrategy != null) {
            try {
                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, url);
            } catch (SerializationException e) {
                ArchComponentExtKt.logError(e);
                ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv.readValue(url, new TypeReference<LiveEventLoadData>() { // from class: com.cncverse.PlayZTVLiveEventsProvider$load$$inlined$parseJson$1
                });
            } catch (Throwable th3) {
                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv2.readValue(url, new TypeReference<LiveEventLoadData>() { // from class: com.cncverse.PlayZTVLiveEventsProvider$load$$inlined$parseJson$1
                });
            }
        } else {
            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
            objDecodeFromString = $this$readValue$iv$iv3.readValue(url, new TypeReference<LiveEventLoadData>() { // from class: com.cncverse.PlayZTVLiveEventsProvider$load$$inlined$parseJson$1
            });
        }
        LiveEventLoadData data = (LiveEventLoadData) objDecodeFromString;
        PlayZLiveEventInfo info = data.getEventInfo();
        StringBuilder $this$load_u24lambda_u240 = new StringBuilder();
        if (info != null) {
            String it = info.getEventType();
            if (it != null) {
                $this$load_u24lambda_u240.append("📌 " + it + '\n');
            }
            String it2 = info.getEventName();
            if (it2 != null) {
                $this$load_u24lambda_u240.append("🏆 " + it2 + '\n');
            }
            String it3 = info.getStartTime();
            if (it3 != null) {
                try {
                    SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z", Locale.US);
                    SimpleDateFormat disp = new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.US);
                    Date d = df.parse(it3);
                    if (d != null) {
                        $this$load_u24lambda_u240.append("🕐 " + disp.format(d) + '\n');
                    }
                } catch (Exception e2) {
                    $this$load_u24lambda_u240.append("🕐 " + it3 + '\n');
                }
            }
        }
        $this$load_u24lambda_u240.append("\n📡 Available Servers: " + data.getFormats().size());
        String plot = $this$load_u24lambda_u240.toString();
        return MainAPIKt.newLiveStreamLoadResponse(this, data.getTitle(), url, url, new C00172(data, plot, null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.PlayZTVLiveEventsProvider$load$2 */
    /* JADX INFO: compiled from: PlayZTVLiveEventsProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/LiveStreamLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.PlayZTVLiveEventsProvider$load$2", f = "PlayZTVLiveEventsProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00172 extends SuspendLambda implements Function2<LiveStreamLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ LiveEventLoadData $data;
        final /* synthetic */ String $plot;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00172(LiveEventLoadData liveEventLoadData, String str, Continuation<? super C00172> continuation) {
            super(2, continuation);
            this.$data = liveEventLoadData;
            this.$plot = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00172 = new C00172(this.$data, this.$plot, continuation);
            c00172.L$0 = obj;
            return c00172;
        }

        public final Object invoke(LiveStreamLoadResponse liveStreamLoadResponse, Continuation<? super Unit> continuation) {
            return create(liveStreamLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            LiveStreamLoadResponse $this$newLiveStreamLoadResponse = (LiveStreamLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newLiveStreamLoadResponse.setPosterUrl(this.$data.getPoster());
                    $this$newLiveStreamLoadResponse.setPlot(this.$plot);
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
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.PlayZTVLiveEventsProvider$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    PlayZTVLiveEventsProvider.showSubscriptionPopupIfNeeded$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.PlayZTVLiveEventsProvider$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlayZTVLiveEventsProvider.showSubscriptionPopupIfNeeded$lambda$0$11($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249, $ctx, dialog, view);
                }
            });
            subscribeTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.PlayZTVLiveEventsProvider$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlayZTVLiveEventsProvider.showSubscriptionPopupIfNeeded$lambda$0$12(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.PlayZTVLiveEventsProvider$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                PlayZTVLiveEventsProvider.showTelegramPopup$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.PlayZTVLiveEventsProvider$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            joinTv.setOnClickListener(new View.OnClickListener() { // from class: com.cncverse.PlayZTVLiveEventsProvider$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlayZTVLiveEventsProvider.showTelegramPopup$lambda$0$9(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.cncverse.PlayZTVLiveEventsProvider$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                PlayZTVLiveEventsProvider.openInExternalBrowser$lambda$0(ctx, url);
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

    /* JADX WARN: Code duplicated, block: B:130:0x0492  */
    /* JADX WARN: Code duplicated, block: B:132:0x04a1  */
    /* JADX WARN: Code duplicated, block: B:135:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:136:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:150:0x0526  */
    /* JADX WARN: Code duplicated, block: B:153:0x052a A[Catch: Exception -> 0x07bd, TRY_ENTER, TryCatch #24 {Exception -> 0x07bd, blocks: (B:144:0x04ec, B:153:0x052a, B:155:0x0531), top: B:311:0x04ec }] */
    /* JADX WARN: Code duplicated, block: B:187:0x075f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:188:0x0760  */
    /* JADX WARN: Code duplicated, block: B:197:0x07e0  */
    /* JADX WARN: Code duplicated, block: B:207:0x0810  */
    /* JADX WARN: Code duplicated, block: B:208:0x0812 A[Catch: Exception -> 0x08d4, TryCatch #17 {Exception -> 0x08d4, blocks: (B:205:0x080a, B:226:0x0913, B:208:0x0812, B:210:0x081d, B:211:0x0820), top: B:302:0x080a }] */
    /* JADX WARN: Code duplicated, block: B:210:0x081d A[Catch: Exception -> 0x08d4, TryCatch #17 {Exception -> 0x08d4, blocks: (B:205:0x080a, B:226:0x0913, B:208:0x0812, B:210:0x081d, B:211:0x0820), top: B:302:0x080a }] */
    /* JADX WARN: Code duplicated, block: B:213:0x089a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:214:0x089b  */
    /* JADX WARN: Code duplicated, block: B:223:0x0902  */
    /* JADX WARN: Code duplicated, block: B:226:0x0913 A[Catch: Exception -> 0x08d4, TRY_ENTER, TRY_LEAVE, TryCatch #17 {Exception -> 0x08d4, blocks: (B:205:0x080a, B:226:0x0913, B:208:0x0812, B:210:0x081d, B:211:0x0820), top: B:302:0x080a }] */
    /* JADX WARN: Code duplicated, block: B:235:0x098e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:236:0x098f  */
    /* JADX WARN: Code duplicated, block: B:263:0x0ab1  */
    /* JADX WARN: Code duplicated, block: B:280:0x07fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:286:0x04d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:300:0x04f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:311:0x04ec A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0196: MOVE (r29 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY] A[D('streamLink' java.lang.String)]), block:B:24:0x0194 */
    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0198: MOVE (r1 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY] A[D('element$iv' java.lang.Object)]), block:B:24:0x0194 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:171:0x0606 -> B:262:0x0aa3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:190:0x0781 -> B:262:0x0aa3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:214:0x089b -> B:319:0x08b1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:238:0x09a9 -> B:262:0x0aa3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:261:0x0a8e -> B:262:0x0aa3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r37, boolean r38, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r39, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r40, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r41) {
        /*
            Method dump skipped, instruction units count: 2788
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cncverse.PlayZTVLiveEventsProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadLinks$lambda$0$0(Context $_ctx) {
        Toast.makeText($_ctx, "⚠️(Opening ads) Subscription expired. If you have renewed your subscription, please re-verify it in Subscription Manager.", 1).show();
    }

    private final Pair<String, Map<String, String>> parseStreamLink(String link) {
        String headerName;
        Map headers = new LinkedHashMap();
        int i = 0;
        int i2 = 2;
        if (!StringsKt.contains$default(link, "|", false, 2, (Object) null)) {
            return new Pair<>(link, headers);
        }
        List parts = StringsKt.split$default(link, new String[]{"|"}, false, 2, 2, (Object) null);
        String url = (String) parts.get(0);
        int i3 = 1;
        if (parts.size() > 1) {
            String headerPart = (String) parts.get(1);
            Iterable $this$forEach$iv = StringsKt.split$default(headerPart, new String[]{"&"}, false, 0, 6, (Object) null);
            for (Object element$iv : $this$forEach$iv) {
                String headerPair = (String) element$iv;
                List keyValue = StringsKt.split$default(headerPair, new String[]{"="}, false, 2, 2, (Object) null);
                if (keyValue.size() == i2) {
                    String key = StringsKt.trim((String) keyValue.get(i)).toString();
                    String value = StringsKt.trim((String) keyValue.get(i3)).toString();
                    String lowerCase = key.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    switch (lowerCase) {
                        case "cookie":
                            headerName = "Cookie";
                            break;
                        case "origin":
                            headerName = "Origin";
                            break;
                        case "user-agent":
                            headerName = "User-Agent";
                            break;
                        case "referer":
                            headerName = "Referer";
                            break;
                        default:
                            headerName = key;
                            break;
                    }
                    headers.put(headerName, value);
                }
                i3 = 1;
                i = 0;
                i2 = 2;
            }
        }
        return new Pair<>(url, headers);
    }

    private final String hexToBase64(String hex) {
        Iterable $this$map$iv = StringsKt.chunked(StringsKt.replace$default(hex, "-", "", false, 4, (Object) null), 2);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(Byte.valueOf((byte) Integer.parseInt(it, CharsKt.checkRadix(16))));
        }
        byte[] bytes = CollectionsKt.toByteArray((List) destination$iv$iv);
        return Base64.encodeToString(bytes, 11);
    }
}
