package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StremioC.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StremioX/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002\u0012*\b\u0003\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003Ja\u0010\u0010\u001a\u00020\u00002*\b\u0003\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u00022*\b\u0003\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/phisher98/KeywordResults;", "", "results", "Ljava/util/ArrayList;", "Lcom/phisher98/Keywords;", "Lkotlin/collections/ArrayList;", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "keywords", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getResults", "()Ljava/util/ArrayList;", "getKeywords", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "StremioX"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class KeywordResults {

    @Nullable
    private final ArrayList<Keywords> keywords;

    @Nullable
    private final ArrayList<Keywords> results;

    /* JADX WARN: Illegal instructions before constructor call */
    public KeywordResults() {
        ArrayList arrayList = null;
        this(arrayList, arrayList, 3, arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KeywordResults copy$default(KeywordResults keywordResults, ArrayList arrayList, ArrayList arrayList2, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = keywordResults.results;
        }
        if ((i & 2) != 0) {
            arrayList2 = keywordResults.keywords;
        }
        return keywordResults.copy(arrayList, arrayList2);
    }

    @Nullable
    public final ArrayList<Keywords> component1() {
        return this.results;
    }

    @Nullable
    public final ArrayList<Keywords> component2() {
        return this.keywords;
    }

    @NotNull
    public final KeywordResults copy(@JsonProperty("results") @Nullable ArrayList<Keywords> results, @JsonProperty("keywords") @Nullable ArrayList<Keywords> keywords) {
        return new KeywordResults(results, keywords);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeywordResults)) {
            return false;
        }
        KeywordResults keywordResults = (KeywordResults) other;
        return Intrinsics.areEqual(this.results, keywordResults.results) && Intrinsics.areEqual(this.keywords, keywordResults.keywords);
    }

    public int hashCode() {
        return ((this.results == null ? 0 : this.results.hashCode()) * 31) + (this.keywords != null ? this.keywords.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "KeywordResults(results=" + this.results + ", keywords=" + this.keywords + ')';
    }

    public KeywordResults(@JsonProperty("results") @Nullable ArrayList<Keywords> arrayList, @JsonProperty("keywords") @Nullable ArrayList<Keywords> arrayList2) {
        this.results = arrayList;
        this.keywords = arrayList2;
    }

    public /* synthetic */ KeywordResults(ArrayList arrayList, ArrayList arrayList2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList, (i & 2) != 0 ? new ArrayList() : arrayList2);
    }

    @Nullable
    public final ArrayList<Keywords> getResults() {
        return this.results;
    }

    @Nullable
    public final ArrayList<Keywords> getKeywords() {
        return this.keywords;
    }
}
