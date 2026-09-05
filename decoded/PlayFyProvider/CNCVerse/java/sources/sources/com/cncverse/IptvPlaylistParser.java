package com.cncverse;

import android.util.Base64;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagradost.cloudstream3.MainAPIKt;
import com.lagradost.cloudstream3.mvvm.ArchComponentExtKt;
import com.lagradost.cloudstream3.utils.AppUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.sequences.Sequence;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.modules.SerializersModule;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: PlayFy.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/PlayFyProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0005H\u0002J\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u0005H\u0002J\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0005*\u00020\u0005H\u0002J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\n\u001a\u00020\u0005H\u0002J\"\u0010\u000b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\f\u0010\u0012\u001a\u00020\u0005*\u00020\u0005H\u0002J\f\u0010\u0013\u001a\u00020\u0014*\u00020\u0005H\u0002J\u000e\u0010\u0015\u001a\u0004\u0018\u00010\u0005*\u00020\u0005H\u0002J\u000e\u0010\u0016\u001a\u0004\u0018\u00010\u0005*\u00020\u0005H\u0002J\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0005*\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0018\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t*\u00020\u0005H\u0002J\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u0005*\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002¨\u0006\u001b"}, d2 = {"Lcom/cncverse/IptvPlaylistParser;", "", "<init>", "()V", "hexOrNull", "", "base64ToHexOrNull", "normalizeDrmHexOrNull", "parseLicenseKeysMap", "", "licenseKey", "parseLicenseKeyPair", "Lkotlin/Pair;", "parseM3U", "Lcom/cncverse/Playlist;", "content", "input", "Ljava/io/InputStream;", "replaceQuotesAndTrim", "isExtendedM3u", "", "getTitle", "getUrl", "getUrlParameter", "key", "getAttributes", "getTagValue", "PlayFyProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPlayFy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlayFy.kt\ncom/cncverse/IptvPlaylistParser\n+ 2 AppUtils.kt\ncom/lagradost/cloudstream3/utils/AppUtils\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Extensions.kt\ncom/fasterxml/jackson/module/kotlin/ExtensionsKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,1422:1\n63#2:1423\n64#2,15:1425\n1#3:1424\n1#3:1453\n1#3:1467\n50#4:1440\n43#4:1441\n1642#5,10:1442\n1915#5:1452\n1916#5:1454\n1652#5:1455\n1642#5,10:1456\n1915#5:1466\n1916#5:1468\n1652#5:1469\n1342#6,2:1470\n*S KotlinDebug\n*F\n+ 1 PlayFy.kt\ncom/cncverse/IptvPlaylistParser\n*L\n1055#1:1423\n1055#1:1425,15\n1055#1:1424\n1113#1:1453\n1121#1:1467\n1055#1:1440\n1055#1:1441\n1113#1:1442,10\n1113#1:1452\n1113#1:1454\n1113#1:1455\n1121#1:1456,10\n1121#1:1466\n1121#1:1468\n1121#1:1469\n1378#1:1470,2\n*E\n"})
public final class IptvPlaylistParser {
    private final String hexOrNull(String $this$hexOrNull) {
        String normalizedHex = StringsKt.trim(StringsKt.replace$default($this$hexOrNull, "-", "", false, 4, (Object) null)).toString();
        if (StringsKt.isBlank(normalizedHex) || normalizedHex.length() % 2 != 0) {
            return null;
        }
        if (!new Regex("^[0-9a-fA-F]+$").matches(normalizedHex)) {
            return null;
        }
        String lowerCase = normalizedHex.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private final String base64ToHexOrNull(String $this$base64ToHexOrNull) {
        String value = StringsKt.replace$default(StringsKt.replace$default(StringsKt.trim($this$base64ToHexOrNull).toString(), '-', '+', false, 4, (Object) null), '_', '/', false, 4, (Object) null);
        int padding = (4 - (value.length() % 4)) % 4;
        try {
            byte[] decoded = Base64.decode(value + StringsKt.repeat("=", padding), 0);
            return ArraysKt.joinToString$default(decoded, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.cncverse.IptvPlaylistParser$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    return IptvPlaylistParser.base64ToHexOrNull$lambda$1(((Byte) obj).byteValue());
                }
            }, 30, (Object) null);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence base64ToHexOrNull$lambda$1(byte b) {
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    private final String normalizeDrmHexOrNull(String $this$normalizeDrmHexOrNull) {
        String trimmed = StringsKt.trim($this$normalizeDrmHexOrNull).toString();
        if ((trimmed.length() == 0) || StringsKt.equals(trimmed, "null", true)) {
            return null;
        }
        String strHexOrNull = hexOrNull(trimmed);
        return strHexOrNull == null ? base64ToHexOrNull(trimmed) : strHexOrNull;
    }

    private final Map<String, String> parseLicenseKeysMap(String licenseKey) {
        String trimmedKey = StringsKt.trim(licenseKey).toString();
        if (!StringsKt.startsWith$default(trimmedKey, "{", false, 2, (Object) null)) {
            return MapsKt.emptyMap();
        }
        try {
            JSONObject json = new JSONObject(trimmedKey);
            JSONArray keys = json.optJSONArray("keys");
            if (keys == null) {
                return MapsKt.emptyMap();
            }
            Map parsed = new LinkedHashMap();
            int length = keys.length();
            for (int index = 0; index < length; index++) {
                JSONObject item = keys.optJSONObject(index);
                if (item != null) {
                    String kid = normalizeDrmHexOrNull(item.optString("kid"));
                    String key = normalizeDrmHexOrNull(item.optString("k"));
                    String str = kid;
                    boolean z = true;
                    if (!(str == null || str.length() == 0)) {
                        String str2 = key;
                        if (str2 != null && str2.length() != 0) {
                            z = false;
                        }
                        if (!z) {
                            parsed.put(kid, key);
                        }
                    }
                }
            }
            return parsed;
        } catch (Exception e) {
            return MapsKt.emptyMap();
        }
    }

    private final Pair<String, String> parseLicenseKeyPair(String licenseKey) {
        List parts;
        String trimmedKey = StringsKt.trim(licenseKey).toString();
        if (trimmedKey.length() == 0) {
            return null;
        }
        if (StringsKt.startsWith$default(trimmedKey, "{", false, 2, (Object) null)) {
            try {
                JSONObject json = new JSONObject(trimmedKey);
                JSONArray keys = json.optJSONArray("keys");
                if (keys == null) {
                    return null;
                }
                int length = keys.length();
                for (int index = 0; index < length; index++) {
                    JSONObject item = keys.optJSONObject(index);
                    if (item != null) {
                        String kid = normalizeDrmHexOrNull(item.optString("kid"));
                        String key = normalizeDrmHexOrNull(item.optString("k"));
                        if (kid == null && key == null) {
                        }
                        return TuplesKt.to(key, kid);
                    }
                }
            } catch (Exception e) {
            }
            return null;
        }
        if (StringsKt.contains$default(trimmedKey, ":", false, 2, (Object) null)) {
            parts = StringsKt.split$default(trimmedKey, new String[]{":"}, false, 2, 2, (Object) null);
        } else {
            parts = StringsKt.contains$default(trimmedKey, ",", false, 2, (Object) null) ? StringsKt.split$default(trimmedKey, new String[]{","}, false, 2, 2, (Object) null) : CollectionsKt.emptyList();
        }
        if (parts.size() != 2) {
            return null;
        }
        String keyId = normalizeDrmHexOrNull(StringsKt.trim((String) parts.get(0)).toString());
        return TuplesKt.to(normalizeDrmHexOrNull(StringsKt.trim((String) parts.get(1)).toString()), keyId);
    }

    @NotNull
    public final Playlist parseM3U(@NotNull String content) {
        byte[] bytes = content.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return parseM3U(new ByteArrayInputStream(bytes));
    }

    /* JADX WARN: Code duplicated, block: B:196:0x048d  */
    /* JADX WARN: Code duplicated, block: B:205:0x04a2  */
    @NotNull
    public final Playlist parseM3U(@NotNull InputStream input) throws PlaylistParserException {
        int i;
        String bufferedCookie;
        String bufferedUserAgent;
        String bufferedKey;
        String bufferedKeyId;
        Map map;
        Map bufferedHeaders;
        String bufferedLicenseUrl;
        String line;
        int i2;
        byte[] byteArray;
        byte[] drmKeyBytes;
        String drmKidBase64;
        String drmKeyBase64;
        String strReplace$default;
        Iterable iterableChunked;
        Byte bValueOf;
        Collection destination$iv$iv;
        String strReplace$default2;
        Iterable iterableChunked2;
        Byte bValueOf2;
        String bufferedUserAgent2;
        String bufferedKey2;
        String bufferedKeyId2;
        Object obj;
        Object objDecodeFromString;
        Reader inputStreamReader = new InputStreamReader(input, Charsets.UTF_8);
        List allLines = TextStreamsKt.readLines(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192));
        List playlistItems = new ArrayList();
        Map bufferedHeaders2 = MapsKt.emptyMap();
        Map<String, String> mapEmptyMap = MapsKt.emptyMap();
        String bufferedTitle = null;
        Map<String, String> mapEmptyMap2 = MapsKt.emptyMap();
        String bufferedLicenseUrl2 = null;
        String bufferedKeyId3 = null;
        String bufferedKey3 = null;
        Map bufferedHeaders3 = bufferedHeaders2;
        String bufferedUserAgent3 = null;
        String bufferedCookie2 = null;
        int i3 = 0;
        while (i3 < i) {
            String line2 = StringsKt.trim((String) allLines.get(i3)).toString();
            if (line2.length() > 0) {
                if (StringsKt.startsWith$default(line2, PlayFy.EXT_INF, false, 2, (Object) null)) {
                    String bufferedTitle2 = getTitle(line2);
                    mapEmptyMap2 = getAttributes(line2);
                    String keyFromAttr = mapEmptyMap2.get("key");
                    if (keyFromAttr == null) {
                        keyFromAttr = mapEmptyMap2.get("drm-key");
                    }
                    String keyidFromAttr = mapEmptyMap2.get("keyid");
                    if (keyidFromAttr == null && (keyidFromAttr = mapEmptyMap2.get("drm-keyid")) == null) {
                        keyidFromAttr = mapEmptyMap2.get("kid");
                    }
                    if (bufferedKey3 == null) {
                        bufferedKey3 = keyFromAttr;
                    }
                    bufferedTitle = bufferedTitle2;
                    if (bufferedKeyId3 == null) {
                        bufferedKeyId3 = keyidFromAttr;
                        map = bufferedHeaders3;
                    } else {
                        map = bufferedHeaders3;
                    }
                } else {
                    i = i3;
                    bufferedCookie = bufferedCookie2;
                    if (StringsKt.startsWith$default(line2, "#EXTHTTP:", false, 2, (Object) null)) {
                        String json = StringsKt.trim(StringsKt.removePrefix(line2, "#EXTHTTP:")).toString();
                        try {
                            AppUtils appUtils = AppUtils.INSTANCE;
                            try {
                                Result.Companion companion = Result.Companion;
                                try {
                                    bufferedUserAgent2 = bufferedUserAgent3;
                                    try {
                                        bufferedKey2 = bufferedKey3;
                                        try {
                                            KType kTypeTypeOf = Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)));
                                            MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
                                            obj = Result.constructor-impl(SerializersKt.serializer(kTypeTypeOf));
                                        } catch (Throwable th) {
                                            th = th;
                                            Result.Companion companion2 = Result.Companion;
                                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        bufferedKey2 = bufferedKey3;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    bufferedUserAgent2 = bufferedUserAgent3;
                                    bufferedKey2 = bufferedKey3;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                bufferedUserAgent2 = bufferedUserAgent3;
                                bufferedKey2 = bufferedKey3;
                            }
                            try {
                                if (Result.exceptionOrNull-impl(obj) == null) {
                                    bufferedKeyId2 = bufferedKeyId3;
                                } else {
                                    try {
                                        Result.Companion companion3 = Result.Companion;
                                        bufferedKeyId2 = bufferedKeyId3;
                                        try {
                                            obj = Result.constructor-impl(SerializersModule.getContextual$default(MainAPIKt.getJson().getSerializersModule(), Reflection.getOrCreateKotlinClass(Map.class), (List) null, 2, (Object) null));
                                        } catch (Throwable th5) {
                                            th = th5;
                                            Result.Companion companion4 = Result.Companion;
                                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        bufferedKeyId2 = bufferedKeyId3;
                                    }
                                }
                                try {
                                    DeserializationStrategy deserializationStrategy = (KSerializer) (Result.isFailure-impl(obj) ? null : obj);
                                    if (deserializationStrategy != null) {
                                        try {
                                            objDecodeFromString = MainAPIKt.getJson().decodeFromString(deserializationStrategy, json);
                                        } catch (SerializationException e) {
                                            ArchComponentExtKt.logError(e);
                                            ObjectMapper $this$readValue$iv$iv = MainAPIKt.getMapper();
                                            objDecodeFromString = $this$readValue$iv$iv.readValue(json, new TypeReference<Map<String, ? extends String>>() { // from class: com.cncverse.IptvPlaylistParser$parseM3U$$inlined$parseJson$1
                                            });
                                        } catch (Throwable th7) {
                                            ObjectMapper $this$readValue$iv$iv2 = MainAPIKt.getMapper();
                                            objDecodeFromString = $this$readValue$iv$iv2.readValue(json, new TypeReference<Map<String, ? extends String>>() { // from class: com.cncverse.IptvPlaylistParser$parseM3U$$inlined$parseJson$1
                                            });
                                        }
                                    } else {
                                        ObjectMapper $this$readValue$iv$iv3 = MainAPIKt.getMapper();
                                        objDecodeFromString = $this$readValue$iv$iv3.readValue(json, new TypeReference<Map<String, ? extends String>>() { // from class: com.cncverse.IptvPlaylistParser$parseM3U$$inlined$parseJson$1
                                        });
                                    }
                                    Map map2 = (Map) objDecodeFromString;
                                    String bufferedCookie3 = map2.containsKey("cookie") ? (String) map2.get("cookie") : bufferedCookie;
                                    try {
                                        if (map2.containsKey("user-agent")) {
                                            bufferedCookie2 = bufferedCookie3;
                                            bufferedUserAgent3 = (String) map2.get("user-agent");
                                            map = bufferedHeaders3;
                                            i3 = i;
                                            bufferedKeyId3 = bufferedKeyId2;
                                            bufferedKey3 = bufferedKey2;
                                        } else {
                                            bufferedCookie2 = bufferedCookie3;
                                            map = bufferedHeaders3;
                                            i3 = i;
                                            bufferedKeyId3 = bufferedKeyId2;
                                            bufferedUserAgent3 = bufferedUserAgent2;
                                            bufferedKey3 = bufferedKey2;
                                        }
                                    } catch (Exception e2) {
                                        bufferedCookie2 = bufferedCookie3;
                                        map = bufferedHeaders3;
                                        i3 = i;
                                        bufferedKeyId3 = bufferedKeyId2;
                                        bufferedUserAgent3 = bufferedUserAgent2;
                                        bufferedKey3 = bufferedKey2;
                                    }
                                } catch (Exception e3) {
                                    bufferedCookie2 = bufferedCookie;
                                }
                            } catch (Exception e4) {
                                bufferedKeyId2 = bufferedKeyId3;
                                bufferedCookie2 = bufferedCookie;
                            }
                        } catch (Exception e5) {
                            bufferedUserAgent2 = bufferedUserAgent3;
                            bufferedKey2 = bufferedKey3;
                            bufferedKeyId2 = bufferedKeyId3;
                            bufferedCookie2 = bufferedCookie;
                        }
                    } else {
                        bufferedUserAgent = bufferedUserAgent3;
                        bufferedKey = bufferedKey3;
                        bufferedKeyId = bufferedKeyId3;
                        if (StringsKt.startsWith$default(line2, PlayFy.EXT_VLC_OPT, false, 2, (Object) null)) {
                            String userAgent = getTagValue(line2, "http-user-agent");
                            String referrer = getTagValue(line2, "http-referrer");
                            if (referrer == null) {
                                referrer = getTagValue(line2, "http-referer");
                            }
                            String bufferedUserAgent4 = userAgent != null ? userAgent : bufferedUserAgent;
                            if (referrer != null) {
                                map = MapsKt.plus(bufferedHeaders3, MapsKt.mapOf(TuplesKt.to("Referer", referrer)));
                                bufferedUserAgent3 = bufferedUserAgent4;
                                i3 = i;
                                bufferedCookie2 = bufferedCookie;
                                bufferedKeyId3 = bufferedKeyId;
                                bufferedKey3 = bufferedKey;
                            } else {
                                bufferedUserAgent3 = bufferedUserAgent4;
                                map = bufferedHeaders3;
                                i3 = i;
                                bufferedCookie2 = bufferedCookie;
                                bufferedKeyId3 = bufferedKeyId;
                                bufferedKey3 = bufferedKey;
                            }
                        } else if (StringsKt.startsWith$default(line2, "#KODIPROP:inputstream.adaptive.license_key=", false, 2, (Object) null)) {
                            String licenseKey = StringsKt.trim(StringsKt.removePrefix(line2, "#KODIPROP:inputstream.adaptive.license_key=")).toString();
                            if (StringsKt.startsWith$default(licenseKey, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(licenseKey, "https://", false, 2, (Object) null)) {
                                bufferedLicenseUrl2 = licenseKey;
                                map = bufferedHeaders3;
                                i3 = i;
                                bufferedCookie2 = bufferedCookie;
                                bufferedKeyId3 = bufferedKeyId;
                                bufferedUserAgent3 = bufferedUserAgent;
                                bufferedKey3 = bufferedKey;
                            } else if (StringsKt.startsWith$default(licenseKey, "{", false, 2, (Object) null)) {
                                Map<String, String> licenseKeysMap = parseLicenseKeysMap(licenseKey);
                                if (licenseKeysMap.isEmpty()) {
                                    bufferedKeyId3 = bufferedKeyId;
                                    bufferedKey3 = bufferedKey;
                                } else {
                                    mapEmptyMap = licenseKeysMap;
                                    Map.Entry firstPair = (Map.Entry) CollectionsKt.firstOrNull(licenseKeysMap.entrySet());
                                    if (firstPair != null) {
                                        bufferedKey3 = bufferedKey == null ? (String) firstPair.getValue() : bufferedKey;
                                        bufferedKeyId3 = bufferedKeyId == null ? (String) firstPair.getKey() : bufferedKeyId;
                                    } else {
                                        bufferedKeyId3 = bufferedKeyId;
                                        bufferedKey3 = bufferedKey;
                                    }
                                }
                                Pair<String, String> licenseKeyPair = parseLicenseKeyPair(licenseKey);
                                if (licenseKeyPair != null) {
                                    String key = (String) licenseKeyPair.component1();
                                    String keyId = (String) licenseKeyPair.component2();
                                    if (key != null) {
                                        bufferedKey3 = key;
                                    }
                                    if (keyId != null) {
                                        bufferedKeyId3 = keyId;
                                        map = bufferedHeaders3;
                                        i3 = i;
                                        bufferedCookie2 = bufferedCookie;
                                        bufferedUserAgent3 = bufferedUserAgent;
                                    } else {
                                        map = bufferedHeaders3;
                                        i3 = i;
                                        bufferedCookie2 = bufferedCookie;
                                        bufferedUserAgent3 = bufferedUserAgent;
                                    }
                                } else {
                                    map = bufferedHeaders3;
                                    i3 = i;
                                    bufferedCookie2 = bufferedCookie;
                                    bufferedUserAgent3 = bufferedUserAgent;
                                }
                            } else {
                                List parts = StringsKt.contains$default(licenseKey, ":", false, 2, (Object) null) ? StringsKt.split$default(licenseKey, new String[]{":"}, false, 0, 6, (Object) null) : StringsKt.contains$default(licenseKey, ",", false, 2, (Object) null) ? StringsKt.split$default(licenseKey, new String[]{","}, false, 0, 6, (Object) null) : CollectionsKt.listOf(licenseKey);
                                String str = (String) CollectionsKt.getOrNull(parts, 0);
                                if (str == null || (strReplace$default2 = StringsKt.replace$default(str, "-", "", false, 4, (Object) null)) == null || (iterableChunked2 = StringsKt.chunked(strReplace$default2, 2)) == null) {
                                    i2 = 16;
                                    byteArray = null;
                                } else {
                                    Iterable $this$mapNotNull$iv = iterableChunked2;
                                    Collection destination$iv$iv2 = new ArrayList();
                                    for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                                        String it = (String) element$iv$iv$iv;
                                        try {
                                            bValueOf2 = Byte.valueOf((byte) Integer.parseInt(it, CharsKt.checkRadix(16)));
                                        } catch (NumberFormatException e6) {
                                            bValueOf2 = null;
                                        }
                                        if (bValueOf2 != null) {
                                            destination$iv$iv2.add(bValueOf2);
                                        }
                                    }
                                    i2 = 16;
                                    byteArray = CollectionsKt.toByteArray((List) destination$iv$iv2);
                                }
                                byte[] drmKidBytes = byteArray;
                                String str2 = (String) CollectionsKt.getOrNull(parts, 1);
                                if (str2 == null || (strReplace$default = StringsKt.replace$default(str2, "-", "", false, 4, (Object) null)) == null || (iterableChunked = StringsKt.chunked(strReplace$default, 2)) == null) {
                                    drmKeyBytes = null;
                                } else {
                                    Iterable $this$mapNotNull$iv2 = iterableChunked;
                                    Collection destination$iv$iv3 = new ArrayList();
                                    Collection destination$iv$iv4 = destination$iv$iv3;
                                    for (Object element$iv$iv$iv2 : $this$mapNotNull$iv2) {
                                        String it2 = (String) element$iv$iv$iv2;
                                        try {
                                            bValueOf = Byte.valueOf((byte) Integer.parseInt(it2, CharsKt.checkRadix(i2)));
                                        } catch (NumberFormatException e7) {
                                            bValueOf = null;
                                        }
                                        if (bValueOf != null) {
                                            destination$iv$iv = destination$iv$iv4;
                                            destination$iv$iv.add(bValueOf);
                                        } else {
                                            destination$iv$iv = destination$iv$iv4;
                                        }
                                        destination$iv$iv4 = destination$iv$iv;
                                    }
                                    drmKeyBytes = CollectionsKt.toByteArray((List) destination$iv$iv4);
                                }
                                if (drmKidBytes == null) {
                                    drmKidBase64 = null;
                                } else if (drmKidBytes.length == 0) {
                                    drmKidBase64 = null;
                                } else {
                                    drmKidBase64 = Base64.encodeToString(drmKidBytes, 11);
                                }
                                if (drmKeyBytes == null) {
                                    drmKeyBase64 = null;
                                } else if (drmKeyBytes.length == 0) {
                                    drmKeyBase64 = null;
                                } else {
                                    drmKeyBase64 = Base64.encodeToString(drmKeyBytes, 11);
                                }
                                String bufferedKey4 = drmKeyBase64 != null ? drmKeyBase64 : bufferedKey;
                                if (drmKidBase64 != null) {
                                    map = bufferedHeaders3;
                                    bufferedKeyId3 = drmKidBase64;
                                    i3 = i;
                                    bufferedCookie2 = bufferedCookie;
                                    bufferedKey3 = bufferedKey4;
                                    bufferedUserAgent3 = bufferedUserAgent;
                                } else {
                                    bufferedKey3 = bufferedKey4;
                                    map = bufferedHeaders3;
                                    i3 = i;
                                    bufferedCookie2 = bufferedCookie;
                                    bufferedKeyId3 = bufferedKeyId;
                                    bufferedUserAgent3 = bufferedUserAgent;
                                }
                            }
                        } else if (!StringsKt.startsWith$default(line2, "#", false, 2, (Object) null)) {
                            String fullLine = line2;
                            int j = i + 1;
                            while (true) {
                                if (j >= allLines.size()) {
                                    bufferedHeaders = bufferedHeaders3;
                                    bufferedLicenseUrl = bufferedLicenseUrl2;
                                    line = line2;
                                    break;
                                }
                                bufferedHeaders = bufferedHeaders3;
                                bufferedLicenseUrl = bufferedLicenseUrl2;
                                line = line2;
                                if (StringsKt.startsWith$default(StringsKt.trim((String) allLines.get(j)).toString(), "#", false, 2, (Object) null)) {
                                    break;
                                }
                                if (!(StringsKt.trim((String) allLines.get(j)).toString().length() > 0)) {
                                    break;
                                }
                                fullLine = fullLine + StringsKt.trim((String) allLines.get(j)).toString();
                                j++;
                                line2 = line;
                                bufferedHeaders3 = bufferedHeaders;
                                bufferedLicenseUrl2 = bufferedLicenseUrl;
                            }
                            int i4 = j - 1;
                            String url = getUrl(fullLine);
                            String urlUserAgent = getUrlParameter(fullLine, "user-agent");
                            String urlReferrer = getUrlParameter(fullLine, "referer");
                            String urlReferrerAlias = getUrlParameter(fullLine, "referrer");
                            String urlCookie = getUrlParameter(fullLine, "cookie");
                            String urlOrigin = getUrlParameter(fullLine, "origin");
                            String urlKey = getUrlParameter(fullLine, "key");
                            String urlKeyid = getUrlParameter(fullLine, "keyid");
                            String urlLicenseUrl = getUrlParameter(fullLine, "licenseUrl");
                            Map finalHeaders = bufferedHeaders;
                            String resolvedReferrer = urlReferrer == null ? urlReferrerAlias : urlReferrer;
                            if (resolvedReferrer != null) {
                                finalHeaders = MapsKt.plus(finalHeaders, MapsKt.mapOf(TuplesKt.to("Referer", resolvedReferrer)));
                            }
                            if (urlOrigin != null) {
                                finalHeaders = MapsKt.plus(finalHeaders, MapsKt.mapOf(TuplesKt.to("Origin", urlOrigin)));
                            }
                            PlaylistItem item = new PlaylistItem(bufferedTitle == null ? "Unknown Channel" : bufferedTitle, mapEmptyMap2, finalHeaders, url, urlUserAgent == null ? bufferedUserAgent : urlUserAgent, urlKey == null ? bufferedKey : urlKey, urlKeyid == null ? bufferedKeyId : urlKeyid, urlCookie == null ? bufferedCookie : urlCookie, urlLicenseUrl == null ? bufferedLicenseUrl : urlLicenseUrl, mapEmptyMap);
                            playlistItems.add(item);
                            Map bufferedHeaders4 = MapsKt.emptyMap();
                            mapEmptyMap = MapsKt.emptyMap();
                            bufferedTitle = null;
                            mapEmptyMap2 = MapsKt.emptyMap();
                            i3 = i4;
                            bufferedCookie2 = null;
                            bufferedUserAgent3 = null;
                            map = bufferedHeaders4;
                            bufferedKey3 = null;
                            bufferedKeyId3 = null;
                            bufferedLicenseUrl2 = null;
                        }
                    }
                }
                i3++;
                bufferedHeaders3 = map;
            } else {
                i = i3;
                bufferedCookie = bufferedCookie2;
                bufferedUserAgent = bufferedUserAgent3;
                bufferedKey = bufferedKey3;
                bufferedKeyId = bufferedKeyId3;
            }
            i3 = i;
            bufferedCookie2 = bufferedCookie;
            bufferedKeyId3 = bufferedKeyId;
            map = bufferedHeaders3;
            bufferedLicenseUrl2 = bufferedLicenseUrl2;
            bufferedUserAgent3 = bufferedUserAgent;
            bufferedKey3 = bufferedKey;
            i3++;
            bufferedHeaders3 = map;
        }
        return new Playlist(playlistItems);
    }

    private final String replaceQuotesAndTrim(String $this$replaceQuotesAndTrim) {
        return StringsKt.trim(StringsKt.replace$default($this$replaceQuotesAndTrim, "\"", "", false, 4, (Object) null)).toString();
    }

    private final boolean isExtendedM3u(String $this$isExtendedM3u) {
        return StringsKt.startsWith$default($this$isExtendedM3u, PlayFy.EXT_M3U, false, 2, (Object) null) || StringsKt.startsWith$default($this$isExtendedM3u, PlayFy.EXT_INF, false, 2, (Object) null) || StringsKt.startsWith$default($this$isExtendedM3u, "#KODIPROP", false, 2, (Object) null);
    }

    private final String getTitle(String $this$getTitle) {
        Regex extInfRegex = new Regex("(#EXTINF:.?[0-9]+)", RegexOption.IGNORE_CASE);
        String afterExtInf = StringsKt.trim(extInfRegex.replace($this$getTitle, "")).toString();
        int lastCommaIndex = -1;
        boolean insideQuotes = false;
        int i = 0;
        int length = afterExtInf.length();
        while (true) {
            if (i < length) {
                switch (afterExtInf.charAt(i)) {
                    case '\"':
                        insideQuotes = insideQuotes ? false : true;
                        break;
                    case ',':
                        if (!insideQuotes) {
                            lastCommaIndex = i;
                        }
                        break;
                }
                i++;
            } else {
                if (lastCommaIndex != -1 && lastCommaIndex < afterExtInf.length() - 1) {
                    String strSubstring = afterExtInf.substring(lastCommaIndex + 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    return replaceQuotesAndTrim(StringsKt.trim(strSubstring).toString());
                }
                String str = (String) CollectionsKt.lastOrNull(StringsKt.split$default(afterExtInf, new String[]{","}, false, 0, 6, (Object) null));
                if (str != null) {
                    return replaceQuotesAndTrim(str);
                }
                return null;
            }
        }
    }

    private final String getUrl(String $this$getUrl) {
        String str = (String) CollectionsKt.firstOrNull(StringsKt.split$default($this$getUrl, new String[]{"|"}, false, 0, 6, (Object) null));
        if (str != null) {
            return replaceQuotesAndTrim(str);
        }
        return null;
    }

    private final String getUrlParameter(String $this$getUrlParameter, String key) {
        Regex urlRegex = new Regex("^(.*)\\|", RegexOption.IGNORE_CASE);
        String paramsString = replaceQuotesAndTrim(urlRegex.replace($this$getUrlParameter, ""));
        List<String> params = StringsKt.split$default(paramsString, new String[]{"&"}, false, 0, 6, (Object) null);
        for (String param : params) {
            List keyValuePair = StringsKt.split$default(param, new String[]{"="}, false, 2, 2, (Object) null);
            if (keyValuePair.size() == 2) {
                String paramKey = StringsKt.trim((String) keyValuePair.get(0)).toString();
                String paramValue = StringsKt.trim((String) keyValuePair.get(1)).toString();
                if (StringsKt.equals(paramKey, key, true)) {
                    return replaceQuotesAndTrim(paramValue);
                }
            }
        }
        return null;
    }

    private final Map<String, String> getAttributes(String $this$getAttributes) {
        String attributesString;
        String key;
        Regex extInfRegex = new Regex("(#EXTINF:.?[0-9]+)", RegexOption.IGNORE_CASE);
        String afterExtInf = StringsKt.trim(extInfRegex.replace($this$getAttributes, "")).toString();
        int lastCommaIndex = -1;
        int i = 0;
        int i2 = 0;
        int length = afterExtInf.length();
        while (true) {
            int i3 = 1;
            if (i2 < length) {
                switch (afterExtInf.charAt(i2)) {
                    case '\"':
                        i = i != 0 ? 0 : 1;
                        break;
                    case ',':
                        if (i == 0) {
                            lastCommaIndex = i2;
                        }
                        break;
                }
                i2++;
            } else {
                if (lastCommaIndex != -1) {
                    String strSubstring = afterExtInf.substring(0, lastCommaIndex);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    attributesString = StringsKt.trim(strSubstring).toString();
                } else {
                    attributesString = StringsKt.trim(afterExtInf).toString();
                }
                Map attributes = new LinkedHashMap();
                Regex attributeRegex = new Regex("(\\w[-\\w]*)\\s*=\\s*(?:\"([^\"]*)\"|([^\\s,]+))", RegexOption.IGNORE_CASE);
                int i4 = 2;
                String str = null;
                Sequence $this$forEach$iv = Regex.findAll$default(attributeRegex, attributesString, 0, 2, (Object) null);
                for (Object element$iv : $this$forEach$iv) {
                    MatchResult matchResult = (MatchResult) element$iv;
                    MatchGroup matchGroup = matchResult.getGroups().get(i3);
                    if (matchGroup == null || (key = matchGroup.getValue()) == null) {
                        key = "";
                    }
                    MatchGroup matchGroup2 = matchResult.getGroups().get(i4);
                    String quotedValue = matchGroup2 != null ? matchGroup2.getValue() : str;
                    MatchGroup matchGroup3 = matchResult.getGroups().get(3);
                    String unquotedValue = matchGroup3 != null ? matchGroup3.getValue() : null;
                    String value = quotedValue == null ? unquotedValue == null ? "" : unquotedValue : quotedValue;
                    if (key.length() > 0) {
                        attributes.put(key, StringsKt.trim(value).toString());
                    }
                    extInfRegex = extInfRegex;
                    i3 = 1;
                    i4 = 2;
                    str = null;
                }
                return attributes;
            }
        }
    }

    private final String getTagValue(String $this$getTagValue, String key) {
        MatchGroupCollection groups;
        MatchGroup matchGroup;
        String value;
        Regex keyRegex = new Regex(key + "=(.*)", RegexOption.IGNORE_CASE);
        MatchResult matchResultFind$default = Regex.find$default(keyRegex, $this$getTagValue, 0, 2, (Object) null);
        if (matchResultFind$default == null || (groups = matchResultFind$default.getGroups()) == null || (matchGroup = groups.get(1)) == null || (value = matchGroup.getValue()) == null) {
            return null;
        }
        return replaceQuotesAndTrim(value);
    }
}
