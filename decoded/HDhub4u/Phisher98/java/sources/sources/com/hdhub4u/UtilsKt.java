package com.hdhub4u;

import com.lagradost.api.Log;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.MainActivityKt;
import com.lagradost.cloudstream3.SubtitleFile;
import com.lagradost.cloudstream3.utils.ExtractorApiKt;
import com.lagradost.cloudstream3.utils.ExtractorLink;
import com.lagradost.nicehttp.NiceResponse;
import com.lagradost.nicehttp.Requests;
import com.lagradost.nicehttp.ResponseParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.text.CharsKt;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/HDhub4u/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u000e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001\u001a^\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\b0\u000eH\u0086@¢\u0006\u0002\u0010\u0012\u001a\u000e\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001¨\u0006\u0015"}, d2 = {"getRedirectLinks", "", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "encode", "value", "pen", "loadSourceNameExtractor", "", "source", "referer", "quality", "", "subtitleCallback", "Lkotlin/Function1;", "Lcom/lagradost/cloudstream3/SubtitleFile;", "callback", "Lcom/lagradost/cloudstream3/utils/ExtractorLink;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanTitle", "raw", "HDhub4u"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\ncom/hdhub4u/UtilsKt\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,207:1\n1505#2,2:208\n1#3:210\n990#4:211\n1065#4,3:212\n*S KotlinDebug\n*F\n+ 1 Utils.kt\ncom/hdhub4u/UtilsKt\n*L\n25#1:208,2\n53#1:211\n53#1:212,3\n*E\n"})
public final class UtilsKt {

    /* JADX INFO: renamed from: com.hdhub4u.UtilsKt$getRedirectLinks$1 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.hdhub4u.UtilsKt", f = "Utils.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {22, 37}, m = "getRedirectLinks", n = {"url", "url", "doc", "regex", "combinedString", "decodedString", "jsonObject", "encodedurl", "data", "wphttp1"}, nl = {23, 37}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"}, v = 2)
    static final class C00161 extends ContinuationImpl {
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

        C00161(Continuation<? super C00161> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.getRedirectLinks(null, (Continuation) this);
        }
    }

    /* JADX INFO: renamed from: com.hdhub4u.UtilsKt$loadSourceNameExtractor$1 */
    /* JADX INFO: compiled from: Utils.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "com.hdhub4u.UtilsKt", f = "Utils.kt", i = {0, 0, 0, 0, 0, 0}, l = {70}, m = "loadSourceNameExtractor", n = {"source", "url", "referer", "quality", "subtitleCallback", "callback"}, nl = {87}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    static final class C00171 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C00171(Continuation<? super C00171> continuation) {
            super(continuation);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UtilsKt.loadSourceNameExtractor(null, null, null, null, null, null, (Continuation) this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:29:0x0109  */
    /* JADX WARN: Code duplicated, block: B:31:0x0113  */
    /* JADX WARN: Code duplicated, block: B:32:0x0118  */
    /* JADX WARN: Code duplicated, block: B:39:0x0129  */
    /* JADX WARN: Code duplicated, block: B:41:0x012d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0221 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:50:0x0222  */
    /* JADX WARN: Code duplicated, block: B:63:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:66:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:67:0x02be  */
    /* JADX WARN: Code duplicated, block: B:69:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:70:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    /* JADX WARN: Code duplicated, block: B:97:0x0130 A[SYNTHETIC] */
    @Nullable
    public static final Object getRedirectLinks(@NotNull String url, @NotNull Continuation<? super String> continuation) {
        C00161 c00161;
        int i;
        String str;
        C00161 c00162;
        Object obj;
        String url2;
        String doc;
        Regex regex;
        StringBuilder $this$getRedirectLinks_u24lambda_u240;
        Regex regex2;
        String combinedString;
        Regex regex3;
        String str2;
        String encodedurl;
        String str3;
        String combinedString2;
        String doc2;
        Regex regex4;
        String url3;
        String encodedurl2;
        String url4;
        MatchResult matchResult;
        MatchGroup matchGroup;
        MatchGroup matchGroup2;
        String extractedValue;
        String str4;
        boolean z;
        Object obj2;
        Object obj3;
        String directlink;
        String str5;
        boolean z2;
        if (continuation instanceof C00161) {
            c00161 = (C00161) continuation;
            if ((c00161.label & Integer.MIN_VALUE) != 0) {
                c00161.label -= Integer.MIN_VALUE;
            } else {
                c00161 = new C00161(continuation);
            }
        } else {
            c00161 = new C00161(continuation);
        }
        C00161 c00163 = c00161;
        Object $result = c00163.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00163.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Requests app = MainActivityKt.getApp();
                c00163.L$0 = url;
                c00163.label = 1;
                i = 0;
                str = "";
                Object obj4 = Requests.get$default(app, url, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00163, 4094, (Object) null);
                c00162 = c00163;
                if (obj4 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = obj4;
                url2 = url;
                doc = ((NiceResponse) obj).toString();
                regex = new Regex("s\\('o','([A-Za-z0-9+/=]+)'|ck\\('_wp_http_\\d+','([^']+)'");
                $this$getRedirectLinks_u24lambda_u240 = new StringBuilder();
                Sequence $this$forEach$iv = Regex.findAll$default(regex, doc, i, 2, (Object) null);
                for (Object element$iv : $this$forEach$iv) {
                    matchResult = (MatchResult) element$iv;
                    Regex regex5 = regex;
                    matchGroup = matchResult.getGroups().get(1);
                    if (matchGroup != null || (extractedValue = matchGroup.getValue()) == null) {
                        matchGroup2 = matchResult.getGroups().get(2);
                        if (matchGroup2 != null) {
                            extractedValue = matchGroup2.getValue();
                        } else {
                            extractedValue = null;
                        }
                    }
                    str4 = extractedValue;
                    if (str4 != null || str4.length() == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        $this$getRedirectLinks_u24lambda_u240.append(extractedValue);
                    }
                    regex = regex5;
                }
                regex2 = regex;
                combinedString = $this$getRedirectLinks_u24lambda_u240.toString();
                try {
                    String decodedString = MainAPIKt.base64Decode(pen(MainAPIKt.base64Decode(MainAPIKt.base64Decode(combinedString))));
                    JSONObject jsonObject = new JSONObject(decodedString);
                    str2 = str;
                    encodedurl = StringsKt.trim(MainAPIKt.base64Decode(jsonObject.optString("o", str2))).toString();
                    String data = StringsKt.trim(encode(jsonObject.optString("data", str2))).toString();
                    String wphttp1 = StringsKt.trim(jsonObject.optString("blog_url", str2)).toString();
                    try {
                        Result.Companion companion = Result.Companion;
                        Requests app2 = MainActivityKt.getApp();
                        String string = StringsKt.trim(wphttp1 + "?re=" + data).toString();
                        c00162.L$0 = url2;
                        c00162.L$1 = SpillingKt.nullOutSpilledVariable(doc);
                        c00162.L$2 = SpillingKt.nullOutSpilledVariable(regex2);
                        c00162.L$3 = SpillingKt.nullOutSpilledVariable(combinedString);
                        c00162.L$4 = SpillingKt.nullOutSpilledVariable(decodedString);
                        c00162.L$5 = SpillingKt.nullOutSpilledVariable(jsonObject);
                        c00162.L$6 = encodedurl;
                        c00162.L$7 = SpillingKt.nullOutSpilledVariable(data);
                        c00162.L$8 = SpillingKt.nullOutSpilledVariable(wphttp1);
                        c00162.label = 2;
                        url4 = url2;
                        str3 = str2;
                        try {
                            $result = Requests.get$default(app2, string, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00162, 4094, (Object) null);
                            if ($result == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            combinedString2 = combinedString;
                            doc2 = doc;
                            regex4 = regex2;
                            url3 = url4;
                            encodedurl2 = encodedurl;
                            try {
                                obj2 = Result.constructor-impl(StringsKt.trim(((NiceResponse) $result).getDocument().select("body").text()).toString());
                            } catch (Throwable th) {
                                th = th;
                                try {
                                    Result.Companion companion2 = Result.Companion;
                                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                                } catch (Exception e) {
                                    e = e;
                                    regex3 = regex4;
                                    url2 = url3;
                                    Log.INSTANCE.e("Error:", "Error processing links " + e);
                                    return url2;
                                }
                            }
                            obj3 = obj2;
                            url2 = url3;
                            try {
                                if (Result.isFailure-impl(obj3)) {
                                    obj3 = str3;
                                }
                                directlink = StringsKt.trim((String) obj3).toString();
                                str5 = encodedurl2;
                                if (str5.length() == 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (!z2) {
                                    directlink = str5;
                                }
                                return directlink;
                            } catch (Exception e2) {
                                e = e2;
                                regex3 = regex4;
                                Log.INSTANCE.e("Error:", "Error processing links " + e);
                                return url2;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            combinedString2 = combinedString;
                            doc2 = doc;
                            regex4 = regex2;
                            url3 = url4;
                            encodedurl2 = encodedurl;
                            Result.Companion companion3 = Result.Companion;
                            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                            obj3 = obj2;
                            url2 = url3;
                            if (Result.isFailure-impl(obj3)) {
                                obj3 = str3;
                            }
                            directlink = StringsKt.trim((String) obj3).toString();
                            str5 = encodedurl2;
                            if (str5.length() == 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                directlink = str5;
                            }
                            return directlink;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str3 = str2;
                        combinedString2 = combinedString;
                        doc2 = doc;
                        regex4 = regex2;
                        url3 = url2;
                        encodedurl2 = encodedurl;
                    }
                } catch (Exception e3) {
                    e = e3;
                    regex3 = regex2;
                    Log.INSTANCE.e("Error:", "Error processing links " + e);
                    return url2;
                }
                break;
                break;
            case 1:
                String url5 = (String) c00163.L$0;
                ResultKt.throwOnFailure($result);
                str = "";
                i = 0;
                c00162 = c00163;
                url2 = url5;
                obj = $result;
                doc = ((NiceResponse) obj).toString();
                regex = new Regex("s\\('o','([A-Za-z0-9+/=]+)'|ck\\('_wp_http_\\d+','([^']+)'");
                $this$getRedirectLinks_u24lambda_u240 = new StringBuilder();
                Sequence $this$forEach$iv2 = Regex.findAll$default(regex, doc, i, 2, (Object) null);
                while (r12.hasNext()) {
                    matchResult = (MatchResult) element$iv;
                    Regex regex6 = regex;
                    matchGroup = matchResult.getGroups().get(1);
                    if (matchGroup != null) {
                        matchGroup2 = matchResult.getGroups().get(2);
                        if (matchGroup2 != null) {
                            extractedValue = matchGroup2.getValue();
                        } else {
                            extractedValue = null;
                        }
                    } else {
                        matchGroup2 = matchResult.getGroups().get(2);
                        if (matchGroup2 != null) {
                            extractedValue = matchGroup2.getValue();
                        } else {
                            extractedValue = null;
                        }
                    }
                    str4 = extractedValue;
                    if (str4 != null) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        $this$getRedirectLinks_u24lambda_u240.append(extractedValue);
                    }
                    regex = regex6;
                }
                regex2 = regex;
                combinedString = $this$getRedirectLinks_u24lambda_u240.toString();
                String decodedString2 = MainAPIKt.base64Decode(pen(MainAPIKt.base64Decode(MainAPIKt.base64Decode(combinedString))));
                JSONObject jsonObject2 = new JSONObject(decodedString2);
                str2 = str;
                encodedurl = StringsKt.trim(MainAPIKt.base64Decode(jsonObject2.optString("o", str2))).toString();
                String data2 = StringsKt.trim(encode(jsonObject2.optString("data", str2))).toString();
                String wphttp2 = StringsKt.trim(jsonObject2.optString("blog_url", str2)).toString();
                Result.Companion companion4 = Result.Companion;
                Requests app3 = MainActivityKt.getApp();
                String string2 = StringsKt.trim(wphttp2 + "?re=" + data2).toString();
                c00162.L$0 = url2;
                c00162.L$1 = SpillingKt.nullOutSpilledVariable(doc);
                c00162.L$2 = SpillingKt.nullOutSpilledVariable(regex2);
                c00162.L$3 = SpillingKt.nullOutSpilledVariable(combinedString);
                c00162.L$4 = SpillingKt.nullOutSpilledVariable(decodedString2);
                c00162.L$5 = SpillingKt.nullOutSpilledVariable(jsonObject2);
                c00162.L$6 = encodedurl;
                c00162.L$7 = SpillingKt.nullOutSpilledVariable(data2);
                c00162.L$8 = SpillingKt.nullOutSpilledVariable(wphttp2);
                c00162.label = 2;
                url4 = url2;
                str3 = str2;
                $result = Requests.get$default(app3, string2, (Map) null, (String) null, (Map) null, (Map) null, false, 0, (TimeUnit) null, 0L, (Interceptor) null, false, (ResponseParser) null, c00162, 4094, (Object) null);
                if ($result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                combinedString2 = combinedString;
                doc2 = doc;
                regex4 = regex2;
                url3 = url4;
                encodedurl2 = encodedurl;
                obj2 = Result.constructor-impl(StringsKt.trim(((NiceResponse) $result).getDocument().select("body").text()).toString());
                obj3 = obj2;
                url2 = url3;
                if (Result.isFailure-impl(obj3)) {
                    obj3 = str3;
                }
                directlink = StringsKt.trim((String) obj3).toString();
                str5 = encodedurl2;
                if (str5.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    directlink = str5;
                }
                return directlink;
            case 2:
                encodedurl2 = (String) c00163.L$6;
                combinedString2 = (String) c00163.L$3;
                regex4 = (Regex) c00163.L$2;
                doc2 = (String) c00163.L$1;
                url3 = (String) c00163.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    str3 = "";
                    obj2 = Result.constructor-impl(StringsKt.trim(((NiceResponse) $result).getDocument().select("body").text()).toString());
                    break;
                } catch (Throwable th4) {
                    th = th4;
                    str3 = "";
                    Result.Companion companion5 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                    obj3 = obj2;
                    url2 = url3;
                    if (Result.isFailure-impl(obj3)) {
                        obj3 = str3;
                    }
                    directlink = StringsKt.trim((String) obj3).toString();
                    str5 = encodedurl2;
                    if (str5.length() == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        directlink = str5;
                    }
                    return directlink;
                }
                obj3 = obj2;
                url2 = url3;
                if (Result.isFailure-impl(obj3)) {
                    obj3 = str3;
                }
                directlink = StringsKt.trim((String) obj3).toString();
                str5 = encodedurl2;
                if (str5.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    directlink = str5;
                }
                return directlink;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @NotNull
    public static final String encode(@NotNull String value) {
        return MainAPIKt.base64Decode(value);
    }

    @NotNull
    public static final String pen(@NotNull String value) {
        char c;
        String $this$map$iv = value;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length());
        for (int i = 0; i < $this$map$iv.length(); i++) {
            char item$iv$iv = $this$map$iv.charAt(i);
            if ('A' <= item$iv$iv && item$iv$iv < '[') {
                c = (char) ((((item$iv$iv - 'A') + 13) % 26) + 65);
            } else if ('a' <= item$iv$iv && item$iv$iv < '{') {
                c = (char) ((((item$iv$iv - 'a') + 13) % 26) + 97);
            } else {
                c = item$iv$iv;
            }
            destination$iv$iv.add(Character.valueOf(c));
        }
        return CollectionsKt.joinToString$default((List) destination$iv$iv, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Nullable
    public static final Object loadSourceNameExtractor(@NotNull final String source, @NotNull String url, @Nullable String referer, @Nullable final Integer quality, @NotNull Function1<? super SubtitleFile, Unit> function1, @NotNull final Function1<? super ExtractorLink, Unit> function2, @NotNull Continuation<? super Unit> continuation) {
        C00171 c00171;
        if (continuation instanceof C00171) {
            c00171 = (C00171) continuation;
            if ((c00171.label & Integer.MIN_VALUE) != 0) {
                c00171.label -= Integer.MIN_VALUE;
            } else {
                c00171 = new C00171(continuation);
            }
        } else {
            c00171 = new C00171(continuation);
        }
        Object $result = c00171.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c00171.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function1 function3 = new Function1() { // from class: com.hdhub4u.UtilsKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        return UtilsKt.loadSourceNameExtractor$lambda$0(function2, source, quality, (ExtractorLink) obj);
                    }
                };
                c00171.L$0 = SpillingKt.nullOutSpilledVariable(source);
                c00171.L$1 = SpillingKt.nullOutSpilledVariable(url);
                c00171.L$2 = SpillingKt.nullOutSpilledVariable(referer);
                c00171.L$3 = SpillingKt.nullOutSpilledVariable(quality);
                c00171.L$4 = SpillingKt.nullOutSpilledVariable(function1);
                c00171.L$5 = SpillingKt.nullOutSpilledVariable(function2);
                c00171.label = 1;
                if (ExtractorApiKt.loadExtractor(url, referer, function1, function3, c00171) == coroutine_suspended) {
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

    public static /* synthetic */ Object loadSourceNameExtractor$default(String str, String str2, String str3, Integer num, Function1 function1, Function1 function2, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            num = null;
        }
        return loadSourceNameExtractor(str, str2, str3, num, function1, function2, continuation);
    }

    static final Unit loadSourceNameExtractor$lambda$0(Function1 $callback, String $source, Integer $quality, ExtractorLink link) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new UtilsKt$loadSourceNameExtractor$2$1($callback, link, $source, $quality, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    @NotNull
    public static final String cleanTitle(@NotNull String raw) {
        String season;
        String name = new Regex("\\s+").replace(StringsKt.trim(StringsKt.substringBefore$default(raw, "(", (String) null, 2, (Object) null)).toString(), " ");
        if (name.length() > 0) {
            StringBuilder sb = new StringBuilder();
            char it = name.charAt(0);
            StringBuilder sbAppend = sb.append((Object) (Character.isLowerCase(it) ? CharsKt.titlecase(it) : String.valueOf(it)));
            String strSubstring = name.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            name = sbAppend.append(strSubstring).toString();
        }
        Regex seasonRegex = new Regex("Season\\s*\\d+", RegexOption.IGNORE_CASE);
        Regex yearRegex = new Regex("\\b(19|20)\\d{2}\\b");
        MatchResult matchResultFind$default = Regex.find$default(seasonRegex, raw, 0, 2, (Object) null);
        if (matchResultFind$default == null || (season = matchResultFind$default.getValue()) == null) {
            season = null;
        } else {
            if (season.length() > 0) {
                StringBuilder sb2 = new StringBuilder();
                String strValueOf = String.valueOf(season.charAt(0));
                Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                String upperCase = strValueOf.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                StringBuilder sbAppend2 = sb2.append((Object) upperCase);
                String strSubstring2 = season.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                season = sbAppend2.append(strSubstring2).toString();
            }
        }
        MatchResult matchResultFind$default2 = Regex.find$default(yearRegex, raw, 0, 2, (Object) null);
        String year = matchResultFind$default2 != null ? matchResultFind$default2.getValue() : null;
        List parts = new ArrayList();
        if (season != null) {
            parts.add(season);
        }
        if (year != null) {
            parts.add(year);
        }
        if (parts.isEmpty()) {
            return name;
        }
        return name + CollectionsKt.joinToString$default(parts, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.hdhub4u.UtilsKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                return UtilsKt.cleanTitle$lambda$2((String) obj);
            }
        }, 30, (Object) null);
    }

    static final CharSequence cleanTitle$lambda$2(String it) {
        return " (" + it + ')';
    }
}
