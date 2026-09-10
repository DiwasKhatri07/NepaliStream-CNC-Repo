package com.horis.cncverse;

import android.content.Context;
import com.cncverse.donation.DonationManager;
import com.horis.cncverse.entities.PostData;
import com.horis.cncverse.entities.Season;
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
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: DisneyStudioProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/CNC_Verse/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 @2\u00020\u0001:\u0003@ABB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001dH\u0002J \u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0096@¢\u0006\u0002\u0010%J\f\u0010&\u001a\u00020'*\u00020(H\u0002J\u000e\u0010)\u001a\u0004\u0018\u00010**\u00020(H\u0002J\u0018\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010.J4\u0010/\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"H\u0082@¢\u0006\u0002\u00105JF\u00106\u001a\u00020\u00182\u0006\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00182\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<0:2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020<0:H\u0096@¢\u0006\u0002\u0010?R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u0018X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/horis/cncverse/DisneyStudioProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "studio", "", "displayName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "lang", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "cookie_value", "headers", "", "buildCookies", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toHomePageList", "Lcom/lagradost/cloudstream3/HomePageList;", "Lorg/jsoup/nodes/Element;", "toSearchResult", "Lcom/lagradost/cloudstream3/SearchResponse;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEpisodes", "", "Lcom/lagradost/cloudstream3/Episode;", "title", "eid", "sid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Id", "LoadData", "CNC Verse_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDisneyStudioProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DisneyStudioProvider.kt\ncom/horis/cncverse/DisneyStudioProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Utils.kt\ncom/horis/cncverse/UtilsKt\n+ 5 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,254:1\n1586#2:255\n1661#2,3:256\n1642#2,10:259\n1915#2:269\n1916#2:271\n1652#2:272\n1586#2:275\n1661#2,3:276\n1586#2:279\n1661#2,3:280\n1586#2:283\n1661#2,3:284\n777#2:287\n873#2,2:288\n1586#2:290\n1661#2,3:291\n1661#2,3:294\n1661#2,3:298\n1#3:270\n66#4:273\n66#4:301\n62#5:274\n62#5:297\n62#5:302\n62#5:303\n*S KotlinDebug\n*F\n+ 1 DisneyStudioProvider.kt\ncom/horis/cncverse/DisneyStudioProvider\n*L\n78#1:255\n78#1:256,3\n86#1:259,10\n86#1:269\n86#1:271\n86#1:272\n129#1:275\n129#1:276,3\n130#1:279\n130#1:280,3\n136#1:283\n136#1:284,3\n137#1:287\n137#1:288,2\n142#1:290\n142#1:291,3\n154#1:294,3\n202#1:298,3\n86#1:270\n118#1:273\n225#1:301\n124#1:274\n201#1:297\n230#1:302\n237#1:303\n*E\n"})
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
    private final Map<String, String> headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"), TuplesKt.to("Accept-Language", "en-IN,en-US;q=0.9,en;q=0.8"), TuplesKt.to("Cache-Control", "max-age=0"), TuplesKt.to("Connection", "keep-alive"), TuplesKt.to("sec-ch-ua", "\"Not(A:Brand\";v=\"8\", \"Chromium\";v=\"144\", \"Android WebView\";v=\"144\""), TuplesKt.to("sec-ch-ua-mobile", "?0"), TuplesKt.to("sec-ch-ua-platform", "\"Android\""), TuplesKt.to("Sec-Fetch-Dest", "document"), TuplesKt.to("Sec-Fetch-Mode", "navigate"), TuplesKt.to("Sec-Fetch-Site", "same-origin"), TuplesKt.to("Sec-Fetch-User", "?1"), TuplesKt.to("Upgrade-Insecure-Requests", "1"), TuplesKt.to("User-Agent", "Mozilla/5.0 (Linux; Android 13; Pixel 5 Build/TQ3A.230901.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/144.0.7559.132 Safari/537.36 /OS.Gatu v3.0"), TuplesKt.to("X-Requested-With", "XMLHttpRequest")});

    /* JADX INFO: renamed from: com.horis.cncverse.DisneyStudioProvider$getEpisodes$1 */
    /* JADX INFO: compiled from: DisneyStudioProvider.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.DisneyStudioProvider", f = "DisneyStudioProvider.kt", i = {0, 0, 0, 0, 0, 0}, l = {196}, m = "getEpisodes", n = {"title", "eid", "sid", "episodes", "page", "pg"}, nl = {201}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 2)
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
    @DebugMetadata(c = "com.horis.cncverse.DisneyStudioProvider", f = "DisneyStudioProvider.kt", i = {0, 0, 0, 1, 1, 1}, l = {71, 72}, m = "getMainPage$suspendImpl", n = {"$this", "request", "page", "$this", "request", "page"}, nl = {72, 77}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0"}, v = 2)
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
    @DebugMetadata(c = "com.horis.cncverse.DisneyStudioProvider", f = "DisneyStudioProvider.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {117, 119, 165, 168, 175}, m = "load$suspendImpl", n = {"$this", "url", "$this", "url", "id", "$this", "url", "id", "data", "episodes", "title", "castList", "cast", "genre", "rating", "suggest", "runTime", "$this", "url", "id", "data", "episodes", "title", "castList", "cast", "genre", "rating", "suggest", "runTime", "$this", "url", "id", "data", "episodes", "title", "castList", "cast", "genre", "rating", "suggest", "type", "runTime"}, nl = {118, 124, 168, 173, -1}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0"}, v = 2)
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
    @DebugMetadata(c = "com.horis.cncverse.DisneyStudioProvider", f = "DisneyStudioProvider.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {224, 226, 227, 233, 234, 243}, m = "loadLinks$suspendImpl", n = {"$this", "data", "subtitleCallback", "callback", "isCasting", "$this", "data", "subtitleCallback", "callback", "apiBase", "id", "isCasting", "$this", "data", "subtitleCallback", "callback", "apiBase", "id", "userToken", "response", "isCasting", "$this", "data", "subtitleCallback", "callback", "apiBase", "id", "userToken", "response", "isCasting", "$this", "data", "subtitleCallback", "callback", "apiBase", "id", "userToken", "response", "isCasting", "$this", "data", "subtitleCallback", "callback", "apiBase", "id", "userToken", "response", "isCasting"}, nl = {225, 227, 230, 234, 237, 242}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "Z$0"}, v = 2)
    static final class C00081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
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
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/horis/cncverse/DisneyStudioProvider$Companion;", "", "<init>", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "CNC Verse_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
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

    /* JADX WARN: Code duplicated, block: B:27:0x0129 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x012a  */
    /* JADX WARN: Code duplicated, block: B:32:0x0159 A[LOOP:0: B:30:0x0153->B:32:0x0159, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getMainPage$suspendImpl(DisneyStudioProvider $this, int page, MainPageRequest request, Continuation<? super HomePageResponse> continuation) throws Exception {
        C00041 c00041;
        String str;
        MainPageRequest request2;
        DisneyStudioProvider $this2;
        int page2;
        int page3;
        MainPageRequest request3;
        Object obj;
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
                if ($this5.cookie_value.length() == 0) {
                    String mainUrl = $this5.getMainUrl();
                    c00041.L$0 = $this5;
                    c00041.L$1 = SpillingKt.nullOutSpilledVariable(request);
                    c00041.L$2 = $this5;
                    page3 = page;
                    c00041.I$0 = page3;
                    c00041.label = 1;
                    Object objBypass = UtilsKt.bypass(mainUrl, c00041);
                    if (objBypass == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    request3 = request;
                    obj = objBypass;
                    $this2 = $this5;
                    str = (String) obj;
                    request2 = request3;
                    page2 = page3;
                } else {
                    str = $this5.cookie_value;
                    request2 = request;
                    $this2 = $this5;
                    page2 = page;
                }
                $this5.cookie_value = str;
                Requests app = UtilsKt.getApp();
                String str2 = $this2.getMainUrl() + "/mobile/home?app=1";
                Map<String, String> mapBuildCookies = $this2.buildCookies();
                Map<String, String> map = $this2.headers;
                String str3 = $this2.getMainUrl() + "/mobile/home?app=1";
                c00041.L$0 = $this2;
                c00041.L$1 = SpillingKt.nullOutSpilledVariable(request2);
                c00041.L$2 = null;
                c00041.I$0 = page2;
                c00041.label = 2;
                $this3 = $this2;
                $result = Requests.get$default(app, str2, map, str3, (Map) null, mapBuildCookies, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00041, 4072, (Object) null);
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
                int page4 = c00041.I$0;
                DisneyStudioProvider disneyStudioProvider = (DisneyStudioProvider) c00041.L$2;
                MainPageRequest request4 = (MainPageRequest) c00041.L$1;
                DisneyStudioProvider $this6 = (DisneyStudioProvider) c00041.L$0;
                ResultKt.throwOnFailure($result);
                $this2 = $this6;
                $this5 = disneyStudioProvider;
                request3 = request4;
                page3 = page4;
                obj = $result;
                str = (String) obj;
                request2 = request3;
                page2 = page3;
                $this5.cookie_value = str;
                Requests app2 = UtilsKt.getApp();
                String str4 = $this2.getMainUrl() + "/mobile/home?app=1";
                Map<String, String> mapBuildCookies2 = $this2.buildCookies();
                Map<String, String> map2 = $this2.headers;
                String str5 = $this2.getMainUrl() + "/mobile/home?app=1";
                c00041.L$0 = $this2;
                c00041.L$1 = SpillingKt.nullOutSpilledVariable(request2);
                c00041.L$2 = null;
                c00041.I$0 = page2;
                c00041.label = 2;
                $this3 = $this2;
                $result = Requests.get$default(app2, str4, map2, str5, (Map) null, mapBuildCookies2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00041, 4072, (Object) null);
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
        return MainAPIKt.newAnimeSearchResponse$default(this, "", AppUtils.INSTANCE.toJson(new Id(id)), (TvType) null, false, new Function1() { // from class: com.horis.cncverse.DisneyStudioProvider$$ExternalSyntheticLambda0
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

    /* JADX WARN: Code duplicated, block: B:109:0x05a4  */
    /* JADX WARN: Code duplicated, block: B:110:0x05a7  */
    /* JADX WARN: Code duplicated, block: B:113:0x0613 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:114:0x0614  */
    /* JADX WARN: Code duplicated, block: B:30:0x01f6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:34:0x022e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0280  */
    /* JADX WARN: Code duplicated, block: B:45:0x02a1 A[LOOP:1: B:43:0x029b->B:45:0x02a1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:48:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:65:0x0385  */
    /* JADX WARN: Code duplicated, block: B:68:0x038d  */
    /* JADX WARN: Code duplicated, block: B:69:0x039c  */
    /* JADX WARN: Code duplicated, block: B:72:0x03b0  */
    /* JADX WARN: Code duplicated, block: B:75:0x03d0 A[LOOP:4: B:73:0x03ca->B:75:0x03d0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:77:0x0423  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x0433  */
    /* JADX WARN: Code duplicated, block: B:81:0x0462  */
    /* JADX WARN: Code duplicated, block: B:84:0x047c A[LOOP:5: B:82:0x0476->B:84:0x047c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:87:0x04bc A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:88:0x04c2  */
    /* JADX WARN: Code duplicated, block: B:92:0x04fc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:93:0x04fd  */
    /* JADX WARN: Code duplicated, block: B:99:0x052b  */
    static /* synthetic */ Object load$suspendImpl(DisneyStudioProvider $this, String url, Continuation<? super LoadResponse> continuation) throws Exception {
        C00051 c00051;
        String url2;
        String str;
        DisneyStudioProvider $this2;
        Object obj;
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
        String id5;
        List episodes5;
        List cast3;
        int runTime4;
        PostData data3;
        List castList4;
        DisneyStudioProvider $this7;
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
                if ($this9.cookie_value.length() == 0) {
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
                    str = (String) obj;
                } else {
                    url2 = url;
                    str = $this9.cookie_value;
                    $this2 = $this9;
                }
                $this9.cookie_value = str;
                String text$iv = url2;
                id = ((Id) UtilsKt.getJSONParser().parse(text$iv, Reflection.getOrCreateKotlinClass(Id.class))).getId();
                Requests app = UtilsKt.getApp();
                String str2 = $this2.getMainUrl() + "/mobile/hs/post.php?id=" + id + "&t=" + APIHolder.INSTANCE.getUnixTime();
                Map<String, String> map = $this2.headers;
                String str3 = $this2.getMainUrl() + "/home";
                Map<String, String> mapBuildCookies = $this2.buildCookies();
                c00052.L$0 = $this2;
                c00052.L$1 = url2;
                c00052.L$2 = id;
                c00052.label = 2;
                url3 = url2;
                $this3 = $this2;
                obj2 = coroutine_suspended;
                obj3 = Requests.get$default(app, str2, map, str3, (Map) null, mapBuildCookies, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00052, 4072, (Object) null);
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
                        destination$iv$iv2.add(MainAPIKt.newAnimeSearchResponse$default($this4, "", AppUtils.INSTANCE.toJson(new Id(it2.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cncverse.DisneyStudioProvider$$ExternalSyntheticLambda1
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
                    Boxing.boxBoolean(episodes.add(MainAPIKt.newEpisode($this4, new LoadData(title, id2), new Function1() { // from class: com.horis.cncverse.DisneyStudioProvider$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj6) {
                            return DisneyStudioProvider.load$lambda$5(data, (Episode) obj6);
                        }
                    })));
                    suggest4 = suggest2;
                    genre4 = genre2;
                    rating3 = rating2;
                    id5 = id2;
                    episodes5 = episodes;
                    cast3 = cast2;
                    runTime4 = runTime;
                    data3 = data;
                    castList4 = castList2;
                    obj5 = obj5;
                    $this7 = $this4;
                } else {
                    $this$mapTo$iv = CollectionsKt.filterNotNull(data.getEpisodes());
                    destination$iv = episodes;
                    $i$f$mapTo = 0;
                    it = $this$mapTo$iv.iterator();
                    while (it.hasNext()) {
                        Object item$iv = it.next();
                        Iterable $this$mapTo$iv2 = $this$mapTo$iv;
                        final com.horis.cncverse.entities.Episode it3 = (com.horis.cncverse.entities.Episode) item$iv;
                        destination$iv.add(MainAPIKt.newEpisode($this4, new LoadData(title, it3.getId()), new Function1() { // from class: com.horis.cncverse.DisneyStudioProvider$$ExternalSyntheticLambda3
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
                str = (String) obj;
                $this9.cookie_value = str;
                String text$iv2 = url2;
                id = ((Id) UtilsKt.getJSONParser().parse(text$iv2, Reflection.getOrCreateKotlinClass(Id.class))).getId();
                Requests app2 = UtilsKt.getApp();
                String str4 = $this2.getMainUrl() + "/mobile/hs/post.php?id=" + id + "&t=" + APIHolder.INSTANCE.getUnixTime();
                Map<String, String> map2 = $this2.headers;
                String str5 = $this2.getMainUrl() + "/home";
                Map<String, String> mapBuildCookies2 = $this2.buildCookies();
                c00052.L$0 = $this2;
                c00052.L$1 = url2;
                c00052.L$2 = id;
                c00052.label = 2;
                url3 = url2;
                $this3 = $this2;
                obj2 = coroutine_suspended;
                obj3 = Requests.get$default(app2, str4, map2, str5, (Map) null, mapBuildCookies2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00052, 4072, (Object) null);
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
                        destination$iv$iv2.add(MainAPIKt.newAnimeSearchResponse$default($this4, "", AppUtils.INSTANCE.toJson(new Id(it4.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cncverse.DisneyStudioProvider$$ExternalSyntheticLambda1
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
                        destination$iv.add(MainAPIKt.newEpisode($this4, new LoadData(title, it5.getId()), new Function1() { // from class: com.horis.cncverse.DisneyStudioProvider$$ExternalSyntheticLambda3
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
                    Boxing.boxBoolean(episodes.add(MainAPIKt.newEpisode($this4, new LoadData(title, id2), new Function1() { // from class: com.horis.cncverse.DisneyStudioProvider$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj6) {
                            return DisneyStudioProvider.load$lambda$5(data, (Episode) obj6);
                        }
                    })));
                    suggest4 = suggest2;
                    genre4 = genre2;
                    rating3 = rating2;
                    id5 = id2;
                    episodes5 = episodes;
                    cast3 = cast2;
                    runTime4 = runTime;
                    data3 = data;
                    castList4 = castList2;
                    obj5 = obj5;
                    $this7 = $this4;
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
                        destination$iv$iv2.add(MainAPIKt.newAnimeSearchResponse$default($this4, "", AppUtils.INSTANCE.toJson(new Id(it6.getId())), (TvType) null, false, new Function1() { // from class: com.horis.cncverse.DisneyStudioProvider$$ExternalSyntheticLambda1
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
                        destination$iv.add(MainAPIKt.newEpisode($this4, new LoadData(title, it7.getId()), new Function1() { // from class: com.horis.cncverse.DisneyStudioProvider$$ExternalSyntheticLambda3
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
                    Boxing.boxBoolean(episodes.add(MainAPIKt.newEpisode($this4, new LoadData(title, id2), new Function1() { // from class: com.horis.cncverse.DisneyStudioProvider$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj6) {
                            return DisneyStudioProvider.load$lambda$5(data, (Episode) obj6);
                        }
                    })));
                    suggest4 = suggest2;
                    genre4 = genre2;
                    rating3 = rating2;
                    id5 = id2;
                    episodes5 = episodes;
                    cast3 = cast2;
                    runTime4 = runTime;
                    data3 = data;
                    castList4 = castList2;
                    obj5 = obj5;
                    $this7 = $this4;
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
    @DebugMetadata(c = "com.horis.cncverse.DisneyStudioProvider$load$4", f = "DisneyStudioProvider.kt", i = {0}, l = {169}, m = "invokeSuspend", n = {"it"}, nl = {-1}, s = {"L$0"}, v = 2)
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

    /* JADX WARN: Code duplicated, block: B:24:0x01c5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:28:0x0264 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x0265  */
    /* JADX WARN: Code duplicated, block: B:32:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:34:0x02d1 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:38:0x0363 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:39:0x0364  */
    /* JADX WARN: Code duplicated, block: B:41:0x0397  */
    /* JADX WARN: Code duplicated, block: B:44:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:48:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:50:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:52:0x03bb  */
    /* JADX WARN: Code duplicated, block: B:54:0x041b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:55:0x041c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object loadLinks$suspendImpl(DisneyStudioProvider $this, String data, boolean isCasting, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Boolean> continuation) throws Exception {
        C00081 c00081;
        String data2;
        Function1<? super ExtractorLink, Unit> function3;
        Object objResolveApiUrl;
        Function1<? super SubtitleFile, Unit> function4;
        boolean isCasting2;
        String apiBase;
        String id;
        Function1<? super ExtractorLink, Unit> function5;
        Object newTvUserToken$default;
        String data3;
        String apiBase2;
        String apiBase3;
        boolean isCasting3;
        Function1<? super SubtitleFile, Unit> function6;
        Function1<? super ExtractorLink, Unit> function7;
        Ref.ObjectRef response;
        DisneyStudioProvider $this2;
        Function1<? super ExtractorLink, Unit> function8;
        String id2;
        String userToken;
        String apiBase4;
        Object obj;
        Object obj2;
        String str;
        String str2;
        boolean isCasting4;
        Object obj3;
        Object obj4;
        Function1<? super SubtitleFile, Unit> function9;
        String data4;
        Function1<? super ExtractorLink, Unit> function10;
        String id3;
        boolean isCasting5;
        String apiBase5;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef response2;
        DisneyStudioProvider $this3;
        DisneyStudioProvider $this4;
        boolean isCasting6;
        String apiBase6;
        Function1<? super SubtitleFile, Unit> function11;
        String apiBase7;
        Ref.ObjectRef response3;
        String str3;
        Object newTvUserToken;
        boolean isCasting7;
        Ref.ObjectRef response4;
        String id4;
        String apiBase8;
        Function1<? super ExtractorLink, Unit> function12;
        Function1<? super SubtitleFile, Unit> function13;
        String data5;
        String userToken2;
        String id5;
        String apiBase9;
        Function1<? super ExtractorLink, Unit> function14;
        Ref.ObjectRef response5;
        boolean isCasting8;
        Object obj5;
        String userToken3;
        Function1<? super ExtractorLink, Unit> function15;
        Ref.ObjectRef objectRef2;
        Ref.ObjectRef response6;
        String apiBase10;
        String id6;
        String video_link;
        boolean z;
        Object objNewExtractorLink;
        Function1<? super ExtractorLink, Unit> function16;
        DisneyStudioProvider $this5 = $this;
        if (continuation instanceof C00081) {
            c00081 = (C00081) continuation;
            if ((c00081.label & Integer.MIN_VALUE) != 0) {
                c00081.label -= Integer.MIN_VALUE;
            } else {
                c00081 = $this5.new C00081(continuation);
            }
        } else {
            c00081 = $this5.new C00081(continuation);
        }
        C00081 c00082 = c00081;
        Object $result = c00082.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00082.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00082.L$0 = $this5;
                data2 = data;
                c00082.L$1 = data2;
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                function3 = function2;
                c00082.L$3 = function3;
                c00082.Z$0 = isCasting;
                c00082.label = 1;
                objResolveApiUrl = UtilsKt.resolveApiUrl(c00082);
                if (objResolveApiUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function4 = function1;
                isCasting2 = isCasting;
                apiBase = (String) objResolveApiUrl;
                String text$iv = data2;
                id = ((LoadData) UtilsKt.getJSONParser().parse(text$iv, Reflection.getOrCreateKotlinClass(LoadData.class))).getId();
                c00082.L$0 = $this5;
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00082.L$3 = function3;
                c00082.L$4 = apiBase;
                c00082.L$5 = id;
                c00082.Z$0 = isCasting2;
                c00082.label = 2;
                function5 = function3;
                newTvUserToken$default = UtilsKt.getNewTvUserToken$default(apiBase, "hs", false, c00082, 4, null);
                if (newTvUserToken$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                data3 = data2;
                apiBase2 = apiBase;
                apiBase3 = id;
                isCasting3 = isCasting2;
                function6 = function4;
                function7 = function5;
                String userToken4 = (String) newTvUserToken$default;
                response = new Ref.ObjectRef();
                Map<String, String> mapBuildNewTvHeaders = UtilsKt.buildNewTvHeaders("hs", MapsKt.mapOf(TuplesKt.to("Usertoken", userToken4)));
                c00082.L$0 = $this5;
                $this2 = $this5;
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(data3);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                c00082.L$3 = function7;
                c00082.L$4 = apiBase2;
                c00082.L$5 = apiBase3;
                c00082.L$6 = SpillingKt.nullOutSpilledVariable(userToken4);
                c00082.L$7 = response;
                c00082.L$8 = response;
                c00082.Z$0 = isCasting3;
                c00082.label = 3;
                function8 = function7;
                id2 = apiBase3;
                userToken = userToken4;
                apiBase4 = apiBase2;
                obj = coroutine_suspended;
                obj2 = "Usertoken";
                str = "/newtv/player.php?id=";
                str2 = "hs";
                isCasting4 = isCasting3;
                obj3 = Requests.get$default(UtilsKt.getApp(), apiBase2 + "/newtv/player.php?id=" + apiBase3, mapBuildNewTvHeaders, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00082, 4092, (Object) null);
                c00082 = c00082;
                if (obj3 == obj) {
                    return obj;
                }
                obj4 = obj3;
                function9 = function6;
                data4 = data3;
                function10 = function8;
                id3 = id2;
                isCasting5 = isCasting4;
                apiBase5 = apiBase4;
                objectRef = response;
                response2 = objectRef;
                $this3 = $this2;
                NiceResponse this_$iv = (NiceResponse) obj4;
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                objectRef.element = parser.parse(this_$iv.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                if (Intrinsics.areEqual(((NewTvPlayerResponse) response2.element).getStatus(), "otp")) {
                    c00082.L$0 = $this3;
                    c00082.L$1 = SpillingKt.nullOutSpilledVariable(data4);
                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                    c00082.L$3 = function10;
                    c00082.L$4 = apiBase5;
                    c00082.L$5 = id3;
                    c00082.L$6 = SpillingKt.nullOutSpilledVariable(userToken);
                    c00082.L$7 = response2;
                    c00082.L$8 = null;
                    c00082.Z$0 = isCasting5;
                    c00082.label = 4;
                    str3 = str2;
                    newTvUserToken = UtilsKt.getNewTvUserToken(apiBase5, str3, true, c00082);
                    if (newTvUserToken == obj) {
                        return obj;
                    }
                    $this4 = $this3;
                    isCasting7 = isCasting5;
                    response4 = response2;
                    id4 = id3;
                    apiBase8 = apiBase5;
                    function12 = function10;
                    function13 = function9;
                    data5 = data4;
                    userToken2 = (String) newTvUserToken;
                    Map<String, String> mapBuildNewTvHeaders2 = UtilsKt.buildNewTvHeaders(str3, MapsKt.mapOf(TuplesKt.to(obj2, userToken2)));
                    c00082.L$0 = $this4;
                    c00082.L$1 = SpillingKt.nullOutSpilledVariable(data5);
                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(function13);
                    c00082.L$3 = function12;
                    c00082.L$4 = apiBase8;
                    c00082.L$5 = SpillingKt.nullOutSpilledVariable(id4);
                    c00082.L$6 = SpillingKt.nullOutSpilledVariable(userToken2);
                    c00082.L$7 = response4;
                    c00082.L$8 = response4;
                    c00082.Z$0 = isCasting7;
                    c00082.label = 5;
                    C00081 c00083 = c00082;
                    id5 = id4;
                    apiBase9 = apiBase8;
                    function14 = function12;
                    response5 = response4;
                    isCasting8 = isCasting7;
                    obj5 = Requests.get$default(UtilsKt.getApp(), apiBase8 + str + id4, mapBuildNewTvHeaders2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00083, 4092, (Object) null);
                    c00082 = c00083;
                    if (obj5 == obj) {
                        return obj;
                    }
                    userToken3 = userToken2;
                    function11 = function13;
                    data4 = data5;
                    function15 = function14;
                    objectRef2 = response5;
                    response6 = objectRef2;
                    apiBase10 = apiBase9;
                    id6 = id5;
                    NiceResponse this_$iv2 = (NiceResponse) obj5;
                    ResponseParser parser2 = this_$iv2.getParser();
                    Intrinsics.checkNotNull(parser2);
                    objectRef2.element = parser2.parse(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                    Function1<? super ExtractorLink, Unit> function17 = function15;
                    apiBase6 = apiBase10;
                    function10 = function17;
                    response3 = response6;
                    userToken = userToken3;
                    apiBase7 = id6;
                    isCasting6 = isCasting8;
                } else {
                    $this4 = $this3;
                    isCasting6 = isCasting5;
                    apiBase6 = apiBase5;
                    function11 = function9;
                    apiBase7 = id3;
                    response3 = response2;
                }
                video_link = ((NewTvPlayerResponse) response3.element).getVideo_link();
                if (video_link != null || StringsKt.isBlank(video_link)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return Boxing.boxBoolean(false);
                }
                String name = $this4.getName();
                String name2 = $this4.getName();
                String video_link2 = ((NewTvPlayerResponse) response3.element).getVideo_link();
                ExtractorLinkType extractorLinkType = ExtractorLinkType.M3U8;
                C00092 c00092 = new C00092(response3, apiBase6, null);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(data4);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(function10);
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(apiBase6);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(apiBase7);
                c00082.L$6 = SpillingKt.nullOutSpilledVariable(userToken);
                c00082.L$7 = SpillingKt.nullOutSpilledVariable(response3);
                c00082.L$8 = function10;
                c00082.Z$0 = isCasting6;
                c00082.label = 6;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, video_link2, extractorLinkType, c00092, c00082);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function16 = function10;
                function16.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            case 1:
                boolean isCasting9 = c00082.Z$0;
                function3 = (Function1) c00082.L$3;
                Function1<? super SubtitleFile, Unit> function18 = (Function1) c00082.L$2;
                String data6 = (String) c00082.L$1;
                $this5 = (DisneyStudioProvider) c00082.L$0;
                ResultKt.throwOnFailure($result);
                isCasting2 = isCasting9;
                function4 = function18;
                data2 = data6;
                objResolveApiUrl = $result;
                apiBase = (String) objResolveApiUrl;
                String text$iv2 = data2;
                id = ((LoadData) UtilsKt.getJSONParser().parse(text$iv2, Reflection.getOrCreateKotlinClass(LoadData.class))).getId();
                c00082.L$0 = $this5;
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(data2);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function4);
                c00082.L$3 = function3;
                c00082.L$4 = apiBase;
                c00082.L$5 = id;
                c00082.Z$0 = isCasting2;
                c00082.label = 2;
                function5 = function3;
                newTvUserToken$default = UtilsKt.getNewTvUserToken$default(apiBase, "hs", false, c00082, 4, null);
                if (newTvUserToken$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                data3 = data2;
                apiBase2 = apiBase;
                apiBase3 = id;
                isCasting3 = isCasting2;
                function6 = function4;
                function7 = function5;
                String userToken5 = (String) newTvUserToken$default;
                response = new Ref.ObjectRef();
                Map<String, String> mapBuildNewTvHeaders3 = UtilsKt.buildNewTvHeaders("hs", MapsKt.mapOf(TuplesKt.to("Usertoken", userToken5)));
                c00082.L$0 = $this5;
                $this2 = $this5;
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(data3);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                c00082.L$3 = function7;
                c00082.L$4 = apiBase2;
                c00082.L$5 = apiBase3;
                c00082.L$6 = SpillingKt.nullOutSpilledVariable(userToken5);
                c00082.L$7 = response;
                c00082.L$8 = response;
                c00082.Z$0 = isCasting3;
                c00082.label = 3;
                function8 = function7;
                id2 = apiBase3;
                userToken = userToken5;
                apiBase4 = apiBase2;
                obj = coroutine_suspended;
                obj2 = "Usertoken";
                str = "/newtv/player.php?id=";
                str2 = "hs";
                isCasting4 = isCasting3;
                obj3 = Requests.get$default(UtilsKt.getApp(), apiBase2 + "/newtv/player.php?id=" + apiBase3, mapBuildNewTvHeaders3, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00082, 4092, (Object) null);
                c00082 = c00082;
                if (obj3 == obj) {
                    return obj;
                }
                obj4 = obj3;
                function9 = function6;
                data4 = data3;
                function10 = function8;
                id3 = id2;
                isCasting5 = isCasting4;
                apiBase5 = apiBase4;
                objectRef = response;
                response2 = objectRef;
                $this3 = $this2;
                NiceResponse this_$iv3 = (NiceResponse) obj4;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                objectRef.element = parser3.parse(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                if (Intrinsics.areEqual(((NewTvPlayerResponse) response2.element).getStatus(), "otp")) {
                    c00082.L$0 = $this3;
                    c00082.L$1 = SpillingKt.nullOutSpilledVariable(data4);
                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                    c00082.L$3 = function10;
                    c00082.L$4 = apiBase5;
                    c00082.L$5 = id3;
                    c00082.L$6 = SpillingKt.nullOutSpilledVariable(userToken);
                    c00082.L$7 = response2;
                    c00082.L$8 = null;
                    c00082.Z$0 = isCasting5;
                    c00082.label = 4;
                    str3 = str2;
                    newTvUserToken = UtilsKt.getNewTvUserToken(apiBase5, str3, true, c00082);
                    if (newTvUserToken == obj) {
                        return obj;
                    }
                    $this4 = $this3;
                    isCasting7 = isCasting5;
                    response4 = response2;
                    id4 = id3;
                    apiBase8 = apiBase5;
                    function12 = function10;
                    function13 = function9;
                    data5 = data4;
                    userToken2 = (String) newTvUserToken;
                    Map<String, String> mapBuildNewTvHeaders4 = UtilsKt.buildNewTvHeaders(str3, MapsKt.mapOf(TuplesKt.to(obj2, userToken2)));
                    c00082.L$0 = $this4;
                    c00082.L$1 = SpillingKt.nullOutSpilledVariable(data5);
                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(function13);
                    c00082.L$3 = function12;
                    c00082.L$4 = apiBase8;
                    c00082.L$5 = SpillingKt.nullOutSpilledVariable(id4);
                    c00082.L$6 = SpillingKt.nullOutSpilledVariable(userToken2);
                    c00082.L$7 = response4;
                    c00082.L$8 = response4;
                    c00082.Z$0 = isCasting7;
                    c00082.label = 5;
                    C00081 c00084 = c00082;
                    id5 = id4;
                    apiBase9 = apiBase8;
                    function14 = function12;
                    response5 = response4;
                    isCasting8 = isCasting7;
                    obj5 = Requests.get$default(UtilsKt.getApp(), apiBase8 + str + id4, mapBuildNewTvHeaders4, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00084, 4092, (Object) null);
                    c00082 = c00084;
                    if (obj5 == obj) {
                        return obj;
                    }
                    userToken3 = userToken2;
                    function11 = function13;
                    data4 = data5;
                    function15 = function14;
                    objectRef2 = response5;
                    response6 = objectRef2;
                    apiBase10 = apiBase9;
                    id6 = id5;
                    NiceResponse this_$iv4 = (NiceResponse) obj5;
                    ResponseParser parser4 = this_$iv4.getParser();
                    Intrinsics.checkNotNull(parser4);
                    objectRef2.element = parser4.parse(this_$iv4.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                    Function1<? super ExtractorLink, Unit> function19 = function15;
                    apiBase6 = apiBase10;
                    function10 = function19;
                    response3 = response6;
                    userToken = userToken3;
                    apiBase7 = id6;
                    isCasting6 = isCasting8;
                } else {
                    $this4 = $this3;
                    isCasting6 = isCasting5;
                    apiBase6 = apiBase5;
                    function11 = function9;
                    apiBase7 = id3;
                    response3 = response2;
                }
                video_link = ((NewTvPlayerResponse) response3.element).getVideo_link();
                if (video_link != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    return Boxing.boxBoolean(false);
                }
                String name3 = $this4.getName();
                String name4 = $this4.getName();
                String video_link3 = ((NewTvPlayerResponse) response3.element).getVideo_link();
                ExtractorLinkType extractorLinkType2 = ExtractorLinkType.M3U8;
                C00092 c00093 = new C00092(response3, apiBase6, null);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(data4);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(function10);
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(apiBase6);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(apiBase7);
                c00082.L$6 = SpillingKt.nullOutSpilledVariable(userToken);
                c00082.L$7 = SpillingKt.nullOutSpilledVariable(response3);
                c00082.L$8 = function10;
                c00082.Z$0 = isCasting6;
                c00082.label = 6;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name3, name4, video_link3, extractorLinkType2, c00093, c00082);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function16 = function10;
                function16.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            case 2:
                isCasting3 = c00082.Z$0;
                apiBase3 = (String) c00082.L$5;
                String apiBase11 = (String) c00082.L$4;
                Function1<? super ExtractorLink, Unit> function20 = (Function1) c00082.L$3;
                Function1<? super SubtitleFile, Unit> function21 = (Function1) c00082.L$2;
                String data7 = (String) c00082.L$1;
                $this5 = (DisneyStudioProvider) c00082.L$0;
                ResultKt.throwOnFailure($result);
                function6 = function21;
                data3 = data7;
                function7 = function20;
                apiBase2 = apiBase11;
                newTvUserToken$default = $result;
                String userToken6 = (String) newTvUserToken$default;
                response = new Ref.ObjectRef();
                Map<String, String> mapBuildNewTvHeaders5 = UtilsKt.buildNewTvHeaders("hs", MapsKt.mapOf(TuplesKt.to("Usertoken", userToken6)));
                c00082.L$0 = $this5;
                $this2 = $this5;
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(data3);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                c00082.L$3 = function7;
                c00082.L$4 = apiBase2;
                c00082.L$5 = apiBase3;
                c00082.L$6 = SpillingKt.nullOutSpilledVariable(userToken6);
                c00082.L$7 = response;
                c00082.L$8 = response;
                c00082.Z$0 = isCasting3;
                c00082.label = 3;
                function8 = function7;
                id2 = apiBase3;
                userToken = userToken6;
                apiBase4 = apiBase2;
                obj = coroutine_suspended;
                obj2 = "Usertoken";
                str = "/newtv/player.php?id=";
                str2 = "hs";
                isCasting4 = isCasting3;
                obj3 = Requests.get$default(UtilsKt.getApp(), apiBase2 + "/newtv/player.php?id=" + apiBase3, mapBuildNewTvHeaders5, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00082, 4092, (Object) null);
                c00082 = c00082;
                if (obj3 == obj) {
                    return obj;
                }
                obj4 = obj3;
                function9 = function6;
                data4 = data3;
                function10 = function8;
                id3 = id2;
                isCasting5 = isCasting4;
                apiBase5 = apiBase4;
                objectRef = response;
                response2 = objectRef;
                $this3 = $this2;
                NiceResponse this_$iv5 = (NiceResponse) obj4;
                ResponseParser parser5 = this_$iv5.getParser();
                Intrinsics.checkNotNull(parser5);
                objectRef.element = parser5.parse(this_$iv5.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                if (Intrinsics.areEqual(((NewTvPlayerResponse) response2.element).getStatus(), "otp")) {
                    c00082.L$0 = $this3;
                    c00082.L$1 = SpillingKt.nullOutSpilledVariable(data4);
                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                    c00082.L$3 = function10;
                    c00082.L$4 = apiBase5;
                    c00082.L$5 = id3;
                    c00082.L$6 = SpillingKt.nullOutSpilledVariable(userToken);
                    c00082.L$7 = response2;
                    c00082.L$8 = null;
                    c00082.Z$0 = isCasting5;
                    c00082.label = 4;
                    str3 = str2;
                    newTvUserToken = UtilsKt.getNewTvUserToken(apiBase5, str3, true, c00082);
                    if (newTvUserToken == obj) {
                        return obj;
                    }
                    $this4 = $this3;
                    isCasting7 = isCasting5;
                    response4 = response2;
                    id4 = id3;
                    apiBase8 = apiBase5;
                    function12 = function10;
                    function13 = function9;
                    data5 = data4;
                    userToken2 = (String) newTvUserToken;
                    Map<String, String> mapBuildNewTvHeaders6 = UtilsKt.buildNewTvHeaders(str3, MapsKt.mapOf(TuplesKt.to(obj2, userToken2)));
                    c00082.L$0 = $this4;
                    c00082.L$1 = SpillingKt.nullOutSpilledVariable(data5);
                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(function13);
                    c00082.L$3 = function12;
                    c00082.L$4 = apiBase8;
                    c00082.L$5 = SpillingKt.nullOutSpilledVariable(id4);
                    c00082.L$6 = SpillingKt.nullOutSpilledVariable(userToken2);
                    c00082.L$7 = response4;
                    c00082.L$8 = response4;
                    c00082.Z$0 = isCasting7;
                    c00082.label = 5;
                    C00081 c00085 = c00082;
                    id5 = id4;
                    apiBase9 = apiBase8;
                    function14 = function12;
                    response5 = response4;
                    isCasting8 = isCasting7;
                    obj5 = Requests.get$default(UtilsKt.getApp(), apiBase8 + str + id4, mapBuildNewTvHeaders6, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00085, 4092, (Object) null);
                    c00082 = c00085;
                    if (obj5 == obj) {
                        return obj;
                    }
                    userToken3 = userToken2;
                    function11 = function13;
                    data4 = data5;
                    function15 = function14;
                    objectRef2 = response5;
                    response6 = objectRef2;
                    apiBase10 = apiBase9;
                    id6 = id5;
                    NiceResponse this_$iv6 = (NiceResponse) obj5;
                    ResponseParser parser6 = this_$iv6.getParser();
                    Intrinsics.checkNotNull(parser6);
                    objectRef2.element = parser6.parse(this_$iv6.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                    Function1<? super ExtractorLink, Unit> function110 = function15;
                    apiBase6 = apiBase10;
                    function10 = function110;
                    response3 = response6;
                    userToken = userToken3;
                    apiBase7 = id6;
                    isCasting6 = isCasting8;
                } else {
                    $this4 = $this3;
                    isCasting6 = isCasting5;
                    apiBase6 = apiBase5;
                    function11 = function9;
                    apiBase7 = id3;
                    response3 = response2;
                }
                video_link = ((NewTvPlayerResponse) response3.element).getVideo_link();
                if (video_link != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    return Boxing.boxBoolean(false);
                }
                String name5 = $this4.getName();
                String name6 = $this4.getName();
                String video_link4 = ((NewTvPlayerResponse) response3.element).getVideo_link();
                ExtractorLinkType extractorLinkType3 = ExtractorLinkType.M3U8;
                C00092 c00094 = new C00092(response3, apiBase6, null);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(data4);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(function10);
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(apiBase6);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(apiBase7);
                c00082.L$6 = SpillingKt.nullOutSpilledVariable(userToken);
                c00082.L$7 = SpillingKt.nullOutSpilledVariable(response3);
                c00082.L$8 = function10;
                c00082.Z$0 = isCasting6;
                c00082.label = 6;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name5, name6, video_link4, extractorLinkType3, c00094, c00082);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function16 = function10;
                function16.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            case 3:
                boolean isCasting10 = c00082.Z$0;
                Ref.ObjectRef objectRef3 = (Ref.ObjectRef) c00082.L$8;
                Ref.ObjectRef response7 = (Ref.ObjectRef) c00082.L$7;
                String userToken7 = (String) c00082.L$6;
                String id7 = (String) c00082.L$5;
                String apiBase12 = (String) c00082.L$4;
                Function1<? super ExtractorLink, Unit> function22 = (Function1) c00082.L$3;
                function9 = (Function1) c00082.L$2;
                data4 = (String) c00082.L$1;
                DisneyStudioProvider $this6 = (DisneyStudioProvider) c00082.L$0;
                ResultKt.throwOnFailure($result);
                userToken = userToken7;
                obj2 = "Usertoken";
                str = "/newtv/player.php?id=";
                str2 = "hs";
                objectRef = objectRef3;
                function10 = function22;
                $this3 = $this6;
                apiBase5 = apiBase12;
                obj = coroutine_suspended;
                response2 = response7;
                id3 = id7;
                isCasting5 = isCasting10;
                obj4 = $result;
                NiceResponse this_$iv7 = (NiceResponse) obj4;
                ResponseParser parser7 = this_$iv7.getParser();
                Intrinsics.checkNotNull(parser7);
                objectRef.element = parser7.parse(this_$iv7.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                if (Intrinsics.areEqual(((NewTvPlayerResponse) response2.element).getStatus(), "otp")) {
                    c00082.L$0 = $this3;
                    c00082.L$1 = SpillingKt.nullOutSpilledVariable(data4);
                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(function9);
                    c00082.L$3 = function10;
                    c00082.L$4 = apiBase5;
                    c00082.L$5 = id3;
                    c00082.L$6 = SpillingKt.nullOutSpilledVariable(userToken);
                    c00082.L$7 = response2;
                    c00082.L$8 = null;
                    c00082.Z$0 = isCasting5;
                    c00082.label = 4;
                    str3 = str2;
                    newTvUserToken = UtilsKt.getNewTvUserToken(apiBase5, str3, true, c00082);
                    if (newTvUserToken == obj) {
                        return obj;
                    }
                    $this4 = $this3;
                    isCasting7 = isCasting5;
                    response4 = response2;
                    id4 = id3;
                    apiBase8 = apiBase5;
                    function12 = function10;
                    function13 = function9;
                    data5 = data4;
                    userToken2 = (String) newTvUserToken;
                    Map<String, String> mapBuildNewTvHeaders7 = UtilsKt.buildNewTvHeaders(str3, MapsKt.mapOf(TuplesKt.to(obj2, userToken2)));
                    c00082.L$0 = $this4;
                    c00082.L$1 = SpillingKt.nullOutSpilledVariable(data5);
                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(function13);
                    c00082.L$3 = function12;
                    c00082.L$4 = apiBase8;
                    c00082.L$5 = SpillingKt.nullOutSpilledVariable(id4);
                    c00082.L$6 = SpillingKt.nullOutSpilledVariable(userToken2);
                    c00082.L$7 = response4;
                    c00082.L$8 = response4;
                    c00082.Z$0 = isCasting7;
                    c00082.label = 5;
                    C00081 c00086 = c00082;
                    id5 = id4;
                    apiBase9 = apiBase8;
                    function14 = function12;
                    response5 = response4;
                    isCasting8 = isCasting7;
                    obj5 = Requests.get$default(UtilsKt.getApp(), apiBase8 + str + id4, mapBuildNewTvHeaders7, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00086, 4092, (Object) null);
                    c00082 = c00086;
                    if (obj5 == obj) {
                        return obj;
                    }
                    userToken3 = userToken2;
                    function11 = function13;
                    data4 = data5;
                    function15 = function14;
                    objectRef2 = response5;
                    response6 = objectRef2;
                    apiBase10 = apiBase9;
                    id6 = id5;
                    NiceResponse this_$iv8 = (NiceResponse) obj5;
                    ResponseParser parser8 = this_$iv8.getParser();
                    Intrinsics.checkNotNull(parser8);
                    objectRef2.element = parser8.parse(this_$iv8.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                    Function1<? super ExtractorLink, Unit> function111 = function15;
                    apiBase6 = apiBase10;
                    function10 = function111;
                    response3 = response6;
                    userToken = userToken3;
                    apiBase7 = id6;
                    isCasting6 = isCasting8;
                } else {
                    $this4 = $this3;
                    isCasting6 = isCasting5;
                    apiBase6 = apiBase5;
                    function11 = function9;
                    apiBase7 = id3;
                    response3 = response2;
                }
                video_link = ((NewTvPlayerResponse) response3.element).getVideo_link();
                if (video_link != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    return Boxing.boxBoolean(false);
                }
                String name7 = $this4.getName();
                String name8 = $this4.getName();
                String video_link5 = ((NewTvPlayerResponse) response3.element).getVideo_link();
                ExtractorLinkType extractorLinkType4 = ExtractorLinkType.M3U8;
                C00092 c00095 = new C00092(response3, apiBase6, null);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(data4);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(function10);
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(apiBase6);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(apiBase7);
                c00082.L$6 = SpillingKt.nullOutSpilledVariable(userToken);
                c00082.L$7 = SpillingKt.nullOutSpilledVariable(response3);
                c00082.L$8 = function10;
                c00082.Z$0 = isCasting6;
                c00082.label = 6;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name7, name8, video_link5, extractorLinkType4, c00095, c00082);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function16 = function10;
                function16.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            case 4:
                isCasting7 = c00082.Z$0;
                response4 = (Ref.ObjectRef) c00082.L$7;
                id4 = (String) c00082.L$5;
                apiBase8 = (String) c00082.L$4;
                Function1<? super ExtractorLink, Unit> function23 = (Function1) c00082.L$3;
                Function1<? super SubtitleFile, Unit> function24 = (Function1) c00082.L$2;
                String data8 = (String) c00082.L$1;
                DisneyStudioProvider $this7 = (DisneyStudioProvider) c00082.L$0;
                ResultKt.throwOnFailure($result);
                obj2 = "Usertoken";
                str = "/newtv/player.php?id=";
                str3 = "hs";
                data5 = data8;
                function13 = function24;
                $this4 = $this7;
                newTvUserToken = $result;
                obj = coroutine_suspended;
                function12 = function23;
                userToken2 = (String) newTvUserToken;
                Map<String, String> mapBuildNewTvHeaders8 = UtilsKt.buildNewTvHeaders(str3, MapsKt.mapOf(TuplesKt.to(obj2, userToken2)));
                c00082.L$0 = $this4;
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(data5);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function13);
                c00082.L$3 = function12;
                c00082.L$4 = apiBase8;
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(id4);
                c00082.L$6 = SpillingKt.nullOutSpilledVariable(userToken2);
                c00082.L$7 = response4;
                c00082.L$8 = response4;
                c00082.Z$0 = isCasting7;
                c00082.label = 5;
                C00081 c00087 = c00082;
                id5 = id4;
                apiBase9 = apiBase8;
                function14 = function12;
                response5 = response4;
                isCasting8 = isCasting7;
                obj5 = Requests.get$default(UtilsKt.getApp(), apiBase8 + str + id4, mapBuildNewTvHeaders8, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00087, 4092, (Object) null);
                c00082 = c00087;
                if (obj5 == obj) {
                    return obj;
                }
                userToken3 = userToken2;
                function11 = function13;
                data4 = data5;
                function15 = function14;
                objectRef2 = response5;
                response6 = objectRef2;
                apiBase10 = apiBase9;
                id6 = id5;
                NiceResponse this_$iv9 = (NiceResponse) obj5;
                ResponseParser parser9 = this_$iv9.getParser();
                Intrinsics.checkNotNull(parser9);
                objectRef2.element = parser9.parse(this_$iv9.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                Function1<? super ExtractorLink, Unit> function112 = function15;
                apiBase6 = apiBase10;
                function10 = function112;
                response3 = response6;
                userToken = userToken3;
                apiBase7 = id6;
                isCasting6 = isCasting8;
                video_link = ((NewTvPlayerResponse) response3.element).getVideo_link();
                if (video_link != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    return Boxing.boxBoolean(false);
                }
                String name9 = $this4.getName();
                String name10 = $this4.getName();
                String video_link6 = ((NewTvPlayerResponse) response3.element).getVideo_link();
                ExtractorLinkType extractorLinkType5 = ExtractorLinkType.M3U8;
                C00092 c00096 = new C00092(response3, apiBase6, null);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(data4);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(function10);
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(apiBase6);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(apiBase7);
                c00082.L$6 = SpillingKt.nullOutSpilledVariable(userToken);
                c00082.L$7 = SpillingKt.nullOutSpilledVariable(response3);
                c00082.L$8 = function10;
                c00082.Z$0 = isCasting6;
                c00082.label = 6;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name9, name10, video_link6, extractorLinkType5, c00096, c00082);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function16 = function10;
                function16.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            case 5:
                boolean isCasting11 = c00082.Z$0;
                objectRef2 = (Ref.ObjectRef) c00082.L$8;
                response6 = (Ref.ObjectRef) c00082.L$7;
                userToken3 = (String) c00082.L$6;
                id6 = (String) c00082.L$5;
                apiBase10 = (String) c00082.L$4;
                function15 = (Function1) c00082.L$3;
                function11 = (Function1) c00082.L$2;
                data4 = (String) c00082.L$1;
                DisneyStudioProvider $this8 = (DisneyStudioProvider) c00082.L$0;
                ResultKt.throwOnFailure($result);
                isCasting8 = isCasting11;
                $this4 = $this8;
                obj5 = $result;
                obj = coroutine_suspended;
                NiceResponse this_$iv10 = (NiceResponse) obj5;
                ResponseParser parser10 = this_$iv10.getParser();
                Intrinsics.checkNotNull(parser10);
                objectRef2.element = parser10.parse(this_$iv10.getText(), Reflection.getOrCreateKotlinClass(NewTvPlayerResponse.class));
                Function1<? super ExtractorLink, Unit> function113 = function15;
                apiBase6 = apiBase10;
                function10 = function113;
                response3 = response6;
                userToken = userToken3;
                apiBase7 = id6;
                isCasting6 = isCasting8;
                video_link = ((NewTvPlayerResponse) response3.element).getVideo_link();
                if (video_link != null) {
                    z = true;
                } else {
                    z = true;
                }
                if (z) {
                    return Boxing.boxBoolean(false);
                }
                String name11 = $this4.getName();
                String name12 = $this4.getName();
                String video_link7 = ((NewTvPlayerResponse) response3.element).getVideo_link();
                ExtractorLinkType extractorLinkType6 = ExtractorLinkType.M3U8;
                C00092 c00097 = new C00092(response3, apiBase6, null);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable($this4);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(data4);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function11);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(function10);
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(apiBase6);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(apiBase7);
                c00082.L$6 = SpillingKt.nullOutSpilledVariable(userToken);
                c00082.L$7 = SpillingKt.nullOutSpilledVariable(response3);
                c00082.L$8 = function10;
                c00082.Z$0 = isCasting6;
                c00082.label = 6;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name11, name12, video_link7, extractorLinkType6, c00097, c00082);
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                function16 = function10;
                function16.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            case 6:
                boolean z2 = c00082.Z$0;
                function16 = (Function1) c00082.L$8;
                ResultKt.throwOnFailure($result);
                objNewExtractorLink = $result;
                function16.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.horis.cncverse.DisneyStudioProvider$loadLinks$2 */
    /* JADX INFO: compiled from: DisneyStudioProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.horis.cncverse.DisneyStudioProvider$loadLinks$2", f = "DisneyStudioProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00092 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $apiBase;
        final /* synthetic */ Ref.ObjectRef<NewTvPlayerResponse> $response;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00092(Ref.ObjectRef<NewTvPlayerResponse> objectRef, String str, Continuation<? super C00092> continuation) {
            super(2, continuation);
            this.$response = objectRef;
            this.$apiBase = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00092 = new C00092(this.$response, this.$apiBase, continuation);
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
                    String referer = ((NewTvPlayerResponse) this.$response.element).getReferer();
                    if (referer == null) {
                        referer = this.$apiBase;
                    }
                    $this$newExtractorLink.setReferer(referer);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: compiled from: DisneyStudioProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/horis/cncverse/DisneyStudioProvider$Id;", "", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "CNC Verse_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
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
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/horis/cncverse/DisneyStudioProvider$LoadData;", "", "title", "", "id", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "CNC Verse_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
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
