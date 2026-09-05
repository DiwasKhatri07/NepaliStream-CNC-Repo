package com.anikoto;

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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.ui.settings.Globals;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
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

/* JADX INFO: compiled from: AnikotoProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AniKoto/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 P2\u00020\u0001:\u0004PQRSB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050$2\u0006\u0010&\u001a\u00020\u0005H\u0002J\u001e\u0010!\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0096@¢\u0006\u0002\u0010,J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u001f2\u0006\u0010/\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00100J\u0018\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00100JF\u00104\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00112\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:082\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020:08H\u0096@¢\u0006\u0002\u0010=J>\u0010>\u001a\u00020\u00112\u0006\u0010?\u001a\u00020\u00052\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:082\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020:08H\u0082@¢\u0006\u0002\u0010@JN\u0010A\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00052\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:082\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020:08H\u0082@¢\u0006\u0002\u0010CJV\u0010D\u001a\u00020\u00112\u0006\u00103\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00052\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:082\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020:08H\u0082@¢\u0006\u0002\u0010FJ\u0010\u0010G\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u0005H\u0002J\u0012\u0010I\u001a\u0004\u0018\u00010\u00052\u0006\u0010H\u001a\u00020\u0005H\u0002J\u000e\u0010J\u001a\u0004\u0018\u00010K*\u00020LH\u0002J\b\u0010M\u001a\u00020:H\u0002J\b\u0010N\u001a\u00020:H\u0002J\u0010\u0010O\u001a\u00020:2\u0006\u00103\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006T"}, d2 = {"Lcom/anikoto/AnikotoProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "mainUrl", "", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "lang", "getLang", "setLang", "subscriptionPopupShown", "", "telegramPopupShown", "lastBrowserOpenMs", "", "BROWSER_DEBOUNCE_MS", "hasMainPage", "getHasMainPage", "()Z", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "browserHeaders", "", "ajaxHeaders", "referer", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveFromWatchPage", "episodeUrl", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveEmbedInline", "audioType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveMegaPlayInline", "domain", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "jsonResultString", "json", "jsonResultUrl", "toSearchResult", "Lcom/lagradost/cloudstream3/AnimeSearchResponse;", "Lorg/jsoup/nodes/Element;", "showSubscriptionPopupIfNeeded", "showTelegramPopup", "openInExternalBrowser", "Companion", "AjaxResponse", "SourcesResponse", "Track", "AniKoto_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnikotoProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnikotoProvider.kt\ncom/anikoto/AnikotoProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,769:1\n1642#2,10:770\n1915#2:780\n1916#2:782\n1652#2:783\n1642#2,10:784\n1915#2:794\n1916#2:796\n1652#2:797\n1586#2:798\n1661#2,3:799\n1915#2:802\n1916#2:804\n1596#2:805\n1629#2,4:806\n1391#2:810\n1480#2,5:811\n1586#2:816\n1661#2,3:817\n777#2:820\n873#2,2:821\n1586#2:823\n1661#2,3:824\n777#2:827\n873#2,2:828\n1915#2,2:849\n1915#2,2:851\n1#3:781\n1#3:795\n1#3:803\n1#3:831\n1#3:854\n1#3:873\n1#3:891\n63#4:830\n64#4,15:832\n63#4:853\n64#4,15:855\n63#4:872\n64#4,15:874\n50#5:847\n43#5:848\n50#5:870\n43#5:871\n50#5:889\n43#5:890\n*S KotlinDebug\n*F\n+ 1 AnikotoProvider.kt\ncom/anikoto/AnikotoProvider\n*L\n85#1:770,10\n85#1:780\n85#1:782\n85#1:783\n93#1:784,10\n93#1:794\n93#1:796\n93#1:797\n114#1:798\n114#1:799,3\n132#1:802\n132#1:804\n160#1:805\n160#1:806,4\n236#1:810\n236#1:811,5\n242#1:816\n242#1:817,3\n243#1:820\n243#1:821,2\n318#1:823\n318#1:824,3\n319#1:827\n319#1:828,2\n439#1:849,2\n453#1:851,2\n85#1:781\n93#1:795\n424#1:831\n469#1:854\n476#1:873\n424#1:830\n424#1:832,15\n469#1:853\n469#1:855,15\n476#1:872\n476#1:874,15\n424#1:847\n424#1:848\n469#1:870\n469#1:871\n476#1:889\n476#1:890\n*E\n"})
public final class AnikotoProvider extends MainAPI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String OMG10 = "aHR0cHM6Ly9vbWcxMC5jb20vNC8xMTEwNDQ4OQ==";

    @Nullable
    private static Context context;
    private static volatile boolean csGuardWasEverActive;
    private long lastBrowserOpenMs;
    private boolean subscriptionPopupShown;
    private boolean telegramPopupShown;

    @NotNull
    private String mainUrl = "https://anikototv.to";

    @NotNull
    private String name = "AniKoto";

    @NotNull
    private String lang = "en";
    private final long BROWSER_DEBOUNCE_MS = 2000;
    private final boolean hasMainPage = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Anime, TvType.AnimeMovie, TvType.OVA});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to(getMainUrl() + "/latest-updated", "Latest Updated"), TuplesKt.to(getMainUrl() + "/most-viewed", "Most Popular"), TuplesKt.to(getMainUrl() + "/status/currently-airing", "Ongoing"), TuplesKt.to(getMainUrl() + "/type/movie", "Movies")});

    @NotNull
    private final Map<String, String> browserHeaders = MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 14; Pixel 8) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Mobile Safari/537.36"), TuplesKt.to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"), TuplesKt.to("Accept-Language", "en-US,en;q=0.5")});

    /* JADX INFO: renamed from: com.anikoto.AnikotoProvider$getMainPage$1 */
    /* JADX INFO: compiled from: AnikotoProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.anikoto.AnikotoProvider", f = "AnikotoProvider.kt", i = {0, 0}, l = {84}, m = "getMainPage", n = {"request", "page"}, nl = {85}, s = {"L$0", "I$0"}, v = 2)
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
            return AnikotoProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.anikoto.AnikotoProvider$load$1 */
    /* JADX INFO: compiled from: AnikotoProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.anikoto.AnikotoProvider", f = "AnikotoProvider.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {98, 127, 168}, m = "load", n = {"url", "url", "response", "doc", "title", "posterEl", "poster", "description", "genres", "animeId", "subEpisodes", "dubEpisodes", "isMovie", "url", "response", "doc", "title", "posterEl", "poster", "description", "genres", "animeId", "subEpisodes", "dubEpisodes", "isMovie"}, nl = {99, 130, -1}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        int I$0;
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
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnikotoProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.anikoto.AnikotoProvider$loadLinks$1 */
    /* JADX INFO: compiled from: AnikotoProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.anikoto.AnikotoProvider", f = "AnikotoProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4}, l = {220, 249, 255, 266, 270}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "ep", "parts", "referer", "serverIds", "audioType", "isCasting", "data", "subtitleCallback", "callback", "ep", "parts", "referer", "serverIds", "audioType", "serverListJson", "serverListHtml", "serverDoc", "typeSelectors", "preferredServers", "linkIds", "linkId", "isCasting", "found", "data", "subtitleCallback", "callback", "ep", "parts", "referer", "serverIds", "audioType", "serverListJson", "serverListHtml", "serverDoc", "typeSelectors", "preferredServers", "linkIds", "linkId", "serverJson", "embedUrl", "isCasting", "found", "data", "subtitleCallback", "callback", "ep", "episodeUrl", "isCasting", "data", "subtitleCallback", "callback", "ep", "isCasting"}, nl = {223, 252, 256, 270, -1}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$15", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$15", "L$16", "L$17", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        int I$0;
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

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnikotoProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.anikoto.AnikotoProvider$resolveEmbedInline$1 */
    /* JADX INFO: compiled from: AnikotoProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.anikoto.AnikotoProvider", f = "AnikotoProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {365, 368}, m = "resolveEmbedInline", n = {"url", "referer", "audioType", "subtitleCallback", "callback", "normalizedUrl", "domain", "isMegaPlayDomain", "url", "referer", "audioType", "subtitleCallback", "callback", "normalizedUrl", "domain", "isMegaPlayDomain"}, nl = {371, 369}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnikotoProvider.this.resolveEmbedInline(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.anikoto.AnikotoProvider$resolveFromWatchPage$1 */
    /* JADX INFO: compiled from: AnikotoProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.anikoto.AnikotoProvider", f = "AnikotoProvider.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {284, 291, 309, 325, 331}, m = "resolveFromWatchPage", n = {"episodeUrl", "subtitleCallback", "callback", "episodeUrl", "subtitleCallback", "callback", "doc", "watchMain", "animeId", "epName", "audioType", "episodeUrl", "subtitleCallback", "callback", "doc", "watchMain", "animeId", "epName", "audioType", "epListJson", "epListHtml", "epDoc", "targetEp", "serverIds", "episodeUrl", "subtitleCallback", "callback", "doc", "watchMain", "animeId", "epName", "audioType", "epListJson", "epListHtml", "epDoc", "targetEp", "serverIds", "serverListJson", "serverListHtml", "serverDoc", "linkIds", "linkId", "found", "episodeUrl", "subtitleCallback", "callback", "doc", "watchMain", "animeId", "epName", "audioType", "epListJson", "epListHtml", "epDoc", "targetEp", "serverIds", "serverListJson", "serverListHtml", "serverDoc", "linkIds", "linkId", "serverJson", "embedUrl", "found"}, nl = {285, 294, 312, 328, 332}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$18", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$18", "L$19", "L$20", "I$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        int I$0;
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
        int label;
        /* synthetic */ Object result;

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnikotoProvider.this.resolveFromWatchPage(null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.anikoto.AnikotoProvider$resolveMegaPlayInline$1 */
    /* JADX INFO: compiled from: AnikotoProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.anikoto.AnikotoProvider", f = "AnikotoProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {412, 420, 437, 441, 458}, m = "resolveMegaPlayInline", n = {"url", "referer", "domain", "audioType", "subtitleCallback", "callback", "host", "serverName", "type", "pageHeaders", "ajaxH", "playbackHeaders", "url", "referer", "domain", "audioType", "subtitleCallback", "callback", "host", "serverName", "type", "pageHeaders", "ajaxH", "playbackHeaders", "doc", "playerEl", "streamId", "url", "referer", "domain", "audioType", "subtitleCallback", "callback", "host", "serverName", "type", "pageHeaders", "ajaxH", "playbackHeaders", "doc", "playerEl", "streamId", "sourcesText", "root", "m3u8", "displayType", "url", "referer", "domain", "audioType", "subtitleCallback", "callback", "host", "serverName", "type", "pageHeaders", "ajaxH", "playbackHeaders", "doc", "playerEl", "streamId", "sourcesText", "root", "m3u8", "displayType", "generated", "url", "referer", "domain", "audioType", "subtitleCallback", "callback", "host", "serverName", "type", "pageHeaders", "ajaxH", "playbackHeaders", "doc", "playerEl", "streamId", "sourcesText", "root", "m3u8", "displayType", "generated", "$this$forEach$iv", "element$iv", "track", "file", "kind", "label", "$i$f$forEach", "$i$a$-forEach-AnikotoProvider$resolveMegaPlayInline$3"}, nl = {413, 423, 438, 452, 461}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$22", "L$23", "L$24", "L$25", "L$26", "I$0", "I$1"}, v = 2)
    static final class C00061 extends ContinuationImpl {
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
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnikotoProvider.this.resolveMegaPlayInline(null, null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.anikoto.AnikotoProvider$search$1 */
    /* JADX INFO: compiled from: AnikotoProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.anikoto.AnikotoProvider", f = "AnikotoProvider.kt", i = {0, 0}, l = {92}, m = "search", n = {"query", "encodedQuery"}, nl = {93}, s = {"L$0", "L$1"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnikotoProvider.this.search(null, (Continuation) this);
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

    /* JADX INFO: compiled from: AnikotoProvider.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/anikoto/AnikotoProvider$Companion;", "", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "OMG10", "", "isCsGuardActive", "", "csGuardWasEverActive", "isCsGuardBlocked", "showCsGuardToast", "", "ctx", "AniKoto_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAnikotoProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnikotoProvider.kt\ncom/anikoto/AnikotoProvider$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,769:1\n1#2:770\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Context getContext() {
            return AnikotoProvider.context;
        }

        public final void setContext(@Nullable Context context) {
            AnikotoProvider.context = context;
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
                AnikotoProvider.csGuardWasEverActive = true;
            }
            return AnikotoProvider.csGuardWasEverActive;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showCsGuardToast(final Context ctx) {
            if (ctx == null) {
                return;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.anikoto.AnikotoProvider$Companion$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AnikotoProvider.Companion.showCsGuardToast$lambda$0(ctx);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showCsGuardToast$lambda$0(Context $c) {
            Toast.makeText($c, "🚫 CSGuard detected — Restart CloudStream after removing CSGuard to use CNCRepo", 1).show();
        }
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

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    private final Map<String, String> ajaxHeaders(String referer) {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 14; Pixel 8) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Mobile Safari/537.36"), TuplesKt.to("X-Requested-With", "XMLHttpRequest"), TuplesKt.to("Accept", "application/json, text/javascript, */*; q=0.01"), TuplesKt.to("Referer", referer)});
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
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
                Requests app = MainActivityKt.getApp();
                String str = request.getData() + "?page=" + page;
                Map<String, String> map = this.browserHeaders;
                c00001.L$0 = request;
                c00001.I$0 = page;
                c00001.label = 1;
                $result = Requests.get$default(app, str, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4092, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                break;
                break;
            case 1:
                int i = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Document doc = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = doc.select("div.item, div.flw-item");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            AnimeSearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List items = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse$default(request2.getName(), items, (Boolean) null, 4, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws UnsupportedEncodingException {
        C00081 c00081;
        if (continuation instanceof C00081) {
            c00081 = (C00081) continuation;
            if ((c00081.label & Integer.MIN_VALUE) != 0) {
                c00081.label -= Integer.MIN_VALUE;
            } else {
                c00081 = new C00081(continuation);
            }
        } else {
            c00081 = new C00081(continuation);
        }
        Object $result = c00081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00081.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (INSTANCE.isCsGuardBlocked()) {
                    INSTANCE.showCsGuardToast(context);
                    return CollectionsKt.emptyList();
                }
                String encodedQuery = URLEncoder.encode(query, "UTF-8");
                Requests app = MainActivityKt.getApp();
                String str = getMainUrl() + "/filter?keyword=" + encodedQuery;
                Map<String, String> map = this.browserHeaders;
                c00081.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00081.L$1 = SpillingKt.nullOutSpilledVariable(encodedQuery);
                c00081.label = 1;
                $result = Requests.get$default(app, str, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00081, 4092, (Object) null);
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
        Document doc = ((NiceResponse) $result).getDocument();
        Iterable $this$mapNotNull$iv = doc.select("div.item, div.flw-item");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            AnimeSearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        return (List) destination$iv$iv;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x02e6 A[Catch: Exception -> 0x044a, TRY_LEAVE, TryCatch #3 {Exception -> 0x044a, blocks: (B:102:0x02d3, B:103:0x02e0, B:105:0x02e6), top: B:205:0x02d3 }] */
    /* JADX WARN: Code duplicated, block: B:109:0x032a A[Catch: Exception -> 0x0423, TRY_LEAVE, TryCatch #12 {Exception -> 0x0423, blocks: (B:107:0x0300, B:109:0x032a, B:139:0x0396, B:122:0x0354, B:132:0x0383), top: B:223:0x0300 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x033a A[Catch: Exception -> 0x034c, TryCatch #2 {Exception -> 0x034c, blocks: (B:111:0x0334, B:113:0x033a, B:116:0x0344, B:125:0x0365, B:129:0x0378), top: B:203:0x0334 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x0342  */
    /* JADX WARN: Code duplicated, block: B:119:0x0349  */
    /* JADX WARN: Code duplicated, block: B:122:0x0354 A[Catch: Exception -> 0x0423, TRY_ENTER, TRY_LEAVE, TryCatch #12 {Exception -> 0x0423, blocks: (B:107:0x0300, B:109:0x032a, B:139:0x0396, B:122:0x0354, B:132:0x0383), top: B:223:0x0300 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0362  */
    /* JADX WARN: Code duplicated, block: B:127:0x0374  */
    /* JADX WARN: Code duplicated, block: B:128:0x0377  */
    /* JADX WARN: Code duplicated, block: B:131:0x0381  */
    /* JADX WARN: Code duplicated, block: B:135:0x038a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:138:0x0394  */
    /* JADX WARN: Code duplicated, block: B:147:0x0409  */
    /* JADX WARN: Code duplicated, block: B:166:0x04b4  */
    /* JADX WARN: Code duplicated, block: B:169:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:179:0x0551  */
    /* JADX WARN: Code duplicated, block: B:182:0x055e  */
    /* JADX WARN: Code duplicated, block: B:183:0x0561  */
    /* JADX WARN: Code duplicated, block: B:186:0x05ce A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:187:0x05cf  */
    /* JADX WARN: Code duplicated, block: B:201:0x022b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:203:0x0334 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:217:0x03cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:230:0x0413 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x0112  */
    /* JADX WARN: Code duplicated, block: B:40:0x011a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0133  */
    /* JADX WARN: Code duplicated, block: B:47:0x0142  */
    /* JADX WARN: Code duplicated, block: B:49:0x014b  */
    /* JADX WARN: Code duplicated, block: B:52:0x0155  */
    /* JADX WARN: Code duplicated, block: B:53:0x015a  */
    /* JADX WARN: Code duplicated, block: B:57:0x0180 A[LOOP:2: B:55:0x017a->B:57:0x0180, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:60:0x01af  */
    /* JADX WARN: Code duplicated, block: B:67:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:70:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:71:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:76:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:78:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:79:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:81:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:83:0x0209  */
    /* JADX WARN: Code duplicated, block: B:86:0x0218  */
    /* JADX WARN: Code duplicated, block: B:96:0x02b2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:97:0x02b3  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        Object obj;
        String url2;
        NiceResponse response;
        Document doc;
        Element elementSelectFirst;
        Element elementSelectFirst2;
        String strText;
        String string;
        String title;
        Element posterEl;
        String dataSrc;
        Element elementSelectFirst3;
        String description;
        Collection destination$iv$iv;
        Element posterEl2;
        List genres;
        int i;
        int i2;
        Element elementSelectFirst4;
        Element elementSelectFirst5;
        String strAttr;
        MatchResult matchResultFind$default;
        List groupValues;
        String animeId;
        ArrayList subEpisodes;
        List dubEpisodes;
        Object obj2;
        NiceResponse response2;
        List dubEpisodes2;
        List subEpisodes2;
        String url3;
        Element posterEl3;
        String description2;
        String poster;
        String url4;
        List dubEpisodes3;
        String description3;
        C00011 c00012;
        String poster2;
        Object obj3;
        String animeId2;
        NiceResponse response3;
        Document doc2;
        String description4;
        String animeId3;
        List subEpisodes3;
        String url5;
        int i3;
        List genres2;
        String url6;
        Element elementSelectFirst6;
        boolean z;
        String strText2;
        String strText3;
        String poster3;
        String description5;
        List genres3;
        TvType tvType;
        Object obj4;
        Object objNewAnimeLoadResponse$default;
        String json;
        int i4;
        Iterable $this$forEach$iv;
        int $i$f$forEach;
        Element el;
        String serverIds;
        Document doc3;
        final Integer episodeNumber;
        boolean hasSub;
        boolean hasDub;
        String str;
        Element elementSelectFirst7;
        String strText4;
        String str2;
        final String episodeName;
        String strAttr2;
        Object obj5;
        String str3 = "1";
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
        C00011 c00013 = c00011;
        Object $result = c00013.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00013.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    Requests app = MainActivityKt.getApp();
                    Map<String, String> map = this.browserHeaders;
                    c00013.L$0 = url;
                    c00013.label = 1;
                    try {
                        obj = Requests.get$default(app, url, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4092, (Object) null);
                        c00013 = c00013;
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url2 = url;
                        try {
                            response = (NiceResponse) obj;
                            doc = response.getDocument();
                            elementSelectFirst = doc.selectFirst("#w-info h1.title, h1[itemprop=name], .title[itemprop=name]");
                            if (elementSelectFirst != null || (strText3 = elementSelectFirst.text()) == null || (string = StringsKt.trim(strText3).toString()) == null) {
                                elementSelectFirst2 = doc.selectFirst("h1.title");
                                if (elementSelectFirst2 != null || (strText = elementSelectFirst2.text()) == null) {
                                    return null;
                                }
                                string = StringsKt.trim(strText).toString();
                            }
                            title = string;
                            posterEl = doc.selectFirst("#w-info .poster img, img[itemprop=image], .poster img");
                            if (posterEl != null) {
                                dataSrc = posterEl.attr("data-src");
                                if (StringsKt.isBlank(dataSrc)) {
                                    dataSrc = posterEl.attr("src");
                                }
                            } else {
                                dataSrc = null;
                            }
                            elementSelectFirst3 = doc.selectFirst("#w-info .synopsis .content, #w-info .synopsis, .synopsis .content");
                            if (elementSelectFirst3 != null) {
                                description = elementSelectFirst3.text();
                            } else {
                                description = null;
                            }
                            Iterable $this$map$iv = doc.select("#w-info a[href*='/genre/'], .meta a[href*='/genre/']");
                            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                Element it = (Element) item$iv$iv;
                                destination$iv$iv.add(StringsKt.trim(it.text()).toString());
                                posterEl = posterEl;
                            }
                            posterEl2 = posterEl;
                            genres = (List) destination$iv$iv;
                            if (doc.selectFirst("#w-info a[href*='/type/movie']") != null) {
                                i = 1;
                            } else {
                                elementSelectFirst6 = doc.selectFirst(".bmeta");
                                if (elementSelectFirst6 == null && (strText2 = elementSelectFirst6.text()) != null && StringsKt.contains(strText2, "Movie", true)) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    i = 1;
                                } else {
                                    i = 0;
                                }
                            }
                            i2 = i;
                            elementSelectFirst4 = doc.selectFirst("#watch-main");
                            if (elementSelectFirst4 != null || (strAttr = elementSelectFirst4.attr("data-id")) == null) {
                                elementSelectFirst5 = doc.selectFirst("[data-id]");
                                if (elementSelectFirst5 != null) {
                                    strAttr = elementSelectFirst5.attr("data-id");
                                } else {
                                    strAttr = null;
                                }
                                if (strAttr == null) {
                                    matchResultFind$default = Regex.find$default(new Regex("data-id=[\"'](\\d+)[\"']"), doc.html(), 0, 2, (Object) null);
                                    if (matchResultFind$default != null || (groupValues = matchResultFind$default.getGroupValues()) == null) {
                                        strAttr = null;
                                    } else {
                                        strAttr = (String) groupValues.get(1);
                                    }
                                }
                            }
                            animeId = strAttr;
                            subEpisodes = new ArrayList();
                            dubEpisodes = new ArrayList();
                            if (animeId != null) {
                                try {
                                    Requests app2 = MainActivityKt.getApp();
                                    String str4 = getMainUrl() + "/ajax/episode/list/" + animeId;
                                    Map<String, String> mapAjaxHeaders = ajaxHeaders(url2);
                                    c00013.L$0 = url2;
                                    try {
                                        c00013.L$1 = SpillingKt.nullOutSpilledVariable(response);
                                        c00013.L$2 = doc;
                                        c00013.L$3 = title;
                                        c00013.L$4 = SpillingKt.nullOutSpilledVariable(posterEl2);
                                        c00013.L$5 = dataSrc;
                                        c00013.L$6 = description;
                                        c00013.L$7 = genres;
                                        c00013.L$8 = SpillingKt.nullOutSpilledVariable(animeId);
                                        c00013.L$9 = subEpisodes;
                                        c00013.L$10 = dubEpisodes;
                                        c00013.I$0 = i2;
                                        c00013.label = 2;
                                        description3 = description;
                                        c00012 = c00013;
                                        poster2 = dataSrc;
                                        try {
                                            obj3 = Requests.get$default(app2, str4, mapAjaxHeaders, url2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4088, (Object) null);
                                            c00013 = c00012;
                                            if (obj3 == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            response2 = response;
                                            dubEpisodes2 = genres;
                                            url3 = url2;
                                            posterEl3 = posterEl2;
                                            description2 = animeId;
                                            poster = poster2;
                                            url4 = description3;
                                            dubEpisodes3 = dubEpisodes;
                                            try {
                                                json = ((NiceResponse) obj3).getText();
                                                String html = jsonResultString(json);
                                                obj2 = coroutine_suspended;
                                                try {
                                                    i4 = i2;
                                                    try {
                                                        $this$forEach$iv = Jsoup.parse(html).select("a[data-ids]");
                                                        $i$f$forEach = 0;
                                                        for (Object element$iv : $this$forEach$iv) {
                                                            el = (Element) element$iv;
                                                            Iterable $this$forEach$iv2 = $this$forEach$iv;
                                                            int $i$f$forEach2 = $i$f$forEach;
                                                            serverIds = el.attr("data-ids");
                                                            doc3 = doc;
                                                            try {
                                                                episodeNumber = StringsKt.toIntOrNull(el.attr("data-num"));
                                                                hasSub = Intrinsics.areEqual(el.attr("data-sub"), str3);
                                                                hasDub = Intrinsics.areEqual(el.attr("data-dub"), str3);
                                                                if (StringsKt.isBlank(serverIds)) {
                                                                    str = str3;
                                                                    title = title;
                                                                    json = json;
                                                                } else {
                                                                    str = str3;
                                                                    elementSelectFirst7 = el.selectFirst(".d-title");
                                                                    if (elementSelectFirst7 != null) {
                                                                        try {
                                                                            strText4 = elementSelectFirst7.text();
                                                                            if (strText4 != null) {
                                                                                str2 = strText4;
                                                                                if (StringsKt.isBlank(str2)) {
                                                                                    str2 = null;
                                                                                }
                                                                                episodeName = str2;
                                                                                if (episodeName == null) {
                                                                                    strAttr2 = el.attr("data-jp");
                                                                                    if (StringsKt.isBlank(strAttr2)) {
                                                                                        StringBuilder sbAppend = new StringBuilder().append("Episode ");
                                                                                        if (episodeNumber == null) {
                                                                                            obj5 = "";
                                                                                        } else {
                                                                                            obj5 = episodeNumber;
                                                                                        }
                                                                                        strAttr2 = sbAppend.append(obj5).toString();
                                                                                    }
                                                                                    episodeName = strAttr2;
                                                                                }
                                                                            } else {
                                                                                strAttr2 = el.attr("data-jp");
                                                                                if (StringsKt.isBlank(strAttr2)) {
                                                                                    StringBuilder sbAppend2 = new StringBuilder().append("Episode ");
                                                                                    if (episodeNumber == null) {
                                                                                        obj5 = "";
                                                                                    } else {
                                                                                        obj5 = episodeNumber;
                                                                                    }
                                                                                    strAttr2 = sbAppend2.append(obj5).toString();
                                                                                }
                                                                                episodeName = strAttr2;
                                                                            }
                                                                        } catch (Exception e) {
                                                                            i2 = i4;
                                                                            subEpisodes2 = subEpisodes;
                                                                            doc = doc3;
                                                                            List list = subEpisodes2;
                                                                            doc2 = doc;
                                                                            subEpisodes3 = list;
                                                                            i3 = i2;
                                                                            animeId2 = description2;
                                                                            genres2 = dubEpisodes2;
                                                                            description4 = url4;
                                                                            posterEl2 = posterEl3;
                                                                            response3 = response2;
                                                                            url5 = url3;
                                                                            animeId3 = title;
                                                                            url6 = poster;
                                                                            if (subEpisodes3.isEmpty()) {
                                                                                poster3 = url6;
                                                                                description5 = description4;
                                                                                genres3 = genres2;
                                                                            } else {
                                                                                poster3 = url6;
                                                                                description5 = description4;
                                                                                genres3 = genres2;
                                                                            }
                                                                            Document doc4 = doc2;
                                                                            AnikotoProvider anikotoProvider = this;
                                                                            if (i3 != 0) {
                                                                                tvType = TvType.AnimeMovie;
                                                                            } else {
                                                                                tvType = TvType.Anime;
                                                                            }
                                                                            String poster4 = poster3;
                                                                            String description6 = description5;
                                                                            List genres4 = genres3;
                                                                            C00024 c00024 = new C00024(poster4, description6, genres4, subEpisodes3, dubEpisodes3, this, null);
                                                                            c00013.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                                                                            c00013.L$1 = SpillingKt.nullOutSpilledVariable(response3);
                                                                            c00013.L$2 = SpillingKt.nullOutSpilledVariable(doc4);
                                                                            c00013.L$3 = SpillingKt.nullOutSpilledVariable(animeId3);
                                                                            c00013.L$4 = SpillingKt.nullOutSpilledVariable(posterEl2);
                                                                            c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster4);
                                                                            c00013.L$6 = SpillingKt.nullOutSpilledVariable(description6);
                                                                            c00013.L$7 = SpillingKt.nullOutSpilledVariable(genres4);
                                                                            c00013.L$8 = SpillingKt.nullOutSpilledVariable(animeId2);
                                                                            c00013.L$9 = SpillingKt.nullOutSpilledVariable(subEpisodes3);
                                                                            c00013.L$10 = SpillingKt.nullOutSpilledVariable(dubEpisodes3);
                                                                            c00013.I$0 = i3;
                                                                            c00013.label = 3;
                                                                            obj4 = obj2;
                                                                            objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(anikotoProvider, animeId3, url5, tvType, false, c00024, c00013, 8, (Object) null);
                                                                            if (objNewAnimeLoadResponse$default == obj4) {
                                                                                return obj4;
                                                                            }
                                                                            return objNewAnimeLoadResponse$default;
                                                                        }
                                                                    } else {
                                                                        strAttr2 = el.attr("data-jp");
                                                                        if (StringsKt.isBlank(strAttr2)) {
                                                                            StringBuilder sbAppend3 = new StringBuilder().append("Episode ");
                                                                            if (episodeNumber == null) {
                                                                                obj5 = "";
                                                                            } else {
                                                                                obj5 = episodeNumber;
                                                                            }
                                                                            strAttr2 = sbAppend3.append(obj5).toString();
                                                                        }
                                                                        episodeName = strAttr2;
                                                                    }
                                                                    if (hasSub || !hasDub) {
                                                                        subEpisodes.add(MainAPIKt.newEpisode(this, "anikoto|" + url3 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.AnikotoProvider$$ExternalSyntheticLambda0
                                                                            public final Object invoke(Object obj6) {
                                                                                return AnikotoProvider.load$lambda$2$2(episodeNumber, episodeName, (Episode) obj6);
                                                                            }
                                                                        }));
                                                                    }
                                                                    if (hasDub) {
                                                                        try {
                                                                            dubEpisodes3.add(MainAPIKt.newEpisode(this, "anikoto|" + url3 + '|' + serverIds + "|dub", new Function1() { // from class: com.anikoto.AnikotoProvider$$ExternalSyntheticLambda1
                                                                                public final Object invoke(Object obj6) {
                                                                                    return AnikotoProvider.load$lambda$2$3(episodeNumber, episodeName, (Episode) obj6);
                                                                                }
                                                                            }));
                                                                        } catch (Exception e2) {
                                                                            i2 = i4;
                                                                            subEpisodes2 = subEpisodes;
                                                                            doc = doc3;
                                                                            title = title;
                                                                            List list2 = subEpisodes2;
                                                                            doc2 = doc;
                                                                            subEpisodes3 = list2;
                                                                            i3 = i2;
                                                                            animeId2 = description2;
                                                                            genres2 = dubEpisodes2;
                                                                            description4 = url4;
                                                                            posterEl2 = posterEl3;
                                                                            response3 = response2;
                                                                            url5 = url3;
                                                                            animeId3 = title;
                                                                            url6 = poster;
                                                                            if (subEpisodes3.isEmpty()) {
                                                                                poster3 = url6;
                                                                                description5 = description4;
                                                                                genres3 = genres2;
                                                                            } else {
                                                                                poster3 = url6;
                                                                                description5 = description4;
                                                                                genres3 = genres2;
                                                                            }
                                                                            Document doc5 = doc2;
                                                                            AnikotoProvider anikotoProvider2 = this;
                                                                            if (i3 != 0) {
                                                                                tvType = TvType.AnimeMovie;
                                                                            } else {
                                                                                tvType = TvType.Anime;
                                                                            }
                                                                            String poster5 = poster3;
                                                                            String description7 = description5;
                                                                            List genres5 = genres3;
                                                                            C00024 c00025 = new C00024(poster5, description7, genres5, subEpisodes3, dubEpisodes3, this, null);
                                                                            c00013.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                                                                            c00013.L$1 = SpillingKt.nullOutSpilledVariable(response3);
                                                                            c00013.L$2 = SpillingKt.nullOutSpilledVariable(doc5);
                                                                            c00013.L$3 = SpillingKt.nullOutSpilledVariable(animeId3);
                                                                            c00013.L$4 = SpillingKt.nullOutSpilledVariable(posterEl2);
                                                                            c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster5);
                                                                            c00013.L$6 = SpillingKt.nullOutSpilledVariable(description7);
                                                                            c00013.L$7 = SpillingKt.nullOutSpilledVariable(genres5);
                                                                            c00013.L$8 = SpillingKt.nullOutSpilledVariable(animeId2);
                                                                            c00013.L$9 = SpillingKt.nullOutSpilledVariable(subEpisodes3);
                                                                            c00013.L$10 = SpillingKt.nullOutSpilledVariable(dubEpisodes3);
                                                                            c00013.I$0 = i3;
                                                                            c00013.label = 3;
                                                                            obj4 = obj2;
                                                                            objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(anikotoProvider2, animeId3, url5, tvType, false, c00025, c00013, 8, (Object) null);
                                                                            if (objNewAnimeLoadResponse$default == obj4) {
                                                                                return obj4;
                                                                            }
                                                                            return objNewAnimeLoadResponse$default;
                                                                        }
                                                                    } else {
                                                                        continue;
                                                                    }
                                                                }
                                                                doc = doc3;
                                                                $this$forEach$iv = $this$forEach$iv2;
                                                                $i$f$forEach = $i$f$forEach2;
                                                                title = title;
                                                                str3 = str;
                                                                json = json;
                                                            } catch (Exception e3) {
                                                                i2 = i4;
                                                                subEpisodes2 = subEpisodes;
                                                                doc = doc3;
                                                            }
                                                        }
                                                        Document doc6 = doc;
                                                        subEpisodes3 = subEpisodes;
                                                        animeId2 = description2;
                                                        genres2 = dubEpisodes2;
                                                        description4 = url4;
                                                        posterEl2 = posterEl3;
                                                        response3 = response2;
                                                        doc2 = doc6;
                                                        animeId3 = title;
                                                        i3 = i4;
                                                        url5 = url3;
                                                        url6 = poster;
                                                    } catch (Exception e4) {
                                                        i2 = i4;
                                                        subEpisodes2 = subEpisodes;
                                                    }
                                                } catch (Exception e5) {
                                                    subEpisodes2 = subEpisodes;
                                                    List list3 = subEpisodes2;
                                                    doc2 = doc;
                                                    subEpisodes3 = list3;
                                                    i3 = i2;
                                                    animeId2 = description2;
                                                    genres2 = dubEpisodes2;
                                                    description4 = url4;
                                                    posterEl2 = posterEl3;
                                                    response3 = response2;
                                                    url5 = url3;
                                                    animeId3 = title;
                                                    url6 = poster;
                                                    if (subEpisodes3.isEmpty()) {
                                                        poster3 = url6;
                                                        description5 = description4;
                                                        genres3 = genres2;
                                                    } else {
                                                        poster3 = url6;
                                                        description5 = description4;
                                                        genres3 = genres2;
                                                    }
                                                    Document doc7 = doc2;
                                                    AnikotoProvider anikotoProvider3 = this;
                                                    if (i3 != 0) {
                                                        tvType = TvType.AnimeMovie;
                                                    } else {
                                                        tvType = TvType.Anime;
                                                    }
                                                    String poster6 = poster3;
                                                    String description8 = description5;
                                                    List genres6 = genres3;
                                                    C00024 c00026 = new C00024(poster6, description8, genres6, subEpisodes3, dubEpisodes3, this, null);
                                                    c00013.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                                                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(response3);
                                                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(doc7);
                                                    c00013.L$3 = SpillingKt.nullOutSpilledVariable(animeId3);
                                                    c00013.L$4 = SpillingKt.nullOutSpilledVariable(posterEl2);
                                                    c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster6);
                                                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(description8);
                                                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(genres6);
                                                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(animeId2);
                                                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(subEpisodes3);
                                                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(dubEpisodes3);
                                                    c00013.I$0 = i3;
                                                    c00013.label = 3;
                                                    obj4 = obj2;
                                                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(anikotoProvider3, animeId3, url5, tvType, false, c00026, c00013, 8, (Object) null);
                                                    if (objNewAnimeLoadResponse$default == obj4) {
                                                        return obj4;
                                                    }
                                                    return objNewAnimeLoadResponse$default;
                                                }
                                            } catch (Exception e6) {
                                                obj2 = coroutine_suspended;
                                            }
                                        } catch (Exception e7) {
                                            obj2 = coroutine_suspended;
                                            c00013 = c00012;
                                            response2 = response;
                                            dubEpisodes2 = genres;
                                            subEpisodes2 = subEpisodes;
                                            url3 = url2;
                                            posterEl3 = posterEl2;
                                            description2 = animeId;
                                            poster = poster2;
                                            url4 = description3;
                                            dubEpisodes3 = dubEpisodes;
                                            List list4 = subEpisodes2;
                                            doc2 = doc;
                                            subEpisodes3 = list4;
                                            i3 = i2;
                                            animeId2 = description2;
                                            genres2 = dubEpisodes2;
                                            description4 = url4;
                                            posterEl2 = posterEl3;
                                            response3 = response2;
                                            url5 = url3;
                                            animeId3 = title;
                                            url6 = poster;
                                            if (subEpisodes3.isEmpty()) {
                                                poster3 = url6;
                                                description5 = description4;
                                                genres3 = genres2;
                                            } else {
                                                poster3 = url6;
                                                description5 = description4;
                                                genres3 = genres2;
                                            }
                                            Document doc8 = doc2;
                                            AnikotoProvider anikotoProvider4 = this;
                                            if (i3 != 0) {
                                                tvType = TvType.AnimeMovie;
                                            } else {
                                                tvType = TvType.Anime;
                                            }
                                            String poster7 = poster3;
                                            String description9 = description5;
                                            List genres7 = genres3;
                                            C00024 c00027 = new C00024(poster7, description9, genres7, subEpisodes3, dubEpisodes3, this, null);
                                            c00013.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                                            c00013.L$1 = SpillingKt.nullOutSpilledVariable(response3);
                                            c00013.L$2 = SpillingKt.nullOutSpilledVariable(doc8);
                                            c00013.L$3 = SpillingKt.nullOutSpilledVariable(animeId3);
                                            c00013.L$4 = SpillingKt.nullOutSpilledVariable(posterEl2);
                                            c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster7);
                                            c00013.L$6 = SpillingKt.nullOutSpilledVariable(description9);
                                            c00013.L$7 = SpillingKt.nullOutSpilledVariable(genres7);
                                            c00013.L$8 = SpillingKt.nullOutSpilledVariable(animeId2);
                                            c00013.L$9 = SpillingKt.nullOutSpilledVariable(subEpisodes3);
                                            c00013.L$10 = SpillingKt.nullOutSpilledVariable(dubEpisodes3);
                                            c00013.I$0 = i3;
                                            c00013.label = 3;
                                            obj4 = obj2;
                                            objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(anikotoProvider4, animeId3, url5, tvType, false, c00027, c00013, 8, (Object) null);
                                            if (objNewAnimeLoadResponse$default == obj4) {
                                                return obj4;
                                            }
                                            return objNewAnimeLoadResponse$default;
                                        }
                                    } catch (Exception e8) {
                                        obj2 = coroutine_suspended;
                                        String str5 = dataSrc;
                                        String str6 = description;
                                        response2 = response;
                                        dubEpisodes2 = genres;
                                        subEpisodes2 = subEpisodes;
                                        url3 = url2;
                                        posterEl3 = posterEl2;
                                        description2 = animeId;
                                        poster = str5;
                                        url4 = str6;
                                        dubEpisodes3 = dubEpisodes;
                                    }
                                } catch (Exception e9) {
                                    obj2 = coroutine_suspended;
                                    String str7 = dataSrc;
                                    String animeId4 = description;
                                    response2 = response;
                                    dubEpisodes2 = genres;
                                    subEpisodes2 = subEpisodes;
                                    url3 = url2;
                                    posterEl3 = posterEl2;
                                    description2 = animeId;
                                    poster = str7;
                                    url4 = animeId4;
                                    dubEpisodes3 = dubEpisodes;
                                }
                            } else {
                                obj2 = coroutine_suspended;
                                animeId2 = animeId;
                                String poster8 = dataSrc;
                                response3 = response;
                                doc2 = doc;
                                description4 = description;
                                animeId3 = title;
                                subEpisodes3 = subEpisodes;
                                url5 = url2;
                                dubEpisodes3 = dubEpisodes;
                                i3 = i2;
                                genres2 = genres;
                                url6 = poster8;
                            }
                            if (subEpisodes3.isEmpty() || !dubEpisodes3.isEmpty()) {
                                poster3 = url6;
                                description5 = description4;
                                genres3 = genres2;
                            } else {
                                Iterable $this$mapIndexed$iv = doc2.select("a[href*='/ep-']");
                                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                                final int index$iv$iv = 0;
                                for (Object item$iv$iv2 : $this$mapIndexed$iv) {
                                    int index$iv$iv2 = index$iv$iv + 1;
                                    if (index$iv$iv < 0) {
                                        CollectionsKt.throwIndexOverflow();
                                    }
                                    Iterable $this$mapIndexed$iv2 = $this$mapIndexed$iv;
                                    final Element el2 = (Element) item$iv$iv2;
                                    String poster9 = url6;
                                    destination$iv$iv2.add(Boxing.boxBoolean(subEpisodes3.add(MainAPIKt.newEpisode(this, MainAPIKt.fixUrl(this, el2.attr("href")), new Function1() { // from class: com.anikoto.AnikotoProvider$$ExternalSyntheticLambda2
                                        public final Object invoke(Object obj6) {
                                            return AnikotoProvider.load$lambda$3$0(index$iv$iv, el2, (Episode) obj6);
                                        }
                                    }))));
                                    $this$mapIndexed$iv = $this$mapIndexed$iv2;
                                    index$iv$iv = index$iv$iv2;
                                    url6 = poster9;
                                    description4 = description4;
                                    genres2 = genres2;
                                }
                                poster3 = url6;
                                description5 = description4;
                                genres3 = genres2;
                            }
                            Document doc9 = doc2;
                            AnikotoProvider anikotoProvider5 = this;
                            if (i3 != 0) {
                                tvType = TvType.AnimeMovie;
                            } else {
                                tvType = TvType.Anime;
                            }
                            String poster10 = poster3;
                            String description10 = description5;
                            List genres8 = genres3;
                            C00024 c00028 = new C00024(poster10, description10, genres8, subEpisodes3, dubEpisodes3, this, null);
                            c00013.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                            c00013.L$1 = SpillingKt.nullOutSpilledVariable(response3);
                            c00013.L$2 = SpillingKt.nullOutSpilledVariable(doc9);
                            c00013.L$3 = SpillingKt.nullOutSpilledVariable(animeId3);
                            c00013.L$4 = SpillingKt.nullOutSpilledVariable(posterEl2);
                            c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster10);
                            c00013.L$6 = SpillingKt.nullOutSpilledVariable(description10);
                            c00013.L$7 = SpillingKt.nullOutSpilledVariable(genres8);
                            c00013.L$8 = SpillingKt.nullOutSpilledVariable(animeId2);
                            c00013.L$9 = SpillingKt.nullOutSpilledVariable(subEpisodes3);
                            c00013.L$10 = SpillingKt.nullOutSpilledVariable(dubEpisodes3);
                            c00013.I$0 = i3;
                            c00013.label = 3;
                            obj4 = obj2;
                            objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(anikotoProvider5, animeId3, url5, tvType, false, c00028, c00013, 8, (Object) null);
                            if (objNewAnimeLoadResponse$default == obj4) {
                                return obj4;
                            }
                            return objNewAnimeLoadResponse$default;
                        } catch (Exception e10) {
                            return null;
                        }
                    } catch (Exception e11) {
                        return null;
                    }
                } catch (Exception e12) {
                    return null;
                }
            case 1:
                String url7 = (String) c00013.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    url2 = url7;
                    obj = $result;
                    response = (NiceResponse) obj;
                    doc = response.getDocument();
                    elementSelectFirst = doc.selectFirst("#w-info h1.title, h1[itemprop=name], .title[itemprop=name]");
                    if (elementSelectFirst != null) {
                        elementSelectFirst2 = doc.selectFirst("h1.title");
                        if (elementSelectFirst2 != null) {
                            break;
                        }
                        return null;
                    }
                    elementSelectFirst2 = doc.selectFirst("h1.title");
                    if (elementSelectFirst2 != null) {
                        break;
                    }
                    return null;
                    title = string;
                    posterEl = doc.selectFirst("#w-info .poster img, img[itemprop=image], .poster img");
                    if (posterEl != null) {
                        dataSrc = posterEl.attr("data-src");
                        if (StringsKt.isBlank(dataSrc)) {
                            dataSrc = posterEl.attr("src");
                        }
                    } else {
                        dataSrc = null;
                    }
                    elementSelectFirst3 = doc.selectFirst("#w-info .synopsis .content, #w-info .synopsis, .synopsis .content");
                    if (elementSelectFirst3 != null) {
                        description = elementSelectFirst3.text();
                    } else {
                        description = null;
                    }
                    Iterable $this$map$iv2 = doc.select("#w-info a[href*='/genre/'], .meta a[href*='/genre/']");
                    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    while (r17.hasNext()) {
                        Element it2 = (Element) item$iv$iv;
                        destination$iv$iv.add(StringsKt.trim(it2.text()).toString());
                        posterEl = posterEl;
                    }
                    posterEl2 = posterEl;
                    genres = (List) destination$iv$iv;
                    if (doc.selectFirst("#w-info a[href*='/type/movie']") != null) {
                        i = 1;
                    } else {
                        elementSelectFirst6 = doc.selectFirst(".bmeta");
                        if (elementSelectFirst6 == null) {
                            z = false;
                        } else {
                            z = false;
                        }
                        if (z) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                    }
                    i2 = i;
                    elementSelectFirst4 = doc.selectFirst("#watch-main");
                    if (elementSelectFirst4 != null) {
                        elementSelectFirst5 = doc.selectFirst("[data-id]");
                        if (elementSelectFirst5 != null) {
                            strAttr = elementSelectFirst5.attr("data-id");
                        } else {
                            strAttr = null;
                        }
                        if (strAttr == null) {
                            matchResultFind$default = Regex.find$default(new Regex("data-id=[\"'](\\d+)[\"']"), doc.html(), 0, 2, (Object) null);
                            if (matchResultFind$default != null) {
                                strAttr = null;
                            } else {
                                strAttr = null;
                            }
                        }
                    } else {
                        elementSelectFirst5 = doc.selectFirst("[data-id]");
                        if (elementSelectFirst5 != null) {
                            strAttr = elementSelectFirst5.attr("data-id");
                        } else {
                            strAttr = null;
                        }
                        if (strAttr == null) {
                            matchResultFind$default = Regex.find$default(new Regex("data-id=[\"'](\\d+)[\"']"), doc.html(), 0, 2, (Object) null);
                            if (matchResultFind$default != null) {
                                strAttr = null;
                            } else {
                                strAttr = null;
                            }
                        }
                    }
                    animeId = strAttr;
                    subEpisodes = new ArrayList();
                    dubEpisodes = new ArrayList();
                    if (animeId != null) {
                        Requests app3 = MainActivityKt.getApp();
                        String str8 = getMainUrl() + "/ajax/episode/list/" + animeId;
                        Map<String, String> mapAjaxHeaders2 = ajaxHeaders(url2);
                        c00013.L$0 = url2;
                        c00013.L$1 = SpillingKt.nullOutSpilledVariable(response);
                        c00013.L$2 = doc;
                        c00013.L$3 = title;
                        c00013.L$4 = SpillingKt.nullOutSpilledVariable(posterEl2);
                        c00013.L$5 = dataSrc;
                        c00013.L$6 = description;
                        c00013.L$7 = genres;
                        c00013.L$8 = SpillingKt.nullOutSpilledVariable(animeId);
                        c00013.L$9 = subEpisodes;
                        c00013.L$10 = dubEpisodes;
                        c00013.I$0 = i2;
                        c00013.label = 2;
                        description3 = description;
                        c00012 = c00013;
                        poster2 = dataSrc;
                        obj3 = Requests.get$default(app3, str8, mapAjaxHeaders2, url2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4088, (Object) null);
                        c00013 = c00012;
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        response2 = response;
                        dubEpisodes2 = genres;
                        url3 = url2;
                        posterEl3 = posterEl2;
                        description2 = animeId;
                        poster = poster2;
                        url4 = description3;
                        dubEpisodes3 = dubEpisodes;
                        json = ((NiceResponse) obj3).getText();
                        String html2 = jsonResultString(json);
                        obj2 = coroutine_suspended;
                        i4 = i2;
                        $this$forEach$iv = Jsoup.parse(html2).select("a[data-ids]");
                        $i$f$forEach = 0;
                        while (r19.hasNext()) {
                            el = (Element) element$iv;
                            Iterable $this$forEach$iv3 = $this$forEach$iv;
                            int $i$f$forEach3 = $i$f$forEach;
                            serverIds = el.attr("data-ids");
                            doc3 = doc;
                            episodeNumber = StringsKt.toIntOrNull(el.attr("data-num"));
                            hasSub = Intrinsics.areEqual(el.attr("data-sub"), str3);
                            hasDub = Intrinsics.areEqual(el.attr("data-dub"), str3);
                            if (StringsKt.isBlank(serverIds)) {
                                str = str3;
                                elementSelectFirst7 = el.selectFirst(".d-title");
                                if (elementSelectFirst7 != null) {
                                    strText4 = elementSelectFirst7.text();
                                    if (strText4 != null) {
                                        str2 = strText4;
                                        if (StringsKt.isBlank(str2)) {
                                            str2 = null;
                                        }
                                        episodeName = str2;
                                        if (episodeName == null) {
                                            strAttr2 = el.attr("data-jp");
                                            if (StringsKt.isBlank(strAttr2)) {
                                                StringBuilder sbAppend4 = new StringBuilder().append("Episode ");
                                                if (episodeNumber == null) {
                                                    obj5 = "";
                                                } else {
                                                    obj5 = episodeNumber;
                                                }
                                                strAttr2 = sbAppend4.append(obj5).toString();
                                            }
                                            episodeName = strAttr2;
                                        }
                                    } else {
                                        strAttr2 = el.attr("data-jp");
                                        if (StringsKt.isBlank(strAttr2)) {
                                            StringBuilder sbAppend5 = new StringBuilder().append("Episode ");
                                            if (episodeNumber == null) {
                                                obj5 = "";
                                            } else {
                                                obj5 = episodeNumber;
                                            }
                                            strAttr2 = sbAppend5.append(obj5).toString();
                                        }
                                        episodeName = strAttr2;
                                    }
                                } else {
                                    strAttr2 = el.attr("data-jp");
                                    if (StringsKt.isBlank(strAttr2)) {
                                        StringBuilder sbAppend6 = new StringBuilder().append("Episode ");
                                        if (episodeNumber == null) {
                                            obj5 = "";
                                        } else {
                                            obj5 = episodeNumber;
                                        }
                                        strAttr2 = sbAppend6.append(obj5).toString();
                                    }
                                    episodeName = strAttr2;
                                }
                                if (hasSub) {
                                    subEpisodes.add(MainAPIKt.newEpisode(this, "anikoto|" + url3 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.AnikotoProvider$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj6) {
                                            return AnikotoProvider.load$lambda$2$2(episodeNumber, episodeName, (Episode) obj6);
                                        }
                                    }));
                                } else {
                                    subEpisodes.add(MainAPIKt.newEpisode(this, "anikoto|" + url3 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.AnikotoProvider$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj6) {
                                            return AnikotoProvider.load$lambda$2$2(episodeNumber, episodeName, (Episode) obj6);
                                        }
                                    }));
                                }
                                if (hasDub) {
                                    dubEpisodes3.add(MainAPIKt.newEpisode(this, "anikoto|" + url3 + '|' + serverIds + "|dub", new Function1() { // from class: com.anikoto.AnikotoProvider$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj6) {
                                            return AnikotoProvider.load$lambda$2$3(episodeNumber, episodeName, (Episode) obj6);
                                        }
                                    }));
                                } else {
                                    continue;
                                }
                            } else {
                                str = str3;
                                title = title;
                                json = json;
                            }
                            doc = doc3;
                            $this$forEach$iv = $this$forEach$iv3;
                            $i$f$forEach = $i$f$forEach3;
                            title = title;
                            str3 = str;
                            json = json;
                        }
                        Document doc10 = doc;
                        subEpisodes3 = subEpisodes;
                        animeId2 = description2;
                        genres2 = dubEpisodes2;
                        description4 = url4;
                        posterEl2 = posterEl3;
                        response3 = response2;
                        doc2 = doc10;
                        animeId3 = title;
                        i3 = i4;
                        url5 = url3;
                        url6 = poster;
                    } else {
                        obj2 = coroutine_suspended;
                        animeId2 = animeId;
                        String poster11 = dataSrc;
                        response3 = response;
                        doc2 = doc;
                        description4 = description;
                        animeId3 = title;
                        subEpisodes3 = subEpisodes;
                        url5 = url2;
                        dubEpisodes3 = dubEpisodes;
                        i3 = i2;
                        genres2 = genres;
                        url6 = poster11;
                    }
                    if (subEpisodes3.isEmpty()) {
                        poster3 = url6;
                        description5 = description4;
                        genres3 = genres2;
                    } else {
                        poster3 = url6;
                        description5 = description4;
                        genres3 = genres2;
                    }
                    Document doc11 = doc2;
                    AnikotoProvider anikotoProvider6 = this;
                    if (i3 != 0) {
                        tvType = TvType.AnimeMovie;
                    } else {
                        tvType = TvType.Anime;
                    }
                    String poster12 = poster3;
                    String description11 = description5;
                    List genres9 = genres3;
                    C00024 c00029 = new C00024(poster12, description11, genres9, subEpisodes3, dubEpisodes3, this, null);
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(response3);
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(doc11);
                    c00013.L$3 = SpillingKt.nullOutSpilledVariable(animeId3);
                    c00013.L$4 = SpillingKt.nullOutSpilledVariable(posterEl2);
                    c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster12);
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(description11);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(genres9);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(animeId2);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(subEpisodes3);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(dubEpisodes3);
                    c00013.I$0 = i3;
                    c00013.label = 3;
                    obj4 = obj2;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(anikotoProvider6, animeId3, url5, tvType, false, c00029, c00013, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj4) {
                        return obj4;
                    }
                    return objNewAnimeLoadResponse$default;
                } catch (Exception e13) {
                    return null;
                }
            case 2:
                i2 = c00013.I$0;
                dubEpisodes3 = (List) c00013.L$10;
                subEpisodes2 = (List) c00013.L$9;
                description2 = (String) c00013.L$8;
                dubEpisodes2 = (List) c00013.L$7;
                url4 = (String) c00013.L$6;
                poster = (String) c00013.L$5;
                posterEl3 = (Element) c00013.L$4;
                title = (String) c00013.L$3;
                doc = (Document) c00013.L$2;
                response2 = (NiceResponse) c00013.L$1;
                url3 = (String) c00013.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    subEpisodes = subEpisodes2;
                    obj3 = $result;
                    json = ((NiceResponse) obj3).getText();
                    String html3 = jsonResultString(json);
                    obj2 = coroutine_suspended;
                    i4 = i2;
                    $this$forEach$iv = Jsoup.parse(html3).select("a[data-ids]");
                    $i$f$forEach = 0;
                    while (r19.hasNext()) {
                        el = (Element) element$iv;
                        Iterable $this$forEach$iv4 = $this$forEach$iv;
                        int $i$f$forEach4 = $i$f$forEach;
                        serverIds = el.attr("data-ids");
                        doc3 = doc;
                        episodeNumber = StringsKt.toIntOrNull(el.attr("data-num"));
                        hasSub = Intrinsics.areEqual(el.attr("data-sub"), str3);
                        hasDub = Intrinsics.areEqual(el.attr("data-dub"), str3);
                        if (StringsKt.isBlank(serverIds)) {
                            str = str3;
                            elementSelectFirst7 = el.selectFirst(".d-title");
                            if (elementSelectFirst7 != null) {
                                strText4 = elementSelectFirst7.text();
                                if (strText4 != null) {
                                    str2 = strText4;
                                    if (StringsKt.isBlank(str2)) {
                                        str2 = null;
                                    }
                                    episodeName = str2;
                                    if (episodeName == null) {
                                        strAttr2 = el.attr("data-jp");
                                        if (StringsKt.isBlank(strAttr2)) {
                                            StringBuilder sbAppend7 = new StringBuilder().append("Episode ");
                                            if (episodeNumber == null) {
                                                obj5 = "";
                                            } else {
                                                obj5 = episodeNumber;
                                            }
                                            strAttr2 = sbAppend7.append(obj5).toString();
                                        }
                                        episodeName = strAttr2;
                                    }
                                } else {
                                    strAttr2 = el.attr("data-jp");
                                    if (StringsKt.isBlank(strAttr2)) {
                                        StringBuilder sbAppend8 = new StringBuilder().append("Episode ");
                                        if (episodeNumber == null) {
                                            obj5 = "";
                                        } else {
                                            obj5 = episodeNumber;
                                        }
                                        strAttr2 = sbAppend8.append(obj5).toString();
                                    }
                                    episodeName = strAttr2;
                                }
                            } else {
                                strAttr2 = el.attr("data-jp");
                                if (StringsKt.isBlank(strAttr2)) {
                                    StringBuilder sbAppend9 = new StringBuilder().append("Episode ");
                                    if (episodeNumber == null) {
                                        obj5 = "";
                                    } else {
                                        obj5 = episodeNumber;
                                    }
                                    strAttr2 = sbAppend9.append(obj5).toString();
                                }
                                episodeName = strAttr2;
                            }
                            if (hasSub) {
                                subEpisodes.add(MainAPIKt.newEpisode(this, "anikoto|" + url3 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.AnikotoProvider$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj6) {
                                        return AnikotoProvider.load$lambda$2$2(episodeNumber, episodeName, (Episode) obj6);
                                    }
                                }));
                            } else {
                                subEpisodes.add(MainAPIKt.newEpisode(this, "anikoto|" + url3 + '|' + serverIds + "|sub", new Function1() { // from class: com.anikoto.AnikotoProvider$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj6) {
                                        return AnikotoProvider.load$lambda$2$2(episodeNumber, episodeName, (Episode) obj6);
                                    }
                                }));
                            }
                            if (hasDub) {
                                dubEpisodes3.add(MainAPIKt.newEpisode(this, "anikoto|" + url3 + '|' + serverIds + "|dub", new Function1() { // from class: com.anikoto.AnikotoProvider$$ExternalSyntheticLambda1
                                    public final Object invoke(Object obj6) {
                                        return AnikotoProvider.load$lambda$2$3(episodeNumber, episodeName, (Episode) obj6);
                                    }
                                }));
                            } else {
                                continue;
                            }
                        } else {
                            str = str3;
                            title = title;
                            json = json;
                        }
                        doc = doc3;
                        $this$forEach$iv = $this$forEach$iv4;
                        $i$f$forEach = $i$f$forEach4;
                        title = title;
                        str3 = str;
                        json = json;
                    }
                    Document doc12 = doc;
                    subEpisodes3 = subEpisodes;
                    animeId2 = description2;
                    genres2 = dubEpisodes2;
                    description4 = url4;
                    posterEl2 = posterEl3;
                    response3 = response2;
                    doc2 = doc12;
                    animeId3 = title;
                    i3 = i4;
                    url5 = url3;
                    url6 = poster;
                } catch (Exception e14) {
                    obj2 = coroutine_suspended;
                    List list5 = subEpisodes2;
                    doc2 = doc;
                    subEpisodes3 = list5;
                    i3 = i2;
                    animeId2 = description2;
                    genres2 = dubEpisodes2;
                    description4 = url4;
                    posterEl2 = posterEl3;
                    response3 = response2;
                    url5 = url3;
                    animeId3 = title;
                    url6 = poster;
                    if (subEpisodes3.isEmpty()) {
                        poster3 = url6;
                        description5 = description4;
                        genres3 = genres2;
                    } else {
                        poster3 = url6;
                        description5 = description4;
                        genres3 = genres2;
                    }
                    Document doc13 = doc2;
                    AnikotoProvider anikotoProvider7 = this;
                    if (i3 != 0) {
                        tvType = TvType.AnimeMovie;
                    } else {
                        tvType = TvType.Anime;
                    }
                    String poster13 = poster3;
                    String description12 = description5;
                    List genres10 = genres3;
                    C00024 c000210 = new C00024(poster13, description12, genres10, subEpisodes3, dubEpisodes3, this, null);
                    c00013.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                    c00013.L$1 = SpillingKt.nullOutSpilledVariable(response3);
                    c00013.L$2 = SpillingKt.nullOutSpilledVariable(doc13);
                    c00013.L$3 = SpillingKt.nullOutSpilledVariable(animeId3);
                    c00013.L$4 = SpillingKt.nullOutSpilledVariable(posterEl2);
                    c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster13);
                    c00013.L$6 = SpillingKt.nullOutSpilledVariable(description12);
                    c00013.L$7 = SpillingKt.nullOutSpilledVariable(genres10);
                    c00013.L$8 = SpillingKt.nullOutSpilledVariable(animeId2);
                    c00013.L$9 = SpillingKt.nullOutSpilledVariable(subEpisodes3);
                    c00013.L$10 = SpillingKt.nullOutSpilledVariable(dubEpisodes3);
                    c00013.I$0 = i3;
                    c00013.label = 3;
                    obj4 = obj2;
                    objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(anikotoProvider7, animeId3, url5, tvType, false, c000210, c00013, 8, (Object) null);
                    if (objNewAnimeLoadResponse$default == obj4) {
                        return obj4;
                    }
                    return objNewAnimeLoadResponse$default;
                }
                if (subEpisodes3.isEmpty()) {
                    poster3 = url6;
                    description5 = description4;
                    genres3 = genres2;
                } else {
                    poster3 = url6;
                    description5 = description4;
                    genres3 = genres2;
                }
                Document doc14 = doc2;
                AnikotoProvider anikotoProvider8 = this;
                if (i3 != 0) {
                    tvType = TvType.AnimeMovie;
                } else {
                    tvType = TvType.Anime;
                }
                String poster14 = poster3;
                String description13 = description5;
                List genres11 = genres3;
                C00024 c000211 = new C00024(poster14, description13, genres11, subEpisodes3, dubEpisodes3, this, null);
                c00013.L$0 = SpillingKt.nullOutSpilledVariable(url5);
                c00013.L$1 = SpillingKt.nullOutSpilledVariable(response3);
                c00013.L$2 = SpillingKt.nullOutSpilledVariable(doc14);
                c00013.L$3 = SpillingKt.nullOutSpilledVariable(animeId3);
                c00013.L$4 = SpillingKt.nullOutSpilledVariable(posterEl2);
                c00013.L$5 = SpillingKt.nullOutSpilledVariable(poster14);
                c00013.L$6 = SpillingKt.nullOutSpilledVariable(description13);
                c00013.L$7 = SpillingKt.nullOutSpilledVariable(genres11);
                c00013.L$8 = SpillingKt.nullOutSpilledVariable(animeId2);
                c00013.L$9 = SpillingKt.nullOutSpilledVariable(subEpisodes3);
                c00013.L$10 = SpillingKt.nullOutSpilledVariable(dubEpisodes3);
                c00013.I$0 = i3;
                c00013.label = 3;
                obj4 = obj2;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(anikotoProvider8, animeId3, url5, tvType, false, c000211, c00013, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == obj4) {
                    return obj4;
                }
                return objNewAnimeLoadResponse$default;
            case 3:
                int i5 = c00013.I$0;
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$2$2(Integer $episodeNumber, String $episodeName, Episode $this$newEpisode) {
        $this$newEpisode.setEpisode($episodeNumber);
        $this$newEpisode.setName($episodeName);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$2$3(Integer $episodeNumber, String $episodeName, Episode $this$newEpisode) {
        $this$newEpisode.setEpisode($episodeNumber);
        $this$newEpisode.setName($episodeName);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$3$0(int $i, Element $el, Episode $this$newEpisode) {
        $this$newEpisode.setEpisode(Integer.valueOf($i + 1));
        String strText = $el.text();
        if (StringsKt.isBlank(strText)) {
            strText = "Episode " + ($i + 1);
        }
        $this$newEpisode.setName(strText);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.anikoto.AnikotoProvider$load$4 */
    /* JADX INFO: compiled from: AnikotoProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.anikoto.AnikotoProvider$load$4", f = "AnikotoProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nAnikotoProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnikotoProvider.kt\ncom/anikoto/AnikotoProvider$load$4\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,769:1\n1#2:770\n*E\n"})
    static final class C00024 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ List<Episode> $dubEpisodes;
        final /* synthetic */ List<String> $genres;
        final /* synthetic */ String $poster;
        final /* synthetic */ List<Episode> $subEpisodes;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AnikotoProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00024(String str, String str2, List<String> list, List<Episode> list2, List<Episode> list3, AnikotoProvider anikotoProvider, Continuation<? super C00024> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$description = str2;
            this.$genres = list;
            this.$subEpisodes = list2;
            this.$dubEpisodes = list3;
            this.this$0 = anikotoProvider;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00024 = new C00024(this.$poster, this.$description, this.$genres, this.$subEpisodes, this.$dubEpisodes, this.this$0, continuation);
            c00024.L$0 = obj;
            return c00024;
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
                    String it = this.$poster;
                    $this$newAnimeLoadResponse.setPosterUrl(it != null ? MainAPIKt.fixUrl(this.this$0, it) : null);
                    $this$newAnimeLoadResponse.setPlot(this.$description);
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

    /* JADX WARN: Code duplicated, block: B:123:0x04f7  */
    /* JADX WARN: Code duplicated, block: B:134:0x05a2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:135:0x05a3  */
    /* JADX WARN: Code duplicated, block: B:138:0x05cd  */
    /* JADX WARN: Code duplicated, block: B:139:0x05d3 A[Catch: Exception -> 0x0706, TryCatch #12 {Exception -> 0x0706, blocks: (B:136:0x05c0, B:139:0x05d3, B:141:0x05dd), top: B:223:0x05c0 }] */
    /* JADX WARN: Code duplicated, block: B:141:0x05dd A[Catch: Exception -> 0x0706, TRY_LEAVE, TryCatch #12 {Exception -> 0x0706, blocks: (B:136:0x05c0, B:139:0x05d3, B:141:0x05dd), top: B:223:0x05c0 }] */
    /* JADX WARN: Code duplicated, block: B:147:0x064c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:148:0x064d  */
    /* JADX WARN: Code duplicated, block: B:151:0x0668  */
    /* JADX WARN: Code duplicated, block: B:152:0x0682  */
    /* JADX WARN: Code duplicated, block: B:159:0x06e3  */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0175: MOVE (r15 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY] A[D('linkIds' java.util.List)]), block:B:21:0x0172 */
    /* JADX WARN: Not initialized variable reg: 23, insn: 0x0176: MOVE (r7 I:??[OBJECT, ARRAY] A[D('$result' java.lang.Object)]) = (r23 I:??[OBJECT, ARRAY] A[D('serverListJson' java.lang.String)]), block:B:21:0x0172 */
    /* JADX WARN: Not initialized variable reg: 26, insn: 0x0178: MOVE (r17 I:??[OBJECT, ARRAY]) = (r26 I:??[OBJECT, ARRAY] A[D('referer' java.lang.String)]), block:B:21:0x0172 */
    /* JADX WARN: Not initialized variable reg: 28, insn: 0x017a: MOVE (r16 I:??[OBJECT, ARRAY]) = (r28 I:??[OBJECT, ARRAY] A[D('ep' java.lang.String)]), block:B:21:0x0172 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:148:0x064d -> B:219:0x0660). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:173:0x078e -> B:121:0x04f1). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r52, boolean r53, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r54, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r55, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r56) {
        /*
            Method dump skipped, instruction units count: 2168
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anikoto.AnikotoProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadLinks$lambda$0$0(Context $_ctx) {
        Toast.makeText($_ctx, "⚠️(Opening ads) Subscription expired. If you have renewed your subscription, please re-verify it in Subscription Manager.", 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:135:0x05a9 A[Catch: Exception -> 0x08b9, TRY_LEAVE, TryCatch #18 {Exception -> 0x08b9, blocks: (B:133:0x05a3, B:135:0x05a9), top: B:243:0x05a3 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x0667 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:150:0x0668  */
    /* JADX WARN: Code duplicated, block: B:153:0x069b  */
    /* JADX WARN: Code duplicated, block: B:154:0x06a2 A[Catch: Exception -> 0x07d9, TryCatch #17 {Exception -> 0x07d9, blocks: (B:151:0x068e, B:154:0x06a2, B:156:0x06ac), top: B:241:0x068e }] */
    /* JADX WARN: Code duplicated, block: B:156:0x06ac A[Catch: Exception -> 0x07d9, TRY_LEAVE, TryCatch #17 {Exception -> 0x07d9, blocks: (B:151:0x068e, B:154:0x06a2, B:156:0x06ac), top: B:241:0x068e }] */
    /* JADX WARN: Code duplicated, block: B:160:0x0728 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:161:0x0729  */
    /* JADX WARN: Code duplicated, block: B:164:0x0752  */
    /* JADX WARN: Code duplicated, block: B:165:0x0769  */
    /* JADX WARN: Code duplicated, block: B:170:0x07af  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x014f: MOVE (r0 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:19:0x014f */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x0150: MOVE (r16 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY] A[D('linkIds' java.util.List)]), block:B:19:0x014f */
    /* JADX WARN: Not initialized variable reg: 15, insn: 0x0152: MOVE (r9 I:??[OBJECT, ARRAY]) = (r15 I:??[OBJECT, ARRAY] A[D('serverListJson' java.lang.String)]), block:B:19:0x014f */
    /* JADX WARN: Not initialized variable reg: 19, insn: 0x0169: MOVE (r23 I:??[OBJECT, ARRAY] A[D('audioType' java.lang.String)]) = (r19 I:??[OBJECT, ARRAY] A[D('epDoc' org.jsoup.nodes.Document)]), block:B:19:0x014f */
    /* JADX WARN: Not initialized variable reg: 21, insn: 0x029e: MOVE (r4 I:??[OBJECT, ARRAY] A[D('episodeUrl' java.lang.String)]) = (r21 I:??[OBJECT, ARRAY] A[D('$result' java.lang.Object)]), block:B:48:0x0296 */
    /* JADX WARN: Not initialized variable reg: 22, insn: 0x016b: MOVE (r19 I:??[OBJECT, ARRAY] A[D('epDoc' org.jsoup.nodes.Document)]) = (r22 I:??[OBJECT, ARRAY] A[D('epListJson' java.lang.String)]), block:B:19:0x014f */
    /* JADX WARN: Not initialized variable reg: 23, insn: 0x0165: MOVE (r3 I:??[OBJECT, ARRAY] A[D('$continuation' kotlin.coroutines.Continuation)]) = (r23 I:??[OBJECT, ARRAY] A[D('audioType' java.lang.String)]), block:B:19:0x014f */
    /* JADX WARN: Not initialized variable reg: 24, insn: 0x0153: MOVE (r17 I:??[OBJECT, ARRAY]) = (r24 I:??[OBJECT, ARRAY] A[D('epName' java.lang.String)]), block:B:19:0x014f */
    /* JADX WARN: Not initialized variable reg: 25, insn: 0x0155: MOVE (r18 I:??[OBJECT, ARRAY]) = (r25 I:??[OBJECT, ARRAY] A[D('animeId' java.lang.String)]), block:B:19:0x014f */
    /* JADX WARN: Not initialized variable reg: 26, insn: 0x0157: MOVE (r41 I:??[OBJECT, ARRAY]) = (r26 I:??[OBJECT, ARRAY] A[D('watchMain' org.jsoup.nodes.Element)]), block:B:19:0x014f */
    /* JADX WARN: Not initialized variable reg: 27, insn: 0x0159: MOVE (r42 I:??[OBJECT, ARRAY]) = (r27 I:??[OBJECT, ARRAY] A[D('doc' org.jsoup.nodes.Document)]), block:B:19:0x014f */
    /* JADX WARN: Not initialized variable reg: 28, insn: 0x015b: MOVE (r15 I:??[OBJECT, ARRAY] A[D('serverListJson' java.lang.String)]) = (r28 I:??[OBJECT, ARRAY] A[D('callback' kotlin.jvm.functions.Function1)]), block:B:19:0x014f */
    /* JADX WARN: Not initialized variable reg: 29, insn: 0x0161: MOVE (r7 I:??[OBJECT, ARRAY] A[D('serverIds' java.lang.String)]) = (r29 I:??[OBJECT, ARRAY] A[D('subtitleCallback' kotlin.jvm.functions.Function1)]), block:B:19:0x014f */
    /* JADX WARN: Not initialized variable reg: 30, insn: 0x0167: MOVE (r1 I:??[OBJECT, ARRAY]) = (r30 I:??[OBJECT, ARRAY] A[D('episodeUrl' java.lang.String)]), block:B:19:0x014f */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x015f: MOVE (r11 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY] A[D('targetEp' org.jsoup.nodes.Element)]), block:B:19:0x014f */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x029c: MOVE (r26 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY] A[D('callback' kotlin.jvm.functions.Function1)]), block:B:48:0x0296 */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0160: MOVE (r12 I:??[OBJECT, ARRAY] A[D('linkIds' java.util.List)]) = (r7 I:??[OBJECT, ARRAY] A[D('serverIds' java.lang.String)]), block:B:19:0x014f */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:161:0x0729 -> B:227:0x074a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:186:0x0896 -> B:243:0x05a3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public final java.lang.Object resolveFromWatchPage(java.lang.String r45, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r46, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r47, kotlin.coroutines.Continuation<? super java.lang.Boolean> r48) {
        /*
            Method dump skipped, instruction units count: 2398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anikoto.AnikotoProvider.resolveFromWatchPage(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object resolveEmbedInline(String url, String referer, String audioType, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Boolean> continuation) {
        C00041 c00041;
        String normalizedUrl;
        String normalizedUrl2;
        String domain;
        Function1<? super ExtractorLink, Unit> function3;
        String referer2;
        String domain2;
        String referer3;
        String domain3;
        Object obj;
        List groupValues;
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
        boolean zBooleanValue = false;
        switch (c00042.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (StringsKt.startsWith$default(url, "//", false, 2, (Object) null)) {
                    normalizedUrl = "https:" + url;
                } else {
                    normalizedUrl = StringsKt.startsWith$default(url, "/", false, 2, (Object) null) ? getMainUrl() + url : url;
                }
                MatchResult matchResultFind$default = Regex.find$default(new Regex("https?://([^/]+)"), normalizedUrl, 0, 2, (Object) null);
                if (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (normalizedUrl2 = (String) groupValues.get(1)) == null) {
                    normalizedUrl2 = "";
                }
                int i = (StringsKt.contains(normalizedUrl2, "megaplay", true) || StringsKt.contains(normalizedUrl2, "vidwish", true) || StringsKt.contains(normalizedUrl2, "vidtube", true)) ? 1 : 0;
                if (i != 0) {
                    c00042.L$0 = SpillingKt.nullOutSpilledVariable(url);
                    c00042.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                    c00042.L$2 = SpillingKt.nullOutSpilledVariable(audioType);
                    c00042.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                    c00042.L$4 = SpillingKt.nullOutSpilledVariable(function2);
                    c00042.L$5 = SpillingKt.nullOutSpilledVariable(normalizedUrl);
                    c00042.L$6 = SpillingKt.nullOutSpilledVariable(normalizedUrl2);
                    c00042.I$0 = i;
                    c00042.label = 1;
                    Object objResolveMegaPlayInline = resolveMegaPlayInline(normalizedUrl, referer, normalizedUrl2, audioType, function1, function2, c00042);
                    return objResolveMegaPlayInline == coroutine_suspended ? coroutine_suspended : objResolveMegaPlayInline;
                }
                try {
                    c00042.L$0 = SpillingKt.nullOutSpilledVariable(url);
                    c00042.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                    c00042.L$2 = SpillingKt.nullOutSpilledVariable(audioType);
                    c00042.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                    c00042.L$4 = SpillingKt.nullOutSpilledVariable(function2);
                    c00042.L$5 = SpillingKt.nullOutSpilledVariable(normalizedUrl);
                    c00042.L$6 = SpillingKt.nullOutSpilledVariable(normalizedUrl2);
                    c00042.I$0 = i;
                    c00042.label = 2;
                    domain = referer;
                    function3 = function2;
                    try {
                        Object objLoadExtractor = ExtractorApiKt.loadExtractor(normalizedUrl, domain, function1, function3, c00042);
                        if (objLoadExtractor == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        String str = normalizedUrl2;
                        domain2 = normalizedUrl;
                        referer3 = domain;
                        domain3 = str;
                        obj = objLoadExtractor;
                        zBooleanValue = ((Boolean) obj).booleanValue();
                        return Boxing.boxBoolean(zBooleanValue);
                    } catch (Exception e) {
                        referer2 = normalizedUrl;
                    }
                } catch (Exception e2) {
                    domain = referer;
                    function3 = function2;
                }
                break;
            case 1:
                int i2 = c00042.I$0;
                ResultKt.throwOnFailure($result);
                return $result;
            case 2:
                int i3 = c00042.I$0;
                domain3 = (String) c00042.L$6;
                domain2 = (String) c00042.L$5;
                referer3 = (String) c00042.L$1;
                try {
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    zBooleanValue = ((Boolean) obj).booleanValue();
                    break;
                } catch (Exception e3) {
                    String str2 = domain2;
                    normalizedUrl2 = domain3;
                    domain = referer3;
                    referer2 = str2;
                }
                return Boxing.boxBoolean(zBooleanValue);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:220:0x0962 A[Catch: Exception -> 0x0ac9, TRY_LEAVE, TryCatch #24 {Exception -> 0x0ac9, blocks: (B:218:0x095c, B:220:0x0962), top: B:337:0x095c }] */
    /* JADX WARN: Code duplicated, block: B:222:0x0971  */
    /* JADX WARN: Code duplicated, block: B:223:0x0976  */
    /* JADX WARN: Code duplicated, block: B:238:0x09aa  */
    /* JADX WARN: Code duplicated, block: B:244:0x0a61 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:245:0x0a62  */
    /* JADX WARN: Code duplicated, block: B:332:0x0986 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:357:0x09a4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:360:0x099e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Path cross not found for [B:332:0x0986, B:233:0x0998], limit reached: 345 */
    /* JADX WARN: Path cross not found for [B:341:0x04c7, B:68:0x04e9], limit reached: 345 */
    /* JADX WARN: Path cross not found for [B:355:0x06a0, B:140:0x06c6], limit reached: 345 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:245:0x0a62 -> B:326:0x0a7e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public final java.lang.Object resolveMegaPlayInline(java.lang.String r43, java.lang.String r44, java.lang.String r45, java.lang.String r46, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r47, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r48, kotlin.coroutines.Continuation<? super java.lang.Boolean> r49) {
        /*
            Method dump skipped, instruction units count: 3102
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anikoto.AnikotoProvider.resolveMegaPlayInline(java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.anikoto.AnikotoProvider$resolveMegaPlayInline$2 */
    /* JADX INFO: compiled from: AnikotoProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.anikoto.AnikotoProvider$resolveMegaPlayInline$2", f = "AnikotoProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00072 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $host;
        final /* synthetic */ Map<String, String> $playbackHeaders;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00072(String str, Map<String, String> map, Continuation<? super C00072> continuation) {
            super(2, continuation);
            this.$host = str;
            this.$playbackHeaders = map;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00072 = new C00072(this.$host, this.$playbackHeaders, continuation);
            c00072.L$0 = obj;
            return c00072;
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
                    $this$newExtractorLink.setReferer(this.$host + '/');
                    $this$newExtractorLink.setHeaders(this.$playbackHeaders);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final String jsonResultString(String json) {
        Object obj;
        Object objDecodeFromString;
        try {
            AppUtils appUtils = AppUtils.INSTANCE;
            try {
                Result.Companion companion = Result.Companion;
                KType kTypeTypeOf = Reflection.typeOf(AjaxResponse.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.exceptionOrNull-impl(obj) != null) {
                try {
                    Result.Companion companion3 = Result.Companion;
                    obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AjaxResponse.class), (List) null, 2, (Object) null));
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
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, json);
                } catch (SerializationException e) {
                    ArchComponentExtKt.logError(e);
                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv.readValue(json, new TypeReference<AjaxResponse>() { // from class: com.anikoto.AnikotoProvider$jsonResultString$$inlined$parseJson$1
                    });
                } catch (Throwable th3) {
                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv2.readValue(json, new TypeReference<AjaxResponse>() { // from class: com.anikoto.AnikotoProvider$jsonResultString$$inlined$parseJson$1
                    });
                }
            } else {
                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv3.readValue(json, new TypeReference<AjaxResponse>() { // from class: com.anikoto.AnikotoProvider$jsonResultString$$inlined$parseJson$1
                });
            }
            AjaxResponse obj2 = (AjaxResponse) objDecodeFromString;
            Integer status = obj2.getStatus();
            if (status != null && status.intValue() == 200) {
                Object result = obj2.getResult();
                String str = result instanceof String ? (String) result : null;
                return str == null ? "" : str;
            }
            return "";
        } catch (Exception e2) {
            return "";
        }
    }

    private final String jsonResultUrl(String json) {
        Object obj;
        Object objDecodeFromString;
        try {
            AppUtils appUtils = AppUtils.INSTANCE;
            try {
                Result.Companion companion = Result.Companion;
                KType kTypeTypeOf = Reflection.typeOf(AjaxResponse.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.exceptionOrNull-impl(obj) != null) {
                try {
                    Result.Companion companion3 = Result.Companion;
                    obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AjaxResponse.class), (List) null, 2, (Object) null));
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
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, json);
                } catch (SerializationException e) {
                    ArchComponentExtKt.logError(e);
                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv.readValue(json, new TypeReference<AjaxResponse>() { // from class: com.anikoto.AnikotoProvider$jsonResultUrl$$inlined$parseJson$1
                    });
                } catch (Throwable th3) {
                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv2.readValue(json, new TypeReference<AjaxResponse>() { // from class: com.anikoto.AnikotoProvider$jsonResultUrl$$inlined$parseJson$1
                    });
                }
            } else {
                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv3.readValue(json, new TypeReference<AjaxResponse>() { // from class: com.anikoto.AnikotoProvider$jsonResultUrl$$inlined$parseJson$1
                });
            }
            AjaxResponse obj2 = (AjaxResponse) objDecodeFromString;
            Integer status = obj2.getStatus();
            if (status != null && status.intValue() == 200) {
                Object result = obj2.getResult();
                Map map = result instanceof Map ? (Map) result : null;
                Object obj3 = map != null ? map.get("url") : null;
                if (obj3 instanceof String) {
                    return (String) obj3;
                }
                return null;
            }
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    private final AnimeSearchResponse toSearchResult(Element $this$toSearchResult) {
        final String dataSrc;
        String strOwnText;
        String strText;
        Element titleEl = $this$toSearchResult.selectFirst("a.name.d-title");
        String typeText = null;
        if (titleEl == null && (titleEl = $this$toSearchResult.selectFirst("a[title]")) == null && (titleEl = $this$toSearchResult.selectFirst("a[href*='/watch/']")) == null) {
            return null;
        }
        String strAttr = titleEl.attr("href");
        if (StringsKt.isBlank(strAttr)) {
            Element elementSelectFirst = $this$toSearchResult.selectFirst("div.poster a, a");
            String strAttr2 = elementSelectFirst != null ? elementSelectFirst.attr("href") : null;
            if (strAttr2 == null) {
                strAttr2 = "";
            }
            strAttr = strAttr2;
        }
        String href = strAttr;
        String string = StringsKt.trim(titleEl.text()).toString();
        if (StringsKt.isBlank(string)) {
            string = StringsKt.trim(titleEl.attr("title")).toString();
        }
        String title = string;
        if (StringsKt.isBlank(href) || StringsKt.isBlank(title)) {
            return null;
        }
        String cleanHref = MainAPIKt.fixUrl(this, new Regex("/ep-\\d+$").replace(href, ""));
        Element posterEl = $this$toSearchResult.selectFirst("div.poster img, img");
        if (posterEl != null) {
            dataSrc = posterEl.attr("data-src");
            if (StringsKt.isBlank(dataSrc)) {
                dataSrc = posterEl.attr("src");
            }
        } else {
            dataSrc = null;
        }
        Element elementSelectFirst2 = $this$toSearchResult.selectFirst(".fd-infor .tick-item.tick-type, .item-type, .tick-type");
        if (elementSelectFirst2 == null || (strText = elementSelectFirst2.text()) == null) {
            Element elementSelectFirst3 = $this$toSearchResult.selectFirst(".type");
            if (elementSelectFirst3 != null && (strOwnText = elementSelectFirst3.ownText()) != null) {
                typeText = StringsKt.trim(strOwnText).toString();
            }
        } else {
            typeText = strText;
        }
        TvType type = typeText != null && StringsKt.contains(typeText, "Movie", true) ? TvType.AnimeMovie : TvType.Anime;
        String metaText = $this$toSearchResult.select(".meta, .info, .type, .right").text();
        final boolean hasDub = $this$toSearchResult.selectFirst(".dub, i.dub, .fa-microphone") != null || StringsKt.contains(metaText, "Dub", true);
        final boolean hasSub = ($this$toSearchResult.selectFirst(".sub, i.sub, .fa-closed-captioning") == null && !StringsKt.contains(metaText, "Sub", true) && hasDub) ? false : true;
        return MainAPIKt.newAnimeSearchResponse$default(this, title, cleanHref, type, false, new Function1() { // from class: com.anikoto.AnikotoProvider$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                return AnikotoProvider.toSearchResult$lambda$2(dataSrc, hasDub, hasSub, this, (AnimeSearchResponse) obj);
            }
        }, 8, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toSearchResult$lambda$2(String $poster, boolean $hasDub, boolean $hasSub, AnikotoProvider this$0, AnimeSearchResponse $this$newAnimeSearchResponse) {
        String it = $poster != null ? MainAPIKt.fixUrl(this$0, $poster) : null;
        $this$newAnimeSearchResponse.setPosterUrl(it);
        MainAPIKt.addDubStatus$default($this$newAnimeSearchResponse, $hasDub, $hasSub, (Integer) null, (Integer) null, 12, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: AnikotoProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0001HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0001HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/anikoto/AnikotoProvider$AjaxResponse;", "", "status", "", "result", "<init>", "(Ljava/lang/Integer;Ljava/lang/Object;)V", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getResult", "()Ljava/lang/Object;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Object;)Lcom/anikoto/AnikotoProvider$AjaxResponse;", "equals", "", "other", "hashCode", "toString", "", "AniKoto_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class AjaxResponse {

        @JsonProperty("result")
        @Nullable
        private final Object result;

        @JsonProperty("status")
        @Nullable
        private final Integer status;

        /* JADX WARN: Illegal instructions before constructor call */
        public AjaxResponse() {
            Integer num = null;
            this(num, num, 3, num);
        }

        public static /* synthetic */ AjaxResponse copy$default(AjaxResponse ajaxResponse, Integer num, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                num = ajaxResponse.status;
            }
            if ((i & 2) != 0) {
                obj = ajaxResponse.result;
            }
            return ajaxResponse.copy(num, obj);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Integer getStatus() {
            return this.status;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Object getResult() {
            return this.result;
        }

        @NotNull
        public final AjaxResponse copy(@JsonProperty("status") @Nullable Integer status, @JsonProperty("result") @Nullable Object result) {
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

        public AjaxResponse(@JsonProperty("status") @Nullable Integer status, @JsonProperty("result") @Nullable Object result) {
            this.status = status;
            this.result = result;
        }

        public /* synthetic */ AjaxResponse(Integer num, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : obj);
        }

        @Nullable
        public final Integer getStatus() {
            return this.status;
        }

        @Nullable
        public final Object getResult() {
            return this.result;
        }
    }

    /* JADX INFO: compiled from: AnikotoProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0010\b\u0003\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0010\b\u0003\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/anikoto/AnikotoProvider$SourcesResponse;", "", "sources", "tracks", "", "Lcom/anikoto/AnikotoProvider$Track;", "<init>", "(Ljava/lang/Object;Ljava/util/List;)V", "getSources", "()Ljava/lang/Object;", "getTracks", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AniKoto_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class SourcesResponse {

        @JsonProperty("sources")
        @Nullable
        private final Object sources;

        @JsonProperty("tracks")
        @Nullable
        private final List<Track> tracks;

        /* JADX WARN: Illegal instructions before constructor call */
        public SourcesResponse() {
            List list = null;
            this(list, list, 3, list);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SourcesResponse copy$default(SourcesResponse sourcesResponse, Object obj, List list, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = sourcesResponse.sources;
            }
            if ((i & 2) != 0) {
                list = sourcesResponse.tracks;
            }
            return sourcesResponse.copy(obj, list);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Object getSources() {
            return this.sources;
        }

        @Nullable
        public final List<Track> component2() {
            return this.tracks;
        }

        @NotNull
        public final SourcesResponse copy(@JsonProperty("sources") @Nullable Object sources, @JsonProperty("tracks") @Nullable List<Track> tracks) {
            return new SourcesResponse(sources, tracks);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SourcesResponse)) {
                return false;
            }
            SourcesResponse sourcesResponse = (SourcesResponse) other;
            return Intrinsics.areEqual(this.sources, sourcesResponse.sources) && Intrinsics.areEqual(this.tracks, sourcesResponse.tracks);
        }

        public int hashCode() {
            return ((this.sources == null ? 0 : this.sources.hashCode()) * 31) + (this.tracks != null ? this.tracks.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "SourcesResponse(sources=" + this.sources + ", tracks=" + this.tracks + ')';
        }

        public SourcesResponse(@JsonProperty("sources") @Nullable Object sources, @JsonProperty("tracks") @Nullable List<Track> list) {
            this.sources = sources;
            this.tracks = list;
        }

        public /* synthetic */ SourcesResponse(Object obj, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : obj, (i & 2) != 0 ? null : list);
        }

        @Nullable
        public final Object getSources() {
            return this.sources;
        }

        @Nullable
        public final List<Track> getTracks() {
            return this.tracks;
        }
    }

    /* JADX INFO: compiled from: AnikotoProvider.kt */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/anikoto/AnikotoProvider$Track;", "", "file", "", "label", "kind", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFile", "()Ljava/lang/String;", "getLabel", "getKind", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "AniKoto_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Track {

        @JsonProperty("file")
        @Nullable
        private final String file;

        @JsonProperty("kind")
        @Nullable
        private final String kind;

        @JsonProperty("label")
        @Nullable
        private final String label;

        public Track() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ Track copy$default(Track track, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = track.file;
            }
            if ((i & 2) != 0) {
                str2 = track.label;
            }
            if ((i & 4) != 0) {
                str3 = track.kind;
            }
            return track.copy(str, str2, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFile() {
            return this.file;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getKind() {
            return this.kind;
        }

        @NotNull
        public final Track copy(@JsonProperty("file") @Nullable String file, @JsonProperty("label") @Nullable String label, @JsonProperty("kind") @Nullable String kind) {
            return new Track(file, label, kind);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Track)) {
                return false;
            }
            Track track = (Track) other;
            return Intrinsics.areEqual(this.file, track.file) && Intrinsics.areEqual(this.label, track.label) && Intrinsics.areEqual(this.kind, track.kind);
        }

        public int hashCode() {
            return ((((this.file == null ? 0 : this.file.hashCode()) * 31) + (this.label == null ? 0 : this.label.hashCode())) * 31) + (this.kind != null ? this.kind.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Track(file=" + this.file + ", label=" + this.label + ", kind=" + this.kind + ')';
        }

        public Track(@JsonProperty("file") @Nullable String file, @JsonProperty("label") @Nullable String label, @JsonProperty("kind") @Nullable String kind) {
            this.file = file;
            this.label = label;
            this.kind = kind;
        }

        public /* synthetic */ Track(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        @Nullable
        public final String getFile() {
            return this.file;
        }

        @Nullable
        public final String getLabel() {
            return this.label;
        }

        @Nullable
        public final String getKind() {
            return this.kind;
        }
    }

    private final void showSubscriptionPopupIfNeeded() {
        final Context ctx = context;
        if (ctx == null || this.subscriptionPopupShown) {
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
            this.subscriptionPopupShown = true;
        } else {
            this.subscriptionPopupShown = true;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.anikoto.AnikotoProvider$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    AnikotoProvider.showSubscriptionPopupIfNeeded$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.anikoto.AnikotoProvider$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnikotoProvider.showSubscriptionPopupIfNeeded$lambda$0$11($this$showSubscriptionPopupIfNeeded_u24lambda_u240_u249, $ctx, dialog, view);
                }
            });
            subscribeTv.setOnClickListener(new View.OnClickListener() { // from class: com.anikoto.AnikotoProvider$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnikotoProvider.showSubscriptionPopupIfNeeded$lambda$0$12(dialog, $ctx, view);
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
        if (Globals.INSTANCE.isLayout(2) || (ctx = context) == null || this.telegramPopupShown) {
            return;
        }
        SharedPreferences prefs = ctx.getSharedPreferences("cncverse_prefs", 0);
        if (prefs.getBoolean("telegram_popup_shown", false)) {
            this.telegramPopupShown = true;
            return;
        }
        this.telegramPopupShown = true;
        prefs.edit().putBoolean("telegram_popup_shown", true).apply();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.anikoto.AnikotoProvider$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                AnikotoProvider.showTelegramPopup$lambda$0(ctx);
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
            laterTv.setOnClickListener(new View.OnClickListener() { // from class: com.anikoto.AnikotoProvider$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    dialog.dismiss();
                }
            });
            joinTv.setOnClickListener(new View.OnClickListener() { // from class: com.anikoto.AnikotoProvider$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnikotoProvider.showTelegramPopup$lambda$0$9(dialog, $ctx, view);
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
        if (now - this.lastBrowserOpenMs < this.BROWSER_DEBOUNCE_MS) {
            return;
        }
        this.lastBrowserOpenMs = now;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.anikoto.AnikotoProvider$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                AnikotoProvider.openInExternalBrowser$lambda$0(ctx, url);
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
