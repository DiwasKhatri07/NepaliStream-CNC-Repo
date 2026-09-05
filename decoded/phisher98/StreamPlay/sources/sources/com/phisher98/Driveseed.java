package com.phisher98;

import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.net.URI;
import java.nio.charset.Charset;
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
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u0013JH\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001a0\u001d2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001a0\u001dH\u0096@¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006$"}, d2 = {"Lcom/phisher98/Driveseed;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getIndexQuality", "", "str", "instantLink", "finallink", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CFType1", "", "url", "resumeCloudLink", "resumeBot", "getUrl", "", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanTitle", "title", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/Driveseed\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,4003:1\n1#2:4004\n1#2:4016\n1795#3,10:4005\n2068#3:4015\n2069#3:4017\n1805#3:4018\n2068#3,2:4019\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/Driveseed\n*L\n1280#1:4016\n1280#1:4005,10\n1280#1:4015\n1280#1:4017\n1280#1:4018\n1397#1:4019,2\n*E\n"})
public class Driveseed extends ExtractorApi {
    private final boolean requiresReferer;

    @NotNull
    private final String name = "Driveseed";

    @NotNull
    private final String mainUrl = "https://driveseed.org";

    /* JADX INFO: renamed from: com.phisher98.Driveseed$CFType1$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Driveseed", f = "Extractors.kt", i = {0, 0, 0}, l = {1278}, m = "CFType1", n = {"url", "cfWorkersLink", "$this$CFType1_u24lambda_u240"}, nl = {1279}, s = {"L$0", "L$1", "L$2"}, v = 2)
    static final class C00091 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C00091(Continuation<? super C00091> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Driveseed.this.CFType1(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Driveseed$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Driveseed", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, l = {1339, 1344, 1346, 1369, 1371, 1384, 1386, 1397, 1399, 1411, 1413}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "temp", "$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "document", "qualityText", "parsed", "size", "labelExtras", "instantUrl", "$this", "url", "referer", "subtitleCallback", "callback", "document", "qualityText", "parsed", "size", "labelExtras", "instantUrl", "link", "$this", "url", "referer", "subtitleCallback", "callback", "document", "qualityText", "parsed", "size", "labelExtras", "instantUrl", "resumeBotUrl", "$this", "url", "referer", "subtitleCallback", "callback", "document", "qualityText", "parsed", "size", "labelExtras", "instantUrl", "resumeBotUrl", "link", "$this", "url", "referer", "subtitleCallback", "callback", "document", "qualityText", "parsed", "size", "labelExtras", "instantUrl", "resumeBotUrl", "$this", "url", "referer", "subtitleCallback", "callback", "document", "qualityText", "parsed", "size", "labelExtras", "instantUrl", "resumeBotUrl", "$this$forEach$iv", "element$iv", "link", "$this", "url", "referer", "subtitleCallback", "callback", "document", "qualityText", "parsed", "size", "labelExtras", "instantUrl", "resumeBotUrl", "resumeCloudUrl", "$this", "url", "referer", "subtitleCallback", "callback", "document", "qualityText", "parsed", "size", "labelExtras", "instantUrl", "resumeBotUrl", "resumeCloudUrl", "link"}, nl = {1340, 1346, 1348, 1370, 1370, 1385, 1385, 4004, 1398, 1412, 1412}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$14", "L$15", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13"}, v = 2)
    static final class C00101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
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

        C00101(Continuation<? super C00101> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Driveseed.getUrl$suspendImpl(Driveseed.this, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Driveseed$instantLink$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Driveseed", f = "Extractors.kt", i = {0, 0, 1, 1, 1, 1}, l = {1250, 1261}, m = "instantLink", n = {"finallink", "$this$instantLink_u24lambda_u240", "finallink", "url", "token", "$this$instantLink_u24lambda_u241"}, nl = {1250, 1269}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3"}, v = 2)
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
            return Driveseed.this.instantLink(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Driveseed$resumeBot$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Driveseed", f = "Extractors.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {1310, 1319}, m = "resumeBot", n = {"url", "$this$resumeBot_u24lambda_u240", "url", "$this$resumeBot_u24lambda_u240", "response", "docString", "ssid", "path", "baseUrl", "token"}, nl = {1311, 1325}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    static final class C00121 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C00121(Continuation<? super C00121> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Driveseed.this.resumeBot(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Driveseed$resumeCloudLink$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Driveseed", f = "Extractors.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {1287, 1292}, m = "resumeCloudLink", n = {"url", "resumeCloudUrl", "$this$resumeCloudLink_u24lambda_u240", "url", "resumeCloudUrl", "$this$resumeCloudLink_u24lambda_u240", "doc", "host", "key"}, nl = {1288, 1300}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00131 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00131(Continuation<? super C00131> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Driveseed.this.resumeCloudLink(null, (Continuation) this);
        }
    }

    @Nullable
    public Object getUrl(@NotNull String str, @Nullable String str2, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        return getUrl$suspendImpl(this, str, str2, function1, function2, continuation);
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public String getMainUrl() {
        return this.mainUrl;
    }

    public boolean getRequiresReferer() {
        return this.requiresReferer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getIndexQuality(String str) {
        return ExtractorsKt.extractIndexQuality$default(str, 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x010a  */
    /* JADX WARN: Code duplicated, block: B:45:0x0110 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x0111  */
    /* JADX WARN: Code duplicated, block: B:48:0x0122 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x0123  */
    /* JADX WARN: Code duplicated, block: B:53:0x0140 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:54:0x0141  */
    /* JADX WARN: Code duplicated, block: B:56:0x014e  */
    /* JADX WARN: Code duplicated, block: B:57:0x0151  */
    /* JADX WARN: Code duplicated, block: B:64:0x0212 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:65:0x0213  */
    /* JADX WARN: Code duplicated, block: B:68:0x0239  */
    /* JADX WARN: Code duplicated, block: B:69:0x023c  */
    /* JADX WARN: Code duplicated, block: B:71:0x0240 A[Catch: all -> 0x0256, TryCatch #4 {all -> 0x0256, blocks: (B:66:0x021c, B:71:0x0240, B:73:0x0251), top: B:94:0x021c }] */
    /* JADX WARN: Code duplicated, block: B:72:0x024f  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:84:0x027e  */
    public final Object instantLink(String finallink, Continuation<? super String> continuation) {
        C00111 c00111;
        C00111 c00112;
        Object obj;
        Object obj2;
        char c;
        String finallink2;
        String finallink3;
        Object obj3;
        Object obj4;
        String str;
        String str2;
        Object objPost$default;
        Object obj5;
        String resolvedUrl;
        String actualUrl;
        Object obj6;
        Object obj7;
        String it;
        String str3;
        String strReplace$default;
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
        C00111 c00113 = c00111;
        Object $result = c00113.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00113.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (StringsKt.contains$default(finallink, "cdn.video-gen.xyz", false, 2, (Object) null)) {
                    try {
                        Result.Companion companion = Result.Companion;
                        Driveseed $this$instantLink_u24lambda_u240 = this;
                        Requests app = MainActivityKt.getApp();
                        c00113.L$0 = finallink;
                        c00113.L$1 = SpillingKt.nullOutSpilledVariable($this$instantLink_u24lambda_u240);
                        c00113.label = 1;
                        c = 1;
                        obj2 = null;
                        obj = coroutine_suspended;
                        try {
                            $result = Requests.get$default(app, finallink, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00113, 4094, (Object) null);
                            c00112 = c00113;
                            if ($result == obj) {
                                return obj;
                            }
                            finallink2 = finallink;
                            try {
                                obj3 = Result.constructor-impl(((NiceResponse) $result).getUrl());
                            } catch (Throwable th) {
                                th = th;
                                Result.Companion companion2 = Result.Companion;
                                obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            obj5 = obj3;
                            if (Result.isFailure-impl(obj5)) {
                                obj5 = obj2;
                            }
                            resolvedUrl = (String) obj5;
                            if (resolvedUrl == null) {
                                return obj2;
                            }
                            actualUrl = StringsKt.substringAfter(resolvedUrl, "url=", "");
                            if (!StringsKt.isBlank(actualUrl)) {
                                return actualUrl;
                            }
                            finallink3 = finallink2;
                            break;
                        } catch (Throwable th2) {
                            th = th2;
                            c00112 = c00113;
                            finallink2 = finallink;
                            Result.Companion companion3 = Result.Companion;
                            obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                            obj5 = obj3;
                            if (Result.isFailure-impl(obj5)) {
                                obj5 = obj2;
                            }
                            resolvedUrl = (String) obj5;
                            if (resolvedUrl == null) {
                                return obj2;
                            }
                            actualUrl = StringsKt.substringAfter(resolvedUrl, "url=", "");
                            if (!StringsKt.isBlank(actualUrl)) {
                                return actualUrl;
                            }
                            finallink3 = finallink2;
                            obj4 = obj2;
                            if (!StringsKt.contains$default(finallink3, "?url=", false, 2, obj4)) {
                                return finallink3;
                            }
                            if (StringsKt.contains$default(finallink3, "video-leech", false, 2, obj4)) {
                                str = "video-leech.xyz";
                            } else {
                                str = "video-seed.xyz";
                            }
                            String url = str;
                            String token = StringsKt.substringAfter$default(finallink3, "https://" + url + "/?url=", (String) null, 2, (Object) null);
                            try {
                                Result.Companion companion4 = Result.Companion;
                                Driveseed $this$instantLink_u24lambda_u241 = this;
                                Requests app2 = MainActivityKt.getApp();
                                String str4 = "https://" + url + "/api";
                                Map mapMapOf = MapsKt.mapOf(TuplesKt.to("keys", token));
                                Pair[] pairArr = new Pair[2];
                                pairArr[0] = TuplesKt.to("x-token", url);
                                pairArr[c] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36");
                                Map mapMapOf2 = MapsKt.mapOf(pairArr);
                                c00112.L$0 = SpillingKt.nullOutSpilledVariable(finallink3);
                                c00112.L$1 = SpillingKt.nullOutSpilledVariable(url);
                                c00112.L$2 = SpillingKt.nullOutSpilledVariable(token);
                                c00112.L$3 = SpillingKt.nullOutSpilledVariable($this$instantLink_u24lambda_u241);
                                c00112.label = 2;
                                str2 = null;
                                try {
                                    objPost$default = Requests.post$default(app2, str4, mapMapOf2, finallink3, (Map) null, (Map) null, mapMapOf, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00112, 65496, (Object) null);
                                    if (objPost$default == obj) {
                                        return obj;
                                    }
                                    $result = objPost$default;
                                    try {
                                        String downloadlink = ((NiceResponse) $result).getText();
                                        it = new JSONObject(downloadlink).optString("url");
                                        if (StringsKt.isBlank(it)) {
                                            str3 = str2;
                                        } else {
                                            str3 = it;
                                        }
                                        if (str3 != null) {
                                            strReplace$default = StringsKt.replace$default(str3, "\\/", "/", false, 4, (Object) null);
                                        } else {
                                            strReplace$default = str2;
                                        }
                                        obj6 = Result.constructor-impl(strReplace$default);
                                        break;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        Result.Companion companion5 = Result.Companion;
                                        obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                                    }
                                    obj7 = obj6;
                                    if (Result.isFailure-impl(obj7)) {
                                        return str2;
                                    }
                                    return obj7;
                                } catch (Throwable th4) {
                                    th = th4;
                                    Result.Companion companion6 = Result.Companion;
                                    obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                                    obj7 = obj6;
                                    if (Result.isFailure-impl(obj7)) {
                                        return str2;
                                    }
                                    return obj7;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                str2 = null;
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        c00112 = c00113;
                        obj = coroutine_suspended;
                        obj2 = null;
                        c = 1;
                        finallink2 = finallink;
                    }
                } else {
                    c00112 = c00113;
                    obj = coroutine_suspended;
                    obj2 = null;
                    c = 1;
                    finallink3 = finallink;
                }
                obj4 = obj2;
                if (!StringsKt.contains$default(finallink3, "?url=", false, 2, obj4)) {
                    return finallink3;
                }
                if (StringsKt.contains$default(finallink3, "video-leech", false, 2, obj4)) {
                    str = "video-leech.xyz";
                } else {
                    str = "video-seed.xyz";
                }
                String url2 = str;
                String token2 = StringsKt.substringAfter$default(finallink3, "https://" + url2 + "/?url=", (String) null, 2, (Object) null);
                Result.Companion companion7 = Result.Companion;
                Driveseed $this$instantLink_u24lambda_u242 = this;
                Requests app3 = MainActivityKt.getApp();
                String str5 = "https://" + url2 + "/api";
                Map mapMapOf3 = MapsKt.mapOf(TuplesKt.to("keys", token2));
                Pair[] pairArr2 = new Pair[2];
                pairArr2[0] = TuplesKt.to("x-token", url2);
                pairArr2[c] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36");
                Map mapMapOf4 = MapsKt.mapOf(pairArr2);
                c00112.L$0 = SpillingKt.nullOutSpilledVariable(finallink3);
                c00112.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00112.L$2 = SpillingKt.nullOutSpilledVariable(token2);
                c00112.L$3 = SpillingKt.nullOutSpilledVariable($this$instantLink_u24lambda_u242);
                c00112.label = 2;
                str2 = null;
                objPost$default = Requests.post$default(app3, str5, mapMapOf4, finallink3, (Map) null, (Map) null, mapMapOf3, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00112, 65496, (Object) null);
                if (objPost$default == obj) {
                    return obj;
                }
                $result = objPost$default;
                String downloadlink2 = ((NiceResponse) $result).getText();
                it = new JSONObject(downloadlink2).optString("url");
                if (StringsKt.isBlank(it)) {
                    str3 = it;
                } else {
                    str3 = str2;
                }
                if (str3 != null) {
                    strReplace$default = StringsKt.replace$default(str3, "\\/", "/", false, 4, (Object) null);
                } else {
                    strReplace$default = str2;
                }
                obj6 = Result.constructor-impl(strReplace$default);
                obj7 = obj6;
                if (Result.isFailure-impl(obj7)) {
                    return str2;
                }
                return obj7;
            case 1:
                finallink2 = (String) c00113.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    c00112 = c00113;
                    obj = coroutine_suspended;
                    obj2 = null;
                    c = 1;
                    obj3 = Result.constructor-impl(((NiceResponse) $result).getUrl());
                    break;
                } catch (Throwable th7) {
                    th = th7;
                    c00112 = c00113;
                    obj = coroutine_suspended;
                    obj2 = null;
                    c = 1;
                    Result.Companion companion8 = Result.Companion;
                    obj3 = Result.constructor-impl(ResultKt.createFailure(th));
                    obj5 = obj3;
                    if (Result.isFailure-impl(obj5)) {
                        obj5 = obj2;
                    }
                    resolvedUrl = (String) obj5;
                    if (resolvedUrl == null) {
                        return obj2;
                    }
                    actualUrl = StringsKt.substringAfter(resolvedUrl, "url=", "");
                    if (!StringsKt.isBlank(actualUrl)) {
                        return actualUrl;
                    }
                    finallink3 = finallink2;
                    obj4 = obj2;
                    if (!StringsKt.contains$default(finallink3, "?url=", false, 2, obj4)) {
                        return finallink3;
                    }
                    if (StringsKt.contains$default(finallink3, "video-leech", false, 2, obj4)) {
                        str = "video-leech.xyz";
                    } else {
                        str = "video-seed.xyz";
                    }
                    String url3 = str;
                    String token3 = StringsKt.substringAfter$default(finallink3, "https://" + url3 + "/?url=", (String) null, 2, (Object) null);
                    Result.Companion companion9 = Result.Companion;
                    Driveseed $this$instantLink_u24lambda_u243 = this;
                    Requests app4 = MainActivityKt.getApp();
                    String str6 = "https://" + url3 + "/api";
                    Map mapMapOf5 = MapsKt.mapOf(TuplesKt.to("keys", token3));
                    Pair[] pairArr3 = new Pair[2];
                    pairArr3[0] = TuplesKt.to("x-token", url3);
                    pairArr3[c] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36");
                    Map mapMapOf6 = MapsKt.mapOf(pairArr3);
                    c00112.L$0 = SpillingKt.nullOutSpilledVariable(finallink3);
                    c00112.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                    c00112.L$2 = SpillingKt.nullOutSpilledVariable(token3);
                    c00112.L$3 = SpillingKt.nullOutSpilledVariable($this$instantLink_u24lambda_u243);
                    c00112.label = 2;
                    str2 = null;
                    objPost$default = Requests.post$default(app4, str6, mapMapOf6, finallink3, (Map) null, (Map) null, mapMapOf5, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00112, 65496, (Object) null);
                    if (objPost$default == obj) {
                        return obj;
                    }
                    $result = objPost$default;
                    String downloadlink3 = ((NiceResponse) $result).getText();
                    it = new JSONObject(downloadlink3).optString("url");
                    if (StringsKt.isBlank(it)) {
                        str3 = it;
                    } else {
                        str3 = str2;
                    }
                    if (str3 != null) {
                        strReplace$default = StringsKt.replace$default(str3, "\\/", "/", false, 4, (Object) null);
                    } else {
                        strReplace$default = str2;
                    }
                    obj6 = Result.constructor-impl(strReplace$default);
                    obj7 = obj6;
                    if (Result.isFailure-impl(obj7)) {
                        return str2;
                    }
                    return obj7;
                }
                obj5 = obj3;
                if (Result.isFailure-impl(obj5)) {
                    obj5 = obj2;
                }
                resolvedUrl = (String) obj5;
                if (resolvedUrl == null) {
                    return obj2;
                }
                actualUrl = StringsKt.substringAfter(resolvedUrl, "url=", "");
                if (!StringsKt.isBlank(actualUrl)) {
                    return actualUrl;
                }
                finallink3 = finallink2;
                obj4 = obj2;
                if (!StringsKt.contains$default(finallink3, "?url=", false, 2, obj4)) {
                    return finallink3;
                }
                if (StringsKt.contains$default(finallink3, "video-leech", false, 2, obj4)) {
                    str = "video-leech.xyz";
                } else {
                    str = "video-seed.xyz";
                }
                String url4 = str;
                String token4 = StringsKt.substringAfter$default(finallink3, "https://" + url4 + "/?url=", (String) null, 2, (Object) null);
                Result.Companion companion10 = Result.Companion;
                Driveseed $this$instantLink_u24lambda_u244 = this;
                Requests app5 = MainActivityKt.getApp();
                String str7 = "https://" + url4 + "/api";
                Map mapMapOf7 = MapsKt.mapOf(TuplesKt.to("keys", token4));
                Pair[] pairArr4 = new Pair[2];
                pairArr4[0] = TuplesKt.to("x-token", url4);
                pairArr4[c] = TuplesKt.to("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36");
                Map mapMapOf8 = MapsKt.mapOf(pairArr4);
                c00112.L$0 = SpillingKt.nullOutSpilledVariable(finallink3);
                c00112.L$1 = SpillingKt.nullOutSpilledVariable(url4);
                c00112.L$2 = SpillingKt.nullOutSpilledVariable(token4);
                c00112.L$3 = SpillingKt.nullOutSpilledVariable($this$instantLink_u24lambda_u244);
                c00112.label = 2;
                str2 = null;
                objPost$default = Requests.post$default(app5, str7, mapMapOf8, finallink3, (Map) null, (Map) null, mapMapOf7, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00112, 65496, (Object) null);
                if (objPost$default == obj) {
                    return obj;
                }
                $result = objPost$default;
                String downloadlink4 = ((NiceResponse) $result).getText();
                it = new JSONObject(downloadlink4).optString("url");
                if (StringsKt.isBlank(it)) {
                    str3 = it;
                } else {
                    str3 = str2;
                }
                if (str3 != null) {
                    strReplace$default = StringsKt.replace$default(str3, "\\/", "/", false, 4, (Object) null);
                } else {
                    strReplace$default = str2;
                }
                obj6 = Result.constructor-impl(strReplace$default);
                obj7 = obj6;
                if (Result.isFailure-impl(obj7)) {
                    return str2;
                }
                return obj7;
            case 2:
                try {
                    ResultKt.throwOnFailure($result);
                    str2 = null;
                    String downloadlink5 = ((NiceResponse) $result).getText();
                    it = new JSONObject(downloadlink5).optString("url");
                    if (StringsKt.isBlank(it)) {
                        str3 = it;
                    } else {
                        str3 = str2;
                    }
                    if (str3 != null) {
                        strReplace$default = StringsKt.replace$default(str3, "\\/", "/", false, 4, (Object) null);
                    } else {
                        strReplace$default = str2;
                    }
                    obj6 = Result.constructor-impl(strReplace$default);
                    break;
                } catch (Throwable th8) {
                    th = th8;
                    str2 = null;
                    Result.Companion companion11 = Result.Companion;
                    obj6 = Result.constructor-impl(ResultKt.createFailure(th));
                    obj7 = obj6;
                    if (Result.isFailure-impl(obj7)) {
                        return str2;
                    }
                    return obj7;
                }
                obj7 = obj6;
                if (Result.isFailure-impl(obj7)) {
                    return str2;
                }
                return obj7;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:27:0x00ec A[Catch: all -> 0x0144, TryCatch #0 {all -> 0x0144, blocks: (B:24:0x00c7, B:25:0x00e6, B:27:0x00ec, B:32:0x0124, B:34:0x0133), top: B:48:0x00c7 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x011e  */
    /* JADX WARN: Code duplicated, block: B:30:0x0121  */
    /* JADX WARN: Code duplicated, block: B:32:0x0124 A[Catch: all -> 0x0144, TryCatch #0 {all -> 0x0144, blocks: (B:24:0x00c7, B:25:0x00e6, B:27:0x00ec, B:32:0x0124, B:34:0x0133), top: B:48:0x00c7 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0165  */
    /* JADX WARN: Code duplicated, block: B:58:0x0128 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object CFType1(String url, Continuation<? super List<String>> continuation) {
        C00091 c00091;
        int i;
        Object obj;
        Iterable $this$mapNotNull$iv;
        int $i$f$mapNotNull;
        Collection destination$iv$iv;
        String href;
        String str;
        if (continuation instanceof C00091) {
            c00091 = (C00091) continuation;
            if ((c00091.label & Integer.MIN_VALUE) != 0) {
                c00091.label -= Integer.MIN_VALUE;
            } else {
                c00091 = new C00091(continuation);
            }
        } else {
            c00091 = new C00091(continuation);
        }
        C00091 c00092 = c00091;
        Object $result = c00092.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00092.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String cfWorkersLink = StringsKt.replace$default(url, "/file", "/wfile", false, 4, (Object) null) + "?type=1";
                try {
                    Result.Companion companion = Result.Companion;
                    Driveseed $this$CFType1_u24lambda_u240 = this;
                    Requests app = MainActivityKt.getApp();
                    c00092.L$0 = SpillingKt.nullOutSpilledVariable(url);
                    c00092.L$1 = SpillingKt.nullOutSpilledVariable(cfWorkersLink);
                    c00092.L$2 = SpillingKt.nullOutSpilledVariable($this$CFType1_u24lambda_u240);
                    c00092.label = 1;
                    try {
                        Object obj2 = Requests.get$default(app, cfWorkersLink, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00092, 4094, (Object) null);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i = 0;
                        $result = obj2;
                        try {
                            $this$mapNotNull$iv = ((NiceResponse) $result).getDocument().select("a.btn-success");
                            $i$f$mapNotNull = 0;
                            destination$iv$iv = new ArrayList();
                            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                Element it = (Element) element$iv$iv$iv;
                                int i2 = i;
                                href = it.attr("href");
                                Iterable $this$mapNotNull$iv2 = $this$mapNotNull$iv;
                                int $i$f$mapNotNull2 = $i$f$mapNotNull;
                                if (StringsKt.startsWith$default(href, "http", false, 2, (Object) null)) {
                                    str = null;
                                }
                                if (str != null) {
                                    str = href;
                                    destination$iv$iv.add(str);
                                } else {
                                    str = href;
                                }
                                i = i2;
                                $this$mapNotNull$iv = $this$mapNotNull$iv2;
                                $i$f$mapNotNull = $i$f$mapNotNull2;
                            }
                            obj = Result.constructor-impl((List) destination$iv$iv);
                            break;
                        } catch (Throwable th) {
                            th = th;
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.exceptionOrNull-impl(obj) == null) {
                            return obj;
                        }
                        return CollectionsKt.emptyList();
                    } catch (Throwable th2) {
                        th = th2;
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                        if (Result.exceptionOrNull-impl(obj) == null) {
                            return obj;
                        }
                        return CollectionsKt.emptyList();
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
                break;
            case 1:
                i = 0;
                try {
                    ResultKt.throwOnFailure($result);
                    $this$mapNotNull$iv = ((NiceResponse) $result).getDocument().select("a.btn-success");
                    $i$f$mapNotNull = 0;
                    destination$iv$iv = new ArrayList();
                    while (r13.hasNext()) {
                        Element it2 = (Element) element$iv$iv$iv;
                        int i3 = i;
                        href = it2.attr("href");
                        Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv;
                        int $i$f$mapNotNull3 = $i$f$mapNotNull;
                        if (StringsKt.startsWith$default(href, "http", false, 2, (Object) null)) {
                            str = null;
                        }
                        if (str != null) {
                            str = href;
                            destination$iv$iv.add(str);
                        } else {
                            str = href;
                        }
                        i = i3;
                        $this$mapNotNull$iv = $this$mapNotNull$iv3;
                        $i$f$mapNotNull = $i$f$mapNotNull3;
                    }
                    obj = Result.constructor-impl((List) destination$iv$iv);
                    break;
                } catch (Throwable th4) {
                    th = th4;
                    Result.Companion companion4 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                    if (Result.exceptionOrNull-impl(obj) == null) {
                        return obj;
                    }
                    return CollectionsKt.emptyList();
                }
                if (Result.exceptionOrNull-impl(obj) == null) {
                    return obj;
                }
                return CollectionsKt.emptyList();
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x011c A[Catch: all -> 0x0124, TRY_LEAVE, TryCatch #2 {all -> 0x0124, blocks: (B:32:0x0116, B:34:0x011c), top: B:99:0x0116 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x012a  */
    /* JADX WARN: Code duplicated, block: B:45:0x01e9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:49:0x0212  */
    /* JADX WARN: Code duplicated, block: B:50:0x0215  */
    /* JADX WARN: Code duplicated, block: B:52:0x0219 A[Catch: all -> 0x0236, TRY_LEAVE, TryCatch #3 {all -> 0x0236, blocks: (B:47:0x01f5, B:52:0x0219), top: B:101:0x01f5 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x022e  */
    /* JADX WARN: Code duplicated, block: B:61:0x0247  */
    /* JADX WARN: Code duplicated, block: B:64:0x0255 A[Catch: all -> 0x027d, TryCatch #10 {all -> 0x027d, blocks: (B:62:0x024d, B:64:0x0255), top: B:115:0x024d }] */
    /* JADX WARN: Code duplicated, block: B:73:0x026f  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:93:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:95:0x012e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x0116 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final Object resumeCloudLink(String url, Continuation<? super String> continuation) {
        C00131 c00131;
        String str;
        String str2;
        C00131 c00132;
        String url2;
        String resumeCloudUrl;
        int i;
        Driveseed $this$resumeCloudLink_u24lambda_u240;
        Document doc;
        MatchResult matchResultFind$default;
        List groupValues;
        char c;
        String key;
        String key2;
        Object objPost$default;
        String key3;
        int i2;
        Driveseed $this$resumeCloudLink_u24lambda_u241;
        Element elementSelectFirst;
        String strReplace$default;
        String it;
        Object obj;
        Object obj2;
        String it2;
        String str3;
        if (continuation instanceof C00131) {
            c00131 = (C00131) continuation;
            if ((c00131.label & Integer.MIN_VALUE) != 0) {
                c00131.label -= Integer.MIN_VALUE;
            } else {
                c00131 = new C00131(continuation);
            }
        } else {
            c00131 = new C00131(continuation);
        }
        C00131 c00133 = c00131;
        Object $result = c00133.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00133.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                String resumeCloudUrl2 = getMainUrl() + url;
                try {
                    Result.Companion companion = Result.Companion;
                    Driveseed $this$resumeCloudLink_u24lambda_u242 = this;
                    Requests app = MainActivityKt.getApp();
                    c00133.L$0 = SpillingKt.nullOutSpilledVariable(url);
                    c00133.L$1 = resumeCloudUrl2;
                    c00133.L$2 = $this$resumeCloudLink_u24lambda_u242;
                    c00133.label = 1;
                    str2 = null;
                    try {
                        Object obj3 = Requests.get$default(app, resumeCloudUrl2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00133, 4094, (Object) null);
                        c00132 = c00133;
                        if (obj3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url2 = url;
                        resumeCloudUrl = resumeCloudUrl2;
                        i = 0;
                        $this$resumeCloudLink_u24lambda_u240 = $this$resumeCloudLink_u24lambda_u242;
                        $result = obj3;
                        try {
                            doc = ((NiceResponse) $result).getDocument();
                            matchResultFind$default = Regex.find$default(new Regex("formData\\.append\\(\\s*[\"']key[\"']\\s*,\\s*[\"']([^\"']+)[\"']\\s*\\)"), doc.html(), 0, 2, str2);
                            if (matchResultFind$default != null) {
                                try {
                                    groupValues = matchResultFind$default.getGroupValues();
                                    if (groupValues != null) {
                                        c = 1;
                                        key = (String) CollectionsKt.getOrNull(groupValues, 1);
                                    } else {
                                        c = 1;
                                        key = str2;
                                    }
                                    if (key == null) {
                                        try {
                                            String host = new URI($this$resumeCloudLink_u24lambda_u240.getMainUrl()).getHost();
                                            Requests app2 = MainActivityKt.getApp();
                                            Pair[] pairArr = new Pair[3];
                                            pairArr[0] = TuplesKt.to("action", "cloud");
                                            pairArr[c] = TuplesKt.to("key", key);
                                            pairArr[2] = TuplesKt.to("action_token", "");
                                            Map mapMapOf = MapsKt.mapOf(pairArr);
                                            Pair[] pairArr2 = new Pair[2];
                                            pairArr2[0] = TuplesKt.to("x-token", host);
                                            pairArr2[c] = TuplesKt.to("X-Requested-With", "XMLHttpRequest");
                                            Map mapMapOf2 = MapsKt.mapOf(pairArr2);
                                            c00132.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                            c00132.L$1 = SpillingKt.nullOutSpilledVariable(resumeCloudUrl);
                                            c00132.L$2 = SpillingKt.nullOutSpilledVariable($this$resumeCloudLink_u24lambda_u240);
                                            c00132.L$3 = SpillingKt.nullOutSpilledVariable(doc);
                                            c00132.L$4 = SpillingKt.nullOutSpilledVariable(host);
                                            c00132.L$5 = SpillingKt.nullOutSpilledVariable(key);
                                            c00132.label = 2;
                                            String host2 = resumeCloudUrl;
                                            key2 = key;
                                            try {
                                                objPost$default = Requests.post$default(app2, host2, mapMapOf2, host2, (Map) null, (Map) null, mapMapOf, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00132, 65496, (Object) null);
                                                if (objPost$default == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                key3 = key2;
                                                i2 = i;
                                                $this$resumeCloudLink_u24lambda_u241 = $this$resumeCloudLink_u24lambda_u240;
                                                $result = objPost$default;
                                                try {
                                                    String json = ((NiceResponse) $result).getText();
                                                    it2 = new JSONObject(json).optString("url");
                                                    if (StringsKt.isBlank(it2)) {
                                                        str3 = null;
                                                    } else {
                                                        str3 = it2;
                                                    }
                                                    if (str3 != null) {
                                                        strReplace$default = StringsKt.replace$default(str3, "\\/", "/", false, 4, (Object) null);
                                                        str = null;
                                                    } else {
                                                        strReplace$default = null;
                                                        str = null;
                                                    }
                                                    try {
                                                        obj = Result.constructor-impl(strReplace$default);
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        Result.Companion companion2 = Result.Companion;
                                                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    str = null;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                str = null;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            str = null;
                                        }
                                    } else {
                                        try {
                                            elementSelectFirst = doc.selectFirst("a.btn-success");
                                            if (elementSelectFirst == null || (it = elementSelectFirst.attr("href")) == null) {
                                                str = null;
                                            } else {
                                                str = null;
                                                try {
                                                    if (StringsKt.startsWith$default(it, "http", false, 2, (Object) null)) {
                                                        strReplace$default = it;
                                                    }
                                                    obj = Result.constructor-impl(strReplace$default);
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                }
                                            }
                                            strReplace$default = str;
                                            obj = Result.constructor-impl(strReplace$default);
                                        } catch (Throwable th6) {
                                            th = th6;
                                            str = null;
                                        }
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    str = str2;
                                }
                                Result.Companion companion3 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                            } else {
                                c = 1;
                                key = str2;
                                if (key == null) {
                                    elementSelectFirst = doc.selectFirst("a.btn-success");
                                    if (elementSelectFirst == null) {
                                        str = null;
                                        strReplace$default = str;
                                        obj = Result.constructor-impl(strReplace$default);
                                    } else {
                                        str = null;
                                        strReplace$default = str;
                                        obj = Result.constructor-impl(strReplace$default);
                                    }
                                } else {
                                    String host3 = new URI($this$resumeCloudLink_u24lambda_u240.getMainUrl()).getHost();
                                    Requests app3 = MainActivityKt.getApp();
                                    Pair[] pairArr3 = new Pair[3];
                                    pairArr3[0] = TuplesKt.to("action", "cloud");
                                    pairArr3[c] = TuplesKt.to("key", key);
                                    pairArr3[2] = TuplesKt.to("action_token", "");
                                    Map mapMapOf3 = MapsKt.mapOf(pairArr3);
                                    Pair[] pairArr4 = new Pair[2];
                                    pairArr4[0] = TuplesKt.to("x-token", host3);
                                    pairArr4[c] = TuplesKt.to("X-Requested-With", "XMLHttpRequest");
                                    Map mapMapOf4 = MapsKt.mapOf(pairArr4);
                                    c00132.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                    c00132.L$1 = SpillingKt.nullOutSpilledVariable(resumeCloudUrl);
                                    c00132.L$2 = SpillingKt.nullOutSpilledVariable($this$resumeCloudLink_u24lambda_u240);
                                    c00132.L$3 = SpillingKt.nullOutSpilledVariable(doc);
                                    c00132.L$4 = SpillingKt.nullOutSpilledVariable(host3);
                                    c00132.L$5 = SpillingKt.nullOutSpilledVariable(key);
                                    c00132.label = 2;
                                    String host4 = resumeCloudUrl;
                                    key2 = key;
                                    objPost$default = Requests.post$default(app3, host4, mapMapOf4, host4, (Map) null, (Map) null, mapMapOf3, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00132, 65496, (Object) null);
                                    if (objPost$default == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    key3 = key2;
                                    i2 = i;
                                    $this$resumeCloudLink_u24lambda_u241 = $this$resumeCloudLink_u24lambda_u240;
                                    $result = objPost$default;
                                    String json2 = ((NiceResponse) $result).getText();
                                    it2 = new JSONObject(json2).optString("url");
                                    if (StringsKt.isBlank(it2)) {
                                        str3 = it2;
                                    } else {
                                        str3 = null;
                                    }
                                    if (str3 != null) {
                                        strReplace$default = StringsKt.replace$default(str3, "\\/", "/", false, 4, (Object) null);
                                        str = null;
                                    } else {
                                        strReplace$default = null;
                                        str = null;
                                    }
                                    obj = Result.constructor-impl(strReplace$default);
                                }
                                Result.Companion companion4 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            break;
                        } catch (Throwable th8) {
                            th = th8;
                            str = str2;
                        }
                        obj2 = obj;
                        if (Result.isFailure-impl(obj2)) {
                            return str;
                        }
                        return obj2;
                    } catch (Throwable th9) {
                        th = th9;
                        str = null;
                    }
                } catch (Throwable th10) {
                    th = th10;
                    str = null;
                }
                break;
            case 1:
                Driveseed $this$resumeCloudLink_u24lambda_u243 = (Driveseed) c00133.L$2;
                resumeCloudUrl = (String) c00133.L$1;
                String url3 = (String) c00133.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    i = 0;
                    str2 = null;
                    $this$resumeCloudLink_u24lambda_u240 = $this$resumeCloudLink_u24lambda_u243;
                    url2 = url3;
                    c00132 = c00133;
                    doc = ((NiceResponse) $result).getDocument();
                    matchResultFind$default = Regex.find$default(new Regex("formData\\.append\\(\\s*[\"']key[\"']\\s*,\\s*[\"']([^\"']+)[\"']\\s*\\)"), doc.html(), 0, 2, str2);
                    if (matchResultFind$default != null) {
                        groupValues = matchResultFind$default.getGroupValues();
                        if (groupValues != null) {
                            c = 1;
                            key = (String) CollectionsKt.getOrNull(groupValues, 1);
                        } else {
                            c = 1;
                            key = str2;
                        }
                        if (key == null) {
                            elementSelectFirst = doc.selectFirst("a.btn-success");
                            if (elementSelectFirst == null) {
                                str = null;
                                strReplace$default = str;
                                obj = Result.constructor-impl(strReplace$default);
                            } else {
                                str = null;
                                strReplace$default = str;
                                obj = Result.constructor-impl(strReplace$default);
                            }
                        } else {
                            String host5 = new URI($this$resumeCloudLink_u24lambda_u240.getMainUrl()).getHost();
                            Requests app4 = MainActivityKt.getApp();
                            Pair[] pairArr5 = new Pair[3];
                            pairArr5[0] = TuplesKt.to("action", "cloud");
                            pairArr5[c] = TuplesKt.to("key", key);
                            pairArr5[2] = TuplesKt.to("action_token", "");
                            Map mapMapOf5 = MapsKt.mapOf(pairArr5);
                            Pair[] pairArr6 = new Pair[2];
                            pairArr6[0] = TuplesKt.to("x-token", host5);
                            pairArr6[c] = TuplesKt.to("X-Requested-With", "XMLHttpRequest");
                            Map mapMapOf6 = MapsKt.mapOf(pairArr6);
                            c00132.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                            c00132.L$1 = SpillingKt.nullOutSpilledVariable(resumeCloudUrl);
                            c00132.L$2 = SpillingKt.nullOutSpilledVariable($this$resumeCloudLink_u24lambda_u240);
                            c00132.L$3 = SpillingKt.nullOutSpilledVariable(doc);
                            c00132.L$4 = SpillingKt.nullOutSpilledVariable(host5);
                            c00132.L$5 = SpillingKt.nullOutSpilledVariable(key);
                            c00132.label = 2;
                            String host6 = resumeCloudUrl;
                            key2 = key;
                            objPost$default = Requests.post$default(app4, host6, mapMapOf6, host6, (Map) null, (Map) null, mapMapOf5, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00132, 65496, (Object) null);
                            if (objPost$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            key3 = key2;
                            i2 = i;
                            $this$resumeCloudLink_u24lambda_u241 = $this$resumeCloudLink_u24lambda_u240;
                            $result = objPost$default;
                            String json3 = ((NiceResponse) $result).getText();
                            it2 = new JSONObject(json3).optString("url");
                            if (StringsKt.isBlank(it2)) {
                                str3 = it2;
                            } else {
                                str3 = null;
                            }
                            if (str3 != null) {
                                strReplace$default = StringsKt.replace$default(str3, "\\/", "/", false, 4, (Object) null);
                                str = null;
                            } else {
                                strReplace$default = null;
                                str = null;
                            }
                            obj = Result.constructor-impl(strReplace$default);
                        }
                        Result.Companion companion5 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    } else {
                        c = 1;
                        key = str2;
                        if (key == null) {
                            elementSelectFirst = doc.selectFirst("a.btn-success");
                            if (elementSelectFirst == null) {
                                str = null;
                                strReplace$default = str;
                                obj = Result.constructor-impl(strReplace$default);
                            } else {
                                str = null;
                                strReplace$default = str;
                                obj = Result.constructor-impl(strReplace$default);
                            }
                        } else {
                            String host7 = new URI($this$resumeCloudLink_u24lambda_u240.getMainUrl()).getHost();
                            Requests app5 = MainActivityKt.getApp();
                            Pair[] pairArr7 = new Pair[3];
                            pairArr7[0] = TuplesKt.to("action", "cloud");
                            pairArr7[c] = TuplesKt.to("key", key);
                            pairArr7[2] = TuplesKt.to("action_token", "");
                            Map mapMapOf7 = MapsKt.mapOf(pairArr7);
                            Pair[] pairArr8 = new Pair[2];
                            pairArr8[0] = TuplesKt.to("x-token", host7);
                            pairArr8[c] = TuplesKt.to("X-Requested-With", "XMLHttpRequest");
                            Map mapMapOf8 = MapsKt.mapOf(pairArr8);
                            c00132.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                            c00132.L$1 = SpillingKt.nullOutSpilledVariable(resumeCloudUrl);
                            c00132.L$2 = SpillingKt.nullOutSpilledVariable($this$resumeCloudLink_u24lambda_u240);
                            c00132.L$3 = SpillingKt.nullOutSpilledVariable(doc);
                            c00132.L$4 = SpillingKt.nullOutSpilledVariable(host7);
                            c00132.L$5 = SpillingKt.nullOutSpilledVariable(key);
                            c00132.label = 2;
                            String host8 = resumeCloudUrl;
                            key2 = key;
                            objPost$default = Requests.post$default(app5, host8, mapMapOf8, host8, (Map) null, (Map) null, mapMapOf7, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00132, 65496, (Object) null);
                            if (objPost$default == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            key3 = key2;
                            i2 = i;
                            $this$resumeCloudLink_u24lambda_u241 = $this$resumeCloudLink_u24lambda_u240;
                            $result = objPost$default;
                            String json4 = ((NiceResponse) $result).getText();
                            it2 = new JSONObject(json4).optString("url");
                            if (StringsKt.isBlank(it2)) {
                                str3 = it2;
                            } else {
                                str3 = null;
                            }
                            if (str3 != null) {
                                strReplace$default = StringsKt.replace$default(str3, "\\/", "/", false, 4, (Object) null);
                                str = null;
                            } else {
                                strReplace$default = null;
                                str = null;
                            }
                            obj = Result.constructor-impl(strReplace$default);
                        }
                        Result.Companion companion6 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    break;
                } catch (Throwable th11) {
                    th = th11;
                    str = null;
                }
                obj2 = obj;
                if (Result.isFailure-impl(obj2)) {
                    return str;
                }
                return obj2;
            case 2:
                i2 = 0;
                key3 = (String) c00133.L$5;
                $this$resumeCloudLink_u24lambda_u241 = (Driveseed) c00133.L$2;
                try {
                    ResultKt.throwOnFailure($result);
                    String json5 = ((NiceResponse) $result).getText();
                    it2 = new JSONObject(json5).optString("url");
                    if (StringsKt.isBlank(it2)) {
                        str3 = it2;
                    } else {
                        str3 = null;
                    }
                    if (str3 != null) {
                        strReplace$default = StringsKt.replace$default(str3, "\\/", "/", false, 4, (Object) null);
                        str = null;
                    } else {
                        strReplace$default = null;
                        str = null;
                    }
                    obj = Result.constructor-impl(strReplace$default);
                    break;
                } catch (Throwable th12) {
                    th = th12;
                    str = null;
                    break;
                }
                obj2 = obj;
                if (Result.isFailure-impl(obj2)) {
                    return str;
                }
                return obj2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x029f  */
    /* JADX WARN: Code duplicated, block: B:120:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:138:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x0106  */
    /* JADX WARN: Code duplicated, block: B:42:0x011f A[Catch: all -> 0x0128, TRY_LEAVE, TryCatch #8 {all -> 0x0128, blocks: (B:40:0x0119, B:42:0x011f, B:54:0x0146, B:56:0x014c), top: B:138:0x0119 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x012e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0132  */
    /* JADX WARN: Code duplicated, block: B:54:0x0146 A[Catch: all -> 0x0128, TRY_ENTER, TryCatch #8 {all -> 0x0128, blocks: (B:40:0x0119, B:42:0x011f, B:54:0x0146, B:56:0x014c), top: B:138:0x0119 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0154  */
    /* JADX WARN: Code duplicated, block: B:61:0x0158  */
    /* JADX WARN: Code duplicated, block: B:67:0x0169  */
    /* JADX WARN: Code duplicated, block: B:68:0x016b  */
    /* JADX WARN: Code duplicated, block: B:70:0x016e A[Catch: all -> 0x02bb, TryCatch #10 {all -> 0x02bb, blocks: (B:32:0x00ea, B:36:0x0107, B:50:0x0134, B:65:0x0160, B:70:0x016e, B:76:0x0188, B:79:0x01a9), top: B:142:0x00ea }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0177  */
    /* JADX WARN: Code duplicated, block: B:73:0x0179  */
    /* JADX WARN: Code duplicated, block: B:75:0x017c  */
    /* JADX WARN: Code duplicated, block: B:76:0x0188 A[Catch: all -> 0x02bb, TRY_LEAVE, TryCatch #10 {all -> 0x02bb, blocks: (B:32:0x00ea, B:36:0x0107, B:50:0x0134, B:65:0x0160, B:70:0x016e, B:76:0x0188, B:79:0x01a9), top: B:142:0x00ea }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:84:0x025b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:85:0x025c  */
    /* JADX WARN: Code duplicated, block: B:90:0x028b  */
    /* JADX WARN: Code duplicated, block: B:91:0x028c  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object resumeBot(String str, Continuation<? super String> continuation) {
        C00121 c00121;
        String str2;
        String str3;
        Object obj;
        int i;
        boolean z;
        C00121 c00122;
        Driveseed driveseed;
        Object[] objArr;
        NiceResponse niceResponse;
        String string;
        String str4;
        String str5;
        MatchResult matchResultFind$default;
        List groupValues;
        int i2;
        String str6;
        String str7;
        MatchResult matchResultFind$default2;
        String str8;
        String str9;
        String strSubstringBefore$default;
        boolean z2;
        String strOptString;
        String str10;
        boolean z3;
        List groupValues2;
        Object obj2;
        if (continuation instanceof C00121) {
            c00121 = (C00121) continuation;
            if ((c00121.label & Integer.MIN_VALUE) != 0) {
                c00121.label -= Integer.MIN_VALUE;
            } else {
                c00121 = new C00121(continuation);
            }
        } else {
            c00121 = new C00121(continuation);
        }
        Object objPost$default = c00121.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00121.label) {
            case 0:
                ResultKt.throwOnFailure(objPost$default);
                try {
                    Result.Companion companion = Result.Companion;
                    Driveseed driveseed2 = this;
                    try {
                        Requests app = MainActivityKt.getApp();
                        c00121.L$0 = str;
                        c00121.L$1 = SpillingKt.nullOutSpilledVariable(driveseed2);
                        c00121.label = 1;
                        C00121 c00123 = c00121;
                        obj = coroutine_suspended;
                        i = 2;
                        z = false;
                        try {
                            objPost$default = Requests.get$default(app, str, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00123, 4094, (Object) null);
                            c00122 = c00123;
                            if (objPost$default == obj) {
                                return obj;
                            }
                            str3 = str;
                            driveseed = driveseed2;
                            objArr = 0;
                            try {
                                niceResponse = (NiceResponse) objPost$default;
                                string = niceResponse.getDocument().toString();
                                str4 = (String) niceResponse.getCookies().get("PHPSESSID");
                                if (str4 == null) {
                                    str4 = "";
                                }
                                str5 = null;
                                try {
                                    matchResultFind$default = Regex.find$default(new Regex("formData\\.append\\('token', '([a-f0-9]+)'\\)"), string, z ? 1 : 0, i, (Object) null);
                                    if (matchResultFind$default != null) {
                                        try {
                                            groupValues = matchResultFind$default.getGroupValues();
                                            if (groupValues != null) {
                                                i2 = 1;
                                                str6 = (String) CollectionsKt.getOrNull(groupValues, 1);
                                            } else {
                                                i2 = 1;
                                                str6 = null;
                                            }
                                            if (str6 == null) {
                                                str6 = "";
                                            }
                                            str7 = str6;
                                            try {
                                                matchResultFind$default2 = Regex.find$default(new Regex("fetch\\('/download\\?id=([a-zA-Z0-9/\\+]+)'"), string, z ? 1 : 0, i, (Object) null);
                                                if (matchResultFind$default2 == null && (groupValues2 = matchResultFind$default2.getGroupValues()) != null) {
                                                    str8 = (String) CollectionsKt.getOrNull(groupValues2, i2);
                                                } else {
                                                    str8 = null;
                                                }
                                                str9 = str8 != null ? str8 : "";
                                                str5 = null;
                                                strSubstringBefore$default = StringsKt.substringBefore$default(str3, "/download", (String) null, i, (Object) null);
                                                if (str7.length() == 0) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                if (z2) {
                                                    str2 = null;
                                                } else {
                                                    if (str9.length() == 0) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                    if (z3) {
                                                        str2 = null;
                                                    } else {
                                                        Requests app2 = MainActivityKt.getApp();
                                                        String str11 = strSubstringBefore$default + "/download?id=" + str9;
                                                        try {
                                                            RequestBody requestBodyBuild = new FormBody.Builder((Charset) null, i2, (DefaultConstructorMarker) null).addEncoded("token", str7).build();
                                                            Pair[] pairArr = new Pair[3];
                                                            pairArr[z ? 1 : 0] = TuplesKt.to("Accept", "*/*");
                                                            pairArr[1] = TuplesKt.to("Origin", strSubstringBefore$default);
                                                            pairArr[i] = TuplesKt.to("Sec-Fetch-Site", "same-origin");
                                                            Map mapMapOf = MapsKt.mapOf(pairArr);
                                                            Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to("PHPSESSID", str4));
                                                            RequestBody requestBody = requestBodyBuild;
                                                            c00122.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                                                            c00122.L$1 = SpillingKt.nullOutSpilledVariable(driveseed);
                                                            c00122.L$2 = SpillingKt.nullOutSpilledVariable(niceResponse);
                                                            c00122.L$3 = SpillingKt.nullOutSpilledVariable(string);
                                                            c00122.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                                                            c00122.L$5 = SpillingKt.nullOutSpilledVariable(str9);
                                                            c00122.L$6 = SpillingKt.nullOutSpilledVariable(strSubstringBefore$default);
                                                            c00122.L$7 = SpillingKt.nullOutSpilledVariable(str7);
                                                            c00122.label = i;
                                                            try {
                                                                objPost$default = Requests.post$default(app2, str11, mapMapOf, str3, (Map) null, mapMapOf2, (Map) null, (List) null, (Object) null, requestBody, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00122, 65256, (Object) null);
                                                                if (objPost$default == obj) {
                                                                    return obj;
                                                                }
                                                                str10 = str3;
                                                                try {
                                                                    strOptString = new JSONObject(((NiceResponse) objPost$default).getText()).optString("url");
                                                                    str2 = null;
                                                                    try {
                                                                        if (!StringsKt.startsWith$default(strOptString, "http", z, i, (Object) null)) {
                                                                            strOptString = null;
                                                                        }
                                                                        obj2 = Result.constructor-impl(strOptString);
                                                                    } catch (Throwable th) {
                                                                        th = th;
                                                                        str3 = str10;
                                                                        Result.Companion companion2 = Result.Companion;
                                                                        obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                    }
                                                                } catch (Throwable th2) {
                                                                    th = th2;
                                                                    str2 = null;
                                                                    str3 = str10;
                                                                    Result.Companion companion3 = Result.Companion;
                                                                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                                                }
                                                            } catch (Throwable th3) {
                                                                th = th3;
                                                                str2 = null;
                                                            }
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                            str2 = null;
                                                        }
                                                    }
                                                    Result.Companion companion4 = Result.Companion;
                                                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                                }
                                                strOptString = str2;
                                                str10 = str3;
                                                obj2 = Result.constructor-impl(strOptString);
                                            } catch (Throwable th5) {
                                                th = th5;
                                                str2 = null;
                                            }
                                        } catch (Throwable th6) {
                                            th = th6;
                                            str2 = null;
                                        }
                                    } else {
                                        i2 = 1;
                                        str6 = null;
                                        if (str6 == null) {
                                            str6 = "";
                                        }
                                        str7 = str6;
                                        matchResultFind$default2 = Regex.find$default(new Regex("fetch\\('/download\\?id=([a-zA-Z0-9/\\+]+)'"), string, z ? 1 : 0, i, (Object) null);
                                        if (matchResultFind$default2 == null) {
                                            str8 = null;
                                        } else {
                                            str8 = null;
                                        }
                                        if (str8 != null) {
                                        }
                                        str5 = null;
                                        strSubstringBefore$default = StringsKt.substringBefore$default(str3, "/download", (String) null, i, (Object) null);
                                        if (str7.length() == 0) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            if (str9.length() == 0) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                            if (z3) {
                                                str2 = null;
                                            } else {
                                                Requests app3 = MainActivityKt.getApp();
                                                String str12 = strSubstringBefore$default + "/download?id=" + str9;
                                                RequestBody requestBodyBuild2 = new FormBody.Builder((Charset) null, i2, (DefaultConstructorMarker) null).addEncoded("token", str7).build();
                                                Pair[] pairArr2 = new Pair[3];
                                                pairArr2[z ? 1 : 0] = TuplesKt.to("Accept", "*/*");
                                                pairArr2[1] = TuplesKt.to("Origin", strSubstringBefore$default);
                                                pairArr2[i] = TuplesKt.to("Sec-Fetch-Site", "same-origin");
                                                Map mapMapOf3 = MapsKt.mapOf(pairArr2);
                                                Map mapMapOf4 = MapsKt.mapOf(TuplesKt.to("PHPSESSID", str4));
                                                RequestBody requestBody2 = requestBodyBuild2;
                                                c00122.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                                                c00122.L$1 = SpillingKt.nullOutSpilledVariable(driveseed);
                                                c00122.L$2 = SpillingKt.nullOutSpilledVariable(niceResponse);
                                                c00122.L$3 = SpillingKt.nullOutSpilledVariable(string);
                                                c00122.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                                                c00122.L$5 = SpillingKt.nullOutSpilledVariable(str9);
                                                c00122.L$6 = SpillingKt.nullOutSpilledVariable(strSubstringBefore$default);
                                                c00122.L$7 = SpillingKt.nullOutSpilledVariable(str7);
                                                c00122.label = i;
                                                objPost$default = Requests.post$default(app3, str12, mapMapOf3, str3, (Map) null, mapMapOf4, (Map) null, (List) null, (Object) null, requestBody2, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00122, 65256, (Object) null);
                                                if (objPost$default == obj) {
                                                    return obj;
                                                }
                                                str10 = str3;
                                                strOptString = new JSONObject(((NiceResponse) objPost$default).getText()).optString("url");
                                                str2 = null;
                                                if (!StringsKt.startsWith$default(strOptString, "http", z, i, (Object) null)) {
                                                    strOptString = null;
                                                }
                                                obj2 = Result.constructor-impl(strOptString);
                                            }
                                            Result.Companion companion5 = Result.Companion;
                                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                        } else {
                                            str2 = null;
                                        }
                                        strOptString = str2;
                                        str10 = str3;
                                        obj2 = Result.constructor-impl(strOptString);
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    str2 = str5;
                                }
                                break;
                            } catch (Throwable th8) {
                                th = th8;
                                str2 = null;
                            }
                            if (Result.isFailure-impl(obj2)) {
                                return str2;
                            }
                            return obj2;
                        } catch (Throwable th9) {
                            th = th9;
                            str2 = null;
                            str3 = str;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        str2 = null;
                        str3 = str;
                    }
                } catch (Throwable th11) {
                    th = th11;
                    str2 = null;
                    str3 = str;
                }
                break;
            case 1:
                Driveseed driveseed3 = (Driveseed) c00121.L$1;
                String str13 = (String) c00121.L$0;
                try {
                    ResultKt.throwOnFailure(objPost$default);
                    obj = coroutine_suspended;
                    objArr = 0;
                    driveseed = driveseed3;
                    str3 = str13;
                    i = 2;
                    c00122 = c00121;
                    z = false;
                    niceResponse = (NiceResponse) objPost$default;
                    string = niceResponse.getDocument().toString();
                    str4 = (String) niceResponse.getCookies().get("PHPSESSID");
                    if (str4 == null) {
                        str4 = "";
                    }
                    str5 = null;
                    matchResultFind$default = Regex.find$default(new Regex("formData\\.append\\('token', '([a-f0-9]+)'\\)"), string, z ? 1 : 0, i, (Object) null);
                    if (matchResultFind$default != null) {
                        groupValues = matchResultFind$default.getGroupValues();
                        if (groupValues != null) {
                            i2 = 1;
                            str6 = (String) CollectionsKt.getOrNull(groupValues, 1);
                        } else {
                            i2 = 1;
                            str6 = null;
                        }
                        if (str6 == null) {
                            str6 = "";
                        }
                        str7 = str6;
                        matchResultFind$default2 = Regex.find$default(new Regex("fetch\\('/download\\?id=([a-zA-Z0-9/\\+]+)'"), string, z ? 1 : 0, i, (Object) null);
                        if (matchResultFind$default2 == null) {
                            str8 = null;
                        } else {
                            str8 = null;
                        }
                        if (str8 != null) {
                        }
                        str5 = null;
                        strSubstringBefore$default = StringsKt.substringBefore$default(str3, "/download", (String) null, i, (Object) null);
                        if (str7.length() == 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            if (str9.length() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                str2 = null;
                            } else {
                                Requests app4 = MainActivityKt.getApp();
                                String str14 = strSubstringBefore$default + "/download?id=" + str9;
                                RequestBody requestBodyBuild3 = new FormBody.Builder((Charset) null, i2, (DefaultConstructorMarker) null).addEncoded("token", str7).build();
                                Pair[] pairArr3 = new Pair[3];
                                pairArr3[z ? 1 : 0] = TuplesKt.to("Accept", "*/*");
                                pairArr3[1] = TuplesKt.to("Origin", strSubstringBefore$default);
                                pairArr3[i] = TuplesKt.to("Sec-Fetch-Site", "same-origin");
                                Map mapMapOf5 = MapsKt.mapOf(pairArr3);
                                Map mapMapOf6 = MapsKt.mapOf(TuplesKt.to("PHPSESSID", str4));
                                RequestBody requestBody3 = requestBodyBuild3;
                                c00122.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                                c00122.L$1 = SpillingKt.nullOutSpilledVariable(driveseed);
                                c00122.L$2 = SpillingKt.nullOutSpilledVariable(niceResponse);
                                c00122.L$3 = SpillingKt.nullOutSpilledVariable(string);
                                c00122.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                                c00122.L$5 = SpillingKt.nullOutSpilledVariable(str9);
                                c00122.L$6 = SpillingKt.nullOutSpilledVariable(strSubstringBefore$default);
                                c00122.L$7 = SpillingKt.nullOutSpilledVariable(str7);
                                c00122.label = i;
                                objPost$default = Requests.post$default(app4, str14, mapMapOf5, str3, (Map) null, mapMapOf6, (Map) null, (List) null, (Object) null, requestBody3, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00122, 65256, (Object) null);
                                if (objPost$default == obj) {
                                    return obj;
                                }
                                str10 = str3;
                                strOptString = new JSONObject(((NiceResponse) objPost$default).getText()).optString("url");
                                str2 = null;
                                if (!StringsKt.startsWith$default(strOptString, "http", z, i, (Object) null)) {
                                    strOptString = null;
                                }
                                obj2 = Result.constructor-impl(strOptString);
                            }
                            Result.Companion companion6 = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                        } else {
                            str2 = null;
                        }
                        strOptString = str2;
                        str10 = str3;
                        obj2 = Result.constructor-impl(strOptString);
                    } else {
                        i2 = 1;
                        str6 = null;
                        if (str6 == null) {
                            str6 = "";
                        }
                        str7 = str6;
                        matchResultFind$default2 = Regex.find$default(new Regex("fetch\\('/download\\?id=([a-zA-Z0-9/\\+]+)'"), string, z ? 1 : 0, i, (Object) null);
                        if (matchResultFind$default2 == null) {
                            str8 = null;
                        } else {
                            str8 = null;
                        }
                        if (str8 != null) {
                        }
                        str5 = null;
                        strSubstringBefore$default = StringsKt.substringBefore$default(str3, "/download", (String) null, i, (Object) null);
                        if (str7.length() == 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            if (str9.length() == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                str2 = null;
                            } else {
                                Requests app5 = MainActivityKt.getApp();
                                String str15 = strSubstringBefore$default + "/download?id=" + str9;
                                RequestBody requestBodyBuild4 = new FormBody.Builder((Charset) null, i2, (DefaultConstructorMarker) null).addEncoded("token", str7).build();
                                Pair[] pairArr4 = new Pair[3];
                                pairArr4[z ? 1 : 0] = TuplesKt.to("Accept", "*/*");
                                pairArr4[1] = TuplesKt.to("Origin", strSubstringBefore$default);
                                pairArr4[i] = TuplesKt.to("Sec-Fetch-Site", "same-origin");
                                Map mapMapOf7 = MapsKt.mapOf(pairArr4);
                                Map mapMapOf8 = MapsKt.mapOf(TuplesKt.to("PHPSESSID", str4));
                                RequestBody requestBody4 = requestBodyBuild4;
                                c00122.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                                c00122.L$1 = SpillingKt.nullOutSpilledVariable(driveseed);
                                c00122.L$2 = SpillingKt.nullOutSpilledVariable(niceResponse);
                                c00122.L$3 = SpillingKt.nullOutSpilledVariable(string);
                                c00122.L$4 = SpillingKt.nullOutSpilledVariable(str4);
                                c00122.L$5 = SpillingKt.nullOutSpilledVariable(str9);
                                c00122.L$6 = SpillingKt.nullOutSpilledVariable(strSubstringBefore$default);
                                c00122.L$7 = SpillingKt.nullOutSpilledVariable(str7);
                                c00122.label = i;
                                objPost$default = Requests.post$default(app5, str15, mapMapOf7, str3, (Map) null, mapMapOf8, (Map) null, (List) null, (Object) null, requestBody4, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00122, 65256, (Object) null);
                                if (objPost$default == obj) {
                                    return obj;
                                }
                                str10 = str3;
                                strOptString = new JSONObject(((NiceResponse) objPost$default).getText()).optString("url");
                                str2 = null;
                                if (!StringsKt.startsWith$default(strOptString, "http", z, i, (Object) null)) {
                                    strOptString = null;
                                }
                                obj2 = Result.constructor-impl(strOptString);
                            }
                            Result.Companion companion7 = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                        } else {
                            str2 = null;
                        }
                        strOptString = str2;
                        str10 = str3;
                        obj2 = Result.constructor-impl(strOptString);
                    }
                } catch (Throwable th12) {
                    th = th12;
                    str2 = null;
                    str3 = str13;
                }
                if (Result.isFailure-impl(obj2)) {
                    return str2;
                }
                return obj2;
            case 2:
                str10 = (String) c00121.L$0;
                try {
                    ResultKt.throwOnFailure(objPost$default);
                    i = 2;
                    z = false;
                    strOptString = new JSONObject(((NiceResponse) objPost$default).getText()).optString("url");
                    str2 = null;
                    if (!StringsKt.startsWith$default(strOptString, "http", z, i, (Object) null)) {
                        strOptString = null;
                    }
                    obj2 = Result.constructor-impl(strOptString);
                } catch (Throwable th13) {
                    th = th13;
                    str2 = null;
                    str3 = str10;
                    break;
                }
                if (Result.isFailure-impl(obj2)) {
                    return str2;
                }
                return obj2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:175:0x08b1  */
    /* JADX WARN: Code duplicated, block: B:177:0x095c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:178:0x095d  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:178:0x095d -> B:179:0x0982). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    static /* synthetic */ java.lang.Object getUrl$suspendImpl(com.phisher98.Driveseed r35, java.lang.String r36, java.lang.String r37, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.SubtitleFile, kotlin.Unit> r38, kotlin.jvm.functions.Function1<? super com.lagradost.cloudstream3.utils.ExtractorLink, kotlin.Unit> r39, kotlin.coroutines.Continuation<? super kotlin.Unit> r40) {
        /*
            Method dump skipped, instruction units count: 2974
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.phisher98.Driveseed.getUrl$suspendImpl(com.phisher98.Driveseed, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String cleanTitle(String title) {
        return ExtractorsKt.extractCleanTitle(title);
    }
}
