package com.Aniworld;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.extractors.Vidmoly;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.plugins.CloudstreamPlugin;
import com.lagradost.cloudstream3.plugins.Plugin;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.M3u8Helper;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AniworldPlugin.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Aniworld/classes.dex */
@CloudstreamPlugin
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0007\b\t\n\u000b\f\r\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016Ê\u0001\u0002\b\u0010¨\u0006\u000f"}, d2 = {"Lcom/Aniworld/AniworldPlugin;", "Lcom/lagradost/cloudstream3/plugins/Plugin;", "<init>", "()V", "load", "", "context", "Landroid/content/Context;", "ByseSX", "DetailsRoot", "PlaybackRoot", "Playback", "DecryptKeys", "PlaybackDecrypt", "PlaybackDecryptSource", "Aniworld", "Lcom/lagradost/cloudstream3/plugins/CloudstreamPlugin;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class AniworldPlugin extends Plugin {
    public void load(@NotNull Context context) {
        final SharedPreferences sharedPref = context.getSharedPreferences("serienstream_token", 0);
        registerMainAPI(new Aniworld(sharedPref));
        registerMainAPI(new Serienstream(sharedPref));
        registerExtractorAPI((ExtractorApi) new Dooood());
        registerExtractorAPI((ExtractorApi) new Vidmoly());
        registerExtractorAPI(new FileMoon());
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        final AppCompatActivity activity = (AppCompatActivity) context;
        setOpenSettings(new Function1() { // from class: com.Aniworld.AniworldPlugin$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return AniworldPlugin.load$lambda$0(this.f$0, sharedPref, activity, (Context) obj);
            }
        });
    }

    static final Unit load$lambda$0(AniworldPlugin this$0, SharedPreferences $sharedPref, AppCompatActivity $activity, Context it) {
        SettingsFragment frag = new SettingsFragment(this$0, $sharedPref);
        frag.show($activity.getSupportFragmentManager(), "Frag");
        return Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: AniworldPlugin.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\n\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0019J$\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001b2\u0006\u0010\n\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0002JH\u0010!\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u00052\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\"0%2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\"0%H\u0096@¢\u0006\u0002\u0010)R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u000eX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006*"}, d2 = {"Lcom/Aniworld/AniworldPlugin$ByseSX;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "b64UrlDecode", "", "s", "getBaseUrl", "url", "getCodeFromUrl", "getDetails", "Lcom/Aniworld/AniworldPlugin$DetailsRoot;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPlayback", "Lkotlin/Pair;", "Lcom/Aniworld/AniworldPlugin$PlaybackRoot;", "buildAesKey", "playback", "Lcom/Aniworld/AniworldPlugin$Playback;", "decryptPlayback", "getUrl", "", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Aniworld"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nAniworldPlugin.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AniworldPlugin.kt\ncom/Aniworld/AniworldPlugin$ByseSX\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 4 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 6 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,198:1\n1#2:199\n1#2:213\n73#3,5:200\n73#3,5:205\n93#4,2:210\n63#4:212\n64#4,15:214\n95#4,2:231\n50#5:229\n43#5:230\n2068#6,2:233\n*S KotlinDebug\n*F\n+ 1 AniworldPlugin.kt\ncom/Aniworld/AniworldPlugin$ByseSX\n*L\n111#1:213\n62#1:200,5\n83#1:205,5\n111#1:210,2\n111#1:212\n111#1:214,15\n111#1:231,2\n111#1:229\n111#1:230\n137#1:233,2\n*E\n"})
    public static class ByseSX extends ExtractorApi {

        @NotNull
        private String name = "Byse";

        @NotNull
        private String mainUrl = "https://byse.sx";
        private final boolean requiresReferer = true;

        @Nullable
        public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
            return getUrl$suspendImpl(this, str, str2, function1, function2, continuation);
        }

        @NotNull
        public String getName() {
            return this.name;
        }

        public void setName(@NotNull String str) {
            this.name = str;
        }

        @NotNull
        public String getMainUrl() {
            return this.mainUrl;
        }

        public void setMainUrl(@NotNull String str) {
            this.mainUrl = str;
        }

        public boolean getRequiresReferer() {
            return this.requiresReferer;
        }

        private final byte[] b64UrlDecode(String s) {
            String fixed = StringsKt.replace$default(StringsKt.replace$default(s, '-', '+', false, 4, (Object) null), '_', '/', false, 4, (Object) null);
            int pad = (4 - (fixed.length() % 4)) % 4;
            return MainAPIKt.base64DecodeArray(fixed + StringsKt.repeat("=", pad));
        }

        private final String getBaseUrl(String url) {
            Url it = URLUtilsKt.Url(url);
            return it.getProtocol().getName() + "://" + it.getHost();
        }

        private final String getCodeFromUrl(String url) {
            String path = URLUtilsKt.Url(url).getEncodedPath();
            return StringsKt.substringAfterLast$default(StringsKt.trimEnd(path, new char[]{'/'}), '/', (String) null, 2, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:7:0x0018  */
        public final Object getDetails(String mainUrl, Continuation<? super DetailsRoot> continuation) {
            AniworldPlugin$ByseSX$getDetails$1 aniworldPlugin$ByseSX$getDetails$1;
            Object obj;
            if (continuation instanceof AniworldPlugin$ByseSX$getDetails$1) {
                aniworldPlugin$ByseSX$getDetails$1 = (AniworldPlugin$ByseSX$getDetails$1) continuation;
                if ((aniworldPlugin$ByseSX$getDetails$1.label & Integer.MIN_VALUE) != 0) {
                    aniworldPlugin$ByseSX$getDetails$1.label -= Integer.MIN_VALUE;
                } else {
                    aniworldPlugin$ByseSX$getDetails$1 = new AniworldPlugin$ByseSX$getDetails$1(this, continuation);
                }
            } else {
                aniworldPlugin$ByseSX$getDetails$1 = new AniworldPlugin$ByseSX$getDetails$1(this, continuation);
            }
            AniworldPlugin$ByseSX$getDetails$1 aniworldPlugin$ByseSX$getDetails$2 = aniworldPlugin$ByseSX$getDetails$1;
            Object $result = aniworldPlugin$ByseSX$getDetails$2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (aniworldPlugin$ByseSX$getDetails$2.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    String base = getBaseUrl(mainUrl);
                    String code = getCodeFromUrl(mainUrl);
                    String url = base + "/api/videos/" + code + "/embed/details";
                    Requests app = MainActivityKt.getApp();
                    aniworldPlugin$ByseSX$getDetails$2.L$0 = SpillingKt.nullOutSpilledVariable(mainUrl);
                    aniworldPlugin$ByseSX$getDetails$2.L$1 = SpillingKt.nullOutSpilledVariable(base);
                    aniworldPlugin$ByseSX$getDetails$2.L$2 = SpillingKt.nullOutSpilledVariable(code);
                    aniworldPlugin$ByseSX$getDetails$2.L$3 = SpillingKt.nullOutSpilledVariable(url);
                    aniworldPlugin$ByseSX$getDetails$2.label = 1;
                    obj = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, aniworldPlugin$ByseSX$getDetails$2, 4094, (Object) null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            NiceResponse this_$iv = (NiceResponse) obj;
            try {
                ResponseParser parser = this_$iv.getParser();
                Intrinsics.checkNotNull(parser);
                return parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(DetailsRoot.class));
            } catch (Exception e$iv) {
                e$iv.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:20:0x007f A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:21:0x0080  */
        /* JADX WARN: Code duplicated, block: B:23:0x0172 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:24:0x0173  */
        /* JADX WARN: Code duplicated, block: B:32:0x01a3 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:33:0x01a4  */
        /* JADX WARN: Code duplicated, block: B:7:0x001a  */
        public final Object getPlayback(String mainUrl, Continuation<? super Pair<PlaybackRoot, String>> continuation) {
            AniworldPlugin$ByseSX$getPlayback$1 aniworldPlugin$ByseSX$getPlayback$1;
            Object details;
            String mainUrl2;
            DetailsRoot details2;
            String embedFrameUrl;
            String embedFrameUrl2;
            Object safe;
            PlaybackRoot root;
            if (continuation instanceof AniworldPlugin$ByseSX$getPlayback$1) {
                aniworldPlugin$ByseSX$getPlayback$1 = (AniworldPlugin$ByseSX$getPlayback$1) continuation;
                if ((aniworldPlugin$ByseSX$getPlayback$1.label & Integer.MIN_VALUE) != 0) {
                    aniworldPlugin$ByseSX$getPlayback$1.label -= Integer.MIN_VALUE;
                } else {
                    aniworldPlugin$ByseSX$getPlayback$1 = new AniworldPlugin$ByseSX$getPlayback$1(this, continuation);
                }
            } else {
                aniworldPlugin$ByseSX$getPlayback$1 = new AniworldPlugin$ByseSX$getPlayback$1(this, continuation);
            }
            Object $result = aniworldPlugin$ByseSX$getPlayback$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (aniworldPlugin$ByseSX$getPlayback$1.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    aniworldPlugin$ByseSX$getPlayback$1.L$0 = mainUrl;
                    aniworldPlugin$ByseSX$getPlayback$1.label = 1;
                    details = getDetails(mainUrl, aniworldPlugin$ByseSX$getPlayback$1);
                    if (details == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mainUrl2 = mainUrl;
                    details2 = (DetailsRoot) details;
                    if (details2 == null) {
                        return null;
                    }
                    embedFrameUrl = details2.getEmbedFrameUrl();
                    String embedBase = getBaseUrl(embedFrameUrl);
                    String code = getCodeFromUrl(embedFrameUrl);
                    String playbackUrl = embedBase + "/api/videos/" + code + "/embed/playback";
                    Map headers = MapsKt.mapOf(new Pair[]{TuplesKt.to("accept", "*/*"), TuplesKt.to("accept-language", "en-US,en;q=0.5"), TuplesKt.to("priority", "u=1, i"), TuplesKt.to("referer", embedFrameUrl), TuplesKt.to("x-embed-parent", StringsKt.replace$default(mainUrl2, "/d/", "/e/", false, 4, (Object) null))});
                    Requests app = MainActivityKt.getApp();
                    aniworldPlugin$ByseSX$getPlayback$1.L$0 = SpillingKt.nullOutSpilledVariable(mainUrl2);
                    aniworldPlugin$ByseSX$getPlayback$1.L$1 = SpillingKt.nullOutSpilledVariable(details2);
                    aniworldPlugin$ByseSX$getPlayback$1.L$2 = embedFrameUrl;
                    aniworldPlugin$ByseSX$getPlayback$1.L$3 = SpillingKt.nullOutSpilledVariable(embedBase);
                    aniworldPlugin$ByseSX$getPlayback$1.L$4 = SpillingKt.nullOutSpilledVariable(code);
                    aniworldPlugin$ByseSX$getPlayback$1.L$5 = SpillingKt.nullOutSpilledVariable(playbackUrl);
                    aniworldPlugin$ByseSX$getPlayback$1.L$6 = SpillingKt.nullOutSpilledVariable(headers);
                    aniworldPlugin$ByseSX$getPlayback$1.label = 2;
                    $result = Requests.post$default(app, playbackUrl, headers, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, aniworldPlugin$ByseSX$getPlayback$1, 65532, (Object) null);
                    if ($result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    embedFrameUrl2 = embedFrameUrl;
                    NiceResponse this_$iv = (NiceResponse) $result;
                    try {
                        ResponseParser parser = this_$iv.getParser();
                        Intrinsics.checkNotNull(parser);
                        safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(PlaybackRoot.class));
                        break;
                    } catch (Exception e$iv) {
                        e$iv.printStackTrace();
                        safe = null;
                    }
                    root = (PlaybackRoot) safe;
                    if (root == null) {
                        return null;
                    }
                    return TuplesKt.to(root, embedFrameUrl2);
                case 1:
                    String mainUrl3 = (String) aniworldPlugin$ByseSX$getPlayback$1.L$0;
                    ResultKt.throwOnFailure($result);
                    details = $result;
                    mainUrl2 = mainUrl3;
                    details2 = (DetailsRoot) details;
                    if (details2 == null) {
                        return null;
                    }
                    embedFrameUrl = details2.getEmbedFrameUrl();
                    String embedBase2 = getBaseUrl(embedFrameUrl);
                    String code2 = getCodeFromUrl(embedFrameUrl);
                    String playbackUrl2 = embedBase2 + "/api/videos/" + code2 + "/embed/playback";
                    Map headers2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("accept", "*/*"), TuplesKt.to("accept-language", "en-US,en;q=0.5"), TuplesKt.to("priority", "u=1, i"), TuplesKt.to("referer", embedFrameUrl), TuplesKt.to("x-embed-parent", StringsKt.replace$default(mainUrl2, "/d/", "/e/", false, 4, (Object) null))});
                    Requests app2 = MainActivityKt.getApp();
                    aniworldPlugin$ByseSX$getPlayback$1.L$0 = SpillingKt.nullOutSpilledVariable(mainUrl2);
                    aniworldPlugin$ByseSX$getPlayback$1.L$1 = SpillingKt.nullOutSpilledVariable(details2);
                    aniworldPlugin$ByseSX$getPlayback$1.L$2 = embedFrameUrl;
                    aniworldPlugin$ByseSX$getPlayback$1.L$3 = SpillingKt.nullOutSpilledVariable(embedBase2);
                    aniworldPlugin$ByseSX$getPlayback$1.L$4 = SpillingKt.nullOutSpilledVariable(code2);
                    aniworldPlugin$ByseSX$getPlayback$1.L$5 = SpillingKt.nullOutSpilledVariable(playbackUrl2);
                    aniworldPlugin$ByseSX$getPlayback$1.L$6 = SpillingKt.nullOutSpilledVariable(headers2);
                    aniworldPlugin$ByseSX$getPlayback$1.label = 2;
                    $result = Requests.post$default(app2, playbackUrl2, headers2, (String) null, (Map) null, (Map) null, (Map) null, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, aniworldPlugin$ByseSX$getPlayback$1, 65532, (Object) null);
                    if ($result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    embedFrameUrl2 = embedFrameUrl;
                    NiceResponse this_$iv2 = (NiceResponse) $result;
                    ResponseParser parser2 = this_$iv2.getParser();
                    Intrinsics.checkNotNull(parser2);
                    safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(PlaybackRoot.class));
                    root = (PlaybackRoot) safe;
                    if (root == null) {
                        return null;
                    }
                    return TuplesKt.to(root, embedFrameUrl2);
                case 2:
                    embedFrameUrl2 = (String) aniworldPlugin$ByseSX$getPlayback$1.L$2;
                    ResultKt.throwOnFailure($result);
                    NiceResponse this_$iv3 = (NiceResponse) $result;
                    ResponseParser parser3 = this_$iv3.getParser();
                    Intrinsics.checkNotNull(parser3);
                    safe = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(PlaybackRoot.class));
                    root = (PlaybackRoot) safe;
                    if (root == null) {
                        return null;
                    }
                    return TuplesKt.to(root, embedFrameUrl2);
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        private final byte[] buildAesKey(Playback playback) {
            byte[] p1 = b64UrlDecode(playback.getKeyParts().get(0));
            byte[] p2 = b64UrlDecode(playback.getKeyParts().get(1));
            return ArraysKt.plus(p1, p2);
        }

        private final String decryptPlayback(Playback playback) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
            String jsonStr;
            Object obj;
            Object obj2;
            Object objDecodeFromString;
            PlaybackDecrypt root;
            List<PlaybackDecryptSource> sources;
            PlaybackDecryptSource playbackDecryptSource;
            byte[] keyBytes = buildAesKey(playback);
            byte[] ivBytes = b64UrlDecode(playback.getIv());
            byte[] cipherBytes = b64UrlDecode(playback.getPayload());
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec spec = new GCMParameterSpec(128, ivBytes);
            SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
            cipher.init(2, secretKey, spec);
            byte[] plainBytes = cipher.doFinal(cipherBytes);
            String jsonStr2 = StringsKt.decodeToString(plainBytes);
            if (StringsKt.startsWith$default(jsonStr2, "\ufeff", false, 2, (Object) null)) {
                jsonStr = jsonStr2.substring(1);
                Intrinsics.checkNotNullExpressionValue(jsonStr, "substring(...)");
            } else {
                jsonStr = jsonStr2;
            }
            try {
                AppUtils appUtils = AppUtils.INSTANCE;
                String value$iv = jsonStr;
                if (value$iv == null) {
                    obj2 = null;
                } else {
                    try {
                        try {
                            Result.Companion companion = Result.Companion;
                            KType kTypeTypeOf = Reflection.typeOf(PlaybackDecrypt.class);
                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj) != null) {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                try {
                                    obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(PlaybackDecrypt.class), (List) null, 2, (Object) null));
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        Result.Companion companion4 = Result.Companion;
                                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                                    } catch (Exception e) {
                                        obj2 = null;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        DeserializationStrategy deserializationStrategy = (KSerializer) (Result.isFailure-impl(obj) ? null : obj);
                        if (deserializationStrategy != null) {
                            try {
                                objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                            } catch (SerializationException e2) {
                                ArchComponentExtKt.logError(e2);
                                ObjectMapper $this$readValue$iv$iv$iv = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv.readValue(value$iv, new TypeReference<PlaybackDecrypt>() { // from class: com.Aniworld.AniworldPlugin$ByseSX$decryptPlayback$$inlined$tryParseJson$1
                                });
                            } catch (Throwable th4) {
                                ObjectMapper $this$readValue$iv$iv$iv2 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv$iv2.readValue(value$iv, new TypeReference<PlaybackDecrypt>() { // from class: com.Aniworld.AniworldPlugin$ByseSX$decryptPlayback$$inlined$tryParseJson$1
                                });
                            }
                        } else {
                            ObjectMapper $this$readValue$iv$iv$iv3 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv$iv3.readValue(value$iv, new TypeReference<PlaybackDecrypt>() { // from class: com.Aniworld.AniworldPlugin$ByseSX$decryptPlayback$$inlined$tryParseJson$1
                            });
                        }
                        obj2 = objDecodeFromString;
                    } catch (Exception e3) {
                        obj2 = null;
                        root = (PlaybackDecrypt) obj2;
                        if (root != null) {
                        }
                        return null;
                    }
                }
                try {
                    root = (PlaybackDecrypt) obj2;
                    if (root != null || (sources = root.getSources()) == null || (playbackDecryptSource = (PlaybackDecryptSource) CollectionsKt.firstOrNull(sources)) == null) {
                        return null;
                    }
                    return playbackDecryptSource.getUrl();
                } catch (Exception e4) {
                    return null;
                }
            } catch (Exception e5) {
                return null;
            }
        }

        /* JADX WARN: Code duplicated, block: B:20:0x00b1  */
        /* JADX WARN: Code duplicated, block: B:22:0x00b4  */
        /* JADX WARN: Code duplicated, block: B:24:0x00cd  */
        /* JADX WARN: Code duplicated, block: B:26:0x00d0  */
        /* JADX WARN: Code duplicated, block: B:28:0x012b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:29:0x012c  */
        /* JADX WARN: Code duplicated, block: B:33:0x0142 A[LOOP:0: B:31:0x013c->B:33:0x0142, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:7:0x0018  */
        static /* synthetic */ Object getUrl$suspendImpl(ByseSX $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
            AniworldPlugin$ByseSX$getUrl$1 aniworldPlugin$ByseSX$getUrl$1;
            Object playback;
            Function1<? super SubtitleFile, Unit> function3;
            String referer2;
            Function1<? super ExtractorLink, Unit> function4;
            String url2;
            Pair pair;
            PlaybackRoot playbackRoot;
            String m3u8referer;
            String streamUrl;
            Function1<? super ExtractorLink, Unit> function5;
            Object objGenerateM3u8$default;
            Function1<? super ExtractorLink, Unit> function6;
            ByseSX $this2 = $this;
            if (continuation instanceof AniworldPlugin$ByseSX$getUrl$1) {
                aniworldPlugin$ByseSX$getUrl$1 = (AniworldPlugin$ByseSX$getUrl$1) continuation;
                if ((aniworldPlugin$ByseSX$getUrl$1.label & Integer.MIN_VALUE) != 0) {
                    aniworldPlugin$ByseSX$getUrl$1.label -= Integer.MIN_VALUE;
                } else {
                    aniworldPlugin$ByseSX$getUrl$1 = new AniworldPlugin$ByseSX$getUrl$1($this2, continuation);
                }
            } else {
                aniworldPlugin$ByseSX$getUrl$1 = new AniworldPlugin$ByseSX$getUrl$1($this2, continuation);
            }
            AniworldPlugin$ByseSX$getUrl$1 aniworldPlugin$ByseSX$getUrl$2 = aniworldPlugin$ByseSX$getUrl$1;
            Object $result = aniworldPlugin$ByseSX$getUrl$2.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (aniworldPlugin$ByseSX$getUrl$2.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    aniworldPlugin$ByseSX$getUrl$2.L$0 = $this2;
                    aniworldPlugin$ByseSX$getUrl$2.L$1 = SpillingKt.nullOutSpilledVariable(url);
                    aniworldPlugin$ByseSX$getUrl$2.L$2 = referer;
                    aniworldPlugin$ByseSX$getUrl$2.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                    aniworldPlugin$ByseSX$getUrl$2.L$4 = function2;
                    aniworldPlugin$ByseSX$getUrl$2.label = 1;
                    playback = $this2.getPlayback(url, aniworldPlugin$ByseSX$getUrl$2);
                    if (playback == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function3 = function1;
                    referer2 = referer;
                    function4 = function2;
                    url2 = url;
                    pair = (Pair) playback;
                    if (pair == null) {
                        return Unit.INSTANCE;
                    }
                    playbackRoot = (PlaybackRoot) pair.component1();
                    m3u8referer = (String) pair.component2();
                    streamUrl = $this2.decryptPlayback(playbackRoot.getPlayback());
                    if (streamUrl == null) {
                        return Unit.INSTANCE;
                    }
                    Map headers = MapsKt.mapOf(TuplesKt.to("Referer", m3u8referer));
                    M3u8Helper.Companion companion = M3u8Helper.Companion;
                    String strValueOf = String.valueOf(referer2);
                    aniworldPlugin$ByseSX$getUrl$2.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                    aniworldPlugin$ByseSX$getUrl$2.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                    aniworldPlugin$ByseSX$getUrl$2.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                    aniworldPlugin$ByseSX$getUrl$2.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                    aniworldPlugin$ByseSX$getUrl$2.L$4 = function4;
                    aniworldPlugin$ByseSX$getUrl$2.L$5 = SpillingKt.nullOutSpilledVariable(playbackRoot);
                    aniworldPlugin$ByseSX$getUrl$2.L$6 = SpillingKt.nullOutSpilledVariable(m3u8referer);
                    aniworldPlugin$ByseSX$getUrl$2.L$7 = SpillingKt.nullOutSpilledVariable(streamUrl);
                    aniworldPlugin$ByseSX$getUrl$2.L$8 = SpillingKt.nullOutSpilledVariable(headers);
                    aniworldPlugin$ByseSX$getUrl$2.label = 2;
                    function5 = function4;
                    objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion, strValueOf, streamUrl, m3u8referer, (Integer) null, headers, (String) null, aniworldPlugin$ByseSX$getUrl$2, 40, (Object) null);
                    if (objGenerateM3u8$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function6 = function5;
                    Iterable $this$forEach$iv = (Iterable) objGenerateM3u8$default;
                    for (Object element$iv : $this$forEach$iv) {
                        function6.invoke(element$iv);
                    }
                    return Unit.INSTANCE;
                case 1:
                    function4 = (Function1) aniworldPlugin$ByseSX$getUrl$2.L$4;
                    Function1<? super SubtitleFile, Unit> function7 = (Function1) aniworldPlugin$ByseSX$getUrl$2.L$3;
                    String referer3 = (String) aniworldPlugin$ByseSX$getUrl$2.L$2;
                    String url3 = (String) aniworldPlugin$ByseSX$getUrl$2.L$1;
                    $this2 = (ByseSX) aniworldPlugin$ByseSX$getUrl$2.L$0;
                    ResultKt.throwOnFailure($result);
                    function3 = function7;
                    referer2 = referer3;
                    url2 = url3;
                    playback = $result;
                    pair = (Pair) playback;
                    if (pair == null) {
                        return Unit.INSTANCE;
                    }
                    playbackRoot = (PlaybackRoot) pair.component1();
                    m3u8referer = (String) pair.component2();
                    streamUrl = $this2.decryptPlayback(playbackRoot.getPlayback());
                    if (streamUrl == null) {
                        return Unit.INSTANCE;
                    }
                    Map headers2 = MapsKt.mapOf(TuplesKt.to("Referer", m3u8referer));
                    M3u8Helper.Companion companion2 = M3u8Helper.Companion;
                    String strValueOf2 = String.valueOf(referer2);
                    aniworldPlugin$ByseSX$getUrl$2.L$0 = SpillingKt.nullOutSpilledVariable($this2);
                    aniworldPlugin$ByseSX$getUrl$2.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                    aniworldPlugin$ByseSX$getUrl$2.L$2 = SpillingKt.nullOutSpilledVariable(referer2);
                    aniworldPlugin$ByseSX$getUrl$2.L$3 = SpillingKt.nullOutSpilledVariable(function3);
                    aniworldPlugin$ByseSX$getUrl$2.L$4 = function4;
                    aniworldPlugin$ByseSX$getUrl$2.L$5 = SpillingKt.nullOutSpilledVariable(playbackRoot);
                    aniworldPlugin$ByseSX$getUrl$2.L$6 = SpillingKt.nullOutSpilledVariable(m3u8referer);
                    aniworldPlugin$ByseSX$getUrl$2.L$7 = SpillingKt.nullOutSpilledVariable(streamUrl);
                    aniworldPlugin$ByseSX$getUrl$2.L$8 = SpillingKt.nullOutSpilledVariable(headers2);
                    aniworldPlugin$ByseSX$getUrl$2.label = 2;
                    function5 = function4;
                    objGenerateM3u8$default = M3u8Helper.Companion.generateM3u8$default(companion2, strValueOf2, streamUrl, m3u8referer, (Integer) null, headers2, (String) null, aniworldPlugin$ByseSX$getUrl$2, 40, (Object) null);
                    if (objGenerateM3u8$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    function6 = function5;
                    Iterable $this$forEach$iv2 = (Iterable) objGenerateM3u8$default;
                    while (r13.hasNext()) {
                        function6.invoke(element$iv);
                    }
                    return Unit.INSTANCE;
                case 2:
                    function6 = (Function1) aniworldPlugin$ByseSX$getUrl$2.L$4;
                    ResultKt.throwOnFailure($result);
                    objGenerateM3u8$default = $result;
                    Iterable $this$forEach$iv3 = (Iterable) objGenerateM3u8$default;
                    while (r13.hasNext()) {
                        function6.invoke(element$iv);
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: compiled from: AniworldPlugin.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0016\b\u0001\u0010\u0007\u001a\u00020\u0005:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0016\b\u0001\u0010\f\u001a\u00020\u0005:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0016\b\u0001\u0010\u000e\u001a\u00020\u000f:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u0012\u0016\b\u0001\u0010\u0011\u001a\u00020\u0005:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u000fHÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u0091\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0016\b\u0003\u0010\u0007\u001a\u00020\u0005:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u0016\b\u0003\u0010\f\u001a\u00020\u0005:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r2\u0016\b\u0003\u0010\u000e\u001a\u00020\u000f:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u00102\u0016\b\u0003\u0010\u0011\u001a\u00020\u0005:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012HÆ\u0001J\u0014\u0010)\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010+\u001a\u00020,HÖ\u0081\u0004J\n\u0010-\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018¨\u0006."}, d2 = {"Lcom/Aniworld/AniworldPlugin$DetailsRoot;", "", "id", "", "code", "", "title", "posterUrl", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "poster_url", "description", "createdAt", "created_at", "ownerPrivate", "", "owner_private", "embedFrameUrl", "embed_frame_url", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getId", "()J", "getCode", "()Ljava/lang/String;", "getTitle", "getPosterUrl", "getDescription", "getCreatedAt", "getOwnerPrivate", "()Z", "getEmbedFrameUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "Aniworld"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class DetailsRoot {

        @NotNull
        private final String code;

        @NotNull
        private final String createdAt;

        @NotNull
        private final String description;

        @NotNull
        private final String embedFrameUrl;
        private final long id;
        private final boolean ownerPrivate;

        @NotNull
        private final String posterUrl;

        @NotNull
        private final String title;

        public static /* synthetic */ DetailsRoot copy$default(DetailsRoot detailsRoot, long j, String str, String str2, String str3, String str4, String str5, boolean z, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                j = detailsRoot.id;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = detailsRoot.code;
            }
            String str7 = str;
            if ((i & 4) != 0) {
                str2 = detailsRoot.title;
            }
            String str8 = str2;
            if ((i & 8) != 0) {
                str3 = detailsRoot.posterUrl;
            }
            return detailsRoot.copy(j2, str7, str8, str3, (i & 16) != 0 ? detailsRoot.description : str4, (i & 32) != 0 ? detailsRoot.createdAt : str5, (i & 64) != 0 ? detailsRoot.ownerPrivate : z, (i & 128) != 0 ? detailsRoot.embedFrameUrl : str6);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getId() {
            return this.id;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getPosterUrl() {
            return this.posterUrl;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getCreatedAt() {
            return this.createdAt;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getOwnerPrivate() {
            return this.ownerPrivate;
        }

        @NotNull
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getEmbedFrameUrl() {
            return this.embedFrameUrl;
        }

        @NotNull
        public final DetailsRoot copy(long id, @NotNull String code, @NotNull String title, @JsonProperty("poster_url") @NotNull String posterUrl, @NotNull String description, @JsonProperty("created_at") @NotNull String createdAt, @JsonProperty("owner_private") boolean ownerPrivate, @JsonProperty("embed_frame_url") @NotNull String embedFrameUrl) {
            return new DetailsRoot(id, code, title, posterUrl, description, createdAt, ownerPrivate, embedFrameUrl);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DetailsRoot)) {
                return false;
            }
            DetailsRoot detailsRoot = (DetailsRoot) other;
            return this.id == detailsRoot.id && Intrinsics.areEqual(this.code, detailsRoot.code) && Intrinsics.areEqual(this.title, detailsRoot.title) && Intrinsics.areEqual(this.posterUrl, detailsRoot.posterUrl) && Intrinsics.areEqual(this.description, detailsRoot.description) && Intrinsics.areEqual(this.createdAt, detailsRoot.createdAt) && this.ownerPrivate == detailsRoot.ownerPrivate && Intrinsics.areEqual(this.embedFrameUrl, detailsRoot.embedFrameUrl);
        }

        public int hashCode() {
            return (((((((((((((AniworldPlugin$DetailsRoot$$ExternalSyntheticBackport0.m0m(this.id) * 31) + this.code.hashCode()) * 31) + this.title.hashCode()) * 31) + this.posterUrl.hashCode()) * 31) + this.description.hashCode()) * 31) + this.createdAt.hashCode()) * 31) + AniworldPlugin$DetailsRoot$$ExternalSyntheticBackport1.m1m(this.ownerPrivate)) * 31) + this.embedFrameUrl.hashCode();
        }

        @NotNull
        public String toString() {
            return "DetailsRoot(id=" + this.id + ", code=" + this.code + ", title=" + this.title + ", posterUrl=" + this.posterUrl + ", description=" + this.description + ", createdAt=" + this.createdAt + ", ownerPrivate=" + this.ownerPrivate + ", embedFrameUrl=" + this.embedFrameUrl + ')';
        }

        public DetailsRoot(long id, @NotNull String code, @NotNull String title, @JsonProperty("poster_url") @NotNull String posterUrl, @NotNull String description, @JsonProperty("created_at") @NotNull String createdAt, @JsonProperty("owner_private") boolean ownerPrivate, @JsonProperty("embed_frame_url") @NotNull String embedFrameUrl) {
            this.id = id;
            this.code = code;
            this.title = title;
            this.posterUrl = posterUrl;
            this.description = description;
            this.createdAt = createdAt;
            this.ownerPrivate = ownerPrivate;
            this.embedFrameUrl = embedFrameUrl;
        }

        public final long getId() {
            return this.id;
        }

        @NotNull
        public final String getCode() {
            return this.code;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getPosterUrl() {
            return this.posterUrl;
        }

        @NotNull
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final String getCreatedAt() {
            return this.createdAt;
        }

        public final boolean getOwnerPrivate() {
            return this.ownerPrivate;
        }

        @NotNull
        public final String getEmbedFrameUrl() {
            return this.embedFrameUrl;
        }
    }

    /* JADX INFO: compiled from: AniworldPlugin.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/Aniworld/AniworldPlugin$PlaybackRoot;", "", "playback", "Lcom/Aniworld/AniworldPlugin$Playback;", "<init>", "(Lcom/Aniworld/AniworldPlugin$Playback;)V", "getPlayback", "()Lcom/Aniworld/AniworldPlugin$Playback;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Aniworld"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class PlaybackRoot {

        @NotNull
        private final Playback playback;

        public static /* synthetic */ PlaybackRoot copy$default(PlaybackRoot playbackRoot, Playback playback, int i, Object obj) {
            if ((i & 1) != 0) {
                playback = playbackRoot.playback;
            }
            return playbackRoot.copy(playback);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Playback getPlayback() {
            return this.playback;
        }

        @NotNull
        public final PlaybackRoot copy(@NotNull Playback playback) {
            return new PlaybackRoot(playback);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PlaybackRoot) && Intrinsics.areEqual(this.playback, ((PlaybackRoot) other).playback);
        }

        public int hashCode() {
            return this.playback.hashCode();
        }

        @NotNull
        public String toString() {
            return "PlaybackRoot(playback=" + this.playback + ')';
        }

        public PlaybackRoot(@NotNull Playback playback) {
            this.playback = playback;
        }

        @NotNull
        public final Playback getPlayback() {
            return this.playback;
        }
    }

    /* JADX INFO: compiled from: AniworldPlugin.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u001c\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0016\b\u0001\u0010\u000b\u001a\u00020\u0003:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0016\b\u0001\u0010\r\u001a\u00020\u000e:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u000eHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0089\u0001\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u001c\b\u0003\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n2\u0016\b\u0003\u0010\u000b\u001a\u00020\u0003:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f2\u0016\b\u0003\u0010\r\u001a\u00020\u000e:\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0003HÆ\u0001J\u0014\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010+\u001a\u00020,HÖ\u0081\u0004J\n\u0010-\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015¨\u0006."}, d2 = {"Lcom/Aniworld/AniworldPlugin$Playback;", "", "algorithm", "", "iv", "payload", "keyParts", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "key_parts", "expiresAt", "expires_at", "decryptKeys", "Lcom/Aniworld/AniworldPlugin$DecryptKeys;", "decrypt_keys", "iv2", "payload2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/Aniworld/AniworldPlugin$DecryptKeys;Ljava/lang/String;Ljava/lang/String;)V", "getAlgorithm", "()Ljava/lang/String;", "getIv", "getPayload", "getKeyParts", "()Ljava/util/List;", "getExpiresAt", "getDecryptKeys", "()Lcom/Aniworld/AniworldPlugin$DecryptKeys;", "getIv2", "getPayload2", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "Aniworld"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Playback {

        @NotNull
        private final String algorithm;

        @NotNull
        private final DecryptKeys decryptKeys;

        @NotNull
        private final String expiresAt;

        @NotNull
        private final String iv;

        @NotNull
        private final String iv2;

        @NotNull
        private final List<String> keyParts;

        @NotNull
        private final String payload;

        @NotNull
        private final String payload2;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Playback copy$default(Playback playback, String str, String str2, String str3, List list, String str4, DecryptKeys decryptKeys, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = playback.algorithm;
            }
            if ((i & 2) != 0) {
                str2 = playback.iv;
            }
            if ((i & 4) != 0) {
                str3 = playback.payload;
            }
            if ((i & 8) != 0) {
                list = playback.keyParts;
            }
            if ((i & 16) != 0) {
                str4 = playback.expiresAt;
            }
            if ((i & 32) != 0) {
                decryptKeys = playback.decryptKeys;
            }
            if ((i & 64) != 0) {
                str5 = playback.iv2;
            }
            if ((i & 128) != 0) {
                str6 = playback.payload2;
            }
            String str7 = str5;
            String str8 = str6;
            String str9 = str4;
            DecryptKeys decryptKeys2 = decryptKeys;
            return playback.copy(str, str2, str3, list, str9, decryptKeys2, str7, str8);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAlgorithm() {
            return this.algorithm;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getIv() {
            return this.iv;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getPayload() {
            return this.payload;
        }

        @NotNull
        public final List<String> component4() {
            return this.keyParts;
        }

        @NotNull
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getExpiresAt() {
            return this.expiresAt;
        }

        @NotNull
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final DecryptKeys getDecryptKeys() {
            return this.decryptKeys;
        }

        @NotNull
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getIv2() {
            return this.iv2;
        }

        @NotNull
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getPayload2() {
            return this.payload2;
        }

        @NotNull
        public final Playback copy(@NotNull String algorithm, @NotNull String iv, @NotNull String payload, @JsonProperty("key_parts") @NotNull List<String> keyParts, @JsonProperty("expires_at") @NotNull String expiresAt, @JsonProperty("decrypt_keys") @NotNull DecryptKeys decryptKeys, @NotNull String iv2, @NotNull String payload2) {
            return new Playback(algorithm, iv, payload, keyParts, expiresAt, decryptKeys, iv2, payload2);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Playback)) {
                return false;
            }
            Playback playback = (Playback) other;
            return Intrinsics.areEqual(this.algorithm, playback.algorithm) && Intrinsics.areEqual(this.iv, playback.iv) && Intrinsics.areEqual(this.payload, playback.payload) && Intrinsics.areEqual(this.keyParts, playback.keyParts) && Intrinsics.areEqual(this.expiresAt, playback.expiresAt) && Intrinsics.areEqual(this.decryptKeys, playback.decryptKeys) && Intrinsics.areEqual(this.iv2, playback.iv2) && Intrinsics.areEqual(this.payload2, playback.payload2);
        }

        public int hashCode() {
            return (((((((((((((this.algorithm.hashCode() * 31) + this.iv.hashCode()) * 31) + this.payload.hashCode()) * 31) + this.keyParts.hashCode()) * 31) + this.expiresAt.hashCode()) * 31) + this.decryptKeys.hashCode()) * 31) + this.iv2.hashCode()) * 31) + this.payload2.hashCode();
        }

        @NotNull
        public String toString() {
            return "Playback(algorithm=" + this.algorithm + ", iv=" + this.iv + ", payload=" + this.payload + ", keyParts=" + this.keyParts + ", expiresAt=" + this.expiresAt + ", decryptKeys=" + this.decryptKeys + ", iv2=" + this.iv2 + ", payload2=" + this.payload2 + ')';
        }

        public Playback(@NotNull String algorithm, @NotNull String iv, @NotNull String payload, @JsonProperty("key_parts") @NotNull List<String> list, @JsonProperty("expires_at") @NotNull String expiresAt, @JsonProperty("decrypt_keys") @NotNull DecryptKeys decryptKeys, @NotNull String iv2, @NotNull String payload2) {
            this.algorithm = algorithm;
            this.iv = iv;
            this.payload = payload;
            this.keyParts = list;
            this.expiresAt = expiresAt;
            this.decryptKeys = decryptKeys;
            this.iv2 = iv2;
            this.payload2 = payload2;
        }

        @NotNull
        public final String getAlgorithm() {
            return this.algorithm;
        }

        @NotNull
        public final String getIv() {
            return this.iv;
        }

        @NotNull
        public final String getPayload() {
            return this.payload;
        }

        @NotNull
        public final List<String> getKeyParts() {
            return this.keyParts;
        }

        @NotNull
        public final String getExpiresAt() {
            return this.expiresAt;
        }

        @NotNull
        public final DecryptKeys getDecryptKeys() {
            return this.decryptKeys;
        }

        @NotNull
        public final String getIv2() {
            return this.iv2;
        }

        @NotNull
        public final String getPayload2() {
            return this.payload2;
        }
    }

    /* JADX INFO: compiled from: AniworldPlugin.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0001\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0016\b\u0001\u0010\t\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003JQ\u0010\u0014\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\u0007\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0016\b\u0003\u0010\t\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\nHÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/Aniworld/AniworldPlugin$DecryptKeys;", "", "edge1", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "edge_1", "edge2", "edge_2", "legacyFallback", "legacy_fallback", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEdge1", "()Ljava/lang/String;", "getEdge2", "getLegacyFallback", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Aniworld"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class DecryptKeys {

        @NotNull
        private final String edge1;

        @NotNull
        private final String edge2;

        @NotNull
        private final String legacyFallback;

        public static /* synthetic */ DecryptKeys copy$default(DecryptKeys decryptKeys, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = decryptKeys.edge1;
            }
            if ((i & 2) != 0) {
                str2 = decryptKeys.edge2;
            }
            if ((i & 4) != 0) {
                str3 = decryptKeys.legacyFallback;
            }
            return decryptKeys.copy(str, str2, str3);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getEdge1() {
            return this.edge1;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getEdge2() {
            return this.edge2;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getLegacyFallback() {
            return this.legacyFallback;
        }

        @NotNull
        public final DecryptKeys copy(@JsonProperty("edge_1") @NotNull String edge1, @JsonProperty("edge_2") @NotNull String edge2, @JsonProperty("legacy_fallback") @NotNull String legacyFallback) {
            return new DecryptKeys(edge1, edge2, legacyFallback);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DecryptKeys)) {
                return false;
            }
            DecryptKeys decryptKeys = (DecryptKeys) other;
            return Intrinsics.areEqual(this.edge1, decryptKeys.edge1) && Intrinsics.areEqual(this.edge2, decryptKeys.edge2) && Intrinsics.areEqual(this.legacyFallback, decryptKeys.legacyFallback);
        }

        public int hashCode() {
            return (((this.edge1.hashCode() * 31) + this.edge2.hashCode()) * 31) + this.legacyFallback.hashCode();
        }

        @NotNull
        public String toString() {
            return "DecryptKeys(edge1=" + this.edge1 + ", edge2=" + this.edge2 + ", legacyFallback=" + this.legacyFallback + ')';
        }

        public DecryptKeys(@JsonProperty("edge_1") @NotNull String edge1, @JsonProperty("edge_2") @NotNull String edge2, @JsonProperty("legacy_fallback") @NotNull String legacyFallback) {
            this.edge1 = edge1;
            this.edge2 = edge2;
            this.legacyFallback = legacyFallback;
        }

        @NotNull
        public final String getEdge1() {
            return this.edge1;
        }

        @NotNull
        public final String getEdge2() {
            return this.edge2;
        }

        @NotNull
        public final String getLegacyFallback() {
            return this.legacyFallback;
        }
    }

    /* JADX INFO: compiled from: AniworldPlugin.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/Aniworld/AniworldPlugin$PlaybackDecrypt;", "", "sources", "", "Lcom/Aniworld/AniworldPlugin$PlaybackDecryptSource;", "<init>", "(Ljava/util/List;)V", "getSources", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Aniworld"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class PlaybackDecrypt {

        @NotNull
        private final List<PlaybackDecryptSource> sources;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PlaybackDecrypt copy$default(PlaybackDecrypt playbackDecrypt, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = playbackDecrypt.sources;
            }
            return playbackDecrypt.copy(list);
        }

        @NotNull
        public final List<PlaybackDecryptSource> component1() {
            return this.sources;
        }

        @NotNull
        public final PlaybackDecrypt copy(@NotNull List<PlaybackDecryptSource> sources) {
            return new PlaybackDecrypt(sources);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PlaybackDecrypt) && Intrinsics.areEqual(this.sources, ((PlaybackDecrypt) other).sources);
        }

        public int hashCode() {
            return this.sources.hashCode();
        }

        @NotNull
        public String toString() {
            return "PlaybackDecrypt(sources=" + this.sources + ')';
        }

        public PlaybackDecrypt(@NotNull List<PlaybackDecryptSource> list) {
            this.sources = list;
        }

        @NotNull
        public final List<PlaybackDecryptSource> getSources() {
            return this.sources;
        }
    }

    /* JADX INFO: compiled from: AniworldPlugin.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010\u0005\u001a\u00020\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010\n\u001a\u00020\u000b:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÆ\u0003Jc\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0003\u0010\u0005\u001a\u00020\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u0016\b\u0003\u0010\n\u001a\u00020\u000b:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020$HÖ\u0081\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/Aniworld/AniworldPlugin$PlaybackDecryptSource;", "", "quality", "", "label", "mimeType", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "mime_type", "url", "bitrateKbps", "", "bitrate_kbps", "height", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Object;)V", "getQuality", "()Ljava/lang/String;", "getLabel", "getMimeType", "getUrl", "getBitrateKbps", "()J", "getHeight", "()Ljava/lang/Object;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "Aniworld"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class PlaybackDecryptSource {
        private final long bitrateKbps;

        @Nullable
        private final Object height;

        @NotNull
        private final String label;

        @NotNull
        private final String mimeType;

        @NotNull
        private final String quality;

        @NotNull
        private final String url;

        public static /* synthetic */ PlaybackDecryptSource copy$default(PlaybackDecryptSource playbackDecryptSource, String str, String str2, String str3, String str4, long j, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                str = playbackDecryptSource.quality;
            }
            if ((i & 2) != 0) {
                str2 = playbackDecryptSource.label;
            }
            if ((i & 4) != 0) {
                str3 = playbackDecryptSource.mimeType;
            }
            if ((i & 8) != 0) {
                str4 = playbackDecryptSource.url;
            }
            if ((i & 16) != 0) {
                j = playbackDecryptSource.bitrateKbps;
            }
            if ((i & 32) != 0) {
                obj = playbackDecryptSource.height;
            }
            Object obj3 = obj;
            long j2 = j;
            return playbackDecryptSource.copy(str, str2, str3, str4, j2, obj3);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getQuality() {
            return this.quality;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMimeType() {
            return this.mimeType;
        }

        @NotNull
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final long getBitrateKbps() {
            return this.bitrateKbps;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Object getHeight() {
            return this.height;
        }

        @NotNull
        public final PlaybackDecryptSource copy(@NotNull String quality, @NotNull String label, @JsonProperty("mime_type") @NotNull String mimeType, @NotNull String url, @JsonProperty("bitrate_kbps") long bitrateKbps, @Nullable Object height) {
            return new PlaybackDecryptSource(quality, label, mimeType, url, bitrateKbps, height);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PlaybackDecryptSource)) {
                return false;
            }
            PlaybackDecryptSource playbackDecryptSource = (PlaybackDecryptSource) other;
            return Intrinsics.areEqual(this.quality, playbackDecryptSource.quality) && Intrinsics.areEqual(this.label, playbackDecryptSource.label) && Intrinsics.areEqual(this.mimeType, playbackDecryptSource.mimeType) && Intrinsics.areEqual(this.url, playbackDecryptSource.url) && this.bitrateKbps == playbackDecryptSource.bitrateKbps && Intrinsics.areEqual(this.height, playbackDecryptSource.height);
        }

        public int hashCode() {
            return (((((((((this.quality.hashCode() * 31) + this.label.hashCode()) * 31) + this.mimeType.hashCode()) * 31) + this.url.hashCode()) * 31) + AniworldPlugin$PlaybackDecryptSource$$ExternalSyntheticBackport0.m2m(this.bitrateKbps)) * 31) + (this.height == null ? 0 : this.height.hashCode());
        }

        @NotNull
        public String toString() {
            return "PlaybackDecryptSource(quality=" + this.quality + ", label=" + this.label + ", mimeType=" + this.mimeType + ", url=" + this.url + ", bitrateKbps=" + this.bitrateKbps + ", height=" + this.height + ')';
        }

        public PlaybackDecryptSource(@NotNull String quality, @NotNull String label, @JsonProperty("mime_type") @NotNull String mimeType, @NotNull String url, @JsonProperty("bitrate_kbps") long bitrateKbps, @Nullable Object height) {
            this.quality = quality;
            this.label = label;
            this.mimeType = mimeType;
            this.url = url;
            this.bitrateKbps = bitrateKbps;
            this.height = height;
        }

        @NotNull
        public final String getQuality() {
            return this.quality;
        }

        @NotNull
        public final String getLabel() {
            return this.label;
        }

        @NotNull
        public final String getMimeType() {
            return this.mimeType;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        public final long getBitrateKbps() {
            return this.bitrateKbps;
        }

        @Nullable
        public final Object getHeight() {
            return this.height;
        }
    }
}
