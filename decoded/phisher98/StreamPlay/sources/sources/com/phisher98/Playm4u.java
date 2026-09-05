package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lagradost.cloudstream3.APIHolder;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApi;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.cloudstream3.utils.ExtractorLinkType;
import com.lagradost.cloudstream3.utils.Qualities;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
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
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: compiled from: Extractors.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00100\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00100\u0014H\u0096@¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\f\u0010!\u001a\u00020\u0005*\u00020\u0005H\u0002J\u0014\u0010\"\u001a\u00020\u0005*\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0002J\f\u0010$\u001a\u00020\u0005*\u00020\u0005H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/phisher98/Playm4u;", "Lcom/lagradost/cloudstream3/utils/ExtractorApi;", "<init>", "()V", "name", "", "getName", "()Ljava/lang/String;", "mainUrl", "getMainUrl", "requiresReferer", "", "getRequiresReferer", "()Z", "password", "getUrl", "", "url", "referer", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "caesarShift", "str", "amount", "", "mahoa", "input", "key", "md5", "toHex", "findIn", "data", "toLanguage", "Source", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExtractors.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Extractors.kt\ncom/phisher98/Playm4u\n+ 2 NiceResponse.kt\ncom/lagradost/nicehttp/NiceResponse\n*L\n1#1,4003:1\n73#2,5:4004\n*S KotlinDebug\n*F\n+ 1 Extractors.kt\ncom/phisher98/Playm4u\n*L\n161#1:4004,5\n*E\n"})
public class Playm4u extends ExtractorApi {

    @NotNull
    private final String name = "Playm4u";

    @NotNull
    private final String mainUrl = "https://play9str.playm4u.xyz";
    private final boolean requiresReferer = true;

    @NotNull
    private final String password = "plhq@@@22";

    /* JADX INFO: renamed from: com.phisher98.Playm4u$getUrl$1 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Playm4u", f = "Extractors.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {127, 148, 154, 164, 176}, m = "getUrl$suspendImpl", n = {"$this", "url", "referer", "subtitleCallback", "callback", "$this", "url", "referer", "subtitleCallback", "callback", "document", "script", "passScript", "pass", "idFile", "idUser", "domainApi", "nameKeyV3", "dataEnc", "captchaKey", "amount", "$this", "url", "referer", "subtitleCallback", "callback", "document", "script", "passScript", "pass", "idFile", "idUser", "domainApi", "nameKeyV3", "dataEnc", "captchaKey", "token", "amount", "$this", "url", "referer", "subtitleCallback", "callback", "document", "script", "passScript", "pass", "idFile", "idUser", "domainApi", "nameKeyV3", "dataEnc", "captchaKey", "token", "source", "amount", "$this", "url", "referer", "subtitleCallback", "callback", "document", "script", "passScript", "pass", "idFile", "idUser", "domainApi", "nameKeyV3", "dataEnc", "captchaKey", "token", "source", "amount"}, nl = {128, 154, 161, 163, 175}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "I$0"}, v = 2)
    static final class C00561 extends ContinuationImpl {
        int I$0;
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

        C00561(Continuation<? super C00561> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Playm4u.getUrl$suspendImpl(Playm4u.this, null, null, null, null, (Continuation) this);
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

    /* JADX WARN: Code duplicated, block: B:37:0x04bc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:46:0x04f9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object getUrl$suspendImpl(Playm4u $this, String url, String referer, Function1<? super SubtitleFile, Unit> function1, Function1<? super ExtractorLink, Unit> function2, Continuation<? super Unit> continuation) {
        C00561 c00561;
        Object obj;
        char c;
        int i;
        String url2;
        String referer2;
        Function1<? super SubtitleFile, Unit> function3;
        Object obj2;
        Function1<? super ExtractorLink, Unit> function4;
        Element elementSelectFirst;
        String script;
        String passScript;
        String script2;
        Object captchaToken;
        String script3;
        String passScript2;
        Document document;
        String pass;
        String idFile;
        String url3;
        String captchaKey;
        String dataEnc;
        String idUser;
        String nameKeyV3;
        String $result;
        Function1<? super ExtractorLink, Unit> function5;
        Function1<? super SubtitleFile, Unit> function6;
        int amount;
        String token;
        Function1<? super ExtractorLink, Unit> function7;
        Function1<? super SubtitleFile, Unit> function8;
        int amount2;
        String domainApi;
        String dataEnc2;
        String nameKeyV4;
        Object objPost$default;
        String pass2;
        String domainApi2;
        String passScript3;
        String idFile2;
        Function1<? super ExtractorLink, Unit> function9;
        Function1<? super SubtitleFile, Unit> function10;
        int amount3;
        Playm4u $this2;
        Object safe;
        Source source;
        String data;
        Object objNewExtractorLink;
        Source source2;
        Playm4u $this3;
        Function1<? super ExtractorLink, Unit> function11;
        String passScript4;
        String passScript5;
        String sub;
        String strSubstringBefore$default;
        String language;
        Object objNewSubtitleFile$default;
        Function1<? super SubtitleFile, Unit> function12;
        Playm4u $this4 = $this;
        if (continuation instanceof C00561) {
            c00561 = (C00561) continuation;
            if ((c00561.label & Integer.MIN_VALUE) != 0) {
                c00561.label -= Integer.MIN_VALUE;
            } else {
                c00561 = $this4.new C00561(continuation);
            }
        } else {
            c00561 = $this4.new C00561(continuation);
        }
        C00561 c00562 = c00561;
        Object $result2 = c00562.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00562.label) {
            case 0:
                ResultKt.throwOnFailure($result2);
                obj = coroutine_suspended;
                Requests app = MainActivityKt.getApp();
                c00562.L$0 = $this4;
                c00562.L$1 = url;
                c00562.L$2 = referer;
                c00562.L$3 = function1;
                c00562.L$4 = function2;
                c00562.label = 1;
                c = 1;
                i = 2;
                Object obj3 = Requests.get$default(app, url, (Map) null, referer, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00562, 4090, (Object) null);
                c00562 = c00562;
                if (obj3 == obj) {
                    return obj;
                }
                url2 = url;
                referer2 = referer;
                function3 = function1;
                obj2 = obj3;
                function4 = function2;
                Document document2 = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document2.selectFirst("script:containsData(idfile =)");
                if (elementSelectFirst != null || (script = elementSelectFirst.data()) == null) {
                    return Unit.INSTANCE;
                }
                Element elementSelectFirst2 = document2.selectFirst("script:containsData(domain_ref =)");
                if (elementSelectFirst2 == null || (passScript = elementSelectFirst2.data()) == null) {
                    return Unit.INSTANCE;
                }
                String pass3 = StringsKt.substringBefore$default(StringsKt.substringAfter$default(passScript, "CryptoJS.MD5('", (String) null, i, (Object) null), "')", (String) null, i, (Object) null);
                int amount4 = Integer.parseInt(StringsKt.substringBefore$default(StringsKt.substringAfter$default(passScript, ".toString()), ", (String) null, i, (Object) null), "));", (String) null, i, (Object) null));
                String idFile3 = $this4.findIn("idfile", script);
                String idUser2 = $this4.findIn("idUser", script);
                script2 = $this4.findIn("DOMAIN_API", script);
                String nameKeyV5 = $this4.findIn("NameKeyV3", script);
                String dataEnc3 = $this4.toHex($this4.caesarShift($this4.mahoa("Win32|" + idUser2 + '|' + idFile3 + '|' + referer2, $this4.md5(pass3)), amount4));
                String captchaKey2 = StringsKt.substringAfter$default(document2.select("script[src*=https://www.google.com/recaptcha/api.js?render=]").attr("src"), "render=", (String) null, 2, (Object) null);
                APIHolder aPIHolder = APIHolder.INSTANCE;
                c00562.L$0 = $this4;
                c00562.L$1 = SpillingKt.nullOutSpilledVariable(url2);
                c00562.L$2 = referer2;
                c00562.L$3 = function3;
                c00562.L$4 = function4;
                c00562.L$5 = SpillingKt.nullOutSpilledVariable(document2);
                c00562.L$6 = SpillingKt.nullOutSpilledVariable(script);
                c00562.L$7 = SpillingKt.nullOutSpilledVariable(passScript);
                c00562.L$8 = SpillingKt.nullOutSpilledVariable(pass3);
                c00562.L$9 = SpillingKt.nullOutSpilledVariable(idFile3);
                c00562.L$10 = SpillingKt.nullOutSpilledVariable(idUser2);
                c00562.L$11 = script2;
                c00562.L$12 = nameKeyV5;
                c00562.L$13 = dataEnc3;
                c00562.L$14 = SpillingKt.nullOutSpilledVariable(captchaKey2);
                c00562.I$0 = amount4;
                c00562.label = 2;
                captchaToken = aPIHolder.getCaptchaToken(url2, captchaKey2, referer2, c00562);
                if (captchaToken == obj) {
                    return obj;
                }
                script3 = script;
                passScript2 = passScript;
                document = document2;
                pass = pass3;
                idFile = idFile3;
                url3 = url2;
                captchaKey = captchaKey2;
                dataEnc = dataEnc3;
                idUser = idUser2;
                nameKeyV3 = nameKeyV5;
                $result = referer2;
                function5 = function4;
                function6 = function3;
                amount = amount4;
                token = (String) captchaToken;
                Requests app2 = MainActivityKt.getApp();
                Pair[] pairArr = new Pair[4];
                pairArr[0] = TuplesKt.to("namekey", nameKeyV3);
                pairArr[c] = TuplesKt.to("token", String.valueOf(token));
                pairArr[2] = TuplesKt.to("referrer", String.valueOf($result));
                pairArr[3] = TuplesKt.to("data", dataEnc + '|' + $this4.md5(dataEnc + $this4.password));
                Map mapMapOf = MapsKt.mapOf(pairArr);
                String str = $this4.getMainUrl() + '/';
                c00562.L$0 = $this4;
                c00562.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                c00562.L$2 = SpillingKt.nullOutSpilledVariable($result);
                c00562.L$3 = function6;
                c00562.L$4 = function5;
                c00562.L$5 = SpillingKt.nullOutSpilledVariable(document);
                c00562.L$6 = SpillingKt.nullOutSpilledVariable(script3);
                c00562.L$7 = SpillingKt.nullOutSpilledVariable(passScript2);
                c00562.L$8 = SpillingKt.nullOutSpilledVariable(pass);
                c00562.L$9 = SpillingKt.nullOutSpilledVariable(idFile);
                c00562.L$10 = SpillingKt.nullOutSpilledVariable(idUser);
                c00562.L$11 = SpillingKt.nullOutSpilledVariable(script2);
                c00562.L$12 = SpillingKt.nullOutSpilledVariable(nameKeyV3);
                c00562.L$13 = SpillingKt.nullOutSpilledVariable(dataEnc);
                c00562.L$14 = SpillingKt.nullOutSpilledVariable(captchaKey);
                c00562.L$15 = SpillingKt.nullOutSpilledVariable(token);
                c00562.I$0 = amount;
                c00562.label = 3;
                function7 = function5;
                function8 = function6;
                C00561 c00563 = c00562;
                amount2 = amount;
                domainApi = script2;
                dataEnc2 = dataEnc;
                nameKeyV4 = nameKeyV3;
                objPost$default = Requests.post$default(app2, domainApi, (Map) null, str, (Map) null, (Map) null, mapMapOf, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00563, 65498, (Object) null);
                c00562 = c00563;
                if (objPost$default == obj) {
                    return obj;
                }
                pass2 = $result;
                domainApi2 = domainApi;
                passScript3 = passScript2;
                idFile2 = script3;
                function9 = function7;
                function10 = function8;
                amount3 = amount2;
                $this2 = $this4;
                NiceResponse this_$iv = (NiceResponse) objPost$default;
                try {
                    ResponseParser parser = this_$iv.getParser();
                    Intrinsics.checkNotNull(parser);
                    safe = parser.parseSafe(this_$iv.getText(), Reflection.getOrCreateKotlinClass(Source.class));
                    break;
                } catch (Exception e$iv) {
                    e$iv.printStackTrace();
                    safe = null;
                }
                source = (Source) safe;
                String name = $this2.getName();
                String name2 = $this2.getName();
                if (source != null || (data = source.getData()) == null) {
                    return Unit.INSTANCE;
                }
                ExtractorLinkType infer_type = ExtractorApiKt.getINFER_TYPE();
                C00572 c00572 = $this2.new C00572(null);
                c00562.L$0 = $this2;
                c00562.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                c00562.L$2 = SpillingKt.nullOutSpilledVariable(pass2);
                c00562.L$3 = function10;
                c00562.L$4 = SpillingKt.nullOutSpilledVariable(function9);
                c00562.L$5 = SpillingKt.nullOutSpilledVariable(document);
                c00562.L$6 = SpillingKt.nullOutSpilledVariable(idFile2);
                c00562.L$7 = SpillingKt.nullOutSpilledVariable(passScript3);
                c00562.L$8 = SpillingKt.nullOutSpilledVariable(pass);
                c00562.L$9 = SpillingKt.nullOutSpilledVariable(idFile);
                c00562.L$10 = SpillingKt.nullOutSpilledVariable(idUser);
                c00562.L$11 = SpillingKt.nullOutSpilledVariable(domainApi2);
                c00562.L$12 = SpillingKt.nullOutSpilledVariable(nameKeyV4);
                c00562.L$13 = SpillingKt.nullOutSpilledVariable(dataEnc2);
                c00562.L$14 = SpillingKt.nullOutSpilledVariable(captchaKey);
                c00562.L$15 = SpillingKt.nullOutSpilledVariable(token);
                c00562.L$16 = source;
                c00562.L$17 = function9;
                c00562.I$0 = amount3;
                c00562.label = 4;
                C00561 c00564 = c00562;
                objNewExtractorLink = ExtractorApiKt.newExtractorLink(name, name2, data, infer_type, c00572, c00564);
                c00562 = c00564;
                if (objNewExtractorLink == obj) {
                    return obj;
                }
                Playm4u playm4u = $this2;
                source2 = source;
                $this3 = playm4u;
                function11 = function9;
                passScript4 = passScript3;
                passScript5 = idUser;
                function11.invoke(objNewExtractorLink);
                sub = source2.getSub();
                if (sub != null || (strSubstringBefore$default = StringsKt.substringBefore$default(sub, "|", (String) null, 2, (Object) null)) == null || (language = $this3.toLanguage(strSubstringBefore$default)) == null) {
                    return Unit.INSTANCE;
                }
                String strSubstringAfter$default = StringsKt.substringAfter$default(source2.getSub(), "|", (String) null, 2, (Object) null);
                c00562.L$0 = SpillingKt.nullOutSpilledVariable($this3);
                c00562.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                c00562.L$2 = SpillingKt.nullOutSpilledVariable(pass2);
                c00562.L$3 = SpillingKt.nullOutSpilledVariable(function10);
                c00562.L$4 = SpillingKt.nullOutSpilledVariable(function9);
                c00562.L$5 = SpillingKt.nullOutSpilledVariable(document);
                c00562.L$6 = SpillingKt.nullOutSpilledVariable(idFile2);
                c00562.L$7 = SpillingKt.nullOutSpilledVariable(passScript4);
                c00562.L$8 = SpillingKt.nullOutSpilledVariable(pass);
                c00562.L$9 = SpillingKt.nullOutSpilledVariable(idFile);
                c00562.L$10 = SpillingKt.nullOutSpilledVariable(passScript5);
                c00562.L$11 = SpillingKt.nullOutSpilledVariable(domainApi2);
                c00562.L$12 = SpillingKt.nullOutSpilledVariable(nameKeyV4);
                c00562.L$13 = SpillingKt.nullOutSpilledVariable(dataEnc2);
                c00562.L$14 = SpillingKt.nullOutSpilledVariable(captchaKey);
                c00562.L$15 = SpillingKt.nullOutSpilledVariable(token);
                c00562.L$16 = SpillingKt.nullOutSpilledVariable(source2);
                c00562.L$17 = function10;
                c00562.I$0 = amount3;
                c00562.label = 5;
                objNewSubtitleFile$default = MainAPIKt.newSubtitleFile$default(language, strSubstringAfter$default, (Function2) null, c00562, 4, (Object) null);
                if (objNewSubtitleFile$default == obj) {
                    return obj;
                }
                function12 = function10;
                function12.invoke(objNewSubtitleFile$default);
                return Unit.INSTANCE;
            case 1:
                Function1<? super ExtractorLink, Unit> function13 = (Function1) c00562.L$4;
                function3 = (Function1) c00562.L$3;
                referer2 = (String) c00562.L$2;
                url2 = (String) c00562.L$1;
                $this4 = (Playm4u) c00562.L$0;
                ResultKt.throwOnFailure($result2);
                function4 = function13;
                obj = coroutine_suspended;
                obj2 = $result2;
                i = 2;
                c = 1;
                Document document3 = ((NiceResponse) obj2).getDocument();
                elementSelectFirst = document3.selectFirst("script:containsData(idfile =)");
                if (elementSelectFirst != null) {
                }
                return Unit.INSTANCE;
            case 2:
                int amount5 = c00562.I$0;
                String captchaKey3 = (String) c00562.L$14;
                String dataEnc4 = (String) c00562.L$13;
                String nameKeyV6 = (String) c00562.L$12;
                String domainApi3 = (String) c00562.L$11;
                String idUser3 = (String) c00562.L$10;
                String idFile4 = (String) c00562.L$9;
                String pass4 = (String) c00562.L$8;
                String passScript6 = (String) c00562.L$7;
                String script4 = (String) c00562.L$6;
                Document document4 = (Document) c00562.L$5;
                Function1<? super ExtractorLink, Unit> function14 = (Function1) c00562.L$4;
                Function1<? super SubtitleFile, Unit> function15 = (Function1) c00562.L$3;
                String referer3 = (String) c00562.L$2;
                String url4 = (String) c00562.L$1;
                $this4 = (Playm4u) c00562.L$0;
                ResultKt.throwOnFailure($result2);
                dataEnc = dataEnc4;
                function5 = function14;
                url3 = url4;
                obj = coroutine_suspended;
                captchaKey = captchaKey3;
                document = document4;
                nameKeyV3 = nameKeyV6;
                idUser = idUser3;
                idFile = idFile4;
                pass = pass4;
                passScript2 = passScript6;
                script3 = script4;
                amount = amount5;
                c = 1;
                $result = referer3;
                function6 = function15;
                script2 = domainApi3;
                captchaToken = $result2;
                token = (String) captchaToken;
                Requests app3 = MainActivityKt.getApp();
                Pair[] pairArr2 = new Pair[4];
                pairArr2[0] = TuplesKt.to("namekey", nameKeyV3);
                pairArr2[c] = TuplesKt.to("token", String.valueOf(token));
                pairArr2[2] = TuplesKt.to("referrer", String.valueOf($result));
                pairArr2[3] = TuplesKt.to("data", dataEnc + '|' + $this4.md5(dataEnc + $this4.password));
                Map mapMapOf2 = MapsKt.mapOf(pairArr2);
                String str2 = $this4.getMainUrl() + '/';
                c00562.L$0 = $this4;
                c00562.L$1 = SpillingKt.nullOutSpilledVariable(url3);
                c00562.L$2 = SpillingKt.nullOutSpilledVariable($result);
                c00562.L$3 = function6;
                c00562.L$4 = function5;
                c00562.L$5 = SpillingKt.nullOutSpilledVariable(document);
                c00562.L$6 = SpillingKt.nullOutSpilledVariable(script3);
                c00562.L$7 = SpillingKt.nullOutSpilledVariable(passScript2);
                c00562.L$8 = SpillingKt.nullOutSpilledVariable(pass);
                c00562.L$9 = SpillingKt.nullOutSpilledVariable(idFile);
                c00562.L$10 = SpillingKt.nullOutSpilledVariable(idUser);
                c00562.L$11 = SpillingKt.nullOutSpilledVariable(script2);
                c00562.L$12 = SpillingKt.nullOutSpilledVariable(nameKeyV3);
                c00562.L$13 = SpillingKt.nullOutSpilledVariable(dataEnc);
                c00562.L$14 = SpillingKt.nullOutSpilledVariable(captchaKey);
                c00562.L$15 = SpillingKt.nullOutSpilledVariable(token);
                c00562.I$0 = amount;
                c00562.label = 3;
                function7 = function5;
                function8 = function6;
                C00561 c00565 = c00562;
                amount2 = amount;
                domainApi = script2;
                dataEnc2 = dataEnc;
                nameKeyV4 = nameKeyV3;
                objPost$default = Requests.post$default(app3, domainApi, (Map) null, str2, (Map) null, (Map) null, mapMapOf2, (List) null, (Object) null, (RequestBody) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00565, 65498, (Object) null);
                c00562 = c00565;
                if (objPost$default == obj) {
                    return obj;
                }
                pass2 = $result;
                domainApi2 = domainApi;
                passScript3 = passScript2;
                idFile2 = script3;
                function9 = function7;
                function10 = function8;
                amount3 = amount2;
                $this2 = $this4;
                NiceResponse this_$iv2 = (NiceResponse) objPost$default;
                ResponseParser parser2 = this_$iv2.getParser();
                Intrinsics.checkNotNull(parser2);
                safe = parser2.parseSafe(this_$iv2.getText(), Reflection.getOrCreateKotlinClass(Source.class));
                source = (Source) safe;
                String name3 = $this2.getName();
                String name4 = $this2.getName();
                if (source != null) {
                    break;
                }
                return Unit.INSTANCE;
            case 3:
                int amount6 = c00562.I$0;
                String token2 = (String) c00562.L$15;
                String captchaKey4 = (String) c00562.L$14;
                String dataEnc5 = (String) c00562.L$13;
                String nameKeyV7 = (String) c00562.L$12;
                String domainApi4 = (String) c00562.L$11;
                String idUser4 = (String) c00562.L$10;
                String idFile5 = (String) c00562.L$9;
                String pass5 = (String) c00562.L$8;
                passScript3 = (String) c00562.L$7;
                idFile2 = (String) c00562.L$6;
                Document document5 = (Document) c00562.L$5;
                Function1<? super ExtractorLink, Unit> function16 = (Function1) c00562.L$4;
                Function1<? super SubtitleFile, Unit> function17 = (Function1) c00562.L$3;
                String referer4 = (String) c00562.L$2;
                String url5 = (String) c00562.L$1;
                Playm4u $this5 = (Playm4u) c00562.L$0;
                ResultKt.throwOnFailure($result2);
                url3 = url5;
                obj = coroutine_suspended;
                token = token2;
                document = document5;
                captchaKey = captchaKey4;
                dataEnc2 = dataEnc5;
                nameKeyV4 = nameKeyV7;
                idUser = idUser4;
                idFile = idFile5;
                pass = pass5;
                amount3 = amount6;
                pass2 = referer4;
                function9 = function16;
                objPost$default = $result2;
                domainApi2 = domainApi4;
                function10 = function17;
                $this2 = $this5;
                NiceResponse this_$iv3 = (NiceResponse) objPost$default;
                ResponseParser parser3 = this_$iv3.getParser();
                Intrinsics.checkNotNull(parser3);
                safe = parser3.parseSafe(this_$iv3.getText(), Reflection.getOrCreateKotlinClass(Source.class));
                source = (Source) safe;
                String name5 = $this2.getName();
                String name6 = $this2.getName();
                if (source != null) {
                    break;
                }
                return Unit.INSTANCE;
            case 4:
                int amount7 = c00562.I$0;
                function11 = (Function1) c00562.L$17;
                Source source3 = (Source) c00562.L$16;
                String token3 = (String) c00562.L$15;
                String captchaKey5 = (String) c00562.L$14;
                String dataEnc6 = (String) c00562.L$13;
                String nameKeyV8 = (String) c00562.L$12;
                domainApi2 = (String) c00562.L$11;
                passScript5 = (String) c00562.L$10;
                String idFile6 = (String) c00562.L$9;
                String pass6 = (String) c00562.L$8;
                String passScript7 = (String) c00562.L$7;
                String script5 = (String) c00562.L$6;
                Document document6 = (Document) c00562.L$5;
                Function1<? super ExtractorLink, Unit> function18 = (Function1) c00562.L$4;
                Function1<? super SubtitleFile, Unit> function19 = (Function1) c00562.L$3;
                String referer5 = (String) c00562.L$2;
                String url6 = (String) c00562.L$1;
                $this3 = (Playm4u) c00562.L$0;
                ResultKt.throwOnFailure($result2);
                url3 = url6;
                obj = coroutine_suspended;
                token = token3;
                captchaKey = captchaKey5;
                pass = pass6;
                passScript4 = passScript7;
                dataEnc2 = dataEnc6;
                nameKeyV4 = nameKeyV8;
                idFile = idFile6;
                amount3 = amount7;
                idFile2 = script5;
                document = document6;
                pass2 = referer5;
                function10 = function19;
                function9 = function18;
                objNewExtractorLink = $result2;
                source2 = source3;
                function11.invoke(objNewExtractorLink);
                sub = source2.getSub();
                if (sub != null) {
                    break;
                }
                return Unit.INSTANCE;
            case 5:
                int i2 = c00562.I$0;
                function12 = (Function1) c00562.L$17;
                ResultKt.throwOnFailure($result2);
                objNewSubtitleFile$default = $result2;
                function12.invoke(objNewSubtitleFile$default);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.phisher98.Playm4u$getUrl$2 */
    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.phisher98.Playm4u$getUrl$2", f = "Extractors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    static final class C00572 extends SuspendLambda implements Function2<ExtractorLink, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C00572(Continuation<? super C00572> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c00572 = Playm4u.this.new C00572(continuation);
            c00572.L$0 = obj;
            return c00572;
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
                    $this$newExtractorLink.setReferer(Playm4u.this.getMainUrl() + '/');
                    $this$newExtractorLink.setQuality(Qualities.P1080.getValue());
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final String caesarShift(String str, int amount) {
        char c;
        String output = "";
        int adjustedAmount = amount < 0 ? amount + 26 : amount;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char element = str.charAt(i);
            char c2 = element;
            if (Character.isLetter(c2)) {
                if (!('A' <= c2 && c2 < '[')) {
                    if ('a' <= c2 && c2 < '{') {
                        c = (char) ((((c2 - 97) + adjustedAmount) % 26) + 97);
                    } else {
                        c = c2;
                    }
                } else {
                    c = (char) ((((c2 - 65) + adjustedAmount) % 26) + 65);
                }
                c2 = c;
            }
            output = output + c2;
        }
        return output;
    }

    private final String mahoa(String input, String key) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        String a = CryptoJS.INSTANCE.encrypt(key, input);
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(a, "U2FsdGVkX1", "", false, 4, (Object) null), "/", "|a", false, 4, (Object) null), "+", "|b", false, 4, (Object) null), "=", "|c", false, 4, (Object) null), "|", "-z", false, 4, (Object) null);
    }

    private final String md5(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = input.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return StringsKt.padStart(new BigInteger(1, md.digest(bytes)).toString(16), 32, '0');
    }

    private final String toHex(String $this$toHex) {
        byte[] bytes = $this$toHex.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return ArraysKt.joinToString$default(bytes, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.phisher98.Playm4u$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return Playm4u.toHex$lambda$0(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    static final CharSequence toHex$lambda$0(byte it) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(it)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private final String findIn(String $this$findIn, String data) {
        List groupValues;
        String str;
        MatchResult matchResultFind$default = Regex.find$default(new Regex($this$findIn + "\\s*=\\s*[\"'](\\S+)[\"'];"), data, 0, 2, (Object) null);
        return (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str = (String) groupValues.get(1)) == null) ? "" : str;
    }

    private final String toLanguage(String $this$toLanguage) {
        return Intrinsics.areEqual($this$toLanguage, "EN") ? "English" : $this$toLanguage;
    }

    /* JADX INFO: compiled from: Extractors.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J=\u0010\u000e\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/phisher98/Playm4u$Source;", "", "data", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "sub", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "getSub", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final /* data */ class Source {

        @Nullable
        private final String data;

        @Nullable
        private final String sub;

        /* JADX WARN: Illegal instructions before constructor call */
        public Source() {
            String str = null;
            this(str, str, 3, str);
        }

        public static /* synthetic */ Source copy$default(Source source, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = source.data;
            }
            if ((i & 2) != 0) {
                str2 = source.sub;
            }
            return source.copy(str, str2);
        }

        @Nullable
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getData() {
            return this.data;
        }

        @Nullable
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSub() {
            return this.sub;
        }

        @NotNull
        public final Source copy(@JsonProperty("data") @Nullable String data, @JsonProperty("sub") @Nullable String sub) {
            return new Source(data, sub);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Source)) {
                return false;
            }
            Source source = (Source) other;
            return Intrinsics.areEqual(this.data, source.data) && Intrinsics.areEqual(this.sub, source.sub);
        }

        public int hashCode() {
            return ((this.data == null ? 0 : this.data.hashCode()) * 31) + (this.sub != null ? this.sub.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Source(data=" + this.data + ", sub=" + this.sub + ')';
        }

        public Source(@JsonProperty("data") @Nullable String data, @JsonProperty("sub") @Nullable String sub) {
            this.data = data;
            this.sub = sub;
        }

        public /* synthetic */ Source(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        @Nullable
        public final String getData() {
            return this.data;
        }

        @Nullable
        public final String getSub() {
            return this.sub;
        }
    }
}
