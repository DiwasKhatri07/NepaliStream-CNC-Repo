package com.Anichi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AnichiUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Anichi/classes.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0013\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a<\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0086@¢\u0006\u0002\u0010\f\u001a\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0013\u001ab\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00150\u001a2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00150\u001a2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\nH\u0086@¢\u0006\u0002\u0010\u001f\u001a\u001c\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020&\u0018\u00010/H\u0086@¢\u0006\u0002\u00100\u001a\u0006\u00106\u001a\u00020\u0015\u001a\b\u0010:\u001a\u000205H\u0002\u001a\b\u0010;\u001a\u000205H\u0002\u001a(\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u0002052\u0006\u0010@\u001a\u00020\u0003H\u0002\u001a\u001c\u0010A\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\n\u0018\u00010/H\u0086@¢\u0006\u0002\u00100\u001a\"\u0010B\u001a\u0004\u0018\u00010\u00032\u0006\u0010C\u001a\u00020\u00032\b\b\u0002\u0010@\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010D\u001a$\u0010E\u001a\u0004\u0018\u00010\u00032\u0006\u0010F\u001a\u00020\u00032\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0003H\u0086@¢\u0006\u0002\u0010D\"\u000e\u0010\r\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000\"\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010 \u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\"\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\"\u001c\u0010+\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*\"\u0010\u00101\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0012\u00102\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u00103\"\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u00107\u001a\u000205X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00108\u001a\u000205X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00109\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"parseAnimeData", "Lcom/Anichi/MetaAnimeData;", "jsonString", "", "fetchTmdbLogoUrl", "tmdbAPI", "apiKey", "type", "Lcom/lagradost/cloudstream3/TvType;", "tmdbId", "", "appLangCode", "(Ljava/lang/String;Ljava/lang/String;Lcom/lagradost/cloudstream3/TvType;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "apiUrl", "headerJSON", "", "anilistAPICall", "Lcom/Anichi/AnilistAPIResponse;", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadCustomExtractor", "", "name", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "quality", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mkissaBuildId", "getMkissaBuildId", "()Ljava/lang/String;", "setMkissaBuildId", "(Ljava/lang/String;)V", "mkissaKeyMask", "", "getMkissaKeyMask", "()[B", "setMkissaKeyMask", "([B)V", "capturedAesKeyFromWebView", "getCapturedAesKeyFromWebView", "setCapturedAesKeyFromWebView", "getMkissaCryptoConfig", "Lkotlin/Pair;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cachedCryptoKey", "cachedEpoch", "Ljava/lang/Integer;", "cachedSwitchAt", "", "resetCryptoCache", "AA_EPOCH_MS", "AA_GRACE_MS", "AA_LANE", "getFsEpoch", "getBhEpoch", "makeBootToken", "buildId", "keyMask", "epoch", "lane", "getCryptoMaterial", "generateAaReq", "queryHash", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decodeToBeParsed", "encoded", "mode", "Anichi"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAnichiUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AnichiUtils.kt\ncom/Anichi/AnichiUtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 5 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 6 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n*L\n1#1,580:1\n1#2:581\n1#2:592\n73#3,5:582\n1088#4,2:587\n93#5,2:589\n63#5:591\n64#5,15:593\n95#5,2:610\n50#6:608\n43#6:609\n*S KotlinDebug\n*F\n+ 1 AnichiUtils.kt\ncom/Anichi/AnichiUtilsKt\n*L\n481#1:592\n265#1:582,5\n395#1:587,2\n481#1:589,2\n481#1:591\n481#1:593,15\n481#1:610,2\n481#1:608\n481#1:609\n*E\n"})
public final class AnichiUtilsKt {
    private static final long AA_EPOCH_MS = 259200000;
    private static final long AA_GRACE_MS = 86400000;

    @NotNull
    private static final String AA_LANE = "k7";

    @Nullable
    private static byte[] cachedCryptoKey;

    @Nullable
    private static Integer cachedEpoch;
    private static long cachedSwitchAt;

    @Nullable
    private static byte[] capturedAesKeyFromWebView;

    @Nullable
    private static String mkissaBuildId;

    @Nullable
    private static byte[] mkissaKeyMask;

    @NotNull
    private static final String apiUrl = Anichi.anilistApi;

    @NotNull
    private static final Map<String, String> headerJSON = MapsKt.mapOf(new Pair[]{TuplesKt.to("Accept", "application/json"), TuplesKt.to("Content-Type", "application/json")});

    /* JADX INFO: renamed from: com.Anichi.AnichiUtilsKt$anilistAPICall$1 */
    /* JADX INFO: compiled from: AnichiUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.AnichiUtilsKt", f = "AnichiUtils.kt", i = {0, 0}, l = {263}, m = "anilistAPICall", n = {"query", "data"}, nl = {265}, s = {"L$0", "L$1"}, v = 2)
    static final class C00231 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00231(Continuation<? super C00231> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnichiUtilsKt.anilistAPICall(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Anichi.AnichiUtilsKt$decodeToBeParsed$1 */
    /* JADX INFO: compiled from: AnichiUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.AnichiUtilsKt", f = "AnichiUtils.kt", i = {0, 0, 0, 0, 0}, l = {543}, m = "decodeToBeParsed", n = {"encoded", "mode", "raw", "iv", "ciphertext"}, nl = {544}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    static final class C00241 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C00241(Continuation<? super C00241> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnichiUtilsKt.decodeToBeParsed(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Anichi.AnichiUtilsKt$fetchTmdbLogoUrl$1 */
    /* JADX INFO: compiled from: AnichiUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.AnichiUtilsKt", f = "AnichiUtils.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {229}, m = "fetchTmdbLogoUrl", n = {"tmdbAPI", "apiKey", "type", "tmdbId", "appLangCode", "appLang", "url"}, nl = {229}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"}, v = 2)
    static final class C00251 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C00251(Continuation<? super C00251> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnichiUtilsKt.fetchTmdbLogoUrl(null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Anichi.AnichiUtilsKt$generateAaReq$1 */
    /* JADX INFO: compiled from: AnichiUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.AnichiUtilsKt", f = "AnichiUtils.kt", i = {0, 0}, l = {505}, m = "generateAaReq", n = {"queryHash", "lane"}, nl = {506}, s = {"L$0", "L$1"}, v = 2)
    static final class C00261 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C00261(Continuation<? super C00261> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnichiUtilsKt.generateAaReq(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Anichi.AnichiUtilsKt$getCryptoMaterial$1 */
    /* JADX INFO: compiled from: AnichiUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.AnichiUtilsKt", f = "AnichiUtils.kt", i = {0, 1, 1, 1, 1, 1, 1, 1}, l = {462, 471}, m = "getCryptoMaterial", n = {"nowMs", "config", "buildId", "keyMask", "epochs", "token", "nowMs", "epoch"}, nl = {463, 479}, s = {"J$0", "L$0", "L$1", "L$2", "L$3", "L$5", "J$0", "J$1"}, v = 2)
    static final class C00271 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00271(Continuation<? super C00271> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnichiUtilsKt.getCryptoMaterial((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Anichi.AnichiUtilsKt$getMkissaCryptoConfig$1 */
    /* JADX INFO: compiled from: AnichiUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.AnichiUtilsKt", f = "AnichiUtils.kt", i = {1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {366, 370, 388}, m = "getMkissaCryptoConfig", n = {"html", "appMatch", "appUrl", "html", "appMatch", "appUrl", "appBundle", "imports", "patterns", "ref", "bundleUrl"}, nl = {367, 372, 389}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8"}, v = 2)
    static final class C00281 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        C00281(Continuation<? super C00281> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnichiUtilsKt.getMkissaCryptoConfig((Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.Anichi.AnichiUtilsKt$loadCustomExtractor$1 */
    /* JADX INFO: compiled from: AnichiUtils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.Anichi.AnichiUtilsKt", f = "AnichiUtils.kt", i = {0, 0, 0, 0, 0, 0}, l = {332}, m = "loadCustomExtractor", n = {"name", "url", "referer", "subtitleCallback", "callback", "quality"}, nl = {351}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00291 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00291(Continuation<? super C00291> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AnichiUtilsKt.loadCustomExtractor(null, null, null, null, null, null, (Continuation) this);
        }
    }

    @Nullable
    public static final MetaAnimeData parseAnimeData(@NotNull String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return (MetaAnimeData) objectMapper.readValue(jsonString, MetaAnimeData.class);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x01f7 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x018f  */
    /* JADX WARN: Code duplicated, block: B:51:0x0195 A[ADDED_TO_REGION, REMOVE, RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x0196  */
    /* JADX WARN: Code duplicated, block: B:60:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:66:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:68:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:71:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:78:0x01df  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:81:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:99:0x01d5 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    @Nullable
    public static final Object fetchTmdbLogoUrl(@NotNull String tmdbAPI, @NotNull String apiKey, @NotNull TvType type, @Nullable Integer tmdbId, @Nullable String appLangCode, @NotNull Continuation<? super String> continuation) {
        C00251 c00251;
        String appLang;
        Object obj;
        boolean z;
        String url;
        String strSubstringBefore$default;
        Object obj2;
        Object obj3;
        JSONObject json;
        JSONArray logos;
        String str;
        int i;
        int length;
        JSONObject logo;
        int i2;
        int length2;
        JSONObject logo2;
        if (continuation instanceof C00251) {
            c00251 = (C00251) continuation;
            if ((c00251.label & Integer.MIN_VALUE) != 0) {
                c00251.label -= Integer.MIN_VALUE;
            } else {
                c00251 = new C00251(continuation);
            }
        } else {
            c00251 = new C00251(continuation);
        }
        C00251 c00252 = c00251;
        Object $result = c00252.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00252.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (tmdbId == null) {
                    return null;
                }
                if (appLangCode == null || (strSubstringBefore$default = StringsKt.substringBefore$default(appLangCode, "-", (String) null, 2, (Object) null)) == null) {
                    appLang = null;
                } else {
                    appLang = strSubstringBefore$default.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(appLang, "toLowerCase(...)");
                }
                String url2 = type == TvType.Movie ? tmdbAPI + "/movie/" + tmdbId.intValue() + "/images?api_key=" + apiKey : tmdbAPI + "/tv/" + tmdbId.intValue() + "/images?api_key=" + apiKey;
                try {
                    Result.Companion companion = Result.Companion;
                    Requests app = MainActivityKt.getApp();
                    c00252.L$0 = SpillingKt.nullOutSpilledVariable(tmdbAPI);
                    c00252.L$1 = SpillingKt.nullOutSpilledVariable(apiKey);
                    c00252.L$2 = SpillingKt.nullOutSpilledVariable(type);
                    c00252.L$3 = SpillingKt.nullOutSpilledVariable(tmdbId);
                    c00252.L$4 = SpillingKt.nullOutSpilledVariable(appLangCode);
                    c00252.L$5 = appLang;
                    c00252.L$6 = SpillingKt.nullOutSpilledVariable(url2);
                    c00252.label = 1;
                    String appLang2 = appLang;
                    z = true;
                    obj = null;
                    try {
                        Object obj4 = Requests.get$default(app, url2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00252, 4094, (Object) null);
                        if (obj4 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url = appLang2;
                        $result = obj4;
                        try {
                            obj2 = Result.constructor-impl(new JSONObject(((NiceResponse) $result).getText()));
                            break;
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion2 = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        obj3 = obj2;
                        if (Result.isFailure-impl(obj3)) {
                            obj3 = obj;
                        }
                        json = (JSONObject) obj3;
                        if (json != null || (logos = json.optJSONArray("logos")) == null || logos.length() == 0) {
                            return obj;
                        }
                        str = url;
                        if (str != null && !StringsKt.isBlank(str)) {
                            z = false;
                        }
                        if (!z) {
                            length2 = logos.length();
                            for (i2 = 0; i2 < length2; i2++) {
                                logo2 = logos.optJSONObject(i2);
                                if (logo2 != null && Intrinsics.areEqual(logo2.optString("iso_639_1"), url)) {
                                    return fetchTmdbLogoUrl$logoUrlAt(logos, i2);
                                }
                            }
                        }
                        length = logos.length();
                        for (i = 0; i < length; i++) {
                            logo = logos.optJSONObject(i);
                            if (logo != null && Intrinsics.areEqual(logo.optString("iso_639_1"), "en")) {
                                return fetchTmdbLogoUrl$logoUrlAt(logos, i);
                            }
                        }
                        return fetchTmdbLogoUrl$logoUrlAt(logos, 0);
                    } catch (Throwable th2) {
                        th = th2;
                        url = appLang2;
                        Result.Companion companion3 = Result.Companion;
                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                        obj3 = obj2;
                        if (Result.isFailure-impl(obj3)) {
                            obj3 = obj;
                        }
                        json = (JSONObject) obj3;
                        if (json != null) {
                            return obj;
                        }
                        str = url;
                        if (str != null) {
                            z = false;
                        }
                        if (!z) {
                            length2 = logos.length();
                            while (i2 < length2) {
                                logo2 = logos.optJSONObject(i2);
                                if (logo2 != null) {
                                    return fetchTmdbLogoUrl$logoUrlAt(logos, i2);
                                }
                            }
                        }
                        length = logos.length();
                        while (i < length) {
                            logo = logos.optJSONObject(i);
                            if (logo != null) {
                                return fetchTmdbLogoUrl$logoUrlAt(logos, i);
                            }
                        }
                        return fetchTmdbLogoUrl$logoUrlAt(logos, 0);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    obj = null;
                    z = true;
                    url = appLang;
                }
                break;
            case 1:
                url = (String) c00252.L$5;
                try {
                    ResultKt.throwOnFailure($result);
                    obj = null;
                    z = true;
                    obj2 = Result.constructor-impl(new JSONObject(((NiceResponse) $result).getText()));
                    break;
                } catch (Throwable th4) {
                    th = th4;
                    obj = null;
                    z = true;
                    Result.Companion companion4 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                    obj3 = obj2;
                    if (Result.isFailure-impl(obj3)) {
                        obj3 = obj;
                    }
                    json = (JSONObject) obj3;
                    if (json != null) {
                        return obj;
                    }
                    str = url;
                    if (str != null) {
                        z = false;
                    }
                    if (!z) {
                        length2 = logos.length();
                        while (i2 < length2) {
                            logo2 = logos.optJSONObject(i2);
                            if (logo2 != null) {
                                return fetchTmdbLogoUrl$logoUrlAt(logos, i2);
                            }
                        }
                    }
                    length = logos.length();
                    while (i < length) {
                        logo = logos.optJSONObject(i);
                        if (logo != null) {
                            return fetchTmdbLogoUrl$logoUrlAt(logos, i);
                        }
                    }
                    return fetchTmdbLogoUrl$logoUrlAt(logos, 0);
                }
                obj3 = obj2;
                if (Result.isFailure-impl(obj3)) {
                    obj3 = obj;
                }
                json = (JSONObject) obj3;
                if (json != null) {
                    return obj;
                }
                str = url;
                if (str != null) {
                    z = false;
                }
                if (!z) {
                    length2 = logos.length();
                    while (i2 < length2) {
                        logo2 = logos.optJSONObject(i2);
                        if (logo2 != null) {
                            return fetchTmdbLogoUrl$logoUrlAt(logos, i2);
                        }
                    }
                }
                length = logos.length();
                while (i < length) {
                    logo = logos.optJSONObject(i);
                    if (logo != null) {
                        return fetchTmdbLogoUrl$logoUrlAt(logos, i);
                    }
                }
                return fetchTmdbLogoUrl$logoUrlAt(logos, 0);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private static final String fetchTmdbLogoUrl$logoUrlAt(JSONArray logos, int i) {
        return "https://image.tmdb.org/t/p/w500" + logos.getJSONObject(i).optString("file_path");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Nullable
    public static final Object anilistAPICall(@NotNull String query, @NotNull Continuation<? super AnilistAPIResponse> continuation) throws Exception {
        C00231 c00231;
        Object safe;
        if (continuation instanceof C00231) {
            c00231 = (C00231) continuation;
            if ((c00231.label & Integer.MIN_VALUE) != 0) {
                c00231.label -= Integer.MIN_VALUE;
            } else {
                c00231 = new C00231(continuation);
            }
        } else {
            c00231 = new C00231(continuation);
        }
        C00231 c00232 = c00231;
        Object $result = c00232.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00232.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Map data = MapsKt.mapOf(TuplesKt.to("query", query));
                Requests app = MainActivityKt.getApp();
                String str = apiUrl;
                Map<String, String> map = headerJSON;
                c00232.L$0 = SpillingKt.nullOutSpilledVariable(query);
                c00232.L$1 = SpillingKt.nullOutSpilledVariable(data);
                c00232.label = 1;
                $result = Requests.post$default(app, str, map, (String) null, (Map) null, (Map) null, data, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00232, 65500, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        NiceResponse test = (NiceResponse) $result;
        try {
            ResponseParser parser = test.getParser();
            Intrinsics.checkNotNull(parser);
            safe = parser.parseSafe(test.getText(), Reflection.getOrCreateKotlinClass(AnilistAPIResponse.class));
        } catch (Exception e$iv) {
            e$iv.printStackTrace();
            safe = null;
        }
        AnilistAPIResponse res = (AnilistAPIResponse) safe;
        if (res == null) {
            throw new Exception("Unable to fetch or parse Anilist api response");
        }
        return res;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public static final Object loadCustomExtractor(@Nullable final String name, @NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull final Function1<? super ExtractorLink, Unit> function2, @Nullable final Integer quality, @NotNull Continuation<? super Unit> continuation) {
        C00291 c00291;
        if (continuation instanceof C00291) {
            c00291 = (C00291) continuation;
            if ((c00291.label & Integer.MIN_VALUE) != 0) {
                c00291.label -= Integer.MIN_VALUE;
            } else {
                c00291 = new C00291(continuation);
            }
        } else {
            c00291 = new C00291(continuation);
        }
        Object $result = c00291.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00291.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function1 function3 = new Function1() { // from class: com.Anichi.AnichiUtilsKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        return AnichiUtilsKt.loadCustomExtractor$lambda$0(function2, name, quality, (ExtractorLink) obj);
                    }
                };
                c00291.L$0 = SpillingKt.nullOutSpilledVariable(name);
                c00291.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00291.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00291.L$3 = SpillingKt.nullOutSpilledVariable(function1);
                c00291.L$4 = SpillingKt.nullOutSpilledVariable(function2);
                c00291.L$5 = SpillingKt.nullOutSpilledVariable(quality);
                c00291.label = 1;
                if (ExtractorApiKt.loadExtractor(url, referer, function1, function3, c00291) == coroutine_suspended) {
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

    public static /* synthetic */ Object loadCustomExtractor$default(String str, String str2, String str3, Function1 function1, Function1 function2, Integer num, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 32) != 0) {
            num = null;
        }
        return loadCustomExtractor(str, str2, str3, function1, function2, num, continuation);
    }

    static final Unit loadCustomExtractor$lambda$0(Function1 $callback, String $name, Integer $quality, ExtractorLink link) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new AnichiUtilsKt$loadCustomExtractor$2$1($callback, $name, link, $quality, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    @Nullable
    public static final String getMkissaBuildId() {
        return mkissaBuildId;
    }

    public static final void setMkissaBuildId(@Nullable String str) {
        mkissaBuildId = str;
    }

    @Nullable
    public static final byte[] getMkissaKeyMask() {
        return mkissaKeyMask;
    }

    public static final void setMkissaKeyMask(@Nullable byte[] bArr) {
        mkissaKeyMask = bArr;
    }

    @Nullable
    public static final byte[] getCapturedAesKeyFromWebView() {
        return capturedAesKeyFromWebView;
    }

    public static final void setCapturedAesKeyFromWebView(@Nullable byte[] bArr) {
        capturedAesKeyFromWebView = bArr;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0349 A[Catch: Exception -> 0x038b, LOOP:2: B:100:0x0347->B:101:0x0349, LOOP_END, TryCatch #3 {Exception -> 0x038b, blocks: (B:64:0x027c, B:67:0x0288, B:69:0x02b4, B:70:0x02ba, B:72:0x02c2, B:94:0x02fb, B:97:0x0306, B:99:0x031c, B:101:0x0349, B:102:0x0368, B:96:0x0302, B:91:0x02ef), top: B:137:0x027c }] */
    /* JADX WARN: Code duplicated, block: B:104:0x037c  */
    /* JADX WARN: Code duplicated, block: B:109:0x0399  */
    /* JADX WARN: Code duplicated, block: B:150:0x031c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:154:0x02f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:155:0x02ed A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x01cf A[Catch: Exception -> 0x03c9, TRY_LEAVE, TryCatch #5 {Exception -> 0x03c9, blocks: (B:47:0x01c9, B:49:0x01cf), top: B:141:0x01c9 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x0238 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:54:0x0239  */
    /* JADX WARN: Code duplicated, block: B:59:0x0257 A[Catch: Exception -> 0x03ad, TryCatch #1 {Exception -> 0x03ad, blocks: (B:57:0x0251, B:59:0x0257, B:60:0x025f, B:62:0x0265), top: B:133:0x0251 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0265 A[Catch: Exception -> 0x03ad, TRY_LEAVE, TryCatch #1 {Exception -> 0x03ad, blocks: (B:57:0x0251, B:59:0x0257, B:60:0x025f, B:62:0x0265), top: B:133:0x0251 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0282  */
    /* JADX WARN: Code duplicated, block: B:67:0x0288 A[Catch: Exception -> 0x038b, TryCatch #3 {Exception -> 0x038b, blocks: (B:64:0x027c, B:67:0x0288, B:69:0x02b4, B:70:0x02ba, B:72:0x02c2, B:94:0x02fb, B:97:0x0306, B:99:0x031c, B:101:0x0349, B:102:0x0368, B:96:0x0302, B:91:0x02ef), top: B:137:0x027c }] */
    /* JADX WARN: Code duplicated, block: B:69:0x02b4 A[Catch: Exception -> 0x038b, TryCatch #3 {Exception -> 0x038b, blocks: (B:64:0x027c, B:67:0x0288, B:69:0x02b4, B:70:0x02ba, B:72:0x02c2, B:94:0x02fb, B:97:0x0306, B:99:0x031c, B:101:0x0349, B:102:0x0368, B:96:0x0302, B:91:0x02ef), top: B:137:0x027c }] */
    /* JADX WARN: Code duplicated, block: B:72:0x02c2 A[Catch: Exception -> 0x038b, TryCatch #3 {Exception -> 0x038b, blocks: (B:64:0x027c, B:67:0x0288, B:69:0x02b4, B:70:0x02ba, B:72:0x02c2, B:94:0x02fb, B:97:0x0306, B:99:0x031c, B:101:0x0349, B:102:0x0368, B:96:0x0302, B:91:0x02ef), top: B:137:0x027c }] */
    /* JADX WARN: Code duplicated, block: B:74:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:77:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:79:0x02da  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code duplicated, block: B:81:0x02de  */
    /* JADX WARN: Code duplicated, block: B:84:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:86:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:87:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:88:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:91:0x02ef A[Catch: Exception -> 0x038b, LOOP:1: B:70:0x02ba->B:91:0x02ef, LOOP_END, TryCatch #3 {Exception -> 0x038b, blocks: (B:64:0x027c, B:67:0x0288, B:69:0x02b4, B:70:0x02ba, B:72:0x02c2, B:94:0x02fb, B:97:0x0306, B:99:0x031c, B:101:0x0349, B:102:0x0368, B:96:0x0302, B:91:0x02ef), top: B:137:0x027c }] */
    /* JADX WARN: Code duplicated, block: B:94:0x02fb A[Catch: Exception -> 0x038b, TryCatch #3 {Exception -> 0x038b, blocks: (B:64:0x027c, B:67:0x0288, B:69:0x02b4, B:70:0x02ba, B:72:0x02c2, B:94:0x02fb, B:97:0x0306, B:99:0x031c, B:101:0x0349, B:102:0x0368, B:96:0x0302, B:91:0x02ef), top: B:137:0x027c }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0300  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0239 -> B:143:0x023c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object getMkissaCryptoConfig(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.String, byte[]>> r38) {
        /*
            Method dump skipped, instruction units count: 1034
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.Anichi.AnichiUtilsKt.getMkissaCryptoConfig(kotlin.coroutines.Continuation):java.lang.Object");
    }

    static final String getMkissaCryptoConfig$lambda$0(MatchResult it) {
        return (String) it.getGroupValues().get(1);
    }

    public static final void resetCryptoCache() {
        cachedCryptoKey = null;
        cachedEpoch = null;
        cachedSwitchAt = 0L;
        mkissaBuildId = null;
        mkissaKeyMask = null;
    }

    private static final long getFsEpoch() {
        long now = System.currentTimeMillis();
        long t = now / AA_EPOCH_MS;
        return (now - (AA_EPOCH_MS * t) >= AA_GRACE_MS || t <= 0) ? t : t - 1;
    }

    private static final long getBhEpoch() {
        return System.currentTimeMillis() / AA_EPOCH_MS;
    }

    private static final String makeBootToken(String buildId, byte[] keyMask, long epoch, String lane) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac it = Mac.getInstance("HmacSHA256");
        it.init(new SecretKeySpec(keyMask, "HmacSHA256"));
        byte[] inner = it.doFinal(StringsKt.encodeToByteArray("aa-boot:" + buildId));
        String payload = buildId + ":mkissa:mkissa.to:" + epoch + ':' + lane;
        Mac it2 = Mac.getInstance("HmacSHA256");
        it2.init(new SecretKeySpec(inner, "HmacSHA256"));
        byte[] token = it2.doFinal(StringsKt.encodeToByteArray(payload));
        return ArraysKt.joinToString$default(token, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.Anichi.AnichiUtilsKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return AnichiUtilsKt.makeBootToken$lambda$2(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    static final CharSequence makeBootToken$lambda$2(byte it) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:162:0x0241 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:182:0x027e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x010c  */
    /* JADX WARN: Code duplicated, block: B:42:0x01ae A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x01af  */
    /* JADX WARN: Code duplicated, block: B:47:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:48:0x01da  */
    /* JADX WARN: Code duplicated, block: B:68:0x023d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code duplicated, block: B:80:0x0277  */
    /* JADX WARN: Code duplicated, block: B:97:0x029e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:122:0x031d -> B:35:0x0106). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x01af -> B:158:0x01bf). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Object getCryptoMaterial(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Pair<byte[], java.lang.Integer>> r41) throws java.security.NoSuchAlgorithmException, java.security.InvalidKeyException {
        /*
            Method dump skipped, instruction units count: 952
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.Anichi.AnichiUtilsKt.getCryptoMaterial(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0068 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:26:0x0069 A[Catch: Exception -> 0x0136, TryCatch #2 {Exception -> 0x0136, blocks: (B:23:0x0064, B:26:0x0069, B:29:0x007e), top: B:54:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x007d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x007e A[Catch: Exception -> 0x0136, TRY_LEAVE, TryCatch #2 {Exception -> 0x0136, blocks: (B:23:0x0064, B:26:0x0069, B:29:0x007e), top: B:54:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00de A[Catch: Exception -> 0x0132, TRY_LEAVE, TryCatch #5 {Exception -> 0x0132, blocks: (B:31:0x0090, B:33:0x00de), top: B:60:0x0090 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0131 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Nullable
    public static final Object generateAaReq(@NotNull String queryHash, @NotNull String lane, @NotNull Continuation<? super String> continuation) {
        C00261 c00261;
        String lane2;
        Object obj;
        String queryHash2;
        Object cryptoMaterial;
        Pair material;
        byte[] key;
        int epoch;
        String buildId;
        byte[] iv;
        String body;
        if (continuation instanceof C00261) {
            c00261 = (C00261) continuation;
            if ((c00261.label & Integer.MIN_VALUE) != 0) {
                c00261.label -= Integer.MIN_VALUE;
            } else {
                c00261 = new C00261(continuation);
            }
        } else {
            c00261 = new C00261(continuation);
        }
        C00261 c00262 = c00261;
        Object $result = c00262.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00262.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                lane2 = queryHash;
                try {
                    c00262.L$0 = lane2;
                    queryHash2 = lane;
                    try {
                        c00262.L$1 = queryHash2;
                        c00262.label = 1;
                        cryptoMaterial = getCryptoMaterial(c00262);
                        if (cryptoMaterial == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        try {
                            material = (Pair) cryptoMaterial;
                            if (material == null) {
                                return null;
                            }
                            key = (byte[]) material.getFirst();
                            epoch = ((Number) material.getSecond()).intValue();
                            buildId = mkissaBuildId;
                            if (buildId == null) {
                                return null;
                            }
                            long timestamp = (System.currentTimeMillis() / 300000) * 300000;
                            iv = new byte[12];
                            obj = null;
                            try {
                                new SecureRandom().nextBytes(iv);
                                body = "{\"v\":1,\"ts\":" + timestamp + ",\"epoch\":" + epoch + ",\"buildId\":\"" + buildId + "\",\"qh\":\"" + lane2 + "\",\"k\":\"" + queryHash2 + "\"}";
                                if (key.length >= 32) {
                                    return null;
                                }
                                byte[] aesKey = ArraysKt.copyOfRange(key, 0, 32);
                                Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                                cipher.init(1, new SecretKeySpec(aesKey, "AES"), new GCMParameterSpec(128, iv));
                                byte[] encrypted = cipher.doFinal(StringsKt.encodeToByteArray(body));
                                byte[] result = new byte[iv.length + 1 + encrypted.length];
                                result[0] = 1;
                                try {
                                    System.arraycopy(iv, 0, result, 1, iv.length);
                                    System.arraycopy(encrypted, 0, result, iv.length + 1, encrypted.length);
                                    return MainAPIKt.base64Encode(result);
                                } catch (Exception e) {
                                    e = e;
                                }
                            } catch (Exception e2) {
                                e = e2;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            obj = null;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        obj = null;
                    }
                } catch (Exception e5) {
                    e = e5;
                    obj = null;
                }
                e.printStackTrace();
                return obj;
            case 1:
                String lane3 = (String) c00262.L$1;
                String queryHash3 = (String) c00262.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    queryHash2 = lane3;
                    lane2 = queryHash3;
                    cryptoMaterial = $result;
                    material = (Pair) cryptoMaterial;
                    if (material == null) {
                        return null;
                    }
                    key = (byte[]) material.getFirst();
                    epoch = ((Number) material.getSecond()).intValue();
                    buildId = mkissaBuildId;
                    if (buildId == null) {
                        return null;
                    }
                    long timestamp2 = (System.currentTimeMillis() / 300000) * 300000;
                    iv = new byte[12];
                    obj = null;
                    new SecureRandom().nextBytes(iv);
                    body = "{\"v\":1,\"ts\":" + timestamp2 + ",\"epoch\":" + epoch + ",\"buildId\":\"" + buildId + "\",\"qh\":\"" + lane2 + "\",\"k\":\"" + queryHash2 + "\"}";
                    if (key.length >= 32) {
                        return null;
                    }
                    byte[] aesKey2 = ArraysKt.copyOfRange(key, 0, 32);
                    Cipher cipher2 = Cipher.getInstance("AES/GCM/NoPadding");
                    cipher2.init(1, new SecretKeySpec(aesKey2, "AES"), new GCMParameterSpec(128, iv));
                    byte[] encrypted2 = cipher2.doFinal(StringsKt.encodeToByteArray(body));
                    byte[] result2 = new byte[iv.length + 1 + encrypted2.length];
                    result2[0] = 1;
                    System.arraycopy(iv, 0, result2, 1, iv.length);
                    System.arraycopy(encrypted2, 0, result2, iv.length + 1, encrypted2.length);
                    return MainAPIKt.base64Encode(result2);
                } catch (Exception e6) {
                    e = e6;
                    obj = null;
                }
                e.printStackTrace();
                return obj;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ Object generateAaReq$default(String str, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = AA_LANE;
        }
        return generateAaReq(str, str2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:38:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:40:0x0103 A[Catch: Exception -> 0x00f9, TryCatch #1 {Exception -> 0x00f9, blocks: (B:35:0x00e6, B:40:0x0103, B:43:0x0113, B:47:0x0129, B:49:0x0144, B:50:0x016e), top: B:65:0x00e6 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0124  */
    /* JADX WARN: Code duplicated, block: B:46:0x0127  */
    /* JADX WARN: Code duplicated, block: B:49:0x0144 A[Catch: Exception -> 0x00f9, TryCatch #1 {Exception -> 0x00f9, blocks: (B:35:0x00e6, B:40:0x0103, B:43:0x0113, B:47:0x0129, B:49:0x0144, B:50:0x016e), top: B:65:0x00e6 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x016e A[Catch: Exception -> 0x00f9, TRY_LEAVE, TryCatch #1 {Exception -> 0x00f9, blocks: (B:35:0x00e6, B:40:0x0103, B:43:0x0113, B:47:0x0129, B:49:0x0144, B:50:0x016e), top: B:65:0x00e6 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    @Nullable
    public static final Object decodeToBeParsed(@NotNull String encoded, @Nullable String mode, @NotNull Continuation<? super String> continuation) {
        C00241 c00241;
        byte[] iv;
        byte[] rawKey;
        byte[] ciphertext;
        Object obj;
        String str;
        Pair pair;
        if (continuation instanceof C00241) {
            c00241 = (C00241) continuation;
            if ((c00241.label & Integer.MIN_VALUE) != 0) {
                c00241.label -= Integer.MIN_VALUE;
            } else {
                c00241 = new C00241(continuation);
            }
        } else {
            c00241 = new C00241(continuation);
        }
        C00241 c00242 = c00241;
        Object $result = c00242.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Object obj2 = null;
        switch (c00242.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                try {
                    byte[] raw = MainAPIKt.base64DecodeArray(encoded);
                    Log.INSTANCE.d("Crypto", "decode raw size: " + raw.length);
                    if (raw.length == 0) {
                        return null;
                    }
                    if (raw[0] == 1) {
                        iv = ArraysKt.copyOfRange(raw, 1, 13);
                        byte[] ciphertext2 = ArraysKt.copyOfRange(raw, 13, raw.length);
                        Log.INSTANCE.d("Crypto", "GCM Mode - IV: " + iv.length + ", Ciphertext: " + ciphertext2.length);
                        rawKey = capturedAesKeyFromWebView;
                        if (rawKey == null) {
                            c00242.L$0 = SpillingKt.nullOutSpilledVariable(encoded);
                            c00242.L$1 = SpillingKt.nullOutSpilledVariable(mode);
                            c00242.L$2 = SpillingKt.nullOutSpilledVariable(raw);
                            c00242.L$3 = iv;
                            c00242.L$4 = ciphertext2;
                            c00242.label = 1;
                            Object cryptoMaterial = getCryptoMaterial(c00242);
                            if (cryptoMaterial == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj = cryptoMaterial;
                            ciphertext = ciphertext2;
                            pair = (Pair) obj;
                            if (pair != null) {
                                obj2 = null;
                                try {
                                    Log.INSTANCE.d("Crypto", "Using bootstrap-derived key (no WebView key cached)");
                                    rawKey = (byte[]) pair.getFirst();
                                } catch (Exception e) {
                                    e = e;
                                }
                            } else {
                                obj2 = null;
                                rawKey = null;
                            }
                            if (rawKey == null) {
                                Log.INSTANCE.e("Crypto", "No key available — WebView key not captured and getCryptoMaterial() failed");
                                return obj2;
                            }
                        } else {
                            obj2 = null;
                            ciphertext = ciphertext2;
                        }
                        Log log = Log.INSTANCE;
                        StringBuilder sbAppend = new StringBuilder().append("Key source: ");
                        if (capturedAesKeyFromWebView != null) {
                            str = "WebView";
                        } else {
                            str = "bootstrap";
                        }
                        log.d("Crypto", sbAppend.append(str).append(", length: ").append(rawKey.length).toString());
                        if (rawKey.length >= 32) {
                            Log.INSTANCE.e("Crypto", "Key too short for AES-256: " + rawKey.length + " bytes");
                            return obj2;
                        }
                        byte[] aesKey = ArraysKt.copyOfRange(rawKey, 0, 32);
                        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                        cipher.init(2, new SecretKeySpec(aesKey, "AES"), new GCMParameterSpec(128, iv));
                        return StringsKt.decodeToString(cipher.doFinal(ciphertext));
                    }
                    try {
                        Log.INSTANCE.d("Crypto", "CTR Mode decryption");
                        byte[] iv2 = ArraysKt.copyOfRange(raw, 1, 13);
                        byte[] ctr = new byte[16];
                        System.arraycopy(iv2, 0, ctr, 0, iv2.length);
                        ctr[15] = 2;
                        byte[] ciphertext3 = ArraysKt.copyOfRange(raw, 13, raw.length - 16);
                        byte[] key = MessageDigest.getInstance("SHA-256").digest(StringsKt.encodeToByteArray("Xot36i3lK3:v1"));
                        Cipher cipher2 = Cipher.getInstance("AES/CTR/NoPadding");
                        cipher2.init(2, new SecretKeySpec(key, "AES"), new IvParameterSpec(ctr));
                        return StringsKt.decodeToString(cipher2.doFinal(ciphertext3));
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                Log.INSTANCE.e("Crypto", "Decryption failed");
                e.printStackTrace();
                return obj2;
            case 1:
                ciphertext = (byte[]) c00242.L$4;
                iv = (byte[]) c00242.L$3;
                try {
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    pair = (Pair) obj;
                    if (pair != null) {
                        obj2 = null;
                        Log.INSTANCE.d("Crypto", "Using bootstrap-derived key (no WebView key cached)");
                        rawKey = (byte[]) pair.getFirst();
                    } else {
                        obj2 = null;
                        rawKey = null;
                    }
                    if (rawKey == null) {
                        Log.INSTANCE.e("Crypto", "No key available — WebView key not captured and getCryptoMaterial() failed");
                        return obj2;
                    }
                    Log log2 = Log.INSTANCE;
                    StringBuilder sbAppend2 = new StringBuilder().append("Key source: ");
                    if (capturedAesKeyFromWebView != null) {
                        str = "WebView";
                    } else {
                        str = "bootstrap";
                    }
                    log2.d("Crypto", sbAppend2.append(str).append(", length: ").append(rawKey.length).toString());
                    if (rawKey.length >= 32) {
                        Log.INSTANCE.e("Crypto", "Key too short for AES-256: " + rawKey.length + " bytes");
                        return obj2;
                    }
                    byte[] aesKey2 = ArraysKt.copyOfRange(rawKey, 0, 32);
                    Cipher cipher3 = Cipher.getInstance("AES/GCM/NoPadding");
                    cipher3.init(2, new SecretKeySpec(aesKey2, "AES"), new GCMParameterSpec(128, iv));
                    return StringsKt.decodeToString(cipher3.doFinal(ciphertext));
                } catch (Exception e4) {
                    e = e4;
                    obj2 = null;
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ Object decodeToBeParsed$default(String str, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return decodeToBeParsed(str, str2, continuation);
    }
}
