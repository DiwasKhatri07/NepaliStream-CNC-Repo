package com.anikage;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import com.lagradost.cloudstream3.Score;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.ShowStatus;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
import kotlin.reflect.KTypeProjection;
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

/* JADX INFO: compiled from: AnikageProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Anikage/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\b@ABCDEFGB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005H\u0002J\u001e\u0010\"\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0096@¢\u0006\u0002\u0010)J\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020+0 2\u0006\u0010,\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010-J\f\u0010.\u001a\u00020/*\u000200H\u0002J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010-JF\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00122\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020:082\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020:08H\u0096@¢\u0006\u0002\u0010=J\u0012\u0010>\u001a\u00020&2\b\u0010?\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u0012X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\rR\u0014\u0010\u0018\u001a\u00020\u0012X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006H"}, d2 = {"Lcom/anikage/AnikageProvider;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "proxyUrl", "", "buildProxyUrl", "path", "type", "mainUrl", "getMainUrl", "()Ljava/lang/String;", "setMainUrl", "(Ljava/lang/String;)V", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "lang", "getLang", "setLang", "hasDownloadSupport", "getHasDownloadSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "mainPage", "", "Lcom/lagradost/cloudstream3/MainPageData;", "getMainPage", "()Ljava/util/List;", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "Lcom/lagradost/cloudstream3/SearchResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSearchResponse", "Lcom/lagradost/cloudstream3/AnimeSearchResponse;", "Lcom/anikage/AnikageProvider$AnimeResult;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "url", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQualityFromName", "quality", "EpisodeData", "AnikageResponse", "AnimeDetailsResponse", "AnimeResult", "AnimeTitle", "AnikageCoverImage", "AnilistStats", "EpisodeResult", "Anikage"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnikageProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnikageProvider.kt\ncom/anikage/AnikageProvider\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,299:1\n63#2:300\n64#2,15:302\n63#2:323\n64#2,15:325\n63#2:346\n64#2,15:348\n63#2:365\n64#2,15:367\n63#2:384\n64#2,15:386\n1#3:301\n1#3:324\n1#3:347\n1#3:366\n1#3:385\n1#3:403\n50#4:317\n43#4:318\n50#4:340\n43#4:341\n50#4:363\n43#4:364\n50#4:382\n43#4:383\n50#4:401\n43#4:402\n1739#5:319\n1814#5,3:320\n1739#5:342\n1814#5,3:343\n*S KotlinDebug\n*F\n+ 1 AnikageProvider.kt\ncom/anikage/AnikageProvider\n*L\n46#1:300\n46#1:302,15\n62#1:323\n62#1:325,15\n81#1:346\n81#1:348,15\n87#1:365\n87#1:367,15\n143#1:384\n143#1:386,15\n46#1:301\n62#1:324\n81#1:347\n87#1:366\n143#1:385\n46#1:317\n46#1:318\n62#1:340\n62#1:341\n81#1:363\n81#1:364\n87#1:382\n87#1:383\n143#1:401\n143#1:402\n48#1:319\n48#1:320,3\n64#1:342\n64#1:343,3\n*E\n"})
public final class AnikageProvider extends MainAPI {

    @NotNull
    private final String proxyUrl = "https://gg.akage.lol";

    @NotNull
    private String mainUrl = "https://anikage.cc";

    @NotNull
    private String name = "Anikage";
    private final boolean hasMainPage = true;

    @NotNull
    private String lang = "en";
    private final boolean hasDownloadSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(new TvType[]{TvType.Anime, TvType.AnimeMovie, TvType.OVA});

    @NotNull
    private final List<MainPageData> mainPage = MainAPIKt.mainPageOf(new Pair[]{TuplesKt.to(getMainUrl() + "/api/media/anime/browse?sort=trending&limit=25&adult=true&page=", "Trending"), TuplesKt.to(getMainUrl() + "/api/media/anime/browse?sort=updated&page=1&limit=25&adult=true&status=RELEASING&page=", "Latest Updates"), TuplesKt.to(getMainUrl() + "/api/media/anime/browse?sort=popularity&limit=25&adult=true&page=", "Popular"), TuplesKt.to(getMainUrl() + "/api/media/anime/browse?sort=popularity&limit=25&adult=true&format=MOVIE&page=", "Popular Movies"), TuplesKt.to(getMainUrl() + "/api/media/anime/browse?sort=popularity&limit=25&adult=true&format=OVA&page=", "Popular OVAs")});

    /* JADX INFO: renamed from: com.anikage.AnikageProvider$getMainPage$1 */
    /* JADX INFO: compiled from: AnikageProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anikage.AnikageProvider", f = "AnikageProvider.kt", i = {0, 0, 0}, l = {45}, m = "getMainPage", n = {"request", "url", "page"}, nl = {46}, s = {"L$0", "L$1", "I$0"}, v = 2)
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
            return AnikageProvider.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.anikage.AnikageProvider$load$1 */
    /* JADX INFO: compiled from: AnikageProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anikage.AnikageProvider", f = "AnikageProvider.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {79, 87, 94}, m = "load", n = {"url", "slug", "episodesUrl", "url", "slug", "episodesUrl", "episodesText", "episodesList", "infoUrl", "url", "slug", "episodesUrl", "episodesText", "episodesList", "infoUrl", "infoParsed", "animeInfo", "titleName", "tvType"}, nl = {80, 319, -1}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
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
            return AnikageProvider.this.load(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.anikage.AnikageProvider$loadLinks$1 */
    /* JADX INFO: compiled from: AnikageProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anikage.AnikageProvider", f = "AnikageProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {148, 162, 173, 192, 198, 214}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "epData", "lang", "serversUrl", "isCasting", "data", "subtitleCallback", "callback", "epData", "lang", "serversUrl", "serversJson", "serversArray", "server", "serverId", "providerId", "sourceUrl", "isCasting", "i", "data", "subtitleCallback", "callback", "epData", "lang", "serversUrl", "serversJson", "serversArray", "server", "serverId", "providerId", "sourceUrl", "sourceJson", "subtitlesArr", "seenSubs", "sub", "file", "label", "subUrl", "isCasting", "i", "s", "data", "subtitleCallback", "callback", "epData", "lang", "serversUrl", "serversJson", "serversArray", "server", "serverId", "providerId", "sourceUrl", "sourceJson", "subtitlesArr", "seenSubs", "subType", "baseName", "usedEmbedUrls", "sourcesArr", "src", "encodedUrl", "quality", "embedUrl", "isCasting", "i", "hasSubs", "s", "isM3u8", "data", "subtitleCallback", "callback", "epData", "lang", "serversUrl", "serversJson", "serversArray", "server", "serverId", "providerId", "sourceUrl", "sourceJson", "subtitlesArr", "seenSubs", "subType", "baseName", "usedEmbedUrls", "sourcesArr", "src", "encodedUrl", "quality", "embedUrl", "videoUrl", "nameStr", "isCasting", "i", "hasSubs", "s", "isM3u8", "data", "subtitleCallback", "callback", "epData", "lang", "serversUrl", "serversJson", "serversArray", "server", "serverId", "providerId", "sourceUrl", "sourceJson", "subtitlesArr", "seenSubs", "subType", "baseName", "usedEmbedUrls", "sourcesArr", "embedsArr", "embed", "embedUrl", "isCasting", "i", "hasSubs", "e"}, nl = {149, 163, 167, 195, 197, 210}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "Z$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "Z$0", "I$0", "I$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "Z$0", "I$0", "I$2", "I$3", "Z$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "Z$0", "I$0", "I$2", "I$3", "Z$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "Z$0", "I$0", "I$2", "I$3"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
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
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnikageProvider.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.anikage.AnikageProvider$search$1 */
    /* JADX INFO: compiled from: AnikageProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anikage.AnikageProvider", f = "AnikageProvider.kt", i = {0, 0}, l = {61}, m = "search", n = {"query", "url"}, nl = {62}, s = {"L$0", "L$1"}, v = 2)
    static final class C00061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00061(Continuation<? super C00061> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnikageProvider.this.search(null, (Continuation) this);
        }
    }

    private final String buildProxyUrl(String path, String type) {
        if (StringsKt.startsWith$default(path, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(path, "https://", false, 2, (Object) null)) {
            return path;
        }
        if (StringsKt.startsWith$default(path, "/m3u8/", false, 2, (Object) null) || StringsKt.startsWith$default(path, "/stream/", false, 2, (Object) null) || StringsKt.startsWith$default(path, "/hls/", false, 2, (Object) null)) {
            return this.proxyUrl + path;
        }
        if (StringsKt.startsWith$default(path, "m3u8/", false, 2, (Object) null) || StringsKt.startsWith$default(path, "stream/", false, 2, (Object) null) || StringsKt.startsWith$default(path, "hls/", false, 2, (Object) null)) {
            return this.proxyUrl + '/' + path;
        }
        return this.proxyUrl + '/' + type + '/' + path;
    }

    static /* synthetic */ String buildProxyUrl$default(AnikageProvider anikageProvider, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "stream";
        }
        return anikageProvider.buildProxyUrl(str, str2);
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

    @NotNull
    public List<MainPageData> getMainPage() {
        return this.mainPage;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) {
        C00001 c00001;
        boolean z;
        MainPageRequest request2;
        Object obj;
        Object obj2;
        Object objDecodeFromString;
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
                String url = request.getData() + page;
                Requests app = MainActivityKt.getApp();
                c00001.L$0 = request;
                c00001.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00001.I$0 = page;
                c00001.label = 1;
                z = true;
                Object obj3 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00001, 4094, (Object) null);
                if (obj3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                request2 = request;
                obj = obj3;
                break;
                break;
            case 1:
                int i = c00001.I$0;
                request2 = (MainPageRequest) c00001.L$0;
                ResultKt.throwOnFailure($result);
                z = true;
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String responseText = ((NiceResponse) obj).getText();
        AppUtils appUtils = AppUtils.INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            KType kTypeTypeOf = Reflection.typeOf(AnikageResponse.class);
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
            obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj2) != null) {
            try {
                Result.Companion companion3 = Result.Companion;
                obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnikageResponse.class), (List) null, 2, (Object) null));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
            }
        }
        DeserializationStrategy deserializationStrategy = (KSerializer) (Result.isFailure-impl(obj2) ? null : obj2);
        if (deserializationStrategy != null) {
            try {
                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, responseText);
            } catch (SerializationException e) {
                ArchComponentExtKt.logError(e);
                ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv.readValue(responseText, new TypeReference<AnikageResponse>() { // from class: com.anikage.AnikageProvider$getMainPage$$inlined$parseJson$1
                });
            } catch (Throwable th3) {
                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv2.readValue(responseText, new TypeReference<AnikageResponse>() { // from class: com.anikage.AnikageProvider$getMainPage$$inlined$parseJson$1
                });
            }
        } else {
            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
            objDecodeFromString = $this$readValue$iv$iv3.readValue(responseText, new TypeReference<AnikageResponse>() { // from class: com.anikage.AnikageProvider$getMainPage$$inlined$parseJson$1
            });
        }
        AnikageResponse parsed = (AnikageResponse) objDecodeFromString;
        Iterable $this$map$iv = parsed.getData();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            AnimeResult it = (AnimeResult) item$iv$iv;
            destination$iv$iv.add(toSearchResponse(it));
        }
        List home = (List) destination$iv$iv;
        return MainAPIKt.newHomePageResponse(new HomePageList(request2.getName(), home, false, 4, (DefaultConstructorMarker) null), Boxing.boxBoolean(z));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) {
        C00061 c00061;
        Object obj;
        Object obj2;
        Object objDecodeFromString;
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
                String url = getMainUrl() + "/api/media/anime/browse?per_page=25&page=1&query=" + query;
                Requests app = MainActivityKt.getApp();
                c00062.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00062.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00062.label = 1;
                obj = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00062, 4094, (Object) null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String responseText = ((NiceResponse) obj).getText();
        AppUtils appUtils = AppUtils.INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            KType kTypeTypeOf = Reflection.typeOf(AnikageResponse.class);
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
            obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj2) != null) {
            try {
                Result.Companion companion3 = Result.Companion;
                obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnikageResponse.class), (List) null, 2, (Object) null));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
            }
        }
        DeserializationStrategy deserializationStrategy = (KSerializer) (Result.isFailure-impl(obj2) ? null : obj2);
        if (deserializationStrategy != null) {
            try {
                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, responseText);
            } catch (SerializationException e) {
                ArchComponentExtKt.logError(e);
                ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv.readValue(responseText, new TypeReference<AnikageResponse>() { // from class: com.anikage.AnikageProvider$search$$inlined$parseJson$1
                });
            } catch (Throwable th3) {
                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv2.readValue(responseText, new TypeReference<AnikageResponse>() { // from class: com.anikage.AnikageProvider$search$$inlined$parseJson$1
                });
            }
        } else {
            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
            objDecodeFromString = $this$readValue$iv$iv3.readValue(responseText, new TypeReference<AnikageResponse>() { // from class: com.anikage.AnikageProvider$search$$inlined$parseJson$1
            });
        }
        AnikageResponse parsed = (AnikageResponse) objDecodeFromString;
        Iterable $this$map$iv = parsed.getData();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            AnimeResult it = (AnimeResult) item$iv$iv;
            destination$iv$iv.add(toSearchResponse(it));
        }
        return (List) destination$iv$iv;
    }

    private final AnimeSearchResponse toSearchResponse(final AnimeResult $this$toSearchResponse) {
        String english = $this$toSearchResponse.getTitle().getEnglish();
        if (english == null) {
            english = $this$toSearchResponse.getTitle().getRomaji();
        }
        String titleName = english;
        return MainAPIKt.newAnimeSearchResponse$default(this, titleName, $this$toSearchResponse.getSlug(), (TvType) null, false, new Function1() { // from class: com.anikage.AnikageProvider$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return AnikageProvider.toSearchResponse$lambda$0($this$toSearchResponse, (AnimeSearchResponse) obj);
            }
        }, 12, (Object) null);
    }

    static final Unit toSearchResponse$lambda$0(AnimeResult $this_toSearchResponse, AnimeSearchResponse $this$newAnimeSearchResponse) {
        Score scoreFrom10;
        Long meanScore;
        String extraLarge = $this_toSearchResponse.getCoverImage().getExtraLarge();
        if (extraLarge == null) {
            extraLarge = $this_toSearchResponse.getCoverImage().getLarge();
        }
        $this$newAnimeSearchResponse.setPosterUrl(extraLarge);
        AnilistStats anilistStats = $this_toSearchResponse.getAnilistStats();
        if (anilistStats == null || (meanScore = anilistStats.getMeanScore()) == null) {
            scoreFrom10 = null;
        } else {
            double it = meanScore.longValue() / 10.0d;
            scoreFrom10 = Score.Companion.from10(Double.valueOf(it));
        }
        $this$newAnimeSearchResponse.setScore(scoreFrom10);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x028a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:0x0174 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:112:0x01a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x02c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:45:0x01bc A[Catch: Exception -> 0x01d6, TryCatch #6 {Exception -> 0x01d6, blocks: (B:20:0x013a, B:26:0x016d, B:33:0x019a, B:36:0x01a1, B:46:0x01d3, B:45:0x01bc, B:44:0x01b6, B:32:0x018f, B:25:0x0163, B:22:0x0140, B:29:0x0174, B:39:0x01a7), top: B:108:0x013a, inners: #0, #9, #10 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0250 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x0251  */
    /* JADX WARN: Code duplicated, block: B:61:0x0287  */
    /* JADX WARN: Code duplicated, block: B:74:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:83:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:86:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:89:0x030d  */
    /* JADX WARN: Code duplicated, block: B:93:0x031d  */
    /* JADX WARN: Code duplicated, block: B:94:0x0320  */
    /* JADX WARN: Code duplicated, block: B:97:0x0382 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:98:0x0383  */
    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        C00011 c00011;
        List list;
        String str;
        int i;
        Object obj;
        String episodesUrl;
        String episodesUrl2;
        String episodesUrl3;
        String episodesText;
        List episodesList;
        String infoUrl;
        AppUtils appUtils;
        String slug;
        Object obj2;
        List episodesList2;
        String slug2;
        String url2;
        String infoUrl2;
        AppUtils this_$iv;
        Object obj3;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        String value$iv;
        Object obj4;
        Object obj5;
        Object obj6;
        DeserializationStrategy deserializationStrategy2;
        Object objDecodeFromString2;
        AnimeResult animeInfo;
        String english;
        String type;
        boolean z;
        TvType tvType;
        Object objNewAnimeLoadResponse$default;
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
                String slug3 = StringsKt.substringAfterLast$default(url, "/", (String) null, 2, (Object) null);
                String episodesUrl4 = getMainUrl() + "/api/media/anime/" + slug3 + "/episodes";
                Requests app = MainActivityKt.getApp();
                c00012.L$0 = url;
                c00012.L$1 = slug3;
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(episodesUrl4);
                c00012.label = 1;
                list = null;
                str = "/api/media/anime/";
                i = 2;
                obj = Requests.get$default(app, episodesUrl4, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00012, 4094, (Object) null);
                c00012 = c00012;
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                episodesUrl = episodesUrl4;
                episodesUrl2 = slug3;
                episodesUrl3 = url;
                episodesText = ((NiceResponse) obj).getText();
                try {
                    AppUtils appUtils2 = AppUtils.INSTANCE;
                    try {
                        Result.Companion companion = Result.Companion;
                        KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(EpisodeResult.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (Result.exceptionOrNull-impl(obj3) != null) {
                        try {
                            Result.Companion companion3 = Result.Companion;
                            obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), list, i, list));
                        } catch (Throwable th2) {
                            Result.Companion companion4 = Result.Companion;
                            obj3 = Result.constructor-impl(ResultKt.createFailure(th2));
                        }
                    }
                    if (Result.isFailure-impl(obj3)) {
                        obj3 = list;
                    }
                    deserializationStrategy = (KSerializer) obj3;
                    if (deserializationStrategy != null) {
                        try {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, episodesText);
                        } catch (SerializationException e) {
                            ArchComponentExtKt.logError(e);
                            ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv.readValue(episodesText, new TypeReference<List<? extends EpisodeResult>>() { // from class: com.anikage.AnikageProvider$load$$inlined$parseJson$1
                            });
                        } catch (Throwable th3) {
                            ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv2.readValue(episodesText, new TypeReference<List<? extends EpisodeResult>>() { // from class: com.anikage.AnikageProvider$load$$inlined$parseJson$1
                            });
                        }
                        episodesList = (List) objDecodeFromString;
                        infoUrl = getMainUrl() + str + episodesUrl2;
                        appUtils = AppUtils.INSTANCE;
                        Requests app2 = MainActivityKt.getApp();
                        c00012.L$0 = episodesUrl3;
                        c00012.L$1 = episodesUrl2;
                        c00012.L$2 = SpillingKt.nullOutSpilledVariable(episodesUrl);
                        c00012.L$3 = SpillingKt.nullOutSpilledVariable(episodesText);
                        c00012.L$4 = episodesList;
                        c00012.L$5 = SpillingKt.nullOutSpilledVariable(infoUrl);
                        c00012.L$6 = appUtils;
                        c00012.label = i;
                        C00011 c00013 = c00012;
                        slug = episodesUrl2;
                        obj2 = Requests.get$default(app2, infoUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4094, (Object) null);
                        c00012 = c00013;
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        episodesList2 = episodesList;
                        slug2 = slug;
                        url2 = episodesUrl3;
                        infoUrl2 = infoUrl;
                        this_$iv = appUtils;
                    } else {
                        ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv3.readValue(episodesText, new TypeReference<List<? extends EpisodeResult>>() { // from class: com.anikage.AnikageProvider$load$$inlined$parseJson$1
                        });
                        episodesList = (List) objDecodeFromString;
                        infoUrl = getMainUrl() + str + episodesUrl2;
                        appUtils = AppUtils.INSTANCE;
                        Requests app3 = MainActivityKt.getApp();
                        c00012.L$0 = episodesUrl3;
                        c00012.L$1 = episodesUrl2;
                        c00012.L$2 = SpillingKt.nullOutSpilledVariable(episodesUrl);
                        c00012.L$3 = SpillingKt.nullOutSpilledVariable(episodesText);
                        c00012.L$4 = episodesList;
                        c00012.L$5 = SpillingKt.nullOutSpilledVariable(infoUrl);
                        c00012.L$6 = appUtils;
                        c00012.label = i;
                        C00011 c00014 = c00012;
                        slug = episodesUrl2;
                        obj2 = Requests.get$default(app3, infoUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00014, 4094, (Object) null);
                        c00012 = c00014;
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        episodesList2 = episodesList;
                        slug2 = slug;
                        url2 = episodesUrl3;
                        infoUrl2 = infoUrl;
                        this_$iv = appUtils;
                    }
                    break;
                } catch (Exception e2) {
                    episodesList = CollectionsKt.emptyList();
                }
                value$iv = ((NiceResponse) obj2).getText();
                try {
                    Result.Companion companion5 = Result.Companion;
                    KType kTypeTypeOf2 = Reflection.typeOf(AnimeDetailsResponse.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                    break;
                } catch (Throwable th4) {
                    Result.Companion companion6 = Result.Companion;
                    obj4 = Result.constructor-impl(ResultKt.createFailure(th4));
                }
                if (Result.exceptionOrNull-impl(obj4) != null) {
                    try {
                        Result.Companion companion7 = Result.Companion;
                        obj5 = null;
                        try {
                            obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnimeDetailsResponse.class), (List) null, i, (Object) null));
                        } catch (Throwable th5) {
                            th = th5;
                            Result.Companion companion8 = Result.Companion;
                            obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        obj5 = null;
                    }
                    break;
                } else {
                    obj5 = null;
                }
                obj6 = obj4;
                if (Result.isFailure-impl(obj6)) {
                    obj6 = obj5;
                }
                deserializationStrategy2 = (KSerializer) obj6;
                if (deserializationStrategy2 != null) {
                    try {
                        objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv);
                    } catch (SerializationException e3) {
                        ArchComponentExtKt.logError(e3);
                        ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                        objDecodeFromString2 = $this$readValue$iv$iv4.readValue(value$iv, new TypeReference<AnimeDetailsResponse>() { // from class: com.anikage.AnikageProvider$load$$inlined$parseJson$2
                        });
                    } catch (Throwable th7) {
                        ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                        objDecodeFromString2 = $this$readValue$iv$iv5.readValue(value$iv, new TypeReference<AnimeDetailsResponse>() { // from class: com.anikage.AnikageProvider$load$$inlined$parseJson$2
                        });
                    }
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                    objDecodeFromString2 = $this$readValue$iv$iv6.readValue(value$iv, new TypeReference<AnimeDetailsResponse>() { // from class: com.anikage.AnikageProvider$load$$inlined$parseJson$2
                    });
                }
                AnimeDetailsResponse infoParsed = (AnimeDetailsResponse) objDecodeFromString2;
                animeInfo = infoParsed.getAnime();
                english = animeInfo.getTitle().getEnglish();
                if (english == null) {
                    english = animeInfo.getTitle().getRomaji();
                }
                String titleName = english;
                type = animeInfo.getType();
                z = false;
                if (type != null && StringsKt.contains(type, "movie", true)) {
                    z = true;
                }
                if (z) {
                    tvType = TvType.AnimeMovie;
                } else {
                    tvType = TvType.Anime;
                }
                TvType tvType2 = tvType;
                List episodesList3 = episodesList2;
                String slug4 = slug2;
                C00022 c00022 = new C00022(animeInfo, episodesList3, this, slug4, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(slug4);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(episodesUrl);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(episodesText);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(episodesList3);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(infoUrl2);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(infoParsed);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(animeInfo);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(titleName);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(tvType2);
                c00012.label = 3;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, titleName, url2, tvType2, false, c00022, c00012, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objNewAnimeLoadResponse$default;
            case 1:
                String episodesUrl5 = (String) c00012.L$2;
                episodesUrl2 = (String) c00012.L$1;
                String url3 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                episodesUrl = episodesUrl5;
                str = "/api/media/anime/";
                i = 2;
                obj = $result;
                list = null;
                episodesUrl3 = url3;
                episodesText = ((NiceResponse) obj).getText();
                AppUtils appUtils3 = AppUtils.INSTANCE;
                Result.Companion companion9 = Result.Companion;
                KType kTypeTypeOf3 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(EpisodeResult.class)));
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                if (Result.exceptionOrNull-impl(obj3) != null) {
                    Result.Companion companion10 = Result.Companion;
                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), list, i, list));
                    break;
                }
                if (Result.isFailure-impl(obj3)) {
                    obj3 = list;
                }
                deserializationStrategy = (KSerializer) obj3;
                if (deserializationStrategy != null) {
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, episodesText);
                    episodesList = (List) objDecodeFromString;
                    infoUrl = getMainUrl() + str + episodesUrl2;
                    appUtils = AppUtils.INSTANCE;
                    Requests app4 = MainActivityKt.getApp();
                    c00012.L$0 = episodesUrl3;
                    c00012.L$1 = episodesUrl2;
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(episodesUrl);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(episodesText);
                    c00012.L$4 = episodesList;
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(infoUrl);
                    c00012.L$6 = appUtils;
                    c00012.label = i;
                    C00011 c00015 = c00012;
                    slug = episodesUrl2;
                    obj2 = Requests.get$default(app4, infoUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00015, 4094, (Object) null);
                    c00012 = c00015;
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    episodesList2 = episodesList;
                    slug2 = slug;
                    url2 = episodesUrl3;
                    infoUrl2 = infoUrl;
                    this_$iv = appUtils;
                } else {
                    ObjectMapper $this$readValue$iv$iv7 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv7.readValue(episodesText, new TypeReference<List<? extends EpisodeResult>>() { // from class: com.anikage.AnikageProvider$load$$inlined$parseJson$1
                    });
                    episodesList = (List) objDecodeFromString;
                    infoUrl = getMainUrl() + str + episodesUrl2;
                    appUtils = AppUtils.INSTANCE;
                    Requests app5 = MainActivityKt.getApp();
                    c00012.L$0 = episodesUrl3;
                    c00012.L$1 = episodesUrl2;
                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(episodesUrl);
                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(episodesText);
                    c00012.L$4 = episodesList;
                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(infoUrl);
                    c00012.L$6 = appUtils;
                    c00012.label = i;
                    C00011 c00016 = c00012;
                    slug = episodesUrl2;
                    obj2 = Requests.get$default(app5, infoUrl, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00016, 4094, (Object) null);
                    c00012 = c00016;
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    episodesList2 = episodesList;
                    slug2 = slug;
                    url2 = episodesUrl3;
                    infoUrl2 = infoUrl;
                    this_$iv = appUtils;
                }
                value$iv = ((NiceResponse) obj2).getText();
                Result.Companion companion11 = Result.Companion;
                KType kTypeTypeOf4 = Reflection.typeOf(AnimeDetailsResponse.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                if (Result.exceptionOrNull-impl(obj4) != null) {
                    Result.Companion companion12 = Result.Companion;
                    obj5 = null;
                    obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnimeDetailsResponse.class), (List) null, i, (Object) null));
                    break;
                } else {
                    obj5 = null;
                }
                obj6 = obj4;
                if (Result.isFailure-impl(obj6)) {
                    obj6 = obj5;
                }
                deserializationStrategy2 = (KSerializer) obj6;
                if (deserializationStrategy2 != null) {
                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv);
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv8 = MainAPIKt.getMapper();
                    objDecodeFromString2 = $this$readValue$iv$iv8.readValue(value$iv, new TypeReference<AnimeDetailsResponse>() { // from class: com.anikage.AnikageProvider$load$$inlined$parseJson$2
                    });
                }
                AnimeDetailsResponse infoParsed2 = (AnimeDetailsResponse) objDecodeFromString2;
                animeInfo = infoParsed2.getAnime();
                english = animeInfo.getTitle().getEnglish();
                if (english == null) {
                    english = animeInfo.getTitle().getRomaji();
                }
                String titleName2 = english;
                type = animeInfo.getType();
                z = false;
                if (type != null) {
                    z = true;
                }
                if (z) {
                    tvType = TvType.AnimeMovie;
                } else {
                    tvType = TvType.Anime;
                }
                TvType tvType3 = tvType;
                List episodesList4 = episodesList2;
                String slug5 = slug2;
                C00022 c00023 = new C00022(animeInfo, episodesList4, this, slug5, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(slug5);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(episodesUrl);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(episodesText);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(episodesList4);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(infoUrl2);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(infoParsed2);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(animeInfo);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(titleName2);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(tvType3);
                c00012.label = 3;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, titleName2, url2, tvType3, false, c00023, c00012, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objNewAnimeLoadResponse$default;
            case 2:
                this_$iv = (AppUtils) c00012.L$6;
                String infoUrl3 = (String) c00012.L$5;
                episodesList2 = (List) c00012.L$4;
                String episodesText2 = (String) c00012.L$3;
                String episodesUrl6 = (String) c00012.L$2;
                slug2 = (String) c00012.L$1;
                String url4 = (String) c00012.L$0;
                ResultKt.throwOnFailure($result);
                url2 = url4;
                infoUrl2 = infoUrl3;
                episodesText = episodesText2;
                episodesUrl = episodesUrl6;
                i = 2;
                obj2 = $result;
                value$iv = ((NiceResponse) obj2).getText();
                Result.Companion companion13 = Result.Companion;
                KType kTypeTypeOf5 = Reflection.typeOf(AnimeDetailsResponse.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj4 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                if (Result.exceptionOrNull-impl(obj4) != null) {
                    Result.Companion companion14 = Result.Companion;
                    obj5 = null;
                    obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(AnimeDetailsResponse.class), (List) null, i, (Object) null));
                    break;
                } else {
                    obj5 = null;
                }
                obj6 = obj4;
                if (Result.isFailure-impl(obj6)) {
                    obj6 = obj5;
                }
                deserializationStrategy2 = (KSerializer) obj6;
                if (deserializationStrategy2 != null) {
                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv);
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv9 = MainAPIKt.getMapper();
                    objDecodeFromString2 = $this$readValue$iv$iv9.readValue(value$iv, new TypeReference<AnimeDetailsResponse>() { // from class: com.anikage.AnikageProvider$load$$inlined$parseJson$2
                    });
                }
                AnimeDetailsResponse infoParsed3 = (AnimeDetailsResponse) objDecodeFromString2;
                animeInfo = infoParsed3.getAnime();
                english = animeInfo.getTitle().getEnglish();
                if (english == null) {
                    english = animeInfo.getTitle().getRomaji();
                }
                String titleName3 = english;
                type = animeInfo.getType();
                z = false;
                if (type != null) {
                    z = true;
                }
                if (z) {
                    tvType = TvType.AnimeMovie;
                } else {
                    tvType = TvType.Anime;
                }
                TvType tvType4 = tvType;
                List episodesList5 = episodesList2;
                String slug6 = slug2;
                C00022 c00024 = new C00022(animeInfo, episodesList5, this, slug6, null);
                c00012.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                c00012.L$1 = SpillingKt.nullOutSpilledVariable(slug6);
                c00012.L$2 = SpillingKt.nullOutSpilledVariable(episodesUrl);
                c00012.L$3 = SpillingKt.nullOutSpilledVariable(episodesText);
                c00012.L$4 = SpillingKt.nullOutSpilledVariable(episodesList5);
                c00012.L$5 = SpillingKt.nullOutSpilledVariable(infoUrl2);
                c00012.L$6 = SpillingKt.nullOutSpilledVariable(infoParsed3);
                c00012.L$7 = SpillingKt.nullOutSpilledVariable(animeInfo);
                c00012.L$8 = SpillingKt.nullOutSpilledVariable(titleName3);
                c00012.L$9 = SpillingKt.nullOutSpilledVariable(tvType4);
                c00012.label = 3;
                objNewAnimeLoadResponse$default = MainAPIKt.newAnimeLoadResponse$default(this, titleName3, url2, tvType4, false, c00024, c00012, 8, (Object) null);
                if (objNewAnimeLoadResponse$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return objNewAnimeLoadResponse$default;
            case 3:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.anikage.AnikageProvider$load$2 */
    /* JADX INFO: compiled from: AnikageProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/AnimeLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anikage.AnikageProvider$load$2", f = "AnikageProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nAnikageProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnikageProvider.kt\ncom/anikage/AnikageProvider$load$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,299:1\n1#2:300\n1739#3:301\n1814#3,3:302\n1739#3:305\n1814#3,3:306\n*S KotlinDebug\n*F\n+ 1 AnikageProvider.kt\ncom/anikage/AnikageProvider$load$2\n*L\n111#1:301\n111#1:302,3\n123#1:305\n123#1:306,3\n*E\n"})
    static final class C00022 extends SuspendLambda implements Function2<AnimeLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimeResult $animeInfo;
        final /* synthetic */ List<EpisodeResult> $episodesList;
        final /* synthetic */ String $slug;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AnikageProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00022(AnimeResult animeResult, List<EpisodeResult> list, AnikageProvider anikageProvider, String str, Continuation<? super C00022> continuation) {
            super(2, continuation);
            this.$animeInfo = animeResult;
            this.$episodesList = list;
            this.this$0 = anikageProvider;
            this.$slug = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00022 = new C00022(this.$animeInfo, this.$episodesList, this.this$0, this.$slug, continuation);
            c00022.L$0 = obj;
            return c00022;
        }

        public final Object invoke(AnimeLoadResponse animeLoadResponse, Continuation<? super Unit> continuation) {
            return create(animeLoadResponse, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x00ca  */
        public final Object invokeSuspend(Object $result) {
            Score scoreFrom10;
            String strReplace;
            Long meanScore;
            LoadResponse loadResponse = (AnimeLoadResponse) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String extraLarge = this.$animeInfo.getCoverImage().getExtraLarge();
                    if (extraLarge == null) {
                        extraLarge = this.$animeInfo.getCoverImage().getLarge();
                    }
                    loadResponse.setPosterUrl(extraLarge);
                    loadResponse.setBackgroundPosterUrl(this.$animeInfo.getBannerImage());
                    Long year = this.$animeInfo.getYear();
                    ShowStatus showStatus = null;
                    loadResponse.setYear(year != null ? Boxing.boxInt((int) year.longValue()) : null);
                    AnilistStats anilistStats = this.$animeInfo.getAnilistStats();
                    if (anilistStats == null || (meanScore = anilistStats.getMeanScore()) == null) {
                        scoreFrom10 = null;
                    } else {
                        double it = meanScore.longValue() / 10.0d;
                        scoreFrom10 = Score.Companion.from10(Boxing.boxDouble(it));
                    }
                    loadResponse.setScore(scoreFrom10);
                    Long anilistId = this.$animeInfo.getAnilistId();
                    if (anilistId != null) {
                        long it2 = anilistId.longValue();
                        LoadResponse.Companion.addAniListId(loadResponse, Boxing.boxInt((int) it2));
                    }
                    Long malId = this.$animeInfo.getMalId();
                    if (malId != null) {
                        long it3 = malId.longValue();
                        LoadResponse.Companion.addMalId(loadResponse, Boxing.boxInt((int) it3));
                    }
                    String description = this.$animeInfo.getDescription();
                    if (description != null) {
                        strReplace = new Regex("<.*?>").replace(description, "");
                        if (strReplace == null) {
                            strReplace = "Format: " + this.$animeInfo.getFormat();
                        }
                    } else {
                        strReplace = "Format: " + this.$animeInfo.getFormat();
                    }
                    loadResponse.setPlot(strReplace);
                    String status = this.$animeInfo.getStatus();
                    if (Intrinsics.areEqual(status, "FINISHED")) {
                        showStatus = ShowStatus.Completed;
                    } else if (Intrinsics.areEqual(status, "RELEASING")) {
                        showStatus = ShowStatus.Ongoing;
                    }
                    loadResponse.setShowStatus(showStatus);
                    loadResponse.setTags(this.$animeInfo.getGenres());
                    Iterable $this$map$iv = this.$episodesList;
                    AnikageProvider anikageProvider = this.this$0;
                    String str = this.$slug;
                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        final EpisodeResult ep = (EpisodeResult) item$iv$iv;
                        destination$iv$iv.add(MainAPIKt.newEpisode(anikageProvider, AppUtils.INSTANCE.toJson(new EpisodeData(str, ep.getNumber(), false)), new Function1() { // from class: com.anikage.AnikageProvider$load$2$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                return AnikageProvider.C00022.invokeSuspend$lambda$3$0(ep, (Episode) obj);
                            }
                        }));
                        $this$map$iv = $this$map$iv;
                        anikageProvider = anikageProvider;
                    }
                    List subEpisodes = (List) destination$iv$iv;
                    MainAPIKt.addEpisodes(loadResponse, DubStatus.Subbed, subEpisodes);
                    Iterable $this$map$iv2 = this.$episodesList;
                    AnikageProvider anikageProvider2 = this.this$0;
                    String str2 = this.$slug;
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    for (Object item$iv$iv2 : $this$map$iv2) {
                        final EpisodeResult ep2 = (EpisodeResult) item$iv$iv2;
                        destination$iv$iv2.add(MainAPIKt.newEpisode(anikageProvider2, AppUtils.INSTANCE.toJson(new EpisodeData(str2, ep2.getNumber(), true)), new Function1() { // from class: com.anikage.AnikageProvider$load$2$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                return AnikageProvider.C00022.invokeSuspend$lambda$4$0(ep2, (Episode) obj);
                            }
                        }));
                        subEpisodes = subEpisodes;
                        $this$map$iv2 = $this$map$iv2;
                    }
                    List dubEpisodes = (List) destination$iv$iv2;
                    MainAPIKt.addEpisodes(loadResponse, DubStatus.Dubbed, dubEpisodes);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$3$0(EpisodeResult $ep, Episode $this$newEpisode) {
            $this$newEpisode.setEpisode(Integer.valueOf($ep.getNumber()));
            String title = $ep.getTitle();
            if (title == null) {
                title = "Episode " + $ep.getNumber();
            }
            $this$newEpisode.setName(title);
            $this$newEpisode.setPosterUrl($ep.getImage());
            $this$newEpisode.setDescription($ep.getDescription());
            Double rating = $ep.getRating();
            if (rating != null) {
                double it = rating.doubleValue();
                $this$newEpisode.setScore(Score.Companion.from10(String.valueOf(it)));
            }
            MainAPIKt.addDate$default($this$newEpisode, $ep.getAirDate(), (String) null, 2, (Object) null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$4$0(EpisodeResult $ep, Episode $this$newEpisode) {
            $this$newEpisode.setEpisode(Integer.valueOf($ep.getNumber()));
            String title = $ep.getTitle();
            if (title == null) {
                title = "Episode " + $ep.getNumber();
            }
            $this$newEpisode.setName(title);
            $this$newEpisode.setPosterUrl($ep.getImage());
            $this$newEpisode.setDescription($ep.getDescription());
            Double rating = $ep.getRating();
            if (rating != null) {
                double it = rating.doubleValue();
                $this$newEpisode.setScore(Score.Companion.from10(String.valueOf(it)));
            }
            MainAPIKt.addDate$default($this$newEpisode, $ep.getAirDate(), (String) null, 2, (Object) null);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:139:0x09b5  */
    /* JADX WARN: Code duplicated, block: B:141:0x09bb  */
    /* JADX WARN: Code duplicated, block: B:142:0x09c2  */
    /* JADX WARN: Code duplicated, block: B:144:0x09d8  */
    /* JADX WARN: Code duplicated, block: B:149:0x0a14  */
    /* JADX WARN: Code duplicated, block: B:153:0x0a35  */
    /* JADX WARN: Code duplicated, block: B:155:0x0a38  */
    /* JADX WARN: Code duplicated, block: B:164:0x0b66  */
    /* JADX WARN: Code duplicated, block: B:165:0x0b6f  */
    /* JADX WARN: Code duplicated, block: B:168:0x0b8a  */
    /* JADX WARN: Code duplicated, block: B:170:0x0b94  */
    /* JADX WARN: Code duplicated, block: B:171:0x0b97  */
    /* JADX WARN: Code duplicated, block: B:173:0x0b9b  */
    /* JADX WARN: Code duplicated, block: B:174:0x0bdf  */
    /* JADX WARN: Code duplicated, block: B:177:0x0be9  */
    /* JADX WARN: Code duplicated, block: B:181:0x0c08  */
    /* JADX WARN: Code duplicated, block: B:182:0x0c0b  */
    /* JADX WARN: Code duplicated, block: B:185:0x0cba A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:186:0x0cbb  */
    /* JADX WARN: Code duplicated, block: B:191:0x0d24  */
    /* JADX WARN: Code duplicated, block: B:192:0x0d29  */
    /* JADX WARN: Code duplicated, block: B:264:0x0d0d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:265:0x09f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:205:0x0e30 -> B:206:0x0e5c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:208:0x0e84 -> B:209:0x0e9c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:219:0x0f73 -> B:220:0x0f83). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object loadLinks(@org.jetbrains.annotations.NotNull java.lang.String r65, boolean r66, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r67, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r68, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r69) {
        /*
            Method dump skipped, instruction units count: 4046
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anikage.AnikageProvider.loadLinks(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.anikage.AnikageProvider$loadLinks$2 */
    /* JADX INFO: compiled from: AnikageProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/SubtitleFile;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anikage.AnikageProvider$loadLinks$2", f = "AnikageProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00042 extends SuspendLambda implements Function2<SubtitleFile, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00042(Continuation<? super C00042> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00042 = AnikageProvider.this.new C00042(continuation);
            c00042.L$0 = obj;
            return c00042;
        }

        public final Object invoke(SubtitleFile subtitleFile, Continuation<? super Unit> continuation) {
            return create(subtitleFile, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            SubtitleFile $this$newSubtitleFile = (SubtitleFile) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    $this$newSubtitleFile.setHeaders(MapsKt.mapOf(new Pair[]{TuplesKt.to("Referer", AnikageProvider.this.getMainUrl() + '/'), TuplesKt.to("Origin", AnikageProvider.this.getMainUrl() + '/')}));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.anikage.AnikageProvider$loadLinks$3 */
    /* JADX INFO: compiled from: AnikageProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.anikage.AnikageProvider$loadLinks$3", f = "AnikageProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00053 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $quality;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00053(String str, Continuation<? super C00053> continuation) {
            super(2, continuation);
            this.$quality = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00053 = AnikageProvider.this.new C00053(this.$quality, continuation);
            c00053.L$0 = obj;
            return c00053;
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
                    $this$newExtractorLink.setQuality(AnikageProvider.this.getQualityFromName(this.$quality));
                    $this$newExtractorLink.setReferer(AnikageProvider.this.getMainUrl() + '/');
                    $this$newExtractorLink.setHeaders(MapsKt.mapOf(new Pair[]{TuplesKt.to("Referer", AnikageProvider.this.getMainUrl() + '/'), TuplesKt.to("Origin", AnikageProvider.this.getMainUrl() + '/')}));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getQualityFromName(String quality) {
        if (quality != null && StringsKt.contains$default(quality, "1080", false, 2, (Object) null)) {
            return Qualities.P1080.getValue();
        }
        if (quality != null && StringsKt.contains$default(quality, "720", false, 2, (Object) null)) {
            return Qualities.P720.getValue();
        }
        if (quality != null && StringsKt.contains$default(quality, "480", false, 2, (Object) null)) {
            return Qualities.P480.getValue();
        }
        return quality != null && StringsKt.contains$default(quality, "360", false, 2, (Object) null) ? Qualities.P360.getValue() : Qualities.P1080.getValue();
    }

    /* JADX INFO: compiled from: AnikageProvider.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/anikage/AnikageProvider$EpisodeData;", "", "slug", "", "number", "", "isDub", "", "<init>", "(Ljava/lang/String;IZ)V", "getSlug", "()Ljava/lang/String;", "getNumber", "()I", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "Anikage"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class EpisodeData {
        private final boolean isDub;
        private final int number;

        @NotNull
        private final String slug;

        public static /* synthetic */ EpisodeData copy$default(EpisodeData episodeData, String str, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = episodeData.slug;
            }
            if ((i2 & 2) != 0) {
                i = episodeData.number;
            }
            if ((i2 & 4) != 0) {
                z = episodeData.isDub;
            }
            return episodeData.copy(str, i, z);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSlug() {
            return this.slug;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getNumber() {
            return this.number;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsDub() {
            return this.isDub;
        }

        @NotNull
        public final EpisodeData copy(@NotNull String slug, int number, boolean isDub) {
            return new EpisodeData(slug, number, isDub);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EpisodeData)) {
                return false;
            }
            EpisodeData episodeData = (EpisodeData) other;
            return Intrinsics.areEqual(this.slug, episodeData.slug) && this.number == episodeData.number && this.isDub == episodeData.isDub;
        }

        public int hashCode() {
            return (((this.slug.hashCode() * 31) + this.number) * 31) + AnikageProvider$EpisodeData$$ExternalSyntheticBackport0.m1m(this.isDub);
        }

        @NotNull
        public String toString() {
            return "EpisodeData(slug=" + this.slug + ", number=" + this.number + ", isDub=" + this.isDub + ')';
        }

        public EpisodeData(@NotNull String slug, int number, boolean isDub) {
            this.slug = slug;
            this.number = number;
            this.isDub = isDub;
        }

        public /* synthetic */ EpisodeData(String str, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, (i2 & 4) != 0 ? false : z);
        }

        public final int getNumber() {
            return this.number;
        }

        @NotNull
        public final String getSlug() {
            return this.slug;
        }

        public final boolean isDub() {
            return this.isDub;
        }
    }

    /* JADX INFO: compiled from: AnikageProvider.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/anikage/AnikageProvider$AnikageResponse;", "", "count", "", "data", "", "Lcom/anikage/AnikageProvider$AnimeResult;", "<init>", "(JLjava/util/List;)V", "getCount", "()J", "getData", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anikage"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AnikageResponse {
        private final long count;

        @NotNull
        private final List<AnimeResult> data;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AnikageResponse copy$default(AnikageResponse anikageResponse, long j, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                j = anikageResponse.count;
            }
            if ((i & 2) != 0) {
                list = anikageResponse.data;
            }
            return anikageResponse.copy(j, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getCount() {
            return this.count;
        }

        @NotNull
        public final List<AnimeResult> component2() {
            return this.data;
        }

        @NotNull
        public final AnikageResponse copy(long count, @NotNull List<AnimeResult> data) {
            return new AnikageResponse(count, data);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnikageResponse)) {
                return false;
            }
            AnikageResponse anikageResponse = (AnikageResponse) other;
            return this.count == anikageResponse.count && Intrinsics.areEqual(this.data, anikageResponse.data);
        }

        public int hashCode() {
            return (AnikageProvider$AnikageResponse$$ExternalSyntheticBackport0.m0m(this.count) * 31) + this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "AnikageResponse(count=" + this.count + ", data=" + this.data + ')';
        }

        public AnikageResponse(long count, @NotNull List<AnimeResult> list) {
            this.count = count;
            this.data = list;
        }

        public final long getCount() {
            return this.count;
        }

        @NotNull
        public final List<AnimeResult> getData() {
            return this.data;
        }
    }

    /* JADX INFO: compiled from: AnikageProvider.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/anikage/AnikageProvider$AnimeDetailsResponse;", "", "anime", "Lcom/anikage/AnikageProvider$AnimeResult;", "<init>", "(Lcom/anikage/AnikageProvider$AnimeResult;)V", "getAnime", "()Lcom/anikage/AnikageProvider$AnimeResult;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Anikage"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AnimeDetailsResponse {

        @NotNull
        private final AnimeResult anime;

        public static /* synthetic */ AnimeDetailsResponse copy$default(AnimeDetailsResponse animeDetailsResponse, AnimeResult animeResult, int i, Object obj) {
            if ((i & 1) != 0) {
                animeResult = animeDetailsResponse.anime;
            }
            return animeDetailsResponse.copy(animeResult);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final AnimeResult getAnime() {
            return this.anime;
        }

        @NotNull
        public final AnimeDetailsResponse copy(@NotNull AnimeResult anime) {
            return new AnimeDetailsResponse(anime);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AnimeDetailsResponse) && Intrinsics.areEqual(this.anime, ((AnimeDetailsResponse) other).anime);
        }

        public int hashCode() {
            return this.anime.hashCode();
        }

        @NotNull
        public String toString() {
            return "AnimeDetailsResponse(anime=" + this.anime + ')';
        }

        public AnimeDetailsResponse(@NotNull AnimeResult anime) {
            this.anime = anime;
        }

        @NotNull
        public final AnimeResult getAnime() {
            return this.anime;
        }
    }

    /* JADX INFO: compiled from: AnikageProvider.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b/\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B§\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u00103\u001a\u00020\u0003HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u00106\u001a\u00020\bHÆ\u0003J\t\u00107\u001a\u00020\nHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u00101JÎ\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÆ\u0001¢\u0006\u0002\u0010DJ\u0014\u0010E\u001a\u00020\u00182\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010G\u001a\u00020HHÖ\u0081\u0004J\n\u0010I\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b)\u0010\u001eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b+\u0010\u001eR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u00102\u001a\u0004\b\u0017\u00101¨\u0006J"}, d2 = {"Lcom/anikage/AnikageProvider$AnimeResult;", "", "slug", "", "anilistId", "", "malId", "title", "Lcom/anikage/AnikageProvider$AnimeTitle;", "coverImage", "Lcom/anikage/AnikageProvider$AnikageCoverImage;", "bannerImage", "format", "type", "status", "year", "season", "totalEpisodes", "description", "genres", "", "anilistStats", "Lcom/anikage/AnikageProvider$AnilistStats;", "isAdult", "", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lcom/anikage/AnikageProvider$AnimeTitle;Lcom/anikage/AnikageProvider$AnikageCoverImage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Lcom/anikage/AnikageProvider$AnilistStats;Ljava/lang/Boolean;)V", "getSlug", "()Ljava/lang/String;", "getAnilistId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMalId", "getTitle", "()Lcom/anikage/AnikageProvider$AnimeTitle;", "getCoverImage", "()Lcom/anikage/AnikageProvider$AnikageCoverImage;", "getBannerImage", "getFormat", "getType", "getStatus", "getYear", "getSeason", "getTotalEpisodes", "getDescription", "getGenres", "()Ljava/util/List;", "getAnilistStats", "()Lcom/anikage/AnikageProvider$AnilistStats;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lcom/anikage/AnikageProvider$AnimeTitle;Lcom/anikage/AnikageProvider$AnikageCoverImage;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Lcom/anikage/AnikageProvider$AnilistStats;Ljava/lang/Boolean;)Lcom/anikage/AnikageProvider$AnimeResult;", "equals", "other", "hashCode", "", "toString", "Anikage"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AnimeResult {

        @Nullable
        private final Long anilistId;

        @Nullable
        private final AnilistStats anilistStats;

        @Nullable
        private final String bannerImage;

        @NotNull
        private final AnikageCoverImage coverImage;

        @Nullable
        private final String description;

        @Nullable
        private final String format;

        @Nullable
        private final List<String> genres;

        @Nullable
        private final Boolean isAdult;

        @Nullable
        private final Long malId;

        @Nullable
        private final String season;

        @NotNull
        private final String slug;

        @Nullable
        private final String status;

        @NotNull
        private final AnimeTitle title;

        @Nullable
        private final Long totalEpisodes;

        @Nullable
        private final String type;

        @Nullable
        private final Long year;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ AnimeResult copy$default(AnimeResult animeResult, String str, Long l, Long l2, AnimeTitle animeTitle, AnikageCoverImage anikageCoverImage, String str2, String str3, String str4, String str5, Long l3, String str6, Long l4, String str7, List list, AnilistStats anilistStats, Boolean bool, int i, Object obj) {
            String str8 = (i & 1) != 0 ? animeResult.slug : str;
            return animeResult.copy(str8, (i & 2) != 0 ? animeResult.anilistId : l, (i & 4) != 0 ? animeResult.malId : l2, (i & 8) != 0 ? animeResult.title : animeTitle, (i & 16) != 0 ? animeResult.coverImage : anikageCoverImage, (i & 32) != 0 ? animeResult.bannerImage : str2, (i & 64) != 0 ? animeResult.format : str3, (i & 128) != 0 ? animeResult.type : str4, (i & 256) != 0 ? animeResult.status : str5, (i & 512) != 0 ? animeResult.year : l3, (i & 1024) != 0 ? animeResult.season : str6, (i & 2048) != 0 ? animeResult.totalEpisodes : l4, (i & 4096) != 0 ? animeResult.description : str7, (i & 8192) != 0 ? animeResult.genres : list, (i & 16384) != 0 ? animeResult.anilistStats : anilistStats, (i & 32768) != 0 ? animeResult.isAdult : bool);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getSlug() {
            return this.slug;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Long getYear() {
            return this.year;
        }

        @Nullable
        /* JADX INFO: renamed from: component11, reason: from getter */
        public final String getSeason() {
            return this.season;
        }

        @Nullable
        /* JADX INFO: renamed from: component12, reason: from getter */
        public final Long getTotalEpisodes() {
            return this.totalEpisodes;
        }

        @Nullable
        /* JADX INFO: renamed from: component13, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final List<String> component14() {
            return this.genres;
        }

        @Nullable
        /* JADX INFO: renamed from: component15, reason: from getter */
        public final AnilistStats getAnilistStats() {
            return this.anilistStats;
        }

        @Nullable
        /* JADX INFO: renamed from: component16, reason: from getter */
        public final Boolean getIsAdult() {
            return this.isAdult;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getAnilistId() {
            return this.anilistId;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getMalId() {
            return this.malId;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final AnimeTitle getTitle() {
            return this.title;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final AnikageCoverImage getCoverImage() {
            return this.coverImage;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getBannerImage() {
            return this.bannerImage;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getFormat() {
            return this.format;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        @NotNull
        public final AnimeResult copy(@NotNull String slug, @Nullable Long anilistId, @Nullable Long malId, @NotNull AnimeTitle title, @NotNull AnikageCoverImage coverImage, @Nullable String bannerImage, @Nullable String format, @Nullable String type, @Nullable String status, @Nullable Long year, @Nullable String season, @Nullable Long totalEpisodes, @Nullable String description, @Nullable List<String> genres, @Nullable AnilistStats anilistStats, @Nullable Boolean isAdult) {
            return new AnimeResult(slug, anilistId, malId, title, coverImage, bannerImage, format, type, status, year, season, totalEpisodes, description, genres, anilistStats, isAdult);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnimeResult)) {
                return false;
            }
            AnimeResult animeResult = (AnimeResult) other;
            return Intrinsics.areEqual(this.slug, animeResult.slug) && Intrinsics.areEqual(this.anilistId, animeResult.anilistId) && Intrinsics.areEqual(this.malId, animeResult.malId) && Intrinsics.areEqual(this.title, animeResult.title) && Intrinsics.areEqual(this.coverImage, animeResult.coverImage) && Intrinsics.areEqual(this.bannerImage, animeResult.bannerImage) && Intrinsics.areEqual(this.format, animeResult.format) && Intrinsics.areEqual(this.type, animeResult.type) && Intrinsics.areEqual(this.status, animeResult.status) && Intrinsics.areEqual(this.year, animeResult.year) && Intrinsics.areEqual(this.season, animeResult.season) && Intrinsics.areEqual(this.totalEpisodes, animeResult.totalEpisodes) && Intrinsics.areEqual(this.description, animeResult.description) && Intrinsics.areEqual(this.genres, animeResult.genres) && Intrinsics.areEqual(this.anilistStats, animeResult.anilistStats) && Intrinsics.areEqual(this.isAdult, animeResult.isAdult);
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((((this.slug.hashCode() * 31) + (this.anilistId == null ? 0 : this.anilistId.hashCode())) * 31) + (this.malId == null ? 0 : this.malId.hashCode())) * 31) + this.title.hashCode()) * 31) + this.coverImage.hashCode()) * 31) + (this.bannerImage == null ? 0 : this.bannerImage.hashCode())) * 31) + (this.format == null ? 0 : this.format.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.status == null ? 0 : this.status.hashCode())) * 31) + (this.year == null ? 0 : this.year.hashCode())) * 31) + (this.season == null ? 0 : this.season.hashCode())) * 31) + (this.totalEpisodes == null ? 0 : this.totalEpisodes.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.genres == null ? 0 : this.genres.hashCode())) * 31) + (this.anilistStats == null ? 0 : this.anilistStats.hashCode())) * 31) + (this.isAdult != null ? this.isAdult.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AnimeResult(slug=").append(this.slug).append(", anilistId=").append(this.anilistId).append(", malId=").append(this.malId).append(", title=").append(this.title).append(", coverImage=").append(this.coverImage).append(", bannerImage=").append(this.bannerImage).append(", format=").append(this.format).append(", type=").append(this.type).append(", status=").append(this.status).append(", year=").append(this.year).append(", season=").append(this.season).append(", totalEpisodes=");
            sb.append(this.totalEpisodes).append(", description=").append(this.description).append(", genres=").append(this.genres).append(", anilistStats=").append(this.anilistStats).append(", isAdult=").append(this.isAdult).append(')');
            return sb.toString();
        }

        public AnimeResult(@NotNull String slug, @Nullable Long anilistId, @Nullable Long malId, @NotNull AnimeTitle title, @NotNull AnikageCoverImage coverImage, @Nullable String bannerImage, @Nullable String format, @Nullable String type, @Nullable String status, @Nullable Long year, @Nullable String season, @Nullable Long totalEpisodes, @Nullable String description, @Nullable List<String> list, @Nullable AnilistStats anilistStats, @Nullable Boolean isAdult) {
            this.slug = slug;
            this.anilistId = anilistId;
            this.malId = malId;
            this.title = title;
            this.coverImage = coverImage;
            this.bannerImage = bannerImage;
            this.format = format;
            this.type = type;
            this.status = status;
            this.year = year;
            this.season = season;
            this.totalEpisodes = totalEpisodes;
            this.description = description;
            this.genres = list;
            this.anilistStats = anilistStats;
            this.isAdult = isAdult;
        }

        @NotNull
        public final String getSlug() {
            return this.slug;
        }

        @Nullable
        public final Long getAnilistId() {
            return this.anilistId;
        }

        @Nullable
        public final Long getMalId() {
            return this.malId;
        }

        @NotNull
        public final AnimeTitle getTitle() {
            return this.title;
        }

        @NotNull
        public final AnikageCoverImage getCoverImage() {
            return this.coverImage;
        }

        @Nullable
        public final String getBannerImage() {
            return this.bannerImage;
        }

        @Nullable
        public final String getFormat() {
            return this.format;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final Long getYear() {
            return this.year;
        }

        @Nullable
        public final String getSeason() {
            return this.season;
        }

        @Nullable
        public final Long getTotalEpisodes() {
            return this.totalEpisodes;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final List<String> getGenres() {
            return this.genres;
        }

        @Nullable
        public final AnilistStats getAnilistStats() {
            return this.anilistStats;
        }

        @Nullable
        public final Boolean isAdult() {
            return this.isAdult;
        }
    }

    /* JADX INFO: compiled from: AnikageProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/anikage/AnikageProvider$AnimeTitle;", "", "native", "", "romaji", "english", "userPreferred", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNative", "()Ljava/lang/String;", "getRomaji", "getEnglish", "getUserPreferred", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Anikage"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AnimeTitle {

        @Nullable
        private final String english;

        @Nullable
        private final String native;

        @NotNull
        private final String romaji;

        @Nullable
        private final String userPreferred;

        public static /* synthetic */ AnimeTitle copy$default(AnimeTitle animeTitle, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = animeTitle.native;
            }
            if ((i & 2) != 0) {
                str2 = animeTitle.romaji;
            }
            if ((i & 4) != 0) {
                str3 = animeTitle.english;
            }
            if ((i & 8) != 0) {
                str4 = animeTitle.userPreferred;
            }
            return animeTitle.copy(str, str2, str3, str4);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getNative() {
            return this.native;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getRomaji() {
            return this.romaji;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getEnglish() {
            return this.english;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getUserPreferred() {
            return this.userPreferred;
        }

        @NotNull
        public final AnimeTitle copy(@Nullable String str, @NotNull String romaji, @Nullable String english, @Nullable String userPreferred) {
            return new AnimeTitle(str, romaji, english, userPreferred);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnimeTitle)) {
                return false;
            }
            AnimeTitle animeTitle = (AnimeTitle) other;
            return Intrinsics.areEqual(this.native, animeTitle.native) && Intrinsics.areEqual(this.romaji, animeTitle.romaji) && Intrinsics.areEqual(this.english, animeTitle.english) && Intrinsics.areEqual(this.userPreferred, animeTitle.userPreferred);
        }

        public int hashCode() {
            return ((((((this.native == null ? 0 : this.native.hashCode()) * 31) + this.romaji.hashCode()) * 31) + (this.english == null ? 0 : this.english.hashCode())) * 31) + (this.userPreferred != null ? this.userPreferred.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "AnimeTitle(native=" + this.native + ", romaji=" + this.romaji + ", english=" + this.english + ", userPreferred=" + this.userPreferred + ')';
        }

        public AnimeTitle(@Nullable String str, @NotNull String romaji, @Nullable String english, @Nullable String userPreferred) {
            this.native = str;
            this.romaji = romaji;
            this.english = english;
            this.userPreferred = userPreferred;
        }

        @Nullable
        public final String getNative() {
            return this.native;
        }

        @NotNull
        public final String getRomaji() {
            return this.romaji;
        }

        @Nullable
        public final String getEnglish() {
            return this.english;
        }

        @Nullable
        public final String getUserPreferred() {
            return this.userPreferred;
        }
    }

    /* JADX INFO: compiled from: AnikageProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/anikage/AnikageProvider$AnikageCoverImage;", "", "large", "", "medium", "extraLarge", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLarge", "()Ljava/lang/String;", "getMedium", "getExtraLarge", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Anikage"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AnikageCoverImage {

        @Nullable
        private final String extraLarge;

        @Nullable
        private final String large;

        @Nullable
        private final String medium;

        public static /* synthetic */ AnikageCoverImage copy$default(AnikageCoverImage anikageCoverImage, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = anikageCoverImage.large;
            }
            if ((i & 2) != 0) {
                str2 = anikageCoverImage.medium;
            }
            if ((i & 4) != 0) {
                str3 = anikageCoverImage.extraLarge;
            }
            return anikageCoverImage.copy(str, str2, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getLarge() {
            return this.large;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getMedium() {
            return this.medium;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getExtraLarge() {
            return this.extraLarge;
        }

        @NotNull
        public final AnikageCoverImage copy(@Nullable String large, @Nullable String medium, @Nullable String extraLarge) {
            return new AnikageCoverImage(large, medium, extraLarge);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnikageCoverImage)) {
                return false;
            }
            AnikageCoverImage anikageCoverImage = (AnikageCoverImage) other;
            return Intrinsics.areEqual(this.large, anikageCoverImage.large) && Intrinsics.areEqual(this.medium, anikageCoverImage.medium) && Intrinsics.areEqual(this.extraLarge, anikageCoverImage.extraLarge);
        }

        public int hashCode() {
            return ((((this.large == null ? 0 : this.large.hashCode()) * 31) + (this.medium == null ? 0 : this.medium.hashCode())) * 31) + (this.extraLarge != null ? this.extraLarge.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "AnikageCoverImage(large=" + this.large + ", medium=" + this.medium + ", extraLarge=" + this.extraLarge + ')';
        }

        public AnikageCoverImage(@Nullable String large, @Nullable String medium, @Nullable String extraLarge) {
            this.large = large;
            this.medium = medium;
            this.extraLarge = extraLarge;
        }

        @Nullable
        public final String getLarge() {
            return this.large;
        }

        @Nullable
        public final String getMedium() {
            return this.medium;
        }

        @Nullable
        public final String getExtraLarge() {
            return this.extraLarge;
        }
    }

    /* JADX INFO: compiled from: AnikageProvider.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010JV\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\"HÖ\u0081\u0004J\n\u0010#\u001a\u00020$HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u0010R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010¨\u0006%"}, d2 = {"Lcom/anikage/AnikageProvider$AnilistStats;", "", "rating", "", "trending", "", "meanScore", "favourites", "popularity", "averageScore", "<init>", "(Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getRating", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getTrending", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMeanScore", "getFavourites", "getPopularity", "getAverageScore", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/anikage/AnikageProvider$AnilistStats;", "equals", "", "other", "hashCode", "", "toString", "", "Anikage"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class AnilistStats {

        @Nullable
        private final Long averageScore;

        @Nullable
        private final Long favourites;

        @Nullable
        private final Long meanScore;

        @Nullable
        private final Long popularity;

        @Nullable
        private final Double rating;

        @Nullable
        private final Long trending;

        public static /* synthetic */ AnilistStats copy$default(AnilistStats anilistStats, Double d, Long l, Long l2, Long l3, Long l4, Long l5, int i, Object obj) {
            if ((i & 1) != 0) {
                d = anilistStats.rating;
            }
            if ((i & 2) != 0) {
                l = anilistStats.trending;
            }
            if ((i & 4) != 0) {
                l2 = anilistStats.meanScore;
            }
            if ((i & 8) != 0) {
                l3 = anilistStats.favourites;
            }
            if ((i & 16) != 0) {
                l4 = anilistStats.popularity;
            }
            if ((i & 32) != 0) {
                l5 = anilistStats.averageScore;
            }
            Long l6 = l4;
            Long l7 = l5;
            return anilistStats.copy(d, l, l2, l3, l6, l7);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Double getRating() {
            return this.rating;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getTrending() {
            return this.trending;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getMeanScore() {
            return this.meanScore;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Long getFavourites() {
            return this.favourites;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Long getPopularity() {
            return this.popularity;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Long getAverageScore() {
            return this.averageScore;
        }

        @NotNull
        public final AnilistStats copy(@Nullable Double rating, @Nullable Long trending, @Nullable Long meanScore, @Nullable Long favourites, @Nullable Long popularity, @Nullable Long averageScore) {
            return new AnilistStats(rating, trending, meanScore, favourites, popularity, averageScore);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnilistStats)) {
                return false;
            }
            AnilistStats anilistStats = (AnilistStats) other;
            return Intrinsics.areEqual(this.rating, anilistStats.rating) && Intrinsics.areEqual(this.trending, anilistStats.trending) && Intrinsics.areEqual(this.meanScore, anilistStats.meanScore) && Intrinsics.areEqual(this.favourites, anilistStats.favourites) && Intrinsics.areEqual(this.popularity, anilistStats.popularity) && Intrinsics.areEqual(this.averageScore, anilistStats.averageScore);
        }

        public int hashCode() {
            return ((((((((((this.rating == null ? 0 : this.rating.hashCode()) * 31) + (this.trending == null ? 0 : this.trending.hashCode())) * 31) + (this.meanScore == null ? 0 : this.meanScore.hashCode())) * 31) + (this.favourites == null ? 0 : this.favourites.hashCode())) * 31) + (this.popularity == null ? 0 : this.popularity.hashCode())) * 31) + (this.averageScore != null ? this.averageScore.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "AnilistStats(rating=" + this.rating + ", trending=" + this.trending + ", meanScore=" + this.meanScore + ", favourites=" + this.favourites + ", popularity=" + this.popularity + ", averageScore=" + this.averageScore + ')';
        }

        public AnilistStats(@Nullable Double rating, @Nullable Long trending, @Nullable Long meanScore, @Nullable Long favourites, @Nullable Long popularity, @Nullable Long averageScore) {
            this.rating = rating;
            this.trending = trending;
            this.meanScore = meanScore;
            this.favourites = favourites;
            this.popularity = popularity;
            this.averageScore = averageScore;
        }

        @Nullable
        public final Double getRating() {
            return this.rating;
        }

        @Nullable
        public final Long getTrending() {
            return this.trending;
        }

        @Nullable
        public final Long getMeanScore() {
            return this.meanScore;
        }

        @Nullable
        public final Long getFavourites() {
            return this.favourites;
        }

        @Nullable
        public final Long getPopularity() {
            return this.popularity;
        }

        @Nullable
        public final Long getAverageScore() {
            return this.averageScore;
        }
    }

    /* JADX INFO: compiled from: AnikageProvider.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b'\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0084\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010.J\u0014\u0010/\u001a\u00020\f2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00101\u001a\u00020\u0003HÖ\u0081\u0004J\n\u00102\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u000b\u0010\u001cR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b!\u0010\u001fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015¨\u00063"}, d2 = {"Lcom/anikage/AnikageProvider$EpisodeResult;", "", "number", "", "title", "", "description", "image", "rating", "", "airDate", "isFiller", "", "seasonNumber", "episodeInSeason", "seasonName", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getNumber", "()I", "getTitle", "()Ljava/lang/String;", "getDescription", "getImage", "getRating", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getAirDate", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSeasonNumber", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEpisodeInSeason", "getSeasonName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/anikage/AnikageProvider$EpisodeResult;", "equals", "other", "hashCode", "toString", "Anikage"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class EpisodeResult {

        @Nullable
        private final String airDate;

        @Nullable
        private final String description;

        @Nullable
        private final Integer episodeInSeason;

        @Nullable
        private final String image;

        @Nullable
        private final Boolean isFiller;
        private final int number;

        @Nullable
        private final Double rating;

        @Nullable
        private final String seasonName;

        @Nullable
        private final Integer seasonNumber;

        @Nullable
        private final String title;

        public static /* synthetic */ EpisodeResult copy$default(EpisodeResult episodeResult, int i, String str, String str2, String str3, Double d, String str4, Boolean bool, Integer num, Integer num2, String str5, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = episodeResult.number;
            }
            if ((i2 & 2) != 0) {
                str = episodeResult.title;
            }
            if ((i2 & 4) != 0) {
                str2 = episodeResult.description;
            }
            if ((i2 & 8) != 0) {
                str3 = episodeResult.image;
            }
            if ((i2 & 16) != 0) {
                d = episodeResult.rating;
            }
            if ((i2 & 32) != 0) {
                str4 = episodeResult.airDate;
            }
            if ((i2 & 64) != 0) {
                bool = episodeResult.isFiller;
            }
            if ((i2 & 128) != 0) {
                num = episodeResult.seasonNumber;
            }
            if ((i2 & 256) != 0) {
                num2 = episodeResult.episodeInSeason;
            }
            if ((i2 & 512) != 0) {
                str5 = episodeResult.seasonName;
            }
            Integer num3 = num2;
            String str6 = str5;
            Boolean bool2 = bool;
            Integer num4 = num;
            Double d2 = d;
            String str7 = str4;
            return episodeResult.copy(i, str, str2, str3, d2, str7, bool2, num4, num3, str6);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getNumber() {
            return this.number;
        }

        @Nullable
        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getSeasonName() {
            return this.seasonName;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getImage() {
            return this.image;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Double getRating() {
            return this.rating;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getAirDate() {
            return this.airDate;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Boolean getIsFiller() {
            return this.isFiller;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Integer getSeasonNumber() {
            return this.seasonNumber;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Integer getEpisodeInSeason() {
            return this.episodeInSeason;
        }

        @NotNull
        public final EpisodeResult copy(int number, @Nullable String title, @Nullable String description, @Nullable String image, @Nullable Double rating, @Nullable String airDate, @Nullable Boolean isFiller, @Nullable Integer seasonNumber, @Nullable Integer episodeInSeason, @Nullable String seasonName) {
            return new EpisodeResult(number, title, description, image, rating, airDate, isFiller, seasonNumber, episodeInSeason, seasonName);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EpisodeResult)) {
                return false;
            }
            EpisodeResult episodeResult = (EpisodeResult) other;
            return this.number == episodeResult.number && Intrinsics.areEqual(this.title, episodeResult.title) && Intrinsics.areEqual(this.description, episodeResult.description) && Intrinsics.areEqual(this.image, episodeResult.image) && Intrinsics.areEqual(this.rating, episodeResult.rating) && Intrinsics.areEqual(this.airDate, episodeResult.airDate) && Intrinsics.areEqual(this.isFiller, episodeResult.isFiller) && Intrinsics.areEqual(this.seasonNumber, episodeResult.seasonNumber) && Intrinsics.areEqual(this.episodeInSeason, episodeResult.episodeInSeason) && Intrinsics.areEqual(this.seasonName, episodeResult.seasonName);
        }

        public int hashCode() {
            return (((((((((((((((((this.number * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.description == null ? 0 : this.description.hashCode())) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.rating == null ? 0 : this.rating.hashCode())) * 31) + (this.airDate == null ? 0 : this.airDate.hashCode())) * 31) + (this.isFiller == null ? 0 : this.isFiller.hashCode())) * 31) + (this.seasonNumber == null ? 0 : this.seasonNumber.hashCode())) * 31) + (this.episodeInSeason == null ? 0 : this.episodeInSeason.hashCode())) * 31) + (this.seasonName != null ? this.seasonName.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "EpisodeResult(number=" + this.number + ", title=" + this.title + ", description=" + this.description + ", image=" + this.image + ", rating=" + this.rating + ", airDate=" + this.airDate + ", isFiller=" + this.isFiller + ", seasonNumber=" + this.seasonNumber + ", episodeInSeason=" + this.episodeInSeason + ", seasonName=" + this.seasonName + ')';
        }

        public EpisodeResult(int number, @Nullable String title, @Nullable String description, @Nullable String image, @Nullable Double rating, @Nullable String airDate, @Nullable Boolean isFiller, @Nullable Integer seasonNumber, @Nullable Integer episodeInSeason, @Nullable String seasonName) {
            this.number = number;
            this.title = title;
            this.description = description;
            this.image = image;
            this.rating = rating;
            this.airDate = airDate;
            this.isFiller = isFiller;
            this.seasonNumber = seasonNumber;
            this.episodeInSeason = episodeInSeason;
            this.seasonName = seasonName;
        }

        public final int getNumber() {
            return this.number;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final String getImage() {
            return this.image;
        }

        @Nullable
        public final Double getRating() {
            return this.rating;
        }

        @Nullable
        public final String getAirDate() {
            return this.airDate;
        }

        @Nullable
        public final Boolean isFiller() {
            return this.isFiller;
        }

        @Nullable
        public final Integer getSeasonNumber() {
            return this.seasonNumber;
        }

        @Nullable
        public final Integer getEpisodeInSeason() {
            return this.episodeInSeason;
        }

        @Nullable
        public final String getSeasonName() {
            return this.seasonName;
        }
    }
}
