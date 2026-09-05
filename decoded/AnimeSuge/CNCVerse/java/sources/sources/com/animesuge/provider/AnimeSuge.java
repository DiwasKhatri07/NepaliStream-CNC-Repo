package com.animesuge.provider;

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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.AnimeLoadResponse;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.DubStatus;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageData;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.ui.settings.Globals;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
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
import kotlin.reflect.KType;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: AnimeSuge.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AnimeSuge/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 E2\u00020\u0001:\u0004EFGHB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H\u0002J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0002J\u001e\u0010\u001c\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0096@¢\u0006\u0002\u0010.J\u000e\u0010/\u001a\u0004\u0018\u000100*\u000201H\u0002J\u001c\u00102\u001a\b\u0012\u0004\u0012\u0002000\u001a2\u0006\u00103\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00104J\u0018\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00104JF\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u000e2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>0<2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020>0<H\u0096@¢\u0006\u0002\u0010AJ\b\u0010B\u001a\u00020>H\u0002J\b\u0010C\u001a\u00020>H\u0002J\u0010\u0010D\u001a\u00020>2\u0006\u00107\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lcom/animesuge/provider/AnimeSuge;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "rc4", "", "key", "input", "shiftCharcode", "t", "rot13", "s", "generateVrf", "ajaxHeaders", "", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "Lorg/jsoup/nodes/Element;", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showSubscriptionPopupIfNeeded", "showTelegramPopup", "openInExternalBrowser", "Companion", "AjaxResponse", "ServerInfoResponse", "ServerInfoResult", "AnimeSuge_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnimeSuge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimeSuge.kt\ncom/animesuge/provider/AnimeSuge\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,574:1\n990#2:575\n1065#2,3:576\n1642#3,10:579\n1915#3:589\n1916#3:591\n1652#3:592\n1696#3,8:593\n1642#3,10:602\n1915#3:612\n1916#3:614\n1652#3:615\n1696#3,8:616\n1586#3:624\n1661#3,3:625\n1915#3:647\n1916#3:649\n1915#3:669\n1915#3:670\n1916#3:672\n1916#3:673\n1915#3:674\n1916#3:695\n1#4:590\n1#4:601\n1#4:613\n1#4:629\n1#4:648\n1#4:651\n1#4:671\n1#4:676\n1#4:694\n63#5:628\n64#5,15:630\n63#5:650\n64#5,15:652\n63#5:675\n64#5,15:677\n50#6:645\n43#6:646\n50#6:667\n43#6:668\n50#6:692\n43#6:693\n*S KotlinDebug\n*F\n+ 1 AnimeSuge.kt\ncom/animesuge/provider/AnimeSuge\n*L\n103#1:575\n103#1:576,3\n135#1:579,10\n135#1:589\n135#1:591\n135#1:592\n136#1:593,8\n157#1:602,10\n157#1:612\n157#1:614\n157#1:615\n157#1:616,8\n184#1:624\n184#1:625,3\n199#1:647\n199#1:649\n279#1:669\n287#1:670\n287#1:672\n279#1:673\n299#1:674\n299#1:695\n135#1:590\n157#1:613\n192#1:629\n273#1:651\n308#1:676\n192#1:628\n192#1:630,15\n273#1:650\n273#1:652,15\n308#1:675\n308#1:677,15\n192#1:645\n192#1:646\n273#1:667\n273#1:668\n308#1:692\n308#1:693\n*E\n"})
public final class AnimeSuge extends MainAPI {
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
    private String mainUrl = "https://animesuge.cz";

    @NotNull
    private String name = "AnimeSuge";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "en";

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Anime, TvType.AnimeMovie, TvType.OVA});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to(getMainUrl() + "/latest-updated", "Recently Updated"), TuplesKt.to(getMainUrl() + "/new-release", "New Releases"), TuplesKt.to(getMainUrl() + "/most-viewed", "Popular Anime"), TuplesKt.to(getMainUrl() + "/status/finished-airing", "Completed"), TuplesKt.to(getMainUrl() + "/status/currently-airing", "Ongoing")});

    @NotNull
    private final Map<String, String> ajaxHeaders = MapsKt.mapOf(new Pair[]{TuplesKt.to("X-Requested-With", "XMLHttpRequest"), TuplesKt.to("Referer", getMainUrl() + '/')});

    /* JADX INFO: renamed from: com.animesuge.provider.AnimeSuge$getMainPage$1 */
    /* JADX INFO: compiled from: AnimeSuge.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.animesuge.provider.AnimeSuge", f = "AnimeSuge.kt", i = {0, 0, 0}, l = {134}, m = "getMainPage", n = {"request", "url", "page"}, nl = {135}, s = {"L$0", "L$1", "I$0"}, v = 2)
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
            return AnimeSuge.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.animesuge.provider.AnimeSuge$load$1 */
    /* JADX INFO: compiled from: AnimeSuge.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.animesuge.provider.AnimeSuge", f = "AnimeSuge.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {164, 188, 215}, m = "load", n = {"url", "animeUrl", "url", "animeUrl", "doc", "dataId", "title", "poster", "plot", "genres", "vrf", "url", "animeUrl", "doc", "dataId", "title", "poster", "plot", "genres", "vrf", "epsText", "epsJson", "epsHtml", "epsSoup", "subEpisodes", "dubEpisodes"}, nl = {167, 191, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14"}, v = 2)
    static final class C00011 extends ContinuationImpl {
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
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnimeSuge.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.animesuge.provider.AnimeSuge$loadLinks$1 */
    /* JADX INFO: compiled from: AnimeSuge.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.animesuge.provider.AnimeSuge", f = "AnimeSuge.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {266, 301, 312}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "parts", "animeUrl", "dataIds", "selectedType", "isCasting", "data", "subtitleCallback", "callback", "parts", "animeUrl", "dataIds", "selectedType", "serverListText", "serverListJson", "serverListHtml", "serverListSoup", "serversToLoad", "found", "$this$forEach$iv", "element$iv", "serverName", "linkId", "isCasting", "$i$f$forEach", "$i$a$-forEach-AnimeSuge$loadLinks$4", "data", "subtitleCallback", "callback", "parts", "animeUrl", "dataIds", "selectedType", "serverListText", "serverListJson", "serverListHtml", "serverListSoup", "serversToLoad", "found", "$this$forEach$iv", "element$iv", "serverName", "linkId", "serverInfoJson", "serverInfoText", "playerUrl", "isCasting", "$i$f$forEach", "$i$a$-forEach-AnimeSuge$loadLinks$4"}, nl = {272, 307, 313}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$15", "L$16", "L$17", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "Z$0", "I$0", "I$1"}, v = 2)
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
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$20;
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

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnimeSuge.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.animesuge.provider.AnimeSuge$search$1 */
    /* JADX INFO: compiled from: AnimeSuge.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.animesuge.provider.AnimeSuge", f = "AnimeSuge.kt", i = {0, 0}, l = {156}, m = "search", n = {"query", "encoded"}, nl = {157}, s = {"L$0", "L$1"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnimeSuge.this.search(null, (Continuation) this);
        }
    }

    /* JADX INFO: compiled from: AnimeSuge.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/animesuge/provider/AnimeSuge$Companion;", "", "<init>", "()V", "isCsGuardActive", "", "csGuardWasEverActive", "isCsGuardBlocked", "showCsGuardToast", "", "ctx", "Landroid/content/Context;", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "OMG10", "", "lastBrowserOpenMs", "", "telegramPopupShown", "subscriptionPopupShown", "BROWSER_DEBOUNCE_MS", "AnimeSuge_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAnimeSuge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnimeSuge.kt\ncom/animesuge/provider/AnimeSuge$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,574:1\n1#2:575\n*E\n"})
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
                AnimeSuge.csGuardWasEverActive = true;
            }
            return AnimeSuge.csGuardWasEverActive;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showCsGuardToast(final Context ctx) {
            if (ctx == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.animesuge.provider.AnimeSuge$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AnimeSuge.Companion.showCsGuardToast$lambda$0(ctx);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showCsGuardToast$lambda$0(Context $c) {
            Toast.makeText($c, "🚫 CSGuard detected — Restart CloudStream after removing CSGuard to use CNCRepo", 1).show();
        }

        @Nullable
        public final Context getContext() {
            return AnimeSuge.context;
        }

        public final void setContext(@Nullable Context context) {
            AnimeSuge.context = context;
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

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    private final byte[] rc4(byte[] key, byte[] input) {
        int[] s = new int[256];
        for (int i = 0; i < 256; i++) {
            s[i] = i;
        }
        int j = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            j = (s[i2] + j + (key[i2 % key.length] & 255)) & 255;
            int tmp = s[i2];
            s[i2] = s[j];
            s[j] = tmp;
        }
        int i3 = 0;
        int j2 = 0;
        byte[] out = new byte[input.length];
        int length = input.length;
        for (int x = 0; x < length; x++) {
            i3 = (i3 + 1) & 255;
            j2 = (s[i3] + j2) & 255;
            int tmp2 = s[i3];
            s[i3] = s[j2];
            s[j2] = tmp2;
            out[x] = (byte) ((input[x] & 255) ^ s[(s[i3] + s[j2]) & 255]);
        }
        return out;
    }

    private final byte[] shiftCharcode(String t) {
        byte[] result = new byte[t.length()];
        int length = t.length();
        for (int r = 0; r < length; r++) {
            int s = t.charAt(r);
            switch (r % 8) {
                case 0:
                    s -= 3;
                    break;
                case 1:
                    s += 3;
                    break;
                case 2:
                    s -= 4;
                    break;
                case 3:
                    s += 2;
                    break;
                case 4:
                    s -= 2;
                    break;
                case 5:
                case 7:
                    s += 5;
                    break;
                case 6:
                    s += 4;
                    break;
            }
            result[r] = (byte) s;
        }
        return result;
    }

    private final String rot13(String s) {
        char c;
        String $this$map$iv = s;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length());
        for (int i = 0; i < $this$map$iv.length(); i++) {
            char item$iv$iv = $this$map$iv.charAt(i);
            if ('a' <= item$iv$iv && item$iv$iv < '{') {
                c = (char) ((((item$iv$iv - 'a') + 13) % 26) + 97);
            } else if ('A' <= item$iv$iv && item$iv$iv < '[') {
                c = (char) ((((item$iv$iv - 'A') + 13) % 26) + 65);
            } else {
                c = item$iv$iv;
            }
            destination$iv$iv.add(Character.valueOf(c));
        }
        return CollectionsKt.joinToString$default((List) destination$iv$iv, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    private final String generateVrf(String input) {
        String encoded = StringsKt.replace$default(URLEncoder.encode(input, "UTF-8"), "+", "%20", false, 4, (Object) null);
        byte[] key = "ysJhV6U27FVIjjuk".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(key, "getBytes(...)");
        byte[] bytes = encoded.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] rc4Bytes = rc4(key, bytes);
        String b64 = Base64.encodeToString(rc4Bytes, 10);
        byte[] shifted = shiftCharcode(b64);
        String b64Shifted = Base64.encodeToString(shifted, 10);
        return rot13(b64Shifted);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        boolean z;
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
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return MainAPIKt.newHomePageResponse$default(CollectionsKt.emptyList(), (Boolean) null, 2, (Object) null);
                }
                showTelegramPopup();
                showSubscriptionPopupIfNeeded();
                String url = request.getData() + (page > 1 ? "?page=" + page : "");
                Requests app = MainActivityKt.getApp();
                c00001.L$0 = request;
                c00001.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00001.I$0 = page;
                c00001.label = 1;
                z = true;
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
                z = true;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document doc = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = doc.select("div.item");
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
        Iterable items = (List) destination$iv$iv;
        String name = request2.getName();
        Iterable $this$distinctBy$iv = items;
        HashSet set$iv = new HashSet();
        ArrayList list$iv = new ArrayList();
        for (Object e$iv : $this$distinctBy$iv) {
            SearchResponse it2 = (SearchResponse) e$iv;
            if (set$iv.add(it2.getUrl())) {
                list$iv.add(e$iv);
            }
        }
        return MainAPIKt.newHomePageResponse(name, list$iv, Boxing.boxBoolean(z));
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        String title;
        Element anchor = $this$toSearchResult.selectFirst("a.poster");
        final String poster = null;
        if (anchor == null && (anchor = $this$toSearchResult.selectFirst("a")) == null) {
            return null;
        }
        String rawHref = anchor.attr("href");
        if (StringsKt.isBlank(rawHref)) {
            rawHref = null;
        }
        if (rawHref == null) {
            return null;
        }
        String href = MainAPIKt.fixUrl(this, new Regex("/ep-\\d+$").replace(rawHref, ""));
        Element it = $this$toSearchResult.selectFirst(".name a, .name, img");
        if (it != null) {
            String strAttr = Intrinsics.areEqual(it.tagName(), "img") ? it.attr("alt") : it.text();
            if (strAttr != null && (title = StringsKt.trim(strAttr).toString()) != null) {
                Element it2 = $this$toSearchResult.selectFirst("img.lazyload, img");
                if (it2 != null) {
                    String it3 = it2.attr("data-src");
                    if (StringsKt.isBlank(it3)) {
                        it3 = null;
                    }
                    if (it3 == null) {
                        it3 = it2.attr("src");
                    }
                    if (it3 != null) {
                        poster = StringsKt.startsWith$default(it3, "http", false, 2, (Object) null) ? it3 : getMainUrl() + '/' + it3;
                    }
                }
                return MainAPIKt.newAnimeSearchResponse$default(this, title, href, (TvType) null, false, new Function1() { // from class: com.animesuge.provider.AnimeSuge$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj) {
                        return AnimeSuge.toSearchResult$lambda$4(poster, (AnimeSearchResponse) obj);
                    }
                }, 12, (Object) null);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toSearchResult$lambda$4(String $poster, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl($poster);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws UnsupportedEncodingException {
        C00041 c00041;
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
        Object $result = c00041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00041.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return CollectionsKt.emptyList();
                }
                String encoded = URLEncoder.encode(query, "UTF-8");
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/filter?keyword=" + encoded;
                c00041.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00041.L$1 = SpillingKt.nullOutSpilledVariable(encoded);
                c00041.label = 1;
                $result = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00041, 4094, (Object) null);
                if ($result == coroutine_suspended) {
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
        Iterable $this$mapNotNull$iv = ((NiceResponse) $result).getDocument().select("div.item");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        Iterable $this$distinctBy$iv = (List) destination$iv$iv;
        HashSet set$iv = new HashSet();
        ArrayList list$iv = new ArrayList();
        for (Object e$iv : $this$distinctBy$iv) {
            SearchResponse it2 = (SearchResponse) e$iv;
            if (set$iv.add(it2.getUrl())) {
                list$iv.add(e$iv);
            }
        }
        return list$iv;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x037b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:103:0x037e  */
    /* JADX WARN: Code duplicated, block: B:106:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:108:0x03b9  */
    /* JADX WARN: Code duplicated, block: B:109:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:111:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:112:0x03d7  */
    /* JADX WARN: Code duplicated, block: B:116:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:118:0x03f3  */
    /* JADX WARN: Code duplicated, block: B:119:0x0409  */
    /* JADX WARN: Code duplicated, block: B:123:0x0420  */
    /* JADX WARN: Code duplicated, block: B:125:0x0423  */
    /* JADX WARN: Code duplicated, block: B:126:0x0429  */
    /* JADX WARN: Code duplicated, block: B:128:0x0447  */
    /* JADX WARN: Code duplicated, block: B:129:0x0489  */
    /* JADX WARN: Code duplicated, block: B:131:0x048f  */
    /* JADX WARN: Code duplicated, block: B:136:0x0563 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:137:0x0564  */
    /* JADX WARN: Code duplicated, block: B:145:0x030b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:147:0x0349 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:152:0x04cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x013c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0151  */
    /* JADX WARN: Code duplicated, block: B:37:0x0180  */
    /* JADX WARN: Code duplicated, block: B:39:0x0189  */
    /* JADX WARN: Code duplicated, block: B:44:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:47:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:48:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:56:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:58:0x01de  */
    /* JADX WARN: Code duplicated, block: B:61:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:65:0x0214 A[LOOP:1: B:63:0x020e->B:65:0x0214, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:68:0x02c0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:69:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:77:0x0306  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:89:0x0342  */
    /* JADX WARN: Code duplicated, block: B:98:0x035e  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        Object obj;
        int i;
        String animeUrl;
        String animeUrl2;
        Document doc;
        Element elementSelectFirst;
        MatchResult matchResultFind$default;
        List groupValues;
        String dataId;
        Element elementSelectFirst2;
        Element elementSelectFirst3;
        String title;
        String strAttr;
        String strSubstringBefore$default;
        Element elementSelectFirst4;
        String poster;
        Element elementSelectFirst5;
        Element elementSelectFirst6;
        String plot;
        String strAttr2;
        Collection destination$iv$iv;
        List genres;
        String vrf;
        String title2;
        String plot2;
        String poster2;
        String animeUrl3;
        String dataId2;
        Document doc2;
        String title3;
        String animeUrl4;
        String animeUrl5;
        String title4;
        String animeUrl6;
        String vrf2;
        List genres2;
        String url2;
        String strText;
        String string;
        String strText2;
        String epsText;
        Object obj2;
        String url3;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        AjaxResponse epsJson;
        String epsHtml;
        Document epsSoup;
        List subEpisodes;
        List dubEpisodes;
        Iterable $this$forEach$iv;
        int $i$f$forEach;
        Element epLink;
        Integer intOrNull;
        String epsHtml2;
        Integer intOrNull2;
        final int epNum;
        final String epTitle;
        String dataIds;
        Iterable $this$forEach$iv2;
        int $i$f$forEach2;
        boolean hasSub;
        boolean hasDub;
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
                String animeUrl7 = new Regex("/ep-\\d+$").replace(url, "");
                Requests app = MainActivityKt.getApp();
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c00012.L$1 = animeUrl7;
                c00012.label = 1;
                obj = coroutine_suspended;
                i = 2;
                animeUrl = animeUrl7;
                $result = Requests.get$default(app, animeUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                c00012 = c00012;
                if ($result == obj) {
                    return obj;
                }
                animeUrl2 = url;
                doc = ((NiceResponse) $result).getDocument();
                elementSelectFirst = doc.selectFirst(".watch-wrap[data-id]");
                if (elementSelectFirst != null || (dataId = elementSelectFirst.attr("data-id")) == null) {
                    matchResultFind$default = Regex.find$default(new Regex("mangaId\\s*=\\s*(\\d+)"), doc.html(), 0, i, (Object) null);
                    if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null) {
                        return null;
                    }
                    dataId = (String) groupValues.get(1);
                }
                elementSelectFirst2 = doc.selectFirst(".maindata h1.title, h1.title[itemprop=name], h1.title");
                if (elementSelectFirst2 != null || (strText2 = elementSelectFirst2.text()) == null || (title = StringsKt.trim(strText2).toString()) == null) {
                    elementSelectFirst3 = doc.selectFirst("meta[property=og:title]");
                    if (elementSelectFirst3 != null || (strAttr = elementSelectFirst3.attr("content")) == null || (strSubstringBefore$default = StringsKt.substringBefore$default(strAttr, " Episode", (String) null, i, (Object) null)) == null) {
                        title = "Unknown";
                    } else {
                        title = StringsKt.trim(strSubstringBefore$default).toString();
                    }
                }
                elementSelectFirst4 = doc.selectFirst("meta[property=og:image]");
                if (elementSelectFirst4 != null) {
                    poster = elementSelectFirst4.attr("content");
                } else {
                    poster = null;
                }
                elementSelectFirst5 = doc.selectFirst(".description .full.cts-block div, .description .full div");
                if (elementSelectFirst5 != null || (strText = elementSelectFirst5.text()) == null || (string = StringsKt.trim(strText).toString()) == null) {
                    elementSelectFirst6 = doc.selectFirst("meta[property=og:description]");
                    if (elementSelectFirst6 != null || (strAttr2 = elementSelectFirst6.attr("content")) == null) {
                        plot = null;
                    } else {
                        plot = StringsKt.trim(strAttr2).toString();
                    }
                } else {
                    plot = string;
                }
                Iterable $this$map$iv = doc.select(".meta a[href*='/genre/'], .data a[href*='/genre/']");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Element it = (Element) item$iv$iv;
                    destination$iv$iv.add(StringsKt.trim(it.text()).toString());
                }
                genres = (List) destination$iv$iv;
                vrf = generateVrf(dataId);
                Requests app2 = MainActivityKt.getApp();
                String str = getMainUrl() + "/ajax/episode/list/" + dataId + "?vrf=" + vrf;
                Map<String, String> map = this.ajaxHeaders;
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(animeUrl2);
                c00012.L$1 = animeUrl;
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(doc);
                c00012.L$3 = dataId;
                c00012.L$4 = title;
                c00012.L$5 = poster;
                c00012.L$6 = plot;
                c00012.L$7 = genres;
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(vrf);
                c00012.label = 2;
                title2 = title;
                plot2 = plot;
                C00011 c00013 = c00012;
                poster2 = poster;
                animeUrl3 = animeUrl;
                dataId2 = dataId;
                $result = Requests.get$default(app2, str, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4092, (Object) null);
                c00012 = c00013;
                if ($result == obj) {
                    return obj;
                }
                doc2 = doc;
                title3 = vrf;
                animeUrl4 = animeUrl3;
                animeUrl5 = dataId2;
                title4 = title2;
                animeUrl6 = plot2;
                vrf2 = poster2;
                genres2 = genres;
                url2 = animeUrl2;
                epsText = ((NiceResponse) $result).getText();
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(AjaxResponse.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    break;
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj2) != null) {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        url3 = url2;
                        try {
                            obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AjaxResponse.class), (List) null, 2, (Object) null));
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion4 = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        url3 = url2;
                    }
                    break;
                } else {
                    url3 = url2;
                }
                if (Result.isFailure-impl(obj2)) {
                    obj2 = null;
                }
                deserializationStrategy = (KSerializer) obj2;
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, epsText);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv.readValue(epsText, new TypeReference<AjaxResponse>() { // from class: com.animesuge.provider.AnimeSuge$load$$inlined$parseJson$1
                        });
                    } catch (Throwable th4) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(epsText, new TypeReference<AjaxResponse>() { // from class: com.animesuge.provider.AnimeSuge$load$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(epsText, new TypeReference<AjaxResponse>() { // from class: com.animesuge.provider.AnimeSuge$load$$inlined$parseJson$1
                    });
                }
                epsJson = (AjaxResponse) objDecodeFromString;
                epsHtml = epsJson.getResult();
                if (epsHtml == null) {
                    return null;
                }
                epsSoup = Jsoup.parse(epsHtml);
                subEpisodes = new ArrayList();
                dubEpisodes = new ArrayList();
                $this$forEach$iv = epsSoup.select("a[data-ids]");
                $i$f$forEach = 0;
                for (Object element$iv : $this$forEach$iv) {
                    AjaxResponse epsJson2 = epsJson;
                    epLink = (Element) element$iv;
                    intOrNull = StringsKt.toIntOrNull(epLink.text());
                    if (intOrNull != null) {
                        int iIntValue = intOrNull.intValue();
                        epsHtml2 = epsHtml;
                        epNum = iIntValue;
                    } else {
                        epsHtml2 = epsHtml;
                        intOrNull2 = StringsKt.toIntOrNull(epLink.attr("data-slug"));
                        if (intOrNull2 != null) {
                            epNum = intOrNull2.intValue();
                        } else {
                            epNum = 1;
                        }
                    }
                    Document epsSoup2 = epsSoup;
                    epTitle = epLink.attr("data-num");
                    if (StringsKt.isBlank(epTitle)) {
                        epTitle = null;
                    }
                    if (epTitle == null) {
                        epTitle = "Episode " + epNum;
                    }
                    dataIds = epLink.attr("data-ids");
                    if (StringsKt.isBlank(dataIds)) {
                        dataIds = null;
                    }
                    if (dataIds == null) {
                        $this$forEach$iv2 = $this$forEach$iv;
                        $i$f$forEach2 = $i$f$forEach;
                    } else {
                        $this$forEach$iv2 = $this$forEach$iv;
                        $i$f$forEach2 = $i$f$forEach;
                        hasSub = Intrinsics.areEqual(epLink.attr("data-sub"), "1");
                        hasDub = Intrinsics.areEqual(epLink.attr("data-dub"), "1");
                        if (hasSub) {
                            subEpisodes.add(MainAPIKt.newEpisode(this, animeUrl4 + '|' + animeUrl5 + '|' + epNum + '|' + dataIds + "|sub", new Function1() { // from class: com.animesuge.provider.AnimeSuge$$ExternalSyntheticLambda8
                                public final Object invoke(Object obj3) {
                                    return AnimeSuge.load$lambda$1$2(epNum, epTitle, (Episode) obj3);
                                }
                            }));
                        }
                        if (hasDub) {
                            dubEpisodes.add(MainAPIKt.newEpisode(this, animeUrl4 + '|' + animeUrl5 + '|' + epNum + '|' + dataIds + "|dub", new Function1() { // from class: com.animesuge.provider.AnimeSuge$$ExternalSyntheticLambda9
                                public final Object invoke(Object obj3) {
                                    return AnimeSuge.load$lambda$1$3(epNum, epTitle, (Episode) obj3);
                                }
                            }));
                        }
                    }
                    epsJson = epsJson2;
                    epsHtml = epsHtml2;
                    epsSoup = epsSoup2;
                    $this$forEach$iv = $this$forEach$iv2;
                    $i$f$forEach = $i$f$forEach2;
                    title4 = title4;
                }
                TvType tvType = TvType.Anime;
                C00023 c00023 = new C00023(vrf2, animeUrl6, genres2, subEpisodes, dubEpisodes, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(animeUrl4);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(doc2);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(animeUrl5);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(title4);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(vrf2);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(animeUrl6);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(genres2);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(title3);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(epsText);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(epsJson);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(epsHtml);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(epsSoup);
                c00012.L$13 = SpillingKt.nullOutSpilledVariable(subEpisodes);
                c00012.L$14 = SpillingKt.nullOutSpilledVariable(dubEpisodes);
                c00012.label = 3;
                $result = MainAPIKt.newAnimeLoadResponse$default(this, title4, animeUrl4, tvType, false, c00023, c00012, 8, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                return $result;
            case 1:
                String animeUrl8 = (String) c00012.L$1;
                String url4 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                i = 2;
                animeUrl = animeUrl8;
                animeUrl2 = url4;
                doc = ((NiceResponse) $result).getDocument();
                elementSelectFirst = doc.selectFirst(".watch-wrap[data-id]");
                if (elementSelectFirst != null) {
                    matchResultFind$default = Regex.find$default(new Regex("mangaId\\s*=\\s*(\\d+)"), doc.html(), 0, i, (Object) null);
                    if (matchResultFind$default != null) {
                        break;
                    }
                    return null;
                }
                matchResultFind$default = Regex.find$default(new Regex("mangaId\\s*=\\s*(\\d+)"), doc.html(), 0, i, (Object) null);
                if (matchResultFind$default != null) {
                    break;
                }
                return null;
                elementSelectFirst2 = doc.selectFirst(".maindata h1.title, h1.title[itemprop=name], h1.title");
                if (elementSelectFirst2 != null) {
                    elementSelectFirst3 = doc.selectFirst("meta[property=og:title]");
                    if (elementSelectFirst3 != null) {
                        title = "Unknown";
                    } else {
                        title = "Unknown";
                    }
                } else {
                    elementSelectFirst3 = doc.selectFirst("meta[property=og:title]");
                    if (elementSelectFirst3 != null) {
                        title = "Unknown";
                    } else {
                        title = "Unknown";
                    }
                }
                elementSelectFirst4 = doc.selectFirst("meta[property=og:image]");
                if (elementSelectFirst4 != null) {
                    poster = elementSelectFirst4.attr("content");
                } else {
                    poster = null;
                }
                elementSelectFirst5 = doc.selectFirst(".description .full.cts-block div, .description .full div");
                if (elementSelectFirst5 != null) {
                    elementSelectFirst6 = doc.selectFirst("meta[property=og:description]");
                    if (elementSelectFirst6 != null) {
                        plot = null;
                    } else {
                        plot = null;
                    }
                } else {
                    elementSelectFirst6 = doc.selectFirst("meta[property=og:description]");
                    if (elementSelectFirst6 != null) {
                        plot = null;
                    } else {
                        plot = null;
                    }
                }
                Iterable $this$map$iv2 = doc.select(".meta a[href*='/genre/'], .data a[href*='/genre/']");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                while (r16.hasNext()) {
                    Element it2 = (Element) item$iv$iv;
                    destination$iv$iv.add(StringsKt.trim(it2.text()).toString());
                }
                genres = (List) destination$iv$iv;
                vrf = generateVrf(dataId);
                Requests app3 = MainActivityKt.getApp();
                String str2 = getMainUrl() + "/ajax/episode/list/" + dataId + "?vrf=" + vrf;
                Map<String, String> map2 = this.ajaxHeaders;
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(animeUrl2);
                c00012.L$1 = animeUrl;
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(doc);
                c00012.L$3 = dataId;
                c00012.L$4 = title;
                c00012.L$5 = poster;
                c00012.L$6 = plot;
                c00012.L$7 = genres;
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(vrf);
                c00012.label = 2;
                title2 = title;
                plot2 = plot;
                C00011 c00014 = c00012;
                poster2 = poster;
                animeUrl3 = animeUrl;
                dataId2 = dataId;
                $result = Requests.get$default(app3, str2, map2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00014, 4092, (Object) null);
                c00012 = c00014;
                if ($result == obj) {
                    return obj;
                }
                doc2 = doc;
                title3 = vrf;
                animeUrl4 = animeUrl3;
                animeUrl5 = dataId2;
                title4 = title2;
                animeUrl6 = plot2;
                vrf2 = poster2;
                genres2 = genres;
                url2 = animeUrl2;
                epsText = ((NiceResponse) $result).getText();
                AppUtils appUtils2 = AppUtils.INSTANCE;
                Result.Companion companion5 = Result.Companion;
                KType kTypeTypeOf2 = Reflection.typeOf(AjaxResponse.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                if (Result.exceptionOrNull-impl(obj2) != null) {
                    Result.Companion companion6 = Result.Companion;
                    url3 = url2;
                    obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AjaxResponse.class), (List) null, 2, (Object) null));
                    break;
                } else {
                    url3 = url2;
                }
                if (Result.isFailure-impl(obj2)) {
                    obj2 = null;
                }
                deserializationStrategy = (KSerializer) obj2;
                if (deserializationStrategy != null) {
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, epsText);
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv4.readValue(epsText, new TypeReference<AjaxResponse>() { // from class: com.animesuge.provider.AnimeSuge$load$$inlined$parseJson$1
                    });
                }
                epsJson = (AjaxResponse) objDecodeFromString;
                epsHtml = epsJson.getResult();
                if (epsHtml == null) {
                    return null;
                }
                epsSoup = Jsoup.parse(epsHtml);
                subEpisodes = new ArrayList();
                dubEpisodes = new ArrayList();
                $this$forEach$iv = epsSoup.select("a[data-ids]");
                $i$f$forEach = 0;
                while (r11.hasNext()) {
                    AjaxResponse epsJson3 = epsJson;
                    epLink = (Element) element$iv;
                    intOrNull = StringsKt.toIntOrNull(epLink.text());
                    if (intOrNull != null) {
                        int iIntValue2 = intOrNull.intValue();
                        epsHtml2 = epsHtml;
                        epNum = iIntValue2;
                    } else {
                        epsHtml2 = epsHtml;
                        intOrNull2 = StringsKt.toIntOrNull(epLink.attr("data-slug"));
                        if (intOrNull2 != null) {
                            epNum = intOrNull2.intValue();
                        } else {
                            epNum = 1;
                        }
                    }
                    Document epsSoup3 = epsSoup;
                    epTitle = epLink.attr("data-num");
                    if (StringsKt.isBlank(epTitle)) {
                        epTitle = null;
                    }
                    if (epTitle == null) {
                        epTitle = "Episode " + epNum;
                    }
                    dataIds = epLink.attr("data-ids");
                    if (StringsKt.isBlank(dataIds)) {
                        dataIds = null;
                    }
                    if (dataIds == null) {
                        $this$forEach$iv2 = $this$forEach$iv;
                        $i$f$forEach2 = $i$f$forEach;
                    } else {
                        $this$forEach$iv2 = $this$forEach$iv;
                        $i$f$forEach2 = $i$f$forEach;
                        hasSub = Intrinsics.areEqual(epLink.attr("data-sub"), "1");
                        hasDub = Intrinsics.areEqual(epLink.attr("data-dub"), "1");
                        if (hasSub) {
                            subEpisodes.add(MainAPIKt.newEpisode(this, animeUrl4 + '|' + animeUrl5 + '|' + epNum + '|' + dataIds + "|sub", new Function1() { // from class: com.animesuge.provider.AnimeSuge$$ExternalSyntheticLambda8
                                public final Object invoke(Object obj3) {
                                    return AnimeSuge.load$lambda$1$2(epNum, epTitle, (Episode) obj3);
                                }
                            }));
                        }
                        if (hasDub) {
                            dubEpisodes.add(MainAPIKt.newEpisode(this, animeUrl4 + '|' + animeUrl5 + '|' + epNum + '|' + dataIds + "|dub", new Function1() { // from class: com.animesuge.provider.AnimeSuge$$ExternalSyntheticLambda9
                                public final Object invoke(Object obj3) {
                                    return AnimeSuge.load$lambda$1$3(epNum, epTitle, (Episode) obj3);
                                }
                            }));
                        }
                    }
                    epsJson = epsJson3;
                    epsHtml = epsHtml2;
                    epsSoup = epsSoup3;
                    $this$forEach$iv = $this$forEach$iv2;
                    $i$f$forEach = $i$f$forEach2;
                    title4 = title4;
                }
                TvType tvType2 = TvType.Anime;
                C00023 c00024 = new C00023(vrf2, animeUrl6, genres2, subEpisodes, dubEpisodes, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(animeUrl4);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(doc2);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(animeUrl5);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(title4);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(vrf2);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(animeUrl6);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(genres2);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(title3);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(epsText);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(epsJson);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(epsHtml);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(epsSoup);
                c00012.L$13 = SpillingKt.nullOutSpilledVariable(subEpisodes);
                c00012.L$14 = SpillingKt.nullOutSpilledVariable(dubEpisodes);
                c00012.label = 3;
                $result = MainAPIKt.newAnimeLoadResponse$default(this, title4, animeUrl4, tvType2, false, c00024, c00012, 8, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                return $result;
            case 2:
                String vrf3 = (String) c00012.L$8;
                List genres3 = (List) c00012.L$7;
                String plot3 = (String) c00012.L$6;
                String poster3 = (String) c00012.L$5;
                String title5 = (String) c00012.L$4;
                String dataId3 = (String) c00012.L$3;
                doc2 = (Document) c00012.L$2;
                String animeUrl9 = (String) c00012.L$1;
                String url5 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                url2 = url5;
                genres2 = genres3;
                animeUrl6 = plot3;
                vrf2 = poster3;
                title4 = title5;
                animeUrl4 = animeUrl9;
                title3 = vrf3;
                animeUrl5 = dataId3;
                epsText = ((NiceResponse) $result).getText();
                AppUtils appUtils3 = AppUtils.INSTANCE;
                Result.Companion companion7 = Result.Companion;
                KType kTypeTypeOf3 = Reflection.typeOf(AjaxResponse.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                if (Result.exceptionOrNull-impl(obj2) != null) {
                    Result.Companion companion8 = Result.Companion;
                    url3 = url2;
                    obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AjaxResponse.class), (List) null, 2, (Object) null));
                    break;
                } else {
                    url3 = url2;
                }
                if (Result.isFailure-impl(obj2)) {
                    obj2 = null;
                }
                deserializationStrategy = (KSerializer) obj2;
                if (deserializationStrategy != null) {
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, epsText);
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv5.readValue(epsText, new TypeReference<AjaxResponse>() { // from class: com.animesuge.provider.AnimeSuge$load$$inlined$parseJson$1
                    });
                }
                epsJson = (AjaxResponse) objDecodeFromString;
                epsHtml = epsJson.getResult();
                if (epsHtml == null) {
                    return null;
                }
                epsSoup = Jsoup.parse(epsHtml);
                subEpisodes = new ArrayList();
                dubEpisodes = new ArrayList();
                $this$forEach$iv = epsSoup.select("a[data-ids]");
                $i$f$forEach = 0;
                while (r11.hasNext()) {
                    AjaxResponse epsJson4 = epsJson;
                    epLink = (Element) element$iv;
                    intOrNull = StringsKt.toIntOrNull(epLink.text());
                    if (intOrNull != null) {
                        int iIntValue3 = intOrNull.intValue();
                        epsHtml2 = epsHtml;
                        epNum = iIntValue3;
                    } else {
                        epsHtml2 = epsHtml;
                        intOrNull2 = StringsKt.toIntOrNull(epLink.attr("data-slug"));
                        if (intOrNull2 != null) {
                            epNum = intOrNull2.intValue();
                        } else {
                            epNum = 1;
                        }
                    }
                    Document epsSoup4 = epsSoup;
                    epTitle = epLink.attr("data-num");
                    if (StringsKt.isBlank(epTitle)) {
                        epTitle = null;
                    }
                    if (epTitle == null) {
                        epTitle = "Episode " + epNum;
                    }
                    dataIds = epLink.attr("data-ids");
                    if (StringsKt.isBlank(dataIds)) {
                        dataIds = null;
                    }
                    if (dataIds == null) {
                        $this$forEach$iv2 = $this$forEach$iv;
                        $i$f$forEach2 = $i$f$forEach;
                    } else {
                        $this$forEach$iv2 = $this$forEach$iv;
                        $i$f$forEach2 = $i$f$forEach;
                        hasSub = Intrinsics.areEqual(epLink.attr("data-sub"), "1");
                        hasDub = Intrinsics.areEqual(epLink.attr("data-dub"), "1");
                        if (hasSub) {
                            subEpisodes.add(MainAPIKt.newEpisode(this, animeUrl4 + '|' + animeUrl5 + '|' + epNum + '|' + dataIds + "|sub", new Function1() { // from class: com.animesuge.provider.AnimeSuge$$ExternalSyntheticLambda8
                                public final Object invoke(Object obj3) {
                                    return AnimeSuge.load$lambda$1$2(epNum, epTitle, (Episode) obj3);
                                }
                            }));
                        }
                        if (hasDub) {
                            dubEpisodes.add(MainAPIKt.newEpisode(this, animeUrl4 + '|' + animeUrl5 + '|' + epNum + '|' + dataIds + "|dub", new Function1() { // from class: com.animesuge.provider.AnimeSuge$$ExternalSyntheticLambda9
                                public final Object invoke(Object obj3) {
                                    return AnimeSuge.load$lambda$1$3(epNum, epTitle, (Episode) obj3);
                                }
                            }));
                        }
                    }
                    epsJson = epsJson4;
                    epsHtml = epsHtml2;
                    epsSoup = epsSoup4;
                    $this$forEach$iv = $this$forEach$iv2;
                    $i$f$forEach = $i$f$forEach2;
                    title4 = title4;
                }
                TvType tvType3 = TvType.Anime;
                C00023 c00025 = new C00023(vrf2, animeUrl6, genres2, subEpisodes, dubEpisodes, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(animeUrl4);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(doc2);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(animeUrl5);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(title4);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(vrf2);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(animeUrl6);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(genres2);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(title3);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(epsText);
                c00012.L$10 = SpillingKt.nullOutSpilledVariable(epsJson);
                c00012.L$11 = SpillingKt.nullOutSpilledVariable(epsHtml);
                c00012.L$12 = SpillingKt.nullOutSpilledVariable(epsSoup);
                c00012.L$13 = SpillingKt.nullOutSpilledVariable(subEpisodes);
                c00012.L$14 = SpillingKt.nullOutSpilledVariable(dubEpisodes);
                c00012.label = 3;
                $result = MainAPIKt.newAnimeLoadResponse$default(this, title4, animeUrl4, tvType3, false, c00025, c00012, 8, (Object) null);
                if ($result == obj) {
                    return obj;
                }
                return $result;
            case 3:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$1$2(int $epNum, String $epTitle, Episode $this$newEpisode) {
        $this$newEpisode.setEpisode(Integer.valueOf($epNum));
        $this$newEpisode.setName($epTitle);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$1$3(int $epNum, String $epTitle, Episode $this$newEpisode) {
        $this$newEpisode.setEpisode(Integer.valueOf($epNum));
        $this$newEpisode.setName($epTitle);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.animesuge.provider.AnimeSuge$load$3 */
    /* JADX INFO: compiled from: AnimeSuge.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.animesuge.provider.AnimeSuge$load$3", f = "AnimeSuge.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00023 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Episode> $dubEpisodes;
        final /* synthetic */ List<String> $genres;
        final /* synthetic */ String $plot;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<Episode> $subEpisodes;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00023(String str, String str2, List<String> list, List<Episode> list2, List<Episode> list3, Continuation<? super C00023> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$plot = str2;
            this.$genres = list;
            this.$subEpisodes = list2;
            this.$dubEpisodes = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00023 = new C00023(this.$poster, this.$plot, this.$genres, this.$subEpisodes, this.$dubEpisodes, continuation);
            c00023.L$0 = obj;
            return c00023;
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
                    $this$newAnimeLoadResponse.setPlot(this.$plot);
                    $this$newAnimeLoadResponse.setTags(this.$genres);
                    if (!this.$subEpisodes.isEmpty()) {
                        MainAPIKt.addEpisodes($this$newAnimeLoadResponse, DubStatus.Subbed, this.$subEpisodes);
                    }
                    if (!this.$dubEpisodes.isEmpty()) {
                        MainAPIKt.addEpisodes($this$newAnimeLoadResponse, DubStatus.Dubbed, this.$dubEpisodes);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:129:0x051b  */
    /* JADX WARN: Code duplicated, block: B:142:0x063b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:143:0x063c  */
    /* JADX WARN: Code duplicated, block: B:152:0x0691  */
    /* JADX WARN: Code duplicated, block: B:168:0x06e1  */
    /* JADX WARN: Code duplicated, block: B:192:0x073f A[Catch: Exception -> 0x081c, TryCatch #16 {Exception -> 0x081c, blocks: (B:166:0x06db, B:169:0x06e2, B:190:0x0735, B:192:0x073f, B:194:0x0746, B:199:0x0756, B:189:0x071a, B:165:0x06d1), top: B:266:0x06db }] */
    /* JADX WARN: Code duplicated, block: B:194:0x0746 A[Catch: Exception -> 0x081c, TryCatch #16 {Exception -> 0x081c, blocks: (B:166:0x06db, B:169:0x06e2, B:190:0x0735, B:192:0x073f, B:194:0x0746, B:199:0x0756, B:189:0x071a, B:165:0x06d1), top: B:266:0x06db }] */
    /* JADX WARN: Code duplicated, block: B:196:0x0752  */
    /* JADX WARN: Code duplicated, block: B:197:0x0753  */
    /* JADX WARN: Code duplicated, block: B:199:0x0756 A[Catch: Exception -> 0x081c, TRY_LEAVE, TryCatch #16 {Exception -> 0x081c, blocks: (B:166:0x06db, B:169:0x06e2, B:190:0x0735, B:192:0x073f, B:194:0x0746, B:199:0x0756, B:189:0x071a, B:165:0x06d1), top: B:266:0x06db }] */
    /* JADX WARN: Code duplicated, block: B:201:0x07e6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:202:0x07e7  */
    /* JADX WARN: Code duplicated, block: B:205:0x0803  */
    /* JADX WARN: Code duplicated, block: B:210:0x080a  */
    /* JADX WARN: Code duplicated, block: B:214:0x0812  */
    /* JADX WARN: Code duplicated, block: B:215:0x0814  */
    /* JADX WARN: Code duplicated, block: B:257:0x069a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:280:0x06e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Not initialized variable reg: 25, insn: 0x0164: MOVE (r7 I:??[OBJECT, ARRAY]) = (r25 I:??[OBJECT, ARRAY] A[D('found' kotlin.jvm.internal.Ref$BooleanRef)]), block:B:19:0x015e */
    /* JADX WARN: Not initialized variable reg: 29, insn: 0x0166: MOVE (r21 I:??[OBJECT, ARRAY]) = (r29 I:??[OBJECT, ARRAY] A[D('serverListJson' com.animesuge.provider.AnimeSuge$AjaxResponse)]), block:B:19:0x015e */
    /* JADX WARN: Not initialized variable reg: 31, insn: 0x0168: MOVE (r8 I:??[OBJECT, ARRAY]) = (r31 I:??[OBJECT, ARRAY] A[D('selectedType' java.lang.String)]), block:B:19:0x015e */
    /* JADX WARN: Type inference failed for: r0v27, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v32, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v91, types: [java.lang.Throwable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:202:0x07e7 -> B:251:0x07fb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:238:0x0920 -> B:239:0x0921). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r50, boolean r51, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r52, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r53, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r54) {
        /*
            Method dump skipped, instruction units count: 2380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animesuge.provider.AnimeSuge.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadLinks$lambda$0$0(Context $_ctx) {
        Toast.makeText($_ctx, "⚠️(Opening ads) Subscription expired. If you have renewed your subscription, please re-verify it in Subscription Manager.", 1).show();
    }

    /* JADX INFO: compiled from: AnimeSuge.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/animesuge/provider/AnimeSuge$AjaxResponse;", "", "status", "", "result", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getResult", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/animesuge/provider/AnimeSuge$AjaxResponse;", "equals", "", "other", "hashCode", "toString", "AnimeSuge_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class AjaxResponse {

        @JsonProperty("result")
        @Nullable
        private final String result;

        @JsonProperty("status")
        @Nullable
        private final Integer status;

        /* JADX WARN: Multi-variable type inference failed */
        public AjaxResponse() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ AjaxResponse copy$default(AjaxResponse ajaxResponse, Integer num, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                num = ajaxResponse.status;
            }
            if ((i & 2) != 0) {
                str = ajaxResponse.result;
            }
            return ajaxResponse.copy(num, str);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getStatus() {
            return this.status;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getResult() {
            return this.result;
        }

        @NotNull
        public final AjaxResponse copy(@JsonProperty("status") @Nullable Integer status, @JsonProperty("result") @Nullable String result) {
            return new AjaxResponse(status, result);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AjaxResponse)) {
                return false;
            }
            AjaxResponse ajaxResponse = (AjaxResponse) other;
            return Intrinsics.areEqual(this.status, ajaxResponse.status) && Intrinsics.areEqual(this.result, ajaxResponse.result);
        }

        public int hashCode() {
            return ((this.status == null ? 0 : this.status.hashCode()) * 31) + (this.result != null ? this.result.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "AjaxResponse(status=" + this.status + ", result=" + this.result + ')';
        }

        public AjaxResponse(@JsonProperty("status") @Nullable Integer status, @JsonProperty("result") @Nullable String result) {
            this.status = status;
            this.result = result;
        }

        public /* synthetic */ AjaxResponse(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str);
        }

        @Nullable
        public final Integer getStatus() {
            return this.status;
        }

        @Nullable
        public final String getResult() {
            return this.result;
        }
    }

    /* JADX INFO: compiled from: AnimeSuge.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/animesuge/provider/AnimeSuge$ServerInfoResponse;", "", "status", "", "result", "Lcom/animesuge/provider/AnimeSuge$ServerInfoResult;", "<init>", "(Ljava/lang/Integer;Lcom/animesuge/provider/AnimeSuge$ServerInfoResult;)V", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getResult", "()Lcom/animesuge/provider/AnimeSuge$ServerInfoResult;", "component1", "component2", "copy", "(Ljava/lang/Integer;Lcom/animesuge/provider/AnimeSuge$ServerInfoResult;)Lcom/animesuge/provider/AnimeSuge$ServerInfoResponse;", "equals", "", "other", "hashCode", "toString", "", "AnimeSuge_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ServerInfoResponse {

        @JsonProperty("result")
        @Nullable
        private final ServerInfoResult result;

        @JsonProperty("status")
        @Nullable
        private final Integer status;

        /* JADX WARN: Multi-variable type inference failed */
        public ServerInfoResponse() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ServerInfoResponse copy$default(ServerInfoResponse serverInfoResponse, Integer num, ServerInfoResult serverInfoResult, int i, Object obj) {
            if ((i & 1) != 0) {
                num = serverInfoResponse.status;
            }
            if ((i & 2) != 0) {
                serverInfoResult = serverInfoResponse.result;
            }
            return serverInfoResponse.copy(num, serverInfoResult);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getStatus() {
            return this.status;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ServerInfoResult getResult() {
            return this.result;
        }

        @NotNull
        public final ServerInfoResponse copy(@JsonProperty("status") @Nullable Integer status, @JsonProperty("result") @Nullable ServerInfoResult result) {
            return new ServerInfoResponse(status, result);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ServerInfoResponse)) {
                return false;
            }
            ServerInfoResponse serverInfoResponse = (ServerInfoResponse) other;
            return Intrinsics.areEqual(this.status, serverInfoResponse.status) && Intrinsics.areEqual(this.result, serverInfoResponse.result);
        }

        public int hashCode() {
            return ((this.status == null ? 0 : this.status.hashCode()) * 31) + (this.result != null ? this.result.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "ServerInfoResponse(status=" + this.status + ", result=" + this.result + ')';
        }

        public ServerInfoResponse(@JsonProperty("status") @Nullable Integer status, @JsonProperty("result") @Nullable ServerInfoResult result) {
            this.status = status;
            this.result = result;
        }

        public /* synthetic */ ServerInfoResponse(Integer num, ServerInfoResult serverInfoResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : serverInfoResult);
        }

        @Nullable
        public final Integer getStatus() {
            return this.status;
        }

        @Nullable
        public final ServerInfoResult getResult() {
            return this.result;
        }
    }

    /* JADX INFO: compiled from: AnimeSuge.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/animesuge/provider/AnimeSuge$ServerInfoResult;", "", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "AnimeSuge_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class ServerInfoResult {

        @JsonProperty("url")
        @Nullable
        private final String url;

        /* JADX WARN: Illegal instructions before constructor call */
        public ServerInfoResult() {
            String str = null;
            this(str, 1, str);
        }

        public static /* synthetic */ ServerInfoResult copy$default(ServerInfoResult serverInfoResult, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = serverInfoResult.url;
            }
            return serverInfoResult.copy(str);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        public final ServerInfoResult copy(@JsonProperty("url") @Nullable String url) {
            return new ServerInfoResult(url);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ServerInfoResult) && Intrinsics.areEqual(this.url, ((ServerInfoResult) other).url);
        }

        public int hashCode() {
            if (this.url == null) {
                return 0;
            }
            return this.url.hashCode();
        }

        @NotNull
        public String toString() {
            return "ServerInfoResult(url=" + this.url + ')';
        }

        public ServerInfoResult(@JsonProperty("url") @Nullable String url) {
            this.url = url;
        }

        public /* synthetic */ ServerInfoResult(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        @Nullable
        public final String getUrl() {
            return this.url;
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
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.animesuge.provider.AnimeSuge$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    AnimeSuge.showSubscriptionPopupIfNeeded$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.animesuge.provider.AnimeSuge$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnimeSuge.showSubscriptionPopupIfNeeded$lambda$0$11($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249, $ctx, dialog, view);
                }
            });
            subscribeTv.setOnClickListener(new View.OnClickListener() { // from class: com.animesuge.provider.AnimeSuge$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnimeSuge.showSubscriptionPopupIfNeeded$lambda$0$12(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.animesuge.provider.AnimeSuge$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                AnimeSuge.showTelegramPopup$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.animesuge.provider.AnimeSuge$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            joinTv.setOnClickListener(new View.OnClickListener() { // from class: com.animesuge.provider.AnimeSuge$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnimeSuge.showTelegramPopup$lambda$0$9(dialog, $ctx, view);
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.animesuge.provider.AnimeSuge$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                AnimeSuge.openInExternalBrowser$lambda$0(ctx, url);
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
}
