package com.horis.cncverse;

import android.content.Context;
import com.cncverse.donation.DonationManager;
import com.horis.cncverse.entities.PostData;
import com.horis.cncverse.entities.Season;
import com.horis.cncverse.entities.Source;
import com.horis.cncverse.entities.Suggest;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.Actor;
import com.lagradost.cloudstream3.ActorData;
import com.lagradost.cloudstream3.ActorRole;
import com.lagradost.cloudstream3.AnimeSearchResponse;
import com.lagradost.cloudstream3.Episode;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvSeriesLoadResponse;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
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
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: DisneyStudioProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/CNC_Verse_Mobile/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 @2\u00020\u0001:\u0003@ABB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001dH\u0002J \u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\f\u0010&\u001a\u00020'*\u00020(H\u0002J\u000e\u0010)\u001a\u0004\u0018\u00010**\u00020(H\u0002J\u0018\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010.J4\u0010/\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"H\u0082@¢\u0006\u0002\u00105JF\u00106\u001a\u00020\u00182\u0006\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00182\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<0:2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020<0:H\u0096@¢\u0006\u0002\u0010?R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/horis/cncverse/DisneyStudioProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "studio", "", "displayName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "lang", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "cookie_value", "headers", "", "buildCookies", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toHomePageList", "Lcom/lagradost/cloudstream3/HomePageList;", "Lorg/jsoup/nodes/Element;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEpisodes", "", "Lcom/lagradost/cloudstream3/Episode;", "title", "eid", "sid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Id", "LoadData", "CNC Verse Mobile_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDisneyStudioProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DisneyStudioProvider.kt\ncom/horis/cncverse/DisneyStudioProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Utils.kt\ncom/horis/cncverse/UtilsKt\n+ 5 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,294:1\n1586#2:295\n1661#2,3:296\n1642#2,10:299\n1915#2:309\n1916#2:311\n1652#2:312\n1586#2:315\n1661#2,3:316\n1586#2:319\n1661#2,3:320\n1586#2:323\n1661#2,3:324\n777#2:327\n873#2,2:328\n1586#2:330\n1661#2,3:331\n1661#2,3:334\n1661#2,3:338\n777#2:343\n873#2,2:344\n1586#2:346\n1661#2,3:347\n1#3:310\n53#4:313\n53#4:341\n62#5:314\n62#5:337\n62#5:342\n*S KotlinDebug\n*F\n+ 1 DisneyStudioProvider.kt\ncom/horis/cncverse/DisneyStudioProvider\n*L\n82#1:295\n82#1:296,3\n90#1:299,10\n90#1:309\n90#1:311\n90#1:312\n133#1:315\n133#1:316,3\n134#1:319\n134#1:320,3\n140#1:323\n140#1:324,3\n141#1:327\n141#1:328,2\n146#1:330\n146#1:331,3\n158#1:334,3\n206#1:338,3\n273#1:343\n273#1:344,2\n273#1:346\n273#1:347,3\n90#1:310\n122#1:313\n228#1:341\n128#1:314\n205#1:337\n255#1:342\n*E\n"})
public class DisneyStudioProvider extends MainAPI {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static Context context;

    @NotNull
    private String name;

    @NotNull
    private final String studio;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Movie, TvType.TvSeries, TvType.Anime, TvType.AsianDrama});

    @NotNull
    private String lang = "ta";

    @NotNull
    private String mainUrl = "https://net52.cc";
    private final boolean hasMainPage = true;

    @NotNull
    private String cookie_value = "";

    @NotNull
    private final Map<String, String> headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"), TuplesKt.to("Accept-Language", "en-IN,en-US;q=0.9,en;q=0.8"), TuplesKt.to("Cache-Control", "max-age=0"), TuplesKt.to("Connection", "keep-alive"), TuplesKt.to("sec-ch-ua", "\"Not(A:Brand\";v=\"8\", \"Chromium\";v=\"144\", \"Android WebView\";v=\"144\""), TuplesKt.to("sec-ch-ua-mobile", "?0"), TuplesKt.to("sec-ch-ua-platform", "\"Android\""), TuplesKt.to("Sec-Fetch-Dest", "document"), TuplesKt.to("Sec-Fetch-Mode", "navigate"), TuplesKt.to("Sec-Fetch-Site", "same-origin"), TuplesKt.to("Sec-Fetch-User", "?1"), TuplesKt.to("Upgrade-Insecure-Requests", "1"), TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 13; Pixel 5 Build/TQ3A.230901.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/144.0.7559.132 Safari/537.36 /OS.Gatu v3.0"), TuplesKt.to("X-Requested-With", "app.netmirror.netmirrornew")});

    /* JADX INFO: renamed from: com.horis.cncverse.DisneyStudioProvider$getEpisodes$1 */
    /* JADX INFO: compiled from: DisneyStudioProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.DisneyStudioProvider", f = "DisneyStudioProvider.kt", i = {0, 0, 0, 0, 0, 0}, l = {200}, m = "getEpisodes", n = {"title", "eid", "sid", "episodes", "page", "pg"}, nl = {205}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DisneyStudioProvider.this.getEpisodes(null, null, null, 0, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cncverse.DisneyStudioProvider$getMainPage$1 */
    /* JADX INFO: compiled from: DisneyStudioProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.DisneyStudioProvider", f = "DisneyStudioProvider.kt", i = {0, 0, 0, 1, 1, 1}, l = {75, 76}, m = "getMainPage$suspendImpl", n = {"$this", "request", "page", "$this", "request", "page"}, nl = {76, 81}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DisneyStudioProvider.getMainPage$suspendImpl(DisneyStudioProvider.this, 0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cncverse.DisneyStudioProvider$load$1 */
    /* JADX INFO: compiled from: DisneyStudioProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.DisneyStudioProvider", f = "DisneyStudioProvider.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {121, 123, 169, 172, 179}, m = "load$suspendImpl", n = {"$this", "url", "$this", "url", "id", "$this", "url", "id", "data", "episodes", "title", "castList", "cast", "genre", "rating", "suggest", "runTime", "$this", "url", "id", "data", "episodes", "title", "castList", "cast", "genre", "rating", "suggest", "runTime", "$this", "url", "id", "data", "episodes", "title", "castList", "cast", "genre", "rating", "suggest", "type", "runTime"}, nl = {122, 128, 172, 177, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0"}, v = 2)
    static final class C00051 extends ContinuationImpl {
        int I$0;
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

        C00051(Continuation<? super C00051> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DisneyStudioProvider.load$suspendImpl(DisneyStudioProvider.this, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.horis.cncverse.DisneyStudioProvider$loadLinks$1 */
    /* JADX INFO: compiled from: DisneyStudioProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.DisneyStudioProvider", f = "DisneyStudioProvider.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {227, 250, 260, 275}, m = "loadLinks$suspendImpl", n = {"$this", "data", "subtitleCallback", "callback", "isCasting", "$this", "data", "subtitleCallback", "callback", "title", "id", "cookies", "cookieStr", "playlistHeaders", "isCasting", "$this", "data", "subtitleCallback", "callback", "title", "id", "cookies", "cookieStr", "playlistHeaders", "playlist", "item", "source", "isCasting", "$this", "data", "subtitleCallback", "callback", "title", "id", "cookies", "cookieStr", "playlistHeaders", "playlist", "item", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "track", "isCasting", "$i$f$map", "$i$f$mapTo", "$i$a$-map-DisneyStudioProvider$loadLinks$4"}, nl = {228, 255, 259, 274}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$13", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$11", "L$12", "L$13", "L$14", "L$16", "L$17", "Z$0", "I$0", "I$1", "I$2"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
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

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DisneyStudioProvider.loadLinks$suspendImpl(DisneyStudioProvider.this, null, false, null, null, (Continuation) this);
        }
    }

    @Nullable
    public Object getMainPage(int i, @NotNull MainPageRequest mainPageRequest, @NotNull Continuation<? super HomePageResponse> continuation) {
        return getMainPage$suspendImpl(this, i, mainPageRequest, continuation);
    }

    @Nullable
    public Object load(@NotNull String str, @NotNull Continuation<? super LoadResponse> continuation) {
        return load$suspendImpl(this, str, continuation);
    }

    @Nullable
    public Object loadLinks(@NotNull String str, boolean z, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        return loadLinks$suspendImpl(this, str, z, function1, function2, continuation);
    }

    public DisneyStudioProvider(@NotNull String studio, @NotNull String displayName) {
        this.studio = studio;
        this.name = displayName;
    }

    /* JADX INFO: compiled from: DisneyStudioProvider.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/horis/cncverse/DisneyStudioProvider$Companion;", "", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "CNC Verse Mobile_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final Context getContext() {
            return DisneyStudioProvider.context;
        }

        public final void setContext(@Nullable Context context) {
            DisneyStudioProvider.context = context;
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

    private final Map<String, String> buildCookies() {
        Map<String, String> mapMutableMapOf = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("t_hash_t", this.cookie_value), TuplesKt.to("ott", "dp"), TuplesKt.to("hd", "on")});
        if (this.studio.length() > 0) {
            mapMutableMapOf.put("studio", this.studio);
        }
        return mapMutableMapOf;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x010f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x0110  */
    /* JADX WARN: Code duplicated, block: B:25:0x013f A[LOOP:0: B:23:0x0139->B:25:0x013f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getMainPage$suspendImpl(DisneyStudioProvider $this, int page, MainPageRequest request, Continuation<? super HomePageResponse> continuation) {
        C00041 c00041;
        int page2;
        MainPageRequest request2;
        Object obj;
        DisneyStudioProvider $this2;
        DisneyStudioProvider $this3;
        DisneyStudioProvider $this4;
        Collection destination$iv$iv;
        DisneyStudioProvider $this5 = $this;
        if (continuation instanceof C00041) {
            c00041 = (C00041) continuation;
            if ((c00041.label & Integer.MIN_VALUE) != 0) {
                c00041.label -= Integer.MIN_VALUE;
            } else {
                c00041 = $this5.new C00041(continuation);
            }
        } else {
            c00041 = $this5.new C00041(continuation);
        }
        Object $result = c00041.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00041.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                DonationManager.INSTANCE.checkAndShow($this5.getName());
                String mainUrl = $this5.getMainUrl();
                c00041.L$0 = $this5;
                c00041.L$1 = SpillingKt.nullOutSpilledVariable(request);
                c00041.L$2 = $this5;
                page2 = page;
                c00041.I$0 = page2;
                c00041.label = 1;
                Object objBypass = UtilsKt.bypass(mainUrl, c00041);
                if (objBypass == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                obj = objBypass;
                $this2 = $this5;
                $this5.cookie_value = (String) obj;
                Requests app = UtilsKt.getApp();
                String str = $this2.getMainUrl() + "/mobile/home?app=1";
                Map<String, String> mapBuildCookies = $this2.buildCookies();
                Map<String, String> map = $this2.headers;
                String str2 = $this2.getMainUrl() + "/mobile/home?app=1";
                c00041.L$0 = $this2;
                c00041.L$1 = SpillingKt.nullOutSpilledVariable(request2);
                c00041.L$2 = null;
                c00041.I$0 = page2;
                c00041.label = 2;
                $this3 = $this2;
                $result = Requests.get$default(app, str, map, str2, (Map) null, mapBuildCookies, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00041, 4072, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this4 = $this3;
                Document document = ((NiceResponse) $result).getDocument();
                Iterable $this$map$iv = document.select(".tray-container, #top10");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Element it = (Element) item$iv$iv;
                    destination$iv$iv.add($this4.toHomePageList(it));
                }
                List items = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(items, Boxing.boxBoolean(false));
            case 1:
                int page3 = c00041.I$0;
                DisneyStudioProvider disneyStudioProvider = (DisneyStudioProvider) c00041.L$2;
                MainPageRequest request3 = (MainPageRequest) c00041.L$1;
                DisneyStudioProvider $this6 = (DisneyStudioProvider) c00041.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this6;
                $this5 = disneyStudioProvider;
                page2 = page3;
                request2 = request3;
                obj = $result;
                $this5.cookie_value = (String) obj;
                Requests app2 = UtilsKt.getApp();
                String str3 = $this2.getMainUrl() + "/mobile/home?app=1";
                Map<String, String> mapBuildCookies2 = $this2.buildCookies();
                Map<String, String> map2 = $this2.headers;
                String str4 = $this2.getMainUrl() + "/mobile/home?app=1";
                c00041.L$0 = $this2;
                c00041.L$1 = SpillingKt.nullOutSpilledVariable(request2);
                c00041.L$2 = null;
                c00041.I$0 = page2;
                c00041.label = 2;
                $this3 = $this2;
                $result = Requests.get$default(app2, str3, map2, str4, (Map) null, mapBuildCookies2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00041, 4072, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this4 = $this3;
                Document document2 = ((NiceResponse) $result).getDocument();
                Iterable $this$map$iv2 = document2.select(".tray-container, #top10");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                while (r11.hasNext()) {
                    Element it2 = (Element) item$iv$iv;
                    destination$iv$iv.add($this4.toHomePageList(it2));
                }
                List items2 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(items2, Boxing.boxBoolean(false));
            case 2:
                int i = c00041.I$0;
                $this4 = (DisneyStudioProvider) c00041.L$0;
                ResultKt.throwOnFailure($result);
                Document document3 = ((NiceResponse) $result).getDocument();
                Iterable $this$map$iv3 = document3.select(".tray-container, #top10");
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                while (r11.hasNext()) {
                    Element it3 = (Element) item$iv$iv;
                    destination$iv$iv.add($this4.toHomePageList(it3));
                }
                List items3 = (List) destination$iv$iv;
                return MainAPIKt.newHomePageResponse(items3, Boxing.boxBoolean(false));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final HomePageList toHomePageList(Element $this$toHomePageList) {
        String name = $this$toHomePageList.select("h2, span").text();
        Iterable $this$mapNotNull$iv = $this$toHomePageList.select("article, .top10-post");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Element it = (Element) element$iv$iv$iv;
            SearchResponse searchResult = toSearchResult(it);
            if (searchResult != null) {
                destination$iv$iv.add(searchResult);
            }
        }
        List items = (List) destination$iv$iv;
        return new HomePageList(name, items, false);
    }

    private final SearchResponse toSearchResult(Element $this$toSearchResult) {
        final String id;
        Element elementSelectFirst = $this$toSearchResult.selectFirst("a");
        if (elementSelectFirst == null || (id = elementSelectFirst.attr("data-post")) == null) {
            id = $this$toSearchResult.attr("data-post");
        }
        return MainAPIKt.newAnimeSearchResponse$default(this, "", AppUtils.INSTANCE.toJson(new Id(id)), (TvType) null, false, new Function1() { // from class: com.horis.cncverse.DisneyStudioProvider$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                return DisneyStudioProvider.toSearchResult$lambda$0(id, this, (AnimeSearchResponse) obj);
            }
        }, 12, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toSearchResult$lambda$0(String $id, DisneyStudioProvider this$0, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl("https://imgcdn.kim/hs/v/" + $id + ".jpg");
        $this$newAnimeSearchResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this$0.getMainUrl() + "/home")));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x058c  */
    /* JADX WARN: Code duplicated, block: B:103:0x058f  */
    /* JADX WARN: Code duplicated, block: B:106:0x05fb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:107:0x05fc  */
    /* JADX WARN: Code duplicated, block: B:23:0x01de A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x01df  */
    /* JADX WARN: Code duplicated, block: B:27:0x0216  */
    /* JADX WARN: Code duplicated, block: B:34:0x0268  */
    /* JADX WARN: Code duplicated, block: B:38:0x0289 A[LOOP:1: B:36:0x0283->B:38:0x0289, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:41:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:58:0x036d  */
    /* JADX WARN: Code duplicated, block: B:61:0x0375  */
    /* JADX WARN: Code duplicated, block: B:62:0x0384  */
    /* JADX WARN: Code duplicated, block: B:65:0x0398  */
    /* JADX WARN: Code duplicated, block: B:68:0x03b8 A[LOOP:4: B:66:0x03b2->B:68:0x03b8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:70:0x040b  */
    /* JADX WARN: Code duplicated, block: B:73:0x041b  */
    /* JADX WARN: Code duplicated, block: B:74:0x044a  */
    /* JADX WARN: Code duplicated, block: B:77:0x0464 A[LOOP:5: B:75:0x045e->B:77:0x0464, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x04a4 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:81:0x04aa  */
    /* JADX WARN: Code duplicated, block: B:85:0x04e4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:86:0x04e5  */
    /* JADX WARN: Code duplicated, block: B:92:0x0513  */
    static /* synthetic */ Object load$suspendImpl(DisneyStudioProvider $this, String url, Continuation<? super LoadResponse> continuation) {
        C00051 c00051;
        String url2;
        Object obj;
        DisneyStudioProvider $this2;
        String id;
        String url3;
        DisneyStudioProvider $this3;
        Object obj2;
        Object obj3;
        String id2;
        Object obj4;
        String rating;
        final DisneyStudioProvider $this4;
        final PostData data;
        ArrayList episodes;
        String title;
        String cast;
        List listEmptyList;
        List castList;
        List $this$map$iv;
        int $i$f$map;
        Collection destination$iv$iv;
        List cast2;
        String genre;
        List list;
        List genre2;
        String match;
        String strReplace$default;
        String rating2;
        int runTime;
        Iterable suggest;
        Object obj5;
        List castList2;
        ArrayList arrayList;
        List suggest2;
        Iterable $this$mapTo$iv;
        ArrayList destination$iv;
        int $i$f$mapTo;
        Iterator it;
        int runTime2;
        Integer nextPageShow;
        Object episodes2;
        String id3;
        ArrayList episodes3;
        List genre3;
        String id4;
        String url4;
        int runTime3;
        List castList3;
        List suggest3;
        DisneyStudioProvider $this5;
        String title2;
        ArrayList arrayList2;
        String url5;
        String url6;
        String title3;
        DisneyStudioProvider $this6;
        ArrayList episodes4;
        PostData data2;
        List suggest4;
        List genre4;
        String rating3;
        DisneyStudioProvider $this7;
        String id5;
        List episodes5;
        List cast3;
        int runTime4;
        PostData data3;
        List castList4;
        Iterable $this$map$iv2;
        Collection destination$iv$iv2;
        Iterable $this$mapTo$iv$iv;
        Iterable iterableSplit$default;
        Iterable iterableSplit$default2;
        List<Season> season;
        List listDropLast;
        List suggest5;
        DisneyStudioProvider $this8;
        List cast4;
        List cast5;
        String url7;
        List genre5;
        String title4;
        String title5;
        List castList5;
        TvType tvType;
        Object objNewTvSeriesLoadResponse;
        DisneyStudioProvider $this9 = $this;
        if (continuation instanceof C00051) {
            c00051 = (C00051) continuation;
            if ((c00051.label & Integer.MIN_VALUE) != 0) {
                c00051.label -= Integer.MIN_VALUE;
            } else {
                c00051 = $this9.new C00051(continuation);
            }
        } else {
            c00051 = $this9.new C00051(continuation);
        }
        C00051 c00052 = c00051;
        Object $result = c00052.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00052.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String mainUrl = $this9.getMainUrl();
                c00052.L$0 = $this9;
                url2 = url;
                c00052.L$1 = url2;
                c00052.L$2 = $this9;
                c00052.label = 1;
                Object objBypass = UtilsKt.bypass(mainUrl, c00052);
                if (objBypass == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objBypass;
                $this2 = $this9;
                $this9.cookie_value = (String) obj;
                String text$iv = url2;
                id = ((Id) UtilsKt.getJSONParser().parse(text$iv, Reflection.getOrCreateKotlinClass(Id.class))).getId();
                Requests app = UtilsKt.getApp();
                String str = $this2.getMainUrl() + "/mobile/hs/post.php?id=" + id + "&t=" + APIHolder.INSTANCE.getUnixTime();
                Map<String, String> map = $this2.headers;
                String str2 = $this2.getMainUrl() + "/home";
                Map<String, String> mapBuildCookies = $this2.buildCookies();
                c00052.L$0 = $this2;
                c00052.L$1 = url2;
                c00052.L$2 = id;
                c00052.label = 2;
                url3 = url2;
                $this3 = $this2;
                obj2 = coroutine_suspended;
                obj3 = Requests.get$default(app, str, map, str2, (Map) null, mapBuildCookies, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00052, 4072, (Object) null);
                c00052 = c00052;
                if (obj3 == obj2) {
                    return obj2;
                }
                id2 = id;
                obj4 = obj3;
                rating = url3;
                $this4 = $this3;
                NiceResponse this_$iv = (NiceResponse) obj4;
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                data = (PostData) parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(PostData.class));
                episodes = new ArrayList();
                title = data.getTitle();
                cast = data.getCast();
                if (cast != null || (iterableSplit$default2 = StringsKt.split$default(cast, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    Iterable $this$map$iv3 = iterableSplit$default2;
                    Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                    for (Object item$iv$iv : $this$map$iv3) {
                        destination$iv$iv3.add(StringsKt.trim((String) item$iv$iv).toString());
                    }
                    listEmptyList = (List) destination$iv$iv3;
                }
                castList = listEmptyList;
                $this$map$iv = castList;
                $i$f$map = 0;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv2 : $this$map$iv) {
                    destination$iv$iv.add(new ActorData(new Actor((String) item$iv$iv2, (String) null, 2, (DefaultConstructorMarker) null), (ActorRole) null, (String) null, (Actor) null, 14, (DefaultConstructorMarker) null));
                    $this$map$iv = $this$map$iv;
                    $result = $result;
                    $i$f$map = $i$f$map;
                }
                cast2 = (List) destination$iv$iv;
                genre = data.getGenre();
                if (genre != null || (iterableSplit$default = StringsKt.split$default(genre, new String[]{","}, false, 0, 6, (Object) null)) == null) {
                    list = null;
                } else {
                    Iterable $this$map$iv4 = iterableSplit$default;
                    Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                    for (Object item$iv$iv3 : $this$map$iv4) {
                        destination$iv$iv4.add(StringsKt.trim((String) item$iv$iv3).toString());
                        $this$map$iv4 = $this$map$iv4;
                    }
                    Iterable $this$filter$iv = (List) destination$iv$iv4;
                    Collection destination$iv$iv5 = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        Iterable $this$filter$iv2 = $this$filter$iv;
                        if (((String) element$iv$iv).length() > 0) {
                            destination$iv$iv5.add(element$iv$iv);
                        }
                        $this$filter$iv = $this$filter$iv2;
                    }
                    list = (List) destination$iv$iv5;
                }
                genre2 = list;
                match = data.getMatch();
                if (match != null) {
                    strReplace$default = StringsKt.replace$default(match, "IMDb ", "", false, 4, (Object) null);
                } else {
                    strReplace$default = null;
                }
                rating2 = strReplace$default;
                runTime = UtilsKt.convertRuntimeToMinutes(String.valueOf(data.getRuntime()));
                suggest = data.getSuggest();
                if (suggest != null) {
                    $this$map$iv2 = suggest;
                    int $i$f$map2 = CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10);
                    destination$iv$iv2 = new ArrayList($i$f$map2);
                    $this$mapTo$iv$iv = $this$map$iv2;
                    for (Object item$iv$iv4 : $this$mapTo$iv$iv) {
                        Iterable $this$map$iv5 = $this$map$iv2;
                        final Suggest it2 = (Suggest) item$iv$iv4;
                        destination$iv$iv2.add(MainAPIKt.newAnimeSearchResponse$default($this4, "", AppUtils.INSTANCE.toJson(new Id(it2.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cncverse.DisneyStudioProvider$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj6) {
                                return DisneyStudioProvider.load$lambda$4$0(it2, $this4, (AnimeSearchResponse) obj6);
                            }
                        }, 12, (Object) null));
                        $this$map$iv2 = $this$map$iv5;
                        castList = castList;
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                        obj2 = obj2;
                    }
                    obj5 = obj2;
                    castList2 = castList;
                    arrayList = (List) destination$iv$iv2;
                } else {
                    obj5 = obj2;
                    castList2 = castList;
                    arrayList = null;
                }
                suggest2 = arrayList;
                if (CollectionsKt.first(data.getEpisodes()) == null) {
                    Boxing.boxBoolean(episodes.add(MainAPIKt.newEpisode($this4, new LoadData(title, id2), new Function1() { // from class: com.horis.cncverse.DisneyStudioProvider$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj6) {
                            return DisneyStudioProvider.load$lambda$5(data, (Episode) obj6);
                        }
                    })));
                    suggest4 = suggest2;
                    genre4 = genre2;
                    rating3 = rating2;
                    $this7 = $this4;
                    id5 = id2;
                    episodes5 = episodes;
                    cast3 = cast2;
                    runTime4 = runTime;
                    data3 = data;
                    castList4 = castList2;
                    obj5 = obj5;
                } else {
                    $this$mapTo$iv = CollectionsKt.filterNotNull(data.getEpisodes());
                    destination$iv = episodes;
                    $i$f$mapTo = 0;
                    it = $this$mapTo$iv.iterator();
                    while (it.hasNext()) {
                        Object item$iv = it.next();
                        Iterable $this$mapTo$iv2 = $this$mapTo$iv;
                        final com.horis.cncverse.entities.Episode it3 = (com.horis.cncverse.entities.Episode) item$iv;
                        destination$iv.add(MainAPIKt.newEpisode($this4, new LoadData(title, it3.getId()), new Function1() { // from class: com.horis.cncverse.DisneyStudioProvider$$ExternalSyntheticLambda4
                            public final Object invoke(Object obj6) {
                                return DisneyStudioProvider.load$lambda$6$0(it3, (Episode) obj6);
                            }
                        }));
                        $this$mapTo$iv = $this$mapTo$iv2;
                        $i$f$mapTo = $i$f$mapTo;
                        it = it;
                        runTime = runTime;
                    }
                    runTime2 = runTime;
                    nextPageShow = data.getNextPageShow();
                    if (nextPageShow == null && nextPageShow.intValue() == 1) {
                        String nextPageSeason = data.getNextPageSeason();
                        Intrinsics.checkNotNull(nextPageSeason);
                        c00052.L$0 = $this4;
                        c00052.L$1 = rating;
                        c00052.L$2 = id2;
                        c00052.L$3 = data;
                        c00052.L$4 = episodes;
                        c00052.L$5 = title;
                        c00052.L$6 = SpillingKt.nullOutSpilledVariable(castList2);
                        c00052.L$7 = cast2;
                        c00052.L$8 = genre2;
                        c00052.L$9 = rating2;
                        c00052.L$10 = suggest2;
                        c00052.L$11 = episodes;
                        c00052.I$0 = runTime2;
                        c00052.label = 3;
                        episodes2 = $this4.getEpisodes(title, rating, nextPageSeason, 2, c00052);
                        obj5 = obj5;
                        if (episodes2 == obj5) {
                            return obj5;
                        }
                        id3 = id2;
                        episodes3 = episodes;
                        genre3 = genre2;
                        id4 = rating2;
                        url4 = rating;
                        runTime3 = runTime2;
                        castList3 = castList2;
                        suggest3 = suggest2;
                        $this5 = $this4;
                        title2 = title;
                        arrayList2 = episodes3;
                        arrayList2.addAll((Collection) episodes2);
                        $this6 = $this5;
                        url5 = url4;
                        suggest2 = suggest3;
                        castList2 = castList3;
                        title3 = title2;
                        episodes4 = episodes3;
                        url6 = id3;
                        data2 = data;
                        season = data2.getSeason();
                        if (season != null || (listDropLast = CollectionsKt.dropLast(season, 1)) == null) {
                            suggest4 = suggest2;
                            runTime4 = runTime3;
                            $this7 = $this6;
                            title = title3;
                            rating = url5;
                            rating3 = id4;
                            genre4 = genre3;
                            cast3 = cast2;
                            data3 = data2;
                            id5 = url6;
                            castList4 = castList2;
                            episodes5 = episodes4;
                        } else {
                            C00064 c00064 = new C00064(episodes4, $this6, title3, url5, null);
                            c00052.L$0 = $this6;
                            c00052.L$1 = url5;
                            c00052.L$2 = url6;
                            c00052.L$3 = data2;
                            c00052.L$4 = episodes4;
                            c00052.L$5 = title3;
                            c00052.L$6 = SpillingKt.nullOutSpilledVariable(castList2);
                            c00052.L$7 = cast2;
                            c00052.L$8 = genre3;
                            c00052.L$9 = id4;
                            c00052.L$10 = suggest2;
                            c00052.L$11 = null;
                            c00052.I$0 = runTime3;
                            c00052.label = 4;
                            $result = ParCollectionsKt.amap(listDropLast, c00064, c00052);
                            if ($result == obj5) {
                                return obj5;
                            }
                            DisneyStudioProvider disneyStudioProvider = $this6;
                            suggest5 = suggest2;
                            $this8 = disneyStudioProvider;
                            cast4 = cast2;
                            cast5 = episodes4;
                            url7 = url5;
                            genre5 = genre3;
                            title4 = title3;
                            title5 = id4;
                            castList5 = castList2;
                            $this7 = $this8;
                            runTime4 = runTime3;
                            suggest4 = suggest5;
                            rating3 = title5;
                            genre4 = genre5;
                            cast3 = cast4;
                            title = title4;
                            data3 = data2;
                            id5 = url6;
                            rating = url7;
                            castList4 = castList5;
                            episodes5 = cast5;
                        }
                    } else {
                        url5 = rating;
                        url6 = id2;
                        id4 = rating2;
                        title3 = title;
                        $this6 = $this4;
                        episodes4 = episodes;
                        genre3 = genre2;
                        runTime3 = runTime2;
                        data2 = data;
                        season = data2.getSeason();
                        if (season != null) {
                        }
                        suggest4 = suggest2;
                        runTime4 = runTime3;
                        $this7 = $this6;
                        title = title3;
                        rating = url5;
                        rating3 = id4;
                        genre4 = genre3;
                        cast3 = cast2;
                        data3 = data2;
                        id5 = url6;
                        castList4 = castList2;
                        episodes5 = episodes4;
                    }
                }
                if (CollectionsKt.first(data3.getEpisodes()) == null) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                TvType type = tvType;
                C00075 c00075 = new C00075(id5, $this7, data3, genre4, cast3, rating3, runTime4, suggest4, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable($this7);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(rating);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(id5);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(episodes5);
                c00052.L$5 = SpillingKt.nullOutSpilledVariable(title);
                c00052.L$6 = SpillingKt.nullOutSpilledVariable(castList4);
                c00052.L$7 = SpillingKt.nullOutSpilledVariable(cast3);
                c00052.L$8 = SpillingKt.nullOutSpilledVariable(genre4);
                c00052.L$9 = SpillingKt.nullOutSpilledVariable(rating3);
                c00052.L$10 = SpillingKt.nullOutSpilledVariable(suggest4);
                c00052.L$11 = SpillingKt.nullOutSpilledVariable(type);
                c00052.I$0 = runTime4;
                c00052.label = 5;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse($this7, title, rating, type, episodes5, c00075, c00052);
                if (objNewTvSeriesLoadResponse == obj5) {
                    return obj5;
                }
                return objNewTvSeriesLoadResponse;
            case 1:
                DisneyStudioProvider disneyStudioProvider2 = (DisneyStudioProvider) c00052.L$2;
                url2 = (String) c00052.L$1;
                DisneyStudioProvider $this10 = (DisneyStudioProvider) c00052.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this10;
                $this9 = disneyStudioProvider2;
                obj = $result;
                $this9.cookie_value = (String) obj;
                String text$iv2 = url2;
                id = ((Id) UtilsKt.getJSONParser().parse(text$iv2, Reflection.getOrCreateKotlinClass(Id.class))).getId();
                Requests app2 = UtilsKt.getApp();
                String str3 = $this2.getMainUrl() + "/mobile/hs/post.php?id=" + id + "&t=" + APIHolder.INSTANCE.getUnixTime();
                Map<String, String> map2 = $this2.headers;
                String str4 = $this2.getMainUrl() + "/home";
                Map<String, String> mapBuildCookies2 = $this2.buildCookies();
                c00052.L$0 = $this2;
                c00052.L$1 = url2;
                c00052.L$2 = id;
                c00052.label = 2;
                url3 = url2;
                $this3 = $this2;
                obj2 = coroutine_suspended;
                obj3 = Requests.get$default(app2, str3, map2, str4, (Map) null, mapBuildCookies2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00052, 4072, (Object) null);
                c00052 = c00052;
                if (obj3 == obj2) {
                    return obj2;
                }
                id2 = id;
                obj4 = obj3;
                rating = url3;
                $this4 = $this3;
                NiceResponse this_$iv2 = (NiceResponse) obj4;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                data = (PostData) parser2.parse(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(PostData.class));
                episodes = new ArrayList();
                title = data.getTitle();
                cast = data.getCast();
                if (cast != null) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                castList = listEmptyList;
                $this$map$iv = castList;
                $i$f$map = 0;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r17.hasNext()) {
                    destination$iv$iv.add(new ActorData(new Actor((String) item$iv$iv2, (String) null, 2, (DefaultConstructorMarker) null), (ActorRole) null, (String) null, (Actor) null, 14, (DefaultConstructorMarker) null));
                    $this$map$iv = $this$map$iv;
                    $result = $result;
                    $i$f$map = $i$f$map;
                }
                cast2 = (List) destination$iv$iv;
                genre = data.getGenre();
                if (genre != null) {
                    list = null;
                } else {
                    list = null;
                }
                genre2 = list;
                match = data.getMatch();
                if (match != null) {
                    strReplace$default = StringsKt.replace$default(match, "IMDb ", "", false, 4, (Object) null);
                } else {
                    strReplace$default = null;
                }
                rating2 = strReplace$default;
                runTime = UtilsKt.convertRuntimeToMinutes(String.valueOf(data.getRuntime()));
                suggest = data.getSuggest();
                if (suggest != null) {
                    $this$map$iv2 = suggest;
                    int $i$f$map3 = CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10);
                    destination$iv$iv2 = new ArrayList($i$f$map3);
                    $this$mapTo$iv$iv = $this$map$iv2;
                    while (r17.hasNext()) {
                        Iterable $this$map$iv6 = $this$map$iv2;
                        final Suggest it4 = (Suggest) item$iv$iv4;
                        destination$iv$iv2.add(MainAPIKt.newAnimeSearchResponse$default($this4, "", AppUtils.INSTANCE.toJson(new Id(it4.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cncverse.DisneyStudioProvider$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj6) {
                                return DisneyStudioProvider.load$lambda$4$0(it4, $this4, (AnimeSearchResponse) obj6);
                            }
                        }, 12, (Object) null));
                        $this$map$iv2 = $this$map$iv6;
                        castList = castList;
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                        obj2 = obj2;
                    }
                    obj5 = obj2;
                    castList2 = castList;
                    arrayList = (List) destination$iv$iv2;
                } else {
                    obj5 = obj2;
                    castList2 = castList;
                    arrayList = null;
                }
                suggest2 = arrayList;
                if (CollectionsKt.first(data.getEpisodes()) == null) {
                    $this$mapTo$iv = CollectionsKt.filterNotNull(data.getEpisodes());
                    destination$iv = episodes;
                    $i$f$mapTo = 0;
                    it = $this$mapTo$iv.iterator();
                    while (it.hasNext()) {
                        Object item$iv2 = it.next();
                        Iterable $this$mapTo$iv3 = $this$mapTo$iv;
                        final com.horis.cncverse.entities.Episode it5 = (com.horis.cncverse.entities.Episode) item$iv2;
                        destination$iv.add(MainAPIKt.newEpisode($this4, new LoadData(title, it5.getId()), new Function1() { // from class: com.horis.cncverse.DisneyStudioProvider$$ExternalSyntheticLambda4
                            public final Object invoke(Object obj6) {
                                return DisneyStudioProvider.load$lambda$6$0(it5, (Episode) obj6);
                            }
                        }));
                        $this$mapTo$iv = $this$mapTo$iv3;
                        $i$f$mapTo = $i$f$mapTo;
                        it = it;
                        runTime = runTime;
                    }
                    runTime2 = runTime;
                    nextPageShow = data.getNextPageShow();
                    if (nextPageShow == null) {
                        String nextPageSeason2 = data.getNextPageSeason();
                        Intrinsics.checkNotNull(nextPageSeason2);
                        c00052.L$0 = $this4;
                        c00052.L$1 = rating;
                        c00052.L$2 = id2;
                        c00052.L$3 = data;
                        c00052.L$4 = episodes;
                        c00052.L$5 = title;
                        c00052.L$6 = SpillingKt.nullOutSpilledVariable(castList2);
                        c00052.L$7 = cast2;
                        c00052.L$8 = genre2;
                        c00052.L$9 = rating2;
                        c00052.L$10 = suggest2;
                        c00052.L$11 = episodes;
                        c00052.I$0 = runTime2;
                        c00052.label = 3;
                        episodes2 = $this4.getEpisodes(title, rating, nextPageSeason2, 2, c00052);
                        obj5 = obj5;
                        if (episodes2 == obj5) {
                            return obj5;
                        }
                        id3 = id2;
                        episodes3 = episodes;
                        genre3 = genre2;
                        id4 = rating2;
                        url4 = rating;
                        runTime3 = runTime2;
                        castList3 = castList2;
                        suggest3 = suggest2;
                        $this5 = $this4;
                        title2 = title;
                        arrayList2 = episodes3;
                        arrayList2.addAll((Collection) episodes2);
                        $this6 = $this5;
                        url5 = url4;
                        suggest2 = suggest3;
                        castList2 = castList3;
                        title3 = title2;
                        episodes4 = episodes3;
                        url6 = id3;
                        data2 = data;
                        season = data2.getSeason();
                        if (season != null) {
                        }
                        suggest4 = suggest2;
                        runTime4 = runTime3;
                        $this7 = $this6;
                        title = title3;
                        rating = url5;
                        rating3 = id4;
                        genre4 = genre3;
                        cast3 = cast2;
                        data3 = data2;
                        id5 = url6;
                        castList4 = castList2;
                        episodes5 = episodes4;
                        break;
                    }
                    url5 = rating;
                    url6 = id2;
                    id4 = rating2;
                    title3 = title;
                    $this6 = $this4;
                    episodes4 = episodes;
                    genre3 = genre2;
                    runTime3 = runTime2;
                    data2 = data;
                    season = data2.getSeason();
                    if (season != null) {
                    }
                    suggest4 = suggest2;
                    runTime4 = runTime3;
                    $this7 = $this6;
                    title = title3;
                    rating = url5;
                    rating3 = id4;
                    genre4 = genre3;
                    cast3 = cast2;
                    data3 = data2;
                    id5 = url6;
                    castList4 = castList2;
                    episodes5 = episodes4;
                    break;
                } else {
                    Boxing.boxBoolean(episodes.add(MainAPIKt.newEpisode($this4, new LoadData(title, id2), new Function1() { // from class: com.horis.cncverse.DisneyStudioProvider$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj6) {
                            return DisneyStudioProvider.load$lambda$5(data, (Episode) obj6);
                        }
                    })));
                    suggest4 = suggest2;
                    genre4 = genre2;
                    rating3 = rating2;
                    $this7 = $this4;
                    id5 = id2;
                    episodes5 = episodes;
                    cast3 = cast2;
                    runTime4 = runTime;
                    data3 = data;
                    castList4 = castList2;
                    obj5 = obj5;
                }
                if (CollectionsKt.first(data3.getEpisodes()) == null) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                TvType type2 = tvType;
                C00075 c00076 = new C00075(id5, $this7, data3, genre4, cast3, rating3, runTime4, suggest4, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable($this7);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(rating);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(id5);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(episodes5);
                c00052.L$5 = SpillingKt.nullOutSpilledVariable(title);
                c00052.L$6 = SpillingKt.nullOutSpilledVariable(castList4);
                c00052.L$7 = SpillingKt.nullOutSpilledVariable(cast3);
                c00052.L$8 = SpillingKt.nullOutSpilledVariable(genre4);
                c00052.L$9 = SpillingKt.nullOutSpilledVariable(rating3);
                c00052.L$10 = SpillingKt.nullOutSpilledVariable(suggest4);
                c00052.L$11 = SpillingKt.nullOutSpilledVariable(type2);
                c00052.I$0 = runTime4;
                c00052.label = 5;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse($this7, title, rating, type2, episodes5, c00076, c00052);
                if (objNewTvSeriesLoadResponse == obj5) {
                    return obj5;
                }
                return objNewTvSeriesLoadResponse;
            case 2:
                String id6 = (String) c00052.L$2;
                String url8 = (String) c00052.L$1;
                DisneyStudioProvider $this11 = (DisneyStudioProvider) c00052.L$0;
                ResultKt.throwOnFailure($result);
                $this4 = $this11;
                obj2 = coroutine_suspended;
                id2 = id6;
                rating = url8;
                obj4 = $result;
                NiceResponse this_$iv3 = (NiceResponse) obj4;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                data = (PostData) parser3.parse(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(PostData.class));
                episodes = new ArrayList();
                title = data.getTitle();
                cast = data.getCast();
                if (cast != null) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    listEmptyList = CollectionsKt.emptyList();
                }
                castList = listEmptyList;
                $this$map$iv = castList;
                $i$f$map = 0;
                destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                while (r17.hasNext()) {
                    destination$iv$iv.add(new ActorData(new Actor((String) item$iv$iv2, (String) null, 2, (DefaultConstructorMarker) null), (ActorRole) null, (String) null, (Actor) null, 14, (DefaultConstructorMarker) null));
                    $this$map$iv = $this$map$iv;
                    $result = $result;
                    $i$f$map = $i$f$map;
                }
                cast2 = (List) destination$iv$iv;
                genre = data.getGenre();
                if (genre != null) {
                    list = null;
                } else {
                    list = null;
                }
                genre2 = list;
                match = data.getMatch();
                if (match != null) {
                    strReplace$default = StringsKt.replace$default(match, "IMDb ", "", false, 4, (Object) null);
                } else {
                    strReplace$default = null;
                }
                rating2 = strReplace$default;
                runTime = UtilsKt.convertRuntimeToMinutes(String.valueOf(data.getRuntime()));
                suggest = data.getSuggest();
                if (suggest != null) {
                    $this$map$iv2 = suggest;
                    int $i$f$map4 = CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10);
                    destination$iv$iv2 = new ArrayList($i$f$map4);
                    $this$mapTo$iv$iv = $this$map$iv2;
                    while (r17.hasNext()) {
                        Iterable $this$map$iv7 = $this$map$iv2;
                        final Suggest it6 = (Suggest) item$iv$iv4;
                        destination$iv$iv2.add(MainAPIKt.newAnimeSearchResponse$default($this4, "", AppUtils.INSTANCE.toJson(new Id(it6.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cncverse.DisneyStudioProvider$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj6) {
                                return DisneyStudioProvider.load$lambda$4$0(it6, $this4, (AnimeSearchResponse) obj6);
                            }
                        }, 12, (Object) null));
                        $this$map$iv2 = $this$map$iv7;
                        castList = castList;
                        $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                        obj2 = obj2;
                    }
                    obj5 = obj2;
                    castList2 = castList;
                    arrayList = (List) destination$iv$iv2;
                } else {
                    obj5 = obj2;
                    castList2 = castList;
                    arrayList = null;
                }
                suggest2 = arrayList;
                if (CollectionsKt.first(data.getEpisodes()) == null) {
                    $this$mapTo$iv = CollectionsKt.filterNotNull(data.getEpisodes());
                    destination$iv = episodes;
                    $i$f$mapTo = 0;
                    it = $this$mapTo$iv.iterator();
                    while (it.hasNext()) {
                        Object item$iv3 = it.next();
                        Iterable $this$mapTo$iv4 = $this$mapTo$iv;
                        final com.horis.cncverse.entities.Episode it7 = (com.horis.cncverse.entities.Episode) item$iv3;
                        destination$iv.add(MainAPIKt.newEpisode($this4, new LoadData(title, it7.getId()), new Function1() { // from class: com.horis.cncverse.DisneyStudioProvider$$ExternalSyntheticLambda4
                            public final Object invoke(Object obj6) {
                                return DisneyStudioProvider.load$lambda$6$0(it7, (Episode) obj6);
                            }
                        }));
                        $this$mapTo$iv = $this$mapTo$iv4;
                        $i$f$mapTo = $i$f$mapTo;
                        it = it;
                        runTime = runTime;
                    }
                    runTime2 = runTime;
                    nextPageShow = data.getNextPageShow();
                    if (nextPageShow == null) {
                        String nextPageSeason3 = data.getNextPageSeason();
                        Intrinsics.checkNotNull(nextPageSeason3);
                        c00052.L$0 = $this4;
                        c00052.L$1 = rating;
                        c00052.L$2 = id2;
                        c00052.L$3 = data;
                        c00052.L$4 = episodes;
                        c00052.L$5 = title;
                        c00052.L$6 = SpillingKt.nullOutSpilledVariable(castList2);
                        c00052.L$7 = cast2;
                        c00052.L$8 = genre2;
                        c00052.L$9 = rating2;
                        c00052.L$10 = suggest2;
                        c00052.L$11 = episodes;
                        c00052.I$0 = runTime2;
                        c00052.label = 3;
                        episodes2 = $this4.getEpisodes(title, rating, nextPageSeason3, 2, c00052);
                        obj5 = obj5;
                        if (episodes2 == obj5) {
                            return obj5;
                        }
                        id3 = id2;
                        episodes3 = episodes;
                        genre3 = genre2;
                        id4 = rating2;
                        url4 = rating;
                        runTime3 = runTime2;
                        castList3 = castList2;
                        suggest3 = suggest2;
                        $this5 = $this4;
                        title2 = title;
                        arrayList2 = episodes3;
                        arrayList2.addAll((Collection) episodes2);
                        $this6 = $this5;
                        url5 = url4;
                        suggest2 = suggest3;
                        castList2 = castList3;
                        title3 = title2;
                        episodes4 = episodes3;
                        url6 = id3;
                        data2 = data;
                        season = data2.getSeason();
                        if (season != null) {
                        }
                        suggest4 = suggest2;
                        runTime4 = runTime3;
                        $this7 = $this6;
                        title = title3;
                        rating = url5;
                        rating3 = id4;
                        genre4 = genre3;
                        cast3 = cast2;
                        data3 = data2;
                        id5 = url6;
                        castList4 = castList2;
                        episodes5 = episodes4;
                        break;
                    }
                    url5 = rating;
                    url6 = id2;
                    id4 = rating2;
                    title3 = title;
                    $this6 = $this4;
                    episodes4 = episodes;
                    genre3 = genre2;
                    runTime3 = runTime2;
                    data2 = data;
                    season = data2.getSeason();
                    if (season != null) {
                    }
                    suggest4 = suggest2;
                    runTime4 = runTime3;
                    $this7 = $this6;
                    title = title3;
                    rating = url5;
                    rating3 = id4;
                    genre4 = genre3;
                    cast3 = cast2;
                    data3 = data2;
                    id5 = url6;
                    castList4 = castList2;
                    episodes5 = episodes4;
                    break;
                } else {
                    Boxing.boxBoolean(episodes.add(MainAPIKt.newEpisode($this4, new LoadData(title, id2), new Function1() { // from class: com.horis.cncverse.DisneyStudioProvider$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj6) {
                            return DisneyStudioProvider.load$lambda$5(data, (Episode) obj6);
                        }
                    })));
                    suggest4 = suggest2;
                    genre4 = genre2;
                    rating3 = rating2;
                    $this7 = $this4;
                    id5 = id2;
                    episodes5 = episodes;
                    cast3 = cast2;
                    runTime4 = runTime;
                    data3 = data;
                    castList4 = castList2;
                    obj5 = obj5;
                }
                if (CollectionsKt.first(data3.getEpisodes()) == null) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                TvType type3 = tvType;
                C00075 c00077 = new C00075(id5, $this7, data3, genre4, cast3, rating3, runTime4, suggest4, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable($this7);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(rating);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(id5);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(episodes5);
                c00052.L$5 = SpillingKt.nullOutSpilledVariable(title);
                c00052.L$6 = SpillingKt.nullOutSpilledVariable(castList4);
                c00052.L$7 = SpillingKt.nullOutSpilledVariable(cast3);
                c00052.L$8 = SpillingKt.nullOutSpilledVariable(genre4);
                c00052.L$9 = SpillingKt.nullOutSpilledVariable(rating3);
                c00052.L$10 = SpillingKt.nullOutSpilledVariable(suggest4);
                c00052.L$11 = SpillingKt.nullOutSpilledVariable(type3);
                c00052.I$0 = runTime4;
                c00052.label = 5;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse($this7, title, rating, type3, episodes5, c00077, c00052);
                if (objNewTvSeriesLoadResponse == obj5) {
                    return obj5;
                }
                return objNewTvSeriesLoadResponse;
            case 3:
                int runTime5 = c00052.I$0;
                arrayList2 = (ArrayList) c00052.L$11;
                suggest3 = (List) c00052.L$10;
                id4 = (String) c00052.L$9;
                genre3 = (List) c00052.L$8;
                cast2 = (List) c00052.L$7;
                castList3 = (List) c00052.L$6;
                String title6 = (String) c00052.L$5;
                episodes3 = (ArrayList) c00052.L$4;
                data = (PostData) c00052.L$3;
                id3 = (String) c00052.L$2;
                String url9 = (String) c00052.L$1;
                $this5 = (DisneyStudioProvider) c00052.L$0;
                ResultKt.throwOnFailure($result);
                obj5 = coroutine_suspended;
                title2 = title6;
                runTime3 = runTime5;
                url4 = url9;
                episodes2 = $result;
                arrayList2.addAll((Collection) episodes2);
                $this6 = $this5;
                url5 = url4;
                suggest2 = suggest3;
                castList2 = castList3;
                title3 = title2;
                episodes4 = episodes3;
                url6 = id3;
                data2 = data;
                season = data2.getSeason();
                if (season != null) {
                    break;
                }
                suggest4 = suggest2;
                runTime4 = runTime3;
                $this7 = $this6;
                title = title3;
                rating = url5;
                rating3 = id4;
                genre4 = genre3;
                cast3 = cast2;
                data3 = data2;
                id5 = url6;
                castList4 = castList2;
                episodes5 = episodes4;
                if (CollectionsKt.first(data3.getEpisodes()) == null) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                TvType type4 = tvType;
                C00075 c00078 = new C00075(id5, $this7, data3, genre4, cast3, rating3, runTime4, suggest4, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable($this7);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(rating);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(id5);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(episodes5);
                c00052.L$5 = SpillingKt.nullOutSpilledVariable(title);
                c00052.L$6 = SpillingKt.nullOutSpilledVariable(castList4);
                c00052.L$7 = SpillingKt.nullOutSpilledVariable(cast3);
                c00052.L$8 = SpillingKt.nullOutSpilledVariable(genre4);
                c00052.L$9 = SpillingKt.nullOutSpilledVariable(rating3);
                c00052.L$10 = SpillingKt.nullOutSpilledVariable(suggest4);
                c00052.L$11 = SpillingKt.nullOutSpilledVariable(type4);
                c00052.I$0 = runTime4;
                c00052.label = 5;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse($this7, title, rating, type4, episodes5, c00078, c00052);
                if (objNewTvSeriesLoadResponse == obj5) {
                    return obj5;
                }
                return objNewTvSeriesLoadResponse;
            case 4:
                runTime3 = c00052.I$0;
                suggest5 = (List) c00052.L$10;
                title5 = (String) c00052.L$9;
                genre5 = (List) c00052.L$8;
                cast4 = (List) c00052.L$7;
                castList5 = (List) c00052.L$6;
                title4 = (String) c00052.L$5;
                cast5 = (ArrayList) c00052.L$4;
                data2 = (PostData) c00052.L$3;
                String id7 = (String) c00052.L$2;
                String url10 = (String) c00052.L$1;
                $this8 = (DisneyStudioProvider) c00052.L$0;
                ResultKt.throwOnFailure($result);
                obj5 = coroutine_suspended;
                url7 = url10;
                url6 = id7;
                $this7 = $this8;
                runTime4 = runTime3;
                suggest4 = suggest5;
                rating3 = title5;
                genre4 = genre5;
                cast3 = cast4;
                title = title4;
                data3 = data2;
                id5 = url6;
                rating = url7;
                castList4 = castList5;
                episodes5 = cast5;
                if (CollectionsKt.first(data3.getEpisodes()) == null) {
                    tvType = TvType.Movie;
                } else {
                    tvType = TvType.TvSeries;
                }
                TvType type5 = tvType;
                C00075 c00079 = new C00075(id5, $this7, data3, genre4, cast3, rating3, runTime4, suggest4, null);
                c00052.L$0 = SpillingKt.nullOutSpilledVariable($this7);
                c00052.L$1 = SpillingKt.nullOutSpilledVariable(rating);
                c00052.L$2 = SpillingKt.nullOutSpilledVariable(id5);
                c00052.L$3 = SpillingKt.nullOutSpilledVariable(data3);
                c00052.L$4 = SpillingKt.nullOutSpilledVariable(episodes5);
                c00052.L$5 = SpillingKt.nullOutSpilledVariable(title);
                c00052.L$6 = SpillingKt.nullOutSpilledVariable(castList4);
                c00052.L$7 = SpillingKt.nullOutSpilledVariable(cast3);
                c00052.L$8 = SpillingKt.nullOutSpilledVariable(genre4);
                c00052.L$9 = SpillingKt.nullOutSpilledVariable(rating3);
                c00052.L$10 = SpillingKt.nullOutSpilledVariable(suggest4);
                c00052.L$11 = SpillingKt.nullOutSpilledVariable(type5);
                c00052.I$0 = runTime4;
                c00052.label = 5;
                objNewTvSeriesLoadResponse = MainAPIKt.newTvSeriesLoadResponse($this7, title, rating, type5, episodes5, c00079, c00052);
                if (objNewTvSeriesLoadResponse == obj5) {
                    return obj5;
                }
                return objNewTvSeriesLoadResponse;
            case 5:
                int i = c00052.I$0;
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$4$0(Suggest $it, DisneyStudioProvider this$0, AnimeSearchResponse $this$newAnimeSearchResponse) {
        $this$newAnimeSearchResponse.setPosterUrl("https://imgcdn.kim/hs/v/" + $it.getId() + ".jpg");
        $this$newAnimeSearchResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this$0.getMainUrl() + "/home")));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$5(PostData $data, Episode $this$newEpisode) {
        $this$newEpisode.setName($data.getTitle());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit load$lambda$6$0(com.horis.cncverse.entities.Episode $it, Episode $this$newEpisode) {
        $this$newEpisode.setName($it.getT());
        $this$newEpisode.setEpisode(StringsKt.toIntOrNull(StringsKt.replace$default($it.getEp(), "E", "", false, 4, (Object) null)));
        $this$newEpisode.setSeason(StringsKt.toIntOrNull(StringsKt.replace$default($it.getS(), "S", "", false, 4, (Object) null)));
        $this$newEpisode.setPosterUrl("https://imgcdn.kim/hsepimg/150/" + $it.getId() + ".jpg");
        $this$newEpisode.setRunTime(StringsKt.toIntOrNull(StringsKt.replace$default($it.getTime(), "m", "", false, 4, (Object) null)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.horis.cncverse.DisneyStudioProvider$load$4 */
    /* JADX INFO: compiled from: DisneyStudioProvider.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/horis/cncverse/entities/Season;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.DisneyStudioProvider$load$4", f = "DisneyStudioProvider.kt", i = {0}, l = {173}, m = "invokeSuspend", n = {"it"}, nl = {-1}, s = {"L$0"}, v = 2)
    static final class C00064 extends SuspendLambda implements Function2<Season, Continuation<? super Boolean>, Object> {
        final /* synthetic */ ArrayList<Episode> $episodes;
        final /* synthetic */ String $title;
        final /* synthetic */ String $url;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ DisneyStudioProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00064(ArrayList<Episode> arrayList, DisneyStudioProvider disneyStudioProvider, String str, String str2, Continuation<? super C00064> continuation) {
            super(2, continuation);
            this.$episodes = arrayList;
            this.this$0 = disneyStudioProvider;
            this.$title = str;
            this.$url = str2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00064 = new C00064(this.$episodes, this.this$0, this.$title, this.$url, continuation);
            c00064.L$0 = obj;
            return c00064;
        }

        public final Object invoke(Season season, Continuation<? super Boolean> continuation) {
            return create(season, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object episodes;
            ArrayList<Episode> arrayList;
            Season it = (Season) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    ArrayList<Episode> arrayList2 = this.$episodes;
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.L$1 = arrayList2;
                    this.label = 1;
                    episodes = this.this$0.getEpisodes(this.$title, this.$url, it.getId(), 1, (Continuation) this);
                    if (episodes == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    arrayList = arrayList2;
                    break;
                    break;
                case 1:
                    arrayList = (ArrayList) this.L$1;
                    ResultKt.throwOnFailure($result);
                    episodes = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Boxing.boxBoolean(arrayList.addAll((Collection) episodes));
        }
    }

    /* JADX INFO: renamed from: com.horis.cncverse.DisneyStudioProvider$load$5 */
    /* JADX INFO: compiled from: DisneyStudioProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/TvSeriesLoadResponse;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.DisneyStudioProvider$load$5", f = "DisneyStudioProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00075 extends SuspendLambda implements Function2<TvSeriesLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<ActorData> $cast;
        final /* synthetic */ PostData $data;
        final /* synthetic */ List<String> $genre;
        final /* synthetic */ String $id;
        final /* synthetic */ String $rating;
        final /* synthetic */ int $runTime;
        final /* synthetic */ List<AnimeSearchResponse> $suggest;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DisneyStudioProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00075(String str, DisneyStudioProvider disneyStudioProvider, PostData postData, List<String> list, List<ActorData> list2, String str2, int i, List<AnimeSearchResponse> list3, Continuation<? super C00075> continuation) {
            super(2, continuation);
            this.$id = str;
            this.this$0 = disneyStudioProvider;
            this.$data = postData;
            this.$genre = list;
            this.$cast = list2;
            this.$rating = str2;
            this.$runTime = i;
            this.$suggest = list3;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00075 = new C00075(this.$id, this.this$0, this.$data, this.$genre, this.$cast, this.$rating, this.$runTime, this.$suggest, continuation);
            c00075.L$0 = obj;
            return c00075;
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
                    $this$newTvSeriesLoadResponse.setPosterUrl("https://imgcdn.kim/hs/v/" + this.$id + ".jpg");
                    $this$newTvSeriesLoadResponse.setBackgroundPosterUrl("https://imgcdn.kim/hs/h/" + this.$id + ".jpg");
                    $this$newTvSeriesLoadResponse.setPosterHeaders(MapsKt.mapOf(TuplesKt.to("Referer", this.this$0.getMainUrl() + "/home")));
                    $this$newTvSeriesLoadResponse.setPlot(this.$data.getDesc());
                    $this$newTvSeriesLoadResponse.setYear(StringsKt.toIntOrNull(this.$data.getYear()));
                    $this$newTvSeriesLoadResponse.setTags(this.$genre);
                    $this$newTvSeriesLoadResponse.setActors(this.$cast);
                    $this$newTvSeriesLoadResponse.setScore(Score.Companion.from10(this.$rating));
                    $this$newTvSeriesLoadResponse.setDuration(Boxing.boxInt(this.$runTime));
                    $this$newTvSeriesLoadResponse.setContentRating(this.$data.getUa());
                    $this$newTvSeriesLoadResponse.setRecommendations(this.$suggest);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x011b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:17:0x011c  */
    /* JADX WARN: Code duplicated, block: B:20:0x0149  */
    /* JADX WARN: Code duplicated, block: B:23:0x0159 A[LOOP:0: B:21:0x0153->B:23:0x0159, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:25:0x0195  */
    /* JADX WARN: Code duplicated, block: B:28:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x011c -> B:18:0x0127). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public final java.lang.Object getEpisodes(java.lang.String r28, java.lang.String r29, java.lang.String r30, int r31, kotlin.coroutines.Continuation<? super java.util.List<com.lagradost.cloudstream3.Episode>> r32) {
        /*
            Method dump skipped, instruction units count: 440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horis.cncverse.DisneyStudioProvider.getEpisodes(java.lang.String, java.lang.String, java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getEpisodes$lambda$0$0(com.horis.cncverse.entities.Episode $it, Episode $this$newEpisode) {
        $this$newEpisode.setName($it.getT());
        $this$newEpisode.setEpisode(StringsKt.toIntOrNull(StringsKt.replace$default($it.getEp(), "E", "", false, 4, (Object) null)));
        $this$newEpisode.setSeason(StringsKt.toIntOrNull(StringsKt.replace$default($it.getS(), "S", "", false, 4, (Object) null)));
        $this$newEpisode.setPosterUrl("https://imgcdn.kim/hsepimg/" + $it.getId() + ".jpg");
        $this$newEpisode.setRunTime(StringsKt.toIntOrNull(StringsKt.replace$default($it.getTime(), "m", "", false, 4, (Object) null)));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x03e7  */
    /* JADX WARN: Code duplicated, block: B:30:0x040a  */
    /* JADX WARN: Code duplicated, block: B:33:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:37:0x04d8  */
    /* JADX WARN: Code duplicated, block: B:40:0x04f0  */
    /* JADX WARN: Code duplicated, block: B:42:0x050a  */
    /* JADX WARN: Code duplicated, block: B:53:0x0666  */
    /* JADX WARN: Code duplicated, block: B:58:0x04a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x050d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0513 -> B:45:0x0549). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x05f5 -> B:51:0x0619). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0666 -> B:25:0x03e1). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    static /* synthetic */ java.lang.Object loadLinks$suspendImpl(com.horis.cncverse.DisneyStudioProvider r37, java.lang.String r38, boolean r39, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r40, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r41, kotlin.coroutines.Continuation<? super java.lang.Boolean> r42) {
        /*
            Method dump skipped, instruction units count: 1674
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horis.cncverse.DisneyStudioProvider.loadLinks$suspendImpl(com.horis.cncverse.DisneyStudioProvider, java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence loadLinks$lambda$0(Map.Entry it) {
        return ((String) it.getKey()) + '=' + ((String) it.getValue());
    }

    /* JADX INFO: renamed from: com.horis.cncverse.DisneyStudioProvider$loadLinks$2 */
    /* JADX INFO: compiled from: DisneyStudioProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.DisneyStudioProvider$loadLinks$2", f = "DisneyStudioProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00092 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $playlistHeaders;
        final /* synthetic */ Source $source;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ DisneyStudioProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00092(Map<String, String> map, DisneyStudioProvider disneyStudioProvider, Source source, Continuation<? super C00092> continuation) {
            super(2, continuation);
            this.$playlistHeaders = map;
            this.this$0 = disneyStudioProvider;
            this.$source = source;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00092 = new C00092(this.$playlistHeaders, this.this$0, this.$source, continuation);
            c00092.L$0 = obj;
            return c00092;
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
                    $this$newExtractorLink.setHeaders(this.$playlistHeaders);
                    $this$newExtractorLink.setReferer(this.this$0.getMainUrl() + "/mobile/home?app=1");
                    $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(StringsKt.substringAfter(this.$source.getFile(), "q=", "")));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: compiled from: DisneyStudioProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/horis/cncverse/DisneyStudioProvider$Id;", "", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "CNC Verse Mobile_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class Id {

        @NotNull
        private final String id;

        public static /* synthetic */ Id copy$default(Id id, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = id.id;
            }
            return id.copy(str);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final Id copy(@NotNull String id) {
            return new Id(id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Id) && Intrinsics.areEqual(this.id, ((Id) other).id);
        }

        public int hashCode() {
            return this.id.hashCode();
        }

        @NotNull
        public String toString() {
            return "Id(id=" + this.id + ')';
        }

        public Id(@NotNull String id) {
            this.id = id;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }
    }

    /* JADX INFO: compiled from: DisneyStudioProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/horis/cncverse/DisneyStudioProvider$LoadData;", "", "title", "", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CNC Verse Mobile_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class LoadData {

        @NotNull
        private final String id;

        @NotNull
        private final String title;

        public static /* synthetic */ LoadData copy$default(LoadData loadData, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loadData.title;
            }
            if ((i & 2) != 0) {
                str2 = loadData.id;
            }
            return loadData.copy(str, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final LoadData copy(@NotNull String title, @NotNull String id) {
            return new LoadData(title, id);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadData)) {
                return false;
            }
            LoadData loadData = (LoadData) other;
            return Intrinsics.areEqual(this.title, loadData.title) && Intrinsics.areEqual(this.id, loadData.id);
        }

        public int hashCode() {
            return (this.title.hashCode() * 31) + this.id.hashCode();
        }

        @NotNull
        public String toString() {
            return "LoadData(title=" + this.title + ", id=" + this.id + ')';
        }

        public LoadData(@NotNull String title, @NotNull String id) {
            this.title = title;
            this.id = id;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }
    }
}
