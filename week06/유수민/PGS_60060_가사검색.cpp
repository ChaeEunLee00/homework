#include <bits/stdc++.h>
using namespace std;

struct TrieNode {
    unordered_map<char, TrieNode*> children;
    int count; // 현재 노드를 포함하는 단어 개수
    
    TrieNode() : count(0) {}
};

class Trie {
public:
    TrieNode* root;

    Trie() { root = new TrieNode(); }

    void insert(const string &word) {
        TrieNode* node = root;
        for (char ch : word) {
            if (!node->children[ch])
                node->children[ch] = new TrieNode();
            node = node->children[ch];
            node->count++; // 해당 노드를 거치는 단어 개수 증가
        }
    }

    int search(const string &query) {
        TrieNode* node = root;
        for (char ch : query) {
            if (ch == '?') break; // '?' 이후는 더 이상 탐색할 필요 없음
            if (!node->children[ch]) return 0; // 해당 접두사가 없음
            node = node->children[ch];
        }
        return node->count; // 현재 노드까지 지나간 단어 개수 반환ㅜ
    }
};

vector<int> solution(vector<string> words, vector<string> queries) {
    unordered_map<int, Trie> prefixTrie, suffixTrie; // 길이별 Trie 저장
    unordered_map<int, int> lengthCount; // 길이별 단어 개수 저장 (전부 '?'일 때 활용)

    // 단어를 Trie에 저장 (길이별로 분리하여 저장)
    for (const auto &word : words) {
        int len = word.size();
        prefixTrie[len].insert(word); // 일반적인 Trie
        string reversedWord = word;
        reverse(reversedWord.begin(), reversedWord.end());
        suffixTrie[len].insert(reversedWord); // 뒤집힌 Trie
        lengthCount[len]++; // 길이별 단어 개수 증가
    }

    vector<int> answer;
    for (const auto &query : queries) {
        int len = query.size();
        if (prefixTrie.find(len) == prefixTrie.end()) {
            answer.push_back(0); // 해당 길이의 단어가 없음
            continue;
        }

        // 쿼리가 전부 '?'인 경우 → 해당 길이의 단어 개수를 바로 반환
        if (query[0] == '?' && query.back() == '?') {
            answer.push_back(lengthCount[len]);
            continue;
        }

        // '?'가 앞쪽이면 접미사 Trie에서 검색
        if (query[0] == '?') {
            string reversedQuery = query;
            reverse(reversedQuery.begin(), reversedQuery.end());
            answer.push_back(suffixTrie[len].search(reversedQuery));
        } 
        // '?'가 뒤쪽이면 접두사 Trie에서 검색
        else {
            answer.push_back(prefixTrie[len].search(query));
        }
    }

    return answer;
}
