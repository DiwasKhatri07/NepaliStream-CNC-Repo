package com.phisher98;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000f0\u0013H\u0096@¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/phisher98/BuzzServer;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class BuzzServer extends ExtractorApi {

    @NotNull
    private final String name = "BuzzServer";

    @NotNull
    private final String mainUrl = "https://buzzheavier.com";
    private final boolean requiresReferer = true;

    /* JADX INFO: renamed from: com.phisher98.BuzzServer$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.BuzzServer", f = "Extractors.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {2382, 2384, 2389}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "url", "referer", "subtitleCallback", "callback", "qualityText", "quality", "url", "referer", "subtitleCallback", "callback", "qualityText", "response", "redirectUrl", "quality"}, nl = {2383, 2385, 2388}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"}, v = 2)
    static final class C00021 extends ContinuationImpl {
        int I$0;
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

        C00021(Continuation<? super C00021> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BuzzServer.this.getUrl(null, null, null, null, (Continuation) this);
        }
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

    /* JADX WARN: Code duplicated, block: B:110:0x012e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0140  */
    /* JADX WARN: Code duplicated, block: B:46:0x01aa A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:47:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:50:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:57:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:58:0x01da  */
    /* JADX WARN: Code duplicated, block: B:60:0x01df A[Catch: Exception -> 0x024f, TRY_LEAVE, TryCatch #2 {Exception -> 0x024f, blocks: (B:48:0x01b4, B:55:0x01cf, B:60:0x01df), top: B:95:0x01b4 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0229 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:64:0x022a  */
    /* JADX WARN: Code duplicated, block: B:69:0x023c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0090: MOVE (r14 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY] A[D('callback' kotlin.jvm.functions.Function1)]), block:B:19:0x008b */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00021 c00021;
        String str;
        String str2;
        String str3;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Object obj;
        Function1<? super ExtractorLink, Unit> function4;
        Element elementSelectFirst;
        String strText;
        String qualityText;
        int quality;
        Function1<? super ExtractorLink, Unit> function5;
        String url3;
        String referer3;
        Function1<? super SubtitleFile, Unit> function6;
        Function1<? super ExtractorLink, Unit> function7;
        int quality2;
        NiceResponse response;
        String str4;
        String redirectUrl;
        boolean z;
        Function1<? super ExtractorLink, Unit> function8;
        Function1<? super ExtractorLink, Unit> function9;
        if (continuation instanceof C00021) {
            c00021 = (C00021) continuation;
            if ((c00021.label & Integer.MIN_VALUE) != 0) {
                c00021.label -= Integer.MIN_VALUE;
            } else {
                c00021 = new C00021(continuation);
            }
        } else {
            c00021 = new C00021(continuation);
        }
        C00021 c00022 = c00021;
        Object $result = c00022.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (c00022.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    try {
                        Requests app = MainActivityKt.getApp();
                        c00022.L$0 = url;
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                        c00022.L$3 = function2;
                        c00022.label = 1;
                        str2 = "BuzzServer";
                        str3 = null;
                        try {
                            Object obj2 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00022, 4094, (Object) null);
                            c00022 = c00022;
                            if (obj2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            url2 = url;
                            referer2 = referer;
                            function3 = function1;
                            obj = obj2;
                            function4 = function2;
                            try {
                                elementSelectFirst = ((NiceResponse) obj).getDocument().selectFirst("div.max-w-2xl > span");
                                if (elementSelectFirst != null) {
                                    try {
                                        strText = elementSelectFirst.text();
                                    } catch (Exception e) {
                                        e = e;
                                        str = str2;
                                        Log.INSTANCE.e(str, "Exception occurred: " + e.getMessage());
                                        return Unit.INSTANCE;
                                    }
                                } else {
                                    strText = str3;
                                }
                                qualityText = strText;
                                quality = StreamPlayUtilsKt.getIndexQuality(qualityText);
                                Requests app2 = MainActivityKt.getApp();
                                String str5 = url2 + "/download";
                                c00022.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                                c00022.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                                c00022.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                                c00022.L$3 = function4;
                                c00022.L$4 = SpillingKt.nullOutSpilledVariable(qualityText);
                                c00022.I$0 = quality;
                                c00022.label = 2;
                                function5 = function4;
                                C00021 c00023 = c00022;
                                try {
                                    $result = Requests.get$default(app2, str5, (Map) null, url2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00023, 4058, (Object) null);
                                    c00022 = c00023;
                                    if ($result == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    url3 = url2;
                                    referer3 = referer2;
                                    function6 = function3;
                                    function7 = function5;
                                    quality2 = quality;
                                    try {
                                        response = (NiceResponse) $result;
                                        str4 = response.getHeaders().get("hx-redirect");
                                        if (str4 == null) {
                                            str4 = "";
                                        }
                                        redirectUrl = str4;
                                        if (redirectUrl.length() > 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (!z) {
                                            try {
                                                str = str2;
                                                try {
                                                    Log.INSTANCE.w(str, "No redirect URL found in headers.");
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    Log.INSTANCE.e(str, "Exception occurred: " + e.getMessage());
                                                }
                                            } catch (Exception e3) {
                                                e = e3;
                                                str = str2;
                                            }
                                            break;
                                        } else {
                                            C00032 c00032 = new C00032(quality2, str3);
                                            c00022.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                                            c00022.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                                            c00022.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                                            c00022.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                                            c00022.L$4 = SpillingKt.nullOutSpilledVariable(qualityText);
                                            c00022.L$5 = SpillingKt.nullOutSpilledVariable(response);
                                            c00022.L$6 = SpillingKt.nullOutSpilledVariable(redirectUrl);
                                            c00022.L$7 = function7;
                                            c00022.I$0 = quality2;
                                            c00022.label = 3;
                                            $result = ExtractorApiKt.newExtractorLink$default("BuzzServer", "BuzzServer", redirectUrl, (ExtractorLinkType) null, c00032, c00022, 8, (Object) null);
                                            if ($result == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            function8 = function7;
                                            function9 = function8;
                                            try {
                                                function8.invoke($result);
                                            } catch (Exception e4) {
                                                e = e4;
                                                str = str2;
                                                Log.INSTANCE.e(str, "Exception occurred: " + e.getMessage());
                                            }
                                        }
                                    } catch (Exception e5) {
                                        e = e5;
                                        str = str2;
                                    }
                                    return Unit.INSTANCE;
                                } catch (Exception e6) {
                                    e = e6;
                                    str = str2;
                                    Log.INSTANCE.e(str, "Exception occurred: " + e.getMessage());
                                    return Unit.INSTANCE;
                                }
                            } catch (Exception e7) {
                                e = e7;
                                str = str2;
                            }
                        } catch (Exception e8) {
                            e = e8;
                            str = str2;
                            Log.INSTANCE.e(str, "Exception occurred: " + e.getMessage());
                            return Unit.INSTANCE;
                        }
                    } catch (Exception e9) {
                        e = e9;
                        str = "BuzzServer";
                    }
                    break;
                case 1:
                    Function1<? super ExtractorLink, Unit> function10 = (Function1) c00022.L$3;
                    Function1<? super SubtitleFile, Unit> function11 = (Function1) c00022.L$2;
                    String referer4 = (String) c00022.L$1;
                    String url4 = (String) c00022.L$0;
                    try {
                        ResultKt.throwOnFailure($result);
                        str3 = null;
                        str2 = "BuzzServer";
                        function3 = function11;
                        referer2 = referer4;
                        url2 = url4;
                        function4 = function10;
                        obj = $result;
                        elementSelectFirst = ((NiceResponse) obj).getDocument().selectFirst("div.max-w-2xl > span");
                        if (elementSelectFirst != null) {
                            strText = elementSelectFirst.text();
                            break;
                        } else {
                            strText = str3;
                        }
                        qualityText = strText;
                        quality = StreamPlayUtilsKt.getIndexQuality(qualityText);
                        Requests app3 = MainActivityKt.getApp();
                        String str6 = url2 + "/download";
                        c00022.L$0 = SpillingKt.nullOutSpilledVariable(url2);
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(referer2);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(function3);
                        c00022.L$3 = function4;
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(qualityText);
                        c00022.I$0 = quality;
                        c00022.label = 2;
                        function5 = function4;
                        C00021 c00024 = c00022;
                        $result = Requests.get$default(app3, str6, (Map) null, url2, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00024, 4058, (Object) null);
                        c00022 = c00024;
                        if ($result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url3 = url2;
                        referer3 = referer2;
                        function6 = function3;
                        function7 = function5;
                        quality2 = quality;
                        response = (NiceResponse) $result;
                        str4 = response.getHeaders().get("hx-redirect");
                        if (str4 == null) {
                            str4 = "";
                        }
                        redirectUrl = str4;
                        if (redirectUrl.length() > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            str = str2;
                            Log.INSTANCE.w(str, "No redirect URL found in headers.");
                            break;
                        } else {
                            C00032 c00033 = new C00032(quality2, str3);
                            c00022.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                            c00022.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                            c00022.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                            c00022.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                            c00022.L$4 = SpillingKt.nullOutSpilledVariable(qualityText);
                            c00022.L$5 = SpillingKt.nullOutSpilledVariable(response);
                            c00022.L$6 = SpillingKt.nullOutSpilledVariable(redirectUrl);
                            c00022.L$7 = function7;
                            c00022.I$0 = quality2;
                            c00022.label = 3;
                            $result = ExtractorApiKt.newExtractorLink$default("BuzzServer", "BuzzServer", redirectUrl, (ExtractorLinkType) null, c00033, c00022, 8, (Object) null);
                            if ($result == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            function8 = function7;
                            function9 = function8;
                            function8.invoke($result);
                        }
                        return Unit.INSTANCE;
                    } catch (Exception e10) {
                        e = e10;
                        str = "BuzzServer";
                        Log.INSTANCE.e(str, "Exception occurred: " + e.getMessage());
                        return Unit.INSTANCE;
                    }
                case 2:
                    int quality3 = c00022.I$0;
                    String qualityText2 = (String) c00022.L$4;
                    Function1<? super ExtractorLink, Unit> function12 = (Function1) c00022.L$3;
                    function6 = (Function1) c00022.L$2;
                    referer3 = (String) c00022.L$1;
                    url3 = (String) c00022.L$0;
                    ResultKt.throwOnFailure($result);
                    quality2 = quality3;
                    str3 = null;
                    str2 = "BuzzServer";
                    qualityText = qualityText2;
                    function7 = function12;
                    response = (NiceResponse) $result;
                    str4 = response.getHeaders().get("hx-redirect");
                    if (str4 == null) {
                        str4 = "";
                    }
                    redirectUrl = str4;
                    if (redirectUrl.length() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        str = str2;
                        Log.INSTANCE.w(str, "No redirect URL found in headers.");
                        break;
                    } else {
                        C00032 c00034 = new C00032(quality2, str3);
                        c00022.L$0 = SpillingKt.nullOutSpilledVariable(url3);
                        c00022.L$1 = SpillingKt.nullOutSpilledVariable(referer3);
                        c00022.L$2 = SpillingKt.nullOutSpilledVariable(function6);
                        c00022.L$3 = SpillingKt.nullOutSpilledVariable(function7);
                        c00022.L$4 = SpillingKt.nullOutSpilledVariable(qualityText);
                        c00022.L$5 = SpillingKt.nullOutSpilledVariable(response);
                        c00022.L$6 = SpillingKt.nullOutSpilledVariable(redirectUrl);
                        c00022.L$7 = function7;
                        c00022.I$0 = quality2;
                        c00022.label = 3;
                        $result = ExtractorApiKt.newExtractorLink$default("BuzzServer", "BuzzServer", redirectUrl, (ExtractorLinkType) null, c00034, c00022, 8, (Object) null);
                        if ($result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        function8 = function7;
                        function9 = function8;
                        function8.invoke($result);
                    }
                    return Unit.INSTANCE;
                case 3:
                    int i = c00022.I$0;
                    function8 = (Function1) c00022.L$7;
                    function9 = (Function1) c00022.L$3;
                    ResultKt.throwOnFailure($result);
                    str2 = "BuzzServer";
                    function8.invoke($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e11) {
            e = e11;
            str = "BuzzServer";
        }
    }

    /* JADX INFO: renamed from: com.phisher98.BuzzServer$getUrl$2 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.BuzzServer$getUrl$2", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00032 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $quality;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C00032(int i, Continuation<? super C00032> continuation) {
            super(2, continuation);
            this.$quality = i;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00032 = new C00032(this.$quality, continuation);
            c00032.L$0 = obj;
            return c00032;
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
                    $this$newExtractorLink.setQuality(this.$quality);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
