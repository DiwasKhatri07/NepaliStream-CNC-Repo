package com.cncverse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ProviderManager.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/CricifyProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\rJ\u000e\u0010\u000f\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\rJ \u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000b0\nH\u0086@¢\u0006\u0002\u0010\rJ\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\nH\u0086@¢\u0006\u0002\u0010\rJ\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\n2\u0006\u0010\u0014\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/cncverse/ProviderManager;", "", "<init>", "()V", "DEFAULT_BASE_URL", "", "cachedBaseUrl", "client", "Lokhttp3/OkHttpClient;", "fallbackProviders", "", "", "getBaseUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProvidersUrl", "getLiveEventsUrl", "fetchProviders", "fetchLiveEvents", "Lcom/cncverse/LiveEventData;", "fetchCustomEvents", "catLink", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CricifyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProviderManager.kt\ncom/cncverse/ProviderManager\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,318:1\n1#2:319\n*E\n"})
public final class ProviderManager {

    @NotNull
    private static final String DEFAULT_BASE_URL = "https://cfymarkscanjiostar80.top";

    @Nullable
    private static String cachedBaseUrl;

    @NotNull
    public static final ProviderManager INSTANCE = new ProviderManager();

    @NotNull
    private static final OkHttpClient client = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).build();

    @NotNull
    private static final List<Map<String, Object>> fallbackProviders = CollectionsKt.listOf(new Map[]{MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 13), TuplesKt.to("title", "TATA PLAY"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQz_qYe3Y4S5bXXVlPtXQnqtAkLw1-no57QHhPyMgWE0SQmxujzHxZKiDs&s=10"), TuplesKt.to("catLink", "https://hotstarlive.delta-cloud.workers.dev/?token=240bb9-374e2e-3c13f0-4a7xz5")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 14), TuplesKt.to("title", "HOTSTAR"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRWwYjMvB58DMLsL9Ii2fhvw6NBYvD1iVCjOMU8TXBLJt0eibLGOjoRkLJP&s=10"), TuplesKt.to("catLink", "https://hotstar-live-event.alpha-circuit.workers.dev/?token=a13d9c-4b782a-6c90fd-9a1b84")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 15), TuplesKt.to("title", "TATAPLAY BD"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQz_qYe3Y4S5bXXVlPtXQnqtAkLw1-no57QHhPyMgWE0SQmxujzHxZKiDs&s=10"), TuplesKt.to("catLink", "https://ranapk.short.gy/BDIX/tata.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 17), TuplesKt.to("title", "T SPORTS "), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJ0QvfKyjAqcCOumIXjcuYg505GnaBeVk2lQ&usqp=CAU "), TuplesKt.to("catLink", "https://fifabangladesh2-xyz-ekkj.spidy.online/AYN/tsports.m3u  ")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 18), TuplesKt.to("title", "FANCODE IND"), TuplesKt.to("image", "https://play-lh.googleusercontent.com/lp1Tdhp75MQyrHqrsyRBV74HxoL3Ko8KRAjOUI1wUHREAxuuVwKR6vnamgvMEn4C4Q"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/Jitendra-unatti/fancode/refs/heads/main/data/fancode.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 19), TuplesKt.to("title", "SONYLIV"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTzscCrHEfnHNeZdMO3haF1XSVgjskN4TNv0g&usqp=CAU "), TuplesKt.to("catLink", "https://raw.githubusercontent.com/doctor-8trange/zyphora/refs/heads/main/data/sony.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 22), TuplesKt.to("title", "JIO IND"), TuplesKt.to("image", "https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/jio-logo-icon.png "), TuplesKt.to("catLink", "https://jiotv.byte-vault.workers.dev/?token=42e4f5-2d873b-3c37d8-7f3f50")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 29), TuplesKt.to("title", "SONY IN"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxsCm4WKugE7ubLr2J3AP7s-hqHl0dh69ImA&usqp=CAU"), TuplesKt.to("catLink", "https://sonyliv.logic-lane.workers.dev?token=a14d9c-4b782a-6c90fd-9a1b84")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 31), TuplesKt.to("title", "SONY IN 2"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxsCm4WKugE7ubLr2J3AP7s-hqHl0dh69ImA&usqp=CAU"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/ramnarayan01/data/refs/heads/main/s0nyind.m3u.html")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 48), TuplesKt.to("title", "SUN DIRECT"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwc4OuqPmOP-Fi9dhfiDw_q-s3rOmgCPla_IaE76VD2KRQ7c4KHeI2zJY&s=10"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/suntv.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 70), TuplesKt.to("title", "VOOT BD"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfS6QZFts2FoedMGZE28H7Kh158PsrNIiabFBVJMy_jXa8Tvvb9WAlut8&s=10"), TuplesKt.to("catLink", "https://ranapk.short.gy/VOOTBD.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 71), TuplesKt.to("title", "VOOT IND"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfS6QZFts2FoedMGZE28H7Kh158PsrNIiabFBVJMy_jXa8Tvvb9WAlut8&s=10"), TuplesKt.to("catLink", "https://jiocinema-live.cloud-hatchh.workers.dev/?token=42e4f5-2d414b-3c37d8-5f3f45")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 85), TuplesKt.to("title", "SUN NXT"), TuplesKt.to("image", "https://upload.wikimedia.org/wikipedia/en/d/d5/Sun_NXT_logo_small.png"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alexandermail371/cricfytv/refs/heads/main/sunxt.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 90), TuplesKt.to("title", "AIRTEL IND"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQf7pkggfHJKj2R8O6ttuHxgv-vQVL03xUeAg&usqp=CAU"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/artl.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 92), TuplesKt.to("title", "DISTRO TV"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRYQjBTT5SL_kuJF7CbQtoSEA7PzyiH9RYIuDO9F1sx87CtiULDyiDf7ybt&s=10"), TuplesKt.to("catLink", "https://playlist-storage.pages.dev/PLAYLIST/DistroTV.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 104), TuplesKt.to("title", "ZEE5"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQS0OT2NFe9Jb4ofg_DrXx42EKLgyGnSGwoLg&usqp=CAU"), TuplesKt.to("catLink", "https://zee5.cloud-hatchh.workers.dev/?token=42e4f5-2d413b-3c37d8-7f3f35")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 106), TuplesKt.to("title", "JIOTV+"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRh5KeAyYdOyxaCWDPbiUsJW7Oy4v_7uFqf06rIwGxaWc6nQuNVqZ2Q_Qej&s=10"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/jtv.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 110), TuplesKt.to("title", "JIOLIVE IND"), TuplesKt.to("image", "https://lens-storage.storage.googleapis.com/png/bb364a303da24e5db23f01bac26949cf"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/jc_live/refs/heads/main/jevents_live.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 111), TuplesKt.to("title", "ISLAMIC TV"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTcTOpdBeIBA52NTSANHC6Ow0v-k6hAr76vWg&usqp=CAU"), TuplesKt.to("catLink", "null")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 114), TuplesKt.to("title", "TAPMAD PK"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4X-7suwtvYWwoa6m0ngFTKZt5Hg5Z2kQF1g&usqp=CAU"), TuplesKt.to("catLink", "https://tv.noobon.top/playlist/tapmad.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 117), TuplesKt.to("title", "ZEE5 IN"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQS0OT2NFe9Jb4ofg_DrXx42EKLgyGnSGwoLg&usqp=CAU"), TuplesKt.to("catLink", "https://ranapk.short.gy/Z5in.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 126), TuplesKt.to("title", "WORLD TV"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSg8OiEwOT5UL5UttBZ5Tnhgsod8i2EQlfB97FFchdBOo8e_PfxvR8RJ68&s=10"), TuplesKt.to("catLink", "https://ranapk.short.gy/WorldTV11.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 129), TuplesKt.to("title", "AYNA"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvAant65yQ_au1e51MFs-uiE6juswXv4ZJoNCpzBBSg4q7DzJ1NeliS80c&s=10"), TuplesKt.to("catLink", "https://playlist-cricfy.noobon.top/aynaott.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 130), TuplesKt.to("title", "JIO CINEMA IND"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQc3qZ1WgzPyFRX4cWIBJF0MSjWW3gZcLFycg&usqp=CAU"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/jcinema.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 131), TuplesKt.to("title", "DISH TV"), TuplesKt.to("image", "https://m.media-amazon.com/images/S/stores-image-uploads-eu-prod/1/AmazonStores/A21TJRUUN4KGV/d5086253b614724be106c06be13f7d54.w600.h600._RO299,1,0,0,0,0,0,0,0,0,15_FMpng_.jpg"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/dishtv.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 132), TuplesKt.to("title", "SHOOQ PK"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvSWLnpgyvbzV9rHkREzbsX1Rzh2IbEZBL8yPpSv8aCPmy1nVcv7BhIWQ&s=10"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/shoq.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 133), TuplesKt.to("title", "SAMSUNG TV"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQI9T5vcm8wU-dLuaK5vBfoHpz8KL9Ru0aU1eoVaKNcqauxGtRTfvI1rGTA&s=10"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/samsungtv.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 134), TuplesKt.to("title", "JAGOBD"), TuplesKt.to("image", "https://www.jagobd.com/wp-content/uploads/2015/10/web_hi_res_512.png"), TuplesKt.to("catLink", "https://tv.noobon.top/playlist/jagobd.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 135), TuplesKt.to("title", "JADOO"), TuplesKt.to("image", "https://bdix.net/wp-content/uploads/2019/07/Jadoo-Digital-Logo-PNG-1002x1024.png"), TuplesKt.to("catLink", "https://fifabangladesh.site/PLAYLIST/jadoo.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 136), TuplesKt.to("title", "PISHOW"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1hOo397X8uamgdXoknED8klICRLPCqwuEUtB394H2cc7YIyYiD78s-B8&s=10"), TuplesKt.to("catLink", "http://playlist-storage.pages.dev/PLAYLIST/playboxtv.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 146), TuplesKt.to("title", "CRICHD"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ08h1gOe7MPxwehZBrbYKAUtjv22B6rAJ1kMkN-cea64Ka49KUyGU2lpTz&s=10"), TuplesKt.to("catLink", "https://github.com/abusaeeidx/CricHd-playlists-Auto-Update-permanent/raw/main/ALL.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 150), TuplesKt.to("title", "ZAP SPORTS"), TuplesKt.to("image", "https://i.ibb.co/dJfysm3V/zap-Sports.png"), TuplesKt.to("catLink", "https://tv.noobon.top/zapx/api.php?action=getIPTVPlaylist")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 151), TuplesKt.to("title", "Pirates TV"), TuplesKt.to("image", "https://raw.githubusercontent.com/FunctionError/Logos/main/Pirates-Tv.png"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/FunctionError/PiratesTv/refs/heads/main/combined_playlist.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 152), TuplesKt.to("title", "YUPPTV"), TuplesKt.to("image", "https://d229kpbsb5jevy.cloudfront.net/bott/v2/networks/circularimages/yupptv.png"), TuplesKt.to("catLink", "https://tv.noobon.top/playlist/yapp.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 153), TuplesKt.to("title", "DANGAL TV"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTMnDuHwjd3WEFHmObqo53bAjkIB6E7JvIIPjGGGxqZzbNsKT85D_sRYNc&s=10"), TuplesKt.to("catLink", "https://playlist-storage.pages.dev/PLAYLIST/DangalPlay.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 157), TuplesKt.to("title", "Movies & Series"), TuplesKt.to("image", "https://i.postimg.cc/QCVVj6D1/Movies.png"), TuplesKt.to("catLink", "http://tv.noobon.top/playlist/movies.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 158), TuplesKt.to("title", "DEKHO 24 X 7"), TuplesKt.to("image", "https://tstatic.videoready.tv/cms-ui/images/custom-content/1739684250358.png"), TuplesKt.to("catLink", "https://dehkho24h.alpha-circuit.workers.dev/?token=1b8j9b-796c8a-36e17f-8f83a5")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 159), TuplesKt.to("title", "JIOTV+ S2"), TuplesKt.to("image", "https://i.ibb.co/VY9ND7rY/image.png"), TuplesKt.to("catLink", "https://jiotvplus.byte-vault.workers.dev/?token=42e4f5-2d863b-3c38d8-7f3f51")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 163), TuplesKt.to("title", "JIOHOTSTAR"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPuz9ekmjh3vEpEc3lYL4nh6Gj7y2CQTswVG-ZCHnIS1foScuwPzuyxic&s=10"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/jstar.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 164), TuplesKt.to("title", "JIOTV+ S3"), TuplesKt.to("image", "https://i.ibb.co/VY9ND7rY/image.png"), TuplesKt.to("catLink", "https://jiotv.edge-nexus.workers.dev/?token=42e4f5-2d863b-3c37d8-8f3f51")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 165), TuplesKt.to("title", "ICC TV"), TuplesKt.to("image", "https://m.media-amazon.com/images/I/31F7ropt9OL.png"), TuplesKt.to("catLink", "https://icc.alpha-circuit.workers.dev/?token=42e4f5-2d863b-3c37d8-7f3f69")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 166), TuplesKt.to("title", "Pluto Tv"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRI_jYjppElN7Tb6Ok3bL_J0K7QQPzfQbzPeAWzVilH9y7CYKzAy-XJbi4&s=10"), TuplesKt.to("catLink", "https://tv.noobon.top/playlist/plutotv.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 167), TuplesKt.to("title", "Movies"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZsNCiIfBGnyhPuE6n-t37ma_baSTkX_trJ45qtXvwLhxsdVWzNW0dt8u7&s=10"), TuplesKt.to("catLink", "ok")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 168), TuplesKt.to("title", "FANCODE BD"), TuplesKt.to("image", "https://play-lh.googleusercontent.com/lp1Tdhp75MQyrHqrsyRBV74HxoL3Ko8KRAjOUI1wUHREAxuuVwKR6vnamgvMEn4C4Q"), TuplesKt.to("catLink", "https://ranapk.short.gy/FCBD/playlist.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 169), TuplesKt.to("title", "EPL BD IP"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQye0cNsXab_lPM3Zv2pklCk2ZT92X3micxy7jF2n5F46-kaSgnIBjHq3KY&s=10"), TuplesKt.to("catLink", "https://bdix.short.gy/EPLxBDIX/playlist.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 170), TuplesKt.to("title", "JIO BD"), TuplesKt.to("image", "https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/jio-logo-icon.png"), TuplesKt.to("catLink", "https://ranapk.short.gy/JIOBD.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 173), TuplesKt.to("title", "World Sports"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7iSlqAmYv4wa-7P9aRqiLVniqbUQUtVNmgsf4BxJJqpRKNJVhlVHvFKI&s=10"), TuplesKt.to("catLink", "https://tv.xmasterbd.sbs/dhd/playlist.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 174), TuplesKt.to("title", "Prime Channel"), TuplesKt.to("image", "https://static.vecteezy.com/system/resources/previews/046/437/251/non_2x/amazon-prime-logo-free-png.png"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/amzusa.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 175), TuplesKt.to("title", "RUN TV"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7zqXTonSH_Xo--YxMlOacinf7mhLwuwSFFF1KJa8lGw&s=10"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/runn.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 176), TuplesKt.to("title", "WAVES OTT"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNyx_lxD3xXIB8jpFGnMnHZIziUo1vKW9sSS-7zP-h0vhZT4cPB6wly6o&s=10"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/waves.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 177), TuplesKt.to("title", "JIO IND2"), TuplesKt.to("image", "https://uxwing.com/wp-content/themes/uxwing/download/brands-and-social-media/jio-logo-icon.png"), TuplesKt.to("catLink", "https://playlist-cricfy.noobon.top/noob/jiotv.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 178), TuplesKt.to("title", "JIOTV+ S4"), TuplesKt.to("image", "https://i.ibb.co/VY9ND7rY/image.png"), TuplesKt.to("catLink", "https://jiotvplus.iron-shield.workers.dev/?token=42e4f5-2d963b-3c37d8-7f3f52")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 179), TuplesKt.to("title", "LGTV IND"), TuplesKt.to("image", "https://raw.githubusercontent.com/alex8875/img/refs/heads/main/LG_tv.png"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/lgtv.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 180), TuplesKt.to("title", "TOFFEE BD"), TuplesKt.to("image", "https://yt3.googleusercontent.com/q0CJuxOL2f7Duy3hiM3uKArC_Zvji24XVGNfcf2TMqXMxTW6RO3R3tqwH2XAxbcz5TG-d2p6=s900-c-k-c0x00ffffff-no-rj"), TuplesKt.to("catLink", "https://playlist-cricfy.noobon.top/toffee.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 181), TuplesKt.to("title", "ZEE5 IN 2"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQS0OT2NFe9Jb4ofg_DrXx42EKLgyGnSGwoLg&usqp=CAU"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/alex8875/m3u/refs/heads/main/z5.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 182), TuplesKt.to("title", "SONY BD"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxsCm4WKugE7ubLr2J3AP7s-hqHl0dh69ImA&usqp=CAU"), TuplesKt.to("catLink", "https://ranapk.short.gy/sonybd/playlist.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 183), TuplesKt.to("title", "AYNA 2"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvAant65yQ_au1e51MFs-uiE6juswXv4ZJoNCpzBBSg4q7DzJ1NeliS80c&s=10"), TuplesKt.to("catLink", "https://bdix2.short.gy/AYNA/playlist.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 184), TuplesKt.to("title", "DARK TV"), TuplesKt.to("image", "https://i.ibb.co/CsQCkNnb/Screenshot-2025-11-04-06-03-45-53.jpg"), TuplesKt.to("catLink", "https://ranapk.short.gy/Darktv/playlist.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 185), TuplesKt.to("title", "AKASH"), TuplesKt.to("image", "https://image.winudf.com/v2/image1/Y29tLmFrYXNoLmdvX2ljb25fMTcyMjU3ODg2N18wNTA/icon.png?w=184&fakeurl=1"), TuplesKt.to("catLink", "https://playlist-cricfy.noobon.top/akashgo.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 186), TuplesKt.to("title", "FREE TV"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTS4HoWswvKYjnMyenamwz-xBJq0PLSyZYpo0kp3oN6gw&s=10"), TuplesKt.to("catLink", "https://playlist-storage.pages.dev/PLAYLIST/freetv.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 187), TuplesKt.to("title", "FANCODE BD 2"), TuplesKt.to("image", "https://play-lh.googleusercontent.com/lp1Tdhp75MQyrHqrsyRBV74HxoL3Ko8KRAjOUI1wUHREAxuuVwKR6vnamgvMEn4C4Q"), TuplesKt.to("catLink", "https://ranapk.short.gy/FcOnlyBD/playlist.php")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 188), TuplesKt.to("title", "DISH HOME BD"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfc5DoDgZ5r5s1_umhMp0UUBENdkOUdWWFcSAzv-EUxA&s"), TuplesKt.to("catLink", "https://dish.data-vortex.workers.dev?token=42e4f5-2d863b-3c37d8-7f3f51")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 189), TuplesKt.to("title", "ZEE5 LIVE"), TuplesKt.to("image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQS0OT2NFe9Jb4ofg_DrXx42EKLgyGnSGwoLg&usqp=CAU"), TuplesKt.to("catLink", "https://raw.githubusercontent.com/doctor-8trange/quarnex/refs/heads/main/data/zee5.m3u")}), MapsKt.mapOf(new Pair[]{TuplesKt.to("id", 190), TuplesKt.to("title", "FREE SPORTS"), TuplesKt.to("image", "https://media.unreel.me/prod/freelivesports/general/6496be67-a318-46c6-a25d-93c161f86845"), TuplesKt.to("catLink", "https://playlist-storage.pages.dev/PLAYLIST/freelivesports.m3u")})});

    /* JADX INFO: renamed from: com.cncverse.ProviderManager$getBaseUrl$1 */
    /* JADX INFO: compiled from: ProviderManager.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.ProviderManager", f = "ProviderManager.kt", i = {}, l = {149}, m = "getBaseUrl", n = {}, nl = {150}, s = {}, v = 2)
    static final class C00331 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00331(Continuation<? super C00331> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProviderManager.this.getBaseUrl((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.ProviderManager$getLiveEventsUrl$1 */
    /* JADX INFO: compiled from: ProviderManager.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.ProviderManager", f = "ProviderManager.kt", i = {}, l = {173}, m = "getLiveEventsUrl", n = {}, nl = {174}, s = {}, v = 2)
    static final class C00341 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00341(Continuation<? super C00341> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProviderManager.this.getLiveEventsUrl((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.cncverse.ProviderManager$getProvidersUrl$1 */
    /* JADX INFO: compiled from: ProviderManager.kt */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.ProviderManager", f = "ProviderManager.kt", i = {}, l = {165}, m = "getProvidersUrl", n = {}, nl = {166}, s = {}, v = 2)
    static final class C00351 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C00351(Continuation<? super C00351> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProviderManager.this.getProvidersUrl((Continuation) this);
        }
    }

    private ProviderManager() {
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public final Object getBaseUrl(@NotNull Continuation<? super String> continuation) {
        C00331 c00331;
        Object providerApiUrl;
        if (continuation instanceof C00331) {
            c00331 = (C00331) continuation;
            if ((c00331.label & Integer.MIN_VALUE) != 0) {
                c00331.label -= Integer.MIN_VALUE;
            } else {
                c00331 = new C00331(continuation);
            }
        } else {
            c00331 = new C00331(continuation);
        }
        Object $result = c00331.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00331.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String it = cachedBaseUrl;
                if (it != null) {
                    return it;
                }
                FirebaseRemoteConfigFetcher firebaseRemoteConfigFetcher = FirebaseRemoteConfigFetcher.INSTANCE;
                c00331.label = 1;
                providerApiUrl = firebaseRemoteConfigFetcher.getProviderApiUrl(c00331);
                if (providerApiUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                providerApiUrl = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String firebaseUrl = (String) providerApiUrl;
        String str = firebaseUrl;
        if (!(str == null || StringsKt.isBlank(str))) {
            cachedBaseUrl = StringsKt.trimEnd(firebaseUrl, new char[]{'/'});
            String str2 = cachedBaseUrl;
            Intrinsics.checkNotNull(str2);
            return str2;
        }
        cachedBaseUrl = DEFAULT_BASE_URL;
        return DEFAULT_BASE_URL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getProvidersUrl(Continuation<? super String> continuation) {
        C00351 c00351;
        Object baseUrl;
        if (continuation instanceof C00351) {
            c00351 = (C00351) continuation;
            if ((c00351.label & Integer.MIN_VALUE) != 0) {
                c00351.label -= Integer.MIN_VALUE;
            } else {
                c00351 = new C00351(continuation);
            }
        } else {
            c00351 = new C00351(continuation);
        }
        Object $result = c00351.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00351.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00351.label = 1;
                baseUrl = getBaseUrl(c00351);
                if (baseUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                baseUrl = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String baseUrl2 = (String) baseUrl;
        return baseUrl2 + "/cats.txt";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getLiveEventsUrl(Continuation<? super String> continuation) {
        C00341 c00341;
        Object baseUrl;
        if (continuation instanceof C00341) {
            c00341 = (C00341) continuation;
            if ((c00341.label & Integer.MIN_VALUE) != 0) {
                c00341.label -= Integer.MIN_VALUE;
            } else {
                c00341 = new C00341(continuation);
            }
        } else {
            c00341 = new C00341(continuation);
        }
        Object $result = c00341.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00341.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                c00341.label = 1;
                baseUrl = getBaseUrl(c00341);
                if (baseUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                baseUrl = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String baseUrl2 = (String) baseUrl;
        return baseUrl2 + "/categories/live-events.txt";
    }

    /* JADX INFO: renamed from: com.cncverse.ProviderManager$fetchProviders$2 */
    /* JADX INFO: compiled from: ProviderManager.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.ProviderManager$fetchProviders$2", f = "ProviderManager.kt", i = {}, l = {181}, m = "invokeSuspend", n = {}, nl = {183}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProviderManager.kt\ncom/cncverse/ProviderManager$fetchProviders$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,318:1\n63#2:319\n64#2,15:321\n1#3:320\n50#4:336\n43#4:337\n777#5:338\n873#5,2:339\n1586#5:341\n1661#5,3:342\n*S KotlinDebug\n*F\n+ 1 ProviderManager.kt\ncom/cncverse/ProviderManager$fetchProviders$2\n*L\n194#1:319\n194#1:321,15\n194#1:320\n194#1:336\n194#1:337\n196#1:338\n196#1:339,2\n197#1:341\n197#1:342,3\n*E\n"})
    static final class C00312 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Map<String, ? extends Object>>>, Object> {
        int label;

        C00312(Continuation<? super C00312> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00312(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Map<String, ? extends Object>>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object providersUrl;
            Object obj;
            char c;
            Object objDecodeFromString;
            char c2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        providersUrl = ProviderManager.INSTANCE.getProvidersUrl((Continuation) this);
                        if (providersUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        providersUrl = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String providersUrl2 = (String) providersUrl;
                Request request = new Request.Builder().url(providersUrl2).header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36").build();
                Response response = ProviderManager.client.newCall(request).execute();
                if (response.isSuccessful()) {
                    String encryptedData = response.body().string();
                    String str = encryptedData;
                    if (!(str == null || StringsKt.isBlank(str))) {
                        String decryptedData = CryptoUtils.INSTANCE.decryptData(StringsKt.trim(encryptedData).toString());
                        String str2 = decryptedData;
                        if (!(str2 == null || StringsKt.isBlank(str2))) {
                            AppUtils appUtils = AppUtils.INSTANCE;
                            try {
                                Result.Companion companion = Result.Companion;
                                KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(ProviderData.class)));
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            Object obj2 = null;
                            if (Result.exceptionOrNull-impl(obj) == null) {
                                c = 1;
                            } else {
                                try {
                                    Result.Companion companion3 = Result.Companion;
                                    c = 1;
                                    try {
                                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                                    } catch (Throwable th2) {
                                        th = th2;
                                        Result.Companion companion4 = Result.Companion;
                                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    c = 1;
                                }
                            }
                            if (!Result.isFailure-impl(obj)) {
                                obj2 = obj;
                            }
                            DeserializationStrategy deserializationStrategy = (KSerializer) obj2;
                            if (deserializationStrategy != null) {
                                try {
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, decryptedData);
                                    c2 = 0;
                                } catch (SerializationException e) {
                                    ArchComponentExtKt.logError(e);
                                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                    c2 = 0;
                                    objDecodeFromString = $this$readValue$iv$iv.readValue(decryptedData, new TypeReference<List<? extends ProviderData>>() { // from class: com.cncverse.ProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                                    });
                                } catch (Throwable th4) {
                                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                    c2 = 0;
                                    objDecodeFromString = $this$readValue$iv$iv2.readValue(decryptedData, new TypeReference<List<? extends ProviderData>>() { // from class: com.cncverse.ProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                                    });
                                }
                            } else {
                                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                c2 = 0;
                                objDecodeFromString = $this$readValue$iv$iv3.readValue(decryptedData, new TypeReference<List<? extends ProviderData>>() { // from class: com.cncverse.ProviderManager$fetchProviders$2$invokeSuspend$$inlined$parseJson$1
                                });
                            }
                            List providers = (List) objDecodeFromString;
                            List $this$filter$iv = providers;
                            Collection destination$iv$iv = new ArrayList();
                            for (Object element$iv$iv : $this$filter$iv) {
                                ProviderData it = (ProviderData) element$iv$iv;
                                String catLink = it.getCatLink();
                                if (!(catLink == null || StringsKt.isBlank(catLink))) {
                                    destination$iv$iv.add(element$iv$iv);
                                }
                            }
                            Iterable $this$map$iv = (List) destination$iv$iv;
                            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                ProviderData provider = (ProviderData) item$iv$iv;
                                Pair[] pairArr = new Pair[5];
                                List providers2 = providers;
                                pairArr[c2] = TuplesKt.to("id", Boxing.boxInt(provider.getId()));
                                pairArr[c] = TuplesKt.to("title", provider.getTitle());
                                pairArr[2] = TuplesKt.to("image", provider.getImage());
                                String catLink2 = provider.getCatLink();
                                Intrinsics.checkNotNull(catLink2);
                                pairArr[3] = TuplesKt.to("catLink", catLink2);
                                String type = provider.getType();
                                if (type == null) {
                                    type = "custom";
                                }
                                pairArr[4] = TuplesKt.to("type", type);
                                destination$iv$iv2.add(MapsKt.mapOf(pairArr));
                                providers = providers2;
                            }
                            return (List) destination$iv$iv2;
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return ProviderManager.fallbackProviders;
        }
    }

    @Nullable
    public final Object fetchProviders(@NotNull Continuation<? super List<? extends Map<String, ? extends Object>>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00312(null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.ProviderManager$fetchLiveEvents$2 */
    /* JADX INFO: compiled from: ProviderManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/cncverse/LiveEventData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.ProviderManager$fetchLiveEvents$2", f = "ProviderManager.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, nl = {229}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProviderManager.kt\ncom/cncverse/ProviderManager$fetchLiveEvents$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,318:1\n63#2:319\n64#2,15:321\n1#3:320\n50#4:336\n43#4:337\n777#5:338\n873#5,2:339\n*S KotlinDebug\n*F\n+ 1 ProviderManager.kt\ncom/cncverse/ProviderManager$fetchLiveEvents$2\n*L\n240#1:319\n240#1:321,15\n240#1:320\n240#1:336\n240#1:337\n242#1:338\n242#1:339,2\n*E\n"})
    static final class C00292 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends LiveEventData>>, Object> {
        int label;

        C00292(Continuation<? super C00292> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00292(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<LiveEventData>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object liveEventsUrl;
            Object obj;
            Object objDecodeFromString;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.label = 1;
                        liveEventsUrl = ProviderManager.INSTANCE.getLiveEventsUrl((Continuation) this);
                        if (liveEventsUrl == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        liveEventsUrl = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String liveEventsUrl2 = (String) liveEventsUrl;
                Request request = new Request.Builder().url(liveEventsUrl2).header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36").build();
                Response response = ProviderManager.client.newCall(request).execute();
                if (response.isSuccessful()) {
                    String encryptedData = response.body().string();
                    String str = encryptedData;
                    if (!(str == null || StringsKt.isBlank(str))) {
                        String decryptedData = CryptoUtils.INSTANCE.decryptData(StringsKt.trim(encryptedData).toString());
                        String str2 = decryptedData;
                        if (!(str2 == null || StringsKt.isBlank(str2))) {
                            AppUtils appUtils = AppUtils.INSTANCE;
                            try {
                                Result.Companion companion = Result.Companion;
                                KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(LiveEventData.class)));
                                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            Object obj2 = null;
                            if (Result.exceptionOrNull-impl(obj) != null) {
                                try {
                                    Result.Companion companion3 = Result.Companion;
                                    obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                                } catch (Throwable th2) {
                                    Result.Companion companion4 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th2));
                                }
                            }
                            if (!Result.isFailure-impl(obj)) {
                                obj2 = obj;
                            }
                            DeserializationStrategy deserializationStrategy = (KSerializer) obj2;
                            if (deserializationStrategy != null) {
                                try {
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, decryptedData);
                                } catch (SerializationException e) {
                                    ArchComponentExtKt.logError(e);
                                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv.readValue(decryptedData, new TypeReference<List<? extends LiveEventData>>() { // from class: com.cncverse.ProviderManager$fetchLiveEvents$2$invokeSuspend$$inlined$parseJson$1
                                    });
                                } catch (Throwable th3) {
                                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv2.readValue(decryptedData, new TypeReference<List<? extends LiveEventData>>() { // from class: com.cncverse.ProviderManager$fetchLiveEvents$2$invokeSuspend$$inlined$parseJson$1
                                    });
                                }
                            } else {
                                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv3.readValue(decryptedData, new TypeReference<List<? extends LiveEventData>>() { // from class: com.cncverse.ProviderManager$fetchLiveEvents$2$invokeSuspend$$inlined$parseJson$1
                                });
                            }
                            Iterable events = (List) objDecodeFromString;
                            Iterable $this$filter$iv = events;
                            Collection destination$iv$iv = new ArrayList();
                            for (Object element$iv$iv : $this$filter$iv) {
                                LiveEventData it = (LiveEventData) element$iv$iv;
                                if (it.getPublish() == 1) {
                                    destination$iv$iv.add(element$iv$iv);
                                }
                            }
                            return (List) destination$iv$iv;
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return CollectionsKt.emptyList();
        }
    }

    @Nullable
    public final Object fetchLiveEvents(@NotNull Continuation<? super List<LiveEventData>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00292(null), continuation);
    }

    /* JADX INFO: renamed from: com.cncverse.ProviderManager$fetchCustomEvents$2 */
    /* JADX INFO: compiled from: ProviderManager.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/cncverse/LiveEventData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.cncverse.ProviderManager$fetchCustomEvents$2", f = "ProviderManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    @SourceDebugExtension({"SMAP\nProviderManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProviderManager.kt\ncom/cncverse/ProviderManager$fetchCustomEvents$2\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,318:1\n63#2:319\n64#2,15:321\n63#2:342\n64#2,15:344\n1#3:320\n1#3:343\n1#3:366\n50#4:336\n43#4:337\n50#4:359\n43#4:360\n1606#5:338\n1617#5:339\n1924#5,2:340\n1596#5:361\n1629#5,4:362\n1926#5:367\n1618#5:368\n777#5:369\n873#5,2:370\n*S KotlinDebug\n*F\n+ 1 ProviderManager.kt\ncom/cncverse/ProviderManager$fetchCustomEvents$2\n*L\n267#1:319\n267#1:321,15\n270#1:342\n270#1:344,15\n267#1:320\n270#1:343\n268#1:366\n267#1:336\n267#1:337\n270#1:359\n270#1:360\n268#1:338\n268#1:339\n268#1:340,2\n295#1:361\n295#1:362,4\n268#1:367\n268#1:368\n307#1:369\n307#1:370,2\n*E\n"})
    static final class C00262 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends LiveEventData>>, Object> {
        final /* synthetic */ String $catLink;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00262(String str, Continuation<? super C00262> continuation) {
            super(2, continuation);
            this.$catLink = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00262(this.$catLink, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<LiveEventData>> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:106:0x021e  */
        /* JADX WARN: Code duplicated, block: B:107:0x0221 A[Catch: Exception -> 0x0350, TryCatch #1 {Exception -> 0x0350, blocks: (B:83:0x01c3, B:87:0x01cc, B:104:0x020e, B:107:0x0221, B:109:0x0229, B:116:0x0238, B:119:0x0242, B:123:0x0252, B:130:0x0262, B:132:0x0291, B:134:0x02a9, B:135:0x02c2, B:137:0x02c8, B:139:0x02d0, B:140:0x02d3, B:142:0x02e7, B:147:0x02fb, B:148:0x0312, B:149:0x0325, B:151:0x033a, B:150:0x0332, B:103:0x01f4, B:101:0x01eb, B:82:0x01b9), top: B:178:0x01c3 }] */
        /* JADX WARN: Code duplicated, block: B:113:0x0232  */
        /* JADX WARN: Code duplicated, block: B:115:0x0235  */
        /* JADX WARN: Code duplicated, block: B:116:0x0238 A[Catch: Exception -> 0x0350, TryCatch #1 {Exception -> 0x0350, blocks: (B:83:0x01c3, B:87:0x01cc, B:104:0x020e, B:107:0x0221, B:109:0x0229, B:116:0x0238, B:119:0x0242, B:123:0x0252, B:130:0x0262, B:132:0x0291, B:134:0x02a9, B:135:0x02c2, B:137:0x02c8, B:139:0x02d0, B:140:0x02d3, B:142:0x02e7, B:147:0x02fb, B:148:0x0312, B:149:0x0325, B:151:0x033a, B:150:0x0332, B:103:0x01f4, B:101:0x01eb, B:82:0x01b9), top: B:178:0x01c3 }] */
        /* JADX WARN: Code duplicated, block: B:118:0x0240  */
        /* JADX WARN: Code duplicated, block: B:150:0x0332 A[Catch: Exception -> 0x0350, TryCatch #1 {Exception -> 0x0350, blocks: (B:83:0x01c3, B:87:0x01cc, B:104:0x020e, B:107:0x0221, B:109:0x0229, B:116:0x0238, B:119:0x0242, B:123:0x0252, B:130:0x0262, B:132:0x0291, B:134:0x02a9, B:135:0x02c2, B:137:0x02c8, B:139:0x02d0, B:140:0x02d3, B:142:0x02e7, B:147:0x02fb, B:148:0x0312, B:149:0x0325, B:151:0x033a, B:150:0x0332, B:103:0x01f4, B:101:0x01eb, B:82:0x01b9), top: B:178:0x01c3 }] */
        /* JADX WARN: Code duplicated, block: B:160:0x035c A[Catch: Exception -> 0x03ab, TryCatch #5 {Exception -> 0x03ab, blocks: (B:7:0x0018, B:9:0x0043, B:11:0x0051, B:17:0x005d, B:19:0x0074, B:25:0x0080, B:31:0x00b2, B:44:0x00e8, B:47:0x00ef, B:57:0x0122, B:58:0x013c, B:60:0x0142, B:62:0x014a, B:63:0x014d, B:160:0x035c, B:157:0x0355, B:162:0x036a, B:163:0x0382, B:165:0x0388, B:170:0x039e, B:172:0x03a4, B:56:0x010a, B:55:0x0104, B:43:0x00de, B:30:0x00a8, B:27:0x0085, B:50:0x00f5), top: B:182:0x0018, inners: #6, #14 }] */
        /* JADX WARN: Code duplicated, block: B:204:0x0360 A[SYNTHETIC] */
        /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
        public final Object invokeSuspend(Object $result) {
            Object obj;
            boolean z;
            Object objDecodeFromString;
            String str;
            LiveEventData liveEventData;
            Object obj2;
            String value$iv;
            Object objDecodeFromString2;
            CricifyChannelData channelData;
            String links;
            boolean z2;
            String name;
            String links2;
            String links3;
            List listEmptyList;
            Iterable iterableSplit$default;
            int $i$f$mapIndexed;
            int $i$f$mapIndexed2;
            String str2;
            String str3 = "kotlinx.serialization.serializer.simple";
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        Request request = new Request.Builder().url(this.$catLink).header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36").build();
                        Response response = ProviderManager.client.newCall(request).execute();
                        if (response.isSuccessful()) {
                            String encryptedData = response.body().string();
                            String str4 = encryptedData;
                            if (!(str4 == null || StringsKt.isBlank(str4))) {
                                String decryptedData = CryptoUtils.INSTANCE.decryptData(StringsKt.trim(encryptedData).toString());
                                String str5 = decryptedData;
                                if (!(str5 == null || StringsKt.isBlank(str5))) {
                                    AppUtils appUtils = AppUtils.INSTANCE;
                                    try {
                                        Result.Companion companion = Result.Companion;
                                        KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(CricifyChannelWrapper.class)));
                                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                        obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                        break;
                                    } catch (Throwable th) {
                                        Result.Companion companion2 = Result.Companion;
                                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                                    }
                                    if (Result.exceptionOrNull-impl(obj) != null) {
                                        try {
                                            Result.Companion companion3 = Result.Companion;
                                            z = false;
                                            try {
                                                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                                            } catch (Throwable th2) {
                                                th = th2;
                                                Result.Companion companion4 = Result.Companion;
                                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            z = false;
                                        }
                                        break;
                                    } else {
                                        z = false;
                                    }
                                    if (Result.isFailure-impl(obj)) {
                                        obj = null;
                                    }
                                    DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                                    if (deserializationStrategy != null) {
                                        try {
                                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, decryptedData);
                                        } catch (SerializationException e) {
                                            ArchComponentExtKt.logError(e);
                                            ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                            objDecodeFromString = $this$readValue$iv$iv.readValue(decryptedData, new TypeReference<List<? extends CricifyChannelWrapper>>() { // from class: com.cncverse.ProviderManager$fetchCustomEvents$2$invokeSuspend$$inlined$parseJson$1
                                            });
                                        } catch (Throwable th4) {
                                            ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                            objDecodeFromString = $this$readValue$iv$iv2.readValue(decryptedData, new TypeReference<List<? extends CricifyChannelWrapper>>() { // from class: com.cncverse.ProviderManager$fetchCustomEvents$2$invokeSuspend$$inlined$parseJson$1
                                            });
                                        }
                                        break;
                                    } else {
                                        ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv3.readValue(decryptedData, new TypeReference<List<? extends CricifyChannelWrapper>>() { // from class: com.cncverse.ProviderManager$fetchCustomEvents$2$invokeSuspend$$inlined$parseJson$1
                                        });
                                    }
                                    Iterable wrappers = (List) objDecodeFromString;
                                    Iterable $this$mapIndexedNotNull$iv = wrappers;
                                    Collection destination$iv$iv = new ArrayList();
                                    int index$iv$iv$iv = 0;
                                    for (Object item$iv$iv$iv : $this$mapIndexedNotNull$iv) {
                                        int index$iv$iv$iv2 = index$iv$iv$iv + 1;
                                        if (index$iv$iv$iv < 0) {
                                            CollectionsKt.throwIndexOverflow();
                                        }
                                        int index$iv$iv = index$iv$iv$iv;
                                        CricifyChannelWrapper wrapper = (CricifyChannelWrapper) item$iv$iv$iv;
                                        try {
                                            AppUtils appUtils2 = AppUtils.INSTANCE;
                                            String value$iv2 = wrapper.getChannel();
                                            try {
                                                Result.Companion companion5 = Result.Companion;
                                                KType kTypeTypeOf2 = Reflection.typeOf(CricifyChannelData.class);
                                                MagicApiIntrinsics.voidMagicApiCall(str3);
                                                obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                                            } catch (Throwable th5) {
                                                Result.Companion companion6 = Result.Companion;
                                                obj2 = Result.constructor-impl(ResultKt.createFailure(th5));
                                            }
                                            if (Result.exceptionOrNull-impl(obj2) == null) {
                                                str = str3;
                                            } else {
                                                try {
                                                    Result.Companion companion7 = Result.Companion;
                                                    str = str3;
                                                    try {
                                                        obj2 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(CricifyChannelData.class), (List) null, 2, (Object) null));
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                        Result.Companion companion8 = Result.Companion;
                                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                                    }
                                                } catch (Throwable th7) {
                                                    th = th7;
                                                    str = str3;
                                                }
                                            }
                                            try {
                                                DeserializationStrategy deserializationStrategy2 = (KSerializer) (Result.isFailure-impl(obj2) ? null : obj2);
                                                if (deserializationStrategy2 != null) {
                                                    try {
                                                        value$iv = value$iv2;
                                                        try {
                                                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, value$iv);
                                                        } catch (SerializationException e2) {
                                                            e$iv = e2;
                                                            ArchComponentExtKt.logError((Throwable) e$iv);
                                                            ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                                                            String content$iv$iv = value$iv;
                                                            objDecodeFromString2 = $this$readValue$iv$iv4.readValue(content$iv$iv, new TypeReference<CricifyChannelData>() { // from class: com.cncverse.ProviderManager$fetchCustomEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                                            });
                                                        } catch (Throwable th8) {
                                                            ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                                                            String content$iv$iv2 = value$iv;
                                                            objDecodeFromString2 = $this$readValue$iv$iv5.readValue(content$iv$iv2, new TypeReference<CricifyChannelData>() { // from class: com.cncverse.ProviderManager$fetchCustomEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                                            });
                                                        }
                                                    } catch (SerializationException e3) {
                                                        e$iv = e3;
                                                        value$iv = value$iv2;
                                                    } catch (Throwable th9) {
                                                        value$iv = value$iv2;
                                                    }
                                                    channelData = (CricifyChannelData) objDecodeFromString2;
                                                    if (Intrinsics.areEqual(channelData.getVisible(), Boxing.boxBoolean(z))) {
                                                        liveEventData = null;
                                                    } else {
                                                        links = channelData.getLinks();
                                                        if (links != null || StringsKt.isBlank(links)) {
                                                            z2 = true;
                                                        } else {
                                                            z2 = false;
                                                        }
                                                        if (z2) {
                                                            liveEventData = null;
                                                        } else {
                                                            int i = index$iv$iv + 1;
                                                            name = channelData.getName();
                                                            if (name == null) {
                                                                name = "Unknown Channel";
                                                            }
                                                            String str6 = name;
                                                            String logo = channelData.getLogo();
                                                            links2 = channelData.getLinks();
                                                            if (links2 != null || (strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(links2, ".", (String) null, 2, (Object) null)) == null) {
                                                                String strSubstringBeforeLast$default = "";
                                                            }
                                                            String str7 = strSubstringBeforeLast$default;
                                                            LiveEventInfo liveEventInfo = new LiveEventInfo(null, null, null, null, null, channelData.getName(), channelData.getLogo(), "0", null, null, null);
                                                            links3 = channelData.getLinks();
                                                            if (links3 != null || (iterableSplit$default = StringsKt.split$default(links3, new String[]{", "}, false, 0, 6, (Object) null)) == null) {
                                                                listEmptyList = CollectionsKt.emptyList();
                                                            } else {
                                                                Iterable $this$mapIndexed$iv = iterableSplit$default;
                                                                int $i$f$mapIndexed3 = 0;
                                                                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                                                                int index$iv$iv2 = 0;
                                                                for (Object item$iv$iv : $this$mapIndexed$iv) {
                                                                    int index$iv$iv3 = index$iv$iv2 + 1;
                                                                    if (index$iv$iv2 < 0) {
                                                                        CollectionsKt.throwIndexOverflow();
                                                                    }
                                                                    String link = (String) item$iv$iv;
                                                                    CricifyChannelData channelData2 = channelData;
                                                                    Iterable $this$mapIndexed$iv2 = $this$mapIndexed$iv;
                                                                    List<String> link_names = channelData2.getLink_names();
                                                                    if (link_names != null) {
                                                                        $i$f$mapIndexed = $i$f$mapIndexed3;
                                                                        $i$f$mapIndexed2 = index$iv$iv2;
                                                                        str2 = (String) CollectionsKt.getOrNull(link_names, $i$f$mapIndexed2);
                                                                        if (str2 == null) {
                                                                        }
                                                                        destination$iv$iv2.add(new LiveEventFormat(str2, link));
                                                                        index$iv$iv2 = index$iv$iv3;
                                                                        $this$mapIndexed$iv = $this$mapIndexed$iv2;
                                                                        channelData = channelData2;
                                                                        $i$f$mapIndexed3 = $i$f$mapIndexed;
                                                                    } else {
                                                                        $i$f$mapIndexed = $i$f$mapIndexed3;
                                                                        $i$f$mapIndexed2 = index$iv$iv2;
                                                                    }
                                                                    int formatIndex = $i$f$mapIndexed2;
                                                                    str2 = "Link " + (formatIndex + 1);
                                                                    destination$iv$iv2.add(new LiveEventFormat(str2, link));
                                                                    index$iv$iv2 = index$iv$iv3;
                                                                    $this$mapIndexed$iv = $this$mapIndexed$iv2;
                                                                    channelData = channelData2;
                                                                    $i$f$mapIndexed3 = $i$f$mapIndexed;
                                                                }
                                                                listEmptyList = (List) destination$iv$iv2;
                                                            }
                                                            liveEventData = new LiveEventData(i, str6, logo, str7, "Custom", liveEventInfo, 1, listEmptyList);
                                                        }
                                                    }
                                                    if (liveEventData != null) {
                                                        destination$iv$iv.add(liveEventData);
                                                    }
                                                    index$iv$iv$iv = index$iv$iv$iv2;
                                                    str3 = str;
                                                } else {
                                                    value$iv = value$iv2;
                                                }
                                                ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                                                String content$iv$iv3 = value$iv;
                                                objDecodeFromString2 = $this$readValue$iv$iv6.readValue(content$iv$iv3, new TypeReference<CricifyChannelData>() { // from class: com.cncverse.ProviderManager$fetchCustomEvents$2$invokeSuspend$lambda$0$$inlined$parseJson$1
                                                });
                                                channelData = (CricifyChannelData) objDecodeFromString2;
                                                if (Intrinsics.areEqual(channelData.getVisible(), Boxing.boxBoolean(z))) {
                                                    liveEventData = null;
                                                } else {
                                                    links = channelData.getLinks();
                                                    if (links != null) {
                                                        z2 = true;
                                                    } else {
                                                        z2 = true;
                                                    }
                                                    if (z2) {
                                                        liveEventData = null;
                                                    } else {
                                                        int i2 = index$iv$iv + 1;
                                                        name = channelData.getName();
                                                        if (name == null) {
                                                            name = "Unknown Channel";
                                                        }
                                                        String str8 = name;
                                                        String logo2 = channelData.getLogo();
                                                        links2 = channelData.getLinks();
                                                        if (links2 != null) {
                                                        }
                                                        String strSubstringBeforeLast$default2 = "";
                                                        String str9 = strSubstringBeforeLast$default2;
                                                        LiveEventInfo liveEventInfo2 = new LiveEventInfo(null, null, null, null, null, channelData.getName(), channelData.getLogo(), "0", null, null, null);
                                                        links3 = channelData.getLinks();
                                                        if (links3 != null) {
                                                            listEmptyList = CollectionsKt.emptyList();
                                                        } else {
                                                            listEmptyList = CollectionsKt.emptyList();
                                                        }
                                                        liveEventData = new LiveEventData(i2, str8, logo2, str9, "Custom", liveEventInfo2, 1, listEmptyList);
                                                    }
                                                }
                                            } catch (Exception e4) {
                                                e = e4;
                                                e.printStackTrace();
                                                liveEventData = null;
                                            }
                                        } catch (Exception e5) {
                                            e = e5;
                                            str = str3;
                                            e.printStackTrace();
                                            liveEventData = null;
                                            if (liveEventData != null) {
                                                destination$iv$iv.add(liveEventData);
                                            }
                                            index$iv$iv$iv = index$iv$iv$iv2;
                                            str3 = str;
                                        }
                                        if (liveEventData != null) {
                                            destination$iv$iv.add(liveEventData);
                                        }
                                        index$iv$iv$iv = index$iv$iv$iv2;
                                        str3 = str;
                                        break;
                                    }
                                    Iterable events = (List) destination$iv$iv;
                                    Iterable $this$filter$iv = events;
                                    Collection destination$iv$iv3 = new ArrayList();
                                    for (Object element$iv$iv : $this$filter$iv) {
                                        LiveEventData it = (LiveEventData) element$iv$iv;
                                        Iterable $this$filter$iv2 = $this$filter$iv;
                                        if (it.getPublish() == 1) {
                                            destination$iv$iv3.add(element$iv$iv);
                                        }
                                        $this$filter$iv = $this$filter$iv2;
                                    }
                                    return (List) destination$iv$iv3;
                                }
                            }
                        }
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                    return CollectionsKt.emptyList();
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    @Nullable
    public final Object fetchCustomEvents(@NotNull String catLink, @NotNull Continuation<? super List<LiveEventData>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C00262(catLink, null), continuation);
    }
}
