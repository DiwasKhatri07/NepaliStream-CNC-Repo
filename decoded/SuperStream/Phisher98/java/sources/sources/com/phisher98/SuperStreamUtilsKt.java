package com.phisher98;

import com.lagradost.cloudstream3.utils.Qualities;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SuperStreamUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/SuperStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\u001a\u0012\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a/\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\n\u001a\u0010\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010\r\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0001\u001a\u000e\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001\u001a\u0016\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001\u001a\u0016\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001\u001a\u000e\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001\"&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"getLanguage", "", "language", "languageMap", "", "Lkotlin/Pair;", "getEpisodeSlug", "season", "", "episode", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lkotlin/Pair;", "getIndexQuality", "str", "createSlug", "CathexToBinary", "hex", "CatxorDecrypt", "binary", "key", "CatdecryptHexWithKey", "cleanTitle", "title", "SuperStream"}, k = 2, mv = {2, 4, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSuperStreamUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuperStreamUtils.kt\ncom/phisher98/SuperStreamUtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,184:1\n1#2:185\n1#2:206\n437#3:186\n513#3,5:187\n1795#4,10:192\n2068#4:202\n1960#4,3:203\n2069#4:207\n1805#4:208\n*S KotlinDebug\n*F\n+ 1 SuperStreamUtils.kt\ncom/phisher98/SuperStreamUtilsKt\n*L\n164#1:206\n102#1:186\n102#1:187,5\n164#1:192,10\n164#1:202\n170#1:203,3\n164#1:207\n164#1:208\n*E\n"})
public final class SuperStreamUtilsKt {

    @NotNull
    private static final Map<String, Pair<String, String>> languageMap = MapsKt.mapOf(new Pair[]{TuplesKt.to("Afrikaans", new Pair("af", "afr")), TuplesKt.to("Albanian", new Pair("sq", "sqi")), TuplesKt.to("Amharic", new Pair("am", "amh")), TuplesKt.to("Arabic", new Pair("ar", "ara")), TuplesKt.to("Armenian", new Pair("hy", "hye")), TuplesKt.to("Azerbaijani", new Pair("az", "aze")), TuplesKt.to("Basque", new Pair("eu", "eus")), TuplesKt.to("Belarusian", new Pair("be", "bel")), TuplesKt.to("Bengali", new Pair("bn", "ben")), TuplesKt.to("Bosnian", new Pair("bs", "bos")), TuplesKt.to("Bulgarian", new Pair("bg", "bul")), TuplesKt.to("Catalan", new Pair("ca", "cat")), TuplesKt.to("Chinese", new Pair("zh", "zho")), TuplesKt.to("Croatian", new Pair("hr", "hrv")), TuplesKt.to("Czech", new Pair("cs", "ces")), TuplesKt.to("Danish", new Pair("da", "dan")), TuplesKt.to("Dutch", new Pair("nl", "nld")), TuplesKt.to("English", new Pair("en", "eng")), TuplesKt.to("Estonian", new Pair("et", "est")), TuplesKt.to("Filipino", new Pair("tl", "tgl")), TuplesKt.to("Finnish", new Pair("fi", "fin")), TuplesKt.to("French", new Pair("fr", "fra")), TuplesKt.to("Galician", new Pair("gl", "glg")), TuplesKt.to("Georgian", new Pair("ka", "kat")), TuplesKt.to("German", new Pair("de", "deu")), TuplesKt.to("Greek", new Pair("el", "ell")), TuplesKt.to("Gujarati", new Pair("gu", "guj")), TuplesKt.to("Hebrew", new Pair("he", "heb")), TuplesKt.to("Hindi", new Pair("hi", "hin")), TuplesKt.to("Hungarian", new Pair("hu", "hun")), TuplesKt.to("Icelandic", new Pair("is", "isl")), TuplesKt.to("Indonesian", new Pair("id", "ind")), TuplesKt.to("Italian", new Pair("it", "ita")), TuplesKt.to("Japanese", new Pair("ja", "jpn")), TuplesKt.to("Kannada", new Pair("kn", "kan")), TuplesKt.to("Kazakh", new Pair("kk", "kaz")), TuplesKt.to("Korean", new Pair("ko", "kor")), TuplesKt.to("Latvian", new Pair("lv", "lav")), TuplesKt.to("Lithuanian", new Pair("lt", "lit")), TuplesKt.to("Macedonian", new Pair("mk", "mkd")), TuplesKt.to("Malay", new Pair("ms", "msa")), TuplesKt.to("Malayalam", new Pair("ml", "mal")), TuplesKt.to("Maltese", new Pair("mt", "mlt")), TuplesKt.to("Marathi", new Pair("mr", "mar")), TuplesKt.to("Mongolian", new Pair("mn", "mon")), TuplesKt.to("Nepali", new Pair("ne", "nep")), TuplesKt.to("Norwegian", new Pair("no", "nor")), TuplesKt.to("Persian", new Pair("fa", "fas")), TuplesKt.to("Polish", new Pair("pl", "pol")), TuplesKt.to("Portuguese", new Pair("pt", "por")), TuplesKt.to("Punjabi", new Pair("pa", "pan")), TuplesKt.to("Romanian", new Pair("ro", "ron")), TuplesKt.to("Russian", new Pair("ru", "rus")), TuplesKt.to("Serbian", new Pair("sr", "srp")), TuplesKt.to("Sinhala", new Pair("si", "sin")), TuplesKt.to("Slovak", new Pair("sk", "slk")), TuplesKt.to("Slovenian", new Pair("sl", "slv")), TuplesKt.to("Spanish", new Pair("es", "spa")), TuplesKt.to("Swahili", new Pair("sw", "swa")), TuplesKt.to("Swedish", new Pair("sv", "swe")), TuplesKt.to("Tamil", new Pair("ta", "tam")), TuplesKt.to("Telugu", new Pair("te", "tel")), TuplesKt.to("Thai", new Pair("th", "tha")), TuplesKt.to("Turkish", new Pair("tr", "tur")), TuplesKt.to("Ukrainian", new Pair("uk", "ukr")), TuplesKt.to("Urdu", new Pair("ur", "urd")), TuplesKt.to("Uzbek", new Pair("uz", "uzb")), TuplesKt.to("Vietnamese", new Pair("vi", "vie")), TuplesKt.to("Welsh", new Pair("cy", "cym")), TuplesKt.to("Yiddish", new Pair("yi", "yid"))});

    @Nullable
    public static final String getLanguage(@Nullable String language) {
        Object next;
        Map.Entry it;
        if (language == null) {
            return null;
        }
        String normalizedLang = StringsKt.substringBefore$default(language, "-", (String) null, 2, (Object) null);
        Iterator<T> it2 = languageMap.entrySet().iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
            it = (Map.Entry) next;
        } while (!(Intrinsics.areEqual(((Pair) it.getValue()).getFirst(), normalizedLang) || Intrinsics.areEqual(((Pair) it.getValue()).getSecond(), normalizedLang)));
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (String) entry.getKey();
        }
        return null;
    }

    public static /* synthetic */ Pair getEpisodeSlug$default(Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        return getEpisodeSlug(num, num2);
    }

    @NotNull
    public static final Pair<String, String> getEpisodeSlug(@Nullable Integer season, @Nullable Integer episode) {
        if (season == null && episode == null) {
            return TuplesKt.to("", "");
        }
        Intrinsics.checkNotNull(season);
        String string = season.intValue() < 10 ? new StringBuilder().append('0').append(season.intValue()).toString() : String.valueOf(season.intValue());
        Intrinsics.checkNotNull(episode);
        return TuplesKt.to(string, episode.intValue() < 10 ? new StringBuilder().append('0').append(episode.intValue()).toString() : String.valueOf(episode.intValue()));
    }

    public static final int getIndexQuality(@Nullable String str) {
        List groupValues;
        String str2;
        Integer intOrNull;
        MatchResult matchResultFind$default = Regex.find$default(new Regex("(\\d{3,4})[pP]"), str == null ? "" : str, 0, 2, (Object) null);
        return (matchResultFind$default == null || (groupValues = matchResultFind$default.getGroupValues()) == null || (str2 = (String) CollectionsKt.getOrNull(groupValues, 1)) == null || (intOrNull = StringsKt.toIntOrNull(str2)) == null) ? Qualities.Unknown.getValue() : intOrNull.intValue();
    }

    @Nullable
    public static final String createSlug(@Nullable String $this$createSlug) throws IOException {
        String string;
        if ($this$createSlug != null) {
            String $this$filterTo$iv$iv = $this$createSlug;
            Appendable destination$iv$iv = new StringBuilder();
            int length = $this$filterTo$iv$iv.length();
            for (int index$iv$iv = 0; index$iv$iv < length; index$iv$iv++) {
                char element$iv$iv = $this$filterTo$iv$iv.charAt(index$iv$iv);
                if (CharsKt.isWhitespace(element$iv$iv) || Character.isLetterOrDigit(element$iv$iv)) {
                    destination$iv$iv.append(element$iv$iv);
                }
            }
            String $this$filter$iv = ((StringBuilder) destination$iv$iv).toString();
            if ($this$filter$iv != null && (string = StringsKt.trim($this$filter$iv).toString()) != null) {
                String strReplace = new Regex("\\s+").replace(string, "-");
                if (strReplace != null) {
                    String lowerCase = strReplace.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    return lowerCase;
                }
            }
        }
        return null;
    }

    @NotNull
    public static final String CathexToBinary(@NotNull String hex) {
        StringBuilder binary = new StringBuilder();
        int i = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, hex.length() - 1, 2);
        if (0 <= progressionLastElement) {
            while (true) {
                String hexPair = hex.substring(i, i + 2);
                Intrinsics.checkNotNullExpressionValue(hexPair, "substring(...)");
                char charValue = (char) Integer.parseInt(hexPair, CharsKt.checkRadix(16));
                binary.append(charValue);
                if (i == progressionLastElement) {
                    break;
                }
                i += 2;
            }
        }
        return binary.toString();
    }

    @NotNull
    public static final String CatxorDecrypt(@NotNull String binary, @NotNull String key) {
        StringBuilder decrypted = new StringBuilder();
        int keyLength = key.length();
        int length = binary.length();
        for (int i = 0; i < length; i++) {
            int decryptedChar = binary.charAt(i) ^ key.charAt(i % keyLength);
            decrypted.append((char) decryptedChar);
        }
        return decrypted.toString();
    }

    @NotNull
    public static final String CatdecryptHexWithKey(@NotNull String hex, @NotNull String key) {
        String binary = CathexToBinary(hex);
        return CatxorDecrypt(binary, key);
    }

    /* JADX WARN: Code duplicated, block: B:47:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:53:0x01d1 A[SYNTHETIC] */
    @NotNull
    public static final String cleanTitle(@NotNull String title) {
        List parts;
        Set sourceTags;
        Set codecTags;
        String str;
        boolean z;
        String str2;
        Object it$iv$iv = new Regex("\\.[a-zA-Z0-9]{2,4}$").replace(title, "");
        String normalized = new Regex("DDP[ .]?([0-9]\\.[0-9])", RegexOption.IGNORE_CASE).replace(new Regex("H[ .]?264", RegexOption.IGNORE_CASE).replace(new Regex("H[ .]?265", RegexOption.IGNORE_CASE).replace(new Regex("WEB[-_. ]?RIP", RegexOption.IGNORE_CASE).replace(new Regex("WEB[-_. ]?DL", RegexOption.IGNORE_CASE).replace((CharSequence) it$iv$iv, "WEB-DL"), "WEBRIP"), "H265"), "H264"), "DDP$1");
        List parts2 = StringsKt.split$default(normalized, new String[]{" ", "_", "."}, false, 0, 6, (Object) null);
        Set sourceTags2 = SetsKt.setOf(new String[]{"WEB-DL", "WEBRIP", "BLURAY", "HDRIP", "DVDRIP", "HDTV", "CAM", "TS", "BRRIP", "BDRIP"});
        Set codecTags2 = SetsKt.setOf(new String[]{"H264", "H265", "X264", "X265", "HEVC", "AVC"});
        Iterable audioTags = SetsKt.setOf(new String[]{"AAC", "AC3", "DTS", "MP3", "FLAC", "DD", "DDP", "EAC3"});
        Set audioExtras = SetsKt.setOf("ATMOS");
        Set hdrTags = SetsKt.setOf(new String[]{"SDR", "HDR", "HDR10", "HDR10+", "DV", "DOLBYVISION"});
        List $this$mapNotNull$iv = parts2;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            Object name = it$iv$iv;
            String part = (String) element$iv$iv$iv;
            String normalized2 = normalized;
            String p = part.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(p, "toUpperCase(...)");
            if (sourceTags2.contains(p) || codecTags2.contains(p)) {
                parts = parts2;
                sourceTags = sourceTags2;
                codecTags = codecTags2;
            } else {
                Iterable $this$any$iv = audioTags;
                parts = parts2;
                if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
                    sourceTags = sourceTags2;
                    codecTags = codecTags2;
                    z = false;
                    str = null;
                } else {
                    Iterator it = $this$any$iv.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            sourceTags = sourceTags2;
                            codecTags = codecTags2;
                            str = null;
                            z = false;
                            break;
                        }
                        Object element$iv = it.next();
                        String it2 = (String) element$iv;
                        Iterator it3 = it;
                        sourceTags = sourceTags2;
                        codecTags = codecTags2;
                        str = null;
                        if (StringsKt.startsWith$default(p, it2, false, 2, (Object) null)) {
                            z = true;
                            break;
                        }
                        codecTags2 = codecTags;
                        it = it3;
                        sourceTags2 = sourceTags;
                    }
                }
                if (!z && !audioExtras.contains(p)) {
                    if (hdrTags.contains(p)) {
                        if (Intrinsics.areEqual(p, "DV") || Intrinsics.areEqual(p, "DOLBYVISION")) {
                            str2 = "DOLBYVISION";
                        }
                    } else if (!Intrinsics.areEqual(p, "NF") && !Intrinsics.areEqual(p, "CR")) {
                        str2 = str;
                    }
                }
                if (str2 != null) {
                    destination$iv$iv.add(str2);
                }
                it$iv$iv = name;
                normalized = normalized2;
                parts2 = parts;
                codecTags2 = codecTags;
                sourceTags2 = sourceTags;
            }
            str2 = p;
            if (str2 != null) {
                destination$iv$iv.add(str2);
            }
            it$iv$iv = name;
            normalized = normalized2;
            parts2 = parts;
            codecTags2 = codecTags;
            sourceTags2 = sourceTags;
        }
        List filtered = (List) destination$iv$iv;
        return CollectionsKt.joinToString$default(CollectionsKt.distinct(filtered), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }
}
