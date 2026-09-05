package com.hdhub4u;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/HDhub4u/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b\u0012\u0016\b\u0001\u0010\t\u001a\u00020\n:\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0016\b\u0001\u0010\u000e\u001a\u00020\u000f:\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bHÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003J\t\u0010!\u001a\u00020\u000fHÆ\u0003Jk\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b2\u0016\b\u0003\u0010\t\u001a\u00020\n:\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r2\u0016\b\u0003\u0010\u000e\u001a\u00020\u000f:\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010HÆ\u0001J\u0014\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010&\u001a\u00020'HÖ\u0081\u0004J\n\u0010(\u001a\u00020\u0006HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006)"}, d2 = {"Lcom/hdhub4u/Hit;", "", "document", "Lcom/hdhub4u/Document;", "highlight", "", "", "highlights", "", "textMatch", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "text_match", "textMatchInfo", "Lcom/hdhub4u/TextMatchInfo;", "text_match_info", "<init>", "(Lcom/hdhub4u/Document;Ljava/util/Map;Ljava/util/List;JLcom/hdhub4u/TextMatchInfo;)V", "getDocument", "()Lcom/hdhub4u/Document;", "getHighlight", "()Ljava/util/Map;", "getHighlights", "()Ljava/util/List;", "getTextMatch", "()J", "getTextMatchInfo", "()Lcom/hdhub4u/TextMatchInfo;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "HDhub4u"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Hit {

    @NotNull
    private final Document document;

    @NotNull
    private final Map<String, Object> highlight;

    @NotNull
    private final List<Object> highlights;
    private final long textMatch;

    @NotNull
    private final TextMatchInfo textMatchInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Hit copy$default(Hit hit, Document document, Map map, List list, long j, TextMatchInfo textMatchInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            document = hit.document;
        }
        if ((i & 2) != 0) {
            map = hit.highlight;
        }
        if ((i & 4) != 0) {
            list = hit.highlights;
        }
        if ((i & 8) != 0) {
            j = hit.textMatch;
        }
        if ((i & 16) != 0) {
            textMatchInfo = hit.textMatchInfo;
        }
        TextMatchInfo textMatchInfo2 = textMatchInfo;
        List list2 = list;
        return hit.copy(document, map, list2, j, textMatchInfo2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Document getDocument() {
        return this.document;
    }

    @NotNull
    public final Map<String, Object> component2() {
        return this.highlight;
    }

    @NotNull
    public final List<Object> component3() {
        return this.highlights;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getTextMatch() {
        return this.textMatch;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final TextMatchInfo getTextMatchInfo() {
        return this.textMatchInfo;
    }

    @NotNull
    public final Hit copy(@NotNull Document document, @NotNull Map<String, ? extends Object> highlight, @NotNull List<? extends Object> highlights, @JsonProperty("text_match") long textMatch, @JsonProperty("text_match_info") @NotNull TextMatchInfo textMatchInfo) {
        return new Hit(document, highlight, highlights, textMatch, textMatchInfo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Hit)) {
            return false;
        }
        Hit hit = (Hit) other;
        return Intrinsics.areEqual(this.document, hit.document) && Intrinsics.areEqual(this.highlight, hit.highlight) && Intrinsics.areEqual(this.highlights, hit.highlights) && this.textMatch == hit.textMatch && Intrinsics.areEqual(this.textMatchInfo, hit.textMatchInfo);
    }

    public int hashCode() {
        return (((((((this.document.hashCode() * 31) + this.highlight.hashCode()) * 31) + this.highlights.hashCode()) * 31) + Hit$$ExternalSyntheticBackport0.m1m(this.textMatch)) * 31) + this.textMatchInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "Hit(document=" + this.document + ", highlight=" + this.highlight + ", highlights=" + this.highlights + ", textMatch=" + this.textMatch + ", textMatchInfo=" + this.textMatchInfo + ')';
    }

    public Hit(@NotNull Document document, @NotNull Map<String, ? extends Object> map, @NotNull List<? extends Object> list, @JsonProperty("text_match") long textMatch, @JsonProperty("text_match_info") @NotNull TextMatchInfo textMatchInfo) {
        this.document = document;
        this.highlight = map;
        this.highlights = list;
        this.textMatch = textMatch;
        this.textMatchInfo = textMatchInfo;
    }

    @NotNull
    public final Document getDocument() {
        return this.document;
    }

    @NotNull
    public final Map<String, Object> getHighlight() {
        return this.highlight;
    }

    @NotNull
    public final List<Object> getHighlights() {
        return this.highlights;
    }

    public final long getTextMatch() {
        return this.textMatch;
    }

    @NotNull
    public final TextMatchInfo getTextMatchInfo() {
        return this.textMatchInfo;
    }
}
