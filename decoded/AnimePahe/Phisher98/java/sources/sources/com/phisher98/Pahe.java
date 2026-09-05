package com.phisher98;

import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/AnimePahe/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002JH\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001b0\u001f2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001b0\u001fH\u0096@¢\u0006\u0002\u0010#R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/phisher98/Pahe;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "kwikParamsRegex", "Lkotlin/text/Regex;", "kwikDUrl", "kwikDToken", "client", "Lokhttp3/OkHttpClient;", "decrypt", "fullString", "key", "v1", "", "v2", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AnimePahe"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/phisher98/Pahe\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,260:1\n1358#2,2:261\n1435#2,4:263\n*S KotlinDebug\n*F\n+ 1 Utils.kt\ncom/phisher98/Pahe\n*L\n116#1:261,2\n116#1:263,4\n*E\n"})
public final class Pahe extends ExtractorApi {

    @NotNull
    private final String name = "Pahe";

    @NotNull
    private final String mainUrl = "https://pahe.win";
    private final boolean requiresReferer = true;

    @NotNull
    private final Regex kwikParamsRegex = new Regex("\\(\"(\\w+)\",\\d+,\"(\\w+)\",(\\d+),(\\d+),\\d+\\)");

    @NotNull
    private final Regex kwikDUrl = new Regex("action=\"([^\"]+)\"");

    @NotNull
    private final Regex kwikDToken = new Regex("value=\"([^\"]+)\"");

    @NotNull
    private final OkHttpClient client = new OkHttpClient();

    /* JADX INFO: renamed from: com.phisher98.Pahe$getUrl$1 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Pahe", f = "Utils.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {199}, m = "getUrl", n = {"url", "referer", "subtitleCallback", "callback", "noRedirects", "initialRequest", "kwikUrl", "fContentRequest", "fContent", "fContentString", "fullString", "key", "v1", "v2", "decrypted", "uri", "tok", "noRedirectClient", "content", "location", "code", "tries"}, nl = {198}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "I$0", "I$1"}, v = 2)
    static final class C00151 extends ContinuationImpl {
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
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C00151(Continuation<? super C00151> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Pahe.this.getUrl(null, null, null, null, (Continuation) this);
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

    private final String decrypt(String fullString, String key, int v1, int v2) {
        Iterable $this$associate$iv = StringsKt.withIndex(key);
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        Map keyIndexMap = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associate$iv) {
            IndexedValue it = (IndexedValue) element$iv$iv;
            Pair pair = TuplesKt.to(it.getValue(), Integer.valueOf(it.getIndex()));
            keyIndexMap.put(pair.getFirst(), pair.getSecond());
        }
        StringBuilder sb = new StringBuilder();
        char toFind = key.charAt(v2);
        int i = 0;
        while (i < i) {
            int nextIndex = StringsKt.indexOf$default(fullString, toFind, i, false, 4, (Object) null);
            StringBuilder $this$decrypt_u24lambda_u241 = new StringBuilder();
            for (int j = i; j < nextIndex; j++) {
                Integer num = (Integer) keyIndexMap.get(Character.valueOf(fullString.charAt(j)));
                $this$decrypt_u24lambda_u241.append(num != null ? num.intValue() : -1);
            }
            String decodedCharStr = $this$decrypt_u24lambda_u241.toString();
            i = nextIndex + 1;
            char decodedChar = (char) (Integer.parseInt(decodedCharStr, CharsKt.checkRadix(v2)) - v1);
            sb.append(decodedChar);
        }
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Nullable
    public Object getUrl(@NotNull String url, @Nullable String referer, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00151 c00151;
        Function1<? super ExtractorLink, Unit> function3;
        Object obj;
        if (continuation instanceof C00151) {
            c00151 = (C00151) continuation;
            if ((c00151.label & Integer.MIN_VALUE) != 0) {
                c00151.label -= Integer.MIN_VALUE;
            } else {
                c00151 = new C00151(continuation);
            }
        } else {
            c00151 = new C00151(continuation);
        }
        C00151 c00152 = c00151;
        Object $result = c00152.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00152.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                OkHttpClient noRedirects = new OkHttpClient.Builder().followRedirects(false).followSslRedirects(false).build();
                Request initialRequest = new Request.Builder().url(url + "/i").get().build();
                StringBuilder sbAppend = new StringBuilder().append("https://");
                String strHeader$default = Response.header$default(noRedirects.newCall(initialRequest).execute(), "location", (String) null, 2, (Object) null);
                Intrinsics.checkNotNull(strHeader$default);
                String kwikUrl = sbAppend.append(StringsKt.substringAfterLast$default(strHeader$default, "https://", (String) null, 2, (Object) null)).toString();
                Request fContentRequest = new Request.Builder().url(kwikUrl).header("referer", "https://kwik.cx/").get().build();
                Response fContent = this.client.newCall(fContentRequest).execute();
                String fContentString = fContent.body().toString();
                MatchResult matchResultFind$default = Regex.find$default(this.kwikParamsRegex, fContentString, 0, 2, (Object) null);
                Intrinsics.checkNotNull(matchResultFind$default);
                MatchResult.Destructured destructured = matchResultFind$default.getDestructured();
                String fullString = (String) destructured.getMatch().getGroupValues().get(1);
                String key = (String) destructured.getMatch().getGroupValues().get(2);
                String v1 = (String) destructured.getMatch().getGroupValues().get(3);
                String v2 = (String) destructured.getMatch().getGroupValues().get(4);
                String decrypted = decrypt(fullString, key, Integer.parseInt(v1), Integer.parseInt(v2));
                MatchResult matchResultFind$default2 = Regex.find$default(this.kwikDUrl, decrypted, 0, 2, (Object) null);
                Intrinsics.checkNotNull(matchResultFind$default2);
                String uri = (String) matchResultFind$default2.getDestructured().getMatch().getGroupValues().get(1);
                MatchResult matchResultFind$default3 = Regex.find$default(this.kwikDToken, decrypted, 0, 2, (Object) null);
                Intrinsics.checkNotNull(matchResultFind$default3);
                String tok = (String) matchResultFind$default3.getDestructured().getMatch().getGroupValues().get(1);
                OkHttpClient noRedirectClient = new OkHttpClient().newBuilder().followRedirects(false).followSslRedirects(false).cookieJar(this.client.cookieJar()).build();
                int code = 419;
                int tries = 0;
                Response content = null;
                while (code != 302 && tries < 20) {
                    Request postRequest = new Request.Builder().url(uri).header("user-agent", " Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36").header("referer", fContent.request().url().toString()).header("cookie", String.valueOf(CollectionsKt.firstOrNull(fContent.headers("set-cookie")))).post(new FormBody.Builder((Charset) null, 1, (DefaultConstructorMarker) null).add("_token", tok).build()).build();
                    content = noRedirectClient.newCall(postRequest).execute();
                    code = content.code();
                    tries++;
                    v1 = v1;
                    v2 = v2;
                }
                String v3 = v1;
                String v4 = v2;
                String location = String.valueOf(content != null ? Response.header$default(content, "location", (String) null, 2, (Object) null) : null);
                if (content != null) {
                    content.close();
                }
                String name = getName();
                String name2 = getName();
                ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                C00162 c00162 = new C00162(null);
                c00152.L$0 = SpillingKt.nullOutSpilledVariable(url);
                c00152.L$1 = SpillingKt.nullOutSpilledVariable(referer);
                c00152.L$2 = SpillingKt.nullOutSpilledVariable(function1);
                c00152.L$3 = SpillingKt.nullOutSpilledVariable(function2);
                c00152.L$4 = SpillingKt.nullOutSpilledVariable(noRedirects);
                c00152.L$5 = SpillingKt.nullOutSpilledVariable(initialRequest);
                c00152.L$6 = SpillingKt.nullOutSpilledVariable(kwikUrl);
                c00152.L$7 = SpillingKt.nullOutSpilledVariable(fContentRequest);
                c00152.L$8 = SpillingKt.nullOutSpilledVariable(fContent);
                c00152.L$9 = SpillingKt.nullOutSpilledVariable(fContentString);
                c00152.L$10 = SpillingKt.nullOutSpilledVariable(fullString);
                c00152.L$11 = SpillingKt.nullOutSpilledVariable(key);
                c00152.L$12 = SpillingKt.nullOutSpilledVariable(v3);
                c00152.L$13 = SpillingKt.nullOutSpilledVariable(v4);
                c00152.L$14 = SpillingKt.nullOutSpilledVariable(decrypted);
                c00152.L$15 = SpillingKt.nullOutSpilledVariable(uri);
                c00152.L$16 = SpillingKt.nullOutSpilledVariable(tok);
                c00152.L$17 = SpillingKt.nullOutSpilledVariable(noRedirectClient);
                c00152.L$18 = SpillingKt.nullOutSpilledVariable(content);
                c00152.L$19 = SpillingKt.nullOutSpilledVariable(location);
                c00152.L$20 = function2;
                c00152.I$0 = code;
                c00152.I$1 = tries;
                c00152.label = 1;
                Object objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, location, infer_type, c00162, c00152);
                if (objNewExtractorLink == coroutine_suspended) {
                    return coroutine_suspended;
                }
                function3 = function2;
                obj = objNewExtractorLink;
                break;
                break;
            case 1:
                int i = c00152.I$1;
                int i2 = c00152.I$0;
                function3 = (Function1) c00152.L$20;
                ResultKt.throwOnFailure($result);
                obj = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        function3.invoke(obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.phisher98.Pahe$getUrl$2 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Pahe$getUrl$2", f = "Utils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00162 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00162(Continuation<? super C00162> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00162 = new C00162(continuation);
            c00162.L$0 = obj;
            return c00162;
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
                    $this$newExtractorLink.setReferer("https://kwik.cx/");
                    $this$newExtractorLink.setQuality(ExtractorApiKt.getQualityFromName(""));
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
