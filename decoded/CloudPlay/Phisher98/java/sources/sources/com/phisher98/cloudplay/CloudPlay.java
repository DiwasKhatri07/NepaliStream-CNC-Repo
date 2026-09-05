package com.phisher98.cloudplay;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.HomePageList;
import com.lagradost.cloudstream3.HomePageResponse;
import com.lagradost.cloudstream3.LiveSearchResponse;
import com.lagradost.cloudstream3.LiveStreamLoadResponse;
import com.lagradost.cloudstream3.LoadResponse;
import com.lagradost.cloudstream3.MainAPI;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.MainPageRequest;
import com.lagradost.cloudstream3.ParCollectionsKt;
import com.lagradost.cloudstream3.SearchResponse;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.TvType;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import com.lagradost.cloudstream3.utils.DrmExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
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

/* JADX INFO: compiled from: CloudPlayProvider.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/CloudPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0004NOPQB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0005H\u0002J\u001e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0096@¢\u0006\u0002\u0010'J.\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010\u0005H\u0082@¢\u0006\u0002\u0010.J&\u0010/\u001a\b\u0012\u0004\u0012\u0002000)2\u0006\u0010,\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010\u0005H\u0082@¢\u0006\u0002\u00101J\u0016\u00102\u001a\b\u0012\u0004\u0012\u0002030)2\u0006\u00104\u001a\u00020\u0005H\u0002J\u001c\u00105\u001a\b\u0012\u0004\u0012\u0002000)2\u0006\u00106\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00107J\u0016\u00108\u001a\u0002092\u0006\u0010,\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u00107J\f\u0010:\u001a\u00020\u0005*\u00020\u0005H\u0002J,\u0010;\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0014\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001cH\u0082@¢\u0006\u0002\u0010=J\u001e\u0010>\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u00101JF\u0010@\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u00112\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020F0D2\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020F0DH\u0096@¢\u0006\u0002\u0010IJ \u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00052\u0006\u0010M\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/phisher98/cloudplay/CloudPlay;", "Lcom/lagradost/cloudstream3/MainAPI;", "<init>", "()V", "lang", "", "getLang", "()Ljava/lang/String;", "setLang", "(Ljava/lang/String;)V", "mainUrl", "getMainUrl", "setMainUrl", "name", "getName", "setName", "hasMainPage", "", "getHasMainPage", "()Z", "hasChromecastSupport", "getHasChromecastSupport", "supportedTypes", "", "Lcom/lagradost/cloudstream3/TvType;", "getSupportedTypes", "()Ljava/util/Set;", "apiHeaders", "", "generateSign", "ts", "", "mainPhpUrl", "getMainPage", "Lcom/lagradost/cloudstream3/HomePageResponse;", "page", "", "request", "Lcom/lagradost/cloudstream3/MainPageRequest;", "(ILcom/lagradost/cloudstream3/MainPageRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchHomeSections", "", "Lcom/lagradost/cloudstream3/HomePageList;", "sectionName", "url", "fallbackLogo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchChannels", "Lcom/lagradost/cloudstream3/SearchResponse;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseM3u", "Lcom/phisher98/cloudplay/CloudPlay$CloudPlayChannel;", "m3uText", "search", "query", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Lcom/lagradost/cloudstream3/LoadResponse;", "hexToBase64Url", "getMpdStream", "customHeaders", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDRMKeysFromLicenseServer", "kid", "loadLinks", "data", "isCasting", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decryptPayload", "payloadBase64", "ivBase64", "tagBase64", "CloudPlayResponse", "CloudPlayStreams", "CloudPlayStream", "CloudPlayChannel", "CloudPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCloudPlayProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CloudPlayProvider.kt\ncom/phisher98/cloudplay/CloudPlay\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n+ 3 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 6 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,461:1\n73#2,5:462\n73#2,5:580\n63#3:467\n64#3,15:469\n63#3:491\n64#3,15:493\n63#3:514\n64#3,15:516\n63#3:538\n64#3,15:540\n63#3:561\n64#3,15:563\n63#3:585\n64#3,15:587\n63#3:607\n64#3,15:609\n63#3:630\n64#3,15:632\n63#3:651\n64#3,15:653\n1#4:468\n1#4:489\n1#4:492\n1#4:515\n1#4:536\n1#4:539\n1#4:562\n1#4:586\n1#4:608\n1#4:631\n1#4:652\n50#5:484\n43#5:485\n50#5:508\n43#5:509\n50#5:531\n43#5:532\n50#5:555\n43#5:556\n50#5:578\n43#5:579\n50#5:602\n43#5:603\n50#5:624\n43#5:625\n50#5:647\n43#5:648\n50#5:668\n43#5:669\n1739#6:486\n1814#6,2:487\n1816#6:490\n1739#6:510\n1814#6,3:511\n1739#6:533\n1814#6,2:534\n1816#6:537\n1739#6:557\n1814#6,3:558\n777#6:604\n873#6,2:605\n1739#6:626\n1814#6,3:627\n296#6,2:649\n*S KotlinDebug\n*F\n+ 1 CloudPlayProvider.kt\ncom/phisher98/cloudplay/CloudPlay\n*L\n65#1:462,5\n265#1:580,5\n69#1:467\n69#1:469,15\n108#1:491\n108#1:493,15\n123#1:514\n123#1:516,15\n162#1:538\n162#1:540,15\n177#1:561\n177#1:563,15\n268#1:585\n268#1:587,15\n278#1:607\n278#1:609,15\n317#1:630\n317#1:632,15\n332#1:651\n332#1:653,15\n69#1:468\n108#1:492\n123#1:515\n162#1:539\n177#1:562\n268#1:586\n278#1:608\n317#1:631\n332#1:652\n69#1:484\n69#1:485\n108#1:508\n108#1:509\n123#1:531\n123#1:532\n162#1:555\n162#1:556\n177#1:578\n177#1:579\n268#1:602\n268#1:603\n278#1:624\n278#1:625\n317#1:647\n317#1:648\n332#1:668\n332#1:669\n94#1:486\n94#1:487,2\n94#1:490\n110#1:510\n110#1:511,3\n151#1:533\n151#1:534,2\n151#1:537\n164#1:557\n164#1:558,3\n274#1:604\n274#1:605,2\n294#1:626\n294#1:627,3\n320#1:649,2\n*E\n"})
public final class CloudPlay extends MainAPI {

    @NotNull
    private String lang = "en";

    @NotNull
    private String mainUrl = MainAPIKt.base64Decode("aHR0cHM6Ly91cmwtbWFpbi5jcGx5OS53b3JrZXJzLmRldg==");

    @NotNull
    private String name = "CloudPlay";
    private final boolean hasMainPage = true;
    private final boolean hasChromecastSupport = true;

    @NotNull
    private final Set<TvType> supportedTypes = SetsKt.setOf(TvType.Live);

    @NotNull
    private final Map<String, String> apiHeaders = MapsKt.mapOf(new Pair[]{TuplesKt.to("Connection", "Keep-Alive"), TuplesKt.to("User-Agent", "okhttp/4.12.0"), TuplesKt.to("X-Package", MainAPIKt.base64Decode("Y29tLmNsb3VkcGxheS5hcHA="))});

    /* JADX INFO: renamed from: com.phisher98.cloudplay.CloudPlay$fetchChannels$1 */
    /* JADX INFO: compiled from: CloudPlayProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.cloudplay.CloudPlay", f = "CloudPlayProvider.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {146, 179}, m = "fetchChannels", n = {"url", "fallbackLogo", "shows", "headers", "isHost", "url", "fallbackLogo", "shows", "headers", "resText", "subStreams", "isHost"}, nl = {147, 181}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0"}, v = 2)
    static final class C00001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00001(Continuation<? super C00001> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CloudPlay.this.fetchChannels(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.cloudplay.CloudPlay$fetchHomeSections$1 */
    /* JADX INFO: compiled from: CloudPlayProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.cloudplay.CloudPlay", f = "CloudPlayProvider.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {89, 126}, m = "fetchHomeSections", n = {"sectionName", "url", "fallbackLogo", "headers", "isHost", "sectionName", "url", "fallbackLogo", "headers", "resText", "subStreams", "sections", "isHost"}, nl = {90, 134}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0"}, v = 2)
    static final class C00011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C00011(Continuation<? super C00011> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CloudPlay.this.fetchHomeSections(null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.cloudplay.CloudPlay$getDRMKeysFromLicenseServer$1 */
    /* JADX INFO: compiled from: CloudPlayProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.cloudplay.CloudPlay", f = "CloudPlayProvider.kt", i = {0, 0, 0}, l = {307}, m = "getDRMKeysFromLicenseServer", n = {"url", "kid", "userAgent"}, nl = {314}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C00031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00031(Continuation<? super C00031> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CloudPlay.this.getDRMKeysFromLicenseServer(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.cloudplay.CloudPlay$getMainPage$1 */
    /* JADX INFO: compiled from: CloudPlayProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.cloudplay.CloudPlay", f = "CloudPlayProvider.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {64, 72}, m = "getMainPage", n = {"request", "page", "request", "req", "res", "decryptedJson", "streams", "homePageLists", "page"}, nl = {65, 77}, s = {"L$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0"}, v = 2)
    static final class C00041 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00041(Continuation<? super C00041> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CloudPlay.this.getMainPage(0, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.cloudplay.CloudPlay$getMpdStream$1 */
    /* JADX INFO: compiled from: CloudPlayProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.cloudplay.CloudPlay", f = "CloudPlayProvider.kt", i = {0, 0}, l = {302}, m = "getMpdStream", n = {"url", "customHeaders"}, nl = {-1}, s = {"L$0", "L$1"}, v = 2)
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
            return CloudPlay.this.getMpdStream(null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.cloudplay.CloudPlay$loadLinks$1 */
    /* JADX INFO: compiled from: CloudPlayProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.cloudplay.CloudPlay", f = "CloudPlayProvider.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {342, 347, 351, 381}, m = "loadLinks", n = {"data", "subtitleCallback", "callback", "channel", "licenseUrl", "keyStr", "kidStr", "isCasting", "data", "subtitleCallback", "callback", "channel", "licenseUrl", "keyStr", "kidStr", "mpdStr", "regex", "matchResult", "drmKid", "isCasting", "data", "subtitleCallback", "callback", "channel", "licenseUrl", "keyStr", "kidStr", "isCasting", "data", "subtitleCallback", "callback", "channel", "isCasting", "isTs"}, nl = {343, 350, 350, 380}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1"}, v = 2)
    static final class C00081 extends ContinuationImpl {
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
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        C00081(Continuation<? super C00081> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CloudPlay.this.loadLinks(null, false, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.cloudplay.CloudPlay$search$1 */
    /* JADX INFO: compiled from: CloudPlayProvider.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.cloudplay.CloudPlay", f = "CloudPlayProvider.kt", i = {0, 1, 1, 1, 1}, l = {264, 270}, m = "search", n = {"query", "query", "res", "decryptedJson", "streams"}, nl = {265, 272}, s = {"L$0", "L$0", "L$1", "L$2", "L$3"}, v = 2)
    static final class C00111 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C00111(Continuation<? super C00111> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CloudPlay.this.search(null, (Continuation) this);
        }
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

    public boolean getHasChromecastSupport() {
        return this.hasChromecastSupport;
    }

    @NotNull
    public Set<TvType> getSupportedTypes() {
        return this.supportedTypes;
    }

    private final String generateSign(long ts) throws NoSuchAlgorithmException, InvalidKeyException {
        String key = MainAPIKt.base64Decode("amlvdHZwbHVz");
        Mac mac = Mac.getInstance("HmacSHA256");
        byte[] bytes = key.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        mac.init(new SecretKeySpec(bytes, "HmacSHA256"));
        byte[] bytes2 = String.valueOf(ts).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        return ArraysKt.joinToString$default(mac.doFinal(bytes2), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.cloudplay.CloudPlay$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return CloudPlay.generateSign$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    static final CharSequence generateSign$lambda$0(byte it) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private final String mainPhpUrl() throws NoSuchAlgorithmException, InvalidKeyException {
        long ts = System.currentTimeMillis() / 1000;
        String sign = generateSign(ts);
        return getMainUrl() + "/main.php?ts=" + ts + "&sign=" + sign;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:27:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:35:0x0120  */
    /* JADX WARN: Code duplicated, block: B:47:0x0158  */
    /* JADX WARN: Code duplicated, block: B:56:0x0174  */
    /* JADX WARN: Code duplicated, block: B:59:0x01ca A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:60:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:63:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:67:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x015f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getMainPage(int page, @NotNull MainPageRequest request, @NotNull Continuation<? super HomePageResponse> continuation) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        C00041 c00041;
        Object obj;
        MainPageRequest request2;
        Object obj2;
        int page2;
        NiceResponse req;
        Object safe;
        CloudPlayResponse res;
        String tag;
        String decryptedJson;
        Object obj3;
        int i;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        List<CloudPlayStream> streams;
        ArrayList homePageLists;
        C00052 c00052;
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
        switch (c00042.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                String strMainPhpUrl = mainPhpUrl();
                Map<String, String> map = this.apiHeaders;
                c00042.L$0 = SpillingKt.nullOutSpilledVariable(request);
                c00042.I$0 = page;
                c00042.label = 1;
                obj = coroutine_suspended;
                Object obj4 = Requests.get$default(app, strMainPhpUrl, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00042, 4092, (Object) null);
                c00042 = c00042;
                if (obj4 == obj) {
                    return obj;
                }
                request2 = request;
                obj2 = obj4;
                page2 = page;
                req = (NiceResponse) obj2;
                try {
                    ResponseParser parser = req.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(req.getText(), Reflection.getOrCreateKotlinClass(CloudPlayResponse.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                res = (CloudPlayResponse) safe;
                if (res != null) {
                    throw new Error("Failed to parse main.php. Text: " + req.getText());
                }
                String payload = res.getPayload();
                String iv = res.getIv();
                tag = res.getTag();
                if (tag == null) {
                    tag = "";
                }
                decryptedJson = decryptPayload(payload, iv, tag);
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(CloudPlayStreams.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    break;
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj3) == null) {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        i = 2;
                        try {
                            obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(CloudPlayStreams.class), (List) null, 2, (Object) null));
                        } catch (Throwable th2) {
                            th = th2;
                            Result.Companion companion4 = Result.Companion;
                            obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        i = 2;
                    }
                    break;
                } else {
                    i = 2;
                }
                if (Result.isFailure-impl(obj3)) {
                    obj3 = null;
                }
                deserializationStrategy = (KSerializer) obj3;
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, decryptedJson);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv.readValue(decryptedJson, new TypeReference<CloudPlayStreams>() { // from class: com.phisher98.cloudplay.CloudPlay$getMainPage$$inlined$parseJson$1
                        });
                    } catch (Throwable th4) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(decryptedJson, new TypeReference<CloudPlayStreams>() { // from class: com.phisher98.cloudplay.CloudPlay$getMainPage$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(decryptedJson, new TypeReference<CloudPlayStreams>() { // from class: com.phisher98.cloudplay.CloudPlay$getMainPage$$inlined$parseJson$1
                    });
                }
                streams = ((CloudPlayStreams) objDecodeFromString).getStreams();
                homePageLists = new ArrayList();
                c00052 = new C00052(homePageLists, null);
                c00042.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(req);
                c00042.L$2 = SpillingKt.nullOutSpilledVariable(res);
                c00042.L$3 = SpillingKt.nullOutSpilledVariable(decryptedJson);
                c00042.L$4 = SpillingKt.nullOutSpilledVariable(streams);
                c00042.L$5 = homePageLists;
                c00042.I$0 = page2;
                c00042.label = i;
                if (ParCollectionsKt.amap(streams, c00052, c00042) == obj) {
                    return obj;
                }
                return MainAPIKt.newHomePageResponse$default(homePageLists, (Boolean) null, i, (Object) null);
            case 1:
                int page3 = c00042.I$0;
                request2 = (MainPageRequest) c00042.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                page2 = page3;
                obj2 = $result;
                req = (NiceResponse) obj2;
                ResponseParser parser2 = req.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(req.getText(), Reflection.getOrCreateKotlinClass(CloudPlayResponse.class));
                res = (CloudPlayResponse) safe;
                if (res != null) {
                    throw new Error("Failed to parse main.php. Text: " + req.getText());
                }
                String payload2 = res.getPayload();
                String iv2 = res.getIv();
                tag = res.getTag();
                if (tag == null) {
                    tag = "";
                }
                decryptedJson = decryptPayload(payload2, iv2, tag);
                AppUtils appUtils2 = AppUtils.INSTANCE;
                Result.Companion companion5 = Result.Companion;
                KType kTypeTypeOf2 = Reflection.typeOf(CloudPlayStreams.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                if (Result.exceptionOrNull-impl(obj3) == null) {
                    Result.Companion companion6 = Result.Companion;
                    i = 2;
                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(CloudPlayStreams.class), (List) null, 2, (Object) null));
                    break;
                } else {
                    i = 2;
                }
                if (Result.isFailure-impl(obj3)) {
                    obj3 = null;
                }
                deserializationStrategy = (KSerializer) obj3;
                if (deserializationStrategy != null) {
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, decryptedJson);
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv4.readValue(decryptedJson, new TypeReference<CloudPlayStreams>() { // from class: com.phisher98.cloudplay.CloudPlay$getMainPage$$inlined$parseJson$1
                    });
                }
                streams = ((CloudPlayStreams) objDecodeFromString).getStreams();
                homePageLists = new ArrayList();
                c00052 = new C00052(homePageLists, null);
                c00042.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                c00042.L$1 = SpillingKt.nullOutSpilledVariable(req);
                c00042.L$2 = SpillingKt.nullOutSpilledVariable(res);
                c00042.L$3 = SpillingKt.nullOutSpilledVariable(decryptedJson);
                c00042.L$4 = SpillingKt.nullOutSpilledVariable(streams);
                c00042.L$5 = homePageLists;
                c00042.I$0 = page2;
                c00042.label = i;
                if (ParCollectionsKt.amap(streams, c00052, c00042) == obj) {
                    return obj;
                }
                return MainAPIKt.newHomePageResponse$default(homePageLists, (Boolean) null, i, (Object) null);
            case 2:
                int i2 = c00042.I$0;
                homePageLists = (List) c00042.L$5;
                ResultKt.throwOnFailure($result);
                i = 2;
                return MainAPIKt.newHomePageResponse$default(homePageLists, (Boolean) null, i, (Object) null);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.cloudplay.CloudPlay$getMainPage$2 */
    /* JADX INFO: compiled from: CloudPlayProvider.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "stream", "Lcom/phisher98/cloudplay/CloudPlay$CloudPlayStream;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.cloudplay.CloudPlay$getMainPage$2", f = "CloudPlayProvider.kt", i = {0}, l = {73}, m = "invokeSuspend", n = {"stream"}, nl = {74}, s = {"L$0"}, v = 2)
    static final class C00052 extends SuspendLambda implements Function2<CloudPlayStream, Continuation<? super Boolean>, Object> {
        final /* synthetic */ List<HomePageList> $homePageLists;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00052(List<HomePageList> list, Continuation<? super C00052> continuation) {
            super(2, continuation);
            this.$homePageLists = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00052 = CloudPlay.this.new C00052(this.$homePageLists, continuation);
            c00052.L$0 = obj;
            return c00052;
        }

        public final Object invoke(CloudPlayStream cloudPlayStream, Continuation<? super Boolean> continuation) {
            return create(cloudPlayStream, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object objFetchHomeSections;
            CloudPlayStream stream = (CloudPlayStream) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CloudPlay cloudPlay = CloudPlay.this;
                    String name = stream.getName();
                    if (name == null) {
                        name = "Unknown";
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(stream);
                    this.label = 1;
                    objFetchHomeSections = cloudPlay.fetchHomeSections(name, stream.getUrl(), stream.getLogo(), (Continuation) this);
                    if (objFetchHomeSections == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objFetchHomeSections = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List sections = (List) objFetchHomeSections;
            return Boxing.boxBoolean(this.$homePageLists.addAll(sections));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:103:0x02da A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:104:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:105:0x02df  */
    /* JADX WARN: Code duplicated, block: B:109:0x0327 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:120:0x0366  */
    /* JADX WARN: Code duplicated, block: B:133:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:145:0x03ca A[Catch: Exception -> 0x044e, TRY_ENTER, TryCatch #0 {Exception -> 0x044e, blocks: (B:112:0x032c, B:118:0x0360, B:131:0x03a0, B:134:0x03a7, B:146:0x03df, B:148:0x03eb, B:145:0x03ca, B:129:0x0395, B:117:0x0356, B:114:0x0331), top: B:167:0x032c, inners: #10 }] */
    /* JADX WARN: Code duplicated, block: B:148:0x03eb A[Catch: Exception -> 0x044e, TRY_LEAVE, TryCatch #0 {Exception -> 0x044e, blocks: (B:112:0x032c, B:118:0x0360, B:131:0x03a0, B:134:0x03a7, B:146:0x03df, B:148:0x03eb, B:145:0x03ca, B:129:0x0395, B:117:0x0356, B:114:0x0331), top: B:167:0x032c, inners: #10 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x0434 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:155:0x0435  */
    /* JADX WARN: Code duplicated, block: B:161:0x044a  */
    /* JADX WARN: Code duplicated, block: B:169:0x01d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x036d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x020f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x03ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:193:0x024d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:197:0x0182 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:201:0x02e1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:28:0x0114  */
    /* JADX WARN: Code duplicated, block: B:30:0x0119  */
    /* JADX WARN: Code duplicated, block: B:32:0x0127  */
    /* JADX WARN: Code duplicated, block: B:35:0x0147  */
    /* JADX WARN: Code duplicated, block: B:37:0x0157  */
    /* JADX WARN: Code duplicated, block: B:40:0x0161  */
    /* JADX WARN: Code duplicated, block: B:42:0x016f  */
    /* JADX WARN: Code duplicated, block: B:43:0x0172  */
    /* JADX WARN: Code duplicated, block: B:46:0x0177  */
    /* JADX WARN: Code duplicated, block: B:48:0x017b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x017d  */
    /* JADX WARN: Code duplicated, block: B:50:0x0180  */
    /* JADX WARN: Code duplicated, block: B:54:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:55:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:66:0x020c  */
    /* JADX WARN: Code duplicated, block: B:78:0x0246  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:88:0x0262 A[Catch: Exception -> 0x032a, TryCatch #1 {Exception -> 0x032a, blocks: (B:58:0x01d0, B:64:0x0206, B:76:0x0240, B:79:0x0247, B:89:0x027c, B:91:0x0287, B:93:0x0294, B:95:0x02a0, B:96:0x02b8, B:98:0x02be, B:101:0x02d2, B:106:0x02e1, B:107:0x0313, B:88:0x0262, B:87:0x025c, B:75:0x0236, B:63:0x01fc, B:82:0x024d, B:60:0x01d6), top: B:169:0x01d0, inners: #3, #13, #15 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0287 A[Catch: Exception -> 0x032a, TryCatch #1 {Exception -> 0x032a, blocks: (B:58:0x01d0, B:64:0x0206, B:76:0x0240, B:79:0x0247, B:89:0x027c, B:91:0x0287, B:93:0x0294, B:95:0x02a0, B:96:0x02b8, B:98:0x02be, B:101:0x02d2, B:106:0x02e1, B:107:0x0313, B:88:0x0262, B:87:0x025c, B:75:0x0236, B:63:0x01fc, B:82:0x024d, B:60:0x01d6), top: B:169:0x01d0, inners: #3, #13, #15 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x02be A[Catch: Exception -> 0x032a, TryCatch #1 {Exception -> 0x032a, blocks: (B:58:0x01d0, B:64:0x0206, B:76:0x0240, B:79:0x0247, B:89:0x027c, B:91:0x0287, B:93:0x0294, B:95:0x02a0, B:96:0x02b8, B:98:0x02be, B:101:0x02d2, B:106:0x02e1, B:107:0x0313, B:88:0x0262, B:87:0x025c, B:75:0x0236, B:63:0x01fc, B:82:0x024d, B:60:0x01d6), top: B:169:0x01d0, inners: #3, #13, #15 }] */
    public final Object fetchHomeSections(String sectionName, String url, String fallbackLogo, Continuation<? super List<HomePageList>> continuation) {
        C00011 c00011;
        Continuation $continuation;
        boolean z;
        int i;
        C00011 c00012;
        boolean isHost;
        Object obj;
        String sectionName2;
        String url2;
        String fallbackLogo2;
        Map<String, String> map;
        String resText;
        boolean isHost2;
        String resText2;
        String resText3;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        List subStreams;
        List sections;
        String fallbackLogo3;
        C00023 c00023;
        Object obj6;
        DeserializationStrategy deserializationStrategy2;
        Object objDecodeFromString2;
        List channels;
        List $this$map$iv;
        Collection destination$iv$iv;
        String name;
        String logo;
        Iterable $this$map$iv2;
        Collection destination$iv$iv2;
        String name2;
        String it;
        boolean z2;
        CloudPlay cloudPlay = this;
        if (continuation instanceof C00011) {
            c00011 = (C00011) continuation;
            if ((c00011.label & Integer.MIN_VALUE) != 0) {
                c00011.label -= Integer.MIN_VALUE;
            } else {
                c00011 = cloudPlay.new C00011(continuation);
            }
        } else {
            c00011 = cloudPlay.new C00011(continuation);
        }
        C00011 c00013 = c00011;
        Object $result = c00013.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00013.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                boolean isHost3 = StringsKt.contains$default(url, MainAPIKt.base64Decode("Y2xvdWRwbGF5"), false, 2, (Object) null);
                Map<String, String> mapEmptyMap = isHost3 ? cloudPlay.apiHeaders : MapsKt.emptyMap();
                Requests app = MainActivityKt.getApp();
                c00013.L$0 = sectionName;
                c00013.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00013.L$2 = fallbackLogo;
                c00013.L$3 = SpillingKt.nullOutSpilledVariable(mapEmptyMap);
                c00013.Z$0 = isHost3;
                c00013.label = 1;
                Map<String, String> map2 = mapEmptyMap;
                $continuation = null;
                z = false;
                i = 2;
                Object obj7 = Requests.get$default(app, url, map2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00013, 4092, (Object) null);
                c00012 = c00013;
                if (obj7 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                isHost = isHost3;
                obj = obj7;
                sectionName2 = sectionName;
                url2 = url;
                fallbackLogo2 = fallbackLogo;
                map = map2;
                resText = ((NiceResponse) obj).getText();
                if (StringsKt.isBlank(resText)) {
                    return CollectionsKt.emptyList();
                }
                if (StringsKt.startsWith$default(resText, "#EXTM3U", z, i, $continuation)) {
                    $this$map$iv2 = cloudPlay.parseM3u(resText);
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    for (Object item$iv$iv : $this$map$iv2) {
                        CloudPlayChannel channel = (CloudPlayChannel) item$iv$iv;
                        name2 = channel.getName();
                        if (name2 == null) {
                            name2 = "Unknown";
                        }
                        String channelName = name2;
                        it = channel.getLogo();
                        if (it == null) {
                            if (it.length() > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                it = null;
                            }
                            if (it == null) {
                                if (fallbackLogo2 == null) {
                                    it = "";
                                } else {
                                    it = fallbackLogo2;
                                }
                            }
                        } else if (fallbackLogo2 == null) {
                            it = "";
                        } else {
                            it = fallbackLogo2;
                        }
                        final String posterUrl = it;
                        destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(cloudPlay, channelName, AppUtils.INSTANCE.toJson(channel), TvType.Live, false, new Function1() { // from class: com.phisher98.cloudplay.CloudPlay$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj8) {
                                return CloudPlay.fetchHomeSections$lambda$0$1(posterUrl, (LiveSearchResponse) obj8);
                            }
                        }, 8, (Object) null));
                        cloudPlay = this;
                        $this$map$iv2 = $this$map$iv2;
                    }
                    List channels2 = (List) destination$iv$iv2;
                    return !channels2.isEmpty() ? CollectionsKt.listOf(new HomePageList(sectionName2, channels2, true)) : CollectionsKt.emptyList();
                }
                try {
                    AppUtils appUtils = AppUtils.INSTANCE;
                    try {
                        Result.Companion companion = Result.Companion;
                        KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(CloudPlayChannel.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj6 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (Result.exceptionOrNull-impl(obj6) == null) {
                        try {
                            Result.Companion companion3 = Result.Companion;
                            try {
                                obj6 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            } catch (Throwable th2) {
                                th = th2;
                                Result.Companion companion4 = Result.Companion;
                                obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        break;
                    }
                    if (Result.isFailure-impl(obj6)) {
                        obj6 = null;
                    }
                    deserializationStrategy2 = (KSerializer) obj6;
                    if (deserializationStrategy2 != null) {
                        try {
                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, resText);
                        } catch (SerializationException e) {
                            ArchComponentExtKt.logError(e);
                            ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv.readValue(resText, new TypeReference<List<? extends CloudPlayChannel>>() { // from class: com.phisher98.cloudplay.CloudPlay$fetchHomeSections$$inlined$parseJson$1
                            });
                        } catch (Throwable th4) {
                            ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv2.readValue(resText, new TypeReference<List<? extends CloudPlayChannel>>() { // from class: com.phisher98.cloudplay.CloudPlay$fetchHomeSections$$inlined$parseJson$1
                            });
                        }
                        channels = (List) objDecodeFromString2;
                        if (!channels.isEmpty() && (((CloudPlayChannel) channels.get(0)).getM3u8_url() != null || ((CloudPlayChannel) channels.get(0)).getMpd_url() != null)) {
                            $this$map$iv = channels;
                            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv2 : $this$map$iv) {
                                CloudPlayChannel channel2 = (CloudPlayChannel) item$iv$iv2;
                                name = channel2.getName();
                                if (name == null) {
                                    name = "Unknown";
                                }
                                String channelName2 = name;
                                logo = channel2.getLogo();
                                if (logo != null) {
                                    if (fallbackLogo2 == null) {
                                        logo = "";
                                    } else {
                                        logo = fallbackLogo2;
                                    }
                                }
                                final String posterUrl2 = logo;
                                destination$iv$iv.add(MainAPIKt.newLiveSearchResponse$default(this, channelName2, AppUtils.INSTANCE.toJson(channel2), TvType.Live, false, new Function1() { // from class: com.phisher98.cloudplay.CloudPlay$$ExternalSyntheticLambda4
                                    public final Object invoke(Object obj8) {
                                        return CloudPlay.fetchHomeSections$lambda$1$0(posterUrl2, (LiveSearchResponse) obj8);
                                    }
                                }, 8, (Object) null));
                                channels = channels;
                                $this$map$iv = $this$map$iv;
                            }
                            List shows = (List) destination$iv$iv;
                            return CollectionsKt.listOf(new HomePageList(sectionName2, shows, true));
                        }
                        try {
                            AppUtils appUtils2 = AppUtils.INSTANCE;
                            try {
                                Result.Companion companion5 = Result.Companion;
                                KType kTypeTypeOf2 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(CloudPlayStream.class)));
                                MagicApiIntrinsics.voidMagicApiCall((Object) r2);
                                obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                            } catch (Throwable th5) {
                                Result.Companion companion6 = Result.Companion;
                                obj2 = Result.constructor-impl(ResultKt.createFailure(th5));
                            }
                            if (Result.exceptionOrNull-impl(obj2) == null) {
                                obj3 = null;
                                obj5 = obj2;
                            } else {
                                try {
                                    Result.Companion companion7 = Result.Companion;
                                    obj3 = null;
                                    try {
                                        obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                                    } catch (Throwable th6) {
                                        th = th6;
                                        Result.Companion companion8 = Result.Companion;
                                        obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    obj3 = null;
                                }
                                obj5 = obj4;
                            }
                            if (Result.isFailure-impl(obj5)) {
                                obj5 = obj3;
                            }
                            deserializationStrategy = (KSerializer) obj5;
                            if (deserializationStrategy != null) {
                                try {
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, resText);
                                    break;
                                } catch (SerializationException e2) {
                                    try {
                                        ArchComponentExtKt.logError(e2);
                                        ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv3.readValue(resText, new TypeReference<List<? extends CloudPlayStream>>() { // from class: com.phisher98.cloudplay.CloudPlay$fetchHomeSections$$inlined$parseJson$2
                                        });
                                    } catch (Exception e3) {
                                        isHost2 = isHost;
                                        resText2 = resText;
                                        resText3 = fallbackLogo2;
                                    }
                                } catch (Throwable th8) {
                                    ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv4.readValue(resText, new TypeReference<List<? extends CloudPlayStream>>() { // from class: com.phisher98.cloudplay.CloudPlay$fetchHomeSections$$inlined$parseJson$2
                                    });
                                }
                                subStreams = (List) objDecodeFromString;
                                if (!subStreams.isEmpty()) {
                                    sections = new ArrayList();
                                    try {
                                        fallbackLogo3 = fallbackLogo2;
                                        String sectionName3 = sectionName2;
                                        try {
                                            c00023 = new C00023(sectionName3, fallbackLogo3, sections, null);
                                            c00012.L$0 = SpillingKt.nullOutSpilledVariable(sectionName3);
                                            c00012.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                                            c00012.L$2 = SpillingKt.nullOutSpilledVariable(fallbackLogo3);
                                            c00012.L$3 = SpillingKt.nullOutSpilledVariable(map);
                                            c00012.L$4 = SpillingKt.nullOutSpilledVariable(resText);
                                            c00012.L$5 = SpillingKt.nullOutSpilledVariable(subStreams);
                                            c00012.L$6 = sections;
                                            c00012.Z$0 = isHost;
                                            c00012.label = 2;
                                            if (ParCollectionsKt.amap(subStreams, c00023, c00012) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            return sections;
                                        } catch (Exception e4) {
                                            isHost2 = isHost;
                                            resText2 = resText;
                                            resText3 = fallbackLogo3;
                                        }
                                    } catch (Exception e5) {
                                        isHost2 = isHost;
                                        resText2 = resText;
                                        resText3 = fallbackLogo2;
                                    }
                                }
                            } else {
                                ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv5.readValue(resText, new TypeReference<List<? extends CloudPlayStream>>() { // from class: com.phisher98.cloudplay.CloudPlay$fetchHomeSections$$inlined$parseJson$2
                                });
                                subStreams = (List) objDecodeFromString;
                                if (!subStreams.isEmpty()) {
                                    sections = new ArrayList();
                                    fallbackLogo3 = fallbackLogo2;
                                    String sectionName4 = sectionName2;
                                    c00023 = new C00023(sectionName4, fallbackLogo3, sections, null);
                                    c00012.L$0 = SpillingKt.nullOutSpilledVariable(sectionName4);
                                    c00012.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                                    c00012.L$2 = SpillingKt.nullOutSpilledVariable(fallbackLogo3);
                                    c00012.L$3 = SpillingKt.nullOutSpilledVariable(map);
                                    c00012.L$4 = SpillingKt.nullOutSpilledVariable(resText);
                                    c00012.L$5 = SpillingKt.nullOutSpilledVariable(subStreams);
                                    c00012.L$6 = sections;
                                    c00012.Z$0 = isHost;
                                    c00012.label = 2;
                                    if (ParCollectionsKt.amap(subStreams, c00023, c00012) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    return sections;
                                }
                            }
                        } catch (Exception e6) {
                            isHost2 = isHost;
                            resText2 = resText;
                            resText3 = fallbackLogo2;
                        }
                        break;
                    } else {
                        ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                        objDecodeFromString2 = $this$readValue$iv$iv6.readValue(resText, new TypeReference<List<? extends CloudPlayChannel>>() { // from class: com.phisher98.cloudplay.CloudPlay$fetchHomeSections$$inlined$parseJson$1
                        });
                        channels = (List) objDecodeFromString2;
                        if (!channels.isEmpty()) {
                            $this$map$iv = channels;
                            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            while (r17.hasNext()) {
                                CloudPlayChannel channel3 = (CloudPlayChannel) item$iv$iv2;
                                name = channel3.getName();
                                if (name == null) {
                                    name = "Unknown";
                                }
                                String channelName3 = name;
                                logo = channel3.getLogo();
                                if (logo != null) {
                                    if (fallbackLogo2 == null) {
                                        logo = "";
                                    } else {
                                        logo = fallbackLogo2;
                                    }
                                }
                                final String posterUrl3 = logo;
                                destination$iv$iv.add(MainAPIKt.newLiveSearchResponse$default(this, channelName3, AppUtils.INSTANCE.toJson(channel3), TvType.Live, false, new Function1() { // from class: com.phisher98.cloudplay.CloudPlay$$ExternalSyntheticLambda4
                                    public final Object invoke(Object obj8) {
                                        return CloudPlay.fetchHomeSections$lambda$1$0(posterUrl3, (LiveSearchResponse) obj8);
                                    }
                                }, 8, (Object) null));
                                channels = channels;
                                $this$map$iv = $this$map$iv;
                            }
                            List shows2 = (List) destination$iv$iv;
                            return CollectionsKt.listOf(new HomePageList(sectionName2, shows2, true));
                        }
                        AppUtils appUtils3 = AppUtils.INSTANCE;
                        Result.Companion companion9 = Result.Companion;
                        KType kTypeTypeOf3 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(CloudPlayStream.class)));
                        MagicApiIntrinsics.voidMagicApiCall((Object) r2);
                        obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                        if (Result.exceptionOrNull-impl(obj2) == null) {
                            obj3 = null;
                            obj5 = obj2;
                        } else {
                            Result.Companion companion10 = Result.Companion;
                            obj3 = null;
                            obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            obj5 = obj4;
                        }
                        if (Result.isFailure-impl(obj5)) {
                            obj5 = obj3;
                        }
                        deserializationStrategy = (KSerializer) obj5;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, resText);
                            subStreams = (List) objDecodeFromString;
                            if (!subStreams.isEmpty()) {
                                sections = new ArrayList();
                                fallbackLogo3 = fallbackLogo2;
                                String sectionName5 = sectionName2;
                                c00023 = new C00023(sectionName5, fallbackLogo3, sections, null);
                                c00012.L$0 = SpillingKt.nullOutSpilledVariable(sectionName5);
                                c00012.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                                c00012.L$2 = SpillingKt.nullOutSpilledVariable(fallbackLogo3);
                                c00012.L$3 = SpillingKt.nullOutSpilledVariable(map);
                                c00012.L$4 = SpillingKt.nullOutSpilledVariable(resText);
                                c00012.L$5 = SpillingKt.nullOutSpilledVariable(subStreams);
                                c00012.L$6 = sections;
                                c00012.Z$0 = isHost;
                                c00012.label = 2;
                                if (ParCollectionsKt.amap(subStreams, c00023, c00012) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return sections;
                            }
                        } else {
                            ObjectMapper $this$readValue$iv$iv7 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv7.readValue(resText, new TypeReference<List<? extends CloudPlayStream>>() { // from class: com.phisher98.cloudplay.CloudPlay$fetchHomeSections$$inlined$parseJson$2
                            });
                            subStreams = (List) objDecodeFromString;
                            if (!subStreams.isEmpty()) {
                                sections = new ArrayList();
                                fallbackLogo3 = fallbackLogo2;
                                String sectionName6 = sectionName2;
                                c00023 = new C00023(sectionName6, fallbackLogo3, sections, null);
                                c00012.L$0 = SpillingKt.nullOutSpilledVariable(sectionName6);
                                c00012.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                                c00012.L$2 = SpillingKt.nullOutSpilledVariable(fallbackLogo3);
                                c00012.L$3 = SpillingKt.nullOutSpilledVariable(map);
                                c00012.L$4 = SpillingKt.nullOutSpilledVariable(resText);
                                c00012.L$5 = SpillingKt.nullOutSpilledVariable(subStreams);
                                c00012.L$6 = sections;
                                c00012.Z$0 = isHost;
                                c00012.label = 2;
                                if (ParCollectionsKt.amap(subStreams, c00023, c00012) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return sections;
                            }
                        }
                    }
                    break;
                } catch (Exception e7) {
                }
                return CollectionsKt.emptyList();
            case 1:
                boolean isHost4 = c00013.Z$0;
                map = (Map) c00013.L$3;
                fallbackLogo2 = (String) c00013.L$2;
                url2 = (String) c00013.L$1;
                sectionName2 = (String) c00013.L$0;
                ResultKt.throwOnFailure($result);
                isHost = isHost4;
                c00012 = c00013;
                obj = $result;
                $continuation = null;
                z = false;
                i = 2;
                resText = ((NiceResponse) obj).getText();
                if (StringsKt.isBlank(resText)) {
                    return CollectionsKt.emptyList();
                }
                if (StringsKt.startsWith$default(resText, "#EXTM3U", z, i, $continuation)) {
                    $this$map$iv2 = cloudPlay.parseM3u(resText);
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    while (r18.hasNext()) {
                        CloudPlayChannel channel4 = (CloudPlayChannel) item$iv$iv;
                        name2 = channel4.getName();
                        if (name2 == null) {
                            name2 = "Unknown";
                        }
                        String channelName4 = name2;
                        it = channel4.getLogo();
                        if (it == null) {
                            if (it.length() > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                it = null;
                            }
                            if (it == null) {
                                if (fallbackLogo2 == null) {
                                    it = "";
                                } else {
                                    it = fallbackLogo2;
                                }
                            }
                        } else if (fallbackLogo2 == null) {
                            it = "";
                        } else {
                            it = fallbackLogo2;
                        }
                        final String posterUrl4 = it;
                        destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(cloudPlay, channelName4, AppUtils.INSTANCE.toJson(channel4), TvType.Live, false, new Function1() { // from class: com.phisher98.cloudplay.CloudPlay$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj8) {
                                return CloudPlay.fetchHomeSections$lambda$0$1(posterUrl4, (LiveSearchResponse) obj8);
                            }
                        }, 8, (Object) null));
                        cloudPlay = this;
                        $this$map$iv2 = $this$map$iv2;
                    }
                    List channels3 = (List) destination$iv$iv2;
                    if (!channels3.isEmpty()) {
                    }
                }
                AppUtils appUtils4 = AppUtils.INSTANCE;
                Result.Companion companion11 = Result.Companion;
                KType kTypeTypeOf4 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(CloudPlayChannel.class)));
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj6 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                if (Result.exceptionOrNull-impl(obj6) == null) {
                    Result.Companion companion12 = Result.Companion;
                    obj6 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                    break;
                }
                if (Result.isFailure-impl(obj6)) {
                    obj6 = null;
                }
                deserializationStrategy2 = (KSerializer) obj6;
                if (deserializationStrategy2 != null) {
                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, resText);
                    channels = (List) objDecodeFromString2;
                    if (!channels.isEmpty()) {
                        $this$map$iv = channels;
                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        while (r17.hasNext()) {
                            CloudPlayChannel channel5 = (CloudPlayChannel) item$iv$iv2;
                            name = channel5.getName();
                            if (name == null) {
                                name = "Unknown";
                            }
                            String channelName5 = name;
                            logo = channel5.getLogo();
                            if (logo != null) {
                                if (fallbackLogo2 == null) {
                                    logo = "";
                                } else {
                                    logo = fallbackLogo2;
                                }
                            }
                            final String posterUrl5 = logo;
                            destination$iv$iv.add(MainAPIKt.newLiveSearchResponse$default(this, channelName5, AppUtils.INSTANCE.toJson(channel5), TvType.Live, false, new Function1() { // from class: com.phisher98.cloudplay.CloudPlay$$ExternalSyntheticLambda4
                                public final Object invoke(Object obj8) {
                                    return CloudPlay.fetchHomeSections$lambda$1$0(posterUrl5, (LiveSearchResponse) obj8);
                                }
                            }, 8, (Object) null));
                            channels = channels;
                            $this$map$iv = $this$map$iv;
                        }
                        List shows3 = (List) destination$iv$iv;
                        return CollectionsKt.listOf(new HomePageList(sectionName2, shows3, true));
                    }
                    AppUtils appUtils5 = AppUtils.INSTANCE;
                    Result.Companion companion13 = Result.Companion;
                    KType kTypeTypeOf5 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(CloudPlayStream.class)));
                    MagicApiIntrinsics.voidMagicApiCall((Object) r2);
                    obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                    if (Result.exceptionOrNull-impl(obj2) == null) {
                        obj3 = null;
                        obj5 = obj2;
                    } else {
                        Result.Companion companion14 = Result.Companion;
                        obj3 = null;
                        obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                        obj5 = obj4;
                    }
                    if (Result.isFailure-impl(obj5)) {
                        obj5 = obj3;
                    }
                    deserializationStrategy = (KSerializer) obj5;
                    if (deserializationStrategy != null) {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, resText);
                        subStreams = (List) objDecodeFromString;
                        if (!subStreams.isEmpty()) {
                            sections = new ArrayList();
                            fallbackLogo3 = fallbackLogo2;
                            String sectionName7 = sectionName2;
                            c00023 = new C00023(sectionName7, fallbackLogo3, sections, null);
                            c00012.L$0 = SpillingKt.nullOutSpilledVariable(sectionName7);
                            c00012.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                            c00012.L$2 = SpillingKt.nullOutSpilledVariable(fallbackLogo3);
                            c00012.L$3 = SpillingKt.nullOutSpilledVariable(map);
                            c00012.L$4 = SpillingKt.nullOutSpilledVariable(resText);
                            c00012.L$5 = SpillingKt.nullOutSpilledVariable(subStreams);
                            c00012.L$6 = sections;
                            c00012.Z$0 = isHost;
                            c00012.label = 2;
                            if (ParCollectionsKt.amap(subStreams, c00023, c00012) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return sections;
                        }
                    } else {
                        ObjectMapper $this$readValue$iv$iv8 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv8.readValue(resText, new TypeReference<List<? extends CloudPlayStream>>() { // from class: com.phisher98.cloudplay.CloudPlay$fetchHomeSections$$inlined$parseJson$2
                        });
                        subStreams = (List) objDecodeFromString;
                        if (!subStreams.isEmpty()) {
                            sections = new ArrayList();
                            fallbackLogo3 = fallbackLogo2;
                            String sectionName8 = sectionName2;
                            c00023 = new C00023(sectionName8, fallbackLogo3, sections, null);
                            c00012.L$0 = SpillingKt.nullOutSpilledVariable(sectionName8);
                            c00012.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                            c00012.L$2 = SpillingKt.nullOutSpilledVariable(fallbackLogo3);
                            c00012.L$3 = SpillingKt.nullOutSpilledVariable(map);
                            c00012.L$4 = SpillingKt.nullOutSpilledVariable(resText);
                            c00012.L$5 = SpillingKt.nullOutSpilledVariable(subStreams);
                            c00012.L$6 = sections;
                            c00012.Z$0 = isHost;
                            c00012.label = 2;
                            if (ParCollectionsKt.amap(subStreams, c00023, c00012) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return sections;
                        }
                    }
                } else {
                    ObjectMapper $this$readValue$iv$iv9 = MainAPIKt.getMapper();
                    objDecodeFromString2 = $this$readValue$iv$iv9.readValue(resText, new TypeReference<List<? extends CloudPlayChannel>>() { // from class: com.phisher98.cloudplay.CloudPlay$fetchHomeSections$$inlined$parseJson$1
                    });
                    channels = (List) objDecodeFromString2;
                    if (!channels.isEmpty()) {
                        $this$map$iv = channels;
                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        while (r17.hasNext()) {
                            CloudPlayChannel channel6 = (CloudPlayChannel) item$iv$iv2;
                            name = channel6.getName();
                            if (name == null) {
                                name = "Unknown";
                            }
                            String channelName6 = name;
                            logo = channel6.getLogo();
                            if (logo != null) {
                                if (fallbackLogo2 == null) {
                                    logo = "";
                                } else {
                                    logo = fallbackLogo2;
                                }
                            }
                            final String posterUrl6 = logo;
                            destination$iv$iv.add(MainAPIKt.newLiveSearchResponse$default(this, channelName6, AppUtils.INSTANCE.toJson(channel6), TvType.Live, false, new Function1() { // from class: com.phisher98.cloudplay.CloudPlay$$ExternalSyntheticLambda4
                                public final Object invoke(Object obj8) {
                                    return CloudPlay.fetchHomeSections$lambda$1$0(posterUrl6, (LiveSearchResponse) obj8);
                                }
                            }, 8, (Object) null));
                            channels = channels;
                            $this$map$iv = $this$map$iv;
                        }
                        List shows4 = (List) destination$iv$iv;
                        return CollectionsKt.listOf(new HomePageList(sectionName2, shows4, true));
                    }
                    AppUtils appUtils6 = AppUtils.INSTANCE;
                    Result.Companion companion15 = Result.Companion;
                    KType kTypeTypeOf6 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(CloudPlayStream.class)));
                    MagicApiIntrinsics.voidMagicApiCall((Object) r2);
                    obj2 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf6));
                    if (Result.exceptionOrNull-impl(obj2) == null) {
                        obj3 = null;
                        obj5 = obj2;
                    } else {
                        Result.Companion companion16 = Result.Companion;
                        obj3 = null;
                        obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                        obj5 = obj4;
                    }
                    if (Result.isFailure-impl(obj5)) {
                        obj5 = obj3;
                    }
                    deserializationStrategy = (KSerializer) obj5;
                    if (deserializationStrategy != null) {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, resText);
                        subStreams = (List) objDecodeFromString;
                        if (!subStreams.isEmpty()) {
                            sections = new ArrayList();
                            fallbackLogo3 = fallbackLogo2;
                            String sectionName9 = sectionName2;
                            c00023 = new C00023(sectionName9, fallbackLogo3, sections, null);
                            c00012.L$0 = SpillingKt.nullOutSpilledVariable(sectionName9);
                            c00012.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                            c00012.L$2 = SpillingKt.nullOutSpilledVariable(fallbackLogo3);
                            c00012.L$3 = SpillingKt.nullOutSpilledVariable(map);
                            c00012.L$4 = SpillingKt.nullOutSpilledVariable(resText);
                            c00012.L$5 = SpillingKt.nullOutSpilledVariable(subStreams);
                            c00012.L$6 = sections;
                            c00012.Z$0 = isHost;
                            c00012.label = 2;
                            if (ParCollectionsKt.amap(subStreams, c00023, c00012) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return sections;
                        }
                    } else {
                        ObjectMapper $this$readValue$iv$iv10 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv10.readValue(resText, new TypeReference<List<? extends CloudPlayStream>>() { // from class: com.phisher98.cloudplay.CloudPlay$fetchHomeSections$$inlined$parseJson$2
                        });
                        subStreams = (List) objDecodeFromString;
                        if (!subStreams.isEmpty()) {
                            sections = new ArrayList();
                            fallbackLogo3 = fallbackLogo2;
                            String sectionName10 = sectionName2;
                            c00023 = new C00023(sectionName10, fallbackLogo3, sections, null);
                            c00012.L$0 = SpillingKt.nullOutSpilledVariable(sectionName10);
                            c00012.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                            c00012.L$2 = SpillingKt.nullOutSpilledVariable(fallbackLogo3);
                            c00012.L$3 = SpillingKt.nullOutSpilledVariable(map);
                            c00012.L$4 = SpillingKt.nullOutSpilledVariable(resText);
                            c00012.L$5 = SpillingKt.nullOutSpilledVariable(subStreams);
                            c00012.L$6 = sections;
                            c00012.Z$0 = isHost;
                            c00012.label = 2;
                            if (ParCollectionsKt.amap(subStreams, c00023, c00012) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return sections;
                        }
                    }
                }
                return CollectionsKt.emptyList();
            case 2:
                isHost2 = c00013.Z$0;
                List sections2 = (List) c00013.L$6;
                resText2 = (String) c00013.L$4;
                resText3 = (String) c00013.L$2;
                try {
                    ResultKt.throwOnFailure($result);
                    return sections2;
                } catch (Exception e8) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit fetchHomeSections$lambda$0$1(String $posterUrl, LiveSearchResponse $this$newLiveSearchResponse) {
        $this$newLiveSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit fetchHomeSections$lambda$1$0(String $posterUrl, LiveSearchResponse $this$newLiveSearchResponse) {
        $this$newLiveSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.phisher98.cloudplay.CloudPlay$fetchHomeSections$3 */
    /* JADX INFO: compiled from: CloudPlayProvider.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "subStream", "Lcom/phisher98/cloudplay/CloudPlay$CloudPlayStream;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.cloudplay.CloudPlay$fetchHomeSections$3", f = "CloudPlayProvider.kt", i = {0}, l = {127}, m = "invokeSuspend", n = {"subStream"}, nl = {132}, s = {"L$0"}, v = 2)
    static final class C00023 extends SuspendLambda implements Function2<CloudPlayStream, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $fallbackLogo;
        final /* synthetic */ String $sectionName;
        final /* synthetic */ List<HomePageList> $sections;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00023(String str, String str2, List<HomePageList> list, Continuation<? super C00023> continuation) {
            super(2, continuation);
            this.$sectionName = str;
            this.$fallbackLogo = str2;
            this.$sections = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00023 = CloudPlay.this.new C00023(this.$sectionName, this.$fallbackLogo, this.$sections, continuation);
            c00023.L$0 = obj;
            return c00023;
        }

        public final Object invoke(CloudPlayStream cloudPlayStream, Continuation<? super Boolean> continuation) {
            return create(cloudPlayStream, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object objFetchHomeSections;
            CloudPlayStream subStream = (CloudPlayStream) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    CloudPlay cloudPlay = CloudPlay.this;
                    String name = subStream.getName();
                    if (name == null) {
                        name = this.$sectionName;
                    }
                    String url = subStream.getUrl();
                    String logo = subStream.getLogo();
                    if (logo == null) {
                        logo = this.$fallbackLogo;
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(subStream);
                    this.label = 1;
                    objFetchHomeSections = cloudPlay.fetchHomeSections(name, url, logo, (Continuation) this);
                    if (objFetchHomeSections == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    objFetchHomeSections = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List subSections = (List) objFetchHomeSections;
            return Boxing.boxBoolean(this.$sections.addAll(subSections));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:101:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:105:0x030c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:119:0x034e  */
    /* JADX WARN: Code duplicated, block: B:132:0x0386  */
    /* JADX WARN: Code duplicated, block: B:141:0x03a2 A[Catch: Exception -> 0x0411, TryCatch #7 {Exception -> 0x0411, blocks: (B:111:0x0315, B:117:0x0348, B:130:0x0380, B:133:0x0387, B:142:0x03b7, B:144:0x03c2, B:141:0x03a2, B:140:0x039c, B:128:0x0375, B:116:0x033e, B:113:0x031b, B:135:0x038d), top: B:167:0x0315, inners: #14, #15 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x03c2 A[Catch: Exception -> 0x0411, TRY_LEAVE, TryCatch #7 {Exception -> 0x0411, blocks: (B:111:0x0315, B:117:0x0348, B:130:0x0380, B:133:0x0387, B:142:0x03b7, B:144:0x03c2, B:141:0x03a2, B:140:0x039c, B:128:0x0375, B:116:0x033e, B:113:0x031b, B:135:0x038d), top: B:167:0x0315, inners: #14, #15 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x03f5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:147:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:152:0x040e  */
    /* JADX WARN: Code duplicated, block: B:161:0x0200 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x0352 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:179:0x038d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:0x023e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:0x018b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:189:0x02d1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:28:0x011d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x011e  */
    /* JADX WARN: Code duplicated, block: B:31:0x012d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0150  */
    /* JADX WARN: Code duplicated, block: B:36:0x0160  */
    /* JADX WARN: Code duplicated, block: B:39:0x016a  */
    /* JADX WARN: Code duplicated, block: B:41:0x0178  */
    /* JADX WARN: Code duplicated, block: B:42:0x017b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0180  */
    /* JADX WARN: Code duplicated, block: B:47:0x0184 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x0186  */
    /* JADX WARN: Code duplicated, block: B:49:0x0189  */
    /* JADX WARN: Code duplicated, block: B:53:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:62:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:74:0x0237  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:84:0x0253 A[Catch: Exception -> 0x030f, TryCatch #0 {Exception -> 0x030f, blocks: (B:72:0x0231, B:75:0x0238, B:85:0x026d, B:87:0x0278, B:89:0x0285, B:91:0x0291, B:92:0x02a8, B:94:0x02ae, B:97:0x02c2, B:102:0x02d1, B:103:0x0303, B:84:0x0253, B:83:0x024d, B:71:0x0227, B:78:0x023e), top: B:157:0x0227, inners: #11, #14 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x0278 A[Catch: Exception -> 0x030f, TryCatch #0 {Exception -> 0x030f, blocks: (B:72:0x0231, B:75:0x0238, B:85:0x026d, B:87:0x0278, B:89:0x0285, B:91:0x0291, B:92:0x02a8, B:94:0x02ae, B:97:0x02c2, B:102:0x02d1, B:103:0x0303, B:84:0x0253, B:83:0x024d, B:71:0x0227, B:78:0x023e), top: B:157:0x0227, inners: #11, #14 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x02ae A[Catch: Exception -> 0x030f, TryCatch #0 {Exception -> 0x030f, blocks: (B:72:0x0231, B:75:0x0238, B:85:0x026d, B:87:0x0278, B:89:0x0285, B:91:0x0291, B:92:0x02a8, B:94:0x02ae, B:97:0x02c2, B:102:0x02d1, B:103:0x0303, B:84:0x0253, B:83:0x024d, B:71:0x0227, B:78:0x023e), top: B:157:0x0227, inners: #11, #14 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:99:0x02ca A[DONT_INVERT] */
    public final Object fetchChannels(String url, String fallbackLogo, Continuation<? super List<? extends SearchResponse>> continuation) {
        C00001 c00001;
        Object obj;
        boolean z;
        int i;
        C00001 c00002;
        String url2;
        String fallbackLogo2;
        List shows;
        Object obj2;
        Map<String, String> map;
        boolean isHost;
        String resText;
        String resText2;
        boolean isHost2;
        String fallbackLogo3;
        String url3;
        String value$iv;
        Object obj3;
        Object obj4;
        Object obj5;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        List subStreams;
        Object objAmap;
        Object obj6;
        DeserializationStrategy deserializationStrategy2;
        Object objDecodeFromString2;
        List channels;
        List $this$map$iv;
        Collection destination$iv$iv;
        String name;
        String logo;
        List m3uChannels;
        Collection destination$iv$iv2;
        String name2;
        String it;
        boolean z2;
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
        C00001 c00003 = c00001;
        Object $result = c00003.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00003.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                List shows2 = new ArrayList();
                boolean isHost3 = StringsKt.contains$default(url, MainAPIKt.base64Decode("aG9zdC5jbG91ZHBsYXkubWU="), false, 2, (Object) null);
                Map<String, String> mapEmptyMap = isHost3 ? this.apiHeaders : MapsKt.emptyMap();
                Requests app = MainActivityKt.getApp();
                c00003.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c00003.L$1 = fallbackLogo;
                c00003.L$2 = shows2;
                c00003.L$3 = SpillingKt.nullOutSpilledVariable(mapEmptyMap);
                c00003.Z$0 = isHost3;
                c00003.label = 1;
                Map<String, String> map2 = mapEmptyMap;
                obj = coroutine_suspended;
                z = false;
                i = 2;
                Object obj7 = Requests.get$default(app, url, map2, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00003, 4092, (Object) null);
                c00002 = c00003;
                if (obj7 == obj) {
                    return obj;
                }
                url2 = url;
                fallbackLogo2 = fallbackLogo;
                shows = shows2;
                obj2 = obj7;
                map = map2;
                isHost = isHost3;
                resText = ((NiceResponse) obj2).getText();
                if (StringsKt.isBlank(resText)) {
                    return shows;
                }
                if (StringsKt.startsWith$default(resText, "#EXTM3U", z, i, (Object) null)) {
                    m3uChannels = parseM3u(resText);
                    List $this$map$iv2 = m3uChannels;
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                    for (Object item$iv$iv : $this$map$iv2) {
                        CloudPlayChannel channel = (CloudPlayChannel) item$iv$iv;
                        name2 = channel.getName();
                        if (name2 == null) {
                            name2 = "Unknown";
                        }
                        String channelName = name2;
                        it = channel.getLogo();
                        if (it == null) {
                            if (it.length() > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                it = null;
                            }
                            if (it == null) {
                                if (fallbackLogo2 == null) {
                                    it = "";
                                } else {
                                    it = fallbackLogo2;
                                }
                            }
                        } else if (fallbackLogo2 == null) {
                            it = "";
                        } else {
                            it = fallbackLogo2;
                        }
                        final String posterUrl = it;
                        destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, channelName, AppUtils.INSTANCE.toJson(channel), TvType.Live, false, new Function1() { // from class: com.phisher98.cloudplay.CloudPlay$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj8) {
                                return CloudPlay.fetchChannels$lambda$0$1(posterUrl, (LiveSearchResponse) obj8);
                            }
                        }, 8, (Object) null));
                        m3uChannels = m3uChannels;
                    }
                    return (List) destination$iv$iv2;
                }
                try {
                    AppUtils appUtils = AppUtils.INSTANCE;
                    try {
                        Result.Companion companion = Result.Companion;
                        KType kTypeTypeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(CloudPlayChannel.class)));
                        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                        obj6 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    if (Result.exceptionOrNull-impl(obj6) != null) {
                        resText2 = resText;
                    } else {
                        try {
                            Result.Companion companion3 = Result.Companion;
                            resText2 = resText;
                            try {
                                obj6 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                                break;
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    Result.Companion companion4 = Result.Companion;
                                    obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                                } catch (Exception e) {
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            resText2 = resText;
                        }
                    }
                    if (Result.isFailure-impl(obj6)) {
                        obj6 = null;
                    }
                    deserializationStrategy2 = (KSerializer) obj6;
                    if (deserializationStrategy2 != null) {
                        try {
                            objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, resText);
                        } catch (SerializationException e2) {
                            ArchComponentExtKt.logError(e2);
                            ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv.readValue(resText, new TypeReference<List<? extends CloudPlayChannel>>() { // from class: com.phisher98.cloudplay.CloudPlay$fetchChannels$$inlined$parseJson$1
                            });
                        } catch (Throwable th4) {
                            ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                            objDecodeFromString2 = $this$readValue$iv$iv2.readValue(resText, new TypeReference<List<? extends CloudPlayChannel>>() { // from class: com.phisher98.cloudplay.CloudPlay$fetchChannels$$inlined$parseJson$1
                            });
                        }
                        channels = (List) objDecodeFromString2;
                        if (!channels.isEmpty() && (((CloudPlayChannel) channels.get(0)).getM3u8_url() != null || ((CloudPlayChannel) channels.get(0)).getMpd_url() != null)) {
                            $this$map$iv = channels;
                            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv2 : $this$map$iv) {
                                CloudPlayChannel channel2 = (CloudPlayChannel) item$iv$iv2;
                                name = channel2.getName();
                                if (name == null) {
                                    name = "Unknown";
                                }
                                String channelName2 = name;
                                logo = channel2.getLogo();
                                if (logo != null) {
                                    if (fallbackLogo2 == null) {
                                        logo = "";
                                    } else {
                                        logo = fallbackLogo2;
                                    }
                                }
                                final String posterUrl2 = logo;
                                String data = AppUtils.INSTANCE.toJson(channel2);
                                destination$iv$iv.add(MainAPIKt.newLiveSearchResponse$default(this, channelName2, data, TvType.Live, false, new Function1() { // from class: com.phisher98.cloudplay.CloudPlay$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj8) {
                                        return CloudPlay.fetchChannels$lambda$1$0(posterUrl2, (LiveSearchResponse) obj8);
                                    }
                                }, 8, (Object) null));
                                channels = channels;
                                $this$map$iv = $this$map$iv;
                            }
                            return (List) destination$iv$iv;
                        }
                        try {
                            AppUtils appUtils2 = AppUtils.INSTANCE;
                            value$iv = resText2;
                            try {
                                Result.Companion companion5 = Result.Companion;
                                KType kTypeTypeOf2 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(CloudPlayStream.class)));
                                MagicApiIntrinsics.voidMagicApiCall((Object) r3);
                                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                            } catch (Throwable th5) {
                                Result.Companion companion6 = Result.Companion;
                                obj3 = Result.constructor-impl(ResultKt.createFailure(th5));
                            }
                            if (Result.exceptionOrNull-impl(obj3) == null) {
                                obj5 = obj3;
                            } else {
                                try {
                                    Result.Companion companion7 = Result.Companion;
                                    try {
                                        obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                                    } catch (Throwable th6) {
                                        th = th6;
                                        Result.Companion companion8 = Result.Companion;
                                        obj4 = Result.constructor-impl(ResultKt.createFailure(th));
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                }
                                obj5 = obj4;
                            }
                            if (Result.isFailure-impl(obj5)) {
                                obj5 = null;
                            }
                            deserializationStrategy = (KSerializer) obj5;
                            if (deserializationStrategy != null) {
                                try {
                                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                                } catch (SerializationException e3) {
                                    ArchComponentExtKt.logError(e3);
                                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv3.readValue(value$iv, new TypeReference<List<? extends CloudPlayStream>>() { // from class: com.phisher98.cloudplay.CloudPlay$fetchChannels$$inlined$parseJson$2
                                    });
                                } catch (Throwable th8) {
                                    ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                                    objDecodeFromString = $this$readValue$iv$iv4.readValue(value$iv, new TypeReference<List<? extends CloudPlayStream>>() { // from class: com.phisher98.cloudplay.CloudPlay$fetchChannels$$inlined$parseJson$2
                                    });
                                }
                                subStreams = (List) objDecodeFromString;
                                if (!subStreams.isEmpty()) {
                                    CloudPlay$fetchChannels$allShows$1 cloudPlay$fetchChannels$allShows$1 = new CloudPlay$fetchChannels$allShows$1(this, fallbackLogo2, null);
                                    c00002.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                    c00002.L$1 = SpillingKt.nullOutSpilledVariable(fallbackLogo2);
                                    c00002.L$2 = shows;
                                    c00002.L$3 = SpillingKt.nullOutSpilledVariable(map);
                                    c00002.L$4 = SpillingKt.nullOutSpilledVariable(resText2);
                                    c00002.L$5 = SpillingKt.nullOutSpilledVariable(subStreams);
                                    c00002.Z$0 = isHost;
                                    c00002.label = 2;
                                    objAmap = ParCollectionsKt.amap(subStreams, cloudPlay$fetchChannels$allShows$1, c00002);
                                    if (objAmap == obj) {
                                        return obj;
                                    }
                                    isHost2 = isHost;
                                    fallbackLogo3 = fallbackLogo2;
                                    url3 = url2;
                                    try {
                                        List allShows = CollectionsKt.flatten((Iterable) objAmap);
                                        shows.addAll(allShows);
                                    } catch (Exception e4) {
                                    }
                                }
                                break;
                            } else {
                                ObjectMapper $this$readValue$iv$iv5 = MainAPIKt.getMapper();
                                objDecodeFromString = $this$readValue$iv$iv5.readValue(value$iv, new TypeReference<List<? extends CloudPlayStream>>() { // from class: com.phisher98.cloudplay.CloudPlay$fetchChannels$$inlined$parseJson$2
                                });
                                subStreams = (List) objDecodeFromString;
                                if (!subStreams.isEmpty()) {
                                    CloudPlay$fetchChannels$allShows$1 cloudPlay$fetchChannels$allShows$2 = new CloudPlay$fetchChannels$allShows$1(this, fallbackLogo2, null);
                                    c00002.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                    c00002.L$1 = SpillingKt.nullOutSpilledVariable(fallbackLogo2);
                                    c00002.L$2 = shows;
                                    c00002.L$3 = SpillingKt.nullOutSpilledVariable(map);
                                    c00002.L$4 = SpillingKt.nullOutSpilledVariable(resText2);
                                    c00002.L$5 = SpillingKt.nullOutSpilledVariable(subStreams);
                                    c00002.Z$0 = isHost;
                                    c00002.label = 2;
                                    objAmap = ParCollectionsKt.amap(subStreams, cloudPlay$fetchChannels$allShows$2, c00002);
                                    if (objAmap == obj) {
                                        return obj;
                                    }
                                    isHost2 = isHost;
                                    fallbackLogo3 = fallbackLogo2;
                                    url3 = url2;
                                    List allShows2 = CollectionsKt.flatten((Iterable) objAmap);
                                    shows.addAll(allShows2);
                                }
                            }
                        } catch (Exception e5) {
                            isHost2 = isHost;
                            fallbackLogo3 = fallbackLogo2;
                            url3 = url2;
                            return shows;
                        }
                        break;
                    } else {
                        ObjectMapper $this$readValue$iv$iv6 = MainAPIKt.getMapper();
                        objDecodeFromString2 = $this$readValue$iv$iv6.readValue(resText, new TypeReference<List<? extends CloudPlayChannel>>() { // from class: com.phisher98.cloudplay.CloudPlay$fetchChannels$$inlined$parseJson$1
                        });
                        channels = (List) objDecodeFromString2;
                        if (!channels.isEmpty()) {
                            $this$map$iv = channels;
                            destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            while (r16.hasNext()) {
                                CloudPlayChannel channel3 = (CloudPlayChannel) item$iv$iv2;
                                name = channel3.getName();
                                if (name == null) {
                                    name = "Unknown";
                                }
                                String channelName3 = name;
                                logo = channel3.getLogo();
                                if (logo != null) {
                                    if (fallbackLogo2 == null) {
                                        logo = "";
                                    } else {
                                        logo = fallbackLogo2;
                                    }
                                }
                                final String posterUrl3 = logo;
                                String data2 = AppUtils.INSTANCE.toJson(channel3);
                                destination$iv$iv.add(MainAPIKt.newLiveSearchResponse$default(this, channelName3, data2, TvType.Live, false, new Function1() { // from class: com.phisher98.cloudplay.CloudPlay$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj8) {
                                        return CloudPlay.fetchChannels$lambda$1$0(posterUrl3, (LiveSearchResponse) obj8);
                                    }
                                }, 8, (Object) null));
                                channels = channels;
                                $this$map$iv = $this$map$iv;
                            }
                            return (List) destination$iv$iv;
                        }
                        AppUtils appUtils3 = AppUtils.INSTANCE;
                        value$iv = resText2;
                        Result.Companion companion9 = Result.Companion;
                        KType kTypeTypeOf3 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(CloudPlayStream.class)));
                        MagicApiIntrinsics.voidMagicApiCall((Object) r3);
                        obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf3));
                        if (Result.exceptionOrNull-impl(obj3) == null) {
                            obj5 = obj3;
                        } else {
                            Result.Companion companion10 = Result.Companion;
                            obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                            obj5 = obj4;
                        }
                        if (Result.isFailure-impl(obj5)) {
                            obj5 = null;
                        }
                        deserializationStrategy = (KSerializer) obj5;
                        if (deserializationStrategy != null) {
                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                            subStreams = (List) objDecodeFromString;
                            if (!subStreams.isEmpty()) {
                                CloudPlay$fetchChannels$allShows$1 cloudPlay$fetchChannels$allShows$3 = new CloudPlay$fetchChannels$allShows$1(this, fallbackLogo2, null);
                                c00002.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                c00002.L$1 = SpillingKt.nullOutSpilledVariable(fallbackLogo2);
                                c00002.L$2 = shows;
                                c00002.L$3 = SpillingKt.nullOutSpilledVariable(map);
                                c00002.L$4 = SpillingKt.nullOutSpilledVariable(resText2);
                                c00002.L$5 = SpillingKt.nullOutSpilledVariable(subStreams);
                                c00002.Z$0 = isHost;
                                c00002.label = 2;
                                objAmap = ParCollectionsKt.amap(subStreams, cloudPlay$fetchChannels$allShows$3, c00002);
                                if (objAmap == obj) {
                                    return obj;
                                }
                                isHost2 = isHost;
                                fallbackLogo3 = fallbackLogo2;
                                url3 = url2;
                                List allShows3 = CollectionsKt.flatten((Iterable) objAmap);
                                shows.addAll(allShows3);
                            }
                        } else {
                            ObjectMapper $this$readValue$iv$iv7 = MainAPIKt.getMapper();
                            objDecodeFromString = $this$readValue$iv$iv7.readValue(value$iv, new TypeReference<List<? extends CloudPlayStream>>() { // from class: com.phisher98.cloudplay.CloudPlay$fetchChannels$$inlined$parseJson$2
                            });
                            subStreams = (List) objDecodeFromString;
                            if (!subStreams.isEmpty()) {
                                CloudPlay$fetchChannels$allShows$1 cloudPlay$fetchChannels$allShows$4 = new CloudPlay$fetchChannels$allShows$1(this, fallbackLogo2, null);
                                c00002.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                c00002.L$1 = SpillingKt.nullOutSpilledVariable(fallbackLogo2);
                                c00002.L$2 = shows;
                                c00002.L$3 = SpillingKt.nullOutSpilledVariable(map);
                                c00002.L$4 = SpillingKt.nullOutSpilledVariable(resText2);
                                c00002.L$5 = SpillingKt.nullOutSpilledVariable(subStreams);
                                c00002.Z$0 = isHost;
                                c00002.label = 2;
                                objAmap = ParCollectionsKt.amap(subStreams, cloudPlay$fetchChannels$allShows$4, c00002);
                                if (objAmap == obj) {
                                    return obj;
                                }
                                isHost2 = isHost;
                                fallbackLogo3 = fallbackLogo2;
                                url3 = url2;
                                List allShows4 = CollectionsKt.flatten((Iterable) objAmap);
                                shows.addAll(allShows4);
                            }
                        }
                    }
                    break;
                } catch (Exception e6) {
                    resText2 = resText;
                }
                return shows;
            case 1:
                boolean isHost4 = c00003.Z$0;
                Map<String, String> map3 = (Map) c00003.L$3;
                List shows3 = (List) c00003.L$2;
                fallbackLogo2 = (String) c00003.L$1;
                url2 = (String) c00003.L$0;
                ResultKt.throwOnFailure($result);
                obj = coroutine_suspended;
                map = map3;
                shows = shows3;
                z = false;
                i = 2;
                c00002 = c00003;
                isHost = isHost4;
                obj2 = $result;
                resText = ((NiceResponse) obj2).getText();
                if (StringsKt.isBlank(resText)) {
                    return shows;
                }
                if (StringsKt.startsWith$default(resText, "#EXTM3U", z, i, (Object) null)) {
                    m3uChannels = parseM3u(resText);
                    List $this$map$iv3 = m3uChannels;
                    destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                    while (r17.hasNext()) {
                        CloudPlayChannel channel4 = (CloudPlayChannel) item$iv$iv;
                        name2 = channel4.getName();
                        if (name2 == null) {
                            name2 = "Unknown";
                        }
                        String channelName4 = name2;
                        it = channel4.getLogo();
                        if (it == null) {
                            if (it.length() > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                it = null;
                            }
                            if (it == null) {
                                if (fallbackLogo2 == null) {
                                    it = "";
                                } else {
                                    it = fallbackLogo2;
                                }
                            }
                        } else if (fallbackLogo2 == null) {
                            it = "";
                        } else {
                            it = fallbackLogo2;
                        }
                        final String posterUrl4 = it;
                        destination$iv$iv2.add(MainAPIKt.newLiveSearchResponse$default(this, channelName4, AppUtils.INSTANCE.toJson(channel4), TvType.Live, false, new Function1() { // from class: com.phisher98.cloudplay.CloudPlay$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj8) {
                                return CloudPlay.fetchChannels$lambda$0$1(posterUrl4, (LiveSearchResponse) obj8);
                            }
                        }, 8, (Object) null));
                        m3uChannels = m3uChannels;
                    }
                    return (List) destination$iv$iv2;
                }
                AppUtils appUtils4 = AppUtils.INSTANCE;
                Result.Companion companion11 = Result.Companion;
                KType kTypeTypeOf4 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(CloudPlayChannel.class)));
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj6 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf4));
                if (Result.exceptionOrNull-impl(obj6) != null) {
                    Result.Companion companion12 = Result.Companion;
                    resText2 = resText;
                    obj6 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                    break;
                } else {
                    resText2 = resText;
                }
                if (Result.isFailure-impl(obj6)) {
                    obj6 = null;
                }
                deserializationStrategy2 = (KSerializer) obj6;
                if (deserializationStrategy2 != null) {
                    objDecodeFromString2 = MainAPIKt.getJson().decodeFromString(deserializationStrategy2, resText);
                    channels = (List) objDecodeFromString2;
                    if (!channels.isEmpty()) {
                        $this$map$iv = channels;
                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        while (r16.hasNext()) {
                            CloudPlayChannel channel5 = (CloudPlayChannel) item$iv$iv2;
                            name = channel5.getName();
                            if (name == null) {
                                name = "Unknown";
                            }
                            String channelName5 = name;
                            logo = channel5.getLogo();
                            if (logo != null) {
                                if (fallbackLogo2 == null) {
                                    logo = "";
                                } else {
                                    logo = fallbackLogo2;
                                }
                            }
                            final String posterUrl5 = logo;
                            String data3 = AppUtils.INSTANCE.toJson(channel5);
                            destination$iv$iv.add(MainAPIKt.newLiveSearchResponse$default(this, channelName5, data3, TvType.Live, false, new Function1() { // from class: com.phisher98.cloudplay.CloudPlay$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj8) {
                                    return CloudPlay.fetchChannels$lambda$1$0(posterUrl5, (LiveSearchResponse) obj8);
                                }
                            }, 8, (Object) null));
                            channels = channels;
                            $this$map$iv = $this$map$iv;
                        }
                        return (List) destination$iv$iv;
                    }
                    AppUtils appUtils5 = AppUtils.INSTANCE;
                    value$iv = resText2;
                    Result.Companion companion13 = Result.Companion;
                    KType kTypeTypeOf5 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(CloudPlayStream.class)));
                    MagicApiIntrinsics.voidMagicApiCall((Object) r3);
                    obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf5));
                    if (Result.exceptionOrNull-impl(obj3) == null) {
                        obj5 = obj3;
                    } else {
                        Result.Companion companion14 = Result.Companion;
                        obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                        obj5 = obj4;
                    }
                    if (Result.isFailure-impl(obj5)) {
                        obj5 = null;
                    }
                    deserializationStrategy = (KSerializer) obj5;
                    if (deserializationStrategy != null) {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                        subStreams = (List) objDecodeFromString;
                        if (!subStreams.isEmpty()) {
                            CloudPlay$fetchChannels$allShows$1 cloudPlay$fetchChannels$allShows$5 = new CloudPlay$fetchChannels$allShows$1(this, fallbackLogo2, null);
                            c00002.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                            c00002.L$1 = SpillingKt.nullOutSpilledVariable(fallbackLogo2);
                            c00002.L$2 = shows;
                            c00002.L$3 = SpillingKt.nullOutSpilledVariable(map);
                            c00002.L$4 = SpillingKt.nullOutSpilledVariable(resText2);
                            c00002.L$5 = SpillingKt.nullOutSpilledVariable(subStreams);
                            c00002.Z$0 = isHost;
                            c00002.label = 2;
                            objAmap = ParCollectionsKt.amap(subStreams, cloudPlay$fetchChannels$allShows$5, c00002);
                            if (objAmap == obj) {
                                return obj;
                            }
                            isHost2 = isHost;
                            fallbackLogo3 = fallbackLogo2;
                            url3 = url2;
                            List allShows5 = CollectionsKt.flatten((Iterable) objAmap);
                            shows.addAll(allShows5);
                        }
                    } else {
                        ObjectMapper $this$readValue$iv$iv8 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv8.readValue(value$iv, new TypeReference<List<? extends CloudPlayStream>>() { // from class: com.phisher98.cloudplay.CloudPlay$fetchChannels$$inlined$parseJson$2
                        });
                        subStreams = (List) objDecodeFromString;
                        if (!subStreams.isEmpty()) {
                            CloudPlay$fetchChannels$allShows$1 cloudPlay$fetchChannels$allShows$6 = new CloudPlay$fetchChannels$allShows$1(this, fallbackLogo2, null);
                            c00002.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                            c00002.L$1 = SpillingKt.nullOutSpilledVariable(fallbackLogo2);
                            c00002.L$2 = shows;
                            c00002.L$3 = SpillingKt.nullOutSpilledVariable(map);
                            c00002.L$4 = SpillingKt.nullOutSpilledVariable(resText2);
                            c00002.L$5 = SpillingKt.nullOutSpilledVariable(subStreams);
                            c00002.Z$0 = isHost;
                            c00002.label = 2;
                            objAmap = ParCollectionsKt.amap(subStreams, cloudPlay$fetchChannels$allShows$6, c00002);
                            if (objAmap == obj) {
                                return obj;
                            }
                            isHost2 = isHost;
                            fallbackLogo3 = fallbackLogo2;
                            url3 = url2;
                            List allShows6 = CollectionsKt.flatten((Iterable) objAmap);
                            shows.addAll(allShows6);
                        }
                    }
                } else {
                    ObjectMapper $this$readValue$iv$iv9 = MainAPIKt.getMapper();
                    objDecodeFromString2 = $this$readValue$iv$iv9.readValue(resText, new TypeReference<List<? extends CloudPlayChannel>>() { // from class: com.phisher98.cloudplay.CloudPlay$fetchChannels$$inlined$parseJson$1
                    });
                    channels = (List) objDecodeFromString2;
                    if (!channels.isEmpty()) {
                        $this$map$iv = channels;
                        destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        while (r16.hasNext()) {
                            CloudPlayChannel channel6 = (CloudPlayChannel) item$iv$iv2;
                            name = channel6.getName();
                            if (name == null) {
                                name = "Unknown";
                            }
                            String channelName6 = name;
                            logo = channel6.getLogo();
                            if (logo != null) {
                                if (fallbackLogo2 == null) {
                                    logo = "";
                                } else {
                                    logo = fallbackLogo2;
                                }
                            }
                            final String posterUrl6 = logo;
                            String data4 = AppUtils.INSTANCE.toJson(channel6);
                            destination$iv$iv.add(MainAPIKt.newLiveSearchResponse$default(this, channelName6, data4, TvType.Live, false, new Function1() { // from class: com.phisher98.cloudplay.CloudPlay$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj8) {
                                    return CloudPlay.fetchChannels$lambda$1$0(posterUrl6, (LiveSearchResponse) obj8);
                                }
                            }, 8, (Object) null));
                            channels = channels;
                            $this$map$iv = $this$map$iv;
                        }
                        return (List) destination$iv$iv;
                    }
                    AppUtils appUtils6 = AppUtils.INSTANCE;
                    value$iv = resText2;
                    Result.Companion companion15 = Result.Companion;
                    KType kTypeTypeOf6 = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(CloudPlayStream.class)));
                    MagicApiIntrinsics.voidMagicApiCall((Object) r3);
                    obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf6));
                    if (Result.exceptionOrNull-impl(obj3) == null) {
                        obj5 = obj3;
                    } else {
                        Result.Companion companion16 = Result.Companion;
                        obj4 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(List.class), (List) null, 2, (Object) null));
                        obj5 = obj4;
                    }
                    if (Result.isFailure-impl(obj5)) {
                        obj5 = null;
                    }
                    deserializationStrategy = (KSerializer) obj5;
                    if (deserializationStrategy != null) {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, value$iv);
                        subStreams = (List) objDecodeFromString;
                        if (!subStreams.isEmpty()) {
                            CloudPlay$fetchChannels$allShows$1 cloudPlay$fetchChannels$allShows$7 = new CloudPlay$fetchChannels$allShows$1(this, fallbackLogo2, null);
                            c00002.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                            c00002.L$1 = SpillingKt.nullOutSpilledVariable(fallbackLogo2);
                            c00002.L$2 = shows;
                            c00002.L$3 = SpillingKt.nullOutSpilledVariable(map);
                            c00002.L$4 = SpillingKt.nullOutSpilledVariable(resText2);
                            c00002.L$5 = SpillingKt.nullOutSpilledVariable(subStreams);
                            c00002.Z$0 = isHost;
                            c00002.label = 2;
                            objAmap = ParCollectionsKt.amap(subStreams, cloudPlay$fetchChannels$allShows$7, c00002);
                            if (objAmap == obj) {
                                return obj;
                            }
                            isHost2 = isHost;
                            fallbackLogo3 = fallbackLogo2;
                            url3 = url2;
                            List allShows7 = CollectionsKt.flatten((Iterable) objAmap);
                            shows.addAll(allShows7);
                        }
                    } else {
                        ObjectMapper $this$readValue$iv$iv10 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv10.readValue(value$iv, new TypeReference<List<? extends CloudPlayStream>>() { // from class: com.phisher98.cloudplay.CloudPlay$fetchChannels$$inlined$parseJson$2
                        });
                        subStreams = (List) objDecodeFromString;
                        if (!subStreams.isEmpty()) {
                            CloudPlay$fetchChannels$allShows$1 cloudPlay$fetchChannels$allShows$8 = new CloudPlay$fetchChannels$allShows$1(this, fallbackLogo2, null);
                            c00002.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                            c00002.L$1 = SpillingKt.nullOutSpilledVariable(fallbackLogo2);
                            c00002.L$2 = shows;
                            c00002.L$3 = SpillingKt.nullOutSpilledVariable(map);
                            c00002.L$4 = SpillingKt.nullOutSpilledVariable(resText2);
                            c00002.L$5 = SpillingKt.nullOutSpilledVariable(subStreams);
                            c00002.Z$0 = isHost;
                            c00002.label = 2;
                            objAmap = ParCollectionsKt.amap(subStreams, cloudPlay$fetchChannels$allShows$8, c00002);
                            if (objAmap == obj) {
                                return obj;
                            }
                            isHost2 = isHost;
                            fallbackLogo3 = fallbackLogo2;
                            url3 = url2;
                            List allShows8 = CollectionsKt.flatten((Iterable) objAmap);
                            shows.addAll(allShows8);
                        }
                    }
                }
                return shows;
            case 2:
                isHost2 = c00003.Z$0;
                shows = (List) c00003.L$2;
                fallbackLogo3 = (String) c00003.L$1;
                url3 = (String) c00003.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    objAmap = $result;
                    List allShows9 = CollectionsKt.flatten((Iterable) objAmap);
                    shows.addAll(allShows9);
                } catch (Exception e7) {
                    return shows;
                }
                return shows;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit fetchChannels$lambda$0$1(String $posterUrl, LiveSearchResponse $this$newLiveSearchResponse) {
        $this$newLiveSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit fetchChannels$lambda$1$0(String $posterUrl, LiveSearchResponse $this$newLiveSearchResponse) {
        $this$newLiveSearchResponse.setPosterUrl($posterUrl);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0255  */
    /* JADX WARN: Code duplicated, block: B:102:0x0275  */
    /* JADX WARN: Code duplicated, block: B:105:0x0288  */
    /* JADX WARN: Code duplicated, block: B:106:0x028a  */
    /* JADX WARN: Code duplicated, block: B:108:0x028d  */
    /* JADX WARN: Code duplicated, block: B:111:0x029b  */
    /* JADX WARN: Code duplicated, block: B:112:0x029e  */
    /* JADX WARN: Code duplicated, block: B:114:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:117:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:118:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:121:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:122:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:89:0x0230  */
    /* JADX WARN: Code duplicated, block: B:90:0x0232  */
    /* JADX WARN: Code duplicated, block: B:93:0x023d  */
    /* JADX WARN: Code duplicated, block: B:94:0x0240  */
    /* JADX WARN: Code duplicated, block: B:96:0x0244  */
    /* JADX WARN: Code duplicated, block: B:98:0x024e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0251  */
    private final List<CloudPlayChannel> parseM3u(String m3uText) {
        String str;
        String str2;
        String str3;
        List groupValues;
        String str4;
        List groupValues2;
        List groupValues3;
        List groupValues4;
        String urlUserAgent;
        String urlReferer;
        String urlKey;
        String urlKeyId;
        String type;
        boolean z;
        String licenseUrl;
        Map headersMap;
        boolean z2;
        boolean z3;
        String str5;
        String str6;
        boolean z4;
        List groupValues5;
        List groupValues6;
        List groupValues7;
        List groupValues8;
        List<String> lines = StringsKt.split$default(m3uText, new String[]{"\n"}, false, 0, 6, (Object) null);
        List channels = new ArrayList();
        String currentKey = "";
        String currentKeyId = "";
        String currentUserAgent = "";
        String currentReferer = "";
        String currentName = "";
        String currentLogo = "";
        String currentGroup = "";
        for (String line : lines) {
            String l = StringsKt.trim(line).toString();
            String str7 = "";
            if (StringsKt.startsWith$default(l, "#EXTINF:", false, 2, (Object) null)) {
                currentName = StringsKt.trim(StringsKt.substringAfterLast$default(l, ",", (String) null, 2, (Object) null)).toString();
                List lines2 = lines;
                MatchResult matchResultFind$default = Regex.find$default(new Regex("tvg-logo=\"([^\"]+)\""), l, 0, 2, (Object) null);
                if (matchResultFind$default == null || (groupValues4 = matchResultFind$default.getGroupValues()) == null || (str = (String) groupValues4.get(1)) == null) {
                    str = "";
                }
                currentLogo = str;
                MatchResult matchResultFind$default2 = Regex.find$default(new Regex("group-title=\"([^\"]+)\""), l, 0, 2, (Object) null);
                if (matchResultFind$default2 == null || (groupValues3 = matchResultFind$default2.getGroupValues()) == null || (str2 = (String) groupValues3.get(1)) == null) {
                    str2 = "";
                }
                currentGroup = str2;
                MatchResult matchResultFind$default3 = Regex.find$default(new Regex("key=\"([^\"]+)\""), l, 0, 2, (Object) null);
                if (matchResultFind$default3 == null || (groupValues2 = matchResultFind$default3.getGroupValues()) == null || (str3 = (String) groupValues2.get(1)) == null) {
                    str3 = "";
                }
                currentKey = str3;
                MatchResult matchResultFind$default4 = Regex.find$default(new Regex("keyid=\"([^\"]+)\""), l, 0, 2, (Object) null);
                if (matchResultFind$default4 != null && (groupValues = matchResultFind$default4.getGroupValues()) != null && (str4 = (String) groupValues.get(1)) != null) {
                    str7 = str4;
                }
                currentKeyId = str7;
                lines = lines2;
            } else {
                List lines3 = lines;
                if (!StringsKt.startsWith$default(l, "#EXTVLCOPT:", false, 2, (Object) null)) {
                    if (!StringsKt.startsWith$default(l, "#", false, 2, (Object) null)) {
                        if (l.length() > 0) {
                            List urlParts = StringsKt.split$default(l, new String[]{"|"}, false, 0, 6, (Object) null);
                            String rawUrl = (String) urlParts.get(0);
                            String params = urlParts.size() > 1 ? (String) urlParts.get(1) : "";
                            MatchResult matchResultFind$default5 = Regex.find$default(new Regex("User-Agent=([^&]+)", RegexOption.IGNORE_CASE), params, 0, 2, (Object) null);
                            if (matchResultFind$default5 == null || (groupValues8 = matchResultFind$default5.getGroupValues()) == null || (urlUserAgent = (String) groupValues8.get(1)) == null) {
                                urlUserAgent = currentUserAgent;
                            }
                            MatchResult matchResultFind$default6 = Regex.find$default(new Regex("Referer=([^&]+)", RegexOption.IGNORE_CASE), params, 0, 2, (Object) null);
                            if (matchResultFind$default6 == null || (groupValues7 = matchResultFind$default6.getGroupValues()) == null || (urlReferer = (String) groupValues7.get(1)) == null) {
                                urlReferer = currentReferer;
                            }
                            String params2 = params;
                            MatchResult matchResultFind$default7 = Regex.find$default(new Regex("key=([^&]+)", RegexOption.IGNORE_CASE), params, 0, 2, (Object) null);
                            if (matchResultFind$default7 == null || (groupValues6 = matchResultFind$default7.getGroupValues()) == null || (urlKey = (String) groupValues6.get(1)) == null) {
                                urlKey = currentKey;
                            }
                            MatchResult matchResultFind$default8 = Regex.find$default(new Regex("keyid=([^&]+)", RegexOption.IGNORE_CASE), params2, 0, 2, (Object) null);
                            if (matchResultFind$default8 != null && (groupValues5 = matchResultFind$default8.getGroupValues()) != null) {
                                urlKeyId = (String) groupValues5.get(1);
                                if (urlKeyId == null) {
                                }
                                if (StringsKt.contains$default(rawUrl, ".mpd", false, 2, (Object) null)) {
                                    type = "dash";
                                } else {
                                    type = "hls";
                                }
                                if (urlKey.length() > 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z) {
                                    if (urlKeyId.length() > 0) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    if (z4) {
                                        licenseUrl = "https://dummy.com/?keyid=" + urlKeyId + "&key=" + urlKey;
                                    } else {
                                        licenseUrl = "";
                                    }
                                } else {
                                    licenseUrl = "";
                                }
                                headersMap = new LinkedHashMap();
                                if (urlUserAgent.length() > 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    headersMap.put("User-Agent", urlUserAgent);
                                }
                                if (urlReferer.length() > 0) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    headersMap.put("Referer", urlReferer);
                                }
                                if (Intrinsics.areEqual(type, "hls")) {
                                    str5 = rawUrl;
                                } else {
                                    str5 = null;
                                }
                                if (Intrinsics.areEqual(type, "dash")) {
                                    str6 = rawUrl;
                                } else {
                                    str6 = null;
                                }
                                channels.add(new CloudPlayChannel(type, null, currentName, currentGroup, currentLogo, urlUserAgent, str5, str6, licenseUrl, headersMap));
                                currentName = "";
                                currentLogo = "";
                                currentGroup = "";
                                currentKey = "";
                                currentKeyId = "";
                                currentUserAgent = "";
                                currentReferer = "";
                                lines = lines3;
                            }
                            urlKeyId = currentKeyId;
                            if (StringsKt.contains$default(rawUrl, ".mpd", false, 2, (Object) null)) {
                                type = "dash";
                            } else {
                                type = "hls";
                            }
                            if (urlKey.length() > 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                licenseUrl = "";
                            } else {
                                if (urlKeyId.length() > 0) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                if (z4) {
                                    licenseUrl = "https://dummy.com/?keyid=" + urlKeyId + "&key=" + urlKey;
                                } else {
                                    licenseUrl = "";
                                }
                            }
                            headersMap = new LinkedHashMap();
                            if (urlUserAgent.length() > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                headersMap.put("User-Agent", urlUserAgent);
                            }
                            if (urlReferer.length() > 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                headersMap.put("Referer", urlReferer);
                            }
                            if (Intrinsics.areEqual(type, "hls")) {
                                str5 = rawUrl;
                            } else {
                                str5 = null;
                            }
                            if (Intrinsics.areEqual(type, "dash")) {
                                str6 = rawUrl;
                            } else {
                                str6 = null;
                            }
                            channels.add(new CloudPlayChannel(type, null, currentName, currentGroup, currentLogo, urlUserAgent, str5, str6, licenseUrl, headersMap));
                            currentName = "";
                            currentLogo = "";
                            currentGroup = "";
                            currentKey = "";
                            currentKeyId = "";
                            currentUserAgent = "";
                            currentReferer = "";
                            lines = lines3;
                        }
                    }
                    lines = lines3;
                    currentKey = currentKey;
                    currentKeyId = currentKeyId;
                } else {
                    String opt = StringsKt.substringAfter$default(l, ":", (String) null, 2, (Object) null);
                    if (StringsKt.startsWith$default(opt, "http-user-agent=", false, 2, (Object) null)) {
                        currentUserAgent = StringsKt.substringAfter$default(opt, "=", (String) null, 2, (Object) null);
                        lines = lines3;
                    } else if (!StringsKt.startsWith$default(opt, "http-referrer=", false, 2, (Object) null)) {
                        lines = lines3;
                        currentKey = currentKey;
                        currentKeyId = currentKeyId;
                    } else {
                        currentReferer = StringsKt.substringAfter$default(opt, "=", (String) null, 2, (Object) null);
                        lines = lines3;
                    }
                }
            }
        }
        return channels;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:27:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:29:0x00db  */
    /* JADX WARN: Code duplicated, block: B:44:0x013d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0159  */
    /* JADX WARN: Code duplicated, block: B:56:0x0199 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x019a  */
    /* JADX WARN: Code duplicated, block: B:61:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:63:0x01da  */
    /* JADX WARN: Code duplicated, block: B:69:0x0111 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0144 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x01dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object search(@NotNull String query, @NotNull Continuation<? super List<? extends SearchResponse>> continuation) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        C00111 c00111;
        Object obj;
        Object obj2;
        String $result;
        Object safe;
        CloudPlayResponse res;
        String tag;
        String decryptedJson;
        Object obj3;
        DeserializationStrategy deserializationStrategy;
        Object objDecodeFromString;
        List<CloudPlayStream> streams;
        Object objAmap;
        String query2;
        List allChannels;
        Collection destination$iv$iv;
        SearchResponse it;
        if (continuation instanceof C00111) {
            c00111 = (C00111) continuation;
            if ((c00111.label & Integer.MIN_VALUE) != 0) {
                c00111.label -= Integer.MIN_VALUE;
            } else {
                c00111 = new C00111(continuation);
            }
        } else {
            c00111 = new C00111(continuation);
        }
        C00111 c00112 = c00111;
        Object $result2 = c00112.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00112.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                Requests app = MainActivityKt.getApp();
                String strMainPhpUrl = mainPhpUrl();
                Map<String, String> map = this.apiHeaders;
                c00112.L$0 = query;
                c00112.label = 1;
                obj = coroutine_suspended;
                Object obj4 = Requests.get$default(app, strMainPhpUrl, map, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00112, 4092, (Object) null);
                c00112 = c00112;
                if (obj4 == obj) {
                    return obj;
                }
                obj2 = obj4;
                $result = query;
                NiceResponse this_$iv = (NiceResponse) obj2;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(CloudPlayResponse.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                res = (CloudPlayResponse) safe;
                if (res == null) {
                    return CollectionsKt.emptyList();
                }
                String payload = res.getPayload();
                String iv = res.getIv();
                tag = res.getTag();
                if (tag == null) {
                    tag = "";
                }
                decryptedJson = decryptPayload(payload, iv, tag);
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(CloudPlayStreams.class);
                    MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                    obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                    break;
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.exceptionOrNull-impl(obj3) != null) {
                    try {
                        Result.Companion companion3 = Result.Companion;
                        obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(CloudPlayStreams.class), (List) null, 2, (Object) null));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        obj3 = Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                    break;
                }
                if (Result.isFailure-impl(obj3)) {
                    obj3 = null;
                }
                deserializationStrategy = (KSerializer) obj3;
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, decryptedJson);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv.readValue(decryptedJson, new TypeReference<CloudPlayStreams>() { // from class: com.phisher98.cloudplay.CloudPlay$search$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(decryptedJson, new TypeReference<CloudPlayStreams>() { // from class: com.phisher98.cloudplay.CloudPlay$search$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(decryptedJson, new TypeReference<CloudPlayStreams>() { // from class: com.phisher98.cloudplay.CloudPlay$search$$inlined$parseJson$1
                    });
                }
                streams = ((CloudPlayStreams) objDecodeFromString).getStreams();
                CloudPlay$search$allChannels$1 cloudPlay$search$allChannels$1 = new CloudPlay$search$allChannels$1(this, null);
                c00112.L$0 = $result;
                c00112.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00112.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson);
                c00112.L$3 = SpillingKt.nullOutSpilledVariable(streams);
                c00112.label = 2;
                objAmap = ParCollectionsKt.amap(streams, cloudPlay$search$allChannels$1, c00112);
                if (objAmap == obj) {
                    return obj;
                }
                query2 = $result;
                $result2 = objAmap;
                allChannels = CollectionsKt.flatten((Iterable) $result2);
                List $this$filter$iv = allChannels;
                destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    it = (SearchResponse) element$iv$iv;
                    List<CloudPlayStream> list = streams;
                    List allChannels2 = allChannels;
                    if (StringsKt.contains(it.getName(), query2, true)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    streams = list;
                    allChannels = allChannels2;
                }
                return (List) destination$iv$iv;
            case 1:
                String query3 = (String) c00112.L$0;
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                $result = query3;
                obj2 = $result2;
                NiceResponse this_$iv2 = (NiceResponse) obj2;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(CloudPlayResponse.class));
                res = (CloudPlayResponse) safe;
                if (res == null) {
                    return CollectionsKt.emptyList();
                }
                String payload2 = res.getPayload();
                String iv2 = res.getIv();
                tag = res.getTag();
                if (tag == null) {
                    tag = "";
                }
                decryptedJson = decryptPayload(payload2, iv2, tag);
                AppUtils appUtils2 = AppUtils.INSTANCE;
                Result.Companion companion5 = Result.Companion;
                KType kTypeTypeOf2 = Reflection.typeOf(CloudPlayStreams.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                obj3 = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf2));
                if (Result.exceptionOrNull-impl(obj3) != null) {
                    Result.Companion companion6 = Result.Companion;
                    obj3 = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(CloudPlayStreams.class), (List) null, 2, (Object) null));
                    break;
                }
                if (Result.isFailure-impl(obj3)) {
                    obj3 = null;
                }
                deserializationStrategy = (KSerializer) obj3;
                if (deserializationStrategy != null) {
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, decryptedJson);
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv4 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv4.readValue(decryptedJson, new TypeReference<CloudPlayStreams>() { // from class: com.phisher98.cloudplay.CloudPlay$search$$inlined$parseJson$1
                    });
                }
                streams = ((CloudPlayStreams) objDecodeFromString).getStreams();
                CloudPlay$search$allChannels$1 cloudPlay$search$allChannels$2 = new CloudPlay$search$allChannels$1(this, null);
                c00112.L$0 = $result;
                c00112.L$1 = SpillingKt.nullOutSpilledVariable(res);
                c00112.L$2 = SpillingKt.nullOutSpilledVariable(decryptedJson);
                c00112.L$3 = SpillingKt.nullOutSpilledVariable(streams);
                c00112.label = 2;
                objAmap = ParCollectionsKt.amap(streams, cloudPlay$search$allChannels$2, c00112);
                if (objAmap == obj) {
                    return obj;
                }
                query2 = $result;
                $result2 = objAmap;
                allChannels = CollectionsKt.flatten((Iterable) $result2);
                List $this$filter$iv2 = allChannels;
                destination$iv$iv = new ArrayList();
                while (r12.hasNext()) {
                    it = (SearchResponse) element$iv$iv;
                    List<CloudPlayStream> list2 = streams;
                    List allChannels3 = allChannels;
                    if (StringsKt.contains(it.getName(), query2, true)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    streams = list2;
                    allChannels = allChannels3;
                }
                return (List) destination$iv$iv;
            case 2:
                streams = (List) c00112.L$3;
                query2 = (String) c00112.L$0;
                ResultKt.throwOnFailure($result2);
                allChannels = CollectionsKt.flatten((Iterable) $result2);
                List $this$filter$iv3 = allChannels;
                destination$iv$iv = new ArrayList();
                while (r12.hasNext()) {
                    it = (SearchResponse) element$iv$iv;
                    List<CloudPlayStream> list3 = streams;
                    List allChannels4 = allChannels;
                    if (StringsKt.contains(it.getName(), query2, true)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    streams = list3;
                    allChannels = allChannels4;
                }
                return (List) destination$iv$iv;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public Object load(@NotNull String url, @NotNull Continuation<? super LoadResponse> continuation) {
        Object obj;
        Object objDecodeFromString;
        AppUtils appUtils = AppUtils.INSTANCE;
        try {
            Result.Companion companion = Result.Companion;
            KType kTypeTypeOf = Reflection.typeOf(CloudPlayChannel.class);
            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(obj) != null) {
            try {
                Result.Companion companion3 = Result.Companion;
                obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(CloudPlayChannel.class), (List) null, 2, (Object) null));
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
                objDecodeFromString = $this$readValue$iv$iv.readValue(url, new TypeReference<CloudPlayChannel>() { // from class: com.phisher98.cloudplay.CloudPlay$load$$inlined$parseJson$1
                });
            } catch (Throwable th3) {
                ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv2.readValue(url, new TypeReference<CloudPlayChannel>() { // from class: com.phisher98.cloudplay.CloudPlay$load$$inlined$parseJson$1
                });
            }
        } else {
            ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
            objDecodeFromString = $this$readValue$iv$iv3.readValue(url, new TypeReference<CloudPlayChannel>() { // from class: com.phisher98.cloudplay.CloudPlay$load$$inlined$parseJson$1
            });
        }
        CloudPlayChannel data = (CloudPlayChannel) objDecodeFromString;
        String name = data.getName();
        if (name == null) {
            name = "Unknown";
        }
        String title = name;
        String poster = data.getLogo();
        if (poster == null) {
            poster = "";
        }
        return MainAPIKt.newLiveStreamLoadResponse(this, title, url, url, new C00072(poster, data, null), continuation);
    }

    /* JADX INFO: renamed from: com.phisher98.cloudplay.CloudPlay$load$2 */
    /* JADX INFO: compiled from: CloudPlayProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/LiveStreamLoadResponse;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.cloudplay.CloudPlay$load$2", f = "CloudPlayProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00072 extends SuspendLambda implements Function2<LiveStreamLoadResponse, Continuation<? super Unit>, Object> {
        final /* synthetic */ CloudPlayChannel $data;
        final /* synthetic */ String $poster;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00072(String str, CloudPlayChannel cloudPlayChannel, Continuation<? super C00072> continuation) {
            super(2, continuation);
            this.$poster = str;
            this.$data = cloudPlayChannel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00072 = new C00072(this.$poster, this.$data, continuation);
            c00072.L$0 = obj;
            return c00072;
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
                    $this$newLiveStreamLoadResponse.setPosterUrl(this.$poster);
                    $this$newLiveStreamLoadResponse.setPlot(this.$data.getGroup());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final String hexToBase64Url(String $this$hexToBase64Url) {
        String normalizedHex = StringsKt.replace$default(StringsKt.trim($this$hexToBase64Url).toString(), "-", "", false, 4, (Object) null);
        if ((normalizedHex.length() == 0) || normalizedHex.length() % 2 != 0 || !new Regex("^[0-9a-fA-F]+$").matches(normalizedHex)) {
            return $this$hexToBase64Url;
        }
        try {
            Iterable $this$map$iv = StringsKt.chunked(normalizedHex, 2);
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String it = (String) item$iv$iv;
                destination$iv$iv.add(Byte.valueOf((byte) Integer.parseInt(it, CharsKt.checkRadix(16))));
            }
            byte[] bytes = CollectionsKt.toByteArray((List) destination$iv$iv);
            return StringsKt.trimEnd(StringsKt.replace$default(StringsKt.replace$default(MainAPIKt.base64Encode(bytes), "+", "-", false, 4, (Object) null), "/", "_", false, 4, (Object) null), new char[]{'='});
        } catch (Exception e) {
            return $this$hexToBase64Url;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object getMpdStream(String url, Map<String, String> map, Continuation<? super String> continuation) {
        C00061 c00061;
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
        Object $result = c00061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00061.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                Map<String, String> mapEmptyMap = map == null ? MapsKt.emptyMap() : map;
                c00061.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c00061.L$1 = SpillingKt.nullOutSpilledVariable(map);
                c00061.label = 1;
                $result = Requests.get$default(app, url, mapEmptyMap, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00061, 4092, (Object) null);
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
        return ((NiceResponse) $result).getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public final Object getDRMKeysFromLicenseServer(String url, String kid, Continuation<? super String> continuation) {
        C00031 c00031;
        int i;
        String kid2;
        Object obj;
        Object objDecodeFromString;
        String str;
        if (continuation instanceof C00031) {
            c00031 = (C00031) continuation;
            if ((c00031.label & Integer.MIN_VALUE) != 0) {
                c00031.label -= Integer.MIN_VALUE;
            } else {
                c00031 = new C00031(continuation);
            }
        } else {
            c00031 = new C00031(continuation);
        }
        C00031 c00032 = c00031;
        Object $result = c00032.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00032.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                Map mapMapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("User-Agent", "Dalvik/2.1.0 (Linux; U; Android)"), TuplesKt.to("Content-Type", "application/json;charset=UTF-8")});
                Map mapMapOf2 = MapsKt.mapOf(new Pair[]{TuplesKt.to("kids", CollectionsKt.listOf(kid)), TuplesKt.to("type", "temporary")});
                c00032.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c00032.L$1 = kid;
                c00032.L$2 = SpillingKt.nullOutSpilledVariable("Dalvik/2.1.0 (Linux; U; Android)");
                c00032.label = 1;
                i = 2;
                Object objPost$default = Requests.post$default(app, url, mapMapOf, (String) null, (Map) null, (Map) null, (Map) null, (List) null, mapMapOf2, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00032, 65404, (Object) null);
                if (objPost$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                kid2 = kid;
                $result = objPost$default;
                break;
                break;
            case 1:
                kid2 = (String) c00032.L$1;
                ResultKt.throwOnFailure($result);
                i = 2;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String responseString = ((NiceResponse) $result).getText();
        try {
            AppUtils appUtils = AppUtils.INSTANCE;
            try {
                Result.Companion companion = Result.Companion;
                KType kTypeTypeOf = Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Object.class)));
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
                    obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Map.class), (List) null, i, (Object) null));
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
                    objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, responseString);
                } catch (SerializationException e) {
                    ArchComponentExtKt.logError(e);
                    ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv.readValue(responseString, new TypeReference<Map<String, ? extends Object>>() { // from class: com.phisher98.cloudplay.CloudPlay$getDRMKeysFromLicenseServer$$inlined$parseJson$1
                    });
                } catch (Throwable th3) {
                    ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv2.readValue(responseString, new TypeReference<Map<String, ? extends Object>>() { // from class: com.phisher98.cloudplay.CloudPlay$getDRMKeysFromLicenseServer$$inlined$parseJson$1
                    });
                }
            } else {
                ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                objDecodeFromString = $this$readValue$iv$iv3.readValue(responseString, new TypeReference<Map<String, ? extends Object>>() { // from class: com.phisher98.cloudplay.CloudPlay$getDRMKeysFromLicenseServer$$inlined$parseJson$1
                });
            }
            Map jsonResponse = (Map) objDecodeFromString;
            Object obj3 = jsonResponse.get("keys");
            Iterable keys = obj3 instanceof List ? (List) obj3 : null;
            if (keys == null) {
                return "";
            }
            Iterable $this$firstOrNull$iv = keys;
            for (Object element$iv : $this$firstOrNull$iv) {
                Map it = (Map) element$iv;
                if (Intrinsics.areEqual(it.get("kid"), kid2)) {
                    obj2 = element$iv;
                    Map map = (Map) obj2;
                    return (map == null || (str = (String) map.get("k")) == null) ? "" : str;
                }
            }
            Map map2 = (Map) obj2;
            if (map2 == null) {
                return "";
            }
        } catch (Exception e2) {
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0323  */
    /* JADX WARN: Code duplicated, block: B:102:0x0326  */
    /* JADX WARN: Code duplicated, block: B:104:0x032a  */
    /* JADX WARN: Code duplicated, block: B:105:0x032f  */
    /* JADX WARN: Code duplicated, block: B:108:0x0388 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:109:0x0389  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code duplicated, block: B:84:0x0280  */
    /* JADX WARN: Code duplicated, block: B:87:0x02cd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:88:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:93:0x0300  */
    /* JADX WARN: Code duplicated, block: B:96:0x0314  */
    /* JADX WARN: Code duplicated, block: B:97:0x0316  */
    /* JADX WARN: Code duplicated, block: B:99:0x0319  */
    @Nullable
    public Object loadLinks(@NotNull String data, boolean isCasting, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Boolean> continuation) {
        C00081 c00081;
        Object obj;
        Object objDecodeFromString;
        Object objNewExtractorLink;
        String data2;
        Function1<? super SubtitleFile, Unit> function3;
        String licenseUrl;
        Ref.ObjectRef keyStr;
        Ref.ObjectRef kidStr;
        Object mpdStream;
        String mpdStr;
        CloudPlayChannel channel;
        boolean isCasting2;
        Ref.ObjectRef kidStr2;
        Ref.ObjectRef kidStr3;
        Function1<? super SubtitleFile, Unit> function4;
        CloudPlayChannel channel2;
        Function1<? super ExtractorLink, Unit> function5;
        String data3;
        Function1<? super SubtitleFile, Unit> function6;
        String licenseUrl2;
        String strHexToBase64Url;
        List groupValues;
        String str;
        String strHexToBase64Url2;
        List groupValues2;
        String str2;
        Function1<? super SubtitleFile, Unit> function7;
        MatchResult matchResult;
        String drmKid;
        Object dRMKeysFromLicenseServer;
        Ref.ObjectRef keyStr2;
        Object obj2;
        Ref.ObjectRef kidStr4;
        Ref.ObjectRef objectRef;
        Function1<? super ExtractorLink, Unit> function8;
        List groupValues3;
        String name;
        boolean z;
        UUID uuidFromString;
        Object objNewDrmExtractorLink;
        boolean isTs;
        Function1<? super ExtractorLink, Unit> function9;
        CloudPlayChannel channel3;
        boolean z2;
        boolean isCasting3 = isCasting;
        Function1<? super ExtractorLink, Unit> function10 = function2;
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
        C00081 c00082 = c00081;
        Object $result = c00082.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00082.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                AppUtils appUtils = AppUtils.INSTANCE;
                try {
                    Result.Companion companion = Result.Companion;
                    KType kTypeTypeOf = Reflection.typeOf(CloudPlayChannel.class);
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
                        obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(CloudPlayChannel.class), (List) null, 2, (Object) null));
                    } catch (Throwable th2) {
                        Result.Companion companion4 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                    break;
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                DeserializationStrategy deserializationStrategy = (KSerializer) obj;
                if (deserializationStrategy != null) {
                    try {
                        objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, data);
                    } catch (SerializationException e) {
                        ArchComponentExtKt.logError(e);
                        ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv.readValue(data, new TypeReference<CloudPlayChannel>() { // from class: com.phisher98.cloudplay.CloudPlay$loadLinks$$inlined$parseJson$1
                        });
                    } catch (Throwable th3) {
                        ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                        objDecodeFromString = $this$readValue$iv$iv2.readValue(data, new TypeReference<CloudPlayChannel>() { // from class: com.phisher98.cloudplay.CloudPlay$loadLinks$$inlined$parseJson$1
                        });
                    }
                    break;
                } else {
                    ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                    objDecodeFromString = $this$readValue$iv$iv3.readValue(data, new TypeReference<CloudPlayChannel>() { // from class: com.phisher98.cloudplay.CloudPlay$loadLinks$$inlined$parseJson$1
                    });
                }
                CloudPlayChannel channel4 = (CloudPlayChannel) objDecodeFromString;
                if (channel4.getMpd_url() != null) {
                    licenseUrl = channel4.getLicense_url();
                    String str3 = "";
                    if (licenseUrl == null) {
                        licenseUrl = "";
                    }
                    keyStr = new Ref.ObjectRef();
                    keyStr.element = "";
                    kidStr = new Ref.ObjectRef();
                    kidStr.element = "";
                    if (StringsKt.contains$default(licenseUrl, "keyid=", false, 2, (Object) null) && StringsKt.contains$default(licenseUrl, "key=", false, 2, (Object) null)) {
                        MatchResult matchResultFind$default = Regex.find$default(new Regex("keyid=([^&]+)"), licenseUrl, 0, 2, (Object) null);
                        if (matchResultFind$default == null || (groupValues2 = matchResultFind$default.getGroupValues()) == null || (str2 = (String) groupValues2.get(1)) == null || (strHexToBase64Url = hexToBase64Url(str2)) == null) {
                            strHexToBase64Url = "";
                        }
                        kidStr.element = strHexToBase64Url;
                        MatchResult matchResultFind$default2 = Regex.find$default(new Regex("key=([^&]+)"), licenseUrl, 0, 2, (Object) null);
                        if (matchResultFind$default2 != null && (groupValues = matchResultFind$default2.getGroupValues()) != null && (str = (String) groupValues.get(1)) != null && (strHexToBase64Url2 = hexToBase64Url(str)) != null) {
                            str3 = strHexToBase64Url2;
                        }
                        keyStr.element = str3;
                    } else {
                        if (licenseUrl.length() > 0) {
                            String mpd_url = channel4.getMpd_url();
                            Map<String, String> headers = channel4.getHeaders();
                            c00082.L$0 = SpillingKt.nullOutSpilledVariable(data);
                            c00082.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                            c00082.L$2 = function10;
                            c00082.L$3 = channel4;
                            c00082.L$4 = licenseUrl;
                            c00082.L$5 = keyStr;
                            c00082.L$6 = kidStr;
                            c00082.Z$0 = isCasting3;
                            c00082.label = 1;
                            mpdStream = getMpdStream(mpd_url, headers, c00082);
                            if (mpdStream == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            mpdStr = data;
                            channel = channel4;
                            isCasting2 = isCasting3;
                            kidStr2 = keyStr;
                            kidStr3 = kidStr;
                            function4 = function1;
                            String mpdStr2 = (String) mpdStream;
                            Regex regex = new Regex("cenc:default_KID=[\"']([0-9a-fA-F\\-]{36})[\"']");
                            function7 = function4;
                            matchResult = Regex.find$default(regex, mpdStr2, 0, 2, (Object) null);
                            if (matchResult != null || (groupValues3 = matchResult.getGroupValues()) == null || (drmKid = (String) groupValues3.get(1)) == null) {
                                drmKid = UUID.randomUUID().toString();
                            }
                            kidStr3.element = hexToBase64Url(drmKid);
                            String str4 = (String) kidStr3.element;
                            c00082.L$0 = SpillingKt.nullOutSpilledVariable(mpdStr);
                            c00082.L$1 = SpillingKt.nullOutSpilledVariable(function7);
                            c00082.L$2 = function10;
                            c00082.L$3 = channel;
                            c00082.L$4 = licenseUrl;
                            c00082.L$5 = kidStr2;
                            c00082.L$6 = kidStr3;
                            c00082.L$7 = SpillingKt.nullOutSpilledVariable(mpdStr2);
                            c00082.L$8 = SpillingKt.nullOutSpilledVariable(regex);
                            c00082.L$9 = SpillingKt.nullOutSpilledVariable(matchResult);
                            c00082.L$10 = SpillingKt.nullOutSpilledVariable(drmKid);
                            c00082.L$11 = kidStr2;
                            c00082.Z$0 = isCasting2;
                            c00082.label = 2;
                            dRMKeysFromLicenseServer = getDRMKeysFromLicenseServer(licenseUrl, str4, c00082);
                            if (dRMKeysFromLicenseServer == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            keyStr2 = kidStr2;
                            obj2 = dRMKeysFromLicenseServer;
                            kidStr4 = kidStr3;
                            objectRef = keyStr2;
                            function8 = function10;
                            function6 = function7;
                            objectRef.element = obj2;
                            function5 = function8;
                            keyStr = keyStr2;
                            kidStr = kidStr4;
                            isCasting3 = isCasting2;
                            channel2 = channel;
                            data3 = mpdStr;
                            licenseUrl2 = licenseUrl;
                        }
                        String name2 = getName();
                        name = channel2.getName();
                        if (name == null) {
                            name = "DASH";
                        }
                        String mpd_url2 = channel2.getMpd_url();
                        ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                        if (((CharSequence) kidStr.element).length() > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            if (((CharSequence) keyStr.element).length() > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                uuidFromString = ExtractorApiKt.getCLEARKEY_UUID();
                            } else {
                                uuidFromString = UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed");
                            }
                        } else {
                            uuidFromString = UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed");
                        }
                        Ref.ObjectRef keyStr3 = keyStr;
                        Ref.ObjectRef kidStr5 = kidStr;
                        C00092 c00092 = new C00092(channel2, kidStr5, keyStr3, licenseUrl2, null);
                        c00082.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                        c00082.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                        c00082.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                        c00082.L$3 = SpillingKt.nullOutSpilledVariable(channel2);
                        c00082.L$4 = SpillingKt.nullOutSpilledVariable(licenseUrl2);
                        c00082.L$5 = SpillingKt.nullOutSpilledVariable(keyStr3);
                        c00082.L$6 = SpillingKt.nullOutSpilledVariable(kidStr5);
                        c00082.L$7 = function5;
                        c00082.L$8 = null;
                        c00082.L$9 = null;
                        c00082.L$10 = null;
                        c00082.L$11 = null;
                        c00082.Z$0 = isCasting3;
                        c00082.label = 3;
                        objNewDrmExtractorLink = ExtractorApiKt.newDrmExtractorLink(name2, name, mpd_url2, infer_type, uuidFromString, c00092, c00082);
                        if (objNewDrmExtractorLink == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        isTs = isCasting3;
                        function9 = function5;
                        channel3 = channel2;
                        function9.invoke(objNewDrmExtractorLink);
                    }
                    channel2 = channel4;
                    function5 = function10;
                    data3 = data;
                    function6 = function1;
                    licenseUrl2 = licenseUrl;
                    String name3 = getName();
                    name = channel2.getName();
                    if (name == null) {
                        name = "DASH";
                    }
                    String mpd_url3 = channel2.getMpd_url();
                    ExtractorLinkType infer_type2 = ExtractorApiKt.getINFER_TYPE();
                    if (((CharSequence) kidStr.element).length() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        uuidFromString = UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed");
                    } else {
                        if (((CharSequence) keyStr.element).length() > 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            uuidFromString = ExtractorApiKt.getCLEARKEY_UUID();
                        } else {
                            uuidFromString = UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed");
                        }
                    }
                    Ref.ObjectRef keyStr4 = keyStr;
                    Ref.ObjectRef kidStr6 = kidStr;
                    C00092 c00093 = new C00092(channel2, kidStr6, keyStr4, licenseUrl2, null);
                    c00082.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                    c00082.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                    c00082.L$3 = SpillingKt.nullOutSpilledVariable(channel2);
                    c00082.L$4 = SpillingKt.nullOutSpilledVariable(licenseUrl2);
                    c00082.L$5 = SpillingKt.nullOutSpilledVariable(keyStr4);
                    c00082.L$6 = SpillingKt.nullOutSpilledVariable(kidStr6);
                    c00082.L$7 = function5;
                    c00082.L$8 = null;
                    c00082.L$9 = null;
                    c00082.L$10 = null;
                    c00082.L$11 = null;
                    c00082.Z$0 = isCasting3;
                    c00082.label = 3;
                    objNewDrmExtractorLink = ExtractorApiKt.newDrmExtractorLink(name3, name, mpd_url3, infer_type2, uuidFromString, c00093, c00082);
                    if (objNewDrmExtractorLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    isTs = isCasting3;
                    function9 = function5;
                    channel3 = channel2;
                    function9.invoke(objNewDrmExtractorLink);
                } else if (channel4.getM3u8_url() != null) {
                    boolean isTs2 = StringsKt.contains(channel4.getM3u8_url(), ".ts", true);
                    String name4 = getName();
                    String name5 = channel4.getName();
                    if (name5 == null) {
                        name5 = "HLS";
                    }
                    String m3u8_url = channel4.getM3u8_url();
                    ExtractorLinkType extractorLinkType = isTs2 ? ExtractorLinkType.VIDEO : ExtractorLinkType.M3U8;
                    C00103 c00103 = new C00103(channel4, null);
                    c00082.L$0 = SpillingKt.nullOutSpilledVariable(data);
                    c00082.L$1 = SpillingKt.nullOutSpilledVariable(function1);
                    c00082.L$2 = SpillingKt.nullOutSpilledVariable(function10);
                    c00082.L$3 = SpillingKt.nullOutSpilledVariable(channel4);
                    c00082.L$4 = function10;
                    c00082.Z$0 = isCasting3;
                    c00082.Z$1 = isTs2;
                    c00082.label = 4;
                    objNewExtractorLink = ExtractorApiKt.newExtractorLink(name4, name5, m3u8_url, extractorLinkType, c00103, c00082);
                    if (objNewExtractorLink == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    data2 = data;
                    function3 = function1;
                    function10.invoke(objNewExtractorLink);
                }
                return Boxing.boxBoolean(true);
            case 1:
                isCasting2 = c00082.Z$0;
                Ref.ObjectRef kidStr7 = (Ref.ObjectRef) c00082.L$6;
                Ref.ObjectRef keyStr5 = (Ref.ObjectRef) c00082.L$5;
                String licenseUrl3 = (String) c00082.L$4;
                CloudPlayChannel channel5 = (CloudPlayChannel) c00082.L$3;
                function10 = (Function1) c00082.L$2;
                function4 = (Function1) c00082.L$1;
                mpdStr = (String) c00082.L$0;
                ResultKt.throwOnFailure($result);
                kidStr3 = kidStr7;
                kidStr2 = keyStr5;
                licenseUrl = licenseUrl3;
                channel = channel5;
                mpdStream = $result;
                String mpdStr3 = (String) mpdStream;
                Regex regex2 = new Regex("cenc:default_KID=[\"']([0-9a-fA-F\\-]{36})[\"']");
                function7 = function4;
                matchResult = Regex.find$default(regex2, mpdStr3, 0, 2, (Object) null);
                if (matchResult != null) {
                    drmKid = UUID.randomUUID().toString();
                } else {
                    drmKid = UUID.randomUUID().toString();
                }
                kidStr3.element = hexToBase64Url(drmKid);
                String str5 = (String) kidStr3.element;
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(mpdStr);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(function7);
                c00082.L$2 = function10;
                c00082.L$3 = channel;
                c00082.L$4 = licenseUrl;
                c00082.L$5 = kidStr2;
                c00082.L$6 = kidStr3;
                c00082.L$7 = SpillingKt.nullOutSpilledVariable(mpdStr3);
                c00082.L$8 = SpillingKt.nullOutSpilledVariable(regex2);
                c00082.L$9 = SpillingKt.nullOutSpilledVariable(matchResult);
                c00082.L$10 = SpillingKt.nullOutSpilledVariable(drmKid);
                c00082.L$11 = kidStr2;
                c00082.Z$0 = isCasting2;
                c00082.label = 2;
                dRMKeysFromLicenseServer = getDRMKeysFromLicenseServer(licenseUrl, str5, c00082);
                if (dRMKeysFromLicenseServer == coroutine_suspended) {
                    return coroutine_suspended;
                }
                keyStr2 = kidStr2;
                obj2 = dRMKeysFromLicenseServer;
                kidStr4 = kidStr3;
                objectRef = keyStr2;
                function8 = function10;
                function6 = function7;
                objectRef.element = obj2;
                function5 = function8;
                keyStr = keyStr2;
                kidStr = kidStr4;
                isCasting3 = isCasting2;
                channel2 = channel;
                data3 = mpdStr;
                licenseUrl2 = licenseUrl;
                String name6 = getName();
                name = channel2.getName();
                if (name == null) {
                    name = "DASH";
                }
                String mpd_url4 = channel2.getMpd_url();
                ExtractorLinkType infer_type3 = ExtractorApiKt.getINFER_TYPE();
                if (((CharSequence) kidStr.element).length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    uuidFromString = UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed");
                } else {
                    if (((CharSequence) keyStr.element).length() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        uuidFromString = ExtractorApiKt.getCLEARKEY_UUID();
                    } else {
                        uuidFromString = UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed");
                    }
                }
                Ref.ObjectRef keyStr6 = keyStr;
                Ref.ObjectRef kidStr8 = kidStr;
                C00092 c00094 = new C00092(channel2, kidStr8, keyStr6, licenseUrl2, null);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(channel2);
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(licenseUrl2);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(keyStr6);
                c00082.L$6 = SpillingKt.nullOutSpilledVariable(kidStr8);
                c00082.L$7 = function5;
                c00082.L$8 = null;
                c00082.L$9 = null;
                c00082.L$10 = null;
                c00082.L$11 = null;
                c00082.Z$0 = isCasting3;
                c00082.label = 3;
                objNewDrmExtractorLink = ExtractorApiKt.newDrmExtractorLink(name6, name, mpd_url4, infer_type3, uuidFromString, c00094, c00082);
                if (objNewDrmExtractorLink == coroutine_suspended) {
                    return coroutine_suspended;
                }
                isTs = isCasting3;
                function9 = function5;
                channel3 = channel2;
                function9.invoke(objNewDrmExtractorLink);
                return Boxing.boxBoolean(true);
            case 2:
                boolean isCasting4 = c00082.Z$0;
                Ref.ObjectRef objectRef2 = (Ref.ObjectRef) c00082.L$11;
                Ref.ObjectRef kidStr9 = (Ref.ObjectRef) c00082.L$6;
                Ref.ObjectRef keyStr7 = (Ref.ObjectRef) c00082.L$5;
                licenseUrl = (String) c00082.L$4;
                channel = (CloudPlayChannel) c00082.L$3;
                Function1<? super ExtractorLink, Unit> function11 = (Function1) c00082.L$2;
                function6 = (Function1) c00082.L$1;
                String data4 = (String) c00082.L$0;
                ResultKt.throwOnFailure($result);
                objectRef = objectRef2;
                keyStr2 = keyStr7;
                kidStr4 = kidStr9;
                function8 = function11;
                mpdStr = data4;
                obj2 = $result;
                isCasting2 = isCasting4;
                objectRef.element = obj2;
                function5 = function8;
                keyStr = keyStr2;
                kidStr = kidStr4;
                isCasting3 = isCasting2;
                channel2 = channel;
                data3 = mpdStr;
                licenseUrl2 = licenseUrl;
                String name7 = getName();
                name = channel2.getName();
                if (name == null) {
                    name = "DASH";
                }
                String mpd_url5 = channel2.getMpd_url();
                ExtractorLinkType infer_type4 = ExtractorApiKt.getINFER_TYPE();
                if (((CharSequence) kidStr.element).length() > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    uuidFromString = UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed");
                } else {
                    if (((CharSequence) keyStr.element).length() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        uuidFromString = ExtractorApiKt.getCLEARKEY_UUID();
                    } else {
                        uuidFromString = UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed");
                    }
                }
                Ref.ObjectRef keyStr8 = keyStr;
                Ref.ObjectRef kidStr10 = kidStr;
                C00092 c00095 = new C00092(channel2, kidStr10, keyStr8, licenseUrl2, null);
                c00082.L$0 = SpillingKt.nullOutSpilledVariable(data3);
                c00082.L$1 = SpillingKt.nullOutSpilledVariable(function6);
                c00082.L$2 = SpillingKt.nullOutSpilledVariable(function5);
                c00082.L$3 = SpillingKt.nullOutSpilledVariable(channel2);
                c00082.L$4 = SpillingKt.nullOutSpilledVariable(licenseUrl2);
                c00082.L$5 = SpillingKt.nullOutSpilledVariable(keyStr8);
                c00082.L$6 = SpillingKt.nullOutSpilledVariable(kidStr10);
                c00082.L$7 = function5;
                c00082.L$8 = null;
                c00082.L$9 = null;
                c00082.L$10 = null;
                c00082.L$11 = null;
                c00082.Z$0 = isCasting3;
                c00082.label = 3;
                objNewDrmExtractorLink = ExtractorApiKt.newDrmExtractorLink(name7, name, mpd_url5, infer_type4, uuidFromString, c00095, c00082);
                if (objNewDrmExtractorLink == coroutine_suspended) {
                    return coroutine_suspended;
                }
                isTs = isCasting3;
                function9 = function5;
                channel3 = channel2;
                function9.invoke(objNewDrmExtractorLink);
                return Boxing.boxBoolean(true);
            case 3:
                isTs = c00082.Z$0;
                function9 = (Function1) c00082.L$7;
                channel3 = (CloudPlayChannel) c00082.L$3;
                Function1<? super ExtractorLink, Unit> function12 = (Function1) c00082.L$2;
                ResultKt.throwOnFailure($result);
                function5 = function12;
                objNewDrmExtractorLink = $result;
                function9.invoke(objNewDrmExtractorLink);
                return Boxing.boxBoolean(true);
            case 4:
                boolean z3 = c00082.Z$1;
                boolean z4 = c00082.Z$0;
                Function1<? super ExtractorLink, Unit> function13 = (Function1) c00082.L$4;
                function3 = (Function1) c00082.L$1;
                data2 = (String) c00082.L$0;
                ResultKt.throwOnFailure($result);
                function10 = function13;
                objNewExtractorLink = $result;
                function10.invoke(objNewExtractorLink);
                return Boxing.boxBoolean(true);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.cloudplay.CloudPlay$loadLinks$2 */
    /* JADX INFO: compiled from: CloudPlayProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/DrmExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.cloudplay.CloudPlay$loadLinks$2", f = "CloudPlayProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00092 extends SuspendLambda implements Function2<DrmExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ CloudPlayChannel $channel;
        final /* synthetic */ Ref.ObjectRef<String> $keyStr;
        final /* synthetic */ Ref.ObjectRef<String> $kidStr;
        final /* synthetic */ String $licenseUrl;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00092(CloudPlayChannel cloudPlayChannel, Ref.ObjectRef<String> objectRef, Ref.ObjectRef<String> objectRef2, String str, Continuation<? super C00092> continuation) {
            super(2, continuation);
            this.$channel = cloudPlayChannel;
            this.$kidStr = objectRef;
            this.$keyStr = objectRef2;
            this.$licenseUrl = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00092 = new C00092(this.$channel, this.$kidStr, this.$keyStr, this.$licenseUrl, continuation);
            c00092.L$0 = obj;
            return c00092;
        }

        public final Object invoke(DrmExtractorLink drmExtractorLink, Continuation<? super Unit> continuation) {
            return create(drmExtractorLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:34:0x009a  */
        /* JADX WARN: Code duplicated, block: B:36:0x00a4  */
        /* JADX WARN: Code duplicated, block: B:38:0x00a7  */
        public final Object invokeSuspend(Object $result) {
            DrmExtractorLink $this$newDrmExtractorLink = (DrmExtractorLink) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Map headersMap = new LinkedHashMap();
                    if (this.$channel.getHeaders() != null) {
                        headersMap.putAll(this.$channel.getHeaders());
                    }
                    String user_agent = this.$channel.getUser_agent();
                    if (!(user_agent == null || user_agent.length() == 0)) {
                        headersMap.put("User-Agent", this.$channel.getUser_agent());
                    } else {
                        headersMap.put("User-Agent", MainAPIKt.base64Decode("aHR0cHM6Ly90Lm1lL2Nsb3VkcGx5IHx8IEBjbG91ZHBsYXk="));
                    }
                    if (!headersMap.isEmpty()) {
                        $this$newDrmExtractorLink.setHeaders(headersMap);
                    }
                    if (((CharSequence) this.$kidStr.element).length() > 0) {
                        if (((CharSequence) this.$keyStr.element).length() > 0) {
                            $this$newDrmExtractorLink.setKid((String) this.$kidStr.element);
                            $this$newDrmExtractorLink.setKey((String) this.$keyStr.element);
                        } else {
                            if (this.$licenseUrl.length() > 0) {
                                $this$newDrmExtractorLink.setLicenseUrl(this.$licenseUrl);
                            }
                        }
                    } else {
                        if (this.$licenseUrl.length() > 0) {
                            $this$newDrmExtractorLink.setLicenseUrl(this.$licenseUrl);
                        }
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.phisher98.cloudplay.CloudPlay$loadLinks$3 */
    /* JADX INFO: compiled from: CloudPlayProvider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.cloudplay.CloudPlay$loadLinks$3", f = "CloudPlayProvider.kt", i = {0, 0}, l = {399}, m = "invokeSuspend", n = {"$this$newExtractorLink", "headersMap"}, nl = {404}, s = {"L$0", "L$1"}, v = 2)
    static final class C00103 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ CloudPlayChannel $channel;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00103(CloudPlayChannel cloudPlayChannel, Continuation<? super C00103> continuation) {
            super(2, continuation);
            this.$channel = cloudPlayChannel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00103 = new C00103(this.$channel, continuation);
            c00103.L$0 = obj;
            return c00103;
        }

        public final Object invoke(ExtractorLink extractorLink, Continuation<? super Unit> continuation) {
            return create(extractorLink, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object objAmap;
            Map headersMap;
            ExtractorLink $this$newExtractorLink = (ExtractorLink) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Map headersMap2 = new LinkedHashMap();
                    if (this.$channel.getHeaders() != null) {
                        headersMap2.putAll(this.$channel.getHeaders());
                    }
                    String user_agent = this.$channel.getUser_agent();
                    if (!(user_agent == null || user_agent.length() == 0)) {
                        headersMap2.put("User-Agent", this.$channel.getUser_agent());
                    } else {
                        headersMap2.put("User-Agent", MainAPIKt.base64Decode("aHR0cHM6Ly90Lm1lL2Nsb3VkcGx5IHx8IEBjbG91ZHBsYXk="));
                    }
                    if (!headersMap2.isEmpty()) {
                        $this$newExtractorLink.setHeaders(headersMap2);
                    }
                    Map<String, String> headers = this.$channel.getHeaders();
                    if (headers != null) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable($this$newExtractorLink);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(headersMap2);
                        this.label = 1;
                        objAmap = ParCollectionsKt.amap(headers, new AnonymousClass1($this$newExtractorLink, null), (Continuation) this);
                        if (objAmap == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        headersMap = headersMap2;
                    }
                    return Unit.INSTANCE;
                case 1:
                    headersMap = (Map) this.L$1;
                    ResultKt.throwOnFailure($result);
                    objAmap = $result;
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.phisher98.cloudplay.CloudPlay$loadLinks$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: CloudPlayProvider.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "<destruct>", "", ""}, k = 3, mv = {2, 4, 0}, xi = 48)
        @DebugMetadata(c = "com.phisher98.cloudplay.CloudPlay$loadLinks$3$1", f = "CloudPlayProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        static final class AnonymousClass1 extends SuspendLambda implements Function2<Map.Entry<? extends String, ? extends String>, Continuation<? super Unit>, Object> {
            final /* synthetic */ ExtractorLink $$this$newExtractorLink;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ExtractorLink extractorLink, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$$this$newExtractorLink = extractorLink;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$$this$newExtractorLink, continuation);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            public final Object invoke(Map.Entry<String, String> entry, Continuation<? super Unit> continuation) {
                return create(entry, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                Map.Entry entry = (Map.Entry) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String key = (String) entry.getKey();
                        String value = (String) entry.getValue();
                        if (StringsKt.equals(key, "referer", true)) {
                            this.$$this$newExtractorLink.setReferer(value);
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
    }

    private final String decryptPayload(String payloadBase64, String ivBase64, String tagBase64) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        String kString = MainAPIKt.base64Decode("amlvdHZwbHVz");
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = kString.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] keyHash = digest.digest(bytes);
        byte[] ivBytes = MainAPIKt.base64DecodeArray(ivBase64);
        byte[] cipherBytes = MainAPIKt.base64DecodeArray(payloadBase64);
        byte[] tagBytes = tagBase64.length() > 0 ? MainAPIKt.base64DecodeArray(tagBase64) : new byte[0];
        byte[] cipherWithTag = ArraysKt.plus(cipherBytes, tagBytes);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, new SecretKeySpec(keyHash, "AES"), new GCMParameterSpec(128, ivBytes));
        byte[] decrypted = cipher.doFinal(cipherWithTag);
        return StringsKt.decodeToString(decrypted);
    }

    /* JADX INFO: compiled from: CloudPlayProvider.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010JF\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010¨\u0006 "}, d2 = {"Lcom/phisher98/cloudplay/CloudPlay$CloudPlayResponse;", "", "payload", "", "iv", "tag", "ts", "", "expires", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getPayload", "()Ljava/lang/String;", "getIv", "getTag", "getTs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getExpires", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lcom/phisher98/cloudplay/CloudPlay$CloudPlayResponse;", "equals", "", "other", "hashCode", "", "toString", "CloudPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class CloudPlayResponse {

        @Nullable
        private final Long expires;

        @NotNull
        private final String iv;

        @NotNull
        private final String payload;

        @Nullable
        private final String tag;

        @Nullable
        private final Long ts;

        public static /* synthetic */ CloudPlayResponse copy$default(CloudPlayResponse cloudPlayResponse, String str, String str2, String str3, Long l, Long l2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cloudPlayResponse.payload;
            }
            if ((i & 2) != 0) {
                str2 = cloudPlayResponse.iv;
            }
            if ((i & 4) != 0) {
                str3 = cloudPlayResponse.tag;
            }
            if ((i & 8) != 0) {
                l = cloudPlayResponse.ts;
            }
            if ((i & 16) != 0) {
                l2 = cloudPlayResponse.expires;
            }
            Long l3 = l2;
            String str4 = str3;
            return cloudPlayResponse.copy(str, str2, str4, l, l3);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPayload() {
            return this.payload;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getIv() {
            return this.iv;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getTag() {
            return this.tag;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Long getTs() {
            return this.ts;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Long getExpires() {
            return this.expires;
        }

        @NotNull
        public final CloudPlayResponse copy(@NotNull String payload, @NotNull String iv, @Nullable String tag, @Nullable Long ts, @Nullable Long expires) {
            return new CloudPlayResponse(payload, iv, tag, ts, expires);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CloudPlayResponse)) {
                return false;
            }
            CloudPlayResponse cloudPlayResponse = (CloudPlayResponse) other;
            return Intrinsics.areEqual(this.payload, cloudPlayResponse.payload) && Intrinsics.areEqual(this.iv, cloudPlayResponse.iv) && Intrinsics.areEqual(this.tag, cloudPlayResponse.tag) && Intrinsics.areEqual(this.ts, cloudPlayResponse.ts) && Intrinsics.areEqual(this.expires, cloudPlayResponse.expires);
        }

        public int hashCode() {
            return (((((((this.payload.hashCode() * 31) + this.iv.hashCode()) * 31) + (this.tag == null ? 0 : this.tag.hashCode())) * 31) + (this.ts == null ? 0 : this.ts.hashCode())) * 31) + (this.expires != null ? this.expires.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "CloudPlayResponse(payload=" + this.payload + ", iv=" + this.iv + ", tag=" + this.tag + ", ts=" + this.ts + ", expires=" + this.expires + ')';
        }

        public CloudPlayResponse(@NotNull String payload, @NotNull String iv, @Nullable String tag, @Nullable Long ts, @Nullable Long expires) {
            this.payload = payload;
            this.iv = iv;
            this.tag = tag;
            this.ts = ts;
            this.expires = expires;
        }

        @NotNull
        public final String getPayload() {
            return this.payload;
        }

        @NotNull
        public final String getIv() {
            return this.iv;
        }

        @Nullable
        public final String getTag() {
            return this.tag;
        }

        @Nullable
        public final Long getTs() {
            return this.ts;
        }

        @Nullable
        public final Long getExpires() {
            return this.expires;
        }
    }

    /* JADX INFO: compiled from: CloudPlayProvider.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/phisher98/cloudplay/CloudPlay$CloudPlayStreams;", "", "streams", "", "Lcom/phisher98/cloudplay/CloudPlay$CloudPlayStream;", "<init>", "(Ljava/util/List;)V", "getStreams", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CloudPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class CloudPlayStreams {

        @NotNull
        private final List<CloudPlayStream> streams;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CloudPlayStreams copy$default(CloudPlayStreams cloudPlayStreams, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = cloudPlayStreams.streams;
            }
            return cloudPlayStreams.copy(list);
        }

        @NotNull
        public final List<CloudPlayStream> component1() {
            return this.streams;
        }

        @NotNull
        public final CloudPlayStreams copy(@NotNull List<CloudPlayStream> streams) {
            return new CloudPlayStreams(streams);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CloudPlayStreams) && Intrinsics.areEqual(this.streams, ((CloudPlayStreams) other).streams);
        }

        public int hashCode() {
            return this.streams.hashCode();
        }

        @NotNull
        public String toString() {
            return "CloudPlayStreams(streams=" + this.streams + ')';
        }

        public CloudPlayStreams(@NotNull List<CloudPlayStream> list) {
            this.streams = list;
        }

        @NotNull
        public final List<CloudPlayStream> getStreams() {
            return this.streams;
        }
    }

    /* JADX INFO: compiled from: CloudPlayProvider.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/phisher98/cloudplay/CloudPlay$CloudPlayStream;", "", "name", "", "url", "logo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getUrl", "getLogo", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "CloudPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class CloudPlayStream {

        @Nullable
        private final String logo;

        @Nullable
        private final String name;

        @NotNull
        private final String url;

        public static /* synthetic */ CloudPlayStream copy$default(CloudPlayStream cloudPlayStream, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cloudPlayStream.name;
            }
            if ((i & 2) != 0) {
                str2 = cloudPlayStream.url;
            }
            if ((i & 4) != 0) {
                str3 = cloudPlayStream.logo;
            }
            return cloudPlayStream.copy(str, str2, str3);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getLogo() {
            return this.logo;
        }

        @NotNull
        public final CloudPlayStream copy(@Nullable String name, @NotNull String url, @Nullable String logo) {
            return new CloudPlayStream(name, url, logo);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CloudPlayStream)) {
                return false;
            }
            CloudPlayStream cloudPlayStream = (CloudPlayStream) other;
            return Intrinsics.areEqual(this.name, cloudPlayStream.name) && Intrinsics.areEqual(this.url, cloudPlayStream.url) && Intrinsics.areEqual(this.logo, cloudPlayStream.logo);
        }

        public int hashCode() {
            return ((((this.name == null ? 0 : this.name.hashCode()) * 31) + this.url.hashCode()) * 31) + (this.logo != null ? this.logo.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "CloudPlayStream(name=" + this.name + ", url=" + this.url + ", logo=" + this.logo + ')';
        }

        public CloudPlayStream(@Nullable String name, @NotNull String url, @Nullable String logo) {
            this.name = name;
            this.url = url;
            this.logo = logo;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final String getLogo() {
            return this.logo;
        }
    }

    /* JADX INFO: compiled from: CloudPlayProvider.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0003J\u008d\u0001\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0001J\u0014\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010*\u001a\u00020+HÖ\u0081\u0004J\n\u0010,\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006-"}, d2 = {"Lcom/phisher98/cloudplay/CloudPlay$CloudPlayChannel;", "", "type", "", "id", "name", "group", "logo", "user_agent", "m3u8_url", "mpd_url", "license_url", "headers", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getType", "()Ljava/lang/String;", "getId", "getName", "getGroup", "getLogo", "getUser_agent", "getM3u8_url", "getMpd_url", "getLicense_url", "getHeaders", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "CloudPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class CloudPlayChannel {

        @Nullable
        private final String group;

        @Nullable
        private final Map<String, String> headers;

        @Nullable
        private final String id;

        @Nullable
        private final String license_url;

        @Nullable
        private final String logo;

        @Nullable
        private final String m3u8_url;

        @Nullable
        private final String mpd_url;

        @Nullable
        private final String name;

        @Nullable
        private final String type;

        @Nullable
        private final String user_agent;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CloudPlayChannel copy$default(CloudPlayChannel cloudPlayChannel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cloudPlayChannel.type;
            }
            if ((i & 2) != 0) {
                str2 = cloudPlayChannel.id;
            }
            if ((i & 4) != 0) {
                str3 = cloudPlayChannel.name;
            }
            if ((i & 8) != 0) {
                str4 = cloudPlayChannel.group;
            }
            if ((i & 16) != 0) {
                str5 = cloudPlayChannel.logo;
            }
            if ((i & 32) != 0) {
                str6 = cloudPlayChannel.user_agent;
            }
            if ((i & 64) != 0) {
                str7 = cloudPlayChannel.m3u8_url;
            }
            if ((i & 128) != 0) {
                str8 = cloudPlayChannel.mpd_url;
            }
            if ((i & 256) != 0) {
                str9 = cloudPlayChannel.license_url;
            }
            if ((i & 512) != 0) {
                map = cloudPlayChannel.headers;
            }
            String str10 = str9;
            Map map2 = map;
            String str11 = str7;
            String str12 = str8;
            String str13 = str5;
            String str14 = str6;
            return cloudPlayChannel.copy(str, str2, str3, str4, str13, str14, str11, str12, str10, map2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final Map<String, String> component10() {
            return this.headers;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @Nullable
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getGroup() {
            return this.group;
        }

        @Nullable
        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getLogo() {
            return this.logo;
        }

        @Nullable
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getUser_agent() {
            return this.user_agent;
        }

        @Nullable
        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getM3u8_url() {
            return this.m3u8_url;
        }

        @Nullable
        /* JADX INFO: renamed from: component8, reason: from getter */
        public final String getMpd_url() {
            return this.mpd_url;
        }

        @Nullable
        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getLicense_url() {
            return this.license_url;
        }

        @NotNull
        public final CloudPlayChannel copy(@Nullable String type, @Nullable String id, @Nullable String name, @Nullable String group, @Nullable String logo, @Nullable String user_agent, @Nullable String m3u8_url, @Nullable String mpd_url, @Nullable String license_url, @Nullable Map<String, String> headers) {
            return new CloudPlayChannel(type, id, name, group, logo, user_agent, m3u8_url, mpd_url, license_url, headers);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CloudPlayChannel)) {
                return false;
            }
            CloudPlayChannel cloudPlayChannel = (CloudPlayChannel) other;
            return Intrinsics.areEqual(this.type, cloudPlayChannel.type) && Intrinsics.areEqual(this.id, cloudPlayChannel.id) && Intrinsics.areEqual(this.name, cloudPlayChannel.name) && Intrinsics.areEqual(this.group, cloudPlayChannel.group) && Intrinsics.areEqual(this.logo, cloudPlayChannel.logo) && Intrinsics.areEqual(this.user_agent, cloudPlayChannel.user_agent) && Intrinsics.areEqual(this.m3u8_url, cloudPlayChannel.m3u8_url) && Intrinsics.areEqual(this.mpd_url, cloudPlayChannel.mpd_url) && Intrinsics.areEqual(this.license_url, cloudPlayChannel.license_url) && Intrinsics.areEqual(this.headers, cloudPlayChannel.headers);
        }

        public int hashCode() {
            return ((((((((((((((((((this.type == null ? 0 : this.type.hashCode()) * 31) + (this.id == null ? 0 : this.id.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.group == null ? 0 : this.group.hashCode())) * 31) + (this.logo == null ? 0 : this.logo.hashCode())) * 31) + (this.user_agent == null ? 0 : this.user_agent.hashCode())) * 31) + (this.m3u8_url == null ? 0 : this.m3u8_url.hashCode())) * 31) + (this.mpd_url == null ? 0 : this.mpd_url.hashCode())) * 31) + (this.license_url == null ? 0 : this.license_url.hashCode())) * 31) + (this.headers != null ? this.headers.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "CloudPlayChannel(type=" + this.type + ", id=" + this.id + ", name=" + this.name + ", group=" + this.group + ", logo=" + this.logo + ", user_agent=" + this.user_agent + ", m3u8_url=" + this.m3u8_url + ", mpd_url=" + this.mpd_url + ", license_url=" + this.license_url + ", headers=" + this.headers + ')';
        }

        public CloudPlayChannel(@Nullable String type, @Nullable String id, @Nullable String name, @Nullable String group, @Nullable String logo, @Nullable String user_agent, @Nullable String m3u8_url, @Nullable String mpd_url, @Nullable String license_url, @Nullable Map<String, String> map) {
            this.type = type;
            this.id = id;
            this.name = name;
            this.group = group;
            this.logo = logo;
            this.user_agent = user_agent;
            this.m3u8_url = m3u8_url;
            this.mpd_url = mpd_url;
            this.license_url = license_url;
            this.headers = map;
        }

        @Nullable
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getGroup() {
            return this.group;
        }

        @Nullable
        public final String getLogo() {
            return this.logo;
        }

        @Nullable
        public final String getUser_agent() {
            return this.user_agent;
        }

        @Nullable
        public final String getM3u8_url() {
            return this.m3u8_url;
        }

        @Nullable
        public final String getMpd_url() {
            return this.mpd_url;
        }

        @Nullable
        public final String getLicense_url() {
            return this.license_url;
        }

        @Nullable
        public final Map<String, String> getHeaders() {
            return this.headers;
        }
    }
}
